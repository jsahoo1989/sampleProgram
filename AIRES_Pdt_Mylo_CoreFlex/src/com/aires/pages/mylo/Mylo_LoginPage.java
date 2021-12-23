package com.aires.pages.mylo;

import java.util.Set;

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

	public void openApplication() throws InterruptedException {
		Log.info(FileReaderManager.getInstance().getConfigReader().getMyloApplicationUrl());
		CoreFunctions.waitForBrowserToLoad(driver);
		VerifyMYLOLogo();
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
		CoreFunctions.explicitWaitTillElementVisibility(driver, _staySignedInYes, _staySignedInYes.getAttribute("value"),10);
		CoreFunctions.click(driver, _staySignedInYes, _staySignedInYes.getAttribute("value"));
		CoreFunctions.switchToParentWindow(driver);
	}

	public void enterUserEmailAndPasswordForMylo(String userName, String password) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txt_UserEmail,
					_txt_UserEmail.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _txt_UserEmail, _txt_UserEmail.getAttribute("placeholder"), userName);
			CoreFunctions.clickUsingJS(driver, _submit, _submit.getAttribute("value"));
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txt_Password,
					_txt_Password.getAttribute("name"));
			CoreFunctions.clearAndSetText(driver, _txt_Password, _txt_Password.getAttribute("name"), password);
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean switchWindow() {
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles.size());
		for (String actualWin : handles) {
			if (!actualWin.equalsIgnoreCase(currentWindow)) {
				driver.switchTo().window(actualWin);
				Log.info(driver.getTitle());
				Log.info(driver.getCurrentUrl());
				return true;
			}
		}
		return false;
	}

}
