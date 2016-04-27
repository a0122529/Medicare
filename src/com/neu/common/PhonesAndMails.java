package com.neu.common;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import com.neu.dao.impl.DoctorDAOImpl;
import com.neu.dao.impl.PatientDAOImpl;
import com.neu.model.Diagnosis;
import com.neu.model.Encounter;
import com.neu.model.Patient;
import com.neu.model.WorkRequest;

public class PhonesAndMails {
	public static String mailTo = "kaushik.k@husky.neu.edu";
	public static String mailFrom = "kshitijkaushik14@gmailcom";
	public static String messageTo = "";
	public static String messageFrom = "";
	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	String host = "localhost";

	public String sendMailOnRequest(Patient patient) {
		Encounter enc = patient.getEncounterList().get(0);
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
			Session session = Session.getDefaultInstance(properties);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailFrom));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
			message.setSubject("Test results for patient " + patient.getRefNumber() + " for latest checkup.");
			message.setContent("Patient Name = " + patient.getName() + "<br><br>"
					+ "<strong>Vital Sign Information</strong>" + "<strong>Respiratory Rate</strong> = "
					+ enc.getVitalSign().getRespRate() + "<br>" + "<strong>Weight</strong> = "
					+ enc.getVitalSign().getWeight() + "<br>" + "<strong>Height</strong> = "
					+ enc.getVitalSign().getHeight() + "<br>" + "<strong>Blood Pressure</strong> = "
					+ enc.getVitalSign().getBp() + "<br>" + "<strong>BMI</strong> = " + enc.getVitalSign().getBmi()
					+ "<br>" + "<strong>Pulse</strong> = " + enc.getVitalSign().getPulse() + "<br>"
					+ "<strong>Skin Condition</strong> = " + enc.getVitalSign().getSkinCondition() + "<br>"

					, "text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect(null, username, password);
			message.saveChanges();
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("Message Send successfully");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return "mail sent successfully";
	}

	public String emailSummary(Encounter enc) {

		DoctorDAOImpl dDAO = new DoctorDAOImpl();
		Diagnosis diagnosis = dDAO.findDiabObj(enc.getDiagnosis());

		Patient patient = enc.getPatient();
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
			Session session = Session.getDefaultInstance(properties);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailFrom));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
			message.setSubject("Patient Record Summary");
			message.setContent("Patient Name = " + patient.getName() + "<br><br>"
					+ "<strong>Vital Sign Information</strong>" + "<strong>Respiratory Rate</strong> = "
					+ enc.getVitalSign().getRespRate() + "<br>" + "<strong>Weight</strong> = "
					+ enc.getVitalSign().getWeight() + "<br>" + "<strong>Height</strong> = "
					+ enc.getVitalSign().getHeight() + "<br>" + "<strong>Blood Pressure</strong> = "
					+ enc.getVitalSign().getBp() + "<br>" + "<strong>BMI</strong> = " + enc.getVitalSign().getBmi()
					+ "<br>" + "<strong>Pulse</strong> = " + enc.getVitalSign().getPulse() + "<br>"
					+ "<strong>Skin Condition</strong> = " + enc.getVitalSign().getSkinCondition() + "<br>"
					+ "<strong>Disease Knowledge</strong> = " + diagnosis.getEdulink() + "<br>", "text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect(null, username, password);
			message.saveChanges();
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("Message Send successfully");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return "mail sent successfully";
	}

	public String sendPhysicianPatientDetail(Patient patient) {
		int count = 0;
		ArrayList<Encounter> encList = new ArrayList<>();
		PatientDAOImpl pDAO = new PatientDAOImpl();
		encList = pDAO.sendEmailToPhysician(patient);
		StringBuffer sb = new StringBuffer();
		sb.append("Patient Vital Sign Details <br><br>");
		for (Encounter enc : encList) {
			if (count == 5) {
				break;
			} else {
				sb.append("<strong>Respiratory Rate</strong> = " + enc.getVitalSign().getRespRate()
						+ "<br> <strong>Weight</strong> = " + enc.getVitalSign().getWeight()
						+ "<br> <strong>Height</strong> = " + enc.getVitalSign().getHeight()
						+ "<br> <strong>Blood Pressure </strong> = " + enc.getVitalSign().getBp()
						+ "<br> <strong>BMI</strong> = " + enc.getVitalSign().getBmi()
						+ "<br> <strong>Pulse</strong> = " + enc.getVitalSign().getPulse()
						+ "<br> <strong>Skin Condition</strong> = " + enc.getVitalSign().getSkinCondition() + "");
				count++;
			}
		}
		// Encounter enc = patient.getEncounterList().get(0);
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
			Session session = Session.getDefaultInstance(properties);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailFrom));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(patient.getPhyEmail()));
			message.setSubject("Test results for patient " + patient.getName() + ", Ref Number "
					+ patient.getRefNumber() + " for Checkup and Medical Reconcilliation.");
			message.setContent(sb.toString(), "text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect(null, username, password);
			message.saveChanges();
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("Message Send successfully");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return "mail sent successfully";
	}

}
