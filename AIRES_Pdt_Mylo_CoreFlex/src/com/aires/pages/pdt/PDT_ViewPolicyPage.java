package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class PDT_ViewPolicyPage extends Base {
	public PDT_ViewPolicyPage(WebDriver driver) {
		super(driver);
	}

	// View/Edit Policy Forms
	@FindBy(how = How.CSS, using = "h4.card-title")
	private WebElement _headingViewEditPolicyForm;

	// User name
	@FindBy(how = How.CSS, using = "a.nav-link.nav_username")
	private WebElement _userName;

	// Logout
	@FindBy(how = How.CSS, using = "i.material-icons.dp48")
	private WebElement _logout;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	// Edit Icon
	@FindBy(how = How.CSS, using = "img.formicon")
	private List<WebElement> _iconEdit;

	// Edit Icon
	@FindBy(how = How.CSS, using = "img.formicon")
	private List<WebElement> _txtPolicyName;

	// Left Menu - Add New Policy
	@FindBy(how = How.XPATH, using = "//a[contains(string(),'Add New Policy Form')]")
	private WebElement _addNewPolicyForm;

	// Left Menu - View Edit Policy
	@FindBy(how = How.XPATH, using = "//a[contains(string(),'View/Edit Policy Forms')]")
	private WebElement _viewEditPolicyForm;

	// Input Client/Company Name field
	@FindBy(how = How.ID, using = "companyName")
	private WebElement _inputClientName;

	// Input ClientId field
	@FindBy(how = How.ID, using = "companyId")
	private WebElement _inputClientId;

	// Input Policy Name
	@FindBy(how = How.ID, using = "policyName")
	private WebElement _inputPolicyName;

	// Policies List
	@FindBy(how = How.CSS, using = "h5.text-info.info-pname")
	private List<WebElement> _listPolicyName;

	// Client Name list
	@FindBy(how = How.CSS, using = "h6.info-pclient")
	private List<WebElement> _listClientName;

	// Search Button
	@FindBy(how = How.CSS, using = "button.searchbtn")
	private WebElement _btnSearch;

	// Edit Policy Icon
	@FindBy(how = How.CSS, using = "a[mattooltip='Edit Policy']")
	private WebElement _btnEditIcon;

	// Search Button
	@FindBy(how = How.CSS, using = "a.clear_filter")
	private WebElement _clearFilter;

	// Version Control Dialog
	@FindBy(how = How.CSS, using = "app-dialog-version-control")
	private WebElement _dialogVersionContol;

	// Version Control Dialog text
	@FindBy(how = How.CSS, using = "div.msg-2")
	private List<WebElement> _textVersionContolDialog;

	// Version Control Dialog - Next Version Number
	@FindBy(how = How.CSS, using = "div.control-label > p")
	private WebElement _textVersionContolDialogNextVersionNumber;

	// Version Control Dialog - Description Input
	@FindBy(how = How.CSS, using = "input[formcontrolname='description']")
	private WebElement _inputVersionContolDialogDescription;

	// Create Button
	@FindBy(how = How.XPATH, using = "//button[contains(string(),'CREATE')]")
	private WebElement _btnVersionControlCreate;

	// Add new Policy Form link
	@FindBy(how = How.XPATH, using = "//p[text()='Add New Policy Form']")
	private WebElement _lnkAddNewPolicyForm;

	// Policies Status List
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Policy Status')]/parent::h6")
	private List<WebElement> _listPolicyStatus;

	// Policies Version List
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Version Number')]/parent::h6")
	private List<WebElement> _listPolicyVersion;

	// Policy Edit Icon List
	@FindBy(how = How.CSS, using = "div.icons-action a[mattooltip='Edit Policy']>img")
	private List<WebElement> _listEditIcon;

	// Policy Delete Icon List
	@FindBy(how = How.CSS, using = "div.icons-action a[mattooltip='Delete Policy']>img")
	private List<WebElement> _listDeleteIcon;

	// Policy Clone Icon List
	@FindBy(how = How.CSS, using = "div.icons-action a[mattooltip='Clone Policy']>img")
	private List<WebElement> _listCloneIcon;

	// Policy Assignment History Icon List
	@FindBy(how = How.CSS, using = "div.icons-action a[mattooltip='Assignment History']>img")
	private List<WebElement> _listAssignmentHistoryIcon;

	final By _listPolicyNameByLocator = By.cssSelector("h5.text-info.info-pname");
	final By _listClientNameByLocator = By.cssSelector("h6.info-pclient");
	long timeBeforeAction, timeAfterAction;

	public String getElementText(String elementName) {
		String elementText = null;

		switch (elementName) {
		case PDTConstants.HEADING:
			elementText = _headingViewEditPolicyForm.getText();
			break;
		case PDTConstants.USERNAME:
			elementText = _userName.getText();
			break;
		default:
			Assert.fail("Element not found");
		}
		return elementText;

	}

	public void clickElementOfPage(String elementName) {
		switch (elementName) {
		case PDTConstants.LOGOUT:
			CoreFunctions.clickElement(driver, _logout);
			break;
		case PDTConstants.ADD_NEW_POLICY_FORM:
			CoreFunctions.clickUsingJS(driver, _addNewPolicyForm, PDTConstants.ADD_NEW_POLICY_FORM);
			if (CoreFunctions.isElementExist(driver, _progressBar, 4))
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			break;
		case PDTConstants.VIEW_EDIT_POLICY_FORMS:
			CoreFunctions.clickElement(driver, _viewEditPolicyForm);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case COREFLEXConstants.SEARCH:
			CoreFunctions.clickElement(driver, _btnSearch);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case COREFLEXConstants.CREATE:
			CoreFunctions.clickElement(driver, _btnVersionControlCreate);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case COREFLEXConstants.EDIT_ICON:
			CoreFunctions.clickElement(driver, _btnEditIcon);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case PDTConstants.CLEAR_FILTER:
			CoreFunctions.highlightElementAndClick(driver, _clearFilter, PDTConstants.CLEAR_FILTER);
			break;
		default:
			Assert.fail("Element not found");
		}
	}

	public String getUserName() {
		String userArray[] = _userName.getText().split("\n");
		return userArray[1].trim();
	}

	public Boolean verifyUserlogin(String userName, String pageName) {
		if (CoreFunctions.isElementExist(driver, _progressBar, 2))
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		if (getUserName().contains(userName)) {
			CoreFunctions.highlightObject(driver, _userName);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_USERNAME_IS_DISPLAYED, CoreConstants.PASS,
					userName, pageName));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL, pageName,
				userName, getUserName()));
		return false;
	}

	public Boolean verifyViewPolicyHeading(String pageName) {
		timeBeforeAction = new Date().getTime();
		if (CoreFunctions.isElementExist(driver, _progressBar, 2))
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, PDTConstants.VIEW_POLICY_PAGE);
		return CoreFunctions.verifyElementOnPage(driver, _headingViewEditPolicyForm, PDTConstants.heading,
				PDTConstants.VIEW_EDIT_POLICY_FORMS, pageName, true);
	}

	public boolean verifyPoliciesAreDisplayed(String pageName) {
		timeBeforeAction = new Date().getTime();
		if (CoreFunctions.isElementExist(driver, _progressBar, 2))
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, PDTConstants.VIEW_POLICY_PAGE);
		if (_txtPolicyName.size() > 0) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.POLICIES_ARE_DISPLAYED, CoreConstants.PASS, pageName));
			clickElementOfPage(PDTConstants.LOGOUT);
			return true;
		}
		return false;
	}

	public void performSearchOperation(Map<String, String> policyDetails, String pageName) {
		switch (policyDetails.get("SearchBy")) {
		case PDTConstants.CLIENT_ID:
			CoreFunctions.clearAndSetText(driver, _inputClientId, policyDetails.get("SearchText"));
			CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			Assert.assertTrue(
					verifyClientIdAndCompanyName(policyDetails.get("SearchText"), policyDetails.get("CompanyName"),
							pageName),
					MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_CLIENT_ID_COMPANY_NAME, CoreConstants.FAIL,
							policyDetails.get("SearchText"), policyDetails.get("CompanyName"), pageName));
			break;
		case PDTConstants.CLIENT_NAME:
			CoreFunctions.clearAndSetText(driver, _inputClientName, policyDetails.get("SearchText"));
			CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			Assert.assertTrue(
					verifyClientIdAndCompanyName(policyDetails.get("ClientId"), policyDetails.get("SearchText"),
							pageName),
					MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_CLIENT_ID_COMPANY_NAME, CoreConstants.FAIL,
							policyDetails.get("ClientId"), policyDetails.get("SearchText"), pageName));
			break;
		case PDTConstants.POLICY:
			CoreFunctions.clearAndSetText(driver, _inputPolicyName, policyDetails.get("SearchText"));
			CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			Assert.assertTrue(verifyPolicyName(policyDetails.get("SearchText"), pageName),
					MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_POLICY_NAME_ON_PAGE, CoreConstants.FAIL,
							policyDetails.get("SearchText"), pageName));
			Assert.assertTrue(
					verifyClientIdAndCompanyName(policyDetails.get("ClientId"), policyDetails.get("CompanyName"),
							pageName),
					MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_CLIENT_ID_COMPANY_NAME, CoreConstants.FAIL,
							policyDetails.get("ClientId"), policyDetails.get("CompanyName"), pageName));
			break;
		}
	}

	public boolean verifyClientIdAndCompanyName(String clientId, String companyName, String pageName) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _listClientName);
		if (_listClientName.stream().allMatch(t -> t.getText().contains(clientId))
				&& _listClientName.stream().allMatch(t -> t.getText().toString().contains(companyName.toString()))) {
			_listClientName.stream().forEach(t -> {
				CoreFunctions.moveToElement(driver, t);
				CoreFunctions.highlightObject(driver, t);
			});
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_CLIENT_ID_COMPANY_NAME, CoreConstants.PASS,
					clientId, companyName, pageName));
			return true;
		}
		return false;
	}

	public boolean verifyPolicyName(String policyName, String pageName) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _listClientName);
		if (_listPolicyName.stream().allMatch(t -> t.getText().toLowerCase().equalsIgnoreCase(policyName))) {
			_listPolicyName.stream().forEach(t -> {
				CoreFunctions.moveToElement(driver, t);
				CoreFunctions.highlightObject(driver, t);
			});
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_POLICY_NAME_ON_PAGE, CoreConstants.PASS,
					policyName, pageName));
			return true;
		}
		return false;
	}

	public void iteratePolicyData(List<Map<String, String>> policyData, String pageName) {
		for (int i = 0; i < policyData.size(); i++) {
			performSearchOperation(policyData.get(i), pageName);
			clickElementOfPage(PDTConstants.CLEAR_FILTER);
		}
	}

	public boolean searchAndVerifyPolicy(String policyName, String pageName, PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			// CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver,
			// _progressBar, 5);
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			CoreFunctions.isElementByLocatorExist(driver, _listPolicyNameByLocator, 20);
			if (_listPolicyName.stream().anyMatch(t -> t.getText().toLowerCase().equalsIgnoreCase(policyName))) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_DISPLAYED_ON_PAGE,
						CoreConstants.PASS, PDTConstants.POLICY_NAME, policyName, pageName));
				return true;
			}
		} catch (Exception e) {
			Assert.fail("Failed to search Policy:-" + policyName);
		}
		return false;
	}

	public List<String> getPolicyList() {
		return CoreFunctions.getElementTextAndStoreInList(driver, _listPolicyName);
	}

	public boolean verifyApprovedPolicyStatusAndVersion(String selectedPolicyName, String expectedPolicyStatus,
			String expectedPolicyVersion) {
		boolean isApprovedPolicyStatusVerified, isApprovedPolicyVersionVerified, isApprovedPolicyVerified = false;
		String[] actualPolicyStatus = null, actualPolicyVersion = null;
		try {
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyName, selectedPolicyName);
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listPolicyName, selectedPolicyName));

			String actualPolicyStatusList = _listPolicyStatus.get(index).getText();
			actualPolicyStatus = actualPolicyStatusList.split(":");
			isApprovedPolicyStatusVerified = (actualPolicyStatus[1].trim()).equals(expectedPolicyStatus);
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listPolicyStatus, (actualPolicyStatus[1].trim())));

			String actualPolicyVersionList = _listPolicyVersion.get(index).getText();
			actualPolicyVersion = actualPolicyVersionList.split(":");
			isApprovedPolicyVersionVerified = (actualPolicyVersion[1].trim()).equals(expectedPolicyVersion);
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listPolicyVersion, (actualPolicyVersion[1].trim())));
			CoreFunctions.writeToPropertiesFile("CoreFlex_PolicyVersion", actualPolicyVersion[1].trim());
			isApprovedPolicyVerified = isApprovedPolicyStatusVerified && isApprovedPolicyVersionVerified;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_STATUS_AND_VERSION_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isApprovedPolicyVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_STATUS_AND_VERSION_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.PASS, expectedPolicyStatus, expectedPolicyVersion, selectedPolicyName));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS_AND_VERSION_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, expectedPolicyStatus, actualPolicyStatus[1].trim(), expectedPolicyVersion,
					actualPolicyVersion[1].trim()));
		}
		return isApprovedPolicyVerified;
	}

	public boolean verifySubmittedPolicyStatus(String selectedPolicyName, String expectedPolicyStatus) {
		boolean isSubmittedPolicyStatusVerified = false;
		String[] actualPolicyStatus = null;
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyName, selectedPolicyName);
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listPolicyName, selectedPolicyName));
			String actualPolicyStatusList = _listPolicyStatus.get(index).getText();
			actualPolicyStatus = actualPolicyStatusList.split(":");
			isSubmittedPolicyStatusVerified = (actualPolicyStatus[1].trim()).equals(expectedPolicyStatus);
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listPolicyStatus, (actualPolicyStatus[1].trim())));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedPolicyStatusVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.PASS, expectedPolicyStatus, selectedPolicyName));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE, CoreConstants.FAIL,
					expectedPolicyStatus, actualPolicyStatus[1].trim()));
		}
		return isSubmittedPolicyStatusVerified;
	}

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		return CoreFunctions.verifyElementOnPage(driver, _headingViewEditPolicyForm, COREFLEXConstants.VIEW_EDIT_POLICY,
				expectedPageName, expectedPageName, true);
	}

	public boolean searchAndVerifyPolicy(String policyName, String pageName) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputPolicyName, policyName);
			clickElementOfPage(COREFLEXConstants.SEARCH);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _listPolicyName);
			if (_listPolicyName.stream().anyMatch(t -> t.getText().toLowerCase().equalsIgnoreCase(policyName))) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_DISPLAYED_ON_PAGE,
						CoreConstants.PASS, PDTConstants.POLICY_NAME, policyName, pageName));

				return true;
			}
		} catch (Exception e) {
			Assert.fail("Failed to search Policy:-" + policyName);
		}
		return false;
	}

	public boolean isVersionControlDialogDisplayed() {
		if (CoreFunctions.isElementExist(driver, _dialogVersionContol, 5)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_VERSION_CONTROL_DIALOG_DISPLAYED_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.PASS));
			return true;
		} else
			return false;
	}

	public boolean verifyVersionControlDialog() {
		try {
			String expectedNewPolicyVersionString = getNextPolicyVersion(
					CoreFunctions.getPropertyFromConfig("CoreFlex_PolicyVersion"));
			CoreFunctions.verifyText(driver, _textVersionContolDialog.get(0),
					(COREFLEXConstants.VERSION_CONTROL_DIALOG_VERSION_ASSIGNMENT_EXPECTED_TEXT.replace("PV",
							CoreFunctions.getPropertyFromConfig("CoreFlex_PolicyVersion"))),
					COREFLEXConstants.VERSION_CONTROL_DIALOG);
			CoreFunctions.verifyText(driver, _textVersionContolDialog.get(1),
					COREFLEXConstants.VERSION_CONTROL_DIALOG_PROCESS_INFORMATION_EXPECTED_TEXT,
					COREFLEXConstants.VERSION_CONTROL_DIALOG);
			String[] actualPolicyVersion = CoreFunctions
					.getElementText(driver, _textVersionContolDialogNextVersionNumber).split(":");
			CoreFunctions.verifyText(actualPolicyVersion[1].trim(), expectedNewPolicyVersionString);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_VERSION_CONTROL_DIALOG_ASSIGNMENT_PROCESS_AND_VERSION_TEXT,
					CoreConstants.PASS));
			return true;

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_VERSION_CONTROL_DIALOG_CONTENTS,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	public String getNextPolicyVersion(String approvedPolicyVersion) {
		int nextPolicyVersion = Integer.parseInt(approvedPolicyVersion.replace("V", "").trim()) + 1;
		return ("V" + nextPolicyVersion).trim();
	}

	public void enterVersionControlDialogDescription() {
		CoreFunctions.clearAndSetText(driver, _inputVersionContolDialogDescription,
				COREFLEXConstants.VERSION_CONTROL_DESCRIPTION);
	}

	public void navigateToGeneralInfoPage(String selectedPolicyName, String pageName) {
		try {
			timeBeforeAction = new Date().getTime();
			CoreFunctions.clickElement(driver,
					CoreFunctions.getElementFromListByText(_listPolicyName, selectedPolicyName));
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_PAGE, PDTConstants.GENERAL_INFORMATION,
					CoreConstants.FAIL));
		}
	}

	public boolean verifyPolicyIconsStatus(String versioning, String policyStatus, DataTable dataTable) {
		boolean isPolicyIconsVerified = false;
		try {
			switch (versioning) {
			case COREFLEXConstants.POST:
				isPolicyIconsVerified = verifyPolicyActionIconsPostVersioning(dataTable);
				break;
			case COREFLEXConstants.PRE:
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_ICONS_ENABLED_DISABLED_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isPolicyIconsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_ICONS_ENABLED_DISABLED_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.PASS));
		}
		return isPolicyIconsVerified;
	}

	private boolean verifyPolicyActionIconsPostVersioning(DataTable dataTable) {
		boolean isPolicyActionIconsVerified = false;
		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> dataList : dataMap) {
			String policyVersion = dataList.get("PolicyVersion");
			int versionIndex = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyVersion,
					policyVersion, true);
			CoreFunctions.highlightObject(driver, _listPolicyVersion.get(versionIndex));
			CoreFunctions.highlightObject(driver, _listPolicyStatus.get(versionIndex));
			isPolicyActionIconsVerified = verifyPolicyIconsStatus(versionIndex, dataList);
			if (!isPolicyActionIconsVerified) {
				return false;
			}
		}
		return isPolicyActionIconsVerified;
	}

	private boolean verifyPolicyIconsStatus(int versionIndex, Map<String, String> dataList) {
		try {
			String actualEditIconStatus = CoreFunctions.getAttributeText(_listEditIcon.get(versionIndex), "src")
					.contains("Pencildisable") ? COREFLEXConstants.DISABLED : COREFLEXConstants.ENABLED;
			CoreFunctions.highlightObject(driver, _listEditIcon.get(versionIndex));
			String actualDeleteIconStatus = CoreFunctions.getAttributeText(_listDeleteIcon.get(versionIndex), "src")
					.contains("Trash") ? COREFLEXConstants.DISABLED : COREFLEXConstants.ENABLED;
			CoreFunctions.highlightObject(driver, _listDeleteIcon.get(versionIndex));
			String actualCloneIconStatus = CoreFunctions.getAttributeText(_listCloneIcon.get(versionIndex), "src")
					.contains("cloneDisable") ? COREFLEXConstants.DISABLED : COREFLEXConstants.ENABLED;
			CoreFunctions.highlightObject(driver, _listCloneIcon.get(versionIndex));
			String actualAssignmentHistoryIconStatus = CoreFunctions
					.getAttributeText(_listAssignmentHistoryIcon.get(versionIndex), "src").contains("disable")
							? COREFLEXConstants.DISABLED
							: COREFLEXConstants.ENABLED;
			CoreFunctions.highlightObject(driver, _listAssignmentHistoryIcon.get(versionIndex));
			CoreFunctions.verifyText(actualEditIconStatus, dataList.get("EditIcon"), COREFLEXConstants.EDIT_ICON);
			CoreFunctions.verifyText(actualDeleteIconStatus, dataList.get("DeleteIcon"), COREFLEXConstants.DELETE_ICON);
			CoreFunctions.verifyText(actualCloneIconStatus, dataList.get("CloneIcon"), COREFLEXConstants.CLONE_ICON);
			CoreFunctions.verifyText(actualAssignmentHistoryIconStatus, dataList.get("AssignmentHistoryIcon"),
					COREFLEXConstants.ASSIGNMENT_HISTORY_ICON);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.POLICY_ICONS_ENABLED_DISABLED_STATUS_NOT_AS_EXPECTED_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL));
			return false;
		}
	}

	public void clickPolicyActionIcon(String iconName, String policyVersion, String policyStatus) {
		try {
			int versionIndex = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyVersion,
					policyVersion, true);
			switch (iconName) {
			case COREFLEXConstants.EDIT_ICON:
				CoreFunctions.clickElement(driver, _listEditIcon.get(versionIndex));
				CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
				break;
			case COREFLEXConstants.DELETE_ICON:
				CoreFunctions.clickElement(driver, _listDeleteIcon.get(versionIndex));
				CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
				break;
			case COREFLEXConstants.CLONE_ICON:
				CoreFunctions.clickElement(driver, _listCloneIcon.get(versionIndex));
				CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
				break;
			case COREFLEXConstants.ASSIGNMENT_HISTORY_ICON:
				CoreFunctions.clickElement(driver, _listAssignmentHistoryIcon.get(versionIndex));
				CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_CLICK_ON_POLICY_ACTION_ICON_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, iconName, policyVersion));
			Assert.fail(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_CLICK_ON_POLICY_ACTION_ICON_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, iconName, policyVersion));
		}

	}

}
