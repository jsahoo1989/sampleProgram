package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
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
import com.aires.testdatatypes.pdt.PDT_CulturalTrainingBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_CulturalTrainingPage extends PDT_SharedSubBenefitPage {
	public PDT_CulturalTrainingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeNoOfDays']")
	private WebElement _drpDownEmployeNumOfDays;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeNoOfDays'] div.ng-option")
	private List<WebElement> _drpDownEmployeNumOfDaysOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeNoOfDays'] div.ng-value")
	private WebElement _drpDownEmployeeNumOfDaysOptionSelected;

	@FindBy(how = How.CSS, using = "input[formcontrolname='employeeNoOfDaysOther']")
	private WebElement _txtBoxEmpNumOfDaysOther;

	@FindBy(how = How.XPATH, using = "//app-cultural-employee//label[text()='Number of Days']")
	private WebElement _lblNumOfDaysForEmployee;

	@FindBy(how = How.XPATH, using = "//div[@id='collapseOne1']//child::label[text()='Other Number of Days']")
	private WebElement _lblOtherNumOfDaysForEmploye;

	@FindBy(how = How.XPATH, using = "//app-cultural-employee//label[contains(text(),'Gross-Up')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioBtnLblGrossUpEmp;

	@FindBy(how = How.XPATH, using = "//app-cultural-employee//label[contains(text(),'Reimbursed By')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioBtnLblReimbByEmp;

	@FindBy(how = How.CSS, using = "#collapseOne1 input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForCultTrainingEmp;

	@FindBy(how = How.CSS, using = "#collapseOne1 textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForCultTrainingEmp;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='familyNoOfDays']")
	private WebElement _drpDownFamilyNumOfDays;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='familyNoOfDays'] div.ng-option")
	private List<WebElement> _drpDownFamilyNumOfDaysOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='familyNoOfDays'] div.ng-value")
	private WebElement _drpDownFamilyNumOfDaysOptionSelected;

	@FindBy(how = How.CSS, using = "input[formcontrolname='familyNoOfDaysOther']")
	private WebElement _txtBoxFamilyNumOfDaysOther;

	@FindBy(how = How.XPATH, using = "//app-cultural-family//label[contains(text(),'Gross-Up')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioBtnLblGrossUpFamily;

	@FindBy(how = How.XPATH, using = "//app-cultural-family//label[contains(text(),'Reimbursed By')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioBtnLblReimbursedByFamily;

	@FindBy(how = How.CSS, using = "#collapseTwo input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForCultTrainingFamily;

	@FindBy(how = How.CSS, using = "#collapseTwo textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForCultTrainingFamily;

	@FindBy(how = How.XPATH, using = "//div[@id='collapseTwo']//child::label[text()='Number of Days']")
	private WebElement _lblNumOfDaysForFamily;

	@FindBy(how = How.XPATH, using = "//div[@id='collapseTwo']//child::label[text()='Other Number of Days']")
	private WebElement _lblOtherNumOfDaysForFamily;

	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _formHeaderCulturalTrainingEmployee;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHeaderCulturalTrainingFamily;

	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='culturalTrainingEmployeeExpenseCodeList']")
	private WebElement _drpDownCultTrainEmpExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='culturalTrainingEmployeeExpenseCodeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownOptionsCultTrainEmpExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='culturalTrainingEmployeeExpenseCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownSelectedOptionsCultTrainEmpExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='culturalTrainingFamilyExpenseCodeList']")
	private WebElement _drpDownCultTrainFamilyExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='culturalTrainingFamilyExpenseCodeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownOptionsCultTrainFamilyExpenseCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='culturalTrainingFamilyExpenseCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownSelectedOptionsCultTrainFamilyExpenseCode;

	@FindBy(how = How.CSS, using = "#collapseOne1 input[formcontrolname='grossedUpInd']")
	private List<WebElement> _radioBtnCulTrainEmployee;

	@FindBy(how = How.CSS, using = "#collapseTwo input[formcontrolname='paidByCode']")
	private List<WebElement> _radioBtnCulTrainFamily;

	PDT_CulturalTrainingBenefit culturalTrainingBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getCulturalTrainingDataList("Cultural Training");

	String numOfDaysForEmp, numOfDaysForFamily, grossUpEmp, grossUpFamily, reimbursedByEmp, reimbursedByFamily;
	LinkedHashMap<String, WebElement> subBenefitHeaderMap = new LinkedHashMap<String, WebElement>();
	private ArrayList<String> _expenseCodeCultTrainEmp = null;
	private ArrayList<String> _expenseCodeCultTrainFamily = null;

	public void setNumOfDayForEmployee(String numOfDays) {
		numOfDaysForEmp = numOfDays;
	}

	public String getNumOfDaysForEmp() {
		return numOfDaysForEmp;
	}

	public void setNumOfDayForFamily(String numOfDays) {
		numOfDaysForFamily = numOfDays;
	}

	public String getNumOfDaysForFamily() {
		return numOfDaysForFamily;
	}

	public void setExpenseCodeCultTrainEmp(ArrayList<String> expenseCode) {
		this._expenseCodeCultTrainEmp = expenseCode;
	}

	public ArrayList<String> getExpenseCodeCultTrainEmp() {
		return _expenseCodeCultTrainEmp;
	}

	public void setExpenseCodeCultTrainFamily(ArrayList<String> expenseCode) {
		this._expenseCodeCultTrainFamily = expenseCode;
	}

	public ArrayList<String> getExpenseCodeCultTrainFamily() {
		return _expenseCodeCultTrainFamily;
	}

	public void setGrossUpEmp(String grossUp) {
		grossUpEmp = grossUp;
	}

	public String getGrossUpEmp() {
		return grossUpEmp;
	}

	public void setReimbursedByEmp(String reimbursedBy) {
		reimbursedByEmp = reimbursedBy;
	}

	public String getReimbursedByEmp() {
		return reimbursedByEmp;
	}

	public void setGrossUpFamily(String grossUp) {
		grossUpFamily = grossUp;
	}

	public String getGrossUpFamily() {
		return grossUpEmp;
	}

	public void setReimbursedByFamily(String reimbursedBy) {
		reimbursedByFamily = reimbursedBy;
	}

	public String getReimbursedByFamily() {
		return reimbursedByFamily;
	}

	/**
	 * Add the Form Header of Cultural Training Employee & Cultural Training Family
	 * in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.CULTURAL_TRAINING_EMPLOYEE, _formHeaderCulturalTrainingEmployee);
		subBenefitHeaderMap.put(PDTConstants.CULTURAL_TRAINING_FAMILY, _formHeaderCulturalTrainingFamily);
	}

	/**
	 * Fill Cultural Training Employee form.
	 * 
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param sharedSubBenefitPage
	 * @param pageName
	 */
	public void fillCulturalTrainingEmployee(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			PDT_SharedSubBenefitPage sharedSubBenefitPage, String pageName, PDT_GeneralInformationPage generalInfoPage,
			PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName),
					subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblNumOfDaysForEmployee,
					_lblNumOfDaysForEmployee.getText());
			CoreFunctions.clickElement(driver, _drpDownEmployeNumOfDays);
			String randNumOfDayForEmp = _drpDownEmployeNumOfDaysOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownEmployeNumOfDaysOptions.size() - 1)).getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownEmployeNumOfDaysOptions, randNumOfDayForEmp,
					_lblNumOfDaysForEmployee.getText(), PDTConstants.DROP_DOWN, true);
			setNumOfDayForEmployee(randNumOfDayForEmp);
			if (_drpDownEmployeeNumOfDaysOptionSelected.getText().equalsIgnoreCase(PDTConstants.OTHER)
					&& CoreFunctions.isElementExist(driver, _txtBoxEmpNumOfDaysOther, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblOtherNumOfDaysForEmploye.getText(), subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxEmpNumOfDaysOther);
				CoreFunctions.clearAndSetText(driver, _txtBoxEmpNumOfDaysOther, _lblOtherNumOfDaysForEmploye.getText(),
						culturalTrainingBenefitData.culturalTrainingEmployee.otherNumberOfDays);
			}

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnLblGrossUpEmp);
			BusinessFunctions.verifyDefaultSelectedRadioButtonForField(driver, _radioBtnLblGrossUpEmp,
					_radioBtnCulTrainEmployee, PDTConstants.GROSS_UP, generalInfoPage.getGrossUp(), generalInfoPage,
					sharedSubBenefitStep);
			BusinessFunctions.verifyDefaultSelectedRadioButtonForField(driver, _radioBtnLblReimbByEmp,
					_radioBtnCulTrainEmployee, PDTConstants.REIMBURSED_BY, generalInfoPage.getReimbursedBy(),
					generalInfoPage, sharedSubBenefitStep);
			if (sharedSubBenefitPage.getCompletePolicyState())
				CoreFunctions.selectItemInListByText(driver, _radioBtnLblGrossUpEmp,
						culturalTrainingBenefitData.culturalTrainingEmployee.grossUp, PDTConstants.GROSS_UP,
						PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnLblReimbByEmp,
					culturalTrainingBenefitData.culturalTrainingEmployee.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					culturalTrainingBenefitData.culturalTrainingEmployee.reimbursedBy,
					_txtBoxReimbursedByOtherForCultTrainingEmp,
					culturalTrainingBenefitData.culturalTrainingEmployee.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForCultTrainingEmp, PDTConstants.COMMENT,
					culturalTrainingBenefitData.culturalTrainingEmployee.comments);

			CoreFunctions.clickElement(driver, _drpDownCultTrainEmpExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.CULTURAL_TRAINING, PDTConstants.CULTURAL_TRAINING_EMPLOYEE,
							_drpDownOptionsCultTrainEmpExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.CULTURAL_TRAINING_EMPLOYEE,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.CULTURAL_TRAINING).toString(),
							CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsCultTrainEmpExpenseCode)
									.toString()));

			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptionsCultTrainEmpExpenseCode.size(), 3, driver, _drpDownOptionsCultTrainEmpExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES,
					_drpDownCultTrainEmpExpenseCode, _drpDownOptionsCultTrainEmpExpenseCode,
					_drpDownSelectedOptionsCultTrainEmpExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeCultTrainEmp(randExpenseCodeOptions);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Fill Cultural Training Family Form
	 * 
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param sharedSubBenefitPage
	 * @param pageName
	 */
	public void fillCulturalTrainingFamily(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,
			PDT_SharedSubBenefitPage sharedSubBenefitPage, String pageName, PDT_GeneralInformationPage generalInfoPage,
			PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(
					BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
							subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName),
					subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblNumOfDaysForFamily,
					_lblNumOfDaysForFamily.getText());
			CoreFunctions.clickElement(driver, _drpDownFamilyNumOfDays);
			String randNumOfDayForFamily = _drpDownFamilyNumOfDaysOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownFamilyNumOfDaysOptions.size() - 1)).getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownFamilyNumOfDaysOptions, randNumOfDayForFamily,
					_lblNumOfDaysForFamily.getText(), PDTConstants.DROP_DOWN, true);
			setNumOfDayForFamily(randNumOfDayForFamily);
			if (_drpDownFamilyNumOfDaysOptionSelected.getText().equalsIgnoreCase(PDTConstants.OTHER)
					&& CoreFunctions.isElementExist(driver, _txtBoxFamilyNumOfDaysOther, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblOtherNumOfDaysForFamily.getText(), subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxFamilyNumOfDaysOther);
				CoreFunctions.clearAndSetText(driver, _txtBoxFamilyNumOfDaysOther,
						_lblOtherNumOfDaysForFamily.getText(),
						culturalTrainingBenefitData.culturalTrainingFamily.otherNumberOfDays);
			}

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnLblGrossUpFamily);
			BusinessFunctions.verifyDefaultSelectedRadioButtonForField(driver, _radioBtnLblGrossUpFamily,
					_radioBtnCulTrainFamily, PDTConstants.GROSS_UP, generalInfoPage.getGrossUp(), generalInfoPage,
					sharedSubBenefitStep);
			BusinessFunctions.verifyDefaultSelectedRadioButtonForField(driver, _radioBtnLblReimbursedByFamily,
					_radioBtnCulTrainFamily, PDTConstants.REIMBURSED_BY, generalInfoPage.getReimbursedBy(),
					generalInfoPage, sharedSubBenefitStep);
			if (sharedSubBenefitPage.getCompletePolicyState())
				CoreFunctions.selectItemInListByText(driver, _radioBtnLblGrossUpFamily,
						culturalTrainingBenefitData.culturalTrainingFamily.grossUp, PDTConstants.GROSS_UP,
						PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnLblReimbursedByFamily,
					culturalTrainingBenefitData.culturalTrainingFamily.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					culturalTrainingBenefitData.culturalTrainingFamily.reimbursedBy,
					_txtBoxReimbursedByOtherForCultTrainingFamily,
					culturalTrainingBenefitData.culturalTrainingFamily.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForCultTrainingFamily, PDTConstants.COMMENT,
					culturalTrainingBenefitData.culturalTrainingFamily.comments);

			CoreFunctions.clickElement(driver, _drpDownCultTrainFamilyExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.CULTURAL_TRAINING, PDTConstants.CULTURAL_TRAINING_FAMILY,
							_drpDownOptionsCultTrainFamilyExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.CULTURAL_TRAINING_FAMILY,
							DbFunctions.getExpenseCodeListForBenefit(PDTConstants.CULTURAL_TRAINING).toString(),
							CoreFunctions
									.getElementTextAndStoreInList(driver, _drpDownOptionsCultTrainFamilyExpenseCode)
									.toString()));
			ArrayList<String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptionsCultTrainFamilyExpenseCode.size(), 3, driver,
					_drpDownOptionsCultTrainFamilyExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES,
					_drpDownCultTrainFamilyExpenseCode, _drpDownOptionsCultTrainFamilyExpenseCode,
					_drpDownSelectedOptionsCultTrainFamilyExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeCultTrainFamily(randExpenseCodeOptions);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	/**
	 * Fill Cultural Training sub-benefit based on sub-benefit name
	 * 
	 * @param subBenefit
	 * @param pageName
	 * @param addNewPolicyPage
	 * @param sharedSubBenefitPage
	 */
	public void fillCulturalTrainingSubBenefit(String subBenefit, String pageName,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage sharedSubBenefitPage,
			PDT_GeneralInformationPage generalInfoPage, PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		switch (subBenefit) {
		case PDTConstants.CULTURAL_TRAINING_EMPLOYEE:
			fillCulturalTrainingEmployee(addNewPolicyPage, subBenefit, sharedSubBenefitPage, pageName, generalInfoPage,
					sharedSubBenefitStep);
			break;
		case PDTConstants.CULTURAL_TRAINING_FAMILY:
			fillCulturalTrainingFamily(addNewPolicyPage, subBenefit, sharedSubBenefitPage, pageName, generalInfoPage,
					sharedSubBenefitStep);
			break;
		default:
			Assert.fail(
					MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}
	}

	/**
	 * Iterate Cultural Training sub-benefits and fill their corresponding form.
	 * 
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage
	 */
	public void iterateAndFillCulturalTrainingSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName,
			PDT_SharedSubBenefitPage subBenefitPage, PDT_GeneralInformationPage generalInfoPage) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		// WebElement btnToClick = (btnName != null) ? buttonMap.get(btnName) :
		// buttonMap.get(PDTConstants.SAVE);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillCulturalTrainingSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage, generalInfoPage,
					objStep);
		}
		try {
			if (btnName != null)
				CoreFunctions.click(driver, buttonMap.get(btnName), buttonMap.get(btnName).getText());
			// CoreFunctions.click(driver, btnToClick, btnToClick.getText());

		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}

	public boolean verifyGrossUpForCultTrainEmployee() {
		return BusinessFunctions.verifyRadioButtonIsSelected(driver, _radioBtnLblGrossUpEmp, _radioBtnCulTrainEmployee,
				culturalTrainingBenefitData.culturalTrainingEmployee.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.SUBMITTED);
	}

	public boolean verifyReimbursedByForCultTrainEmpolyee() {
		return BusinessFunctions.verifyRadioButtonIsSelected(driver, _radioBtnLblReimbByEmp, _radioBtnCulTrainEmployee,
				culturalTrainingBenefitData.culturalTrainingFamily.reimbursedBy, PDTConstants.REIMBURSED_BY,
				PDTConstants.SUBMITTED);
	}

	public boolean verifyGrossUpAndReimbursedByForEmployee(String pageName, String subBenefitFormName) {
		populateSubBenefitHeaderMap();
		Assert.assertTrue(
				BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver,
						subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
				MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
		BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName,
				driver);
		if (verifyGrossUpForCultTrainEmployee() && verifyReimbursedByForCultTrainEmpolyee())
			return true;
		else
			return false;
	}

	public boolean verifyGrossUpForCultTrainFamily() {
		return BusinessFunctions.verifyRadioButtonIsSelected(driver, _radioBtnLblGrossUpFamily, _radioBtnCulTrainFamily,
				culturalTrainingBenefitData.culturalTrainingFamily.grossUp, PDTConstants.GROSS_UP,
				PDTConstants.SUBMITTED);
	}

	public boolean verifyReimbursedByForCultTrainFamily() {
		return BusinessFunctions.verifyRadioButtonIsSelected(driver, _radioBtnLblReimbursedByFamily,
				_radioBtnCulTrainFamily, culturalTrainingBenefitData.culturalTrainingFamily.reimbursedBy,
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
		if (verifyGrossUpForCultTrainFamily() && verifyReimbursedByForCultTrainFamily())
			return true;
		else
			return false;
	}

}
