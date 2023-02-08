package com.aires.pages.coreflex;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

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

	@FindBy(how = How.XPATH, using = "//span[@class='RXCFSmallText RXAiresSeaglass'] | //span[contains(@id,'subp')]")
	private List<WebElement> _confirmationDialogAmountAllowanceMessage;

	@FindBy(how = How.CSS, using = "span[class='RXCFHugestText RXWhite RXBold']")
	private List<WebElement> _confirmationDialogBenefitPoint;

	@FindBy(how = How.CSS, using = "span[class='RXText RXGraniteGrey RXBolder']")
	private List<WebElement> _confirmationDialogBenefitSelectionQuantity;

	@FindBy(how = How.CSS, using = "div[class*='RXCFBenefitNameDesc'] span[class*='RXBolder']")
	private List<WebElement> _textSubmittedBenefitNameList;

	@FindBy(how = How.CSS, using = "div[id*='Submit'] span[class='RXCFSmallText RXMineShaft RXCFWordwrap']")
	private List<WebElement> _textSubmittedAllowanceAmountList;

	@FindBy(how = How.CSS, using = "div[class*='Benefit'] span[class='RXCFText RXBold RXAiresSeaglass']")
	private List<WebElement> _textSubmittedBenefitsPointsList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'SubmitBenefit')]//span[@class='RXBolder RXCFSmallText'] | //div[contains(@id,'innerDivCashoutSubmitCashoutBenefit')]//span[contains(text(),'Cashout')]")
	private List<WebElement> _textSubmittedBenefitQuantityList;

	@FindBy(how = How.CSS, using = "span[class='RXCFSmallerItalicText RXAiresCharcoal']")
	private List<WebElement> _textSubmittedBenefitDate;

	@FindBy(how = How.CSS, using = "div[id*='Benefit'] a[class*='BorderButton'] > span")
	private List<WebElement> _buttonDeleteSubmittedBenefitList;

	@FindBy(how = How.CSS, using = "div[id*='Benefit'] a[class*='BorderButton']")
	private List<WebElement> _buttonDeleteBenefitList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Unable to delete benefit. Please see comments in the History section below for more information.')]")
	private List<WebElement> _disabledDeleteButtonHoverText;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Unable to delete benefit due to completion of benefit.')]")
	private List<WebElement> _completedBenefitDisabledDeleteButtonHoverText;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'This benefit has been canceled by your Aires Representative due to a change. There will be no points returned to you as this benefit is still being used.')]")
	private List<WebElement> _canceledBenefitDisabledDeleteButtonHoverText;

	@FindBy(how = How.CSS, using = "div[id*='mainSubmittedBenefits'] span[class='RXAiresSeaglass RXCFBigText']")
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

	@FindBy(how = How.XPATH, using = "//span[text()='Back to benefits list']")
	private WebElement _link_backToBenefitList;

	@FindBy(how = How.XPATH, using = "//span[@class='RXHugestText RXBolder'][contains(text(),'My Benefits Bundle')]")
	private WebElement _headerMyBenefitsBundle;

	@FindBy(how = How.CSS, using = "div[class*='RXCFBenefitRow']")
	private List<WebElement> _submittedBenefitfRow;

	private By _deleteButtonSubElement = By.cssSelector("a[class*='BorderButton']");

	private By _disabledDeleteButtonHoverTextSubElement = By
			.xpath(".//span[contains(text(),'Unable to delete benefit due to completion of benefit.')]");

	private By _canceledBenefitDisabledDeleteButtonHoverTextSubElement = By.xpath(
			".//span[contains(text(),'This benefit has been canceled by your Aires Representative due to a change. There will be no points returned to you as this benefit is still being used.')]");

	@FindBy(how = How.CSS, using = "div[id*='deleteOwnedBenefits::content'] span[class='RXCFSmallText RXMineShaft RXCFWordwrap']")
	private List<WebElement> _deleteCashoutDescriptionText;

	private By _denyBenefitRequestDisabledDeleteButtonHoverTextSubElement = By.xpath(
			".//span[contains(text(),'Unable to delete benefit. Please see comments in the History section below for more information.')]");
	
	@FindBy(how = How.CSS, using = "iframe[class*='appcues-tooltip-container']")
	private WebElement _tooltipIFrame;

	@FindBy(how = How.CSS, using = "div[class*='appcues-actions-right'] > a")
	private WebElement _tooltipIFrameNextButton;

	@FindBy(how = How.CSS, using = "a[class='text-muted appcues-skip']")
	private WebElement _tooltipIFrameHideLink;
	
	@FindBy(how = How.CSS, using = "div.zone-content > div.rich-text")
	private WebElement _tooltipIFrameText;

	/*********************************************************************/

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

	public boolean isMyBundlePageDisplayed() {
		if (CoreFunctions.isElementExist(driver, _textMyBenefitsBundleTitle, 10)) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.MY_BUNDLE_PAGE_DISPLAYED, CoreConstants.PASS));
			return true;
		}
		Reporter.addStepLog(
				MessageFormat.format(MobilityXConstants.MY_BUNDLE_PAGE_IS_NOT_DISPLAYED, CoreConstants.FAIL));
		return false;
	}

	public void clickReviewAndSubmit() {
		CoreFunctions.clickUsingJS(driver, _btn_reviewAndSubmit, MobilityXConstants.REVIEW_AND_SUBMIT);
		CoreFunctions.writeToPropertiesFile("CF_Transferee_BenefitSubmitted", "true");
	}

	public void viewSubmittedBenefits() {
		CoreFunctions.clickElement(driver, _btn_seeBenefits);
		CoreFunctions.waitHandler(5);
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
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _btn_submitBundle, buttonName);
		CoreFunctions.click(driver, _btn_submitBundle, buttonName);
		CoreFunctions.writeToPropertiesFile("CF_Transferee_AvailablePoints", String.valueOf(
				Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")) - Double
						.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))));
	}

	public boolean verifySelectedBenefitDetails() {
		boolean isBenefitsAndPointsMatached = false;
		try {
			isBenefitsAndPointsMatached = verifyFlexBenefitsDetailsOnMBBPage()
					&& (Double.parseDouble(CoreFunctions.getElementText(driver, _selectedPoints)) == (Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))))
					&& ((CoreFunctions.getElementText(driver, _totalPoints))
							.equals(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")));
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
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		for (WebElement element : _confirmationDialogBenefitName) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_confirmationDialogBenefitName,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				CoreFunctions.verifyValue(
						(Double.parseDouble((CoreFunctions.getItemsFromListByIndex(driver,
								_confirmationDialogBenefitPoint, indexCashout, false)))),
						(Double.parseDouble(
								CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints"))),
						MobilityXConstants.SELECTED_CASHOUT_POINTS);
				CoreFunctions.verifyTextContains(
						CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogAmountAllowanceMessage,
								indexCashout, false),
						BusinessFunctions.getExpectedCashoutDescription(),
						MobilityXConstants.SELECTED_CASHOUT_DESCRIPTION);
				return true;
			}
		}
		return false;
	}

	private boolean validateSubmissionInfoText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		try {
			CoreFunctions.verifyTextContains(CoreFunctions.getElementText(driver, _testPointsConsumed),
					(MobilityXConstants.POINTS_CONSUMED_TEXT
							.replace("points_used",
									(String.valueOf(format.format(Double.parseDouble(CoreFunctions
											.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))))))
							.replace("total_points",
									CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))),
					MobilityXConstants.BENEFIT_SUBMISSION_INFO_TEXT);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_POINTS_INFO_TEXT_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	public boolean verifyFlexBenefitsDetailsOnMBBPage() {
		boolean isFlexBenefitDetailsOnMMBVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
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
		try {
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textAddedBenefitNameList, indexBenefit, true),
					benefit.getBenefitDisplayName(), COREFLEXConstants.SELECTED_BENEFIT_NAME);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _allowanceAmountList, indexBenefit, true),
					benefit.getBenefitAmount(), COREFLEXConstants.SELECTED_BENEFIT_ALLOWANCE_AMOUNT);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _benefitQuantityList, indexBenefit, true),
					String.valueOf(benefit.getNumberOfBenefitSelected()),
					COREFLEXConstants.SELECTED_BENEFIT_SELECTED_QUANTITY);
			CoreFunctions.verifyValue(
					(Double.parseDouble(
							(CoreFunctions.getItemsFromListByIndex(driver, _benefitsPointsList, indexBenefit, true)
									.replace("pts", "").trim()))),
					((Double.parseDouble(benefit.getPoints())) * (Integer.parseInt(
							CoreFunctions.getItemsFromListByIndex(driver, _benefitQuantityList, indexBenefit, true)))),
					COREFLEXConstants.SELECTED_BENEFIT_POINTS);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;

	}

	public boolean verifyFlexBenefitsDetailsOnSubmissionConfirmationDialog() {
		boolean isFlexBenefitDetailsOnFTPVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
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
		try {
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogBenefitName, indexBenefit, false),
					benefit.getBenefitDisplayName(), MobilityXConstants.BENEFIT_DISPLAY_NAME);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogAmountAllowanceMessage,
							indexBenefit, false),
					benefit.getBenefitAmount(), MobilityXConstants.BENEFIT_ALLOWANCE_AMOUNT);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogBenefitSelectionQuantity,
							indexBenefit, false),
					(String.valueOf(benefit.getNumberOfBenefitSelected())), MobilityXConstants.BENEFIT_QUANTITY);
			CoreFunctions.verifyValue(
					(Double.parseDouble((CoreFunctions.getItemsFromListByIndex(driver, _confirmationDialogBenefitPoint,
							indexBenefit, false)))),
					((Double.parseDouble(benefit.getPoints()))
							* (Integer.parseInt(CoreFunctions.getItemsFromListByIndex(driver,
									_confirmationDialogBenefitSelectionQuantity, indexBenefit, false)))),
					MobilityXConstants.BENEFIT_POINTS);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	public boolean validateSubmittedBenefitDetails() {
		boolean isSubmittedBenefitDetailsVerified = false;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
					&& verifySubmittedCashoutDetailsOnMBBPage() && verifySubmittedFlexBenefitsDetailsOnMBBPage()
					&& verifySubmittedPointsDetailsOnMBBPage();
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_ON_MY_BUNDLE_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedBenefitDetailsVerified)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.PASS));

		return isSubmittedBenefitDetailsVerified;
	}

	private boolean verifySubmittedPointsDetailsOnMBBPage() {
		try {
			CoreFunctions.verifyValue(
					Double.parseDouble(
							CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 0, true)),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints")),
					MobilityXConstants.SUBMITTED_BENEFIT_POINTS);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true),
					CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"),
					MobilityXConstants.TOTAL_AVAILABLE_POINTS);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_ON_MY_BUNDLE_PAGE,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	private boolean verifySubmittedCashoutDetailsOnMBBPage() {
		boolean isSubmittedPortionCashoutDetailsVerified = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isSubmittedPortionCashoutDetailsVerified = verifySubmittedCashout();
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
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_CASHOUT_DETAILS_ON_MBB_PAGE,
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
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
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
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
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
		try {
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexBenefit, true),
					benefit.getBenefitDisplayName(), COREFLEXConstants.SUBMITTED_BENEFIT_NAME);
			CoreFunctions
					.verifyText(
							CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedAllowanceAmountList,
									indexBenefit, true),
							benefit.getBenefitAmount(), COREFLEXConstants.SUBMITTED_BENEFIT_ALLOWANCE_AMOUNT);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit,
							true),
					String.valueOf(benefit.getNumberOfBenefitSelected()),
					COREFLEXConstants.SUBMITTED_BENEFIT_SELECTED_QUANTITY);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitDate, indexBenefit, true),
					CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"), COREFLEXConstants.SUBMITTED_DATE);
			CoreFunctions.verifyValue(
					(Double.parseDouble((CoreFunctions
							.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexBenefit, true)
							.replace("pts", "").trim()))),
					((Double.parseDouble(benefit.getPoints())) * (Integer.parseInt(CoreFunctions
							.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit, true)))),
					COREFLEXConstants.SUBMITTED_BENEFIT_POINTS);
			CoreFunctions.verifyText(CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexBenefit, true),
					benefit.getAiresManagedService().equals("No") ? MobilityXConstants.VIEW_PAYMENTS
							: MobilityXConstants.SUBMITTED,
					COREFLEXConstants.SUBMITTED_BENEFIT_STATUS);
			CoreFunctions.verifyText(CoreFunctions.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList,
					indexBenefit, true), MobilityXConstants.DELETE, COREFLEXConstants.SUBMITTED_BENEFIT_DELETE_BUTTON);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
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
		for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
				CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
			isDeletedBenefitUndo = undoDeletedBenefit(benefit);
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
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
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
				.equalsIgnoreCase(MobilityXConstants.REMOVE_BENEFIT_DIALOG_INFO_TEXT);
	}

	public void reviewAndConfirmRemoveBenefitSubmission(String optionalNotes, String transfereeName,
			String buttonName) {
		CoreFunctions.setElementText(driver, input_transfereeName, transfereeName);
		CoreFunctions.setElementText(driver, optionalComments, optionalNotes);
		CoreFunctions.waitHandler(2);
		CoreFunctions.click(driver, _buttonDeleteThisBenefits, buttonName);
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
				CoreFunctions.writeToPropertiesFile("CF_Transferee_BenefitDeletedFlag", "true");
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
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
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
		try {
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexBenefit, true),
					benefit.getBenefitDisplayName(), MobilityXConstants.SUBMITTED_BENEFIT_NAME);
			CoreFunctions
					.verifyText(
							CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedAllowanceAmountList,
									indexBenefit, true),
							benefit.getBenefitAmount(), MobilityXConstants.SUBMITTED_BENEFIT_ALLOWANCE_AMOUNT);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit,
							true),
					String.valueOf(benefit.getNumberOfBenefitSelected()),
					MobilityXConstants.SUBMITTED_BENEFIT_QUANTITY);
			CoreFunctions.verifyValue(
					(Double.parseDouble((CoreFunctions
							.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexBenefit, true)
							.replace("pts", "").trim()))),
					(Double.parseDouble(benefit.getPoints()) * (Integer.parseInt(CoreFunctions
							.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit, true)))),
					MobilityXConstants.SUBMITTED_BENEFIT_POINTS);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitDate, indexBenefit, true),
					CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"),
					MobilityXConstants.SUBMITTED_BENEFIT_DATE);
			CoreFunctions.verifyText(CoreFunctions.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList,
					indexBenefit, true), MobilityXConstants.UNDO, MobilityXConstants.UNDO_BUTTON);
			CoreFunctions.verifyText(CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexBenefit, true),
					MobilityXConstants.DELETE_REQUEST_PENDING, MobilityXConstants.DELETE_REQUEST_PENDING);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETED_FLEX_BENEFIT_STATUS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
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
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CASHOUT_DETAILS_UNDER_MY_BENEFIT_BUNDLE_SECTION_OF_MBB_PAGE,
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
			String expectedCashoutValue;
			DecimalFormat format = new DecimalFormat();
			format.setDecimalSeparatorAlwaysShown(false);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textAddedBenefitNameList, indexCashout, true),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyValue(
					(Double.parseDouble(
							(CoreFunctions.getItemsFromListByIndex(driver, _benefitsPointsList, indexCashout, true)
									.replace("pts", "").trim()))),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")),
					MobilityXConstants.CASHOUT_POINTS);
			CoreFunctions.verifyValue(Double.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value")),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")),
					MobilityXConstants.CASHOUT_INPUT_FIELD);

			if (CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign").length() == 1) {
				expectedCashoutValue = CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign")
						+ format.format(Double.parseDouble(
								CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")))
						+ " (" + CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode") + ")";
			} else {
				expectedCashoutValue = CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign") + " "
						+ format.format(Double.parseDouble(
								CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")))
						+ " (" + CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode") + ")";
			}
			String actualCashOutInputText = CoreFunctions.getElementText(driver, _textInputCashoutPoints);
			CoreFunctions.verifyText(actualCashOutInputText, expectedCashoutValue,
					MobilityXConstants.CASHOUT_INPUT_FIELD_LABEL_VALUE);
			CoreFunctions.verifyTextContains(
					CoreFunctions.getItemsFromListByIndex(driver, _allowanceAmountList, indexCashout, true),
					BusinessFunctions.getExpectedCashoutDescription(),
					MobilityXConstants.TRANSFEREE_CASHOUT_DESCRIPTION_FIELD);
			return CoreFunctions.isElementExist(driver, _buttonCashoutUpdate, 2);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CASHOUT_DETAILS_UNDER_MY_BENEFIT_BUNDLE_SECTION_OF_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifySubmittedCashout() {
		boolean isSubmittedPortionCashoutDetailsVerified = false;
		for (WebElement element : _textSubmittedBenefitNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_textSubmittedBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				isSubmittedPortionCashoutDetailsVerified = verifySubmittedCashoutDetails(indexCashout,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				break;
			}
		}
		if (isSubmittedPortionCashoutDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_CASHOUT_DETAILS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_MBB_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedPortionCashoutDetailsVerified;
	}

	private boolean verifySubmittedCashoutDetails(int indexCashout, String customCashoutBenefitName) {
		try {
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexCashout, true),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyValue(
					(Double.parseDouble((CoreFunctions
							.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexCashout, true)
							.replace("pts", "").trim()))),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")),
					MobilityXConstants.CASHOUT_POINTS);
			CoreFunctions.verifyText(CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexCashout, true),
					MobilityXConstants.VIEW_PAYMENTS, MobilityXConstants.VIEW_PAYMENTS);
			CoreFunctions.verifyText(CoreFunctions.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList,
					indexCashout, true), MobilityXConstants.DELETE, MobilityXConstants.DELETE);
			CoreFunctions.verifyTextContains(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedAllowanceAmountList, indexCashout,
							true),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible").contains(
							COREFLEXConstants.CLIENT) ? BusinessFunctions.getMXClientExpectedCashoutDescription()
									: BusinessFunctions.getExpectedCashoutDescription(),
					MobilityXConstants.TRANSFEREE_CASHOUT_DESCRIPTION_FIELD);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_CASHOUT_DETAILS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
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
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()) {
					CoreFunctions.scrollToElementUsingJS(driver, _headerMyBenefitsBundle,
							MobilityXConstants.MY_BENEFITS_BUNDLE);
					flag = false;
//					CoreFunctions.waitHandler(2);
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
					CoreFunctions.explicitWaitTillElementInVisibility(driver, _beleteBenefitSentGrowlMessage);
					CoreFunctions.scrollToElementUsingJS(driver, _headerMyBenefitsBundle,
							MobilityXConstants.MY_BENEFITS_BUNDLE);
				} else if (!benefit.getDeleteBenefitOnMBBPage())
					isSubmittedBenefitDeleted = true;
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
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_textSubmittedBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonDeleteSubmittedBenefitList,
						indexCashout);
				CoreFunctions.explicitWaitTillElementVisibility(driver, _removeBenefitDialog,
						MobilityXConstants.REMOVE_BENEFIT_DIALOG);
				int indexDeleteBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_textRemoveBenefitNameList, policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				CoreFunctions.verifyText(
						CoreFunctions.getItemsFromListByIndex(driver, _textRemoveBenefitNameList, indexDeleteBenefit,
								false),
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
						MobilityXConstants.CASHOUT_NAME);
				CoreFunctions.verifyTextContains(
						CoreFunctions.getItemsFromListByIndex(driver, _deleteCashoutDescriptionText, indexDeleteBenefit,
								false),
						BusinessFunctions.getExpectedCashoutDescription(),
						MobilityXConstants.TRANSFEREE_CASHOUT_DESCRIPTION_FIELD);
				CoreFunctions.verifyValue(
						Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver,
								_confirmationDialogBenefitPoint, indexDeleteBenefit, false)),
						Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")),
						MobilityXConstants.BENEFIT_POINTS);
				reviewAndConfirmRemoveBenefitSubmission(MobilityXConstants.SUBMIT_BENEFITS_OPTIONAL_NOTES,
						CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
								+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
						buttonName);
				isSubmittedCashoutDeleted = verifyRemoveBenefitRequestSuccessMessage();
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _beleteBenefitSentGrowlMessage);
			} else
				return true;
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
				CoreFunctions.writeToPropertiesFile("CF_Transferee_BenefitDeletedFlag", "true");
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
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_textSubmittedBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				isCashoutDeletedStatusVerified = verifyDeletedCashoutDetails(indexCashout,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
			} else
				return true;
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

	private boolean verifyDeletedCashoutDetails(int indexCashout, String customCashoutBenefitName) {
		try {
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexCashout, true),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyValue(
					(Double.parseDouble((CoreFunctions
							.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexCashout, true)
							.replace("pts", "").trim()))),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")),
					MobilityXConstants.CASHOUT_POINTS);
			CoreFunctions.verifyText(CoreFunctions.getItemsFromListByIndex(driver, _benefitStatus, indexCashout, true),
					MobilityXConstants.DELETE_REQUEST_PENDING, MobilityXConstants.DELETE_REQUEST_PENDING);
			CoreFunctions.verifyText(CoreFunctions.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList,
					indexCashout, true), MobilityXConstants.UNDO, MobilityXConstants.UNDO);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitDate, indexCashout, true),
					CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"), MobilityXConstants.SUBMITTED_DATE);
			CoreFunctions.verifyTextContains(
					CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedAllowanceAmountList, indexCashout,
							true),
					BusinessFunctions.getExpectedCashoutDescription(),
					MobilityXConstants.TRANSFEREE_CASHOUT_DESCRIPTION_FIELD);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DELETED_CASHOUT_DETAILS_UNDER_SUBMITTED_BENEFITS_SECTION_OF_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean validateSubmittedBenefitDetailsPostDeleteRequestOperation(String actionPerformed) {
		boolean isBenefitsAndPointsMatched = false, isSubmittedBenefitDetailsVerified = false;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
					&& verifySubmittedDetailsPostDeleteRequestOperationOnMBBPage(actionPerformed);
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0, true))) == (Double.parseDouble(
									CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))))
					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true))
							.equals(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")));
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
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedDetailsVerifiedOnMBBVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
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
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()) {
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
			try {
				isDeleteButtonDisabled = Boolean.valueOf(CoreFunctions.getAttributeText(
						CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit), _deleteButtonSubElement),
						"aria-disabled"));
				CoreFunctions.scrollToElementUsingJS(driver,
						CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit), _deleteButtonSubElement),
						COREFLEXConstants.DELETE_BUTTON);
				CoreFunctions.moveToElement(driver,
						CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit), _deleteButtonSubElement));
				isDeleteHoverTextVerified = CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit),
								_denyBenefitRequestDisabledDeleteButtonHoverTextSubElement),
						5);
				CoreFunctions.highlightObject(driver,
						CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit),
								_denyBenefitRequestDisabledDeleteButtonHoverTextSubElement));
				if (isDeleteButtonDisabled && isDeleteHoverTextVerified) {
					Reporter.addStepLog(MessageFormat.format(
							COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETE_BUTTON_IS_DISABLED_AND_DISABLED_DELETE_HOVER_TEXT_POST_DELETE_REQUEST_DENIED_BY_MSPEC_PPC_USER,
							CoreConstants.PASS));
					CoreFunctions.moveToElement(driver, _textSubmittedBenefitNameList.get(indexBenefit));
					return true;
				} else {
					Reporter.addStepLog(MessageFormat.format(
							COREFLEXConstants.DELETE_HOVER_TEXT_POST_DELETE_REQUEST_DENIED_BY_MSPEC_PPC_USER_IS_NOT_DISPLAYED_UNDER_SUBMITTED_BENEFITS_SECTION_OF_MBB_PAGE,
							CoreConstants.FAIL));
					return false;
				}
			} catch (Exception e) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_BUTTON_IS_DISABLED_AND_DISABLED_DELETE_HOVER_TEXT_POST_DELETE_REQUEST_DENIED_BY_MSPEC_PPC_USER,
						CoreConstants.FAIL, e.getMessage()));
			}
		}
		return true;
	}

	private boolean verifySubmittedBenefitDetailsPostApprovedDeleteRequest() {
		boolean isDeletedBenefitNotInSubmittedList = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
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
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_BENEFIT_REQUEST_REMOVED_ON_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isDeletedBenefitNotInSubmittedList) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETED_FLEX_BENEFIT_NOT_PRESENT_IN_SUBMITTED_BENEFITS_LIST_ON_MY_BENEFITS_PAGE_POST_DELETE_REQUEST_APPROVAL,
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
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if (benefit.getSelectBenefitOnFPTPage() && (benefit.getAiresManagedService().equals("Yes"))) {
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
					&& verifySubmittedCashoutDetailsOnMBBPage()
					&& verifySubmittedAiresManagedBenefitsDetailsOnMBBPage(expectedStatus);
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0, true))) == (Double.parseDouble(
									CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))))
					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true))
							.equals(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")));

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
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))) {
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
						|| expectedStatus.equalsIgnoreCase(MobilityXConstants.CANCELED))
								? (Boolean.valueOf(CoreFunctions
										.getAttributeText(_buttonDeleteBenefitList.get(indexBenefit), "aria-disabled")))
								: CoreFunctions.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList,
										indexBenefit, true).equals(MobilityXConstants.DELETE));
	}

	private boolean verifyBenefitDeleteButtonDisabled(int indexBenefit, Benefit benefit, String expectedStatus) {
		switch (expectedStatus) {
		case MobilityXConstants.COMPLETE:
			return verifyCompetedBenefitDeleteButtonStatus(indexBenefit);
		case MobilityXConstants.CANCELED:
			return verifyCanceledBenefitDeleteButtonStatus(indexBenefit);
		default:
			return true;
		}
	}

	private boolean verifyCanceledBenefitDeleteButtonStatus(int indexBenefit) {
		boolean isDeleteButtonDisabled = false;
		boolean isDeleteHoverTextVerified = false;
		try {

			isDeleteButtonDisabled = Boolean.valueOf(CoreFunctions.getAttributeText(
					CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit), _deleteButtonSubElement),
					"aria-disabled"));
			CoreFunctions.scrollToElementUsingJS(driver,
					CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit), _deleteButtonSubElement),
					COREFLEXConstants.DELETE_BUTTON);
			CoreFunctions.moveToElement(driver,
					CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit), _deleteButtonSubElement));
			isDeleteHoverTextVerified = CoreFunctions.isElementExist(driver,
					CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit),
							_canceledBenefitDisabledDeleteButtonHoverTextSubElement),
					5);
			CoreFunctions.highlightObject(driver, CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit),
					_canceledBenefitDisabledDeleteButtonHoverTextSubElement));
			if (isDeleteButtonDisabled && isDeleteHoverTextVerified) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETE_BUTTON_IS_DISABLED_AND_DISABLED_DELETE_HOVER_TEXT_POST_BENEFIT_STATUS_CANCELED,
						CoreConstants.PASS));
				CoreFunctions.moveToElement(driver, _textSubmittedBenefitNameList.get(indexBenefit));
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
			isDeleteButtonDisabled = Boolean.valueOf(CoreFunctions.getAttributeText(
					CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit), _deleteButtonSubElement),
					"aria-disabled"));
			CoreFunctions.scrollToElementUsingJS(driver,
					CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit), _deleteButtonSubElement),
					COREFLEXConstants.DELETE_BUTTON);
			CoreFunctions.moveToElement(driver,
					CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit), _deleteButtonSubElement));
			isDeleteHoverTextVerified = CoreFunctions.isElementExist(driver, CoreFunctions.findSubElement(
					_submittedBenefitfRow.get(indexBenefit), _disabledDeleteButtonHoverTextSubElement), 5);
			CoreFunctions.highlightObject(driver, CoreFunctions.findSubElement(_submittedBenefitfRow.get(indexBenefit),
					_disabledDeleteButtonHoverTextSubElement));
			if (isDeleteButtonDisabled && isDeleteHoverTextVerified) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETE_BUTTON_IS_DISABLED_AND_DISABLED_DELETE_HOVER_TEXT_POST_BENEFIT_STATUS_COMPLETE,
						CoreConstants.PASS));
				CoreFunctions.moveToElement(driver, _textSubmittedBenefitNameList.get(indexBenefit));
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
						|| expectedStatus.equalsIgnoreCase(MobilityXConstants.CANCELED))
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

