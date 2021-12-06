package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class PDT_PreAcceptanceService extends Base{
	public PDT_PreAcceptanceService(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;

	@FindBy(how = How.CSS, using = "a[href='#collapseOne']")
	private WebElement _formCandidateSelection;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _preAcceptanceTripTransportation;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _preAcceptanceTripLodging;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseFour']")
	private WebElement _preAcceptanceTripMeals;
	
	@FindBy(how = How.CSS, using = "div.card-header-info > h4.card-title")
	private WebElement _subCategoryHeading;
	
	final By _subBenefitCategoriesLocator = By.cssSelector("div.form-check > label.form-check-label");
	
	public WebElement getElementByName(String elementName)
	{
		WebElement element = null;
		switch(elementName) {
		case PDTConstants.CANDIDATE_SELECTION:
			element = _formCandidateSelection;
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION:
			element = _preAcceptanceTripTransportation;
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING:
			element = _preAcceptanceTripLodging;
			break;
		case PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS:
			element = _preAcceptanceTripMeals;
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}
	
	public String getElementText(String elementName) {
		String elementText = null;
		switch (elementName) {
		case PDTConstants.HEADING:
			elementText = _subCategoryHeading.getText();
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return elementText;
	}
	
	public boolean verifyFormIsDisplayed(String formName, WebElement element, String pageName) {
		if(element.isDisplayed()) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_DISPLAYED, CoreConstants.PASS,
					formName, pageName));
			return true;
		}
		return false;
	}
	
	public boolean verifyFormIsHidden(String formName, WebElement element, String pageName) {
		if(!CoreFunctions.isElementExist(driver, element, 2)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_HIDDEN, CoreConstants.PASS,
					formName, pageName));
			return true;
		}
		return false;
	}
	
	public boolean verifySubCategoryHeading(String pageName) {			
		CoreFunctions.waitHandler(3);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _subCategoryHeading, _subCategoryHeading.getText());
		return CoreFunctions.verifyElementOnPage(driver, _subCategoryHeading, PDTConstants.heading, pageName, pageName, true);
	}
	
	public void selectSubBenefitAndVerifyFormIsDisplayed(DataTable subBenefitTable, String pageName) {		
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		List<String> subBenefits = subBenefitTable.asList(String.class);
		for(String subBenefit : subBenefits) {			
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);			
			Assert.assertTrue(verifyFormIsDisplayed(subBenefit, getElementByName(subBenefit), pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefit, pageName));
		}
	}
	
	public void deselectSubBenefit(DataTable subBenefitTable, String pageName) {		
		List<String> subBenefits = subBenefitTable.asList(String.class);
		for(String subBenefit : subBenefits) {			
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);			
		}
	}
	
	public void checkFormIsHidden(DataTable subBenefitTable, String pageName) {
		List<String> subBenefits = subBenefitTable.asList(String.class);
		for(String subBenefit : subBenefits) {			
			Assert.assertTrue(verifyFormIsHidden(subBenefit, getElementByName(subBenefit), pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_HIDDEN, subBenefit, pageName));			
		}
	}
}
