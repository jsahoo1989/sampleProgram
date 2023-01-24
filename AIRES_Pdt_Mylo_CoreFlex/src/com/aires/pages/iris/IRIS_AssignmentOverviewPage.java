package com.aires.pages.iris;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.pages.iris.basepage.BasePage;
import com.aires.testdatatypes.iris.IRIS_AssignmentData;
import com.aires.testdatatypes.iris.IRIS_AssignmentData.AiresFileTeamHistory;
import com.aires.testdatatypes.iris.IRIS_AssignmentData.Authorization;
import com.aires.testdatatypes.iris.IRIS_AssignmentData.ClientContact;
import com.aires.testdatatypes.iris.IRIS_AssignmentData.DestinationAddress;
import com.aires.testdatatypes.iris.IRIS_AssignmentData.File;
import com.aires.testdatatypes.iris.IRIS_AssignmentData.OriginAddress;
import com.aires.utilities.Log;
import com.aires.utilities.getWindowText;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.ButtonDescription;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.DialogDescription;
import com.hp.lft.sdk.java.Editor;
import com.hp.lft.sdk.java.EditorDescription;
import com.hp.lft.sdk.java.List;
import com.hp.lft.sdk.java.ListDescription;
import com.hp.lft.sdk.java.Menu;
import com.hp.lft.sdk.java.MenuDescription;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.TableDescription;
import com.hp.lft.sdk.java.UiObject;
import com.hp.lft.sdk.java.Window;
import com.hp.lft.sdk.java.WindowDescription;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class IRIS_AssignmentOverviewPage extends BasePage {

	public IRIS_AssignmentOverviewPage() throws Exception {
		super();
	}

	private static String _newAssignmentId = null;
	private Window file12CWindow = IRIS_PageMaster.getWindowObject("File");
	private Editor _fileIDEditor1 = IRIS_PageMaster.getEditorObject(file12CWindow, "File ID*");
	private static String _savedAssignmentTitle = null;
	private Window _assignmentWindow = null;
	private String _getCurrentWindowTitle = null;
	private boolean _isExists = false;
	private static String _clientId = null;
	private Table _authorizationTable = null;
	private Table _jTableAiresTeamHistory = null;
	private static int _rowCount = 0;
	String irisWindowTitle;

	/**
	 * Verify Overview tab title.
	 * 
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public boolean verifyOverviewTab() throws GeneralLeanFtException {
		file12CWindow.waitUntilVisible();
		_IRIS = file12CWindow;
		_IRIS.maximize();
		try {
			CoreFunctions.waitHandler(10);
			if (IRIS_PageMaster.getTabControlObject(_IRIS, 0).getSelectedTab().equals(IRISConstants.OVERVIEW)) {
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CURRENT_TAB, CoreConstants.PASS,
						IRIS_PageMaster.getTabControlObject(_IRIS, 0).getSelectedTab()));
				return true;
			}
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e.getStackTrace());
			Assert.fail("Failed to verify Overview tab");

		}
		return false;
	}

	/**
	 * Query Assignment by File Id.
	 * 
	 * @param fileNumber
	 */
	public void queryFile(String fileNumber) {
		try {
			file12CWindow.waitUntilVisible();
			_IRIS = file12CWindow;
			_IRIS.maximize();

			IRIS_PageMaster.getMenuObject(IRIS_PageMaster.getMenuObject(_IRIS, "Query"), "File").waitUntilEnabled();
			Helpers.selectMenu(IRIS_PageMaster.getMenuObject(IRIS_PageMaster.getMenuObject(_IRIS, "Query"), "File"),
					IRIS_PageMaster.getMenuObject(IRIS_PageMaster.getMenuObject(_IRIS, "Query"), "File").getLabel());
			_fileIDEditor1.waitUntilEnabled();
			CoreFunctions.waitHandler(2);
			Helpers.setEditorText(_fileIDEditor1, fileNumber, _fileIDEditor1.getAttachedText());
			Window file12CWindow = Desktop.describe(Window.class,
					new WindowDescription.Builder().title("File").build());
			Button executeButton = file12CWindow.describe(Button.class,
					new ButtonDescription.Builder().label("Execute").build());
			executeButton.click();
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_FILEID_QUERIED, CoreConstants.PASS, fileNumber));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Query Assignment by Transferee Name.
	 * 
	 * @param First Name, Last Name
	 */
	public void queryTransfereeName(String firstName, String lastName) {
		try {
			IRIS_PageMaster.getMenuObject(IRIS_PageMaster.getMenuObject(_IRIS, "Query"), "Transferee Name")
					.waitUntilEnabled();
			Helpers.selectMenu(
					IRIS_PageMaster.getMenuObject(IRIS_PageMaster.getMenuObject(_IRIS, "Query"), "Transferee Name"),
					IRIS_PageMaster.getMenuObject(IRIS_PageMaster.getMenuObject(_IRIS, "Query"), "Transferee Name")
							.getLabel());
			_IRIS.describe(Dialog.class, new DialogDescription.Builder().title("Query by Transferee's Name").build())
					.waitUntilEnabled();
			Helpers.setEditorText(
					IRIS_PageMaster.getEditorObject(_IRIS.describe(Dialog.class,
							new DialogDescription.Builder().title("Query by Transferee's Name").build()), "First Name"),
					firstName,
					IRIS_PageMaster.getEditorObject(
							_IRIS.describe(Dialog.class,
									new DialogDescription.Builder().title("Query by Transferee's Name").build()),
							"First Name").getAttachedText());
			Helpers.setEditorText(
					IRIS_PageMaster.getEditorObject(_IRIS.describe(Dialog.class,
							new DialogDescription.Builder().title("Query by Transferee's Name").build()), "Last Name"),
					lastName,
					IRIS_PageMaster.getEditorObject(
							_IRIS.describe(Dialog.class,
									new DialogDescription.Builder().title("Query by Transferee's Name").build()),
							"Last Name").getAttachedText());
			Helpers.clickButton(
					IRIS_PageMaster.getButtonObjectFromLabel(
							IRIS_PageMaster.getDialogObject(_IRIS, "Query by Transferee's Name"), "Execute"),
					IRIS_PageMaster
							.getButtonObjectFromLabel(
									IRIS_PageMaster.getDialogObject(_IRIS, "Query by Transferee's Name"), "Execute")
							.getLabel());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFY_TRANSFEREE_NAME_QUERIED, CoreConstants.PASS,
					firstName, lastName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyAndClickLinkSuggestionDialog() throws Exception {
		try {
			if (IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion").exists()) {
				Helpers.clickButton(
						IRIS_PageMaster.getButtonObject(IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion"),
								"This is a different person"),
						IRIS_PageMaster.getButtonObject(IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion"),
								"This is a different person").getLabel());
				IRIS_PageMaster.getDialogObject(IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion"),
						"Confirm Link Files").waitUntilVisible();
				Helpers.clickButton(
						IRIS_PageMaster.getButtonObject(IRIS_PageMaster.getDialogObject(
								IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion"), "Confirm Link Files"), "OK"),
						IRIS_PageMaster.getButtonObject(IRIS_PageMaster.getDialogObject(
								IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion"), "Confirm Link Files"), "OK")
								.getLabel());
			} else
				Log.info("Link Suggestion Dialog not Exists");
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verify Policy in Policy dropdown.
	 * 
	 * @param policyName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPolicy(String policyName) throws Exception {
		_isExists = Helpers.searchAndVerifySelectedItemInList(IRIS_PageMaster.getListObject(_IRIS, "Policy"),
				policyName);
		if (_isExists)
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_POLICY, CoreConstants.PASS, policyName,
					IRISConstants.OVERVIEW));

		return _isExists;
	}

	/**
	 * Switch to another Tab
	 * 
	 * @param tabName
	 */
	public void switchTab(String tabName) throws Exception {
		_IRIS = getIRISWindow();
		switch (tabName) {
		case IRISConstants.TRANSFEREE_AND_FAMILY:
			Helpers.selectTabControl(IRIS_PageMaster.getTabControlObject(_IRIS, 0),
					IRISConstants.TRANSFEREE_AND_FAMILY);
			break;
		case IRISConstants.OVERVIEW:
			Helpers.selectTabControl(IRIS_PageMaster.getTabControlObject(_IRIS, 0), IRISConstants.OVERVIEW);
			break;
		case IRISConstants.ACTIVITY_FINANCE_TAB:
			Helpers.selectTabControl(IRIS_PageMaster.getTabControlObject(_IRIS, 0), IRISConstants.ACTIVITY_FINANCE_TAB);
			break;
		case IRISConstants.EXCEPTIONS_TAB:
			Helpers.selectTabControl(IRIS_PageMaster.getTabControlObject(_IRIS, 0), IRISConstants.EXCEPTIONS_TAB);
			break;
		case IRISConstants.SERVICE_TAB:
			Helpers.selectTabControl(IRIS_PageMaster.getTabControlObject(_IRIS, 0), IRISConstants.SERVICE_TAB);
			break;
		case IRISConstants.PAYMENT_PREF:
			Helpers.selectTabControl(IRIS_PageMaster.getTabControlObject(_IRIS, 0), IRISConstants.PAYMENT_PREF);
			break;
		}
	}

	/**
	 * Verify Function name in AIRES Team History.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFunctionInAIRETeamHistory(DataTable table) throws Exception {
		java.util.List<String> functionNameInAIRES = table.asList(String.class);
		String[] emplName = new String[functionNameInAIRES.size()];
		boolean isExistsFunction[] = new boolean[functionNameInAIRES.size()];
		isExistsFunction[0] = true;
		for (int i = 1; i < functionNameInAIRES.size(); i++) {
			emplName[i] = Helpers.searchJTable(IRIS_PageMaster.getTableObjectWithIndex(_IRIS, "javax.swing.JTable", 0),
					IRISConstants.FUNCTION, functionNameInAIRES.get(i), IRISConstants.EMPLOYEE_NAME);
			isExistsFunction[i] = (emplName[i] != null) ? true : false;
			printAiresTeamHistoryReport(isExistsFunction[i], functionNameInAIRES.get(i), emplName[i]);
		}
		for (boolean isExist : isExistsFunction)
			if (!isExist)
				return false;
		return true;
	}

	/**
	 * Print AIRES Team History function search status to Report
	 * 
	 * @param valueExists
	 * @param functionName
	 * @param emplName
	 */
	public void printAiresTeamHistoryReport(boolean valueExists, String functionName, String emplName) {
		if (valueExists)
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_AIRES_TEAM_HISTORY, CoreConstants.PASS,
					functionName, emplName));
		else
			Reporter.addStepLog(MessageFormat.format(IRISConstants.FAILED_TO_VERIFY_TEXT_IN_AIRES_TEAM_HISTORY,
					CoreConstants.FAIL, functionName));

	}

	/**
	 * Select New from file Menu for Assignment
	 * 
	 * @throws Exception
	 */
	public void selectNewAssignmentFromFileMenu() throws Exception {
		try {
			IRIS_PageMaster.getMenuObject(IRIS_PageMaster.getMenuObjectWithPath(_IRIS, "File",
					"JMenu;JMenuBar;JPanel;JLayeredPane;JRootPane;AssignFrame;"), "New").waitUntilEnabled();
			Helpers.selectMenu(
					IRIS_PageMaster.getMenuObject(IRIS_PageMaster.getMenuObjectWithPath(_IRIS, "File",
							"JMenu;JMenuBar;JPanel;JLayeredPane;JRootPane;AssignFrame;"), "New"),
					IRISConstants.FILE_NEW_MENU);
		} catch (GeneralLeanFtException e) {
			Log.info(CoreConstants.FAIL + IRISConstants.CREATE_A_NEW_FILE);
			e.printStackTrace();
		}
	}

	public void selectExitFromFileMenu() throws Exception {
		try {
			IRIS_PageMaster
					.getMenuObject(
							IRIS_PageMaster.getMenuObjectWithPath(_IRIS, "File",
									"JMenu;JMenuBar;JPanel;JLayeredPane;JRootPane;AssignFrame;", "javax.swing.JMenu"),
							"Exit")
					.waitUntilEnabled();
			Helpers.selectMenu(
					IRIS_PageMaster.getMenuObject(
							IRIS_PageMaster.getMenuObjectWithPath(_IRIS, "File",
									"JMenu;JMenuBar;JPanel;JLayeredPane;JRootPane;AssignFrame;", "javax.swing.JMenu"),
							"Exit"),
					IRISConstants.FILE_RESET_MENU);
		} catch (GeneralLeanFtException e) {
			Log.info(CoreConstants.FAIL + IRISConstants.RESET_FILE);
			e.printStackTrace();
		}
	}

	/**
	 * Add all mandatory details on Overview Tab for New file/Assignment
	 * 
	 * @param policyName
	 * @param clientID
	 * 
	 * @param IRIS_AssignmentData
	 * @throws Exception
	 */
	public void addDetailsOnOverviewTabForNewAssignment(IRIS_AssignmentData overviewData, String clientID,
			String policyName) throws Exception {
		addFileSectionDetails(overviewData.file, clientID, policyName);
		addClientContactDetails(overviewData.clientContact);
		addOriginAddressDetails(overviewData.originAddress);
		addDestinationAddressDetails(overviewData.destinationAddress);
		// addAuthorizationInfo(overviewData.authorization);
		deleteAiresFileTeamHistoryDetails(IRISConstants.FUNCTION_PPC);
		saveAssignment(1);
		addAiresFileTeamHistoryDetails(IRISConstants.FUNCTION_PPC, overviewData.airesFileTeamHistory);
		saveAssignment(1);
		addAiresFileTeamHistoryDetails(IRISConstants.FUNCTION_MSPEC, overviewData.airesFileTeamHistory);
		saveAssignment(1);
		addAiresFileTeamHistoryDetails(IRISConstants.FUNCTION_PPCSPPRT, overviewData.airesFileTeamHistory);
		saveAssignment(1);
	}

	/**
	 * Add all mandatory details under file section.
	 * 
	 * @param policyName
	 * @param clientID
	 * 
	 * @param assignmentData
	 */
	public void addFileSectionDetails(File file, String clientID, String policyName) {
		try {
			Format f = new SimpleDateFormat("M/d/yyyy");
			String strDate = f.format(new Date());
			Assert.assertEquals(IRIS_PageMaster.getEditorObject(_IRIS, " Booked").getText(), strDate,
					IRISConstants.DATES_NOT_MATCHED);
			_IRIS.maximize();
			IRIS_PageMaster.getListObject(_IRIS, " Type").waitUntilEnabled();
			IRIS_PageMaster.getEditorObject(_IRIS, "Client ID*").waitUntilEnabled();
			Helpers.setEditorText(IRIS_PageMaster.getEditorObject(_IRIS, "Client ID*"), clientID,
					IRIS_PageMaster.getEditorObject(_IRIS, "Client ID*").getAttachedText());
			IRIS_PageMaster.getEditorObject(_IRIS, "Client Name").click();
			IRIS_PageMaster.getListObject(_IRIS, "Policy").waitUntilEnabled();
			IRIS_PageMaster.getListObject(_IRIS, "Policy").click();
			_clientId = IRIS_PageMaster.getEditorObject(_IRIS, "Client ID*").getText().toString();
			CoreFunctions.writeToPropertiesFile("Assignment_ClientID", _clientId);
			String _clientEditorName = IRIS_PageMaster.getEditorObject(_IRIS, "Client Name").getText();
			CoreFunctions.writeToPropertiesFile("Assignment_ClientName", _clientEditorName);
			if (IRIS_PageMaster.getEditorObject(_IRIS, "Client Name").getText().length() > 0) {
				Reporter.addStepLog(CoreConstants.PASS + IRISConstants.VERIFIED_ENTERED_CLIENT_ID + _clientId
						+ IRISConstants.CLIENT_NAME_DISPLAYED_TEXT
						+ IRIS_PageMaster.getEditorObject(_IRIS, "Client Name").getText() + "'");
				Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Policy"), policyName,
						IRIS_PageMaster.getListObject(_IRIS, "Policy").getAttachedText());
				CoreFunctions.writeToPropertiesFile("Assignment_Policy", policyName);
				Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, " Type"), file.type,
						IRIS_PageMaster.getListObject(_IRIS, " Type").getAttachedText());
				String currentWindowTitle = getWindowText.getActiveWindowText();
				_newAssignmentId = IRIS_PageMaster.getEditorObject(_IRIS, "File ID*").getText();
				CoreFunctions.writeToPropertiesFile("Assignment_FileID", _newAssignmentId);
				_savedAssignmentTitle = getSavedAssignmentTitle(currentWindowTitle, _newAssignmentId,
						IRISConstants.SAVE_ASSIGNMENT_MESSAGE_TITLE);
				saveAssignment(0);
//				CoreFunctions.waitHandler(7);
//				_IRIS = getIRISWindow();				
//				Helpers.clickLabel(IRIS_PageMaster.getLabelObject(_IRIS, "Expense Mgmt?"),
//						IRIS_PageMaster.getEditorObject(_IRIS, "Expense Mgmt?").getText());
				Reporter.addStepLog(MessageFormat.format(IRISConstants.NEW_ASSIGNMENT_ID_CREATED, CoreConstants.PASS,
						_newAssignmentId));
			} else {
				Assert.fail(IRISConstants.CLIENT_NAME_NOT_POPULATED + _clientId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Save Assignment.
	 * 
	 * @param clickCount
	 * @throws Exception
	 */
	public void saveAssignment(int clickCount) throws Exception {
		try {
			if (clickCount == 0) {
				Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save"),
						IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getAttachedText());
				// acceptWarningDialogIfDisplayed();
//				verifySaveSucceedDialog();
			} else {
				Button saveButtonAfterFileCreation = IRIS_PageMaster.getButtonObjectFromLabel(Desktop.describe(
						Window.class, new WindowDescription.Builder().title(_savedAssignmentTitle).build()), "Save");
				Helpers.clickButton(saveButtonAfterFileCreation, saveButtonAfterFileCreation.getAttachedText());
//				verifySaveSucceedDialog();
			}
			_assignmentWindow = IRIS_PageMaster.getWindowObject("File "
					+ CoreFunctions.getPropertyFromConfig("Assignment_FileID") + " - Aires LLC Agreement in place.");
			Dialog saveSucceededDialog = IRIS_PageMaster.getDialogObject(_assignmentWindow, "Save succeeded");
			saveSucceededDialog.waitUntilVisible();
			Button saveSucceedoKButton = IRIS_PageMaster.getButtonObjectFromLabel(saveSucceededDialog, "OK");
			Helpers.clickButton(saveSucceedoKButton, saveSucceedoKButton.getAttachedText());

		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
			Assert.fail(CoreConstants.FAIL + "Not Able to save the assignment");
		}
	}

	private void acceptWarningDialogIfDisplayed() throws Exception {
		_isExists = IRIS_PageMaster.getDialogObject(_IRIS, "Warning").getVisibleText().contains("Warning") ? true
				: false;
		if (_isExists) {
			Dialog warningDialog = IRIS_PageMaster.getDialogObject(_IRIS, "Warning");
			Button warningoKButton = IRIS_PageMaster.getButtonObjectFromLabel(warningDialog, "OK");
			Helpers.clickButton(warningoKButton, warningoKButton.getAttachedText());
			CoreFunctions.waitHandler(3);
		}
	}

	public void saveAssignment() throws Exception {
		Window file12C582393For = Desktop.describe(Window.class,
				new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build());
		Button saveButton = file12C582393For.describe(Button.class,
				new ButtonDescription.Builder().label("Save").build());
		saveButton.click();

		Dialog saveSucceededDialog = file12C582393For.describe(Dialog.class,
				new DialogDescription.Builder().title("Save succeeded").build());
		Button oKButton = saveSucceededDialog.describe(Button.class,
				new ButtonDescription.Builder().label("OK").build());
		oKButton.click();

	}

	/**
	 * Verify the title of Save succeed dialog.
	 */
	public void verifySaveSucceedDialog() {
		_getCurrentWindowTitle = getWindowText.getActiveWindowText();
		System.out.println("This is dialog text: " + _getCurrentWindowTitle);
		if (_getCurrentWindowTitle.contains(IRISConstants.SAVE_SUCCEEDED_MESSAGE)) {
			Log.info(CoreConstants.PASS + IRISConstants.FILE_SAVED + COREFLEXConstants.IS_DISPLAYED);
		} else {
			Log.info(CoreConstants.FAIL + IRISConstants.FILE_NOT_SAVED);
			Assert.fail(IRISConstants.FILE_NOT_SAVED);
		}
	}

	/**
	 * Get the title of saved file/assignment displayed on Window's title bar.
	 * 
	 * @param curTitle
	 * @param assignmentId
	 * @param msgToAppend
	 * @return
	 */
	public String getSavedAssignmentTitle(String curTitle, String assignmentId, String msgToAppend) {
		String assignmentTitle = null;
		try {
			CoreFunctions.waitHandler(2);
			assignmentTitle = curTitle + assignmentId + " - " + msgToAppend;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return assignmentTitle;
	}

	/**
	 * Fill client contact details.
	 * 
	 * @param clientContact.fName
	 */
	public void addClientContactDetails(ClientContact clientContact) {
		Log.info(IRISConstants.CLIENT_CONTACT_INFO);
		try {
			_IRIS = getIRISWindow();
			if (IRIS_PageMaster.getEditorObject(_IRIS, "Name(f*/m/l)").isEnabled()) {
				Helpers.setEditorText(IRIS_PageMaster.getEditorObject(_IRIS, "Name(f*/m/l)"), clientContact.fName,
						IRISConstants.FIRST_NAME);

				Helpers.setEditorText(
						IRIS_PageMaster.getEditorObjectWithIndex(_IRIS, "Client Contact", "javax.swing.JTextField", 1),
						clientContact.lName, IRISConstants.LAST_NAME);

				Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Prefix/Gen/Email"), clientContact.prefix,
						IRISConstants.PREFIX);

				IRIS_PageMaster.getListObject(_IRIS, "Client Contact").waitUntilEnabled();
				IRIS_PageMaster.getListObject(_IRIS, "Client Contact").select("M");

				Helpers.setEditorText(
						IRIS_PageMaster.getEditorObjectWithIndex(_IRIS, "Client Contact", "javax.swing.JTextField", 2),
						clientContact.email, IRISConstants.EMAIL);
			} else {
				Log.info(CoreConstants.FAIL + IRISConstants.CONTACT_SECTION_NOT_ENABLED);
				Assert.fail(IRISConstants.CONTACT_SECTION_NOT_ENABLED);
			}

		} catch (Exception e) {
			Log.info(CoreConstants.FAIL + e.getStackTrace());
			Assert.fail(CoreConstants.FAIL + clientContact);
		}
	}

	/**
	 * Fill Origin Address details.
	 * 
	 * @param originAddress
	 * @throws Exception
	 */
	public void addOriginAddressDetails(OriginAddress originAddress) throws Exception {
		Log.info(IRISConstants.ENTER_ORIGIN_ADDRESS);
		try {
			Helpers.setEditorText(
					IRIS_PageMaster.getEditorObjectWithIndex(_IRIS, "Street1", "javax.swing.JTextField", 0),
					originAddress.street1, IRIS_PageMaster
							.getEditorObjectWithIndex(_IRIS, "Street1", "javax.swing.JTextField", 0).getAttachedText());

			Helpers.setEditorText(
					IRIS_PageMaster.getEditorObjectWithIndex(_IRIS, "C*/St/Zip", "javax.swing.JTextField", 0),
					originAddress.city,
					IRIS_PageMaster.getEditorObjectWithIndex(_IRIS, "C*/St/Zip", "javax.swing.JTextField", 0)
							.getAttachedText());

			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Origin Address"), originAddress.state,
					IRIS_PageMaster.getListObject(_IRIS, "Origin Address").getAttachedText());

			Helpers.setEditorText(
					IRIS_PageMaster.getEditorObjectWithNativeClass(_IRIS, "Origin Address", "javax.swing.JTextField"),
					originAddress.zip,
					IRIS_PageMaster.getEditorObjectWithNativeClass(_IRIS, "Origin Address", "javax.swing.JTextField")
							.getAttachedText());

			Helpers.selectFromList(IRIS_PageMaster.getListObjectWithIndex(_IRIS, "Country*", 0), originAddress.country,
					IRIS_PageMaster.getListObjectWithIndex(_IRIS, "Country*", 0).getAttachedText());
			String _originAddress = originAddress.city + ", " + originAddress.state + ", " + originAddress.country;
			CoreFunctions.writeToPropertiesFile("Assignment_OriginAddress", _originAddress);

		} catch (GeneralLeanFtException e) {
			Log.info(CoreConstants.FAIL + e.getStackTrace());
			Assert.fail(CoreConstants.FAIL + "Missing details for Origin Address Section on Ocerview Tab");
		}
	}

	/**
	 * Fill Destination Address Details.
	 * 
	 * @param destinationAddress
	 */
	public void addDestinationAddressDetails(DestinationAddress destinationAddress) {
		Log.info(IRISConstants.ENTER_DESTINATION_ADDRESS);
		try {
			Helpers.setEditorText(
					IRIS_PageMaster.getEditorObjectWithIndex(_IRIS, "Street1", "javax.swing.JTextField", 1),
					destinationAddress.street1, IRIS_PageMaster
							.getEditorObjectWithIndex(_IRIS, "Street1", "javax.swing.JTextField", 1).getAttachedText());

			Helpers.setEditorText(
					IRIS_PageMaster.getEditorObjectWithIndex(_IRIS, "C*/St/Zip", "javax.swing.JTextField", 1),
					destinationAddress.city,
					IRIS_PageMaster.getEditorObjectWithIndex(_IRIS, "C*/St/Zip", "javax.swing.JTextField", 1)
							.getAttachedText());

			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Destination Address"),
					destinationAddress.state,
					IRIS_PageMaster.getListObject(_IRIS, "Destination Address").getAttachedText());

			Helpers.setEditorText(IRIS_PageMaster.getEditorObject(_IRIS, "Destination Address"), destinationAddress.zip,
					IRIS_PageMaster.getEditorObject(_IRIS, "Destination Address").getAttachedText());

			Helpers.selectFromList(IRIS_PageMaster.getListObjectWithIndex(_IRIS, "Country*", 1),
					destinationAddress.country,
					IRIS_PageMaster.getListObjectWithIndex(_IRIS, "Country*", 1).getAttachedText());
			String _destinationAddress = destinationAddress.city + ", " + destinationAddress.state + ", "
					+ destinationAddress.country;
			CoreFunctions.writeToPropertiesFile("Assignment_DestinationAddress", _destinationAddress);

		} catch (Exception e) {
			Log.info(CoreConstants.FAIL + e.getStackTrace());
			Assert.fail(CoreConstants.FAIL + "Missing Details for Destination Address Section on Overview Tab");
		}
	}

	/**
	 * Fill Authorization Info details.
	 * 
	 * @param authorization
	 * @throws Exception
	 */
	public void addAuthorizationInfo(Authorization authorization) throws Exception {
		try {
			String empNum = authorization.number + CoreFunctions.generateRandomNumberAsGivenLength(5);
			CoreFunctions.writeToPropertiesFile("Empolyee_Id", empNum);
			_assignmentWindow = _IRIS;
			Helpers.clickButton(IRIS_PageMaster.getButtonObject(_assignmentWindow, "Add", 1),
					IRIS_PageMaster.getButtonObject(_assignmentWindow, "Add", 1).getAttachedText());

			_authorizationTable = IRIS_PageMaster.getTableObjectWithAttachText(_assignmentWindow, "javax.swing.JTable",
					"<html><u>Link/Unlink</u></html>");
			_rowCount = _authorizationTable.getRows().size();
			Helpers.setTableCellValue(_authorizationTable, _rowCount - 1, "Type", authorization.type);
			Helpers.setTableCellValue(_authorizationTable, _rowCount - 1, "Number", empNum);
			_authorizationTable.activateRow(_rowCount - 1);

			UiObject jScrollPaneUiObject = IRIS_PageMaster.getUiObject(_assignmentWindow, "javax.swing.JScrollPane", 3);
			jScrollPaneUiObject.click();
		} catch (GeneralLeanFtException e) {
			Log.info(CoreConstants.FAIL + e.getStackTrace());
			Assert.fail(
					CoreConstants.FAIL + "Not able to add details under 'Authorization Info' section on Overview Tab");
		}
	}

	public void deleteAiresFileTeamHistoryDetails(String functionName) throws Exception {
		try {
			_IRIS = Desktop.describe(Window.class,
					new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build());
			_assignmentWindow = _IRIS;
			_jTableAiresTeamHistory = IRIS_PageMaster.getTableObjectWithIndex(_assignmentWindow, "javax.swing.JTable",
					0);
			_rowCount = _jTableAiresTeamHistory.getRows().size();

			switch (functionName) {
			case IRISConstants.FUNCTION_PPC:
				_jTableAiresTeamHistory.selectRows(1);
				Button deleteButton = _assignmentWindow.describe(Button.class,
						new ButtonDescription.Builder().label("Delete").build());
				deleteButton.click();
				Dialog deleteConfirmedDialog = _assignmentWindow.describe(Dialog.class,
						new DialogDescription.Builder().title("Delete Confirmed").build());
				Button oKButton = deleteConfirmedDialog.describe(Button.class,
						new ButtonDescription.Builder().label("OK").build());
				oKButton.click();
				break;
			default:
				Assert.fail(IRISConstants.NO_FUNCTION_SELECTED);
			}
		} catch (GeneralLeanFtException e) {
			Log.info(CoreConstants.FAIL + e.getStackTrace());
			Assert.fail(CoreConstants.FAIL
					+ "Not able to add details under 'Aires File Team History' section on Overview Tab");
		}

	}

	public void addAiresFileTeamHistoryDetails(String functionName, AiresFileTeamHistory airesFileTeamHistory)
			throws Exception {
		try {
			_IRIS = Desktop.describe(Window.class,
					new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build());
			_assignmentWindow = _IRIS;
			Helpers.clickButton(IRIS_PageMaster.getButtonObject(_assignmentWindow, "Add", 0),
					IRIS_PageMaster.getButtonObject(_assignmentWindow, "Add", 0).getAttachedText());

			_jTableAiresTeamHistory = IRIS_PageMaster.getTableObjectWithIndex(_assignmentWindow, "javax.swing.JTable",
					0);
			_rowCount = _jTableAiresTeamHistory.getRows().size();
			switch (functionName) {
			case IRISConstants.FUNCTION_EMAC:
				_jTableAiresTeamHistory.getCell(_rowCount - 1, "Function").setValue(airesFileTeamHistory.functionEMAC);
				_jTableAiresTeamHistory.getCell(_rowCount - 1, "Emp Name").setValue(airesFileTeamHistory.empNameEMAC);
				break;
			case IRISConstants.FUNCTION_MSPEC:
				_jTableAiresTeamHistory.getCell(_rowCount - 1, "Function").setValue(airesFileTeamHistory.functionMSPEC);
				_jTableAiresTeamHistory.getCell(_rowCount - 1, "Emp Name").setValue(airesFileTeamHistory.empNameMSPEC);
				break;
			case IRISConstants.FUNCTION_PPC:
				_jTableAiresTeamHistory.getCell(_rowCount - 1, "Function").setValue(airesFileTeamHistory.functionPPC);
				_jTableAiresTeamHistory.getCell(_rowCount - 1, "Emp Name").setValue(airesFileTeamHistory.empNamePPC);
				break;
			case IRISConstants.FUNCTION_PPCSPPRT:
				_jTableAiresTeamHistory.getCell(_rowCount - 1, "Function").setValue(airesFileTeamHistory.functionPPCSPPRT);
				_jTableAiresTeamHistory.getCell(_rowCount - 1, "Emp Name").setValue(airesFileTeamHistory.empNamePPCSPPRT);
				break;

			default:
				Assert.fail(IRISConstants.NO_FUNCTION_SELECTED);
			}
		} catch (GeneralLeanFtException e) {
			Log.info(CoreConstants.FAIL + e.getStackTrace());
			Assert.fail(CoreConstants.FAIL
					+ "Not able to add details under 'Aires File Team History' section on Overview Tab");
		}
	}

	public void clickOnLinkUnlinkElement(String linkUnlinkElement, String btnName) throws Exception {
		CoreFunctions.waitHandler(1);
		Helpers.clickLabel(IRIS_PageMaster.getLabelObject(_IRIS, "<html><u>Link/Unlink</u></html>"),
				IRISConstants.LINK_UNLINK_TEXT);
		clickRadioButton(btnName);
		clickNextButton();
		Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFY_LINK_UNLINK_ELEMENT_CLICKED, CoreConstants.PASS,
				linkUnlinkElement));
	}

	public void UnlinkAssignmentToExistingFile(String BtnName) throws Exception {
		CoreFunctions.waitHandler(1);
		Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Unlink this file from this person"),
				IRISConstants.UNLINK_ASSIGNMENT);
		Reporter.addStepLog(
				MessageFormat.format(IRISConstants.VERIFIED_BUTTON_IS_CLICKED, CoreConstants.PASS, BtnName));
	}

	public void clickRadioButton(String radioBtn) throws Exception {
		CoreFunctions.waitHandler(1);
		switch (radioBtn) {
		case IRISConstants.LINK_ASSIGNMENT:
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_RADIO_BUTTON_IS_CLICKED, CoreConstants.PASS, radioBtn));
			break;
		case IRISConstants.UNLINK_ASSIGNMENT:
			Helpers.clickRadioButton(IRIS_PageMaster.getRadioButtonObject(_IRIS,
					"<html><p><b>Unlink this file from this person</b></p><p>For example, these are two different transferees whose information was mistakenly linked.</p></html>"),
					IRISConstants.UNLINK_ASSIGNMENT);
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_RADIO_BUTTON_IS_CLICKED, CoreConstants.PASS, radioBtn));
			break;
		}
	}

	public void clickNextButton() throws Exception {
		CoreFunctions.waitHandler(1);
		Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(
				IRIS_PageMaster.getDialogObject(_IRIS, "Link/Unlink Files"), "Next"), IRISConstants.NEXT_BUTTON);
	}

	public void clickOnThisFileIsANewTransferOrAssignmentBtn(String btnName) throws Exception {
		CoreFunctions.waitHandler(1);
		Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(
				IRIS_PageMaster.getWindowObject(
						"File - 12C 577800  for Shreshtha Gupta of MobilityX Inc. - Aires LLC Agreement in place."),
				"Search and Link Similar File"), "This file is a new transfer or assignment for the selected person"),
				IRISConstants.NEW_TRANSFEREE_OR_ASSIGNMENT);
		CoreFunctions.waitHandler(1);
		Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(
				IRIS_PageMaster.getWindowObject(
						"File - 12C 577800  for Shreshtha Gupta of MobilityX Inc. - Aires LLC Agreement in place."),
				"Link File"), "OK"), IRISConstants.OK_BUTTON);
		Reporter.addStepLog(
				MessageFormat.format(IRISConstants.VERIFIED_BUTTON_IS_CLICKED, CoreConstants.PASS, btnName));
	}

	public void linkAssignmentToExistingFile(DataTable table) throws Exception {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		CoreFunctions.waitHandler(2);
		String firstName = data.get(0).get(IRISConstants.FIRST_NAME);
		Helpers.setEditorText(IRIS_PageMaster.getEditorObject(IRIS_PageMaster.getDialogObject(
				IRIS_PageMaster.getWindowObject(
						"File - 12C 577800  for Shreshtha Gupta of MobilityX Inc. - Aires LLC Agreement in place."),
				"Search and Link Similar File"), "First Name:"), firstName, IRISConstants.FIRST_NAME);
		String lastName = data.get(0).get(IRISConstants.LAST_NAME);
		Helpers.setEditorText(IRIS_PageMaster.getEditorObject(IRIS_PageMaster.getDialogObject(
				IRIS_PageMaster.getWindowObject(
						"File - 12C 577800  for Shreshtha Gupta of MobilityX Inc. - Aires LLC Agreement in place."),
				"Search and Link Similar File"), "Last Name:"), lastName, IRISConstants.LAST_NAME);
		String fileID = data.get(0).get(IRISConstants.FILE_ID);
		Helpers.setEditorText(IRIS_PageMaster.getEditorObject(IRIS_PageMaster.getDialogObject(
				IRIS_PageMaster.getWindowObject(
						"File - 12C 577800  for Shreshtha Gupta of MobilityX Inc. - Aires LLC Agreement in place."),
				"Search and Link Similar File"), "File ID:"), fileID, IRISConstants.FILE_ID);
		Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Search"), IRISConstants.SEARCH_BUTTON);
		Helpers.selectTableRow(IRIS_PageMaster.getTableObject(IRIS_PageMaster.getDialogObject(
				IRIS_PageMaster.getWindowObject(
						"File - 12C 577800  for Shreshtha Gupta of MobilityX Inc. - Aires LLC Agreement in place."),
				"Search and Link Similar File")), 0);
		clickOnThisFileIsANewTransferOrAssignmentBtn(IRISConstants.NEW_TRANSFEREE_OR_ASSIGNMENT);
		Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFY_TRANSFEREE_DETAILS_ENTERED, CoreConstants.PASS,
				firstName, lastName, fileID));
	}

	public boolean verfiyUnlinkFileMessage(String msg) throws Exception {
		_isExists = IRIS_PageMaster.getDialogObject(_IRIS, "Unlink File").getVisibleText().contains(msg) ? true : false;
		if (_isExists) {
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_MESSAGE_ON_UNLINK_FILE, CoreConstants.PASS, msg));
			Helpers.clickButton(
					IRIS_PageMaster.getDialogObject(_IRIS, "Unlink File").describe(Button.class,
							new ButtonDescription.Builder().label("OK").build()),
					IRIS_PageMaster.getDialogObject(_IRIS, "Unlink File")
							.describe(Button.class, new ButtonDescription.Builder().label("OK").build()).getLabel());
		}
		return _isExists;
	}

	public boolean verfiyAssignmentIsUnlinked(String fileId) throws Exception {
		if ((!IRIS_PageMaster.getTreeViewObject(_IRIS, "Pre-assignment").getVisibleText().contains(fileId)) ? true
				: false) {
			_isExists = true;
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_FILE_ID_REMOVED, CoreConstants.PASS, fileId));
		}
		return _isExists;
	}

	public boolean verfiyAssignmentIsLinked() throws Exception {
		CoreFunctions.waitHandler(2);
		if (IRIS_PageMaster.getTreeViewObject(_IRIS, "Pre-assignment").getVisibleText()
				.contains(IRISConstants.TRANSFEREE_ADDRESS) ? true : false) {
			_isExists = true;
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_TRANSFEREE_ADDRESS_DISPLAYED,
					CoreConstants.PASS, IRISConstants.TRANSFEREE_ADDRESS));
		}
		return _isExists;
	}

	public void attachFromDocumentManagement(String linkName, String tabName) throws Exception {
		irisWindowTitle = getWindowText.getActiveWindowText();
		Menu documentManagementMenu = getIRISWindow().describe(Menu.class,
				new MenuDescription.Builder().label(tabName).build());
		switch (linkName) {
		case IRISConstants.ATTACH_MENU:
			Menu attachMenu = documentManagementMenu.describe(Menu.class,
					new MenuDescription.Builder().label(linkName).build());
			Thread.sleep(2000);
			Helpers.selectMenu(attachMenu, IRISConstants.ATTACH_MENU);
			break;
		case IRISConstants.VIEW_ALL_ALL_MENU:
			Menu viewMenu = documentManagementMenu.describe(Menu.class,
					new MenuDescription.Builder().label("View").build());
			Menu aLLMenu = viewMenu.describe(Menu.class,
					new MenuDescription.Builder().label("ALL").nativeClass("javax.swing.JMenu").build());
			Menu aLLMenu1 = aLLMenu.describe(Menu.class, new MenuDescription.Builder().label("ALL").build());
			Thread.sleep(2000);
			Helpers.selectMenu(aLLMenu1, IRISConstants.VIEW_ALL_ALL_MENU);
			break;
		}
		Reporter.addStepLog(
				MessageFormat.format(IRISConstants.VERIFIED_DOC_MGMT_LINK_CLICKED, CoreConstants.PASS, linkName));
	}

	/**
	 * Verify Editor value on Overview tab.
	 * 
	 * @param editorMap
	 * @param tabName
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public HashMap<String, Boolean> verifyTextEditorValuesOnOverviewTab(HashMap<String, String> editorMap,
			String tabName) throws GeneralLeanFtException {
		HashMap<String, Boolean> editorResultMap = new HashMap<String, Boolean>();
		for (@SuppressWarnings("rawtypes")
		Map.Entry m : editorMap.entrySet()) {
			_isExists = BusinessFunctions.verifyTextEditorValueInIris(getElementByName(m.getKey().toString()),
					m.getKey().toString(), m.getValue().toString(), tabName);
			editorResultMap.put(m.getKey().toString(), _isExists);
		}
		return editorResultMap;
	}

//	/**
//	 * Verify Drop down value on partner tab.
//	 * 
//	 * @param dropDownMap
//	 * @param tabName
//	 * @return
//	 * @throws GeneralLeanFtException
//	 */
//	public HashMap<String, Boolean> verifyDropDownValuesOnOverviewTab(HashMap<String, String> dropDownMap,
//			String tabName) throws GeneralLeanFtException {
//		HashMap<String, Boolean> dropDownResultMap = new HashMap<String, Boolean>();
//		for (@SuppressWarnings("rawtypes")
//		Map.Entry m : dropDownMap.entrySet()) {
//			_isExists = BusinessFunctions.verifyDropDownValueInIris(getElementByListName(m.getKey().toString()),
//					m.getKey().toString(), m.getValue().toString(), tabName);
//			dropDownResultMap.put(m.getKey().toString(), _isExists);
//		}
//		return dropDownResultMap;
//	}

	/**
	 * Return List object for the elementName passed as parameter.
	 * 
	 * @param elementName
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public List getElementByListName(String elementName) throws GeneralLeanFtException {
		List element = null;
		Window _IRIS = Desktop.describe(Window.class,
				new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build());
		switch (elementName) {
		case IRISConstants.status:
			List _statusList = _IRIS.describe(List.class,
					new ListDescription.Builder().attachedText("Status*").build());
			element = _statusList;
			break;
		case IRISConstants.POLICY_TEXT:
			List _policyList = _IRIS.describe(List.class, new ListDescription.Builder().attachedText("Policy").build());
			element = _policyList;
			break;
		default:
			Assert.fail(COREFLEXConstants.NO_ELEMENT_FOUND);
			break;
		}

		return element;
	}

	/**
	 * Return Editor object for the elementName passed as parameter.
	 * 
	 * @param elementName
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public Editor getElementByName(String elementName) throws GeneralLeanFtException {
		Editor element = null;
		Window _IRIS = Desktop.describe(Window.class,
				new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build());
		switch (elementName) {
		case IRISConstants.FILE_ID:
			Editor _fileIDEditor = _IRIS.describe(Editor.class,
					new EditorDescription.Builder().attachedText("File ID*").build());
			;
			element = _fileIDEditor;
			break;
		case IRISConstants.CLIENT_ID:
			Editor _clientIDEditor = _IRIS.describe(Editor.class,
					new EditorDescription.Builder().attachedText("Client ID*").build());
			element = _clientIDEditor;
			break;
		case IRISConstants.CLIENT_NAME:
			Editor _clientNameEditor = _IRIS.describe(Editor.class,
					new EditorDescription.Builder().attachedText("Client Name").build());
			element = _clientNameEditor;
			break;
		default:
			Assert.fail(COREFLEXConstants.NO_ELEMENT_FOUND);
			break;
		}

		return element;
	}

	/**
	 * Select File status from the status drop down.
	 * 
	 * @param status
	 * @throws Exception
	 */
	public void selectFileStatus(String status, String tabName) throws Exception {
		IRIS_PageMaster.getMenuObject(IRIS_PageMaster.getMenuObject(_IRIS, "Query"), "File").waitUntilEnabled();
		Helpers.selectMenu(IRIS_PageMaster.getMenuObject(IRIS_PageMaster.getMenuObject(_IRIS, "Query"), "File"),
				IRISConstants.QUERY_FILE_MENU);
		IRIS_PageMaster.getListObject(_IRIS, "Status*").waitUntilEnabled();
		Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Status*"), status,
				IRIS_PageMaster.getListObject(_IRIS, "Status*").getAttachedText());
		Reporter.addStepLog(
				MessageFormat.format(IRISConstants.VERIFIED_SELECTED_STATUS, CoreConstants.PASS, status, tabName));
	}

	/**
	 * Enter clientId & press Execute button.
	 * 
	 * @param clientId
	 * @throws GeneralLeanFtException
	 */
	public void enterClientId(String clientId, String tabName) throws Exception {
		Helpers.setEditorText(IRIS_PageMaster.getEditorObject(_IRIS, "Client ID*"), clientId,
				IRIS_PageMaster.getEditorObject(_IRIS, "Client ID*").getAttachedText());
		Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_ENTERED_VAL, CoreConstants.PASS,
				IRISConstants.CLIENT_ID, clientId, tabName));
	}

	/**
	 * Select file from Query Result dialog.
	 * 
	 * @param fileId
	 * @throws Exception
	 */
	public void selectFileFromResultSet(String btnName, String fileId, String dialogName) throws Exception {
		IRIS_PageMaster.getDialogObject(_IRIS, "Query Result List").waitUntilVisible();
		Helpers.selectItemFromDialog(
				IRIS_PageMaster.getListObject(IRIS_PageMaster.getDialogObject(_IRIS, "Query Result List"), "ID"),
				IRISConstants.FILE_ID, fileId);
		Helpers.clickButton(
				IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Query Result List"),
						"Ok"),
				IRIS_PageMaster
						.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Query Result List"), "Ok")
						.getLabel());
		Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CLICKED_ON_BTN_QRYRSLT_DIALOG,
				CoreConstants.PASS, btnName, dialogName, fileId));
	}

	/**
	 * Click on execute button.
	 * 
	 * @param tabName
	 * @param moduleName
	 * @throws GeneralLeanFtException
	 */
	public void clickOnExecuteBtn(String tabName, String moduleName) throws Exception {
		Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Execute"),
				IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Execute").getLabel());
		Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CLICKED_ON_BTN_TAB, CoreConstants.PASS,
				IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Execute").getLabel(), tabName, moduleName));

	}

	/**
	 * Verify message on invalid file id search
	 * 
	 * @param message
	 * @param moduleName
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public boolean verifyMessageOnDialog(String message, String moduleName) throws Exception {
		IRIS_PageMaster.getDialogObject(_IRIS, "Info").waitUntilVisible();
		_isExists = (IRIS_PageMaster.getDialogObject(_IRIS, "Info").isVisible()
				&& BusinessFunctions.verifyMsgOnDialog(IRIS_PageMaster.getDialogObject(_IRIS, "Info"), message,
						IRIS_PageMaster.getDialogObject(_IRIS, "Info").getTitle())) ? true : false;
		if (_isExists) {
			Helpers.clickButton(
					IRIS_PageMaster.getDialogObject(_IRIS, "Info").describe(Button.class,
							new ButtonDescription.Builder().label("OK").build()),
					IRIS_PageMaster.getDialogObject(_IRIS, "Info")
							.describe(Button.class, new ButtonDescription.Builder().label("OK").build()).getLabel());
		}
		return _isExists;
	}

//	public boolean verifyAuthorizationDataOnOverviewTab(MobilityX_DashboardData authorizationData, String employeeID)
//			throws Exception {
//		return verifyTextEditorValuesOnOverviewTab(authorizationData.employeeInfo)
//				&& verifyListValuesOnOverviewTab(authorizationData.employeeInfo)
//				&& verifyOrigin_DestinationAddress(authorizationData.employeeInfo) && verifyEmployeeID(employeeID);
//	}
//
//	public boolean verifyTextEditorValuesOnOverviewTab(EmployeeInfo employeeInfo) throws Exception {
//		verifyAndClickLinkSuggestionDialog();
//		CoreFunctions.waitHandler(2);
//		_IRIS = getIRISWindow();
//		CoreFunctions.waitHandler(5);
//		String editorAttachedText[] = { "Name(f*/m/l)", "Origin Address", "Destination Address" };
//		String editorTextValue[] = { "Test Six", employeeInfo.originZip, employeeInfo.destinationZip };
//		for (int i = 0; i < editorAttachedText.length; i++) {
//			_editor = _IRIS.describe(Editor.class,
//					new EditorDescription.Builder().attachedText(editorAttachedText[i].toString()).build());
//			if (_editor.getText().equalsIgnoreCase(editorTextValue[i])) {
//				_isExists = true;
//				Reporter.addStepLog("Pass: Verified the Editor Text Value Exists on Overview Tab for <i>"
//						+ editorAttachedText[i].toString() + "</i> is : " + editorTextValue[i]);
//			}
//		}
//		return _isExists;
//	}
//
//	public boolean verifyListValuesOnOverviewTab(EmployeeInfo employeeInfo) {
//		try {
//			_IRIS = getIRISWindow();
//			CoreFunctions.waitHandler(5);
//			String listAttachedText[] = { " Type", "Policy", "Origin Address", "Destination Address" };
//			String listTextValue[] = { employeeInfo.assignmentType, employeeInfo.relocationPolicy, "NY", "PA" };
//			for (int i = 0; i < listAttachedText.length; i++) {
//				_list = _IRIS.describe(List.class,
//						new ListDescription.Builder().attachedText(listAttachedText[i].toString()).build());
//				if (_list.getVisibleText().equalsIgnoreCase(listTextValue[i])) {
//					_isExists = true;
//					Reporter.addStepLog("Pass: Verified the List Value Exists on Overview Tab for <i>"
//							+ listAttachedText[i].toString() + "</i> is : " + listTextValue[i]);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return _isExists;
//	}
//
//	public boolean verifyOrigin_DestinationAddress(EmployeeInfo employeeInfo) {
//		try {
//			_IRIS = getIRISWindow();
//			String addressAttachedText[] = { "Street1", "C*/St/Zip" };
//			String addressTextValue[] = { employeeInfo.originAddress, employeeInfo.originCity,
//					employeeInfo.destinationAddress, employeeInfo.destinationCity };
//			for (int i = 0; i <= 1; i++) {
//				for (int j = 0; j < addressAttachedText.length; j++) {
//					for (int k = 0; k < addressTextValue.length; k++) {
//						_editor = _IRIS.describe(Editor.class,
//								new EditorDescription.Builder().attachedText(addressAttachedText[j]).index(i)
//										.nativeClass("javax.swing.JTextField").build());
//						if (_editor.getText().equalsIgnoreCase(addressTextValue[k])) {
//							_isExists = true;
//							Reporter.addStepLog("Pass: Verified the Editor Text Value Exists on Overview Tab for <i>"
//									+ addressAttachedText[j].toString() + "</i> is : " + addressTextValue[k]);
//							break;
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return _isExists;
//	}

	public boolean verifyEmployeeID(String employeeID) {
		try {
			_IRIS = getIRISWindow();
			Table htmlULinkUnlinkUHtmlTable = _IRIS.describe(Table.class, new TableDescription.Builder()
					.attachedText("<html><u>Link/Unlink</u></html>").nativeClass("javax.swing.JTable").build());
			htmlULinkUnlinkUHtmlTable.waitUntilVisible();
			int rowNum = htmlULinkUnlinkUHtmlTable.getRows().size();
			for (int rowCount = 0; rowCount < rowNum; rowCount++) {
				if (htmlULinkUnlinkUHtmlTable.getCell(rowCount, "Type").getValue().toString().equals("Emp #")
						&& htmlULinkUnlinkUHtmlTable.getCell(rowCount, "Number").getValue().toString()
								.equals(employeeID)) {
					_isExists = true;
					Reporter.addStepLog(
							CoreConstants.PASS + "Verified the Employee ID id displayed as : " + employeeID);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return _isExists;
	}

	public void setFileStatus(String fileStatus) throws Exception {
		_IRIS = getIRISWindow();
		Menu optionsMenu = _IRIS.describe(Menu.class, new MenuDescription.Builder().label("Options").build());
		Menu changeStatusMenu = optionsMenu.describe(Menu.class,
				new MenuDescription.Builder().label("Change Status").build());
		Menu changeFileStatusMenu = changeStatusMenu.describe(Menu.class,
				new MenuDescription.Builder().label("Change File Status").build());
		Menu activateMenu = changeFileStatusMenu.describe(Menu.class,
				new MenuDescription.Builder().label(fileStatus).build());
		activateMenu.select();
		CoreFunctions.waitHandler(2);
		acceptFailedImageLoadDialog();
		CoreFunctions.waitHandler(2);
		Robot robot = new Robot();
		robot.setAutoDelay(250);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public void setSubServiceStatus(String fileStatus) throws Exception {
		_IRIS = getIRISWindow();
		Menu optionsMenu = _IRIS.describe(Menu.class, new MenuDescription.Builder().label("Options").build());
		Menu changeStatusMenu = optionsMenu.describe(Menu.class,
				new MenuDescription.Builder().label("Change Status").build());
		Menu changeFileStatusMenu = changeStatusMenu.describe(Menu.class,
				new MenuDescription.Builder().label("Change Sub Service Status").build());
		Menu activateMenu = changeFileStatusMenu.describe(Menu.class,
				new MenuDescription.Builder().label(fileStatus).build());
		CoreFunctions.waitHandler(2);
		activateMenu.select();
		CoreFunctions.waitHandler(2);
		Robot robot = new Robot();
		robot.setAutoDelay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void unlinkInitiation() throws Exception {
		try {
			Button _oKButtonForUnlink = _IRIS
					.describe(Dialog.class, new DialogDescription.Builder().title("Link Suggestion").build())
					.describe(Dialog.class, new DialogDescription.Builder().title("Confirm Link Files").build())
					.describe(Button.class, new ButtonDescription.Builder().label("OK").build());
			Button _thisIsADifferentPersonAndUnlinkButton = _IRIS
					.describe(Dialog.class, new DialogDescription.Builder().title("Link Suggestion").build()).describe(
							Button.class, new ButtonDescription.Builder().label("This is a different person").build());
			Helpers.clickButton(_thisIsADifferentPersonAndUnlinkButton,
					_thisIsADifferentPersonAndUnlinkButton.getLabel());
			Helpers.clickButton(_oKButtonForUnlink, _oKButtonForUnlink.getLabel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void launchCoatEstimate() throws Exception {
		try {
			_IRIS = getIRISWindow();
			Menu optionsMenu = _IRIS.describe(Menu.class, new MenuDescription.Builder().label("Options").build());
			Menu launchCostEstimatesMenu = optionsMenu.describe(Menu.class,
					new MenuDescription.Builder().label("Launch Cost Estimates").build());
			launchCostEstimatesMenu.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveAiresFileHistory() throws GeneralLeanFtException, Exception {
		Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save"),
				IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getAttachedText());
		verifySaveSucceedDialog();
		Dialog saveSucceededDialog = IRIS_PageMaster.getDialogObject(_IRIS, "Save succeeded");
		Button saveSucceedoKButton = IRIS_PageMaster.getButtonObjectFromLabel(saveSucceededDialog, "OK");
		Helpers.clickButton(saveSucceedoKButton, saveSucceedoKButton.getAttachedText());
	}

	public void saveAssignmentIdClientNameInConfigFile() {
		try {
			_IRIS = Desktop.describe(Window.class,
					new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build());
			CoreFunctions.writeToPropertiesFile("AssignID_cName_For_Expense",
					IRIS_PageMaster.getEditorObject(_IRIS, "File ID*").getText().toString() + "_"
							+ IRIS_PageMaster.getEditorObject(_IRIS, "Client Name").getText().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void acceptFailedImageLoadDialog() throws GeneralLeanFtException, Exception {
		if (CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("PreProd")
				|| CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("UAT")) {
			try {
				_isExists = (IRIS_PageMaster.getDialogObject(_IRIS, "Failed").isVisible());
				if (_isExists) {
					Helpers.clickButton(
							IRIS_PageMaster.getDialogObject(_IRIS, "Failed").describe(Button.class,
									new ButtonDescription.Builder().label("OK").build()),
							IRIS_PageMaster.getDialogObject(_IRIS, "Failed")
									.describe(Button.class, new ButtonDescription.Builder().label("OK").build())
									.getLabel());
				}
			} catch (Exception e) {
			}
		}
	}

	public void acceptLinkSuggestionDialog() {
		try {
			_isExists = (IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion").isVisible());
			if (_isExists) {
				Helpers.clickButton(
						IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion").describe(Button.class,
								new ButtonDescription.Builder().label("This is a different person").build()),
						IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion")
								.describe(Button.class,
										new ButtonDescription.Builder().label("This is a different person").build())
								.getLabel());
				Helpers.clickButton(
						IRIS_PageMaster.getDialogObject(_IRIS, "Confirm Link Files").describe(Button.class,
								new ButtonDescription.Builder().label("OK").build()),
						IRIS_PageMaster.getDialogObject(_IRIS, "Confirm Link Files")
								.describe(Button.class, new ButtonDescription.Builder().label("OK").build())
								.getLabel());
			}
		} catch (Exception e) {
		}
	}

	public void addAiresTeamDetailsOnOverviewTab(IRIS_AssignmentData overviewData) throws Exception {
//		deleteAiresFileTeamHistoryDetails(IRISConstants.FUNCTION_PPC);
//		saveAssignmentAfterFileCreation();
		addAiresFileTeamHistoryDetails(IRISConstants.FUNCTION_PPC, overviewData.airesFileTeamHistory);
		saveAssignmentAfterFileCreation();
		addAiresFileTeamHistoryDetails(IRISConstants.FUNCTION_MSPEC, overviewData.airesFileTeamHistory);
		saveAssignmentAfterFileCreation();
	}

	/**
	 * Save Assignment.
	 * 
	 * @param clickCount
	 * @throws Exception
	 */
	public void saveAssignmentAfterFileCreation() throws Exception {
		try {
			_assignmentWindow = IRIS_PageMaster.getWindowObject("File "
					+ CoreFunctions.getPropertyFromConfig("Assignment_FileID") + "  for "
					+ CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
					+ CoreFunctions.getPropertyFromConfig("Transferee_lastName") + " of "
					+ CoreFunctions.getPropertyFromConfig("Policy_ClientName") + " - Aires LLC Agreement in place.");
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save"),
					IRIS_PageMaster.getButtonObjectFromLabel(_assignmentWindow, "Save").getLabel());
			acceptAddConfirmationDialog();
			Dialog saveSucceededDialog = IRIS_PageMaster.getDialogObject(_assignmentWindow, "Save succeeded");
			saveSucceededDialog.waitUntilVisible();
			Button saveSucceedoKButton = IRIS_PageMaster.getButtonObjectFromLabel(saveSucceededDialog, "OK");
			Helpers.clickButton(saveSucceedoKButton, saveSucceedoKButton.getAttachedText());
		} catch (GeneralLeanFtException e) {
			Assert.fail(CoreConstants.FAIL + "Not Able to save the assignment");
		}
	}

	public void acceptAddConfirmationDialog() {
		try {
			_isExists = (IRIS_PageMaster.getDialogObject(_IRIS, "Add confirmation").isVisible());
			if (_isExists) {
				Helpers.clickButton(
						IRIS_PageMaster.getDialogObject(_IRIS, "Add confirmation").describe(Button.class,
								new ButtonDescription.Builder().label("Yes").build()),
						IRIS_PageMaster.getDialogObject(_IRIS, "Add confirmation")
								.describe(Button.class, new ButtonDescription.Builder().label("Yes").build())
								.getLabel());
			}
		} catch (Exception e) {
		}
	}
}