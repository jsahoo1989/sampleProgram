package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.LinkedHashMap;
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
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.iris.IRIS_AssignmentData;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
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
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'EXIT')] | //button/span[contains(text(),'EXIT')] ")
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

	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Version Number')]/parent::h6")
	private List<WebElement> _listVersionNo;

	// Policies Version List
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Version Number')]/parent::h6")
	private List<WebElement> _listPolicyVersion;

	@FindBy(how = How.CSS, using = "img[src*='ClockCounterClockwise_Open.png']")
	private List<WebElement> _listAssignmentHistoryEnableIcon;

	@FindBy(how = How.CSS, using = "div.msg-2>p")
	private List<WebElement> _msgVersionPopUp;

	@FindBy(how = How.CSS, using = "div.control-label")
	private WebElement _versionText;

	@FindBy(how = How.XPATH, using = "//span[text()='CREATE']/parent::button[@disabled='true']")
	private WebElement _btnCreateDisabled;

	@FindBy(how = How.XPATH, using = "//span[text()='CREATE']/parent::button")
	private WebElement _btnCreate;

	@FindBy(how = How.XPATH, using = "//span[text()='CANCEL']/parent::button")
	private WebElement _btnCancel;

	@FindBy(how = How.CSS, using = "img[src='assets/img/Vectoreditimg.png']")
	private List<WebElement> _listEditEnableIcon;

	@FindBy(how = How.CSS, using = "img[src*='Info.png']")
	private WebElement _imgInfoIcon;

	@FindBy(how = How.CSS, using = "textarea[formcontrolname='description']")
	private WebElement _txtAreaDescription;

	@FindBy(how = How.CSS, using = "input[formcontrolname='description']")
	private WebElement _inputDescription;

	@FindBy(how = How.CSS, using = "img[src='assets/img/vectorcopy.png']")
	private List<WebElement> _listCloneEnableIcon;

	@FindBy(how = How.CSS, using = "img[src='assets/img/cloneDisable.png']")
	private List<WebElement> _listCloneDisableIcon;

	@FindBy(how = How.CSS, using = "img[src='assets/img/approveDisable.png']")
	private List<WebElement> _listApprovePolicyDisableIcon;

	@FindBy(how = How.CSS, using = "img[src='assets/img/Trash.png']")
	private List<WebElement> _listDeleteDisableIcon;

	@FindBy(how = How.CSS, using = "img[src='assets/img/VectorDel.png']")
	private List<WebElement> _listDeleteEnableIcon;

	@FindBy(how = How.CSS, using = "img[src='assets/img/ClockCounterClockwise_disable.png']")
	private List<WebElement> _listAssignmentHistoryDisableIcon;

	@FindBy(how = How.CSS, using = "img[src='assets/img/Pencildisable.png']")
	private List<WebElement> _listEditDisableIcon;

	@FindBy(how = How.CSS, using = "img[src='assets/img/vectorApprove.png']")
	private List<WebElement> _listApprovePolicyEnableIcon;

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

	// Assignment PPC
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='toCorporationPolicyId'] input")
	private WebElement _inputClonePolicy;

	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Version Number')]/parent::label/following-sibling::label")
	private WebElement _versionNumber;

	// Core Flex Word
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Points Based Flex Policy')]")
	private WebElement _textCoreFlex;

	@FindBy(how = How.XPATH, using = "//strong[text()='Policy Status:']/parent::h6/span/i | //strong[text()='Policy Status:']/parent::h6[contains(text(),'Active')] | //strong[text()='Policy Status:']/parent::h6[contains(text(),'Legacy')]")
	private List<WebElement> _policyStatusIndicator;

	// Edit Policy benefit page Header
	@FindBy(how = How.CSS, using = "div.sidebar-wrapper li.nav-item a.nav-link > p")
	private WebElement _headingEditPolicyBenefit;

	// Exit Button
	@FindBy(how = How.CSS, using = "button[class*='btn-exit']")
	private WebElement _buttonExit;

	// Approve Policy Icon List
	@FindBy(how = How.CSS, using = "div.icons-action a[mattooltip='Approve Policy']>img")
	private List<WebElement> _listApprovePolicyIcon;
	LinkedHashMap<String, List<WebElement>> iconMap = new LinkedHashMap<String, List<WebElement>>();
	LinkedHashMap<String, WebElement> webElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> webElementsTextMap = new LinkedHashMap<String, String>();

	final By _listPolicyNameByLocator = By.cssSelector("h5.text-info.info-pname");
	final By _listClientNameByLocator = By.cssSelector("h6.info-pclient");
	long timeBeforeAction, timeAfterAction;
	int policySearchIndex;

	IRIS_AssignmentData assignmentOverviewData = FileReaderManager.getInstance().getIrisJsonReader()
			.getAssignmentDataByTabName(IRISConstants.OVERVIEW);

	public void clickElementOfPage(String elementName) {
		switch (elementName) {
		case PDTConstants.LOGOUT:
			CoreFunctions.clickElement(driver, _logout);
			break;
		case PDTConstants.ADD_NEW_POLICY_FORM:
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _listPolicyName);
//			CoreFunctions.clickUsingJS(driver, _addNewPolicyForm, PDTConstants.ADD_NEW_POLICY_FORM);
			CoreFunctions.clickElement(driver, _addNewPolicyForm);
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
//			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case PDTConstants.CLEAR_FILTER:
			CoreFunctions.highlightElementAndClick(driver, _clearFilter, PDTConstants.CLEAR_FILTER);
//			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case COREFLEXConstants.EXIT:
			CoreFunctions.clickElement(driver, _btnExit);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 10);
			break;
		case COREFLEXConstants.OK:
			CoreFunctions.clickElement(driver, _btnOK);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			break;
		case COREFLEXConstants.ASSIGNMENT_POLICY:
			CoreFunctions.clickElement(driver, CoreFunctions.getElementFromListByText(_listPolicyName,
					CoreFunctions.getPropertyFromConfig("Assignment_Policy")));
			break;
		default:
			Assert.fail("Element not found");
		}
	}

	public void populateIconMap() {
		iconMap.put(PDTConstants.ICON_ASSIGNMENT_HISTORY, _listAssignmentHistoryEnableIcon);
		iconMap.put(PDTConstants.ICON_EDIT, _listEditEnableIcon);
	}

	public void initWebElementsMap() {
		webElementsMap.put(PDTConstants.LOGOUT, _logout);
		webElementsMap.put(PDTConstants.ADD_NEW_POLICY_FORM, _addNewPolicyForm);
		webElementsMap.put(PDTConstants.CLEAR_FILTER, _clearFilter);
	}

	public void initWebElementsTextMap() {
		webElementsTextMap.put(PDTConstants.HEADING, _headingViewEditPolicyForm.getText());
		webElementsTextMap.put(PDTConstants.USERNAME, _userName.getText());
	}

	public String getElementText(String elementName) {
		String elementText = null;
		initWebElementsTextMap();
		try {
			elementText = webElementsTextMap.get(elementName);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return elementText;
	}

	public void clickElementOfPage(String elementName, String pageName) {
		try {
			initWebElementsMap();
			CoreFunctions.clickUsingJS(driver, webElementsMap.get(elementName), elementName);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK, elementName, pageName));
		}
	}

	public String getUserName() {
		String userName = "";
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _userName, _userName.getText().split("\n")[1]);
			userName = _userName.getText().substring(_userName.getText().indexOf("\n") + 1,
					_userName.getText().length());
		} catch (Exception e) {
			Assert.fail("Failed to get username");
		}
		return userName;
	}

	public Boolean verifyUserlogin(String userName, String pageName) {
		BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _userName, _userName.getText().split("\n")[1]);
		if (getUserName().contains(userName)) {
			CoreFunctions.highlightObject(driver, _userName);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_USERNAME_IS_DISPLAYED, CoreConstants.PASS,
					userName, pageName));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL, pageName,
				userName, CoreFunctions.getElementText(driver, _userName)));
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
			clickElementOfPage(PDTConstants.LOGOUT, pageName);
			return true;
		}
		return false;
	}

	public void enterSearchCriteria(WebElement element, String searchText) {
		try {
			CoreFunctions.clearAndSetText(driver, element, searchText);
			CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		} catch (Exception e) {
			Assert.fail("Fail to enter search criteria");
		}
	}

	public void performSearchOperation(Map<String, String> policyDetails, String pageName) {
		switch (policyDetails.get("SearchBy")) {
		case PDTConstants.CLIENT_ID:
			enterSearchCriteria(_inputClientId, policyDetails.get("SearchText"));
			Assert.assertTrue(
					verifyClientIdAndCompanyName(policyDetails.get("SearchText"), policyDetails.get("CompanyName"),
							pageName),
					MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_CLIENT_ID_COMPANY_NAME, CoreConstants.FAIL,
							policyDetails.get("SearchText"), policyDetails.get("CompanyName"), pageName));
			break;
		case PDTConstants.CLIENT_NAME:
			enterSearchCriteria(_inputClientName, policyDetails.get("SearchText"));
			Assert.assertTrue(
					verifyClientIdAndCompanyName(policyDetails.get("ClientId"), policyDetails.get("SearchText"),
							pageName),
					MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_CLIENT_ID_COMPANY_NAME, CoreConstants.FAIL,
							policyDetails.get("ClientId"), policyDetails.get("SearchText"), pageName));
			break;
		case PDTConstants.POLICY:
			enterSearchCriteria(_inputPolicyName, policyDetails.get("SearchText"));
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
			clickElementOfPage(PDTConstants.CLEAR_FILTER, pageName);
		}
	}

	public boolean searchAndVerifyPolicy(String policyName, String pageName, PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
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
			CoreFunctions.waitHandler(3);
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
		CoreFunctions.clearAndSetText(driver, _txtAreaDescription, COREFLEXConstants.VERSION_CONTROL_DESCRIPTION);
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
//				CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
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
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_POLICY_ACTION_ICON_ON_VIEW_EDIT_POLICY_FORMS_PAGE,
					CoreConstants.FAIL, iconName, policyVersion, e.getMessage()));
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
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _btnSearch, COREFLEXConstants.SEARCH);
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
//			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonExit, COREFLEXConstants.EXIT);
			String corporationPolicyValue = generalInfoPage.getElementText(COREFLEXConstants.CORPORATION_POLICY_NUMBER);
			CoreFunctions.writeToPropertiesFile("ClonePolicy_Reference_CorporationPolicyNum", corporationPolicyValue);
			generalInfoPage.clickElementOfPage(COREFLEXConstants.EXIT);
