package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import com.aires.testdatatypes.mylo.Mylo_FileData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_CreateNewFileSection extends Base {

	public MyloJourneyPage_CreateNewFileSection(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "input[formcontrolname='firstName']")
	private WebElement _newFileFirstName;

	@FindBy(how = How.CSS, using = "input[formcontrolname='lastName']")
	private WebElement _newFileLastName;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='clientId'] input")
	private WebElement _newFileClientNameinput;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='officeCode']")
	private WebElement _newFileOfficeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='journeyTypeCode']")
	private WebElement _newFileJourneyTypeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='corporationPolicyId']")
	private WebElement _newFilePolicyTypeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='corporationPolicyId'] input[disabled]")
	private WebElement _newFilePolicyTypeDisabled;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='taxTreatment']")
	private WebElement _newFileTaxTreatmentDropdown;

	@FindBy(how = How.CSS, using = "input[formcontrolname='newRepatInd']+span")
	private WebElement _newFileRepatCheckbox;

	@FindBy(how = How.XPATH, using = "//button[text()='Create File']")
	private WebElement _btnCreateFile;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "app-aires-identification p a")
	private WebElement _identDocSection;

	@FindBy(how = How.CSS, using = "app-service-section p a")
	private WebElement _benefitsGlanceSection;

	@FindBy(how = How.CSS, using = "app-authorization-tracking p a")
	private WebElement _authTrackSection;

	@FindBy(how = How.CSS, using = "app-filenotepurplebubble b")
	private WebElement _purpleBubbleSectionFileId;

	@FindBy(how = How.CSS, using = "app-filenotepurplebubble h1")
	private WebElement _purpleBubbleSectionTransfereeName;

	@FindBy(how = How.CSS, using = "app-filenotepurplebubble h2")
	private WebElement _purpleBubbleSectionClientName;

	@FindBy(how = How.CSS, using = "app-aires-file-information input[placeholder='FILE ID']")
	private WebElement _fileInfoSectionFileId;

	@FindBy(how = How.CSS, using = "app-aires-file-information input[placeholder='Client Id']")
	private WebElement _fileInfoSectionClientName;

	@FindBy(how = How.CSS, using = "app-aires-file-information button[aria-controls='collapseOne']")
	private WebElement _fileInfoDetailsCarrot;

	@FindBy(how = How.CSS, using = "app-file-status div[class='FS_aboutuser FS_title']")
	private WebElement _cornerSectionClientName;

	@FindBy(how = How.CSS, using = "app-file-status div[class='FS_aboutuser']")
	private WebElement _cornerSectionTransfereeName;

	@FindBy(how = How.CSS, using = "app-file-status p[class='fileinfo_profitvalue_negative']")
	private WebElement _cornerSectionFileGrossProfit;

	@FindBy(how = How.CSS, using = "app-transferee div[class='T_aboutuser usertitle']")
	private WebElement _transfereeSectionTransfereeName;

	@FindBy(how = How.CSS, using = "app-primary div[class='T_aboutuser usertitle']")
	private WebElement _primaryContactSectionTransfereeName;

	@FindBy(how = How.CSS, using = "app-aires-file-teams #empFunctionCode")
	private List<WebElement> _fileTeamSectionRole;

	@FindBy(how = How.CSS, using = "app-aires-file-teams #empName")
	private List<WebElement> _fileTeamSectionName;

	@FindBy(how = How.CSS, using = "ng-select[name='policyType'] span[class *='ng-value-label']")
	private WebElement _fileInfoPolicyType;

	@FindBy(how = How.CSS, using = "ng-select[name='office'] span[class *='ng-value-label']")
	private WebElement _fileInfoOffice;

	@FindBy(how = How.CSS, using = "ng-select[name='journeyType'] span[class *='ng-value-label']")
	private WebElement _fileInfoJourneyType;

	@FindBy(how = How.CSS, using = "ng-select[name='taxTreatment'] span[class *='ng-value-label']")
	private WebElement _fileInfoTaxTreatment;

	@FindBy(how = How.CSS, using = "#repatriation")
	private WebElement _fileInfoRepatriationCheckbox;

	final By _dropdownOptions = By.cssSelector("div[role='option']>span");

	LinkedHashMap<String, WebElement> newFileWebElementsMap = new LinkedHashMap<String, WebElement>();

	Mylo_FileData myloNewFileData = FileReaderManager.getInstance().getMyloJsonReader()
			.getFileDataByFileType(MYLOConstants.CREATE_NEW_FILE);

	public void mapCreateNewFileWebElementFields() {
		newFileWebElementsMap.put(MYLOConstants.TRANSFEREE_FIRSTNAME, _newFileFirstName);
		newFileWebElementsMap.put(MYLOConstants.TRANSFEREE_LASTNAME, _newFileLastName);
		newFileWebElementsMap.put(MYLOConstants.CLIENT_NAME, _newFileClientNameinput);
		newFileWebElementsMap.put(MYLOConstants.OFFICE, _newFileOfficeDropdown);
		newFileWebElementsMap.put(MYLOConstants.JOURNEY_TYPE, _newFileJourneyTypeDropdown);
		newFileWebElementsMap.put(MYLOConstants.POLICY_TYPE, _newFilePolicyTypeDropdown);
		newFileWebElementsMap.put(MYLOConstants.TAX_TREATMENT, _newFileTaxTreatmentDropdown);
		newFileWebElementsMap.put(MYLOConstants.CREATE_NEW_FILE, _btnCreateFile);
	}

	/**
	 * @param fieldName
	 * @param fieldValue Set Value of different fields on New File section
	 */
	public void setNewFileFields(String fieldName, String fieldValue) {
		mapCreateNewFileWebElementFields();
		try {
			WebElement reqWebElement = newFileWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.CREATE_NEW_FILE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.CREATE_NEW_FILE));
		}
	}

	/**
	 * @param fieldName Click respective fields of New File section
	 */
	public void clickFieldsOnNewFileSection(String fieldName) {
		mapCreateNewFileWebElementFields();
		try {
			WebElement element = newFileWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 120);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName, 100);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.CREATE_NEW_FILE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.CREATE_NEW_FILE));
		}
	}

	public String setNewFileDropdownValues(String fieldName, String fieldValue) {
		clickFieldsOnNewFileSection(fieldName);
		String updatedValue = BusinessFunctions.setDifferentDropDownFieldsForMylo(driver, _dropdownOptions, fieldValue);
		return updatedValue;
	}

	/**
	 * @param table
	 * @return Verify Toast Messages for Mandatory Fields of Create New File section
	 */
	public void verifyMandatoryFieldsToastMessagesCreateNewFileSection(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setNewFileFields(MYLOConstants.TRANSFEREE_FIRSTNAME, data.get(i).get(MYLOConstants.TRANSFEREE_FIRSTNAME));
			setNewFileFields(MYLOConstants.TRANSFEREE_LASTNAME, data.get(i).get(MYLOConstants.TRANSFEREE_LASTNAME));
			setNewFileDropdownValues(MYLOConstants.OFFICE, data.get(i).get(MYLOConstants.OFFICE));
			setNewFileFields(MYLOConstants.CLIENT_NAME, data.get(i).get(MYLOConstants.CLIENT_NAME));
			if (!(data.get(i).get(MYLOConstants.CLIENT_NAME).equals(""))) {
				CoreFunctions.hoverAndClick(driver,
						CoreFunctions.getElementListByLocator(driver, _dropdownOptions).get(0),
						data.get(i).get(MYLOConstants.CLIENT_NAME));
			}
			setNewFileDropdownValues(MYLOConstants.POLICY_TYPE, data.get(i).get(MYLOConstants.POLICY_TYPE));
			setNewFileDropdownValues(MYLOConstants.TAX_TREATMENT, data.get(i).get(MYLOConstants.TAX_TREATMENT));
			CoreFunctions.click(driver, _btnCreateFile, MYLOConstants.CREATE_NEW_FILE);
			verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE));
		}
	}

	public boolean verifyToastMessage(String msg) {
		boolean flag = false;
		flag = (BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, msg, MYLOConstants.CREATE_NEW_FILE));
		Assert.assertTrue(flag, MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, msg,
				_alertMessage.getText(), MYLOConstants.JOURNEY));
		return flag;
	}

	/**
	 * @param table
	 * @return Verify Toast Messages for Special Characters entered in fields of New
	 *         File section
	 */
	public void verifySpecialCharacterToastMessagesOtherSection(DataTable table) {
		setNewFileFields(MYLOConstants.CLIENT_NAME, MYLOConstants.CLIENT_NAME_VALUE);
		CoreFunctions.hoverAndClick(driver, CoreFunctions.getElementListByLocator(driver, _dropdownOptions).get(0),
				MYLOConstants.CLIENT_NAME_VALUE);
		setNewFileDropdownValues(MYLOConstants.OFFICE, MYLOConstants.OFFICE_VALUE);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String firstNameValue = (fieldName.equals(MYLOConstants.TRANSFEREE_FIRSTNAME))
					? MYLOConstants.SPECIAL_CHARACTERS_STRING
					: MYLOConstants.TEST;
			String lastNameValue = (fieldName.equals(MYLOConstants.TRANSFEREE_LASTNAME))
					? MYLOConstants.SPECIAL_CHARACTERS_STRING
					: MYLOConstants.TEST;
			setNewFileFields(MYLOConstants.TRANSFEREE_FIRSTNAME, firstNameValue);
			setNewFileFields(MYLOConstants.TRANSFEREE_LASTNAME, lastNameValue);
			CoreFunctions.click(driver, _btnCreateFile, MYLOConstants.CREATE_NEW_FILE);
			verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE));
		}
	}

	public boolean isClientOptionsExistsInDropdown() {
		return CoreFunctions.isElementByLocatorExist(driver, _dropdownOptions, 5);
	}

	public boolean verifyPolicyTypeFieldReadonly() {
		return CoreFunctions.isElementExist(driver, _newFilePolicyTypeDisabled, 5);
	}

	public void enterAllFieldsForNewFile(String transfereeFirstName, String transfereeLastName, String client,
			String office, String journeyType, String policyType, String taxTreatment, boolean repatIndicator) {
		if (repatIndicator == Boolean.TRUE)
			_newFileRepatCheckbox.click();
		String tName = createRandomTransfereeName(transfereeFirstName, transfereeLastName);
		setNewFileFields(MYLOConstants.TRANSFEREE_FIRSTNAME, tName.split(" ")[0]);
		setNewFileFields(MYLOConstants.TRANSFEREE_LASTNAME, tName.split(" ")[1]);
		setNewFileFields(MYLOConstants.CLIENT_NAME, client);
		CoreFunctions.hoverAndClick(driver, CoreFunctions.getElementListByLocator(driver, _dropdownOptions).get(0),
				client);
		if (policyType != "")
			setNewFileDropdownValues(MYLOConstants.POLICY_TYPE, policyType);
		setNewFileDropdownValues(MYLOConstants.TAX_TREATMENT, taxTreatment);
		setNewFileDropdownValues(MYLOConstants.JOURNEY_TYPE, journeyType);
		setNewFileDropdownValues(MYLOConstants.OFFICE, office);
	}

	public void writeTransfereeName(String fieldName, String fieldValue) {
		if (fieldName.equals(MYLOConstants.TRANSFEREE_FIRSTNAME))
			CoreFunctions.writeToPropertiesFile("Mylo_Transferee_firstName", fieldValue);
		else
			CoreFunctions.writeToPropertiesFile("Mylo_Transferee_lastName", fieldValue);
	}

	public String getTransfereeCharacterLengthString(String fieldName, String fieldValue) {
		String requiredValue;
		try {
			requiredValue = CoreFunctions.generateRandomString(Integer.parseInt(fieldValue) - 1);
			writeTransfereeName(fieldName, requiredValue.substring(0, Integer.parseInt(fieldValue) - 1));
		} catch (NumberFormatException e) {
			requiredValue = fieldValue;
			writeTransfereeName(fieldName, fieldValue);
		}
		return requiredValue;
	}

	public String createRandomTransfereeName(String firstName, String lastName) {
		String fName, lName;
		if (firstName.equals(MYLOConstants.RANDOM) && lastName.equals(MYLOConstants.RANDOM)) {
			fName = myloNewFileData.newFile.firstName + CoreFunctions.generateRandomString(5);
			lName = myloNewFileData.newFile.lastName + CoreFunctions.generateRandomString(5);
			writeTransfereeName(MYLOConstants.TRANSFEREE_FIRSTNAME, fName);
			writeTransfereeName(MYLOConstants.TRANSFEREE_LASTNAME, fName);
		} else {
			fName = getTransfereeCharacterLengthString(MYLOConstants.TRANSFEREE_FIRSTNAME, firstName);
			lName = getTransfereeCharacterLengthString(MYLOConstants.TRANSFEREE_LASTNAME, lastName);
		}
		return fName + " " + lName;
	}

	public boolean verifyFileInfoInDifferentSection(String sectionName) {
		boolean flag = (sectionName.equals(MYLOConstants.PURPLE_BUBBLE_SECTION)) ? verifyFileInfoPurpleBubbleSection()
				: (sectionName.equals(MYLOConstants.TOP_RIGHT_CORNER_SECTION)) ? verifyFileInfoTopRightCornerSection()
						: (sectionName.equals(MYLOConstants.FILE_INFORMATION_SECTION))
								? verifyFileInfoFileInformationSection()
								: (sectionName.equals(MYLOConstants.TRANSFEREE)) ? verifyFileInfoTransfereeSection()
										: (sectionName.equals(MYLOConstants.PRIMARY_CONTACT_SECTION))
												? verifyFileInfoPrimaryContactSection()
												: verifyFileInfoFileTeamSection();

		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ALL_VALUES_UPDATED_ON_SECTION,
					CoreConstants.PASS, MYLOConstants.CREATE_NEW_FILE, sectionName, MYLOConstants.JOURNEY));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.MISMATCH_DIFFERENT_FIELDVALUES, CoreConstants.FAIL,
					sectionName));
		return flag;
	}

	public boolean verifyFileInfoMessageDisplayedDifferentSections(String sectionName, String msg) {
		boolean flag = (sectionName.equals(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION))
				? verifyFileInfoIdentDocSection(msg)
				: (sectionName.equals(MYLOConstants.BENEFITS_AT_A_GLANCE)) ? verifyFileInfoBenefitsGlanceSection(msg)
						: verifyFileInfoAuthTrackSection(msg);
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_NO_VALUES_UPDATED_ON_SECTION,
					CoreConstants.PASS, MYLOConstants.CREATE_NEW_FILE, sectionName, MYLOConstants.JOURNEY));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ALL_VALUES_UPDATED_ON_SECTION,
					CoreConstants.FAIL, MYLOConstants.CREATE_NEW_FILE, sectionName, MYLOConstants.JOURNEY));
		return flag;

	}

	public boolean verifyFileInfoPurpleBubbleSection() {
		boolean flag = false;
		String expectedTransfereeName = CoreFunctions.getPropertyFromConfig("Mylo_Transferee_firstName") + " "
				+ CoreFunctions.getPropertyFromConfig("Mylo_Transferee_lastName");
		try {
			String transfereeName = CoreFunctions.getElementText(driver, _purpleBubbleSectionTransfereeName);
			String clientName = CoreFunctions.getElementText(driver, _purpleBubbleSectionClientName);
			if (transfereeName.equals(expectedTransfereeName) && clientName.equals(myloNewFileData.newFile.clientName)
					&& CoreFunctions.isElementExist(driver, _purpleBubbleSectionFileId, 10)) {
				flag = true;
				CoreFunctions.writeToPropertiesFile("Mylo_AssignmentID", _purpleBubbleSectionFileId.getText());
			} else {
				String msg = (transfereeName != expectedTransfereeName)
						? MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL,
								expectedTransfereeName, MYLOConstants.TRANSFEREE_NAME,
								MYLOConstants.PURPLE_BUBBLE_SECTION, MYLOConstants.JOURNEY)
						: (clientName != myloNewFileData.newFile.clientName)
								? MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL,
										myloNewFileData.newFile.clientName, MYLOConstants.CLIENT_NAME,
										MYLOConstants.PURPLE_BUBBLE_SECTION, MYLOConstants.JOURNEY)
								: MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL,
										MYLOConstants.ASTERISK, MYLOConstants.FILE_ID,
										MYLOConstants.PURPLE_BUBBLE_SECTION, MYLOConstants.JOURNEY);
				Reporter.addStepLog(msg);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.PURPLE_BUBBLE_SECTION));
		}
		return flag;
	}

	public boolean verifyFileInfoTopRightCornerSection() {
		boolean flag = false;
		String expectedTransfereeName = CoreFunctions.getPropertyFromConfig("Mylo_Transferee_firstName") + " "
				+ CoreFunctions.getPropertyFromConfig("Mylo_Transferee_lastName");
		try {
			String transfereeName = CoreFunctions.getElementText(driver, _cornerSectionTransfereeName);
			String clientName = CoreFunctions.getElementText(driver, _cornerSectionClientName);
			String fileGrossProfit = CoreFunctions.getElementText(driver, _cornerSectionFileGrossProfit);
			if (transfereeName.equals(expectedTransfereeName) && clientName.equals(myloNewFileData.newFile.clientName)
					&& fileGrossProfit.equals(myloNewFileData.newFile.fileGrossprofit))
				flag = true;
			else {
				String msg = (transfereeName != expectedTransfereeName)
						? MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL,
								expectedTransfereeName, MYLOConstants.TRANSFEREE_NAME,
								MYLOConstants.TOP_RIGHT_CORNER_SECTION, MYLOConstants.JOURNEY)
						: (clientName != myloNewFileData.newFile.clientName)
								? MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL,
										myloNewFileData.newFile.clientName, MYLOConstants.CLIENT_NAME,
										MYLOConstants.TOP_RIGHT_CORNER_SECTION, MYLOConstants.JOURNEY)
								: MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL,
										myloNewFileData.newFile.fileGrossprofit, MYLOConstants.FILE_GROSS_PROFIT,
										MYLOConstants.TOP_RIGHT_CORNER_SECTION, MYLOConstants.JOURNEY);
				Reporter.addStepLog(msg);
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.TOP_RIGHT_CORNER_SECTION));
		}
		return flag;
	}

	public String getFailureMessageForReport(String field, String value, String section) {
		return (MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL, value, field,
				section, MYLOConstants.JOURNEY));
	}

	public boolean verifyFileInfoFileInformationSection() {
		boolean flag = false;
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoDetailsCarrot,
					_fileInfoDetailsCarrot.getText());
			CoreFunctions.click(driver, _fileInfoDetailsCarrot, _fileInfoDetailsCarrot.getText());
			String section = MYLOConstants.AIRES_FILE_INFORMATION;
			String clientName = CoreFunctions.getElementAttributeValue(driver, _fileInfoSectionClientName, "value");
			String fileID = CoreFunctions.getElementAttributeValue(driver, _fileInfoSectionFileId, "value");
			String policyType = CoreFunctions.getElementText(driver, _fileInfoPolicyType);
			String office = CoreFunctions.getElementText(driver, _fileInfoOffice);
			String journeyType = CoreFunctions.getElementText(driver, _fileInfoJourneyType);
			String taxTreatment = CoreFunctions.getElementText(driver, _fileInfoTaxTreatment);
			boolean repatCheckbox = _fileInfoRepatriationCheckbox.isSelected();
			CoreFunctions.click(driver, _fileInfoDetailsCarrot, _fileInfoDetailsCarrot.getText());

			if (clientName.contains(myloNewFileData.newFile.clientName)
					&& fileID.equals(CoreFunctions.getPropertyFromConfig("Mylo_AssignmentID"))
					&& policyType.equals(myloNewFileData.newFile.policyType)
					&& office.equals(myloNewFileData.newFile.office)
					&& journeyType.equals(myloNewFileData.newFile.journeyType)
					&& taxTreatment.equals(myloNewFileData.newFile.taxTreatment) && repatCheckbox)
				flag = true;
			else {
				String msg = (clientName != myloNewFileData.newFile.clientName)
						? getFailureMessageForReport(MYLOConstants.CLIENT_NAME, myloNewFileData.newFile.clientName,
								section)
						: (fileID != CoreFunctions.getPropertyFromConfig("Mylo_AssignmentID"))
								? getFailureMessageForReport(MYLOConstants.FILE_ID,
										CoreFunctions.getPropertyFromConfig("Mylo_AssignmentID"), section)
								: (policyType != myloNewFileData.newFile.policyType)
										? getFailureMessageForReport(MYLOConstants.POLICY_TYPE,
												myloNewFileData.newFile.policyType, section)
										: (office != myloNewFileData.newFile.office)
												? getFailureMessageForReport(MYLOConstants.JOURNEY_TYPE,
														myloNewFileData.newFile.journeyType, section)
												: (journeyType != myloNewFileData.newFile.journeyType)
														? getFailureMessageForReport(MYLOConstants.OFFICE,
																myloNewFileData.newFile.office, section)
														: getFailureMessageForReport(MYLOConstants.TAX_TREATMENT,
																myloNewFileData.newFile.taxTreatment, section);
				Reporter.addStepLog(msg);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.AIRES_FILE_INFORMATION));
		}
		return flag;
	}

	public boolean verifyFileInfoTransfereeSection() {
		boolean flag = false;
		String expectedTransfereeName = CoreFunctions.getPropertyFromConfig("Mylo_Transferee_firstName") + " "
				+ CoreFunctions.getPropertyFromConfig("Mylo_Transferee_lastName");
		try {
			if (CoreFunctions.getElementText(driver, _transfereeSectionTransfereeName).equals(expectedTransfereeName))
				flag = true;
			else
				Reporter.addStepLog(getFailureMessageForReport(MYLOConstants.TRANSFEREE_NAME, expectedTransfereeName,
						MYLOConstants.TRANSFEREE));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.TRANSFEREE));
		}
		return flag;
	}

	public boolean verifyFileInfoPrimaryContactSection() {
		boolean flag = false;
		String expectedTransfereeName = CoreFunctions.getPropertyFromConfig("Mylo_Transferee_firstName") + " "
				+ CoreFunctions.getPropertyFromConfig("Mylo_Transferee_lastName");
		try {
			if (CoreFunctions.getElementText(driver, _primaryContactSectionTransfereeName).trim()
					.equals(expectedTransfereeName))
				flag = true;
			else
				Reporter.addStepLog(getFailureMessageForReport(MYLOConstants.TRANSFEREE_NAME, expectedTransfereeName,
						MYLOConstants.PRIMARY_CONTACT_SECTION));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.PRIMARY_CONTACT_SECTION));
		}
		return flag;
	}

	public boolean verifyFileInfoFileTeamSection() {
		boolean flag = false;
		try {
			String ppcValue = CoreFunctions.getElementAttributeValue(driver, (_fileTeamSectionName.get(BusinessFunctions
					.returnindexItemFromListUsingAttribute(driver, _fileTeamSectionRole, "PPC", "value"))), "value");
			if (ppcValue.equals("mxsso dev5"))
				flag = true;
			else
				Reporter.addStepLog(
						getFailureMessageForReport(MYLOConstants.PPC, "mxsso dev5", MYLOConstants.AIRES_FILE_TEAM));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.AIRES_FILE_TEAM));
		}
		return flag;
	}

	public boolean verifyFileInfoIdentDocSection(String msg) {
		boolean flag = false;
		try {
			CoreFunctions.scrollToElementUsingJS(driver, _identDocSection,
					MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
			if (CoreFunctions.getElementText(driver, _identDocSection).equals(msg))
				flag = true;
			else
				Reporter.addStepLog(MessageFormat.format(MYLOConstants.VALUE_UPDATED_ON_SECTION, CoreConstants.FAIL,
						msg, MYLOConstants.CREATE_NEW_FILE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION,
						MYLOConstants.JOURNEY));
		} catch (Throwable e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		}
		return flag;
	}

	public boolean verifyFileInfoBenefitsGlanceSection(String msg) {
		boolean flag = false;
		try {
			if (CoreFunctions.getElementText(driver, _benefitsGlanceSection).equals(msg))
				flag = true;
			else
				Reporter.addStepLog(MessageFormat.format(MYLOConstants.VALUE_UPDATED_ON_SECTION, CoreConstants.FAIL,
						msg, MYLOConstants.CREATE_NEW_FILE, MYLOConstants.BENEFITS_AT_A_GLANCE, MYLOConstants.JOURNEY));
		} catch (Throwable e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.BENEFITS_AT_A_GLANCE));
		}
		return flag;
	}

	public boolean verifyFileInfoAuthTrackSection(String msg) {
		boolean flag = false;
		try {
			if (CoreFunctions.getElementText(driver, _authTrackSection).equals(msg))
				flag = true;
			else
				Reporter.addStepLog(MessageFormat.format(MYLOConstants.VALUE_UPDATED_ON_SECTION, CoreConstants.FAIL,
						msg, MYLOConstants.CREATE_NEW_FILE, MYLOConstants.AUTH_TRACK, MYLOConstants.JOURNEY));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.AUTH_TRACK));
		}
		return flag;
	}
}
