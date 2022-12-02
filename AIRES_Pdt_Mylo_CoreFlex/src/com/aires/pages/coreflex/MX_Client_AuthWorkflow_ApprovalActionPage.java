package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.ArrayList;
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
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class MX_Client_AuthWorkflow_ApprovalActionPage extends Base {

	public MX_Client_AuthWorkflow_ApprovalActionPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Initiation For Transferee Text
	@FindBy(how = How.CSS, using = "span[id*='HeaderEEPanel']")
	private WebElement _textInitiationFor;

	// Approve Button
	@FindBy(how = How.CSS, using = "div[id*='approveButton']")
	private WebElement _buttonApprove;

	// Deny Button
	@FindBy(how = How.CSS, using = "div[id*='denyButton']")
	private WebElement _buttonDeny;

	// Send Approval Button
	@FindBy(how = How.CSS, using = "div[id*='adpapproal']")
	private WebElement _buttonSendApproval;

	@FindBy(how = How.CSS, using = "span[id*='totalPoints'] :not([style*='display:none']) input[id*='totalInput']")
	private WebElement _inputTotalPoints;

	@FindBy(how = How.CSS, using = "span[id*='totalPoints'] :not([style*='display:none']) span[class*='RXHeaderText']")
	private WebElement _textTotalPointsHeader;

	@FindBy(how = How.CSS, using = "span[id*='totalPoints'] :not([style*='display:none']) span[class*='RXInputHint'] label[for*='totalInput']")
	private WebElement _labelTotalPointsInputHint;

	@FindBy(how = How.CSS, using = "span[id*='coreFlex'] span[class='RXHeaderText']")
	private WebElement _textFlexBenefitsHeader;

	@FindBy(how = How.CSS, using = "span[id*='coreFlex'] span[class='RXCFSmallText']")
	private WebElement _textFlexBenefitsDesc;

	@FindBy(how = How.CSS, using = "span[id*='coreFlex'] span[class*='button']")
	private WebElement _btnFlexBenefitSelection;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'RXCFSubmitBenefitsGrPnl')]//td[1]/span")
	private WebElement _selectedPoints;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'RXCFSubmitBenefitsGrPnl')]//td[3]/span")
	private WebElement _totalPoints;

	@FindBy(how = How.CSS, using = "div[id*='savedCore'] label")
	private List<WebElement> _textSelectedCoreBenefitsNameList;

	// CookiePopUp
	@FindBy(how = How.ID, using = "cookiePupupButtonId")
	private WebElement _btn_OkOnSiteCookieAfterLogin;

	@FindBy(how = How.CSS, using = "div[id*='savedCore'] span[class='RXCFSmallText RXAiresSeaglass']")
	private List<WebElement> _textCoreAllowanceAmountList;

	@FindBy(how = How.CSS, using = "div[id*='savedFlex'] span[class*='RXCFSubmitBenefitsBenefits']")
	private List<WebElement> _textSelectedFlexBenefitsNameList;

	@FindBy(how = How.CSS, using = "div[id*='savedFlex'] div>span[class*='RXAiresSeaglass']")
	private List<WebElement> _textSelectedFlexBenefitsAmountAllowanceList;

	@FindBy(how = How.CSS, using = "div[id*='savedFlex'] td>span[class*='RXAiresSeaglass']")
	private List<WebElement> _textSelectedFlexBenefitsPointsList;

	@FindBy(how = How.CSS, using = "div[id*='savedFlex'] td>span[class*='RXBolder RXCFSmallText']")
	private List<WebElement> _textSelectedFlexBenefitsQuantityList;
	
	@FindBy(how = How.XPATH, using = "//div[@class='growl-message'][contains(string(),'Thanks. Your approval for this initiation has been received.')]")
	private WebElement _textApprovalSuccessGrowlMessage;
	
	@FindBy(how = How.CSS, using = "a[id='dppw1::close']")
	private WebElement _iconClose;
	
	@FindBy(how = How.CSS, using = "table[class*='RXRightIconPanel'] span[class*='RXHeaderText']")
	private WebElement _textPostApprovalAuthStatus;
	

	/**************************************************************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	/**************************************************************************************************************/

	/**
	 * Method to verify navigated Page
	 */
	public boolean verifyPageNavigation(String pageName) {
		try {
			String expectedIntiationForText = MobilityXConstants.INITIATION_FOR + " "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT) + " "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _textInitiationFor,
					MobilityXConstants.INITIATION_FOR);
			CoreFunctions.verifyText(driver, _textInitiationFor, expectedIntiationForText,
					MobilityXConstants.INITIATION_FOR);
			if (CoreFunctions.isElementExist(driver, _buttonApprove, 2)
					&& CoreFunctions.isElementExist(driver, _buttonDeny, 2)) {
				Reporter.addStepLog(MessageFormat.format(MobilityXConstants.SUCCESSFULLY_NAVIGATED_TO_PAGE,
						CoreConstants.PASS, pageName));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_PAGE,
					CoreConstants.FAIL, e.getMessage(), pageName));
		}
		return false;
	}

	public boolean verifyTotalPointsSection() {
		boolean isTotalPointsSectionVerified = false;
		try {
			switch (CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_FlexSetupType")) {
			case COREFLEXConstants.USER_DEFINED:
				if (CoreFunctions.isElementExist(driver, _inputTotalPoints, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.TOTAL_POINTS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_USER_DEFINED_POLICY_TYPE_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS));
					isTotalPointsSectionVerified = verifyTotalPointsContents();
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.TOTAL_POINTS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_USER_DEFINED_POLICY_TYPE_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					isTotalPointsSectionVerified = false;
				}
				break;
			case COREFLEXConstants.STATIC_FIXED:
				if (CoreFunctions.isElementExist(driver, _inputTotalPoints, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.TOTAL_POINTS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_STATIC_FIXED_FLEX_POLICY_TYPE_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					isTotalPointsSectionVerified = false;
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.SUCCESSFULLY_VERIFIED_TOTAL_POINTS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_STATIC_FIXED_FLEX_POLICY_TYPE_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS));
					isTotalPointsSectionVerified = true;
				}
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TOTAL_POINTS_SECTION_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
		}
		return isTotalPointsSectionVerified;
	}

	private boolean verifyTotalPointsContents() {
		try {
			CoreFunctions.verifyText(driver, _textTotalPointsHeader, MobilityXConstants.TOTAL_POINTS,
					MobilityXConstants.TOTAL_POINTS);
			return true;
		} catch (Exception e) {
			Log.info(e.getMessage());
			return false;
		}
	}

	public boolean verifyFlexBenefitsSection(String personResponsible) {
		boolean iFlexBenefitsSectionVerified = false;
		try {
			switch (CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")) {
			case COREFLEXConstants.CLIENT_INITIATOR:
			case COREFLEXConstants.CLIENT_AND_TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS,
							CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
					iFlexBenefitsSectionVerified = verifyFlexBenefitsSectionContents();
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL,
							CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
					iFlexBenefitsSectionVerified = false;
				}
				break;
			case COREFLEXConstants.TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					iFlexBenefitsSectionVerified = false;
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFITS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS));
					iFlexBenefitsSectionVerified = true;
				}
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FLEX_BENEFIT_SECTION_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
		}
		return iFlexBenefitsSectionVerified;
	}

	private boolean verifyFlexBenefitsSectionContents() {
		try {
			CoreFunctions.verifyText(driver, _textFlexBenefitsHeader, MobilityXConstants.FLEX_BENEFITS,
					MobilityXConstants.FLEX_BENEFITS_HEADER);
			CoreFunctions.verifyText(driver, _textFlexBenefitsDesc, MobilityXConstants.FLEX_BENEFITS_SECTION_DESC,
					MobilityXConstants.FLEX_BENEFITS_SECTION_TEXT);
			return (!CoreFunctions.isElementExist(driver, _btnFlexBenefitSelection, 2));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FLEX_BENEFIT_SECTION_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
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

	public void clickElementOnThePage(String elementName) {
		try {
			switch (elementName) {
			case MobilityXConstants.APPROVE:
				CoreFunctions.clickElement(driver, _buttonApprove);
				break;
			case MobilityXConstants.DENY:
				CoreFunctions.clickElement(driver, _buttonDeny);
				break;
			case MobilityXConstants.SEND_APPROVAL:
				CoreFunctions.clickElement(driver, _buttonSendApproval);
				break;
			case MobilityXConstants.CLOSE_ICON:
				CoreFunctions.waitHandler(3);
				CoreFunctions.clickElement(driver, _iconClose);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_BUTTON_ON_THE_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage(), elementName));
			Log.info(e.getMessage());
		}
	}

	public boolean verifySubmittedFlexBenefits(String personResponsible) {
		boolean iFlexBenefitsSectionVerified = false;
		try {
			switch (personResponsible) {
			case COREFLEXConstants.CLIENT_INITIATOR:
			case COREFLEXConstants.CLIENT_AND_TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS,
							CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
					iFlexBenefitsSectionVerified = verifyFlexBenefitsSectionContents()
							&& verifySelectedCoreFlexBenefits();
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL,
							CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
					iFlexBenefitsSectionVerified = false;
				}
				break;
			case COREFLEXConstants.TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					iFlexBenefitsSectionVerified = false;
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFITS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS));
					iFlexBenefitsSectionVerified = true;
				}
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_FLEX_BENEFITS_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
		}
		return iFlexBenefitsSectionVerified;
	}

	public boolean verifySelectedCoreFlexBenefits() {
		boolean isFlexBenefitSectionVerified = false;
		try {
			isFlexBenefitSectionVerified = verifySelectedBenefitDetails(
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"))
					&& Double.parseDouble(CoreFunctions.getElementText(driver, _selectedPoints)) == (Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")))
					&& (Double.parseDouble(CoreFunctions.getElementText(driver, _totalPoints)) == (Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))));

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_COREFLEX_BENEFITS_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isFlexBenefitSectionVerified;
	}

	private boolean verifySelectedBenefitDetails(String policyRequiredFor, String benefitType) {
		switch (benefitType) {
		case COREFLEXConstants.FLEX:
			return verifySelectedFlexBenefitsDetails(policyRequiredFor, benefitType);
		case COREFLEXConstants.CORE:
			return verifyCoreBenefitsDetails(policyRequiredFor, benefitType);
		case COREFLEXConstants.BOTH:
			return verifyCoreBenefitsDetails(policyRequiredFor, benefitType)
					&& verifySelectedFlexBenefitsDetails(policyRequiredFor, benefitType);
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
		return false;
	}

	private boolean verifyCoreBenefitsDetails(String policyRequiredFor, String benefitType) {
		boolean isCoreBenefitDetailsOnAuthFormVerified = false;
		try {
			for (Benefit benefit : getCoreBenefits(benefitType, policyRequiredFor, "0")) {
				int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_textSelectedCoreBenefitsNameList, benefit.getBenefitDisplayName());
				isCoreBenefitDetailsOnAuthFormVerified = verifyCorePlanningToolBenefitDetails(indexBenefit, benefit);
				if (!isCoreBenefitDetailsOnAuthFormVerified) {
					break;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CORE_BENEFIT_DETAILS_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCoreBenefitDetailsOnAuthFormVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_DETAILS_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.PASS));
		}
		return isCoreBenefitDetailsOnAuthFormVerified;
	}

	private boolean verifyCorePlanningToolBenefitDetails(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textSelectedCoreBenefitsNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textCoreAllowanceAmountList, indexBenefit, true)
						.equals(benefit.getBenefitAmount()));
	}

	private List<Benefit> getCoreBenefits(String policyType, String policyRequiredFor, String numberOfMilestones) {
		List<Benefit> benefitNameList = new ArrayList<Benefit>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (Benefit benefit : coreBenefits) {
				if ((policyRequiredFor.equals(COREFLEXConstants.ALL_BENEFITS))
						&& (benefit.getPolicyCreationGroup().contains(policyRequiredFor))) {
					benefitNameList.add(benefit);
				} else if ((policyRequiredFor.equals(COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS))
						&& (benefit.getAiresManagedService().equals("Yes"))
						&& (benefit.getNoOfMilestones() == Integer.parseInt(numberOfMilestones))) {
					benefitNameList.add(benefit);
				} else if (((policyRequiredFor.equals(COREFLEXConstants.CLONING))
						|| (policyRequiredFor.equals(COREFLEXConstants.VERSIONING))
						|| (policyRequiredFor.equals(COREFLEXConstants.CLIENT)))
						&& (benefit.getPolicyCreationGroup().contains(policyRequiredFor))) {
					benefitNameList.add(benefit);
				}

			}
		}
		return benefitNameList;
	}

	private boolean verifySelectedFlexBenefitsDetails(String policyRequiredFor, String benefitType) {
		boolean isFlexBenefitDetailsVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textSelectedFlexBenefitsNameList, benefit.getBenefitDisplayName());
					isFlexBenefitDetailsVerified = verifySelectedBenefitDetailsOnAuthForm(indexBenefit, benefit);
					if (!isFlexBenefitDetailsVerified) {
						return false;
					} else {
						flag = true;
					}
				} else {
					isFlexBenefitDetailsVerified = true;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FLEX_BENEFIT_DETAILS_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_DETAILS_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsVerified;
	}

	private List<Benefit> getBenefits(String policyType, String policyRequiredFor, String numberOfMilestones) {
		List<Benefit> benefitNameList = new ArrayList<Benefit>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if ((policyRequiredFor.equals(COREFLEXConstants.ALL_BENEFITS))
							&& (ben.getPolicyCreationGroup().contains(policyRequiredFor))) {
						benefitNameList.add(ben);
					} else if ((policyRequiredFor.equals(COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS))
							&& (ben.getAiresManagedService().equals("Yes"))
							&& (ben.getNoOfMilestones() == Integer.parseInt(numberOfMilestones))) {
						benefitNameList.add(ben);
					} else if (((policyRequiredFor.equals(COREFLEXConstants.CLONING))
							|| (policyRequiredFor.equals(COREFLEXConstants.VERSIONING))
							|| (policyRequiredFor.equals(COREFLEXConstants.CLIENT)))
							&& (ben.getPolicyCreationGroup().contains(policyRequiredFor))) {
						benefitNameList.add(ben);
					}
				}
			}
		}
		return benefitNameList;
	}

	private boolean verifySelectedBenefitDetailsOnAuthForm(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsAmountAllowanceList,
						indexBenefit, true).equals(benefit.getBenefitAmount()))
				&& (CoreFunctions
						.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsQuantityList, indexBenefit, true)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& ((Double.parseDouble((CoreFunctions
						.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsPointsList, indexBenefit, true)
						.replace("pts", "").trim()))) == ((Double.parseDouble(benefit.getPoints()))
								* (benefit.getNumberOfBenefitSelected())));
	}

	public boolean verifyCashoutSelectionOnAuthForm() {
		boolean isSelectedPortionCashoutDetailsVerified = false;
		for (WebElement element : _textSelectedFlexBenefitsNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_textSelectedFlexBenefitsNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				isSelectedPortionCashoutDetailsVerified = verifySelectedCashoutDetails(indexCashout,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				break;
			}
		}
		if (isSelectedPortionCashoutDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SELECTED_PORTION_CASHOUT_DETAILS_UNDER_FLEX_BENEFIT_SECTION_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.PASS));
		}
		return isSelectedPortionCashoutDetailsVerified;
	}

	private boolean verifySelectedCashoutDetails(int indexCashout, String customCashoutBenefitName) {
		try {
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsNameList, indexCashout,
							true),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyValue(
					(Double.parseDouble((CoreFunctions
							.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsPointsList, indexCashout, true)
							.replace("pts", "").trim()))),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints")),
					MobilityXConstants.CASHOUT_POINTS);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}
	
	public boolean verifySuccessGrowlMessageDisplayed(String messagetype) {
		try {
			if(CoreFunctions.isElementExist(driver, _iconClose, 2)) {
				CoreFunctions.clickElement(driver, _iconClose);
			}
			if (CoreFunctions.isElementExist(driver, _textApprovalSuccessGrowlMessage, 5)) {
				Reporter.addStepLog(
						CoreConstants.PASS + CoreConstants.VRFIED_THAT + MobilityXConstants.SUCCESS_MESSAGE_TEXT
								+ CoreConstants.IS_DISPLAYED_AS + "<b>\"" + _textApprovalSuccessGrowlMessage.getText() + "\"</b>");
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _textApprovalSuccessGrowlMessage);
				CoreFunctions.clickElement(driver, _iconClose);
				return true;
			}
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.GROWL_MESSAGE_NOT_MATCHED, CoreConstants.FAIL,
					_textApprovalSuccessGrowlMessage.getText()));
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _textApprovalSuccessGrowlMessage);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_GROWL_MESSAGE_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage(),messagetype));
		}
		return false;
	}

	public boolean verifyAuthFormStatusPostAction(String status) {
		try {
			if (CoreFunctions.getElementText(driver, _textPostApprovalAuthStatus).equals(status)) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_POST_APPROVAL_AUTH_FORM_STATUS_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
						CoreConstants.PASS,status));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_POST_APPROVAL_AUTH_FORM_STATUS_ON_AUTH_WORKFLOW_APPROVAL_ACTION_PAGE,
					CoreConstants.FAIL, e.getMessage(),status));			
		}	
		return false;
	}

}