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
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_ViewPolicyPage extends Base{
	public PDT_ViewPolicyPage(WebDriver driver) {
		super(driver);
	}
	
	//View/Edit Policy Forms
	@FindBy(how = How.CSS, using = "h4.card-title")
	private WebElement _headingViewEditPolicyForm;
	
	//User name
	@FindBy(how = How.CSS, using = "a.nav-link.nav_username")
	private WebElement _userName;
	
	//Logout
	@FindBy(how = How.CSS, using = "i.material-icons.dp48")
	private WebElement _logout;
	
	//Logout
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;
	
	//Edit Icon
	@FindBy(how = How.CSS, using = "img.formicon")
	private List<WebElement> _iconEdit;
	
	//Policy Name
	@FindBy(how = How.CSS, using = "img.formicon")
	private List<WebElement> _txtPolicyName;	

	// Input Client/Company Name field
	@FindBy(how = How.ID, using = "companyName")
	private WebElement _inputClientName;
	
	// Input ClientId field
	@FindBy(how = How.ID, using = "companyId")
	private WebElement _inputClientId;
	
	// Input Policy Name
	@FindBy(how = How.ID, using = "policyName")
	private WebElement _inputPolicyName;
	
	//Policies List
	@FindBy(how = How.CSS, using = "h5.text-info.info-pname")
	private List<WebElement> _listPolicyName;
	
	//Client Name list
	@FindBy(how = How.CSS , using = "h6.info-pclient")
	private List<WebElement> _listClientName;
	
	//Search Button
	@FindBy(how = How.CSS , using = "button.searchbtn")
	private WebElement _btnSearch;
	
	//Search Button
	@FindBy(how = How.CSS , using = "a.clear_filter")
	private WebElement _clearFilter;
	
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
			CoreFunctions.highlightObject(driver, _logout);
			CoreFunctions.clickElement(driver, _logout);
			break;
		case PDTConstants.CLEAR_FILTER:
			CoreFunctions.highlightObject(driver, _clearFilter);
			CoreFunctions.clickElement(driver, _clearFilter);
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
		if ( getUserName().equalsIgnoreCase(userName)) {			
			CoreFunctions.highlightObject(driver, _userName);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_USERNAME_IS_DISPLAYED, CoreConstants.PASS, userName, pageName ));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL, pageName, userName, getUserName()));
		return false;
	}
	
	public Boolean verifyViewPolicyHeading(String pageName) {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);		
		if ( _headingViewEditPolicyForm.getText().equalsIgnoreCase(PDTConstants.VIEW_EDIT_POLICY_FORMS)) {			
			CoreFunctions.highlightObject(driver, _headingViewEditPolicyForm);
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_HEADING_ON_PAGE, CoreConstants.PASS, _headingViewEditPolicyForm.getText(), pageName ));			
			Log.info("Verified Heading");
			return true;
		}
		Log.info("Failed to verify Heading");
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_HEADING_ON_PAGE, CoreConstants.FAIL, pageName, PDTConstants.VIEW_EDIT_POLICY_FORMS, _headingViewEditPolicyForm.getText()));
		return false;		
	}
	
	public boolean verifyPoliciesAreDisplayed(String pageName) {
		if(_txtPolicyName.size() > 0) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.POLICIES_ARE_DISPLAYED, CoreConstants.PASS, pageName));
			Log.info("Policies are displayed");
			clickElementOfPage(PDTConstants.LOGOUT);
			return true;
		}
		Log.info("Policies are not displayed");
		return false;
	}
	
	public void performSearchOperation(Map<String, String> policyDetails) {
		Log.info("searchBy=="+policyDetails.get("SearchBy"));
		switch(policyDetails.get("SearchBy")) {
		case PDTConstants.CLIENT_ID:
			searchByClientId(policyDetails.get("SearchText"));
			Assert.assertTrue(verifyClientIdAndCompanyName(policyDetails.get("SearchText"), policyDetails.get("CompanyName")), "Failed to verify Client id and Company name");
			break;
		case PDTConstants.CLIENT_NAME:
			searchByClientName(policyDetails.get("SearchText"));
			Assert.assertTrue(verifyClientIdAndCompanyName(policyDetails.get("ClientId"), policyDetails.get("SearchText")), "Failed to verify Client id and Company name");
			break;
		case PDTConstants.POLICY:
			searchByPolicyName(policyDetails.get("SearchText"));
			Assert.assertTrue(verifyPolicyName(policyDetails.get("SearchText")), "Failed to verify Policy Details");
			break;
		}
		
	}
	
	public boolean verifyClientIdAndCompanyName(String clientId, String companyName) {
		Log.info("inside verifyClientIdAndCompanyName");
		Log.info("Clientid=="+clientId);
		Log.info("companyName=="+companyName);
		//CoreFunctions.explicitWaitTillElementListClickable(driver, _listClientName);
		//_listClientName.stream().forEach(t -> Log.info("origin==" + t.getText()));
		if(CoreFunctions.isElementByLocatorExist(driver, _listClientNameByLocator, 10)) {
			CoreFunctions.waitForBrowserToLoad(driver);
			_listClientName.stream().forEach(t -> Log.info("companyName=="+t.getText()));
			if ( _listClientName.stream()
					.allMatch(t -> t.getText().contains(clientId)) && _listClientName.stream()
					.allMatch(t -> t.getText().toString().contains(companyName.toString()))) {
				_listClientName.stream().forEach(t -> CoreFunctions.highlightObject(driver, t));				
				return true;
			}
			
		}
		return false;
	}
	
	public boolean verifyPolicyName(String policyName) {
		if(CoreFunctions.isElementByLocatorExist(driver, _listPolicyNameByLocator, 5)) {
			_listPolicyName.stream().forEach(t -> Log.info("Policy==" + t.getText()));
			if (_listPolicyName.stream()
					.allMatch(t -> t.getText().toLowerCase().equalsIgnoreCase(policyName))) {
				_listPolicyName.stream().forEach(t -> CoreFunctions.highlightObject(driver, t));				
				return true;
			}	
		}
		return false;
}
	
	public void searchByClientId(String clientId) {
		CoreFunctions.clearAndSetText(driver, _inputClientId, clientId);
		CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
	}
	
	public void searchByClientName(String clientName) {
		CoreFunctions.clearAndSetText(driver, _inputClientName, clientName);
		CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
	}
	
	public void searchByPolicyName(String policyName) {
		CoreFunctions.clearAndSetText(driver, _inputPolicyName, policyName);
		CoreFunctions.click(driver, _btnSearch, _btnSearch.getText());
	}
	
	public void iteratePolicyData(List<Map<String, String>> policyData) {
		for(int i=0; i<policyData.size(); i++) {			
			performSearchOperation(policyData.get(i));
			clickElementOfPage(PDTConstants.CLEAR_FILTER);			
		}
	}
}
