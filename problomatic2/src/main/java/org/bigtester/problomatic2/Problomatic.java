package org.bigtester.problomatic2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import org.bigtester.problomatic2.config.ConfigurationException;
import org.bigtester.problomatic2.config.XMLConfigurator;
import org.bigtester.problomatic2.problems.RawProblem;

/*
 * Copyright 2004 Stieglitech, LLC.
 *
 * This file is part of Prob-lo-Matic
 *
 * Prob-lo-Matic is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Prob-lo-Matic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Prob-lo-Matic; if not, write to the Free Software
 * Foundation, Inc 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

/**
 * User: danstieglitz Date: Feb 24, 2004 Time: 9:28:39 PM
 */
abstract public class Problomatic {

	private static boolean configured = false;

	private static boolean verbose = true;

	private static boolean failOnInitError = false;

//	private static ProblomaticConfiguration configuration;

	/**
	 * A map of LinkedHashSets that are the problem handler chains of
	 * responsibility, keyed by the problem class name
	 */
	private static Map problemHandlerChains;
	
	private static final String RAW_PROBLEM_CLASS_NAME = "org.bigtester.problomatic2.problems.RawProblem";

	private static final Logger log = Logger.getLogger(Problomatic.class);

	static {
		problemHandlerChains = new HashMap();
	}

	/**
	 * Accepts a Problem object and hands it off to the appropriate handler
	 * chain. This method generates a key by calling the getClass().getName()
	 * method of aProblem and uses the generated key to lookup a LinkedHashSet
	 * of ProblemHandler implementations (the chain). The chains are stored in a
	 * Map. For each link in the chain, its handleProblem method is invoked with
	 * aProblem.
	 * 
	 * @see org.bigtester.problomatic2.Problem
	 */
	public static void handleProblem(Problem aProblem) {
		
		// Configure the system if not configured yet
		if (!configured) {
			if (isVerbose()) {
				System.out
						.println("Problomatic not yet configured; configuring");
			}
			try {
				XMLConfigurator.configure("problomatic.xml");
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
		}
		if (isVerbose()) {
			System.out.println(getConfiguration());
		}
		
		String key = aProblem.getClass().getName();
		LinkedHashSet chain = (LinkedHashSet) problemHandlerChains.get(key);
		if (chain == null) {
			chain = (LinkedHashSet) problemHandlerChains.get(RAW_PROBLEM_CLASS_NAME);
		}
		if (chain == null) {
			// todo: activate another handler when none are found?
			Iterator exceptions = aProblem.getUnderlyingExceptions().iterator();
			while (exceptions.hasNext()) {
				Throwable next = (Throwable) exceptions.next();
				next.printStackTrace();
			}
			throw new UnknownProblemException(key);
		} else {
			Iterator links = chain.iterator();
			while (links.hasNext()) {
				ProblemHandler link = (ProblemHandler) links.next();
				link.handleProblem(aProblem);
			}
		}
	}

	/**
	 * Convienience method that accepts any Throwable object, wraps it in a
	 * GenericThrowableException, and calls handleProblem() with the
	 * aformentioned Problem object.
	 */
	public static void handleThrowable(Object source, Throwable exception) {
		handleProblem(new RawProblem(source, exception));
	}
	
	/**
	 * Make sure the supplied parameters are of the appropriate type.
	 * 
	 * @see addProblemHandlerForProblem
	 * @deprecated use addProblemHandlerForProblem(String,String,Properties)
	 *             instead
	 * @param problemClass
	 * @param handlerClass
	 * @throws InstantiationException
	 */
	public static void addProblemHandlerForProblem(Class problemClass,
			Class handlerClass) throws InstantiationException {
		try {
			addProblemHandlerForProblem(problemClass.getName(), handlerClass
					.getName());
			configured = true;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InstantiationException(problemClass
					+ " is not an instance of Problem, and/or " + handlerClass
					+ " is not an instance of ProblemHandler");
		}
	}

	/**
	 * This method is supplied to programatically configure problem chains at
	 * run-time. The supplied problemClassName is used to generate a key for the
	 * chain Map. If the specified key exists, the supplied
	 * problemHandlerClassName is dynamically instantiated and added to the
	 * pre-existing chain. <p/>If the generated key does not exist, it is added
	 * to the Map with the supplied problemHandlerClassName instance as the head
	 * of the chain.
	 * 
	 * @deprecated use addProblemHandlerForProblem(String,String,Properties)
	 *             instead
	 */
	public static void addProblemHandlerForProblem(String problemClassName,
			String problemHandlerClassName) throws ClassNotFoundException,
			IllegalAccessException, InstantiationException {
		LinkedHashSet chain = (LinkedHashSet) problemHandlerChains
				.get(problemClassName);
		ProblemHandler handler;
		handler = (ProblemHandler) Class.forName(problemHandlerClassName)
				.newInstance();
		if (chain == null) {
			chain = new LinkedHashSet();
		}

		// try {
		// PropertiesConfigurator.configure(handler);
		// } catch (ConfigurationException e) {
		// e.printStackTrace();
		// System.exit(0);
		// }

		chain.add(handler);
		problemHandlerChains.put(problemClassName, chain);
		configured = true;
	}

	/**
	 * This method is supplied to programatically configure problem chains at
	 * run-time. The supplied problemClassName is used to generate a key for the
	 * chain Map. If the specified key exists, the supplied
	 * problemHandlerClassName is dynamically instantiated and added to the
	 * pre-existing chain. <p/>If the generated key does not exist, it is added
	 * to the Map with the supplied problemHandlerClassName instance as the head
	 * of the chain.
	 */
	public static void addProblemHandlerForProblem(String problemClassName,
			String problemHandlerClassName, Properties props)
			throws ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		LinkedHashSet chain = (LinkedHashSet) problemHandlerChains
				.get(problemClassName);

		ProblemHandler handler = (ProblemHandler) Class.forName(
				problemHandlerClassName).newInstance();

		if (chain == null) {
			chain = new LinkedHashSet();
		}

		try {
			handler.init(props);
			chain.add(handler);
			problemHandlerChains.put(problemClassName, chain);
			if (isVerbose()) {
				System.out.println("Added " + problemHandlerClassName + " for "
						+ problemClassName);
				System.out.println(props);
			}
		} catch (InitException e) {
			if (failOnInitError) {
				e.printStackTrace();
				System.exit(0);
			} else {
				System.err.println(problemHandlerClassName
						+ " was not loaded due to the following error(s):");
				e.printStackTrace();
				System.err.println();
			}
		}

	}

