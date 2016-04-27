package com.neu.common;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import com.neu.model.Patient;
import com.neu.model.WorkRequest;

public class PhonesAndMails {
	public static String mailTo = "kaushik.k@husky.neu.edu.com";
	public static String mailFrom = "kshitijkaushik14@gmailcom";
	public static String messageTo = "";
	public static String messageFrom = "";
	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	String host = "localhost";

	public String sendMailDaily(Patient patient) {
		System.out.println("reached inside mail");
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.user", "kshitijkaushik14@gmailcom");
		properties.setProperty("mail.smtp.password", "kshitu14187");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.debug", "true");
		properties.put("mail.store.protocol", "pop3");
		properties.put("mail.transport.protocol", "smtp");
		final String username = "kshitijkaushik14@gmail.com";
		final String password = "kshitu14187";
		try {
			// Session session = Session.getDefaultInstance(properties, new
			// Authenticator() {
			// protected PasswordAuthentication getPasswordAuthentication() {
			// return new PasswordAuthentication(username, password);
			// }
			// });
			Session session = Session.getDefaultInstance(properties);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailFrom));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
			message.setSubject("Test results for patient <p><strong>" + patient.getRefNumber()
					+ "</p></strong> for latest checkup.");
			message.setContent("Patient Name = " + patient.getName() + "<br>" + "<strong>VitalSign</strong>",
					"text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect(null, username, password); // host, 25,
															// "myemailhere",
															// "mypasshere");
			message.saveChanges();
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("Message Send successfully");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return "mail sent successfully";
	}
}
