package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;

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
	
	//Edit Icon
	@FindBy(how = How.CSS, using = "img.formicon")
	private List<WebElement> _txtPolicyName;
	
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
			Log.info("Verified username");
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
}
