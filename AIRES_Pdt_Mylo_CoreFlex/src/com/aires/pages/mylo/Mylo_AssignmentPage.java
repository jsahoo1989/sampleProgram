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
	private WebElement _NoButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement _YesButton;

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
	
	@FindBy(how = How.XPATH, using = "//ng-select[@name='policyType']")
	private WebElement _fileInfoPolicyTypeBgColor;
	
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

	/**
	 * @param option 
	 * Click Different tabs in Assignment page
	 */
	public void clickAssignmentTabs(String option) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _assignmentSubMenus);
		CoreFunctions.selectItemInListByText(driver, _assignmentSubMenus, option);
	}

	/**
	 * @param tabName
	 * @return 
	 * Verify Active tab in Assignment page
	 */
	public boolean verifyActiveTab(String tabName) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _assignmentSubMenus);
		noOfAiresFileTeamMember = _noOfAddedAiresFileTeamMember.size();
		airesFileTeamExistingMembers = CoreFunctions.returnMapFromBothLists(driver, _airesFileTeamRoleName,
				_airesFileTeamMemberName);
		WebElement tabElement = CoreFunctions.returnItemInListByText(driver, _assignmentSubMenus, tabName);
		return (tabElement.getAttribute("class").contains("active")) ? true : false;
	}

	// *************** Aires File Team Section***********************//

	/**
	 * @param buttonName 
	 * Click Different Buttons on Aires File Team section
	 */
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
			CoreFunctions.click(driver, _NoButton, _NoButton.getText());
			break;
		case MYLOConstants.YES_BUTTON:
			CoreFunctions.click(driver, _YesButton, _YesButton.getText());
			break;
		}
	}

	/**
	 * @param roleName 
	 * Add Role By Name on Aires File Team section
	 */
	public void addRole(String roleName) {
		CoreFunctions.click(driver, _roleSelectButtton, _roleSelectButtton.getAttribute(MYLOConstants.NAME));
		CoreFunctions.selectItemInListByText(driver, CoreFunctions.getElementListByLocator(driver, _dropdownOptions),
				roleName);
	}

	/**
	 * @param userType
	 * @param roleName
	 * @return
	 * Verifying Role availability for specific Users on Aires File Team section
	 */
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

	/**
	 * @param roleName
	 * @return
	 * Verifying Role availability in the dropdown on Aires File Team section
	 */
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

	/**
	 * @param memberName
	 * Add Team Member By Name or Random selection on Aires File Team section
	 */
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

	/**
	 * @param roleName
	 * @return
	 * Verify Team Member which is displaying not available in the dropdown on Aires File Team section
	 */
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

	/**
	 * @param msg
	 * @return
	 * Verifying the Warning Message Text on Aires File Team section
	 */
	public boolean verifyPopUpMessage(String msg) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _popUpMessage, _popUpMessage.getText());
			Assert.assertEquals(_popUpMessage.getText(), msg);
		} catch (Throwable e) {
			return false;
		}
		return true;
	}

	/**
	 * @return
	 * Verifying any Role Added on Aires File Team section
	 */
	public boolean verifyRowAddedInAiresFileTeam() {
		return (_noOfAddedAiresFileTeamMember.size() != noOfAiresFileTeamMember) ? true : false;
	}

	/**
	 * @param roleName
	 * @return
	 * Verifying the Updated Team Member by RoleName along with fields associated with it
	 */
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

	/**
	 * @return
	 * Verifying all fields Displaying on Aires File Team section are readonly
	 */
	public boolean verifyAiresFileTeamRecordsReadonly() {
		for (WebElement element : _airesFileTeamMemberGrid) {
			if (element.getAttribute(MYLOConstants.CLASS).contains(MYLOConstants.MYLO_READONLY))
				continue;
			else
				return false;
		}
		return true;
	}

	// ***************Aires File Information Section***********************//

	/**
	 * @param buttonName
	 * Click Different Buttons on Aires File Information section
	 */
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
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoEditButton, _fileInfoEditButton.getText());
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
		case MYLOConstants.NO_BUTTON:
			CoreFunctions.click(driver, _NoButton, _NoButton.getText());
			break;
		case MYLOConstants.YES_BUTTON:
			CoreFunctions.click(driver, _YesButton, _YesButton.getText());
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_BUTTON_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_BUTTON_NAME);
		}
	}

	/**
	 * @param fileID
	 * @param clientIDandName
	 * @param policyType
	 * @return
	 * Verifying Field Values displayed on Aires File Information section
	 */
	public boolean verifyFileInfoDisplayedFields(String fileID, String clientIDandName, String policyType) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoFileId, _fileInfoFileId.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoClientId, _fileInfoClientId.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoPolicyType, _fileInfoPolicyType.getText());
		if (_fileInfoFileId.getAttribute(CoreConstants.VALUE).equals(fileID)
				&& _fileInfoClientId.getAttribute(CoreConstants.VALUE).equals(clientIDandName)
				&& _fileInfoPolicyType.getText().equals(policyType)) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FIELD_NAME_VALUE_DISPLAYED, CoreConstants.PASS,
					_fileInfoFileId.getAttribute(MYLOConstants.NAME), fileID, MYLOConstants.AIRES_FILE_INFORMATION,
					MYLOConstants.ASSIGNMENT));
			return true;
		}
		return false;
	}
	
	
	/**
	 * @param fieldName
	 * @param propertyType
	 * @param expectedValue
	 * @return
	 * Verifying CSS Property Value of Elements available in any section
	 */
	public boolean verifyElementCSSValue(String fieldName, String propertyType, String expectedValue) {
			String code = null;
			switch (fieldName) {
			case MYLOConstants.POLICY_TYPE:
				code=CoreFunctions.getElementCSSProperty(driver, _fileInfoPolicyTypeBgColor, propertyType);
				break;
			case MYLOConstants.FILE_ID:
				code=CoreFunctions.getElementCSSProperty(driver, _fileInfoFileId, propertyType);
				break;
			case MYLOConstants.CLIENT_ID:
				code=CoreFunctions.getElementCSSProperty(driver, _fileInfoClientId, propertyType);
				break;
			default:
				Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
				Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			}
			if(code.equals(expectedValue))
				return true;
			return false;
	}
	


	/**
	 * Mapping the AiresFileInformation WebElements with associated fields
	 */
	public void mapFileInfoWebElementFields() {
		airesFileInfoFieldsMap.put(MYLOConstants.POLICY_TYPE, _fileInfoPolicyType);
		airesFileInfoFieldsMap.put(MYLOConstants.STATUS, _fileInfoStatus);
		airesFileInfoFieldsMap.put(MYLOConstants.OFFICE, _fileInfoOffice);
		airesFileInfoFieldsMap.put(MYLOConstants.TRANSFER_TYPE, _fileInfoTransferType);
		airesFileInfoFieldsMap.put(MYLOConstants.JOURNEY_TYPE, _fileInfoJourneyType);
		airesFileInfoFieldsMap.put(MYLOConstants.HOMESTATUS, _fileInfoHomeStatus);
	}

	/**
	 * @return
	 * Verifying Additional Fields displayed on Aires File Information section after clicking on Details Carrot button
	 */
	public boolean verifyFileInfoAdditionalFieldsDisplayed() {
		if (CoreFunctions.verifyElementPresentOnPage(_fileInfoTaxTreatmentSection,
				_fileInfoTaxTreatmentSection.getText())
				&& CoreFunctions.verifyElementPresentOnPage(_fileInfoStatus, _fileInfoStatus.getText())
				&& CoreFunctions.verifyElementPresentOnPage(_fileInfoProvider, _fileInfoProvider.getText())
				&& CoreFunctions.verifyElementPresentOnPage(_fileInfoEditButton, _fileInfoEditButton.getText())) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, _fileInfoTaxTreatmentSection.getText()));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, _fileInfoStatus.getText()));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, _fileInfoProvider.getText()));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, _fileInfoEditButton.getText()));
			return true;
		}
		Reporter.addStepLog(
				MessageFormat.format(CoreConstants.VRFIED_ELE_NOT_ON_PAGE, CoreConstants.FAIL, _fileInfoEditButton.getText()));
		return false;
	}

	/**
	 * @param fieldName
	 * @return
	 * Get value of specific fields by FieldName on Aires File Information section
	 */
	public String getFileInfoFieldValue(String fieldName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, airesFileInfoFieldsMap.get(fieldName),
					airesFileInfoFieldsMap.get(fieldName).getText());
		} catch (Exception e) {
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FIELD_NAME_VALUE_DISPLAYED, CoreConstants.PASS,
				fieldName, airesFileInfoFieldsMap.get(fieldName).getText(), MYLOConstants.AIRES_FILE_INFORMATION,
				MYLOConstants.ASSIGNMENT));
		System.out.println(airesFileInfoFieldsMap.get(fieldName).getText());
		return airesFileInfoFieldsMap.get(fieldName).getText();
	}

	/**
	 * @param scenarioType
	 * @param fieldName
	 * @throws InterruptedException
	 * Verifying Fields ReadOnly status for different Users and Different File Type on Aires File Information section
	 */
	public void verifyFileInfoFieldsForScenarioType(String scenarioType, String fieldName) throws InterruptedException {
		switch (scenarioType) {
		case MYLOConstants.USER_WITHOUT_RESOURCE300096:
		case MYLOConstants.NOT_AIRESSH_PROVIDER:
		case MYLOConstants.AFFINITY_ENABLED:
			Assert.assertFalse(verifyFileInfoFieldsReadOnly(fieldName));
			break;
		case MYLOConstants.USER_WITH_RESOURCE300096:
		case MYLOConstants.AIRESSH_PROVIDER:
		case MYLOConstants.NOT_AFFINITY_ENABLED:
			Assert.assertTrue(verifyFileInfoFieldsReadOnly(fieldName));
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_SCENARIO_TYPE);
			Assert.fail(MYLOConstants.ENTER_CORRECT_SCENARIO_TYPE);
		}
	}

	/**
	 * @param elementName
	 * @return
	 * Verifying Fields ReadOnly status by FieldName on Aires File Information section
	 */
	public boolean verifyFileInfoFieldsReadOnly(String fieldName) {
		switch (fieldName) {
		case MYLOConstants.POLICY_TYPE:
			return CoreFunctions.isElementPresent(driver, _fileInfoPolicyTypeDropdownReadOnly, 2,
					MYLOConstants.POLICY_TYPE_READONLY);
		case MYLOConstants.OFFICE:
			return CoreFunctions.isElementPresent(driver, _fileInfoOfficeDropdownReadOnly, 2, MYLOConstants.OFFICE_READONLY);
		case MYLOConstants.EDIT_BUTTON:
			return CoreFunctions.isElementVisible(_fileInfoEditButton);
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
		return false;
	}

	/**
	 * @param chechboxText
	 * @return
	 * Verify checkbox is Selected or Not on Aires File Information section
	 */
	public boolean verifyFileInfoCheckboxSelected(String chechboxText) {
		if (chechboxText.equals(MYLOConstants.RANDOM))
			return BusinessFunctions.returnItemFromListUsingAttribute(driver, _fileInfoCheckBoxText,
					updatedFileInfoCheckboxSelected, MYLOConstants.NAME).isSelected();
		else
			return BusinessFunctions
					.returnItemFromListUsingAttribute(driver, _fileInfoCheckBoxText, chechboxText, MYLOConstants.NAME)
					.isSelected();
	}

	/**
	 * @param checkboxName
	 * @param checkBoxStatus
	 * Verify checkbox is Selected or Not according to the checkBoxStatus provided
	 */
	public void verifyFileInfoCheckBoxIsChecked(String checkboxName, String checkBoxStatus) {
		if (checkBoxStatus.equals(MYLOConstants.CHECKED))
			Assert.assertTrue(verifyFileInfoCheckboxSelected(checkboxName));
		else
			Assert.assertFalse(verifyFileInfoCheckboxSelected(checkboxName));
	}

	/**
	 * @param chechboxText
	 * Click on CheckBox by CheckboxName or Random Selection on Aires File Information section
	 */
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

	/**
	 * @param fieldName
	 * @param options
	 * @return
	 * Select Random Dropdown options By fieldName on Aires File Information section
	 */
	public String selectRandomDropdownOptions(String fieldName, List<WebElement> options) {
		WebElement element = null;
		String selectedText;
		do {
			element = (fieldName.equals(MYLOConstants.POLICY_TYPE )||fieldName.equals(MYLOConstants.JOURNEY_TYPE)) ? options.get(CoreFunctions.getRandomNumber(2, 4))
					: options.get(CoreFunctions.getRandomNumber(1, options.size()));
			selectedText = element.getText();
		} while (element.getText() == airesFileInfoFieldsMap.get(fieldName).getText());
		CoreFunctions.clickElement(driver, element);
		return selectedText;

	}

	/**
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 * Select DropDown options by FieldName from fieldValue or Randomly and Return the Text which is selected on Aires File Information section
	 */
	public String selectDropdownOptionsAndReturnText(String fieldName, String fieldValue) {
		String selectedText = null;
		List<WebElement> allOptions = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		if (fieldValue.equals(MYLOConstants.RANDOM)) {
			selectedText = selectRandomDropdownOptions(fieldName, allOptions);
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.RANDOM_VALUE_UPDATED_ON_SECTION, CoreConstants.PASS,
					selectedText, fieldName, MYLOConstants.AIRES_FILE_INFORMATION, MYLOConstants.ASSIGNMENT));
		} else {
			if (fieldValue != airesFileInfoFieldsMap.get(fieldName).getText())
				selectedText = CoreFunctions.returnItemInListByText(driver, allOptions, fieldValue).getText();
			CoreFunctions.clickElement(driver, CoreFunctions.returnItemInListByText(driver, allOptions, fieldValue));
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VALUE_UPDATED_ON_SECTION, CoreConstants.PASS,
					selectedText, fieldName, MYLOConstants.AIRES_FILE_INFORMATION, MYLOConstants.ASSIGNMENT));
		}
		return selectedText;
	}

	/**
	 * @param fieldName
	 * @param fieldValue
	 * Update Field Values by Field Name on Aires File Information section
	 */
	public void updateFileInfoFields(String fieldName, String fieldValue) {
		CoreFunctions.click(driver, airesFileInfoFieldsMap.get(fieldName),
				airesFileInfoFieldsMap.get(fieldName).getText());
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

	/**
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 * Verify Passed Value present in the Dropdown fields By FieldName on Aires File Information section
	 */
	public boolean verifyFileInfoDropDownValues(String fieldName, String fieldValue) {
		CoreFunctions.click(driver, airesFileInfoFieldsMap.get(fieldName),
				airesFileInfoFieldsMap.get(fieldName).getText());
		List<WebElement> allOptions = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		return CoreFunctions.searchElementExistsInListByText(driver, allOptions, fieldValue);
	}

	/**
	 * @param buttonName
	 * Verify Fields Updated or Nor Depending upon the option selected on Aires File Information section
	 */
	public void verifyFileInfoFieldsOnClickedButton(String buttonName) {
		if (buttonName.equals(MYLOConstants.CANCEL_BUTTON)) {
			CoreFunctions.explicitWaitTillElementVisibility(driver,_fileInfoEditButton, _fileInfoEditButton.getText(), 5);
			clickButtonOnAiresFileInformationSection(MYLOConstants.EDIT_BUTTON);
			Assert.assertFalse(verifyFileInfoUpdatedFields(MYLOConstants.JOURNEY_TYPE));
			Assert.assertFalse(verifyFileInfoUpdatedFields(MYLOConstants.HOMESTATUS));
			Assert.assertFalse(verifyFileInfoCheckboxSelected(MYLOConstants.INHERITED_FILE));
		}

		else if (buttonName.equals(MYLOConstants.SAVE_BUTTON)) {
			Assert.assertTrue(verifyMessage(MYLOConstants.SUCCESS_MESSAGE));
			clickButtonOnAiresFileInformationSection(MYLOConstants.OK_BUTTON);
			Assert.assertTrue(verifyFileInfoUpdatedFields(MYLOConstants.POLICY_TYPE));
			Assert.assertTrue(verifyFileInfoUpdatedFields(MYLOConstants.JOURNEY_TYPE));
			Assert.assertTrue(verifyFileInfoUpdatedFields(MYLOConstants.HOMESTATUS));
			Assert.assertTrue(verifyFileInfoCheckboxSelected(MYLOConstants.INHERITED_FILE));
			resetFileInfoField();
		}
	}
	
	/**
	 * Resetting File Information fields to earlier values
	 */
	public void resetFileInfoField() {
		clickButtonOnAiresFileInformationSection(MYLOConstants.EDIT_BUTTON);
		updateFileInfoFields(MYLOConstants.POLICY_TYPE, MYLOConstants.POLICY_TYPE_VALUE);
		updateFileInfoFields(MYLOConstants.JOURNEY_TYPE, MYLOConstants.JOURNEY_TYPE_VALUE);
		updateFileInfoFields(MYLOConstants.HOMESTATUS, MYLOConstants.HOMESTATUS_VALUE);
		clickCheckBoxOnAiresFileInfoSection(MYLOConstants.INHERITED_FILE);
		clickButtonOnAiresFileInformationSection(MYLOConstants.SAVE_BUTTON);
		Assert.assertTrue(verifyMessage(MYLOConstants.SUCCESS_MESSAGE));
		clickButtonOnAiresFileInformationSection(MYLOConstants.OK_BUTTON);
	}

	/**
	 * @param fieldName
	 * @return
	 * Verifying Fields getting updated or not on Aires File Information section
	 */
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
	

	/**
	 * @param messageType
	 * @return
	 * Verify Success Message on Aires File Information section 
	 */
	public boolean verifyMessage(String messageType) {
		switch (messageType) {
		case MYLOConstants.SUCCESS_MESSAGE:
			return _fileInfoSuccessMessage.getText().equals(MYLOConstants.FILE_INFO_SUCCESS_MESSAGE);
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return false;

	}

	/**
	 * @param fileStatusMode
	 * @param requiredField
	 * @return
	 * Retrieve Required Assignment Field Data from json file based on the fileStatusMode
	 */
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
		case MYLOConstants.LUMP_SUM_PLAN_POLICY:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.lumpSumpPlanPolicyType.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.lumpSumpPlanPolicyType.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.lumpSumpPlanPolicyType.clientName);
			break;
		case MYLOConstants.DOMESTIC_POLICY:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.domesticPolicyType.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.domesticPolicyType.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.domesticPolicyType.clientName);
			break;
		case MYLOConstants.ACTIVE_ASSIGNMENT:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.activeAssignment.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.activeAssignment.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.activeAssignment.clientName);
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return fileInfoDetailsmap.get(requiredField);

	}

}