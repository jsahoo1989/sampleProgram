package com.aires.pages.coreflex;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import com.vimalselvam.cucumber.listener.Reporter;

public class MX_Client_BenefitsBundlePage extends Base {

	public MX_Client_BenefitsBundlePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "span[class='RXHugestText RXBolder']")
	private WebElement _textMyBenefitsBundleTitle;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Submitted Benefits')][@class='RXBiggerText RXBolder']")
	private WebElement _textSubmittedBenefitsTitle;

	@FindBy(how = How.XPATH, using = "//span[text()='Review and Submit']")
	private WebElement _btn_reviewAndSubmit;

	@FindBy(how = How.CSS, using = "div[id*='innerDiv']")
	private List<WebElement> _benefit_list;

	@FindBy(how = How.XPATH, using = "//textarea[@placeholder='Type optional notes here']")
	private WebElement optionalComments;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Type your name as above to confirm']")
	private WebElement input_transfereeName;

	@FindBy(how = How.CSS, using = "span.RXCFSubmitBenefitsTrnslink")
	private WebElement _link_transfereeName;

	@FindBy(how = How.CSS, using = "div.RXCFGreenRoundedButton.af_button.p_AFTextOnly")
	private WebElement _btn_submitBundle;

	@FindBy(how = How.XPATH, using = "//span[text()='OK - Let Me See My Benefits!']")
	private WebElement _btn_seeBenefits;

	@FindBy(how = How.CSS, using = "span.RXCFBiggerText.RXMineShaft.RXBolder")
	private WebElement _submitBundleTitle;

	@FindBy(how = How.XPATH, using = "//table[contains(@id,'subpointpn')]//td[1]/span")
	private WebElement _selectedPoints;

	@FindBy(how = How.XPATH, using = "//table[contains(@id,'subpointpn')]//td[3]/span")
	private WebElement _totalPoints;

	@FindBy(how = How.XPATH, using = "//table[contains(@id,'sbptpn')]//td[1]/span")
	private WebElement _submittedPoints;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'popup-container')]//span[@class='RXCFText RXMineShaft']")
	private WebElement _testPointsConsumed;

	@FindBy(how = How.CSS, using = "div[id*='innerDivCashoutSubmitBenefit'] span.RXText.RXCFSubmitBenefitsBenefits.RXBolder.RXCFWordwrap")
	private List<WebElement> submittedBenefits;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'popup-container')]//table[@class='RXAthensGreyBackground AFStretchWidth af_panelGroupLayout']")
	private List<WebElement> _confirmationDialogBenefitlist;

	@FindBy(how = How.CSS, using = "span[class='RXCFSmallText RXMineShaft RXBolder RXCFWordwrap']")
	private List<WebElement> _textAddedBenefitNameList;

	@FindBy(how = How.CSS, using = "span[class='RXCFSmallText RXMineShaft RXCFWordwrap']")
	private List<WebElement> _allowanceAmountList;

	@FindBy(how = How.CSS, using = "span[class='RXCFText RXBold RXAiresSeaglass']")
	private List<WebElement> _benefitsPointsList;

	@FindBy(how = How.CSS, using = "span[class='RXCFSmallText RXMineShaft']")
	private List<WebElement> _benefitQuantityList;

	@FindBy(how = How.CSS, using = "span[class='RXText RXBolder']")
	private List<WebElement> _confirmationDialogBenefitName;

	@FindBy(how = How.CSS, using = "span[class='RXCFSmallText RXAiresSeaglass']")
	private List<WebElement> _confirmationDialogAmountAllowanceMessage;

	@FindBy(how = How.CSS, using = "span[class='RXCFHugestText RXWhite RXBold']")
	private List<WebElement> _confirmationDialogBenefitPoint;

	@FindBy(how = How.CSS, using = "span[class='RXText RXGraniteGrey RXBolder']")
	private List<WebElement> _confirmationDialogBenefitSelectionQuantity;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'RXCFBenefitNameDesc')]//span[contains(@class,'RXBolder')]")
	private List<WebElement> _textSubmittedBenefitNameList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'SubmitBenefit')]//span[@class='RXCFSmallText RXMineShaft RXCFWordwrap'] | //div[contains(@id,'innerDivCashoutSubmitCashoutBenefit')]//div[contains(@class,'RXCFBenefitNameDesc')]")
	private List<WebElement> _textSubmittedAllowanceAmountList;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'Benefit')]//span[@class='RXCFText RXBold RXAiresSeaglass']")
	private List<WebElement> _textSubmittedBenefitsPointsList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'SubmitBenefit')]//span[@class='RXBolder RXCFSmallText'] | //div[contains(@id,'innerDivCashoutSubmitCashoutBenefit')]//img[@src='/mobilityx/adf/images/t.gif']")
	private List<WebElement> _textSubmittedBenefitQuantityList;

	@FindBy(how = How.CSS, using = "span[class='RXCFSmallerItalicText RXAiresCharcoal']")
	private List<WebElement> _textSubmittedBenefitDate;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'Benefit')]//a[contains(@class,'BorderButton')]/span")
	private List<WebElement> _buttonDeleteSubmittedBenefitList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'Benefit')]//a[contains(@class,'BorderButton')]")
	private List<WebElement> _buttonDeleteBenefitList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Unable to delete benefit. Please see comments in the History section below for more information.')]")
	private List<WebElement> _disabledDeleteButtonHoverText;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Unable to delete benefit due to completion of benefit.')]")
	private List<WebElement> _completedBenefitDisabledDeleteButtonHoverText;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'This benefit has been canceled by your Aires Representative due to a change. There will be no points returned to you as this benefit is still being used.')]")
	private List<WebElement> _canceledBenefitDisabledDeleteButtonHoverText;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'mainSubmittedBenefits')]//span[@class='RXAiresSeaglass RXCFBigText']")
	private List<WebElement> _textSubmittedBenefitsPoints;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Are you sure you want to remove this benefit selection?')]")
	private WebElement _removeBenefitDialog;

	@FindBy(how = How.XPATH, using = "//div[@class='growl-message'][contains(string(),'Your undo request is completed.')]")
	private WebElement _undoBenefitSuccessGrowlMessage;

	@FindBy(how = How.CSS, using = "span[class='RXCFText RXCFMineShaft']")
	private WebElement _removeBenefitDialogText;

	@FindBy(how = How.CSS, using = "span[class='RXText RXBolder']")
	private List<WebElement> _textRemoveBenefitNameList;

	@FindBy(how = How.XPATH, using = "//span[text()='Yes - request to delete these benefits']")
	private WebElement _buttonDeleteTheseBenefits;

	@FindBy(how = How.XPATH, using = "//span[text()='Yes - request to delete this benefit'] | //span[text()='Yes - request to delete these benefits']")
	private WebElement _buttonDeleteThisBenefits;

	@FindBy(how = How.XPATH, using = "//div[@class='growl-message'][contains(string(),'Your request has been sent. You will receive an email about the outcome of your request.')]")
	private WebElement _deleteBenefitSentGrowlMessage;

	@FindBy(how = How.CSS, using = "div[class='growl-message']")
	private WebElement _deleteClientBenefitSentGrowlMessage;

	@FindBy(how = How.XPATH, using = "//table[contains(@id,'stsrdiconpnl')]//span[contains(@id,'sbs')] | //table[contains(@id,'cotsrdiconpnl')]//span[contains(@id,'sbs')]")
	private List<WebElement> _benefitStatus;

	// Cashout Points Field Non Editable Text
	@FindBy(how = How.CSS, using = "td.AFContentCell > input")
	private WebElement _inputCashoutPoints;

	// Cashout Points Field Non Editable Text
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'RXCFGreenSmallRoundedButton')]/parent::td/preceding-sibling::td//span[@class='RXAiresSeaglass RXBolder RXCFText']")
	private WebElement _textInputCashoutPoints;

	// Cashout Update Button
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'RXCFGreenSmallRoundedButton')]//span[text()='Update']")
	private WebElement _buttonCashoutUpdate;

	@FindBy(how = How.XPATH, using = "//span[text()='Back to benefits list']")
	private WebElement _link_backToBenefitList;

	@FindBy(how = How.XPATH, using = "//span[text()='Save & Exit']")
	private WebElement _buttonSaveAndExit;

	/*********************************************************************/

	public static double availablePointsAfterSubmission = 0;

	public static double submittedPoints = 0;

	public static int hoverIndex = 0;

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	CoreFlex_SettlingInBenefitsData languageTrainingBenefitData = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getSettlingInBenefitDataList(COREFLEXConstants.LANGUAGE_TRAINING);

	public static boolean benefitDeletedFlag;
	public static boolean undoDeletedBenefitFlag;

	/*********************************************************************/

	public void clickElementOfPage(String elementName) {
		try {
			switch (elementName) {
			case MobilityXConstants.BACK_TO_BENEFITS_LIST:
				CoreFunctions.clickElement(driver, _link_backToBenefitList);
				break;
			case MobilityXConstants.SAVE_AND_EXIT:
				CoreFunctions.clickElement(driver, _buttonSaveAndExit);
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

	public boolean isBenefitsBundlePageDisplayed() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textMyBenefitsBundleTitle,
				MobilityXConstants.BENEFITS_BUNDLE);
		if ((CoreFunctions.getElementText(driver, _textMyBenefitsBundleTitle))
				.equals(MobilityXConstants.BENEFITS_BUNDLE)) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.MY_BUNDLE_PAGE_DISPLAYED, CoreConstants.PASS));
			return true;
		}
		Reporter.addStepLog(
				MessageFormat.format(MobilityXConstants.MY_BUNDLE_PAGE_IS_NOT_DISPLAYED, CoreConstants.FAIL));
		return false;
	}

	public void clickReviewAndSubmit() {
		CoreFunctions.clickElement(driver, _btn_reviewAndSubmit);
	}

	public void viewSubmittedBenefits() {
		CoreFunctions.clickElement(driver, _btn_seeBenefits);
		CoreFunctions.waitHandler(3);
		Reporter.addStepLog(
				MessageFormat.format(MobilityXConstants.SUBMISSION_SUCCESS_POPUP_DISPLAYED, CoreConstants.PASS));
	}

	public boolean isBenefitSubmittedPopUpDisplayed() {
		try {
			CoreFunctions.waitHandler(3);
			return CoreFunctions.isElementExist(driver, _btn_seeBenefits, 5);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMISSION_SUCCESS_POPUP,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	public void reviewAndConfirmBenefitSubmission(String optionalNotes, String transfereeName, String buttonName) {
		CoreFunctions.setElementText(driver, input_transfereeName, transfereeName);
		CoreFunctions.setElementText(driver, optionalComments, optionalNotes);
		CoreFunctions.waitHandler(2);
		CoreFunctions.click(driver, _btn_submitBundle, buttonName);
		MX_Client_BenefitsBundlePage.availablePointsAfterSubmission = Double
				.parseDouble(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable)
				- (MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints);
		MX_Client_BenefitsBundlePage.submittedPoints = MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints;
	}

	public boolean verifySelectedBenefitDetails() {
		boolean isBenefitsAndPointsMatached = false;
		try {
			isBenefitsAndPointsMatached = verifyFlexBenefitsDetailsOnBBPage()
					&& Double.parseDouble(CoreFunctions.getElementText(driver, _selectedPoints)) == (Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")))
					&& (Double.parseDouble(CoreFunctions.getElementText(driver, _totalPoints)) == (Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_REVIEWING_SELECTED_BENEFITS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatached)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_REVIEWED_SELECTED_BENEFITS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
		return isBenefitsAndPointsMatached;
	}

	public boolean isSubmitBundlePopupDisplayed() {
		return CoreFunctions.isElementExist(driver, _submitBundleTitle, 10);
	}

	public boolean isDeleteBenefitPopupDisplayed() {
		return CoreFunctions.isElementExist(driver, _removeBenefitDialog, 10);
	}

	public boolean verifyBenefitsDetailsOnSubmissionDialog() {
		boolean isPointsBenefitsDetailsValid = false;
		try {
			isPointsBenefitsDetailsValid = validateSubmissionInfoText()
					&& verifyFlexBenefitsDetailsOnSubmissionConfirmationDialog()
					&& verifyCashoutDetailsOnSubmissionConfirmationDialog();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPointsBenefitsDetailsValid) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.PASS));
		}
		return isPointsBenefitsDetailsValid;
	}

	private boolean verifyCashoutDetailsOnSubmissionConfirmationDialog() {
		boolean isPortionCashoutDetailsVerifiedOnConfirmationDialog = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isPortionCashoutDetailsVerifiedOnConfirmationDialog = iterateSubmissionDialogListAndVerifyCashout();
			} else if (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CASHOUT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPortionCashoutDetailsVerifiedOnConfirmationDialog) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_PORTION_CASHOUT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.PASS));
		}
		return isPortionCashoutDetailsVerifiedOnConfirmationDialog;
	}

	private boolean iterateSubmissionDialogListAndVerifyCashout() {
		for (WebElement element : _confirmationDialogBenefitName) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_confirmationDialogBenefitName,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				return (Double
						.parseDouble((CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogBenefitPoint,
								indexCashout, false)))) == (MX_Transferee_FlexPlanningTool_Page.selectedCashoutPoints);
			}
		}
		return false;
	}

	private boolean validateSubmissionInfoText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return CoreFunctions.getElementText(driver, _testPointsConsumed)
				.contains(
						MobilityXConstants.POINTS_CONSUMED_TEXT
								.replace("points_used",
										(String.valueOf(format
												.format(MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints))))
								.replace("total_points",
										policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
	}

	public boolean verifyFlexBenefitsDetailsOnBBPage() {
		boolean isFlexBenefitDetailsOnBBVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, benefit.getBenefitDisplayName());
					isFlexBenefitDetailsOnBBVerified = verifyBenefitsBundleDetails(indexBenefit, benefit);
					if (!isFlexBenefitDetailsOnBBVerified) {
						return false;
					} else {
						flag = true;
					}
				} else {
					isFlexBenefitDetailsOnBBVerified = true;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsOnBBVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsOnBBVerified;
	}

	private boolean verifyBenefitsBundleDetails(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textAddedBenefitNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _allowanceAmountList, indexBenefit, true)
						.equals(benefit.getBenefitAmount()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _benefitQuantityList, indexBenefit, true)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& ((Double.parseDouble(
						(CoreFunctions.getItemsFromListByIndex(driver, _benefitsPointsList, indexBenefit, true)
								.replace("pts", "").trim()))) == ((Double.parseDouble(benefit.getPoints()))
										* (Integer.parseInt(CoreFunctions.getItemsFromListByIndex(driver,
												_benefitQuantityList, indexBenefit, true)))));
	}

	public boolean verifyFlexBenefitsDetailsOnSubmissionConfirmationDialog() {
		boolean isFlexBenefitDetailsOnFTPVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, benefit.getBenefitDisplayName());
					isFlexBenefitDetailsOnFTPVerified = verifySelectedBenefitDetailsOnConfirmationDialog(indexBenefit,
							benefit);
					if (!isFlexBenefitDetailsOnFTPVerified) {
						return false;
					} else {
						flag = true;
					}
				} else {
					isFlexBenefitDetailsOnFTPVerified = true;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsOnFTPVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsOnFTPVerified;
	}

	private boolean verifySelectedBenefitDetailsOnConfirmationDialog(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogBenefitName, indexBenefit, false)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions
						.getItemsFromListByIndex(driver, _confirmationDialogAmountAllowanceMessage, indexBenefit, false)
						.equals(benefit.getBenefitAmount()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogBenefitSelectionQuantity,
						indexBenefit, false).equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& ((Double.parseDouble((CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogBenefitPoint,
						indexBenefit, false)))) == ((Double.parseDouble(benefit.getPoints()))
								* (Integer.parseInt(CoreFunctions.getItemsFromListByIndex(driver,
										_confirmationDialogBenefitSelectionQuantity, indexBenefit, false)))));
	}

	public boolean validateSubmittedBenefitDetails() {
		boolean isBenefitsAndPointsMatched = false, isSubmittedBenefitDetailsVerified = false;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
					&& verifySubmittedFlexBenefitsDetailsOnBBPage();
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0, true))) == Double
									.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")))
					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true))
							.equals(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_SUBMITTED_BENEFITS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatched)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));

		return isBenefitsAndPointsMatched;
	}

	public boolean validateSubmittedBenefitCashoutDetails() {
		boolean isBenefitsAndPointsMatched = false, isSubmittedBenefitDetailsVerified = false;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
					&& verifySubmittedCashoutDetailsOnBBPage() && verifySubmittedFlexBenefitsDetailsOnBBPage();
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0, true))) == Double
									.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")))
					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true))
							.equals(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_SUBMITTED_BENEFITS_AND_CASHOUT_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatched)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_CASHOUT_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));

		return isBenefitsAndPointsMatched;
	}

	private boolean verifySubmittedCashoutDetailsOnBBPage() {
		boolean isSubmittedPortionCashoutDetailsVerified = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isSubmittedPortionCashoutDetailsVerified = iterateSubmittedBenefitListAndVerifyCashout();
			} else if (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_CASHOUT_DETAILS_ON_BB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedPortionCashoutDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_CASHOUT_DETAILS_ON_BB_PAGE, CoreConstants.PASS));
		}
		return isSubmittedPortionCashoutDetailsVerified;
	}

	private boolean verifySubmittedBenefitsSectionHeader() {
		if (CoreFunctions.isElementExist(driver, _textSubmittedBenefitsTitle, 5)) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_DISPLAYED_SUBMITTED_BENEFIT_SECTION_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
			return true;
		}
		Reporter.addStepLog(
				MessageFormat.format(MobilityXConstants.SUBMITTED_BENEFIT_SECTION_NOT_DISPLAYED_ON_BENEFITS_BUNDLE_PAGE,
						CoreConstants.FAIL));
		return false;
	}

	private boolean verifySubmittedFlexBenefitsDetailsOnBBPage() {
		boolean isSubmittedFlexBenefitDetailsOnBBVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
					isSubmittedFlexBenefitDetailsOnBBVerified = verifySubmittedBenefitDetailsOnBB(indexBenefit,
							benefit);
					if (!isSubmittedFlexBenefitDetailsOnBBVerified) {
						return false;
					} else {
						flag = true;
					}
				} else {
					isSubmittedFlexBenefitDetailsOnBBVerified = true;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedFlexBenefitDetailsOnBBVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedFlexBenefitDetailsOnBBVerified;
	}

	private boolean verifySubmittedBenefitDetailsOnBB(int indexBenefit, Benefit benefit) {
		return ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedAllowanceAmountList, indexBenefit, true)
						.equals(benefit.getBenefitAmount()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit, true)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitDate, indexBenefit, true)
						.equals(CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy")))
				&& ((Double.parseDouble((CoreFunctions
						.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexBenefit, true)
						.replace("pts", "").trim()))) == ((Double.parseDouble(benefit.getPoints()))
								* (Integer.parseInt(CoreFunctions.getItemsFromListByIndex(driver,
										_textSubmittedBenefitQuantityList, indexBenefit, true)))))
				&& (benefit.getAiresManagedService().equals("No")
						? CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexBenefit, true)
								.equals(MobilityXConstants.VIEW_PAYMENTS)
						: CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexBenefit, true)
								.equals(COREFLEXConstants.SUBMITTED))
				&& CoreFunctions.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList, indexBenefit, true)
						.equals(MobilityXConstants.DELETE));
	}

	public boolean performSubmittedBenefitAction(String action) {
		try {
			switch (action) {
			case MobilityXConstants.DELETE:
				return deleteSubmittedFlexBenefit();
			case MobilityXConstants.UNDO:
				return undoDeletedFlexBenefit();
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_DELETING_SUBMITTED_BENEFIT,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean undoDeletedFlexBenefit() {
		boolean isDeletedBenefitUndo = false;
		for (FlexBenefit benefitList : flexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				isDeletedBenefitUndo = undoDeletedBenefit(benefit);
			}
			if (!isDeletedBenefitUndo) {
				break;
			}
		}
		return isDeletedBenefitUndo;
	}

	private boolean undoDeletedBenefit(Benefit benefit) {
		if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()) {
			int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _textSubmittedBenefitNameList,
					benefit.getBenefitDisplayName());
			return verifyAndClickUndoButton(benefit, indexBenefit);
		} else if (!benefit.getDeleteBenefitOnMBBPage()) {
			return true;
		}
		return false;
	}

	private boolean verifyAndClickUndoButton(Benefit benefit, int indexBenefit) {
		if (CoreFunctions.getElementText(driver, _buttonDeleteSubmittedBenefitList.get(indexBenefit))
				.equals(MobilityXConstants.UNDO)) {
			BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonDeleteSubmittedBenefitList, indexBenefit);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_CLICKED_UNDO_BUTTON_FOR_DELETED_BENEFIT_ON_MBB_PAGE,
					CoreConstants.PASS, benefit.getBenefitDisplayName()));
			undoDeletedBenefitFlag = true;
			CoreFunctions.writeToPropertiesFile("CF_Transferee_BenefitUndoFlag", "true");
			return true;

		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.FAILED_TO_DISPLAY_UNDO_BUTTON_FOR_DELETED_BENEFIT_IN_SUBMITTED_BENEFITS_SECTION,
					CoreConstants.FAIL, benefit.getBenefitDisplayName()));
			return false;
		}
	}

	private boolean deleteSubmittedFlexBenefit() {
		boolean isSubmittedBenefitDeleted = false;
		for (FlexBenefit benefitList : flexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				isSubmittedBenefitDeleted = deleteBenefit(benefit);
			}
			if (!isSubmittedBenefitDeleted) {
				break;
			}
		}
		return isSubmittedBenefitDeleted;
	}

	private boolean deleteBenefit(Benefit benefit) {
		if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()) {
			int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _textSubmittedBenefitNameList,
					benefit.getBenefitDisplayName());
			BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonDeleteSubmittedBenefitList, indexBenefit);
			if (CoreFunctions.isElementExist(driver, _removeBenefitDialog, 5)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_CLICKED_DELETE_BUTTON_IN_SUBMITTED_BENEFITS_SECTION,
						CoreConstants.PASS, benefit.getBenefitDisplayName()));
				return true;
			}
		} else if (!benefit.getDeleteBenefitOnMBBPage())
			return true;

		return false;
	}

	public boolean verifyBenefitsDetailsOnRemoveBenefitDialog() {
		boolean isPointsBenefitsDetailsValid = false;
		try {
			isPointsBenefitsDetailsValid = validateRemoveBenefitInfoText()
					&& verifyFlexBenefitsDetailsOnRemoveBenefitDialog();
			if (isPointsBenefitsDetailsValid) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
						CoreConstants.PASS));
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isPointsBenefitsDetailsValid;
	}

	private boolean verifyFlexBenefitsDetailsOnRemoveBenefitDialog() {
		boolean isFlexBenefitDetailsVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getDeleteBenefitOnMBBPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textRemoveBenefitNameList, benefit.getBenefitDisplayName());
						isFlexBenefitDetailsVerified = verifySelectedBenefitDetailsOnConfirmationDialog(indexBenefit,
								benefit);
						if (!isFlexBenefitDetailsVerified) {
							break;
						} else {
							flag = true;
						}
					} else {
						isFlexBenefitDetailsVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETED_FLEX_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETED_FLEX_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsVerified;
	}

	private boolean validateRemoveBenefitInfoText() {
		return CoreFunctions.getElementText(driver, _removeBenefitDialogText)
				.equals(MobilityXConstants.REMOVE_BENEFIT_DIALOG_INFO_TEXT);
	}

	public void reviewAndConfirmRemoveBenefitSubmission(String optionalNotes, String transfereeName,
			String buttonName) {
		CoreFunctions.setElementText(driver, input_transfereeName, transfereeName);
		CoreFunctions.setElementText(driver, optionalComments, optionalNotes);
		CoreFunctions.waitHandler(3);
		CoreFunctions.click(driver, _buttonDeleteThisBenefits, buttonName);
	}

	public boolean verifyRemoveBenefitRequestSuccessMessage() {
		try {
			if ((CoreFunctions.isElementExist(driver, _deleteClientBenefitSentGrowlMessage, 5))
					&& ((CoreFunctions.getElementText(driver, _deleteClientBenefitSentGrowlMessage))
							.equalsIgnoreCase((MobilityXConstants.DELETE_BENEFIT_GROWL_MESSAGE).replace("TransFN",
									CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
											+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"))))) {
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_DISPLAYED_DELETE_REQUEST_SENT_GROWL_MESSAGE,
								CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETE_REQUEST_SENT_SUCCESS_GROWL_MESSAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyDeletedBenefitStatus() {
		boolean isStatusVerifed = false;
		try {
			isStatusVerifed = verifyFlexBenefitsDeleteStatus();
			if (isStatusVerifed) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_DELETE_REQUEST_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_ON_BB_PAGE,
						CoreConstants.PASS));
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETE_REQUEST_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_ON_BB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isStatusVerifed;
	}

	private boolean verifyFlexBenefitsDeleteStatus() {
		boolean isFlexBenefitDeleteStatus = false;
		boolean flag = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {				
				if (benefit.getDeleteBenefitOnMBBPage()) {
					flag = false;
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
					isFlexBenefitDeleteStatus = verifyDeleteBenefitStatus(indexBenefit, benefit);
					if (!isFlexBenefitDeleteStatus) {
						return false;
					} else {
						flag = true;
						benefitDeletedFlag = true;
					}
				} else {
					isFlexBenefitDeleteStatus = true;
				}

			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETED_FLEX_BENEFIT_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_BB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDeleteStatus & flag) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_DELETED_FLEX_BENEFIT_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_BB_PAGE,
					CoreConstants.PASS));
			CoreFunctions.writeToPropertiesFile("CF_Transferee_BenefitDeletedFlag", "true");
		}
		return isFlexBenefitDeleteStatus;
	}

	private boolean verifyDeleteBenefitStatus(int indexBenefit, Benefit benefit) {

		return (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedAllowanceAmountList, indexBenefit, true)
						.equals(benefit.getBenefitAmount()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit, true)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& ((Double.parseDouble((CoreFunctions
						.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexBenefit, true)
						.replace("pts", "").trim()))) == (Double.parseDouble(benefit.getPoints())
								* (Integer.parseInt(CoreFunctions.getItemsFromListByIndex(driver,
										_textSubmittedBenefitQuantityList, indexBenefit, true)))))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitDate, indexBenefit, true)
						.equals(CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy")))
				&& CoreFunctions.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList, indexBenefit, true)
						.equals(MobilityXConstants.UNDO)
				&& CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexBenefit, true)
						.equals(MobilityXConstants.DELETE_REQUEST_PENDING);
	}

	public boolean verifySelectedCashoutDetails() {
		try {
			switch ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType"))) {
			case MobilityXConstants.PORTION_CASHOUT:
			case MobilityXConstants.AFTER_RELOCATION_ONLY:
				return verifySelectedCashout();
			case MobilityXConstants.CASHOUT_NOT_AUTHORIZED:
				return true;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_PORTION_CASHOUT_DETAILS_UNDER_BENEFITS_BUNDLE_SECTION_OF_BB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifySelectedCashout() {
		boolean isSelectedPortionCashoutDetailsVerified = false;
		for (WebElement element : _textAddedBenefitNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver, _textAddedBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				isSelectedPortionCashoutDetailsVerified = verifyBenefitsBundleCashoutDetails(indexCashout,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				break;
			}
		}
		if (isSelectedPortionCashoutDetailsVerified) {
			CoreFunctions.writeToPropertiesFile("CF_Transferee_SelectedCashOutPoints",
					CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints"));
			
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SELECTED_PORTION_CASHOUT_DETAILS_UNDER_MY_BENEFIT_BUNDLES_SECTION_OF_MBB_PAGE,
					CoreConstants.PASS));
		}
		return isSelectedPortionCashoutDetailsVerified;
	}

	private boolean verifyBenefitsBundleCashoutDetails(int indexCashout, String customCashoutBenefitName) {
		try {
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textAddedBenefitNameList, indexCashout, true),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyValue(
					(Double.parseDouble(
							(CoreFunctions.getItemsFromListByIndex(driver, _benefitsPointsList, indexCashout, true)
									.replace("pts", "").trim()))),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints")),
					MobilityXConstants.CASHOUT_POINTS);
			CoreFunctions.verifyValue(Double.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value")),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints")),
					MobilityXConstants.CASHOUT_INPUT_FIELD);
			String[] cashOutInputText = CoreFunctions.getElementText(driver, _textInputCashoutPoints).split("\\(");
			CoreFunctions.verifyValue(Double.parseDouble(cashOutInputText[0].trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints")),
					MobilityXConstants.CASHOUT_INPUT_FIELD_LABEL_VALUE);
			return CoreFunctions.isElementExist(driver, _buttonCashoutUpdate, 2);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_PORTION_CASHOUT_DETAILS_UNDER_BENEFITS_BUNDLE_SECTION_OF_BB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean iterateSubmittedBenefitListAndVerifyCashout() {
		for (WebElement element : _textSubmittedBenefitNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_textSubmittedBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				return (((CoreFunctions
						.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexCashout, true)
						.equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)))
						&& ((Double.parseDouble((CoreFunctions
								.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexCashout, true)
								.replace("pts", "").trim()))) == Double.parseDouble(
										CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints")))
						&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitDate, indexCashout, true)
								.equals(CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy")))
						&& CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexCashout, true)
								.equals(MobilityXConstants.VIEW_PAYMENTS)
						&& (CoreFunctions
								.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList, indexCashout, true)
								.equals(MobilityXConstants.DELETE)));
			}
		}
		return false;
	}

	public boolean deleteSubmittedBenefitAndCashout(String buttonName) {
		try {
			return deleteSubmittedBenefitDetails(buttonName) && deleteSubmittedCashoutDetails(buttonName);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_DELETING_SUBMITTED_BENEFIT_AND_CASHOUT_OF_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean deleteSubmittedBenefit(String buttonName) {
		try {
			return deleteSubmittedBenefitDetails(buttonName);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_DELETING_SUBMITTED_BENEFIT_OF_BB_PAGE, CoreConstants.FAIL,
					e.getMessage()));
		}
		return false;
	}

	private boolean deleteSubmittedBenefitDetails(String buttonName) {
		boolean isSubmittedBenefitDeleted = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
				if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
					BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonDeleteSubmittedBenefitList,
							indexBenefit);
					CoreFunctions.explicitWaitTillElementVisibility(driver, _removeBenefitDialog,
							MobilityXConstants.REMOVE_BENEFIT_DIALOG);
					int indexDeleteBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textRemoveBenefitNameList, benefit.getBenefitDisplayName());
					CoreFunctions.verifyText(
							CoreFunctions.getItemsFromListByIndex(driver, _textRemoveBenefitNameList,
									indexDeleteBenefit, false),
							benefit.getBenefitDisplayName(), MobilityXConstants.BENEFIT_NAME);
					CoreFunctions.verifyText(
							CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogAmountAllowanceMessage,
									indexDeleteBenefit, false),
							benefit.getBenefitAmount(), MobilityXConstants.BENEFIT_ALLOWANCE_AMOUNT);
					CoreFunctions.verifyText(
							CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogBenefitSelectionQuantity,
									indexDeleteBenefit, false),
							(String.valueOf(benefit.getNumberOfBenefitSelected())),
							MobilityXConstants.BENEFIT_QUANTITY);
					CoreFunctions.verifyValue(
							Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver,
									_confirmationDialogBenefitPoint, indexDeleteBenefit, false)),
							((Double.parseDouble(benefit.getPoints()))
									* (Integer.parseInt(CoreFunctions.getItemsFromListByIndex(driver,
											_confirmationDialogBenefitSelectionQuantity, indexDeleteBenefit, false)))),
							MobilityXConstants.BENEFIT_POINTS);
					reviewAndConfirmRemoveBenefitSubmission(MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
							CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
									+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
							buttonName);
					isSubmittedBenefitDeleted = verifyRemoveBenefitRequestSuccessMessage();
					CoreFunctions.explicitWaitTillElementInVisibility(driver, _deleteClientBenefitSentGrowlMessage);
				} else if (!benefit.getDeleteBenefitOnMBBPage())
					isSubmittedBenefitDeleted = true;
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_DELETING_SUBMITTED_BENEFIT_OF_BB_PAGE, CoreConstants.FAIL,
					e.getMessage()));
		}
		if (isSubmittedBenefitDeleted) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_DELETED_SUBMITTED_BENEFIT_FROM_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedBenefitDeleted;
	}

	public boolean deleteSubmittedCashoutDetails(String buttonName) {
		boolean isSubmittedCashoutDeleted = false;
		try {
			int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver, _textSubmittedBenefitNameList,
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonDeleteSubmittedBenefitList, indexCashout);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _removeBenefitDialog,
					MobilityXConstants.REMOVE_BENEFIT_DIALOG);
			int indexDeleteBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
					_textRemoveBenefitNameList, policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textRemoveBenefitNameList, indexDeleteBenefit,
							false),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName, MobilityXConstants.CASHOUT_NAME);
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogBenefitPoint,
							indexDeleteBenefit, false)),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints")),
					MobilityXConstants.BENEFIT_POINTS);
			reviewAndConfirmRemoveBenefitSubmission(MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
					CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
					buttonName);
			isSubmittedCashoutDeleted = verifyRemoveBenefitRequestSuccessMessage();
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _deleteClientBenefitSentGrowlMessage);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_DELETING_SUBMITTED_CASHOUT_ON_BB_PAGE, CoreConstants.FAIL,
					e.getMessage()));
		}
		if (isSubmittedCashoutDeleted) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_DELETED_SUBMITTED_CASHOUT_FROM_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedCashoutDeleted;
	}

	public boolean verifyDeletedBenefitCashoutStatus() {
		boolean isStatusVerifed = false;
		try {
			isStatusVerifed = verifyFlexBenefitsDeleteStatus() && verifyCashoutDeleteStatus();
			if (isStatusVerifed) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_DELETE_REQUEST_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_ON_MBB_PAGE,
						CoreConstants.PASS));
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETE_REQUEST_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_ON_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isStatusVerifed;
	}

	public boolean verifyCashoutDeleteStatus() {
		boolean isCashoutDeletedStatusVerified = false;
		try {
			int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver, _textSubmittedBenefitNameList,
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
			isCashoutDeletedStatusVerified = (((CoreFunctions
					.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexCashout, true)
					.equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)))
					&& ((Double.parseDouble((CoreFunctions
							.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexCashout, true)
							.replace("pts", "").trim()))) == (Double.parseDouble(
									CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints"))))
					&& CoreFunctions
							.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList, indexCashout, true)
							.equals(MobilityXConstants.UNDO)
					&& CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexCashout, true)
							.equals(MobilityXConstants.DELETE_REQUEST_PENDING));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETED_CASHOUT_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_BB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCashoutDeletedStatusVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_DELETED_CASHOUT_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_BB_PAGE,
					CoreConstants.PASS));
		}
		return isCashoutDeletedStatusVerified;
	}

	public boolean validateSubmittedBenefitDetailsPostDeleteRequestOperation(String actionPerformed) {
		boolean isBenefitsAndPointsMatched = false, isSubmittedBenefitDetailsVerified = false;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
					&& verifySubmittedDetailsPostDeleteRequestOperationOnMBBPage(actionPerformed);
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0, true))) == (Double
									.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints"))))
					&& (Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							1, true))) == Double.parseDouble(
									(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")));
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_ON_BENEFITS_BUNDLE_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatched)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));

		return isBenefitsAndPointsMatched;
	}

	public boolean verifySubmittedDetailsPostDeleteRequestOperationOnMBBPage(String actionPerformed) {
		boolean isSubmittedDetailsVerifiedOnMBBVerified = false;
		try {
			switch (actionPerformed) {
			case COREFLEXConstants.APPROVED:
				isSubmittedDetailsVerifiedOnMBBVerified = verifySubmittedBenefitDetailsPostApprovedDeleteRequest()
						&& verifySubmittedCashoutDetailsPostApprovedDeleteRequest();
				break;
			case COREFLEXConstants.DENIED:
				isSubmittedDetailsVerifiedOnMBBVerified = verifySubmittedBenefitDetailsPostDeniedDeleteRequest()
						&& verifySubmittedCashoutDetailsPostDeniedDeleteRequest();
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedDetailsVerifiedOnMBBVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedDetailsVerifiedOnMBBVerified;
	}

	private boolean verifySubmittedCashoutDetailsPostApprovedDeleteRequest() {

		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				return iterateAndVerifyCashoutNotPresent();
			} else if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED))) {
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CASHOUT_DETAILS_POST_APPROVED_DELETE_REQUEST_ON_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		Reporter.addStepLog(MessageFormat.format(
				COREFLEXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_NOT_DISPLAYED_UNDER_SUBMITTED_BENEFITS_POST_APPROVED_DELETE_REQUEST_ON_MBB_PAGE,
				CoreConstants.PASS));
		return true;
	}

	private boolean iterateAndVerifyCashoutNotPresent() {
		for (WebElement element : _textSubmittedBenefitNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				return false;
			}
		}
		return true;
	}

	private boolean verifySubmittedBenefitDetailsPostDeniedDeleteRequest() {
		boolean isSubmittedFlexBenefitDetailsOnMBBVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
					isSubmittedFlexBenefitDetailsOnMBBVerified = verifySubmittedBenefitDetailsOnBB(indexBenefit,
							benefit) && verifyDeniedBenefitRequestDeleteButtonDisabled(indexBenefit, benefit);
					if (!isSubmittedFlexBenefitDetailsOnMBBVerified) {
						return false;
					} else {
						flag = true;
					}
				} else {
					isSubmittedFlexBenefitDetailsOnMBBVerified = true;
				}

			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE_POST_DELETE_REQUEST_APPROVAL,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedFlexBenefitDetailsOnMBBVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE_POST_DELETE_REQUEST_APPROVAL,
					CoreConstants.PASS));
		}
		return isSubmittedFlexBenefitDetailsOnMBBVerified;
	}

	private boolean verifyDeniedBenefitRequestDeleteButtonDisabled(int indexBenefit, Benefit benefit) {
		boolean isDeleteButtonDisabled = false;
		boolean isDeleteHoverTextVerified = false;
		if (benefit.getDeleteBenefitOnMBBPage()) {
			isDeleteButtonDisabled = Boolean.valueOf(
					CoreFunctions.getAttributeText(_buttonDeleteBenefitList.get(indexBenefit), "aria-disabled"));
			CoreFunctions.moveToElement(driver, _buttonDeleteBenefitList.get(indexBenefit));
			isDeleteHoverTextVerified = CoreFunctions.isElementExist(driver,
					_disabledDeleteButtonHoverText.get(indexBenefit), 5);
			CoreFunctions.highlightObject(driver, _disabledDeleteButtonHoverText.get(indexBenefit));
			if (isDeleteButtonDisabled && isDeleteHoverTextVerified) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETE_BUTTON_IS_DISABLED_AND_DISABLED_DELETE_HOVER_TEXT_POST_DELETE_REQUEST_DENIED_BY_MSPEC_PPC_USER,
						CoreConstants.PASS));
				CoreFunctions.moveToElement(driver, _textSubmittedBenefitNameList.get(indexBenefit));
				return true;
			} else
				return false;
		}
		return true;
	}

	private boolean verifySubmittedBenefitDetailsPostApprovedDeleteRequest() {
		boolean isDeletedBenefitNotInSubmittedList = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
				if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()) {
					int index = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
					if (index == -1) {
						isDeletedBenefitNotInSubmittedList = true;
						continue;
					} else {
						isDeletedBenefitNotInSubmittedList = false;
						break;
					}
				}

			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_BENEFIT_REQUEST_REMOVED_ON_BB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isDeletedBenefitNotInSubmittedList) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETED_FLEX_BENEFIT_NOT_PRESENT_IN_SUBMITTED_BENEFITS_LIST_ON_BENEFITS_BUNDLE_PAGE_POST_DELETE_REQUEST_APPROVAL,
					CoreConstants.PASS));
		}
		return isDeletedBenefitNotInSubmittedList;
	}

	public boolean verifyUndoSuccessMessage() {
		if (CoreFunctions.isElementExist(driver, _undoBenefitSuccessGrowlMessage, 5)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_DISPLAYED_UNDO_SUCCESS_GROWL_MESSAGE_ON_MBB_PAGE,
					CoreConstants.PASS));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.UNDO_SUCCESS_GROWL_MESSAGE_NOT_DISPLAYED_AFTER_UNDO_OPERATION_ON_MBB_PAGE,
					CoreConstants.FAIL));
			return false;
		}
	}

	public boolean verifySubmittedBenefitStatus() {
		boolean isStatusVerifed = false;
		try {
			isStatusVerifed = verifyFlexBenefitsDeleteStatus();
			if (isStatusVerifed) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_DELETE_REQUEST_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_ON_MBB_PAGE,
						CoreConstants.PASS));
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETE_REQUEST_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_ON_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isStatusVerifed;
	}

	public boolean verifyAiresManagedBenefitDetailsOnSubmissionDialog() {
		boolean isPointsBenefitsDetailsValid = false;
		try {
			isPointsBenefitsDetailsValid = validateSubmissionInfoText()
					&& verifyFlexAiresManagedBenefitsDetailsOnSubmissionConfirmationDialog();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPointsBenefitsDetailsValid) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.PASS));
		}
		return isPointsBenefitsDetailsValid;
	}

	public boolean verifyFlexAiresManagedBenefitsDetailsOnSubmissionConfirmationDialog() {
		boolean isAiresManagedBenefitDetailsVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						isAiresManagedBenefitDetailsVerified = verifySelectedBenefitDetailsOnConfirmationDialog(
								indexBenefit, benefit);
						if (!isAiresManagedBenefitDetailsVerified) {
							return false;
						} else {
							flag = true;
						}
					} else {
						isAiresManagedBenefitDetailsVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_AIRES_MANAGED_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isAiresManagedBenefitDetailsVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_AIRES_MANAGED_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.PASS));
		}
		return isAiresManagedBenefitDetailsVerified;
	}

	public boolean validateSubmittedAiresManagedBenefitDetails(String expectedStatus) {
		boolean isBenefitsAndPointsMatched = false, isSubmittedBenefitDetailsVerified = false;
		hoverIndex = 0;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
					&& verifySubmittedCashoutDetailsOnBBPage()
					&& verifySubmittedAiresManagedBenefitsDetailsOnMBBPage(expectedStatus);
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0, true))) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints)
					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true))
							.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_AIRES_MANAGED_BENEFITS_ON_MY_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatched)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_AIRES_MANAGED_BENEFIT_ON_MY_BUNDLE_PAGE,
					CoreConstants.PASS));

		return isBenefitsAndPointsMatched;
	}

	private boolean verifySubmittedAiresManagedBenefitsDetailsOnMBBPage(String expectedStatus) {
		boolean isSubmittedAiresManagedBenefitDetailsOnMBBVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))
							&& (benefit.getMultipleBenefitSubmission())) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
						isSubmittedAiresManagedBenefitDetailsOnMBBVerified = verifySubmittedAiresManagedBenefitDetailsOnMBB(
								indexBenefit, benefit, expectedStatus)
								&& verifyBenefitDeleteButtonDisabled(indexBenefit, benefit, expectedStatus);
						if (!isSubmittedAiresManagedBenefitDetailsOnMBBVerified) {
							return false;
						} else {
							flag = true;
						}
					} else {
						isSubmittedAiresManagedBenefitDetailsOnMBBVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_AIRES_MANAGED_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedAiresManagedBenefitDetailsOnMBBVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_AIRES_MANAGED_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedAiresManagedBenefitDetailsOnMBBVerified;
	}

	private boolean verifySubmittedAiresManagedBenefitDetailsOnMBB(int indexBenefit, Benefit benefit,
			String expectedStatus) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedAllowanceAmountList, indexBenefit, true)
						.equals(benefit.getBenefitAmount()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit, true)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitDate, indexBenefit, true)
						.equals(CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy")))
				&& ((Double.parseDouble((CoreFunctions
						.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexBenefit, true)
						.replace("pts", "").trim()))) == ((Double.parseDouble(benefit.getPoints()))
								* (Integer.parseInt(CoreFunctions.getItemsFromListByIndex(driver,
										_textSubmittedBenefitQuantityList, indexBenefit, true)))))
				&& CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexBenefit, true)
						.equals(expectedStatus)
				&& ((expectedStatus.equalsIgnoreCase(MobilityXConstants.COMPLETE)
						|| expectedStatus.equalsIgnoreCase(MobilityXConstants.CANCELLED))
								? (Boolean.valueOf(CoreFunctions
										.getAttributeText(_buttonDeleteBenefitList.get(indexBenefit), "aria-disabled")))
								: CoreFunctions.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList,
										indexBenefit, true).equals(MobilityXConstants.DELETE));
	}

	private boolean verifyBenefitDeleteButtonDisabled(int indexBenefit, Benefit benefit, String expectedStatus) {
		switch (expectedStatus) {
		case MobilityXConstants.COMPLETE:
			return verifyCompetedBenefitDeleteButtonStatus(indexBenefit);
		case MobilityXConstants.CANCELLED:
			return verifyCanceledBenefitDeleteButtonStatus(indexBenefit);
		default:
			return true;
		}
	}

	private boolean verifyCanceledBenefitDeleteButtonStatus(int indexBenefit) {
		boolean isDeleteButtonDisabled = false;
		boolean isDeleteHoverTextVerified = false;
		try {
			isDeleteButtonDisabled = Boolean.valueOf(
					CoreFunctions.getAttributeText(_buttonDeleteBenefitList.get(indexBenefit), "aria-disabled"));
			CoreFunctions.moveToElement(driver, _buttonDeleteBenefitList.get(indexBenefit));
			isDeleteHoverTextVerified = CoreFunctions.isElementExist(driver,
					_canceledBenefitDisabledDeleteButtonHoverText.get(hoverIndex), 5);
			CoreFunctions.highlightObject(driver, _canceledBenefitDisabledDeleteButtonHoverText.get(hoverIndex));
			if (isDeleteButtonDisabled && isDeleteHoverTextVerified) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETE_BUTTON_IS_DISABLED_AND_DISABLED_DELETE_HOVER_TEXT_POST_BENEFIT_STATUS_CANCELED,
						CoreConstants.PASS));
				CoreFunctions.moveToElement(driver, _textSubmittedBenefitNameList.get(indexBenefit));
				hoverIndex++;
				return true;
			} else
				return false;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CANCELED_BENEFIT_DELETE_BUTTON_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyCompetedBenefitDeleteButtonStatus(int indexBenefit) {
		boolean isDeleteButtonDisabled = false;
		boolean isDeleteHoverTextVerified = false;
		try {
			isDeleteButtonDisabled = Boolean.valueOf(
					CoreFunctions.getAttributeText(_buttonDeleteBenefitList.get(indexBenefit), "aria-disabled"));
			CoreFunctions.scrollToElementUsingJS(driver, _buttonDeleteBenefitList.get(indexBenefit),
					COREFLEXConstants.DELETE_BUTTON);
			CoreFunctions.moveToElement(driver, _buttonDeleteBenefitList.get(indexBenefit));
			isDeleteHoverTextVerified = CoreFunctions.isElementExist(driver,
					_completedBenefitDisabledDeleteButtonHoverText.get(hoverIndex), 5);
			CoreFunctions.highlightObject(driver, _completedBenefitDisabledDeleteButtonHoverText.get(hoverIndex));
			if (isDeleteButtonDisabled && isDeleteHoverTextVerified) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETE_BUTTON_IS_DISABLED_AND_DISABLED_DELETE_HOVER_TEXT_POST_BENEFIT_STATUS_COMPLETE,
						CoreConstants.PASS));
				CoreFunctions.moveToElement(driver, _textSubmittedBenefitNameList.get(indexBenefit));
				hoverIndex++;
				return true;
			} else
				return false;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_COMPLETED_BENEFIT_DELETE_BUTTON_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean validateSubmittedPolicyAiresManagedBenefitDetails(String expectedStatus) {
		boolean isSubmittedPolicyBenefitDetailsVerified = false, isSubmittedBenefitDisplayed = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))) {
						isSubmittedPolicyBenefitDetailsVerified = verifySubmittedPolicyBenefitDetails(benefit,
								expectedStatus);
						if (isSubmittedPolicyBenefitDetailsVerified) {
							isSubmittedBenefitDisplayed = true;
						}
					}

				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_AIRES_MANAGED_BENEFITS_ON_MY_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedPolicyBenefitDetailsVerified && isSubmittedBenefitDisplayed)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_AIRES_MANAGED_BENEFIT_ON_MY_BUNDLE_PAGE,
					CoreConstants.PASS));

		return isSubmittedPolicyBenefitDetailsVerified;
	}

	private boolean verifySubmittedPolicyBenefitDetails(Benefit benefit, String expectedStatus) {
		boolean isSubmittedPolicyBenefitDetailsVerified = false;
		int multipleSubmissionBenefitCount = (int) _textSubmittedBenefitNameList.stream()
				.filter(x -> x.getText().equals(benefit.getBenefitDisplayName())).count();
		if (multipleSubmissionBenefitCount > 1) {
			isSubmittedPolicyBenefitDetailsVerified = verifySubmittedBenefits(benefit, multipleSubmissionBenefitCount,
					expectedStatus);
		}
		return isSubmittedPolicyBenefitDetailsVerified;

	}

	private boolean verifySubmittedBenefits(Benefit benefit, int multipleSubmissionBenefitCount,
			String expectedStatus) {
		int counter = 0;
		boolean isSubmittedPolicyBenefitDetailsVerified = false;
		try {
			Map<String, String> submittedPolicyDetails = CoreFunctions
					.convertStringToMapWithStream(CoreFunctions.getPropertyFromConfig("CoreFlexSubmittedPolicyData"));
			List<Integer> multipleSubmittedBenefitIndex = getMultipleSubmittedBenefitIndexes(benefit);
			while (counter < multipleSubmissionBenefitCount) {
				if (submittedPolicyDetails.get(" BenefitSubmittedDate").equals(CoreFunctions.getElementText(driver,
						_textSubmittedBenefitDate.get(multipleSubmittedBenefitIndex.get(counter))))) {
					isSubmittedPolicyBenefitDetailsVerified = verifySubmittedPolicyAiresManagedBenefitDetailsOnMBB(
							multipleSubmittedBenefitIndex.get(counter), benefit, expectedStatus)
							&& verifyBenefitDeleteButtonDisabled(multipleSubmittedBenefitIndex.get(counter), benefit,
									expectedStatus);
					if (!isSubmittedPolicyBenefitDetailsVerified) {
						return false;
					}
				}
				counter++;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_MULTIPLE_SUBMISSION_FLEX_BENEFIT_CARD_DETAILS,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		return isSubmittedPolicyBenefitDetailsVerified;

	}

	private boolean verifySubmittedPolicyAiresManagedBenefitDetailsOnMBB(Integer indexBenefit, Benefit benefit,
			String expectedStatus) {
		Map<String, String> submittedPolicyDetails = CoreFunctions
				.convertStringToMapWithStream(CoreFunctions.getPropertyFromConfig("CoreFlexSubmittedPolicyData"));
		return (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedAllowanceAmountList, indexBenefit, true)
						.equals(benefit.getBenefitAmount()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit, true)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitDate, indexBenefit, true)
						.equals(submittedPolicyDetails.get(" BenefitSubmittedDate")))
				&& ((Double.parseDouble((CoreFunctions
						.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexBenefit, true)
						.replace("pts", "").trim()))) == ((Double.parseDouble(benefit.getPoints()))
								* (Integer.parseInt(CoreFunctions.getItemsFromListByIndex(driver,
										_textSubmittedBenefitQuantityList, indexBenefit, true)))))
				&& CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexBenefit, true)
						.equals(expectedStatus)
				&& ((expectedStatus.equalsIgnoreCase(MobilityXConstants.COMPLETE)
						|| expectedStatus.equalsIgnoreCase(MobilityXConstants.CANCELLED))
								? (Boolean.valueOf(CoreFunctions
										.getAttributeText(_buttonDeleteBenefitList.get(indexBenefit), "aria-disabled")))
								: CoreFunctions.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList,
										indexBenefit, true).equals(MobilityXConstants.DELETE));
	}

	private List<Integer> getMultipleSubmittedBenefitIndexes(Benefit benefit) {
		List<Integer> flexCardIndexes = new ArrayList<Integer>();
		for (WebElement element : _textSubmittedBenefitNameList) {
			if (element.getText().equals(benefit.getBenefitDisplayName())) {
				flexCardIndexes.add(_textSubmittedBenefitNameList.indexOf(element));
			}
		}
		return flexCardIndexes;
	}

	public boolean verifySelectedAiresManagedBenefitDetails(int noOfTracingPrompts) {
		boolean isBenefitsAndPointsMatached = false;
		try {
			isBenefitsAndPointsMatached = verifyAiresManagedFlexBenefitsDetailsOnMBBPage(noOfTracingPrompts)
					&& (Double.parseDouble(CoreFunctions.getElementText(driver,
							_selectedPoints)) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints)
					&& ((CoreFunctions.getElementText(driver, _totalPoints))
							.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_REVIEWING_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatached)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_REVIEWED_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.PASS));
		return isBenefitsAndPointsMatached;
	}

	public boolean verifyAiresManagedFlexBenefitsDetailsOnMBBPage(int noOfMilestones) {
		boolean isFlexBenefitDetailsOnMMBVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (Objects.equals(benefit.getAiresManagedService(), "Yes") && benefit.getSelectBenefitOnFPTPage()
							&& benefit.getNoOfMilestones() != null
							&& Objects.equals(benefit.getNoOfMilestones(), noOfMilestones)) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						isFlexBenefitDetailsOnMMBVerified = verifyBenefitsBundleDetails(indexBenefit, benefit);
						if (!isFlexBenefitDetailsOnMMBVerified) {
							return false;
						} else {
							flag = true;
						}
					} else {
						isFlexBenefitDetailsOnMMBVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsOnMMBVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsOnMMBVerified;
	}

	public boolean verifyAiresManagedBenefitsDetailsOnSubmissionDialog(int noOfTracingPrompts) {
		boolean isPointsBenefitsDetailsValid = false;
		try {
			isPointsBenefitsDetailsValid = validateSubmissionInfoText()
					&& verifyFlexBenefitsDetailsOnSubmissionConfirmationDialog(noOfTracingPrompts)
					&& verifyCashoutDetailsOnSubmissionConfirmationDialog();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPointsBenefitsDetailsValid) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.PASS));
		}
		return isPointsBenefitsDetailsValid;
	}

	public boolean verifyFlexBenefitsDetailsOnSubmissionConfirmationDialog(int noOfMilestones) {
		boolean isFlexBenefitDetailsOnFTPVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (Objects.equals(benefit.getAiresManagedService(), "Yes") && benefit.getSelectBenefitOnFPTPage()
							&& benefit.getNoOfMilestones() != null
							&& Objects.equals(benefit.getNoOfMilestones(), noOfMilestones)) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						isFlexBenefitDetailsOnFTPVerified = verifySelectedBenefitDetailsOnConfirmationDialog(
								indexBenefit, benefit);
						if (!isFlexBenefitDetailsOnFTPVerified) {
							return false;
						} else {
							flag = true;
						}
					} else {
						isFlexBenefitDetailsOnFTPVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsOnFTPVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsOnFTPVerified;
	}

	public boolean validateSubmittedAiresManagedBenefitDetails(String expectedStatus, int noOfMilestones) {
		boolean isBenefitsAndPointsMatched = false, isSubmittedBenefitDetailsVerified = false;
		hoverIndex = 0;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
//					&& verifySubmittedCashoutDetailsOnMBBPage()
					&& verifySubmittedAiresManagedBenefitsDetailsOnMBBPage(expectedStatus, noOfMilestones);
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified;
//					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
//							0, true))) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints)
//					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true))
//							.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_AIRES_MANAGED_BENEFITS_ON_MY_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatched)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_AIRES_MANAGED_BENEFIT_ON_MY_BUNDLE_PAGE,
					CoreConstants.PASS));

		return isBenefitsAndPointsMatched;
	}

	private boolean verifySubmittedAiresManagedBenefitsDetailsOnMBBPage(String expectedStatus, int noOfMilestones) {
		boolean isSubmittedAiresManagedBenefitDetailsOnMBBVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))
							&& benefit.getNoOfMilestones() != null
							&& Objects.equals(benefit.getNoOfMilestones(), noOfMilestones)) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
						isSubmittedAiresManagedBenefitDetailsOnMBBVerified = verifySubmittedAiresManagedBenefitDetailsOnMBB(
								indexBenefit, benefit, expectedStatus)
								&& verifyBenefitDeleteButtonDisabled(indexBenefit, benefit, expectedStatus);
						if (!isSubmittedAiresManagedBenefitDetailsOnMBBVerified) {
							return false;
						} else {
							flag = true;
						}
					} else {
						isSubmittedAiresManagedBenefitDetailsOnMBBVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_AIRES_MANAGED_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedAiresManagedBenefitDetailsOnMBBVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_AIRES_MANAGED_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedAiresManagedBenefitDetailsOnMBBVerified;
	}

	public boolean verifySelectedBenefitDetails(int noOfMilestones) {
		boolean isBenefitsAndPointsMatached = false;
		try {
			isBenefitsAndPointsMatached = verifyAiresManagedFlexBenefitsDetailsOnMBBPage(noOfMilestones)
					&& (Double.parseDouble(CoreFunctions.getElementText(driver,
							_selectedPoints)) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints)
					&& ((CoreFunctions.getElementText(driver, _totalPoints))
							.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_REVIEWING_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatached)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_REVIEWED_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.PASS));
		return isBenefitsAndPointsMatached;
	}

	public boolean verifySelectedMultipleSubmissionBenefitDetails() {
		boolean isBenefitsAndPointsMatached = false;
		try {
			isBenefitsAndPointsMatached = verifyMultipleSubmissionFlexBenefitsDetailsOnMBBPage()
					&& (Double.parseDouble(CoreFunctions.getElementText(driver,
							_selectedPoints)) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints)
					&& ((CoreFunctions.getElementText(driver, _totalPoints))
							.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_REVIEWING_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatached)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_REVIEWED_SELECTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.PASS));
		return isBenefitsAndPointsMatached;
	}

	public boolean verifyMultipleSubmissionFlexBenefitsDetailsOnMBBPage() {
		boolean isFlexBenefitDetailsOnMMBVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage() && benefit.getMultipleBenefitSubmission()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						isFlexBenefitDetailsOnMMBVerified = verifyBenefitsBundleDetails(indexBenefit, benefit);
						if (!isFlexBenefitDetailsOnMMBVerified) {
							return false;
						} else {
							flag = true;
						}
					} else {
						isFlexBenefitDetailsOnMMBVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsOnMMBVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsOnMMBVerified;
	}

	public boolean validateSubmittedAMMultipleSubmissionBenefitDetails(String expectedStatus) {
		boolean isBenefitsAndPointsMatched = false, isSubmittedBenefitDetailsVerified = false;
		hoverIndex = 0;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
					&& verifySubmittedCashoutDetailsOnBBPage()
					&& verifySubmittedAMMultipleBenefitsDetailsOnMBBPage(expectedStatus);
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0, true))) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints)
					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true))
							.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_AIRES_MANAGED_BENEFITS_ON_MY_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatched)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_AIRES_MANAGED_BENEFIT_ON_MY_BUNDLE_PAGE,
					CoreConstants.PASS));

		return isBenefitsAndPointsMatched;
	}

	private boolean verifySubmittedAMMultipleBenefitsDetailsOnMBBPage(String expectedStatus) {
		boolean isSubmittedAiresManagedBenefitDetailsOnMBBVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage() && benefit.getMultipleBenefitSubmission()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
						isSubmittedAiresManagedBenefitDetailsOnMBBVerified = verifySubmittedAiresManagedBenefitDetailsOnMBB(
								indexBenefit, benefit, expectedStatus)
								&& verifyBenefitDeleteButtonDisabled(indexBenefit, benefit, expectedStatus);
						if (!isSubmittedAiresManagedBenefitDetailsOnMBBVerified) {
							return false;
						} else {
							flag = true;
						}
					} else {
						isSubmittedAiresManagedBenefitDetailsOnMBBVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_AIRES_MANAGED_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedAiresManagedBenefitDetailsOnMBBVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_AIRES_MANAGED_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedAiresManagedBenefitDetailsOnMBBVerified;
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

	private boolean verifySubmittedCashoutDetailsPostDeniedDeleteRequest() {

		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				return iterateSubmittedBenefitListAndVerifyCashout();
			} else if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED))) {
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CASHOUT_DETAILS_POST_APPROVED_DELETE_REQUEST_ON_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		Reporter.addStepLog(MessageFormat.format(
				COREFLEXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_NOT_DISPLAYED_UNDER_SUBMITTED_BENEFITS_POST_APPROVED_DELETE_REQUEST_ON_MBB_PAGE,
				CoreConstants.PASS));
		return true;
	}
}
