package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.iris.IRIS_AssignmentData;
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

	// Exit Button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'EXIT')]/parent::button")
	private WebElement _btnExit;

	// OK Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	private WebElement _btnOK;

	// Assignment History Icon
	@FindBy(how = How.CSS, using = "a[mattooltip='Assignment History']")
	private WebElement _btnAssignmentHistoryIcon;

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

	// Next Policy Page Button
	@FindBy(how = How.CSS, using = "li.next-item > a")
	private WebElement _btnNextPolicyPage;

	// Clone Policy Dialog
	@FindBy(how = How.XPATH, using = "//app-dialog-overview//span[contains(text(),'Clone Policy:')]")
	private WebElement _dialogClonePolicy;

	// Clone Policy Dialog - Reference Policy
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Reference Policy:')]/parent::p")
	private WebElement _labelReferencePolicy;

	// Clone Policy Dialog - Reference Client
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Reference Client:')]/parent::p")
	private WebElement _labelReferenceClient;

	// Clone Policy Dialog - Clone to: Client Text
	@FindBy(how = How.XPATH, using = "//app-dialog-overview//label[contains(text(),'Clone to: Client')]")
	private WebElement _labelCloneToClient;

	// Clone Policy Dialog - Clone to: Client Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='toCompanyId']")
	private WebElement _selectCloneToClient;

	// Clone Policy Dialog - Clone to: Client Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='toCompanyId'] span[class*='ng-value-label']")
	private WebElement _selectCloneToClientSelectedValue;

	// Clone Policy Dialog - Clone to: Client Select Options
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='toCompanyId'] div.ng-option")
	private List<WebElement> _selectCloneToClientOptionsList;

	// Clone Policy Dialog - Close Clone to: Client Select Options
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='toCompanyId'] span[class='ng-arrow-wrapper']")
	private WebElement _buttonCloseCloneToClientOptionsList;

	// Clone Policy Dialog - Clone to: Policy Text
	@FindBy(how = How.XPATH, using = "//app-dialog-overview//label[contains(text(),'Clone to: Policy')]")
	private WebElement _labelCloneToPolicy;

	// Clone Policy Dialog - Clone to: Policy Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='toCorporationPolicyId']")
	private WebElement _selectCloneToPolicy;

	// Clone Policy Dialog - Clone to: Policy Select Options
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='toCorporationPolicyId'] div.ng-option")
	private List<WebElement> _selectCloneToPolicyOptionsList;

	// Clone Policy Dialog - Close Clone to: Policy Select Options
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='toCorporationPolicyId'] span[class='ng-arrow-wrapper']")
	private WebElement _buttonCloseCloneToPolicyOptionsList;

	// Clone Policy Dialog - Clone to: Client Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='toCompanyId'] div.ng-placeholder")
	private WebElement _selectCloneToClientDefaultText;

	// Clone Policy Dialog - Clone to: Policy Select Field
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='toCorporationPolicyId'] div.ng-placeholder")
	private WebElement _selectCloneToPolicyDefaultText;

	// Save As Draft Button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'SAVE AS DRAFT')]/parent::button")
	private WebElement _buttonSaveAsDraft;

	// Cancel Button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'CANCEL')]/parent::button")
	private WebElement _buttonCancel;

	// View Policy Benefit
	@FindBy(how = How.CSS, using = "li.view-text a.nav-link > p")
	private WebElement _headingViewPolicyBenefit;

	// Assignment History - No Assignment Association Record
	@FindBy(how = How.XPATH, using = "//tfoot[@role='rowgroup']/mat-footer-row[not(@hidden)]/mat-footer-cell")
	private WebElement _textAssignmentHistoryNoRecords;

	// Assignment History - Export Button
	@FindBy(how = How.CSS, using = "div.exportbutton > button")
	private WebElement _buttonExportAssignmentHistory;

	// Assignment ID
	@FindBy(how = How.CSS, using = "td.mat-column-assignmentId")
	private WebElement _textAssignmentID;

	// Assignment Name
	@FindBy(how = How.CSS, using = "td.mat-column-transfereeName")
	private WebElement _textAssignmentName;

	// Assignment Status
	@FindBy(how = How.CSS, using = "td.mat-column-assignmentStatusCode")
	private WebElement _textAssignmentStatus;

	// Assignment Booked Date
	@FindBy(how = How.CSS, using = "td.mat-column-bookDate")
	private WebElement _textAssignmentBookedDate;

	// Assignment Origin Country
	@FindBy(how = How.CSS, using = "td.mat-column-originCountryName")
	private WebElement _textAssignmentOriginCountry;

	// Assignment Destination Country
	@FindBy(how = How.CSS, using = "td.mat-column-destCountryName")
	private WebElement _textAssignmentDestinationCountry;

	// Assignment MSPEC
	@FindBy(how = How.CSS, using = "td.mat-column-mspec")
	private WebElement _textAssignmentMSPEC;

	// Assignment PPC
	@FindBy(how = How.CSS, using = "td.mat-column-ppc")
	private WebElement _textAssignmentPPC;

	final By _listPolicyNameByLocator = By.cssSelector("h5.text-info.info-pname");
	final By _listClientNameByLocator = By.cssSelector("h6.info-pclient");
	long timeBeforeAction, timeAfterAction;

	IRIS_AssignmentData assignmentOverviewData = FileReaderManager.getInstance().getIrisJsonReader()
			.getAssignmentDataByTabName(IRISConstants.OVERVIEW);

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
		case COREFLEXConstants.NEXT:
			CoreFunctions.clickElement(driver, _btnNextPolicyPage);
			break;
		case COREFLEXConstants.EDIT_ICON:
			CoreFunctions.clickElement(driver, _btnEditIcon);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case COREFLEXConstants.ASSIGNMENT_HISTORY_ICON:
			CoreFunctions.clickElement(driver, _btnAssignmentHistoryIcon);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case COREFLEXConstants.SAVE_AS_DRAFT:
			CoreFunctions.clickElement(driver, _buttonSaveAsDraft);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case PDTConstants.CLEAR_FILTER:
			CoreFunctions.highlightElementAndClick(driver, _clearFilter, PDTConstants.CLEAR_FILTER);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case COREFLEXConstants.EXIT:
			CoreFunctions.clickElement(driver, _btnExit);
			break;
		case COREFLEXConstants.OK:
			CoreFunctions.clickElement(driver, _btnOK);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
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
		if (CoreFunctions.isElementExist(driver, _progressBar, 5))
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
			String actualPolicyStatusList = _listPolicyStatus.get(index).getText();
			String actualPolicyVersionList = _listPolicyVersion.get(index).getText();
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listPolicyName, selectedPolicyName));

			actualPolicyStatus = actualPolicyStatusList.split(":");
			isApprovedPolicyStatusVerified = (actualPolicyStatus[1].trim()).equals(expectedPolicyStatus);
			CoreFunctions.highlightObject(driver, _listPolicyStatus.get(index));

			actualPolicyVersion = actualPolicyVersionList.split(":");
			isApprovedPolicyVersionVerified = (actualPolicyVersion[1].trim()).equals(expectedPolicyVersion);
			CoreFunctions.highlightObject(driver, _listPolicyVersion.get(index));
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

	public int searchPolicyByStatus(String policyStatus) {
		int policyIndex = -1;
		try {
			policyIndex = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyStatus, policyStatus,
					true);
			if (policyIndex == -1) {
				while (policyIndex == -1) {
					clickElementOfPage(COREFLEXConstants.NEXT);
					policyIndex = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyStatus,
							policyStatus, true);
					if (policyIndex != -1) {
						captureReferencePolicyValues(policyIndex);
						return policyIndex;
					}
				}
			} else {
				CoreFunctions.highlightObject(driver, _listPolicyStatus.get(policyIndex));
				captureReferencePolicyValues(policyIndex);
				return policyIndex;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SEARCHING_POLICY_WITH_STATUS,
							CoreConstants.FAIL, e.getMessage(), policyStatus));
		}
		return policyIndex;
	}

	private void captureReferencePolicyValues(int policyIndex) {
		CoreFunctions.highlightObject(driver, _listPolicyStatus.get(policyIndex));
		CoreFunctions.writeToPropertiesFile("ClonePolicy_Reference_PolicyName",
				_listPolicyName.get(policyIndex).getText());
		CoreFunctions.writeToPropertiesFile("ClonePolicy_Reference_PolicyVersion",
				_listPolicyVersion.get(policyIndex).getText().replace("Version Number:", "").trim());
		CoreFunctions.writeToPropertiesFile("ClonePolicy_Reference_PolicyStatus",
				_listPolicyStatus.get(policyIndex).getText().replace("Policy Status:", "").trim());
		CoreFunctions.writeToPropertiesFile("ClonePolicy_Reference_Client",
				_listClientName.get(policyIndex).getText().trim());
	}

	public boolean verifyIconStatus(String iconName, int searchedPolicyIndex, String expectedIconStatus,
			String policyStatus) {
		String actualIconStatus = null;
		try {
			switch (iconName) {
			case COREFLEXConstants.CLONE_ICON:
				actualIconStatus = CoreFunctions.getAttributeText(_listCloneIcon.get(searchedPolicyIndex), "src")
						.contains("cloneDisable") ? COREFLEXConstants.DISABLED : COREFLEXConstants.ENABLED;
				CoreFunctions.highlightObject(driver, _listCloneIcon.get(searchedPolicyIndex));
				CoreFunctions.waitHandler(1);
				break;
			case COREFLEXConstants.ASSIGNMENT_HISTORY_ICON:
				actualIconStatus = CoreFunctions
						.getAttributeText(_listAssignmentHistoryIcon.get(searchedPolicyIndex), "src")
						.contains("disable") ? COREFLEXConstants.DISABLED : COREFLEXConstants.ENABLED;
				CoreFunctions.highlightObject(driver, _listAssignmentHistoryIcon.get(searchedPolicyIndex));
				CoreFunctions.waitHandler(1);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ICON_ENABLED_DISABLED_STATE_FOR_POLICY_WITH_STATUS,
					CoreConstants.FAIL, iconName, expectedIconStatus, policyStatus, e.getMessage()));
		}
		if (actualIconStatus.equalsIgnoreCase(expectedIconStatus)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_ICON_ENABLED_DISABLED_STATE_FOR_POLICY_STATUS,
					CoreConstants.PASS, iconName, expectedIconStatus, policyStatus));
			return true;
		}
		return false;
	}

	public void hoverIcon(String iconName, int searchedPolicyIndex) {
		try {
			switch (iconName) {
			case COREFLEXConstants.CLONE_ICON:
				CoreFunctions.moveToElement(driver, _listCloneIcon.get(searchedPolicyIndex));
				break;
			case COREFLEXConstants.ASSIGNMENT_HISTORY_ICON:
				CoreFunctions.moveToElement(driver, _listAssignmentHistoryIcon.get(searchedPolicyIndex));
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_HOVERING_OVER_ICON,
					CoreConstants.FAIL, iconName, e.getMessage()));
		}
	}

	public void searchPolicy(String policyName) {
		CoreFunctions.clearAndSetText(driver, _inputPolicyName, policyName);
		clickElementOfPage(COREFLEXConstants.SEARCH);
	}

	public boolean verifyCoreFlexClonePolicyDialog(String policyStatus, DataTable dataTable) {
		boolean isCFClonePolicyDialogVerified = false;
		try {
			if (CoreFunctions.isElementExist(driver, _dialogClonePolicy, 5)) {
				String expectedReferencePolicy = CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_PolicyName")
						+ " # " + CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_CorporationPolicyNum");
				String expectedReferenceClient = CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_Client");

				isCFClonePolicyDialogVerified = expectedReferencePolicy
						.equals(CoreFunctions.getElementText(driver, _labelReferencePolicy)
								.replace("Reference Policy:", "").trim())
						&& expectedReferenceClient.equals(CoreFunctions.getElementText(driver, _labelReferenceClient)
								.replace("Reference Client:", "").trim())
						&& verifyCloneToClientPolicyDefaultValues() && verifyClonePolicyDialogButtons();
			} else {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.CLONE_POLICY_DIALOG_NOT_DISPLAYED_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
						CoreConstants.FAIL, policyStatus));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CLONE_POLICY_DIALOG_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, policyStatus, e.getMessage()));
		}
		if (isCFClonePolicyDialogVerified) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_CLONE_POLICY_DIALOG,
					CoreConstants.PASS));
		}
		return isCFClonePolicyDialogVerified;
	}

	private boolean verifyClonePolicyDialogButtons() {
		return ((CoreFunctions.isElementExist(driver, _buttonSaveAsDraft, 2))
				&& (CoreFunctions.isElementExist(driver, _buttonCancel, 2)));
	}

	private boolean verifyCloneToClientPolicyDefaultValues() {
		boolean isCloneToClientPolicyFieldsExist, isCloneToClientVerified, isCloneToPolicyVerified,
				isCloneToClientPlaceHolderVerified, isCloneToClientPolicyDefaultValuesVerified = false;
		try {
			isCloneToClientPolicyFieldsExist = CoreFunctions.isElementExist(driver, _labelCloneToClient, 2)
					&& CoreFunctions.isElementExist(driver, _selectCloneToClient, 2)
					&& CoreFunctions.isElementExist(driver, _labelCloneToPolicy, 2)
					&& CoreFunctions.isElementExist(driver, _selectCloneToPolicy, 2);
			isCloneToClientPlaceHolderVerified = CoreFunctions.getElementText(driver, _selectCloneToClientDefaultText)
					.equals(COREFLEXConstants.SELECT_FIELD_PLACEHOLDER);
			CoreFunctions.clickElement(driver, _selectCloneToClient);
			isCloneToClientVerified = (_selectCloneToClientOptionsList.size() != -1)
					&& CoreFunctions.searchElementExistsInListByText(driver, _selectCloneToClientOptionsList,
							CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_Client").split("[(]")[0].trim())
					&& isCloneToClientPlaceHolderVerified;
			CoreFunctions.clickElement(driver, _buttonCloseCloneToClientOptionsList);
			CoreFunctions.clickElement(driver, _selectCloneToPolicy);
			isCloneToPolicyVerified = (_selectCloneToPolicyOptionsList.size() == 1)
					&& ((CoreFunctions.getElementText(driver, _selectCloneToPolicyOptionsList.get(0)))
							.equals(COREFLEXConstants.NO_ITEMS_FOUND));
			CoreFunctions.clickElement(driver, _buttonCloseCloneToPolicyOptionsList);
			isCloneToClientPolicyDefaultValuesVerified = isCloneToClientPolicyFieldsExist && isCloneToClientVerified
					&& isCloneToPolicyVerified;

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CLONE_TO_CLIENT_POLICY_DEFAULT_VALUES_OF_CLONE_POLICY_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCloneToClientPolicyDefaultValuesVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_CLONE_TO_CLIENT_POLICY_DEFAULT_VALUES_OF_CLONE_POLICY_DIALOG,
					CoreConstants.PASS));
		}
		return isCloneToClientPolicyDefaultValuesVerified;
	}

	public void clickCloneIconOfReferencePolicy(String policyStatus) {
		int versionIndex = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyVersion,
				CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_PolicyVersion"), true);
		if ((CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_Client")
				.equals(_listClientName.get(versionIndex).getText().trim()))
				&& (CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_PolicyName")
						.equals(_listPolicyName.get(versionIndex).getText()))
				&& (CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_PolicyVersion")
						.equals(_listPolicyVersion.get(versionIndex).getText().replace("Version Number:", "").trim()))
				&& (CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_PolicyStatus")
						.equals(_listPolicyStatus.get(versionIndex).getText().replace("Policy Status:", "").trim()))) {
			CoreFunctions.clickElement(driver, _listCloneIcon.get(versionIndex));
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_CLICK_ON_POLICY_ACTION_ICON_FOR_POLICY_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, COREFLEXConstants.CLONE_ICON, policyStatus));
			Assert.fail(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_CLICK_ON_POLICY_ACTION_ICON_FOR_POLICY_STATUS_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, COREFLEXConstants.CLONE_ICON, policyStatus));
		}
	}

	public void captureCorporationPolicyValue(int searchedPolicyIndex, String policyStatus,
			PDT_GeneralInformationPage generalInfoPage) {
		try {
			CoreFunctions.clickElement(driver, _listPolicyName.get(searchedPolicyIndex));
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
			CoreFunctions.waitHandler(4);
			String corporationPolicyValue = generalInfoPage.getElementText(COREFLEXConstants.CORPORATION_POLICY_NUMBER);
			CoreFunctions.writeToPropertiesFile("ClonePolicy_Reference_CorporationPolicyNum", corporationPolicyValue);
			generalInfoPage.clickElementOfPage(COREFLEXConstants.EXIT);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_CAPTURE_CORPORATION_POLICY_NUMBER_FOR_SELECTED_POLICY_WITH_STATUS,
					CoreConstants.FAIL, policyStatus));
			Assert.fail(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_CAPTURE_CORPORATION_POLICY_NUMBER_FOR_SELECTED_POLICY_WITH_STATUS,
					CoreConstants.FAIL, policyStatus));
		}
	}

	public boolean performCoreFlexCloneToClientPolicySelection(String clientType) {
		try {
			selectClientBasedOnType(clientType);
			selectFirstAvailableCloneToPolicy();
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_COREFLEX_CLONE_TO_CLIENT_POLICY_ON_CLONE_POLICY_DIALOG,
					CoreConstants.FAIL));
		}
		return false;
	}

	private void selectFirstAvailableCloneToPolicy() {
		if (!(CoreFunctions.getElementText(driver, _selectCloneToPolicyDefaultText))
				.equals(COREFLEXConstants.NO_POLICY_AVAILABLE_FOR_SELECTION)) {
			CoreFunctions.clickElement(driver, _selectCloneToPolicy);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _selectCloneToPolicyOptionsList);
			CoreFunctions.writeToPropertiesFile("ClonedPolicy_Policy_Name",
					_selectCloneToPolicyOptionsList.get(0).getText().split("\\(#")[0].trim());
			CoreFunctions.clickElement(driver, _selectCloneToPolicyOptionsList.get(0));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.POLICY_NOT_AVAILABLE_FOR_SELECTED_CLONE_TO_CLIENT_ON_CLONE_POLICY_DIALOG,
					CoreConstants.FAIL));
			Assert.fail(MessageFormat.format(
					COREFLEXConstants.POLICY_NOT_AVAILABLE_FOR_SELECTED_CLONE_TO_CLIENT_ON_CLONE_POLICY_DIALOG,
					CoreConstants.FAIL));
		}

	}

	private void selectClientBasedOnType(String clientType) {
		CoreFunctions.clickElement(driver, _selectCloneToClient);
		if (clientType.equals(COREFLEXConstants.EXISTING)) {
			CoreFunctions.selectItemInListByText(driver, _selectCloneToClientOptionsList,
					CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_Client").split("\\(")[0].trim());
		} else {
			selectCloneToDifferentClientName(_selectCloneToClientOptionsList);
		}
		String clonedClient[] = CoreFunctions.getElementText(driver, _selectCloneToClientSelectedValue).split("\\(#");
		CoreFunctions.writeToPropertiesFile("ClonedPolicy_Client_Name", clonedClient[0].trim());
		CoreFunctions.writeToPropertiesFile("ClonedPolicy_Client_ID", clonedClient[1].replace(")", "").trim());
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
	}

	private void selectCloneToDifferentClientName(List<WebElement> _selectCloneToClientOptionsList) {
		try {
			List<String> clientNamesList = _selectCloneToClientOptionsList.stream().map(x -> x.getText())
					.collect(Collectors.toList());
			for (String clientName : clientNamesList) {
				if (!(clientName.contains(
						CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_Client").split("\\(")[0].trim()))) {
					CoreFunctions.clickElement(driver, _selectCloneToClient);
					CoreFunctions.selectItemInListByText(driver, _selectCloneToClientOptionsList, clientName);
					CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
					if (!(CoreFunctions.getElementText(driver, _selectCloneToPolicyDefaultText))
							.equals(COREFLEXConstants.NO_POLICY_AVAILABLE_FOR_SELECTION)) {
						return;
					} else {
						CoreFunctions.clickElement(driver, _selectCloneToClient);
						continue;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_DIFFERENT_CLONE_TO_CLIENT_ON_CLONE_POLICY_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		Assert.fail(MessageFormat.format(
				COREFLEXConstants.POLICY_NOT_AVAILABLE_FOR_SELECTION_FOR_ANY_CLIENT_EXCEPT_REFERENCE_CLIENT_ON_CLONE_POLICY_DIALOG,
				CoreConstants.FAIL));
	}

	public boolean verifyPolicyStatusForVersion(String selectedPolicyName, String expectedStatus,
			String policyVersion) {
		boolean isPolicyStatusVerifiedForVersion = false;
		String actualPolicyStatus = null;
		try {
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
			CoreFunctions.clearAndSetText(driver, _inputPolicyName, selectedPolicyName);
			clickElementOfPage(COREFLEXConstants.SEARCH);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _listPolicyName);
			if (_listPolicyName.stream()
					.anyMatch(t -> t.getText().toLowerCase().equalsIgnoreCase(selectedPolicyName))) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_DISPLAYED_ON_PAGE,
						CoreConstants.PASS, PDTConstants.POLICY_NAME, selectedPolicyName,
						COREFLEXConstants.VIEW_EDIT_POLICY_FORMS));
				int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyVersion,
						policyVersion, true);
				actualPolicyStatus = CoreFunctions.getElementText(driver, _listPolicyStatus.get(index))
						.replace("Policy Status:", "").trim();
				isPolicyStatusVerifiedForVersion = actualPolicyStatus.equals(expectedStatus);
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_STATUS_AND_VERSION_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPolicyStatusVerifiedForVersion) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_STATUS_FOR_VERSION_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.PASS, expectedStatus, policyVersion, selectedPolicyName));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS_FOR_VERSION_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, expectedStatus, actualPolicyStatus));
		}
		return isPolicyStatusVerifiedForVersion;
	}

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyViewPolicyPageNavigation(String expectedPageName) {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		return CoreFunctions.verifyElementOnPage(driver, _headingViewPolicyBenefit,
				COREFLEXConstants.VIEW_POLICY_BENEFIT, expectedPageName, expectedPageName, true);
	}

	public boolean verifyRecordForNoAssignmentAssociation(String expectedText) {
		try {
			if ((CoreFunctions.getElementText(driver, _textAssignmentHistoryNoRecords).trim()).equals(expectedText)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_ASSIGNMENT_HISTORY_RECORD_FOR_NO_ASSIGNMENT_ASSOCIATION,
						CoreConstants.PASS, expectedText));
				return true;
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ASSIGNMENT_HISTORY_RECORD_FOR_NO_ASSIGNMENT_ASSOCIATION,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyExportButtonDisplayed(String buttonName) {
		return CoreFunctions.isElementExist(driver, _buttonExportAssignmentHistory, 3);
	}

	public boolean verifyRecordForAssignmentAssociation(DataTable dataTable) {
		boolean isAssignmentDetailsVerified = false;
		List<String> columnList = dataTable.asList(String.class);
		try {
			for (String columnName : columnList) {
				isAssignmentDetailsVerified = verifyAssignmentHistoryColumnData(columnName);
				if (!isAssignmentDetailsVerified) {
					Reporter.addStepLog(MessageFormat.format(
							COREFLEXConstants.ASSIGNMENT_HISTORY_DATA_NOT_MATCHED_ON_ASSIGNMENT_HISTORY_PAGE,
							CoreConstants.FAIL, columnName));
					break;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ASSIGNMENT_HISTORY_RECORD_FOR_NO_ASSIGNMENT_ASSOCIATION,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isAssignmentDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_ASSIGNMENT_DETAILS_ON_ASSIGNMENT_HISTORY_VIEW_POLICY_BENEFIT_PAGE,
					CoreConstants.PASS));
		}
		return isAssignmentDetailsVerified;
	}

	private boolean verifyAssignmentHistoryColumnData(String columnName) {
		boolean isAssignmentColumnDataMatched = false;
		try {
			switch (columnName) {
			case COREFLEXConstants.ASSIGNMENT_ID:
				isAssignmentColumnDataMatched = (CoreFunctions.getElementText(driver, _textAssignmentID)
						.equals(CoreFunctions.getPropertyFromConfig("Assignment_FileID")));
				break;
			case COREFLEXConstants.TRANSFEREE_NAME:
				isAssignmentColumnDataMatched = (CoreFunctions.getElementText(driver, _textAssignmentName)
						.equals((CoreFunctions.getPropertyFromConfig("Transferee_firstName")) + " "
								+ (CoreFunctions.getPropertyFromConfig("Transferee_lastName"))));
				break;
			case COREFLEXConstants.ASSIGNMENT_STATUS:
				isAssignmentColumnDataMatched = (CoreFunctions.getElementText(driver, _textAssignmentStatus)
						.equals(COREFLEXConstants.ACTIVE));
				break;
			case COREFLEXConstants.BOOKED_DATE:
				isAssignmentColumnDataMatched = (CoreFunctions.getElementText(driver, _textAssignmentBookedDate)
						.equals(CoreFunctions.getPropertyFromConfig("Assignment_ActualizationDate")));
				break;
			case COREFLEXConstants.ORIGIN_COUNTRY:
				isAssignmentColumnDataMatched = (CoreFunctions.getPropertyFromConfig("Assignment_OriginAddress")
						.contains(CoreFunctions.getElementText(driver, _textAssignmentOriginCountry)));
				break;
			case COREFLEXConstants.DESTINATION_COUNTRY:
				isAssignmentColumnDataMatched = (CoreFunctions.getPropertyFromConfig("Assignment_DestinationAddress")
						.contains(CoreFunctions.getElementText(driver, _textAssignmentDestinationCountry)));
				break;
			case COREFLEXConstants.MSPEC_NAME:
				isAssignmentColumnDataMatched = (CoreFunctions.getElementText(driver, _textAssignmentMSPEC)
						.equals(assignmentOverviewData.airesFileTeamHistory.empNameMSPEC));
				break;
			case COREFLEXConstants.PPC_NAME:
				isAssignmentColumnDataMatched = (CoreFunctions.getElementText(driver, _textAssignmentPPC)
						.equals(assignmentOverviewData.airesFileTeamHistory.empNamePPC));
				break;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ASSIGNMENT_HISTORY_COLUMN_DATA,
					CoreConstants.FAIL, columnName, e.getMessage()));
		}
		return isAssignmentColumnDataMatched;
	}
}
