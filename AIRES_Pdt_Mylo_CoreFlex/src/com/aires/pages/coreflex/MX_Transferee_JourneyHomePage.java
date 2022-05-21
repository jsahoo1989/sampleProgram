package com.aires.pages.coreflex;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
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
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.CoreFlex_SettlingInBenefitsData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
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

	@FindBy(how = How.CSS, using = "iframe[class*='appcues-tooltip-container']")
	private WebElement _tooltipIFrame;

	@FindBy(how = How.CSS, using = "div[class*='appcues-actions-right'] > a")
	private WebElement _tooltipIFrameNextButton;

	@FindBy(how = How.CSS, using = "div[class='appcues-actions-left'] > small")
	private WebElement _tooltipIFrameHideLink;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'cfcardstatus')]//span[contains(text(),'There are no services set up yet.')]")
	private WebElement _serviceNotSetupCFCard;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> flexCardPanelList;

	private By flexCardBeginTrainingStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Begin training')]");

	private By flexCardTrainingCompletedStatus = By
			.xpath(".//span[contains(@class,'RXSmallerTextMuted RXBold')][contains(text(),'Training complete')]");

	private By manageThisBenefitButton = By
			.xpath(".//a[contains(@class,'RXCFGreenCardSmallRoundedButton')]//span[@class='RXWhite]");

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> coreCardPanelList;

	private By coreCardBeginTrainingStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Begin training')]");

	private By coreCardTrainingCompletedStatus = By
			.xpath(".//span[contains(@class,'RXSmallerTextMuted RXBold')][contains(text(),'Training complete')]");

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//span[contains(@class,'RCFXMJHeadingText')]")
	private List<WebElement> flexCardBenefitDisplayName;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//span[contains(@class,'RCFXMJSubHeadingText')]")
	private List<WebElement> flexCardAmountAllowanceText;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//div[contains(@class,'RXCFCircle')]//span")
	private List<WebElement> flexCardNumberOfBenefitSelected;

	@FindBy(how = How.CSS, using = "div.RXFlexBeneftsPointsTooltiptext  > div > span")
	private List<WebElement> flexCardNumberOfBenefitSelectedToolTipText;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]")
	private List<WebElement> flexCardStartingSoonStatusList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Canceled')]")
	private List<WebElement> flexCardCancelledStatusList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]")
	private WebElement flexCardStartingSoonStatus;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//span[contains(@class,'icon-help')]")
	private List<WebElement> flexCardLongDescIcon;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//div[contains(@class,'RXFlexBeneftsMjTooltiptext')]//span[contains(@class,'RXWrappedText')]")
	private List<WebElement> flexCardLongDesc;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//a[contains(@class,'RXCFGreenCardSmallRoundedButton ')]//span[@class='RXWhite']")
	private List<WebElement> flexCardManageBenefitButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//a[contains(@class,'RXCFGreenCardSmallRoundedButton ')]//span[@class='RXWhite']")
	private WebElement flexCardManageThisBenefitButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//span[contains(@class,'RCFXMJHeadingText')]")
	private List<WebElement> coreCardBenefitDisplayName;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//span[contains(@class,'RCFXMJSubHeadingText')]")
	private List<WebElement> coreCardAmountAllowanceText;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]")
	private List<WebElement> coreCardStartingSoonStatusList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Canceled')]")
	private List<WebElement> coreCardCancelledStatusList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]")
	private WebElement coreCardStartingSoonStatus;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//span[contains(@class,'icon-help')]")
	private List<WebElement> coreCardLongDescIcon;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//div[contains(@class,'RXFlexBeneftsMjTooltiptext')]//span[contains(@class,'RXWrappedText')]")
	private List<WebElement> coreCardLongDesc;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//a[contains(@class,'RXCFGreenCardSmallRoundedButton ')]//span[@class='RXWhite']")
	private WebElement coreCardManageBenefitButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Begin training')]")
	private WebElement coreCardBeginProgressStatus;

	/*********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	MX_Transferee_AccountSetupDetails accountDetails = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMxTransfereeAccountSetupDetails();

	public static final List<FlexBenefit> airesManagedFlexBenefits = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getMXTransfereeAiresManagedFlexBenefitData();

	public static final List<Benefit> airesManagedCoreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeAiresManagedCoreBenefitData();

	CoreFlex_SettlingInBenefitsData languageTrainingBenefitData = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getSettlingInBenefitDataList(COREFLEXConstants.LANGUAGE_TRAINING);

	/*********************************************************************/

	public void clickElementOfPage(String elementName) {
		switch (elementName) {
		case MobilityXConstants.MANAGE_MY_POINTS:
			CoreFunctions.clickUsingJS(driver, _linkManageMyPoints, MobilityXConstants.MANAGE_MY_POINTS);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
		}
	}

	public boolean verifyUserNavigationToJourneyHomePage() {
		try {
			return CoreFunctions.isElementExist(driver, _linkManageMyPoints, 10);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
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

	public void switchToTooltipIFrameAndPerformAction(String action, int time) {
		if (CoreFunctions.isElementExist(driver, _tooltipIFrame, time)) {
			driver.switchTo().frame(_tooltipIFrame);
			switch (action) {
			case MobilityXConstants.NEXT:
				CoreFunctions.clickElement(driver, _tooltipIFrameNextButton);
				break;
			case MobilityXConstants.HIDE:
				CoreFunctions.clickElement(driver, _tooltipIFrameHideLink);
				break;
			default:
				Assert.fail(MobilityXConstants.NO_ELEMENT_FOUND);
				break;
			}
			driver.switchTo().defaultContent();
		}
	}

	public boolean verifyAssignmentAndPolicyDetails() {
		boolean isAssignmentClientDetailsMatched = false, isPolicyPointsDetailsMatched = false;
		boolean isDetailsMatched = false;
		try {
			switchToTooltipIFrameAndPerformAction(MobilityXConstants.HIDE, 10);
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
		Log.info(CoreFunctions.getPropertyFromConfig("Assignment_ClientName").equals(actualClientName) + "");
		Log.info(CoreFunctions.getPropertyFromConfig("Assignment_FileID").equals(actualFileId) + "");
		Log.info((CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
				+ CoreFunctions.getPropertyFromConfig("Transferee_lastName")) + ":" + (actualTransfereeName) + "");

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
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				return proceedToAccountSetupPage() && selectAccountType() && setupAccountAndSave();
			} else
				return true;
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

	public boolean verifyAiresManagedBenefitCardNotDisplayed() {
		return CoreFunctions.isElementExist(driver, _serviceNotSetupCFCard, 10);
	}

	public boolean isFlexBenefitCardVerified(String expectedStatus) {
		try {
			return verifyFlexBenefitCardDetails(expectedStatus);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	private boolean verifyFlexBenefitCardStatusAfterStartDateActualization(int indexBenefitCard,
			String expectedStatus) {
		try {
			if (CoreFunctions.isElementExist(driver,
					CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), flexCardBeginTrainingStatus),
					3) && (!CoreFunctions.isElementExist(driver, flexCardStartingSoonStatus, 3))) {
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, expectedStatus));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyFlexBenefitCardStatusAfterEndDateActualization(int indexBenefitCard, String expectedStatus) {
		try {
			if (CoreFunctions.isElementExist(driver,
					CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
							flexCardTrainingCompletedStatus),
					3) && (!CoreFunctions.isElementExist(driver, flexCardStartingSoonStatus, 3))) {

				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, expectedStatus));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyFlexBenefitCardStatusBeforeActualization(int indexBenefitCard, String expectedStatus) {
		try {
			if (CoreFunctions.isElementExist(driver, flexCardStartingSoonStatusList.get(indexBenefitCard), 3)) {
				CoreFunctions.highlightObject(driver, flexCardStartingSoonStatusList.get(indexBenefitCard));
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, expectedStatus));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyFlexBenefitCardStatusAfterCancellation(int indexBenefitCard, String expectedStatus) {
		try {
			if (CoreFunctions.isElementExist(driver, flexCardCancelledStatusList.get(indexBenefitCard), 3)) {
				CoreFunctions.highlightObject(driver, flexCardCancelledStatusList.get(indexBenefitCard));
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, expectedStatus));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyFlexBenefitCardDetails(String expectedStatus) {
		boolean isFlexCardDetailsVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : airesManagedFlexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefitCard = BusinessFunctions.returnindexItemFromListUsingText(driver,
								flexCardBenefitDisplayName, benefit.getBenefitDisplayName());
						isFlexCardDetailsVerified = verifyFlexCardDetails(indexBenefitCard, benefit)
								&& verifyFlexCardStatus(indexBenefitCard, expectedStatus)
								&& verifyManageThisBenefitButton(indexBenefitCard, expectedStatus);
						if (!isFlexCardDetailsVerified) {
							return false;
						} else {
							flag = true;
						}
					} else {
						isFlexCardDetailsVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isFlexCardDetailsVerified && flag) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.PASS));
		}
		return isFlexCardDetailsVerified;
	}

	private boolean verifyManageThisBenefitButton(int indexBenefitCard, String expectedStatus) {
		try {
			if ((expectedStatus.equals(MobilityXConstants.CANCELLED))
					|| (expectedStatus.equals(MobilityXConstants.COMPLETE))) {
				return (!CoreFunctions.isElementExist(driver, flexCardManageThisBenefitButton, 3));
			} else {
				CoreFunctions.verifyText(driver, flexCardManageBenefitButton.get(indexBenefitCard),
						MobilityXConstants.MANAGE_THIS_BENEFIT,
						MobilityXConstants.FLEX_CARD_MANAGE_THIS_BENEFIT_BUTTON);
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_MANAGE_THIS_BENEFIT_BUTTON,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}

	}

	private boolean verifyFlexCardStatus(int indexBenefitCard, String expectedStatus) {
		boolean isFlexBenefitCardStatusVerified = false;
		try {
			switch (expectedStatus) {
			case MobilityXConstants.STARTING_SOON:
				isFlexBenefitCardStatusVerified = verifyFlexBenefitCardStatusBeforeActualization(indexBenefitCard,
						expectedStatus);
				break;
			case MobilityXConstants.BEGIN_TRAINING:
				isFlexBenefitCardStatusVerified = verifyFlexBenefitCardStatusAfterStartDateActualization(
						indexBenefitCard, expectedStatus);
				break;
			case MobilityXConstants.TRAINING_COMPLETE:
				isFlexBenefitCardStatusVerified = verifyFlexBenefitCardStatusAfterEndDateActualization(indexBenefitCard,
						expectedStatus);
				break;
			case MobilityXConstants.CANCELLED:
				isFlexBenefitCardStatusVerified = verifyFlexBenefitCardStatusAfterCancellation(indexBenefitCard,
						expectedStatus);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return isFlexBenefitCardStatusVerified;
	}

	private boolean verifyFlexCardDetails(int indexBenefitCard, Benefit benefit) {
		try {
			CoreFunctions.verifyText(driver, flexCardBenefitDisplayName.get(indexBenefitCard),
					benefit.getBenefitDisplayName(), MobilityXConstants.FLEX_CARD_BENEFIT_DISPLAY_NAME);
			CoreFunctions.verifyText(driver, flexCardAmountAllowanceText.get(indexBenefitCard),
					benefit.getBenefitAmount(), MobilityXConstants.FLEX_CARD_BENEFIT_ALLOWANCE_AMOUNT);
			CoreFunctions.verifyText(driver, flexCardNumberOfBenefitSelected.get(indexBenefitCard),
					String.valueOf(benefit.getNumberOfBenefitSelected()),
					MobilityXConstants.FLEX_CARD_NUMBER_OF_BENEFIT_SELECTED);
			CoreFunctions.moveToElement(driver, flexCardNumberOfBenefitSelected.get(indexBenefitCard));
			CoreFunctions.verifyText(driver, flexCardNumberOfBenefitSelectedToolTipText.get(indexBenefitCard),
					MobilityXConstants.FLEX_CARD_NUMBER_OF_BENEFIT_SELECTED_TOOLTIP_TEXT.replace("numberOf",
							String.valueOf(benefit.getNumberOfBenefitSelected())),
					MobilityXConstants.FLEX_CARD_NUMBER_OF_BENEFIT_SELECTED_TOOLTIP);
			CoreFunctions.moveToElement(driver, flexCardLongDescIcon.get(indexBenefitCard));
			CoreFunctions.verifyText(driver, flexCardLongDesc.get(indexBenefitCard), benefit.getBenefitDesc(),
					MobilityXConstants.FLEX_CARD_BENEFIT_LONG_DESCRIPTION);
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.PASS, flexCardBenefitDisplayName.get(indexBenefitCard).getText()));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.FAIL, flexCardBenefitDisplayName.get(indexBenefitCard)));
			return false;
		}
	}

	public boolean isCoreBenefitCardVerified(String expectedStatus) {
		try {
			return verifyCoreBenefitCardDetails(expectedStatus);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	private boolean verifyCoreBenefitCardDetails(String expectedStatus) {
		boolean isCoreCardDetailsVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : airesManagedCoreBenefits) {
				int indexBenefitCard = BusinessFunctions.returnindexItemFromListUsingText(driver,
						coreCardBenefitDisplayName, benefit.getBenefitDisplayName());
				isCoreCardDetailsVerified = verifyCoreCardDetails(indexBenefitCard, benefit)
						&& verifyCoreCardStatus(indexBenefitCard, expectedStatus);
				if (!isCoreCardDetailsVerified) {
					return false;
				} else {
					flag = true;
				}
			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isCoreCardDetailsVerified && flag) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_CARD_DETAILS,
					CoreConstants.PASS));
		}
		return isCoreCardDetailsVerified;
	}

	private boolean verifyCoreCardDetails(int indexBenefitCard, Benefit benefit) {
		try {
			CoreFunctions.scrollToElementUsingJS(driver, _textPolicyFileID, MobilityXConstants.POLICY_FILE_ID);
			CoreFunctions.verifyText(driver, coreCardBenefitDisplayName.get(indexBenefitCard),
					benefit.getBenefitDisplayName(), MobilityXConstants.CORE_CARD_BENEFIT_DISPLAY_NAME);
			CoreFunctions.verifyText(driver, coreCardAmountAllowanceText.get(indexBenefitCard),
					benefit.getBenefitAmount(), MobilityXConstants.CORE_CARD_BENEFIT_ALLOWANCE_AMOUNT);
			CoreFunctions.moveToElement(driver, coreCardLongDescIcon.get(indexBenefitCard));
			CoreFunctions.verifyText(driver, coreCardLongDesc.get(indexBenefitCard), benefit.getBenefitDesc(),
					MobilityXConstants.CORE_CARD_BENEFIT_LONG_DESCRIPTION);
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_CARD_DETAILS,
					CoreConstants.PASS, coreCardBenefitDisplayName.get(indexBenefitCard)));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	private boolean verifyCoreCardStatus(int indexBenefitCard, String expectedStatus) {
		boolean isCoreBenefitCardStatusVerified = false;
		try {
			switch (expectedStatus) {
			case MobilityXConstants.STARTING_SOON:
				isCoreBenefitCardStatusVerified = verifyCoreBenefitCardStatusBeforeActualization(indexBenefitCard,
						expectedStatus);
				break;
			case MobilityXConstants.BEGIN_TRAINING:
				isCoreBenefitCardStatusVerified = verifyCoreBenefitCardStatusAfterStartDateActualization(
						indexBenefitCard, expectedStatus);
				break;
			case MobilityXConstants.TRAINING_COMPLETE:
				isCoreBenefitCardStatusVerified = verifyCoreBenefitCardStatusAfterEndDateActualization(indexBenefitCard,
						expectedStatus);
				break;
			case MobilityXConstants.CANCELLED:
				isCoreBenefitCardStatusVerified = verifyCoreBenefitCardStatusAfterCancellation(indexBenefitCard,
						expectedStatus);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return isCoreBenefitCardStatusVerified;
	}

	private boolean verifyCoreBenefitCardStatusAfterStartDateActualization(int indexBenefitCard,
			String expectedStatus) {
		try {
			if (CoreFunctions.isElementExist(driver,
					CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), coreCardBeginTrainingStatus),
					3) && (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3))) {
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, expectedStatus));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyCoreBenefitCardStatusAfterEndDateActualization(int indexBenefitCard, String expectedStatus) {
		try {
			if (CoreFunctions.isElementExist(driver,
					CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
							coreCardTrainingCompletedStatus),
					3) && (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3))) {
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, expectedStatus));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyCoreBenefitCardStatusBeforeActualization(int indexBenefitCard, String expectedStatus) {
		try {
			if (CoreFunctions.isElementExist(driver, coreCardStartingSoonStatusList.get(indexBenefitCard), 3)) {
				CoreFunctions.highlightObject(driver, coreCardStartingSoonStatusList.get(indexBenefitCard));
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, expectedStatus));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyCoreBenefitCardStatusAfterCancellation(int indexBenefitCard, String expectedStatus) {
		try {
			if (CoreFunctions.isElementExist(driver, coreCardCancelledStatusList.get(indexBenefitCard), 3)) {
				CoreFunctions.highlightObject(driver, coreCardCancelledStatusList.get(indexBenefitCard));
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, expectedStatus));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyFlexCardForNotSubmittedAiresManagedBenefit() {
		try {
			if (verifyFlexCardNotDisplayed()) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_NOT_DISPLAYED_FOR_NOT_SUBMITTED_AIRES_MANAGED_BENEFIT,
						CoreConstants.PASS));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_FOR_NOT_SUBMITTED_AIRES_MANAGED_BENEFIT,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyFlexCardNotDisplayedAfterUpdatingSubServiceType() {
		try {
			if (verifyFlexCardNotDisplayed()) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_NOT_DISPLAYED_ON_MOBILITY_JOURNEY_PAGE_AFTER_CHANGING_COREFLEX_SUBSERVICE_TYPE_IN_IRIS_APPLICATION,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_NOT_DISPLAYED_ON_MOBILITY_JOURNEY_PAGE_AFTER_CHANGING_COREFLEX_SUBSERVICE_TYPE_IN_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyFlexCardNotDisplayed() {
		boolean isFlexCardNotDisplayed = false;
		for (FlexBenefit benefitList : airesManagedFlexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					int indexBenefitCard = BusinessFunctions.returnindexItemFromListUsingText(driver,
							flexCardBenefitDisplayName, benefit.getBenefitDisplayName());
					if (indexBenefitCard == -1) {
						isFlexCardNotDisplayed = true;
					} else {
						return false;
					}
				}
			}
		}
		return isFlexCardNotDisplayed;
	}

	public boolean verifyCoreCardNotDisplayedAfterUpdatingSubServiceType() {
		try {
			if (verifyCoreCardNotDisplayed()) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_CARD_NOT_DISPLAYED_ON_MOBILITY_JOURNEY_PAGE_AFTER_CHANGING_COREFLEX_SUBSERVICE_TYPE_IN_IRIS_APPLICATION,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_NOT_DISPLAYED_ON_MOBILITY_JOURNEY_PAGE_AFTER_CHANGING_COREFLEX_SUBSERVICE_TYPE_IN_IRIS_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyCoreCardNotDisplayed() {
		boolean isCoreCardNotDisplayed = false;
		for (Benefit benefit : airesManagedCoreBenefits) {
			int indexBenefitCard = BusinessFunctions.returnindexItemFromListUsingText(driver,
					coreCardBenefitDisplayName, benefit.getBenefitDisplayName());
			if (indexBenefitCard == -1) {
				isCoreCardNotDisplayed = true;
			} else {
				return false;
			}

		}
		return isCoreCardNotDisplayed;
	}

}
