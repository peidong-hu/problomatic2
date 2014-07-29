package org.bigtester.problomatic2.handlers;

import org.bigtester.problomatic2.ProblemHandler;
import org.bigtester.problomatic2.InitException;

import java.util.Properties;

import org.apache.log4j.Logger;

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
 * User: danstieglitz Date: Feb 29, 2004 Time: 3:40:05 PM
 */
public abstract class AbstractProblemHandler implements ProblemHandler {

	/**
	 * Properties loaded from a properties file
	 */
	private Properties properties;
	
	private static final Logger log = Logger
			.getLogger(AbstractProblemHandler.class);

	public AbstractProblemHandler() {
		properties = new Properties();
	}

	protected void fail(String msg) throws InitException {
		throw new InitException(msg);
	}

	protected void setRequiredProperty(Properties source, String key)
			throws InitException {
		setPropertyInternal(source, key, true);
	}

	protected void setProperty(Properties source, String key) {
		try {
			setPropertyInternal(source, key, false);
		} catch (InitException ex) {
			log.warn("Unable to load property " + key, ex);
		}
	}

	protected void setPropertyInternal(Properties source, String key, boolean required)
			throws InitException {
		if (source==null) {
			fail("Source properties is null");
		}
		else {
			String value = (String) source.get(key);
			if (value == null) {
				if (required) {
					fail("Property "+key+" is required but not defined anywhere");
				}
				else {
					System.err.println("WARN: Property "+key+" is not defined anywhere");
				}
			}
			else {
				setPropertyInternal(key,value);
			}
		}
	}

	protected void setPropertyInternal(String key, String value) {
		properties.setProperty(key, value);
	}

	public Properties getProperties() {
		return properties;
	}

	public String getProperty(String name) {
//		if (!properties.containsKey(name)) {
//			String msg = "Required property " + name
//			+ " not found in properties";
//			log.fatal(msg);
//			throw new RuntimeException(msg);
//		}
		String prop = (String) properties.get(name);
		if (prop!=null) {
			return (String) properties.get(name);
		}
		else {
			System.err.println("WARN: Property "+name+" is not defined");
			return "";
		}
	}
}