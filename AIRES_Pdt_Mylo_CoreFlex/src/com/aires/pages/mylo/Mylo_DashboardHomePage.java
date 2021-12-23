package com.aires.pages.mylo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.utilities.Log;

import cucumber.api.DataTable;

public class Mylo_DashboardHomePage extends Base {
	
	public Mylo_DashboardHomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'mat-dialog-container')]")
	private WebElement _popupModal;
	
	@FindBy(how = How.XPATH, using = "//*[@id='user-profile']//span[2]")
	private WebElement _userProfile;

	@FindBy(how = How.CSS, using = "div[class='secondmenu']")
	private WebElement _hamburgerMenu;

	@FindBy(how = How.XPATH, using = "//nav[@class='menu']/a")
	private List<WebElement> _hamburgerMenuOptions;

	@FindBy(how = How.XPATH, using = "//div[@class='firstmenu']/ul/li/a")
	private List<WebElement> _firstMenuOptions;

	@FindBy(how = How.CSS, using = "div[class='container']")
	private List<WebElement> _selectQueryParameterRows;

	@FindBy(how = How.CSS, using = "button[class='query-btn']")
	private List<WebElement> _selectQueryParameterButtons;

	@FindBy(how = How.CSS, using = "button[class='close-button']")
	private WebElement _closeButton;

	@FindBy(how = How.XPATH, using = "//*[@role='option']/span")
	private List<WebElement> _selectOptions;

	@FindBy(how = How.XPATH, using = "//tbody[@class='scrollbody']//following::label")
	private List<WebElement> _fileParameterList;

	@FindBy(how = How.XPATH, using = "//tbody[@class='scrollbody']/tr")
	private List<WebElement> _fileParameterRows;

	@FindBy(how = How.XPATH, using = "//button[text()='Execute']")
	private WebElement _executeButton;

	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	private WebElement _okButton;

	@FindBy(how = How.XPATH, using = "//div[@role='dialog']//h1")
	private WebElement _popUpMessage;

	@FindBy(how = How.XPATH, using = "//tbody[@class='scrollbody']/a/tr")
	private List<WebElement> _queryResultRows;

	@FindBy(how = How.XPATH, using = "//table[@class='table']/descendant::th")
	private List<WebElement> _queryResultColHeaders;

	@FindBy(how = How.XPATH, using = "//h1")
	private WebElement _headerText;

	final By _selectQueryoptions = By.xpath("./button");
	final By _fileParameterOptions = By.xpath(".//following-sibling::label");
	final By _queryResultColumns = By.xpath("./td");
	final By _dropdownSections = By.xpath(".//parent::div/ng-select");

	public boolean verifyUserName(String userName) {
		CoreFunctions.waitForBrowserToLoad(driver);
		CoreFunctions.waitHandler(6);
		Log.info("userName is : " + _userProfile.getText());
		CoreFunctions.highlightObject(driver, _userProfile);
		if (CoreFunctions.isElementExist(driver, _userProfile, 10) && userName.equals(_userProfile.getText())) {
			return true;
		} else
			return false;
	}

	public void clickOptionFromMainMenu(String option) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _firstMenuOptions);
		CoreFunctions.selectItemInListByText(driver, _firstMenuOptions, option);
	}

	public void closePopUp() {
		//CoreFunctions.waitHandler(5);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _popupModal, _popupModal.getText(), 10L);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _closeButton, _closeButton.getText(), 10L);
		CoreFunctions.highlightElementAndClick(driver, _closeButton, _closeButton.getText());
	}

	public void clickExecuteButton() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _executeButton, _executeButton.getText(), 10L);
		CoreFunctions.highlightElementAndClick(driver, _executeButton, _executeButton.getText());
	}

	public boolean clickHamburgerMenu() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _hamburgerMenu, _hamburgerMenu.getText());
			CoreFunctions.click(driver, _hamburgerMenu, _hamburgerMenu.getText());
		} catch (Exception e) {
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
				List<String> actualOptions = allOptions.stream().map(x -> x.getText()).collect(Collectors.toList());
				List<String> expectedOptions = Arrays.asList(data.raw().get(i + 1).get(1).split(","));
				if (actualOptions.equals(expectedOptions))
					continue;
				else
					return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void selectParameterFromQueryScreen(String parameter) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _selectQueryParameterButtons);
		CoreFunctions.selectItemInListByText(driver, _selectQueryParameterButtons, parameter);
	}

	public boolean verifyFileParameterOptions(DataTable data) {
		try {
			for (int i = 0; i < _fileParameterRows.size(); i++) {
				List<WebElement> allOptions = CoreFunctions.getElementsByLocator(driver, _fileParameterRows.get(i),
						_fileParameterOptions);
				List<String> actualParameterOptions = allOptions.stream().map(x -> x.getText())
						.collect(Collectors.toList());
				List<String> expectedParameterOptions = Arrays.asList(data.raw().get(i + 1).get(1).split(","));
				if (actualParameterOptions.equals(expectedParameterOptions))
					continue;
				else
					return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void selectOptionsForFileParameters(String option, String optionValue) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _fileParameterList);
		WebElement getOptionElement = CoreFunctions.returnItemInListByText(driver, _fileParameterList, option);
		if (option.contains(MYLOConstants.STATUS) || option.contains(MYLOConstants.OFFICE)
				|| option.contains(MYLOConstants.COUNTRY) || option.contains(MYLOConstants.STATE)) {
			WebElement dropdowns = CoreFunctions.getElementByLocator(driver, getOptionElement,
					_dropdownSections);
			CoreFunctions.highlightElementAndClick(driver, dropdowns, dropdowns.getText());
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _selectOptions);
			CoreFunctions.selectItemInListByText(driver, _selectOptions, optionValue);
		} else {
			CoreFunctions.sendKeysUsingAction(driver, getOptionElement, optionValue);
		}
	}

	public boolean verifyPopUpMessage(String message) {
		try {
			clickExecuteButton();
			CoreFunctions.waitForBrowserToLoad(driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _popUpMessage, _popUpMessage.getText());
			Assert.assertEquals(_popUpMessage.getText(), message, MYLOConstants.INCORRECT_MESSAGE);
			CoreFunctions.click(driver, _okButton, _okButton.getText());
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public void resetFileParameters() {
		closePopUp();
		clickOptionFromMainMenu(MYLOConstants.ASSIGNMENT);
		selectParameterFromQueryScreen(MYLOConstants.FILE);
	}

	public boolean verifyQueryResults(String colName, String colValue) {
		try {

			CoreFunctions.explicitWaitTillElementListVisibilityWithTime(driver, _queryResultRows, 60);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _headerText, _headerText.getText());
			Assert.assertEquals(_headerText.getText(), MYLOConstants.QUERY_RESULT_HEADER_TEXT);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _queryResultRows);
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _queryResultColHeaders, colName);
			List<WebElement> allValueElements = new ArrayList<>();
			List<Integer> fileIDs = new ArrayList<>();
			for (int i = 0; i < _queryResultRows.size(); i++) {
				allValueElements = CoreFunctions.getElementsByLocator(driver, _queryResultRows.get(i),
						_queryResultColumns);
				if (!(colName.equalsIgnoreCase(MYLOConstants.FILE_ID)))
					Assert.assertEquals(allValueElements.get(index).getText(), colValue);
				else
					fileIDs.add(Integer.parseInt(allValueElements.get(index).getText()));
			}
			if (!(fileIDs.isEmpty())) {
				List<Integer> copyFileIDs = new ArrayList<>(fileIDs);
				Collections.sort(copyFileIDs);
				Assert.assertTrue(fileIDs.equals(copyFileIDs), MYLOConstants.INCORRECT_FILEID_SORTING);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
