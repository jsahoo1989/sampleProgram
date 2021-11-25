package com.aires.pages.mylo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.utilities.Log;

import cucumber.api.DataTable;



public class Mylo_DashboardHomePage extends Base {

	public Mylo_DashboardHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='user-profile']//span[2]")
	private WebElement _userProfile;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Good Morning')]")
	private WebElement _goodMorning;
	
	@FindBy(how = How.XPATH, using = "//div[@class='secondmenu']")
	private WebElement _hamburgerMenu;
	
	@FindBy(how = How.XPATH, using = "//nav[@class='menu']/a")
	private List<WebElement> _hamburgerMenuOptions;
	
	@FindBy(how = How.XPATH, using = "//div[@class='firstmenu']/ul/li/a")
	private List<WebElement> _firstMenuOptions;
	
	@FindBy(how = How.XPATH, using = "//div[@class='container']")
	private List<WebElement> _selectQueryParameterRows;
	
	@FindBy(how = How.XPATH, using = "//button[@class='close-button']")
	private WebElement _closeButton;
	
	
	final By _selectQueryoptions = By.xpath("./button");
	
	

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
	
	public void clickOptionsFromMainMenu(String option) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _firstMenuOptions);
		CoreFunctions.selectItemInListByText(driver, _firstMenuOptions, option);
	}
	
	public void closePopUp() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _closeButton, _closeButton.getText(), 10L);
		CoreFunctions.highlightElementAndClick(driver, _closeButton, _closeButton.getText());
	}
	
	public boolean clickHamburgerMenu() {
		try{
			CoreFunctions.explicitWaitTillElementVisibility(driver, _hamburgerMenu, _hamburgerMenu.getText());
		CoreFunctions.click(driver, _hamburgerMenu, _hamburgerMenu.getText());
		}
		catch(Exception e) {
			return false;
		}
		return true;
		
	}
	
	public void selectOptionsFromHamburgerMenu(String optionToBeSelected) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _hamburgerMenuOptions);
		CoreFunctions.selectItemInListByText(driver, _hamburgerMenuOptions, optionToBeSelected);	
	}

	public boolean verifySelectQueryOptions(DataTable data) {
		try {
			for (int i = 0; i < _selectQueryParameterRows.size(); i++) {
				List<WebElement> allOptions = CoreFunctions.getElementsByLocator(driver,
						_selectQueryParameterRows.get(i), _selectQueryoptions);
				for (int j = 0; j < allOptions.size(); j++) {
					Assert.assertEquals(allOptions.get(j).getText(), data.raw().get(i).get(j + 1));
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
