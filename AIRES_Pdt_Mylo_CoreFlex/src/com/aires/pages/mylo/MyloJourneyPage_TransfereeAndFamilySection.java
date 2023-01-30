package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_TransfereeAndFamilySection extends Base {

	public MyloJourneyPage_TransfereeAndFamilySection(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "app-transferee-family button")
	private WebElement _appTransfereeAndFamilyExpandButton;

	@FindBy(how = How.CSS, using = "div#accordionExampleTransferee a")
	private List<WebElement> _addTransfereeAndFamilyLinks;

	@FindBy(how = How.CSS, using = "app-transferee-family-add-popup input")
	private List<WebElement> _addTransfereeInput;

	@FindBy(how = How.CSS, using = "app-transferee-family-add-popup ng-select")
	private List<WebElement> _addTransfereeDropDown;

	@FindBy(how = How.CSS, using = "app-transferee-family-add-popup div[role='option']")
	private List<WebElement> _addTransfereeDropDownOptions;

	@FindBy(how = How.CSS, using = "i[class='icon-FloppyDisk_Open']")
	private WebElement _saveIcon;

	@FindBy(how = How.CSS, using = "app-transferee-family-add-popup  button[class*='submit']")
	private WebElement _saveButton;


	@FindBy(how = How.CSS, using = "app-partner i[class='icon-Pencil_Open']")
	private List<WebElement> _partnerEditButtons;

	@FindBy(how = How.CSS, using = "app-dependents i[class='icon-Pencil_Open']")
	private List<WebElement> _dependentEditButtons;
	
	@FindBy(how = How.CSS, using = "app-others i[class='icon-Pencil_Open']")
	private List<WebElement> _otherEditButtons;

	@FindBy(how = How.CSS, using = "app-transferee-family input")
	private List<WebElement> _editTransfereeInput;

	@FindBy(how = How.CSS, using = "app-transferee-family ng-select")
	private List<WebElement> _editTransfereeDropDown;

	@FindBy(how = How.CSS, using = "app-transferee-family div[role='option']")
	private List<WebElement> _editTransfereeDropDownOptions;

	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2']")
	private WebElement _emailTypeDropdown;

	@FindBy(how = How.CSS, using = "app-transferee-family button[aria-controls='collapseOneTransferee']")
	private WebElement _transfereeAndFamilySection;

	@FindBy(how = How.CSS, using = "app-partner div[class*='userdesignation']")
	private List<WebElement> _partnerRelationship;

	@FindBy(how = How.CSS, using = "app-dependents div[class*='userdesignation']")
	private List<WebElement> _dependentRelationship;

	@FindBy(how = How.CSS, using = "app-others div[class*='userdesignation']")
	private List<WebElement> _otherRelationship;

	@FindBy(how = How.CSS, using = "app-partner div[class*='usertitle']")
	private List<WebElement> _savedPartnerNames;

	@FindBy(how = How.CSS, using = "div[id='collapseOneTransferee'] app-partner")
	private List<WebElement> _partnerList;

	@FindBy(how = How.CSS, using = "div[id='collapseOneTransferee'] app-dependents")
	private List<WebElement> _dependentList;

	@FindBy(how = How.CSS, using = "app-dependents div[class*='usertitle']")
	private List<WebElement> _savedDependentNames;

	@FindBy(how = How.CSS, using = "div[id='collapseOneTransferee'] app-others")
	private List<WebElement> _otherList;

	@FindBy(how = How.CSS, using = "app-others div[class*='usertitle']")
	private List<WebElement> _savedOtherMemberNames;

	@FindBy(how = How.CSS, using = "app-partner div[class*='userdesignation']")
	private List<WebElement> _savedPartnerRelationships;

	@FindBy(how = How.CSS, using = "app-dependents div[class*='userdesignation']")
	private List<WebElement> _savedDependentRelationships;

	@FindBy(how = How.CSS, using = "app-others div[class*='userdesignation']")
	private List<WebElement> _savedOtherMemberRelationships;

	@FindBy(how = How.CSS, using = "app-partner")
	private WebElement _partnerSection;

	@FindBy(how = How.CSS, using = "app-dependents")
	private WebElement _dependentSection;

	@FindBy(how = How.CSS, using = "app-others")
	private WebElement _otherSection;

	@FindBy(how = How.CSS, using = "app-partner")
	private List<WebElement> _savedPartnerMembers;

	@FindBy(how = How.CSS, using = "app-dependents")
	private List<WebElement> _savedDependentMembers;

	@FindBy(how = How.CSS, using = "app-others")
	private List<WebElement> _savedOtherMembers;

	@FindBy(how = How.CSS, using = "app-phone")
	private WebElement _savedPhoneSection;

	@FindBy(how = How.CSS, using = "app-email")
	private WebElement _savedEmailSection;

	@FindBy(how = How.CSS, using = "app-partner i[class='icon-CaretUp_Open']")
	private WebElement _partnerCloseEditButton;

	@FindBy(how = How.CSS, using = "app-dependents i[class='icon-CaretUp_Open']")
	private WebElement _dependentCloseEditButton;

	@FindBy(how = How.CSS, using = "app-others i[class='icon-CaretUp_Open']")
	private WebElement _otherCloseEditButton;

	/**
	 * add transferee
	 * 
	 * @param table
	 */
	public void addTransfereeAndFamily(DataTable table) {
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			switch (data.get("Member")) {
			case (MYLOConstants.PARTNER):
				addPartnerWithMandatoryFields(data.get("Relationship"));
				break;
			case (MYLOConstants.DEPENDENT):
				addDependentWithMandatoryFields(data.get("Relationship"));
				break;
			case (MYLOConstants.OTHER):
				addOtherMemberWithMandatoryFields(data.get("Relationship"));
			}
		}
	}

	/**
	 * Add Partner
	 * 
	 * @param relationship
	 */
	public void addPartnerWithMandatoryFields(String relationship) {
		try {
			clickAddLink(MYLOConstants.ADD_PARTNER_LINK);
			enterRandomFirstNameAndLastName();
			selectValueFromDropdown(MYLOConstants.RELATIONSHIP_FORM_CONTROL, relationship);
			clickSaveOnAddMemberPopup();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ADD_PARTNER, relationship));
		}
	}

	/**
	 * Add Dependent
	 * 
	 * @param relationship
	 */
	public void addDependentWithMandatoryFields(String relationship) {
		try {
			clickAddLink(MYLOConstants.ADD_DEPENDENT_LINK);
			enterRandomFirstNameAndLastName();
			selectValueFromDropdown(MYLOConstants.RELATIONSHIP_FORM_CONTROL, relationship);
			clickSaveOnAddMemberPopup();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ADD_DEPENDENT, relationship));
		}
	}

	/**
	 * Add Other Member
	 * 
	 * @param relationship
	 */
	public void addOtherMemberWithMandatoryFields(String relationship) {
		try {
			clickAddLink(MYLOConstants.ADD_OTHER_LINK);
			enterRandomFirstNameAndLastName();
			enterText(MYLOConstants.TITLE, MYLOConstants.OTHER);
			clickSaveOnAddMemberPopup();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ADD_OTHER_MEMBER, relationship));
		}
	}

	/**
	 * Enter first Name and Last on Add Member Popup
	 */
	public void enterRandomFirstNameAndLastName() {
		enterText(MYLOConstants.FIRST_NAME, CoreFunctions.generateRandomString(5));
		enterText(MYLOConstants.LAST_NAME, CoreFunctions.generateRandomString(5));
	}

	/**
	 * Click Save On Add member Popup
	 */
	public void clickSaveOnAddMemberPopup() {
		try {
			CoreFunctions.click(driver, _saveButton, MYLOConstants.SAVE_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.SAVE_BUTTON));
		}
	}

	/**
	 * add transferee and family based on member
	 * 
	 * @param member
	 */
	public void addTransfereeAndFamily(String member) {
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		switch (member) {
		case (MYLOConstants.PARTNER):
			addPartnerWithMandatoryFields(MYLOConstants.DOMESTIC_PARTNER);
			break;
		case (MYLOConstants.DEPENDENT):
			addDependentWithMandatoryFields(MYLOConstants.PARENT);
			break;
		case (MYLOConstants.OTHER):
			addOtherMemberWithMandatoryFields(MYLOConstants.OTHER);
		}
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);

	}

	/**
	 * Click Add Links on transferee and Family Section
	 * 
	 * @param linkName
	 */
	private void clickAddLink(String linkName) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_addTransfereeAndFamilyLinks, linkName, MYLOConstants.TEXT);
			CoreFunctions.scrollToElementUsingJavaScript(driver, fieldElement, linkName);
			CoreFunctions.clickUsingJS(driver, fieldElement, linkName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_CLICK_LINK, linkName));
		}
	}

	/**
	 * Enter Text in text box on add popup
	 * 
	 * @param fieldName
	 * @param fieldValue
	 */
	private void enterText(String fieldName, String fieldValue) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver, _addTransfereeInput,
					fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.clearAndSetText(driver, fieldElement, fieldValue, MYLOConstants.TRUE);
			CoreFunctions.waitHandler(MYLOConstants.WAIT);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_TEXT, fieldName));
		}
	}

	/**
	 * select drop down values on add popup
	 * 
	 * @param fieldName
	 * @param fieldValue
	 */
	private void selectValueFromDropdown(String fieldName, String fieldValue) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_addTransfereeDropDown, fieldName, MYLOConstants.FORMCONTROLNAME);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, fieldElement, fieldName);
			CoreFunctions.click(driver, fieldElement, fieldName);
			CoreFunctions.waitHandler(MYLOConstants.WAIT);
			CoreFunctions.selectItemInListByText(driver, _addTransfereeDropDownOptions, fieldValue, MYLOConstants.TRUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_VALUE_FROM_DROPDOWN, fieldName));
		}
	}

	/**
	 * Enter text in input fields in edit mode
	 * 
	 * @param fieldName
	 * @param fieldValue
	 */
	private void enterTextEditTransfereeFamily(String fieldName, String fieldValue) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_editTransfereeInput, fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.clearAndSetText(driver, fieldElement, fieldValue, MYLOConstants.TRUE);
			CoreFunctions.waitHandler(MYLOConstants.WAIT);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_TEXT, fieldName));
		}
	}

	/**
	 * select drop down values in edit mode
	 * 
	 * @param fieldName
	 * @param fieldValue
	 */
	private void editValueFromDropdown(String fieldName, String fieldValue) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_editTransfereeDropDown, fieldName, MYLOConstants.FORMCONTROLNAME);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, fieldElement, fieldName);
			scrollToSuffix();
			CoreFunctions.click(driver, fieldElement, fieldName);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _editTransfereeDropDownOptions);
			scrollToSuffix();
			CoreFunctions.selectItemInListByText(driver, _editTransfereeDropDownOptions, fieldValue,
					MYLOConstants.TRUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_VALUE_FROM_DROPDOWN, fieldName));
		}
	}

	/**
	 * select phone/email value from drop down in edit mode
	 * 
	 * @param fieldName
	 * @param fieldValue
	 */
	private void selectPhoneEmailValueFromDropdown(String fieldName, String fieldValue) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_editTransfereeDropDown, fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.explicitWaitTillElementVisibility(driver, fieldElement, fieldName);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, fieldElement, fieldName);
			scrollToCitizen();
			CoreFunctions.click(driver, fieldElement, fieldName);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _editTransfereeDropDownOptions);
			CoreFunctions.waitHandler(MYLOConstants.WAIT);
			scrollToCitizen();
			CoreFunctions.selectItemInListByText(driver, _editTransfereeDropDownOptions, fieldValue,
					MYLOConstants.TRUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_VALUE_FROM_DROPDOWN, fieldName));
		}
	}

	/**
	 * scroll To Citizen
	 */
	public void scrollToCitizen() {
		WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver, _editTransfereeDropDown,
				MYLOConstants.CITIZENSHIP, MYLOConstants.FORMCONTROLNAME);
		CoreFunctions.scrollToElementUsingJavaScript(driver, fieldElement, MYLOConstants.CITIZENSHIP);

	}

	/**
	 * scroll to suffix
	 */
	public void scrollToSuffix() {
		WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver, _editTransfereeInput,
				MYLOConstants.SUFFIX_FORM_CONTROL, MYLOConstants.FORMCONTROLNAME);
		CoreFunctions.scrollToElementUsingJavaScript(driver, fieldElement, MYLOConstants.SUFFIX_FORM_CONTROL);

	}

	/**
	 * edit first and last name
	 */
	public void editToRandomFirstNameLastName() {
		String firstNameValue = CoreFunctions.generateRandomString(5);
		MyloNewFileUtil.set_partnerFName(firstNameValue);
		enterTextEditTransfereeFamily(MYLOConstants.FIRST_NAME, firstNameValue);
		scrollToSuffix();
		String lastNameValue = CoreFunctions.generateRandomString(5);
		MyloNewFileUtil.set_partnerLName(lastNameValue);
		enterTextEditTransfereeFamily(MYLOConstants.LAST_NAME, lastNameValue);
	}

	/**
	 * edit pronoun
	 */
	public void editPronoun(String pronoun) {
		try {
			editValueFromDropdown(MYLOConstants.PRONOUN_FORM_CONTROL, pronoun);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_TEXT, MYLOConstants.PRONOUNS));
		}
	}

	/**
	 * Edit partner relationship
	 * 
	 * @param relationship
	 */
	public void editPartnerOrDependentRelationship(String relationship) {
		try {
			editValueFromDropdown(MYLOConstants.RELATIONSHIP_FORM_CONTROL, relationship);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_TEXT, MYLOConstants.RELATIONSHIP));
		}
	}

	/**
	 * Edit Other Relationship
	 * 
	 * @param relationship
	 */
	public void editOtherRelationship(String relationship) {
		try {
			enterTextEditTransfereeFamily(MYLOConstants.TITLE, relationship);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_TEXT, MYLOConstants.RELATIONSHIP));
		}
	}

	/**
	 * add Phone Details
	 */
	public void addPhoneDetails() {
		try {
			scrollToCitizen();
			if (!CoreFunctions.isElementExist(driver, _savedPhoneSection, 5))
				clickAddLink(MYLOConstants.ADD_PHONE);
			String randomPhoneNumber = CoreFunctions.generateRandomNumberOfLength(10);
			MyloNewFileUtil.set_transfereePhoneNo(randomPhoneNumber);
			enterTextEditTransfereeFamily(MYLOConstants.NUMBER, randomPhoneNumber);
			selectPhoneEmailValueFromDropdown(MYLOConstants.ORIG_DEST, MYLOConstants.ORIGIN);
			selectPhoneEmailValueFromDropdown(MYLOConstants.TYPE, MYLOConstants.CELL_PHONE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_VALUES, MYLOConstants.PHONE_DETAILS));
		}
	}

	/**
	 * add email details
	 * 
	 * @param emailType
	 */
	public void addEmailDetails(String emailType) {
		try {
			scrollToCitizen();
			if (!CoreFunctions.isElementExist(driver, _savedEmailSection, MYLOConstants.WAIT))
				clickAddLink(MYLOConstants.ADD_EMAIL);
			scrollToCitizen();
			String email = CoreFunctions.generateRandomString(5) + MYLOConstants.EMAIL_ADDRESS_TEST;
			MyloNewFileUtil.set_transfereeEmail(email);
			enterTextEditTransfereeFamily(MYLOConstants.EMAIL_ADDRESS, email);
			scrollToCitizen();
			CoreFunctions.click(driver, _emailTypeDropdown, MYLOConstants.EMAIL_TYPE_COLUMN);
			scrollToCitizen();
			CoreFunctions.selectItemInListByText(driver, _editTransfereeDropDownOptions, emailType, MYLOConstants.TRUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_VALUES, MYLOConstants.EMAIL_DETAILS));
		}
	}

	/**
	 * add phone details in Other
	 */
	public void addPhoneDetailsInOther() {
		try {
			scrollToCitizen();
			String randomPhoneNumber = CoreFunctions.generateRandomNumberOfLength(10);
			MyloNewFileUtil.set_transfereePhoneNo(randomPhoneNumber);
			WebElement addlinkElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_addTransfereeAndFamilyLinks, MYLOConstants.ADD_PHONE, MYLOConstants.TEXT);
			if (!CoreFunctions.isElementExist(driver, _savedPhoneSection, 5))
				CoreFunctions.click(driver, addlinkElement, MYLOConstants.ADD_PHONE);
			enterTextEditTransfereeFamily(MYLOConstants.NUMBER, randomPhoneNumber);
			selectPhoneEmailValueFromDropdown(MYLOConstants.ORIG_DEST, MYLOConstants.ORIGIN);
			selectPhoneEmailValueFromDropdown(MYLOConstants.TYPE, MYLOConstants.CELL_PHONE);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_VALUES, MYLOConstants.PHONE_DETAILS));
		}
	}

	/**
	 * add email details in other
	 */
	public void addEmailDetailsInOther() {
		try {
			scrollToCitizen();
			if (!CoreFunctions.isElementExist(driver, _savedEmailSection, 5))
				clickAddLink(MYLOConstants.ADD_EMAIL);
			scrollToCitizen();
			String email = CoreFunctions.generateRandomString(5) + MYLOConstants.EMAIL_ADDRESS_TEST;
			MyloNewFileUtil.set_transfereeEmail(email);
			enterTextEditTransfereeFamily(MYLOConstants.EMAIL_ADDRESS, email);
			scrollToCitizen();
			CoreFunctions.click(driver, _emailTypeDropdown, MYLOConstants.EMAIL_TYPE_COLUMN);
			scrollToCitizen();
			CoreFunctions.selectItemInListByText(driver, _editTransfereeDropDownOptions, MYLOConstants.OTHER,
					MYLOConstants.TRUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_VALUES, MYLOConstants.EMAIL_DETAILS));
		}
	}

	/**
	 * Click Save in Edit member
	 */
	public void clickSaveInEditMember() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _saveIcon, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.highlightElementAndClick(driver, _saveIcon, MYLOConstants.SAVE_BUTTON);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.SAVE_BUTTON));
		}
	}

	/**
	 * Create Transferee and family if not exist
	 * 
	 * @param table
	 * @return
	 */
	public boolean createTransfereeAndFamilyIfNotExist(DataTable table) {
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		List<String> _existingPartnerRelationship = new ArrayList<String>();
		List<String> _existingDependentRelationship = new ArrayList<String>();
		List<String> _existingOtherRelationship = new ArrayList<String>();
		_existingPartnerRelationship = CoreFunctions.getElementInnerTextAndStoreInList(driver,
				_savedPartnerRelationships);
		_existingDependentRelationship = CoreFunctions.getElementTextAndStoreInList(driver,
				_savedDependentRelationships);
		_existingOtherRelationship = CoreFunctions.getElementTextAndStoreInList(driver, _savedOtherMemberRelationships);

		if (_existingPartnerRelationship.size() <= 2 && _existingOtherRelationship.size() <= 1
				&& _existingDependentRelationship.size() <= 2) {
			verifyAndCreatePartners(_existingPartnerRelationship);
			verifyAndCreateDependents(_existingDependentRelationship);
			verifyAndCreateOthers(_existingOtherRelationship);
			return true;
		}
		return false;
	}

	/**
	 * verify and Create Partners
	 * 
	 * @param _existingPartnerRelationship
	 */
	private void verifyAndCreatePartners(List<String> _existingPartnerRelationship) {
		int spouseCount = Collections.frequency(_existingPartnerRelationship, MYLOConstants.SPOUSE);
		int domesticPartnerCount = Collections.frequency(_existingPartnerRelationship, MYLOConstants.DOMESTIC_PARTNER);
		if (_existingPartnerRelationship.size() == 2) {
			if (spouseCount == 2) {
				updateRandomPartnerRelationship(MYLOConstants.DOMESTIC_PARTNER);
				CoreFunctions.scrollToElementUsingJavaScript(driver, _partnerSection, MYLOConstants.PARTNER);
				clickSaveInEditMember();
				CoreFunctions.scrollClickUsingJS(driver, _partnerCloseEditButton, MYLOConstants.EDIT_BUTTON);
			} else if (domesticPartnerCount == 2) {
				updateRandomPartnerRelationship(MYLOConstants.SPOUSE);
				CoreFunctions.scrollToElementUsingJavaScript(driver, _partnerSection, MYLOConstants.PARTNER);
				clickSaveInEditMember();
				CoreFunctions.scrollClickUsingJS(driver, _partnerCloseEditButton, MYLOConstants.EDIT_BUTTON);
			}
		}
		if (_existingPartnerRelationship.size() == 1) {
			// var result =
			// _existingPartnerRelationship.contains(MYLOConstants.DOMESTIC_PARTNER)?addPartnerWithMandatoryFields(MYLOConstants.SPOUSE):addPartnerWithMandatoryFields(MYLOConstants.DOMESTIC_PARTNER);
			if (_existingPartnerRelationship.contains(MYLOConstants.DOMESTIC_PARTNER))
				addPartnerWithMandatoryFields(MYLOConstants.SPOUSE);
			else
				addPartnerWithMandatoryFields(MYLOConstants.DOMESTIC_PARTNER);
		}
		if (_existingPartnerRelationship.size() == 0) {
			addPartnerWithMandatoryFields(MYLOConstants.SPOUSE);
			addPartnerWithMandatoryFields(MYLOConstants.DOMESTIC_PARTNER);
		}

	}

	/**
	 * update random partner relationship
	 * 
	 * @param partnerRelationship
	 */
	private void updateRandomPartnerRelationship(String partnerRelationship) {
		CoreFunctions.scrollToElementUsingJS(driver, _partnerSection, MYLOConstants.PARTNER);
		CoreFunctions.clickUsingJS(driver, _partnerEditButtons.get(0), MYLOConstants.EDIT_BUTTON);
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		editPartnerOrDependentRelationship(partnerRelationship);
	}

	/**
	 * verify and create Dependents
	 * 
	 * @param _existingDependentRelationship
	 */
	public void verifyAndCreateDependents(List<String> _existingDependentRelationship) {
		int parentCount = Collections.frequency(_existingDependentRelationship, MYLOConstants.PARENT);
		int childCount = Collections.frequency(_existingDependentRelationship, MYLOConstants.CHILD);

		if (_existingDependentRelationship.size() == 2) {
			CoreFunctions.refreshPage(driver);
			CoreFunctions.waitForBrowserToLoad(driver);
			CoreFunctions.waitHandler(MYLOConstants.CUSTOM_WAIT_TIME);
			CoreFunctions.click(driver, _appTransfereeAndFamilyExpandButton,
					MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
			if (parentCount == 2) {
				updateRandomDependentRelationship(MYLOConstants.CHILD);
				CoreFunctions.scrollToElementUsingJavaScript(driver, _dependentSection, MYLOConstants.DEPENDENT);
				clickSaveInEditMember();
				CoreFunctions.scrollClickUsingJS(driver, _dependentCloseEditButton, MYLOConstants.EDIT_BUTTON);
			} else if (childCount == 2) {
				updateRandomDependentRelationship(MYLOConstants.PARENT);
				CoreFunctions.scrollToElementUsingJavaScript(driver, _dependentSection, MYLOConstants.DEPENDENT);
				clickSaveInEditMember();
				CoreFunctions.scrollClickUsingJS(driver, _dependentCloseEditButton, MYLOConstants.EDIT_BUTTON);
			}
		}
		if (_existingDependentRelationship.size() == 1) {
			if (_existingDependentRelationship.contains(MYLOConstants.CHILD))
				addDependentWithMandatoryFields(MYLOConstants.PARENT);
			else
				addDependentWithMandatoryFields(MYLOConstants.CHILD);
		}
		if (_existingDependentRelationship.size() == 0) {
			addDependentWithMandatoryFields(MYLOConstants.PARENT);
			addDependentWithMandatoryFields(MYLOConstants.CHILD);
		}

	}

	/**
	 * Update Random Dependent Relationship
	 * 
	 * @param dependentRelationship
	 */
	private void updateRandomDependentRelationship(String dependentRelationship) {
		CoreFunctions.scrollToElementUsingJS(driver, _dependentSection, MYLOConstants.DEPENDENT);
		CoreFunctions.clickUsingJS(driver, _dependentEditButtons.get(0), MYLOConstants.EDIT_BUTTON);
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		CoreFunctions.waitHandler(MYLOConstants.WAIT);
		editPartnerOrDependentRelationship(dependentRelationship);
	}

	/**
	 * verify and create Others
	 * 
	 * @param _existingOtherRelationship
	 */
	public void verifyAndCreateOthers(List<String> _existingOtherRelationship) {
		if (_existingOtherRelationship.size() == 1 && !_existingOtherRelationship.contains(MYLOConstants.OTHER)) {
			updateOtherMemberRelationship(MYLOConstants.OTHER);
			CoreFunctions.scrollToElementUsingJavaScript(driver, _otherSection, MYLOConstants.OTHER);
			clickSaveInEditMember();
			CoreFunctions.scrollClickUsingJS(driver, _otherCloseEditButton, MYLOConstants.EDIT_BUTTON);
		}
		if (_existingOtherRelationship.size() == 0) {
			addOtherMemberWithMandatoryFields(MYLOConstants.OTHER);
		}

	}

	/**
	 * Update Other Member Relationship
	 * 
	 * @param Relationship
	 */
	private void updateOtherMemberRelationship(String relationship) {
		CoreFunctions.scrollToElementUsingJS(driver, _otherSection, MYLOConstants.EDIT_BUTTON);
		CoreFunctions.clickUsingJS(driver, _otherEditButtons.get(0), MYLOConstants.EDIT_BUTTON);
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		editOtherRelationship(relationship);
	}

	/**
	 * Create Partner if not exist
	 * 
	 * @param relationship
	 */
	public void createPartnerIfNotExists(String relationship) {
		boolean flag = false;
		for (WebElement row : _partnerRelationship) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
			if (row.getText().contains(relationship)) {
				flag = true;
				break;
			}
		}
		if (!flag)
			addPartnerWithMandatoryFields(relationship);
	}

	/**
	 * Create Dependent if not exist
	 * 
	 * @param relationship
	 */
	public void createDependentIfNotExists(String relationship) {
		boolean flag = false;
		for (WebElement row : _dependentRelationship) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
			if (row.getText().contains(relationship)) {
				flag = true;
				break;
			}
		}
		if (!flag)
			addDependentWithMandatoryFields(relationship);
	}

	/**
	 * Create Other if not exist
	 * 
	 * @param relationship
	 */
	public void createOtherIfNotExists(String relationship) {
		boolean flag = false;
		for (WebElement row : _otherRelationship) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
			if (row.getText().contains(relationship)) {
				flag = true;
				break;
			}
		}
		if (!flag)
			addOtherMemberWithMandatoryFields(relationship);
	}

	/**
	 * Update tranferee and family details
	 * 
	 * @param member
	 * @param table
	 */
	public void updateFields(String member, String memberName) {
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		String expanded = CoreFunctions.getElementAttributeValue(driver, _appTransfereeAndFamilyExpandButton,
				"aria-expanded");
		if (expanded.equals("false"))
			CoreFunctions.click(driver, _appTransfereeAndFamilyExpandButton,
					MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		int index;
		switch (member) {
		case (MYLOConstants.PARTNER):
			index = BusinessFunctions.returnindexItemFromListUsingAttribute(driver, _savedPartnerNames, memberName,
					MYLOConstants.OUTER_TEXT);
			CoreFunctions.scrollToElementUsingJS(driver, _partnerSection, MYLOConstants.EDIT_BUTTON);
			CoreFunctions.clickUsingJS(driver, _partnerEditButtons.get(index), MYLOConstants.EDIT_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			editToRandomFirstNameLastName();
			editPronoun(MYLOConstants.PREFER_NOT_TO_ANSWER);
			editPartnerOrDependentRelationship(MYLOConstants.SPOUSE);
			addPhoneDetails();
			addEmailDetails(MYLOConstants.SPOUSE_PERSONAL);
			CoreFunctions.scrollToElementUsingJavaScript(driver, _partnerSection, MYLOConstants.PARTNER);
			clickSaveInEditMember();
			CoreFunctions.scrollClickUsingJS(driver, _partnerCloseEditButton, MYLOConstants.EDIT_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			break;
		case (MYLOConstants.DEPENDENT):
			CoreFunctions.refreshPage(driver);
			CoreFunctions.waitForBrowserToLoad(driver);
			CoreFunctions.waitHandler(MYLOConstants.CUSTOM_WAIT_TIME);
			CoreFunctions.click(driver, _appTransfereeAndFamilyExpandButton,
					MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
			index = BusinessFunctions.returnindexItemFromListUsingAttribute(driver, _savedDependentNames, memberName,
					MYLOConstants.OUTER_TEXT);
			CoreFunctions.scrollToElementUsingJS(driver, _dependentEditButtons.get(index), MYLOConstants.EDIT_BUTTON);
			CoreFunctions.clickUsingJS(driver, _dependentEditButtons.get(index), MYLOConstants.EDIT_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			editToRandomFirstNameLastName();
			editPronoun(MYLOConstants.PREFER_NOT_TO_ANSWER);
			editPartnerOrDependentRelationship(MYLOConstants.CHILD);
			addPhoneDetails();
			addEmailDetails(MYLOConstants.OTHER);
			CoreFunctions.scrollToElementUsingJavaScript(driver, _dependentSection, MYLOConstants.DEPENDENT);
			clickSaveInEditMember();
			CoreFunctions.scrollClickUsingJS(driver, _dependentCloseEditButton, MYLOConstants.EDIT_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			break;
		case (MYLOConstants.OTHER):
			CoreFunctions.refreshPage(driver);
			CoreFunctions.waitForBrowserToLoad(driver);
			CoreFunctions.waitHandler(MYLOConstants.CUSTOM_WAIT_TIME);
			CoreFunctions.click(driver, _appTransfereeAndFamilyExpandButton,
					MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
			index = BusinessFunctions.returnindexItemFromListUsingAttribute(driver, _savedOtherMemberNames, memberName,
					MYLOConstants.OUTER_TEXT);
			CoreFunctions.scrollToElementUsingJS(driver, _otherEditButtons.get(index), MYLOConstants.EDIT_BUTTON);
			CoreFunctions.clickUsingJS(driver, _otherEditButtons.get(index), MYLOConstants.EDIT_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			editToRandomFirstNameLastName();
			editPronoun(MYLOConstants.PREFER_NOT_TO_ANSWER);
			editOtherRelationship(MYLOConstants.OTHER_EDIT);
			addPhoneDetailsInOther();
			addEmailDetailsInOther();
			CoreFunctions.scrollToElementUsingJavaScript(driver, _otherSection, MYLOConstants.OTHER);
			clickSaveInEditMember();
			CoreFunctions.scrollClickUsingJS(driver, _otherCloseEditButton, MYLOConstants.EDIT_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			break;
		}
		CoreFunctions.waitHandler(MYLOConstants.WAIT);
	}

	/**
	 * @param relationship
	 * @return
	 */
	public String getSavedPartnerName(String relationship) {
		String partnerName = "";
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingAttribute(driver, _savedPartnerRelationships,
					relationship, MYLOConstants.TITLE);
			partnerName = CoreFunctions.getAttributeText(_savedPartnerNames.get(index), MYLOConstants.OUTER_TEXT);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.UNABLE_TO_GET_PARTNER_DETAILS, CoreConstants.FAIL,
					relationship));
			Assert.fail(MessageFormat.format(CoreConstants.UNABLE_TO_GET_PARTNER_DETAILS, CoreConstants.FAIL,
					relationship));
		}
		return partnerName;
	}

	/**
	 * @param relationship
	 * @return
	 */
	public String getSavedDependentName(String relationship) {
		String dependentName = "";
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingAttribute(driver, _savedDependentRelationships,
					relationship, MYLOConstants.TITLE);
			dependentName = CoreFunctions.getAttributeText(_savedDependentNames.get(index), MYLOConstants.OUTER_TEXT);

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.UNABLE_TO_GET_DEPENDENT_DETAILS, CoreConstants.FAIL,
					relationship));
			Assert.fail(MessageFormat.format(CoreConstants.UNABLE_TO_GET_DEPENDENT_DETAILS, CoreConstants.FAIL,
					relationship));
		}
		return dependentName;

	}

	/**
	 * @param relationship
	 * @return
	 */
	public String getSavedOtherName(String relationship) {
		String otherName = "";
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingAttribute(driver, _savedOtherMemberRelationships,
					relationship, MYLOConstants.TITLE);
			otherName = CoreFunctions.getAttributeText(_savedOtherMemberNames.get(index), MYLOConstants.OUTER_TEXT);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(CoreConstants.UNABLE_TO_GET_OTHER_DETAILS, CoreConstants.FAIL, relationship));
			Assert.fail(
					MessageFormat.format(CoreConstants.UNABLE_TO_GET_OTHER_DETAILS, CoreConstants.FAIL, relationship));
		}
		return otherName;

	}

	/**
	 * verify and create Transferee and family if not exist
	 * 
	 * @param table
	 * @param _myloDashboardPage
	 * @param _myloNewFileSection
	 */
	public void verifyAndCreateTransfereeAndFamilyIfNotExist(DataTable table, Mylo_DashboardHomePage _myloDashboardPage,
			MyloJourneyPage_CreateNewFileSection _myloNewFileSection) {
		if (!createTransfereeAndFamilyIfNotExist(table)) {
			_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
			_myloNewFileSection.createNewFile(MYLOConstants.AUTOMATION_CLIENT_ID);
			CoreFunctions.writeToPropertiesFile("FileID", MyloNewFileUtil.getFileID());
			CoreFunctions.writeToPropertiesFile(MYLOConstants.TRANSFEREE_FIRSTNAME,
					MyloNewFileUtil.getTransfereeFirstName());
			CoreFunctions.writeToPropertiesFile(MYLOConstants.TRANSFEREE_LASTNAME,
					MyloNewFileUtil.getTransfereeLastName());
			addTransfereeAndFamily(table);
		}

	}

}
