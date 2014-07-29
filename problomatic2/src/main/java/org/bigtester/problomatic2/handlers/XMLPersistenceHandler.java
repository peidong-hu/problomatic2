package org.bigtester.problomatic2.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import org.bigtester.problomatic2.InitException;
import org.bigtester.problomatic2.Persistable;
import org.bigtester.problomatic2.Problem;

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
 * Persist a problem to an XML file for posterity. The problem must implement
 * the Persistable interface to be persisted. If the problem does not implement
 * Persistable, it is not stored. User: danstieglitz Date: Feb 29, 2004 Time:
 * 3:38:21 PM
 */
public class XMLPersistenceHandler extends AbstractProblemHandler {

	private static final Logger log = Logger.getLogger(XMLPersistenceHandler.class);
	
	public static final String KEY_XML_DATA = "xmlData";
	public static final String KEY_TRANSFORM_FLAG = "transformFlag";
	public static final String KEY_URL = "URL";
	
	private static final String PATH_TO_FILES = "xmlpersistencehandler.pathtofiles";
	private static final String WRITE_TO_DISK = "xmlpersistencehandler.writeToDisk";
	
	private static final String escapedChars = "<>\'\"&]";
	
	/**
	 * todo this implementation of initializing properties is not very clean...
	 * find a better way
	 */
	public void init(Properties props) throws InitException {
		setProperty(props, PATH_TO_FILES);
		setRequiredProperty(props, WRITE_TO_DISK);
	}
	
	private void persistUnderlyingExceptions(Problem aProblem, StringBuffer buf) {
		List underlyingExceptions = aProblem.getUnderlyingExceptions();
		buf.append("<underlying-exceptions>\n\t");
		Iterator keys = underlyingExceptions.iterator();
		while (keys.hasNext()) {
			Throwable exception = (Throwable) keys.next();
			buf.append("<exception class-name='"
					+ XMLescape(exception.getClass().getName()) + "'>\n\t\t");
			StringWriter stackTrace = new StringWriter();
			PrintWriter out = new PrintWriter(stackTrace);
			exception.printStackTrace(out);
			buf.append("<stack-trace>" + XMLescape(stackTrace.toString())
					+ "</stack-trace>");
			buf.append("<message>"+exception.getMessage()+"</message>");
			buf.append("</exception>\n");
			if (keys.hasNext()) {
				buf.append("\t");
			}
		}
		buf.append("</underlying-exceptions>");
	}

	private void persistAttributes(Problem aProblem, StringBuffer buf) {
		Set keySet = aProblem.getAttributes().keySet();
		buf.append("<attributes>\n\t");
		Iterator keys = keySet.iterator();
		while (keys.hasNext()) {
			String attributeName = (String) keys.next();
			buf.append("<attribute name='" + XMLescape(attributeName)
					+ "'>\n\t\t");
			buf
					.append("<value>"
							+ XMLescape(aProblem.getAttribute(attributeName)
									.toString()));
			buf.append("</value>\n\t");
			buf.append("</attribute>\n");
			if (keys.hasNext()) {
				buf.append("\t");
			}
		}
		buf.append("</attributes>");
	}

	private void persistMessages(Problem aProblem, StringBuffer buf) {
		List messages = aProblem.getMessages();
		buf.append("<messages>\n\t");
		Iterator messageIterator = messages.iterator();
		while (messageIterator.hasNext()) {
			String message = (String) messageIterator.next();
			buf.append("<message>\n\t\t");
			buf.append("<text>" + XMLescape(message) + "</text>");
			buf.append("</message>\n\t");
			if (messageIterator.hasNext()) {
				buf.append("\t");
			}
		}
		buf.append("</messages>");
	}

	public void handleProblem(Problem aProblem) {
		if (aProblem instanceof Persistable) {
			StringBuffer buf = new StringBuffer();
			buf.append("<?xml version='1.0' encoding='UTF-8'?>\n");
			buf.append("<problem class-name='" + aProblem.getClass().getName()
					+ "' occured-on='"
					+ aProblem.getAttribute("problomatic.occuredOn") + "'"
					+ ">\n\t");

			persistUnderlyingExceptions(aProblem, buf);
			persistMessages(aProblem, buf);
			persistAttributes(aProblem, buf);

			buf.append("</problem>");
			log.debug(buf.toString());
			aProblem.setAttribute(KEY_XML_DATA, buf.toString());

			if (getWriteToDisk()) {
				String filename = getPathToFiles() + File.separator
				+ generateUniqueName(aProblem);
				try {
					PrintWriter out = new PrintWriter(new OutputStreamWriter(
							new FileOutputStream(filename)));
					out.write(buf.toString());
					out.close();
					aProblem.setAttribute(KEY_URL, "file://" + filename);
					aProblem.setAttribute(KEY_TRANSFORM_FLAG, "1");
				} catch (FileNotFoundException e) {
					log.error(e);
				}
			}
		}
		else {
			log.warn("Encountered non-persistable Problem "+aProblem.getClass().getName());
		}

	}

	public String XMLescape(char c) {
		return (c == '<') ? "&lt;" : (c == '>') ? "&gt;"
				: (c == '\'') ? "&apos;" : (c == '\"') ? "&quot;"
						: (c == '&') ? "&amp;" : (c == ']') ? "&#93;" : null;
	}

	public String XMLescape(String s) {
		for (int n = 0; n < escapedChars.length(); n++)
			if (s.indexOf(escapedChars.charAt(n)) >= 0) {
				StringBuffer result = new StringBuffer(s.length() * 6 / 5);

				for (int i = 0; i < s.length(); i++) {
					char c = s.charAt(i);
					String esc = XMLescape(c);
					if (esc == null)
						result.append(c);
					else
						result.append(esc);
				}
				return result.toString();
			}
		return s;
	}

	/**
	 * @return
	 */
	private String getPathToFiles() {
		return getProperty(PATH_TO_FILES);
	}

	private boolean getWriteToDisk() {
		return Boolean.valueOf(getProperty(WRITE_TO_DISK)).booleanValue();
	}
	
	/**
	 * @return
	 */
	private String generateUniqueName(Problem aProblem) {
		return aProblem.getClass().getName() + "_" + new Date().getTime()
				+ ".xml";
	}

}