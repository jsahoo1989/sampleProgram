package com.aires.pages.mylo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class Mylo_LoginPage extends Base {

	public Mylo_LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "img[src*='mylo-logo']")
	private WebElement _img_MYLOLogo;

	@FindBy(how = How.CSS, using = "input[type='email']")
	private WebElement _txt_UserEmail;

	@FindBy(how = How.CSS, using = "input[type='submit']")
	private WebElement _submit;

	@FindBy(how = How.CSS, using = "input[type='password']")
	private WebElement _txt_Password;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'idSIButton')]")
	private WebElement _staySignedInYes;
	
	@FindBy(how = How.XPATH, using = "//div[@class='profile-img']/a/img")
	private WebElement _userProfileImg;
	
	@FindBy(how = How.XPATH, using = "//img[@class='tile-img']")
	private WebElement _logoutUserImg;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Use another account']")
	private WebElement _anotherAccount;
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;
	
	@FindBy(how = How.CSS, using = "div[id='user-profile']")
	private WebElement _userProfile;
	
	final By _loginImg = By.xpath("//img[contains(@src,'login-with-office-365.jpg')]");
	
	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public void openApplication() throws InterruptedException {
		Log.info(FileReaderManager.getInstance().getConfigReader().getMyloApplicationUrl());
		CoreFunctions.waitForBrowserToLoad(driver);
		VerifyMYLOLogo();
		CoreFunctions.switchToNewTab(driver);
	}

	public void VerifyMYLOLogo() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _img_MYLOLogo, MYLOConstants.MYLOLOGO_TEXT);
		if (_img_MYLOLogo.isDisplayed())
			Log.info(CoreConstants.VRFIED + MYLOConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
		else
			Assert.fail(CoreConstants.FAIL + MYLOConstants.APPLICATION_FAILED_TO_LAUNCH);
	}

	public void clickSignIn() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _submit, _submit.getAttribute("value"));
		CoreFunctions.click(driver, _submit, _submit.getAttribute("value"));
		if (CoreFunctions.isElementExist(driver, _staySignedInYes, 5)) {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _staySignedInYes,
					_staySignedInYes.getAttribute("value"), 10);
			CoreFunctions.click(driver, _staySignedInYes, _staySignedInYes.getAttribute("value"));
		}
		CoreFunctions.switchToParentWindow(driver);
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 10);
		while(!(CoreFunctions.isElementExist(driver, _userProfile, 6))) {
			CoreFunctions.clickElement(driver, CoreFunctions.getElementByLocator(driver, _loginImg));
		}	
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 10);
		CoreFunctions.highlightObject(driver, _userProfile);
	}

	public void enterUserEmailAndPasswordForMylo(String userName, String password) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txt_UserEmail,
					_txt_UserEmail.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _txt_UserEmail, _txt_UserEmail.getAttribute("placeholder"), userName);
			CoreFunctions.clickUsingJS(driver, _submit, _submit.getAttribute("value"));
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txt_Password,
					_txt_Password.getAttribute("name"));
			CoreFunctions.clearAndSetText(driver, _txt_Password, _txt_Password.getAttribute("type"), password);
		} catch (ElementNotFoundException e) {
		}
	}
	
	public void logout() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _userProfileImg, MYLOConstants.USER_PROFILE_IMAGE);
		CoreFunctions.click(driver, _userProfileImg, MYLOConstants.USER_PROFILE_IMAGE);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _logoutUserImg, _logoutUserImg.getText());
		CoreFunctions.click(driver, _logoutUserImg, MYLOConstants.LOGOUT_IMAGE);
	}
	
	public void clickAnotherAccount() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _anotherAccount, _anotherAccount.getText());
		CoreFunctions.click(driver, _anotherAccount, _anotherAccount.getText());
	}
	
	public void loginWithUser(String userType) throws InterruptedException {
		logout();
		openApplication();
		CoreFunctions.explicitWaitTillElementVisibility(driver, _anotherAccount, _anotherAccount.getText());
		CoreFunctions.click(driver, _anotherAccount, _anotherAccount.getText());
		if (userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE15)||userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE300096)||userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE300140)) {
			enterUserEmailAndPasswordForMylo(loginData.MyloWithOutResource15UserName, loginData.MyloPassword);	
		}
		else {
			enterUserEmailAndPasswordForMylo(loginData.MyloUserName, loginData.MyloPassword);	
		}
		clickSignIn();
	}

}
