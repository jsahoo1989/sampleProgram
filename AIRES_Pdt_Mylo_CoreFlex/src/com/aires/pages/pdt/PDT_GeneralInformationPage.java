package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class PDT_GeneralInformationPage extends Base {

	public PDT_GeneralInformationPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Add New Policy Forms
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//i[contains(text(),'pending_actions')]/following-sibling::p[contains(text(),'General Information')]")
	private WebElement _leftNavGeneralInfo;

	// General Information Header
	@FindBy(how = How.XPATH, using = "//h4[@class='card-title'][contains(text(),'General Information')]")
	private WebElement _headerGeneralInfo;

	// Policy Header
	@FindBy(how = How.CSS, using = "h4[class='card-title'] > b")
	private WebElement _headerPolicyInfo;

	// Client Name - General Information
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Client Name:')]/following-sibling::label")
	private WebElement _textClientName;

	// Client ID - General Information
	@FindBy(how = How.XPATH, using = "//label[contains(string(),'Client#')]/following-sibling::label")
	private WebElement _textClientID;

	/*********************************************************************/

	public boolean validateGeneralInfo(String pageName, DataTable dataTable, String selectedPolicyName) {

		boolean isGeneralInfoValid = false;
		boolean leftNavigationVerified, clientPolicyDetailsVerified = false;

		try {
			leftNavigationVerified = verifyLeftNavigationMenu(pageName);
			clientPolicyDetailsVerified = verifyClientPolicyDetails(pageName, dataTable, selectedPolicyName);
			isGeneralInfoValid = leftNavigationVerified && clientPolicyDetailsVerified;
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_GENERAL_INFORMATION_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}

		if (isGeneralInfoValid) {
			Reporter.addStepLog(MessageFormat.format(
					PDTConstants.SUCCESSFULLY_VERIFIED_CLIENT_AND_POLICY_DETAILS_ON_GENERAL_INFO_PAGE,
					CoreConstants.PASS, pageName));
		}

		return isGeneralInfoValid;

	}

	private boolean verifyClientPolicyDetails(String pageName, DataTable dataTable, String selectedPolicyName) {

		List<Map<String, String>> clientInfo = dataTable.asMaps(String.class, String.class);
		String expectedClientID = clientInfo.get(0).get("ClientID");
		String expectedClientName = clientInfo.get(0).get("ClientName");

		CoreFunctions.explicitWaitTillElementVisibility(driver, _headerGeneralInfo, PDTConstants.GENERAL_INFORMATION);

		boolean isPolicyNameCorrect = verifyPolicyNameOnGeneralInfo(selectedPolicyName);
		boolean isClientDetailsCorrect = verifyClientDetailsOnGenaralInfo(expectedClientID, expectedClientName);

		return (isPolicyNameCorrect && isClientDetailsCorrect);
	}

	private boolean verifyClientDetailsOnGenaralInfo(String expectedClientID, String expectedClientName) {

		if ((CoreFunctions.getElementText(driver, _textClientName).equals(expectedClientName))
				&& (CoreFunctions.getElementText(driver, _textClientID).equals(expectedClientID))) {
			return true;
		} else
			return false;

	}

	private boolean verifyPolicyNameOnGeneralInfo(String selectedPolicyName) {

		String[] expectedPolicyName = (CoreFunctions.getElementText(driver, _headerPolicyInfo)).split(":");

		if (selectedPolicyName.contains(expectedPolicyName[1].trim()))
			return true;
		else
			return false;
	}

	private boolean verifyLeftNavigationMenu(String pageName) {

		return (CoreFunctions.isElementExist(driver, _leftNavGeneralInfo, 5) ? true : false);

	}

}
