package com.aires.pages.pdt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;

public class PDT_PolicyBenefitsCategoriesPage extends Base {
	
	public PDT_PolicyBenefitsCategoriesPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Policy Header
	@FindBy(how = How.CSS, using = "h4[class='card-title'] > b")
	private WebElement _headerPolicyInfo;

	//Policy Benefits Categories Header
	@FindBy(how = How.CSS, using = "div[class*='pcard-header'] > h4[class='card-title']")
	private WebElement _headerPage;

	// Policy Benefits Categories Left Navigation
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//a[contains(@class,'nav-link disabled')]//p")
	private WebElement _leftNavigationTitle;

	/*********************************************************************/
	
	public String getPageHeaderTitle() {
		CoreFunctions.waitHandler(2);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerPage,"Policy Benefits Categories");
		return CoreFunctions.getElementText(driver, _headerPage);
	}

	public String getLeftNavigationPageTitle() {
		return CoreFunctions.getElementText(driver, _leftNavigationTitle);
	}
	

}
