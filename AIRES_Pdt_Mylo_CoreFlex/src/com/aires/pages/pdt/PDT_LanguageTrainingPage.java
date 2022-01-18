package com.aires.pages.pdt;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_LanguageTrainingBenefit;
import com.aires.utilities.Log;

public class PDT_LanguageTrainingPage extends Base {

	public PDT_LanguageTrainingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "app-employee input[formcontrolname='maxNumOfHours']")
	private WebElement _txtBoxMaxNumOfHours;

	@FindBy(how = How.XPATH, using = "//label[text()='Max. Number of Hours']")
	private WebElement _lblMaxNumOfHours;

	@FindBy(how = How.CSS, using = "#collapseOne1 label.form-check-label")
	private List<WebElement> _radioBtnLangTrainingEmployee;

	@FindBy(how = How.CSS, using = "#collapseOne1 input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForLangTrainingEmp;

	@FindBy(how = How.CSS, using = "#collapseOne1 textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForLangTrainingEmp;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numHoursPerPerson']")
	private WebElement _txtBoxMaxNumOfHoursPerPerson;

	@FindBy(how = How.CSS, using = "app-family input[formcontrolname='maxNumOfHours']")
	private WebElement _txtBoxMaxNumOfHoursForLangTrainingFamily;

	@FindBy(how = How.CSS, using = "#collapseTwo label.form-check-label")
	private List<WebElement> _radioBtnLangTrainingFamily;

	@FindBy(how = How.CSS, using = "#collapseTwo input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForLangTrainingFamily;

	@FindBy(how = How.CSS, using = "#collapseTwo textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForLangTrainingFamily;

	@FindBy(how = How.XPATH, using = "//label[text()='Max. Number of Hours']")
	private WebElement _lblMaxNumOfHoursPerPerson;

	@FindBy(how = How.XPATH, using = "//label[text()='Max. Number of Hours per Family (if applicable)']")
	private WebElement _lblMaxNumOfHoursPerFamily;

	PDT_LanguageTrainingBenefit languageTrainingBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getLanguageTrainingDataList("Language Training");
	

	public void fillLanguageTrainingEmployee(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {			
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxMaxNumOfHours, _lblMaxNumOfHours.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxNumOfHours, _lblMaxNumOfHours.getText(),
					languageTrainingBenefitData.languageTrainingEmployee.maxNumOfHours);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnLangTrainingEmployee);
			CoreFunctions.selectItemInListByText(driver, _radioBtnLangTrainingEmployee,
					languageTrainingBenefitData.languageTrainingEmployee.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnLangTrainingEmployee,
					languageTrainingBenefitData.languageTrainingEmployee.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					languageTrainingBenefitData.languageTrainingEmployee.reimbursedBy,
					_txtBoxReimbursedByOtherForLangTrainingEmp,
					languageTrainingBenefitData.languageTrainingEmployee.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForLangTrainingEmp, PDTConstants.COMMENT,
					languageTrainingBenefitData.languageTrainingEmployee.comments);
		} catch (Exception e) {			
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail("Failed to fill Language Training Employee form.");
		}
	}

	public void fillLanguageTrainingFamily(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxMaxNumOfHoursPerPerson,
					_lblMaxNumOfHoursPerPerson.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxNumOfHoursPerPerson, _lblMaxNumOfHoursPerPerson.getText(),
					languageTrainingBenefitData.languageTrainingFamily.maxNumOfHrsPerPerson);
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxNumOfHoursForLangTrainingFamily,
					_lblMaxNumOfHoursPerFamily.getText(),
					languageTrainingBenefitData.languageTrainingFamily.maxNumOfHrsPerFamily);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnLangTrainingFamily);
			CoreFunctions.selectItemInListByText(driver, _radioBtnLangTrainingFamily,
					languageTrainingBenefitData.languageTrainingFamily.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnLangTrainingFamily,
					languageTrainingBenefitData.languageTrainingFamily.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					languageTrainingBenefitData.languageTrainingFamily.reimbursedBy,
					_txtBoxReimbursedByOtherForLangTrainingFamily,
					languageTrainingBenefitData.languageTrainingFamily.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForLangTrainingFamily, PDTConstants.COMMENT,
					languageTrainingBenefitData.languageTrainingFamily.comments);
		} catch (Exception e) {			
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			Assert.fail("Failed to fill Language Training Family form.");
		}
	}
}
