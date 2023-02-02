package com.aires.pages.iris;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.pages.iris.basepage.BasePage;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Table;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class IRIS_Corporation_Accounting extends BasePage {

	public IRIS_Corporation_Accounting() throws Exception {
		super();
	}

	private static boolean isCheckboxSelectionAlreadyPerformed = false;

	public static boolean getCheckboxSelectionAlreadyPerformedStatus() {
		return isCheckboxSelectionAlreadyPerformed;
	}

	public static void setCheckboxSelectionAlreadyPerformedStatus(boolean alreadyPerformed) {
		isCheckboxSelectionAlreadyPerformed = alreadyPerformed;
	}

	/**
	 * Verify Accounting tab title.
	 * 
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public boolean verifyAccountingTab() throws GeneralLeanFtException {
		_IRIS.maximize();
		try {
//			CoreFunctions.waitHandler(5);
			if (IRIS_PageMaster.getTabControlObject(_IRIS, 0).getSelectedTab().equals(IRISConstants.ACCOUNTING)) {
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CURRENT_TAB, CoreConstants.PASS,
						IRIS_PageMaster.getTabControlObject(_IRIS, 0).getSelectedTab()));
				return true;
			}
		} catch (Exception e) {
			Assert.fail(IRISConstants.FAILED_TO_VERIFY_ACCOUNTING_TAB);
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

		boolean _isExists = false;
		_isExists = Helpers.searchJTableColumn(
				(IRIS_PageMaster.getTableObject(_IRIS, "com.aires.iris.view.corporation.accounting.PolicyPanel$1")),
				searchColumnName);
		if (_isExists) {
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_TABLE_COLUMN_NAME, CoreConstants.PASS,
					searchColumnName, IRISConstants.ACCOUNTING));
		}
		return _isExists;
	}

	/**
	 * Overloaded method to Perform selection of CoreFlex Enabled Checkbox for the
	 * specified Policies.
	 * 
	 * @param columnName
	 * @param dataTable
	 */
	public void performCoreFlexCheckboxSelectionForPolicy(String columnName, DataTable dataTable) {
		try {
			List<Map<String, String>> policyData = dataTable.asMaps(String.class, String.class);
			for (int i = 0; i < policyData.size(); i++) {
				Table table = IRIS_PageMaster.getTableObject(_IRIS,
						"com.aires.iris.view.corporation.accounting.PolicyPanel$1");
				table.waitUntilVisible();
				if (table.getRows().size() > 0 & table.getColumnHeaders().contains(columnName)) {
					searchPolicyNameInPolicyTable(table, columnName,
							policyData.get(i).get(IRISConstants.POLICY_NAME_COLUMN),
							policyData.get(i).get(IRISConstants.COREFLEX_CHECKBOX_SELECTION));
				} else {
					Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_SEARCHING_POLICY_NAME_AND_COREFLEX_ENABLED_COLUMNS_IN_POLICY_TABLE_OF_ACCOUNTING_TAB,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Overloaded method to Perform selection of CoreFlex Enabled Checkbox for the
	 * specified Policy.
	 * 
	 * @param columnName
	 * @param checkboxSelection
	 * @param policyName
	 */
	public void performCoreFlexCheckboxSelectionForPolicy(String columnName, String checkboxSelection,
			String policyName) {
		try {
			Table table = IRIS_PageMaster.getTableObject(_IRIS,
					"com.aires.iris.view.corporation.accounting.PolicyPanel$1");
			table.waitUntilVisible();
			if (table.getRows().size() > 0 & table.getColumnHeaders().contains(columnName)) {
				searchPolicyNameInPolicyTable(table, columnName, policyName, checkboxSelection);
			} else {
				Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_SEARCHING_POLICY_NAME_AND_COREFLEX_ENABLED_COLUMNS_IN_POLICY_TABLE_OF_ACCOUNTING_TAB,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Method to search Policy name in Policy Table
	 * 
	 * @param table
	 * @param columnName
	 * @param policyName
	 * @param checkboxSelection
	 * @throws GeneralLeanFtException
	 */
	private void searchPolicyNameInPolicyTable(Table table, String columnName, String policyName,
			String checkboxSelection) throws GeneralLeanFtException {
		try {
			for (int rowCount = 0; rowCount < table.getRows().size(); rowCount++) {
				if (policyName.equals(table.getCell(rowCount, "Policy").getValue().toString())) {
					performCoreFlexCheckboxSelectionBasedOnUserInput(table, rowCount, columnName, policyName,
							checkboxSelection);
					CoreFunctions.writeToPropertiesFile("Policy_TracingSet",
							(table.getCell(rowCount, "Tracing Set").getValue().toString()));
					break;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_SEARCHING_REQUIRED_POLICY_IN_POLICY_TABLE_OF_ACCOUNTING_TAB,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Method to perform checkbox Selection based on User Input/Requirement -
	 * Checked or Unchecked
	 * 
	 * @param table
	 * @param rowCount
	 * @param columnName
	 * @param policyName
	 * @param checkboxSelection
	 * @throws GeneralLeanFtException
	 */
	private void performCoreFlexCheckboxSelectionBasedOnUserInput(Table table, int rowCount, String columnName,
			String policyName, String checkboxSelection) throws GeneralLeanFtException {
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

	/**
	 * Method to uncheck CoreFlex Enabled Checkbox if checked and ignore if already
	 * unchecked.
	 * 
	 * @param table
	 * @param rowCount
	 * @param columnName
	 * @param policyName
	 * @throws GeneralLeanFtException
	 */
	private void uncheckCoreFlexEnabledCheckbox(Table table, int rowCount, String columnName, String policyName)
			throws GeneralLeanFtException {
		setCheckboxSelectionAlreadyPerformedStatus(false);
		if ((table.getCell(rowCount, columnName).getValue().toString()).equals("1.0")) {
			table.getCell(rowCount, columnName).click();
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.SUCCESSFULLY_UNCHECKED_COREFLEX_ENABLED_COLUMN_FOR_THE_POLICY,
							CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
		} else if ((table.getCell(rowCount, columnName).getValue().toString()).equals("0.0")) {
			setCheckboxSelectionAlreadyPerformedStatus(true);
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_ALREADY_UNCHECKED_FOR_THE_POLICY,
							CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
		}
	}

	/**
	 * Method to check CoreFlex Enabled Checkbox if unchecked and ignore if already
	 * checked.
	 * 
	 * @param table
	 * @param rowCount
	 * @param columnName
	 * @param policyName
	 * @throws GeneralLeanFtException
	 */
	private void checkCoreFlexEnabledCheckbox(Table table, int rowCount, String columnName, String policyName)
			throws GeneralLeanFtException {
		setCheckboxSelectionAlreadyPerformedStatus(false);
		if ((table.getCell(rowCount, columnName).getValue().toString()).equals("0.0")) {
			table.getCell(rowCount, columnName).click();
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.SUCCESSFULLY_CHECKED_COREFLEX_ENABLED_COLUMN_FOR_THE_POLICY,
							CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
		} else if ((table.getCell(rowCount, columnName).getValue().toString()).equals("1.0")) {
			setCheckboxSelectionAlreadyPerformedStatus(true);
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_ALREADY_CHECKED_FOR_THE_POLICY,
							CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
		}
	}

	/**
	 * Method to click on Save button and accept all the confirmation dialog box
	 */
	public void clickOnSaveBtn() {
		try {
			if (!getCheckboxSelectionAlreadyPerformedStatus()) {
//				CoreFunctions.waitHandler(1);
				IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").waitUntilEnabled();
				Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save"),
						IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getLabel());
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS,
						IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getLabel()));
				acceptSaveConfirmation();
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_SAVING_COREFLEX_CHECKBOX_SELECTION_IN_POLICY_TABLE_OF_ACCOUNTING_TAB,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Method to accept all dialog boxes appearing after saving the policy table
	 * selections
	 * 
	 * @throws GeneralLeanFtException
	 * @throws Exception
	 */
	private void acceptSaveConfirmation() throws GeneralLeanFtException, Exception {
//		CoreFunctions.waitHandler(1);
		if (IRIS_PageMaster.getDialogObject(_IRIS, "Saved").isVisible()) {
			Helpers.clickButton(
					IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Saved"), "OK"),
					"OK");
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_OK_CONFIRMATION, CoreConstants.PASS));
		}
	}

	/**
	 * Method to verify CoreFlex Checkbox selection is maintained for Policies -
	 * CoreFlex Checked/Unchecked earlier
	 * 
	 * @param columnName
	 * @param dataTable
	 * @return
	 */
	public boolean verifyCoreFlexCheckboxSelectionForPolicy(String columnName, DataTable dataTable) {
		boolean isCoreFlexSelectionCorrect = false;
		List<Map<String, String>> policyData = dataTable.asMaps(String.class, String.class);
		try {
			Table table = IRIS_PageMaster.getTableObject(_IRIS,
					"com.aires.iris.view.corporation.accounting.PolicyPanel$1");
			table.waitUntilVisible();
			for (int i = 0; i < policyData.size(); i++) {
				if (table.getRows().size() > 0 & table.getColumnHeaders().contains(columnName)) {
					isCoreFlexSelectionCorrect = verifyPolicyNameInPolicyTable(table, columnName,
							policyData.get(i).get(IRISConstants.POLICY_NAME_COLUMN),
							policyData.get(i).get(IRISConstants.COREFLEX_CHECKBOX_SELECTION));
					if (!isCoreFlexSelectionCorrect)
						return false;
				} else {
					Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
				}
			}
		} catch (Exception e) {

		}
		return isCoreFlexSelectionCorrect;
	}

	/**
	 * Method to verify Policy Name in Policy Table
	 * 
	 * @param table
	 * @param columnName
	 * @param policyName
	 * @param checkboxSelection
	 * @return
	 * @throws GeneralLeanFtException
	 */
	private boolean verifyPolicyNameInPolicyTable(Table table, String columnName, String policyName,
			String checkboxSelection) throws GeneralLeanFtException {
		for (int rowCount = 0; rowCount < table.getRows().size(); rowCount++) {
			if (table.getCell(rowCount, "Policy").getValue().toString().contains(policyName))
				return verifyCheckboxSelection(table, rowCount, columnName, policyName, checkboxSelection);
		}
		return false;
	}

	/**
	 * Method to call checked/unchecked verification method based on User selection
	 * 
	 * @param table
	 * @param rowCount
	 * @param columnName
	 * @param policyName
	 * @param checkboxSelection
	 * @return
	 * @throws GeneralLeanFtException
	 */
	private boolean verifyCheckboxSelection(Table table, int rowCount, String columnName, String policyName,
			String checkboxSelection) throws GeneralLeanFtException {
		switch (checkboxSelection) {
		case IRISConstants.CHECKED:
			return verifyCoreFlexEnabledCheckboxIsChecked(table, rowCount, columnName, policyName);
		case IRISConstants.UNCHECKED:
			return verifyCoreFlexEnabledCheckboxIsUnchecked(table, rowCount, columnName, policyName);
		default:
			Assert.fail(IRISConstants.NO_VALID_SELECTION);
		}
		return false;
	}

	/**
	 * Method to verify whether user checked selection is maintained or not
	 * 
	 * @param table
	 * @param rowCount
	 * @param columnName
	 * @param policyName
	 * @return
	 * @throws GeneralLeanFtException
	 */
	private boolean verifyCoreFlexEnabledCheckboxIsChecked(Table table, int rowCount, String columnName,
			String policyName) throws GeneralLeanFtException {
		if ((table.getCell(rowCount, columnName).getValue().toString()).equals("1.0")) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.SUCCESSFULLY_VERIFIED_COREFLEX_ENABLED_COLUMN_IS_CHECKED_FOR_THE_POLICY,
					CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
			return true;
		} else if ((table.getCell(rowCount, columnName).getValue().toString()).equals("0.0")) {
			Reporter.addStepLog(MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_NOT_CHECKED_FOR_THE_POLICY,
					CoreConstants.FAIL, columnName, policyName, IRISConstants.ACCOUNTING));
		}
		return false;
	}

	/**
	 * Method to verify whether user unchecked selection is maintained or not
	 * 
	 * @param table
	 * @param rowCount
	 * @param columnName
	 * @param policyName
	 * @return
	 * @throws GeneralLeanFtException
	 */
	private boolean verifyCoreFlexEnabledCheckboxIsUnchecked(Table table, int rowCount, String columnName,
			String policyName) throws GeneralLeanFtException {
		if ((table.getCell(rowCount, columnName).getValue().toString()).equals("0.0")) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.SUCCESSFULLY_VERIFIED_COREFLEX_ENABLED_COLUMN_IS_UNCHECKED_FOR_THE_POLICY,
					CoreConstants.PASS, columnName, policyName, IRISConstants.ACCOUNTING));
			return true;
		} else if ((table.getCell(rowCount, columnName).getValue().toString()).equals("1.0")) {
			Reporter.addStepLog(MessageFormat.format(IRISConstants.COREFLEX_ENABLED_COLUMN_NOT_UNCHECKED_FOR_THE_POLICY,
					CoreConstants.FAIL, columnName, policyName, IRISConstants.ACCOUNTING));
		}
		return false;
	}

	public void addPolicy() throws GeneralLeanFtException, Exception {
		Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Add", 0),
				IRIS_PageMaster.getButtonObject(_IRIS, "Add", 0).getAttachedText());
		Table policyTable = IRIS_PageMaster.getTableObject(_IRIS,
				"com.aires.iris.view.corporation.accounting.PolicyPanel$1");
		String policyName = IRISConstants.AUTO_TEST_POLICY + CoreFunctions.generateRandomString(5);
		policyTable.getCell(policyTable.getRows().size() - 1, PDTConstants.POLICY).setValue(policyName);
		policyTable.getCell(policyTable.getRows().size() - 1, "Tax Assistance Policy").setValue("No w/h No GUP|None");
		policyTable.getCell(policyTable.getRows().size() - 1, "Tracing Set").setValue("Transfer");
		Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Save"),
				IRIS_PageMaster.getButtonObject(_IRIS, "Save").getAttachedText());
		Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS,
				IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getLabel()));
		acceptSaveConfirmation();
		searchAndVerifyNewlyAddedPolicyNameInPolicyTable(policyTable, PDTConstants.POLICY, policyName);
	}

	private void searchAndVerifyNewlyAddedPolicyNameInPolicyTable(Table table, String columnName, String policyName)
			throws GeneralLeanFtException {
		try {
			boolean policyFound = false;
			for (int rowCount = 0; rowCount < table.getRows().size(); rowCount++) {
				if (policyName.equals(table.getCell(rowCount, "Policy").getValue().toString())) {
					Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_NEWLY_ADDED_POLICY_NAME,
							CoreConstants.PASS, policyName));
					policyFound = true;
					CoreFunctions.writeToPropertiesFile("pdtPolicyName", policyName);
					break;
				}
			}
			if (!policyFound) {
				Assert.fail(MessageFormat.format(IRISConstants.FAILED_TO_FIND_POLICY, CoreConstants.FAIL, policyName));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					IRISConstants.EXCEPTION_OCCURED_WHILE_SEARCHING_REQUIRED_POLICY_IN_POLICY_TABLE_OF_ACCOUNTING_TAB,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	public void addNewOnPointAutomationPolicies() throws Exception {
		for (int counter = 0; counter < 15; counter++) {
			Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Add", 0),
					IRIS_PageMaster.getButtonObject(_IRIS, "Add", 0).getAttachedText());
			Table policyTable = IRIS_PageMaster.getTableObject(_IRIS,
					"com.aires.iris.view.corporation.accounting.PolicyPanel$1");
			String policyName = IRISConstants.ONPOINT_AUTOMATION_POLICY + CoreFunctions.generateRandomString(5);
			policyTable.getCell(policyTable.getRows().size() - 1, PDTConstants.POLICY).setValue(policyName);
			policyTable.getCell(policyTable.getRows().size() - 1, "Tax Assistance Policy")
					.setValue("US Expat State & FICA only");
			policyTable.getCell(policyTable.getRows().size() - 1, "Tracing Set").setValue("Assignment");

			if ((policyTable.getCell(policyTable.getRows().size() - 1, "OnPoint Enabled").getValue().toString())
					.equals("0.0"))
				policyTable.getCell(policyTable.getRows().size() - 1, "OnPoint Enabled").click();

			Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Save"),
					IRIS_PageMaster.getButtonObject(_IRIS, "Save").getAttachedText());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS,
					IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save").getLabel()));
			acceptSaveConfirmation();
		}
	}
}