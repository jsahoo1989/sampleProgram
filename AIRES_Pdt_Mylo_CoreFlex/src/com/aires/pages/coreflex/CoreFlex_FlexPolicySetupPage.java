package com.aires.pages.coreflex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.PDTConstants;

public class CoreFlex_FlexPolicySetupPage extends Base {

	public CoreFlex_FlexPolicySetupPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Policy Header
	@FindBy(how = How.CSS, using = "h4[class='card-title'] > b")
	private WebElement _headerPolicyInfo;

	// Flex Policy Setup Header
	@FindBy(how = How.CSS, using = "div[class*='pcard-header'] > h4[class='card-title']")
	private WebElement _headerPage;

	// Flex Policy Left Navigation
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[@class='disabled nav-item active']//p")
	private WebElement _leftNavigationTitle;	

	/*********************************************************************/
	
	public String getPageHeaderTitle() {		
		CoreFunctions.waitHandler(2);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerPage,"Flex Policy Setup");
		return CoreFunctions.getElementText(driver, _headerPage);
	}

	public String getLeftNavigationPageTitle() {

		return CoreFunctions.getElementText(driver, _leftNavigationTitle);
	}
	
	
	
	

}
