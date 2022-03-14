package com.aires.pages.coreflex;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;

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
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.MX_Transferee_LoginData;
import com.vimalselvam.cucumber.listener.Reporter;

public class MX_Transferee_MyBenefitsBundlePage extends Base {

	public MX_Transferee_MyBenefitsBundlePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "span.RXHugestText.RXBolder.RXGraniteGrey")
	private WebElement myBenefitsBundleTitle;

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

	private By _confirmationDialogBenefitName = By
			.xpath(".//span[@class='RXText RXCFSubmitBenefitsBenefits RXBolder']");

	private By _confirmationDialogAmountAllowanceMessage = By.xpath(".//span[@class='RXCFSmallText RXAiresSeaglass']");

	private By _confirmationDialogBenefitPoint = By.xpath(".//span[@class='RXCFHugestText RXWhite RXBold']");

	private By _confirmationDialogBenefitSelectionQuantity = By
			.xpath(".//span[@class='RXText RXGraniteGrey RXBolder']");

	/*********************************************************************/

	public static double availablePointsAfterSubmission = 0;

	MX_Transferee_LoginData loginData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getloginDetailsByUserFirstName(COREFLEXConstants.USER_FIRST_NAME);

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	private List<Benefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader().getAllFlexBenefits();

	/*********************************************************************/

	public boolean isMyBundlePageDisplayed() {
		if (CoreFunctions.isElementExist(driver, myBenefitsBundleTitle, 10)) {
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

	public void reviewAndConfirmBenefitSubmission(String optionalNotes, String transfereeName) {
		CoreFunctions.setElementText(driver, input_transfereeName, transfereeName);
		CoreFunctions.setElementText(driver, optionalComments, optionalNotes);
		CoreFunctions.clickElement(driver, _btn_submitBundle);
		MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission = Double
				.parseDouble(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable)
				- (MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints);
	}

	public boolean verifySelectedBenefitDetails() {
		boolean isBenefitsAndPointsMatached = false;
		try {
			int count = 0;
			for (Benefit benefit : flexBenefits) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					for (int i = 0; i < _benefit_list.size(); i++) {
						WebElement selectedBenefit = _benefit_list.get(i);
						String actualBenefitDisplayName = CoreFunctions.getSubElementText(driver, selectedBenefit,
								benefitName);
						String actualAmountAllowanceMessage = CoreFunctions.getSubElementText(driver, selectedBenefit,
								amountAllowanceMessage);
						String actualBenfitPoints = CoreFunctions
								.getSubElementText(driver, selectedBenefit, benefitPoint).replace("pts", "").trim();
						String actualBenefitSelectionQuantity = CoreFunctions.getSubElementText(driver, selectedBenefit,
								benefitSelectionQuantity);
						if ((actualBenefitDisplayName.equals(benefit.getBenefitDisplayName()))
								&& (actualAmountAllowanceMessage.equals(benefit.getBenefitAmount()))
								&& (actualBenfitPoints.equals(String.valueOf(Double.parseDouble(benefit.getPoints())
										* Integer.parseInt(actualBenefitSelectionQuantity))))
								&& (actualBenefitSelectionQuantity
										.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))) {
							count += 1;
							break;
						}
					}
				}
			}
			if (CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT)) {
				for (int i = 0; i < _benefit_list.size(); i++) {
					WebElement selectedBenefit = _benefit_list.get(i);
					String benefitType = CoreFunctions.getSubElementText(driver, selectedBenefit, benefitName);
					if (benefitType.equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
						count += 1;
						break;
					}
				}
			}
			isBenefitsAndPointsMatached = (count == _benefit_list.size())
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

	public boolean isSubmitBundlePopupDisplayed() {
		return CoreFunctions.isElementExist(driver, _submitBundleTitle, 10);
	}

	public boolean verifyBenefitsDetailsOnSubmissionDialog() {

		boolean isSubmissionInfoTextValid = false, isSubmittedBenefitDetailsValid = false;
		boolean isPointsBenefitsDetailsValid = false;
		try {
			isSubmittedBenefitDetailsValid = verifyBenefitDetailsOnSubmissionConfirmationDialog();
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

	private boolean verifyBenefitDetailsOnSubmissionConfirmationDialog() {
		boolean isSubmittedBenefitDetailsValid = false;
		int count = 0;
		for (Benefit benefit : flexBenefits) {
			if (benefit.getSelectBenefitOnFPTPage()) {
				for (int i = 0; i < _confirmationDialogBenefitlist.size(); i++) {
					WebElement selectedBenefit = _confirmationDialogBenefitlist.get(i);
					String actualBenefitDisplayName = CoreFunctions.getSubElementText(driver, selectedBenefit,
							_confirmationDialogBenefitName);
					String actualAmountAllowanceMessage = CoreFunctions.getSubElementText(driver, selectedBenefit,
							_confirmationDialogAmountAllowanceMessage);
					String actualBenfitPoints = CoreFunctions.getSubElementText(driver, selectedBenefit,
							_confirmationDialogBenefitPoint);
					String actualBenefitSelectionQuantity = CoreFunctions.getSubElementText(driver, selectedBenefit,
							_confirmationDialogBenefitSelectionQuantity);
					if ((actualBenefitDisplayName.equals(benefit.getBenefitDisplayName()))
							&& (actualAmountAllowanceMessage.equals(benefit.getBenefitAmount()))
							&& (actualBenfitPoints.equals(String.valueOf(Double.parseDouble(benefit.getPoints())
									* Integer.parseInt(actualBenefitSelectionQuantity))))
							&& (actualBenefitSelectionQuantity
									.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))) {
						isSubmittedBenefitDetailsValid = true;
						count += 1;
						break;
					}
				}
			}
		}
		return isSubmittedBenefitDetailsValid && (count == _confirmationDialogBenefitlist.size());
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

	public boolean validateSubmittedBenefitDetails() {
		boolean isBenefitsAndPointsMatached = false;
		try {
			int count = 0;
			for (Benefit benefit : flexBenefits) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					for (int i = 0; i < submittedBenefits.size(); i++) {
						WebElement submittedBenefit = submittedBenefits.get(i);
						if (CoreFunctions.getSubElementText(driver, submittedBenefit, benefitName)
								.equals(benefit.getBenefitDisplayName())) {
							count += 1;
							break;
						}
					}

				}
			}
			isBenefitsAndPointsMatached = (count == submittedBenefits.size())
					&& (Double.parseDouble(CoreFunctions.getElementText(driver,
							_submittedPoints)) == MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints);

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_SUBMITTED_BENEFITS_ON_MY_BUNDLE_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitsAndPointsMatached)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_ON_MY_BUNDLE_PAGE, CoreConstants.PASS));

		return isBenefitsAndPointsMatached;
	}

}
