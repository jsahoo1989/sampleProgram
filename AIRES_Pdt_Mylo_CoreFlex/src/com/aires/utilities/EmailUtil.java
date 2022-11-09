package com.aires.utilities;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.azure.identity.UsernamePasswordCredential;
import com.azure.identity.UsernamePasswordCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.requests.GraphServiceClient;
import com.microsoft.graph.requests.MessageCollectionPage;
import com.vimalselvam.cucumber.listener.Reporter;

import okhttp3.Request;

public class EmailUtil {
	private static String[] _searchTag = new String[2];

	public static String[] getStartEndTagFromEmail(String infoToExtractFromMail) {
		switch (infoToExtractFromMail) {
		case CoreConstants.USER_NAME:
			_searchTag[0] = "<font style=\"padding-left:5px;\" size=\"3\" face=\"Arial\" color=\"#424143\"><b>";
			_searchTag[1] = "</b></font>";
			break;
		case PDTConstants.TRANSFEREE_USER_NAME:
			_searchTag[0] = "<strong>Username</strong> :";
			_searchTag[1] = "</span> </p>";
			break;
		case PDTConstants.TRANSFEREE_PASSWORD:
			_searchTag[0] = "Password: </span></b><span style=\"font-family:century gothic,Helvetica,Calibri,Roboto\">";
			_searchTag[1] = "</span> </p>";
			break;
		case MobilityXConstants.FLEX_BENEFIT_SUBMISSION:
			_searchTag[0] = "journey!<br><br></p><p>";
			_searchTag[1] = "<br><br>Your Aires";
			break;
		case MobilityXConstants.DELETE_REQUEST_APPROVED:
			_searchTag[0] = "Hello";
			_searchTag[1] = "Please use the link below to login";
			break;
		case MobilityXConstants.DELETE_REQUEST_DENIED:
			_searchTag[0] = "Hello";
			_searchTag[1] = "using the link below to log";
			break;
		case MobilityXConstants.INITIATION_FILE_ID:
			_searchTag[0] = "File ID: ";
			_searchTag[1] = "</th>";
			break;
		case MobilityXConstants.NEW_INITIATION_SUBMISSION_BENEFIT_TOTAL_POINTS:
		case MobilityXConstants.APPROVAL_EMAIL_BENEFIT_TOTAL_POINTS_AND_SUBMITTED_POINTS:
			_searchTag[0] = "Benefits Total Points: ";
			_searchTag[1] = "</th>";
			break;
		case MobilityXConstants.NEW_INITIATION_SUBMISSION_BENEFIT_TOTAL_POINTS_AND_SUBMITTED_POINTS:
			_searchTag[0] = "Benefits Total Points: ";
			_searchTag[1] = "</th>";
			break;
		case MobilityXConstants.REVISED_MOBILITY_INITIATION_SUBMISSION_BENEFIT_TOTAL_POINTS:
			_searchTag[0] = "Benefits Total Points: <span style=\"\">0</span> / <span style=\"color:Red\">";
			_searchTag[1] = "</span></th>";
			break;
		case MobilityXConstants.MOBILITY_APPROVAL_REQUEST:
			_searchTag[0] = "Hello";
			_searchTag[1] = "Please see below";
			break;
		case MobilityXConstants.APPROVAL_EMAIL_TRANSFEREE_FIRST_NAME:
			_searchTag[0] = "Legal First Name</td><td width=\"60%\" style=\"font-family:century gothic, Helvetica, Calibri, Roboto;font-size:14px;text-align:left;padding-left:10px;border:1px solid #E7F2F5;\">";
			_searchTag[1] = "</td></tr>";
			break;
		case MobilityXConstants.APPROVAL_EMAIL_TRANSFEREE_LAST_NAME:
			_searchTag[0] = "Legal Last Name</td><td width=\"60%\" style=\"font-family:century gothic, Helvetica, Calibri, Roboto;font-size:14px;text-align:left;padding-left:10px;border:1px solid #E7F2F5;\">";
			_searchTag[1] = "</td></tr>";
			break;
		case MobilityXConstants.APPROVAL_EMAIL_RELOCATION_POLICY:
			_searchTag[0] = "Relocation Policy</td><td width=\"60%\" style=\"font-family:century gothic, Helvetica, Calibri, Roboto;font-size:14px;text-align:left;padding-left:10px;border:1px solid #E7F2F5;\">";
			_searchTag[1] = "</td></tr>";
			break;
		case MobilityXConstants.SUBMIT_MY_RESPONSE:
			_searchTag[0] = "href=";
			_searchTag[1] = "><img alt=\"Submit My Response\"";
			break;
		case MobilityXConstants.NEW_INITIATION_SUBMISSION_STATUS:
			_searchTag[0] = "Status of the Initiation </td><td width=\"60%\" style=\"font-family:century gothic,Helvetica,Calibri,Roboto; font-size:14px; text-align:left; padding-left:10px; border:1px solid #E7F2F5\">";
			_searchTag[1] = "</td></tr></tbody></table>";
			break;
		default:
			Assert.fail(MobilityXConstants.INFORMATION_NOT_FOUND_IN_EMAIL);
		}
		return _searchTag;
	}

