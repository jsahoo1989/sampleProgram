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
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.aires.testdatatypes.coreflex.MX_Transferee_LoginData;
import com.aires.testdatatypes.coreflex.OtherBenefit;
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

	private By benefitName = By.xpath(".//span[@class='RXText RXCFSubmitBenefitsBenefits RXBolder RXCFWordwrap']");

	private By amountAllowanceMessage = By.xpath(".//span[@class='RXCFSmallText RXAiresSeaglass RXCFWordwrap']");

	private By benefitPoint = By.xpath(".//span[@class='RXCFText RXBold RXAiresSeaglass']");

	private By benefitSelectionQuantity = By.xpath(".//span[@class='RXCFSmallText RXGraniteGrey']");

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

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'SubmitBenefit')]//span[@class='RXCFSmallText RXMineShaft RXBolder RXCFWordwrap']")
	private List<WebElement> _textSubmittedBenefitNameList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'SubmitBenefit')]//span[@class='RXCFSmallText RXMineShaft RXCFWordwrap']")
	private List<WebElement> _textSubmittedAllowanceAmountList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'SubmitBenefit')]//span[@class='RXCFText RXBold RXAiresSeaglass']")
	private List<WebElement> _textSubmittedBenefitsPointsList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'SubmitBenefit')]//span[@class='RXBolder RXCFSmallText']")
	private List<WebElement> _textSubmittedBenefitQuantityList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'SubmitBenefit')]//a[contains(@class,'RXCFRedBorderButton')]/span")
	private List<WebElement> _buttonDeleteSubmittedBenefitList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'mainSubmittedBenefits')]//span[@class='RXAiresSeaglass RXCFBigText']")
	private List<WebElement> _textSubmittedBenefitsPoints;

	/*********************************************************************/

	public static double availablePointsAfterSubmission = 0;

	MX_Transferee_LoginData loginData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getloginDetailsByUserFirstName(COREFLEXConstants.USER_FIRST_NAME);

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> categoryWiseFlexBenefits = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getMXTransfereeFlexBenefitDetails();

	public static final List<OtherBenefit> otherBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeOtherBenefitDetails();

	public final List<Benefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getAllFlexBenefits();

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
		CoreFunctions.click(driver, _btn_submitBundle, buttonName);
		MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission = Double
				.parseDouble(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable)
				- (MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints);
	}

	public boolean verifySelectedBenefitDetails() {
		boolean isBenefitsAndPointsMatached = false;
		boolean isSelectedBenefitDetailsVerified = false;
		try {
			isSelectedBenefitDetailsVerified = verifyFlexBenefitsDetailsOnMBBPage()
					&& verifyOtherBenefitsDetailsOnMBBPage()
					&& verifyCashOutDetails(CoreFunctions.getPropertyFromConfig("PolicyCashoutType"));

			isBenefitsAndPointsMatached = isSelectedBenefitDetailsVerified
					&& (Double.parseDouble(CoreFunctions.getElementText(driver,
							_selectedPoints)) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints)
					&& ((CoreFunctions.getElementText(driver, _totalPoints))
							.equals(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_REVIEWING_AND_SUBMITTING_BENEFITS_ON_MY_BUNDLE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatached)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_REVIEWED_AND_SUBMITTED_BENEFITS_ON_MY_BUNDLE_PAGE,
					CoreConstants.PASS));

		return isBenefitsAndPointsMatached;
	}

	private boolean verifyCashOutDetails(String cashOutType) {

		switch (cashOutType) {

		case MobilityXConstants.PORTION_CASHOUT:
		case MobilityXConstants.AFTER_RELOCATION_ONLY:
			int count = 0;
			for (int i = 0; i < _benefit_list.size(); i++) {
				WebElement selectedBenefit = _benefit_list.get(i);
				String benefitType = CoreFunctions.getSubElementText(driver, selectedBenefit, benefitName);
				if (benefitType.equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
					count += 1;
					break;
				}
			}
			break;
		case MobilityXConstants.CASHOUT_NOT_AUTHORIZED:
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_ELEMENT);

		}
		return true;
	}

	public boolean isSubmitBundlePopupDisplayed() {
		return CoreFunctions.isElementExist(driver, _submitBundleTitle, 10);
	}

	public boolean verifyBenefitsDetailsOnSubmissionDialog() {

		boolean isSubmissionInfoTextValid = false, isSubmittedBenefitDetailsValid = false;
		boolean isPointsBenefitsDetailsValid = false;
		try {
			isSubmittedBenefitDetailsValid = verifyFlexBenefitsDetailsOnSubmissionConfirmationDialog()
					&& verifyOtherBenefitsDetailsOnSubmissionConfirmationDialog();
			isSubmissionInfoTextValid = validateSubmissionInfoText();
			isPointsBenefitsDetailsValid = isSubmissionInfoTextValid && isSubmittedBenefitDetailsValid;
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

	private boolean validateSubmissionInfoText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return CoreFunctions.getElementText(driver, _testPointsConsumed)
				.contains(MobilityXConstants.POINTS_CONSUMED_TEXT
						.replace("points_used", String.valueOf(MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints))
						.replace("total_points",
								policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
	}

	public boolean verifyFlexBenefitsDetailsOnMBBPage() {
		boolean isFlexBenefitDetailsOnFTPVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : categoryWiseFlexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						isFlexBenefitDetailsOnFTPVerified = verifyFlexPlanningToolBenefitDetails(indexBenefit, benefit);
						if (!isFlexBenefitDetailsOnFTPVerified) {
							break;
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
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsOnFTPVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsOnFTPVerified;
	}

	private boolean verifyOtherBenefitsDetailsOnMBBPage() {
		boolean isOtherBenefitDetailsOnFPTVerified = false;
		boolean flag = false;
		try {
			for (OtherBenefit benefitList : otherBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						isOtherBenefitDetailsOnFPTVerified = verifyFlexPlanningToolBenefitDetails(indexBenefit,
								benefit);
						if (!isOtherBenefitDetailsOnFPTVerified) {
							break;
						} else {
							flag = true;
						}
					} else {
						isOtherBenefitDetailsOnFPTVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_OTHER_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isOtherBenefitDetailsOnFPTVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_OTHER_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.PASS));
		}
		return isOtherBenefitDetailsOnFPTVerified;
	}

	private boolean verifyFlexPlanningToolBenefitDetails(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textAddedBenefitNameList, indexBenefit)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _allowanceAmountList, indexBenefit)
						.equals(benefit.getBenefitAmount()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _benefitQuantityList, indexBenefit)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _benefitsPointsList, indexBenefit).replace("pts", "")
						.trim()).equals(
								String.valueOf(Double.parseDouble(benefit.getPoints()) * Integer.parseInt(CoreFunctions
										.getItemsFromListByIndex(driver, _benefitQuantityList, indexBenefit)))));
	}

	public boolean verifyFlexBenefitsDetailsOnSubmissionConfirmationDialog() {
		boolean isFlexBenefitDetailsOnFTPVerified = false;
		boolean flag = false;
		try {
			for (FlexBenefit benefitList : categoryWiseFlexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						isFlexBenefitDetailsOnFTPVerified = verifySelectedBenefitDetailsOnConfirmationDialog(
								indexBenefit, benefit);
						if (!isFlexBenefitDetailsOnFTPVerified) {
							break;
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

	private boolean verifyOtherBenefitsDetailsOnSubmissionConfirmationDialog() {
		boolean isOtherBenefitDetailsOnFPTVerified = false;
		boolean flag = false;
		try {
			for (OtherBenefit benefitList : otherBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						isOtherBenefitDetailsOnFPTVerified = verifySelectedBenefitDetailsOnConfirmationDialog(
								indexBenefit, benefit);
						if (!isOtherBenefitDetailsOnFPTVerified) {
							break;
						} else {
							flag = true;
						}
					} else {
						isOtherBenefitDetailsOnFPTVerified = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_OTHER_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isOtherBenefitDetailsOnFPTVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_OTHER_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.PASS));
		}
		return isOtherBenefitDetailsOnFPTVerified;
	}

	private boolean verifySelectedBenefitDetailsOnConfirmationDialog(int indexBenefit, Benefit benefit) {
		return (CoreFunctions
				.getItemsFromListByIndexWithoutHighlight(driver, _confirmationDialogBenefitName, indexBenefit)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndexWithoutHighlight(driver,
						_confirmationDialogAmountAllowanceMessage, indexBenefit).equals(benefit.getBenefitAmount()))
				&& (CoreFunctions.getItemsFromListByIndexWithoutHighlight(driver,
						_confirmationDialogBenefitSelectionQuantity, indexBenefit)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& ((CoreFunctions.getItemsFromListByIndexWithoutHighlight(driver, _confirmationDialogBenefitPoint,
						indexBenefit))
								.equals(String.valueOf(Double.parseDouble(benefit.getPoints())
										* Integer.parseInt(CoreFunctions.getItemsFromListByIndexWithoutHighlight(driver,
												_confirmationDialogBenefitSelectionQuantity, indexBenefit)))));
	}

	public boolean validateSubmittedBenefitDetails() {
		boolean isBenefitsAndPointsMatched = false, isSubmittedBenefitDetailsVerified = false;
		try {
			isSubmittedBenefitDetailsVerified = verifySubmittedBenefitsSectionHeader()
					&& verifySubmittedFlexBenefitsDetailsOnMBBPage() && verifySubmittedOtherBenefitsDetailsOnMBBPage();

			isBenefitsAndPointsMatched = isSubmittedBenefitDetailsVerified
					&& ((Double.parseDouble(CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints,
							0))) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints)
					&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPoints, 1))
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

	private boolean verifySubmittedOtherBenefitsDetailsOnMBBPage() {
		boolean isSubmittedOtherBenefitDetailsOnMBB = false;
		boolean flag = false;
		try {
			for (OtherBenefit benefitList : otherBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
						isSubmittedOtherBenefitDetailsOnMBB = verifySubmittedBenefitDetailsOnMBB(indexBenefit, benefit);
						if (!isSubmittedOtherBenefitDetailsOnMBB) {
							break;
						} else {
							flag = true;
						}
					} else {
						isSubmittedOtherBenefitDetailsOnMBB = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_OTHER_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isSubmittedOtherBenefitDetailsOnMBB & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_OTHER_BENEFIT_DETAILS_ON_MY_BENEFITS_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedOtherBenefitDetailsOnMBB;
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
			for (FlexBenefit benefitList : categoryWiseFlexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getSelectBenefitOnFPTPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textSubmittedBenefitNameList, benefit.getBenefitDisplayName());
						isSubmittedFlexBenefitDetailsOnMBBVerified = verifySubmittedBenefitDetailsOnMBB(indexBenefit,
								benefit);
						if (!isSubmittedFlexBenefitDetailsOnMBBVerified) {
							break;
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
		return (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitNameList, indexBenefit)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedAllowanceAmountList, indexBenefit)
						.equals(benefit.getBenefitAmount()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _textSubmittedBenefitsPointsList, indexBenefit).replace("pts","").trim())
						.equals(String.valueOf(Double.parseDouble(benefit.getPoints()) * (Integer.parseInt(CoreFunctions
								.getItemsFromListByIndex(driver, _textSubmittedBenefitQuantityList, indexBenefit)))))
						&& CoreFunctions
								.getItemsFromListByIndex(driver, _buttonDeleteSubmittedBenefitList, indexBenefit)
								.equals(MobilityXConstants.DELETE));
	}
}
