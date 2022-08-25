package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.Date;
import java.util.LinkedHashMap;
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
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.vimalselvam.cucumber.listener.Reporter;

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

	// Search Button
	@FindBy(how = How.CSS, using = "a.clear_filter")
	private WebElement _clearFilter;

	// Add new Policy Form link
	@FindBy(how = How.XPATH, using = "//p[text()='Add New Policy Form']")
	private WebElement _lnkAddNewPolicyForm;

	// Policies Status List
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Policy Status')]/parent::h6")
	private List<WebElement> _listPolicyStatus;

	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Version Number')]/parent::h6")
	private List<WebElement> _listVersionNo;

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

	@FindBy(how = How.CSS, using = "input[formcontrolname='description']")
	private WebElement _txtBoxDescription;

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
	
	// Approve Policy Icon List
	@FindBy(how = How.CSS, using = "div.icons-action a[mattooltip='Approve Policy']>img")
	private List<WebElement> _listApprovePolicyIcon;
	LinkedHashMap<String, List<WebElement>> iconMap = new LinkedHashMap<String, List<WebElement>>();

	final By _listPolicyNameByLocator = By.cssSelector("h5.text-info.info-pname");
	final By _listClientNameByLocator = By.cssSelector("h6.info-pclient");
	long timeBeforeAction, timeAfterAction;
	int policySearchIndex;

	public void populateIconMap() {
		iconMap.put(PDTConstants.ICON_ASSIGNMENT_HISTORY, _listAssignmentHistoryEnableIcon);
		iconMap.put(PDTConstants.ICON_EDIT, _listEditEnableIcon);
	}

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
		case PDTConstants.CLEAR_FILTER:
			CoreFunctions.highlightElementAndClick(driver, _clearFilter, PDTConstants.CLEAR_FILTER);
			break;
		default:
			Assert.fail("Element not found");
		}
	}

	public String getUserName() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _userName, _userName.getText().split("\n")[1]);
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

	public boolean verifyPolicyStatusWithVersion(String selectedPolicyName, String expectedPolicyStatus,
			String expectedPolicyVersion, String pageName) {
		boolean isPolicyStatusVerified = false;
		boolean isPolicyVersionVerified = false;
		String[] actualPolicyStatus = null, actualPolicyVersion = null;
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listPolicyName, selectedPolicyName);
			CoreFunctions.highlightObject(driver,
					CoreFunctions.getElementFromListByText(_listPolicyName, selectedPolicyName));
			String actualPolicyStatusList = _listPolicyStatus.get(index).getText();
			actualPolicyStatus = actualPolicyStatusList.split(":");
			isPolicyStatusVerified = (actualPolicyStatus[1].trim()).equalsIgnoreCase(expectedPolicyStatus);
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
		if (isPolicyStatusVerified && isPolicyVersionVerified) {
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

	public void searchByPolicyName(String iconName, String policyName, String pageName) {
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
		if (CoreFunctions.isElementExist(driver, _progressBar, 3)) {
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		}
	}

	public void contentsOfPopUp(List<List<String>> data) {
		waitForProgressBarToDisapper();
		String msgText = _msgVersionPopUp.get(0).getText().replace('“', '"').replace('”', '"').trim();
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
		if (CoreFunctions.isElementVisible(_txtBoxDescription)) {
			CoreFunctions.highlightObject(driver, _txtBoxDescription);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_VISIBLE, CoreConstants.PASS,
					PDTConstants.TXTBOX, PDTConstants.DESCRIPTION));
		} else
			Assert.fail(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_NOT_VISIBLE, CoreConstants.PASS,
					PDTConstants.TXTBOX, PDTConstants.DESCRIPTION));

	}

	public boolean enterDescriptionAndVerifyCreateBtn(String btnName, String btnStatus) {
		CoreFunctions.clearAndSetText(driver, _txtBoxDescription, PDTConstants.DESCRIPTION,
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
		String msgText = _msgVersionPopUp.get(0).getText().replace('“', '"').replace('”', '"').trim();
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
		if (CoreFunctions.isElementVisible(_txtBoxDescription)) {
			CoreFunctions.highlightObject(driver, _txtBoxDescription);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_VISIBLE, CoreConstants.PASS,
					PDTConstants.TXTBOX, PDTConstants.DESCRIPTION));
		} else
			Assert.fail(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_NOT_VISIBLE, CoreConstants.PASS,
					PDTConstants.TXTBOX, PDTConstants.DESCRIPTION));

	}

	public void enterDescription() {
		CoreFunctions.clearAndSetText(driver, _txtBoxDescription, PDTConstants.DESCRIPTION,
				"Version 2 is getting created");
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
		for(int i=0; i<iconNameArr.length; i++) {
			verifyIcon(iconNameArr[i].trim(), status, pageName);
		}
	}

	public void verifyIcon(String iconName, String status, String pageName) {		
		try {
			switch(iconName) {
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
		if(iconStatus.equalsIgnoreCase(status)) {
			CoreFunctions.highlightObject(driver, _listEditIcon.get(policySearchIndex));
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON, CoreConstants.PASS, iconName, status, pageName));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON, CoreConstants.FAIL, iconName, status,
					pageName));
		}		
	}
	
	public void verifyDeleteIcon(String iconName, String status, String pageName) {
		String iconStatus = CoreFunctions.getAttributeText(_listDeleteIcon.get(policySearchIndex), "src")
				.contains("Trash") ? PDTConstants.DISABLED : PDTConstants.ENABLED;
		if(iconStatus.equalsIgnoreCase(status)) {
			CoreFunctions.highlightObject(driver, _listDeleteIcon.get(policySearchIndex));
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON, CoreConstants.PASS, iconName, status, pageName));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON, CoreConstants.FAIL, iconName, status,
					pageName));
		}
	}
	
	public void verifyCloneIcon(String iconName, String status, String pageName) {
		String iconStatus =  CoreFunctions.getAttributeText(_listCloneIcon.get(policySearchIndex), "src")
				.contains("cloneDisable") ? PDTConstants.DISABLED : PDTConstants.ENABLED;
		if(iconStatus.equalsIgnoreCase(status)) {
			CoreFunctions.highlightObject(driver, _listCloneIcon.get(policySearchIndex));
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON, CoreConstants.PASS, iconName, status, pageName));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON, CoreConstants.FAIL, iconName, status,
					pageName));
		}
	}
	
	public void verifyAssignmentHisoryIcon(String iconName, String status, String pageName) {
		String iconStatus = CoreFunctions.getAttributeText(_listAssignmentHistoryIcon.get(policySearchIndex), "src").contains("disable")
				? PDTConstants.DISABLED
				: PDTConstants.ENABLED;
		if(iconStatus.equalsIgnoreCase(status)) {
			CoreFunctions.highlightObject(driver, _listAssignmentHistoryIcon.get(policySearchIndex));
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON, CoreConstants.PASS, iconName, status, pageName));
		} else {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ICON, CoreConstants.FAIL, iconName, status,
					pageName));
		}
	}
	
	public void approvePolicyIcon(String iconName, String status, String pageName) {
		String iconStatus = CoreFunctions.getAttributeText(_listApprovePolicyIcon.get(policySearchIndex), "src").contains("Disable")
		? PDTConstants.DISABLED : PDTConstants.ENABLED;
		if(iconStatus.equalsIgnoreCase(status)) {
			CoreFunctions.highlightObject(driver, _listApprovePolicyIcon.get(policySearchIndex));
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ICON, CoreConstants.PASS, iconName, status, pageName));
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
		CoreFunctions.highlightElementAndClick(driver, iconMap.get(key).get(policySearchIndex), PDTConstants.CLEAR_FILTER);
	}

}
