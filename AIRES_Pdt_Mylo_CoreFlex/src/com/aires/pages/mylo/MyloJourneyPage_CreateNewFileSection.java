package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
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
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

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

	@FindBy(how = How.XPATH, using = "//app-aires-file-information/descendant::span[text()=' Details ']")
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
	
	@FindBy(how = How.XPATH, using = "//button[text()='Ok']")
	private WebElement _okButtonPopUp;

	final By _dropdownOptions = By.cssSelector("div[role='option']>span");

	LinkedHashMap<String, WebElement> newFileWebElementsMap = new LinkedHashMap<String, WebElement>();

	Mylo_FileData myloNewFileData = FileReaderManager.getInstance().getMyloJsonReader()
			.getFileDataByFileType(MYLOConstants.CREATE_NEW_FILE);

	/**
	 * Map all the New File section fields with there respective locators
	 */
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
	 * Click on any Fields available on the New File section based on the fieldName passed as a parameter
	 * @param fieldName
	 */
	public void clickFieldsOnNewFileSection(String fieldName) {
		mapCreateNewFileWebElementFields();
		try {
			WebElement element = newFileWebElementsMap.get(fieldName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName, 100);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.CREATE_NEW_FILE));
		}
	}
	
	/**
	 * Set Input Fields for New File section based on the fieldName passed as a parameter
	 * @param fieldName
	 * @param fieldValue
	 * @param type
	 */
	public void setNewFileFields(String fieldName, String fieldValue,String type) {
		mapCreateNewFileWebElementFields();
		try {
			WebElement reqWebElement = newFileWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			BusinessFunctions.setMyloInputFields(driver, fieldName, fieldValue, reqWebElement, type);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.CREATE_NEW_FILE));
		}
	}

	/**
	 * Set Dropdown Fields for New File section based on the fieldName passed as a parameter
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 */
	public String setNewFileDropdownValues(String fieldName, String fieldValue) {
		clickFieldsOnNewFileSection(fieldName);
		String updatedValue = BusinessFunctions.setMyloDropdownFields(driver, _dropdownOptions, fieldValue,fieldName);
		return updatedValue;
	}
	
	public void setRepatInd(boolean repatInd) {
		if (repatInd == Boolean.TRUE)
			_newFileRepatCheckbox.click();
	}
	
	public void setClient(String client) {
		setNewFileFields(MYLOConstants.CLIENT_NAME, client, MYLOConstants.VALUE);
		if (!(client.equals("")))
			CoreFunctions.hoverAndClick(driver, CoreFunctions.getElementByLocator(driver, _dropdownOptions), client);
	}
	
	public String setPolicyType(String policyType) {
		String pType="";
		if (policyType != "")
			pType=setNewFileDropdownValues(MYLOConstants.POLICY_TYPE, policyType);
		return pType;
	}
	
	public void enterAllFieldsForNewFile(String tFirstName, String tLastName, String client,
			String office, String journeyType, String policyType, String taxTreatment, boolean repatInd) {
		setRepatInd(repatInd);
		String tName = createTransfereeName(tFirstName, tLastName);
		setNewFileFields(MYLOConstants.TRANSFEREE_FIRSTNAME, tName.split(" ")[0],MYLOConstants.VALUE);
		setNewFileFields(MYLOConstants.TRANSFEREE_LASTNAME, tName.split(" ")[1],MYLOConstants.VALUE);
		setClient(client);
		setPolicyType(policyType);
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

	/**
	 * Verify the Toast Messages appearing for mandatory fields based on the parameters passed
	 * @param firstName
	 * @param lastName
	 * @param office
	 * @param clientName
	 * @param policyType
	 * @param taxTreatment
	 * @param msg
	 * @return
	 */
	public boolean verifyMandatoryFieldsToastMessagesCreateNewFileSection(String firstName, String lastName,
			String office, String clientName, String policyType, String taxTreatment, String msg) {
		String type = MYLOConstants.VALUE;
		setNewFileFields(MYLOConstants.TRANSFEREE_FIRSTNAME, firstName, type);
		setNewFileFields(MYLOConstants.TRANSFEREE_LASTNAME, lastName, type);
		setNewFileDropdownValues(MYLOConstants.OFFICE, office);
		setClient(clientName);
		setNewFileDropdownValues(MYLOConstants.POLICY_TYPE, policyType);
		setNewFileDropdownValues(MYLOConstants.TAX_TREATMENT, taxTreatment);
		clickFieldsOnNewFileSection(MYLOConstants.CREATE_NEW_FILE);
		return (BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, msg, MYLOConstants.CREATE_NEW_FILE));
	}

	/**
	 * Verify the Toast Messages appearing for fields having Special Characters based on the parameters passed
	 * @param fieldName
	 * @param msg
	 * @return
	 */
	public boolean verifySpecialCharacterToastMessagesOtherSection(String fieldName, String msg) {
		String fType,lType;
		setClient(MYLOConstants.CLIENT_NAME_VALUE);
		setNewFileDropdownValues(MYLOConstants.OFFICE, MYLOConstants.OFFICE_VALUE);
		fType=(fieldName.equals(MYLOConstants.TRANSFEREE_FIRSTNAME))?MYLOConstants.SPECIAL_CHARACTERS_STRING:MYLOConstants.VALUE;
		lType=(fieldName.equals(MYLOConstants.TRANSFEREE_LASTNAME))?MYLOConstants.SPECIAL_CHARACTERS_STRING:MYLOConstants.VALUE;
		setNewFileFields(MYLOConstants.TRANSFEREE_FIRSTNAME, MYLOConstants.TEST,fType);
		setNewFileFields(MYLOConstants.TRANSFEREE_LASTNAME, MYLOConstants.TEST,lType);
		clickFieldsOnNewFileSection(MYLOConstants.CREATE_NEW_FILE);
		return (BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, msg, MYLOConstants.CREATE_NEW_FILE));
	}

	public boolean isClientOptionsExistsInDropdown(String clientID) {
		setNewFileFields(MYLOConstants.CLIENT_NAME, clientID, MYLOConstants.VALUE);
		return CoreFunctions.isElementByLocatorExist(driver, _dropdownOptions, 5);
	}

	public boolean verifyPolicyTypeFieldReadonly() {
		return CoreFunctions.isElementExist(driver, _newFilePolicyTypeDisabled, 5);
	}
	
	public String getTransfereeValue(String fieldName, String fieldValue) {
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

	public String createTransfereeName(String firstName, String lastName) {
		String fName, lName;
		fName = (firstName.equals(MYLOConstants.RANDOM))
				? myloNewFileData.newFile.firstName + CoreFunctions.generateRandomString(5)
				: getTransfereeValue(MYLOConstants.TRANSFEREE_FIRSTNAME, firstName);
		lName = (firstName.equals(MYLOConstants.RANDOM))
				? myloNewFileData.newFile.lastName + CoreFunctions.generateRandomString(5)
				: getTransfereeValue(MYLOConstants.TRANSFEREE_LASTNAME, lastName);
		return fName + " " + lName;
	}

	public void verifyFileInfoInDifferentSection(String sectionName) {
		String expectedTransfereeName = CoreFunctions.getPropertyFromConfig("Mylo_Transferee_firstName") + " "
				+ CoreFunctions.getPropertyFromConfig("Mylo_Transferee_lastName");
		switch (sectionName) {
		case MYLOConstants.PURPLE_BUBBLE_SECTION:
			verifyFileInfoPurpleBubbleSection(expectedTransfereeName);
			break;
		case MYLOConstants.TOP_RIGHT_CORNER_SECTION:
			verifyFileInfoTopRightCornerSection(expectedTransfereeName);
			break;
		case MYLOConstants.FILE_INFORMATION_SECTION:
			verifyFileInfoFileInformationSection();
			break;
		case MYLOConstants.TRANSFEREE:
			verifyFileInfoTransfereeSection(expectedTransfereeName);
			break;
		case MYLOConstants.PRIMARY_CONTACT_SECTION:
			verifyFileInfoPrimaryContactSection(expectedTransfereeName);
			break;
		case MYLOConstants.AIRES_FILE_TEAM:
			verifyFileInfoFileTeamSection();
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_SECTION_NAME);
		}
	}

	public boolean verifyFileInfoMessageDisplayedDifferentSections(String sectionName, String msg) {
		boolean flag = (sectionName.equals(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION))
				? verifyFileInfoIdentDocSection(msg)
				: (sectionName.equals(MYLOConstants.BENEFITS_AT_A_GLANCE)) ? verifyFileInfoBenefitsGlanceSection(msg)
						: verifyFileInfoAuthTrackSection(msg);
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_NO_VALUES_UPDATED_ON_SECTION,
					CoreConstants.PASS, MYLOConstants.CREATE_NEW_FILE, sectionName, MYLOConstants.JOURNEY));
		return flag;
	}

	/**
	 * Verify all information for Newly Created File on Purple Bubble Section
	 * @param expectedTransfereeName
	 */
	public void verifyFileInfoPurpleBubbleSection(String expectedTransfereeName) {
		try {
			Assert.assertEquals(CoreFunctions.getElementText(driver, _purpleBubbleSectionTransfereeName),
					expectedTransfereeName, getFailureMessageForReport(MYLOConstants.TRANSFEREE_NAME,
							expectedTransfereeName, MYLOConstants.PURPLE_BUBBLE_SECTION));

			Assert.assertEquals(CoreFunctions.getElementText(driver, _purpleBubbleSectionClientName),
					myloNewFileData.newFile.clientName, getFailureMessageForReport(MYLOConstants.CLIENT_NAME,
							myloNewFileData.newFile.clientName, MYLOConstants.PURPLE_BUBBLE_SECTION));

			Assert.assertTrue(CoreFunctions.isElementExist(driver, _purpleBubbleSectionFileId, 10),
					getFailureMessageForReport(MYLOConstants.FILE_ID, MYLOConstants.ASTERISK,
							MYLOConstants.PURPLE_BUBBLE_SECTION));
			CoreFunctions.writeToPropertiesFile("Mylo_AssignmentID", _purpleBubbleSectionFileId.getText());

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.PURPLE_BUBBLE_SECTION));
		}
	}

	/**
	 * Verify all information for Newly Created File on Top Right Corner Section
	 * available on Journey Page
	 * 
	 * @param expectedTransfereeName
	 */
	public void verifyFileInfoTopRightCornerSection(String expectedTransfereeName) {
		try {
			Assert.assertEquals(CoreFunctions.getElementText(driver, _cornerSectionTransfereeName),
					expectedTransfereeName, getFailureMessageForReport(MYLOConstants.TRANSFEREE_NAME,
							expectedTransfereeName, MYLOConstants.TOP_RIGHT_CORNER_SECTION));

			Assert.assertEquals(CoreFunctions.getElementText(driver, _cornerSectionClientName),
					myloNewFileData.newFile.clientName, getFailureMessageForReport(MYLOConstants.CLIENT_NAME,
							myloNewFileData.newFile.clientName, MYLOConstants.TOP_RIGHT_CORNER_SECTION));

			Assert.assertEquals(CoreFunctions.getElementText(driver, _cornerSectionFileGrossProfit),
					myloNewFileData.newFile.fileGrossprofit, getFailureMessageForReport(MYLOConstants.FILE_GROSS_PROFIT,
							myloNewFileData.newFile.fileGrossprofit, MYLOConstants.TOP_RIGHT_CORNER_SECTION));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.TOP_RIGHT_CORNER_SECTION));
		}
	}

	/**
	 * Verify all information for Newly Created File on File Information Section
	 * available on Journey Page
	 */
	public void verifyFileInfoFileInformationSection() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoDetailsCarrot,
					_fileInfoDetailsCarrot.getText());
			CoreFunctions.click(driver, _fileInfoDetailsCarrot, _fileInfoDetailsCarrot.getText());

			Assert.assertTrue(
					CoreFunctions.getElementAttributeValue(driver, _fileInfoSectionClientName, MYLOConstants.VALUE)
							.contains(myloNewFileData.newFile.clientName),
					getFailureMessageForReport(MYLOConstants.CLIENT_NAME, myloNewFileData.newFile.clientName,
							MYLOConstants.FILE_INFORMATION_SECTION));
			Assert.assertEquals(
					CoreFunctions.getElementAttributeValue(driver, _fileInfoSectionFileId, MYLOConstants.VALUE),
					CoreFunctions.getPropertyFromConfig("Mylo_AssignmentID"),
					getFailureMessageForReport(MYLOConstants.FILE_ID,
							CoreFunctions.getPropertyFromConfig("Mylo_AssignmentID"),
							MYLOConstants.FILE_INFORMATION_SECTION));
			Assert.assertEquals(CoreFunctions.getElementText(driver, _fileInfoPolicyType),
					myloNewFileData.newFile.policyType, getFailureMessageForReport(MYLOConstants.POLICY_TYPE,
							myloNewFileData.newFile.policyType, MYLOConstants.FILE_INFORMATION_SECTION));
			Assert.assertEquals(CoreFunctions.getElementText(driver, _fileInfoJourneyType),
					myloNewFileData.newFile.journeyType, getFailureMessageForReport(MYLOConstants.JOURNEY_TYPE,
							myloNewFileData.newFile.journeyType, MYLOConstants.FILE_INFORMATION_SECTION));
			Assert.assertEquals(CoreFunctions.getElementText(driver, _fileInfoOffice), myloNewFileData.newFile.office,
					getFailureMessageForReport(MYLOConstants.OFFICE, myloNewFileData.newFile.office,
							MYLOConstants.FILE_INFORMATION_SECTION));
			Assert.assertEquals(CoreFunctions.getElementText(driver, _fileInfoTaxTreatment),
					myloNewFileData.newFile.taxTreatment, getFailureMessageForReport(MYLOConstants.TAX_TREATMENT,
							myloNewFileData.newFile.taxTreatment, MYLOConstants.FILE_INFORMATION_SECTION));

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.AIRES_FILE_INFORMATION));
		}
	}

	/**
	 * Verify all information for Newly Created File on Transferee Section available
	 * on Journey Page
	 * 
	 * @param expectedTransfereeName
	 */
	public void verifyFileInfoTransfereeSection(String expectedTransfereeName) {
		try {
			Assert.assertEquals(CoreFunctions.getElementText(driver, _transfereeSectionTransfereeName),
					expectedTransfereeName, getFailureMessageForReport(MYLOConstants.TRANSFEREE_NAME,
							expectedTransfereeName, MYLOConstants.TRANSFEREE));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.TRANSFEREE));
		}
	}

	/**
	 * Verify all information for Newly Created File on Primary Contact Section
	 * available on Journey Page
	 * 
	 * @param expectedTransfereeName
	 */
	public void verifyFileInfoPrimaryContactSection(String expectedTransfereeName) {
		try {
			Assert.assertEquals(CoreFunctions.getElementText(driver, _primaryContactSectionTransfereeName).trim(),
					expectedTransfereeName, getFailureMessageForReport(MYLOConstants.TRANSFEREE_NAME,
							expectedTransfereeName, MYLOConstants.PRIMARY_CONTACT_SECTION));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.PRIMARY_CONTACT_SECTION));
		}
	}

	/**
	 * Verify all information for Newly Created File on Aires File Team Section
	 * available on Journey Page
	 */
	public void verifyFileInfoFileTeamSection() {
		try {
			int userIndex = BusinessFunctions.returnindexItemFromListUsingAttribute(driver, _fileTeamSectionRole,
					MYLOConstants.PPC, MYLOConstants.VALUE);
			Assert.assertEquals(
					CoreFunctions.getElementAttributeValue(driver, (_fileTeamSectionName.get(userIndex)),
							MYLOConstants.VALUE),
					MYLOConstants.MXSSODEV5, getFailureMessageForReport(MYLOConstants.TRANSFEREE_NAME,
							MYLOConstants.MXSSODEV5, MYLOConstants.AIRES_FILE_TEAM));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					MYLOConstants.CREATE_NEW_FILE, MYLOConstants.AIRES_FILE_TEAM));
		}
	}

	/**
	 * Verify No data created and default message displayed on Identification &
	 * Document section available on Journey Page
	 * @param msg
	 * @return
	 */
	public boolean verifyFileInfoIdentDocSection(String msg) {
		CoreFunctions.scrollToElementUsingJS(driver, _identDocSection, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
		return CoreFunctions.getElementText(driver, _identDocSection).equals(msg);
	}

	/**
	 * Verify No data created and default message displayed on Benefits At a Glance
	 * section available on Journey Page
	 * 
	 * @param msg
	 * @return
	 */
	public boolean verifyFileInfoBenefitsGlanceSection(String msg) {
		return (CoreFunctions.getElementText(driver, _benefitsGlanceSection).equals(msg));
	}

	/**
	 * Verify No data created and default message displayed on Authorization &
	 * Tracking section available on Journey Page
	 * 
	 * @param msg
	 * @return
	 */
	public boolean verifyFileInfoAuthTrackSection(String msg) {
		return (CoreFunctions.getElementText(driver, _authTrackSection).equals(msg));
	}

	/**
	 * Get Failure Message For Reporting purpose
	 * 
	 * @param field
	 * @param value
	 * @param section
	 * @return
	 */
	public String getFailureMessageForReport(String field, String value, String section) {
		return (MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL, value, field,
				section, MYLOConstants.JOURNEY));
	}

	/**
	 * Creating a New File for client passed as a parameter with random selected values 
	 * @param client
	 * @param myloNewFileUtil 
	 */
	public void createNewFile(String client) {
		String transfereeFirstName = myloNewFileData.newFile.firstName + CoreFunctions.generateRandomString(5);
		String transfereeLastName = myloNewFileData.newFile.lastName + CoreFunctions.generateRandomString(5);
		setNewFileFields(MYLOConstants.TRANSFEREE_FIRSTNAME, transfereeFirstName, MYLOConstants.VALUE);
		setNewFileFields(MYLOConstants.TRANSFEREE_LASTNAME, transfereeLastName, MYLOConstants.VALUE);
		setClient(client);
		String policyType = setPolicyType(MYLOConstants.RANDOM);
		setNewFileDropdownValues(MYLOConstants.TAX_TREATMENT, MYLOConstants.TAX_TREATMENT_VALUE);
		setNewFileDropdownValues(MYLOConstants.JOURNEY_TYPE, MYLOConstants.JOURNEY_TYPE_VALUE);
		String officeType = setNewFileDropdownValues(MYLOConstants.OFFICE, MYLOConstants.RANDOM);
		setRepatInd(true);
		clickFieldsOnNewFileSection(MYLOConstants.CREATE_NEW_FILE);
		clickOkIfPopUpExist();
		String fileId = CoreFunctions.getElementText(driver, _purpleBubbleSectionFileId);
		setNewFileFields(transfereeFirstName, transfereeLastName, policyType, MYLOConstants.TAX_TREATMENT_VALUE,
				MYLOConstants.JOURNEY_TYPE_VALUE, officeType, fileId, client);
	}

	
	/**
	 * Saving the New File details in MyloNewFileUtil object
	 * @param myloNewFileUtil 
	 * @param tFName
	 * @param tLName
	 * @param pType
	 * @param taxTreatment
	 * @param jType
	 * @param officeType
	 * @param fileId
	 * @param clientID
	 * @return 
	 */
	public void setNewFileFields(String tFName, String tLName, String pType, String taxTreatment, String jType,
			String officeType, String fileId, String clientID) {
		MyloNewFileUtil.setTransfereeFirstName(tFName);
		MyloNewFileUtil.setTransfereeLastName(tLName);
		MyloNewFileUtil.setPolicyType(pType);
		MyloNewFileUtil.setTaxTreatment(taxTreatment);
		MyloNewFileUtil.setJourneyType(jType);
		MyloNewFileUtil.setOfficeType(officeType);
		MyloNewFileUtil.setFileID(fileId);
		MyloNewFileUtil.setClientID(clientID);
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

}
