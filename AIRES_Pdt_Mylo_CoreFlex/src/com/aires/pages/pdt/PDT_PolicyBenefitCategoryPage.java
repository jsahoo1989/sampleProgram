package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
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
		CoreFunctions.click(driver, _btnNext, _btnNext.getText());
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _progressBar, 5);
	}
	
	public String getPageHeaderTitle() {
		CoreFunctions.waitHandler(2);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerPage,"Policy Benefits Categories");
		return CoreFunctions.getElementText(driver, _headerPage);
	}

	public String getLeftNavigationPageTitle() {
		return CoreFunctions.getElementText(driver, _leftNavigationTitle);
	}
}
