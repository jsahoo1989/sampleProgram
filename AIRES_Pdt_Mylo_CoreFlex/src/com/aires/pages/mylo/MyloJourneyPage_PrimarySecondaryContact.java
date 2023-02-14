package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
import com.aires.utilities.CustomSoftAssert;
import com.aires.utilities.Log;
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

/**
 * @author Jsahoo
 *
 */
/**
 * @author Jsahoo
 *
 */
public class MyloJourneyPage_PrimarySecondaryContact extends Base {

	public MyloJourneyPage_PrimarySecondaryContact(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "app-primary-contact")
	private WebElement _primaryContactSection;

	@FindBy(how = How.CSS, using = "button[aria-controls='collapseOneContact']")
	private WebElement _expandPrimaryContactSection;

	@FindBy(how = How.CSS, using = "div#secondaryContact p[class*='addinfo'] a")
	private WebElement _selectSecondaryContactLink;

	@FindBy(how = How.CSS, using = "mat-dialog-container[class*='mat-dialog']")
	private WebElement _selectContactPopup;

	@FindBy(how = How.CSS, using = "app-add-contact-popup button")
	private List<WebElement> _selectContactButtons;

	@FindBy(how = How.CSS, using = "div[class*='primary-secondry-card']")
	private List<WebElement> _contactListOnPopup;

	@FindBy(how = How.CSS, using = "p[class*='contact-card-blue']")
	private List<WebElement> _contactNameOnPopup;

