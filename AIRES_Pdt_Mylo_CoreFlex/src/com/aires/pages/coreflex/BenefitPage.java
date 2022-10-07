package com.aires.pages.coreflex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.iris.helpers.Helpers;
import com.aires.pages.iris.IRIS_PageMaster;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.utilities.Log;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.ButtonDescription;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.DialogDescription;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.Window;

public abstract class BenefitPage extends Base {

	public BenefitPage(WebDriver driver) {
		super(driver);
	}

	public abstract void selectAndFillBenefitsAndSubBenefitDetails(String benefitType, String subBenefitNames,
			String multipleBenefitSelection, String flexPoints, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String aireManagedService);

	public abstract boolean verifyPageNavigation(String expectedPageName);

	public abstract void clickElementOfPage(String elementName);

	public abstract void clickLeftNavigationMenuOfPage(String elementName);

//	public abstract void selectSubBenefitsAndFillMandatoryFields(String subBenefitNames, String benefitType);

//	public abstract void fillSubBenefit(String subBenefit, String benefitType);

	public void expandSubBenefitIfCollapsed(WebElement subBenefitForm) {
		if (subBenefitForm.getAttribute("class").equalsIgnoreCase("collapsed")) {
			CoreFunctions.clickElement(driver, subBenefitForm);
		}
	}

//	public abstract WebElement getElementByName(String elementName);

//	public abstract void selectBenefitTypeAndFillMandatoryFields(String benefitType, String multipleBenefitSelection,
//			String flexPoints, String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription,
//			String aireManagedService);

	public abstract void fillManadatoryDetails(String benefitType, String multipleBenefitSelection,
			String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription,
			String aireManagedService);

	protected abstract boolean verifyAddedBenefitsAndSubBenefitDetails(String policyType, String subBenefits,
			String multipleBenefitSelection, String points, String benefitDisplayName, String benefitAmount,
			String benefitDesc, String payments, String airesManagedService);

//	public abstract void verifyBenefitsMandatoryDetails(String benefitType, String multipleBenefitSelection,
//			String flexPoints, String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription,
//			String paymentOption, String airesManagedService);

//	public abstract void verifyManadatoryDetails(String benefitType, String multipleBenefitSelection,
//			String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription, String paymentOption,
//			String airesManagedService);

//	public abstract void iterateSubBenefitAndVerifyDetails(String subBenefitNames, String benefitType);

//	public abstract void verifySubBenefitDetails(String subBenefit, String benefitType);

	public abstract boolean verifyFlexBenefitCardStatusAfterInitialActualization(int index,
			String expectedEstimatedDate);

	protected abstract boolean verifyFlexBenefitCardStatusAfterEndActualization(int index,
			String expectedEstimatedDate);

	public abstract boolean verifyCoreBenefitCardStatusAfterInitialActualization(int index,
			String expectedEstimatedDate);

	protected abstract boolean verifyCoreBenefitCardStatusAfterEndActualization(int index, Benefit benefit);

	public abstract void addSubService(Window _IRIS, Table table, Benefit benefit, String coreFlexType);

	public void actualizeSubServiceTracingPrompt(Window _IRIS, Table activityFinanceTable, String partner,
			String tracingPrompt) throws Exception {

		int rowId = Helpers.getRowIdMatchingCellValue(activityFinanceTable, "Type", partner);
		activityFinanceTable.selectRows(rowId);

		Log.info(tracingPrompt + ":" + partner);

		Button viewActivitiesButton = IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "View Activities");
		viewActivitiesButton.click();

		rowId = Helpers.getRowIdMatchingCellValue(
				IRIS_PageMaster.getTableObject(_IRIS, "com.aires.iris.shipment.activityfinance.ActivityFinancePanel$1"),
				"Act Desc", tracingPrompt);

		Helpers.selectTableRow(
				IRIS_PageMaster.getTableObject(_IRIS, "com.aires.iris.shipment.activityfinance.ActivityFinancePanel$1"),
				rowId);

		Helpers.setTableCellValue(
				IRIS_PageMaster.getTableObject(_IRIS, "com.aires.iris.shipment.activityfinance.ActivityFinancePanel$1"),
				rowId, "Est. Date", CoreFunctions.getCurrentDateAsGivenFormat("MM/dd/yyyy"));

		Helpers.setTableCellValue(
				IRIS_PageMaster.getTableObject(_IRIS, "com.aires.iris.shipment.activityfinance.ActivityFinancePanel$1"),
				rowId, "Act. Date", CoreFunctions.getCurrentDateAsGivenFormat("MM/dd/yyyy"));
		Button saveButton = IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save");
		saveButton.click();
		Dialog messageDialog = Desktop.describe(Dialog.class, new DialogDescription.Builder().title("Message").build());
		Button oKButton = messageDialog.describe(Button.class, new ButtonDescription.Builder().label("OK").build());
		oKButton.click();
	}


}
