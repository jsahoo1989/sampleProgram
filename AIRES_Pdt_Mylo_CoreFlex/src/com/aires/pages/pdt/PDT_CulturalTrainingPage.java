package com.aires.pages.pdt;

import java.text.MessageFormat;
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

	@FindBy(how = How.CSS, using = "#collapseOne1 label.form-check-label")
	private List<WebElement> _radioBtnLangCulTrainEmployee;

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
	
	@FindBy(how = How.CSS, using = "#collapseTwo label.form-check-label")
	private List<WebElement> _radioBtnCultTrainingFamily;

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
	
	PDT_CulturalTrainingBenefit culturalTrainingBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getCulturalTrainingDataList("Cultural Training");
	
	String numOfDaysForEmp, numOfDaysForFamily;
	LinkedHashMap<String, WebElement> subBenefitHeaderMap = new LinkedHashMap<String, WebElement>();
	
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
	
	/**
	 * Add the Form Header of Cultural Training Employee & Cultural Training Family in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.CULTURAL_TRAINING_EMPLOYEE, _formHeaderCulturalTrainingEmployee);
		subBenefitHeaderMap.put(PDTConstants.CULTURAL_TRAINING_FAMILY, _formHeaderCulturalTrainingFamily);
	}
	
	/**
	 * Fill Cultural Training Employee form.
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param sharedSubBenefitPage
	 * @param pageName
	 */
	public void fillCulturalTrainingEmployee(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, PDT_SharedSubBenefitPage sharedSubBenefitPage, String pageName) {
		try {	
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblNumOfDaysForEmployee, _lblNumOfDaysForEmployee.getText());
			CoreFunctions.clickElement(driver, _drpDownEmployeNumOfDays);
			String randNumOfDayForEmp = _drpDownEmployeNumOfDaysOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownEmployeNumOfDaysOptions.size() - 1))
					.getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownEmployeNumOfDaysOptions,
					randNumOfDayForEmp, _lblNumOfDaysForEmployee.getText(), PDTConstants.DROP_DOWN, true);
			setNumOfDayForEmployee(randNumOfDayForEmp);
			if (_drpDownEmployeeNumOfDaysOptionSelected.getText().equalsIgnoreCase(PDTConstants.OTHER) && CoreFunctions.isElementExist(driver, _txtBoxEmpNumOfDaysOther, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblOtherNumOfDaysForEmploye.getText(), subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxEmpNumOfDaysOther);
				CoreFunctions.clearAndSetText(driver, _txtBoxEmpNumOfDaysOther, _lblOtherNumOfDaysForEmploye.getText(),
						culturalTrainingBenefitData.culturalTrainingEmployee.otherNumberOfDays);
			}

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnLangCulTrainEmployee);
			if(sharedSubBenefitPage.getCompletePolicyState())
			CoreFunctions.selectItemInListByText(driver, _radioBtnLangCulTrainEmployee,
					culturalTrainingBenefitData.culturalTrainingEmployee.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnLangCulTrainEmployee,
					culturalTrainingBenefitData.culturalTrainingEmployee.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,	culturalTrainingBenefitData.culturalTrainingEmployee.reimbursedBy,
					_txtBoxReimbursedByOtherForCultTrainingEmp,
					culturalTrainingBenefitData.culturalTrainingEmployee.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForCultTrainingEmp, PDTConstants.COMMENT,
					culturalTrainingBenefitData.culturalTrainingEmployee.comments);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	/**
	 * Fill Cultural Training Family Form
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param sharedSubBenefitPage
	 * @param pageName
	 */
	public void fillCulturalTrainingFamily(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName,  PDT_SharedSubBenefitPage sharedSubBenefitPage, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblNumOfDaysForFamily, _lblNumOfDaysForFamily.getText());
			CoreFunctions.clickElement(driver, _drpDownFamilyNumOfDays);
			String randNumOfDayForFamily = _drpDownFamilyNumOfDaysOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownFamilyNumOfDaysOptions.size() - 1))
					.getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownFamilyNumOfDaysOptions,
					randNumOfDayForFamily, _lblNumOfDaysForFamily.getText(), PDTConstants.DROP_DOWN, true);
			setNumOfDayForFamily(randNumOfDayForFamily);
			if (_drpDownFamilyNumOfDaysOptionSelected.getText().equalsIgnoreCase(PDTConstants.OTHER) && CoreFunctions.isElementExist(driver, _txtBoxFamilyNumOfDaysOther, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblOtherNumOfDaysForFamily.getText(), subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxFamilyNumOfDaysOther);
				CoreFunctions.clearAndSetText(driver, _txtBoxFamilyNumOfDaysOther, _lblOtherNumOfDaysForFamily.getText(),
						culturalTrainingBenefitData.culturalTrainingFamily.otherNumberOfDays);
			}

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnCultTrainingFamily);
			if(sharedSubBenefitPage.getCompletePolicyState())
			CoreFunctions.selectItemInListByText(driver, _radioBtnCultTrainingFamily,
					culturalTrainingBenefitData.culturalTrainingFamily.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCultTrainingFamily,
					culturalTrainingBenefitData.culturalTrainingFamily.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					culturalTrainingBenefitData.culturalTrainingFamily.reimbursedBy,
					_txtBoxReimbursedByOtherForCultTrainingFamily,
					culturalTrainingBenefitData.culturalTrainingFamily.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForCultTrainingFamily, PDTConstants.COMMENT,
					culturalTrainingBenefitData.culturalTrainingFamily.comments);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	/**
	 * Fill Cultural Training sub-benefit based on sub-benefit name 
	 * @param subBenefit
	 * @param pageName
	 * @param addNewPolicyPage
	 * @param sharedSubBenefitPage
	 */
	public void fillCulturalTrainingSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage sharedSubBenefitPage) {		
		switch (subBenefit) {
		case PDTConstants.CULTURAL_TRAINING_EMPLOYEE:
			fillCulturalTrainingEmployee(addNewPolicyPage, subBenefit, sharedSubBenefitPage, pageName);
			break;
		case PDTConstants.CULTURAL_TRAINING_FAMILY:
			fillCulturalTrainingFamily(addNewPolicyPage, subBenefit, sharedSubBenefitPage, pageName);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}		
	}
	
	/**
	 * Iterate Cultural Training sub-benefits and fill their corresponding form.
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage 
	 */
	public void iterateAndFillCulturalTrainingSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName, PDT_SharedSubBenefitPage subBenefitPage) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);			
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		//WebElement btnToClick = (btnName != null) ?  buttonMap.get(btnName) : buttonMap.get(PDTConstants.SAVE);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillCulturalTrainingSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage);
		}
		try {
			if(btnName != null)
			CoreFunctions.click(driver, buttonMap.get(btnName), buttonMap.get(btnName).getText());
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}
}
