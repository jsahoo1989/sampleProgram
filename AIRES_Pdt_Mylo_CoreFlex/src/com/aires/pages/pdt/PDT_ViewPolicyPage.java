package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
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

	final By _listPolicyNameByLocator = By.cssSelector("h5.text-info.info-pname");
	final By _listClientNameByLocator = By.cssSelector("h6.info-pclient");

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
			CoreFunctions.clickElement(driver, _addNewPolicyForm);
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
		return userArray[1];
	}

	public Boolean verifyUserlogin(String userName, String pageName) {
		if (getUserName().equalsIgnoreCase(userName)) {
			CoreFunctions.highlightObject(driver, _userName);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_USERNAME_IS_DISPLAYED, CoreConstants.PASS,
					userName, pageName));
			Log.info("Verified username");
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL, pageName,
				userName, getUserName()));
		return false;
	}

	public Boolean verifyViewPolicyHeading(String pageName) {
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 3);
		return CoreFunctions.verifyElementOnPage(driver, _headingViewEditPolicyForm, PDTConstants.heading,
				PDTConstants.VIEW_EDIT_POLICY_FORMS, pageName, true);
	}

	public boolean verifyPoliciesAreDisplayed(String pageName) {
		if (_txtPolicyName.size() > 0) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.POLICIES_ARE_DISPLAYED, CoreConstants.PASS, pageName));
			Log.info("Policies are displayed");
			clickElementOfPage(PDTConstants.LOGOUT);
			return true;
		}
		Log.info("Policies are not displayed");
		return false;
	}

	public void performSearchOperation(Map<String, String> policyDetails, String pageName) {
		switch (policyDetails.get("SearchBy")) {
		case PDTConstants.CLIENT_ID:
			CoreFunctions.clearAndSetText(driver, _inputClientId, policyDetails.get("SearchText"));
			CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
			Assert.assertTrue(
					verifyClientIdAndCompanyName(policyDetails.get("SearchText"), policyDetails.get("CompanyName"),
							pageName),
					MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_CLIENT_ID_COMPANY_NAME, CoreConstants.FAIL,
							policyDetails.get("SearchText"), policyDetails.get("CompanyName"), pageName));
			break;
		case PDTConstants.CLIENT_NAME:
			CoreFunctions.clearAndSetText(driver, _inputClientName, policyDetails.get("SearchText"));
			CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
			Assert.assertTrue(
					verifyClientIdAndCompanyName(policyDetails.get("ClientId"), policyDetails.get("SearchText"),
							pageName),
					MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_CLIENT_ID_COMPANY_NAME, CoreConstants.FAIL,
							policyDetails.get("ClientId"), policyDetails.get("SearchText"), pageName));
			break;
		case PDTConstants.POLICY:
			CoreFunctions.clearAndSetText(driver, _inputPolicyName, policyDetails.get("SearchText"));
			CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
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
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
			CoreFunctions.isElementByLocatorExist(driver, _listPolicyNameByLocator, 20);
			if (_listPolicyName.stream().anyMatch(t -> t.getText().toLowerCase().equalsIgnoreCase(policyName))) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_DISPLAYED_ON_PAGE,
						CoreConstants.PASS, PDTConstants.POLICY_NAME, policyName, pageName));
				return true;
			}
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail("Failed to search Policy:-" + policyName);
		}
		DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
		return false;
	}

	public List<String> getPolicyList() {
		return CoreFunctions.getElementTextAndStoreInList(driver, _listPolicyName);
	}

}
