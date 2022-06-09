package com.aires.pages.coreflex;

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
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_OtherHousing_BenefitsPage extends Base {

	public CoreFlex_OtherHousing_BenefitsPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Save & Continue Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'SAVE & CONTINUE')]")
	private WebElement _buttonSaveAndContinue;

	// Add Another Benefit Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Another Benefit')]")
	private WebElement _buttonAddAnotherBenefit;

	// Back Button
	@FindBy(how = How.CSS, using = "button[class*='btn-back']")
	private WebElement _buttonBack;

	// Exit Button
	@FindBy(how = How.CSS, using = "button[class*='btn-exit']")
	private WebElement _buttonExit;

	// Logout Button
	@FindBy(how = How.XPATH, using = "//i[contains(text(),'exit_to_app')]")
	private WebElement _buttonLogout;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	// Policy Header
	@FindBy(how = How.CSS, using = "h4[class='card-title'] > b")
	private WebElement _headerPolicyInfo;

	// Flex Policy Setup Header
	@FindBy(how = How.CSS, using = "div[class*='pcard-header'] > h4[class='card-title']")
	private WebElement _headerPage;

	// Left Navigation Completed Sections
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[contains(@class,'nav-item')]//p")
	private List<WebElement> _leftNavigationTitleList;

	// Left Navigation Selected Benefits List
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//a[contains(@class,'menu-pad')]//p")
	private List<WebElement> _leftNavigationTitleSelectedBenefitsList;

	// Left Navigation Active Benefit
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[@class='nav-item active']//p")
	private WebElement _leftNavigationTitleActiveBenefit;

	// Benefit Title
	@FindBy(how = How.CSS, using = "h5[class*='accordion-header-txt'] > span")
	private WebElement _BenefitTitleList;

	// Added Benefit Button List
	@FindBy(how = How.CSS, using = "div[class='card-header']")
	private List<WebElement> _addedBenefitList;

	// Delete Benefit Button List
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Delete')]")
	private List<WebElement> _deleteBenefitButtonList;

	// Delete Benefit Button - Yes Option
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Yes')]")
	private WebElement _deleteBenefitButtonYesOption;

	// Benefit Display Name Input Field
	@FindBy(how = How.ID, using = "benefitName")
	private WebElement _inputBenefitName;

	// Point Value Input Field
	@FindBy(how = How.ID, using = "flexPoints")
	private WebElement _inputPointValue;

	// Allowance / Amount Message TextArea Field
	@FindBy(how = How.CSS, using = "textarea[name='shortDesc']")
	private WebElement _textAreaAllowanceAmountMessage;

	// Benefit Long Description TextArea Field
	@FindBy(how = How.CSS, using = "textarea[name='longDesc']")
	private WebElement _textAreaBenefitLongDescription;

	// Benefit Comment TextArea Field
	@FindBy(how = How.CSS, using = "textarea[formcontrolname='benefitComment']")
	private WebElement _textAreaBenefitComment;

	// Reimbursed By Radio Buttons
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioButtonReimbursedBy;

	// Gross Up Radio Buttons
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioButtonGrossUp;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='multiAddInd']/parent::label")
	private WebElement _inputMultiAddBenefit;

	// Policy Benefits data Missing Error Dialog
	@FindBy(how = How.XPATH, using = "//div[@id='swal2-content'][contains(text(),'Policy Benefits data missing. Please complete all the benefits.')]")
	private WebElement _errorDialogPolicyBenefitsDataMissing;

	// Policy Benefits data Missing Error Dialog - OK Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _errorDialogPolicyBenefitsDataMissingOKButton;

	// Error PopUp Ok Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _buttonOKErrorDialog;

	// Flex Points Validation Message
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='flexPoints']/following-sibling::div[contains(@class,'input-error')]/div")
	private WebElement _validationMessageFlexPoints;

	// Payments Radio Selection
	@FindBy(how = How.XPATH, using = "//div[@class='form-group required']//label[@class='form-check-label']")
	private List<WebElement> _radioBenefitMandatoryButtons;

	// Expense Reimbursement Instructions Field
	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname='howItWorks']/preceding-sibling::label")
	private WebElement _textExpenseReimInstructions;

	/*********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	/*********************************************************************/

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.OTHER_HOUSING_BENEFIT,
				expectedPageName, expectedPageName, true);
	}

	/**
	 * Generic Method to Click on an Element on a Page.
	 * 
	 * @param elementName
	 */
	public void clickElementOfPage(String elementName) {
		try {
			switch (elementName) {
			case PDTConstants.LOGOUT:
				CoreFunctions.clickElement(driver, _buttonLogout);
				break;
			case COREFLEXConstants.SAVE_AND_CONTINUE:
				CoreFunctions.clickElement(driver, _buttonSaveAndContinue);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.ADD_ANOTHER_BENEFIT:
				CoreFunctions.clickElement(driver, _buttonAddAnotherBenefit);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.OK:
				CoreFunctions.clickElement(driver, _buttonOKErrorDialog);
				break;
			case PDTConstants.BACK:
				CoreFunctions.clickElement(driver, _buttonBack);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.EXIT:
				CoreFunctions.clickElement(driver, _buttonExit);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_AN_ELEMENT_OF_PAGE,
							CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);
		}
	}

	/**
	 * Generic method to click on an Left Navigation Menu.
	 * 
	 * @param elementName
	 */
	public void clickLeftNavigationMenuOfPage(String elementName) {
		try {
			switch (elementName) {
			case COREFLEXConstants.GENERAL_INFORMATION:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.GENERAL_INFORMATION);
				break;
			case COREFLEXConstants.FLEX_POLICY_SETUP:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.FLEX_POLICY_SETUP);
				break;
			case COREFLEXConstants.POLICY_BENEFIT_CATEGORIES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.POLICY_BENEFIT_CATEGORIES);
				break;
			case COREFLEXConstants.BENEFIT_SUMMARY:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.BENEFIT_SUMMARY);
				break;
			case COREFLEXConstants.CUSTOM_BUNDLES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.BENEFIT_SUMMARY);
				break;
			default:
				Assert.fail(PDTConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_LEFTNAVIGATION_ELEMENT_OF_PAGE,
					CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);

		}
	}

	/**
	 * Method to call select Benefit Type and fill all mandatory fields
	 * 
	 * @param benefitDisplayName
	 * @param flexPoints
	 * @param multipleBenefitSelection
	 * @param benefitAllowanceAmount
	 * @param benefitDescription
	 * @param benefitComment
	 * @param grossUp
	 * @param reimbursedBy
	 */
	public void selectAndFillBenefitsDetails(String benefitDisplayName, String flexPoints,
			String multipleBenefitSelection, String benefitAllowanceAmount, String benefitDescription,
			String benefitComment, String grossUp, String reimbursedBy, String paymentOption) {

		CoreFunctions.clearAndSetTextUsingKeys(driver, _inputBenefitName, benefitDisplayName,
				COREFLEXConstants.BENEFIT_DISPLAY_NAME);
		CoreFunctions.clearAndSetTextUsingKeys(driver, _inputPointValue, flexPoints,
				COREFLEXConstants.FLEX_POINTS_VALUE);
		CoreFunctions.selectItemInListByText(driver, _radioBenefitMandatoryButtons, paymentOption, true,
				COREFLEXConstants.PAYMENT_OPTION);
		if (multipleBenefitSelection.equals(COREFLEXConstants.YES))
			CoreFunctions.clickElement(driver, _inputMultiAddBenefit);
		CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaAllowanceAmountMessage, benefitAllowanceAmount,
				COREFLEXConstants.ALLOWANCE_AMOUNT_MESSAGE);
		CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaBenefitLongDescription, benefitDescription,
				COREFLEXConstants.BENEFIT_LONG_DESCRIPTION);
		CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaBenefitComment, benefitComment,
				COREFLEXConstants.BENEFIT_COMMENT);
		CoreFunctions.selectItemInListByText(driver, _radioButtonGrossUp, grossUp, true);
		CoreFunctions.selectItemInListByText(driver, _radioButtonReimbursedBy, reimbursedBy, true);
		verifyUpdatedBenefitTitle(benefitDisplayName);
		verifyAddAnotherBenefitLimit();
		deleteAdditionalAddedBenefits();
		clickElementOfPage(COREFLEXConstants.SAVE_AND_CONTINUE);
		if (CoreFunctions.isElementExist(driver, _errorDialogPolicyBenefitsDataMissing, 3)) {
			CoreFunctions.clickElement(driver, _errorDialogPolicyBenefitsDataMissingOKButton);
			clickElementOfPage(PDTConstants.BACK);
		}
	}

	private void deleteAdditionalAddedBenefits() {
		int counter = 1;
		if (_addedBenefitList.size() == 10) {
			BusinessFunctions.selectValueFromListUsingIndex(driver, _deleteBenefitButtonList, counter);
			CoreFunctions.clickElement(driver, _deleteBenefitButtonYesOption);
			CoreFunctions.waitHandler(1);
			verifyAddAnotherBenefitButtonIsDisplayed();
		}
		deleteBenefits();
	}

	private void deleteBenefits() {
		int counter = 1;
		while (counter < _deleteBenefitButtonList.size()) {
			BusinessFunctions.selectValueFromListUsingIndex(driver, _deleteBenefitButtonList, counter);
			CoreFunctions.clickElement(driver, _deleteBenefitButtonYesOption);
			CoreFunctions.waitHandler(1);
		}
	}

	private void verifyAddAnotherBenefitButtonIsDisplayed() {
		if (CoreFunctions.isElementExist(driver, _buttonAddAnotherBenefit, 3)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_ADD_ANOTHER_BENEFIT_BUTTON_DISPLAYED_AFTER_10TH_BENEFIT_IS_DELETED,
					CoreConstants.PASS));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.ADD_ANOTHER_BENEFIT_BUTTON_NOT_DISPLAYED_AFTER_10TH_BENEFIT_IS_DELETED,
					CoreConstants.FAIL));
			Assert.fail(MessageFormat.format(
					COREFLEXConstants.ADD_ANOTHER_BENEFIT_BUTTON_NOT_DISPLAYED_AFTER_10TH_BENEFIT_IS_DELETED,
					CoreConstants.FAIL));
		}
	}

	private void verifyAddAnotherBenefitLimit() {

		try {
			for (int i = 1; i < 10; i++) {
				clickElementOfPage(COREFLEXConstants.ADD_ANOTHER_BENEFIT);
			}
			if (CoreFunctions.isElementExist(driver, _buttonAddAnotherBenefit, 3)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.ADD_ANOTHER_BENEFIT_BUTTON_DISPLAYED_AFTER_MAXIMUM_BENEFIT_TO_BE_ADDED_LIMIT,
						CoreConstants.FAIL));
				Assert.fail(MessageFormat.format(
						COREFLEXConstants.ADD_ANOTHER_BENEFIT_BUTTON_DISPLAYED_AFTER_MAXIMUM_BENEFIT_TO_BE_ADDED_LIMIT,
						CoreConstants.FAIL));
			} else {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.ADD_ANOTHER_BENEFIT_BUTTON_NOT_DISPLAYED_AFTER_MAXIMUM_BENEFIT_TO_BE_ADDED_LIMIT,
						CoreConstants.PASS));
			}
		} catch (ElementNotFoundException e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.ADD_ANOTHER_BENEFIT_BUTTON_NOT_DISPLAYED_BEFORE_MAXIMUM_BENEFIT_TO_BE_ADDED_LIMIT,
					CoreConstants.FAIL, e.getMessage()));
			Assert.fail(MessageFormat.format(
					COREFLEXConstants.ADD_ANOTHER_BENEFIT_BUTTON_NOT_DISPLAYED_BEFORE_MAXIMUM_BENEFIT_TO_BE_ADDED_LIMIT,
					CoreConstants.FAIL));
		}
	}

	private void verifyUpdatedBenefitTitle(String benefitDisplayName) {

		if (CoreFunctions.getElementText(driver, _BenefitTitleList).equals(benefitDisplayName)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_UPDATED_BENEFIT_TITLE_TO_ENTERED_BENEFIT_DISPLAY_NAME,
					CoreConstants.PASS, benefitDisplayName));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_UPDATE_BENEFIT_TITLE_TO_ENTERED_BENEFIT_DISPLAY_NAME,
					CoreConstants.FAIL, benefitDisplayName));
			Assert.fail(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_UPDATE_BENEFIT_TITLE_TO_ENTERED_BENEFIT_DISPLAY_NAME,
					CoreConstants.FAIL, benefitDisplayName));
		}
	}

	public void checkFieldValidation(String fieldName, String inputValue) {
		boolean isValidationMessageDisplayed = false;
		switch (fieldName) {
		case COREFLEXConstants.FLEX_POINT_VALUE:
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputPointValue, inputValue,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			clickElementOfPage(COREFLEXConstants.SAVE_AND_CONTINUE);
			clickElementOfPage(PDTConstants.OK);
			if (CoreFunctions.isElementExist(driver, _validationMessageFlexPoints, 5))
				isValidationMessageDisplayed = CoreFunctions.getElementText(driver, _validationMessageFlexPoints)
						.equals(COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE);
			BusinessFunctions.checkValidationBasedOnInput(isValidationMessageDisplayed, fieldName, inputValue);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
	}

	public void verifyNumericRangeFieldsValidation() {
		try {
			checkFieldValidation(COREFLEXConstants.FLEX_POINT_VALUE, "0.24");
			checkFieldValidation(COREFLEXConstants.FLEX_POINT_VALUE, "0.50");
			checkFieldValidation(COREFLEXConstants.FLEX_POINT_VALUE, "100.25");
			checkFieldValidation(COREFLEXConstants.FLEX_POINT_VALUE, "999.5");
			checkFieldValidation(COREFLEXConstants.FLEX_POINT_VALUE, "1001");
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_POINTS_FIELD_VALIDATION_ON_OTHER_HOUSING_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	public void verifyFieldTextUpdates() {
		try {
			CoreFunctions.verifyText(driver, _textExpenseReimInstructions,
					COREFLEXConstants.EXPENSE_REIMBURSEMENT_INSTRUCTIONS_TEXT,
					COREFLEXConstants.EXPENSE_REIMBURSEMENT_INSTRUCTIONS);

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FIELD_TEXT_UPDATES_ON_OTHER_HOUSING_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

	}
}
