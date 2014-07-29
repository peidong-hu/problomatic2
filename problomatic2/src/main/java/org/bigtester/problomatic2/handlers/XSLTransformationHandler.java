/*
 * Created on Jun 3, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.bigtester.problomatic2.handlers;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.bigtester.problomatic2.InitException;
import org.bigtester.problomatic2.Problem;

/**
 * @author danstieglitz
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class XSLTransformationHandler extends AbstractProblemHandler {

    private static final String XSL_URL = "xsltransformationhandler.xslurl";
    private static final String PATH_TO_FILES = "xsltransformationhandler.pathtofiles";
    private static final String WRITE_TO_DISK = "xsltransformationhandler.writeToDisk";
    
    	/**
	 * todo this implementation of initializing properties is not very clean...
	 * find a better way
	 */
	public void init(Properties props) throws InitException {
		setProperty(props,PATH_TO_FILES);
		setRequiredProperty(props, XSL_URL);
		setRequiredProperty(props,WRITE_TO_DISK);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bigtester.problomatic2.ProblemHandler#handleProblem(org.bigtester.problomatic2.Problem)
	 */
	public void handleProblem(Problem aProblem) {
		// TODO Auto-generated method stub
		if (aProblem.hasAttribute("transformFlag")
				&& aProblem.hasAttribute("URL")) {
			aProblem.removeAttribute("transformFlag");
			try {
				URL sourceURL = new java.net.URL(aProblem.getAttribute("URL")
						.toString());
				// todo get from properties
				String pathToDest = getProperty("pathtofiles") + java.io.File.separatorChar +
						+ new Date().getTime() + ".html";
				transform(sourceURL, pathToDest);
				aProblem.setAttribute("URL", "file://" + pathToDest);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void transform(URL urlToSource, String pathToDest) {
		PrintWriter outStream = null;
		try {
			// todo get from properties
			String xslURL = getProperty("xslurl");
			//			DocumentBuilder parser = docBuildFactory.newDocumentBuilder();
			//			Document document = parser.parse(pathToSource);
			TransformerFactory xformFactory = TransformerFactory.newInstance();
			StreamSource xslSource = new StreamSource(xslURL);
			Transformer transformer = xformFactory.newTransformer(xslSource);
			//			DOMSource source = new DOMSource(document);
			StreamSource xmlSource = new StreamSource(urlToSource.openStream());
//			StreamResult scrResult = new StreamResult(System.out);
//			transformer.transform(xmlSource, scrResult);
			outStream = new PrintWriter(new FileOutputStream(pathToDest));
			StreamResult fileResult = new StreamResult(outStream);
			transformer.transform(xmlSource, fileResult);
		}
		//		catch (SAXParseException saxEx) {
		//			System.err.println("\nSAXParseException");
		//			System.err.println("Public ID: " + saxEx.getPublicId());
		//			System.err.println("System ID: " + saxEx.getSystemId());
		//			System.err.println("Line: " + saxEx.getLineNumber());
		//			System.err.println("Column:" + saxEx.getColumnNumber());
		//			System.err.println(saxEx.getMessage());
		//
		//			Exception ex = saxEx;
		//			if (saxEx.getException() != null) {
		//				ex = saxEx.getException();
		//				System.err.println(ex.getMessage());
		//			}
		//		}
		//		catch (SAXException saxEx) {
		//			//This catch block may not be reachable.
		//			System.err.println("\nParser Error");
		//			System.err.println(saxEx.getMessage());
		//
		//			Exception ex = saxEx;
		//			if (saxEx.getException() != null) {
		//				ex = saxEx.getException();
		//				System.err.println(ex.getMessage());
		//			}
		//		}
		//		catch (ParserConfigurationException parConEx) {
		//			System.err.println("\nParser Config Error");
		//			System.err.println(parConEx.getMessage());
		//		}
		//		catch (TransformerConfigurationException transConEx) {
		//			System.err.println("\nTransformer Config Error");
		//			System.err.println(transConEx.getMessage());
		//
		//			Throwable ex = transConEx;
		//			if (transConEx.getException() != null) {
		//				ex = transConEx.getException();
		//				System.err.println(ex.getMessage());
		//			}
		//		}
		catch (TransformerException transEx) {
			System.err.println("\nTransformation error");
			System.err.println(transEx.getMessage());

			Throwable ex = transEx;
			if (transEx.getException() != null) {
				ex = transEx.getException();
				System.err.println(ex.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			outStream.close();
		}
	}

}
