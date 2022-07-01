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
import com.aires.testdatatypes.coreflex.Benefit;
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

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Language Training Employee')]")
	private WebElement _headerLanguageTrainingEmployee;

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

	// Self Learning Tool - Radio Button Selection - Button List
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='selfLearningToolInd']")
	private List<WebElement> _radioBtnSelfLearningToolButtonList;

	// Self Learning Tool - Radio Button Selection - Label List
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='selfLearningToolInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnSelfLearningToolLabelList;

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

	// Aires Managed Service Radio Button
	@FindBy(how = How.CSS, using = "div[class*='form-check-radio'] > label[class*='form-check']")
	private List<WebElement> _radioAiresManagedService;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']/parent::label")
	private WebElement _inputMultiAddBenefit;

	// Policy Benefits data Missing Error Dialog
	@FindBy(how = How.XPATH, using = "//div[@id='swal2-content'][contains(text(),'Policy Benefits data missing. Please complete all the benefits.')]")
	private WebElement _errorDialogPolicyBenefitsDataMissing;

	// Policy Benefits data Missing Error Dialog - OK Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _errorDialogPolicyBenefitsDataMissingOKButton;

	// Aires Managed Benefit Radio Label Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Aires Managed Service')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioAiresManagedLabelList;

	// Aires Managed Benefit Radio Button Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Aires Managed Service')]/following-sibling::div//input")
	private List<WebElement> _radioAiresManagedButtonList;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']/parent::label")
	private List<WebElement> _inputMultiAddBenefitLabel;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']")
	private List<WebElement> _inputMultiAddBenefitButton;

	// Gross Up Radio Label Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Gross-Up')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioGrossUpLabelList;

	// Gross Up Radio Button Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Gross-Up')]/following-sibling::div//input")
	private List<WebElement> _radioGrossUpButtonList;

	// Reimbursed By Radio Label Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Reimbursed By')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioReimbursedByLabelList;

	// Reimbursed By Radio Button Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Reimbursed By')]/following-sibling::div//input")
	private List<WebElement> _radioReimbursedByButtonList;

	/*********************************************************************/

	CoreFlex_SettlingInBenefitsData settlingInBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getSettlingInBenefitDataList(COREFLEXConstants.LANGUAGE_TRAINING);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	/*********************************************************************/

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.DUPLICATE_HOUSING,
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
	 * Method to call select Benefit Type and Sub Benefits, fill all mandatory
	 * fields methods
	 * 
	 * @param benefitType
	 * @param subBenefitNames
	 * @param multipleBenefitSelection
	 * @param benefitDescription
	 * @param benefitAllowanceAmount
	 * @param benefitDescription2
	 */
	public void selectAndFillBenefitsAndSubBenefitDetails(String benefitType, String subBenefitNames,
			String multipleBenefitSelection, String flexPoints, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String aireManagedService) {
		if (benefitType.equals(COREFLEXConstants.BOTH)) {
			selectBenefitTypeAndFillMandatoryFields(benefitType, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectBenefitTypeAndFillMandatoryFields(COREFLEXConstants.CORE_BENEFITS, multipleBenefitSelection,
					flexPoints, benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames, COREFLEXConstants.CORE_BENEFITS);
			selectBenefitTypeAndFillMandatoryFields(COREFLEXConstants.FLEX_BENEFITS, multipleBenefitSelection,
					flexPoints, benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames, COREFLEXConstants.FLEX_BENEFITS);
		} else {
			selectBenefitTypeAndFillMandatoryFields(benefitType, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames, benefitType);
		}
		clickElementOfPage(COREFLEXConstants.SAVE_AND_CONTINUE);

		if (CoreFunctions.isElementExist(driver, _errorDialogPolicyBenefitsDataMissing, 7)) {
			CoreFunctions.clickElement(driver, _errorDialogPolicyBenefitsDataMissingOKButton);
		}
	}

	/**
	 * Method to select and fill mentioned SubBenefits and fill all the SubBenefits
	 * section fields
	 * 
	 * @param subBenefitNames
	 * @param benefitType
	 */
	private void selectSubBenefitsAndFillMandatoryFields(String subBenefitNames, String benefitType) {
		try {
			List<String> subBenefitNamesList = new ArrayList<String>();
			if (subBenefitNames.contains(";"))
				subBenefitNamesList = Arrays.asList(subBenefitNames.split(";"));
			else
				subBenefitNamesList.add(subBenefitNames);

			for (String subBenefit : subBenefitNamesList) {
				if(subBenefitNamesList.size() > 1) {
					CoreFunctions.selectItemInListByText(driver, _subBenefitList, subBenefit, true);
					}
				if (CoreFunctions.isElementExist(driver, getElementByName(subBenefit.trim()), 5)) {
					fillSubBenefit(subBenefit.trim(), benefitType);
				} else {
					Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.LANGUAGE_TRAINING_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.LANGUAGE_TRAINING_BENEFITS_PAGE));
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_FILLING_AIRES_MANAGED_SUB_BENEFITS,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Method to Expand and call FillSubBenefit method
	 * 
	 * @param subBenefit
	 * @param benefitType
	 */
	private void fillSubBenefit(String subBenefit, String benefitType) {
		switch (subBenefit) {
		case COREFLEXConstants.LANGUAGE_TRAINING_EMPLOYEE:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.LANGUAGE_TRAINING_EMPLOYEE));
			if (benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) {
				CoreFunctions.clickElement(driver, _headerLanguageTrainingEmployee);
			}
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
				settlingInBenefitData.languageTrainingFamily.maxNumberOfHoursPerPerson);
		CoreFunctions.clearAndSetText(driver, _inputMaxNumOfHours,
				settlingInBenefitData.languageTrainingFamily.maxNumberOfHoursPerFamily);
		CoreFunctions.selectItemInListByText(driver, _radioBtnSelfLearningTool,
				settlingInBenefitData.languageTrainingFamily.selfLearningTool, true);
		if (settlingInBenefitData.languageTrainingFamily.selfLearningTool.equalsIgnoreCase(COREFLEXConstants.YES)) {
			CoreFunctions.clearAndSetText(driver, _inputMaxAmount,
					settlingInBenefitData.languageTrainingFamily.maxAmount);
		}
		CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
				settlingInBenefitData.languageTrainingFamily.grossUp, true);
		CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
				settlingInBenefitData.languageTrainingFamily.reimbursedBy, true);
		if (settlingInBenefitData.languageTrainingFamily.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
			CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
					settlingInBenefitData.languageTrainingFamily.reimbursedByOther);
		}
		CoreFunctions.clearAndSetText(driver, _txtAreaComment, settlingInBenefitData.languageTrainingFamily.comment);
	}

	/**
	 * Method to fill Language Training Employee subBenefit form
	 */
	private void fillLanguageTrainingEmployeeSubBenefitForm() {
		CoreFunctions.clearAndSetText(driver, _inputMaxNumOfHours,
				settlingInBenefitData.languageTrainingEmployee.maxNumberOfHours);
		CoreFunctions.selectItemInListByText(driver, _radioBtnSelfLearningTool,
				settlingInBenefitData.languageTrainingEmployee.selfLearningTool, true);
		if (settlingInBenefitData.languageTrainingEmployee.selfLearningTool.equalsIgnoreCase(COREFLEXConstants.YES)) {
			CoreFunctions.clearAndSetText(driver, _inputMaxAmount,
					settlingInBenefitData.languageTrainingEmployee.maxAmount);
		}
		CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
				settlingInBenefitData.languageTrainingEmployee.grossUp, true);
		CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
				settlingInBenefitData.languageTrainingEmployee.reimbursedBy, true);
		if (settlingInBenefitData.languageTrainingEmployee.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
			CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
					settlingInBenefitData.languageTrainingEmployee.reimbursedByOther);
		}
		CoreFunctions.clearAndSetText(driver, _txtAreaComment, settlingInBenefitData.languageTrainingEmployee.comment);
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
	 * @param multipleBenefitSelection
	 * @param flexPoints
	 * @param benefitDescription
	 * @param benefitAllowanceAmount
	 * @param benefitDescription2
	 */
	private void selectBenefitTypeAndFillMandatoryFields(String benefitType, String multipleBenefitSelection,
			String flexPoints, String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription,
			String aireManagedService) {
		Benefit languageTrainingBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.LANGUAGE_TRAINING)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			fillManadatoryDetails(benefitType, multipleBenefitSelection,
					languageTrainingBenefit.getBenefitDisplayName(), languageTrainingBenefit.getBenefitAmount(),
					languageTrainingBenefit.getBenefitDesc(), aireManagedService);
			break;
		case COREFLEXConstants.FLEX:
			CoreFunctions.clickElement(driver, _textFlex);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputFlexPoints, flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, aireManagedService);
			break;
		case COREFLEXConstants.CORE_BENEFITS:
			CoreFunctions.clickElement(driver, _textCoreBenefits);
			fillManadatoryDetails(benefitType, multipleBenefitSelection,
					languageTrainingBenefit.getBenefitDisplayName(), languageTrainingBenefit.getBenefitAmount(),
					languageTrainingBenefit.getBenefitDesc(), aireManagedService);
			break;
		case COREFLEXConstants.FLEX_BENEFITS:
			CoreFunctions.clickElement(driver, _textFlexBenefits);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputFlexPoints, flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, aireManagedService);
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
	 * 
	 * @param multipleBenefitSelection
	 * @param benefitType
	 * @param benefitDescription
	 * @param benefitAllowanceAmount
	 * @param benefitDescription2
	 */
	private void fillManadatoryDetails(String benefitType, String multipleBenefitSelection, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String aireManagedService) {
		try {
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputBenefitName, benefitDisplayName,
					COREFLEXConstants.BENEFIT_DISPLAY_NAME);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaAllowanceAmountMessage, benefitAllowanceAmount,
					COREFLEXConstants.ALLOWANCE_AMOUNT_MESSAGE);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaBenefitLongDescription, benefitDescription,
					COREFLEXConstants.BENEFIT_LONG_DESCRIPTION);
			if ((benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) || (benefitType.equals(COREFLEXConstants.FLEX))) {
				if ((multipleBenefitSelection.equals(COREFLEXConstants.YES)))
					CoreFunctions.clickElement(driver, _inputMultiAddBenefit);
				CoreFunctions.selectItemInListByText(driver, _radioAiresManagedService, aireManagedService, true,
						COREFLEXConstants.AIRES_MANAGED_SERVICE);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FILLING_MANDATORY_FIELDS_OF_BENEFIT,
							CoreConstants.FAIL, e.getMessage(), benefitDisplayName));
		}
	}

	public boolean verifyAddedBenefitsAndSubBenefitDetails(String benefitType, String subBenefitNames,
			String multipleBenefitSelection, String flexPoints, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String paymentOption,
			String airesManagedService) {
		if (benefitType.equals(COREFLEXConstants.BOTH)) {
			CoreFunctions.clickElement(driver, _textBoth);
			verifyBenefitsMandatoryDetails(COREFLEXConstants.CORE_BENEFITS, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			iterateSubBenefitAndVerifyDetails(subBenefitNames, COREFLEXConstants.CORE_BENEFITS);
			verifyBenefitsMandatoryDetails(COREFLEXConstants.FLEX_BENEFITS, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			iterateSubBenefitAndVerifyDetails(subBenefitNames, COREFLEXConstants.FLEX_BENEFITS);
			return true;
		} else {
			verifyBenefitsMandatoryDetails(benefitType, multipleBenefitSelection, flexPoints, benefitDisplayName,
					benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			iterateSubBenefitAndVerifyDetails(subBenefitNames, benefitType);
			return true;
		}
	}
	
	private void verifyBenefitsMandatoryDetails(String benefitType, String multipleBenefitSelection, String flexPoints,
			String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription, String paymentOption,
			String airesManagedService) {
		Benefit languageTrainingBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.LANGUAGE_TRAINING)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection,
					languageTrainingBenefit.getBenefitDisplayName(), languageTrainingBenefit.getBenefitAmount(),
					languageTrainingBenefit.getBenefitDesc(), paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.FLEX:
			CoreFunctions.clickElement(driver, _textFlex);
			CoreFunctions.verifyText(_inputFlexPoints.getDomProperty("value"), flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			CoreFunctions.highlightObject(driver, _inputFlexPoints);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.CORE_BENEFITS:
			CoreFunctions.clickElement(driver, _textCoreBenefits);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection,
					languageTrainingBenefit.getBenefitDisplayName(), languageTrainingBenefit.getBenefitAmount(),
					languageTrainingBenefit.getBenefitDesc(), paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.FLEX_BENEFITS:
			CoreFunctions.clickElement(driver, _textFlexBenefits);
			CoreFunctions.verifyText(_inputFlexPoints.getDomProperty("value"), flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			CoreFunctions.highlightObject(driver, _inputFlexPoints);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.BOTH:
			CoreFunctions.clickElement(driver, _textBoth);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}

	}

	private void verifyManadatoryDetails(String benefitType, String multipleBenefitSelection, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String paymentOption,
			String airesManagedService) {
		if ((benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) || (benefitType.equals(COREFLEXConstants.FLEX))) {
			if ((multipleBenefitSelection.equals(COREFLEXConstants.YES))) {
				CoreFunctions.verifyRadioButtonSelection(driver, _inputMultiAddBenefitLabel,
						_inputMultiAddBenefitButton, COREFLEXConstants.BENEFIT_SELECTED_MORE_THAN_ONCE,
						COREFLEXConstants.MULTIPLE_BENEFIT_SELECTION);
			}
			CoreFunctions.verifyRadioButtonSelection(driver, _radioAiresManagedLabelList, _radioAiresManagedButtonList,
					airesManagedService, COREFLEXConstants.AIRES_MANAGED_SERVICE);
		}
		CoreFunctions.verifyText(_inputBenefitName.getDomProperty("value"), benefitDisplayName,
				COREFLEXConstants.BENEFIT_DISPLAY_NAME);
		CoreFunctions.highlightObject(driver, _inputBenefitName);
		CoreFunctions.verifyText(_textAreaAllowanceAmountMessage.getDomProperty("value"), benefitAllowanceAmount,
				COREFLEXConstants.ALLOWANCE_AMOUNT_MESSAGE);
		CoreFunctions.highlightObject(driver, _textAreaAllowanceAmountMessage);
		CoreFunctions.verifyText(_textAreaBenefitLongDescription.getDomProperty("value"), benefitDescription,
				COREFLEXConstants.BENEFIT_LONG_DESCRIPTION);
		CoreFunctions.highlightObject(driver, _textAreaBenefitLongDescription);
	}

	
	/**
	 * Method to iterate and verify mentioned SubBenefits details
	 * 
	 * @param subBenefitNames
	 * @param benefitType
	 */
	private void iterateSubBenefitAndVerifyDetails(String subBenefitNames, String benefitType) {
		try {
			List<String> subBenefitNamesList = new ArrayList<String>();
			if (subBenefitNames.contains(";"))
				subBenefitNamesList = Arrays.asList(subBenefitNames.split(";"));
			else
				subBenefitNamesList.add(subBenefitNames);

			for (String subBenefit : subBenefitNamesList) {
				if (CoreFunctions.isElementExist(driver, getElementByName(subBenefit.trim()), 5)) {
					verifySubBenefitDetails(subBenefit.trim(), benefitType);
				} else {
					Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.LANGUAGE_TRAINING_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.LANGUAGE_TRAINING_BENEFITS_PAGE));
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_VERIFYING_SUB_BENEFIT_DETAILS,
					CoreConstants.FAIL, e.getMessage()));
		}
	}
	
	
	
	/**
	 * Method to Expand and call SubBenefit Verification Method's
	 * 
	 * @param subBenefit
	 * @param benefitType
	 */
	private void verifySubBenefitDetails(String subBenefit, String benefitType) {
		switch (subBenefit) {
		case COREFLEXConstants.LANGUAGE_TRAINING_EMPLOYEE:			
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.LANGUAGE_TRAINING_EMPLOYEE));	
			if (benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) {
				CoreFunctions.clickElement(driver, _headerLanguageTrainingEmployee);
			}
			verifyLanguageTrainingEmployeeSubBenefitForm();
			break;
		case COREFLEXConstants.LANGUAGE_TRAINING_FAMILY:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.LANGUAGE_TRAINING_FAMILY));
			verifyLanguageTrainingFamilySubBenefitForm();
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to verify Language Training Family subBenefit form
	 */
	private void verifyLanguageTrainingFamilySubBenefitForm() {
		try {
			CoreFunctions.verifyText(_inputMaxNumOfHoursPerPerson.getDomProperty("value"),
					settlingInBenefitData.languageTrainingFamily.maxNumberOfHoursPerPerson,
					COREFLEXConstants.MAX_NUMBER_OF_HRS_PER_PERSON);
			CoreFunctions.highlightObject(driver, _inputMaxNumOfHoursPerPerson);
			CoreFunctions.verifyText(_inputMaxNumOfHours.getDomProperty("value"),
					settlingInBenefitData.languageTrainingFamily.maxNumberOfHoursPerFamily,
					COREFLEXConstants.MAX_NUMBER_OF_HRS_PER_FAMILY);
			CoreFunctions.highlightObject(driver, _inputMaxNumOfHours);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioBtnSelfLearningToolLabelList,
					_radioBtnSelfLearningToolButtonList, settlingInBenefitData.languageTrainingFamily.selfLearningTool,
					COREFLEXConstants.SELF_LEARNING_TOOL);
			if (settlingInBenefitData.languageTrainingFamily.selfLearningTool.equalsIgnoreCase(COREFLEXConstants.YES)) {
				CoreFunctions.verifyText(_inputMaxAmount.getDomProperty("value"),
						settlingInBenefitData.languageTrainingFamily.maxAmount, COREFLEXConstants.MAX_AMOUNT);
				CoreFunctions.highlightObject(driver, _inputMaxAmount);
			}
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					settlingInBenefitData.languageTrainingFamily.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					settlingInBenefitData.languageTrainingFamily.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (settlingInBenefitData.languageTrainingFamily.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						settlingInBenefitData.languageTrainingFamily.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					settlingInBenefitData.languageTrainingFamily.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);

		} catch (Exception e) {
			Assert.fail(COREFLEXConstants.FAILED_TO_VERIFY_LANGUAGE_TRAINING_SUB_BENEFITS_FORM);
		}
	}

	/**
	 * Method to verify Language Training Employee subBenefit form
	 */
	private void verifyLanguageTrainingEmployeeSubBenefitForm() {
		try {
			CoreFunctions.verifyText(_inputMaxNumOfHours.getDomProperty("value"),
					settlingInBenefitData.languageTrainingEmployee.maxNumberOfHours,
					COREFLEXConstants.MAX_NUMBER_OF_HRS);
			CoreFunctions.highlightObject(driver, _inputMaxNumOfHours);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioBtnSelfLearningToolLabelList,
					_radioBtnSelfLearningToolButtonList,
					settlingInBenefitData.languageTrainingEmployee.selfLearningTool,
					COREFLEXConstants.SELF_LEARNING_TOOL);
			if (settlingInBenefitData.languageTrainingEmployee.selfLearningTool
					.equalsIgnoreCase(COREFLEXConstants.YES)) {
				CoreFunctions.verifyText(_inputMaxAmount.getDomProperty("value"),
						settlingInBenefitData.languageTrainingEmployee.maxAmount, COREFLEXConstants.MAX_AMOUNT);
				CoreFunctions.highlightObject(driver, _inputMaxAmount);
			}
			CoreFunctions.verifyRadioButtonSelection(driver, _radioGrossUpLabelList, _radioGrossUpButtonList,
					settlingInBenefitData.languageTrainingEmployee.grossUp, COREFLEXConstants.GROSS_UP);
			CoreFunctions.verifyRadioButtonSelection(driver, _radioReimbursedByLabelList, _radioReimbursedByButtonList,
					settlingInBenefitData.languageTrainingEmployee.reimbursedBy, COREFLEXConstants.REIMBURSED_BY);
			if (settlingInBenefitData.languageTrainingEmployee.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.verifyText(_inputReimbursedBy.getDomProperty("value"),
						settlingInBenefitData.languageTrainingEmployee.reimbursedByOther,
						COREFLEXConstants.REIMBURSED_BY_OTHER);
				CoreFunctions.highlightObject(driver, _inputReimbursedBy);
			}
			CoreFunctions.verifyText(_txtAreaComment.getDomProperty("value"),
					settlingInBenefitData.languageTrainingEmployee.comment, COREFLEXConstants.COMMENT);
			CoreFunctions.highlightObject(driver, _txtAreaComment);
		} catch (Exception e) {
			Assert.fail(COREFLEXConstants.FAILED_TO_VERIFY_LANGUAGE_TRAINING_SUB_BENEFITS_FORM);
		}
	}
}
