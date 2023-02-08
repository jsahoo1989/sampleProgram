package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
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

public class MyloJourneyPage_SendLoginCredentials extends Base {
	public MyloJourneyPage_SendLoginCredentials(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.XPATH, using = "//button[text()='Send Login Credentials']")
	private WebElement _sendLoginCredentialsButton;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _errorPopUp;

	@FindBy(how = How.CSS, using = "div[class='id-verification']")
	private WebElement _identityVerificationPopUp;

	@FindBy(how = How.CSS, using = "div[class='mylo-popup'] div")
	private WebElement _myloPopUp;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement _yesBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	private WebElement _cancelBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	private WebElement _noBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Submit']")
	private WebElement _submitBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Send Username and Reset Password']")
	private WebElement sendUserNamePswdBtn;

	@FindBy(how = How.CSS, using = "label[for='userEmail1']")
	private WebElement _mailID1;

	@FindBy(how = How.CSS, using = "h5[class='modal-title']")
	private WebElement _fileLinkingHeader;

	@FindBy(how = How.CSS, using = "div [class='modal-warea mt-4'] div")
	private List<WebElement> _fileLinkingDataIntegrityMessages;

	@FindBy(how = How.XPATH, using = "//button[text()='Same person, Link as a New Journey']")
	private WebElement _linkToNewJourBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Same Person, Link to Existing Journey']")
	private WebElement _linkToExistingJourBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Different Person, Do Not Link']")
	private WebElement _diffPersonDntLinkBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Remind Me Later']")
	private WebElement _remindLaterBtn;

	@FindBy(how = How.CSS, using = "label[for*='radio']")
	private WebElement _fileLinkingSimilarTransferee;

	@FindBy(how = How.CSS, using = "div[class='id-verification'] p b")
	private List<WebElement> _identityVerificationPopUpQuesAnswer;

	LinkedHashMap<String, WebElement> sendLoginCredentialWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> fileLinkingButtonWebElementsMap = new LinkedHashMap<String, WebElement>();

	public void mapSendLoginCredentialWebElementFields() {
		sendLoginCredentialWebElementsMap.put(MYLOConstants.SEND_LOGIN_CREDENTIALS, _sendLoginCredentialsButton);
		sendLoginCredentialWebElementsMap.put(MYLOConstants.YES_BUTTON, _yesBtn);
		sendLoginCredentialWebElementsMap.put(MYLOConstants.NO_BUTTON, _noBtn);
		sendLoginCredentialWebElementsMap.put(MYLOConstants.CANCEL_BUTTON, _cancelBtn);
		sendLoginCredentialWebElementsMap.put(MYLOConstants.SUBMIT_BUTTON, _submitBtn);
		sendLoginCredentialWebElementsMap.put(MYLOConstants.EMAIL1, _mailID1);
		sendLoginCredentialWebElementsMap.put(MYLOConstants.SEND_USERNAME_PSWD, sendUserNamePswdBtn);
	}

	public void clickFieldsOnSendLoginCredentialsSection(String fieldName) {
		mapSendLoginCredentialWebElementFields();
		try {
			WebElement element = sendLoginCredentialWebElementsMap.get(fieldName);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.SEND_LOGIN_CREDENTIALS));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.SEND_LOGIN_CREDENTIALS));
		}
	}

	public boolean verifyPopUpErrorMessage(String msg) {
		String actualText = CoreFunctions.getElementText(driver, _errorPopUp);
		return BusinessFunctions.verifyMyloValidationMessage(msg, actualText, MYLOConstants.SEND_LOGIN_CREDENTIALS);
	}

	public boolean verifyMyloPopUpMessage(String msg) {
		String actualText = CoreFunctions.getElementText(driver, _myloPopUp);
		return BusinessFunctions.verifyMyloValidationMessage(msg, actualText, MYLOConstants.SEND_LOGIN_CREDENTIALS);
	}

	public boolean isPopUpexist() {
		return CoreFunctions.isElementExist(driver, _myloPopUp, 5);
	}

	public boolean verifyIdentityVerificationPopUp(String question, String answer) {
		boolean flag = false;
		try {
			CoreFunctions.getElementText(driver, _identityVerificationPopUp);
			String questionValue = CoreFunctions.getElementText(driver, _identityVerificationPopUpQuesAnswer.get(0));
			String answerValue = CoreFunctions.getElementText(driver, _identityVerificationPopUpQuesAnswer.get(1));
			flag = BusinessFunctions.verifyMyloValidationMessage(question, questionValue,
					MYLOConstants.SEND_LOGIN_CREDENTIALS)
					& BusinessFunctions.verifyMyloValidationMessage(answer, answerValue,
							MYLOConstants.SEND_LOGIN_CREDENTIALS);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
							MYLOConstants.IDENTITY_CHALLENGE_QUESTION, MYLOConstants.SEND_LOGIN_CREDENTIALS));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.IDENTITY_CHALLENGE_QUESTION, MYLOConstants.SEND_LOGIN_CREDENTIALS));
		}
		return flag;
	}

	public void verifyFileLinkingSection() {
		BusinessFunctions.verifyMyloValidationMessage(MYLOConstants.FILE_LINKING_HEADER,
				CoreFunctions.getElementText(driver, _fileLinkingHeader), MYLOConstants.FILE_LINKING_POPUP);
		BusinessFunctions.verifyMyloValidationMessage(MYLOConstants.LINK_NEW_JOURNEY_MSG,
				CoreFunctions.getElementText(driver, _fileLinkingDataIntegrityMessages.get(1)),
				MYLOConstants.FILE_LINKING_POPUP);
		BusinessFunctions.verifyMyloValidationMessage(MYLOConstants.LINK_EXISTING_JOURNEY_MSG,
				CoreFunctions.getElementText(driver, _fileLinkingDataIntegrityMessages.get(2)),
				MYLOConstants.FILE_LINKING_POPUP);
		BusinessFunctions.verifyMyloValidationMessage(MYLOConstants.DECISION_FOR_LINKING_MSG,
				CoreFunctions.getElementText(driver, _fileLinkingDataIntegrityMessages.get(3)),
				MYLOConstants.FILE_LINKING_POPUP);
	}

	public void mapFileLinkingButtonWebElementFields() {
		fileLinkingButtonWebElementsMap.put(MYLOConstants.LINK_TO_EXISTING_JOURNEY, _linkToExistingJourBtn);
		fileLinkingButtonWebElementsMap.put(MYLOConstants.LINK_TO_NEW_JOURNEY, _linkToNewJourBtn);
		fileLinkingButtonWebElementsMap.put(MYLOConstants.REMIND_LATER, _remindLaterBtn);
		fileLinkingButtonWebElementsMap.put(MYLOConstants.DIFFERENT_PERSON_DONOT_LINK, _diffPersonDntLinkBtn);
	}

	public boolean verifyfileLinkingButtonsEnability(String fieldName) {
		boolean flag = false;
		try {
			mapFileLinkingButtonWebElementFields();
			flag = fileLinkingButtonWebElementsMap.get(fieldName).isEnabled();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.FILE_LINKING_POPUP));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.FILE_LINKING_POPUP));
		}
		return flag;
	}

	public void selectTransfereeInFileLinkingPopUp() {
		try {
			CoreFunctions.click(driver, _fileLinkingSimilarTransferee, MYLOConstants.TRANSFEREE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, MYLOConstants.TRANSFEREE, MYLOConstants.FILE_LINKING_POPUP));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.TRANSFEREE, MYLOConstants.FILE_LINKING_POPUP));
		}
	}
}
