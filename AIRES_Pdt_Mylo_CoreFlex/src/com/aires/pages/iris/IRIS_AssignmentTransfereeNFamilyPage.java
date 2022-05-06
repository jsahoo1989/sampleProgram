package com.aires.pages.iris;

import java.awt.AWTException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.pages.iris.basepage.BasePage;
import com.aires.testdatatypes.iris.IRIS_AssignmentData;
import com.aires.testdatatypes.iris.IRIS_AssignmentData.BasicInformation;
import com.aires.testdatatypes.iris.IRIS_AssignmentData.MiscInformation;
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
import com.hp.lft.sdk.java.Label;
import com.hp.lft.sdk.java.LabelDescription;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.TableDescription;
import com.hp.lft.sdk.java.UiObject;
import com.hp.lft.sdk.java.UiObjectDescription;
import com.hp.lft.sdk.java.Window;
import com.hp.lft.sdk.java.WindowDescription;
import com.vimalselvam.cucumber.listener.Reporter;

public class IRIS_AssignmentTransfereeNFamilyPage extends BasePage {

	public IRIS_AssignmentTransfereeNFamilyPage() throws Exception {
		super();
	}

	private boolean _isExists = false;
	public static String _fName = null;
	public static String _lName = null;
	private static String _transfereeEmail = null;
	private static int _rowCount = 0;
	private String _newTransfereeWindowTitle = null;
	private Window _transfereeNewWindow = null;
	private String _randomString = CoreFunctions.generateRandomString(5);
	private boolean _printReportMsg = true;

