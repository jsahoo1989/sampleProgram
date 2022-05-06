package com.aires.pages.mylo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
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

	@FindBy(how = How.XPATH, using = "//ul[@class='menu-list']/li/a")
	private List<WebElement> _hamburgerMenuOptions;

	@FindBy(how = How.XPATH, using = "//div[@class='firstmenu']/ul/li/a")
	private List<WebElement> _firstMenuOptions;

	@FindBy(how = How.CSS, using = "div[class='container']")
	private List<WebElement> _selectQueryParameterRows;

	@FindBy(how = How.CSS, using = "button[class='btn btn-primary modal-md-blue-btn']")
	private List<WebElement> _selectQueryParameterButtons;
	
	@FindBy(how = How.CSS, using = "span[class='ng-arrow-wrapper']")
	private List<WebElement> _parameterDropdownList;

	@FindBy(how = How.CSS, using = "button[class='btn-close']")
	private WebElement _closeButton;

	@FindBy(how = How.XPATH, using = "//*[@role='option']/span")
	private List<WebElement> _selectOptions;

	@FindBy(how = How.XPATH, using = "//h5[@class='modal-title']//following::label")
	private List<WebElement> _fileParameterList;
	
	@FindBy(how = How.CSS, using = "h1[class='popupheader']")
	private WebElement _queryTypeHeader;
	
	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _errorText;
	
	@FindBy(how = How.CSS, using = "h5[class='modal-title']")
	private WebElement _assignmentOptionHeader;

	@FindBy(how = How.XPATH, using = "//tbody[@class='scrollbody']/tr")
	private List<WebElement> _fileParameterRows;

	@FindBy(how = How.XPATH, using = "//button[text()='Execute']")
	private WebElement _executeButton;
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	private WebElement _okButton;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Ok']")
	private WebElement _popUpOkButton;

	@FindBy(how = How.XPATH, using = "//div[@role='dialog']//h1")
	private WebElement _popUpMessage;

	@FindBy(how = How.XPATH, using = "//ul[@class='even ng-star-inserted']")
	private List<WebElement> _queryResultRows;

	@FindBy(how = How.XPATH, using = "//ul[@class='mylo-grid-header']/li")
	private List<WebElement> _queryResultColHeaders;

	@FindBy(how = How.XPATH, using = "//h5")
	private WebElement _headerText;
	
	@FindBy(how = How.CSS, using = "button[class='btn btn-primary modal-md-blue-btn']")
	private List<WebElement> _assignmentOptions;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'mylo-errorpopup')]")
	private WebElement _myloErrorPopUp;
	
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	private WebElement _OKButtonPopUp;
			

	final By _selectQueryoptions = By.xpath("./button");
	final By _fileParameterOptions = By.xpath(".//following-sibling::label");
	final By _queryResultColumns = By.xpath("./li");
	final By _dropdownSections = By.xpath(".//parent::div/ng-select");
	LinkedHashMap<String, Integer> parameterDropdownFieldsMap = new LinkedHashMap<String, Integer>();

	public boolean verifyUserName(String userName) {
		CoreFunctions.waitForBrowserToLoad(driver);
		Log.info("userName is : " + _userProfile.getText());
		CoreFunctions.highlightObject(driver, _userProfile);
		if(_userProfile.getText().length()>2) {
			clickOptionFromMainMenu(MYLOConstants.HOME);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 60);
		}
		boolean flag = userName.equals(_userProfile.getText());
		return flag;
	}

	public void clickOptionFromMainMenu(String option) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _firstMenuOptions);
		CoreFunctions.selectItemInListByText(driver, _firstMenuOptions, option);
	}
	
	public boolean verifyJourneyHeaderText() {
		CoreFunctions.highlightObject(driver, _assignmentOptionHeader);
		boolean flag = (_assignmentOptionHeader.getText().equals(MYLOConstants.ASSIGNMENT_OPTIONS_HEADER));
		return flag;
	}

	public void closePopUp() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _popupModal, _popupModal.getText(), 10L);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _closeButton, _closeButton.getText(), 10L);
		CoreFunctions.highlightElementAndClick(driver, _closeButton, _closeButton.getText());
	}

	public void clickExecuteButton() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _executeButton, _executeButton.getText(), 20L);
		CoreFunctions.highlightElementAndClick(driver, _executeButton, _executeButton.getText());
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 60);
		if (CoreFunctions.isElementExist(driver, _myloErrorPopUp, 5) &&
				CoreFunctions.isElementExist(driver, _OKButtonPopUp, 5)) {			
			CoreFunctions.clickElement(driver, _OKButtonPopUp);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 60);
		}
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
	
	public void selectOptionsFromAssignmentMenu(String optionToBeSelected) {
		CoreFunctions.explicitWaitTillElementListVisibilityCustomTime(driver, _assignmentOptions,60);
		CoreFunctions.selectItemInListByText(driver, _assignmentOptions, optionToBeSelected);
		CoreFunctions.highlightObject(driver, _assignmentOptionHeader);
		Assert.assertEquals(_assignmentOptionHeader.getText(), MYLOConstants.ASSIGNMENT_QUERYTYPE_HEADER, MYLOConstants.MISMATCH_HEADERTEXT);
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
		CoreFunctions.highlightObject(driver, _assignmentOptionHeader);
		Assert.assertEquals(_assignmentOptionHeader.getText(), MYLOConstants.ASSIGNMENT_PARAMETERTYPE_HEADER, MYLOConstants.MISMATCH_HEADERTEXT);
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 10);
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
	
	public void mapParameterDropdownFields() {
		parameterDropdownFieldsMap.put(MYLOConstants.STATUS, 0);
		parameterDropdownFieldsMap.put(MYLOConstants.OFFICE, 1);
		parameterDropdownFieldsMap.put(MYLOConstants.ORIGIN_COUNTRY, 2);
		//parameterDropdownFieldsMap.put(MYLOConstants.ORIGIN_STATE, 3);
		parameterDropdownFieldsMap.put(MYLOConstants.DESTINATION_COUNTRY, 4);
		//parameterDropdownFieldsMap.put(MYLOConstants.DESTINATION_STATE, 5);
	}

	public void selectOptionsForFileParameters(String option, String optionValue) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _fileParameterList);
		WebElement getOptionElement = CoreFunctions.returnItemInListByText(driver, _fileParameterList, option);
		if (option.contains(MYLOConstants.STATUS) || option.contains(MYLOConstants.OFFICE)
				|| option.contains(MYLOConstants.COUNTRY) || option.contains(MYLOConstants.STATE)) {
			mapParameterDropdownFields();
			CoreFunctions.click(driver, _parameterDropdownList.get(parameterDropdownFieldsMap.get(option)), option);
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
		clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
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
	
	public void executeDifferentFileIds(int count, List<String> fileIds) {
		for (int i = 0; i < count; i++) {
			clickOptionFromMainMenu(MYLOConstants.JOURNEY);
			selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
			selectParameterFromQueryScreen(MYLOConstants.FILE);
			selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileIds.get(i));
			clickExecuteButton();
			//clickOKInPopUpWindow();
		}
	}
	
	public void clickOKInPopUpWindow() {
		if (CoreFunctions.isElementExist(driver, _errorText, 10)) {
			CoreFunctions.highlightObject(driver, _errorText);
			CoreFunctions.click(driver, _popUpOkButton, MYLOConstants.OK_BUTTON);
	}
	}

}
