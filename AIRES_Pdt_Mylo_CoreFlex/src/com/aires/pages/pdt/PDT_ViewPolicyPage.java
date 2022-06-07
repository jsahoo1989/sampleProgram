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
import com.aires.utilities.Log;
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
			if(CoreFunctions.isElementExist(driver,  _progressBar, 4))
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
		String userArray[] = _userName.getText().split("\n");
		return userArray[1].trim();
	}

	public Boolean verifyUserlogin(String userName, String pageName) {
		if(CoreFunctions.isElementExist(driver, _progressBar, 2))
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
		if(CoreFunctions.isElementExist(driver, _progressBar, 2))
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, PDTConstants.VIEW_POLICY_PAGE);
		return CoreFunctions.verifyElementOnPage(driver, _headingViewEditPolicyForm, PDTConstants.heading,
				PDTConstants.VIEW_EDIT_POLICY_FORMS, pageName, true);
	}

	public boolean verifyPoliciesAreDisplayed(String pageName) {
		timeBeforeAction = new Date().getTime();
		if(CoreFunctions.isElementExist(driver, _progressBar, 2))
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
			//CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
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
			CoreFunctions.clickElement(driver, CoreFunctions.getElementFromListByText(_listPolicyName, selectedPolicyName));
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName);
		} catch(Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_NAVIGATE_TO_PAGE, PDTConstants.GENERAL_INFORMATION, 
					CoreConstants.FAIL));
		}		
	}
}