	public static String searchEmailAndReturnResult(String host, final String userName, final String password, String expFrom,
			String expEmailSubject, String infoToExtractFromMail) {
		String searchText = "";
		int iterationCount = 0;
		Log.info("expected email subject: " + expEmailSubject);
		_searchTag = getStartEndTagFromEmail(infoToExtractFromMail);
		try {
			CoreFunctions.waitHandler(10);
			List<Message> messages = getRecentMessagesRecieved(userName, password);
			while (true) {
				iterationCount++;
				for (Message message : messages) {
					Log.info("Actual email subject: " + message.subject + ": Expected email subject: "
							+ expEmailSubject);
					if (message.subject.contains(expEmailSubject)) {
						Log.info("Pass:Email Received from: " + message.from.emailAddress);
						Log.info("Email Received Date:" + message.receivedDateTime
								.format(DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm")));
						Log.info("Email Subject: " + message.subject);
						String messageText = message.body.content;
						Log.info("messageText==" + messageText);
						Log.info("searchTag[0]==" + _searchTag[0]);
						Log.info("searchTag[1]==" + _searchTag[1]);
						searchText = StringUtils.substringBetween(messageText, _searchTag[0], _searchTag[1]);
						Log.info("Searched Email Result :"+searchText);
						return (searchText.trim());
					}
				}
				if (iterationCount < 30)
					CoreFunctions.waitHandler(10);
				else
					break;
			}
			Log.info("No Email Received within " + iterationCount * 60 + " minutes From:" + expFrom + " with subject:"
					+ expEmailSubject);
			return CoreConstants.EMAIL_NOT_FOUND;
		} catch (Exception e) {
			Assert.fail(CoreConstants.ERROR + e.getMessage());
		}
		return searchText;
	}

	public static boolean verifyReceivedEmailSubjectMatch(String host, final String userName, final String password,
			String expEmailSubject) {
		int iterationCount = 0;
		Log.info("Verifying received email...");
		Log.info("expected email subject: " + expEmailSubject);
		try {
			CoreFunctions.waitHandler(10);
			List<Message> messages = getRecentMessagesRecieved(userName, password);
			while (true) {
				iterationCount++;
				for (Message message : messages) {
					if (message.subject.contains(expEmailSubject)) {
						Log.info("Pass:Email Received from: " + message.from.emailAddress);
						Log.info("Email Received Date:" + message.receivedDateTime
								.format(DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm")));
						Log.info("Email Subject: " + message.subject);
						String messageText = message.body.content;
						Log.info("messageText==" + messageText);
						Log.info("searchTag[0]==" + _searchTag[0]);
						Log.info("searchTag[1]==" + _searchTag[1]);
						return true;
					}
				}
				if (iterationCount < 30)
					CoreFunctions.waitHandler(10);
				else
					break;
			}
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VEIRFY_CONTIRBUTOR_NOT_RECEIVED_NOTIFICATION,
					CoreConstants.FAIL));
			Assert.fail("No Email Received within " + (iterationCount * 10) / 60 + " minutes with subject:"
					+ expEmailSubject);
		} catch (Exception e) {
			Assert.fail(CoreConstants.ERROR + e.getMessage());
		}
		return false;
	}

	public static String getLatestEmailSubject(String host, final String userName, final String password) {
		try {
			List<Message> messages = getRecentMessagesRecieved(userName, password);
			for (Message message : messages) {
				return message.subject;
			}
		} catch (Exception e) {
			Assert.fail(CoreConstants.ERROR + e.getMessage());
		}
		return "";
	}

	public static String verifyEmailPresentAndReturnResult(String host, final String userName, final String password,
			String expFrom, String expEmailSubject, String infoToExtractFromMail) {
		String searchText = "";
		int iterationCount = 0;
		Log.info("expected email subject: " + expEmailSubject);
		_searchTag = getStartEndTagFromEmail(infoToExtractFromMail);
		try {
			CoreFunctions.waitHandler(10);
			List<Message> messages = getRecentMessagesRecieved(userName, password);
			while (true) {
				iterationCount++;
				for (Message message : messages) {
					if (message.subject.contains(expEmailSubject)) {
						Log.info("Pass:Email Received from: " + message.from.emailAddress);
						Log.info("Email Received Date:" + message.receivedDateTime
								.format(DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm")));
						Log.info("Email Subject: " + message.subject);
						String messageText = message.body.content;
						Log.info("messageText==" + messageText);
						Log.info("searchTag[0]==" + _searchTag[0]);
						Log.info("searchTag[1]==" + _searchTag[1]);
						searchText = StringUtils.substringBetween(messageText, _searchTag[0], _searchTag[1]);
						Log.info("Searched Email Result :"+searchText);
						return searchText;
					}
				}
				if (iterationCount < 30)
					CoreFunctions.waitHandler(10);
				else
					break;
			}
			return CoreConstants.EMAIL_NOT_FOUND;
		} catch (

		Exception e) {
			Assert.fail(CoreConstants.ERROR + e.getMessage());
		}
		return searchText;
	}

	private static List<Message> getRecentMessagesRecieved(String email, String password) {
		try {
			final UsernamePasswordCredential usernamePasswordCredential = new UsernamePasswordCredentialBuilder()
					.clientId("724f1c20-511f-4f8f-a901-56daf6e0b4c5").username("airesautomation@aires.com")
					.tenantId("4a76d546-bb2b-44d3-94e6-23c28e086165").password("Aut0Mati0nT34mNov").build();

			final TokenCredentialAuthProvider tokenCredentialAuthProvider = new TokenCredentialAuthProvider(
					new ArrayList<String>() {
						{
							{
								add("user.read");
								add("openid");
								add("profile");
								add("offline_access");

							}
						}
					}, usernamePasswordCredential);

			GraphServiceClient<Request> graphClient = GraphServiceClient.builder()
					.authenticationProvider(tokenCredentialAuthProvider).buildClient();

			MessageCollectionPage user = graphClient.me().messages().buildRequest().get();

			return user.getCurrentPage();
		} catch (Exception e) {
			Assert.fail(CoreConstants.ERROR + e.getMessage());
		}
		return null;
	}

}
