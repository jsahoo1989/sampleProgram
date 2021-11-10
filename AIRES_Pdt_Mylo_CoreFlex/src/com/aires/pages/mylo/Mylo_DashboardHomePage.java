package com.aires.pages.mylo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.utilities.Log;



public class Mylo_DashboardHomePage extends Base {

	public Mylo_DashboardHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='user-profile']//span[2]")
	private WebElement _userProfile;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Good Morning')]")
	private WebElement _goodMorning;
	

	public boolean verifyUserName(String userName) {
		CoreFunctions.waitForBrowserToLoad(driver);
		CoreFunctions.waitHandler(6);
		Log.info("userName is : " + _userProfile.getText());
		CoreFunctions.highlightObject(driver, _userProfile);
		if(CoreFunctions
				.isElementExist(driver, _userProfile, 10) && userName.equals(_userProfile.getText())) {
			return true;
		}
		else
			return false;
	}
	}
