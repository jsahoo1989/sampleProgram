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
import com.vimalselvam.cucumber.listener.Reporter;

public class MyloJourneyPage_SecondaryContact extends Base {

	public MyloJourneyPage_SecondaryContact(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "button[aria-controls='collapseOneContact']")
	private WebElement _expandPrimaryContactSection;

	@FindBy(how = How.XPATH, using = "//a[text()='Select Secondary Contact']")
	private WebElement _selectSecondaryContactLink;

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

	@FindBy(how = How.XPATH, using = "//div[@id='secondaryContact']//div[contains(@class,'usertitle')]")
	private WebElement _selectedSecondaryContactName;

	@FindBy(how = How.XPATH, using = "//div[@id='secondaryContact']//div[contains(@class,'userdesignation')]")
	private WebElement _selectedSecondaryContactRelationship;

	@FindBy(how = How.XPATH, using = "//app-secondary//div[contains(@class,'user-role')]//div[contains(@class,'title')]")
	private WebElement _selectedSecondaryContactPronoun;

	@FindBy(how = How.XPATH, using = "//div[@id='secondaryContact']//div[contains(@class,'userphnumber')]")
	private WebElement _selectedSecondaryContactPhoneNumber;

	@FindBy(how = How.XPATH, using = "//div[@id='secondaryContact']//div[contains(@class,'userphnumber')]/span")
	private WebElement _selectedSecondaryContactPhoneType;

	@FindBy(how = How.XPATH, using = "//div[@id='secondaryContact']//div[contains(@class,'usermailid')]")
	private WebElement _selectedSecondaryContactEmail;

	@FindBy(how = How.CSS, using = "div[class*='mylo-errorpopup']")
	private WebElement _errorDialog;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _errorDialogHeader;

	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _errorDialogOkButton;

	@FindBy(how = How.XPATH, using = "//span[text()='Change']")
	private WebElement _changeButton;

