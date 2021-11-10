package com.aires.utilities;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.PDTConstants;

public class SendAutomationReport_ViaMail_Test {
	
	public static void SendAttachmenteMail(String username, String password, String toMails) {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		/* props.put("mail.smtp.host", "outlook.office365.com"); */
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.auth", "true");	// for office365
		props.put("mail.smtp.starttls.enable", "true");	// for office365
		//props.put("mail.smtp.host", "outlook.com");
		props.put("mail.smtp.port", "587");

		System.out.println("Username: :"+username);
		System.out.println("Password: :"+password);
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() { System.out.println("1");
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			System.out.println("2");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					// InternetAddress.parse(toMail));
					InternetAddress.parse("rsharma@aires.com"));
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(toMails));
			message.setSubject("AIRES Automation - BDD Scenarios Execution Report");

			// create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setContent("Hi,<br><br>Please find attached Automation Report of BDD Scenarios Execution. The Test Run ID in TestRail is "
					+"<a href='http://corpprdvw100/testrail/index.php?/runs/view/"+CoreFunctions.getPropertyFromConfig("SniffSuite_TestRunId")+"'>"
					+CoreFunctions.getPropertyFromConfig("SniffSuite_TestRunId")+"</a>."
					+ " <br><br> Regards, <br> Automation Team. <br><br> PS: "
			+ "This is a system-generated email. Please do not respond.", "text/html;charset=UTF-8");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			//DataSource source = new FileDataSource(Reports.getReportPath());
			DataSource source = new FileDataSource("TestReports/"+CoreFunctions.getPropertyFromConfig("ReportName"));
			//DataSource source = new FileDataSource("C:\\Users\\rsharma\\eclipse-workspace\\AIRES_AppDemo\\TestReport\\AIRESTestReport2020.02.17.11.29.14.html");
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("AIRESAutomationReport.html");
			multipart.addBodyPart(messageBodyPart);

			// Put parts in message
			message.setContent(multipart);
			Transport.send(message);
			Log.info("Pass:Mail Sent");

		} catch (MessagingException e) {
			Log.info("Fail:Mail NOT sent:" + e);
		}
	}

	@Test
	public void callSendReportMailMethod() {
		SendAttachmenteMail(PDTConstants.OUTLOOK_USER_NAME, PDTConstants.OUTLOOK_PASSWORD, "rahul.sharma@intsof.com,npant@aires.com,srana@aires.com,spant@aires.com,pkashyap@aires.com");
	}
}