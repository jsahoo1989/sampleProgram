package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.List;

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

public class MyloJourneyPage_SecondaryContact extends Base {

	public MyloJourneyPage_SecondaryContact(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "button[aria-controls='collapseOneContact']")
	private WebElement _expandPrimaryContactSection;

	@FindBy(how = How.CSS, using = "app-aires-file-information h2")
	private WebElement _fileInformationSection;
	
	@FindBy(how = How.CSS, using = "div#secondaryContact a")
	private List<WebElement> _secondaryContactSectionLinks;

	@FindBy(how = How.CSS, using = "mat-dialog-container[class*='mat-dialog']")
	private WebElement _selectSecondaryContactPopup;

	@FindBy(how = How.CSS, using = "h5[class*='modal-title']")
	private WebElement _selectSecondaryContactPopupHeader;

	@FindBy(how = How.CSS, using = "app-add-contact-popup button")
	private List<WebElement> _selectSecondaryContactButtons;

	@FindBy(how = How.CSS, using = "div[class*='primary-secondry-card']")
	private List<WebElement> _secondaryContactItems;

	@FindBy(how = How.CSS, using = "p[class*='contact-card-blue']")
	private List<WebElement> _selectSecondaryContactText;

	@FindBy(how = How.CSS, using = "div[class='custom-radio']")
	private List<WebElement> _selectSecondaryRadioButtons;

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

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	private boolean _isExists = false;

