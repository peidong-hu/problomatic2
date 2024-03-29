package org.bigtester.problomatic2.config;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.xmlbeans.XmlException;

import org.bigtester.problomatic2.ChainLink;
import org.bigtester.problomatic2.DefaultProperties;
import org.bigtester.problomatic2.DefineChain;
import org.bigtester.problomatic2.Problomatic;
import org.bigtester.problomatic2.ProblomaticConfiguration;
import org.bigtester.problomatic2.ProblomaticConfigurationDocument;
import org.bigtester.problomatic2.Property;

public class XMLBeansConfigurator {

	private static ProblomaticConfigurationDocument doc;

	void configureInternal(URL url) throws ConfigurationException {
		try {
			doc = ProblomaticConfigurationDocument.Factory.parse(url);
			ProblomaticConfiguration conf = doc.getProblomaticConfiguration();
			// Problomatic.setConfiguration(conf);
			DefineChain[] chains = conf.getDefineChainArray();
			for (int i = 0; i < chains.length; i++) {
				DefineChain chain = chains[i];
				ChainLink[] links = chain.getChainLinkArray();
				String problem = chain.getProblem();
				for (int j = 0; j < links.length; j++) {
					ChainLink link = links[i];
					Properties props = getPropertiesForHandler(link
							.getHandler());
					propertyArrayToProperties(props, link.getPropertyArray());
					Problomatic.addProblemHandlerForProblem(problem, link
							.getHandler(), props);
				}
			}
		} catch (XmlException e) {
			throw new ConfigurationException(e);
		} catch (ClassNotFoundException e) {
			throw new ConfigurationException(e);
		} catch (IllegalAccessException e) {
			throw new ConfigurationException(e);
		} catch (InstantiationException e) {
			throw new ConfigurationException(e);
		} catch (IOException e) {
			throw new ConfigurationException(e);
		}
	}

	void configureInternal(File file) throws ConfigurationException {
		try {
			doc = ProblomaticConfigurationDocument.Factory.parse(file);
			ProblomaticConfiguration conf = doc.getProblomaticConfiguration();
			// Problomatic.setConfiguration(conf);
			DefineChain[] chains = conf.getDefineChainArray();
			for (int i = 0; i < chains.length; i++) {
				DefineChain chain = chains[i];
				ChainLink[] links = chain.getChainLinkArray();
				String problem = chain.getProblem();
				for (int j = 0; j < links.length; j++) {
					ChainLink link = links[j];
					Properties props = getPropertiesForHandler(link
							.getHandler());
					propertyArrayToProperties(props, link.getPropertyArray());
					Problomatic.addProblemHandlerForProblem(problem, link
							.getHandler(), props);
				}
			}
		} catch (XmlException e) {
			throw new ConfigurationException(e);
		} catch (ClassNotFoundException e) {
			throw new ConfigurationException(e);
		} catch (IllegalAccessException e) {
			throw new ConfigurationException(e);
		} catch (InstantiationException e) {
			throw new ConfigurationException(e);
		} catch (IOException e) {
			throw new ConfigurationException(e);
		}
	}

	public static  Properties getPropertiesForHandler(String handlerName) {
		Properties props = new Properties();
		DefaultProperties[] defPropsArr = doc.getProblomaticConfiguration().getDefaultPropertiesArray();
		for (int i = 0; i < defPropsArr.length; i++) {
			DefaultProperties defProps = defPropsArr[i];
			if (defProps.getHandler().equals(handlerName)) {
				propertyArrayToProperties(props, defProps.getPropertyArray());
			}
		}
		return props;

	}

	private static void propertyArrayToProperties(Properties props,
			Property[] propertyArray) {
		for (int i = 0; i < propertyArray.length; i++) {
			Property property = propertyArray[i];
			props.put(property.getName(), property.getValue());
		}
	}

}
