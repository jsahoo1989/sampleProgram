package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_LanguageTrainingBenefit;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_LanguageTrainingPage extends PDT_SharedSubBenefitPage {

	public PDT_LanguageTrainingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;

	@FindBy(how = How.CSS, using = "app-employee input[formcontrolname='maxNumOfHours']")
	private WebElement _txtBoxMaxNumOfHours;

	@FindBy(how = How.XPATH, using = "//label[text()='Max. Number of Hours']")
	private WebElement _lblMaxNumOfHours;

	@FindBy(how = How.XPATH, using = "//app-employee//label[contains(text(),'Gross-Up')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioBtnLabelGrossUpEmp;

	@FindBy(how = How.XPATH, using = "//app-employee//label[contains(text(),'Reimbursed By')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioBtnLabelReimbursedByEmp;

	@FindBy(how = How.CSS, using = "#collapseOne1 input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForLangTrainingEmp;

	@FindBy(how = How.CSS, using = "#collapseOne1 textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForLangTrainingEmp;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numHoursPerPerson']")
	private WebElement _txtBoxMaxNumOfHoursPerPerson;

	@FindBy(how = How.CSS, using = "app-family input[formcontrolname='maxNumOfHours']")
	private WebElement _txtBoxMaxNumOfHoursForLangTrainingFamily;

	@FindBy(how = How.XPATH, using = "//app-family//label[contains(text(),'Gross-Up')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioBtnLabelGrossUpFamily;

	@FindBy(how = How.XPATH, using = "//app-family//label[contains(text(),'Reimbursed By')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioBtnLabelReimbByFamily;

	@FindBy(how = How.CSS, using = "#collapseTwo input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForLangTrainingFamily;

	@FindBy(how = How.CSS, using = "#collapseTwo textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForLangTrainingFamily;

	@FindBy(how = How.XPATH, using = "//label[text()='Max. Number of Hours per Person ']")
	private WebElement _lblMaxNumOfHoursPerPerson;

	@FindBy(how = How.XPATH, using = "//label[text()='Max. Number of Hours per Family ']")
	private WebElement _lblMaxNumOfHoursPerFamily;

	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _formHeaderLanguageTrainingEmployee;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHeaderLanguageTrainingFamily;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='languageTrainingEmployeeExpenseCodeList']")
	private WebElement _drpDownLangTrainEmpExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='languageTrainingEmployeeExpenseCodeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownOptionsLangTrainEmpExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='languageTrainingEmployeeExpenseCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownSelectedOptionsLangTrainEmpExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='languageTrainingFamilyExpenseCodeList']")
	private WebElement _drpDownLangTrainFamilyExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='languageTrainingFamilyExpenseCodeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownOptionsLangTrainFamilyExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='languageTrainingFamilyExpenseCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownSelectedOptionsLangTrainFamilyExpenseCode;

	@FindBy(how = How.CSS, using = "#collapseOne1 input[formcontrolname='grossedUpInd']")
	private List<WebElement> _radioBtnGrossUpLangTrainEmp;

	@FindBy(how = How.CSS, using = "#collapseOne1 input[formcontrolname='paidByCode']")
	private List<WebElement> _radioBtnReimbByLangTrainEmp;

	@FindBy(how = How.CSS, using = "#collapseTwo input[formcontrolname='grossedUpInd']")
	private List<WebElement> _radioBtnGrossUpLangTrainFam;

	@FindBy(how = How.CSS, using = "#collapseTwo input[formcontrolname='paidByCode']")
	private List<WebElement> _radioBtnReimbByLangTrainFam;

	PDT_LanguageTrainingBenefit languageTrainingBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getLanguageTrainingDataList("Language Training");

	private ArrayList<String> _expenseCodeLangTrainEmp = null;
	private ArrayList<String> _expenseCodeLangTrainFamily = null;

	public void setExpenseCodeLangTrainEmp(ArrayList<String> expenseCode) {
		this._expenseCodeLangTrainEmp = expenseCode;
	}

	public ArrayList<String> getExpenseCodeLangTrainEmp() {
		return _expenseCodeLangTrainEmp;
	}

	public void setExpenseCodeLangTrainFamily(ArrayList<String> expenseCode) {
		this._expenseCodeLangTrainFamily = expenseCode;
	}

	public ArrayList<String> getExpenseCodeLangTrainFamily() {
		return _expenseCodeLangTrainFamily;
	}

	/**
	 * Add the Form Header of Language Training Employee & Language Training Family
	 * in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.LANGUAGE_TRAINING_EMPLOYEE, _formHeaderLanguageTrainingEmployee);
		subBenefitHeaderMap.put(PDTConstants.LANGUAGE_TRAINING_FAMILY, _formHeaderLanguageTrainingFamily);
	}

	/**
	 * Fill Language Training Employee Sub-benefit form.
	 * 
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param subBenefitPage
	 * @param pageName
	 */
	public void fillLanguageTrainingEmployee(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			PDT_SharedSubBenefitPage subBenefitPage, String pageName, PDT_GeneralInformationPage generalInfoPage,
			PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName),
					subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxMaxNumOfHours, _lblMaxNumOfHours.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxNumOfHours, _lblMaxNumOfHours.getText(),
					languageTrainingBenefitData.languageTrainingEmployee.maxNumOfHours);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnLabelGrossUpEmp);
			if (CoreFunctions.getPropertyFromConfig("expenseMgmt").equalsIgnoreCase("Yes")) {
				BusinessFunctions.verifyDefaultSelectedRadioButtonForField(driver, _radioBtnLabelGrossUpEmp,
						_radioBtnGrossUpLangTrainEmp, PDTConstants.GROSS_UP, generalInfoPage.getGrossUp(),
						generalInfoPage, sharedSubBenefitStep);
				BusinessFunctions.verifyDefaultSelectedRadioButtonForField(driver, _radioBtnLabelReimbursedByEmp,
						_radioBtnReimbByLangTrainEmp, PDTConstants.REIMBURSED_BY, generalInfoPage.getReimbursedBy(),
						generalInfoPage, sharedSubBenefitStep);
			}
			if (subBenefitPage.getCompletePolicyState())
				CoreFunctions.selectItemInListByText(driver, _radioBtnLabelGrossUpEmp,
						languageTrainingBenefitData.languageTrainingEmployee.grossUp, PDTConstants.GROSS_UP,
						PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnLabelReimbursedByEmp,
					languageTrainingBenefitData.languageTrainingEmployee.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					languageTrainingBenefitData.languageTrainingEmployee.reimbursedBy,
					_txtBoxReimbursedByOtherForLangTrainingEmp,
					languageTrainingBenefitData.languageTrainingEmployee.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForLangTrainingEmp, PDTConstants.COMMENT,
					languageTrainingBenefitData.languageTrainingEmployee.comments);

			CoreFunctions.clickElement(driver, _drpDownLangTrainEmpExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.LANGUAGE_TRAINING, PDTConstants.LANGUAGE_TRAINING_EMPLOYEE,
							_drpDownOptionsLangTrainEmpExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.LANGUAGE_TRAINING_EMPLOYEE,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.LANGUAGE_TRAINING).toString(),
							CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsLangTrainEmpExpenseCode)
									.toString()));
			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptionsLangTrainEmpExpenseCode.size(), 3, driver, _drpDownOptionsLangTrainEmpExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES,
					_drpDownLangTrainEmpExpenseCode, _drpDownOptionsLangTrainEmpExpenseCode,
					_drpDownSelectedOptionsLangTrainEmpExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeLangTrainEmp(randExpenseCodeOptions);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Fill Language Training Family Sub-benefit form.
	 * 
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param subBenefitPage
	 * @param pageName
	 */
	public void fillLanguageTrainingFamily(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			PDT_SharedSubBenefitPage subBenefitPage, String pageName, PDT_GeneralInformationPage generalInfoPage,
			PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName),
					subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxMaxNumOfHoursPerPerson,
					_lblMaxNumOfHoursPerPerson.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxNumOfHoursPerPerson, _lblMaxNumOfHoursPerPerson.getText(),
					languageTrainingBenefitData.languageTrainingFamily.maxNumOfHrsPerPerson);
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxNumOfHoursForLangTrainingFamily,
					_lblMaxNumOfHoursPerFamily.getText(),
					languageTrainingBenefitData.languageTrainingFamily.maxNumOfHrsPerFamily);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnLabelGrossUpFamily);
			if (CoreFunctions.getPropertyFromConfig("expenseMgmt").equalsIgnoreCase("Yes")) {
				BusinessFunctions.verifyDefaultSelectedRadioButtonForField(driver, _radioBtnLabelGrossUpFamily,
						_radioBtnGrossUpLangTrainFam, PDTConstants.GROSS_UP, generalInfoPage.getGrossUp(),
						generalInfoPage, sharedSubBenefitStep);
				BusinessFunctions.verifyDefaultSelectedRadioButtonForField(driver, _radioBtnLabelReimbByFamily,
						_radioBtnReimbByLangTrainFam, PDTConstants.REIMBURSED_BY, generalInfoPage.getReimbursedBy(),
						generalInfoPage, sharedSubBenefitStep);
			}
			if (subBenefitPage.getCompletePolicyState())
				CoreFunctions.selectItemInListByText(driver, _radioBtnLabelGrossUpFamily,
						languageTrainingBenefitData.languageTrainingFamily.grossUp, PDTConstants.GROSS_UP,
						PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnLabelReimbByFamily,
					languageTrainingBenefitData.languageTrainingFamily.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					languageTrainingBenefitData.languageTrainingFamily.reimbursedBy,
					_txtBoxReimbursedByOtherForLangTrainingFamily,
					languageTrainingBenefitData.languageTrainingFamily.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForLangTrainingFamily, PDTConstants.COMMENT,
					languageTrainingBenefitData.languageTrainingFamily.comments);

			CoreFunctions.clickElement(driver, _drpDownLangTrainFamilyExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.LANGUAGE_TRAINING, PDTConstants.LANGUAGE_TRAINING_FAMILY,
							_drpDownOptionsLangTrainFamilyExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.LANGUAGE_TRAINING_FAMILY,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.LANGUAGE_TRAINING).toString(),
							CoreFunctions
									.getElementTextAndStoreInList(driver, _drpDownOptionsLangTrainFamilyExpenseCode)
									.toString()));
			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptionsLangTrainFamilyExpenseCode.size(), 3, driver,
					_drpDownOptionsLangTrainFamilyExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES,
					_drpDownLangTrainFamilyExpenseCode, _drpDownOptionsLangTrainFamilyExpenseCode,
					_drpDownSelectedOptionsLangTrainFamilyExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeLangTrainFamily(randExpenseCodeOptions);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Fill Language Training Sub-benefit form depending on sub-benefit name.
	 * 
	 * @param subBenefit
	 * @param pageName
	 * @param addNewPolicyPage
	 * @param subBenefitPage
	 */
	public void fillLanguageTrainingSubBenefit(String subBenefit, String pageName,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage subBenefitPage,
			PDT_GeneralInformationPage generalInfoPage, PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		switch (subBenefit) {
		case PDTConstants.LANGUAGE_TRAINING_EMPLOYEE:
			fillLanguageTrainingEmployee(addNewPolicyPage, subBenefit, subBenefitPage, pageName, generalInfoPage,
					sharedSubBenefitStep);
			break;
		case PDTConstants.LANGUAGE_TRAINING_FAMILY:
			fillLanguageTrainingFamily(addNewPolicyPage, subBenefit, subBenefitPage, pageName, generalInfoPage,
					sharedSubBenefitStep);
			break;
		default:
			Assert.fail(
					MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}
	}

	/**
	 * Iterate Language Training sub-benefits and fill their corresponding form.
	 * 
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage
	 */
	public void iterateAndFillLanguageTrainingSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName,
			PDT_SharedSubBenefitPage subBenefitPage, PDT_GeneralInformationPage generalInfoPage) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		WebElement btnToClick = (btnName != null) ? buttonMap.get(btnName) : buttonMap.get(PDTConstants.SAVE);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			waitForProgressBarToDisapper();
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillLanguageTrainingSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage, generalInfoPage,
					objStep);
		}
		try {
			CoreFunctions.click(driver, btnToClick, btnToClick.getText());
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}

	public boolean verifyGrossUpForLangTrainEmployee() {
		return BusinessFunctions.verifyRadioButtonIsSelected(driver, _radioBtnLabelGrossUpEmp,
				_radioBtnGrossUpLangTrainEmp, languageTrainingBenefitData.languageTrainingEmployee.grossUp,
				PDTConstants.GROSS_UP, PDTConstants.SUBMITTED);
	}

	public boolean verifyReimbursedByForLangTrainEmpolyee() {
		return BusinessFunctions.verifyRadioButtonIsSelected(driver, _radioBtnLabelReimbursedByEmp,
				_radioBtnReimbByLangTrainEmp, languageTrainingBenefitData.languageTrainingEmployee.reimbursedBy,
				PDTConstants.REIMBURSED_BY, PDTConstants.SUBMITTED);
	}

	public boolean verifyGrossUpAndReimbursedByForEmployee(String pageName, String subBenefitFormName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(
				BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
						subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName,
				driver);
		if (verifyGrossUpForLangTrainEmployee() && verifyReimbursedByForLangTrainEmpolyee())
			return true;
		else
			return false;
	}

	public boolean verifyGrossUpForLangTrainFamily() {
		return BusinessFunctions.verifyRadioButtonIsSelected(driver, _radioBtnLabelGrossUpFamily,
				_radioBtnGrossUpLangTrainFam, languageTrainingBenefitData.languageTrainingFamily.grossUp,
				PDTConstants.GROSS_UP, PDTConstants.SUBMITTED);
	}

	public boolean verifyReimbursedByForLangTrainFamily() {
		return BusinessFunctions.verifyRadioButtonIsSelected(driver, _radioBtnLabelReimbByFamily,
				_radioBtnReimbByLangTrainFam, languageTrainingBenefitData.languageTrainingFamily.reimbursedBy,
				PDTConstants.REIMBURSED_BY, PDTConstants.SUBMITTED);
	}

	public boolean verifyGrossUpAndReimbursedByForFamily(String pageName, String subBenefitFormName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(
				BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
						subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName,
				driver);
		if (verifyGrossUpForLangTrainFamily() && verifyReimbursedByForLangTrainFamily())
			return true;
		else
			return false;
	}
}
