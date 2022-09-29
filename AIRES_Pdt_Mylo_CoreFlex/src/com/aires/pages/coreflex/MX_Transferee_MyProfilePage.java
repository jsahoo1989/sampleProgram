package com.aires.pages.coreflex;

import java.text.MessageFormat;
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
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.MX_Transferee_MyProfileData;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MX_Transferee_MyProfilePage extends Base {

	public MX_Transferee_MyProfilePage(WebDriver driver) {
		super(driver);
	}

	// My Profile link
	@FindBy(how = How.XPATH, using = "//a[@title='My Profile']")
	private static WebElement _linkMyProfile;

	// My Profile text
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'lpt1:cBodFDC:lr1:')]/label")
	private static WebElement _textMyProfile;

	// Personal Information
	@FindBy(how = How.XPATH, using = "//td[text()='Personal Information']")
	private static WebElement _linkPersonalInformation;

	// Manage Password
	@FindBy(how = How.XPATH, using = "//td[text()='Manage Password']")
	private static WebElement _linkManagePassword;

	// Manage Security Questions
	@FindBy(how = How.XPATH, using = "//td[text()='Manage Security Questions']")
	private static WebElement _linkManageSecurityQuestions;

	// Manage Account Information
	@FindBy(how = How.XPATH, using = "//td[text()='Manage Account Information']")
	private static WebElement _linkManageAccountInformation;

	// Credit Card Payment to Aires
	@FindBy(how = How.XPATH, using = "//td[text()='Credit Card Payment to Aires']")
	private static WebElement _linkCreditCardPaymenttoAires;

	// Year End Tax Information
	@FindBy(how = How.XPATH, using = "//td[text()='Year End Tax Information']")
	private static WebElement _linkYearEndTaxInformation;

	// Email Reminder Setup
	@FindBy(how = How.XPATH, using = "//td[text()='Email Reminder Setup']")
	private static WebElement _linkEmailReminderSetup;

	// Personal Information
	@FindBy(how = How.XPATH, using = "//label[text()='Personal Information']")
	private static WebElement _textPersonalInformation;

	// Phone
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':tranPhone::content')]")
	private static WebElement _textboxPhoneNumber;

	// Street Address 2
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':originStreetAddr2::content')]")
	private static WebElement _textBoxStreetAddressTwo;

	// Street Address 2 text
	@FindBy(how = How.XPATH, using = "//label[text()='Street Address 2 (optional)']")
	private static WebElement _textStreetAddressTwo;

	// My Moving Date
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':moveDate::content')]")
	private static WebElement _myMovingDate;

	// My Moving Date Text
	@FindBy(how = How.XPATH, using = "//label[text()='My Moving Date']")
	private static WebElement _textMyMovingDate;

	// Save Button
	@FindBy(how = How.XPATH, using = "//*[text()='Save']")
	private static WebElement _buttonSave;

	// Personal Information has been saved successfully.
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'ot4upgm')]")
	private static WebElement _textPersonalInformationSaved;

	// OK
	@FindBy(how = How.XPATH, using = "//*[contains(@id,':l24up')]")
	private static WebElement _linkOk;

	// Back to my Profile
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Back to my')]")
	private static WebElement _buttonBackToMyProfile;

	// Update and maintain your account information using this section.
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'pmot3')]")
	private static WebElement _textUpdatePassword;

	// Old Password:
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':oldPassword::content')]")
	private static WebElement _textBoxOldPassword;

	// Old Password text
	@FindBy(how = How.XPATH, using = "//label[text()='Old Password:']")
	private static WebElement _textOldPassword;

	// New Password:
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':usrPassword::content')]")
	private static WebElement _textBoxNewPassword;

	// New Password text
	@FindBy(how = How.XPATH, using = "//label[text()='New Password:']")
	private static WebElement _textNewPassword;

	// Verify New Password
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':confirmPassword::content')]")
	private static WebElement _textBoxVerifyNewPassword;

	// Verify New Password text
	@FindBy(how = How.XPATH, using = "//label[text()='Verify New Password:']")
	private static WebElement _textVerifyNewPassword;

	// Your password has been successfully changed.
	@FindBy(how = How.CLASS_NAME, using = "Green11pxBold")
	private static WebElement _textResetPasswordUpdated;

	// LogOut link
	@FindBy(how = How.XPATH, using = "//a[@title='Logout']")
	private static WebElement _linkLogOut;

	// Please set up your security questions.
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'sqhs22')]")
	private static WebElement _textSecrityQuestion;

	// Security Answer two
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':sa_row_2::content')]")
	private static WebElement _textBoxSecurityAnswerTwo;

	// Security Question two
	@FindBy(how = How.XPATH, using = "//select[contains(@name,':sq_2')]")
	private static WebElement _securityQuestionTwo;

	// Your security questions and answers have been set. dialogue box
	@FindBy(how = How.XPATH, using = "//span[contains(@id,':pgConfirm')]/span")
	private static WebElement _textSecurityAnswerSet;

	// OK button
	@FindBy(how = How.XPATH, using = "//button[contains(@id,':okButton')]")
	private static WebElement _buttonOk;

	// Add Account link
	@FindBy(how = How.XPATH, using = "//span[text()='Add Account']")
	private static WebElement _linkAddAccount;

	// Payment type Radio Button list
	@FindBy(how = How.XPATH, using = "//div[@role='radiogroup']//div//label")
	private static List<WebElement> _radioButtonListPaymentType;

	// Add Account button
	@FindBy(how = How.XPATH, using = "//button[text()='Add Account']")
	private static WebElement _buttonAddAccount;

	// Add Account Type
	@FindBy(how = How.CLASS_NAME, using = "SBServiceDetailServiceName")
	private static WebElement _textAddAccountType;

	// AccountCurrency dropdown
	@FindBy(how = How.XPATH, using = "//select[contains(@id,'accountCurrency')]")
	private static WebElement _dropdownAccountCurrency;

	// AccountCurrency text
	@FindBy(how = How.XPATH, using = "//label[text()='Account Currency:']")
	private static WebElement _textAccountCurrency;

	// Address 1:
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':AI1:mAddress1::conten')]")
	private static WebElement _textBoxAddressOne;

	// city
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':AI1:mCity::content')]")
	private static WebElement _textBoxCity;

	// State dropdown
	@FindBy(how = How.XPATH, using = "//select[contains(@id,':AI1:mStateCode::content')]")
	private static WebElement _dropdownState;

	// Zip Code
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':AI1:mZipCode::content')]")
	private static WebElement _textBoxZipCode;

	// Country dropdown
	@FindBy(how = How.XPATH, using = "//select[contains(@id,':AI1:mCountryCode::content')]")
	private static WebElement _dropdownCountry;

	// Submit button
	@FindBy(how = How.XPATH, using = "//button[text()='Submit']")
	private static WebElement _buttonSubmit;

	// No button
	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	private static WebElement _buttonNo;

	// Your account has been saved successfully. text
	@FindBy(how = How.XPATH, using = "//label[text()='Your account has been saved successfully.']")
	private static WebElement _textMessageAccountSaved;

	// Payment Type
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'pprot7')]")
	private static List<WebElement> _listPaymentType;

	// Payment Updated Date
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'pprot10')]")
	private static List<WebElement> _listPaymentUpdatedDate;

	// Delete Account
	@FindBy(how = How.XPATH, using = "//span[text()='Delete Account']")
	private static WebElement _linkDeleteAccount;

	// Delete Account OK Button
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	private static WebElement _deleteAccountOkButton;

	// Add Card
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'crdctb4')]")
	private static WebElement _linkAddCard;

	// temporarily redirected to restricted secure payment card application OK
	// button
	@FindBy(how = How.XPATH, using = "//div[contains(@id,'exitNoBtn')]/a/span")
	private static WebElement _addCardOkButton;

	// temporarily redirected to our restricted secure payment card application
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'j_idt247')]//span")
	private static WebElement _popupTextSecurePayment;

	// Credit Card Payment to Aires
	@FindBy(how = How.XPATH, using = "//td[text()='Credit Card Payment to Aires']")
	private static WebElement _textCreditCardPaymentAires;

	// Credit Card Number
	@FindBy(how = How.ID, using = "cc_num")
	private static WebElement _textBoxCreditCardNumber;

	// Credit Card Number
	@FindBy(how = How.ID, using = "ccn")
	private static WebElement _textCreditCardNumber;

	// Credit Card Details
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Credit Card Details')]")
	private static WebElement _textCreditCardDetails;

	// Billing Address for the Credit Card
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Billing Address')]")
	private static WebElement _textBillingAddress;

	// Credit Card Payment Cancel Button
	@FindBy(how = How.ID, using = "closeButton")
	private static WebElement _cancelButtonCCPayment;

	// Move Related Tax Information
	@FindBy(how = How.XPATH, using = "//*[@class='SBYearEndHeader af_outputLabel']/label")
	private static WebElement _textTaxInformation;

	// Filing Status:
	@FindBy(how = How.XPATH, using = "//label[text()='Filing Status:']//following::select[@class='af_selectOneChoice_content']")
	private static WebElement _dropdownFilingStatus;

	// Deduction Method:
	@FindBy(how = How.XPATH, using = "//select[contains(@id,':deduction2::content')]")
	private static WebElement _dropdownDeductionMethod;

	// Estimated Itemized Amount text box
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'estimateInput2::content')]")
	private static WebElement _textboxEstimatedAmount;

	// Estimated Itemized Amount
	@FindBy(how = How.XPATH, using = "//label[text()='Estimated Itemized Amount:']")
	private static WebElement _textEstimatedAmount;

	// Total Number of Dependents:
	@FindBy(how = How.XPATH, using = "//label[text()='Total Number of Dependents:']//following::select[@class='af_selectOneChoice_content']")
	private static WebElement _dropdownNumberOfDependents;

	// Your Year End Information has been successfully saved. Thank You!
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Year End Information has')]")
	private static WebElement _textYearEndInformationMessage;

	// OK button yearEndInformation popup
	@FindBy(how = How.ID, using = "d1_msgDlg_cancel")
	private static WebElement _yearEndInformationOKButton;

	// Email Reminder Preference :
	@FindBy(how = How.XPATH, using = "//label[contains(@for,':reminderPreference::content')]")
	private static WebElement _textEmailReminderPreference;

	// EmailReminderFrequency dropdown
	@FindBy(how = How.XPATH, using = "//select[contains(@id,'reminderPreference::content')]")
	private static WebElement _dropdownEmailReminderFrequency;

	// Email Reminder frequency saved successfully.
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Reminder frequency saved')]")
	private static WebElement _emailReminderFrequencySavedMessage;

	// Email Reminder frequency ok button
	@FindBy(how = How.XPATH, using = "//*[@id='d1_msgDlg_cancel']/a")
	private static WebElement _emailReminderFrequencyOKButton;

	// username
	@FindBy(how = How.XPATH, using = "//input[@name='username']")
	private static WebElement _username;

	// nextButton
	@FindBy(how = How.XPATH, using = "//*[@id='nextButton']/a")
	private static WebElement _nextButton;

	// password
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private static WebElement _password;

	// loginbutton
	@FindBy(how = How.XPATH, using = "//*[@id='loginButton']/a")
	private static WebElement _loginButton;

	@FindBy(how = How.XPATH, using = "//div[@class='zone-content']//p")
	private WebElement _toolTipText;

	@FindBy(how = How.CSS, using = "iframe.appcues-tooltip-container")
	private WebElement _tooltipIFrame;

	@FindBy(how = How.CSS, using = "a.appcues-button")
	private WebElement _tooltipIFrameNextButton;

	@FindBy(how = How.CSS, using = "small.appcues-skip")
	private WebElement _tooltipIFrameHideLink;

	/** New Account Setup **/
	/** Password Setup **/
	// Welcome to Springboard Login Setup! text
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'nupwheaderot')]")
	// @FindBy(how = How.XPATH, using = "//span[contains(@id,':s10:ot2')]")
	private static WebElement _textLoginSetup;

	// New Password:
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'itnewpassword::content')]")
	// @FindBy(how = How.XPATH, using =
	// "//input[contains(@id,':usrPassword::content')]")
	private static WebElement _textboxNewPassword;

	// Verify New Password:
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'itconfirmpassword::content')]")
	// @FindBy(how = How.XPATH, using =
	// "//input[contains(@id,':confirmPassword::content')]")
	private static WebElement _textboxVerifyNewPassword;

	// Save & Continue button
	@FindBy(how = How.XPATH, using = "//span[text()='Save & Continue']")
	private static WebElement _buttonSaveContinue;

	/** Privacy Policy **/
	// AIRES PRIVACY POLICY text
	@FindBy(how = How.XPATH, using = "//span[text()='AIRes privacy policy']")
	private static WebElement _textAiresPrivacyPolicy;

	// Privacy Policy! iframe
	@FindBy(how = How.CSS, using = "iframe.af_inlineFrame")
	private static WebElement _iframePrivacyPolicy;

	// PolicyAcceptance
	// @FindBy(how = How.CSS, using = "input.af_selectBooleanCheckbox_native-input")
	@FindBy(how = How.CSS, using = "label.p_OraHiddenLabel")
	private static WebElement _checkBoxPolicyAcceptance;

	// AcceptPrivacyPolicy button
	@FindBy(how = How.XPATH, using = "//span[text()='Continue']")
	private static WebElement _buttonContinue;

	/*** Manage Security Question **/

	// Please answer a few security questions
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'nusqheaderot')]")
	private static WebElement _textFewSecurityQuestions;

	// Security Answer One
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'secqitr:0:itanswer::content')]")
	private static WebElement _textBoxSecurityAnswerOneNewUser;

	// Security Question One
	@FindBy(how = How.XPATH, using = "//select[contains(@name,'secqitr:0:socquestions')]")
	private static WebElement _securityQuestionOneNewUser;

	// Security Answer two
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'secqitr:1:itanswer::content')]")
	private static WebElement _textBoxSecurityAnswerTwoNewUser;

	// Security Question two
	@FindBy(how = How.XPATH, using = "//select[contains(@name,'secqitr:1:socquestions')]")
	private static WebElement _securityQuestionTwoNewUser;

	// Security Answer three
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'secqitr:2:itanswer::content')]")
	private static WebElement _textBoxSecurityAnswerThreeNewUser;

	// Security Question three
	@FindBy(how = How.XPATH, using = "//select[contains(@name,'secqitr:2:socquestions')]")
	private static WebElement _securityQuestionThreeNewUser;

	/** My Profile **/
	// textMyProfile
	@FindBy(how = How.XPATH, using = "//label[text()='My Profile']")
	private static WebElement _textMyProfileModule;

	// nextbutton
	@FindBy(how = How.XPATH, using = "//span[text()='Next']")
	private static WebElement _buttonNext;

	// Update profile picture link
	@FindBy(how = How.XPATH, using = "//a[contains(@id,'gL2')]")
	private static WebElement _linkUpdateProfilePicture;

	// Upload my image text
	@FindBy(how = How.XPATH, using = "//span[text()='Upload my image']")
	private static WebElement _popupTextUploadMyImage;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'uploadComp::content')]")
	private static WebElement _uploadFileLink;

	// button upload
	@FindBy(how = How.XPATH, using = "//button[text()='Upload']")
	private static WebElement _buttonUpload;

	// Delete profile picture icon
	@FindBy(how = How.XPATH, using = "//a[@title='Delete profile picture']")
	private static WebElement _iconDeleteProfilePicture;

	/*** My Services ***/

	// My Services text
	@FindBy(how = How.XPATH, using = "//label[text()='My Services']")
	private static WebElement _textMyServices;

	// HOUSING services
	@FindBy(how = How.XPATH, using = "//label[text()='HOUSING']")
	private static WebElement _textHousing;

	@FindBy(how = How.XPATH, using = "//label[text()='MOVING']")
	private static WebElement _textMoving;

	@FindBy(how = How.XPATH, using = "//label[text()='SETTLING IN']")
	private static WebElement _textSettlingIn;

	// Services checkboxlist
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'servicesUnselect::text')]")
	private static List<WebElement> _checkboxListServices;

	// Great! Please gather my quotes checkbox
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'serviceNameTop1')]/label")
	private static WebElement _checkboxGatherQuotes;

	// What is your preferred method of contact?
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'unMarkcontactEmail::text')]")
	private static WebElement _checkboxEmail;

	/** Additional Info **/
	// We have a few more questions for you. text
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'few more questions')]")
	private static WebElement _textFewMoreQuestion;

	@FindBy(how = How.XPATH, using = "//label[text()='Additional Info']")
	private static WebElement _textAdditionalInfoModule;

	// Selling My Current Home: Home Sale Estimate price
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'homeSalePriceEstimate::content')]")
	private static WebElement _textboxHomeSaleEstimate;

	@FindBy(how = How.XPATH, using = "//label[contains(@for,'homeSalePriceEstimate::content')]")
	private static WebElement _textHomeSaleEstimate;

	// Service: Selected Service Name List
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'hsLabel')]/label")
	private static List<WebElement> _textSelectedServiceList;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'sdi1::disAcr')]")
	private static WebElement _expandArrowHousing;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'sdi2::disAcr')]")
	private static WebElement _expandArrowMoving;

	// Shipping My Car(s): Number of car(s) (Required)
	@FindBy(how = How.XPATH, using = "//input[contains(@id,':sbAutoShipA1::content')]")
	private static WebElement _textboxNumberOfCarRequired;

	@FindBy(how = How.XPATH, using = "//label[contains(@for,':sbAutoShipA1::content')]")
	private static WebElement _textNumberOfCarRequired;

	// Rental Days (Required)
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'autoRentalValue::content')]")
	private static WebElement _textboxRentalDaysRequired;

	@FindBy(how = How.XPATH, using = "//label[contains(@for,'autoRentalValue::content')]")
	private static WebElement _textRentalDaysRequired;

	// zip code
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'destZipCodeText::content')]")
	private static WebElement _textboxZipCodeAddInfo;

	// Springboard relocation address
	@FindBy(how = How.ID, using = "lpt1:bBarFDC:ot5")
	private static WebElement _springBoardUserAddress;

	/** My Budget **/
	// text My Budget
	@FindBy(how = How.XPATH, using = "//label[text()='My Budget']")
	private static WebElement _textMyBudgetModule;

	// Change Currency link
	@FindBy(how = How.XPATH, using = "//span[text()='Change Currency']")
	private static WebElement _linkChangeCurrency;

	// Total to spend
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'ol7')]")
	private static WebElement _totalToSpendAmount;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'sMap:0:houList:0:serviceBudgetAmount')]")
	private static WebElement _textboxHousingBudgetAmount;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'sMap:1:houList:0:serviceBudgetAmount')]")
	private static WebElement _textboxMovingBudgetAmount;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'sMap:2:houList:0:serviceBudgetAmount')]")
	private static WebElement _textboxSettlingInBudgetAmount;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'houList:0:ol10')]/label")
	private static List<WebElement> _selectedServiceListOnMyBudget;

	/** My Account Information **/
	@FindBy(how = How.XPATH, using = "//label[text()='My Account Information']")
	private static WebElement _textMyAccountInformationModule;

	@FindBy(how = How.CSS, using = "label.af_selectOneRadio_item-text")
	private static WebElement _radioButtonLumpSumPayement;

	// text Account Details
	@FindBy(how = How.XPATH, using = "//h1[text()='Account Details']")
	private static WebElement _textAccountDetails;

	// Payment Type
	@FindBy(how = How.XPATH, using = "//label[text()='Payment Type:']")
	private static WebElement _textPaymentType;

	@FindBy(how = How.CSS, using = "label.af_selectOneRadio_item-text")
	private static List<WebElement> _radioButtonPaymentTypeList;

	// Exact Account Holder's Name on Bank Account
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'itaifo::content')]")
	private static WebElement _textBoxAccountHolderNameACHAccount;

	@FindBy(how = How.XPATH, using = "//label[contains(@for,'itaifo::content')]")
	private static WebElement _textAccountHolderNameACHAccount;

	// Account Type
	@FindBy(how = How.XPATH, using = "//select[contains(@id,'soc1::content')]")
	private static WebElement _dropdownAccountTypeACHAccount;

	// Bank Name
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'BI1:bankName1::content')]")
	private static WebElement _textBoxBankNameACHAccount;

	@FindBy(how = How.XPATH, using = "//label[contains(@for,':BI1:bankName1::content')]")
	private static WebElement _textBankNameACHAccount;

	// Address 1
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'BI1:bankAddress1::content')]")
	private static WebElement _textBoxAddressOneACHAccount;

	// city
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'BI1:city::content')]")
	private static WebElement _textBoxCityACHAccount;

	// state
	@FindBy(how = How.XPATH, using = "//select[contains(@id,'BI1:bStateCode::content')]")
	private static WebElement _dropdownStateACHAccount;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'BI1:bZipCode::content')]")
	private static WebElement _textBoxZipCodeACHAccount;

	@FindBy(how = How.XPATH, using = "//select[contains(@id,'BI1:bbCountry::content')]")
	private static WebElement _dropdownCountryACHAccount;

	// SWIFT/Routing
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'BI1:bbSwiftSortRouting::content')]")
	private static WebElement _textBoxSwiftRoutingACHAccount;

	@FindBy(how = How.XPATH, using = "	//label[contains(@for,'BI1:bbSwiftSortRouting::content')]")
	private static WebElement _textSwiftRoutingACHAccount;

	// Account/IBAN #:
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'BI1:bbAccountIbanNumber::content')]")
	private static WebElement _textBoxAccountIbanNumberACHAccount;

	@FindBy(how = How.XPATH, using = "//label[contains(@for,'BI1:bbAccountIbanNumber::content')]")
	private static WebElement _textAccountIbanNumberACHAccount;

	// Setup is complete text on Springobard
	@FindBy(how = How.XPATH, using = "//span[text()='Setup is complete!']")
	private static WebElement _textSetupIsComplete;

	@FindBy(how = How.CSS, using = "a.SBWhiteCheckLink")
	private static WebElement _buttonCheck;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'firstNameText::content')]")
	private static WebElement _textFirstName;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'lastNameText::content')]")
	private static WebElement _textLastName;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'destCityText::content')]")
	private static WebElement _textDestinationAddress;

	@FindBy(how = How.CLASS_NAME, using = "growl-xsmall-message")
	private static WebElement _textInvalidCredential;
	
	@FindBy(how = How.CSS, using = "label.af_selectOneRadio_item-text")
	private static WebElement _radioButtonLumpSumPayementByLocator;
	
	final By _textSetupIsCompleteByLocator = By.xpath("//span[text()='Setup is complete!']");
	//final By _radioButtonLumpSumPayementByLocator = By.cssSelector("label.af_selectOneRadio_item-text");
	final By _iframePrivacyPolicyByLocator = By.cssSelector("iframe.af_inlineFrame");
	final By _textLoginSetupByLocator = By.xpath("//span[contains(@id,'nupwheaderot')]");
	final By _textMyProfileByLocator = By.xpath("//*[contains(@id,'lpt1:cBodFDC:lr1:')]/label");
	final By _enterDifferentPasswordErrorMessageByLocator = By.className("ErrorMessage");
	final By _invalidCredentialErrorMessageByLocator = By.className("growl-xsmall-message");
	final By _txtSignInByLocator = By.xpath("//span[text()='Sign in']");
	final By _tooltipIFrameByLocator = By.cssSelector("iframe.appcues-tooltip-container");
	final By _deleteAccountOkButtonByLocator = By.xpath("//button[text()='OK']");
	final By _accountSavedMessageByLocator = By.xpath("//span[contains(@id,'pprol2')]/label");
	final By _buttonBackToMyProfileByLocator = By.xpath("//span[contains(text(),'Back to my')]");
	final By _textYearEndInformationByLocator = By.xpath("//div[contains(text(),'Year End Information has')]");
	final By _emailReminderFrequencySavedMessageByLocator = By
			.xpath("//div[contains(text(),'Reminder frequency saved')]");
	final By _popupTextSecurePaymentByLocator = By.xpath("//span[contains(text(),'transmitting and storing credit')]");

	/******************************************************************************************/
	
	MX_Transferee_MyProfileData mxTransfereeMyProfileData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMyProfileDataDataByUserFirstName(MobilityXConstants.USER_FIRST_NAME);
	
	/******************************************************************************************/
	private String _uploadFilePath = System.getProperty(MobilityXConstants.USER_DIR) + MobilityXConstants.FILE_PATH;;

	String phoneNumber, streetAddressTwo, movingDate, oldPassword, newPassword, securityAnswerTwo, zipCode;
	boolean isPersonalInformationVerified, isManagePasswordVerified, isManageSecurityVerified, isManageAccountVerified,
			isCreditCardVerified, isTaxInformationVerified, isEmailReminderVerified;
	String fullName, address;
	MobilityX_LoginPage loginPage;

	public boolean isInvalidCredentialMeesageDisplayed(String message) {
		if (CoreFunctions.isElementByLocatorExist(driver, _invalidCredentialErrorMessageByLocator, MobilityXConstants.CUSTOM_TIME)
				&& _textInvalidCredential.getText().contains(message)) {
			return true;
		}
		return false;
	}

	public void clicksOnMyProfileButton() {
		CoreFunctions.click(driver, _linkMyProfile,
				CoreFunctions.getAttributeText(_linkMyProfile, MobilityXConstants.TITLE));
		if (CoreFunctions.isElementByLocatorExist(driver, _textMyProfileByLocator, MobilityXConstants.CUSTOM_TIME))
			CoreFunctions.highlightObject(driver, _textMyProfile);
	}

	public boolean editAndVerifyInformationOnTiles(DataTable table) {
		List<String> dataList = table.asList(String.class);
		for (String data : dataList) {
			switch (data) {
			case MobilityXConstants.PERSONAL_INFORMATION:
				editPersonalInformationTile();
				isPersonalInformationVerified = verifyPersonalInformationTile();
				CoreFunctions.writeMessageToReport(isPersonalInformationVerified,
						MobilityXConstants.VERIFIED_TILE_ON_MYPROFILE, MobilityXConstants.FAILED_TO_VERIFY_TILE_ON_MYPROFILE,
						MobilityXConstants.PERSONAL_INFORMATION);
				clickOnBackToMyProfileLink();
				break;
			case MobilityXConstants.MANAGE_PASSWORD:
				editManagePasswordTile();
				isManagePasswordVerified = verifyManagePasswordTile();
				CoreFunctions.writeMessageToReport(isManagePasswordVerified, MobilityXConstants.VERIFIED_TILE_ON_MYPROFILE,
						MobilityXConstants.FAILED_TO_VERIFY_TILE_ON_MYPROFILE, MobilityXConstants.MANAGE_PASSWORD);
				break;
			case MobilityXConstants.MANAGE_SECURITY_QUESTION:
				editManageSecurityQuestionsTile();
				isManageSecurityVerified = verifyManageSecurityQuestionsTile();
				CoreFunctions.writeMessageToReport(isManageSecurityVerified, MobilityXConstants.VERIFIED_TILE_ON_MYPROFILE,
						MobilityXConstants.FAILED_TO_VERIFY_TILE_ON_MYPROFILE, MobilityXConstants.MANAGE_SECURITY_QUESTION);
				clickOnBackToMyProfileLink();
				break;
			case MobilityXConstants.MANAGE_ACCOUNT_INFORMATION:
				editManageAccountInformationTile();
				isManageAccountVerified = verifyManageAccountInformationTile();
				CoreFunctions.writeMessageToReport(isManageAccountVerified, MobilityXConstants.VERIFIED_TILE_ON_MYPROFILE,
						MobilityXConstants.FAILED_TO_VERIFY_TILE_ON_MYPROFILE, MobilityXConstants.MANAGE_ACCOUNT_INFORMATION);
				CoreFunctions.waitHandler(4);
				clickOnBackToMyProfileLink();
				break;
			case MobilityXConstants.CREDIT_CARD_PAYMENT_TO_AIRES:
				editCreditCardPaymentToAiresTile();
				isCreditCardVerified = verifyCreditCardPaymentToAiresTile();
				CoreFunctions.writeMessageToReport(isCreditCardVerified, MobilityXConstants.VERIFIED_TILE_ON_MYPROFILE,
						MobilityXConstants.FAILED_TO_VERIFY_TILE_ON_MYPROFILE, MobilityXConstants.CREDIT_CARD_PAYMENT_TO_AIRES);
				clickOnBackToMyProfileLink();
				break;
			case MobilityXConstants.YEAR_END_TAX_INFORMATION:
				editYearEndTaxInformationTiles();
				clickOnBackToMyProfileLink();
				isTaxInformationVerified = verifyYearEndTaxInformationTiles();
				CoreFunctions.writeMessageToReport(isTaxInformationVerified, MobilityXConstants.VERIFIED_TILE_ON_MYPROFILE,
						MobilityXConstants.FAILED_TO_VERIFY_TILE_ON_MYPROFILE, MobilityXConstants.YEAR_END_TAX_INFORMATION);
				clickOnBackToMyProfileLink();
				break;
			case MobilityXConstants.EMAIL_REMAINDER_SETUP:
				editEmailReminderSetupTiles();
				clickOnBackToMyProfileLink();
				isEmailReminderVerified = verifyEmailReminderSetupTiles();
				CoreFunctions.writeMessageToReport(isEmailReminderVerified, MobilityXConstants.VERIFIED_TILE_ON_MYPROFILE,
						MobilityXConstants.FAILED_TO_VERIFY_TILE_ON_MYPROFILE, MobilityXConstants.EMAIL_REMAINDER_SETUP);
				clickOnBackToMyProfileLink();
				break;
			default:
				Assert.fail(MobilityXConstants.NO_ELEMENT_FOUND);
				break;
			}
		}
		return isPersonalInformationVerified && isManagePasswordVerified && isManageSecurityVerified
				&& isManageAccountVerified && isCreditCardVerified && isTaxInformationVerified
				&& isEmailReminderVerified ? true : false;
	}

	public void editPersonalInformationTile() {
		CoreFunctions.click(driver, _linkPersonalInformation, _linkPersonalInformation.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textPersonalInformation,
				_textPersonalInformation.getText());
		phoneNumber = CoreFunctions.generateRandomNumberAsGivenLength(10);
		CoreFunctions.clearAndSetText(driver, _textboxPhoneNumber, MobilityXConstants.TEXT_PHONE_NUMBER, phoneNumber);
		streetAddressTwo = mxTransfereeMyProfileData.streetAddressTwo + MobilityXConstants.BLANK_SPACE
				+ CoreFunctions.generateRandomNumberAsGivenLength(3);
		CoreFunctions.clearAndSetText(driver, _textBoxStreetAddressTwo, _textStreetAddressTwo.getText(),
				streetAddressTwo);
		movingDate = CoreFunctions.addDaysInCurrentDate(MobilityXConstants.DATE_FORMAT_ddMMMyyyy, 45);
		CoreFunctions.clearAndSetText(driver, _myMovingDate, _textMyMovingDate.getText(), movingDate);
		CoreFunctions.click(driver, _buttonSave, _buttonSave.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textPersonalInformationSaved,
				_textPersonalInformationSaved.getText());
		CoreFunctions.click(driver, _linkOk, MobilityXConstants.BUTTON_OK);
	}

	public boolean verifyPersonalInformationTile() {
		CoreFunctions.click(driver, _linkPersonalInformation, _linkPersonalInformation.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textPersonalInformation,
				_textPersonalInformation.getText());
		return CoreFunctions.getAttributeText(_textboxPhoneNumber, MobilityXConstants.VALUE).contains(phoneNumber)
				&& CoreFunctions.getAttributeText(_textBoxStreetAddressTwo, MobilityXConstants.VALUE)
						.contains(streetAddressTwo)
				&& CoreFunctions.getAttributeText(_myMovingDate, MobilityXConstants.VALUE).contains(movingDate);
	}

	public void editManagePasswordTile() {
		CoreFunctions.click(driver, _linkManagePassword, _linkManagePassword.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textUpdatePassword, _textUpdatePassword.getText());
		oldPassword = mxTransfereeMyProfileData.password1;
		newPassword = mxTransfereeMyProfileData.password2;
		enterPasswordAndClickOnSaveButton(oldPassword, newPassword);
		if (CoreFunctions.isElementByLocatorExist(driver, _enterDifferentPasswordErrorMessageByLocator, MobilityXConstants.CUSTOM_TIME)) {
			oldPassword = mxTransfereeMyProfileData.password2;
			newPassword = mxTransfereeMyProfileData.password1;
			enterPasswordAndClickOnSaveButton(oldPassword, newPassword);
		} else {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _textResetPasswordUpdated,
					_textResetPasswordUpdated.getText());
			CoreFunctions.highlightObject(driver, _textResetPasswordUpdated);
		}
	}

	public void enterPasswordAndClickOnSaveButton(String oldPassword, String newPassword) {
		CoreFunctions.clearAndSetText(driver, _textBoxOldPassword, _textOldPassword.getText(), oldPassword);
		CoreFunctions.clearAndSetText(driver, _textBoxNewPassword, _textNewPassword.getText(), newPassword);
		CoreFunctions.clearAndSetText(driver, _textBoxVerifyNewPassword, _textVerifyNewPassword.getText(), newPassword);
		CoreFunctions.click(driver, _buttonSave, _buttonSave.getText());
	}

	public boolean verifyManagePasswordTile() {
		CoreFunctions.click(driver, _linkLogOut, CoreFunctions.getAttributeText(_linkLogOut, MobilityXConstants.TITLE));
		CoreFunctions.waitForBrowserToLoad(driver);
		loginSpringboardApplication(mxTransfereeMyProfileData.springboardMyProfileUser, newPassword);
		clicksOnMyProfileButton();
		return CoreFunctions.isElementVisible(_linkManagePassword);
	}

	public void editManageSecurityQuestionsTile() {
		CoreFunctions.click(driver, _linkManageSecurityQuestions, _linkManageSecurityQuestions.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textSecrityQuestion, _textSecrityQuestion.getText());
		securityAnswerTwo = mxTransfereeMyProfileData.securityAnswerTwo
				+ CoreFunctions.generateRandomNumberAsGivenLength(2);
		CoreFunctions.clearAndSetText(driver, _textBoxSecurityAnswerTwo,
				CoreFunctions.getAttributeText(_securityQuestionTwo, MobilityXConstants.TITLE), securityAnswerTwo);
		CoreFunctions.click(driver, _buttonSave, _buttonSave.getText());
		CoreFunctions.click(driver, _buttonOk, MobilityXConstants.BUTTON_OK);
	}

	public boolean verifyManageSecurityQuestionsTile() {
		CoreFunctions.click(driver, _linkManageSecurityQuestions, _linkManageSecurityQuestions.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textSecrityQuestion, _textSecrityQuestion.getText());
		return CoreFunctions.getAttributeText(_textBoxSecurityAnswerTwo, MobilityXConstants.VALUE)
				.contains(securityAnswerTwo);
	}

	public void editManageAccountInformationTile() {
		CoreFunctions.click(driver, _linkManageAccountInformation, _linkManageAccountInformation.getText());
		CoreFunctions.click(driver, _linkAddAccount, _linkAddAccount.getText());
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _radioButtonListPaymentType);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioButtonListPaymentType,
				mxTransfereeMyProfileData.paymentType);
		CoreFunctions.click(driver, _buttonAddAccount, _buttonAddAccount.getText());
		BusinessFunctions.selectValueFromDropdown(driver,_dropdownAccountCurrency, mxTransfereeMyProfileData.accountCurrency);
		CoreFunctions.clearAndSetText(driver, _textBoxAddressOne, MobilityXConstants.ADDRESS,
				mxTransfereeMyProfileData.addressOne);
		CoreFunctions.clearAndSetText(driver, _textBoxCity, MobilityXConstants.CITY, mxTransfereeMyProfileData.city);
		BusinessFunctions.selectValueFromDropdown(driver,_dropdownState, mxTransfereeMyProfileData.state);
		zipCode = CoreFunctions.generateRandomNumberAsGivenLength(5);
		CoreFunctions.clearAndSetText(driver, _textBoxZipCode, MobilityXConstants.ZIPCODE, zipCode);
		BusinessFunctions.selectValueFromDropdown(driver,_dropdownCountry, mxTransfereeMyProfileData.country);
		CoreFunctions.click(driver, _buttonSubmit, _buttonSubmit.getText());
		CoreFunctions.click(driver, _buttonNo, _buttonNo.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textMessageAccountSaved,
				_textMessageAccountSaved.getText());
	}

	public boolean verifyManageAccountInformationTile() {
		for (int i = 0; i <= _listPaymentType.size(); i++) {
			if (_listPaymentType.get(i).getText().equalsIgnoreCase(mxTransfereeMyProfileData.paymentType)
					&& _listPaymentUpdatedDate.get(i).getText()
							.contains(CoreFunctions.getCurrentDateAsGivenFormat(MobilityXConstants.DATE_FORMAT_ddMMMyyyy))) {
				CoreFunctions.highlightObject(driver, _listPaymentType.get(i));
				CoreFunctions.click(driver, _listPaymentType.get(i), _listPaymentType.get(i).getText());
				CoreFunctions.click(driver, _linkDeleteAccount, _linkDeleteAccount.getText());
				CoreFunctions.isElementByLocatorExist(driver, _deleteAccountOkButtonByLocator, MobilityXConstants.CUSTOM_TIME);
				CoreFunctions.click(driver, _deleteAccountOkButton, _deleteAccountOkButton.getText());
				CoreFunctions.isElementByLocatorExist(driver, _accountSavedMessageByLocator, MobilityXConstants.CUSTOM_TIME);
				return true;
			}
		}
		return false;
	}

	public void editCreditCardPaymentToAiresTile() {
		CoreFunctions.click(driver, _linkCreditCardPaymenttoAires, _linkCreditCardPaymenttoAires.getText());
		CoreFunctions.click(driver, _linkAddCard, _linkAddCard.getText());
		if (CoreFunctions.isElementByLocatorExist(driver, _popupTextSecurePaymentByLocator, MobilityXConstants.CUSTOM_TIME)) {
//			CoreFunctions.explctWaitTillElementVisibility(driver, _popupTextSecurePayment,
//					_popupTextSecurePayment.getText());
			CoreFunctions.click(driver, _addCardOkButton, _addCardOkButton.getText());
			CoreFunctions.explicitWaitTillElementVisibility(driver, _textCreditCardPaymentAires,
					_textCreditCardPaymentAires.getText());
		}

	}

	public boolean verifyCreditCardPaymentToAiresTile() {
		boolean isElementDisplayed = false;
		isElementDisplayed = CoreFunctions.isElementVisible(_textBoxCreditCardNumber);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textCreditCardDetails, _textCreditCardDetails.getText());
		CoreFunctions.highlightObject(driver, _textCreditCardDetails);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textBillingAddress, _textBillingAddress.getText());
		CoreFunctions.highlightObject(driver, _textBillingAddress);

		CoreFunctions.clickUsingJS(driver, _cancelButtonCCPayment,
				CoreFunctions.getAttributeText(_cancelButtonCCPayment, MobilityXConstants.VALUE));
		CoreFunctions.explicitWaitTillElementVisibility(driver, _linkAddCard, _linkAddCard.getText());
		CoreFunctions.waitHandler(3);
		return isElementDisplayed;
	}

	public void editYearEndTaxInformationTiles() {
		CoreFunctions.click(driver, _linkYearEndTaxInformation, _linkYearEndTaxInformation.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textTaxInformation, _textTaxInformation.getText());
		BusinessFunctions.selectValueFromDropdown(driver,_dropdownFilingStatus, mxTransfereeMyProfileData.filingStatus);
		BusinessFunctions.selectValueFromDropdown(driver,_dropdownDeductionMethod, mxTransfereeMyProfileData.deductionMethod);
		CoreFunctions.clearAndSetText(driver, _textboxEstimatedAmount, _textEstimatedAmount.getText(),
				CoreFunctions.generateRandomNumberAsGivenLength(5));
		BusinessFunctions.selectValueFromDropdown(driver,_dropdownNumberOfDependents,
				mxTransfereeMyProfileData.numberOfDependents);
		CoreFunctions.click(driver, _buttonSave, _buttonSave.getText());
		if (CoreFunctions.isElementByLocatorExist(driver, _textYearEndInformationByLocator, MobilityXConstants.CUSTOM_TIME)) {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _textYearEndInformationMessage,
					_textYearEndInformationMessage.getText());
			CoreFunctions.click(driver, _yearEndInformationOKButton, MobilityXConstants.BUTTON_OK);
		}
	}

	public boolean verifyYearEndTaxInformationTiles() {
		CoreFunctions.click(driver, _linkYearEndTaxInformation, _linkYearEndTaxInformation.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textTaxInformation, _textTaxInformation.getText());
		return CoreFunctions.getAttributeText(_dropdownFilingStatus, MobilityXConstants.TITLE)
				.contains(mxTransfereeMyProfileData.filingStatus)
				&& CoreFunctions.getAttributeText(_dropdownDeductionMethod, MobilityXConstants.TITLE)
						.contains(mxTransfereeMyProfileData.deductionMethod)
				&& CoreFunctions.getAttributeText(_dropdownNumberOfDependents, MobilityXConstants.TITLE)
						.contains(mxTransfereeMyProfileData.numberOfDependents);
	}

	public void editEmailReminderSetupTiles() {
		CoreFunctions.click(driver, _linkEmailReminderSetup, _linkEmailReminderSetup.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textEmailReminderPreference,
				_textEmailReminderPreference.getText());
		BusinessFunctions.selectValueFromDropdown(driver,_dropdownEmailReminderFrequency,
				mxTransfereeMyProfileData.emailReminderFrequency);
		CoreFunctions.click(driver, _buttonSave, _buttonSave.getText());
		if (CoreFunctions.isElementByLocatorExist(driver, _emailReminderFrequencySavedMessageByLocator, MobilityXConstants.CUSTOM_TIME)) {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _emailReminderFrequencySavedMessage,
					_emailReminderFrequencySavedMessage.getText());
			CoreFunctions.click(driver, _emailReminderFrequencyOKButton, MobilityXConstants.BUTTON_OK);
		}
	}

	public boolean verifyEmailReminderSetupTiles() {
		CoreFunctions.click(driver, _linkEmailReminderSetup, _linkEmailReminderSetup.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textEmailReminderPreference,
				_textEmailReminderPreference.getText());
		return CoreFunctions.getAttributeText(_dropdownEmailReminderFrequency, MobilityXConstants.TITLE)
				.contains(mxTransfereeMyProfileData.emailReminderFrequency);
	}

	public void clickOnBackToMyProfileLink() {
		// if (CoreFunctions.isElementByLocatorExist(driver,
		// _buttonBackToMyProfileByLocator, MobilityXConstants.CUSTOM_TIME)) {
		CoreFunctions.click(driver, _buttonBackToMyProfile, _buttonBackToMyProfile.getText());
		CoreFunctions.isElementByLocatorExist(driver, _textMyProfileByLocator, MobilityXConstants.CUSTOM_TIME);
	}

	public void switchToTooltipIFrameAndPerformAction(String action, int time) {
		CoreFunctions.waitHandler(3);
		if (CoreFunctions.isElementByLocatorExist(driver, _tooltipIFrameByLocator, time)) {
			driver.switchTo().frame(_tooltipIFrame);
			switch (action) {
			case MobilityXConstants.NEXT:
				CoreFunctions.click(driver, _tooltipIFrameNextButton, _tooltipIFrameNextButton.getText());
				break;
			case MobilityXConstants.HIDE:
				CoreFunctions.click(driver, _tooltipIFrameHideLink, _tooltipIFrameHideLink.getText());
				break;
			default:
				Assert.fail(MobilityXConstants.NO_ELEMENT_FOUND);
				break;
			}
			driver.switchTo().defaultContent();
		}
	}

	public void loginSpringboardApplication(String username, String password) {
		if (CoreFunctions.isElementByLocatorExist(driver, _txtSignInByLocator, MobilityXConstants.CUSTOM_TIME)) {
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _username, MobilityXConstants.USER_NAME);
			CoreFunctions.clearAndSetText(driver, _username, username);
			CoreFunctions.clickUsingJS(driver, _nextButton, MobilityXConstants.NEXT);
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _password, MobilityXConstants.PASSWORD);
			CoreFunctions.clearAndSetText(driver, _password, password);
			CoreFunctions.clickUsingJS(driver, _loginButton, MobilityXConstants.SIGNIN_BTN);
			switchToTooltipIFrameAndPerformAction(MobilityXConstants.HIDE, 60);
		}
	}

	public String[] setupNewSpringboardTransfere() {
		loginPasswaordSetup();
		CoreFunctions.waitHandler(2);
		privacyPolicySetup();
		CoreFunctions.waitHandler(2);
		manageSecurityQuestionsSetup();
		CoreFunctions.waitHandler(2);
		myProfileModuleSetup();
		CoreFunctions.waitHandler(2);
		myServicesModuleSetup();
		CoreFunctions.waitHandler(2);
		additionalInfoModuleSetup();
		CoreFunctions.waitHandler(2);
		myBudgetModuleSetup();
		CoreFunctions.waitHandler(2);
		myAccountInformationModuleSetup();
		CoreFunctions.waitHandler(5);
		String transfereeDetails[] = { fullName, address };
		CoreFunctions.writeToPropertiesFile("Transferee_SprintBoardUser_FullName", fullName);
		return transfereeDetails;
	}
	
	public void setUpNewMobilityXTransferee() {
		loginPasswaordSetup();
		CoreFunctions.waitHandler(2);
		privacyPolicySetup();
		CoreFunctions.waitHandler(2);
		manageSecurityQuestionsSetup();
		CoreFunctions.waitHandler(2);
	}

	public void loginPasswaordSetup() {
		if (CoreFunctions.isElementByLocatorExist(driver, _textLoginSetupByLocator, 10)) {
			CoreFunctions.highlightObject(driver, _textLoginSetup);
			CoreFunctions.clearAndSetText(driver, _textboxNewPassword, mxTransfereeMyProfileData.password1);
			CoreFunctions.clearAndSetText(driver, _textboxVerifyNewPassword, mxTransfereeMyProfileData.password1);
			CoreFunctions.waitHandler(2);
			CoreFunctions.click(driver, _buttonSaveContinue, _buttonSaveContinue.getText());
			CoreFunctions.writeToPropertiesFile("Transferee_PasswordInEMail", mxTransfereeMyProfileData.password1);
			CoreFunctions.waitHandler(4);
		}
		if (CoreFunctions.isElementByLocatorExist(driver, _textLoginSetupByLocator, 10)) {
			CoreFunctions.clearAndSetText(driver, _textboxNewPassword, mxTransfereeMyProfileData.password1);
			CoreFunctions.clearAndSetText(driver, _textboxVerifyNewPassword, mxTransfereeMyProfileData.password1);
			CoreFunctions.click(driver, _buttonSaveContinue, _buttonSaveContinue.getText());
			CoreFunctions.writeToPropertiesFile("Transferee_PasswordInEMail", mxTransfereeMyProfileData.password1);
		}
	}

	public void privacyPolicySetup() {
		if (CoreFunctions.isElementByLocatorExist(driver, _iframePrivacyPolicyByLocator, 10)) {
			driver.switchTo().frame(_iframePrivacyPolicy);
			CoreFunctions.highlightObject(driver, _textAiresPrivacyPolicy);
			driver.switchTo().defaultContent();
			CoreFunctions.checkCheckBox(driver, _checkBoxPolicyAcceptance, _checkBoxPolicyAcceptance.getText());
			CoreFunctions.click(driver, _buttonContinue, _buttonContinue.getText());
		}
	}

	public void manageSecurityQuestionsSetup() {
		CoreFunctions.waitHandler(3);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textFewSecurityQuestions,
				_textFewSecurityQuestions.getText());
		BusinessFunctions.selectValueFromDropdown(driver,_securityQuestionOneNewUser,
				mxTransfereeMyProfileData.securityQuestionOne);
		CoreFunctions.waitHandler(3);
		CoreFunctions.clearAndSetText(driver, _textBoxSecurityAnswerOneNewUser,
				CoreFunctions.getAttributeText(_securityQuestionOneNewUser, MobilityXConstants.TITLE),
				mxTransfereeMyProfileData.securityAnswerTwo);
		CoreFunctions.waitHandler(3);
		BusinessFunctions.selectValueFromDropdown(driver,_securityQuestionTwoNewUser,
				mxTransfereeMyProfileData.securityQuestionTwo);
		CoreFunctions.waitHandler(3);
		CoreFunctions.clearAndSetText(driver, _textBoxSecurityAnswerTwoNewUser,
				CoreFunctions.getAttributeText(_securityQuestionTwoNewUser, MobilityXConstants.TITLE),
				mxTransfereeMyProfileData.securityAnswerTwo);
		CoreFunctions.waitHandler(3);
		BusinessFunctions.selectValueFromDropdown(driver,_securityQuestionThreeNewUser,
				mxTransfereeMyProfileData.securityQuestionThree);
		CoreFunctions.waitHandler(3);
		CoreFunctions.clearAndSetText(driver, _textBoxSecurityAnswerThreeNewUser,
				CoreFunctions.getAttributeText(_securityQuestionThreeNewUser, MobilityXConstants.TITLE),
				mxTransfereeMyProfileData.securityAnswerTwo);
		CoreFunctions.click(driver, _buttonSaveContinue, _buttonSaveContinue.getText());
	}

	public void myProfileModuleSetup() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textPersonalInformation,
				_textPersonalInformation.getText());
		CoreFunctions.highlightObject(driver, _textMyProfileModule);
		CoreFunctions.click(driver, _linkUpdateProfilePicture, _linkUpdateProfilePicture.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _popupTextUploadMyImage,
				_popupTextUploadMyImage.getText());
		CoreFunctions.waitHandler(3);
		_uploadFileLink.sendKeys(_uploadFilePath + mxTransfereeMyProfileData.uploadFileName);
		CoreFunctions.waitHandler(2);
		CoreFunctions.click(driver, _buttonUpload, _buttonUpload.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _iconDeleteProfilePicture,
				CoreFunctions.getAttributeText(_iconDeleteProfilePicture, MobilityXConstants.TITLE));
		CoreFunctions.writeMessageToReport(_iconDeleteProfilePicture.isDisplayed(), MobilityXConstants.VERIFY_FILE_UPLOADED,
				MobilityXConstants.FAILED_TO_UPLOAD_FILE, mxTransfereeMyProfileData.uploadFileName);
		CoreFunctions.clearAndSetText(driver, _textboxPhoneNumber, MobilityXConstants.TEXT_PHONE_NUMBER,
				CoreFunctions.generateRandomNumberAsGivenLength(10));
		streetAddressTwo = mxTransfereeMyProfileData.streetAddressTwo + MobilityXConstants.BLANK_SPACE
				+ CoreFunctions.generateRandomNumberAsGivenLength(3);
		CoreFunctions.clearAndSetText(driver, _textBoxStreetAddressTwo, _textStreetAddressTwo.getText(),
				streetAddressTwo);
		movingDate = CoreFunctions.addDaysInCurrentDate(MobilityXConstants.DATE_FORMAT_ddMMMyyyy, 45);
		CoreFunctions.clearAndSetText(driver, _myMovingDate, _textMyMovingDate.getText(), movingDate);
		fullName = CoreFunctions.getAttributeText(_textFirstName, MobilityXConstants.VALUE) + MobilityXConstants.BLANK_SPACE
				+ CoreFunctions.getAttributeText(_textLastName, MobilityXConstants.VALUE);
		address = CoreFunctions.getAttributeText(_textDestinationAddress, MobilityXConstants.VALUE);
		CoreFunctions.click(driver, _buttonNext, _buttonNext.getText());
	}

	public void myServicesModuleSetup() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textHousing, _textHousing.getText());
		CoreFunctions.highlightObject(driver, _textMyServices);
		CoreFunctions.highlightObject(driver, _textHousing);
		CoreFunctions.selectItemInListByText(driver, _checkboxListServices, mxTransfereeMyProfileData.housingService);
		CoreFunctions.highlightObject(driver, _textMoving);
		CoreFunctions.waitHandler(1);
		CoreFunctions.selectItemInListByText(driver, _checkboxListServices, mxTransfereeMyProfileData.movingService);
		CoreFunctions.waitHandler(1);
		CoreFunctions.highlightObject(driver, _textSettlingIn);
		CoreFunctions.selectItemInListByText(driver, _checkboxListServices, mxTransfereeMyProfileData.settlingInService);
		CoreFunctions.waitHandler(1);
		CoreFunctions.checkCheckBox(driver, _checkboxGatherQuotes, _checkboxGatherQuotes.getText());
		CoreFunctions.checkCheckBox(driver, _checkboxEmail, _checkboxEmail.getText());
		CoreFunctions.click(driver, _buttonNext, _buttonNext.getText());
	}

	public void additionalInfoModuleSetup() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textFewMoreQuestion, _textFewMoreQuestion.getText());
		CoreFunctions.highlightObject(driver, _textAdditionalInfoModule);
		if (CoreFunctions.getAttributeText(_expandArrowHousing, MobilityXConstants.ARIA_EXPANDED)
				.contains(MobilityXConstants.FALSE)) {
			CoreFunctions.clickWithoutReporting(driver, _expandArrowHousing, _expandArrowHousing.getText());
		} else if (CoreFunctions.getAttributeText(_expandArrowMoving, MobilityXConstants.ARIA_EXPANDED)
				.contains(MobilityXConstants.FALSE)) {
			CoreFunctions.clickWithoutReporting(driver, _expandArrowMoving, _expandArrowMoving.getText());
		}
		CoreFunctions.waitHandler(2);
		for (WebElement serviceElement : _textSelectedServiceList) {
			CoreFunctions.highlightObject(driver, serviceElement);
			editInformationAsPerServices(serviceElement.getText());
		}
		CoreFunctions.clearAndSetText(driver, _textboxZipCodeAddInfo, MobilityXConstants.ZIPCODE,
				CoreFunctions.generateRandomNumberAsGivenLength(5));
		CoreFunctions.click(driver, _buttonNext, _buttonNext.getText());
	}

	public void editInformationAsPerServices(String serviceName) {
		switch (serviceName) {
		case MobilityXConstants.SELLING_MY_CURRENT_HOME:
			CoreFunctions.clearAndSetText(driver, _textboxHomeSaleEstimate, MobilityXConstants.HOME_SALE_ESTIMATE,
					CoreFunctions.generateRandomNumberAsGivenLength(3));
			break;
		case MobilityXConstants.SHIPPING_MY_CAR:
			CoreFunctions.clearAndSetText(driver, _textboxNumberOfCarRequired, _textNumberOfCarRequired.getText(),
					CoreFunctions.generateRandomNumberAsGivenLength(1));
			break;
		case MobilityXConstants.BOOKING_MY_RENTAL_CAR:
			CoreFunctions.clearAndSetText(driver, _textboxRentalDaysRequired, MobilityXConstants.RENTAL_DAYS_REQUIRED,
					CoreFunctions.generateRandomNumberAsGivenLength(2));
			break;
		default:
			Assert.fail(MobilityXConstants.NO_ELEMENT_FOUND);
			break;
		}
	}

	public void myBudgetModuleSetup() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _linkChangeCurrency, _linkChangeCurrency.getText());
		CoreFunctions.highlightObject(driver, _textMyBudgetModule);
		CoreFunctions.verifyElementOnPage(driver, _totalToSpendAmount, _totalToSpendAmount.getText());
		if (CoreFunctions.searchElementExistsInListByText(driver, _selectedServiceListOnMyBudget,
				mxTransfereeMyProfileData.housingService))
			CoreFunctions.clearAndSetText(driver, _textboxHousingBudgetAmount, mxTransfereeMyProfileData.housingService,
					CoreFunctions.generateRandomNumberAsGivenLength(2));
		if (CoreFunctions.searchElementExistsInListByText(driver, _selectedServiceListOnMyBudget,
				mxTransfereeMyProfileData.movingService))
			CoreFunctions.clearAndSetText(driver, _textboxMovingBudgetAmount, mxTransfereeMyProfileData.movingService,
					CoreFunctions.generateRandomNumberAsGivenLength(2));
		if (CoreFunctions.searchElementExistsInListByText(driver, _selectedServiceListOnMyBudget,
				mxTransfereeMyProfileData.settlingInService))
			CoreFunctions.clearAndSetText(driver, _textboxSettlingInBudgetAmount,
					mxTransfereeMyProfileData.settlingInService, CoreFunctions.generateRandomNumberAsGivenLength(2));
		CoreFunctions.click(driver, _buttonNext, _buttonNext.getText());
	}

	public void myAccountInformationModuleSetup() {
		if (CoreFunctions.isElementExist(driver, _radioButtonLumpSumPayementByLocator, MobilityXConstants.CUSTOM_TIME)) {
			CoreFunctions.highlightObject(driver, _textMyAccountInformationModule);
			CoreFunctions.click(driver, _radioButtonLumpSumPayement, _radioButtonLumpSumPayement.getText());
			CoreFunctions.click(driver, _buttonNext, _buttonNext.getText());
			addACHAccountForLumpSumPayment();
		}
	}

	public void addACHAccountForLumpSumPayment() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textPaymentType, _textPaymentType.getText());
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioButtonPaymentTypeList,
				mxTransfereeMyProfileData.paymentTypeACH);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textAccountDetails, _textAccountDetails.getText());
		CoreFunctions.clearAndSetText(driver, _textBoxAccountHolderNameACHAccount,
				_textAccountHolderNameACHAccount.getText(), mxTransfereeMyProfileData.accountHolderName);
		BusinessFunctions.selectValueFromDropdown(driver,_dropdownAccountTypeACHAccount, mxTransfereeMyProfileData.accountType);
		CoreFunctions.clearAndSetText(driver, _textBoxBankNameACHAccount, _textBankNameACHAccount.getText(),
				mxTransfereeMyProfileData.bankName);
		CoreFunctions.clearAndSetText(driver, _textBoxAddressOneACHAccount, MobilityXConstants.ADDRESS,
				mxTransfereeMyProfileData.addressOne);
		CoreFunctions.clearAndSetText(driver, _textBoxCityACHAccount, MobilityXConstants.CITY,
				mxTransfereeMyProfileData.city);
		BusinessFunctions.selectValueFromDropdown(driver,_dropdownStateACHAccount, mxTransfereeMyProfileData.state);
		CoreFunctions.clearAndSetText(driver, _textBoxZipCodeACHAccount, MobilityXConstants.ZIPCODE,
				CoreFunctions.generateRandomNumberAsGivenLength(5));
		BusinessFunctions.selectValueFromDropdown(driver,_dropdownCountryACHAccount, mxTransfereeMyProfileData.country);
		CoreFunctions.clearAndSetText(driver, _textBoxSwiftRoutingACHAccount, _textSwiftRoutingACHAccount.getText(),
				mxTransfereeMyProfileData.swiftRoutingNumber);
		CoreFunctions.clearAndSetText(driver, _textBoxAccountIbanNumberACHAccount,
				_textAccountIbanNumberACHAccount.getText(), mxTransfereeMyProfileData.accountIBANNumber);
		CoreFunctions.click(driver, _buttonSave, _buttonSave.getText());
	}

	public boolean finalSubmissionOnSpringBoardDashboard(DataTable table) {
		if (CoreFunctions.isElementByLocatorExist(driver, _textSetupIsCompleteByLocator, MobilityXConstants.CUSTOM_TIME)) {
			CoreFunctions.highlightObject(driver, _textSetupIsComplete);
			CoreFunctions.click(driver, _buttonCheck, MobilityXConstants.BUTTON_OK);
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.VERIFIED_ALL_MODULES_SAVED, CoreConstants.PASS, table));
			return true;
		}
		Reporter.addStepLog(
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_ALL_MODULES_SAVED, CoreConstants.FAIL, table));
		return false;
	}

	public boolean isAddressDisplayed(String address) {
		if (_springBoardUserAddress.getText().contains(address)) {
			CoreFunctions.highlightObject(driver, _springBoardUserAddress);
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.VERIFIED_ELEMENT_ON_PAGE, CoreConstants.PASS,
					MobilityXConstants.ADDRESS + ": " + address, MobilityXConstants.SPRINGBOARD_HOME_PAGE));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(MobilityXConstants.FAIL_TO_VERIFY_ELEMENT_ON_PAGE, CoreConstants.FAIL,
				MobilityXConstants.ADDRESS + ": " + address, MobilityXConstants.SPRINGBOARD_HOME_PAGE));
		return false;
	}

	public void click(String btn_linkName) {		
		switch(btn_linkName) {
		case MobilityXConstants.MANAGE_ACCOUNT_INFORMATION:
			CoreFunctions.clickWithoutReporting(driver, _linkManageAccountInformation, _linkManageAccountInformation.getText());
			break;
		case MobilityXConstants.MY_PROFILE:
			CoreFunctions.clickWithoutReporting(driver, _linkMyProfile,
					CoreFunctions.getAttributeText(_linkMyProfile, MobilityXConstants.TITLE));
			break;
		default:
			Assert.fail(MobilityXConstants.NO_ELEMENT_FOUND);
			break;
		}		
	}
}
