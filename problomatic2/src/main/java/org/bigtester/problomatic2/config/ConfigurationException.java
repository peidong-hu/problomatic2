/*
 * Created on Sep 17, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.bigtester.problomatic2.config;


/**
 * @author danstieglitz
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConfigurationException extends Exception {

	public ConfigurationException(String msg) {
		super(msg);
	}
	
	public ConfigurationException(String msg, Throwable t) {
		super(msg,t);
	}

	/**
	 * @param e
	 */
	public ConfigurationException(Throwable e) {
		super(e);
	}
	
}
