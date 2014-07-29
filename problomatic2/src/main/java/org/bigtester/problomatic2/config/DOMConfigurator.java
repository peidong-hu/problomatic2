package org.bigtester.problomatic2.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.log4j.Logger;
import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.bigtester.problomatic2.Problomatic;

public class DOMConfigurator {
	
	private static final Logger log = Logger.getLogger(DOMConfigurator.class);
	
	void configureInternal(String pathToXMLFile)
			throws ConfigurationException {
		try {
			Document doc = loadXMLDocument(pathToXMLFile);
			List defs = getChainDefinitions(doc.getDocumentElement());
			Iterator definitions = defs.iterator();
			while (definitions.hasNext()) {
				ChainDefinition definition = (ChainDefinition) definitions
						.next();
				List linkList = definition.getChainLinks();
				Iterator links = linkList.iterator();
				while (links.hasNext()) {
					ChainLink link = (ChainLink) links.next();
					DefaultProperties defProps = getDefaultProperties(doc, link
							.getHandlerClassName());
					if (defProps != null) {
						Problomatic.addProblemHandlerForProblem(definition
								.getProblemClassName(), link
								.getHandlerClassName(), defProps.properties);
					} else {
						// TODO: implement override properties feature
						Problomatic.addProblemHandlerForProblem(definition
								.getProblemClassName(), link
								.getHandlerClassName(), new Properties());
					}
				}
			}
		} catch (ParserConfigurationException e) {
			throw new ConfigurationException(e);
		} catch (SAXException e) {
			throw new ConfigurationException(e);
		} catch (IOException e) {
			throw new ConfigurationException(e);
		} catch (ClassNotFoundException e) {
			throw new ConfigurationException(e);
		} catch (IllegalAccessException e) {
			throw new ConfigurationException(e);
		} catch (InstantiationException e) {
			throw new ConfigurationException(e);
		} catch (TransformerException e) {
			throw new ConfigurationException(e);
		}
	}

	private DefaultProperties getDefaultProperties(Document doc,
			String handlerName) throws TransformerException {
		NodeIterator nodes = XPathAPI.eval(doc.getDocumentElement(),
				"//default-properties").nodeset();
		Node node;
		while ((node = nodes.nextNode()) != null) {
			DefaultProperties props = new DefaultProperties(node);
			if (props.getHandlerName().equals(handlerName)) {
				return props;
			}
		}
		return null;
	}

	private List getChainDefinitions(Node documentRoot) {
		List chainDefinitions = new ArrayList();
		try {
			NodeIterator nodes = XPathAPI.eval(documentRoot, "//define-chain")
					.nodeset();
			Node node;
			while ((node = nodes.nextNode()) != null) {
				chainDefinitions.add(new ChainDefinition(node));
			}
		} catch (TransformerException e) {
			log.error(e);
		}
		return chainDefinitions;
	}

	public static Document loadXMLDocument(String pathToXMLFile)
			throws ParserConfigurationException, SAXException, IOException,
			ConfigurationException {
		// BufferedReader in = new BufferedReader(new InputStreamReader(new
		// FileInputStream(pathToXMLFile)));
		BufferedReader in = new BufferedReader(new InputStreamReader(
				getXMLFile(pathToXMLFile)));
		StringBuffer buf = new StringBuffer();
		String str;
		while ((str = in.readLine()) != null) {
			buf.append(str);
		}
		in.close();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(new InputSource(new StringReader(buf.toString())));
	}

	public static InputStream getXMLFile(String filename)
			throws ConfigurationException, IOException {
		if (filename == null) {
			throw new ConfigurationException(
					"No configuration filename supplied");
		}
		InputStream stream = ClassLoader.getSystemResource(filename)
				.openStream();
		if (stream == null) {
			throw new ConfigurationException("Can't load " + filename
					+ "... unknown cause. Is it on the classpath?");
		}
		return stream;
	}

	private class DefaultProperties {
		String handlerName;

		Properties properties = new Properties();

		public DefaultProperties(Node defaultPropertiesNode) {
			try {
				handlerName = XPathAPI.eval(defaultPropertiesNode, "@handler")
						.str();
				NodeIterator nodes = XPathAPI.eval(defaultPropertiesNode,
						"property").nodeset();
				Node node;
				while ((node = nodes.nextNode()) != null) {
					String name = XPathAPI.eval(node, "@name").str();
					String val = XPathAPI.eval(node, "@value").str();
					properties.setProperty(name, val);
				}
			} catch (TransformerException e) {
				log.error(e);
			}

		}

		public String getHandlerName() {
			return handlerName;
		}
	}

	private class ChainDefinition {
		List chainLinks;

		String problemClassName;

		public ChainDefinition(Node chainDefinitionNode) {
			chainLinks = new ArrayList();
			try {
				problemClassName = XPathAPI.eval(chainDefinitionNode,
						"@problem").str();
				NodeIterator nodes = XPathAPI.eval(chainDefinitionNode,
						"chain-link").nodeset();
				Node node;
				while ((node = nodes.nextNode()) != null) {
					chainLinks.add(new ChainLink(node));
				}
			} catch (TransformerException e) {
				log.error(e);
			}
		}

		/**
		 * @return Returns the problemClassName.
		 */
		public String getProblemClassName() {
			return problemClassName;
		}

		/**
		 * @return Returns the chainLinks.
		 */
		public List getChainLinks() {
			return chainLinks;
		}
	}

	private class ChainLink {
		private String handlerClassName;

		private Properties properties;

		public ChainLink(Node linkDefinitionNode) {
			try {
				handlerClassName = XPathAPI
						.eval(linkDefinitionNode, "@handler").str();
				NodeIterator propNodes = XPathAPI.selectNodeIterator(
						linkDefinitionNode, "property");
				Node node = null;
				while ((node = propNodes.nextNode()) != null) {
					if (properties == null) {
						properties = new Properties();
					}
					String propName = XPathAPI.eval(node, "@name").str();
					String propVal = XPathAPI.eval(node, "@value").str();
					properties.setProperty(propName, propVal);
				}
			} catch (TransformerException e) {
				log.error(e);
			}
		}

		/**
		 * @return Returns the handlerClassName.
		 */
		public String getHandlerClassName() {
			return handlerClassName;
		}

		public Properties getProperties() {
			return properties;
		}
	}

}
