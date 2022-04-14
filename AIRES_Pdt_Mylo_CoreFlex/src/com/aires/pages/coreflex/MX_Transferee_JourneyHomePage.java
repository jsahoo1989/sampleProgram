package com.aires.pages.coreflex;

import java.text.DecimalFormat;
import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.MX_Transferee_AccountSetupDetails;
import com.aires.utilities.EmailUtil;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class MX_Transferee_JourneyHomePage extends Base {

	public MX_Transferee_JourneyHomePage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'airesBrand')]/parent::td/following-sibling::td/span[contains(@class,'RXSmallText')]")
	private WebElement _textClientName;

	@FindBy(how = How.CSS, using = "span[id*='mRegion'][class='RXHeaderText RXBold RXWrappedText']")
	private WebElement _textTransfereeUserNameTitle;

	@FindBy(how = How.CSS, using = "a[class*='RXCFPointLink'] > span")
	private WebElement _textInitialSpentAndTotalPoints;

	@FindBy(how = How.CSS, using = "div[id*='mRegion'] > div > span[id*='mRegion'][class='RXBigText']")
	private WebElement _textAssignmentType;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Policy / File ID')]/parent::div/following-sibling::div/span")
	private WebElement _textPolicyFileID;

	@FindBy(how = How.XPATH, using = "//span[text()='Origin']/parent::div/following-sibling::div")
	private WebElement _originAddress;

	@FindBy(how = How.XPATH, using = "//span[text()='Destination']/parent::div/following-sibling::div")
	private WebElement _destinationAddress;

	@FindBy(how = How.CSS, using = "span[id*='manageMyPoints'][class='AddExpenseLinkTextFont']")
	private WebElement _linkManageMyPoints;

	@FindBy(how = How.ID, using = "cookiePupupButtonId")
	private WebElement _btn_OkOnSiteCookieAfterLogin;

	@FindBy(how = How.XPATH, using = "//span[text()='No thanks, I prefer to do this later']")
	private WebElement _linkSkipProceedToJourneyHome;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Start the FleX Planning Tool')]")
	private WebElement _btn_proceedToFlexTool;

	@FindBy(how = How.XPATH, using = "//span[text()='Remind me later']")
	private WebElement _link_remindLater;

	final By _link_remindLaterLocater = By.xpath("//span[text()='Remind me later']");

	@FindBy(how = How.XPATH, using = "//span[text()='Start the FleX Planning Tool']")
	private WebElement _btn_startFlexPlanning;

	@FindBy(how = How.CSS, using = "a.RXCFPointLink.af_link.p_AFTextOnly > span")
	private WebElement _poinBalance_tooltip;

	@FindBy(how = How.CSS, using = "span.RXCFSmallText.RXWrappedText.RXWhite")
	private WebElement _poinBalance_tooltip_content;

	@FindBy(how = How.CSS, using = "a.af_panelWindow_close-icon-style")
	private WebElement _close_tootip;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Hi')]/parent::td")
	private WebElement _link_transferee_dropdown;

	@FindBy(how = How.XPATH, using = "//span[text()='Banking']")
	private WebElement _optionBanking;

	@FindBy(how = How.XPATH, using = "//span[text()='Add payment account']")
	private WebElement _link_addPaymentAccount;

	@FindBy(how = How.CSS, using = "select[title='Account type*']")
	private WebElement _select_accountType;

	@FindBy(how = How.XPATH, using = "//span[text()='Continue']")
	private WebElement _btn_continue;

	@FindBy(how = How.CSS, using = "select[title='Currency*']")
	private WebElement _select_currency;

	@FindBy(how = How.CSS, using = "input[placeholder='All account holder name(s)*']")
	private WebElement _accountHolderName;

	@FindBy(how = How.CSS, using = "div[title='Submit'] > a")
	private WebElement _btn_submit;

	@FindBy(how = How.CSS, using = "div[class='growl-message']")
	private WebElement _successGrowlMessage;

	@FindBy(how = How.CSS, using = "input[id*='chkacdid']")
	private WebElement _accountClosingDate;

	@FindBy(how = How.CSS, using = "select[id*='mailCntry']")
	private WebElement _select_mailingCountry;

	@FindBy(how = How.CSS, using = "input[id*='mailZip']")
	private WebElement _postalCode;

	@FindBy(how = How.CSS, using = "input[id*='itwiremprovince']")
	private WebElement _province;

	@FindBy(how = How.CSS, using = "select[id*='mailState']")
	private WebElement _select_mailingState;

	@FindBy(how = How.CSS, using = "input[id*='mailCity']")
	private WebElement _mailingCity;

	@FindBy(how = How.CSS, using = "input[id*='itwirem2']")
	private WebElement _mailingAddress2;

	@FindBy(how = How.CSS, using = "input[id*='mailAdd1']")
	private WebElement _mailingAddress1;

	@FindBy(how = How.XPATH, using = "//span[text()='Save']")
	private WebElement _btn_save;

	@FindBy(how = How.XPATH, using = "//span[text()='Back to mobility journey']")
	private WebElement _link_backToMobilityJourney;

	/*********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	MX_Transferee_AccountSetupDetails accountDetails = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMxTransfereeAccountSetupDetails();

	/*********************************************************************/

	public boolean navigateToFlexPlanningToolPage() {
		boolean isNavigatedToFPTpage = false;
		try {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkManageMyPoints,
					MobilityXConstants.MANAGE_MY_POINTS);
			if (CoreFunctions.isElementExist(driver, _linkManageMyPoints, 10)) {
				CoreFunctions.clickUsingJS(driver, _linkManageMyPoints, MobilityXConstants.MANAGE_MY_POINTS);
				isNavigatedToFPTpage = true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isNavigatedToFPTpage) {
			Reporter.addStepLog(MessageFormat
					.format(MobilityXConstants.SUCCESSFULLY_NAVIGATED_TO_FLEX_PLANNING_TOOL_PAGE, CoreConstants.PASS));
		}
		return isNavigatedToFPTpage;
	}

	public void handle_Cookie_AfterLogin() {
		CoreFunctions.waitForBrowserToLoad(driver);
		if (CoreFunctions.isElementExist(driver, _btn_OkOnSiteCookieAfterLogin, 15)) {
			HandleCookiePopUp(_btn_OkOnSiteCookieAfterLogin);
		}
	}

	public void HandleCookiePopUp(WebElement element) {
		boolean isExists = CoreFunctions.verifyElementPresentOnPage(element, MobilityXConstants.DAILOG_SITECOOKIE);
		if (isExists) {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, MobilityXConstants.DAILOG_SITECOOKIE);
			CoreFunctions.click(driver, element, MobilityXConstants.COOKIEDAILOG_OKBUTTON);
			CoreFunctions.explicitWaitTillElementInVisibility(driver, element);
			Log.info(MobilityXConstants.VERIFIED + MobilityXConstants.DAILOG_SITECOOKIE
					+ MobilityXConstants.IS_DISPLAYED + MobilityXConstants.ON_MOBILITYX_DASHBOARD_PAGE);
		} else
			Log.info(MobilityXConstants.SITE_COOKIE_DIALOG_NOT_DISPLAY);
	}

	public void handle_points_expiry_reminder_popup() {
		if (CoreFunctions.isElementExist(driver, _link_remindLater, 2)) {
			if (CoreFunctions.verifyElementPresentOnPage(_link_remindLater, MobilityXConstants.REMIND_LATER)) {
				CoreFunctions.click(driver, _link_remindLater, MobilityXConstants.REMIND_LATER);
				Log.info(MobilityXConstants.VERIFIED + MobilityXConstants.REMINDER_POPUP
						+ MobilityXConstants.IS_DISPLAYED + MobilityXConstants.ON_MOBILITYX_DASHBOARD_PAGE);
			} else
				Log.info(MobilityXConstants.REMINDER_POPUP_NOT_DISPLAYED);
		}
	}

	public boolean isManageMyPointsDisplayed() {
		return CoreFunctions.isElementExist(driver, _linkManageMyPoints, 10);
	}

	public void routeToTransfereeJourney() {
		if (CoreFunctions.isElementExist(driver, _linkSkipProceedToJourneyHome, 5))
			CoreFunctions.clickElement(driver, _linkSkipProceedToJourneyHome);
	}

	public boolean isWelcomePopupDisplayed() {
		return CoreFunctions.isElementExist(driver, _btn_startFlexPlanning, 10);
	}

	public void routeToFlexPlanningTool() {
		CoreFunctions.clickElement(driver, _btn_proceedToFlexTool);
	}

	public boolean verifyAssignmentAndPolicyDetails() {
		boolean isAssignmentClientDetailsMatched = false, isPolicyPointsDetailsMatched = false;
		boolean isDetailsMatched = false;
		try {
			String actualClientName = CoreFunctions.getElementText(driver, _textClientName);
			String actualTransfereeName = CoreFunctions.getElementText(driver, _textTransfereeUserNameTitle);
			String actualpolicyAndFileId = CoreFunctions.getElementText(driver, _textPolicyFileID);
			String actualPolicyName = actualpolicyAndFileId.substring(0, actualpolicyAndFileId.lastIndexOf("/")).trim();
			String actualFileId = actualpolicyAndFileId.substring(actualpolicyAndFileId.lastIndexOf("/") + 1).trim();
			String actualPointsWithText[] = CoreFunctions.getElementText(driver, _textInitialSpentAndTotalPoints)
					.split(" ");
			String actualSpentAndTotalPoints[] = actualPointsWithText[0].split("/");
			isAssignmentClientDetailsMatched = verifyAssignmentDetails(actualClientName, actualFileId,
					actualTransfereeName);
			isPolicyPointsDetailsMatched = verifyPolicyPointsDetails(actualPolicyName, actualSpentAndTotalPoints[0],
					actualSpentAndTotalPoints[1]);
			isDetailsMatched = isAssignmentClientDetailsMatched & isPolicyPointsDetailsMatched;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ASSIGNMENT_AND_POLICY_DETAILS_ON_MOBILITY_JOURNEY_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isDetailsMatched) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.ASSIGNMENT_DETAILS_MATCHED_ON_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.PASS));
		}
		return isDetailsMatched;
	}

	private boolean verifyPolicyPointsDetails(String actualPolicyName, String actualSpentPoints,
			String actualTotalPoints) {

		boolean isPolicyPointsDetailsMatched = CoreFunctions.getPropertyFromConfig("Assignment_Policy")
				.equals(actualPolicyName) & actualSpentPoints.equals("0")
				& actualTotalPoints.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable);

		if (isPolicyPointsDetailsMatched) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.POLICY_AND_POINTS_DETAILS_MATCHED_ON_MOBILITY_JOURNEY_HOME_PAGE,
					CoreConstants.PASS));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.POLICY_AND_POINTS_DETAILS_NOT_MATCHED_ON_MOBILITYX_JOURNEY_HOME_PAGE,
					CoreConstants.FAIL, actualPolicyName, CoreFunctions.getPropertyFromConfig("Assignment_Policy"),
					actualSpentPoints, 0, actualTotalPoints,
					policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
		}

		return isPolicyPointsDetailsMatched;
	}

	private boolean verifyAssignmentDetails(String actualClientName, String actualFileId, String actualTransfereeName) {

		boolean isAssignmentClientDetailsMatched = (CoreFunctions.getPropertyFromConfig("Assignment_ClientName").equals(
				actualClientName) & CoreFunctions.getPropertyFromConfig("Assignment_FileID").equals(actualFileId)
				& (CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
						+ CoreFunctions.getPropertyFromConfig("Transferee_lastName")).equals(actualTransfereeName));

		if (isAssignmentClientDetailsMatched) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.ASSIGNMENT_DETAILS_MATCHED_ON_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.PASS));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.ASSIGNMENT_DETAILS_NOT_MATCHED_ON_MOBILITYX_JOURNEY_HOME_PAGE,
					CoreConstants.FAIL, actualFileId, CoreFunctions.getPropertyFromConfig("Assignment_FileID"),
					actualTransfereeName, (CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"))));
		}

		return isAssignmentClientDetailsMatched;

	}

	public boolean verifySubmittedPointsDetails() {
		boolean isSubmittedSpentPointsValid = false;
		double spentPointsAfterBenefitSubmission = 0;
		try {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _textInitialSpentAndTotalPoints,
					MobilityXConstants.TRANSFEREE_JOURNEY_POINTS_LINK);
			String spentPointsAfterBenefitSubmissionWithText[] = CoreFunctions
					.getElementText(driver, _textInitialSpentAndTotalPoints).split(" ");
			String actualSubmittedSpentAndTotalPoints[] = spentPointsAfterBenefitSubmissionWithText[0].split("/");
			spentPointsAfterBenefitSubmission = Double.parseDouble(actualSubmittedSpentAndTotalPoints[0]);
			if (spentPointsAfterBenefitSubmission == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints) {
				CoreFunctions.clickElement(driver, _poinBalance_tooltip);
				CoreFunctions.explicitWaitTillElementVisibility(driver, _poinBalance_tooltip_content,
						MobilityXConstants.TRANSFEREE_JOURNEY_TOOLTIP);
				isSubmittedSpentPointsValid = CoreFunctions.getElementText(driver, _poinBalance_tooltip_content)
						.equals(pointBalanceDetails());
				CoreFunctions.clickElement(driver, _close_tootip);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ASSIGNEMENT_AND_SUBMITTED_POINTS_DETAILS,
					CoreConstants.FAIL, e.getMessage()));
			isSubmittedSpentPointsValid = false;
		}
		if (isSubmittedSpentPointsValid) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VALIDATED_ASSIGNEMENT_AND_SUBMITTED_POINTS_DETAILS_ON_TRANSFEREE_JOURNEY_HOME_PAGE,
					CoreConstants.PASS));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.FAILED_TO_UPDATE_SUBMITTED_BENEFIT_POINTS_ON_TRANSFEREE_JOURNEY_PAGE,
					CoreConstants.FAIL, MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints,
					spentPointsAfterBenefitSubmission));
		}
		return isSubmittedSpentPointsValid;
	}

	public String pointBalanceDetails() {
		String total = CoreFunctions.getElementText(driver, _poinBalance_tooltip).split("/")[1].replace(" pts.", "");
		String consumed = CoreFunctions.getElementText(driver, _poinBalance_tooltip).split("/")[0];
		double remaining = Double.parseDouble(total) - Double.parseDouble(consumed);
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.POINT_BALANCE_DETAILS.replace("used_points", consumed).replace("total_points", total)
				.replace("current_balance", format.format(remaining));
	}

	public void progressOrSkipMobilityJourneyHomePage(String action) {
		if (action.equals(MobilityXConstants.ROUTE_TO_TRANSFEREE_JOURNEY_HOME_PAGE)) {
			routeToTransfereeJourney();
		} else {
			routeToFlexPlanningTool();
		}
	}

	public boolean setUpPaymentAccount() {
		try {
			return proceedToAccountSetupPage() && selectAccountType() && setupAccountAndSave();
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_SETTING_UP_USER_ACCOUNT_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean setupAccountAndSave() {
		try {
			CoreFunctions.selectByVisibleText(driver, _select_currency, accountDetails.currency);
			CoreFunctions.clearAndSetText(driver, _accountHolderName, accountDetails.accountHoldersName);
			CoreFunctions.clearAndSetText(driver, _mailingAddress1, accountDetails.mailingAddress.address1);
			CoreFunctions.clearAndSetText(driver, _mailingAddress2, accountDetails.mailingAddress.address2);
			CoreFunctions.clearAndSetText(driver, _mailingCity, accountDetails.mailingAddress.city);
			CoreFunctions.selectByVisibleText(driver, _select_mailingState, accountDetails.mailingAddress.state);
			CoreFunctions.clearAndSetText(driver, _province, accountDetails.mailingAddress.province);
			CoreFunctions.clearAndSetText(driver, _postalCode, accountDetails.mailingAddress.postalCode);
			CoreFunctions.selectByVisibleText(driver, _select_mailingCountry, accountDetails.mailingAddress.country);
			CoreFunctions.clearAndSetText(driver, _accountClosingDate,
					accountDetails.mailingAddress.accountClosingDate);
			CoreFunctions.clickElement(driver, _btn_submit);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _successGrowlMessage,
					MobilityXConstants.SAVED_SUCCESSFUL_GROWL_MESSAGE);
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _successGrowlMessage);
			CoreFunctions.clickElement(driver, _btn_save);
			CoreFunctions.clickElement(driver, _link_backToMobilityJourney);
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.SUCCESSFULLY_ADDED_PAYMENT_ACCOUNT, CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.PAYMENT_ACCOUNT_SETUP_FAILED,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean selectAccountType() {
		try {
			CoreFunctions.selectByVisibleText(driver, _select_accountType, accountDetails.accountType);
			CoreFunctions.clickElement(driver, _btn_continue);
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.SUCCESSFULLY_SELECTED_ACCOUNT_TYPE, CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.FAILED_TO_SELECT_ACCOUNT_TYPE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean proceedToAccountSetupPage() {
		try {
			CoreFunctions.clickElement(driver, _link_transferee_dropdown);
			CoreFunctions.clickElement(driver, _optionBanking);
			CoreFunctions.clickElement(driver, _link_addPaymentAccount);
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.ACCOUNT_SETUP_PAGE_IS_DISPLAYED_SUCCESSFULLY,
					CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.FAILED_TO_LOAD_ACCOUNT_SETUP_FORM,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyBenefitSubmissionEmail() {
		try {
			// Reading Transferee Username and Password from email and writing to the Config
			// Properties File
			String host = "outlook.office365.com";
			// Enter Your Email ID
			String userName = "airesautomation@aires.com";
			// Enter your email outlook password
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			// Enter expected From complete email address
			String expFromUserName = "testrelonet@aires.com";
			// Enter expected email subject
			String expEmailSubject = "Mobility Flex Benefit(s) Submission";
			String actualResultSubmissionDetails = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject, MobilityXConstants.FLEX_BENEFIT_SUBMISSION);
			actualResultSubmissionDetails = actualResultSubmissionDetails.replace("<span>", "").replace("</span>", "")
					.replace("\r\n", "").trim();
			Reporter.addStepLog(
					CoreConstants.PASS + "Successfully verified Mobility Flex Benefit(s) Submission Email.");
			return actualResultSubmissionDetails.equals(submittedPointsEmailMessage());
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_CREDENTIALS_FROM_EMAIL,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private String submittedPointsEmailMessage() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		String total = policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable;
		double remaining = MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission;
		double consumed = Double.parseDouble(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable)
				- remaining;
		return MobilityXConstants.FLEX_BENEFITS_SUBMISSION_MESSAGE
				.replace("used_points", String.valueOf(format.format(consumed))).replace("total_points", total)
				.replace("current_balance", String.valueOf(format.format(remaining)));
	}
}