//	public boolean validateSubmittedAiresManagedBenefitDetails(String expectedStatus, int noOfMilestones) {
//		boolean isSubmittedBenefitDetailsVerified = false;
//		hoverIndex = 0;
//		try {
//			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
//					&& verifySubmittedAiresManagedBenefitsDetailsOnMBBPage(expectedStatus, noOfMilestones);
//		} catch (Exception e) {
//			Reporter.addStepLog(MessageFormat.format(
//					MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_AIRES_MANAGED_BENEFITS_ON_MY_BUNDLE_PAGE,
//					CoreConstants.FAIL, e.getMessage()));
//		}
//		if (isSubmittedBenefitDetailsVerified)
//			Reporter.addStepLog(MessageFormat.format(
//					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_AIRES_MANAGED_BENEFIT_ON_MY_BUNDLE_PAGE,
//					CoreConstants.PASS));
//
//		return isSubmittedBenefitDetailsVerified;
//	}

//	private boolean verifySubmittedAiresManagedBenefitsDetailsOnMBBPage(String expectedStatus, int noOfMilestones) {
//		boolean isSubmittedAiresManagedBenefitDetailsOnMBBVerified = false;
//		boolean flag = false;
//		try {
//			for (FlexBenefit benefitList : flexBenefits) {
//				for (Benefit benefit : benefitList.getBenefits()) {
//					if ((benefit.getSelectBenefitOnFPTPage()) && (benefit.getAiresManagedService().equals("Yes"))
//							&& benefit.getNoOfMilestones() != null
//							&& Objects.equals(benefit.getNoOfMilestones(), noOfMilestones)) {
//						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
//								_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
//						isSubmittedAiresManagedBenefitDetailsOnMBBVerified = verifySubmittedAiresManagedBenefitDetailsOnMBB(
//								indexBenefit, benefit, expectedStatus)
//								&& verifyBenefitDeleteButtonDisabled(indexBenefit, benefit, expectedStatus);
//						if (!isSubmittedAiresManagedBenefitDetailsOnMBBVerified) {
//							return false;
//						} else {
//							flag = true;
//						}
//					} else {
//						isSubmittedAiresManagedBenefitDetailsOnMBBVerified = true;
//					}
//				}
//			}
//		} catch (Exception e) {
//			Reporter.addStepLog(MessageFormat.format(
//					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_AIRES_MANAGED_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
//					CoreConstants.FAIL, e.getMessage()));
//		}
//		if (isSubmittedAiresManagedBenefitDetailsOnMBBVerified & flag) {
//			Reporter.addStepLog(MessageFormat.format(
//					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_AIRES_MANAGED_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
//					CoreConstants.PASS));
//		}
//		return isSubmittedAiresManagedBenefitDetailsOnMBBVerified;
//	}

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

	public boolean validateSubmittedAMMultipleSubmissionBenefitDetails(String expectedStatus) {
		boolean isBenefitsAndPointsMatched = false, isSubmittedBenefitDetailsVerified = false;
		hoverIndex = 0;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
					&& verifySubmittedCashoutDetailsOnMBBPage()
					&& verifySubmittedAMMultipleBenefitsDetailsOnMBBPage(expectedStatus);
			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0, true))) == (Double.parseDouble(
									CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))))
					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1, true))
							.equals(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")));
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

	private boolean verifySubmittedCashoutDetailsPostDeniedDeleteRequest() {

		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				return iterateAndVerifyCashoutPresent();
			} else if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED))) {
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CASHOUT_DETAILS_POST_DENIED_DELETE_REQUEST_ON_MBB_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		return false;
	}

	private boolean iterateAndVerifyCashoutPresent() {
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
								.replace("pts", "").trim()))) == (Double.parseDouble(
										CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints"))))
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

	public boolean verifySelectedAiresManagedBenefitDetails() {
		boolean isBenefitsAndPointsMatached = false;
		try {
			isBenefitsAndPointsMatached = verifyFlexAiresManagedBenefitsDetailsOnMBBPage()
					&& (Double.parseDouble(CoreFunctions.getElementText(driver, _selectedPoints)) == (Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))))
					&& ((CoreFunctions.getElementText(driver, _totalPoints))
							.equals(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")));
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

	public boolean verifyFlexAiresManagedBenefitsDetailsOnMBBPage() {
		boolean isFlexBenefitDetailsOnMMBVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if (benefit.getSelectBenefitOnFPTPage() && (benefit.getAiresManagedService().equals("Yes"))) {
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

	public boolean verifyAppCues(String pageName, DataTable dataTable) {
		List<String> expectedAppCuesList = dataTable.asList(String.class);
		String actualAppCueText = null;
		int index = 0;
		try {
			if (CoreFunctions.isElementExist(driver, _tooltipIFrame, 5)) {
				while (index < expectedAppCuesList.size()) {
					driver.switchTo().frame(_tooltipIFrame);
					CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _tooltipIFrameHideLink,
							MobilityXConstants.HIDE);
					actualAppCueText = CoreFunctions.getElementText(driver, _tooltipIFrameText);
					CoreFunctions.verifyText(actualAppCueText, expectedAppCuesList.get(index), MobilityXConstants.APPCUES);
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
				Reporter.addStepLog(
						MessageFormat.format(MobilityXConstants.APPCUES_NOT_DISPLAYED, CoreConstants.FAIL, pageName,expectedAppCuesList.get(index)));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_APPCUES,
					CoreConstants.FAIL, e.getMessage(), pageName));
			return false;
		}
	}

}
