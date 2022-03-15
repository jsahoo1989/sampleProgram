package com.aires.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import org.apache.commons.lang.StringUtils;
import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.vimalselvam.cucumber.listener.Reporter;

public class EmailUtil {
	private static String[] _searchTag = new String[2];

	private static String getTextFromMimeMultipart(Multipart mimeMultipart) throws MessagingException, IOException {
		String result = "";
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break; // without break same text appears twice
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent();
				// result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
				result = html;
				// System.out.println("RESULT===="+result);
			} else if (bodyPart.getContent() instanceof Multipart) {
				result = result + getTextFromMimeMultipart((Multipart) bodyPart.getContent());
			}
		}
		return result;
	}

	private static String getTextFromMessage(Message message) throws MessagingException, IOException {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

	@SuppressWarnings("unused")
	public static void verifyReceivedEmail(String host, final String userName, final String password, String expFrom,
			String expEmailSubject) throws Exception {
		Log.info("Verifying received email...");
		int count = 0;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		Store store;
		Log.info("Login Successful...");
		try {
			store = session.getStore("imaps");
			store.connect(host, userName, password);
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
			Message[] messages = emailFolder.getMessages();
			for (int i = messages.length - 1; i >= 0; i--) {
				Message message = messages[i];
				System.out.println("Flag of this Message : " + message.getFlags().contains(Flags.Flag.SEEN));
				System.out.println("Recent Message : " + message.getFlags().contains(Flags.Flag.RECENT));
				String emailSubject = message.getSubject();
				Address From = message.getFrom()[0];
				String actFrom = message.getFrom()[0].toString();
				System.out.println("From--" + From);
				System.out.println("emailSubject--" + emailSubject);
				System.out.println("actFrom--" + actFrom);
				System.out.println("getContentType--" + message.getContentType());
				System.out.println("expFrom--" + expFrom);
				System.out.println("expEmailSubject--" + expEmailSubject);
				if (actFrom.equals(expFrom) && emailSubject.contains(expEmailSubject)) {// &&
																						// message.getFlags().contains(Flags.Flag.RECENT))
																						// {
					Log.info("Pass:Email Received from: " + actFrom);
					count++;
					Log.info("Email number : " + i);
					Log.info("Email Received Date:" + message.getReceivedDate());
					Log.info("Email Subject: " + emailSubject);
					Log.info("Email From: " + message.getFrom()[0]);
					String messageText = getTextFromMessage(message);
					System.out.println("messageText==" + messageText);
					System.out.println("messageContent==" + message.getContent());
					// String link = messageText.split('<');
					// String link = StringUtils.substringBetween(messageText, "<", ">");
					// String strippedText = messageText.replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", "
					// ");
					// System.out.println("\n ----------------- Plain String Text is
					// -------------\n"+strippedText);
					System.out.println("Message Length : " + message.getContent().toString().length());
					System.out.println(messageText);
					Thread.sleep(2000);
					if (message.getContent().toString().contains("Username"))
						System.out.println("Pass: Username Exists");
					else
						System.out.println("Not Exists");

					String msgTxt = message.getContent().toString();
					// String link = StringUtils.substringBetween(msgTxt, "[Submit My Response]<",
					// ">");
					String link = StringUtils.substringBetween(messageText, "href=",
							"><img alt=\"Submit My Response\"");

					String submitMyResponseLink = StringUtils.substringBetween(messageText, "[Submit My Response]<",
							">");
					// String link = StringUtils.substringBetween(msgTxt, "Username</span></strong>
					// : ", "</span>");
					// System.out.println("The value for Username is : "+link);

					System.out.println("The Submit My Response Link : " + link);
					System.out.println("The Submit My Response Link : " + submitMyResponseLink);

					/*
					 * String[] url=messageText.split("<br>"); System.out.println("url[1]:"+url[0]);
					 * String[] url1=url[0].split("Username</span></strong> :");
					 * System.out.println("url1:"+url[0]); String[] url2=url1[0].split("</span>");
					 * System.out.println("url2:"+url2[0]); //path1=url2[0];
					 */
					break;
				}
			}
			if (count < 1) {
				Log.info(
						"Fail:No Email Received within 3 minutes From:" + expFrom + " with subject:" + expEmailSubject);
				Assert.fail();
			}

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public static String emailResetPwdLinkAccess(String host, final String userName, final String pwd, String expFrom,
			String expEmailSubject) {
		Log.info("Verifying received email");
		int count = 0;
		String path1 = " ";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, pwd);
			}
		});
		Store store;
		try {
			store = session.getStore("imaps");
			store.connect(host, userName, pwd);
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
			Message[] messages = emailFolder.getMessages();
			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];
				String emailSubject = message.getSubject();
				Address From = message.getFrom()[0];
				String actFrom = message.getFrom()[0].toString();
				outer: for (int j = 1; j < 2; j++) {
					CoreFunctions.verifyText(actFrom, expFrom);
					try {
						if (actFrom.equals(expFrom)) {
							CoreFunctions.verifyText(emailSubject, expEmailSubject);
							if (emailSubject.contains(expEmailSubject)) {
								Log.info("Pass:Email Received from:" + actFrom);
								count++;
								Log.info("Email number:" + i + 1);
								Log.info("Received Date:" + message.getReceivedDate());
								Log.info("Subject:" + emailSubject);
								Log.info("From:" + message.getFrom()[0]);
								Log.info("Text:" + message.getContent().toString());
								String myVar = EmailUtil.getTextFromMessage(message);
								String[] url = myVar.split("Reset Your Password");
								String[] url1 = url[1].split("<");
								String[] url2 = url1[1].split(">");
								path1 = url2[0];
								break outer;
							}
						}
					} catch (Exception e) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							
							e1.printStackTrace();
						}
					}
				}
			}
			if (count < 1) {
				Log.info(
						"Fail:No Email Received within 5 minutes From:" + expFrom + " with subject:" + expEmailSubject);
				Assert.fail();
			}

		} catch (NoSuchProviderException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		return path1;
	}

	@SuppressWarnings("unused")
	private static boolean hasAttachments(Message msg) throws Exception {
		if (msg.isMimeType("multipart/mixed")) {
			Multipart mp = (Multipart) msg.getContent();
			if (mp.getCount() > 1) {
				return true;
			}
		}

		return false;
	}

	public static void readAttachment(Message message) throws Exception {

		Multipart multiPart = (Multipart) message.getContent();
		for (int i = 0; i < multiPart.getCount(); i++) {
			MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(i);
			if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
				String destFilePath = "C:\\Srahul_Data\\TestMail" + part.getFileName();
				System.out.println("Email attachement ---- " + destFilePath);
				FileOutputStream output = new FileOutputStream(destFilePath);
				InputStream input = part.getInputStream();
				byte[] buffer = new byte[4096];
				int byteRead;
				while ((byteRead = input.read(buffer)) != -1) {
					output.write(buffer, 0, byteRead);
				}
				output.close();
			}
		}
	}

	public static String[] getStartEndTagFromEmail(String infoToExtractFromMail) {
		switch (infoToExtractFromMail) {
		case CoreConstants.USER_NAME:
			_searchTag[0] = "<font style=\"padding-left:5px;\" size=\"3\" face=\"Arial\" color=\"#424143\"><b>";
			_searchTag[1] = "</b></font>";
			break;
		case CoreConstants.PASSWORD:
			_searchTag[0] = "Your temporary password is <b>";
			_searchTag[1] = "</b></font>";
			break;
		case PDTConstants.TRANSFEREE_USER_NAME:
			_searchTag[0] = "<strong>Username</strong>\r\n\t\t\t\t\t\t\t\t\t\t:";
			_searchTag[1] = "</span>\r\n</p>";
			break;
		case PDTConstants.TRANSFEREE_PASSWORD:
			_searchTag[0] = "</span></b><span style=\"font-family:century gothic, Helvetica, Calibri, Roboto;\">";
			_searchTag[1] = "</span>\r\n</p>";
			break;
		case MobilityXConstants.FLEX_BENEFIT_SUBMISSION:
			_searchTag[0] = "journey!<br><br>\r\n<p>";
			_searchTag[1] = "<br><br>\r\n\r\nYour Aires";
			break;
		default:
			Assert.fail("Information not found");
		}
		return _searchTag;
	}

	@SuppressWarnings("unused")
	public static String searchEmailAndReturnResult(String host, final String userName, final String password,
			String expFrom, String expEmailSubject, String infoToExtractFromMail) throws Exception {
		String searchText = "";
		_searchTag = getStartEndTagFromEmail(infoToExtractFromMail);
		Log.info("Verifying received email...");
		int count = 0;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		Store store;
		Log.info("Login Successful...");
		CoreFunctions.waitHandler(10);
		try {
			store = session.getStore("imaps");
			store.connect(host, userName, password);
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
			Message[] messages = emailFolder.getMessages();
			for (int i = messages.length - 1; i >= 0; i--) {
				Message message = messages[i];
				String emailSubject = message.getSubject();
				Address From = message.getFrom()[0];
				String actFrom = message.getFrom()[0].toString();
				if (emailSubject.contains(expEmailSubject)) {
					Log.info("Pass:Email Received from: " + actFrom);
					count++;
					Log.info("Email number : " + i);
					Log.info("Email Received Date:" + message.getReceivedDate());
					Log.info("Email Subject: " + emailSubject);
					Log.info("Email From: " + message.getFrom()[0]);
					String messageText = getTextFromMessage(message);
					// Log.info("messageText=="+messageText);
					Log.info("searchTag[0]==" + _searchTag[0]);
					Log.info("searchTag[1]==" + _searchTag[1]);
					searchText = StringUtils.substringBetween(messageText, _searchTag[0], _searchTag[1]);
					break;
				}
			}
			if (count < 1) {
				Log.info(
						"Fail:No Email Received within 3 minutes From:" + expFrom + " with subject:" + expEmailSubject);
				Assert.fail();
			}
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return searchText;
	}

	public static boolean verifyReceivedEmailSubjectMatch(String host, final String userName, final String password,
			String expEmailSubject) throws Exception {
		Log.info("Verifying received email...");
		int count = 0;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		Store store;
		Log.info("Login Successful...");
		try {
			store = session.getStore("imaps");
			store.connect(host, userName, password);
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
			Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
			for (int i = messages.length - 1; i >= 0; i--) {
				Message message = messages[i];
				String emailSubject = message.getSubject();
				System.out.println("Email subject is--" + emailSubject);
				System.out.println("Expected Email subject is--" + expEmailSubject);
				System.out.println("Total messages are-" + messages.length);
				if (emailSubject.contains(expEmailSubject)) {
					Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_CONTIRBUTOR_RECEIVED_NOTIFICATION,
							CoreConstants.PASS));
					return true;
				} else {
					Thread.sleep(2000);
					count = count + 1;
					if (count == 30) {
						Reporter.addStepLog(MessageFormat.format(
								PDTConstants.VEIRFY_CONTIRBUTOR_NOT_RECEIVED_NOTIFICATION, CoreConstants.FAIL));
						Assert.fail("Unable to find email within 1 minute");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String getLatestEmailSubject(String host, final String userName, final String password) {
		Log.info("Verifying received email...");
		String subject = null;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		Store store;
		Log.info("Login Successful...");
		try {
			store = session.getStore("imaps");
			store.connect(host, userName, password);
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
			Message[] messages = emailFolder.getMessages();
			subject = messages[messages.length - 1].getSubject();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return subject;
	}

	public static boolean verifyReceivedEmailSubjectIsMatched(String host, final String userName, final String password,
			String expEmailSubject) throws Exception {
		Log.info("Verifying received email...");
		int count = 0;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		Store store;
		Log.info("Login Successful...");
		try {
			store = session.getStore("imaps");
			store.connect(host, userName, password);
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
			Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
			for (int i = messages.length - 1; i >= 0; i--) {
				Message message = messages[i];
				String emailSubject = message.getSubject();
				System.out.println("Email subject is--" + emailSubject);
				System.out.println("Expected Email subject is--" + expEmailSubject);
				System.out.println("Total messages are-" + messages.length);
				if (emailSubject.contains(expEmailSubject)) {
					Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_USER_RECEIVED_NOTIFICATION,
							CoreConstants.PASS, userName, expEmailSubject));
					return true;
				} else {
					Thread.sleep(2000);
					count = count + 1;
					if (count == 30) {
						Reporter.addStepLog(MessageFormat.format(PDTConstants.VEIRFY_USER_NOT_RECEIVED_NOTIFICATION,
								CoreConstants.FAIL, expEmailSubject));
						Assert.fail("Unable to find email within 1 minute");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
