package com.aires.pages.iris;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.managers.FileReaderManager;
import com.aires.managers.PageObjectManager_CoreFlex;
import com.aires.pages.iris.basepage.BasePage;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.Benefit.TracingPromptToBeSelected;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.aires.utilities.Log;
import com.aires.utilities.getWindowText;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.ButtonDescription;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.DialogDescription;
import com.hp.lft.sdk.java.Label;
import com.hp.lft.sdk.java.LabelDescription;
import com.hp.lft.sdk.java.Menu;
import com.hp.lft.sdk.java.MenuDescription;
import com.hp.lft.sdk.java.TabControl;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.TableDescription;
import com.hp.lft.sdk.java.UiObject;
import com.hp.lft.sdk.java.UiObjectDescription;
import com.hp.lft.sdk.java.Window;
import com.hp.lft.sdk.java.WindowDescription;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class IRIS_ActivityAndFinancePage extends BasePage {
	public IRIS_ActivityAndFinancePage() throws Exception {
		super();
	}

	String actDateVal = null;
	private boolean _isExists = false;
	public static PageObjectManager_CoreFlex pageObjectManager_CoreFlex;

	private Button _saveButton = IRIS_PageMaster.getDialogObject(_IRIS, "Partner Recommendation").describe(Button.class,
			new ButtonDescription.Builder().label("Save").build());

	private Button _selectPartnerButtonInPartnerReecommendation = IRIS_PageMaster
			.getDialogObject(_IRIS, "Partner Recommendation")
			.describe(Button.class, new ButtonDescription.Builder().label("Select Partner").build());

	private Table _subServiceTable = _IRIS.describe(Table.class, new TableDescription.Builder()
			.nativeClass("IRIS.Presentation.assignment.activityFinance.ParticipantPanel$1").build());

	private Button _deleteButton = _IRIS.describe(Button.class, new ButtonDescription.Builder().attachedText("Delete")
			.label("Delete").nativeClass("javax.swing.JButton").index(0).build());

	private Dialog _deleteConfirmationDialog = _IRIS.describe(Dialog.class,
			new DialogDescription.Builder().title("Delete confirmation").build());
	private Button _yesButton = _deleteConfirmationDialog.describe(Button.class,
			new ButtonDescription.Builder().label("Yes").build());

	private Dialog _deleteSucceededDialog = _IRIS.describe(Dialog.class,
			new DialogDescription.Builder().title("Delete succeeded").build());
	private Button _oKButton = _deleteSucceededDialog.describe(Button.class,
			new ButtonDescription.Builder().label("OK").build());
	private Button _addButton = _IRIS.describe(Button.class, new ButtonDescription.Builder().attachedText("Add")
			.label("Add").nativeClass("javax.swing.JButton").index(0).build());
	private Dialog partnerRecommendationDialog = _IRIS.describe(Dialog.class,
			new DialogDescription.Builder().title("Partner Recommendation").build());
	private UiObject jScrollPaneUiObject = partnerRecommendationDialog.describe(UiObject.class,
			new UiObjectDescription.Builder().index(8).nativeClass("javax.swing.JPanel").build());
	private Label _parentIQRGlobal = jScrollPaneUiObject.describe(Label.class,
			new LabelDescription.Builder().label("IOR Global Services").build());

	private static int _rowCount = 0;
	private static String _partnerID = null;
	private static int _compID = 0;

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	/**
	 * Verify dates exist for either of below tracing prompts a. Make first contact
	 * with transferee/family. b. **Perform needs assessment with transferee
	 * 
	 * @return
	 */
	public boolean verifyActDateExistsForTracingPrompt() {
		String actDateFirstContact;
		String actDatePerformNeeds;
		String msgToDisplay;
		boolean actDateStatus = false;
		try {

			actDateFirstContact = getActDateForTracingPrompt(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
					IRISConstants.ACTIVITY, IRISConstants.MAKE_FIRST_CONTACT, IRISConstants.ACTDATE);
			actDatePerformNeeds = getActDateForTracingPrompt(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
					IRISConstants.ACTIVITY, IRISConstants.PERFORM_NEEDS_ASSESSMENT_TEXT, IRISConstants.ACTDATE);
			actDateStatus = (actDateFirstContact.length() > 0 || actDatePerformNeeds.length() > 0);

			msgToDisplay = actDateFirstContact.length() > 0
					? MessageFormat.format(IRISConstants.TRANSFEREE_ACTUALIZED, CoreConstants.PASS,
							IRISConstants.MAKE_FIRST_CONTACT, actDateFirstContact)
					: actDatePerformNeeds.length() > 0
							? MessageFormat.format(IRISConstants.TRANSFEREE_ACTUALIZED, CoreConstants.PASS,
									IRISConstants.PERFORM_NEEDS_ASSESSMENT_TEXT, actDatePerformNeeds)
							: IRISConstants.ACCOUNT_NOT_ACTUALIZED;

			if ((actDateFirstContact != null && actDateFirstContact.length() > 0)
					|| (actDatePerformNeeds != null && actDatePerformNeeds.length() > 0))
				Reporter.addStepLog(msgToDisplay);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return actDateStatus;
	}

	public boolean verifyRowsInActivitySection(String service, String subServ, String activity, String updby)
			throws GeneralLeanFtException, Exception {
		String msgToDisplay;
		String serviceText = getActDateForTracingPrompt(
				IRIS_PageMaster.getTableObject(_IRIS, "IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
				IRISConstants.ACTIVITY, IRISConstants.PAYMENT_DATE, service);
		msgToDisplay = "\n" + service + ": " + serviceText;

		String subServText = getActDateForTracingPrompt(
				IRIS_PageMaster.getTableObject(_IRIS, "IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
				IRISConstants.ACTIVITY, IRISConstants.PAYMENT_DATE, subServ);
		msgToDisplay += "\n" + subServ + ": " + subServText;

		String activityText = getActDateForTracingPrompt(
				IRIS_PageMaster.getTableObject(_IRIS, "IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
				IRISConstants.ACTIVITY, IRISConstants.PAYMENT_DATE, activity);
		msgToDisplay += "\n" + activity + ": " + activityText;

		String updbyText = getActDateForTracingPrompt(
				IRIS_PageMaster.getTableObject(_IRIS, "IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
				IRISConstants.ACTIVITY, IRISConstants.PAYMENT_DATE, updby);
		msgToDisplay += "\n" + updby + ": " + updbyText;
		if (serviceText.equalsIgnoreCase(IRISConstants.SERVICE_ACT)
				&& updbyText.equalsIgnoreCase(CoreFunctions.getPropertyFromConfig(IRISConstants.UPD_BY))
				&& activityText.equalsIgnoreCase(IRISConstants.PAYMENT_DATE)) {

			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.FOLLOWING_ROWS_VERIFIED, CoreConstants.PASS, msgToDisplay));
			return true;
		}
		return false;
	}

	/**
	 * Verify dates exist for either of below tracing prompts a. Make first contact
	 * with transferee/family. b. **Perform needs assessment with transferee
	 * 
	 * @return
	 */
	public boolean verifyActDateExistsForTracingPrompt(String makeFirstContact, String performNeedAssesment) {
		String actDateFirstContact;
		String actDatePerformNeeds;
		String msgToDisplay;
		boolean actDateStatus = false;
		try {

			actDateFirstContact = getActDateForTracingPrompt(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
					IRISConstants.ACTIVITY, makeFirstContact, IRISConstants.ACTDATE);
			actDatePerformNeeds = getActDateForTracingPrompt(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
					IRISConstants.ACTIVITY, performNeedAssesment, IRISConstants.ACTDATE);
			actDateStatus = (actDateFirstContact.length() > 0 || actDatePerformNeeds.length() > 0);

			msgToDisplay = actDateFirstContact.length() > 0
					? MessageFormat.format(IRISConstants.TRANSFEREE_ACTUALIZED, CoreConstants.PASS, makeFirstContact,
							actDateFirstContact)
					: actDatePerformNeeds.length() > 0
							? MessageFormat.format(IRISConstants.TRANSFEREE_ACTUALIZED, CoreConstants.PASS,
									performNeedAssesment, actDatePerformNeeds)
							: IRISConstants.ACCOUNT_NOT_ACTUALIZED;

			if ((actDateFirstContact != null && actDateFirstContact.length() > 0)
					|| (actDatePerformNeeds != null && actDatePerformNeeds.length() > 0))
				Reporter.addStepLog(msgToDisplay);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return actDateStatus;
	}

	/**
	 * Returns actualized dates for the tracing prompt passed as parameters.
	 * 
	 * @param table
	 * @param columnName
	 * @param tracingPrompt
	 * @param actDateColumn
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public String getActDateForTracingPrompt(Table table, String columnName, String tracingPrompt, String actDateColumn)
			throws GeneralLeanFtException {
		table.waitUntilVisible();
		String actDateVal = null;
		if (table.getRows().size() > 0 & table.getColumnHeaders().contains(columnName)) {
			for (int rowCount = 0; rowCount < table.getRows().size(); rowCount++) {
				if (table.getCell(rowCount, columnName).getValue().toString().contains(tracingPrompt)) {
					actDateVal = table.getCell(rowCount, actDateColumn).getValue().toString();
					break;
				}
			}
		} else {
			Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
		}
		return actDateVal;
	}

	/**
	 * Click Display button on Activity and Finance Page.
	 * 
	 * @throws GeneralLeanFtException
	 */
	public void displayActivityTable() throws Exception {
		IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Display").waitUntilEnabled();
		Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Display"),
				IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Display").getLabel());
		Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS,
				IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Display").getLabel()));
	}

	/**
	 * Verify Activity and Finance tab
	 * 
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public boolean verifyActivityAndFinanceTab() throws Exception {
		if (IRIS_PageMaster.getTabControlObject(_IRIS, "javax.swing.JTabbedPane", 0).getSelectedTab()
				.equals(IRISConstants.ACTIVITY_AND_FINANCE))
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CURRENT_TAB, CoreConstants.PASS,
					IRIS_PageMaster.getTabControlObject(_IRIS, "javax.swing.JTabbedPane", 0).getSelectedTab()));
		return IRIS_PageMaster.getTabControlObject(_IRIS, "javax.swing.JTabbedPane", 0).getSelectedTab()
				.equals(IRISConstants.ACTIVITY_AND_FINANCE);
	}

	/**
	 * Enter Act date for tracing prompt passed as parameter.
	 * 
	 * @param table
	 * @param columnName
	 * @param tracingPrompt
	 * @param actDateColumn
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public void enterActDateForTracingPrompt(Table table, String columnName, String tracingPrompt, String actDateColumn)
			throws Exception {
		table.waitUntilVisible();
		Format f = new SimpleDateFormat("M/d/yyyy");
		actDateVal = f.format(new Date());

		if (table.getRows().size() > 0 & table.getColumnHeaders().contains(columnName)) {
			searchTracingPromptAndEnterActDate(table, columnName, tracingPrompt, actDateColumn);
		} else {
			Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
		}

	}

	/**
	 * search tracing prompt in activity table and enter act date.
	 * 
	 * @param table
	 * @param columnName
	 * @param tracingPrompt
	 * @param actDateColumn
	 * @throws GeneralLeanFtException
	 */
	public void searchTracingPromptAndEnterActDate(Table table, String columnName, String tracingPrompt,
			String actDateColumn) throws Exception {
		for (int rowCount = 0; rowCount < table.getRows().size(); rowCount++) {
			if (table.getCell(rowCount, columnName).getValue().toString().contains(tracingPrompt)) {
				table.getCell(rowCount, actDateColumn).click();
				if (IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "JDateChooserIcon").isVisible()
						&& IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "JDateChooserIcon").isEnabled()) {
					IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "JDateChooserIcon").click();
					String dayInMonth = Integer.toString(CoreFunctions.GetDayofMonthFromDate());
					Button button = IRIS_PageMaster.getButtonObject(_IRIS, dayInMonth,
							"com.aires.iris.calendar.JDayChooser$1", 0);
					Helpers.clickButton(button, button.getLabel());
					Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_ENTERED_ACT_DATE,
							CoreConstants.PASS, actDateColumn, actDateVal, tracingPrompt));
				}
				break;
			}
		}
		CoreFunctions.writeToPropertiesFile("Assignment_ActualizationDate",
				CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"));
	}

	public void clickBtnConfirmationDialog(String btnName, String dialogName) throws Exception {
		try {
			IRIS_PageMaster.getDialogObject(_IRIS, "Confirmation").waitUntilVisible();
			CoreFunctions.waitHandler(3);
			if (IRIS_PageMaster.getDialogObject(_IRIS, "Confirmation").isVisible()) {
				Helpers.clickButton(
						IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Confirmation"),
								"No"),
						IRIS_PageMaster
								.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Confirmation"), "No")
								.getLabel());
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CLICKED_ON_BUTTON, CoreConstants.PASS,
						btnName, dialogName));

			} else {
				Assert.fail(IRISConstants.CONFIRMATION_DIALOG_NOT_VISIBLE);
			}
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send credentials to the transferee and save information.
	 * 
	 * @throws Exception
	 */
	public void sendLoginCredentials(String btnName, String dialogName, String message) throws Exception {
		try {
			IRIS_PageMaster.getDialogObject(_IRIS, "Send Credentials").waitUntilVisible();
			CoreFunctions.waitHandler(3);
			if (IRIS_PageMaster.getDialogObject(_IRIS, "Send Credentials").isVisible()) {
				Helpers.clickButton(
						IRIS_PageMaster.getButtonObjectFromLabel(
								IRIS_PageMaster.getDialogObject(_IRIS, "Send Credentials"), "Yes"),
						IRIS_PageMaster.getButtonObjectFromLabel(
								IRIS_PageMaster.getDialogObject(_IRIS, "Send Credentials"), "Yes").getLabel());
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CLICKED_ON_BUTTON, CoreConstants.PASS,
						btnName, dialogName));

			} else {
				Assert.fail(IRISConstants.SEND_CREDENTIALS_DIALOG_NOT_VISIBLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Handle relonet credentials send message dialog and save successful dialog
	 * 
	 * @param message
	 * @param dialogName
	 * @throws GeneralLeanFtException
	 */
	public boolean relonetCredentialsSent(String message, String dialogName) throws Exception {
		boolean messageVerified = false;
		IRIS_PageMaster.getDialogObject(_IRIS, "Message").waitUntilVisible();
		messageVerified = BusinessFunctions.verifyMsgOnDialog(IRIS_PageMaster.getDialogObject(_IRIS, "Message"),
				message, dialogName);
		if (IRIS_PageMaster.getDialogObject(_IRIS, "Message").isVisible() && messageVerified) {
			Helpers.clickButton(
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Message"), "OK"),
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Message"), "OK")
							.getLabel());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CLICKED_ON_BUTTON, CoreConstants.PASS,
					IRISConstants.BUTTON_OK, dialogName));

			IRIS_PageMaster.getDialogObject(_IRIS, "Saved").waitUntilVisible();
			Dialog savedDialog = _IRIS.describe(Dialog.class, new DialogDescription.Builder().title("Saved").build());
			Button oKButton = savedDialog.describe(Button.class, new ButtonDescription.Builder().label("OK").build());
			oKButton.click();
			CoreFunctions.writeToPropertiesFile("irisWindowTitle", getIRISWindow().getTitle());
		} else {
			Assert.fail(IRISConstants.CREDENTIALS_NOT_SENT);
		}
		return messageVerified;
	}

	/**
	 * Accept Identity Challenge Question dialog
	 * 
	 * @param message
	 * @param dialogName
	 * @throws GeneralLeanFtException
	 */
	public void acceptIdentityChallengeQuestionDialog() {
		CoreFunctions.waitHandler(3);
		try {
			if (IRIS_PageMaster.getDialogObject(_IRIS, "Identity Challenge Question").isVisible()) {
				Helpers.clickButton(
						IRIS_PageMaster.getButtonObjectFromLabel(
								IRIS_PageMaster.getDialogObject(_IRIS, "Identity Challenge Question"), "Yes"),
						IRIS_PageMaster
								.getButtonObjectFromLabel(
										IRIS_PageMaster.getDialogObject(_IRIS, "Identity Challenge Question"), "Yes")
								.getLabel());
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_DIALOG_ACCEPTED, CoreConstants.PASS,
						IRISConstants.BUTTON_YES));
			}
		} catch (Exception e) {

		}
	}

	public boolean relonetCredentialsSentForNewTransferee(String message, String dialogName) throws Exception {
		Dialog confirmationDialog = _IRIS.describe(Dialog.class,
				new DialogDescription.Builder().title("Confirmation").build());
		Button yesButton = confirmationDialog.describe(Button.class,
				new ButtonDescription.Builder().label("Yes").build());
		yesButton.click();
		boolean messageVerified = false;
		IRIS_PageMaster.getDialogObject(_IRIS, "Saved").waitUntilVisible();
		if (IRIS_PageMaster.getDialogObject(_IRIS, "Saved").isVisible()
				&& BusinessFunctions.verifyMsgOnDialog(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"),
						IRISConstants.SAVE_SUCCESSFUL_MESSAGE, IRISConstants.SAVED_TEXT)) {
			Dialog savedDialog = _IRIS.describe(Dialog.class, new DialogDescription.Builder().title("Saved").build());
			Button oKButton = savedDialog.describe(Button.class, new ButtonDescription.Builder().label("OK").build());
			oKButton.click();
			messageVerified = true;
		} else {
			Assert.fail(IRISConstants.CREDENTIALS_NOT_SENT);
		}
		return messageVerified;
	}

	/**
	 * Actualize Transferee.
	 */
	public void actualizeTracingPrompt(String actDate, String activity, String tracingPromptName) {
		try {
			enterActDateForTracingPrompt(
					IRIS_PageMaster.getTableObject(_IRIS,
							"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
					activity, tracingPromptName, actDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Click on Save Button
	 * 
	 * @throws GeneralLeanFtException
	 */
	public void clickOnSaveBtn() throws Exception {
		IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").waitUntilEnabled();
		Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save"),
				IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getLabel());
		Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS,
				IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getLabel()));
	}

	public void selectServiceAndSubService(DataTable table) {
		try {
			java.util.List<java.util.List<String>> data = table.raw();
			String subServiceText = "#" + CoreFunctions.getPropertyFromConfig("Assignment_subServiceID") + " - "
					+ data.get(1).get(1);
			System.out.println("SubService Selection Text : " + subServiceText);
			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Service"), data.get(1).get(0),
					IRIS_PageMaster.getListObject(_IRIS, "Service").getAttachedText());
			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Sub-Service"), subServiceText,
					IRIS_PageMaster.getListObject(_IRIS, "Sub-Service").getAttachedText());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_SERVICE_SELECTED, CoreConstants.PASS,
					data.get(1).get(0), data.get(1).get(1)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickSelectPartnetBtn(String btnName) {
		try {
			IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Select Partner").waitUntilEnabled();
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Select Partner"), btnName);
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS, btnName));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectPartnerClientAgent(String partnerName) throws Exception {
		Helpers.selectFromList(
				IRIS_PageMaster.getListObject(IRIS_PageMaster.getDialogObject(_IRIS, "Partner Recommendation"),
						"Select a participant, then select a partner"),
				partnerName,
				IRIS_PageMaster.getListObject(IRIS_PageMaster.getDialogObject(_IRIS, "Partner Recommendation"),
						"Select a participant, then select a partner").getDisplayName());
		Helpers.selectTableRow(IRIS_PageMaster.getDialogObject(_IRIS, "Partner Recommendation").describe(Table.class,
				new TableDescription()), 1);
		Reporter.addStepLog(
				MessageFormat.format(IRISConstants.VERIFIED_PARTNER_SELECTED, CoreConstants.PASS, partnerName));
	}

	public void clickSaveBtnInPartnerRecommendationBox(String btnName) {
		try {
			_saveButton.waitUntilEnabled();
			Helpers.clickButton(_saveButton, btnName);
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS, btnName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifySaveSuccessMsgInPartnerRecommendationDialog(String message) throws GeneralLeanFtException {
		Window AutoAiresAIRESCWindow = Desktop.describe(Window.class,
				new WindowDescription.Builder().title(CoreFunctions.getPropertyFromConfig("ServiceTitle")).build());
		Dialog partnerRecommendationDialog = AutoAiresAIRESCWindow.describe(Dialog.class,
				new DialogDescription.Builder().title("Partner Recommendation").build());
		Dialog savedDialog = partnerRecommendationDialog.describe(Dialog.class,
				new DialogDescription.Builder().title("Saved").build());
		Button oKButton = savedDialog.describe(Button.class, new ButtonDescription.Builder().label("OK").build());
		if (savedDialog.getVisibleText().contains(message)) {
			_isExists = true;
			Helpers.clickButton(oKButton, oKButton.getLabel());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFY_MESSAGE_DISPLAYED_ON_SERVICE_TAB,
					CoreConstants.PASS, message));
		}
		return _isExists;
	}

	public void clickSelectPartnetBtnInPartnerRecommendationDialog(String btnName) {
		try {
			_selectPartnerButtonInPartnerReecommendation.waitUntilEnabled();
			Helpers.clickButton(_selectPartnerButtonInPartnerReecommendation, btnName);
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS, btnName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyPartnerUnderSelectList(String partnerName) {
		try {
			if (_parentIQRGlobal.getText().contains(partnerName)) {
				_isExists = true;
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_PARTNER_DISPLAYED, CoreConstants.PASS,
						partnerName));
			}
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
		return _isExists;
	}

	public void deletePartnetFromParticipant() {
		try {
			Helpers.selectTableRow(_subServiceTable, 2);
			Helpers.clickButton(_deleteButton, _deleteButton.getDisplayName());
			Helpers.clickButton(_yesButton, _yesButton.getDisplayName());
			Helpers.clickButton(_oKButton, _oKButton.getDisplayName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getParticipantsTableRowCount() throws Exception {
		return Helpers.getTableRowCount(_subServiceTable);
	}

	public boolean verifyNewTableRowAdded(int initialRowCount) throws Exception {
		return Helpers.getTableRowCount(_subServiceTable) > initialRowCount;
	}

	public void clickAddButton() throws GeneralLeanFtException {
		_addButton.waitUntilEnabled();
		Helpers.clickButton(_addButton, _addButton.getLabel());
		Reporter.addStepLog(
				MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS, _addButton.getLabel()));
	}

	public int addPartner(DataTable subServiceData) {
		try {
			java.util.List<java.util.List<String>> data = subServiceData.raw();
			_subServiceTable.waitUntilVisible();
			_rowCount = Helpers.getTableRowCount(_subServiceTable);
			_subServiceTable.getCell(_rowCount - 1, data.get(0).get(0).toString())
					.setValue(data.get(1).get(0).toString());
			_subServiceTable.getCell(_rowCount - 1, data.get(0).get(1).toString())
					.setValue(data.get(1).get(1).toString());
			if (_subServiceTable.getCell(_rowCount - 1, data.get(0).get(2).toString()).getValue()
					.equals(data.get(1).get(2).toString()))
				Reporter.addStepLog(CoreConstants.PASS + CoreConstants.VRFIED_THAT
						+ MessageFormat.format(IRISConstants.COMPANY_NAME_DISPLAYED_FOR_COMP_ID,
								data.get(1).get(1).toString(), data.get(1).get(2).toString()));
			else
				Reporter.addStepLog(CoreConstants.FAIL + MessageFormat
						.format(IRISConstants.COMPANY_NAME_NOT_DISPLAYED_FOR_COMP_ID, data.get(1).get(1).toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return _rowCount;
	}

	public boolean verifyPartnerAddedUnderParticipantsTable(int initialParticipantsTableRowCount,
			DataTable participantsTable) {
		try {
			java.util.List<java.util.List<String>> data = participantsTable.raw();
			_subServiceTable.waitUntilVisible();
			_rowCount = Helpers.getTableRowCount(_subServiceTable);
			int partnerNum;
			for (int rowNum = 0; rowNum < _rowCount; rowNum++) {
				_compID = (int) Math.round(
						Double.parseDouble(_subServiceTable.getCell(rowNum, data.get(0).get(0)).getValue().toString()));
				if (_rowCount > initialParticipantsTableRowCount
						&& _compID == Integer.parseInt(data.get(1).get(0).toString()) && _subServiceTable
								.getCell(rowNum, data.get(0).get(1)).getValue().toString().equals(data.get(1).get(1))) {
					_isExists = true;
					partnerNum = (int) Math
							.round(Double.parseDouble(_subServiceTable.getCell(rowNum, "Part").getValue().toString()));
					_partnerID = Integer.toString(partnerNum);
					CoreFunctions.writeToPropertiesFile("Partner_ID", _partnerID);
					Reporter.addStepLog(CoreConstants.PASS + CoreConstants.VRFIED_THAT
							+ IRISConstants.VERIFY_PARTNER_SUCCESSFULLY_ADDED + _partnerID);
					break;
				}
			}
		} catch (Exception e) {
			Log.info("Fail :" + e.getStackTrace());
		}
		return _isExists;
	}

	public void addNewShipment() throws Exception {

		Thread.sleep(6000);

		System.out.println("1 shipment window is: " + getWindowText.getActiveWindowText());
		String fileId = getWindowText.getActiveWindowText().substring(11, 17);
		String firstName = IRIS_AssignmentTransfereeNFamilyPage._fName;
		String LastName = IRIS_AssignmentTransfereeNFamilyPage._lName;

		System.out.println("id is " + fileId);
		System.out.println("first name is: " + firstName);
		System.out.println("1last name is: " + LastName);

		Window file12C549830ForAutoAireskdvtofTestAireskdvtofOfAIRESCWindow = Desktop.describe(Window.class,
				new WindowDescription.Builder()
						.title("File - 12C " + fileId + "  for " + firstName + " " + LastName
								+ " of AIRES-CIS-DEMO&'TEST(CLIENT) - Aires India Branch Office Agreement in place.")
						.build());
		Menu shipmentMenu = file12C549830ForAutoAireskdvtofTestAireskdvtofOfAIRESCWindow.describe(Menu.class,
				new MenuDescription.Builder().label("Shipment").nativeClass("javax.swing.JMenu").build());
		Menu newMenu = shipmentMenu.describe(Menu.class, new MenuDescription.Builder().label("New").build());
		newMenu.select();

		Thread.sleep(2000);

		System.out.println("1 shipment window is: " + getWindowText.getActiveWindowText());

		while (!getWindowText.getActiveWindowText().contains("Sub-Service ID:")) {
			CoreFunctions.waitHandler(10);
			System.out.println("Shipment window is: " + getWindowText.getActiveWindowText());

			_IRIS = getIRISWindow();
		}
	}

	public void clickOKUsingRobot() throws AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void verifySaveSuccessfulMsg() throws GeneralLeanFtException, Exception {
		if (IRIS_PageMaster.getDialogObject(_IRIS, "Saved").isVisible())
//				&& BusinessFunctions.verifyMsgOnDialog(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"),
//						IRISConstants.MESSAGE_SAVESUCCESSFULL, IRISConstants.SAVED_TEXT)) 
		{
			Dialog actFinanceSavedDialog = IRIS_PageMaster.getDialogObject(_IRIS, "Saved");
			Helpers.clickButton(
					IRIS_PageMaster.getButtonObject(actFinanceSavedDialog, "OK",
							"javax.swing.plaf.basic.BasicOptionPaneUI$ButtonFactory$ConstrainedButton"),
					IRIS_PageMaster
							.getButtonObject(actFinanceSavedDialog, "OK",
									"javax.swing.plaf.basic.BasicOptionPaneUI$ButtonFactory$ConstrainedButton")
							.getLabel());
		} else {
			Assert.fail("Failed to verify save successful message.");
		}
	}

	public int addParticipant(DataTable subServiceData) {
		try {
			java.util.List<java.util.List<String>> data = subServiceData.raw();
			_subServiceTable.waitUntilVisible();
			_rowCount = Helpers.getTableRowCount(_subServiceTable);
			_subServiceTable.getCell(_rowCount - 1, data.get(0).get(2).toString())
					.setValue(data.get(1).get(2).toString());
			_subServiceTable.getCell(_rowCount - 1, data.get(0).get(3).toString())
					.setValue(data.get(1).get(3).toString());
			if (_subServiceTable.getCell(_rowCount - 1, data.get(0).get(4).toString()).getValue()
					.equals(data.get(1).get(4).toString()))
				Reporter.addStepLog(CoreConstants.PASS + CoreConstants.VRFIED_THAT
						+ MessageFormat.format(IRISConstants.COMPANY_NAME_DISPLAYED_FOR_COMP_ID,
								data.get(1).get(3).toString(), data.get(1).get(4).toString()));
			else
				Reporter.addStepLog(CoreConstants.FAIL + MessageFormat
						.format(IRISConstants.COMPANY_NAME_NOT_DISPLAYED_FOR_COMP_ID, data.get(1).get(3).toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return _rowCount;
	}

	public void selectServiceAndSubService(Benefit benefit) {
		String subServiceText = null;
		try {
			subServiceText = "#" + IRIS_AssignmentServicePage.subServiceIDMap.get(benefit.getIrisSubserviceName())
					+ " - " + benefit.getSubServiceActivityFinance();
			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Service"), benefit.getIrisServiceName(),
					IRIS_PageMaster.getListObject(_IRIS, "Service").getAttachedText());
			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Sub-Service"), subServiceText,
					IRIS_PageMaster.getListObject(_IRIS, "Sub-Service").getAttachedText());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_SERVICE_SUBSERVICE_SELECTED,
					CoreConstants.PASS, benefit.getIrisServiceName(), subServiceText));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addParticipant(Benefit benefit) {
		try {
			_subServiceTable.waitUntilVisible();
			_rowCount = Helpers.getTableRowCount(_subServiceTable);
			_subServiceTable.getCell(_rowCount - 1, "Function").setValue(benefit.getSubServiceFunction());
			_subServiceTable.getCell(_rowCount - 1, "Sub Serv")
					.setValue(IRIS_AssignmentServicePage.subServiceIDMap.get(benefit.getIrisSubserviceName()));
			_subServiceTable.getCell(_rowCount - 1, "Comp ID").setValue(benefit.getCompID());
			if (_subServiceTable.getCell(_rowCount - 1, IRISConstants.COMPANY).getValue().equals(benefit.getCompany()))
				Reporter.addStepLog(CoreConstants.PASS + CoreConstants.VRFIED_THAT + MessageFormat.format(
						IRISConstants.COMPANY_NAME_DISPLAYED_FOR_COMP_ID, benefit.getCompID(), benefit.getCompany()));
			else
				Reporter.addStepLog(CoreConstants.FAIL + MessageFormat
						.format(IRISConstants.COMPANY_NAME_NOT_DISPLAYED_FOR_COMP_ID, benefit.getCompID()));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_ADDING_PARTICIPANT_ON_ACTIVITY_AND_FINANCE_TAB_OF_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	public void selectServiceAndAddParticipant() {
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))) {
						selectServiceToAddParticipant(benefit);
						displayActivityTable();
						clickAddButton();
						addParticipant(benefit);
						clickOnSaveBtn();
						verifySaveSuccessfulMsg();
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_ADDING_SERVICE_SUBSERVICE_ON_SERVICES_TAB_OF_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	private void selectServiceToAddParticipant(Benefit benefit) {
		String subServiceText = null;
		try {
			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Service"), benefit.getIrisServiceName(),
					IRIS_PageMaster.getListObject(_IRIS, "Service").getAttachedText());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_SERVICE_SELECTED, CoreConstants.PASS,
					benefit.getIrisServiceName(), subServiceText));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Actualize Services Initial Tracing Prompts.
	 */
	public void actualizeInitialTracingPrompt(String estDate, String activity) {
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))) {
						selectServiceAndSubService(benefit);
						displayActivityTable();
						enterActDateForTracingPrompt(
								IRIS_PageMaster.getTableObject(_IRIS,
										"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
								activity, benefit.getInitialTracingPrompt(), estDate);
						clickOnSaveBtn();
						verifySaveSuccessfulMsg();
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_ACTUALIZING_ADDED_SERVICES_TRACING_PROMPT_ON_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Actualize Services Initial Tracing Prompts.
	 */
	public void actualizeInitialTracingPromptForAiresManagedBenefits(String estDate, String activity,
			int noOfMilestones) {
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))
							&& benefit.getNoOfMilestones() != null && benefit.getNoOfMilestones() == noOfMilestones) {
						if (benefit.getIrisServiceName().equals("Shipment"))
							actualizeInitialTracingPromptForShipmentService(_IRIS, activity, benefit);
						else {
							selectServiceAndSubService(benefit);
							displayActivityTable();
							if (noOfMilestones == 2) {
								if (benefit.getSubServiceFunction() != null
										&& !benefit.getSubServiceFunction().equals("NA")) {
									clickAddButton();
									addParticipant(benefit);
									clickOnSaveBtn();
									verifySaveSuccessfulMsg();
								}
								enterActDateForTracingPrompt(
										IRIS_PageMaster.getTableObject(_IRIS,
												"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
										activity, benefit.getInitialTracingPrompt(), IRISConstants.EST_DATE);
							}
							if (noOfMilestones == 4) {
								enterActDateForTracingPrompt(
										IRIS_PageMaster.getTableObject(_IRIS,
												"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
										activity, IRISConstants.PERFORM_NEEDS_ASSESSMENT_TEXT, estDate);
							}
						}
						clickOnSaveBtn();
						verifySaveSuccessfulMsg();
					}
				}
			}
			CoreFunctions.writeToPropertiesFile("irisWindowTitle", getIRISWindow().getTitle());
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_ACTUALIZING_ADDED_SERVICES_TRACING_PROMPT_ON_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	private void actualizeInitialTracingPromptForShipmentService(Window _IRIS, String activity, Benefit benefit)
			throws Exception {
		Helpers.selectTabControl(IRIS_PageMaster.getTabControlObject(_IRIS, 0), IRISConstants.SERVICE_TAB);

		int rowId = Helpers.getRowIdMatchingCellValue(
				IRIS_PageMaster.getTableObject(_IRIS,
						"IRIS.Presentation.assignment.reloService.ReloServicePanel$RelocationServicePanel$1"),
				"Name", benefit.getIrisServiceName());

		Helpers.selectTableRow(IRIS_PageMaster.getTableObject(_IRIS,
				"IRIS.Presentation.assignment.reloService.ReloServicePanel$RelocationServicePanel$1"), rowId);

		Log.info(IRIS_AssignmentServicePage.subServiceIDMap.get(benefit.getIrisSubserviceName()));

		rowId = Helpers.getRowIdMatchingCellValue(
				IRIS_PageMaster.getTableObjectWithIndex(_IRIS, "javax.swing.JTable", 1), "ID",
				IRIS_AssignmentServicePage.subServiceIDMap.get(benefit.getIrisSubserviceName()));

		Helpers.selectTableRow(IRIS_PageMaster.getTableObjectWithIndex(_IRIS, "javax.swing.JTable", 1), rowId);
		IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Detail").click();

		String subServiceWindowTitle = MessageFormat.format(IRISConstants.SUB_SERVICE_TITLE_WITH_ID,
				IRIS_AssignmentServicePage.subServiceIDMap.get(benefit.getIrisSubserviceName()),
				CoreFunctions.getPropertyFromConfig("Assignment_FileID"),
				CoreFunctions.getPropertyFromConfig("Transferee_firstName"),
				CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
				CoreFunctions.getPropertyFromConfig("Assignment_ClientName"),
				CoreFunctions.getPropertyFromConfig("Assignment_ClientID"));

		Log.info(subServiceWindowTitle);

		_IRIS = IRIS_PageMaster.getWindowObject(subServiceWindowTitle);

		_IRIS.waitUntilVisible();

		TabControl tabControl = IRIS_PageMaster.getTabControlObject(_IRIS, "javax.swing.JTabbedPane", 0);
		Helpers.selectTabControl(tabControl, "Activity & Finance");

		Table activityFinanceTable = IRIS_PageMaster.getTableObject(_IRIS,
				"com.aires.iris.shipment.activityfinance.ActivityFinancePanel$3");

		pageObjectManager_CoreFlex.getPageObjects().get(benefit.getBenefitType()).actualizeSubServiceTracingPrompt(
				_IRIS, activityFinanceTable, benefit.getPartnerForInitialTracingPrompt(),
				benefit.getInitialTracingPrompt());
		_IRIS.close();
	}

	public void displayAllActivityTable() {
		try {
			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Service"), IRISConstants.ALL,
					IRIS_PageMaster.getListObject(_IRIS, "Service").getAttachedText());
			IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Display").waitUntilEnabled();
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Display"),
					IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Display").getLabel());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS,
					IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Display").getLabel()));

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_DISPLAYING_ALL_ACTIVITY_TABLE_OF_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Actualize Services End Tracing Prompts.
	 */
	public void actualizeEndTracingPrompt(String tracingDate, String activity) {
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))) {
						selectServiceAndSubService(benefit);
						displayActivityTable();
						enterActDateForTracingPrompt(
								IRIS_PageMaster.getTableObject(_IRIS,
										"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
								activity, benefit.getEndTracingPrompt(), tracingDate);
						clickOnSaveBtn();
						verifySaveSuccessfulMsg();
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_ACTUALIZING_ADDED_SERVICES_TRACING_PROMPT_ON_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Actualize Services End Tracing Prompts.
	 */
	public void actualizeAllTracingPromptsOfAiresMangedBenefits(String tracingDate, String activity,
			int noOfMilestones) {
		try {
			if (noOfMilestones == 4)
				provideEstimatedDatesForAllTracingPrompts(noOfMilestones);

			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getSelectBenefitOnFPTPage()) && benefit.getAiresManagedService().equals("Yes")
							&& benefit.getNoOfMilestones() != null && benefit.getNoOfMilestones() == noOfMilestones) {
						if (benefit.getIrisServiceName().equals("Shipment")) {
							actualizeAllTracingPromptForShipmentService(_IRIS, activity, benefit);
						} else {
							selectServiceAndSubService(benefit);
							displayActivityTable();
							if (noOfMilestones == 2) {
								enterActDateForTracingPrompt(
										IRIS_PageMaster.getTableObject(_IRIS,
												"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
										activity, benefit.getEndTracingPrompt(), tracingDate);
							}
							if (noOfMilestones == 4) {
								for (int i = 0; i < noOfMilestones; i++) {
									String activityName = benefit.getAllMilestones().split(",")[i].trim();
									enterActDateForTracingPrompt(
											IRIS_PageMaster.getTableObject(_IRIS,
													"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
											activity, activityName, tracingDate);
								}
							}
						}
						clickOnSaveBtn();
						verifySaveSuccessfulMsg();
						handleInactivateSubServiceError();
					}
				}
			}
			CoreFunctions.writeToPropertiesFile("irisWindowTitle", getIRISWindow().getTitle());
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_ACTUALIZING_ADDED_SERVICES_TRACING_PROMPT_ON_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	private void actualizeAllTracingPromptForShipmentService(Window _IRIS, String activity, Benefit benefit)
			throws GeneralLeanFtException, Exception {
		Helpers.selectTabControl(IRIS_PageMaster.getTabControlObject(_IRIS, 0), IRISConstants.SERVICE_TAB);

		int rowId = Helpers.getRowIdMatchingCellValue(
				IRIS_PageMaster.getTableObject(_IRIS,
						"IRIS.Presentation.assignment.reloService.ReloServicePanel$RelocationServicePanel$1"),
				"Name", benefit.getIrisServiceName());

		Helpers.selectTableRow(IRIS_PageMaster.getTableObject(_IRIS,
				"IRIS.Presentation.assignment.reloService.ReloServicePanel$RelocationServicePanel$1"), rowId);

		System.out.println(IRIS_AssignmentServicePage.subServiceIDMap.get(benefit.getIrisSubserviceName()));

		rowId = Helpers.getRowIdMatchingCellValue(
				IRIS_PageMaster.getTableObjectWithIndex(_IRIS, "javax.swing.JTable", 1), "ID",
				IRIS_AssignmentServicePage.subServiceIDMap.get(benefit.getIrisSubserviceName()));

		Helpers.selectTableRow(IRIS_PageMaster.getTableObjectWithIndex(_IRIS, "javax.swing.JTable", 1), rowId);
		IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Detail").click();

		String subServiceWindowTitle = MessageFormat.format(IRISConstants.SUB_SERVICE_TITLE_WITH_ID,
				IRIS_AssignmentServicePage.subServiceIDMap.get(benefit.getIrisSubserviceName()),
				CoreFunctions.getPropertyFromConfig("Assignment_FileID"),
				CoreFunctions.getPropertyFromConfig("Transferee_firstName"),
				CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
				CoreFunctions.getPropertyFromConfig("Assignment_ClientName"),
				CoreFunctions.getPropertyFromConfig("Assignment_ClientID"));

		Log.info(subServiceWindowTitle);

		_IRIS = IRIS_PageMaster.getWindowObject(subServiceWindowTitle);

		_IRIS.waitUntilVisible();

		TabControl tabControl = IRIS_PageMaster.getTabControlObject(_IRIS, "javax.swing.JTabbedPane", 0);
		Helpers.selectTabControl(tabControl, "Activity & Finance");

		Table activityFinanceTable = IRIS_PageMaster.getTableObject(_IRIS,
				"com.aires.iris.shipment.activityfinance.ActivityFinancePanel$3");

		for (TracingPromptToBeSelected partnerAndPrompt : benefit.getTracingPromptsToBeSelected()) {
			pageObjectManager_CoreFlex.getPageObjects().get(benefit.getBenefitType()).actualizeSubServiceTracingPrompt(
					_IRIS, activityFinanceTable, partnerAndPrompt.partner, partnerAndPrompt.tracingPrompt);
		}

		_IRIS.close();
	}

	private void handleInactivateSubServiceError() throws Exception {
		if (IRIS_PageMaster.getDialogObject(_IRIS, "Error while inactivating Sub Service(s)").exists()) {
			Dialog errorWhileInactivatingSubServiceSDialog = IRIS_PageMaster.getDialogObject(_IRIS,
					"Error while inactivating Sub Service(s)");
			Button oKButton = errorWhileInactivatingSubServiceSDialog.describe(Button.class,
					new ButtonDescription.Builder().label("OK")
							.nativeClass("javax.swing.plaf.basic.BasicOptionPaneUI$ButtonFactory$ConstrainedButton")
							.build());
			oKButton.click();
		}
	}

	private void provideEstimatedDatesForAllTracingPrompts(int noOfMilestones) throws Exception {
		for (FlexBenefit benefitList : flexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				if ((benefit.getSelectBenefitOnFPTPage()) && benefit.getAiresManagedService().equals("Yes")
						&& benefit.getNoOfMilestones() != null && benefit.getNoOfMilestones() == noOfMilestones) {
					selectServiceAndSubService(benefit);
					displayActivityTable();
					for (int i = 0; i < noOfMilestones; i++) {
						String activityName = benefit.getAllMilestones().split(",")[i].trim();
						System.out.println("name: " + activityName);
						enterActDateForTracingPrompt(
								IRIS_PageMaster.getTableObject(_IRIS,
										"IRIS.Presentation.assignment.activityFinance.ActivityPanel$1"),
								IRISConstants.ACTIVITY, activityName, IRISConstants.EST_DATE);
						clickOnSaveBtn();
						verifySaveSuccessfulMsg();
					}
				}
			}
		}
	}

	public void acceptWarningDialog() {
		try {
			_isExists = (IRIS_PageMaster.getDialogObject(_IRIS, "Confirmation").isVisible());
			if (_isExists) {
				Helpers.clickButton(
						IRIS_PageMaster.getDialogObject(_IRIS, "Confirmation").describe(Button.class,
								new ButtonDescription.Builder().label("No").build()),
						IRIS_PageMaster.getDialogObject(_IRIS, "Confirmation")
								.describe(Button.class, new ButtonDescription.Builder().label("No").build())
								.getLabel());
			}
		} catch (Exception e) {
		}

	}

	public void acceptSavedSuccessDialog() {
		try {
			_isExists = (IRIS_PageMaster.getDialogObject(_IRIS, "Saved").isVisible());
			if (_isExists) {
				Helpers.clickButton(
						IRIS_PageMaster.getDialogObject(_IRIS, "Saved").describe(Button.class,
								new ButtonDescription.Builder().label("OK").build()),
						IRIS_PageMaster.getDialogObject(_IRIS, "Saved")
								.describe(Button.class, new ButtonDescription.Builder().label("OK").build())
								.getLabel());
			}
		} catch (Exception e) {
		}

	}
}