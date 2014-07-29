package org.bigtester.problomatic2.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.bigtester.problomatic2.InitException;
import org.bigtester.problomatic2.Problem;
import org.bigtester.problomatic2.ProblemRenderer;
import org.bigtester.problomatic2.renderers.DefaultRenderer;

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
public class EmailNotificationHandler extends AbstractProblemHandler {

	private static final String HOST = "mail.smtp.host";

	private static final String USERNAME = "mail.smtp.username";

	private static final String PASSWORD = "mail.smtp.password";

	private static final String SUBJECT = "emailnotificationhandler.subject";

	private static final String RECIPIENTS = "emailnotificationhandler.recipients";

	private static final String SENDER = "emailnotificationhandler.sender";

	private static final String DELIMITER = ",";

	private static final String RENDERER = "emailnotificationhandler.renderer";

	public void init(Properties props) throws InitException {
		setRequiredProperty(props, HOST);
		setRequiredProperty(props, USERNAME);
		setRequiredProperty(props, PASSWORD);
		setPropertyInternal("mail.smtp.auth", "true");
		setRequiredProperty(props, RECIPIENTS);
		setProperty(props, SUBJECT);
		setRequiredProperty(props, SENDER);
		setProperty(props, RENDERER);
	}

	public ProblemRenderer getRenderer() {
		if (getProperty(RENDERER).equals("")) {
			return new DefaultRenderer();
		} else {
			Class clazz;
			try {
				clazz = Class.forName(getProperty(RENDERER));
				ProblemRenderer renderer = (ProblemRenderer) clazz
						.newInstance();
				return renderer;
			} catch (Throwable e) {
				throw new RuntimeException("Unable to instantiate renderer: "+getProperty(RENDERER));
			} 
		}
	}

	public void handleProblem(Problem aProblem) {
		String subject = getProperty(SUBJECT);
		String sender = getProperty(SENDER);
		ProblemRenderer renderer = getRenderer();
		try {
			postMail(getRecipients(), subject, renderer.renderProblem(aProblem).toString(), sender);
		} catch (MessagingException e) {
			e.printStackTrace();
			// todo: devise scheme for this situation
		}

	}

	private List getRecipients() {
		String recipientList = getProperty(RECIPIENTS);
		StringTokenizer tok = new StringTokenizer(recipientList, DELIMITER);
		ArrayList recipients = new ArrayList();
		while (tok.hasMoreTokens()) {
			recipients.add(tok.nextToken());
		}
		return recipients;

	}

	public void postMail(List recipients, String subject, String message,
			String from) throws MessagingException {
		boolean debug = false;

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(getProperties(), auth);

		session.setDebug(debug);

		// create a message
		Message msg = new MimeMessage(session);

		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.size()];

		for (int i = 0; i < recipients.size(); i++) {
			addressTo[i] = new InternetAddress((String) recipients.get(i));
		}

		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");
		Transport.send(msg);
	}

	/**
	 * SimpleAuthenticator is used to do simple authentication when the SMTP
	 * server requires it.
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			String username = getProperty(USERNAME);
			String password = getProperty(PASSWORD);
			return new PasswordAuthentication(username, password);
		}
	}

}