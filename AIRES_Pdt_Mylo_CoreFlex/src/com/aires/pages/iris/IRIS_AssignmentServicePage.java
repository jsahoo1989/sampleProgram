package com.aires.pages.iris;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.pages.iris.basepage.BasePage;
import com.aires.utilities.Log;
import com.aires.utilities.getWindowText;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.ButtonDescription;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.DialogDescription;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.TableDescription;
import com.hp.lft.sdk.java.Window;
import com.hp.lft.sdk.java.WindowDescription;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class IRIS_AssignmentServicePage extends BasePage {

	public IRIS_AssignmentServicePage() throws Exception {
		super();
	}

	private Table _tableName = null;
	private Button _addButtonName = null;
	private boolean _isExists = false;
	private static String _serviceColumnName = null;
	private static int serviceID = 0;
	private static int rowCount = 0;
	private String _serviceWindowTitle = null;

	// Methods
	public boolean verifyServiceTab() throws Exception {
		_isExists = IRIS_PageMaster.getTabControlObject(_IRIS, "javax.swing.JTabbedPane", 0).getSelectedTab()
				.equals(IRISConstants.SERVICE_TAB);
		if (_isExists)
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CURRENT_TAB, CoreConstants.PASS,
					IRIS_PageMaster.getTabControlObject(_IRIS, "javax.swing.JTabbedPane", 0).getSelectedTab()));
		return _isExists;
	}

	public void clickOkButton() throws GeneralLeanFtException, AWTException {
		CoreFunctions.waitHandler(2);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		CoreFunctions.waitHandler(1);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		CoreFunctions.waitHandler(4);
	}

	public Button getButtonName(String sectionName) throws Exception {
		switch (sectionName) {
		case IRISConstants.TEXT_SERVICE:
			_addButtonName = IRIS_PageMaster.getButtonObject(_IRIS, "javax.swing.JButton", 0);
			break;
		case IRISConstants.SUB_SERVICE_TEXT:
			_addButtonName = IRIS_PageMaster.getButtonObject(_IRIS, "Add", 2);
			break;
		default:
			Assert.fail(IRISConstants.NO_BUTTON_FOUND);
		}
		return _addButtonName;
	}

	public Table getTableName(String sectionName) throws Exception {
		switch (sectionName) {
		case IRISConstants.TEXT_SERVICE:
			_tableName = IRIS_PageMaster.getTableObject(_IRIS,
					"IRIS.Presentation.assignment.reloService.ReloServicePanel$RelocationServicePanel$1");
			break;
		case IRISConstants.SUB_SERVICE_TEXT:
			_tableName = IRIS_PageMaster.getTableObjectWithIndex(_IRIS, "javax.swing.JTable", 1);
			break;
		default:
			Assert.fail("Table Not Exists");
		}
		return _tableName;
	}

	public String getServiceIDColumnName(String sectionName) {
		switch (sectionName) {
		case IRISConstants.TEXT_SERVICE:
			_serviceColumnName = IRISConstants.SERVICE_ID;
			break;
		case IRISConstants.SUB_SERVICE_TEXT:
			_serviceColumnName = IRISConstants.ID_TEXT;
			break;
		default:
			Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
		}
		return _serviceColumnName;
	}

	public int addService(String serviceName) {
		try {
			Table _reloServicePanel1Table = IRIS_PageMaster.getTableObject(_IRIS,
					"IRIS.Presentation.assignment.reloService.ReloServicePanel$RelocationServicePanel$1");
			Button _serviceAddButton = _IRIS.describe(Button.class, new ButtonDescription.Builder().attachedText("Add")
					.label("Add").nativeClass("javax.swing.JButton").index(0).build());
			_reloServicePanel1Table.waitUntilVisible();
			Helpers.clickButton(_serviceAddButton, _serviceAddButton.getAttachedText());
			rowCount = Helpers.getTableRowCount(_reloServicePanel1Table);
			_reloServicePanel1Table.getCell(rowCount - 1, IRISConstants.EDITOR_NAME).setValue(serviceName);
		} catch (Exception e) {
			System.out.println("in catch of addService method");
		}
		return rowCount;
	}

	public void clickSaveButton() throws Exception {
		Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save"),
				IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getLabel());
		if(!IRIS_PageMaster.getDialogObject(_IRIS, "Saved").exists()) {
			String _newTransfereeWindowTitle = MessageFormat.format(IRISConstants.TRANSFEREE_TITLE_TO_APPEND_SERVICE,
					CoreFunctions.getPropertyFromConfig("Assignment_FileID"), CoreFunctions.getPropertyFromConfig("Transferee_firstName"), CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
			_IRIS = IRIS_PageMaster.getWindowObject(_newTransfereeWindowTitle);
		}		
		try {
			Helpers.clickButton(
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"), "OK"),
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"), "OK").getLabel());
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
			Assert.fail("Failed to click Ok Button");
		}
	}

	public void clickSaveButtonWithTitleChange() throws Exception {
		try {
			Log.info("window title in clickSaveButtonWithTitleChang=="+getIRISWindow().getTitle());
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save"),
					IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getLabel());

			String _newTransfereeWindowTitle = MessageFormat.format(IRISConstants.TRANSFEREE_TITLE_TO_APPEND_SERVICE,
					CoreFunctions.getPropertyFromConfig("Assignment_FileID"), CoreFunctions.getPropertyFromConfig("Transferee_firstName"), CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
			_IRIS = IRIS_PageMaster.getWindowObject(_newTransfereeWindowTitle);
			IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"), "OK").waitUntilEnabled();
			Helpers.clickButton(
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"), "OK"),
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"), "OK").getLabel());
			Log.info("Ok button clicked.");
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
			Assert.fail("Failed to click Ok Button");
		}
	}

	public void clickSaveButtonForPartnerAllocation() {
		try {
			Button saveButton = _IRIS.describe(Button.class, new ButtonDescription.Builder().label("Save").build());
			Helpers.clickButton(saveButton, saveButton.getLabel());
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public void clickAddButtonForSubService() throws Exception {
		try {
			/*
			 * Window serviceAIRESCWindow = Desktop.describe(Window.class, new
			 * WindowDescription.Builder().title(CoreFunctions.getPropertyFromConfig(
			 * "ServiceTitle")).build());
			 */
			Log.info("inside method==" + "clickAddButtonForSubService");
			_IRIS = getIRISWindow();
			Log.info("Window title==" + _IRIS.getTitle());
			Button _addButton = _IRIS.describe(Button.class, new ButtonDescription.Builder().attachedText("Add")
					.label("Add").nativeClass("javax.swing.JButton").index(2).build());
			Log.info("created object for add button");
			Helpers.clickButton(_addButton, _addButton.getLabel());
			Log.info("Clicked on add button");
		} catch (GeneralLeanFtException e) {
			System.out.println("in catch of clickAddButtonForSubService");
		}
	}

	public boolean verifyServiceAdded(String serviceName, String sectionName, int rowCountAfterServiceAdded)
			throws Exception {
		try {
			_serviceColumnName = getServiceIDColumnName(sectionName);
			_tableName = getTableName(sectionName);
			_tableName.waitUntilVisible();
			if (_tableName.getRows().size() == rowCountAfterServiceAdded && _tableName
					.getCell(rowCountAfterServiceAdded - 1, IRISConstants.EDITOR_NAME).getValue().equals(serviceName)) {
				_isExists = true;
				serviceID = (int) Math.round(Double.parseDouble(
						_tableName.getCell(rowCountAfterServiceAdded - 1, _serviceColumnName).getValue().toString()));
				Reporter.addStepLog(MessageFormat.format(IRISConstants.SERVICE_ADDED_SUCCESSFULLY_MSG,
						CoreConstants.PASS, serviceName, serviceID));
			} else
				Log.info(CoreConstants.FAIL + IRISConstants.TEXT_SERVICE + CoreConstants.NOT_EXIST);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
		return _isExists;
	}

	public void clickAddButton(String sectionName) throws Exception {
		try {
			Helpers.clickButton(getButtonName(sectionName), getButtonName(sectionName).getAttachedText());
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public int addSubService(String sectionName, DataTable subServiceData) {
		try {
			java.util.List<java.util.List<String>> data = subServiceData.raw();
			_tableName = getTableName(sectionName);
			_tableName.waitUntilVisible();
			rowCount = Helpers.getTableRowCount(_tableName);
			_tableName.getCell(rowCount - 1, data.get(0).get(0).toString()).setValue(data.get(1).get(0).toString());
			_tableName.getCell(rowCount - 1, data.get(0).get(1).toString()).setValue(data.get(1).get(1).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public int addSubService(String subServiceName) {
		try {
			/*
			 * Window file12C = Desktop.describe(Window.class, new
			 * WindowDescription.Builder().title(CoreFunctions.getPropertyFromConfig(
			 * "ServiceTitle")).build());
			 */
			Table _subServicejTable = _IRIS.describe(Table.class,
					new TableDescription.Builder().nativeClass("javax.swing.JTable").index(1).build());
			_subServicejTable.waitUntilVisible();
			rowCount = Helpers.getTableRowCount(_subServicejTable);
			_subServicejTable.getCell(rowCount - 1, "Type").setValue(subServiceName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public int addSubService_PartnerAllocation(DataTable subServiceData) {
		try {
			java.util.List<java.util.List<String>> data = subServiceData.raw();
			Window file12C = Desktop.describe(Window.class,
					new WindowDescription.Builder().title(CoreFunctions.getPropertyFromConfig("ServiceTitle")).build());
			Table _subServicejTable = file12C.describe(Table.class,
					new TableDescription.Builder().nativeClass("javax.swing.JTable").index(1).build());

			_subServicejTable.waitUntilVisible();
			rowCount = Helpers.getTableRowCount(_subServicejTable);
			_subServicejTable.getCell(rowCount - 1, data.get(0).get(0).toString())
			.setValue(data.get(1).get(0).toString());
			_subServicejTable.getCell(rowCount - 1, data.get(0).get(1).toString())
			.setValue(data.get(1).get(1).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public boolean verifySaveSuccessMessage(String message) throws Exception {
		_isExists = IRIS_PageMaster.getDialogObject(_IRIS, "Saved").getVisibleText().contains(message) ? true : false;
		if (_isExists) {
			Helpers.clickButton(
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"), "OK"),
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"), "OK")
					.getLabel());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFY_MESSAGE_DISPLAYED_ON_SERVICE_TAB,
					CoreConstants.PASS, message));
		}
		return _isExists;
	}


	// Method need to be deleted as it is using Robot Class
	public boolean verify_SaveSuccessMsg_ForPA_ForClient_92265(String message) throws Exception {
		_serviceWindowTitle = MessageFormat.format(IRISConstants.TRANSFEREE_TITLE_SERVICE_CLIENT_92265,
				CoreFunctions.getPropertyFromConfig("Assignment_FileID"),
				CoreFunctions.getPropertyFromConfig("Transferee_firstName"),
				CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
		String windowTitle = _serviceWindowTitle;
		CoreFunctions.writeToPropertiesFile("ServiceTitle", windowTitle);
		_IRIS = getIRISWindow();
		try {
			CoreFunctions.waitHandler(2);
			Dialog savedDialog = _IRIS.describe(Dialog.class, new DialogDescription.Builder().title("Saved").build());
			Button oKButton = savedDialog.describe(Button.class, new ButtonDescription.Builder().label("OK").build());

			Robot robot = new Robot(); 
			robot.setAutoDelay(250);
			robot.keyPress(KeyEvent.VK_ENTER); 
			robot.keyRelease(KeyEvent.VK_ENTER);

			_isExists = true;
			CoreFunctions.waitHandler(5);
			//Helpers.clickButton(oKButton, oKButton.getLabel());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFY_MESSAGE_DISPLAYED_ON_SERVICE_TAB,
					CoreConstants.PASS, message));
			return true;
		} catch (Exception e) {
			return _isExists;
		}
	}

	public boolean verifySaveSuccessMsgForPartnerAllocation(String message) throws GeneralLeanFtException {
		_serviceWindowTitle = MessageFormat.format(IRISConstants.TRANSFEREE_TITLE_SERVICE,
				CoreFunctions.getPropertyFromConfig("Assignment_FileID"),
				CoreFunctions.getPropertyFromConfig("Transferee_firstName"),
				CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
		String windowTitle = _serviceWindowTitle + "'" + IRISConstants.TRANSFEREE_POLICY;
		CoreFunctions.writeToPropertiesFile("ServiceTitle", windowTitle);
		Window file12C = Desktop.describe(Window.class, new WindowDescription.Builder().title(windowTitle).build());
		Dialog savedDialog = file12C.describe(Dialog.class, new DialogDescription.Builder().title("Saved").build());
		Button oKButton = savedDialog.describe(Button.class, new ButtonDescription.Builder().label("OK").build());
		if (savedDialog.getVisibleText().contains(message)) {
			_isExists = true;
			Helpers.clickButton(oKButton, oKButton.getLabel());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFY_MESSAGE_DISPLAYED_ON_SERVICE_TAB,
					CoreConstants.PASS, message));
		}
		return _isExists;
	}

	public void clickEERFButton() {
		try {
			Window IRIS = Desktop.describe(Window.class,
					new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build());
			Button _eERFButton = IRIS.describe(Button.class, new ButtonDescription.Builder().label("EERF").build());
			Helpers.clickButton(_eERFButton, _eERFButton.getLabel());
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public boolean verifyTransfereeExpenseFormAddedUnderSubServiceTab(String serviceName, String sectionName)
			throws Exception {
		try {
			CoreFunctions.waitHandler(10);
			_serviceColumnName = getServiceIDColumnName(sectionName);
			_tableName = getTableName(sectionName);
			_tableName.waitUntilVisible();
			if (_tableName.getCell(_tableName.getRows().size() - 1, IRISConstants.EDITOR_NAME).getValue()
					.equals(serviceName)) {
				_isExists = true;
				serviceID = (int) Math.round(Double.parseDouble(
						_tableName.getCell(_tableName.getRows().size() - 1, _serviceColumnName).getValue().toString()));
				Reporter.addStepLog(MessageFormat.format(IRISConstants.SERVICE_ADDED_SUCCESSFULLY_MSG,
						CoreConstants.PASS, serviceName, serviceID));
				CoreFunctions.writeToPropertiesFile("ServiceID", Integer.toString(serviceID));
			} else
				Log.info(CoreConstants.FAIL + IRISConstants.TEXT_SERVICE + CoreConstants.NOT_EXIST);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
		return _isExists;
	}

	public void addLangSubServiceDetails(String langDetails) {
		try {
			String transfereeName = CoreFunctions.getPropertyFromConfig(IRISConstants.FIRST_NAME_TEXT) + " "
					+ CoreFunctions.getPropertyFromConfig(IRISConstants.LAST_NAME_TEXT);
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabelText(_IRIS, "Detail"),
					IRIS_PageMaster.getButtonObjectFromLabelText(_IRIS, "Detail").getLabel());
			IRIS_PageMaster.getDialogObject(_IRIS, "Sub-Service Detail Screen").waitUntilVisible();
			Helpers.selectFromList(
					IRIS_PageMaster.getListObject(IRIS_PageMaster.getDialogObject(_IRIS, "Sub-Service Detail Screen"),
							"Service Provider Email"),
					transfereeName,
					IRIS_PageMaster.getListObject(IRIS_PageMaster.getDialogObject(_IRIS, "Sub-Service Detail Screen"),
							"Service Provider Email").getAttachedText());
			Helpers.setEditorText(IRIS_PageMaster.getEditorObjectWithIndex(
					IRIS_PageMaster.getDialogObject(_IRIS, "Sub-Service Detail Screen"), "1976413",
					"javax.swing.JTextField", 2), "English", "English");
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabelText(_IRIS, "Update"),
					IRIS_PageMaster.getButtonObjectFromLabelText(_IRIS, "Update").getLabel());
		} catch (Exception e) {

		}
	}

	public void selectService(String sectionName) throws GeneralLeanFtException, Exception {
		Helpers.selectTableRow(getTableName(sectionName), Helpers.getTableRowCount(getTableName(sectionName)) - 1);
	}

}