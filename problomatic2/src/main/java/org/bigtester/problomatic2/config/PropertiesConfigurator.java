package org.bigtester.problomatic2.config;

import java.util.Properties;

import org.apache.log4j.Logger;

import org.bigtester.problomatic2.InitException;
import org.bigtester.problomatic2.ProblemHandler;
import org.bigtester.problomatic2.util.ResourceLoader;

/**
 * @deprecated use XMLConfigurator instead
 * @author danstieglitz
 *
 */
public class PropertiesConfigurator {
	
	private static final Logger log = Logger.getLogger(PropertiesConfigurator.class);
	
	private static final String MORE_INFO = "Make sure that each defined handler has a properties"
		+ " file named [HandlerClass.getName()].properties on the classpath, even if this properties file is"
		+ " empty.";
	
	private static String removePackageName(String className) {
		return className.substring(className.lastIndexOf(".") + 1, className
				.length());
	}
	
	public static synchronized void configure(ProblemHandler handler) throws ConfigurationException {
		String propertiesFileName = removePackageName(handler.getClass()
				.getName())
				+ ".properties";

		try {
			Properties props = ResourceLoader
					.loadProperties(propertiesFileName);
			handler.init(props);
		} catch (InitException t) {
			log.fatal(
					"Could not initialize handler " + handler.getClass().getName(),
					t);
			log.fatal(MORE_INFO);
			throw new ConfigurationException(t);
		}
	}

}
