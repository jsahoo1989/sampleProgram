package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_PolicyBenefitCategoryPage extends Base {

	public PDT_PolicyBenefitCategoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Policy Type:')]/following-sibling::label")
	private WebElement _txtPolicyType;

	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Employee Type:')]/following-sibling::label")
	private WebElement _txtEmployeeType;

	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Homeowner Type:')]/following-sibling::label")
	private WebElement _txtHomeOwnerType;

	@FindBy(how = How.CSS, using = "div.card-header > h4.card-title")
	private WebElement _headingPolicyBenefitCategory;

	@FindBy(how = How.CSS, using = "input[type='checkbox'][class*='ng-valid']:not(input[disabled])")
	private List<WebElement> _chkBoxPolicyBenefitCategory;

	@FindBy(how = How.CSS, using = "label.form-check-label.cbx-label")
	private List<WebElement> _lblChkBoxPolicyBenefitCategory;

	// Policy Header
	@FindBy(how = How.CSS, using = "h4[class='card-title'] > b")
	private WebElement _headerPolicyInfo;

	// Policy Benefits Categories Header
	@FindBy(how = How.CSS, using = "div[class*='pcard-header'] > h4[class='card-title']")
	private WebElement _headerPage;

	// Policy Benefits Categories Left Navigation
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//a[contains(@class,'nav-link disabled')]//p")
	private WebElement _leftNavigationTitle;

	@FindBy(how = How.CSS, using = "button.btn-next")
	private WebElement _btnNext;
	
	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;
	
	@FindBy(how = How.CSS, using = "label.form-check-label.cbx-label > input")
	private List<WebElement> _inputBenefitCategory;
	
	long timeBeforeAction, timeAfterAction;
	String policyBenefitCategoryName;
	
	private ArrayList<String> selectedBenefitCategories = new ArrayList<String>();
	
	public void setBenefitCategoryName(String categoryName) {
		policyBenefitCategoryName = categoryName;
	}
	
	public String getBenefitCategoryName() {
		return policyBenefitCategoryName; 
	}
	
	public void waitForProgressBarToDisappear() {
		try {
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);			
		} catch(Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_WAIT_PROGRESS_BAR, CoreConstants.FAIL));
		}
	}

	public String getElementText(String elementName) {
		String elementText = null;
		switch (elementName) {
		case PDTConstants.HEADING:
			elementText = _headingPolicyBenefitCategory.getText();
			break;
		case PDTConstants.POLICY_TYPE:
			elementText = _txtPolicyType.getText();
			break;
		case PDTConstants.EMPLOYEE_TYPE:
			elementText = _txtEmployeeType.getText();
			break;
		case PDTConstants.HOMEOWNER_TYPE:
			elementText = _txtHomeOwnerType.getText();
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return elementText;
	}

	public boolean verifyPolicyBenefitCategoryHeading(String pageName) {
		waitForProgressBarToDisappear();
		return CoreFunctions.verifyElementOnPage(driver, _headingPolicyBenefitCategory, PDTConstants.heading,
				PDTConstants.POLICY_BENEFIT_CATEGORIES, pageName, true);
	}

	public boolean verifyPolicyBenefitCategoriesAreDisplayed(String pageName) {
		if (_chkBoxPolicyBenefitCategory.size() > 0) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_DISPLAY_OF_BENEFIT_CATEGORY,
					CoreConstants.PASS, _chkBoxPolicyBenefitCategory.size(), pageName));
			return true;
		}
		return false;
	}

	public void selectPolicyBenefitCategory(String benefitCategoryName) {
		CoreFunctions.selectItemInListByText(driver, _lblChkBoxPolicyBenefitCategory, benefitCategoryName, true);
		if(verifyIsPolicyBenefitCategoryChecked(benefitCategoryName))
			setBenefitCategoryName(benefitCategoryName);
		timeBeforeAction = new Date().getTime();
		CoreFunctions.clickUsingJS(driver, _btnNext, _btnNext.getText());
		BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, benefitCategoryName);
	}
	
	public String getPageHeaderTitle() {
		CoreFunctions.waitHandler(2);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerPage,"Policy Benefits Categories");
		return CoreFunctions.getElementText(driver, _headerPage);
	}

	public String getLeftNavigationPageTitle() {
		return CoreFunctions.getElementText(driver, _leftNavigationTitle);
	}
	
	public boolean verifyIsPolicyBenefitCategoryChecked(String benefitCategoryName) {
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _lblChkBoxPolicyBenefitCategory, benefitCategoryName);		
		//For debugging purpose Log.info("DomProperty=="+_inputBenefitCategory.get(index).getDomProperty("checked"));
		if(_inputBenefitCategory.get(index).getAttribute("checked").equalsIgnoreCase("true")) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_BENEFIT_CATEGORY_IS_SELECTED, CoreConstants.PASS, benefitCategoryName));
			return true;
		}
		return false;
	}
	
	public void navigateToSubbenefitPage(String benefitCategoryName) {
		timeBeforeAction = new Date().getTime();
		CoreFunctions.clickUsingJS(driver, _btnNext, _btnNext.getText());
		BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, benefitCategoryName);
	}	
	
	public void iterateBenefitList(List<String> benefits) {
		for (String benefitName : benefits) {
			CoreFunctions.selectItemInListByText(driver, _lblChkBoxPolicyBenefitCategory, benefitName, true);
			if(verifyIsPolicyBenefitCategoryChecked(benefitName)) {
				selectedBenefitCategories.add(benefitName);				
			}
		}
		timeBeforeAction = new Date().getTime();
		CoreFunctions.clickUsingJS(driver, _btnNext, _btnNext.getText());
		waitForProgressBarToDisappear();
		timeAfterAction = new Date().getTime();
		BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, selectedBenefitCategories.get(1));
	}
	
	public ArrayList<String> getSelectedCategoriesName(){
		return selectedBenefitCategories;
	}
}
