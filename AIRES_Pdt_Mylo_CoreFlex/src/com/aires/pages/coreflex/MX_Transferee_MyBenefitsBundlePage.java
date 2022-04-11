package com.aires.pages.coreflex;

import java.text.DecimalFormat;
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
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class MX_Transferee_MyBenefitsBundlePage extends Base {

	public MX_Transferee_MyBenefitsBundlePage(WebDriver driver) {
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

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'SubmitBenefit')]//span[@class='RXCFSmallText RXMineShaft RXCFWordwrap']")
	private List<WebElement> _textSubmittedAllowanceAmountList;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'Benefit')]//span[@class='RXCFText RXBold RXAiresSeaglass']")
	private List<WebElement> _textSubmittedBenefitsPointsList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'SubmitBenefit')]//span[@class='RXBolder RXCFSmallText']")
	private List<WebElement> _textSubmittedBenefitQuantityList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'Benefit')]//a[contains(@class,'BorderButton')]/span")
	private List<WebElement> _buttonDeleteSubmittedBenefitList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'Benefit')]//a[contains(@class,'BorderButton')]")
	private List<WebElement> _buttonDeleteBenefitList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Unable to delete benefit. Please see comments for more information.')]")
	private WebElement _disabledDeleteButtonHoverText;

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

	@FindBy(how = How.XPATH, using = "//div[@class='growl-message'][contains(string(),'Your request has been sent. You will receive an email about the outcome of your request.')]")
	private WebElement _beleteBenefitSentGrowlMessage;

	@FindBy(how = How.XPATH, using = "//table[contains(@id,'stsrdiconpnl')]//span[contains(@id,'sbs')] | //table[contains(@id,'cotsrdiconpnl')]//span[contains(@id,'sbs')]")
	private List<WebElement> _benefitStatus;

	// Cashout Points Field Non Editable Text
	@FindBy(how = How.CSS, using = "td.AFContentCell > input")
	private WebElement _inputCashoutPoints;

	// Cashout Points Field Non Editable Text
	@FindBy(how = How.CSS, using = "span[class='RXAiresSeaglass RXBolder RXCFText']")
	private WebElement _textInputCashoutPoints;

	// Cashout Update Button
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'RXCFGreenSmallRoundedButton')]//span[text()='Update']")
	private WebElement _buttonCashoutUpdate;

	/*********************************************************************/

	public static double availablePointsAfterSubmission = 0;

	public static double submittedPoints = 0;

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	public static boolean benefitDeletedFlag;
	public static boolean undoDeletedBenefitFlag;

	/*********************************************************************/

	public boolean isMyBundlePageDisplayed() {
		if (CoreFunctions.isElementExist(driver, _textMyBenefitsBundleTitle, 5)) {
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
		Reporter.addStepLog(
				MessageFormat.format(MobilityXConstants.SUBMISSION_SUCCESS_POPUP_DISPLAYED, CoreConstants.PASS));
	}

	public void reviewAndConfirmBenefitSubmission(String optionalNotes, String transfereeName, String buttonName) {
		CoreFunctions.setElementText(driver, input_transfereeName, transfereeName);
		CoreFunctions.setElementText(driver, optionalComments, optionalNotes);
		CoreFunctions.waitHandler(2);
		CoreFunctions.click(driver, _btn_submitBundle, buttonName);
		MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission = Double
				.parseDouble(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable)
				- (MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints);
		MX_Transferee_MyBenefitsBundlePage.submittedPoints = MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints;
	}

	public boolean verifySelectedBenefitDetails() {
		boolean isBenefitsAndPointsMatached = false;
		try {
			isBenefitsAndPointsMatached = verifyFlexBenefitsDetailsOnMBBPage()
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

	public boolean verifyFlexBenefitsDetailsOnMBBPage() {
		boolean isFlexBenefitDetailsOnMMBVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						isFlexBenefitDetailsOnMMBVerified = verifyMyBenefitBundlesBenefitDetails(indexBenefit, benefit);
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

	private boolean verifyMyBenefitBundlesBenefitDetails(int indexBenefit, Benefit benefit) {
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
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
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
					&& verifySubmittedCashoutDetailsOnMBBPage() && verifySubmittedFlexBenefitsDetailsOnMBBPage();
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0, true))) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints)
					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true))
							.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_ON_MY_BUNDLE_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatched)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.PASS));

		return isBenefitsAndPointsMatched;
	}

	private boolean verifySubmittedCashoutDetailsOnMBBPage() {
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
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_CASHOUT_DETAILS_ON_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedPortionCashoutDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_PORTION_CASHOUT_DETAILS_ON_MBB_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedPortionCashoutDetailsVerified;
	}

	private boolean verifySubmittedBenefitsSectionHeader() {
		if (CoreFunctions.isElementExist(driver, _textSubmittedBenefitsTitle, 5)) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_DISPLAYED_SUBMITTED_BENEFIT_SECTION_IN_MY_BENEFIT_BUNDLE_PAGE,
					CoreConstants.PASS));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(
				MobilityXConstants.SUBMITTED_BENEFIT_SECTION_NOT_DISPLAYED_IN_MY_BENEFIT_BUNDLE_PAGE,
				CoreConstants.FAIL));
		return false;
	}

	private boolean verifySubmittedFlexBenefitsDetailsOnMBBPage() {
		boolean isSubmittedFlexBenefitDetailsOnMBBVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
						isSubmittedFlexBenefitDetailsOnMBBVerified = verifySubmittedBenefitDetailsOnMBB(indexBenefit,
								benefit);
						if (!isSubmittedFlexBenefitDetailsOnMBBVerified) {
							return false;
						} else {
							flag = true;
						}
					} else {
						isSubmittedFlexBenefitDetailsOnMBBVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedFlexBenefitDetailsOnMBBVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedFlexBenefitDetailsOnMBBVerified;
	}

	private boolean verifySubmittedBenefitDetailsOnMBB(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedAllowanceAmountList, indexBenefit, true)
						.equals(benefit.getBenefitAmount()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit, true)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& ((Double.parseDouble((CoreFunctions
						.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexBenefit, true)
						.replace("pts", "").trim()))) == ((Double.parseDouble(benefit.getPoints()))
								* (Integer.parseInt(CoreFunctions.getItemsFromListByIndex(driver,
										_textSubmittedBenefitQuantityList, indexBenefit, true))))
								&& CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexBenefit, true)
								.equals(MobilityXConstants.VIEW_PAYMENTS)
						&& CoreFunctions
								.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList, indexBenefit, true)
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
		CoreFunctions.click(driver, _buttonDeleteTheseBenefits, buttonName);
	}

	public boolean verifyRemoveBenefitRequestSuccessMessage() {
		try {
			if (CoreFunctions.isElementExist(driver, _beleteBenefitSentGrowlMessage, 5)) {
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

	private boolean verifyFlexBenefitsDeleteStatus() {
		boolean isFlexBenefitDeleteStatus = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					flag = false;
					if (benefit.getDeleteBenefitOnMBBPage()) {
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
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETED_FLEX_BENEFIT_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDeleteStatus & flag) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_DELETED_FLEX_BENEFIT_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_MBB_PAGE,
					CoreConstants.PASS));
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
				&& CoreFunctions.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList, indexBenefit, true)
						.equals(MobilityXConstants.UNDO)
				&& CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexBenefit, true)
						.equals(MobilityXConstants.DELETE_REQUEST_PENDING);
	}

	public boolean verifySelectedPortionCashoutDetails() {
		try {
			switch ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType"))) {
			case MobilityXConstants.PORTION_CASHOUT:
			case MobilityXConstants.AFTER_RELOCATION_ONLY:
				return verifySelectedPortionCashout();
			case MobilityXConstants.CASHOUT_NOT_AUTHORIZED:
				return true;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_PORTION_CASHOUT_DETAILS_UNDER_MY_BENEFIT_BUNDLE_SECTION_OF_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifySelectedPortionCashout() {
		boolean isSelectedPortionCashoutDetailsVerified = false;
		for (WebElement element : _textAddedBenefitNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver, _textAddedBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				isSelectedPortionCashoutDetailsVerified = verifyMyBenefitBundleCashoutDetails(indexCashout,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				break;
			}
		}
		if (isSelectedPortionCashoutDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SELECTED_PORTION_CASHOUT_DETAILS_UNDER_MY_BENEFIT_BUNDLES_SECTION_OF_MBB_PAGE,
					CoreConstants.PASS));
		}
		return isSelectedPortionCashoutDetailsVerified;
	}

	private boolean verifyMyBenefitBundleCashoutDetails(int indexCashout, String customCashoutBenefitName) {
		try {
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textAddedBenefitNameList, indexCashout, true),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyValue(
					(Double.parseDouble(
							(CoreFunctions.getItemsFromListByIndex(driver, _benefitsPointsList, indexCashout, true)
									.replace("pts", "").trim()))),
					MX_Transferee_FlexPlanningTool_Page.selectedCashoutPoints, MobilityXConstants.CASHOUT_POINTS);
			CoreFunctions.verifyValue(Double.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value")),
					MX_Transferee_FlexPlanningTool_Page.selectedCashoutPoints, MobilityXConstants.CASHOUT_INPUT_FIELD);
			String[] cashOutInputText = CoreFunctions.getElementText(driver, _textInputCashoutPoints).split("\\(");
			CoreFunctions.verifyValue(Double.parseDouble(cashOutInputText[0].trim()),
					MX_Transferee_FlexPlanningTool_Page.selectedCashoutPoints,
					MobilityXConstants.CASHOUT_INPUT_FIELD_LABEL_VALUE);
			return CoreFunctions.isElementExist(driver, _buttonCashoutUpdate, 2);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_PORTION_CASHOUT_DETAILS_UNDER_MY_BENEFIT_BUNDLE_SECTION_OF_MBB_PAGE,
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
								.replace("pts", "")
								.trim()))) == (MX_Transferee_FlexPlanningTool_Page.selectedCashoutPoints))
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

	private boolean deleteSubmittedBenefitDetails(String buttonName) {
		boolean isSubmittedBenefitDeleted = false, flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()) {
						flag = false;
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
								CoreFunctions.getItemsFromListByIndex(driver,
										_confirmationDialogBenefitSelectionQuantity, indexDeleteBenefit, false),
								(String.valueOf(benefit.getNumberOfBenefitSelected())),
								MobilityXConstants.BENEFIT_QUANTITY);
						CoreFunctions.verifyValue(
								Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver,
										_confirmationDialogBenefitPoint, indexDeleteBenefit, false)),
								((Double.parseDouble(benefit.getPoints()))
										* (Integer.parseInt(CoreFunctions.getItemsFromListByIndex(driver,
												_confirmationDialogBenefitSelectionQuantity, indexDeleteBenefit,
												false)))),
								MobilityXConstants.BENEFIT_POINTS);
						reviewAndConfirmRemoveBenefitSubmission(MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
								CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
										+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
								buttonName);
						isSubmittedBenefitDeleted = verifyRemoveBenefitRequestSuccessMessage();
						CoreFunctions.explicitWaitTillElementInVisibility(driver, _beleteBenefitSentGrowlMessage);
					} else if (!benefit.getDeleteBenefitOnMBBPage())
						isSubmittedBenefitDeleted = true;
				}
				if (!isSubmittedBenefitDeleted) {
					break;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_DELETING_SUBMITTED_BENEFIT_OF_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedBenefitDeleted & flag) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_DELETED_SUBMITTED_BENEFIT_FROM_MY_BENEFIT_BUNDLES_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedBenefitDeleted;
	}

	private boolean deleteSubmittedCashoutDetails(String buttonName) {
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
					(MX_Transferee_FlexPlanningTool_Page.selectedCashoutPoints), MobilityXConstants.BENEFIT_POINTS);
			reviewAndConfirmRemoveBenefitSubmission(MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
					CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
					buttonName);
			isSubmittedCashoutDeleted = verifyRemoveBenefitRequestSuccessMessage();
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _beleteBenefitSentGrowlMessage);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_DELETING_SUBMITTED_CASHOUT_OF_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedCashoutDeleted) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_DELETED_SUBMITTED_CASHOUT_FROM_MY_BENEFIT_BUNDLES_PAGE,
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

	private boolean verifyCashoutDeleteStatus() {
		boolean isCashoutDeletedStatusVerified = false;
		try {
			int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver, _textSubmittedBenefitNameList,
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
			isCashoutDeletedStatusVerified = (((CoreFunctions
					.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexCashout, true)
					.equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)))
					&& ((Double.parseDouble((CoreFunctions
							.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexCashout, true)
							.replace("pts", "")
							.trim()))) == (MX_Transferee_FlexPlanningTool_Page.selectedCashoutPoints))
					&& CoreFunctions
							.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList, indexCashout, true)
							.equals(MobilityXConstants.UNDO)
					&& CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexCashout, true)
							.equals(MobilityXConstants.DELETE_REQUEST_PENDING));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETED_CASHOUT_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCashoutDeletedStatusVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_DELETED_CASHOUT_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_MBB_PAGE,
					CoreConstants.PASS));
		}
		return isCashoutDeletedStatusVerified;
	}

	public boolean validateSubmittedBenefitDetailsPostDeleteRequestOperation(String actionPerformed) {
		boolean isBenefitsAndPointsMatched = false, isSubmittedBenefitDetailsVerified = false;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
					&& verifySubmittedCashoutDetailsOnMBBPage()
					&& verifySubmittedBenefitsDetailsPostDeleteRequestOperationOnMBBPage(actionPerformed);
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0, true))) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints)
					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true))
							.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_ON_MY_BUNDLE_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatched)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.PASS));

		return isBenefitsAndPointsMatched;
	}

	public boolean verifySubmittedBenefitsDetailsPostDeleteRequestOperationOnMBBPage(String actionPerformed) {
		boolean isSubmittedFlexBenefitDetailsOnMBBVerified = false;
		try {
			switch (actionPerformed) {
			case COREFLEXConstants.APPROVED:
				isSubmittedFlexBenefitDetailsOnMBBVerified = verifySubmittedBenefitDetailsPostApprovedDeleteRequest();
				break;
			case COREFLEXConstants.DENIED:
				isSubmittedFlexBenefitDetailsOnMBBVerified = verifySubmittedBenefitDetailsPostDeniedDeleteRequest();
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedFlexBenefitDetailsOnMBBVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedFlexBenefitDetailsOnMBBVerified;
	}

	private boolean verifySubmittedBenefitDetailsPostDeniedDeleteRequest() {
		boolean isSubmittedFlexBenefitDetailsOnMBBVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
						isSubmittedFlexBenefitDetailsOnMBBVerified = verifySubmittedBenefitDetailsOnMBB(indexBenefit,
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
			isDeleteHoverTextVerified = CoreFunctions.isElementExist(driver, _disabledDeleteButtonHoverText, 5);
			CoreFunctions.highlightObject(driver, _disabledDeleteButtonHoverText);
			if (isDeleteButtonDisabled && isDeleteHoverTextVerified) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETE_BUTTON_IS_DISABLED_AND_DISABLED_DELETE_HOVER_TEXT_POST_DELETE_REQUEST_DENIED_BY_MSPEC_PPC_USER,
						CoreConstants.PASS));
				return true;
			} else
				return false;
		}
		return true;
	}

	private boolean verifySubmittedBenefitDetailsPostApprovedDeleteRequest() {
		boolean isSubmittedFlexBenefitDetailsOnMBBVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
						if (indexBenefit == -1)
							continue;
						else if (verifyApprovedDeleteRequestBenefitOnMBB(indexBenefit, benefit))
							return false;

						isSubmittedFlexBenefitDetailsOnMBBVerified = verifySubmittedBenefitDetailsOnMBB(indexBenefit,
								benefit);
						if (!isSubmittedFlexBenefitDetailsOnMBBVerified) {
							return false;
						} else {
							flag = true;
						}
					} else {
						isSubmittedFlexBenefitDetailsOnMBBVerified = true;
					}
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

	private boolean verifyApprovedDeleteRequestBenefitOnMBB(int indexBenefit, Benefit benefit) {
		if (benefit.getDeleteBenefitOnMBBPage() && benefitDeletedFlag
				&& TransfereeSubmissions_DetailsPage.isDeleteRequestApproved
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexBenefit, true)
						.equals(benefit.getBenefitDisplayName()))) {
			return true;
		} else
			return false;
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

}