	@FindBy(how = How.XPATH, using = "//span[text()='Remove']")
	private WebElement _removeButton;

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
				CoreFunctions.verifyText(driver, _errorDialogHeader,
						MYLOConstants.SECONDARY_CONTACT_INCORRECT_SELECTION_ERROR, MYLOConstants.WARNING_POPUP);
				BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
				CoreFunctions.clickElement(driver, _errorDialogOkButton);
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
			_isExists = CoreFunctions.isElementExist(driver, _selectSecondaryContactLink, MYLOConstants.WAIT);
			if (_isExists)
				Reporter.addStepLog(
						MessageFormat.format(MYLOConstants.SELECT_SECONDARY_CONTACT_LINK, CoreConstants.PASS));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_selectSecondaryContactLink, MYLOConstants.SELECT_SECONDARY_CONTACT_LINK));
		}
		return _isExists;
	}

	/**
	 * Click Change Button on Secondary Contact Card
	 */
	public void clickChangeButton() {
		try {
			CoreFunctions.highlightElementAndClick(driver, _changeButton, MYLOConstants.CHANGE_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.CHANGE_BUTTON));
		}
	}

	/**
	 * Click Remove Button on Secondary Contact Card
	 */
	public void clickRemoveButton() {
		try {
			CoreFunctions.highlightElementAndClick(driver, _removeButton, MYLOConstants.REMOVE_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.REMOVE_BUTTON));
		}
	}

	/**
	 * Click Select Secondary Contact Card link
	 */
	public void clickSelectSecondaryContactLink() {
		try {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _selectSecondaryContactLink,
					MYLOConstants.SELECT_SECONDARY_CONTACT_LINK);
			CoreFunctions.highlightElementAndClick(driver, _selectSecondaryContactLink,
					MYLOConstants.SELECT_SECONDARY_CONTACT_LINK);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
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
	 * Get selected secondary contact name
	 * 
	 * @return
	 */
	public String getSelectedSecondaryContactName() {
		String secondaryContactName = "";
		try {
			secondaryContactName = CoreFunctions.getElementText(driver, _selectedSecondaryContactName);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_GET_ELEMENT_TEXT,
					MYLOConstants.SELECTED_SECONDARY_CONTACT_NAME));
		}
		return secondaryContactName;
	}

	/**
	 * Get selected secondary contact relation
	 * 
	 * @return
	 */
	public String getSelectedSecondaryContactRelation() {
		String secondaryContactRelation = "";
		try {
			secondaryContactRelation = CoreFunctions.getElementText(driver, _selectedSecondaryContactRelationship);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_GET_ELEMENT_TEXT,
					MYLOConstants.SELECTED_SECONDARY_CONTACT_RELATION));
		}
		return secondaryContactRelation;
	}

	/**
	 * Get selected secondary contact pronoun
	 * 
	 * @return
	 */
	public String getSelectedSecondaryContactPronoun() {
		String secondaryContactPronoun = "";
		try {
			secondaryContactPronoun = CoreFunctions.getElementText(driver, _selectedSecondaryContactPronoun);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_GET_ELEMENT_TEXT,
					MYLOConstants.SELECTED_SECONDARY_CONTACT_PRONOUN));
		}
		return secondaryContactPronoun;
	}

	/**
	 * Get selected secondary contact phone
	 * 
	 * @return
	 */
	public String getSelectedSecondaryContactPhone() {
		String secondaryContactPhone = "";
		try {
			secondaryContactPhone = CoreFunctions.getAttributeText(_selectedSecondaryContactPhoneNumber,
					MYLOConstants.TITLE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_GET_ELEMENT_TEXT,
					MYLOConstants.SELECTED_SECONDARY_CONTACT_PHONE));
		}
		return secondaryContactPhone;
	}

	/**
	 * Get selected secondary contact email
	 * 
	 * @return
	 */
	public String getSelectedSecondaryContactEmail() {
		String secondaryContactEmail = "";
		try {
			secondaryContactEmail = CoreFunctions.getAttributeText(_selectedSecondaryContactEmail, MYLOConstants.TITLE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_GET_ELEMENT_TEXT,
					MYLOConstants.SELECTED_SECONDARY_CONTACT_EMAIL));
		}
		return secondaryContactEmail;
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
			CoreFunctions.verifyText(getSelectedSecondaryContactName(), secondaryContactName,
					MYLOConstants.SECONDARY_CONTACT_NAME);
			clickRemoveButton();
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

		CoreFunctions.verifyText(getSelectedSecondaryContactName(),
				MYLOConstants.FIRST_NAME_TEST + " " + MYLOConstants.LAST_NAME_TEST,
				MYLOConstants.SECONDARY_CONTACT_NAME);
		CoreFunctions.verifyText(getSelectedSecondaryContactPronoun(), MYLOConstants.PREFER_NOT_TO_ANSWER,
				MYLOConstants.PRONOUNS);
		CoreFunctions.verifyText(getSelectedSecondaryContactPhone(),
				MYLOConstants.PHONE_NUMBER_TEST + " " + MYLOConstants.CELL_PHONE, MYLOConstants.PHONE_NUMBER);
		switch (member) {
		case (MYLOConstants.PARTNER):
			CoreFunctions.verifyText(getSelectedSecondaryContactRelation(), MYLOConstants.SPOUSE,
					MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedSecondaryContactEmail(),
					MYLOConstants.EMAIL_ADDRESS_TEST + " " + MYLOConstants.SPOUSE_PERSONAL, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.DEPENDENT):
			CoreFunctions.verifyText(getSelectedSecondaryContactRelation(), MYLOConstants.CHILD,
					MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedSecondaryContactEmail(),
					MYLOConstants.EMAIL_ADDRESS_TEST + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.OTHER):
			CoreFunctions.verifyText(getSelectedSecondaryContactRelation(), MYLOConstants.OTHER_EDIT,
					MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedSecondaryContactEmail(),
					MYLOConstants.EMAIL_ADDRESS_TEST + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		}

	}

}
