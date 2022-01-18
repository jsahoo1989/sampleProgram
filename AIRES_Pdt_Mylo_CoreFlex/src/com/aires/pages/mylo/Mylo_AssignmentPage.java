package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.MyloAssignmentDetails;
import com.vimalselvam.cucumber.listener.Reporter;

public class Mylo_AssignmentPage extends Base {

	public Mylo_AssignmentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "input[id='empName']")
	private List<WebElement> _airesFileTeamMemberName;

	@FindBy(how = How.CSS, using = "input[id='startDate']")
	private List<WebElement> _airesFileTeamStartDates;

	@FindBy(how = How.CSS, using = "input[id='endDate']")
	private List<WebElement> _airesFileTeamEndDates;

	@FindBy(how = How.CSS, using = "input[id='empFunctionCode']")
	private List<WebElement> _airesFileTeamRoleName;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'navlist__container')]/li/a")
	private List<WebElement> _assignmentSubMenus;

	@FindBy(how = How.XPATH, using = "//label[text()='Role']//preceding-sibling::ng-select")
	private WebElement _roleSelectButtton;

	@FindBy(how = How.XPATH, using = "//label[text()='Name']//preceding-sibling::ng-select")
	private WebElement _memberNameSelectButtton;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/parent::td/following-sibling::td/button")
	private WebElement _airesFileTeamAddButton;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/parent::td/following-sibling::td/button[text()='Save']")
	private WebElement _airesFileTeamSaveButton;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/following::tbody[1]/tr")
	private List<WebElement> _noOfAddedAiresFileTeamMember;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _popUpMessage;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/ancestor::tr/following-sibling::tbody/descendant::input")
	private List<WebElement> _airesFileTeamMemberGrid;

	@FindBy(how = How.XPATH, using = "//button[text()='No' and contains(@class,'smallbutton')]")
	private WebElement _airesFileTeamNoButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement _airesFileTeamYesButton;

	@FindBy(how = How.CSS, using = "input[placeholder='FILE ID']")
	private WebElement _fileInfoFileId;

	@FindBy(how = How.CSS, using = "input[placeholder='Client Id']")
	private WebElement _fileInfoClientId;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='policyType']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoPolicyType;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']/span")
	private WebElement _fileInfoDetailsCarrot;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='status']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoStatus;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='provider']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoProvider;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='office']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoOffice;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='transferType']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoTransferType;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='journeyType']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoJourneyType;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='homeStatus']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoHomeStatus;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']//following::div[@id='collapseOne']//span[@class='form-check-sign']")
	private List<WebElement> _fileInfoCheckboxes;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']//following::div[@id='collapseOne']//input[@type='checkbox']")
	private List<WebElement> _fileInfoCheckBoxText;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']//following::button[text()='Save']")
	private WebElement _fileInfoSaveButton;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']//following::button[text()='Cancel']")
	private WebElement _fileInfoCancelButton;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']//following::div[@id='collapseOne']//descendant::button[text()='Edit']")
	private WebElement _fileInfoEditButton;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='taxTreatment']")
	private WebElement _fileInfoTaxTreatmentSection;

	@FindBy(how = How.XPATH, using = "//div[@style='display: block;']")
	private WebElement _fileInfoSuccessMessage;

	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	private WebElement _fileInfoSuccessOkbutton;
	
	int noOfAiresFileTeamMember;
	String updatedTeamMember;
	LinkedHashMap<String, String> airesFileTeamExistingMembers = new LinkedHashMap<String, String>();
	LinkedHashMap<String, WebElement> airesFileInfoFieldsMap = new LinkedHashMap<String, WebElement>();

	final By _dropdownOptions = By.xpath("//div[@role='option']/span");
	final By _fileInfoOfficeDropdownReadOnly = By.xpath("//ng-select[@name='office']//descendant::input[@disabled='']");
	final By _fileInfoPolicyTypeDropdownReadOnly = By.xpath("//ng-select[@name='policyType']//input[@disabled]");

	MyloAssignmentDetails assignmentDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getAssignmentDetailsByApplication(MYLOConstants.IRIS);

	String updatedPolicyType, updatedTaxTreatment, updatedOffice, updatedJourneyType, updatedTransferType,
			updatedHomeStatus;
	String updatedFileInfoCheckboxSelected;

	public void clickAssignmentTabs(String option) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _assignmentSubMenus);
		CoreFunctions.selectItemInListByText(driver, _assignmentSubMenus, option);
	}

	public boolean verifyActiveTab(String tabName) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _assignmentSubMenus);
		noOfAiresFileTeamMember = _noOfAddedAiresFileTeamMember.size();
		airesFileTeamExistingMembers = CoreFunctions.returnMapFromBothLists(driver, _airesFileTeamRoleName,
				_airesFileTeamMemberName);
		WebElement tabElement = CoreFunctions.returnItemInListByText(driver, _assignmentSubMenus, tabName);
		return (tabElement.getAttribute("class").contains("active")) ? true : false;
	}

	public void clickButtonOnAiresFileTeamSection(String buttonName) {
		switch (buttonName) {
		case MYLOConstants.ADD_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamAddButton, _airesFileTeamAddButton.getText());
			break;
		case MYLOConstants.CANCEL_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamAddButton, _airesFileTeamAddButton.getText());
			break;
		case MYLOConstants.SAVE_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamSaveButton, _airesFileTeamSaveButton.getText());
			break;
		case MYLOConstants.NO_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamNoButton, _airesFileTeamNoButton.getText());
			break;
		case MYLOConstants.YES_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamYesButton, _airesFileTeamYesButton.getText());
			break;
		}
	}

	public void addRole(String roleName) {
		CoreFunctions.click(driver, _roleSelectButtton, _roleSelectButtton.getAttribute(MYLOConstants.NAME));
		CoreFunctions.selectItemInListByText(driver, CoreFunctions.getElementListByLocator(driver, _dropdownOptions),
				roleName);
	}

	public boolean verifyRoleAccessFromUserType(String userType, String roleName) {
		try {
			if (userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE15))
				Assert.assertFalse(verifyRoleInDropdown(roleName));
			else
				Assert.assertTrue(verifyRoleInDropdown(roleName));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean verifyRoleInDropdown(String roleName) {
		try {
			CoreFunctions.click(driver, _roleSelectButtton, _roleSelectButtton.getAttribute(MYLOConstants.NAME));
			List<WebElement> optionsList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			return CoreFunctions.searchElementExistsInListByText(driver, optionsList, roleName);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_DROPDOWN,
					CoreConstants.FAIL, roleName, MYLOConstants.ROLE_NAME));
			return false;
		}
	}

	public void addTeamMember(String memberName) {
		try {
			CoreFunctions.click(driver, _memberNameSelectButtton,
					_memberNameSelectButtton.getAttribute(MYLOConstants.NAME));
			List<WebElement> optionsList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			if (memberName != MYLOConstants.RANDOM) {
				CoreFunctions.selectItemInListByText(driver, optionsList, memberName);
				Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFY_ELEMENT_VALUE_ON_SECTION,
						CoreConstants.PASS, MYLOConstants.ROLE_NAME, memberName, MYLOConstants.AIRES_FILE_TEAM));
			} else {
				updatedTeamMember = CoreFunctions.getRandomElementValueFromList(driver, optionsList);
				CoreFunctions.selectItemInListByText(driver, optionsList, updatedTeamMember);
				Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFY_ELEMENT_VALUE_ON_SECTION,
						CoreConstants.PASS, MYLOConstants.ROLE_NAME, updatedTeamMember, MYLOConstants.AIRES_FILE_TEAM));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_DROPDOWN,
					CoreConstants.FAIL, memberName, MYLOConstants.MEMBER_NAME));
		}

	}

	public boolean verifyExistingTeamMemberInDropdown(String roleName) {
		try {
			CoreFunctions.click(driver, _memberNameSelectButtton,
					_memberNameSelectButtton.getAttribute(MYLOConstants.NAME));
			List<WebElement> optionsList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			return CoreFunctions.searchElementExistsInListByText(driver, optionsList,
					airesFileTeamExistingMembers.get(roleName));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_DROPDOWN,
					CoreConstants.FAIL, airesFileTeamExistingMembers.get(roleName), MYLOConstants.MEMBER_NAME));
			return false;
		}
	}

	public boolean verifyPopUpMessage(String msg) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _popUpMessage, _popUpMessage.getText());
			Assert.assertEquals(_popUpMessage.getText(), msg);
		} catch (Throwable e) {
			return false;
		}
		return true;
	}

	public boolean verifyRowAddedInAiresFileTeam() {
		return (_noOfAddedAiresFileTeamMember.size() != noOfAiresFileTeamMember) ? true : false;
	}

	public boolean verifyUpdatedRowAiresFileTeamSection(String roleName) {
		CoreFunctions.waitForBrowserToLoad(driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _airesFileTeamMemberGrid);
		List<String> allRoleNames = _airesFileTeamRoleName.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		List<String> allTeamMembers = _airesFileTeamMemberName.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		List<String> allStartDates = _airesFileTeamStartDates.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		List<String> allEndDates = _airesFileTeamEndDates.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		String currentDate = DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now());
		if (allTeamMembers.get(allRoleNames.indexOf(roleName)).trim().equals(updatedTeamMember)
				&& allStartDates.get(allRoleNames.indexOf(roleName)).trim().equals(currentDate)
				&& allEndDates.get(allRoleNames.indexOf(roleName)).trim().equals(MYLOConstants.ACTIVE)
				&& allEndDates.get(allRoleNames.lastIndexOf(roleName)).trim().equals(currentDate)) {

			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRYFD_UPDATED_ROW, CoreConstants.PASS, roleName,
					MYLOConstants.AIRES_FILE_TEAM));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_UPDATED_ROW, CoreConstants.FAIL, roleName,
				MYLOConstants.AIRES_FILE_TEAM));
		return false;
	}

	public boolean verifyAiresFileTeamRecordsReadonly() {
		for (WebElement element : _airesFileTeamMemberGrid) {
			if (element.getAttribute(MYLOConstants.CLASS).contains(MYLOConstants.MYLO_READONLY))
				continue;
			else
				return false;
		}
		return true;
	}

	public void clickButtonOnAiresFileInformationSection(String buttonName) {
		switch (buttonName) {
		case MYLOConstants.EDIT_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoEditButton, _fileInfoEditButton.getText());
			CoreFunctions.click(driver, _fileInfoEditButton, _fileInfoEditButton.getText());
			break;
		case MYLOConstants.CANCEL_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoCancelButton,
					_fileInfoCancelButton.getText());
			CoreFunctions.click(driver, _fileInfoCancelButton, _fileInfoCancelButton.getText());
			break;
		case MYLOConstants.SAVE_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoSaveButton, _fileInfoSaveButton.getText());
			CoreFunctions.click(driver, _fileInfoSaveButton, _fileInfoSaveButton.getText());
			break;
		case MYLOConstants.DETAILS_CARROT_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoDetailsCarrot,
					_fileInfoDetailsCarrot.getText());
			CoreFunctions.click(driver, _fileInfoDetailsCarrot, _fileInfoDetailsCarrot.getText());
			mapFileInfoWebElementFields();
			break;
		case MYLOConstants.OK_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoSuccessOkbutton,
					_fileInfoSuccessOkbutton.getText());
			CoreFunctions.click(driver, _fileInfoSuccessOkbutton, _fileInfoSuccessOkbutton.getText());
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_BUTTON_NAME);
		}
	}

	public boolean verifyFileInfoDisplayedFields(String fileID, String clientIDandName, String policyType) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoFileId, _fileInfoFileId.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoClientId, _fileInfoClientId.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoPolicyType, _fileInfoPolicyType.getText());
		if (_fileInfoFileId.getAttribute(CoreConstants.VALUE).equals(fileID)
				&& _fileInfoClientId.getAttribute(CoreConstants.VALUE).equals(clientIDandName)
				&& _fileInfoPolicyType.getText().equals(policyType))
			return true;
		return false;
	}

	public void mapFileInfoWebElementFields() {
		airesFileInfoFieldsMap.put(MYLOConstants.POLICY_TYPE, _fileInfoPolicyType);
		airesFileInfoFieldsMap.put(MYLOConstants.STATUS, _fileInfoStatus);
		airesFileInfoFieldsMap.put(MYLOConstants.OFFICE, _fileInfoOffice);
		airesFileInfoFieldsMap.put(MYLOConstants.TRANSFER_TYPE, _fileInfoTransferType);
		airesFileInfoFieldsMap.put(MYLOConstants.JOURNEY_TYPE, _fileInfoJourneyType);
		airesFileInfoFieldsMap.put(MYLOConstants.HOMESTATUS, _fileInfoHomeStatus);
	}

	public boolean verifyFileInfoAdditionalFieldsDisplayed() {
		if (CoreFunctions.verifyElementPresentOnPage(_fileInfoTaxTreatmentSection,
				_fileInfoTaxTreatmentSection.getText())
				&& CoreFunctions.verifyElementPresentOnPage(_fileInfoStatus, _fileInfoStatus.getText())
				&& CoreFunctions.verifyElementPresentOnPage(_fileInfoProvider, _fileInfoProvider.getText())
				&& CoreFunctions.verifyElementPresentOnPage(_fileInfoEditButton, _fileInfoEditButton.getText()))
			return true;
		return false;
	}

	public String getFileInfoFieldValue(String fieldName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, airesFileInfoFieldsMap.get(fieldName),
					airesFileInfoFieldsMap.get(fieldName).getText());
		} catch (Exception e) {
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return airesFileInfoFieldsMap.get(fieldName).getText();
	}

	public void verifyFileInfoFieldsForScenarioType(String scenarioType, String fieldName) throws InterruptedException {
		if (scenarioType.equals(MYLOConstants.USER_WITHOUT_RESOURCE300096))
			Assert.assertFalse(verifyFileInfoButtonsEnabled(fieldName));
		else if (scenarioType.equals(MYLOConstants.USER_WITH_RESOURCE300096))
			Assert.assertTrue(verifyFileInfoButtonsEnabled(fieldName));
		else if ((scenarioType.equals(MYLOConstants.AIRESSH_PROVIDER)||(scenarioType.equals(MYLOConstants.NOT_AFFINITY_ENABLED))))
			Assert.assertTrue(verifyFileInfoFieldsReadOnly(fieldName));
		else if (scenarioType.equals(MYLOConstants.NOT_AIRESSH_PROVIDER)||(scenarioType.equals(MYLOConstants.AFFINITY_ENABLED)))
			Assert.assertFalse(verifyFileInfoFieldsReadOnly(fieldName));
	}

	public boolean verifyFileInfoButtonsEnabled(String elementName) {
		switch (elementName) {
		case MYLOConstants.EDIT_BUTTON:
			return CoreFunctions.isElementVisible(_fileInfoEditButton);
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return false;
	}
	
	public boolean verifyFileInfoFieldsReadOnly(String elementName) {
		switch (elementName) {
		case MYLOConstants.POLICY_TYPE:
			return CoreFunctions.isElementPresent(driver, _fileInfoPolicyTypeDropdownReadOnly, 2);
		case MYLOConstants.OFFICE:
			return CoreFunctions.isElementPresent(driver, _fileInfoOfficeDropdownReadOnly, 2);
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return false;
	}

	public boolean verifyFileInfoCheckboxSelected(String chechboxText) {
		if (chechboxText.equals(MYLOConstants.RANDOM))
			return BusinessFunctions.returnItemFromListUsingAttribute(driver, _fileInfoCheckBoxText,
					updatedFileInfoCheckboxSelected, MYLOConstants.NAME).isSelected();
		else
			return BusinessFunctions
					.returnItemFromListUsingAttribute(driver, _fileInfoCheckBoxText, chechboxText, MYLOConstants.NAME)
					.isSelected();
	}

	public void clickCheckBoxOnAiresFileInfoSection(String chechboxText) {
		if (chechboxText.equals(MYLOConstants.RANDOM) && updatedFileInfoCheckboxSelected == null) {
			int randomIndex = CoreFunctions.getRandomNumber(0, _fileInfoCheckBoxText.size());
			updatedFileInfoCheckboxSelected = _fileInfoCheckBoxText.get(randomIndex).getAttribute(MYLOConstants.NAME);
			_fileInfoCheckboxes.get(randomIndex).click();
		} else if (chechboxText.equals(MYLOConstants.RANDOM) && updatedFileInfoCheckboxSelected != null) {
			_fileInfoCheckboxes.get(BusinessFunctions.returnindexItemFromListUsingAttribute(driver,
					_fileInfoCheckBoxText, updatedFileInfoCheckboxSelected, MYLOConstants.NAME)).click();
		} else {
			updatedFileInfoCheckboxSelected = chechboxText;
			_fileInfoCheckboxes.get(BusinessFunctions.returnindexItemFromListUsingAttribute(driver,
					_fileInfoCheckBoxText, chechboxText, MYLOConstants.NAME)).click();
		}
	}

	public String selectRandomDropdownOptions(String fieldName, List<WebElement> options) {
		WebElement element = null;
		String selectedText;
		do {
			element = (fieldName.equals(MYLOConstants.POLICY_TYPE)) ? options.get(CoreFunctions.getRandomNumber(2, 4))
					: options.get(CoreFunctions.getRandomNumber(1, options.size()));
			selectedText = element.getText();
		} while (element.getText() == airesFileInfoFieldsMap.get(fieldName).getText());
		CoreFunctions.clickElement(driver, element);
		return selectedText;

	}

	public String selectDropdownOptionsAndReturnText(String fieldName, String fieldValue) {
		String selectedText = null;
		List<WebElement> allOptions = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		if (fieldValue.equals(MYLOConstants.RANDOM)) {
			selectedText = selectRandomDropdownOptions(fieldName, allOptions);
		} else {
			if (fieldValue != airesFileInfoFieldsMap.get(fieldName).getText())
				selectedText = CoreFunctions.returnItemInListByText(driver, allOptions, fieldValue).getText();
			CoreFunctions.clickElement(driver, CoreFunctions.returnItemInListByText(driver, allOptions, fieldValue));
		}
		return selectedText;
	}

	public void updateFileInfoFields(String fieldName, String fieldValue) {
		try {
			CoreFunctions.click(driver, airesFileInfoFieldsMap.get(fieldName),
					airesFileInfoFieldsMap.get(fieldName).getText());
			
		} catch (Exception e) {
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		switch (fieldName) {
		case MYLOConstants.POLICY_TYPE:
			updatedPolicyType = selectDropdownOptionsAndReturnText(fieldName, fieldValue);
			break;
		case MYLOConstants.OFFICE:
			updatedOffice = selectDropdownOptionsAndReturnText(fieldName, fieldValue);
			break;
		case MYLOConstants.TRANSFER_TYPE:
			updatedTransferType = selectDropdownOptionsAndReturnText(fieldName, fieldValue);
			break;
		case MYLOConstants.JOURNEY_TYPE:
			updatedJourneyType = selectDropdownOptionsAndReturnText(fieldName, fieldValue);
			break;
		case MYLOConstants.HOMESTATUS:
			updatedHomeStatus = selectDropdownOptionsAndReturnText(fieldName, fieldValue);
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
	}

	public boolean verifyFileInfoUpdatedFields(String fieldName) {
		switch (fieldName) {
		case MYLOConstants.POLICY_TYPE:
			return updatedPolicyType.equals(getFileInfoFieldValue(fieldName));
		case MYLOConstants.OFFICE:
			return updatedOffice.equals(getFileInfoFieldValue(fieldName));
		case MYLOConstants.TRANSFER_TYPE:
			return updatedTransferType.equals(getFileInfoFieldValue(fieldName));
		case MYLOConstants.JOURNEY_TYPE:
			return updatedJourneyType.equals(getFileInfoFieldValue(fieldName));
		case MYLOConstants.HOMESTATUS:
			return updatedHomeStatus.equals(getFileInfoFieldValue(fieldName));
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return false;
	}

	public boolean verifyMessage(String messageType) {
		switch (messageType) {
		case MYLOConstants.SUCCESS_MESSAGE:
			return _fileInfoSuccessMessage.getText().equals(MYLOConstants.FILE_INFO_SUCCESS_MESSAGE);
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return false;

	}

	public String getFileDetailsDataByFieldAndStatus(String fileStatusMode, String requiredField) {
		LinkedHashMap<String, String> fileInfoDetailsmap = new LinkedHashMap<String, String>();
		switch (fileStatusMode) {
		case MYLOConstants.AFFINITY_ENABLED:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.affinityEnabled.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.affinityEnabled.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.affinityEnabled.clientName);
			break;
		case MYLOConstants.NOT_AFFINITY_ENABLED:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.affinityNotEnabled.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.affinityNotEnabled.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.affinityNotEnabled.clientName);
			break;
		case MYLOConstants.AIRESSH_PROVIDER:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.airesshProvider.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.airesshProvider.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.airesshProvider.clientName);
			break;
		case MYLOConstants.NOT_AIRESSH_PROVIDER:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.notairesshProvider.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.notairesshProvider.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.notairesshProvider.clientName);
			break;
		case MYLOConstants.CANCELED:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.canceledFile.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.canceledFile.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.canceledFile.clientName);
			break;
		case MYLOConstants.CLOSED:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.closedFile.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.closedFile.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.closedFile.clientName);
			break;
		case MYLOConstants.RELOCATION_POLICY:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.relocationPolicyType.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.relocationPolicyType.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.relocationPolicyType.clientName);
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return fileInfoDetailsmap.get(requiredField);

	}

}
