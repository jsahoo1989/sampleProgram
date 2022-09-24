package com.aires.pages.mylo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class Mylo_DashboardHomePage extends Base {

	public Mylo_DashboardHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "mat-dialog-container[class*='mat-dialog-container']")
	private WebElement _popupModal;

	@FindBy(how = How.CSS, using = "div[id='user-profile'] span +span")
	private WebElement _userProfile;

	@FindBy(how = How.CSS, using = "div[class='firstmenu'] span")
	private List<WebElement> _firstMenuOptions;

	@FindBy(how = How.CSS, using = "div[class='container']")
	private List<WebElement> _selectQueryParameterRows;

	@FindBy(how = How.CSS, using = "button[class='mylo-query-btn']")
	private List<WebElement> _selectQueryParameterButtons;
	
	@FindBy(how = How.CSS, using = "span[class='ng-arrow-wrapper']")
	private List<WebElement> _parameterDropdownList;

	@FindBy(how = How.CSS, using = "button[class='btn-close']")
	private WebElement _closeButton;

	@FindBy(how = How.CSS, using = "span[class='ng-option-label ng-star-inserted']")
	private List<WebElement> _selectOptions;

	@FindBy(how = How.CSS, using = "td[scope='col'] label")
	private List<WebElement> _fileParameterList;
	
	@FindBy(how = How.CSS, using = "h1[class='popupheader']")
	private WebElement _queryTypeHeader;
	
	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _errorText;
	
	@FindBy(how = How.CSS, using = "h5[class='modal-title']")
	private WebElement _assignmentOptionHeader;

	@FindBy(how = How.CSS, using = "div[class='mylo-popup'] tr")
	private List<WebElement> _fileParameterRows;

	@FindBy(how = How.CSS, using = "button[type='submit']")
	private WebElement _executeButton;
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "div[role='dialog'] h1")
	private WebElement _popUpMessage;

	@FindBy(how = How.CSS, using = "ul[class='even ng-star-inserted']")
	private List<WebElement> _queryResultRows;

	@FindBy(how = How.CSS, using = "ul[class='mylo-grid-header'] li")
	private List<WebElement> _queryResultColHeaders;

	@FindBy(how = How.CSS, using = "h5[class='modal-title']")
	private WebElement _headerText;
	
	@FindBy(how = How.CSS, using = "#collapseSummary a")
	private List<WebElement> _assignmentOptions;
	
	
	@FindBy(how = How.CSS, using = "mat-dialog-container[role='dialog']")
	private WebElement _dialogBox;
	
	@FindBy(how = How.CSS, using = "div[role='dialog']")
	private WebElement _myloErrorPopUp;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Ok']")
	private WebElement _okButtonPopUp;
	
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	private WebElement _OKButtonPopUp;
	
	@FindBy(how = How.CSS, using = "app-aires-file-information")
	private WebElement _fileInformationSection;
	
	@FindBy(how = How.XPATH, using = "//canvas[@data-id!='canvas']")
	private WebElement _webswingSection;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Open File']")
	private WebElement _openFileBtn;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Next']")
	private WebElement _resultNextBtn;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Recall Query']")
	private WebElement _recallQueryBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@class='webswing-banner']/span[3]")
	private WebElement _webswingBannerFileId;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Different Person, Do Not Link']")
	private WebElement _diffPersonDntLinkBtn;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Jump to:']/parent::div/descendant::input[@type='text']")
	private WebElement _jumpToPageInsert;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Jump to:']/parent::div/descendant::ng-select")
	private WebElement _jumpToPageDropdown;
	
	@FindBy(how = How.XPATH, using = "//mat-dialog-container")
	private WebElement myloPopUpQueryResult;
	
	@FindBy(how = How.CSS, using = "div[class='fileuser-info']")
	private List<WebElement> _historyCards;
	
	@FindBy(how = How.CSS, using = "span[class='fileid']")
	private List<WebElement> _fileIdHistoryCard;
			

	final By _selectQueryoptions = By.xpath("./button");
	final By _fileParameterOptions = By.xpath(".//following-sibling::label");
	final By _queryResultColumns = By.xpath("./li");
	final By _dropdownSections = By.xpath(".//parent::div/ng-select");
	final By _journeySubSections = By.cssSelector("#collapseSummary a");
	public By _pageJumpTo = By.cssSelector("div[role='option'] span");
	public By _queryResultFileIds = By.xpath("//ul[@class='even ng-star-inserted']/li[1]");

			
	LinkedHashMap<String, Integer> parameterDropdownFieldsMap = new LinkedHashMap<String, Integer>();
	List<String> fileIds= new ArrayList<String>();

	public boolean verifyUserName(String userName) {
		CoreFunctions.waitForBrowserToLoad(driver);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _userProfile, _userProfile.getText());
		Log.info("userName is : " + _userProfile.getText());
		CoreFunctions.highlightObject(driver, _userProfile);
		boolean flag=userName.equals(_userProfile.getText());
		return flag;
	}

	public void clickOptionFromMainMenu(String option) {
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 60);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _firstMenuOptions);
		CoreFunctions.selectItemInListByText(driver, _firstMenuOptions, option);
	}
	
	public boolean verifyJourneyHeaderText() {
		CoreFunctions.highlightObject(driver, _assignmentOptionHeader);
		boolean flag = (_assignmentOptionHeader.getText().equals(MYLOConstants.ASSIGNMENT_OPTIONS_HEADER));
		return flag;
	}

	public void closePopUp() {
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 60);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _popupModal, _popupModal.getText(), 10L);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _closeButton, _closeButton.getText(), 10L);
		CoreFunctions.highlightElementAndClick(driver, _closeButton, _closeButton.getText());
	}

	public void clickExecuteButton() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _executeButton, _executeButton.getText(), 10);
		CoreFunctions.highlightElementAndClick(driver, _executeButton, _executeButton.getText());
		CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		if (CoreFunctions.isElementExist(driver, _okButtonPopUp, 2)) {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _okButtonPopUp, MYLOConstants.OK_BUTTON);
			CoreFunctions.clickUsingJS(driver, _okButtonPopUp, MYLOConstants.OK_BUTTON);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		}
	}
	
	public void selectOptionsFromAssignmentMenu(String optionToBeSelected) {
		CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		List<WebElement> journeySubSectionList = CoreFunctions.waitTillElementListSizeNotEmpty(driver,
				_journeySubSections);
		CoreFunctions.selectItemInListByText(driver, journeySubSectionList, optionToBeSelected);
		CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		Assert.assertTrue((optionToBeSelected.equals(MYLOConstants.QUERY_FILE))
				? CoreFunctions.getElementText(driver, _assignmentOptionHeader).equals(MYLOConstants.ASSIGNMENT_QUERYTYPE_HEADER)
				:(optionToBeSelected.equals(MYLOConstants.NEW_FILE_BUTTON))
				? CoreFunctions.getElementText(driver, _assignmentOptionHeader).equals(MYLOConstants.CREATE_NEW_FILE)
				:CoreFunctions.isElementExist(driver, _webswingSection, 60));
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
		CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
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
		parameterDropdownFieldsMap.put(MYLOConstants.DESTINATION_COUNTRY, 4);
	}

	public void selectOptionsForFileParameters(String option, String optionValue) {
		
		while(_fileParameterList.size()==0) {
			selectParameterFromQueryScreen(MYLOConstants.FILE);
		}
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
			CoreFunctions.explicitWaitTillElementVisibility(driver, _executeButton, _executeButton.getText(), 20L);
			CoreFunctions.highlightElementAndClick(driver, _executeButton, _executeButton.getText());
			if (CoreFunctions.isElementExist(driver, _spinner, 30)
					|| CoreFunctions.isElementExist(driver, _myloErrorPopUp, 5)) {
				CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 60);
				CoreFunctions.explicitWaitTillElementVisibility(driver, _popUpMessage, _popUpMessage.getText());
				Assert.assertEquals(_popUpMessage.getText(), message, MYLOConstants.INCORRECT_MESSAGE);
				CoreFunctions.clickElement(driver, _OKButtonPopUp);
				CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 60);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void resetFileParameters() {
		closePopUp();
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
		clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		for (int i = 0; i < count; i++) {
			selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
			selectParameterFromQueryScreen(MYLOConstants.FILE);
			selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileIds.get(i));
			clickExecuteButton();
		}
	}
	
	public void clickOKInPopUpWindow() {
		if (CoreFunctions.isElementExist(driver, _errorText, 10)) {
			CoreFunctions.highlightObject(driver, _errorText);
			CoreFunctions.click(driver, _okButtonPopUp, MYLOConstants.OK_BUTTON);
	}
	}
	
	
	public void clickPopUpsIfExist() {
		if (CoreFunctions.isElementExist(driver, _okButtonPopUp, 6)) {
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
			CoreFunctions.click(driver, _okButtonPopUp, MYLOConstants.OK_BUTTON);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		}  
		
		if (CoreFunctions.isElementExist(driver, _diffPersonDntLinkBtn, 6)) {
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
			CoreFunctions.click(driver, _diffPersonDntLinkBtn, MYLOConstants.DIFFERENT_PERSON_DONOT_LINK);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		}
	}
	
	
	
	
	
	public void scrollClickFileIds(String fileId) {
		boolean flag=true;
		while (flag) {
			List<WebElement> fileIdsResult2 = CoreFunctions.getElementListByLocator(driver, _queryResultFileIds);
			List<String> fileIdDetails = new ArrayList<String>();
			fileIdDetails.addAll(fileIdsResult2.stream().map(x -> x.getText()).collect(Collectors.toList()));
			if (fileIdDetails.contains(fileId)) {
				CoreFunctions.scrollClickUsingJS(driver, fileIdsResult2.get(fileIdDetails.indexOf(fileId)), "Y");
				flag=false;
			} else {
				CoreFunctions.scrollClickUsingJS(driver, fileIdsResult2.get(fileIdsResult2.size() - 1), "Y");
			}
		}
	}
	
	
	public void navigateActFinanceSectionForDifffileIds(int maxLimit) {
		int flag=0;			
		String fileId = "";	
		while (flag < 200) {
			for (int j = 0; j < 10; j++) {
				List<WebElement> fileIdsResult = CoreFunctions.getElementListByLocator(driver, _queryResultFileIds);
				fileId = CoreFunctions.getElementText(driver, fileIdsResult.get(j));
				if (fileIds.contains(fileId))
					continue;
				Reporter.addStepLog("<b><i>FileID_</i></b>" + flag + 1 + ": " + fileId);
				CoreFunctions.waitHandler(2);
				CoreFunctions.click(driver, fileIdsResult.get(j), fileId);
				CoreFunctions.click(driver, _openFileBtn, "Open File Button");
				fileIds.add(fileId);
				flag++;
				CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
				clickPopUpsIfExist();
				CoreConstants.TIME_AFTER_ACTION = new Date().getTime();
				selectOptionsFromAssignmentMenu("Activity & Finance");
				CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
				Assert.assertTrue(CoreFunctions.isElementExist(driver, _webswingSection, 60));
				CoreConstants.TIME_BEFORE_ACTION = new Date().getTime();
				Reporter.addStepLog("<b>Total time taken to load <i>WebSwing</i> section is :" + CoreFunctions
						.calculatePageLoadTime(CoreConstants.TIME_BEFORE_ACTION, CoreConstants.TIME_AFTER_ACTION)
						+ " Seconds </b>");
				CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _recallQueryBtn, "Recall Query Button");
				CoreFunctions.clickElement(driver, _recallQueryBtn);
				CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
				CoreFunctions.explicitWaitTillElementVisibility(driver, myloPopUpQueryResult, "Mylo PopUp", 60);
			}
				scrollClickFileIds(fileId);
		}
			
	}
	
	public void loadAlternateFiles() {
		String ctr = System.getProperty("noOfTimes");
		int max = Integer.parseInt(ctr);
		for (int i = 0; i < max; i++) {
			CoreFunctions.explicitWaitTillElementListClickable(driver, _historyCards);
			int index = CoreFunctions.getRandomNumber(0, _historyCards.size());
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
			CoreFunctions.click(driver, _historyCards.get(index), _fileIdHistoryCard.get(index).getText());
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		}
	}

}
