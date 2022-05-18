package com.aires.pages.pdt;

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
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_CulturalTrainingBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_CulturalTrainingPage extends Base {
	public PDT_CulturalTrainingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeNoOfDays']")
	private WebElement _drpDownEmployeNumOfDays;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeNoOfDays'] div.ng-option.ng-star-inserted")
	private List<WebElement> _drpDownEmployeNumOfDaysOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='employeeNoOfDays'] div.ng-value.ng-star-inserted")
	private WebElement _drpDownEmployeeNumOfDaysOptionSelected;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='employeeNoOfDaysOther']")
	private WebElement _txtBoxEmpNumOfDaysOther;

	@FindBy(how = How.XPATH, using = "//div[@id='collapseOne1']//child::label[text()='Number of Days']")
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
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='familyNoOfDays'] div.ng-option.ng-star-inserted")
	private List<WebElement> _drpDownFamilyNumOfDaysOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='familyNoOfDays'] div.ng-value.ng-star-inserted")
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
	
	PDT_CulturalTrainingBenefit culturalTrainingBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getCulturalTrainingDataList("Cultural Training");
	
	String numOfDaysForEmp, numOfDaysForFamily;
	
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
	
	public void fillCulturalTrainingEmployee(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {			
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
			CoreFunctions.selectItemInListByText(driver, _radioBtnLangCulTrainEmployee,
					culturalTrainingBenefitData.culturalTrainingEmployee.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnLangCulTrainEmployee,
					culturalTrainingBenefitData.culturalTrainingEmployee.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					culturalTrainingBenefitData.culturalTrainingEmployee.reimbursedBy,
					_txtBoxReimbursedByOtherForCultTrainingEmp,
					culturalTrainingBenefitData.culturalTrainingEmployee.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForCultTrainingEmp, PDTConstants.COMMENT,
					culturalTrainingBenefitData.culturalTrainingEmployee.comments);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillCulturalTrainingFamily(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {			
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
			CoreFunctions.selectItemInListByText(driver, _radioBtnCultTrainingFamily,
					culturalTrainingBenefitData.culturalTrainingFamily.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnCultTrainingFamily,
					culturalTrainingBenefitData.culturalTrainingFamily.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					culturalTrainingBenefitData.culturalTrainingFamily.reimbursedBy,
					_txtBoxReimbursedByOtherForCultTrainingFamily,
					culturalTrainingBenefitData.culturalTrainingFamily.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForCultTrainingFamily, PDTConstants.COMMENT,
					culturalTrainingBenefitData.culturalTrainingFamily.comments);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
}