	@FindBy(how = How.CSS, using = "div[class='custom-radio']")
	private List<WebElement> _contactRadioButtonsOnPopup;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] div[class*='usertitle']")
	private WebElement _selectedSecondaryContactName;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] div[class*='userdesignation']")
	private WebElement _selectedSecondaryContactRelationship;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] div[class*='user-role'] div[class*='title']")
	private WebElement _selectedSecondaryContactPronoun;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] div[class*='userphnumber']")
	private WebElement _selectedSecondaryContactPhoneNumber;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] div[class*='usermailid']")
	private WebElement _selectedSecondaryContactEmail;

	@FindBy(how = How.CSS, using = "div[class*='mylo-errorpopup']")
	private WebElement _errorDialog;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _errorDialogHeader;

	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _errorDialogOkButton;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] span")
	private List<WebElement> _secondaryContactCardButtons;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] div[class*='usertitle']")
	private WebElement _selectedPrimaryContactName;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] div[class*='userdesignation']")
	private WebElement _selectedPrimaryContactRelationship;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] div[class*='user-role'] div[class*='title']")
	private WebElement _selectedPrimaryContactPronoun;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] div[class*='userphnumber']")
	private WebElement _selectedPrimaryContactPhoneNumber;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] div[class*='usermailid']")
	private WebElement _selectedPrimaryContactEmail;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] button")
	private WebElement _primaryContactChangeButton;

	@FindBy(how = How.CSS, using = "p[class*='contact-card-blue']")
	private List<WebElement> _selectPrimaryContactText;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	private boolean _isExists = false;
	Map<String, String> primaryContactfieldValueMapping = new LinkedHashMap<String, String>();
	Map<String, String> secondaryContactfieldValueMapping = new LinkedHashMap<String, String>();

	/**
	 * Verify if error dialog is displayed
	 * 
	 */
	public void verifySecondaryErrorDialogDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _errorDialog, 5);
			if (_isExists) {
				_isExists = BusinessFunctions.verifyMyloPopUpMessage(driver, _errorDialogHeader,
						MYLOConstants.SECONDARY_CONTACT_INCORRECT_SELECTION_ERROR,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP);
				CoreFunctions.clickElement(driver, _errorDialogOkButton);
				BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_errorDialog, MYLOConstants.SECONDARY_CONTACT_INCORRECT_SELECTION_ERROR));
		}

	}

	/**
	 * Verify if error dialog is displayed
	 * 
	 */
	public void verifyPrimaryErrorDialogDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _errorDialog, 5);
			if (_isExists) {
				_isExists = BusinessFunctions.verifyMyloPopUpMessage(driver, _errorDialogHeader,
						MYLOConstants.PRIMARY_CONTACT_INCORRECT_SELECTION_ERROR,
						MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP);
				CoreFunctions.clickElement(driver, _errorDialogOkButton);
				BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_errorDialog, MYLOConstants.PRIMARY_CONTACT_INCORRECT_SELECTION_ERROR));
		}

	}

	/**
	 * Verify if select secondary contact popup is displayed
	 * 
	 * @return
	 */
	public boolean isSelectSecondaryContactPopupDisplayed() {
		try {
			_isExists = CoreFunctions.isElementExist(driver, _selectContactPopup, 5);
			if (_isExists)
				Reporter.addStepLog(
						MessageFormat.format(MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP, CoreConstants.PASS));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_selectContactPopup, MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));
		}
		return _isExists;
	}

	/**
	 * Verify if select secondary contact link is displayed
	 * 
	 */
	public void verifySelectSecondaryContactLinkDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _selectSecondaryContactLink, 5);
			if (_isExists)
				Reporter.addStepLog(
						MessageFormat.format(MYLOConstants.SELECT_SECONDARY_CONTACT_LINK, CoreConstants.PASS));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.SELECT_SECONDARY_CONTACT_LINK));
		}
	}

	/**
	 * Click button in secondary contact card
	 * 
	 * @param buttonName
	 */
	public void clickButtonInSecondaryContactCard(String buttonName) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_secondaryContactCardButtons, buttonName, MYLOConstants.OUTER_TEXT);
			CoreFunctions.highlightElementAndClick(driver, fieldElement, buttonName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, buttonName));
		}
	}

	/**
	 * Click Select Secondary Contact Card link
	 */
	public void clickSelectSecondaryContactLink() {
		try {
			CoreFunctions.click(driver, _selectSecondaryContactLink, MYLOConstants.SELECT_SECONDARY_CONTACT);
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.SELECT_SECONDARY_CONTACT_LINK));
		}
	}

	/**
	 * Expand Primary Contact Details Section
	 */
	public void expandPrimaryContactDetailsSection() {
		try {
			scrollToPrimaryContactSection();
			CoreFunctions.scrollClickUsingJS(driver, _expandPrimaryContactSection,
					MYLOConstants.EXPAND_PRIMARY_CONTACT_SECTION);
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.EXPAND_PRIMARY_CONTACT_SECTION));
		}

	}

	/**
	 * Click button in Select secondary contact popup
	 * 
	 * @param buttonName
	 */
	public void clickButtonInSelectContactDialog(String buttonName) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_selectContactButtons, buttonName, MYLOConstants.CLASS);
			CoreFunctions.highlightElementAndClick(driver, fieldElement, buttonName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, buttonName));
		}
	}

	/**
	 * verify button is disabled
	 * 
	 * @param buttonName
	 */
	public boolean isButtonDisabled(String buttonName) {
		boolean isDisabled = false;
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_selectContactButtons, buttonName, MYLOConstants.CLASS);
			if (CoreFunctions.getElementAttributeValue(driver, fieldElement, MYLOConstants.DISABLED).equals(""))
				isDisabled = true;
		} catch (Exception e) {
			isDisabled = false;
		}
		return isDisabled;
	}

	/**
	 * Select Secondary contact on Popup by Name
	 * 
	 * @param name
	 * @param _softAssert
	 */
	public void selectSecondaryContactOnPopup(String name, CustomSoftAssert _softAssert) {
		try {
			_softAssert.assertTrue(isButtonDisabled(name), MessageFormat.format(MYLOConstants.BUTTON_ENABLED, name));
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _contactNameOnPopup, name);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _contactRadioButtonsOnPopup, index);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			_softAssert.assertFalse(isButtonDisabled(name), MessageFormat.format(MYLOConstants.BUTTON_DISABLED, name));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_SECONDARY_CONTACT, name));
		}
	}

	/**
	 * Maps the selected contact details
	 * 
	 * @param field
	 * @return
	 */
	public void mapSelectedSecondaryContactDetails() {
		List<String> contactCardFields = Arrays.asList(MYLOConstants.NAME, MYLOConstants.RELATIONSHIP,
				MYLOConstants.PRONOUN, MYLOConstants.PHONE_DETAILS, MYLOConstants.EMAIL_DETAILS);
		List<String> primaryContactCardValues = Arrays.asList(
				CoreFunctions.getElementText(driver, _selectedSecondaryContactName),
				CoreFunctions.getElementText(driver, _selectedSecondaryContactRelationship),
				CoreFunctions.getElementText(driver, _selectedSecondaryContactPronoun),
				CoreFunctions.getAttributeText(_selectedSecondaryContactPhoneNumber, MYLOConstants.TITLE),
				CoreFunctions.getAttributeText(_selectedSecondaryContactEmail, MYLOConstants.TITLE));
		secondaryContactfieldValueMapping = IntStream.range(0, contactCardFields.size()).boxed()
				.collect(Collectors.toMap(i -> contactCardFields.get(i), i -> primaryContactCardValues.get(i)));
	}

	/**
	 * verifySelectedOtherMemberUpdated
	 * 
	 * @param secondaryContact
	 * @param softAssert
	 */
	public void verifySelectedOtherMemberUpdated(String sectionName, CustomSoftAssert softAssert) {
		Map<String, String> contactFieldMapping = getContactFieldValueMap(sectionName);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.NAME)
						.equalsIgnoreCase(MyloNewFileUtil.get_otherFName() + " " + MyloNewFileUtil.get_otherLName()),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.NAME);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.PRONOUN).equalsIgnoreCase(MYLOConstants.PREFER_NOT_TO_ANSWER),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.PRONOUN);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.PHONE_DETAILS)
						.equalsIgnoreCase(MyloNewFileUtil.get_transfereePhoneNo() + " " + MYLOConstants.CELL_PHONE),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.PHONE_NUMBER);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.RELATIONSHIP).equalsIgnoreCase(MYLOConstants.OTHER_EDIT),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.RELATIONSHIP);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.EMAIL_DETAILS)
						.equalsIgnoreCase(MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.OTHER),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.EMAIL);
	}

	/**
	 * verifySelectedDependentMemberUpdated
	 * 
	 * @param secondaryContact
	 * @param softAssert
	 */
	public void verifySelectedDependentMemberUpdated(String sectionName, CustomSoftAssert softAssert) {
		Map<String, String> contactFieldMapping = getContactFieldValueMap(sectionName);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.NAME).equalsIgnoreCase(
						MyloNewFileUtil.get_dependentFName() + " " + MyloNewFileUtil.get_dependentLName()),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.NAME);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.PRONOUN).equalsIgnoreCase(MYLOConstants.PREFER_NOT_TO_ANSWER),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.PRONOUN);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.PHONE_DETAILS)
						.equalsIgnoreCase(MyloNewFileUtil.get_transfereePhoneNo() + " " + MYLOConstants.CELL_PHONE),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.PHONE_NUMBER);
		softAssert.assertTrue(contactFieldMapping.get(MYLOConstants.RELATIONSHIP).equalsIgnoreCase(MYLOConstants.CHILD),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.RELATIONSHIP);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.EMAIL_DETAILS)
						.equalsIgnoreCase(MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.OTHER),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.EMAIL);

	}

	/**
	 * verifySelectedPartnerMemberUpdated
	 * 
	 * @param softAssert
	 */
	public void verifySelectedPartnerMemberUpdated(String sectionName, CustomSoftAssert softAssert) {

		Map<String, String> contactFieldMapping = getContactFieldValueMap(sectionName);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.NAME).equalsIgnoreCase(
						MyloNewFileUtil.get_partnerFName() + " " + MyloNewFileUtil.get_partnerLName()),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.NAME);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.PRONOUN).equalsIgnoreCase(MYLOConstants.PREFER_NOT_TO_ANSWER),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.PRONOUN);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.PHONE_DETAILS)
						.equalsIgnoreCase(MyloNewFileUtil.get_transfereePhoneNo() + " " + MYLOConstants.CELL_PHONE),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.PHONE_NUMBER);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.RELATIONSHIP).equalsIgnoreCase(MYLOConstants.SPOUSE),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.RELATIONSHIP);
		softAssert.assertTrue(
				contactFieldMapping.get(MYLOConstants.EMAIL_DETAILS)
						.equalsIgnoreCase(MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.SPOUSE_PERSONAL),
				CoreConstants.FAILED_TO_VERFY + " " + MYLOConstants.EMAIL);

	}

	/**
	 * getContactFieldValueMap
	 * 
	 * @param sectionName
	 * @return
	 */
	private Map<String, String> getContactFieldValueMap(String sectionName) {

		if (sectionName.equals(MYLOConstants.PRIMARY_CONTACT)) {
			mapSelectedPrimaryContactDetails();
			return primaryContactfieldValueMapping;
		} else {
			mapSelectedSecondaryContactDetails();
			return secondaryContactfieldValueMapping;
		}

	}

	/**
	 * Maps the selected primary contact details
	 * 
	 * @param field
	 * @return
	 */

	public void mapSelectedPrimaryContactDetails() {

		List<String> contactCardFields = Arrays.asList(MYLOConstants.NAME, MYLOConstants.RELATIONSHIP,
				MYLOConstants.PRONOUN, MYLOConstants.PHONE_DETAILS, MYLOConstants.EMAIL_DETAILS);
		List<String> primaryContactCardValues = Arrays.asList(
				CoreFunctions.getElementText(driver, _selectedPrimaryContactName),
				CoreFunctions.getElementText(driver, _selectedPrimaryContactRelationship),
				CoreFunctions.getElementText(driver, _selectedPrimaryContactPronoun),
				CoreFunctions.getAttributeText(_selectedPrimaryContactPhoneNumber, MYLOConstants.TITLE),
				CoreFunctions.getAttributeText(_selectedPrimaryContactEmail, MYLOConstants.TITLE));
		primaryContactfieldValueMapping = IntStream.range(0, contactCardFields.size()).boxed()
				.collect(Collectors.toMap(i -> contactCardFields.get(i), i -> primaryContactCardValues.get(i)));

	}

	/**
	 * Click Change button on Primary contact card
	 * 
	 * @param buttonName
	 */
	public void clickChangeButtonInPrimaryContactCard() {
		try {
			CoreFunctions.highlightElementAndClick(driver, _primaryContactChangeButton, MYLOConstants.CHANGE_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.CHANGE_BUTTON));
		}
	}

	/**
	 * Verify if select Primary contact popup is displayed
	 * 
	 * @return
	 */
	public boolean isSelectPrimaryContactPopupDisplayed() {
		try {
			_isExists = CoreFunctions.isElementExist(driver, _selectContactPopup, 5);
			if (_isExists)
				Reporter.addStepLog(
						MessageFormat.format(MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP, CoreConstants.PASS));

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_selectContactPopup, MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP));
		}
		return _isExists;
	}

	/**
	 * Select Primary contact on Popup by Name
	 * 
	 * @param name
	 * @param _softAssert
	 */
	public void selectPrimaryContactOnPopup(String name, CustomSoftAssert _softAssert) {
		try {
			_softAssert.assertTrue(isButtonDisabled(name), MessageFormat.format(MYLOConstants.BUTTON_ENABLED, name));
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _contactNameOnPopup, name);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _contactRadioButtonsOnPopup, index);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			_softAssert.assertFalse(isButtonDisabled(name), MessageFormat.format(MYLOConstants.BUTTON_ENABLED, name));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_PRIMARY_CONTACT, name));
		}
	}

	/**
	 * scroll to primary contact section
	 */
	public void scrollToPrimaryContactSection() {
		CoreFunctions.scrollToElementUsingJS(driver, _primaryContactSection, MYLOConstants.PRIMARY_CONTACT_SECTION);
	}

	/**
	 * Remove secondary contact if present
	 */
	public void verifyAndRemoveSecondaryContactIfPresent() {
		if (!CoreFunctions.isElementExist(driver, _selectSecondaryContactLink, 5))
			clickButtonInSecondaryContactCard(MYLOConstants.REMOVE_BUTTON);
	}

	/**
	 * Update Primary Contact Details
	 * 
	 * @param _softAssert
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public void verifyAndUpdatePrimaryContact(String transfereeName, CustomSoftAssert _softAssert) {
		mapSelectedPrimaryContactDetails();
		if (!primaryContactfieldValueMapping.get(MYLOConstants.NAME).equals(transfereeName)) {
			scrollToPrimaryContactSection();
			clickChangeButtonInPrimaryContactCard();
			selectPrimaryContactOnPopup(transfereeName, _softAssert);
			clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		}
	}

	/**
	 * Verify Member Present on page
	 * 
	 * @param _softAssert
	 * 
	 * @param name
	 */
	public void verifyMembersPresentOnPopup(List<String> member, CustomSoftAssert _softAssert) {
		for (String name : member)
			_softAssert.assertTrue(
					CoreFunctions.searchElementExistsInListByText(driver, _contactNameOnPopup, name, true),
					MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_MEMBER_ON_POPUP, CoreConstants.FAIL, name));
	}

	/**
	 * verify selected Primary contact name
	 * 
	 * @param name
	 */
	public boolean verifySelectedPrimaryContactName(String name) {
		mapSelectedPrimaryContactDetails();
		if (primaryContactfieldValueMapping.get(MYLOConstants.NAME).equalsIgnoreCase(name)) {
			Reporter.addStepLog(CoreConstants.PASS + CoreConstants.TXT_ACTUAL
					+ primaryContactfieldValueMapping.get(MYLOConstants.NAME) + " " + CoreConstants.TXT_EXPECTED
					+ name);
			return true;
		} else {
			Log.info(CoreConstants.FAIL + CoreConstants.TXT_ACTUAL
					+ primaryContactfieldValueMapping.get(MYLOConstants.NAME) + " " + CoreConstants.TXT_EXPECTED
					+ name);
			return false;
		}

	}

}
