package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.utilities.MyloNewFileUtil;
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

	@FindBy(how = How.CSS, using = "div[class='firstmenu'] li")
	private List<WebElement> _firstMenuOptions;

	@FindBy(how = How.CSS, using = "div[class='container']")
	private List<WebElement> _selectQueryParameterRows;

	@FindBy(how = How.CSS, using = "button[class*='mylo-query-btn']")
	private List<WebElement> _selectQueryParameterButtons;

	@FindBy(how = How.CSS, using = "span[class='ng-arrow-wrapper']")
	private List<WebElement> _parameterDropdownList;

	@FindBy(how = How.CSS, using = "button[class='btn-close']")
	private WebElement _closeButton;

	@FindBy(how = How.CSS, using = "span[class='ng-option-label ng-star-inserted']")
	private List<WebElement> _selectOptions;

	@FindBy(how = How.CSS, using = "div[class='mylo-popup'] input")
	private List<WebElement> _fileParameterList;

	@FindBy(how = How.CSS, using = "h1[class='popupheader']")
	private WebElement _queryTypeHeader;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _errorText;

	@FindBy(how = How.CSS, using = "h5[class='modal-title']")
	private WebElement _assignmentOptionHeader;

	@FindBy(how = How.CSS, using = "div[class='mylo-popup'] label")
	private List<WebElement> _fileParameterOptions;

	@FindBy(how = How.CSS, using = "div[class$='custom-container']")
	private WebElement _fileParameterPopUp;

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

	@FindBy(how = How.CSS, using = "div[class='mylo-grid-warea']")
	private WebElement _queryResultGrid;

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

	@FindBy(how = How.CSS, using = "app-searchmyfile label[class='form-check-label']")
	private List<WebElement> _myFilesCheckboxTextList;

	@FindBy(how = How.CSS, using = "app-searchmyfile span[class='check']")
	private List<WebElement> _myFilesCheckboxList;

	@FindBy(how = How.CSS, using = "app-searchmyfile input[type='checkbox']")
	private List<WebElement> _myFilesCheckboxSelected;

	@FindBy(how = How.ID, using = "fileStatus")
	private WebElement _myFilesFileStatus;

	@FindBy(how = How.XPATH, using = "//cdk-virtual-scroll-viewport//ul/li[1]")
	private List<WebElement> _myFilesFileIDs;

	@FindBy(how = How.XPATH, using = "//cdk-virtual-scroll-viewport//ul/li[2]")
	private List<WebElement> _myFilesClientNames;

	@FindBy(how = How.XPATH, using = "//cdk-virtual-scroll-viewport//ul/li[3]")
	private List<WebElement> _myFilesTransfereeNames;

	@FindBy(how = How.XPATH, using = "//cdk-virtual-scroll-viewport//ul/li[6]")
	private List<WebElement> _myFilesStatusResult;

	@FindBy(how = How.CSS, using = ".errortext")
	private WebElement _errorPopUpText;

	@FindBy(how = How.CSS, using = "app-query-result")
	private WebElement _queryResultPopUp;

	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	private WebElement _cancelBtn;

	@FindBy(how = How.CSS, using = "h4 b")
	private WebElement _fileID;

	@FindBy(how = How.CSS, using = "div[class='mylo-grid']  i[class*='icon-Caret']")
	private List<WebElement> _columnCaretBtn;

	@FindBy(how = How.CSS, using = "ul[class='mylo-grid-header'] li")
	private List<WebElement> _queryResultColHeader;

	@FindBy(how = How.XPATH, using = "//button[text()='New Query']")
	private WebElement _newQueryBtn;

	@FindBy(how = How.CSS, using = "app-search-query")
	private WebElement _myFilesPopUp;

	private final By _queryResultColumns = By.xpath("./li");
	private final By _journeySubSections = By.cssSelector("#collapseSummary a");
	private final By _queryResultFileIds = By.xpath("//ul[@class='even ng-star-inserted']/li[1]");
	private final By _dropdownOptions = By.cssSelector("div[role='option']>span");
	private List<String> fileParameterDropdownFields = Arrays.asList(MYLOConstants.STATUS, MYLOConstants.OFFICE,
			MYLOConstants.ORIGIN_COUNTRY, MYLOConstants.DESTINATION_COUNTRY, MYLOConstants.ORIGIN_STATE,
			MYLOConstants.DESTINATION_STATE);
	private List<String> fileIds = new ArrayList<String>();
	String updatedStatusValue = "", updatedCheckboxValue = "", sortColName = "";
	LinkedHashMap<String, List<WebElement>> queryResultWebElementsMap = new LinkedHashMap<String, List<WebElement>>();
	LinkedHashMap<String, WebElement> myFilesWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> databaseColNameMap = new LinkedHashMap<String, String>();

	/**
	 * Map all the Team Post buttons with there respective locators
	 */
	public void mapQueryResultColumnWebElements() {
		queryResultWebElementsMap.put(MYLOConstants.FILEID, _myFilesFileIDs);
		queryResultWebElementsMap.put(MYLOConstants.CLIENTNAME, _myFilesClientNames);
		queryResultWebElementsMap.put(MYLOConstants.TRANSFEREENAME, _myFilesTransfereeNames);
		queryResultWebElementsMap.put(MYLOConstants.STATUS, _myFilesStatusResult);
	}

	public void mapMyFilesWebElements() {
		myFilesWebElementsMap.put(MYLOConstants.FILE_STATUS, _myFilesFileStatus);
		myFilesWebElementsMap.put(MYLOConstants.EXECUTE, _executeButton);
		myFilesWebElementsMap.put(MYLOConstants.NEW_QUERY, _newQueryBtn);
		myFilesWebElementsMap.put(MYLOConstants.CANCEL_BUTTON, _cancelBtn);
	}

	public void mapDatabaseColumnNames() {
		databaseColNameMap.put(MYLOConstants.CLIENT__NAME, MYLOConstants.CLIENTNAME);
		databaseColNameMap.put(MYLOConstants.FILE_ID, MYLOConstants.FILEID);
		databaseColNameMap.put(MYLOConstants.JOURNEY_TYPE, MYLOConstants.JOURNEYTYPE);
		databaseColNameMap.put(MYLOConstants.TRANSFEREE_NAME, MYLOConstants.TRANSFEREENAME);
		databaseColNameMap.put(MYLOConstants.ORIGIN, MYLOConstants.ORIGIN);
		databaseColNameMap.put(MYLOConstants.DESTINATION, MYLOConstants.DESTINATION);
		databaseColNameMap.put(MYLOConstants.BOOKED, MYLOConstants.BOOKED);
		databaseColNameMap.put(MYLOConstants.STATUS, MYLOConstants.STATUS);
	}

	/**
	 * Verify UserName Logged In
	 * 
	 * @param userName
	 * @return
	 */
	public boolean verifyUserName(String userName) {
		boolean flag = false;
		try {
			CoreFunctions.waitForBrowserToLoad(driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _userProfile, userName);
			flag = userName.equals(CoreFunctions.getElementText(driver, _userProfile));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					userName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_SECTION_DISPLAYED, CoreConstants.PASS,
					userName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
		return flag;
	}

	/**
	 * Clicks on Main Menu Option based on parameter option name passed
	 * 
	 * @param option
	 */
	public void clickOptionFromMainMenu(String option) {
		try {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _firstMenuOptions);
			CoreFunctions.selectItemInListByText(driver, _firstMenuOptions, option);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, option));
		}
	}

	/**
	 * Clicks on Close icon present in the PopUp
	 */
	public void closePopUp() {
		try {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _popupModal, _popupModal.getText(), 10L);
			CoreFunctions.highlightElementAndClick(driver, _closeButton, _closeButton.getText());
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.CLOSE_POPUP));
		}
	}

	/**
	 * Clicks on Execute Button on Query Section
	 */
	public void clickExecuteButton() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _executeButton, _executeButton.getText(), 10);
			CoreFunctions.highlightElementAndClick(driver, _executeButton, _executeButton.getText());
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			clickOkIfPopUpExist();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.EXECUTE));
		}
	}

	/**
	 * Clicks on Ok Button if PopUp appears
	 */
	public void clickOkIfPopUpExist() {
		if (CoreFunctions.isElementExist(driver, _okButtonPopUp, 2)) {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _okButtonPopUp, MYLOConstants.OK_BUTTON);
			CoreFunctions.clickUsingJS(driver, _okButtonPopUp, MYLOConstants.OK_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		}
	}

	/**
	 * Clicks on Sub Menu Options based on parameter passed
	 * 
	 * @param optionName
	 */
	public void selectOptionsFromAssignmentMenu(String optionName) {
		try {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.isElementByLocatorExist(driver, _journeySubSections, MYLOConstants.CUSTOM_WAIT_TIME);
			List<WebElement> journeySubSectionList = CoreFunctions.getElementListByLocator(driver, _journeySubSections);
			CoreFunctions.selectItemInListByText(driver, journeySubSectionList, optionName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.OK_BUTTON));
		}
	}

	/**
	 * Verify Options Available for Query Parameters
	 * 
	 * @param table
	 * @return
	 */
	public boolean verifySelectQueryOptions(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		try {
			List<String> expectedOptions = Arrays.asList(data.get(0).get(MYLOConstants.PARAMETERS).split(","));
			List<String> actualOptionsDisplayed = _selectQueryParameterButtons.stream().map(x -> x.getText().trim())
					.collect(Collectors.toList());
			flag = (actualOptionsDisplayed.equals(expectedOptions));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, MYLOConstants.QUERY_PARAMETERS));
		}
		return flag;
	}

	/**
	 * Clicks on Query Options based on parameter passed
	 * 
	 * @param parameter
	 */
	public void selectParameterFromQueryScreen(String parameter) {
		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _selectQueryParameterButtons);
			CoreFunctions.selectItemInListByText(driver, _selectQueryParameterButtons, parameter);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, parameter));
		}
	}

	/**
	 * Verify Options Available for Select Parameter PopUp
	 * 
	 * @param table
	 * @return
	 */
	public boolean verifyFileParameterOptions(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		try {
			List<String> expectedOptions = Arrays.asList(data.get(0).get(MYLOConstants.PARAMETERS).split(","));
			List<String> actualOptionsDisplayed = _fileParameterOptions.stream().map(x -> x.getText().trim())
					.collect(Collectors.toList());
			flag = (actualOptionsDisplayed.equals(expectedOptions));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, MYLOConstants.QUERY_PARAMETERS));
		}
		return flag;
	}

	/**
	 * Set file query options based on parameter passed for option name and value
	 * 
	 * @param option
	 * @param optionValue
	 */
	public void selectOptionsForFileParameters(String option, String optionValue) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _fileParameterPopUp,
				MYLOConstants.FILE_PARAMETERS_POPUP, 30);
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _fileParameterOptions, option);
		try {
			if (fileParameterDropdownFields.contains(option)) {
				CoreFunctions.click(driver, _fileParameterList.get(index), option);
				BusinessFunctions.setMyloDropdownFields(driver, _dropdownOptions, optionValue, option);
			} else
				CoreFunctions.sendKeysUsingAction(driver, _fileParameterList.get(index), optionValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, option));
		}
	}

	/**
	 * Create a New File if it doesn't exist
	 * 
	 * @param clientID
	 * @param myloNewFileSection
	 * @param myloNewFileUtil
	 */
	public void createNewFileIfNotExists(String clientID, MyloJourneyPage_CreateNewFileSection myloNewFileSection) {
		if (MyloNewFileUtil.getFileID() != null) {
			selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
			selectParameterFromQueryScreen(MYLOConstants.FILE);
			selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getFileID());
			clickExecuteButton();
		} else {
			selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
			myloNewFileSection.createNewFile(clientID);
		}
	}
	
	public void createNewFileIfNotCreated(String clientID, MyloJourneyPage_CreateNewFileSection myloNewFileSection) {
		if (MyloNewFileUtil.getFileID() == null) {
			selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
			myloNewFileSection.createNewFile(clientID);
		} 
	}

	/**
	 * Verify File ParametersPopUpMessage After Clicking on Execute Button
	 * 
	 * @param message
	 * @return
	 */
	public boolean verifyPopUpMessageAfterExecute(String message) {
		boolean flag = false;
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _executeButton, _executeButton.getText(), 20);
			CoreFunctions.highlightElementAndClick(driver, _executeButton, _executeButton.getText());
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _popUpMessage, _popUpMessage.getText(), 60);
			flag = (CoreFunctions.getElementText(driver, _popUpMessage).equals(message));
			CoreFunctions.clickElement(driver, _OKButtonPopUp);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP_MESSAGE_PAGE, MYLOConstants.JOURNEY));
		}
		return flag;
	}

	/**
	 * Loading File Parameters again
	 */
	public void resetFileParameters() {
		closePopUp();
		selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		selectParameterFromQueryScreen(MYLOConstants.FILE);
	}

	/**
	 * Verify Query Results based on the parameter passed
	 * 
	 * @param colName
	 * @param colValue
	 * @return
	 */
	public boolean verifyQueryResults(String colName, String colValue) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _queryResultGrid, MYLOConstants.QUERY_RESULTS, 30);
			Assert.assertEquals(CoreFunctions.getElementText(driver, _headerText),
					MYLOConstants.QUERY_RESULT_HEADER_TEXT);
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _queryResultColHeaders, colName);
			List<WebElement> allValueElements = new ArrayList<>();
			for (int i = 0; i < _queryResultRows.size(); i++) {
				allValueElements = CoreFunctions.getElementsByLocator(driver, _queryResultRows.get(i),
						_queryResultColumns);
				Assert.assertEquals(CoreFunctions.getElementText(driver, allValueElements.get(index)), colValue);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, MYLOConstants.QUERY_RESULTS));
		}
		return true;
	}

	/**
	 * Select File Status dropdown field on My Files section
	 * 
	 * @param statusValue
	 */
	public void selectFileStatus(String statusValue) {
		clickFieldsOnMyFilesSection(MYLOConstants.FILE_STATUS);
		updatedStatusValue = BusinessFunctions.setMyloDropdownFields(driver, _dropdownOptions, statusValue,
				MYLOConstants.FILE_STATUS);
	}

	/**
	 * Select Checkbox on My Files section based on the checkbox name passed
	 * 
	 * @param checkboxValue
	 */
	public void selectMyFilesCheckBox(String checkboxValue) {
		try {
			if (checkboxValue != MYLOConstants.NONE) {
				int index = (checkboxValue.equals(MYLOConstants.RANDOM))
						? CoreFunctions.getRandomNumber(0, _myFilesCheckboxTextList.size())
						: BusinessFunctions.returnindexItemFromListUsingText(driver, _myFilesCheckboxTextList,
								checkboxValue);
				updatedCheckboxValue = CoreFunctions.getElementText(driver, _myFilesCheckboxTextList.get(index));
				CoreFunctions.click(driver, _myFilesCheckboxList.get(index), updatedCheckboxValue);
			} else
				updatedCheckboxValue = checkboxValue;

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, checkboxValue));
		}
	}

	/**
	 * Deselect the Checkbox if selected on MyFiles section
	 */
	public void resetMyFilesCheckbox() {
		for (int i = 0; i < _myFilesCheckboxSelected.size(); i++) {
			if (_myFilesCheckboxSelected.get(i).isSelected())
				CoreFunctions.click(driver, _myFilesCheckboxList.get(i), _myFilesCheckboxTextList.get(i).getText());
		}
	}

	/**
	 * Check whether MyFiles Result appears for given status & checkbox selected
	 *
	 */
	public void isMyFilesResultsExist() {
		if (CoreFunctions.isElementExist(driver, _OKButtonPopUp, 2)) {
			Assert.assertEquals(CoreFunctions.getElementText(driver, _errorPopUpText),
					MYLOConstants.NO_SUCH_FILE_FOUND);
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.NO_SUCH_FILE_FOUND_STATUS_CHECKBOX,
					CoreConstants.PASS, updatedStatusValue, updatedCheckboxValue));
			CoreFunctions.clickUsingJS(driver, _OKButtonPopUp, MYLOConstants.OK_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} else {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.SINGLE_FILE_FOUND_STATUS_CHECKBOX,
					CoreConstants.PASS,CoreFunctions.getElementText(driver, _fileID) , updatedStatusValue, updatedCheckboxValue));
			selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
			selectParameterFromQueryScreen(MYLOConstants.MY_FILES);
		}
	}

	/**
	 * Select different options if No Such File Found or single file found for
	 * selected status and checkbox
	 * 
	 * @param statusValue
	 * @param checkboxValue
	 */
	public void checkMyFilesResultModalAppears(String statusValue, String checkboxValue) {
		while (!(CoreFunctions.isElementExist(driver, _queryResultPopUp, 5))) {
			isMyFilesResultsExist();
			resetMyFilesCheckbox();
			selectFileStatus(statusValue);
			selectMyFilesCheckBox(checkboxValue);
			clickFieldsOnMyFilesSection(MYLOConstants.EXECUTE);
		}
	}

	/**
	 * Verify My Files Query Result from the Database
	 * 
	 * @param empNo
	 * @param reqColumnValue
	 * @param type
	 * @return
	 */
	public boolean verifyMyFilesResultFromDB(String empNo, String reqColumnValue, String type) {
		mapQueryResultColumnWebElements();
		boolean flag = false;
		String noOfRecordsToValidate = CoreFunctions.getPropertyFromConfig(MYLOConstants.MAX_RECORDS_TO_VALIDATE);
		updatedCheckboxValue = (updatedCheckboxValue.equals(MYLOConstants.BLANK)) ? MYLOConstants.NONE
				: updatedCheckboxValue;
		try {
			List<String> DBList = DbFunctions.getMyFilesInfoByStatusAndCheckBox(empNo, updatedStatusValue,
					updatedCheckboxValue, reqColumnValue, noOfRecordsToValidate, type);
			flag = DBList.equals(queryResultWebElementsMap.get(reqColumnValue).stream().limit(DBList.size())
					.map(x -> CoreFunctions.getElementText(driver, x)).collect(Collectors.toList()));

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, MYLOConstants.QUERY_RESULTS));
		}

		if (flag)
			Reporter.addStepLog(
					MessageFormat.format(MYLOConstants.VERIFIED_RESULTS_MATCH_WITH_DATABSE, CoreConstants.PASS,
							reqColumnValue, MYLOConstants.MY_FILES, updatedStatusValue, updatedCheckboxValue));
		return flag;
	}

	/**
	 * Verify All checkboxes available on My Files section
	 * 
	 * @param table
	 * @return
	 */
	public boolean verifyMyFilesCheckBoxesDisplayed(DataTable table) {
		List<String> expectedCheckBoxOptionDisplayed = table.asMaps(String.class, String.class).stream()
				.map(x -> x.get(MYLOConstants.CHECKBOXES)).collect(Collectors.toList());
		boolean flag = expectedCheckBoxOptionDisplayed.equals(_myFilesCheckboxTextList.stream()
				.map(x -> CoreFunctions.getElementText(driver, x)).collect(Collectors.toList()));
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_OPTIONS_MATCHES,
					CoreConstants.PASS, MYLOConstants.MY_FILES));
		return flag;
	}

	/**
	 * Click on any field available on the MyFiles section based on the fieldName
	 * passed as parameter
	 * 
	 * @param fieldName
	 */
	public void clickFieldsOnMyFilesSection(String fieldName) {
		mapMyFilesWebElements();
		try {
			WebElement element = myFilesWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.MY_FILES));
		}
	}

	/**
	 * Verify All File Status Options available on My Files section
	 * 
	 * @param table
	 * @return
	 */
	public boolean verifyStatusOptionsDisplayed(DataTable table) {
		List<String> expectedStatusOptions = table.asMaps(String.class, String.class).stream()
				.map(x -> x.get(MYLOConstants.STATUS)).collect(Collectors.toList());
		boolean flag = expectedStatusOptions.equals(CoreFunctions.getElementListByLocator(driver, _dropdownOptions)
				.stream().map(x -> CoreFunctions.getElementText(driver, x)).collect(Collectors.toList()));
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MATCHES,
					CoreConstants.PASS, MYLOConstants.FILE_STATUS, MYLOConstants.MY_FILES));
		return flag;
	}

	/**
	 * Click on Caret Button of column passed as parameter on results section for
	 * sorting
	 * 
	 * @param colName
	 * @return
	 */
	public String clickColumnCaretButton(String colName) {
		try {
			int index = (colName.equals(MYLOConstants.RANDOM))
					? CoreFunctions.getRandomNumber(0, _queryResultColHeader.size())
					: BusinessFunctions.returnindexItemFromListUsingText(driver, _queryResultColHeader, colName);
			sortColName = CoreFunctions.getElementText(driver, _queryResultColHeader.get(index));
			CoreFunctions.click(driver, _columnCaretBtn.get(index), sortColName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, colName));
		}
		return sortColName;
	}

	/**
	 * Verify My Files Query Result Sorting Order from the Database
	 * 
	 * @param empNo
	 * @param sortingOrder
	 * @return
	 */
	public boolean verifyMyFilesSortResultFromDB(String empNo, String sortingOrder) {
		mapDatabaseColumnNames();
		boolean flag = false;
		String noOfRecordsToValidate = CoreFunctions.getPropertyFromConfig(MYLOConstants.MAX_RECORDS_TO_VALIDATE);
		try {
			List<String> DBList = DbFunctions.getMyFilesSortResult(empNo, updatedStatusValue,
					databaseColNameMap.get(sortColName), sortingOrder, noOfRecordsToValidate);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			List<WebElement> _resultFileIDs = CoreFunctions.getElementListByLocator(driver, _queryResultFileIds);
			flag = DBList.equals(_resultFileIDs.stream().limit(DBList.size())
					.map(x -> CoreFunctions.getElementText(driver, x)).collect(Collectors.toList()));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, MYLOConstants.QUERY_RESULTS));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_FIELDS_SORTED, CoreConstants.PASS,
					MYLOConstants.MY_FILES_QUERY_RESULT, sortColName, sortingOrder));
		return flag;
	}

	public boolean verifyMyFilesPopUpDisplayed() {
		boolean flag = CoreFunctions.isElementExist(driver, _myFilesPopUp, 5);
		return flag;
	}

	/**
	 * Execute Different File IDs
	 * 
	 * @param count
	 * @param fileIds
	 */
	public void executeDifferentFileIds(int count, List<String> fileIds) {
		clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		for (int i = 0; i < count; i++) {
			selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
			selectParameterFromQueryScreen(MYLOConstants.FILE);
			selectOptionsForFileParameters(MYLOConstants.FILE_ID, fileIds.get(i));
			clickExecuteButton();
		}
	}

	public void scrollClickFileIds(String fileId) {
		boolean flag = true;
		while (flag) {
			List<WebElement> fileIdsResult2 = CoreFunctions.getElementListByLocator(driver, _queryResultFileIds);
			List<String> fileIdDetails = new ArrayList<String>();
			fileIdDetails.addAll(fileIdsResult2.stream().map(x -> x.getText()).collect(Collectors.toList()));
			if (fileIdDetails.contains(fileId)) {
				CoreFunctions.scrollClickUsingJS(driver, fileIdsResult2.get(fileIdDetails.indexOf(fileId)), fileId);
				flag = false;
			} else {
				CoreFunctions.scrollClickUsingJS(driver, fileIdsResult2.get(fileIdsResult2.size() - 1), fileId);
			}
		}
	}

	public void navigateActFinanceSectionForDifffileIds(int maxLimit) {
		int flag = 0;
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
				BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
				CoreFunctions.clickOnElementIfExist(driver, _okButtonPopUp, MYLOConstants.OK_BUTTON, 6);
				CoreFunctions.clickOnElementIfExist(driver, _diffPersonDntLinkBtn,
						MYLOConstants.DIFFERENT_PERSON_DONOT_LINK, 6);
				BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
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
		String ctr = "5";
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