	/**
	 * @see addProblemHandlerForProblem
	 */
	public static void addProblemHandlerForProblem(Problem aProblem,
			ProblemHandler handler) {
		String key = aProblem.getClass().getName();
		LinkedHashSet chain = (LinkedHashSet) problemHandlerChains.get(key);
		if (chain == null) {
			chain = new LinkedHashSet();
		}

		// try {
		// PropertiesConfigurator.configure(handler);
		// } catch (ConfigurationException e) {
		// e.printStackTrace();
		// System.exit(0);
		// }

		chain.add(handler);
		problemHandlerChains.put(key, chain);
		configured = true;
	}

	/**
	 * This method, like addProblemHandlerForProblem, locates the appropriate
	 * chain and removes the specified ProblemHandler from it, if it exists. If
	 * it does not exist, nothing happens.
	 * 
	 * @see addProblemHandlerForProblem
	 */
	public static void removeProblemHandlerForProblem(Problem aProblem,
			ProblemHandler handler) {
		String key = aProblem.getClass().getName();
		LinkedHashSet chain = (LinkedHashSet) problemHandlerChains.get(key);
		if (chain != null) {
			chain.remove(handler);
		}
	}

	/**
	 * Returns a String containing a human-readable dump of the Problomatic
	 * configuration for debugging and confidence purposes.
	 * 
	 * @return
	 */
	public static String getConfiguration() {
		StringBuffer buf = new StringBuffer();
		buf.append("Prob-lo-Matic Configuration:\n");
		Set keys = problemHandlerChains.keySet();
		Iterator keyIterator = keys.iterator();
		while (keyIterator.hasNext()) {
			String key = (String) keyIterator.next();
			buf.append("Problem: " + key + "\n");
			buf.append("Handlers:\n");
			Set handlers = (Set) problemHandlerChains.get(key);
			Iterator handlerIterator = handlers.iterator();
			while (handlerIterator.hasNext()) {
				ProblemHandler handler = (ProblemHandler) handlerIterator
						.next();
				buf.append(handler + "\n");
				buf.append("\t" + handler.getProperties() + "\n");
			}
			if (keyIterator.hasNext()) {
				buf.append("***********\n");
			}
		}
		return buf.toString();
	}

//	public static void setConfiguration(ProblomaticConfiguration configuration) {
//		Problomatic.configuration = configuration;
//	}

	public static void setVerbose(boolean verbose) {
		Problomatic.verbose = verbose;
	}

	public static boolean isVerbose() {
		return verbose;
	}

}