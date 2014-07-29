/*
 * Created on Jun 2, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.bigtester.problomatic2.config;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import org.bigtester.problomatic2.Problomatic;

/**
 * @author danstieglitz
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class XMLConfigurator {

	private static XMLBeansConfigurator config;
	
	static {
		config = new XMLBeansConfigurator();
	}
	
	// TODO: cache default properties to avoid repeated parsing?
	public static void configure(String configurationFileName)
			throws ConfigurationException {

		String pathToFile = System.getProperty("problomatic.xml");
		if (pathToFile != null) {
			if (Problomatic.isVerbose()) {
				System.out
						.println("Configuring problomatic with " + pathToFile);
			}
			configurationFileName = pathToFile;
		}

		File file = null;
		file = new File(configurationFileName);

		if (!file.exists()) {
			// file not found; attempt classpath load
			URL configURL = XMLConfigurator.class
					.getResource(configurationFileName);
			if (configURL != null) {
				if (Problomatic.isVerbose()) {
					System.out.println("Configuring problomatic with " + configURL);
				}
				config.configureInternal(configURL);
			} else {
				throw new ConfigurationException(
						"Configuration file not found ("
								+ configurationFileName + ")");
			}
		} else {
			config.configureInternal(file);
		}
	}
	
	public static Properties getDefaultProperties(String handlerName) {
		return XMLBeansConfigurator.getPropertiesForHandler(handlerName);
	}

}
