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
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.managers.PageObjectManager_CoreFlex;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.CoreFlex_SettlingInBenefitsData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.aires.testdatatypes.coreflex.MX_Transferee_AccountSetupDetails;
import com.aires.utilities.EmailUtil;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MX_Transferee_JourneyHomePage extends Base {

	public static PageObjectManager_CoreFlex pageObjectManager_CoreFlex;

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

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Start the OnPoint Planning Tool')]")
	private WebElement _btn_proceedToFlexTool;

	@FindBy(how = How.XPATH, using = "//span[text()='Remind me later']")
	private WebElement _link_remindLater;

	final By _link_remindLaterLocater = By.xpath("//span[text()='Remind me later']");

	@FindBy(how = How.XPATH, using = "//span[text()='Start the OnPoint Planning Tool']")
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

	@FindBy(how = How.XPATH, using = "//span[text()='Account Settings']")
	private WebElement _optionAccountSettings;

	@FindBy(how = How.XPATH, using = "//span[text()='Add payment account']")
	private WebElement _link_addPaymentAccount;

	@FindBy(how = How.CSS, using = "select[title='Account type*']")
	private WebElement _select_accountType;

	@FindBy(how = How.XPATH, using = "//span[text()='Continue']")
	private WebElement _btn_continue;

	@FindBy(how = How.CSS, using = "select[title='Currency*']")
	private WebElement _selectCurrency;

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

	@FindBy(how = How.CSS, using = "div.zone-content > div.rich-text")
	private WebElement _tooltipIFrameText;

	@FindBy(how = How.CSS, using = "div[class*='appcues-actions-right'] > a")
	private WebElement _tooltipIFrameNextButton;

	@FindBy(how = How.CSS, using = "a[class='text-muted appcues-skip']")
	private WebElement _tooltipIFrameHideLink;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'cfcardstatus')]//span[contains(text(),'There are no services set up yet.')]")
	private WebElement _serviceNotSetupCFCard;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> flexCardPanelList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> coreCardPanelList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//span[contains(@class,'RCFXMJHeadingText')]")
	private List<WebElement> flexCardBenefitDisplayName;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//span[contains(@class,'RCFXMJSubHeadingText')]")
	private List<WebElement> flexCardAmountAllowanceText;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//div[contains(@class,'RXCFCircle')]//span")
	private List<WebElement> flexCardNumberOfBenefitSelected;

	private By flexCardNumberOfBenefitSelectedSubElement = By.xpath(".//div[contains(@class,'RXCFCircle')]//span");

	@FindBy(how = How.CSS, using = "div.RXFlexBeneftsPointsTooltiptext  > div > span")
	private List<WebElement> flexCardNumberOfBenefitSelectedToolTipText;

	private By flexCardNumberOfBenefitSelectedToolTipTextSubElement = By
			.cssSelector("div.RXFlexBeneftsPointsTooltiptext  > div > span");

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]")
	private List<WebElement> flexCardStartingSoonStatusList;

	private By flexCardStartingSoonStatusBy = By
			.xpath(".//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]");

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

	@FindBy(how = How.XPATH, using = "//span[@class='RXCFBigText RXMineShaft RXBolder'][contains(text(),'Flex Benefits')]")
	private WebElement flexCardSectionHeader;

	@FindBy(how = How.CSS, using = "input[placeholder*='bank name']")
	private WebElement _textBankName;

	@FindBy(how = How.CSS, using = "input[placeholder*='Bank address 1*']")
	private WebElement _textBankAddress1;

	@FindBy(how = How.CSS, using = "input[placeholder*='Bank address 2']")
	private WebElement _textBankAddress2;

	@FindBy(how = How.CSS, using = "input[placeholder*='Bank city']")
	private WebElement _textBankCity;

	@FindBy(how = How.CSS, using = "input[placeholder*='Bank zip']")
	private WebElement _textBankZip;

	@FindBy(how = How.CSS, using = "select[title*='Bank state']")
	private WebElement _selectBankState;

	@FindBy(how = How.CSS, using = "select[title*='Bank country']")
	private WebElement _selectBankCountry;

	@FindBy(how = How.CSS, using = "span[id*='wire'] > input[placeholder='Account closing date']")
	private WebElement _textBankAccountClosingDate;

	@FindBy(how = How.CSS, using = "input[placeholder*='Account/IBAN number*']")
	private WebElement _textBankIBAN;

	@FindBy(how = How.CSS, using = "input[placeholder*='SWIFT/Routing number*']")
	private WebElement _textBankSwift;

	@FindBy(how = How.CSS, using = "input[id*='dobWire']")
	private WebElement _textAccountHolderDOB;

	@FindBy(how = How.CSS, using = "div[title='Submit'][id*='wire'] > a")
	private WebElement _btnWireSubmit;

	@FindBy(how = How.XPATH, using = "//span[text() ='Impersonate a User']")
	private WebElement _impersonateAUserTile;

	@FindBy(how = How.ID, using = "rRegion:0:userTypeCombo::content")
	private WebElement _userTypeDropdownSelector;

	@FindBy(how = How.ID, using = "rRegion:0:edsocmv1::content")
	private WebElement _clientListDropdownSelector;

	@FindBy(how = How.CSS, using = "input[id='rRegion:0:it2::content']")
	private WebElement _userNameText;

	@FindBy(how = How.ID, using = "rRegion:0:impSearchButton")
	private WebElement _searchButton;

	@FindBy(how = How.CSS, using = "a[class='RXLink RXBigLink RXBold RXWrappedText af_link p_AFTextOnly']")
	private List<WebElement> _userNameList;

	@FindBy(how = How.CSS, using = "[id*='btndelegateheaderadd']")
	private WebElement _btnNewDelegate;

	@FindBy(how = How.CSS, using = "[id*='uRegion:0:delfname::content']")
	private WebElement _inputDelFirstName;

	@FindBy(how = How.CSS, using = "[id*='uRegion:0:dellname::content']")
	private WebElement _inputDelLastName;

	@FindBy(how = How.CSS, using = "[id*='uRegion:0:delemail::content']")
	private WebElement _inputDelEmail;

	@FindBy(how = How.CSS, using = "[id*='uRegion:0:raddcoreflextlpa::Label0']")
	private WebElement _radioDelFlexAccess;

	@FindBy(how = How.CSS, using = "[id*='dsubmitbtn']")
	private WebElement _btnDelegateSubmit;

	@FindBy(how = How.CSS, using = "[id*='dadpbtncont']")
	private WebElement _btnDelContinue;

	@FindBy(how = How.CSS, using = "input[id*='delastartdate']")
	private WebElement _inputDelStartDate;

	@FindBy(how = How.CSS, using = "input[id*='delaenddate']")
	private WebElement _inputDelEndDate;

	@FindBy(how = How.CSS, using = "[id*='otDelHeader2']")
	private WebElement _userBanner;

	@FindBy(how = How.CSS, using = "td > div[id*='delegateNameMisMatch']")
	private WebElement _popUpMatchingFile;

	@FindBy(how = How.XPATH, using = "//td/div[contains(@id,'delegateNameMisMatch')]//span[contains(text(),'Confirm')]")
	private WebElement _popUpMatchingFileConfirmButton;

	@FindBy(how = How.XPATH, using = "//td/div[contains(@id,'delegateAuthDisclaimer')]//span[contains(@id,'title')]")
	private WebElement _popUpDelegateAuthDisclaimer;

	@FindBy(how = How.XPATH, using = "//td/div[contains(@id,'delegateAuthDisclaimer')]//span[contains(text(),'Confirm Delegate')]")
	private WebElement _popUpDelegateAuthDisclaimerConfirmDelegateButton;

	@FindBy(how = How.XPATH, using = "//td/div[contains(@id,'genericUsername')]//span[contains(@id,'title')]")
	private WebElement _popUpDelegateGenericUsername;

	@FindBy(how = How.XPATH, using = "//td/div[contains(@id,'genericUsername')]//span[contains(text(),'Submit')]")
	private WebElement _popUpDelegateGenericUsernameSubmitButton;

	final By _impersonateDialogTitleAppear = By.xpath("//div[@id='rRegion']//span[text() = 'Impersonate a User']");

	@FindBy(how = How.CSS, using = "img#appcuesImage")
	private WebElement _linkGetHelp;

	@FindBy(how = How.CSS, using = "div.appcues-widget-header > p")
	private WebElement _headerGetHelp;

	@FindBy(how = How.CSS, using = "div.appcues-widget-content a")
	private WebElement _optionGetHelp;

	/*********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	MX_Transferee_AccountSetupDetails accountDetails = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMxTransfereeAccountSetupDetails("AddPaymentAccount");

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	CoreFlex_SettlingInBenefitsData languageTrainingBenefitData = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getSettlingInBenefitDataList(COREFLEXConstants.LANGUAGE_TRAINING);

	/*********************************************************************/

	public void clickElementOfPage(String elementName) {
		switch (elementName) {
		case MobilityXConstants.MANAGE_MY_POINTS:
			CoreFunctions.clickUsingJS(driver, _linkManageMyPoints, MobilityXConstants.MANAGE_MY_POINTS);
			break;
		case MobilityXConstants.GET_HELP:
			CoreFunctions.clickElement(driver, _linkGetHelp);
			break;
		case MobilityXConstants.EXPECTED_MOBILITY_JOURNEY_HOME_APP_CUE_OPTION:
			CoreFunctions.clickElement(driver, _optionGetHelp);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
		}
	}

	public boolean verifyUserNavigationToJourneyHomePage() {
		try {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkManageMyPoints,
					MobilityXConstants.MANAGE_MY_POINTS);
			return CoreFunctions.isElementExist(driver, _linkManageMyPoints, 20);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_USER_NAVIGATION_TO_MOBILITYX_JOURNEY_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	public void handle_Cookie_AfterLogin() {
//		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _btn_OkOnSiteCookieAfterLogin,
//				MobilityXConstants.COOKIEDAILOG_OKBUTTON);
//		CoreFunctions.waitHandler(2);
		if (CoreFunctions.isElementExist(driver, _btn_OkOnSiteCookieAfterLogin, 25)) {
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
		try {
			if (CoreFunctions.isElementExist(driver, _link_remindLater, 2)) {
				if (CoreFunctions.verifyElementPresentOnPage(_link_remindLater, MobilityXConstants.REMIND_LATER)) {
					CoreFunctions.click(driver, _link_remindLater, MobilityXConstants.REMIND_LATER);
					Log.info(MobilityXConstants.VERIFIED + MobilityXConstants.REMINDER_POPUP
							+ MobilityXConstants.IS_DISPLAYED + MobilityXConstants.ON_MOBILITYX_DASHBOARD_PAGE);
				} else
					Log.info(MobilityXConstants.REMINDER_POPUP_NOT_DISPLAYED);
			}
		} catch (Exception e) {

		}
	}

	public boolean isManageMyPointsDisplayed() {
		return CoreFunctions.isElementExist(driver, _linkManageMyPoints, 10);
	}

	public void routeToTransfereeJourney() {
		if (CoreFunctions.isElementExist(driver, _linkSkipProceedToJourneyHome, 15))
			CoreFunctions.clickElement(driver, _linkSkipProceedToJourneyHome);
	}

	public boolean isWelcomePopupDisplayed() {
		try {
			if (CoreFunctions.isElementExist(driver, _btn_startFlexPlanning, 45)) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_NAVIGATED_TO_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.PASS));
				return true;
			} else {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.FAILED_TO_NAVIGATE_TO_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.FAIL));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.FAIL,e.getMessage()));
			return false;
		}
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
		boolean isPolicyPointsDetailsMatched;

		if ((CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")
				.equals(COREFLEXConstants.CLIENT_AND_TRANSFEREE))
				&& Boolean.valueOf(CoreFunctions.getPropertyFromConfig("CF_Client_BenefitSubmitted"))) {
			isPolicyPointsDetailsMatched = CoreFunctions.getPropertyFromConfig("Assignment_Policy")
					.equals(actualPolicyName)
					&& (Double.parseDouble(actualSpentPoints) == Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")))
					&& actualTotalPoints
							.equals(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"));
		} else {
			isPolicyPointsDetailsMatched = CoreFunctions.getPropertyFromConfig("Assignment_Policy")
					.equals(actualPolicyName) && actualSpentPoints.equals("0")
					&& actualTotalPoints
							.equals(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"));
		}
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
		try {
			CoreFunctions.verifyText(CoreFunctions.getPropertyFromConfig("Assignment_ClientName"), actualClientName);
			CoreFunctions.verifyText(CoreFunctions.getPropertyFromConfig("Assignment_FileID"), actualFileId);
			CoreFunctions
					.verifyText(
							(CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
									+ CoreFunctions.getPropertyFromConfig("Transferee_lastName")),
							actualTransfereeName);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.ASSIGNMENT_DETAILS_MATCHED_ON_MOBILITY_JOURNEY_HOME_PAGE, CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ASSIGNMENT_DETAILS_ON_MOBILITYX_JOURNEY_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifySubmittedPointsDetails() {
		boolean isSubmittedSpentPointsValid = false;
		double spentPointsAfterBenefitSubmission = 0;
		try {
			CoreFunctions.waitHandler(2);
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
					CoreConstants.FAIL,
					(Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))),
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
		return MobilityXConstants.POINT_BALANCE_DETAILS_FPT.replace("used_points", consumed)
				.replace("total_points", total).replace("current_balance", format.format(remaining));
	}

	public void progressOrSkipMobilityJourneyHomePage(String action) {
		try {
			if (action.equals(MobilityXConstants.ROUTE_TO_TRANSFEREE_JOURNEY_HOME_PAGE)) {
				routeToTransfereeJourney();
			} else {
				routeToFlexPlanningTool();
			}
		} catch (Exception e) {
		}
	}

	public boolean setUpPaymentAccount() {
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				return proceedToAccountSetupPage() && setupUSDCheckAccountAndSave()
						&& setupWireTransferAccountBasedOnCurrencyAndSave();
			} else
				return true;
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_SETTING_UP_USER_ACCOUNT_DETAILS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	/**
	 * Method to Setup USD Check Account if USD currency selection is made in
	 * PortionCashout or AfterRelocation selection in OnPoint Policy setup
	 * 
	 * @return
	 */
	private boolean setupUSDCheckAccountAndSave() {
		try {
			CoreFunctions.selectByVisibleText(driver, _select_accountType, accountDetails.checkAccountType.accountType);
			CoreFunctions.clickElement(driver, _btn_continue);
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.SUCCESSFULLY_SELECTED_ACCOUNT_TYPE, CoreConstants.PASS));
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _btn_submit, MobilityXConstants.SUBMIT);
			CoreFunctions.clearAndSetText(driver, _mailingAddress1, accountDetails.checkAccountType.address1);
			CoreFunctions.clearAndSetText(driver, _accountHolderName,
					accountDetails.checkAccountType.accountHoldersName);
			CoreFunctions.clearAndSetText(driver, _mailingAddress2, accountDetails.checkAccountType.address2);
			CoreFunctions.clearAndSetText(driver, _mailingCity, accountDetails.checkAccountType.city);
//			CoreFunctions.clearAndSetText(driver, _province, accountDetails.checkAccountType.province);
			CoreFunctions.clearAndSetText(driver, _postalCode, accountDetails.checkAccountType.postalCode);
			CoreFunctions.selectByVisibleText(driver, _select_mailingCountry, accountDetails.checkAccountType.country);
			CoreFunctions.waitHandler(1);
			CoreFunctions.selectByVisibleText(driver, _select_mailingState, accountDetails.checkAccountType.state);
			CoreFunctions.clearAndSetText(driver, _accountClosingDate,
					accountDetails.checkAccountType.accountClosingDate);
			CoreFunctions.clickElement(driver, _btn_submit);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _successGrowlMessage,
					MobilityXConstants.SAVED_SUCCESSFUL_GROWL_MESSAGE);
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _successGrowlMessage);
			CoreFunctions.clickElement(driver, _btn_save);
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.SUCCESSFULLY_ADDED_PAYMENT_ACCOUNT,
					CoreConstants.PASS, accountDetails.checkAccountType.accountType));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.PAYMENT_ACCOUNT_SETUP_FAILED,
					CoreConstants.FAIL, e.getMessage(), accountDetails.checkAccountType.accountType));
		}
		return false;
	}

	/**
	 * Method to Setup Wire Transferee Account if NON-USD currency selection is made
	 * in PortionCashout or AfterRelocation selection in OnPoint Policy setup
	 * 
	 * @return
	 */
	private boolean setupWireTransferAccountBasedOnCurrencyAndSave() {
		try {
			if (!CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode").equalsIgnoreCase("USD")) {
				CoreFunctions.clickElement(driver, _link_addPaymentAccount);
				CoreFunctions.selectByVisibleText(driver, _select_accountType,
						accountDetails.wireTransferAccountType.accountType);
				CoreFunctions.clickElement(driver, _btn_continue);
				Reporter.addStepLog(MessageFormat.format(MobilityXConstants.SUCCESSFULLY_SELECTED_ACCOUNT_TYPE,
						CoreConstants.PASS));
				CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _btnWireSubmit,
						MobilityXConstants.SUBMIT);
				CoreFunctions.selectByVisibleText(driver, _selectCurrency,
						CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyText"));
				CoreFunctions.clearAndSetText(driver, _accountHolderName,
						accountDetails.wireTransferAccountType.accountHoldersName);
				CoreFunctions.clearAndSetText(driver, _textAccountHolderDOB,
						accountDetails.wireTransferAccountType.accountHolderDOB);

				CoreFunctions.clearAndSetText(driver, _textBankName, accountDetails.wireTransferAccountType.bankName);
				CoreFunctions.clearAndSetText(driver, _textBankAddress1,
						accountDetails.wireTransferAccountType.bankAddress1);
				CoreFunctions.clearAndSetText(driver, _textBankAddress2,
						accountDetails.wireTransferAccountType.bankAddress2);
				CoreFunctions.clearAndSetText(driver, _textBankCity, accountDetails.wireTransferAccountType.bankCity);
				CoreFunctions.clearAndSetText(driver, _textBankZip,
						accountDetails.wireTransferAccountType.bankPostalCode);
				String bankCountry = DbFunctions.getCoreFlexCurrencyCountry(
						CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode"));
				CoreFunctions.selectByVisibleText(driver, _selectBankCountry, bankCountry);
				CoreFunctions.waitHandler(1);

				if (CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode").equalsIgnoreCase("GBP")) {
					CoreFunctions.clearAndSetText(driver, _textBankIBAN, "GB12345");
				} else if (CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode")
						.equalsIgnoreCase("DKK")) {
					CoreFunctions.clearAndSetText(driver, _textBankIBAN, "DK12345");
				} else {
					CoreFunctions.clearAndSetText(driver, _textBankIBAN,
							accountDetails.wireTransferAccountType.accountIBAN);
				}
				CoreFunctions.clearAndSetText(driver, _textBankSwift,
						accountDetails.wireTransferAccountType.swiftRouting);
				CoreFunctions.clearAndSetText(driver, _textBankAccountClosingDate,
						accountDetails.wireTransferAccountType.bankAccountClosingDate);
				CoreFunctions.clickElement(driver, _btnWireSubmit);
				CoreFunctions.explicitWaitTillElementVisibility(driver, _successGrowlMessage,
						MobilityXConstants.SAVED_SUCCESSFUL_GROWL_MESSAGE);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _successGrowlMessage);
				CoreFunctions.clickElement(driver, _btn_save);
				CoreFunctions.clickElement(driver, _link_backToMobilityJourney);
				Reporter.addStepLog(MessageFormat.format(MobilityXConstants.SUCCESSFULLY_ADDED_PAYMENT_ACCOUNT,
						CoreConstants.PASS, accountDetails.wireTransferAccountType.accountType));
				return true;
			} else {
				Reporter.addStepLog(MessageFormat.format(MobilityXConstants.USD_CURRENCY_PAYMENT_ACCOUNT_ALREADY_SETUP,
						CoreConstants.PASS));
				CoreFunctions.clickElement(driver, _link_backToMobilityJourney);
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.PAYMENT_ACCOUNT_SETUP_FAILED,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean proceedToAccountSetupPage() {
		try {
			CoreFunctions.clickElement(driver, _link_transferee_dropdown);
			CoreFunctions.clickElement(driver, _optionBanking);
			CoreFunctions.clickElement(driver, _link_addPaymentAccount);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.MXTRANSFEREE_ACCOUNT_SETUP_PAGE_IS_DISPLAYED_SUCCESSFULLY, CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.FAILED_TO_LOAD_MXTRANSFEREE_ACCOUNT_SETUP_FORM,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean proceedToAccountSettingsPage() {
		try {
			CoreFunctions.clickElement(driver, _link_transferee_dropdown);
			CoreFunctions.clickElement(driver, _optionAccountSettings);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.MXTRANSFEREE_ACCOUNT_SETUP_PAGE_IS_DISPLAYED_SUCCESSFULLY, CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.FAILED_TO_LOAD_MXTRANSFEREE_ACCOUNT_SETUP_FORM,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyBenefitSubmissionEmail(String benefitSubmittedBy) {
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
			String expEmailSubject = "Mobility Benefit(s) Submission";
			String actualResultSubmissionDetails = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject, MobilityXConstants.FLEX_BENEFIT_SUBMISSION);
			actualResultSubmissionDetails = actualResultSubmissionDetails.replace("<span>", "").replace("</span>", "")
					.replace("\r\n", "").trim();
			Log.info("ActualEmailSearchedText : " + actualResultSubmissionDetails);
			String expectedSubmittedPointsEmailMessage = submittedPointsEmailMessage(benefitSubmittedBy);
			Log.info("ExpectedEmailSearchedText : " + expectedSubmittedPointsEmailMessage);
			CoreFunctions.verifyText(actualResultSubmissionDetails, expectedSubmittedPointsEmailMessage,
					MobilityXConstants.FLEX_BENEFIT_SUBMISSION_EMAIL);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_MOBILITY_FLEX_BENEFITS_SUBMISSION_EMAIL, CoreConstants.PASS,
					actualResultSubmissionDetails, benefitSubmittedBy));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFITS_SUBMISSION_EMAIL,
					CoreConstants.FAIL, e.getMessage(), benefitSubmittedBy));
			return false;
		}
	}

	private String submittedPointsEmailMessage(String submittedBy) {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		String total = CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints");
		double remaining = Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"));
		double consumed = Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"));
		String expectedSubmittedMessageText = null;
		switch (submittedBy) {
		case MobilityXConstants.TRANSFEREE_SUBMISSION:
			expectedSubmittedMessageText = MobilityXConstants.FLEX_BENEFITS_SUBMISSION_BY_TRANSFEREE_MESSAGE
					.replace("used_points", String.valueOf(format.format(consumed))).replace("total_points", total)
					.replace("current_balance", String.valueOf(format.format(remaining)));
			break;

		case MobilityXConstants.CLIENT_IMPERSONATION_SUBMISSION:
		case MobilityXConstants.CLIENT_SUBMISSION:
			expectedSubmittedMessageText = MobilityXConstants.FLEX_BENEFITS_SUBMISSION_BY_CLIENT_IMPERSONATION_MESSAGE
					.replace("used_points", String.valueOf(format.format(consumed))).replace("total_points", total)
					.replace("current_balance", String.valueOf(format.format(remaining)));
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
		return expectedSubmittedMessageText;

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

	private boolean verifyFlexBenefitCardStatusAfterInitialActualization(int indexBenefitCard, Benefit benefit,
			String expectedEstimatedDate) {
		boolean isFlexCardStatusVerified = false;
		try {
			Log.info("benfit name: " + benefit.getBenefitType());
			isFlexCardStatusVerified = pageObjectManager_CoreFlex.getPageObjects().get(benefit.getBenefitType())
					.verifyFlexBenefitCardStatusAfterInitialActualization(indexBenefitCard, expectedEstimatedDate);

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

	private boolean verifyFlexBenefitCardStatusAfterEndActualization(int indexBenefitCard, Benefit benefit,
			String expectedEstimatedDate) {
		boolean isFlexCardStatusVerified = false;
		try {
			Log.info("benfit name: " + benefit.getBenefitType());
			isFlexCardStatusVerified = pageObjectManager_CoreFlex.getPageObjects().get(benefit.getBenefitType())
					.verifyFlexBenefitCardStatusAfterEndActualization(indexBenefitCard, expectedEstimatedDate);

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

	public boolean verifyFlexBenefitCardDetailsOfAiresManagedBenefits(String expectedStatus, String tracingSelection) {
		boolean isFlexCardDetailsVerified = false;
		boolean flag = false;
		String expectedEstimatedDate = CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy");
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))) {
					int indexBenefitCard = BusinessFunctions.returnindexItemFromListUsingText(driver,
							flexCardBenefitDisplayName, benefit.getBenefitDisplayName());
					isFlexCardDetailsVerified = verifyFlexCardDetails(indexBenefitCard, benefit)
							&& verifyFlexCardStatus(indexBenefitCard, benefit, tracingSelection, expectedEstimatedDate)
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
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))) {
					int indexBenefitCard = BusinessFunctions.returnindexItemFromListUsingText(driver,
							flexCardBenefitDisplayName, benefit.getBenefitDisplayName());
					isFlexCardDetailsVerified = verifyFlexCardDetails(indexBenefitCard, benefit)
							&& verifyFlexCardStatus(indexBenefitCard, benefit, tracingSelection, expectedEstimatedDate)
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
			if ((tracingSelection.equals(MobilityXConstants.CANCELED))
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
						benefit, expectedEstimatedDate);
				break;
			case MobilityXConstants.POST_END_TRACING:
				isFlexBenefitCardStatusVerified = verifyFlexBenefitCardStatusAfterEndActualization(indexBenefitCard,
						benefit, expectedEstimatedDate);
				break;
			case MobilityXConstants.CANCELED:
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
			if (benefit.getNumberOfBenefitSelected() > 1) {
				CoreFunctions.scrollToElementUsingJS(driver, flexCardSectionHeader, MobilityXConstants.FLEX_CARD_PANEL);
				CoreFunctions.waitHandler(1);
				CoreFunctions.verifyText(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardNumberOfBenefitSelectedSubElement),
						String.valueOf(benefit.getNumberOfBenefitSelected()),
						MobilityXConstants.FLEX_CARD_NUMBER_OF_BENEFIT_SELECTED);
				CoreFunctions.moveToElement(driver, CoreFunctions.findSubElement(
						flexCardPanelList.get(indexBenefitCard), flexCardNumberOfBenefitSelectedSubElement));
				CoreFunctions.verifyText(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(indexBenefitCard),
								flexCardNumberOfBenefitSelectedToolTipTextSubElement),
						MobilityXConstants.FLEX_CARD_NUMBER_OF_BENEFIT_SELECTED_TOOLTIP_TEXT.replace("numberOf",
								String.valueOf(benefit.getNumberOfBenefitSelected())),
						MobilityXConstants.FLEX_CARD_NUMBER_OF_BENEFIT_SELECTED_TOOLTIP);
			}
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

	private boolean verifyCoreBenefitCardDetails(String tracingSelection) {
		boolean isCoreCardDetailsVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : coreBenefits) {
				if (benefit.getPolicyCreationGroup()
						.contains(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))
						&& benefit.getAiresManagedService().equals("Yes")) {
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
			CoreFunctions.scrollUpUsigActions(driver);
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
						benefit);
				break;
			case MobilityXConstants.POST_END_TRACING:
				isCoreBenefitCardStatusVerified = verifyCoreBenefitCardStatusAfterEndActualization(indexBenefitCard,
						benefit);
				break;
			case MobilityXConstants.CANCELED:
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
		if (isCoreBenefitCardStatusVerified) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_CARD_STATUS,
					CoreConstants.PASS, benefit.getBenefitDisplayName()));
		}
		return isCoreBenefitCardStatusVerified;
	}

	private boolean verifyCoreBenefitCardStatusAfterInitialActualization(int indexBenefitCard, Benefit benefit) {
		boolean isCoreCardStatusVerified = false;
		String expectedEstimatedDate = CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy");
		try {
			isCoreCardStatusVerified = pageObjectManager_CoreFlex.getPageObjects().get(benefit.getBenefitType())
					.verifyCoreBenefitCardStatusAfterInitialActualization(indexBenefitCard, expectedEstimatedDate);
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

	private boolean verifyCoreBenefitCardStatusAfterEndActualization(int indexBenefitCard, Benefit benefit) {
		boolean isCoreCardStatusVerified = false;
		try {
			isCoreCardStatusVerified = pageObjectManager_CoreFlex.getPageObjects().get(benefit.getBenefitType())
					.verifyCoreBenefitCardStatusAfterEndActualization(indexBenefitCard, benefit);

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
					CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"));
			submittedPolicyState.put("TotalPointsSubmitted",
					CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"));
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

	private List<Benefit> getBenefits(String benefitType, String policyRequiredFor) {
		List<Benefit> benefitNameList = new ArrayList<Benefit>();
		if (benefitType.equals(COREFLEXConstants.FLEX) || benefitType.equals(COREFLEXConstants.BOTH)) {
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if ((ben.getPolicyCreationGroup().contains(policyRequiredFor))) {
						benefitNameList.add(ben);
					} else
						continue;
				}
			}
		}
		return benefitNameList;
	}

	public void clickElementOfDashboardPage(String impersonateAUser) {
		CoreFunctions.scrollVerticallyDownByGivenPixle(driver, 1000);
		CoreFunctions.click(driver, _impersonateAUserTile, _impersonateAUserTile.getText());
		CoreFunctions.waitForLoaderToDisappear(driver);
	}

	public boolean verifyImpersonateDialogTitleAppear() {
		return CoreFunctions.isElementByLocatorExist(driver, _impersonateDialogTitleAppear, 20);
	}

	public void searchUserAndImpersonate(DataTable table) {
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		CoreFunctions.clearAndSetText(driver, _userNameText,
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"));
		CoreFunctions.waitHandler(1);
		BusinessFunctions.selectValueFromDropdown(driver, _clientListDropdownSelector,
				data.get(0).get("Client").trim());
		CoreFunctions.waitHandler(2);
		BusinessFunctions.selectValueFromDropdown(driver, _userTypeDropdownSelector,
				data.get(0).get("User Type").trim());
		CoreFunctions.click(driver, _searchButton, "search icon");
		clickUserNameFromList(data.get(0).get("User Name"));
	}

	private void clickUserNameFromList(String userName) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _userNameList);
		CoreFunctions.selectItemInListByText(driver, _userNameList,
				CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail"));

	}

	public boolean delegateAccess() {
		try {
			CoreFunctions.clickElement(driver, _btnNewDelegate);
			CoreFunctions.writeToPropertiesFile("CF_Delegate_FirstName", CoreFunctions.generateRandomString(15));
			CoreFunctions.writeToPropertiesFile("CF_Delegate_LastName", CoreFunctions.generateRandomString(15));
			CoreFunctions.setElementText(driver, _inputDelFirstName,
					CoreFunctions.getPropertyFromConfig("CF_Delegate_FirstName"));
			CoreFunctions.setElementText(driver, _inputDelLastName,
					CoreFunctions.getPropertyFromConfig("CF_Delegate_LastName"));
			CoreFunctions.setElementText(driver, _inputDelEmail, "airesautomationtransferee@aires.com");
			CoreFunctions.setElementText(driver, _inputDelStartDate, CoreFunctions.getcurrentdate());
			CoreFunctions.setElementText(driver, _inputDelEndDate,
					CoreFunctions.addDaysMonthYearToCurrentDate(PDTConstants.YEAR, "dd-MMM-yyyy", 1));
			CoreFunctions.clickElement(driver, _radioDelFlexAccess);
			CoreFunctions.clickElement(driver, _btnDelegateSubmit);
			if (CoreFunctions.isElementExist(driver, _popUpMatchingFile, 3)) {
				CoreFunctions.clickElement(driver, _popUpMatchingFileConfirmButton);
			}
			if (CoreFunctions.getElementText(driver, _popUpDelegateGenericUsername)
					.equalsIgnoreCase(MobilityXConstants.DELEGATE_GENERIC_USERNAME_TEXT)) {
				CoreFunctions.clickElement(driver, _popUpDelegateGenericUsernameSubmitButton);
			}
			if (CoreFunctions.getElementText(driver, _popUpDelegateAuthDisclaimer)
					.equalsIgnoreCase(MobilityXConstants.DELEGATE_CONSENT_TEXT)) {
				CoreFunctions.clickElement(driver, _popUpDelegateAuthDisclaimerConfirmDelegateButton);
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_CREATED_A_NEW_DELEGATE_USER_ON_MOBILITYX_APPLICATION,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CREATING_A_NEW_DELEGATE_USER_ON_MOBILITYX_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));

		}
		return false;
	}

	public boolean validateDelegateUserBanner() {
		try {
			CoreFunctions.verifyTextContains(CoreFunctions.getElementText(driver, _userBanner),
					("You are logged in as " + CoreFunctions.getPropertyFromConfig("CF_Delegate_FirstName") + " "
							+ CoreFunctions.getPropertyFromConfig("CF_Delegate_LastName")
							+ " acting as a delegate on behalf of "
							+ CoreFunctions.getPropertyFromConfig("Transferee_firstName")),
					MobilityXConstants.DELEGATED_USER_BANNER);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_LOGGED_IN_DELEGATE_USER_ON_MOBILITYX_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyDelegateAccessGrantedEmail() {
		try {
			String host = "outlook.office365.com";
			// Enter Your Email ID
			String userName = "airesautomationtransferee@aires.com";
			// Enter your email outlook password
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			// Enter expected From complete email address
			String expFromUserName = "mxssodev5@aires.com";
			// Enter expected email subject
			String expEmailSubject = "MobilityX Delegate Access Granted";
			String actualResultDelegateDetails = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject, MobilityXConstants.DELEGATE_ACCESS_GRANTED);
			actualResultDelegateDetails = removeHTMLTagsFromEmailContent(actualResultDelegateDetails);
			Log.info("ActualEmailText:" + actualResultDelegateDetails);
			Log.info("ExpectEmailText:" + getExpectedDelegateEmailText());
			CoreFunctions.verifyTextContains(actualResultDelegateDetails, getExpectedDelegateEmailText(),
					MobilityXConstants.DELEGATE_ACCESS_GRANTED_EMAIL_CONTENTS);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_MOBILITYX_DELEGATE_ACCESS_GRANTED_EMAIL_CONTENTS,
					CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_MOBILITYX_DELEGATE_ACCESS_GRANTED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	private String getExpectedDelegateEmailText() {
		return MobilityXConstants.EXPECTED_DELEGATE_EMAIL_TEXT
				.replace("transfereeFN", CoreFunctions.getPropertyFromConfig("Transferee_firstName"))
				.replace("transfereeLN", CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
	}

	private String removeHTMLTagsFromEmailContent(String actualResultSubmissionDetails) {
		return actualResultSubmissionDetails.replace("<span>", "").replace("</span>", "").replace("\t", "")
				.replace("\r\n", "").replace("<br>", "").replace("<ul>", "").replace("<li>", "").replace("</ul>", "")
				.replace("<font color=\"#208DA6\">", "").replace("</li>", "").replace("</font>", "")
				.replace("<input checked=\"true\" type=\"checkbox\"><font style=\"font-weight:bold\">", "").trim();
	}

	public boolean verifyFlexPdfDownloadedDocument(String documentName) {
		try {
			String filePath = System.getProperty("user.home") + "/Downloads/" + documentName;
			String file_content = BusinessFunctions.getPdfDocContent(filePath);

			if (verifyPointSummaryPDFContents(documentName, file_content)) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_AND_POINTS_DETAILS_BY_CLIENT_ON_FLEX_PDF_DOWNLOADED_DOCUMENT,
						CoreConstants.PASS, documentName));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_AND_POINTS_DETAILS_BY_CLIENT_ON_FLEX_PDF_DOWNLOADED_DOCUMENT,
					CoreConstants.FAIL, e.getMessage(), documentName));
			return false;
		}
		return false;
	}

	private boolean verifyPointSummaryPDFContents(String documentName, String actualFileContent) {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		try {
			CoreFunctions.verifyTextContainsIgnoreCase(actualFileContent,
					(CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName")),
					MobilityXConstants.TRANSFEREE_NAME);
			CoreFunctions
					.verifyTextContains(actualFileContent,
							MobilityXConstants.EXPECTED_SPENT_POINTS_TEXT_PDF_DOCUMENT
									.replace("SP",
											format.format(Double.parseDouble(CoreFunctions
													.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))))
									.replace("TP",
											format.format(Double.parseDouble(CoreFunctions
													.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")))),
							MobilityXConstants.SPENT_AND_TOTAL_POINTS);
			CoreFunctions.verifyTextContains(actualFileContent,
					MobilityXConstants.EXPECTED_CURRENT_POINT_BALANCE_TEXT_PDF_DOCUMENT.replace("CB",
							format.format(Double.parseDouble(
									CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints")))),
					MobilityXConstants.CURRENT_POINT_BALANCE);

			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					CoreFunctions.verifyTextContains(actualFileContent, benefit.getBenefitDisplayName(),
							MobilityXConstants.BENEFIT_DISPLAY_NAME);
					CoreFunctions.verifyTextContains(actualFileContent, benefit.getBenefitAmount(),
							MobilityXConstants.BENEFIT_ALLOWANCE_AMOUNT);
					CoreFunctions.verifyTextContains(actualFileContent,
							format.format(
									Double.parseDouble(benefit.getPoints()) * benefit.getNumberOfBenefitSelected()),
							MobilityXConstants.BENEFIT_POINTS);
				} else {
					continue;
				}
			}
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				CoreFunctions.verifyTextContains(actualFileContent,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
						MobilityXConstants.CUSTOM_CASHOUT_NAME);
				CoreFunctions.verifyTextContains(actualFileContent,
						format.format(Double.parseDouble(
								CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints"))),
						MobilityXConstants.CASHOUT_POINTS);
				CoreFunctions.verifyTextContains(actualFileContent, BusinessFunctions.getExpectedCashoutDescription(),
						MobilityXConstants.TRANSFEREE_CASHOUT_DESCRIPTION);
			}

			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_AND_POINTS_DETAILS_BY_CLIENT_ON_FLEX_PDF_DOWNLOADED_DOCUMENT,
					CoreConstants.FAIL, e.getMessage(), documentName));
			return false;
		}
	}

	public boolean verifyAppCues(String pageName, DataTable dataTable) {
		List<String> expectedAppCuesList = dataTable.asList(String.class);
		String actualAppCueText = null;
		int index = 0;
		try {
			if (CoreFunctions.isElementExist(driver, _tooltipIFrame, 15)) {
				while (index < expectedAppCuesList.size()) {
					driver.switchTo().frame(_tooltipIFrame);
					CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _tooltipIFrameHideLink,
							MobilityXConstants.HIDE);
					actualAppCueText = CoreFunctions.getElementText(driver, _tooltipIFrameText);
					CoreFunctions.verifyText(actualAppCueText, expectedAppCuesList.get(index),
							MobilityXConstants.APPCUES);
					CoreFunctions.clickElement(driver, _tooltipIFrameNextButton);
					driver.switchTo().defaultContent();
					CoreFunctions.waitHandler(4);
					index++;
				}
				driver.switchTo().defaultContent();
				Reporter.addStepLog(MessageFormat.format(MobilityXConstants.SUCCESSFULLY_VERIFIED_APPCUES,
						CoreConstants.PASS, pageName));
				return true;
			} else {
				Reporter.addStepLog(MessageFormat.format(MobilityXConstants.APPCUES_NOT_DISPLAYED, CoreConstants.FAIL,
						pageName, expectedAppCuesList.get(index)));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_APPCUES,
					CoreConstants.FAIL, e.getMessage(), pageName));
			return false;
		}
	}

	public boolean verifyGetHelpSectionOptions() {
		try {
			CoreFunctions.moveToElement(driver, _headerGetHelp);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _headerGetHelp), MobilityXConstants.GET_HELP,
					MobilityXConstants.GET_HELP_HEADER);
			CoreFunctions.verifyTextContains(CoreFunctions.getElementText(driver, _optionGetHelp),
					MobilityXConstants.EXPECTED_MOBILITY_JOURNEY_HOME_APP_CUE_OPTION,
					MobilityXConstants.MOBILITY_JOURNEY_HOME_APP_CUE_OPTION);
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.SUCCESSFULLY_VERIFIED_APPCUES_OPTION_UNDER_GET_HELP_SECTION,
							CoreConstants.PASS, MobilityXConstants.MOBILITY_JOURNEY_HOME,
							MobilityXConstants.EXPECTED_MOBILITY_JOURNEY_HOME_APP_CUE_OPTION));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_APPCUES_OPTION_UNDER_GET_HELP_SECTION_ON,
					CoreConstants.FAIL, e.getMessage(), MobilityXConstants.MOBILITY_JOURNEY_HOME));
			return false;
		}
	}

}
