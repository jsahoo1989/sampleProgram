package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.CoreFlex_SettlingInBenefitsData;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_LanguageTraining_BenefitsPage extends Base {

	public CoreFlex_LanguageTraining_BenefitsPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Save & Continue Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'SAVE & CONTINUE')]")
	private WebElement _buttonSaveAndContinue;

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

	// Page Header
	@FindBy(how = How.CSS, using = "div[class*='pcard-header'] > h4[class='card-title']")
	private WebElement _headerPage;

	// Left Navigation Completed Sections
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[contains(@class,'nav-item')]//p")
	private List<WebElement> _leftNavigationTitleList;

	// Left Navigation Selected Benefits List
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//a[contains(@class,'menu-pad')]//p")
	private List<WebElement> _leftNavigationTitleSelectedBenefitsList;

	// Core Type Selection
	@FindBy(how = How.ID, using = "core")
	private WebElement _textCore;

	// Flex Type Selection
	@FindBy(how = How.ID, using = "flex")
	private WebElement _textFlex;

	// Flex Points Input Field
	@FindBy(how = How.CSS, using = "input[formcontrolname='flexPoints']")
	private WebElement _inputFlexPoints;

	// Core Benefit - Both Selection
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Core Benefits')]")
	private WebElement _textCoreBenefits;

	// Flex Benefit - Both Selection
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flex Benefits')]")
	private WebElement _textFlexBenefits;

	// Both Benefit Type Selection
	@FindBy(how = How.ID, using = "both")
	private WebElement _textBoth;

	// Benefit Display Name Input Field
	@FindBy(how = How.ID, using = "benefitName")
	private WebElement _inputBenefitName;

	// Allowance / Amount Message TextArea Field
	@FindBy(how = How.CSS, using = "textarea[name='shortDesc']")
	private WebElement _textAreaAllowanceAmountMessage;

	// Benefit Long Description TextArea Field
	@FindBy(how = How.CSS, using = "textarea[name='longDesc']")
	private WebElement _textAreaBenefitLongDescription;

	// SubBenefit List
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitList;

	// SubBenefit - Collapsable Menu 1
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Language Training Employee')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formLanguageTrainingEmployee;

	// SubBenefit - Collapsable Menu 2
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Language Training Family')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formLanguageTrainingFamily;

	// Max Number of Hours Per Family Input Field
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='maxNumOfHours']")
	private WebElement _inputMaxNumOfHours;	

	// Max Number of Hours Per Person Input Field
	@FindBy(how = How.CSS, using = "input[formcontrolname='numHoursPerPerson']")
	private WebElement _inputMaxNumOfHoursPerPerson;

	// Self Learning Tool - Radio Button Selection
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='selfLearningToolInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnSelfLearningTool;

	// Gross Up - Radio Button Selection
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='grossedUpInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnGrossUp;

	// Radio Button Selection From Entire SubBenefit Section
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//label[@class='form-check-label']")
	private List<WebElement> _radioBtnCandidateSelection;

	// Reimbursed By Other Input
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='paidByOther']")
	private WebElement _inputReimbursedBy;

	// Comment Text Area
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//textarea[@formcontrolname='benefitComment']")
	private WebElement _txtAreaComment;

	// Language Max Amount
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='languageMaxAmount']")
	private WebElement _inputMaxAmount;

	/*********************************************************************/

	CoreFlex_SettlingInBenefitsData languageTrainingBenefitData = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getSettlingInBenefitDataList(COREFLEXConstants.LANGUAGE_TRAINING);

	/*********************************************************************/

	/**
	 * Method to get Navigated Page Header.
	 * 
	 * @return
	 */
	public String getPageHeaderTitle() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _headerPage, COREFLEXConstants.LANGUAGE_TRAINING);
			return CoreFunctions.getElementText(driver, _headerPage);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FETCHING_PAGE_HEADER_TITLE,
							CoreConstants.FAIL, e.getMessage()));
		}
		return null;
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
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		return (getPageHeaderTitle().equals(expectedPageName));
	}

	/**
	 * Method to call select Benefit Type and Sub Benefits, fill all mandatory
	 * fields methods
	 * 
	 * @param benefitType
	 * @param subBenefitNames
	 */
	public void selectAndFillBenefitsAndSubBenefitDetails(String benefitType, String subBenefitNames) {
		selectBenefitTypeAndFillMandatoryFields(benefitType);
		if (benefitType.equals(COREFLEXConstants.BOTH)) {
			selectBenefitTypeAndFillMandatoryFields(COREFLEXConstants.CORE_BENEFITS);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames);
			selectBenefitTypeAndFillMandatoryFields(COREFLEXConstants.FLEX_BENEFITS);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames);
		} else {
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames);
		}
		clickElementOfPage(COREFLEXConstants.SAVE_AND_CONTINUE);
	}

	/**
	 * Method to select and fill mentioned SubBenefits and fill all the SubBenefits
	 * section fields
	 * 
	 * @param subBenefitNames
	 */
	private void selectSubBenefitsAndFillMandatoryFields(String subBenefitNames) {

		List<String> subBenefitNamesList = new ArrayList<String>();
		if (subBenefitNames.contains(";"))
			subBenefitNamesList = Arrays.asList(subBenefitNames.split(";"));
		else
			subBenefitNamesList.add(subBenefitNames);

		for (String subBenefit : subBenefitNamesList) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitList, subBenefit.trim(), true);
			if (CoreFunctions.isElementExist(driver, getElementByName(subBenefit.trim()), 5)) {
				fillSubBenefit(subBenefit.trim());
			} else {
				Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
						CoreConstants.FAIL, subBenefit, COREFLEXConstants.DUPLICATE_HOUSING_BENEFITS_PAGE));
				throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
						CoreConstants.FAIL, subBenefit, COREFLEXConstants.DUPLICATE_HOUSING_BENEFITS_PAGE));
			}
		}
	}

	/**
	 * Method to Expand and call FillSubBenefit method
	 * 
	 * @param subBenefit
	 */
	private void fillSubBenefit(String subBenefit) {
		switch (subBenefit) {
		case COREFLEXConstants.LANGUAGE_TRAINING_EMPLOYEE:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.LANGUAGE_TRAINING_EMPLOYEE));
			fillLanguageTrainingEmployeeSubBenefitForm();
			break;
		case COREFLEXConstants.LANGUAGE_TRAINING_FAMILY:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.LANGUAGE_TRAINING_FAMILY));
			fillLanguageTrainingFamilySubBenefitForm();
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to fill Language Training Family subBenefit form
	 */
	private void fillLanguageTrainingFamilySubBenefitForm() {
		CoreFunctions.clearAndSetText(driver, _inputMaxNumOfHoursPerPerson,
				languageTrainingBenefitData.languageTrainingFamily.maxNumberOfHoursPerPerson);
		CoreFunctions.clearAndSetText(driver, _inputMaxNumOfHours,
				languageTrainingBenefitData.languageTrainingFamily.maxNumberOfHoursPerFamily);
		CoreFunctions.selectItemInListByText(driver, _radioBtnSelfLearningTool,
				languageTrainingBenefitData.languageTrainingFamily.selfLearningTool, true);
		if (languageTrainingBenefitData.languageTrainingFamily.selfLearningTool
				.equalsIgnoreCase(COREFLEXConstants.YES)) {
			CoreFunctions.clearAndSetText(driver, _inputMaxAmount,
					languageTrainingBenefitData.languageTrainingFamily.maxAmount);
		}
		CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
				languageTrainingBenefitData.languageTrainingFamily.grossUp, true);
		CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
				languageTrainingBenefitData.languageTrainingFamily.reimbursedBy, true);
		if (languageTrainingBenefitData.languageTrainingFamily.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
			CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
					languageTrainingBenefitData.languageTrainingFamily.reimbursedByOther);
		}
		CoreFunctions.clearAndSetText(driver, _txtAreaComment,
				languageTrainingBenefitData.languageTrainingFamily.comment);
	}

	/**
	 * Method to fill Language Training Employee subBenefit form
	 */
	private void fillLanguageTrainingEmployeeSubBenefitForm() {
		CoreFunctions.clearAndSetText(driver, _inputMaxNumOfHours,
				languageTrainingBenefitData.languageTrainingEmployee.maxNumberOfHours);
		CoreFunctions.selectItemInListByText(driver, _radioBtnSelfLearningTool,
				languageTrainingBenefitData.languageTrainingEmployee.selfLearningTool, true);
		if (languageTrainingBenefitData.languageTrainingEmployee.selfLearningTool
				.equalsIgnoreCase(COREFLEXConstants.YES)) {
			CoreFunctions.clearAndSetText(driver, _inputMaxAmount,
					languageTrainingBenefitData.languageTrainingEmployee.maxAmount);
		}
		CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
				languageTrainingBenefitData.languageTrainingEmployee.grossUp, true);
		CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
				languageTrainingBenefitData.languageTrainingEmployee.reimbursedBy, true);
		if (languageTrainingBenefitData.languageTrainingEmployee.reimbursedBy
				.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
			CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
					languageTrainingBenefitData.languageTrainingEmployee.reimbursedByOther);
		}
		CoreFunctions.clearAndSetText(driver, _txtAreaComment,
				languageTrainingBenefitData.languageTrainingEmployee.comment);
	}

	/**
	 * Method to Expand SubBenefits Section is collapsed
	 * 
	 * @param subBenefitForm
	 */
	private void expandSubBenefitIfCollapsed(WebElement subBenefitForm) {
		if (subBenefitForm.getAttribute("class").equalsIgnoreCase("collapsed")) {
			CoreFunctions.clickElement(driver, subBenefitForm);
		}
	}

	/**
	 * Method to get SubBenefit Section Element
	 * 
	 * @param elementName
	 * @return
	 */
	public WebElement getElementByName(String elementName) {
		WebElement element = null;
		switch (elementName) {
		case COREFLEXConstants.LANGUAGE_TRAINING_EMPLOYEE:
			element = _formLanguageTrainingEmployee;
			break;
		case COREFLEXConstants.LANGUAGE_TRAINING_FAMILY:
			element = _formLanguageTrainingFamily;
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}

	/**
	 * Method to select Benefit Type and fill all Mandatory Fields
	 * 
	 * @param benefitType
	 */
	private void selectBenefitTypeAndFillMandatoryFields(String benefitType) {
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			fillManadatoryDetails();
			break;
		case COREFLEXConstants.FLEX:
			CoreFunctions.clickElement(driver, _textFlex);
			CoreFunctions.clearAndSetText(driver, _inputFlexPoints,
					languageTrainingBenefitData.languageTrainingEmployee.flexPoints);
			fillManadatoryDetails();
			break;
		case COREFLEXConstants.CORE_BENEFITS:
			CoreFunctions.clickElement(driver, _textCoreBenefits);
			fillManadatoryDetails();
			break;
		case COREFLEXConstants.FLEX_BENEFITS:
			CoreFunctions.clickElement(driver, _textFlexBenefits);
			CoreFunctions.clearAndSetText(driver, _inputFlexPoints,
					languageTrainingBenefitData.languageTrainingEmployee.flexPoints);
			fillManadatoryDetails();
			break;
		case COREFLEXConstants.BOTH:
			CoreFunctions.clickElement(driver, _textBoth);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
	}

	/**
	 * Method to fill Default Mandatory Fields of Benefit
	 */
	private void fillManadatoryDetails() {
		CoreFunctions.clearAndSetText(driver, _inputBenefitName, COREFLEXConstants.LANGUAGE_TRAINING);
		CoreFunctions.clearAndSetText(driver, _textAreaAllowanceAmountMessage,
				COREFLEXConstants.LANGUAGE_TRAINING + COREFLEXConstants.ALLOWANCE_AMOUNT_MESSAGE);
		CoreFunctions.clearAndSetText(driver, _textAreaBenefitLongDescription,
				COREFLEXConstants.LANGUAGE_TRAINING + COREFLEXConstants.BENEFIT_LONG_DESCRIPTION);
	}
}