	public void addTransfereeDetailsFromConfig() throws Exception {
		IRIS_PageMaster.getButtonObject(_IRIS, "Add", 1).waitUntilEnabled();
		Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Add", 1),
				IRIS_PageMaster.getButtonObject(_IRIS, "Add", 1).getAttachedText());
		if (IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name").exists()) {
			Helpers.setEditorText(
					IRIS_PageMaster.getEditorObject(IRIS_PageMaster.getDialogObject(_IRIS,
							"Please enter the new Transferee name"), "First name:"),
					CoreFunctions.getPropertyFromConfig(IRISConstants.FIRST_NAME_LINK_TEXT),
					IRIS_PageMaster.getEditorObject(
							IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name"),
							"First name:").getAttachedText());
			Helpers.setEditorText(
					IRIS_PageMaster.getEditorObject(IRIS_PageMaster.getDialogObject(_IRIS,
							"Please enter the new Transferee name"), "Last name:"),
					CoreFunctions.getPropertyFromConfig(IRISConstants.LAST_NAME_LINK_TEXT),
					IRIS_PageMaster.getEditorObject(
							IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name"),
							"Last name:").getAttachedText());
			Helpers.clickButton(
					IRIS_PageMaster.getButtonObjectFromLabel(
							IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name"), "Ok"),
					IRIS_PageMaster.getButtonObjectFromLabel(
							IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name"), "Ok")
							.getLabel());
		}
	}

	public void linkTransferee(String btnName) throws Exception {
		Table linkAssignmentDialogSimilarTransfereeTableTable = IRIS_PageMaster
				.getDialogObject(_IRIS, "Link Suggestion").describe(Table.class, new TableDescription());
		Button samePersonNewTransferOrAssignmentButton = IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion")
				.describe(Button.class,
						new ButtonDescription.Builder().label("Same person, new transfer or assignment").build());
		Button _oKButton = IRIS_PageMaster
				.getDialogObject(IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion"), "Link File")
				.describe(Button.class, new ButtonDescription.Builder().label("OK").build());
		linkAssignmentDialogSimilarTransfereeTableTable.selectRows(0);
		samePersonNewTransferOrAssignmentButton.click();
		Helpers.clickButton(_oKButton, _oKButton.getLabel());
	}

	public boolean verfiyLinkFileMessage(String msg) throws Exception {
		Button _oKButton = IRIS_PageMaster
				.getDialogObject(IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion"), "Link File")
				.describe(Button.class, new ButtonDescription.Builder().label("OK").build());
		_isExists = IRIS_PageMaster
				.getDialogObject(IRIS_PageMaster.getDialogObject(_IRIS, "Link Suggestion"), "Link File")
				.getVisibleText().contains(msg) ? true : false;
		Helpers.clickButton(_oKButton, _oKButton.getLabel());
		if (_isExists && _printReportMsg) {
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_MESSAGE_ON_UNLINK_FILE, CoreConstants.PASS, msg));
		}
		return _isExists;
	}

	public void createNewTransferee(IRIS_AssignmentData transfereeData) throws Exception {
		addTransfereeDetailsFromConfig();
		addBasicInformationDetails(transfereeData.basicInformation);
		addMiscInfoDetails(transfereeData.miscInformation);
		clickSaveButton();
	}

	/**
	 * Verify Transferee & Family tab title.
	 * 
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public boolean verifyTransfereeAndFamilyTab(String tabName) throws GeneralLeanFtException {
		try {
			_IRIS = getIRISWindow();
			_isExists = IRIS_PageMaster.getTabControlObject(_IRIS, 0).getSelectedTab().equals(tabName);
			if (_isExists)
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CURRENT_TAB, CoreConstants.PASS,
						IRIS_PageMaster.getTabControlObject(_IRIS, 0).getSelectedTab()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return _isExists;
	}

	public void addNewTransfereeDetails(IRIS_AssignmentData transfereeData) throws Exception {
		addTransfereeFirstAndLastName(transfereeData);
		Assert.assertTrue(verifyTransfereeNameAdded(), IRISConstants.TRANSFEREE_FIRST_AND_LAST_NAME_NOT_ADDED_TEXT);
		addBasicInformationDetails(transfereeData.basicInformation);
		addMiscInfoDetails(transfereeData.miscInformation);
		System.out.println(_IRIS.getTitle());
		try {
			CoreFunctions.waitHandler(5);
			clickSaveButton();
			if (IRIS_PageMaster.getDialogObject(_IRIS, "Confirmation").waitUntilExists()) {
				clickNoButton();
			}
		} catch (AWTException e) {
		}
	}

	public void addNewTransfereeDetailsForSpringboardUser(IRIS_AssignmentData transfereeData) throws Exception {
		addTransfereeFirstAndLastName(transfereeData);
		Assert.assertTrue(verifyTransfereeNameAdded(), IRISConstants.TRANSFEREE_FIRST_AND_LAST_NAME_NOT_ADDED_TEXT);
		addBasicInformationDetails(transfereeData.basicInformation);
		addMiscInfoDetails(transfereeData.miscInformation);
		CoreFunctions.waitHandler(3);
		try {
			clickSaveButton();
		} catch (AWTException e) {
		}
	}

	public void addTransfereeFirstAndLastName(IRIS_AssignmentData transfereeData) throws Exception {
		_fName = transfereeData.firstName + _randomString;
		_lName = transfereeData.lastName + _randomString;
		CoreFunctions.writeToPropertiesFile("Transferee_lastName", _lName);
		CoreFunctions.writeToPropertiesFile("Transferee_firstName", _fName);
		try {
			IRIS_PageMaster.getButtonObject(_IRIS, "Add", 1).waitUntilEnabled();
			Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Add", 1),
					IRIS_PageMaster.getButtonObject(_IRIS, "Add", 1).getAttachedText());
			if (IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name").exists()) {
				Helpers.setEditorText(IRIS_PageMaster.getEditorObject(
						IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name"), "First name:"),
						_fName,
						IRIS_PageMaster.getEditorObject(
								IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name"),
								"First name:").getAttachedText());
				Helpers.setEditorText(IRIS_PageMaster.getEditorObject(
						IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name"), "Last name:"),
						_lName,
						IRIS_PageMaster.getEditorObject(
								IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name"),
								"Last name:").getAttachedText());
				Helpers.clickButton(
						IRIS_PageMaster.getButtonObjectFromLabel(
								IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name"), "Ok"),
						IRIS_PageMaster.getButtonObjectFromLabel(
								IRIS_PageMaster.getDialogObject(_IRIS, "Please enter the new Transferee name"), "Ok")
								.getLabel());
			}
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public boolean verifyTransfereeNameAdded() throws Exception {
		try {
			IRIS_PageMaster.getEditorObject(_IRIS, "Name(f*/m/l*)").waitUntilEnabled();
			if (IRIS_PageMaster.getEditorObject(_IRIS, "Name(f*/m/l*)").getText().equalsIgnoreCase(_fName)
					&& IRIS_PageMaster.getEditorObject(_IRIS, "Basic Information").getText().equalsIgnoreCase(_lName)) {
				Reporter.addStepLog(MessageFormat.format(IRISConstants.TRANSFEREE_NAME_ADDED_TEXT, CoreConstants.PASS,
						_fName, _lName));
				_isExists = true;
			}
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
		return _isExists;
	}

	public void addBasicInformationDetails(BasicInformation basicInfo) throws Exception {
		/*
		 * _transfereeEmail = basicInfo.emailAddress +
		 * CoreFunctions.generateRandomNumberAsGivenLength(6) + "@mailinator.com";
		 */
		_transfereeEmail = "airesautomation@aires.com";
		try {
			IRIS_PageMaster.getListObject(_IRIS, "Transfer Type").waitUntilEnabled();
			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Transfer Type"), basicInfo.transferType,
					IRIS_PageMaster.getListObject(_IRIS, "Transfer Type").getAttachedText());
			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Citizenship"), basicInfo.citizenship,
					IRIS_PageMaster.getListObject(_IRIS, "Citizenship").getAttachedText());
			Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Add", 0),
					IRIS_PageMaster.getButtonObject(_IRIS, "Add", 0).getAttachedText());
			_rowCount = IRIS_PageMaster
					.getTableObject(_IRIS, "IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2")
					.getRows().size();
			Helpers.setTableCellValue(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2"),
					_rowCount - 1, "Email Address", _transfereeEmail);
			Helpers.setTableCellValue(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2"),
					_rowCount - 1, "Type", basicInfo.type);
			Helpers.setTableCellValue(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2"),
					_rowCount - 1, "Description", basicInfo.description);
			IRIS_PageMaster
					.getTableObject(_IRIS, "IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2")
					.activateRow(_rowCount - 1);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public void addBasicInformationDetailsForSpringboardUser(BasicInformation basicInfo) throws Exception {
		try {
//			IRIS_PageMaster.getListObject(_IRIS, "Transfer Type").waitUntilEnabled();
//			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Transfer Type"), basicInfo.transferType,
//					IRIS_PageMaster.getListObject(_IRIS, "Transfer Type").getAttachedText());
//			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Citizenship"), basicInfo.citizenship,
//					IRIS_PageMaster.getListObject(_IRIS, "Citizenship").getAttachedText());
			Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Add", 0),
					IRIS_PageMaster.getButtonObject(_IRIS, "Add", 0).getAttachedText());
			_rowCount = IRIS_PageMaster
					.getTableObject(_IRIS, "IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2")
					.getRows().size();
			Helpers.setTableCellValue(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2"),
					_rowCount - 1, "Email Address", basicInfo.springboardEmailAddress);
			Helpers.setTableCellValue(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2"),
					_rowCount - 1, "Type", basicInfo.type);
			Helpers.setTableCellValue(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2"),
					_rowCount - 1, "Description", basicInfo.description);
			IRIS_PageMaster
					.getTableObject(_IRIS, "IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2")
					.activateRow(_rowCount - 1);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public void addMiscInfoDetails(MiscInformation miscInfo) throws Exception {
		try {
			IRIS_PageMaster.getTabControlObject(_IRIS, 2).waitUntilEnabled();
			IRIS_PageMaster.getTabControlObject(_IRIS, 2).select("Misc. Information");
			IRIS_PageMaster.getListObject(_IRIS, "Home Stat").select(miscInfo.homeStat);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public void clickSaveButton() throws Exception {
		try {
			IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").waitUntilEnabled();
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save"), IRISConstants.SAVE_BUTTON);
		} catch (GeneralLeanFtException e) {
			Log.info(CoreConstants.FAIL);
			e.printStackTrace();
			Assert.fail("Failed to Click on 'Save' Button");
		}
	}

	public void clickOnSendLoginCridentials() throws Exception {
		try {
			Button sendLoginCredentialsButton = _IRIS.describe(Button.class,
					new ButtonDescription.Builder().label("Send Login Credentials").build());
			sendLoginCredentialsButton.click();

		} catch (GeneralLeanFtException e) {
			Log.info(CoreConstants.FAIL + e.getStackTrace());
			Assert.fail("Failed to Click on 'Save' Button");
		}
	}

	public void clickResetUsserAndPasswordButton() throws Exception {
		Dialog actionDialog = _IRIS.describe(Dialog.class, new DialogDescription.Builder().title("Action").build());
		Button sendUsernameAndResetPasswordButton = actionDialog.describe(Button.class,
				new ButtonDescription.Builder().label("Send Username and Reset Password").build());
		sendUsernameAndResetPasswordButton.click();
		_newTransfereeWindowTitle = MessageFormat.format(IRISConstants.TRANSFEREE_TITLE_SERVICE_CLIENT_92265,
				CoreFunctions.getPropertyFromConfig("Assignment_FileID"),
				CoreFunctions.getPropertyFromConfig("FirstName"), CoreFunctions.getPropertyFromConfig("LastName"));
		Editor htmlBMobilityXUsername = Desktop
				.describe(Window.class,
						new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build())
				.describe(Editor.class,
						new EditorDescription.Builder().attachedText("<html><b>MobilityX Username</b></html>").build());
		CoreFunctions.writeToPropertiesFile("Transferee_UserNameInEMail", htmlBMobilityXUsername.getText());
	}

	public void clickNoButton() throws AWTException {
		try {
			Button _noButton = _IRIS
					.describe(Dialog.class, new DialogDescription.Builder().title("Confirmation").build())
					.describe(Button.class, new ButtonDescription.Builder().label("No").build());
			_noButton.waitUntilEnabled();
			Helpers.clickButton(_noButton, _noButton.getLabel());
		} catch (GeneralLeanFtException e) {
			Log.info(CoreConstants.FAIL + e.getStackTrace());
			Assert.fail("Failed to Click on 'No' Button");
		}
	}

	public void clickSaveButtons() {
		try {

			System.out.println("window title=" + getWindowText.getActiveWindowText());
			Button saveButtonTransferee = Desktop
					.describe(Window.class,
							new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build())
					.describe(Button.class, new ButtonDescription.Builder().label("Save").build());
			// Button _saveButton = _IRIS.describe(Button.class, new
			// ButtonDescription.Builder().label("Save").build());
			System.out.println("label=" + saveButtonTransferee.getLabel());
			System.out.println("title" + saveButtonTransferee.getDisplayName());
			System.out.println("Des" + saveButtonTransferee.getDescription());
			System.out.println("Obj" + saveButtonTransferee.getObjectName());
			saveButtonTransferee.waitUntilEnabled();
			Helpers.clickButton(saveButtonTransferee, saveButtonTransferee.getLabel());
		} catch (GeneralLeanFtException e) {
			Log.info(CoreConstants.FAIL + e.getStackTrace());
			Assert.fail("Failed to Click on 'Save' Button");
		}
	}

	public boolean saveTransferee(String savedMessageText) throws Exception {
		try {
			_newTransfereeWindowTitle = MessageFormat.format(IRISConstants.CLIENT_SEPECIFIC_TRANSFEREE_TITLE,
					CoreFunctions.getPropertyFromConfig("Assignment_FileID"), _fName, _lName,
					CoreFunctions.getPropertyFromConfig("Assignment_ClientName"));

			Log.info("New Transferee Window Title : " + _newTransfereeWindowTitle);
			_IRIS = IRIS_PageMaster.getWindowObject(_newTransfereeWindowTitle);
			Dialog saveSucceededDialog =  IRIS_PageMaster.getDialogObject(_IRIS, "Saved");
			saveSucceededDialog.waitUntilVisible();
			Button saveSucceedoKButton = saveSucceededDialog.describe(Button.class,
					new ButtonDescription.Builder().label("OK").build());
			Helpers.clickButton(saveSucceedoKButton, saveSucceedoKButton.getLabel());

			_isExists = true;
			Reporter.addStepLog(CoreConstants.PASS + CoreConstants.VRFIED_THAT + CoreConstants.SUCCESS_MESSAGE_TEXT
					+ CoreConstants.IS_DISPLAYED_AS + savedMessageText);

			Editor htmlBMobilityXUsernameBHtmlEditor = Desktop
					.describe(Window.class, new WindowDescription.Builder().title(_newTransfereeWindowTitle).build())
					.describe(Editor.class, new EditorDescription.Builder()
							.attachedText("<html><b>MobilityX Username</b></html>").build());
			if (htmlBMobilityXUsernameBHtmlEditor.getText().equalsIgnoreCase(""))
				Log.info("Blank value under MobilityX UserName Field as it is an 'Impersonate User'");
			else
				CoreFunctions.writeToPropertiesFile("Transferee_UserNameInEMail",
						htmlBMobilityXUsernameBHtmlEditor.getText());

		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
			Assert.fail(CoreConstants.FAIL + "Failure in SaveTransferee Method");
		}
		return _isExists;
	}

	public boolean saveTransfereeForPartnerAllocation(String savedMessageText) {
		try {
			_newTransfereeWindowTitle = MessageFormat.format(IRISConstants.TRANSFEREE_TITLE,
					CoreFunctions.getPropertyFromConfig("Assignment_FileID"), _fName, _lName);
			String title = _newTransfereeWindowTitle + "'" + IRISConstants.TRANSFEREE_POLICY;
			CoreFunctions.writeToPropertiesFile("Transferee_title", title);
			System.out.println("New Transferee Window Title : " + title);
			_transfereeNewWindow = Desktop.describe(Window.class, new WindowDescription.Builder().title(title).build());
			Dialog saveSucceededDialog = _transfereeNewWindow.describe(Dialog.class,
					new DialogDescription.Builder().title("Saved").build());
			Button saveSucceedoKButton = saveSucceededDialog.describe(Button.class,
					new ButtonDescription.Builder().label("OK").build());
			UiObject jOptionPaneUiObject = saveSucceededDialog.describe(UiObject.class,
					new UiObjectDescription.Builder().attachedText("Transferee and family have been saved!")
							.nativeClass("javax.swing.JOptionPane").build());
			if (jOptionPaneUiObject.getText().equalsIgnoreCase(savedMessageText)) {
				_isExists = true;
				Reporter.addStepLog(CoreConstants.PASS + CoreConstants.VRFIED_THAT + CoreConstants.SUCCESS_MESSAGE_TEXT
						+ CoreConstants.IS_DISPLAYED_AS + savedMessageText);
				Helpers.clickButton(saveSucceedoKButton, saveSucceedoKButton.getAttachedText());
			}
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
		return _isExists;
	}

	/**
	 * Verify email address exists in Basic information section.
	 * 
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public boolean verifyEmailAddressInBasicInfoSection(String emailAddress) throws Exception {
		if (IRIS_PageMaster
				.getTableObject(_IRIS, "IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2")
				.getCell(0, "Email Address").getValue().toString().equals(emailAddress)) {
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_EMAIL_ADDRESS_EXIST, CoreConstants.PASS,
					IRIS_PageMaster
							.getTableObject(_IRIS,
									"IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2")
							.getCell(0, "Email Address").getValue().toString()));
			_isExists = true;
		}
		return _isExists;
	}

	/**
	 * Verify Editor value on Transferee tab.
	 * 
	 * @param editorMap
	 * @param tabName
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, Boolean> verifyTextEditorValuesOnTransfereeTab(HashMap<String, String> editorMap,
			String tabName) throws Exception {
		HashMap<String, Boolean> editorResultMap = new HashMap<String, Boolean>();
		for (@SuppressWarnings("rawtypes")
		Map.Entry m : editorMap.entrySet()) {
			_isExists = BusinessFunctions.verifyTextEditorValueInIris(getElementByName(m.getKey().toString()),
					m.getKey().toString(), m.getValue().toString(), tabName);
			editorResultMap.put(m.getKey().toString(), _isExists);
		}
		return editorResultMap;
	}

	public void sendLoginCredentials(String tabName) throws Exception {
		IRIS_PageMaster.getButtonObject(_IRIS, "Send Login Credentials").waitUntilEnabled();
		Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Send Login Credentials"),
				IRIS_PageMaster.getButtonObject(_IRIS, "Send Login Credentials").getLabel());
		Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CLICKED_ON_BTN_TAB, CoreConstants.PASS,
				IRIS_PageMaster.getButtonObject(_IRIS, "Send Login Credentials").getLabel(), tabName,
				IRISConstants.ASSIGNMENT_TAB));
	}

	public boolean verifySendCredentialsMsg(String btnName, String dialogName, String message) throws Exception {
		if (BusinessFunctions.verifyMsgOnDialog(IRIS_PageMaster.getDialogObject(_IRIS, "Warning!"),
				message.substring(0, message.indexOf(".")), dialogName)) {
			Helpers.clickButton(
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Warning!"), "Yes"),
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Warning!"), "Yes")
							.getLabel());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CLICKED_ON_BUTTON, CoreConstants.PASS,
					btnName, dialogName));
			_isExists = true;
		}
		return _isExists;
	}

	public boolean verifyResetUserNamePwdMsg(String message) throws Exception {
		Label youAreAboutToEmailTheTransfereeHisHerUsernameStLabel = _IRIS.describe(Label.class,
				new LabelDescription.Builder().label("You are about to email the transferee his/her username.")
						.build());
		if (youAreAboutToEmailTheTransfereeHisHerUsernameStLabel.getText()
				.contains(message.substring(0, message.indexOf(".")))) {
			Dialog actionDialog = _IRIS.describe(Dialog.class, new DialogDescription.Builder().title("Action").build());
			Button sendUsernameAndResetPasswordButton = actionDialog.describe(Button.class,
					new ButtonDescription.Builder().label("Send Username and Reset Password").build());
			sendUsernameAndResetPasswordButton.click();
			_isExists = true;
		}
		return _isExists;
	}

//	public boolean verifyAuthorizationValuesOnTransfereeNFamilyTab(MobilityX_DashboardData authorizationData,
//			String firstName, String lastName, String employeeID) throws Exception {
//		_IRIS = getIRISWindow();
//		String editorAttachedText[] = { "Name(f*/m/l*)", "Basic Information", "Grade", "Employee ID:" };
//		String editorTextValue[] = { firstName, lastName, authorizationData.empIdentificationInfo.gradeLevel,
//				employeeID };
//		for (int i = 0; i < editorAttachedText.length; i++) {
//			_editor = _IRIS.describe(Editor.class,
//					new EditorDescription.Builder().attachedText(editorAttachedText[i].toString()).build());
//			if (_editor.getText().equalsIgnoreCase(editorTextValue[i])) {
//				_isExists = true;
//				Reporter.addStepLog("Pass: Verified the Editor Text Value Exists on Transferee and Family Tab for <i>"
//						+ editorAttachedText[i].toString() + "</i> is : " + editorTextValue[i]);
//			}
//		}
//		return _isExists;
//	}

//	public boolean verifyEmailIDAndType(EmployeeInfo employeeInfo) {
//		try {
//			_IRIS = getIRISWindow();
//			Table gradeTable = _IRIS.describe(Table.class,
//					new TableDescription.Builder().attachedText("Grade")
//							.nativeClass("IRIS.Presentation.assignment.transferee.TransfereePanel$DetailPanel$2")
//							.tagName("Grade").build());
//			gradeTable.waitUntilVisible();
//			int rowNum = gradeTable.getRows().size();
//			for (int rowCount = 0; rowCount < rowNum; rowCount++) {
//				if (gradeTable.getCell(rowCount, "Email Address").getValue().toString().equals(employeeInfo.emailOne)
//						&& gradeTable.getCell(rowCount, "Type").getValue().toString().equals(employeeInfo.emailType)) {
//					_isExists = true;
//					Reporter.addStepLog(
//							CoreConstants.PASS + "Verified that the <i> Email ID and Email Type </i> is displayed as : "
//									+ employeeInfo.emailOne + employeeInfo.emailType);
//					break;
//				} else {
//					_isExists = false;
//					Reporter.addStepLog(
//							CoreConstants.FAIL + "Expected <i> Email ID and Email Type </i> : " + employeeInfo.emailOne
//									+ " " + employeeInfo.emailType + "\n Actual <i> Email ID and Email Type </i> : "
//									+ gradeTable.getCell(rowCount, "Email Address").getValue().toString() + " "
//									+ gradeTable.getCell(rowCount, "Type").getValue().toString());
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return _isExists;
//	}

	/**
	 * Return Editor object for the elementName passed as parameter.
	 * 
	 * @param elementName
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public Editor getElementByName(String elementName) throws Exception {
		Editor element = null;
		Window _IRIS = Desktop.describe(Window.class,
				new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build());
		switch (elementName) {
		case IRISConstants.FIRST_NAME:
			Editor _nameFMLEditor = IRIS_PageMaster.getEditorObject(_IRIS, "Name(f*/m/l*)");
			element = _nameFMLEditor;
			break;
		case IRISConstants.LAST_NAME:
			Editor _basicInformationLastNameEditor = IRIS_PageMaster.getEditorObject(_IRIS, "Basic Information");
			element = _basicInformationLastNameEditor;
			break;
		default:
			Assert.fail(IRISConstants.NO_ELEMENT_FOUND);
			break;
		}

		return element;
	}

	public void addIdentityChallengeInfo() throws Exception {
		IRIS_PageMaster.getTabControlObject(_IRIS, "javax.swing.JTabbedPane", 2).select("Identity Verification");

		Editor identityChallengeResponseEditor = _IRIS.describe(Editor.class,
				new EditorDescription.Builder().attachedText("Identity Challenge Response:").build());
		identityChallengeResponseEditor.setText("test");
	}

	public void addNewTransfereeDetailsWithExstingEmailID(IRIS_AssignmentData transfereeData) throws Exception {
		addTransfereeFirstAndLastName(transfereeData);
		Assert.assertTrue(verifyTransfereeNameAdded(), IRISConstants.TRANSFEREE_FIRST_AND_LAST_NAME_NOT_ADDED_TEXT);
		addBasicInformationDetails(transfereeData.basicInformation);
		addMiscInfoDetails(transfereeData.miscInformation);
		try {
			clickSaveButton();
			if (IRIS_PageMaster.getDialogObject(_IRIS, "Confirmation").waitUntilExists()) {
				clickNoButton();
			}
		} catch (AWTException e) {
		}
	}

}