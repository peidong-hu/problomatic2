package org.bigtester.problomatic2.examples;

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

import org.bigtester.problomatic2.Problomatic;
import org.bigtester.problomatic2.config.ConfigurationException;
import org.bigtester.problomatic2.config.XMLConfigurator;

/**
 * @author danstieglitz
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Configuration {

	private static final String PATH_TO_XML_FILE = 
		"/Applications/Eclipse/workspace/problomatic/misc/problomatic.xml";
	
	/**
	 * 
	 */
	public Configuration() {
		super();
	}
	
	/**
	 * Example of how to configure Problomatic from within Java code.
	 *
	 */
	public void configureProgramatically() {
        try {
			Problomatic.addProblemHandlerForProblem("org.bigtester.problomatic2.problems.RawProblem",
			"org.bigtester.problomatic2.handlers.SystemPrintlnHandler");
	        Problomatic.addProblemHandlerForProblem("org.bigtester.problomatic2.problems.RawProblem",
	        "org.bigtester.problomatic2.handlers.EmailNotificationHandler");
	        System.out.println(Problomatic.getConfiguration());
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
            		
	}
	
	public void configureWithXMLFile() {
		try {
			XMLConfigurator.configure(PATH_TO_XML_FILE);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Problomatic.getConfiguration());
	}

	public void runExample() {
		try {
			throw new Exception("An exception occured!");
		} catch (Throwable t) {
			Problomatic.handleThrowable(this, t);
		}
	}
	
	public static void main(String[] args) {
		Configuration example = new Configuration();
		
		// uncomment the relevant method to run the example you wish
		// example.configureProgramatically();
		
		example.configureWithXMLFile();
		example.runExample();
	}
}