	/**
	 * Verify if error dialog is displayed
	 * 
	 * @return
	 */
	public boolean isErrorDialogDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _errorDialog, MYLOConstants.WAIT);
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
		return _isExists;

	}

	/**
	 * Verify if select secondary contact popup is displayed
	 * 
	 * @return
	 */
	public boolean isSelectSecondaryContactPopupDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _selectSecondaryContactPopup, MYLOConstants.WAIT);
			if (_isExists)
				Reporter.addStepLog(
						MessageFormat.format(MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP, CoreConstants.PASS));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_selectSecondaryContactPopup, MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));
		}
		return _isExists;
	}

	/**
	 * Verify if select secondary contact link is displayed
	 * 
	 * @return
	 */
	public boolean isSelectSecondaryContactLinkDisplayed() {

		try {
			WebElement element = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_secondaryContactSectionLinks, MYLOConstants.SELECT_SECONDARY_CONTACT, MYLOConstants.TEXT);
			_isExists = CoreFunctions.isElementExist(driver, element, MYLOConstants.WAIT);
			if (_isExists)
				Reporter.addStepLog(
						MessageFormat.format(MYLOConstants.SELECT_SECONDARY_CONTACT_LINK, CoreConstants.PASS));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.SELECT_SECONDARY_CONTACT_LINK));
		}
		return _isExists;
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
			WebElement element = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_secondaryContactSectionLinks, MYLOConstants.SELECT_SECONDARY_CONTACT, MYLOConstants.TEXT);
			CoreFunctions.click(driver, element, MYLOConstants.SELECT_SECONDARY_CONTACT);
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
			CoreFunctions.scrollToElementUsingJS(driver, _fileInformationSection,
					MYLOConstants.FILE_INFORMATION_SECTION);
			CoreFunctions.highlightElementAndClick(driver, _expandPrimaryContactSection,
					MYLOConstants.EXPAND_PRIMARY_CONTACT_SECTION);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
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
	public void clickButtonInSelectSecondaryContactDialog(String buttonName) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_selectSecondaryContactButtons, buttonName, MYLOConstants.CLASS);
			CoreFunctions.highlightElementAndClick(driver, fieldElement, buttonName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, buttonName));
		}
	}

	/**
	 * Select Secondary contact on Popup by Name
	 * 
	 * @param name
	 */
	public void selectSecondaryContactOnPopup(String name) {
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _selectSecondaryContactText, name);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _selectSecondaryRadioButtons, index);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_SECONDARY_CONTACT, name));
		}
	}

	/**
	 * Select Secondary contact on Popup by Index
	 * 
	 * @param index
	 */
	public void selectSecondaryContactOnPopup(int index) {
		try {
			BusinessFunctions.selectValueFromListUsingIndex(driver, _selectSecondaryRadioButtons, index);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_SECONDARY_CONTACT_AT_INDEX, index));
		}
	}

	/**
	 * Select Primary Contact on Select Secondary Contact Popup
	 */
	public void selectPrimaryContactOnSecondaryContactPopup() {
		try {
			BusinessFunctions.selectValueFromListUsingIndex(driver, _selectSecondaryRadioButtons, 0);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL, MYLOConstants.FAILED_TO_SELECT_PRIMARY_CONTACT));
		}
	}

	/**
	 * Gets the selected contact details
	 * 
	 * @param field
	 * @return
	 */
	public String getSelectedSecondaryContactDetails(String field) {
		String fieldValue = "";
		try {
			switch (field) {
			case MYLOConstants.NAME:
				fieldValue = CoreFunctions.getElementText(driver, _selectedSecondaryContactName);
				break;
			case MYLOConstants.RELATIONSHIP:
				fieldValue = CoreFunctions.getElementText(driver, _selectedSecondaryContactRelationship);
				break;
			case MYLOConstants.PRONOUN:
				fieldValue = CoreFunctions.getElementText(driver, _selectedSecondaryContactPronoun);
				break;
			case MYLOConstants.PHONE_DETAILS:
				fieldValue = CoreFunctions.getAttributeText(_selectedSecondaryContactPhoneNumber, MYLOConstants.TITLE);
				break;
			case MYLOConstants.EMAIL_DETAILS:
				fieldValue = CoreFunctions.getAttributeText(_selectedSecondaryContactEmail, MYLOConstants.TITLE);
				break;
			}

		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_GET_ELEMENT_TEXT, field));
		}
		return fieldValue;
	}

	/**
	 * Select Secondary Contact on Popup and verify name on secondary contact card
	 */
	public void selectAndVerifySecondaryContact() {

		for (int i = 1; i < _secondaryContactItems.size(); i++) {
			BusinessFunctions.selectValueFromListUsingIndex(driver, _selectSecondaryRadioButtons, i);
			String secondaryContactName = CoreFunctions.getItemsFromListByIndex(driver, _selectSecondaryContactText, i,
					MYLOConstants.TRUE);
			clickButtonInSelectSecondaryContactDialog(MYLOConstants.SUBMIT_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.NAME), secondaryContactName,
					MYLOConstants.SECONDARY_CONTACT_NAME);
			clickButtonInSecondaryContactCard(MYLOConstants.REMOVE_BUTTON);
			clickSelectSecondaryContactLink();
		}
	}

	/**
	 * Get Contact Name on Popup by Index
	 * 
	 * @param index
	 * @return
	 */
	public String getContactNameOnPopUp(int index) {
		return CoreFunctions.getItemsFromListByIndex(driver, _selectSecondaryContactText, index, MYLOConstants.TRUE);
	}

	/**
	 * Verify if contact details are updated on Secondary Contact Card
	 * 
	 * @param member
	 */
	public void isSelectedSecondaryContactUpdated(String member) {

		CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.NAME),
				MYLOConstants.FIRST_NAME_TEST + " " + MYLOConstants.LAST_NAME_TEST,
				MYLOConstants.SECONDARY_CONTACT_NAME);
		CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.PRONOUN),
				MYLOConstants.PREFER_NOT_TO_ANSWER, MYLOConstants.PRONOUN);
		CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.PHONE_DETAILS),
				MYLOConstants.PHONE_NUMBER_TEST + " " + MYLOConstants.CELL_PHONE, MYLOConstants.PHONE_NUMBER);

		switch (member) {
		case (MYLOConstants.PARTNER):
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.RELATIONSHIP),
					MYLOConstants.SPOUSE, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.EMAIL_DETAILS),
					MYLOConstants.EMAIL_ADDRESS_TEST + " " + MYLOConstants.SPOUSE_PERSONAL, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.DEPENDENT):
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.RELATIONSHIP),
					MYLOConstants.CHILD, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.EMAIL_DETAILS),
					MYLOConstants.EMAIL_ADDRESS_TEST + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.OTHER):
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.RELATIONSHIP),
					MYLOConstants.OTHER_EDIT, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.EMAIL_DETAILS),
					MYLOConstants.EMAIL_ADDRESS_TEST + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		}

	}

}
