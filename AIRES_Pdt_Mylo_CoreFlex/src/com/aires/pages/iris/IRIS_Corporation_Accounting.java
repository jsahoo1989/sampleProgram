package com.aires.pages.iris;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.pages.iris.basepage.BasePage;
import com.aires.utilities.Log;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.Editor;
import com.hp.lft.sdk.java.EditorDescription;
import com.hp.lft.sdk.java.Table;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class IRIS_Corporation_Accounting extends BasePage {

	private String windowTitle;
	private boolean _isExists = false;

	public IRIS_Corporation_Accounting() throws Exception {
		super();
	}

	private Editor editor;
	private Button button;
	private Editor nameEditor = _IRIS.describe(Editor.class,
			new EditorDescription.Builder().attachedText("Name*").build());
	private boolean checkOperationPerformed = false;
	private boolean uncheckOperationPerformed = false;

	/**
	 * Verify Overview tab title.
	 * 
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public boolean verifyAccountingTab() throws GeneralLeanFtException {
		_IRIS.maximize();
		try {
			CoreFunctions.waitHandler(5);
			if (IRIS_PageMaster.getTabControlObject(_IRIS, 0).getSelectedTab().equals(IRISConstants.ACCOUNTING)) {
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
	 * Verify CoreFlex Enabled Column in Policy table.
	 * 
	 * @param policyName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPolicyTableColumn(String searchColumnName) throws Exception {

		_isExists = Helpers.searchJTableColumn(
				(IRIS_PageMaster.getTableObject(_IRIS, "com.aires.iris.view.corporation.accounting.PolicyPanel$1")),
				searchColumnName);

		if (_isExists) {
			Log.info(MessageFormat.format(IRISConstants.VERIFIED_TABLE_COLUMN_NAME, CoreConstants.PASS,
					searchColumnName, IRISConstants.ACCOUNTING));
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_TABLE_COLUMN_NAME, CoreConstants.PASS,
					searchColumnName, IRISConstants.ACCOUNTING));
		}
		return _isExists;
	}

	public void performCoreFlexCheckboxSelectionForPolicy(String columnName, DataTable dataTable) {

		List<Map<String, String>> policyData = dataTable.asMaps(String.class, String.class);
		int counter = 0;

		try {

			while (counter < policyData.size()) {

				String policyName = policyData.get(counter).get(IRISConstants.POLICY_NAME_COLUMN);
				String checkboxSelection = policyData.get(counter).get(IRISConstants.COREFLEX_CHECKBOX_SELECTION);

				coreFlexCheckboxSelection(
						(IRIS_PageMaster.getTableObject(_IRIS,
								"com.aires.iris.view.corporation.accounting.PolicyPanel$1")),
						columnName, policyName, checkboxSelection);

				counter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void performCoreFlexCheckboxSelectionForPolicy(String columnName, String checkboxSelection,
			String policyName) {
		try {

			coreFlexCheckboxSelection(
					(IRIS_PageMaster.getTableObject(_IRIS, "com.aires.iris.view.corporation.accounting.PolicyPanel$1")),
					columnName, policyName, checkboxSelection);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Select CoreFlex Enabled Column for a Policy
	 * 
	 * @param tableObject
	 * @param columnName
	 * @throws Exception
	 */
	private void coreFlexCheckboxSelection(Table table, String columnName, String policyName, String checkboxSelection)
			throws Exception {

		table.waitUntilVisible();

		if (table.getRows().size() > 0 & table.getColumnHeaders().contains(columnName)) {
			searchPolicyNameInPolicyTable(table, columnName, policyName, checkboxSelection);
		} else {
			Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
		}

	}

	private void searchPolicyNameInPolicyTable(Table table, String columnName, String policyName,
			String checkboxSelection) throws GeneralLeanFtException {

		for (int rowCount = 0; rowCount < table.getRows().size(); rowCount++) {

			if (table.getCell(rowCount, "Policy").getValue().toString().contains(policyName)) {
				performCoreFlexCheckboxSelection(table, rowCount, columnName, policyName, checkboxSelection);
				break;
			}
		}

	}

	private void performCoreFlexCheckboxSelection(Table table, int rowCount, String columnName, String policyName,
			String checkboxSelection) throws GeneralLeanFtException {

		switch (checkboxSelection) {

		case IRISConstants.CHECKED:
			checkCoreFlexEnabledCheckbox(table, rowCount, columnName, policyName);
			break;

		case IRISConstants.UNCHECKED:
			uncheckCoreFlexEnabledCheckbox(table, rowCount, columnName, policyName);
			break;

		default:
			Assert.fail(IRISConstants.NO_VALID_SELECTION);

		}

	}

	private void uncheckCoreFlexEnabledCheckbox(Table table, int rowCount, String columnName, String policyName)
			throws GeneralLeanFtException {
		checkOperationPerformed = false;
		if ((table.getCell(rowCount, columnName).getValue().toString()).equals("1.0")) {
			table.getCell(rowCount, columnName).click();
			checkOperationPerformed = true;
			Log.info(MessageFormat.format(IRISConstants.SUCCESSFULLY_UNCHECKED_COREFLEX_ENABLED_COLUMN_FOR_THE_POLICY,
					CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.SUCCESSFULLY_UNCHECKED_COREFLEX_ENABLED_COLUMN_FOR_THE_POLICY,
							CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
		} else if ((table.getCell(rowCount, columnName).getValue().toString()).equals("0.0")) {
			Log.info(MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_ALREADY_UNCHECKED_FOR_THE_POLICY,
					CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_ALREADY_UNCHECKED_FOR_THE_POLICY,
							CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
		}

	}

	private void checkCoreFlexEnabledCheckbox(Table table, int rowCount, String columnName, String policyName)
			throws GeneralLeanFtException {
		uncheckOperationPerformed = false;
		if ((table.getCell(rowCount, columnName).getValue().toString()).equals("0.0")) {
			table.getCell(rowCount, columnName).click();
			uncheckOperationPerformed = true;
			Log.info(MessageFormat.format(IRISConstants.SUCCESSFULLY_CHECKED_COREFLEX_ENABLED_COLUMN_FOR_THE_POLICY,
					CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.SUCCESSFULLY_CHECKED_COREFLEX_ENABLED_COLUMN_FOR_THE_POLICY,
							CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
		} else if ((table.getCell(rowCount, columnName).getValue().toString()).equals("1.0")) {
			Log.info(MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_ALREADY_CHECKED_FOR_THE_POLICY,
					CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_ALREADY_CHECKED_FOR_THE_POLICY,
							CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
		}

	}

	public void clickOnSaveBtn() {
		try {
			IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").waitUntilEnabled();
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save"),
					IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getLabel());
			Log.info("Save Button Clicked.");
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS,
					IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getLabel()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void saveConfirmation() throws GeneralLeanFtException, Exception {

		if (checkOperationPerformed || uncheckOperationPerformed) {
			acceptSaveConfirmation();
			acceptSaveDialog();
		}

	}

	private void acceptSaveConfirmation() throws GeneralLeanFtException, Exception {

		try {
			CoreFunctions.waitHandler(1);
			if (IRIS_PageMaster.getDialogObject(_IRIS, "Save confirmation").isVisible()) {
				Helpers.clickButton(
						IRIS_PageMaster.getButtonObjectFromLabel(
								IRIS_PageMaster.getDialogObject(_IRIS, "Save confirmation"), "Save & Continue"),
						"Save & Continue");

				Log.info(IRISConstants.VERIFIED_SAVED_CONFIRMATION);
				Reporter.addStepLog(
						MessageFormat.format(IRISConstants.VERIFIED_SAVED_CONFIRMATION, CoreConstants.PASS));

				acceptDialog();

			} else {
				Assert.fail(IRISConstants.SAVE_CONFIRMATION_DIALOG_NOT_VISIBLE);
			}
		} catch (Exception e) {

		}

	}

	public void acceptSaveDialog() throws Exception {

		try {

			if (IRIS_PageMaster.getDialogObject(_IRIS, "Saved").isVisible()) {
				Helpers.clickButton(
						IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"), "OK"),
						"OK");
				Log.info(IRISConstants.VERIFIED_OK_CONFIRMATION);
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_OK_CONFIRMATION, CoreConstants.PASS));

			}
		} catch (Exception e) {

		}

	}

	public void acceptDialog() {
		try {
			CoreFunctions.waitHandler(1);
			if (IRIS_PageMaster.getDialogObject(_IRIS, "Saved!").isVisible()) {
				Helpers.clickButton(IRIS_PageMaster
						.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Saved!"), "OK"), "OK");
				Log.info(IRISConstants.VERIFIED_OK_CONFIRMATION);
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_OK_CONFIRMATION, CoreConstants.PASS));

			}
		} catch (Exception e) {

		}

	}

	public boolean verifyCoreFlexCheckboxSelectionForPolicy(String columnName, DataTable dataTable) {

		boolean isCoreFlexSelectionCorrect = false;
		List<Map<String, String>> policyData = dataTable.asMaps(String.class, String.class);
		int counter = 0;

		try {

			while (counter < policyData.size()) {

				String policyName = policyData.get(counter).get(IRISConstants.POLICY_NAME_COLUMN);
				String checkboxSelection = policyData.get(counter).get(IRISConstants.COREFLEX_CHECKBOX_SELECTION);

				isCoreFlexSelectionCorrect = verifyCoreFlexCheckboxSelection(
						(IRIS_PageMaster.getTableObject(_IRIS,
								"com.aires.iris.view.corporation.accounting.PolicyPanel$1")),
						columnName, policyName, checkboxSelection);

				counter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isCoreFlexSelectionCorrect;

	}

	private boolean verifyCoreFlexCheckboxSelection(Table table, String columnName, String policyName,
			String checkboxSelection) throws GeneralLeanFtException {

		boolean isPolicyPresentInTable = false;
		table.waitUntilVisible();

		if (table.getRows().size() > 0 & table.getColumnHeaders().contains(columnName)) {
			isPolicyPresentInTable = verifyPolicyNameInPolicyTable(table, columnName, policyName, checkboxSelection);
		} else {
			Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
		}

		return isPolicyPresentInTable;

	}

	private boolean verifyPolicyNameInPolicyTable(Table table, String columnName, String policyName,
			String checkboxSelection) throws GeneralLeanFtException {

		boolean isVerified = false;

		for (int rowCount = 0; rowCount < table.getRows().size(); rowCount++) {

			if (table.getCell(rowCount, "Policy").getValue().toString().contains(policyName)) {
				isVerified = verifyCheckboxSelection(table, rowCount, columnName, policyName, checkboxSelection);
				break;
			}
		}
		return isVerified;
	}

	private boolean verifyCheckboxSelection(Table table, int rowCount, String columnName, String policyName,
			String checkboxSelection) throws GeneralLeanFtException {

		boolean isSelectionVerified = false;

		switch (checkboxSelection) {

		case IRISConstants.CHECKED:
			isSelectionVerified = verifyCheckCoreFlexEnabledCheckbox(table, rowCount, columnName, policyName);
			break;

		case IRISConstants.UNCHECKED:
			isSelectionVerified = verifyUncheckCoreFlexEnabledCheckbox(table, rowCount, columnName, policyName);
			break;

		default:
			Assert.fail(IRISConstants.NO_VALID_SELECTION);

		}

		return isSelectionVerified;

	}

	private boolean verifyCheckCoreFlexEnabledCheckbox(Table table, int rowCount, String columnName, String policyName)
			throws GeneralLeanFtException {

		boolean isCheckedVerified = false;

		if ((table.getCell(rowCount, columnName).getValue().toString()).equals("1.0")) {
			isCheckedVerified = true;
			Log.info(MessageFormat.format(
					IRISConstants.SUCCESSFULLY_VERIFIED_COREFLEX_ENABLED_COLUMN_IS_CHECKED_FOR_THE_POLICY,
					CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.SUCCESSFULLY_VERIFIED_COREFLEX_ENABLED_COLUMN_IS_CHECKED_FOR_THE_POLICY,
					CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
		} else if ((table.getCell(rowCount, columnName).getValue().toString()).equals("0.0")) {
			Log.info(MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_NOT_CHECKED_FOR_THE_POLICY,
					CoreConstants.FAIL, columnName, policyName, IRISConstants.ACCOUNTING));
			Reporter.addStepLog(MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_NOT_CHECKED_FOR_THE_POLICY,
					CoreConstants.FAIL, columnName, policyName, IRISConstants.ACCOUNTING));
		}

		return isCheckedVerified;
	}

	private boolean verifyUncheckCoreFlexEnabledCheckbox(Table table, int rowCount, String columnName,
			String policyName) throws GeneralLeanFtException {

		boolean isUncheckedVerified = false;

		if ((table.getCell(rowCount, columnName).getValue().toString()).equals("0.0")) {
			isUncheckedVerified = true;
			Log.info(MessageFormat.format(
					IRISConstants.SUCCESSFULLY_VERIFIED_COREFLEX_ENABLED_COLUMN_IS_UNCHECKED_FOR_THE_POLICY,
					CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.SUCCESSFULLY_VERIFIED_COREFLEX_ENABLED_COLUMN_IS_UNCHECKED_FOR_THE_POLICY,
					CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
		} else if ((table.getCell(rowCount, columnName).getValue().toString()).equals("1.0")) {
			Log.info(MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_NOT_UNCHECKED_FOR_THE_POLICY,
					CoreConstants.FAIL, columnName, policyName, IRISConstants.ACCOUNTING));
			Reporter.addStepLog(MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_NOT_UNCHECKED_FOR_THE_POLICY,
					CoreConstants.FAIL, columnName, policyName, IRISConstants.ACCOUNTING));
		}

		return isUncheckedVerified;
	}

}
