package com.aires.utilities;

import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.vimalselvam.cucumber.listener.Reporter;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.PropertySet;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.enumeration.search.LogicalOperator;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.core.service.schema.ItemSchema;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.search.ItemView;
import microsoft.exchange.webservices.data.search.filter.SearchFilter;

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
			_searchTag[1] = "</span></p>";
			break;
		case PDTConstants.TRANSFEREE_PASSWORD:
			_searchTag[0] = "</span></b><span style=\"font-family:century gothic, Helvetica, Calibri, Roboto;\">";
			_searchTag[1] = "</span></p>";
			break;
		case MobilityXConstants.FLEX_BENEFIT_SUBMISSION:
			_searchTag[0] = "journey!<br><br>\r\n<p>";
			_searchTag[1] = "<br><br>\r\n\r\nYour Aires";
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
			_searchTag[0] = "Status of the Initiation </td><td width=\"60%\" style=\"font-family:century gothic, Helvetica, Calibri, Roboto;font-size:14px;text-align:left;padding-left:10px;border:1px solid #E7F2F5;\">";
			_searchTag[1] = "</td></tr>";
			break;
		default:
			Assert.fail(MobilityXConstants.INFORMATION_NOT_FOUND_IN_EMAIL);
		}
		return _searchTag;
	}

	public static String searchEmailAndReturnResult(String host, final String userName, final String password,
			String expFrom, String expEmailSubject, String infoToExtractFromMail) {
		String searchText = "";
		int iterationCount = 0;
		_searchTag = getStartEndTagFromEmail(infoToExtractFromMail);
		try {
			while (true) {
				iterationCount++;
				ExchangeService service = createConnection(userName, password);
				Log.info("Login Successful...");
				microsoft.exchange.webservices.data.core.service.folder.Folder inbox = microsoft.exchange.webservices.data.core.service.folder.Folder
						.bind(service, WellKnownFolderName.Inbox);
				// set number of items you want to retrieve
				ItemView view = new ItemView(10);
				List<SearchFilter> searchFilterCollection = new ArrayList<>();
				// flag to pick only email which contains attachments
				searchFilterCollection.add(new SearchFilter.ContainsSubstring(ItemSchema.Subject, expEmailSubject));
				SearchFilter finalSearchFilter = new SearchFilter.SearchFilterCollection(LogicalOperator.And,
						searchFilterCollection);
				ArrayList<Item> items = service.findItems(inbox.getId(), finalSearchFilter, view).getItems();
				if (items.size() > 0) {
					service.loadPropertiesForItems(items, PropertySet.FirstClassProperties);
					EmailMessage emailMessage = (EmailMessage) items.get(0);
					emailMessage.load();
					Log.info("Pass:Email Received from: " + emailMessage.getFrom().toString());
					Log.info("Email Received Date:" + emailMessage.getDateTimeReceived());
					Log.info("Email Subject: " + emailMessage.getSubject());
					String messageText = emailMessage.getBody().toString();
					Log.info("messageText==" + messageText);
					Log.info("searchTag[0]==" + _searchTag[0]);
					Log.info("searchTag[1]==" + _searchTag[1]);
					searchText = StringUtils.substringBetween(messageText, _searchTag[0], _searchTag[1]);
					return searchText;
				}
				if (iterationCount < 12)
					CoreFunctions.waitHandler(10);
				else
					break;
			}
			Log.info("No Email Received within 3 minutes From:" + expFrom + " with subject:" + expEmailSubject);
			return CoreConstants.EMAIL_NOT_FOUND;
		} catch (Exception e) {
			Assert.fail(CoreConstants.ERROR + e.getMessage());
		}
		return searchText;
	}

	public static boolean verifyReceivedEmailSubjectMatch(String host, final String userName, final String password,
			String expEmailSubject) throws Exception {
		int iterationCount = 0;
		Log.info("Verifying received email...");
		try {
			ExchangeService service = createConnection(userName, password);
			Log.info("Login Successful...");
			microsoft.exchange.webservices.data.core.service.folder.Folder inbox = microsoft.exchange.webservices.data.core.service.folder.Folder
					.bind(service, WellKnownFolderName.Inbox);
			// set number of items you want to retrieve
			ItemView view = new ItemView(10);
			List<SearchFilter> searchFilterCollection = new ArrayList<>();
			// flag to pick only email which contains attachments
			searchFilterCollection.add(new SearchFilter.ContainsSubstring(ItemSchema.Subject, expEmailSubject));
			SearchFilter finalSearchFilter = new SearchFilter.SearchFilterCollection(LogicalOperator.And,
					searchFilterCollection);
			while (true) {
				iterationCount++;
				ArrayList<Item> items = service.findItems(inbox.getId(), finalSearchFilter, view).getItems();
				service.loadPropertiesForItems(items, PropertySet.FirstClassProperties);
				if (items.size() > 0) {
					EmailMessage emailMessage = (EmailMessage) items.get(0);
					Log.info("Pass:Email Received from: " + emailMessage.getFrom().toString());
					Log.info("Email Received Date:" + emailMessage.getDateTimeReceived());
					Log.info("Email Subject: " + emailMessage.getSubject());
					String messageText = emailMessage.getBody().toString();
					Log.info("messageText==" + messageText);
					Log.info("searchTag[0]==" + _searchTag[0]);
					Log.info("searchTag[1]==" + _searchTag[1]);
					return true;
				}
				if (iterationCount < 12)
					CoreFunctions.waitHandler(10);
				else
					break;
			}
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VEIRFY_CONTIRBUTOR_NOT_RECEIVED_NOTIFICATION,
					CoreConstants.FAIL));
			Assert.fail("Unable to find email within 3 minute");
		} catch (Exception e) {
			Assert.fail(CoreConstants.ERROR + e.getMessage());
		}

		return false;
	}

	public static String getLatestEmailSubject(String host, final String userName, final String password) {
		try {
			ExchangeService service = createConnection(userName, password);
			Log.info("Login Successful...");
			microsoft.exchange.webservices.data.core.service.folder.Folder inbox = microsoft.exchange.webservices.data.core.service.folder.Folder
					.bind(service, WellKnownFolderName.Inbox);
			ItemView view = new ItemView(1);
			ArrayList<Item> items = service.findItems(inbox.getId(), view).getItems();
			service.loadPropertiesForItems(items, PropertySet.FirstClassProperties);
			EmailMessage emailMessage = (EmailMessage) items.get(0);
			return emailMessage.getSubject();
		} catch (Exception e) {
			Assert.fail(CoreConstants.ERROR + e.getMessage());
		}
		return "";
	}

	public static String verifyEmailPresentAndReturnResult(String host, final String userName, final String password,
			String expFrom, String expEmailSubject, String infoToExtractFromMail) throws Exception {
		String searchText = "";
		int iterationCount = 0;
		_searchTag = getStartEndTagFromEmail(infoToExtractFromMail);
		try {
			ExchangeService service = createConnection(userName, password);
			Log.info("Login Successful...");
			while (true) {
				microsoft.exchange.webservices.data.core.service.folder.Folder inbox = microsoft.exchange.webservices.data.core.service.folder.Folder
						.bind(service, WellKnownFolderName.Inbox);
				// set number of items you want to retrieve
				ItemView view = new ItemView(10);
				List<SearchFilter> searchFilterCollection = new ArrayList<>();
				// flag to pick only email which contains attachments
				searchFilterCollection.add(new SearchFilter.ContainsSubstring(ItemSchema.Subject, expEmailSubject));
				SearchFilter finalSearchFilter = new SearchFilter.SearchFilterCollection(LogicalOperator.And,
						searchFilterCollection);
				iterationCount++;
				ArrayList<Item> items = service.findItems(inbox.getId(), finalSearchFilter, view).getItems();
				if (items.size() > 0) {
					service.loadPropertiesForItems(items, PropertySet.FirstClassProperties);
					EmailMessage emailMessage = (EmailMessage) items.get(0);
					Log.info("Pass:Email Received from: " + emailMessage.getFrom().toString());
					Log.info("Email Received Date:" + emailMessage.getDateTimeReceived());
					Log.info("Email Subject: " + emailMessage.getSubject());
					String messageText = emailMessage.getBody().toString();
					Log.info("messageText==" + messageText);
					Log.info("searchTag[0]==" + _searchTag[0]);
					Log.info("searchTag[1]==" + _searchTag[1]);
					searchText = StringUtils.substringBetween(messageText, _searchTag[0], _searchTag[1]);
					return searchText;
				}
				if (iterationCount < 4)
					CoreFunctions.waitHandler(10);
				else
					break;
			}
			Log.info("No Email Received within 1 minutes From:" + expFrom + " with subject:" + expEmailSubject);
			return CoreConstants.EMAIL_NOT_FOUND;
		} catch (Exception e) {
			Assert.fail(CoreConstants.ERROR + e.getMessage());
		}
		return searchText;
	}

	private static ExchangeService createConnection(String email, String password) throws Exception {
		ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
		ExchangeCredentials credentials = new WebCredentials(email, password);
		service.setUrl(new URI("https://outlook.office365.com/EWS/Exchange.asmx"));
		service.setCredentials(credentials);
		return service;
	}

}
