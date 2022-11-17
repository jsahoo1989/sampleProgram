package com.aires.pages.pdt;

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
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_DuplicateHousingBenefit;

public class PDT_DuplicateHousingPage extends Base {
	public PDT_DuplicateHousingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='durationCode']/preceding-sibling::label")
	private WebElement _lblDuration;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='durationCode']")
	private WebElement _drpDownDuration;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='durationCode'] span.ng-option-label")
	private List<WebElement> _drpDownDurationOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='durationCode'] span.ng-value-label")
	private WebElement _drpDownDurationOptionsSelected;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='durationOther']/preceding-sibling::label")
	private WebElement _lblDurationOther;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='durationOther']")
	private WebElement _txtBoxDurationOther;
	
	@FindBy(how = How.CSS, using = "label.form-check-label")
	private List<WebElement> _radioBtnDuplicateHousing;

	@FindBy(how = How.CSS, using = "input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOther;

	@FindBy(how = How.CSS, using = "textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaDuplicateHousingComment;
	
	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;
	
	@FindBy(how = How.CSS, using = "button.btn.btn-info.btn-back")
	private WebElement _btnBack;

	@FindBy(how = How.CSS, using = "button.btn.btn-info.btn-next")
	private WebElement _btnNext;
	
	@FindBy(how = How.XPATH, using = "//span[text()='SAVE & CONTINUE']/parent::button")
	private WebElement _btnSaveAndContinue;
	
	@FindBy(how = How.XPATH, using = "//span[text()='SAVE']/parent::button")
	private WebElement _btnSave;
	
	@FindBy(how = How.XPATH, using = "//span[text()='CANCEL']")
	private WebElement _btnCancel;
	
	@FindBy(how = How.XPATH, using = "//span[text()='APPROVE']/parent::button")
	private WebElement _btnApprove;
	
	@FindBy(how = How.XPATH, using = "//span[text()='APPROVE POLICY']")
	private WebElement _btnApprovePolicy;
	
	@FindBy(how = How.CSS, using = "button.btn.btn-info.btn-exit")
	private WebElement _btnExit;
	
	@FindBy(how = How.XPATH, using = "//span[text()='SAVE & SUBMIT']/parent::button")
	private WebElement _btnSaveAndSubmit;
	
	@FindBy(how = How.CSS, using = "button.swal2-confirm")
	private WebElement _btnOkOnConfirmationDialog;

	@FindBy(how = How.CSS, using = "button.swal2-deny")
	private WebElement _btnCancelOnConfirmationDialog;

	@FindBy(how = How.CSS, using = "button.swal2-cancel")
	private WebElement _btnSaveOnConfirmationDialog;
	
	PDT_DuplicateHousingBenefit duplicateHousingBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getDuplicateHousingDataList("Duplicate Housing");
	private String duration;
	LinkedHashMap<String, WebElement> buttonMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> confirmationDialogButtonMap = new LinkedHashMap<String, WebElement>();
	
	public void setDuration(String durationSelected) {
		duration = durationSelected;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void populateBtnMap() {
		buttonMap.put(PDTConstants.PDT_BTN_SAVE_SUBMIT, _btnSaveAndSubmit);
		buttonMap.put(PDTConstants.EXIT.toUpperCase(), _btnExit);
		buttonMap.put(PDTConstants.BTN_APPROVE_POLICY, _btnApprovePolicy);
		buttonMap.put(PDTConstants.BTN_APPROVE, _btnApprove);
		buttonMap.put(PDTConstants.BTN_CANCEL, _btnCancel);
		buttonMap.put(PDTConstants.SAVE, _btnSave);
		buttonMap.put(PDTConstants.SAVE_AND_CONTINUE, _btnSaveAndContinue);
		buttonMap.put(PDTConstants.BACK.toUpperCase(), _btnBack);
		buttonMap.put(PDTConstants.NEXT.toUpperCase(), _btnNext);
	}

	public void populateConfirmDialogbuttonMap() {
		confirmationDialogButtonMap.put(PDTConstants.OK, _btnOkOnConfirmationDialog);
		confirmationDialogButtonMap.put(PDTConstants.CANCEL, _btnCancelOnConfirmationDialog);
		confirmationDialogButtonMap.put(PDTConstants.SAVE, _btnSaveOnConfirmationDialog);
	}
	
	public void populateWebElementsMap() {
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		
	}
	
	public void fillDuplicateHousingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String btnName) {
		try {
			populateWebElementsMap();
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblDuration,
					_lblDuration.getText());
			CoreFunctions.click(driver, _drpDownDuration, _lblDuration.getText());
			CoreFunctions.explicitWaitTillElementListClickable(driver, _drpDownDurationOptions);
			String randDuration = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownDuration, _drpDownDurationOptions, _drpDownDurationOptionsSelected,
					_lblDuration.getText());
			setDuration(randDuration);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownDurationOptionsSelected, _lblDuration.getText(), _txtBoxDurationOther,
					PDTConstants.DURATION_OTHER, subBenefitFormName);
			
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnDuplicateHousing);
			CoreFunctions.selectItemInListByText(driver, _radioBtnDuplicateHousing,
					duplicateHousingBenefitData.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnDuplicateHousing,
					duplicateHousingBenefitData.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					duplicateHousingBenefitData.reimbursedBy, _txtBoxReimbursedByOther,
					duplicateHousingBenefitData.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaDuplicateHousingComment, PDTConstants.COMMENT,
					duplicateHousingBenefitData.comments);
			CoreFunctions.click(driver, buttonMap.get(btnName), btnName);						
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

}