//			CoreFunctions.waitHandler(2);
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
			CoreFunctions.clearAndSetText(driver, _inputClonePolicy, COREFLEXConstants.AUTOMATION_POLICY);
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
			if ((clientNamesList.size() == 1) && ((clientNamesList.get(0)).contains(
					CoreFunctions.getPropertyFromConfig("ClonePolicy_Reference_Client").split("\\(")[0].trim()))) {
				Assert.fail(MessageFormat.format(
						COREFLEXConstants.DIFFERENT_CLIENT_NOT_AVAILABLE_FOR_SELECTION_IN_CLONE_TO_CLIENT_LIST,
						CoreConstants.FAIL));
			} else {
				selectDifferentClientForCloning(clientNamesList);
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

	private void selectDifferentClientForCloning(List<String> clientNamesList) {
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

	public Boolean verifyCFUserlogin(String userName, String pageName) {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _addNewPolicyForm,
				PDTConstants.ADD_NEW_POLICY_FORM);
		if (CoreFunctions.getElementText(driver, _userName).contains(userName)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_USERNAME_IS_DISPLAYED, CoreConstants.PASS,
					userName, pageName));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL, pageName,
				userName, CoreFunctions.getElementText(driver, _userName)));
		return false;
	}

	public boolean verifyPolicyStatusWithVersion(String selectedPolicyName, String expectedPolicyStatus,
			String expectedPolicyVersion, String pageName) {
		boolean isSubmittedPolicyStatusVerified = false;
		boolean isPolicyVersionVerified = false;
		String[] actualPolicyStatus = null, actualPolicyVersion = null;
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyName, selectedPolicyName);
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listPolicyName, selectedPolicyName));
			String actualPolicyStatusList = _listPolicyStatus.get(index).getText();
			actualPolicyStatus = actualPolicyStatusList.split(":");
			isSubmittedPolicyStatusVerified = (actualPolicyStatus[1].trim()).equalsIgnoreCase(expectedPolicyStatus);
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listPolicyStatus, (actualPolicyStatus[1].trim())));

			String actualPolicyVersionList = _listVersionNo.get(index).getText();
			actualPolicyVersion = actualPolicyVersionList.split(":");
			isPolicyVersionVerified = (actualPolicyVersion[1].trim()).equalsIgnoreCase(expectedPolicyVersion);
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listVersionNo, (actualPolicyVersion[1].trim())));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_VALIDATING_POLICY_STATUS_VERSION,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedPolicyStatusVerified && isPolicyVersionVerified) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_POLICY_VERSION_STATUS, CoreConstants.PASS,
					selectedPolicyName, actualPolicyVersion[1], actualPolicyStatus[1], pageName));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_POLICY_VERSION_STATUS,
					CoreConstants.FAIL, selectedPolicyName, expectedPolicyVersion, actualPolicyVersion[1],
					expectedPolicyStatus, actualPolicyStatus[1], pageName));
			return false;
		}

	}

	public void searchByPolicyNameAndClickIcon(String iconName, String policyName, String pageName) {
		try {
			populateIconMap();
			CoreFunctions.clearAndSetText(driver, _inputPolicyName, policyName);
			CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
			if (CoreFunctions.isElementExist(driver, _progressBar, 2)) {
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			}
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyName, policyName);
			if (index != -1) {
				CoreFunctions.highlightObject(driver, _listPolicyName.get(index));
				CoreFunctions.highlightElementAndClick(driver, iconMap.get(iconName).get(index), iconName);
			} else {
				Assert.fail("Failed to search policy name");
			}
		} catch (Exception e) {
			Assert.fail("Failed to search policy name");
		}
	}

	public boolean verifyButton(String btnName, String btnStatus) {
		try {
			if (btnName.equalsIgnoreCase("create") && btnStatus.equalsIgnoreCase("disabled")
					&& _btnCreateDisabled.getAttribute("disabled").equalsIgnoreCase("true")) {
				CoreFunctions.highlightObject(driver, _btnCreateDisabled);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_BTN_STATE, CoreConstants.PASS, btnName, btnStatus));
				return true;
			} else if (btnName.equalsIgnoreCase("create") && btnStatus.equalsIgnoreCase("enabled")
					&& CoreFunctions.isElementExist(driver, _btnCreate, 3)) {
				CoreFunctions.highlightObject(driver, _btnCreate);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_BTN_STATE, CoreConstants.PASS, btnName, btnStatus));
				return true;
			} else if (btnName.equalsIgnoreCase("cancel") && btnStatus.equalsIgnoreCase("enabled")
					&& CoreFunctions.isElementExist(driver, _btnCancel, 3)) {
				CoreFunctions.highlightObject(driver, _btnCancel);
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.VERIFIED_BTN_STATE, CoreConstants.PASS, btnName, btnStatus));
				return true;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_BTN_STATE, CoreConstants.FAIL, btnName,
					btnStatus));
		}
		return false;
	}

	public void waitForProgressBarToDisapper() {
		try {
			if (CoreFunctions.isElementExist(driver, _progressBar, 5)) {
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_WAIT_PROGRESS_BAR, CoreConstants.FAIL));
		}
	}

	public void contentsOfPopUp(List<List<String>> data) {
		waitForProgressBarToDisapper();
		String msgText = _msgVersionPopUp.get(0).getText().replace('�', '"').replace('�', '"').trim();
		CoreFunctions.explicitWaitTillElementVisibility(driver, _imgInfoIcon, "Info Icon");
		if (msgText.equalsIgnoreCase(data.get(0).get(1))) {
			CoreFunctions.highlightObject(driver, _msgVersionPopUp.get(0));
			Reporter.addStepLog(CoreConstants.PASS + MobilityXConstants.VERIFIED_FIELD_TEXT + data.get(0).get(0) + " : "
					+ data.get(0).get(1));
		} else {
			Reporter.addStepLog(CoreConstants.FAIL + MobilityXConstants.FAILED_TO_VERIFY + data.get(0).get(0) + " | "
					+ CoreConstants.VAL_ACTUAL + _msgVersionPopUp.get(0).getText() + " " + CoreConstants.VAL_EXPECTED
					+ data.get(0).get(1));
			Assert.fail("Failed to verify the fields " + data.get(0).get(0) + " Text: Actual Text = "
					+ _msgVersionPopUp.get(0).getText() + " | Expected Text = " + data.get(0).get(1));
		}

		CoreFunctions.verifyText(driver, _msgVersionPopUp.get(1), data.get(1).get(1), data.get(1).get(0));
		CoreFunctions.verifyText(driver, _versionText, data.get(2).get(1), data.get(2).get(0));
		if (CoreFunctions.isElementVisible(_txtAreaDescription)) {
			CoreFunctions.highlightObject(driver, _txtAreaDescription);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_VISIBLE, CoreConstants.PASS,
					PDTConstants.TXTAREA, PDTConstants.DESCRIPTION));
		} else
			Assert.fail(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_NOT_VISIBLE, CoreConstants.PASS,
					PDTConstants.TXTAREA, PDTConstants.DESCRIPTION));

	}

	public boolean enterDescriptionAndVerifyCreateBtn(String btnName, String btnStatus) {
		CoreFunctions.clearAndSetText(driver, _txtAreaDescription, PDTConstants.DESCRIPTION,
				"Version 2 is getting created");
		if (verifyButton(btnName, btnStatus))
			return true;
		else
			return false;
	}

	public void contentsOfPopUp() {
		if (CoreFunctions.isElementExist(driver, _progressBar, 3)) {
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		}
		String msgText = _msgVersionPopUp.get(0).getText().replace('�', '"').replace('�', '"').trim();
		CoreFunctions.explicitWaitTillElementVisibility(driver, _imgInfoIcon, "Info Icon");
		if (msgText.equalsIgnoreCase(PDTConstants.MESSAGE1)) {
			CoreFunctions.highlightObject(driver, _msgVersionPopUp.get(0));
			Reporter.addStepLog(CoreConstants.PASS + MobilityXConstants.VERIFIED_FIELD_TEXT + "Message1" + " : "
					+ PDTConstants.MESSAGE1);
		} else {
			Reporter.addStepLog(CoreConstants.FAIL + MobilityXConstants.FAILED_TO_VERIFY + "Message1" + " | "
					+ CoreConstants.VAL_ACTUAL + _msgVersionPopUp.get(0).getText() + " " + CoreConstants.VAL_EXPECTED
					+ PDTConstants.MESSAGE1);
			Assert.fail("Failed to verify the fields Message1 Text: Actual Text = " + _msgVersionPopUp.get(0).getText()
					+ " | Expected Text = " + PDTConstants.MESSAGE1);
		}

		CoreFunctions.verifyText(driver, _msgVersionPopUp.get(1), PDTConstants.MESSAGE2, "Message2");
		CoreFunctions.verifyText(driver, _versionText, PDTConstants.VERSION_V2, "Version");
		if (CoreFunctions.isElementVisible(_txtAreaDescription)) {
			CoreFunctions.highlightObject(driver, _txtAreaDescription);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_VISIBLE, CoreConstants.PASS,
					PDTConstants.TXTBOX, PDTConstants.DESCRIPTION));
		} else
			Assert.fail(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_NOT_VISIBLE, CoreConstants.PASS,
					PDTConstants.TXTBOX, PDTConstants.DESCRIPTION));

	}

	public void enterDescription() {
		CoreFunctions.clearAndSetText(driver, _txtAreaDescription, PDTConstants.DESCRIPTION,
				"Version V2 is getting created");
		CoreFunctions.click(driver, _btnCreate, _btnCreate.getText());
		waitForProgressBarToDisapper();
	}

	public void enterPolicyName(String policyName) {
		CoreFunctions.clearAndSetText(driver, _inputPolicyName, policyName);
		CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
	}

	public boolean verifyAssignmentLinkedCount(String policyName, int expectedAssignmentLinked,
			PDT_PolicyAssignmentPage _policyAssignmentPage) {
		if (expectedAssignmentLinked == _policyAssignmentPage.getTransfereeCount()) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ASSIGNMENT_LINKED, CoreConstants.PASS,
					_policyAssignmentPage.getTransfereeCount()));
			return true;
		}
		return false;
	}

	public void iterateAndVerifyIcons(String iconName, String status, String pageName) {
		String[] iconNameArr = iconName.split(",");
		for (int i = 0; i < iconNameArr.length; i++) {
			verifyIcon(iconNameArr[i].trim(), status, pageName);
		}
	}

	public void verifyIcon(String iconName, String status, String pageName) {
		try {
			switch (iconName) {
			case PDTConstants.ICON_EDIT:
				verifyEditIcon(iconName, status, pageName);
				break;
			case PDTConstants.ICON_DELETE:
				verifyDeleteIcon(iconName, status, pageName);
				break;
			case PDTConstants.ICON_CLONE:
				verifyCloneIcon(iconName, status, pageName);
				break;
			case PDTConstants.ICON_ASSIGNMENT_HISTORY:
				verifyAssignmentHisoryIcon(iconName, status, pageName);
				break;
			case PDTConstants.ICON_APPROVE_POLICY:
				approvePolicyIcon(iconName, status, pageName);
				break;
			}

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON, CoreConstants.FAIL, iconName, status,
					pageName));
		}
	}

	public void verifyEditIcon(String iconName, String status, String pageName) {
		String iconStatus = CoreFunctions.getAttributeText(_listEditIcon.get(policySearchIndex), "src")
				.contains("Pencildisable") ? PDTConstants.DISABLED : PDTConstants.ENABLED;
		if (iconStatus.equalsIgnoreCase(status)) {
			CoreFunctions.highlightObject(driver, _listEditIcon.get(policySearchIndex));
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFIED_ICON, CoreConstants.PASS, iconName, status, pageName));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON, CoreConstants.FAIL, iconName, status,
					pageName));
		}
	}

	public void verifyDeleteIcon(String iconName, String status, String pageName) {
		String iconStatus = CoreFunctions.getAttributeText(_listDeleteIcon.get(policySearchIndex), "src")
				.contains("Trash") ? PDTConstants.DISABLED : PDTConstants.ENABLED;
		if (iconStatus.equalsIgnoreCase(status)) {
			CoreFunctions.highlightObject(driver, _listDeleteIcon.get(policySearchIndex));
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFIED_ICON, CoreConstants.PASS, iconName, status, pageName));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON, CoreConstants.FAIL, iconName, status,
					pageName));
		}
	}

	public void verifyCloneIcon(String iconName, String status, String pageName) {
		String iconStatus = CoreFunctions.getAttributeText(_listCloneIcon.get(policySearchIndex), "src")
				.contains("cloneDisable") ? PDTConstants.DISABLED : PDTConstants.ENABLED;
		if (iconStatus.equalsIgnoreCase(status)) {
			CoreFunctions.highlightObject(driver, _listCloneIcon.get(policySearchIndex));
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFIED_ICON, CoreConstants.PASS, iconName, status, pageName));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON, CoreConstants.FAIL, iconName, status,
					pageName));
		}
	}

	public void verifyAssignmentHisoryIcon(String iconName, String status, String pageName) {
		String iconStatus = CoreFunctions.getAttributeText(_listAssignmentHistoryIcon.get(policySearchIndex), "src")
				.contains("disable") ? PDTConstants.DISABLED : PDTConstants.ENABLED;
		if (iconStatus.equalsIgnoreCase(status)) {
			CoreFunctions.highlightObject(driver, _listAssignmentHistoryIcon.get(policySearchIndex));
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFIED_ICON, CoreConstants.PASS, iconName, status, pageName));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON, CoreConstants.FAIL, iconName, status,
					pageName));
		}
	}

	public void approvePolicyIcon(String iconName, String status, String pageName) {
		String iconStatus = CoreFunctions.getAttributeText(_listApprovePolicyIcon.get(policySearchIndex), "src")
				.contains("Disable") ? PDTConstants.DISABLED : PDTConstants.ENABLED;
		if (iconStatus.equalsIgnoreCase(status)) {
			CoreFunctions.highlightObject(driver, _listApprovePolicyIcon.get(policySearchIndex));
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFIED_ICON, CoreConstants.PASS, iconName, status, pageName));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON, CoreConstants.FAIL, iconName, status,
					pageName));
		}
	}

	public boolean searchAndVerifyPolicyByNameVersionStatus(String policyName, String policyStatus,
			String policyVersion, String pageName) {
		try {
			for (WebElement row : _listPolicyName) {
				if (row.getText().trim().equals(policyName.trim())
						&& _listPolicyStatus.get(_listPolicyName.indexOf(row)).getText().split(":")[1].trim()
								.equalsIgnoreCase(policyStatus)
						&& _listVersionNo.get(_listPolicyName.indexOf(row)).getText().split(":")[1].trim()
								.equalsIgnoreCase(policyVersion)) {
					CoreFunctions.highlightObject(driver, _listPolicyName.get(_listPolicyName.indexOf(row)));
					CoreFunctions.highlightObject(driver, _listPolicyStatus.get(_listPolicyName.indexOf(row)));
					CoreFunctions.highlightObject(driver, _listVersionNo.get(_listPolicyName.indexOf(row)));
					Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_POLICYNAME_VER_STATUS,
							CoreConstants.PASS, policyName, policyStatus, policyVersion));
					policySearchIndex = _listPolicyName.indexOf(row);
					return true;
				}
			}
			return false;
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void navigateAssignmentHistoryPage(PDT_PolicyAssignmentPage _policyAssignmentPage) {
		CoreFunctions.click(driver, iconMap.get(PDTConstants.ICON_ASSIGNMENT_HISTORY).get(policySearchIndex),
				PDTConstants.ICON_ASSIGNMENT_HISTORY);
		_policyAssignmentPage.waitForProgressBarToDisapper();
	}

	public void highlightAndClickIcon(String key) {
		populateIconMap();
		CoreFunctions.highlightElementAndClick(driver, iconMap.get(key).get(policySearchIndex),
				PDTConstants.CLEAR_FILTER);
	}

	public void searchByPolicyNameAndClickPolicy(String policyName, String pageName) {
		try {
			populateIconMap();
			CoreFunctions.clearAndSetText(driver, _inputPolicyName, policyName);
			CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
			if (CoreFunctions.isElementExist(driver, _progressBar, 2)) {
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			}
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyName, policyName);
			if (index != -1) {
				CoreFunctions.highlightElementAndClick(driver, _listPolicyName.get(index),
						_listPolicyName.get(index).getText());
			} else {
				Assert.fail("Failed to search policy name");
			}
		} catch (Exception e) {
			Assert.fail("Failed to search policy name");
		}
	}

	public boolean verifyFlexWordNotDisplayed() {
		return BusinessFunctions.verifyFlexWordNotDisplayed(driver, _textCoreFlex, PDTConstants.VIEW_EDIT_POLICY_FORMS);
	}

	public boolean verifyOnPointPolicyStatusIndicator(String expectedPolicyStatusIndicator,
			String expectedPolicyStatusHoverText, String selectedPolicyName, String expectedPolicyStatus,
			String expectedPolicyVersion) {
		try {
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyName, selectedPolicyName);
			String actualPolicyStatusList = _listPolicyStatus.get(index).getText();
			String actualPolicyVersionList = _listPolicyVersion.get(index).getText();
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listPolicyName, selectedPolicyName));
			CoreFunctions.verifyTextContains(actualPolicyStatusList.split(":")[1].trim(), expectedPolicyStatus,
					COREFLEXConstants.POLICY_STATUS);
			CoreFunctions.highlightObject(driver, _listPolicyStatus.get(index));
			CoreFunctions.verifyText(actualPolicyVersionList.split(":")[1].trim(), expectedPolicyVersion,
					COREFLEXConstants.POLICY_VERSION);
			CoreFunctions.highlightObject(driver, _listPolicyVersion.get(index));
			CoreFunctions.verifyText(getActualPolicyStatusIndicator(index), expectedPolicyStatusIndicator,
					COREFLEXConstants.DRAFT_POLICY_STATUS_INDICATOR);
			CoreFunctions.highlightObject(driver, _policyStatusIndicator.get(index));
			CoreFunctions.verifyText(CoreFunctions.getAttributeText(_policyStatusIndicator.get(index), "mattooltip"),
					expectedPolicyStatusHoverText, COREFLEXConstants.DRAFT_POLICY_STATUS_INDICATOR_HOVER_TEXT);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_DRAFT_POLICY_STATUS_INDICATOR_AND_HOVER_TEXT,
					CoreConstants.PASS, expectedPolicyStatusIndicator, expectedPolicyStatusHoverText,
					COREFLEXConstants.VIEW_EDIT_POLICY_FORMS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_POLICY_STATUS_INDICATOR,
							CoreConstants.FAIL, e.getMessage(), COREFLEXConstants.VIEW_EDIT_POLICY_FORMS));
			return false;
		}
	}

	private String getActualPolicyStatusIndicator(int index) {
		return CoreFunctions.getElementText(driver, _policyStatusIndicator.get(index)).equalsIgnoreCase("error")
				? COREFLEXConstants.RED_INDICATOR
				: (CoreFunctions.getElementText(driver, _policyStatusIndicator.get(index))
						.equalsIgnoreCase("check_circle") ? COREFLEXConstants.GREEN_INDICATOR : null);
	}

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyEditPolicyBenefitPageNavigation() {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		return CoreFunctions.verifyElementOnPage(driver, _headingEditPolicyBenefit,
				COREFLEXConstants.EDIT_POLICY_BENEFIT);
	}

	public int searchPolicyByStatus(String policyStatus, String policyIndicator) {
		int policyIndex = -1;
		try {
			policyIndex = BusinessFunctions.returnindexItemFromListUsingText(driver, _policyStatusIndicator,
					getPolicyIndicatorText(policyIndicator), true);
			if (policyIndex == -1) {
				while (policyIndex == -1) {
					clickElementOfPage(COREFLEXConstants.NEXT);
					policyIndex = BusinessFunctions.returnindexItemFromListUsingText(driver, _policyStatusIndicator,
							getPolicyIndicatorText(policyIndicator), true);
					if (policyIndex != -1) {
						captureReferencePolicyValues(policyIndex);
						return policyIndex;
					}
				}
			} else {
				CoreFunctions.highlightObject(driver, _policyStatusIndicator.get(policyIndex));
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

	private String getPolicyIndicatorText(String policyIndicator) {
		return (policyIndicator.equalsIgnoreCase("Incomplete") ? "error" : "check_circle");
	}

}
