package com.aires.pages.coreflex;

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
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.vimalselvam.cucumber.listener.Reporter;

public class MX_Client_ViewAllInitiationsPage extends Base {

	public MX_Client_ViewAllInitiationsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Back to dashboard')]")
	private WebElement _linkBackToDashboard;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'DISPLAYING MOST RECENTLY UPDATED FIRST')]")
	private WebElement _textDisplayingRecentIntiations;

	@FindBy(how = How.CSS, using = "div[class*='RXBigLink RXBold'] span")
	private List<WebElement> _linkTransfereeNameList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Clone authorization')]")
	private List<WebElement> _buttonCloneAuthorization;

	/*********************************************************************/

	/*********************************************************************/

	/**
	 * Method to verify navigated Page
	 */
	public boolean verifyPageNavigation() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _textDisplayingRecentIntiations,
					MobilityXConstants.VIEW_ALL_INITIATIONS);
			return CoreFunctions.isElementExist(driver, _textDisplayingRecentIntiations, 2)
					&& CoreFunctions.isElementExist(driver, _linkBackToDashboard, 2);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_VIEW_ALL_INITIATIONS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public void clickElementOfPage(String elementName) {
		try {
			switch (elementName) {
			case MobilityXConstants.LINK_GO_BACK_TO_DASHBOARD:
				CoreFunctions.clickElement(driver, _linkBackToDashboard);
				break;
			case MobilityXConstants.INITIATION:
				CoreFunctions.selectItemInListByText(driver, _linkTransfereeNameList,
						CoreFunctions.getPropertyFromConfig("FirstName") + " "
								+ CoreFunctions.getPropertyFromConfig("LastName"));
				break;
			case MobilityXConstants.CLONE_AUTHORIZATION:
				int elementindex = BusinessFunctions.returnindexItemFromListUsingText(driver, _linkTransfereeNameList,
						CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
								+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
				CoreFunctions.hoverAndClick(driver, _buttonCloneAuthorization.get(elementindex),
						MobilityXConstants.CLONE_AUTHORIZATION);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_AN_ELEMENT_OF_PAGE,
							CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);
		}
	}

}
