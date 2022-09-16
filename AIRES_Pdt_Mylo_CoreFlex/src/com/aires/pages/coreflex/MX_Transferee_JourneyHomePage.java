package com.aires.pages.coreflex;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@FindBy(how = How.CSS, using = "span[id*='titleCheckAddAccounta']")
	private WebElement _titleAddPaymentAccount;	

	@FindBy(how = How.XPATH, using = "//span[text()='Back to mobility journey']")
	private WebElement _link_backToMobilityJourney;

	@FindBy(how = How.CSS, using = "iframe[class*='appcues-tooltip-container']")
	private WebElement _tooltipIFrame;

	@FindBy(how = How.CSS, using = "div[class*='appcues-actions-right'] > a")
	private WebElement _tooltipIFrameNextButton;

	@FindBy(how = How.CSS, using = "a[class='text-muted appcues-skip']")
	private WebElement _tooltipIFrameHideLink;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'cfcardstatus')]//span[contains(text(),'There are no services set up yet.')]")
	private WebElement _serviceNotSetupCFCard;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> flexCardPanelList;

	private By travelRequested = By.xpath("div[4]//span[text()='Travel Requested']");
	private By travelBooked = By.xpath("div[4]//span[text()='Travel Booked']");
	private By travelBegins = By.xpath("div[4]//span[text()='Travel Begins']");
	private By travelEnds = By.xpath("div[4]//span[text()='Travel Ends']");

	private By flexCardBeginTrainingStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Begin training')]");

	private By beginTrainingEstimatedDate = By.xpath(".//div[5]//span[not(contains(text(),'estimated'))]");
	private By autoPickupEstimatedDate = By.xpath(".//div[5]//span[not(contains(text(),'estimated'))]");

	private By trainingCompletedActualizedDate = By
			.xpath(".//div[5]//span[not(contains(text(),'estimated'))][@class='RXSmallerTextMuted RXBold']");

	private By flexCardMoveInStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Move In')]");

	private By moveInEstimatedDate = By.xpath(".//div[5]//span[not(contains(text(),'estimated'))]");

	private By moveOutActualizedDate = By
			.xpath(".//div[5]//span[not(contains(text(),'estimated'))][@class='RXSmallerTextMuted RXBold']");

	private By flexCardMoveOutStatus = By.xpath(
			".//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Move out')]");

	private By flexCardTrainingCompletedStatus = By.xpath(
			".//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Training complete')]");

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> coreCardPanelList;

	private By coreCardBeginTrainingStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Begin training')]");

	private By coreCardMoveInStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Move In')]");

	private By coreCardMoveOutStatus = By.xpath(
			".//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Move out')]");

	private By coreCardTrainingCompletedStatus = By.xpath(
			".//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Training complete')]");

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

	private By flexCardStartingSoonStatusBy = By
			.xpath(".//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]");

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Cancelled')]")
	private List<WebElement> flexCardCancelledStatusList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]")
	private WebElement flexCardStartingSoonStatus;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//span[contains(@class,'icon-help')]")
	private List<WebElement> flexCardLongDescIcon;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//div[contains(@class,'RXFlexBeneftsMjTooltiptext')]//span[contains(@class,'RXWrappedText')]")
	private List<WebElement> flexCardLongDesc;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//a[contains(@class,'RXCFGreenCardSmallRoundedButton ')]//span[@class='RXWhite']")
	private List<WebElement> flexCardManageBenefitButton;

	private By flexCardManageBenefitButtonBy = By
			.xpath(".//a[contains(@class,'RXCFGreenCardSmallRoundedButton ')]//span[@class='RXWhite']");

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//a[contains(@class,'RXCFGreenCardSmallRoundedButton ')]//span[@class='RXWhite']")
	private WebElement flexCardManageThisBenefitButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//span[contains(@class,'RCFXMJHeadingText')]")
	private List<WebElement> coreCardBenefitDisplayName;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//span[contains(@class,'RCFXMJSubHeadingText')]")
	private List<WebElement> coreCardAmountAllowanceText;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]")
	private List<WebElement> coreCardStartingSoonStatusList;

	private By coreCardStartingSoonStatusBy = By
			.xpath(".//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]");

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Cancelled')]")
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

	private By coreCardAutoPickupStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Auto pickup')]");

	private By coreCardBeginServiceStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Begin service')]");

	private By coreCardRegistrationScheduledStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Registration scheduled')]");

	private By coreCardBeginTourStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Begin tour')]");

	private By coreCardFurnitureDeliveryStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Furniture Delivery')]");

	private By coreCardAirportPickupStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Appointment Confirmed')]");

	/*********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	MX_Transferee_AccountSetupDetails accountDetails = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMxTransfereeAccountSetupDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	CoreFlex_SettlingInBenefitsData languageTrainingBenefitData = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getSettlingInBenefitDataList(COREFLEXConstants.LANGUAGE_TRAINING);

	private By flexCardAutoPickupStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Auto pickup')]");

	private By flexCardBeginServiceStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Begin service')]");

	private By beginServiceEstimatedDate = By.xpath(".//div[5]//span[not(contains(text(),'estimated'))]");

	private By flexCardRegistrationScheduledStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Registration scheduled')]");

	private By registrationScheduledEstimatedDate = By.xpath(".//div[5]//span[not(contains(text(),'estimated'))]");

	private By flexCardBeginTourStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Begin tour')]");

	private By beginTourEstimatedDate = By.xpath(".//div[5]//span[not(contains(text(),'estimated'))]");

	private By flexCardFurnitureDeliveryStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Furniture Delivery')]");

	private By furnitureDeliveryEstimatedDate = By.xpath(".//div[5]//span[not(contains(text(),'estimated'))]");

	private By flexCardAirportPickupStatus = By
			.xpath(".//span[contains(@class,'RXSmallerLink RXBold')][contains(text(),'Appointment Confirmed')]");

	private By airportPickupEstimatedDate = By.xpath(".//div[5]//span[not(contains(text(),'estimated'))]");

	private By arrivalEstimatedDate = By
			.xpath(".//div[5]//span[not(contains(text(),'estimated'))][@class='RXSmallerTextMuted RXBold']");

	private By flexCardArrivalStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Arrival / meet and greet')]");

	private By furniturePickUpEstimatedDate = By
			.xpath(".//div[5]//span[not(contains(text(),'estimated'))][@class='RXSmallerTextMuted RXBold']");

	private By flexCardFurniturePickUpStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Furniture Pick Up')]");

	private By tourCompleteEstimatedDate = By
			.xpath(".//div[5]//span[not(contains(text(),'estimated'))][@class='RXSmallerTextMuted RXBold']");

	private By flexCardTourCompleteStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Tour complete')]");

	private By registrationCompletedEstimatedDate = By
			.xpath(".//div[5]//span[not(contains(text(),'estimated'))][@class='RXSmallerTextMuted RXBold']");

	private By flexCardRegistrationCompletedStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Registration completed')]");

	private By serviceCompleteEstimatedDate = By
			.xpath(".//div[5]//span[not(contains(text(),'estimated'))][@class='RXSmallerTextMuted RXBold']");

	private By flexCardServiceCompleteStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Service complete')]");

	private By autoReturnEstimatedDate = By
			.xpath(".//div[5]//span[not(contains(text(),'estimated'))][@class='RXSmallerTextMuted RXBold']");

	private By flexCardAutoReturnStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Auto return')]");

//	private By coreCardArrivalStatus = By.xpath(
//			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Arrival / meet and greet')]");

	private By coreCardFurniturePickUpStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Furniture Pick Up')]");

	private By coreCardTourCompleteStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Tour complete')]");

	private By coreCardRegistrationCompletedStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Registration completed')]");

	private By coreCardServiceCompleteStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Service complete')]");

	private By coreCardAutoReturnStatus = By.xpath(
			"//span[contains(@class,'ServicesSuccessIcon ')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Auto return')]");

	private By _serviceCompleted = By
			.cssSelector("span[class='RXBigIconPrimary ServicesSuccessIcon icon-check-approved']");

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
				& actualTotalPoints.equals(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"));

		if (isPolicyPointsDetailsMatched) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.POLICY_AND_POINTS_DETAILS_MATCHED_ON_MOBILITY_JOURNEY_HOME_PAGE,
					CoreConstants.PASS));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.POLICY_AND_POINTS_DETAILS_NOT_MATCHED_ON_MOBILITYX_JOURNEY_HOME_PAGE,
					CoreConstants.FAIL, actualPolicyName, CoreFunctions.getPropertyFromConfig("Assignment_Policy"),
					actualSpentPoints, 0, actualTotalPoints,
					CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")));
		}

		return isPolicyPointsDetailsMatched;
	}

	private boolean verifyAssignmentDetails(String actualClientName, String actualFileId, String actualTransfereeName) {
		Log.info(CoreFunctions.getPropertyFromConfig("Assignment_ClientName").equals(actualClientName) + "");
		Log.info(CoreFunctions.getPropertyFromConfig("Assignment_FileID").equals(actualFileId) + "");
		Log.info((CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
				+ CoreFunctions.getPropertyFromConfig("Transferee_lastName")) + ":" + (actualTransfereeName) + "");

		boolean isAssignmentClientDetailsMatched = (CoreFunctions.getPropertyFromConfig("Assignment_ClientName").equalsIgnoreCase(
				actualClientName) & CoreFunctions.getPropertyFromConfig("Assignment_FileID").equals(actualFileId)
				& (CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
						+ CoreFunctions.getPropertyFromConfig("Transferee_lastName")).equalsIgnoreCase(actualTransfereeName));

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
			if (spentPointsAfterBenefitSubmission == (Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints")))) {
				CoreFunctions.clickElement(driver, _poinBalance_tooltip);
				CoreFunctions.explicitWaitTillElementVisibility(driver, _poinBalance_tooltip_content,
						MobilityXConstants.TRANSFEREE_JOURNEY_TOOLTIP);
				isSubmittedSpentPointsValid = CoreFunctions.getElementText(driver, _poinBalance_tooltip_content)
						.equals(pointBalanceDetailsMobilityJourneyPage());
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
					CoreConstants.FAIL, (Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))),
					spentPointsAfterBenefitSubmission));
		}
		return isSubmittedSpentPointsValid;
	}

	public String pointBalanceDetailsMobilityJourneyPage() {
		String total = CoreFunctions.getElementText(driver, _poinBalance_tooltip).split("/")[1].replace(" pts.", "");
		String consumed = CoreFunctions.getElementText(driver, _poinBalance_tooltip).split("/")[0];
		double remaining = Double.parseDouble(total) - Double.parseDouble(consumed);
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.POINT_BALANCE_DETAILS.replace("used_points", consumed).replace("total_points", total)
				.replace("current_balance", format.format(remaining));
	}
	
	public String pointBalanceDetailsFlexPlanningToolPage() {
		String total = CoreFunctions.getElementText(driver, _poinBalance_tooltip).split("/")[1].replace(" pts.", "");
		String consumed = CoreFunctions.getElementText(driver, _poinBalance_tooltip).split("/")[0];
		double remaining = Double.parseDouble(total) - Double.parseDouble(consumed);
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.POINT_BALANCE_DETAILS_FPT.replace("used_points", consumed).replace("total_points", total)
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
//			CoreFunctions.selectByVisibleText(driver, _select_currency, accountDetails.currency);
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _titleAddPaymentAccount, COREFLEXConstants.ADD_PAYMENT_ACCOUNT);
			CoreFunctions.highlightObject(driver, _titleAddPaymentAccount);
			CoreFunctions.clearAndSetText(driver, _mailingAddress1, accountDetails.mailingAddress.address1);
			CoreFunctions.clearAndSetText(driver, _accountHolderName, accountDetails.accountHoldersName);			
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

	public boolean isFlexBenefitCardVerified(String expectedStatus, String tracingSelection) {
		try {
			return verifyFlexBenefitCardDetails(expectedStatus, tracingSelection);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	private boolean verifyFlexBenefitCardStatusAfterInitialActualization(int indexBenefitCard, String expectedStatus,
			Benefit benefit, String expectedEstimatedDate) {
		boolean isFlexCardStatusVerified = false;
		Log.info("benfit name: " + benefit.getBenefitType());
		try {
			switch (benefit.getBenefitType()) {
			case COREFLEXConstants.LANGUAGE_TRAINING:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardBeginTrainingStatus),
						3))
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										beginTrainingEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3));
				break;
			case COREFLEXConstants.TEMPORARY_LIVING:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), flexCardMoveInStatus), 3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										moveInEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.CULTURAL_TRAINING:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardBeginTrainingStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										beginTrainingEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.AUTO_RENTAL_DURING_ASSIGNMENT:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), flexCardAutoPickupStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										autoPickupEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.CONCIERGE_SERVICES:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardBeginServiceStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										beginServiceEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.EDUCATION_ASSISTANCE_SCHOOL_SEARCH:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardRegistrationScheduledStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										registrationScheduledEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.AREA_TOUR:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), flexCardBeginTourStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										beginTourEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.FURNITURE_RENTAL:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardFurnitureDeliveryStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										furnitureDeliveryEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.AIRPORT_PICKUP:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardAirportPickupStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										airportPickupEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.HOUSE_HUNTING_TRIP:
			case COREFLEXConstants.FINAL_MOVE:
			case COREFLEXConstants.HOME_LEAVE:
			case COREFLEXConstants.PRE_ACCEPTANCE_SERVICES:
				isFlexCardStatusVerified = CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), travelRequested), 3)
						&& CoreFunctions.isElementExist(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), travelBooked), 3)
						&& CoreFunctions.isElementExist(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), travelBegins), 3)
						&& CoreFunctions.isElementExist(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), travelEnds), 3);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);

			}

			if (isFlexCardStatusVerified) {
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, benefit.getBenefitType()));
			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return isFlexCardStatusVerified;
	}

	private boolean verifyFlexBenefitCardStatusAfterEndActualization(int indexBenefitCard, String expectedStatus,
			Benefit benefit, String expectedEstimatedDate) {
		boolean isFlexCardStatusVerified = false;
		try {

			switch (benefit.getBenefitType()) {
			case COREFLEXConstants.LANGUAGE_TRAINING:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardTrainingCompletedStatus),
						3))
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										trainingCompletedActualizedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3));
				break;
			case COREFLEXConstants.TEMPORARY_LIVING:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), flexCardMoveOutStatus), 3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										moveOutActualizedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.CULTURAL_TRAINING:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardTrainingCompletedStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										trainingCompletedActualizedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.AUTO_RENTAL_DURING_ASSIGNMENT:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), flexCardAutoReturnStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										autoReturnEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, flexCardStartingSoonStatus, 3)));
				break;
			case COREFLEXConstants.CONCIERGE_SERVICES:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardServiceCompleteStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										serviceCompleteEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.EDUCATION_ASSISTANCE_SCHOOL_SEARCH:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardRegistrationCompletedStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										registrationCompletedEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.AREA_TOUR:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardTourCompleteStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										tourCompleteEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.FURNITURE_RENTAL:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardFurniturePickUpStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										furniturePickUpEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.AIRPORT_PICKUP:
				isFlexCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), flexCardArrivalStatus), 3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
										arrivalEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.HOUSE_HUNTING_TRIP:
			case COREFLEXConstants.FINAL_MOVE:
			case COREFLEXConstants.HOME_LEAVE:
			case COREFLEXConstants.PRE_ACCEPTANCE_SERVICES:
				isFlexCardStatusVerified = CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), travelRequested), 3)
						&& CoreFunctions.isElementExist(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), travelBooked), 3)
						&& CoreFunctions.isElementExist(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), travelBegins), 3)
						&& CoreFunctions.isElementExist(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), travelEnds), 3);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);

			}
			if (isFlexCardStatusVerified) {
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, benefit.getBenefitType()));
			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return isFlexCardStatusVerified;
	}

	private boolean verifyFlexBenefitCardStatusBeforeActualization(int indexBenefitCard, String expectedStatus) {
		try {
			if (CoreFunctions.isElementExist(driver,
					CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy),
					3)) {
				CoreFunctions.highlightObject(driver, CoreFunctions
						.findSubElement(flexCardPanelList.get(indexBenefitCard), flexCardStartingSoonStatusBy));
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

	public boolean verifyFlexBenefitCardDetailsOfAiresManagedBenefits(String expectedStatus, String tracingSelection,
			int getNoOfMilestones) {
		boolean isFlexCardDetailsVerified = false;
		boolean flag = false;
		String expectedEstimatedDate = CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy");
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))
							&& benefit.getNoOfMilestones() != null
							&& getNoOfMilestones == benefit.getNoOfMilestones()) {
						int indexBenefitCard = BusinessFunctions.returnindexItemFromListUsingText(driver,
								flexCardBenefitDisplayName, benefit.getBenefitDisplayName());
						isFlexCardDetailsVerified = verifyFlexCardDetails(indexBenefitCard, benefit)
								&& verifyFlexCardStatus(indexBenefitCard, benefit, tracingSelection,
										expectedEstimatedDate)
								&& verifyManageThisBenefitButton(indexBenefitCard, tracingSelection, expectedStatus);
						if (!isFlexCardDetailsVerified) {
							return false;
						} else {
							flag = true;
							CoreFunctions.scrollToElementUsingJS(driver, _textPolicyFileID,
									COREFLEXConstants.POLICY_FILE_ID);
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

	private boolean verifyFlexBenefitCardDetails(String expectedStatus, String tracingSelection) {
		boolean isFlexCardDetailsVerified = false;
		boolean flag = false;
		String expectedEstimatedDate = CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy");
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))) {
						int indexBenefitCard = BusinessFunctions.returnindexItemFromListUsingText(driver,
								flexCardBenefitDisplayName, benefit.getBenefitDisplayName());
						isFlexCardDetailsVerified = verifyFlexCardDetails(indexBenefitCard, benefit)
								&& verifyFlexCardStatus(indexBenefitCard, benefit, tracingSelection,
										expectedEstimatedDate)
								&& verifyManageThisBenefitButton(indexBenefitCard, tracingSelection, expectedStatus);
						if (!isFlexCardDetailsVerified) {
							return false;
						} else {
							flag = true;
							CoreFunctions.scrollToElementUsingJS(driver, _textPolicyFileID,
									COREFLEXConstants.POLICY_FILE_ID);
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

	private boolean verifyManageThisBenefitButton(int indexBenefitCard, String tracingSelection,
			String expectedStatus) {
		try {
			if ((tracingSelection.equals(MobilityXConstants.CANCELLED))
					|| (tracingSelection.equals(MobilityXConstants.POST_END_TRACING))) {
				return verifyManageThisBenefitButtonNotDisplayed(expectedStatus);
			} else {
				CoreFunctions.verifyText(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardManageBenefitButtonBy),
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

	private boolean verifyManageThisBenefitButtonNotDisplayed(String expectedStatus) {
		if (CoreFunctions.isElementExist(driver, flexCardManageThisBenefitButton, 3)) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.MANAGE_THIS_BENEFIT_BUTTON_DISPLAYED_ON_FLEX_BENEFIT_CARD,
							CoreConstants.FAIL, expectedStatus));
			return false;
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.MANAGE_THIS_BENEFIT_BUTTON_NOT_DISPLAYED_ON_FLEX_BENEFIT_CARD, CoreConstants.PASS,
					expectedStatus));
			return true;
		}
	}

	private boolean verifyFlexCardStatus(int indexBenefitCard, Benefit benefit, String tracingSelection,
			String expectedEstimatedDate) {
		boolean isFlexBenefitCardStatusVerified = false;
		try {
			switch (tracingSelection) {
			case MobilityXConstants.PRE_INITIAL_TRACING:
				isFlexBenefitCardStatusVerified = verifyFlexBenefitCardStatusBeforeActualization(indexBenefitCard,
						tracingSelection);
				break;
			case MobilityXConstants.POST_INITIAL_TRACING:
				isFlexBenefitCardStatusVerified = verifyFlexBenefitCardStatusAfterInitialActualization(indexBenefitCard,
						tracingSelection, benefit, expectedEstimatedDate);
				break;
			case MobilityXConstants.POST_END_TRACING:
				isFlexBenefitCardStatusVerified = verifyFlexBenefitCardStatusAfterEndActualization(indexBenefitCard,
						tracingSelection, benefit, expectedEstimatedDate);
				break;
			case MobilityXConstants.CANCELLED:
				isFlexBenefitCardStatusVerified = verifyFlexBenefitCardStatusAfterCancellation(indexBenefitCard,
						tracingSelection);
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
			CoreFunctions.moveToElement(driver, flexCardBenefitDisplayName.get(indexBenefitCard));
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.PASS, flexCardBenefitDisplayName.get(indexBenefitCard).getText()));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.FAIL, flexCardBenefitDisplayName.get(indexBenefitCard)));
			return false;
		}
	}

	public boolean isCoreBenefitCardVerified(String tracingSelection) {
		try {
			return verifyCoreBenefitCardDetails(tracingSelection);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	public boolean isCoreBenefitCardVerified(String tracingSelection, int noOfMilestones) {
		try {
			return verifyCoreBenefitCardDetails(tracingSelection, noOfMilestones);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	private boolean verifyCoreBenefitCardDetails(String tracingSelection, int numberOfMilestones) {
		boolean isCoreCardDetailsVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : coreBenefits) {
				if (benefit.getAiresManagedService() != null && benefit.getAiresManagedService().equals("Yes")
						&& benefit.getNoOfMilestones() != null && benefit.getNoOfMilestones() == numberOfMilestones) {
					int indexBenefitCard = BusinessFunctions.returnindexItemFromListUsingText(driver,
							coreCardBenefitDisplayName, benefit.getBenefitDisplayName());
					isCoreCardDetailsVerified = verifyCoreCardDetails(indexBenefitCard, benefit)
							&& verifyCoreCardStatus(indexBenefitCard, tracingSelection, benefit);
					if (!isCoreCardDetailsVerified) {
						return false;
					} else {
						flag = true;
					}
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

	private boolean verifyCoreBenefitCardDetails(String tracingSelection) {
		boolean isCoreCardDetailsVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : coreBenefits) {
				if (benefit.getAiresManagedService() != null && benefit.getAiresManagedService().equals("Yes")) {

					int indexBenefitCard = BusinessFunctions.returnindexItemFromListUsingText(driver,
							coreCardBenefitDisplayName, benefit.getBenefitDisplayName());
					isCoreCardDetailsVerified = verifyCoreCardDetails(indexBenefitCard, benefit)
							&& verifyCoreCardStatus(indexBenefitCard, tracingSelection, benefit);
					if (!isCoreCardDetailsVerified) {
						return false;
					} else {
						flag = true;
					}
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
			CoreFunctions.waitHandler(2);
			CoreFunctions.verifyText(driver, coreCardLongDesc.get(indexBenefitCard), benefit.getBenefitDesc(),
					MobilityXConstants.CORE_CARD_BENEFIT_LONG_DESCRIPTION);
			CoreFunctions.moveToElement(driver, coreCardBenefitDisplayName.get(indexBenefitCard));
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

	private boolean verifyCoreCardStatus(int indexBenefitCard, String tracingSelection, Benefit benefit) {
		boolean isCoreBenefitCardStatusVerified = false;
		try {

			switch (tracingSelection) {
			case MobilityXConstants.PRE_INITIAL_TRACING:
				isCoreBenefitCardStatusVerified = verifyCoreBenefitCardStatusBeforeActualization(indexBenefitCard,
						tracingSelection);
				break;
			case MobilityXConstants.POST_INITIAL_TRACING:
				isCoreBenefitCardStatusVerified = verifyCoreBenefitCardStatusAfterInitialActualization(indexBenefitCard,
						tracingSelection, benefit);
				break;
			case MobilityXConstants.POST_END_TRACING:
				isCoreBenefitCardStatusVerified = verifyCoreBenefitCardStatusAfterEndActualization(indexBenefitCard,
						tracingSelection, benefit);
				break;
			case MobilityXConstants.CANCELLED:
				isCoreBenefitCardStatusVerified = verifyCoreBenefitCardStatusAfterCancellation(indexBenefitCard,
						tracingSelection);
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

	private boolean verifyCoreBenefitCardStatusAfterInitialActualization(int indexBenefitCard, String expectedStatus,
			Benefit benefit) {
		boolean isCoreCardStatusVerified = false;
		String expectedEstimatedDate = CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy");
		try {
			switch (benefit.getBenefitType()) {
			case COREFLEXConstants.LANGUAGE_TRAINING:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardBeginTrainingStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
										beginTrainingEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.TEMPORARY_LIVING:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), coreCardMoveInStatus), 3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
										moveInEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.CULTURAL_TRAINING:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardBeginTrainingStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
										beginTrainingEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.AUTO_RENTAL_DURING_ASSIGNMENT:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), coreCardAutoPickupStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
										autoPickupEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.CONCIERGE_SERVICES:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardBeginServiceStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
										beginServiceEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.EDUCATION_ASSISTANCE_SCHOOL_SEARCH:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardRegistrationScheduledStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
										registrationScheduledEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.AREA_TOUR:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), coreCardBeginTourStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
										beginTourEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.FURNITURE_RENTAL:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardFurnitureDeliveryStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
										furnitureDeliveryEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.AIRPORT_PICKUP:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardAirportPickupStatus),
						3)
						&& (CoreFunctions.getElementText(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
										airportPickupEstimatedDate))
								.equals(expectedEstimatedDate))
						&& (!CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
								coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy), 3)));
				break;
			case COREFLEXConstants.HOUSE_HUNTING_TRIP:
			case COREFLEXConstants.FINAL_MOVE:
			case COREFLEXConstants.HOME_LEAVE:
			case COREFLEXConstants.PRE_ACCEPTANCE_SERVICES:
				isCoreCardStatusVerified = CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), travelRequested), 3)
						&& CoreFunctions.isElementExist(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), travelBooked), 3)
						&& CoreFunctions.isElementExist(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), travelBegins), 3)
						&& CoreFunctions.isElementExist(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), travelEnds), 3);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);

			}

			if (isCoreCardStatusVerified) {
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, benefit.getBenefitType()));
			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return isCoreCardStatusVerified;
	}

	private boolean verifyCoreBenefitCardStatusAfterEndActualization(int indexBenefitCard, String expectedStatus,
			Benefit benefit) {
		boolean isCoreCardStatusVerified = false;
		try {
			switch (benefit.getBenefitType()) {
			case COREFLEXConstants.LANGUAGE_TRAINING:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardTrainingCompletedStatus),
						3) && (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3)));
				break;
			case COREFLEXConstants.TEMPORARY_LIVING:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), coreCardMoveOutStatus), 3)
						&& (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3)));
				break;
			case COREFLEXConstants.CULTURAL_TRAINING:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardTrainingCompletedStatus),
						3) && (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3)));
				break;
			case COREFLEXConstants.AUTO_RENTAL_DURING_ASSIGNMENT:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), coreCardAutoReturnStatus),
						3) && (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3)));
				break;
			case COREFLEXConstants.CONCIERGE_SERVICES:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardServiceCompleteStatus),
						3) && (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3)));
				break;
			case COREFLEXConstants.EDUCATION_ASSISTANCE_SCHOOL_SEARCH:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardRegistrationCompletedStatus),
						3) && (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3)));
				break;
			case COREFLEXConstants.AREA_TOUR:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardTourCompleteStatus),
						3) && (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3)));
				break;
			case COREFLEXConstants.FURNITURE_RENTAL:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard),
								coreCardFurniturePickUpStatus),
						3) && (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3)));
				break;
			case COREFLEXConstants.AIRPORT_PICKUP:
				isCoreCardStatusVerified = (CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), coreCardAutoReturnStatus),
						3) && (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3)));
				break;
			case COREFLEXConstants.HOUSE_HUNTING_TRIP:
			case COREFLEXConstants.FINAL_MOVE:
			case COREFLEXConstants.HOME_LEAVE:
			case COREFLEXConstants.PRE_ACCEPTANCE_SERVICES:
				isCoreCardStatusVerified = CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), _serviceCompleted), 3);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);

			}

			if (isCoreCardStatusVerified) {
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_CARD_STATUS,
								CoreConstants.PASS, benefit.getBenefitType()));
			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CORE_BENEFIT_CARD_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return isCoreCardStatusVerified;
	}

	private boolean verifyCoreBenefitCardStatusBeforeActualization(int indexBenefitCard, String expectedStatus) {
		try {
			if (CoreFunctions.isElementExist(driver,
					CoreFunctions.findSubElement(coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy),
					3)) {
				CoreFunctions.highlightObject(driver, CoreFunctions
						.findSubElement(coreCardPanelList.get(indexBenefitCard), coreCardStartingSoonStatusBy));
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
				return true;
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

	public boolean verifyFlexCardNotDisplayed() {
		boolean isFlexCardNotDisplayed = false;
		for (FlexBenefit benefitList : flexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))) {
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

	public boolean verifyCoreCardNotDisplayed() {
		boolean isCoreCardNotDisplayed = false;
		for (Benefit benefit : coreBenefits) {
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

	public boolean isMultipleSubmissionFlexBenefitCardVerified(String expectedStatus, String tracingSelection) {
		boolean isMultipleFlexCardDetailsVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getMultipleBenefitSubmission())) {
						int multipleSubmissionFlexCardCount = (int) flexCardBenefitDisplayName.stream()
								.filter(x -> x.getText().equals(benefit.getBenefitDisplayName())).count();
						if (multipleSubmissionFlexCardCount > 1) {
							isMultipleFlexCardDetailsVerified = verifyMultipleFlexCards(benefit,
									multipleSubmissionFlexCardCount, expectedStatus, tracingSelection);
						}
						if (!isMultipleFlexCardDetailsVerified) {
							return false;
						} else {
							flag = true;
							CoreFunctions.scrollToElementUsingJS(driver, _textPolicyFileID,
									COREFLEXConstants.POLICY_FILE_ID);
						}
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_MULTIPLE_SUBMISSION_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isMultipleFlexCardDetailsVerified && flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_MULTIPLE_SUBMISSION_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.PASS));
		}
		return isMultipleFlexCardDetailsVerified;
	}

	private boolean verifyMultipleFlexCards(Benefit benefit, int multipleSubmissionFlexCardCount, String expectedStatus,
			String tracingSelection) {
		int counter = 0;
		boolean isMultipleFlexCardDetailsVerified = false;
		String expectedEstimatedDate = CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy");
		try {
			List<Integer> multipleFlexCardIndex = getMultipleFlexCardIndexes(benefit);
			while (counter < multipleSubmissionFlexCardCount) {
				isMultipleFlexCardDetailsVerified = verifyFlexCardDetails(multipleFlexCardIndex.get(counter), benefit)
						&& verifyFlexCardStatus(multipleFlexCardIndex.get(counter), benefit, tracingSelection,
								expectedEstimatedDate)
						&& verifyManageThisBenefitButton(multipleFlexCardIndex.get(counter), tracingSelection,
								expectedStatus);
				counter++;

				if (!isMultipleFlexCardDetailsVerified)
					return false;
				else
					CoreFunctions.scrollToElementUsingJS(driver, _textPolicyFileID, COREFLEXConstants.POLICY_FILE_ID);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_MULTIPLE_SUBMISSION_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		return isMultipleFlexCardDetailsVerified;
	}

	private List<Integer> getMultipleFlexCardIndexes(Benefit benefit) {
		List<Integer> flexCardIndexes = new ArrayList<Integer>();
		for (WebElement element : flexCardBenefitDisplayName) {
			if (element.getText().equals(benefit.getBenefitDisplayName())) {
				flexCardIndexes.add(flexCardBenefitDisplayName.indexOf(element));
			}
		}
		return flexCardIndexes;
	}

	public void saveSubmittedPolicyState() {
		if (CoreFunctions.getPropertyFromConfig("CoreFlexMultipleSubmissionFlag").equals("false")) {
			HashMap<String, String> submittedPolicyState = new HashMap<String, String>();
			submittedPolicyState.put("AssignmentFileID", CoreFunctions.getPropertyFromConfig("Assignment_FileID"));
			submittedPolicyState.put("AssignmentClientID", CoreFunctions.getPropertyFromConfig("Assignment_ClientID"));
			submittedPolicyState.put("AssignmentClientName",
					CoreFunctions.getPropertyFromConfig("Assignment_ClientName").replace(",", ""));
			submittedPolicyState.put("AssignmentPolicy", CoreFunctions.getPropertyFromConfig("Assignment_Policy"));
			submittedPolicyState.put("AssignmentUserName",
					CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"));
			submittedPolicyState.put("AssignmentPassword",
					CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail"));
			submittedPolicyState.put("BenefitSubmittedDate", CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"));
			submittedPolicyState.put("AvailablePointsAfterSubmission",
					String.valueOf(MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission));
			submittedPolicyState.put("TotalPointsSubmitted",
					String.valueOf(MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints));
			submittedPolicyState.put("AssignmentFirstName",
					CoreFunctions.getPropertyFromConfig("Transferee_firstName"));
			submittedPolicyState.put("AssignmentLastName", CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
			submittedPolicyState.put("PolicySubmissionDate", CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"));
			CoreFunctions.writeToPropertiesFile("CoreFlexSubmittedPolicyData", submittedPolicyState.toString());
			CoreFunctions.writeToPropertiesFile("CoreFlexMultipleSubmissionFlag", "true");
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_SAVED_FIRST_SUBMITTED_POLICY_STATE_IN_CONFIG_PROPERTIES,
					CoreConstants.PASS));
		} else {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.FIRST_SUBMITTED_POLICY_STATE_ALREADY_SAVED,
					CoreConstants.PASS));
		}

	}

	public boolean verifyAssignmentAndPolicyDetailsPostSubmission() {
		boolean isAssignmentClientDetailsMatched = false, isPolicyPointsDetailsMatched = false;
		boolean isDetailsMatched = false;
		Map<String, String> submittedPolicyDetails = CoreFunctions
				.convertStringToMapWithStream(CoreFunctions.getPropertyFromConfig("CoreFlexSubmittedPolicyData"));
		try {
			switchToTooltipIFrameAndPerformAction(MobilityXConstants.HIDE, 10);
			String actualClientName = CoreFunctions.getElementText(driver, _textClientName).replace(",", "");
			String actualTransfereeName = CoreFunctions.getElementText(driver, _textTransfereeUserNameTitle);
			String actualpolicyAndFileId = CoreFunctions.getElementText(driver, _textPolicyFileID);
			String actualPolicyName = actualpolicyAndFileId.substring(0, actualpolicyAndFileId.lastIndexOf("/")).trim();
			String actualFileId = actualpolicyAndFileId.substring(actualpolicyAndFileId.lastIndexOf("/") + 1).trim();
			String actualPointsWithText[] = CoreFunctions.getElementText(driver, _textInitialSpentAndTotalPoints)
					.split(" ");
			String actualSpentAndTotalPoints[] = actualPointsWithText[0].split("/");

			isAssignmentClientDetailsMatched = (submittedPolicyDetails.get(" AssignmentClientName"))
					.equals(actualClientName) & submittedPolicyDetails.get(" AssignmentFileID").equals(actualFileId)
					& (submittedPolicyDetails.get(" AssignmentFirstName") + " "
							+ submittedPolicyDetails.get(" AssignmentLastName")).equals(actualTransfereeName);

			isPolicyPointsDetailsMatched = submittedPolicyDetails.get(" AssignmentPolicy").equals(actualPolicyName)
					& actualSpentAndTotalPoints[0].equals(submittedPolicyDetails.get(" TotalPointsSubmitted"))
					& actualSpentAndTotalPoints[1]
							.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable);

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

	public boolean isMultipleDateSubmissionFlexBenefitCardVerified(String expectedStatus, String tracingSelection) {
		boolean isPreviousSubmissionFlexDetailsVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getMultipleBenefitSubmission() && benefit.getSelectBenefitOnFPTPage()
							&& benefit.getAiresManagedService().equals("Yes")) {
						int multipleSubmissionFlexCardCount = (int) flexCardBenefitDisplayName.stream()
								.filter(x -> x.getText().equals(benefit.getBenefitDisplayName())).count();
						if (multipleSubmissionFlexCardCount > 1) {
							isPreviousSubmissionFlexDetailsVerified = verifyPreviousSubmissionFlexCards(benefit,
									multipleSubmissionFlexCardCount, expectedStatus, tracingSelection);
						}
						if (!isPreviousSubmissionFlexDetailsVerified) {
							return false;
						} else {
							flag = true;
							CoreFunctions.scrollToElementUsingJS(driver, _textPolicyFileID,
									COREFLEXConstants.POLICY_FILE_ID);
						}
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_MULTIPLE_SUBMISSION_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isPreviousSubmissionFlexDetailsVerified && flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_MULTIPLE_SUBMISSION_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.PASS));
		}
		return isPreviousSubmissionFlexDetailsVerified;
	}

	private boolean verifyPreviousSubmissionFlexCards(Benefit benefit, int multipleSubmissionFlexCardCount,
			String expectedStatus, String tracingSelection) {
		boolean isPreviousSubmissionFlexCardDetailsVerified = false;
		try {
			Map<String, String> submittedPolicyDetails = CoreFunctions
					.convertStringToMapWithStream(CoreFunctions.getPropertyFromConfig("CoreFlexSubmittedPolicyData"));
			String expectedEstimatedDate = submittedPolicyDetails.get(" BenefitSubmittedDate");
			List<Integer> multipleFlexCardIndex = getMultipleFlexCardIndexes(benefit);
			int lastFlexCardIndex = multipleFlexCardIndex.get(multipleFlexCardIndex.size() - 1);
			isPreviousSubmissionFlexCardDetailsVerified = verifyFlexCardDetails(lastFlexCardIndex, benefit)
					&& verifyFlexCardStatus(lastFlexCardIndex, benefit, tracingSelection, expectedEstimatedDate)
					&& verifyManageThisBenefitButton(lastFlexCardIndex, tracingSelection, expectedStatus);
			CoreFunctions.scrollToElementUsingJS(driver, _textPolicyFileID, COREFLEXConstants.POLICY_FILE_ID);

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_MULTIPLE_SUBMISSION_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		return isPreviousSubmissionFlexCardDetailsVerified;

	}

}
