package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_HouseHoldGoodsBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_HouseHoldGoodsPage extends Base {
	public PDT_HouseHoldGoodsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//app-us-domenstic-vanline-shipment//input[@formcontrolname='usDomNoWeightCostCap']/parent::label")
	private WebElement _chkBoxNoWeighCostCap;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='usDomWeightCapInPounds']/preceding-sibling::label")
	private WebElement _lblWeightCapInPounds;

	@FindBy(how = How.CSS, using = "input[formcontrolname='usDomWeightCapInPounds']")
	private WebElement _txtBoxWeightCapInPounds;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='usDomMaxAmount']/preceding-sibling::label")
	private WebElement _lblCostCapInUsd;

	@FindBy(how = How.CSS, using = "input[formcontrolname='usDomMaxAmount']")
	private WebElement _txtBoxCostCapInUsd;

	@FindBy(how = How.CSS, using = "input[formcontrolname='usDomNoOfDaysInTempStorage']")
	private WebElement _txtBoxAuthorizedDaysInTempStorage;

	@FindBy(how = How.XPATH, using = "//app-us-domenstic-vanline-shipment//input[@formcontrolname='insuranceType']/parent::label")
	private List<WebElement> _radioBtnInsuranceType;

	@FindBy(how = How.CSS, using = "app-us-domenstic-vanline-shipment input[formcontrolname='insuranceTypeOther']")
	private WebElement _txtBoxInsuranceTypeOtherUsDomestic;

	@FindBy(how = How.XPATH, using = "//app-us-domenstic-vanline-shipment//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnVanlineGrossUp;

	@FindBy(how = How.XPATH, using = "//app-us-domenstic-vanline-shipment//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnVanlineReimbursedBy;

	@FindBy(how = How.CSS, using = "app-us-domenstic-vanline-shipment input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherVanline;

	@FindBy(how = How.CSS, using = "app-us-domenstic-vanline-shipment textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForVanline;

	// US Domestic Valuation/Insurance
	@FindBy(how = How.XPATH, using = "//app-household-goods-insurance//input[@formcontrolname='excessValuePaidBy']/parent::label/parent::div/preceding-sibling::label")
	private WebElement _lblExcessValPaidBy;

	@FindBy(how = How.XPATH, using = "//app-household-goods-insurance//input[@formcontrolname='excessValuePaidBy']/parent::label")
	private List<WebElement> _radioBtnExcessValPaidBy;

	@FindBy(how = How.XPATH, using = "//app-household-goods-insurance//input[@formcontrolname='excessWeightPaidBy']/parent::label/parent::div/preceding-sibling::label")
	private WebElement _lblExcessWeightPaidBy;

	@FindBy(how = How.XPATH, using = "//app-household-goods-insurance//input[@formcontrolname='excessWeightPaidBy']/parent::label")
	private List<WebElement> _radioBtnExcessWeighyPaidBy;

	// Auto Shipment
	@FindBy(how = How.XPATH, using = "//app-auto-shipment//input[@formcontrolname='maxNoOfAutos']/parent::div/preceding-sibling::label")
	private WebElement _lblMaxNumOfAutos;

	@FindBy(how = How.CSS, using = "app-auto-shipment input[formcontrolname='maxNoOfAutos']")
	private WebElement _txtBoxMaxNumOfAutos;

	@FindBy(how = How.XPATH, using = "//app-auto-shipment//input[@formcontrolname='insuranceType']/parent::label")
	private List<WebElement> _radioBtnInsuranceTypeForAutoShipment;

	@FindBy(how = How.CSS, using = "app-auto-shipment input[formcontrolname='insuranceTypeOther']")
	private WebElement _txtBoxInsuranceTypeOther;

	@FindBy(how = How.XPATH, using = "//app-auto-shipment//input[@formcontrolname='dependentOnDistance']/parent::label/parent::div/preceding-sibling::label")
	private WebElement _lblShipmentDependent;

	@FindBy(how = How.XPATH, using = "//app-auto-shipment//input[@formcontrolname='dependentOnDistance']/parent::label")
	private List<WebElement> _radioShipmentDependent;

	@FindBy(how = How.XPATH, using = "//app-auto-shipment//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnGrossUp;

	@FindBy(how = How.XPATH, using = "//app-auto-shipment//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnReimbursedBy;

	@FindBy(how = How.CSS, using = "app-auto-shipment input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-auto-shipment textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaBenefitComment;

	// Self Move
	@FindBy(how = How.CSS, using = "app-self-move input[formcontrolname='selfMaxAmount']")
	private WebElement _txtBoxMaxAmount;

	@FindBy(how = How.XPATH, using = "//app-self-move//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnGrossUpSelfMove;

	@FindBy(how = How.XPATH, using = "//app-self-move//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnReimbursedBySelfMove;

	@FindBy(how = How.CSS, using = "app-self-move input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherSelfMove;

	@FindBy(how = How.CSS, using = "app-self-move textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaBenefitCommentSelfMove;

	@FindBy(how = How.CSS, using = "app-self-move ng-select[formcontrolname='selfCurrency']")
	private WebElement _drpDownCurrency;

	@FindBy(how = How.CSS, using = "app-self-move ng-select[formcontrolname='selfCurrency'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-self-move ng-select[formcontrolname='selfCurrency'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionSelected;

	// Air Shipment
	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airNowVolCostCapOrContLimit']//parent::label")
	private WebElement _chkBoxAirShipWeighVolCap;

	@FindBy(how = How.CSS, using = "app-air-shipment input[formcontrolname='airWeightCap']")
	private WebElement _txtBoxAirShipWeightCap;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airNoUnitOfWeightCap']/parent::label")
	private List<WebElement> _radioBtnAirUnitOfWeightCap;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airWeightCapAppliesTo']/ancestor::div/preceding-sibling::label")
	private WebElement _lblAirWeightCapAppliesTo;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airWeightCapAppliesTo']/parent::label")
	private List<WebElement> _radioBtnAirWeightCapAppliesTo;

	@FindBy(how = How.CSS, using = "app-air-shipment input[formcontrolname='airVolumeCap']")
	private WebElement _txtBoxAirVolumeCap;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airUnitOfVolumeCap']/parent::label")
	private List<WebElement> _radioBtnAirUnitOfVolumeCap;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airVolumeCapAppliesTo']/ancestor::div/preceding-sibling::label")
	private WebElement _lblAirVolumeCapAppliesTo;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airVolumeCapAppliesTo']/parent::label")
	private List<WebElement> _radioBtnAirVolumeCapAppliesTo;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airNoOfEContainers']/preceding-sibling::label")
	private WebElement _lblAirNoOfEContainers;

	@FindBy(how = How.CSS, using = "app-air-shipment input[formcontrolname='airNoOfEContainers']")
	private WebElement _txtBoxAirNoOfEContainers;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airEContainerAppliesTo']/ancestor::div/preceding-sibling::label")
	private WebElement _lblAirEContainerAppliesTo;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airEContainerAppliesTo']/parent::label")
	private List<WebElement> _radioBtnAirEContainerAppliesTo;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airNoOfDContainers']/preceding-sibling::label")
	private WebElement _lblAirNoOfDContainers;

	@FindBy(how = How.CSS, using = "app-air-shipment input[formcontrolname='airNoOfDContainers']")
	private WebElement _txtBoxAirNoOfDContainers;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airDContainerAppliesTo']/ancestor::div/preceding-sibling::label")
	private WebElement _lblAirDContainerAppliesTo;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airDContainerAppliesTo']/parent::label")
	private List<WebElement> _radioBtnAirDContainerAppliesTo;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airNoOfLDNContainers']/preceding-sibling::label")
	private WebElement _lblAirNoOfLDNContainers;

	@FindBy(how = How.CSS, using = "app-air-shipment input[formcontrolname='airNoOfLDNContainers']")
	private WebElement _txtBoxAirNoOfLDNContainers;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airLdnContainerAppliesTo']/ancestor::div/preceding-sibling::label")
	private WebElement _lblAirLDNContainerAppliesTo;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='airLdnContainerAppliesTo']/parent::label")
	private List<WebElement> _radioBtnAirLDNContainerAppliesTo;

	@FindBy(how = How.CSS, using = "app-air-shipment input[formcontrolname='airNoOfDaysInTempStorage']")
	private WebElement _txtBoxAirAuthDaysInTempStorage;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='insuranceType']/parent::label")
	private List<WebElement> _radioBtnAirInsuranceType;

	@FindBy(how = How.CSS, using = "app-air-shipment input[formcontrolname='insuranceTypeOther']")
	private WebElement _txtBoxAirInsTypeOther;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnAirGrossUp;

	@FindBy(how = How.XPATH, using = "//app-air-shipment//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnAirReimbursedBy;

	@FindBy(how = How.CSS, using = "app-air-shipment input[formcontrolname='paidByOther']")
	private WebElement _txtBoxAirReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-air-shipment textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaAirBenefitComment;

	// Sea Shipment
	@FindBy(how = How.XPATH, using = "//app-sea-shipment//input[@formcontrolname='seaNowVolCostCapOrContLimit']/parent::label")
	private WebElement _chkBoxSeaShipWeighVolCap;

	@FindBy(how = How.CSS, using = "app-sea-shipment input[formcontrolname='seaWeightCap']")
	private WebElement _txtBoxSeaShipWeightCap;

	@FindBy(how = How.CSS, using = "app-sea-shipment input[formcontrolname='seaVolumeCap']")
	private WebElement _txtBoxSeaVolumeCap;

	@FindBy(how = How.XPATH, using = "//app-sea-shipment//input[@formcontrolname='seaUnitOfWeightCap']/parent::label")
	private List<WebElement> _radioBtnSeaUnitOfWeightCap;

	@FindBy(how = How.XPATH, using = "//app-sea-shipment//input[@formcontrolname='seaUnitOfVolumeCap']/parent::label")
	private List<WebElement> _radioBtnSeaUnitOfVolCap;

	@FindBy(how = How.XPATH, using = "//app-sea-shipment//input[@formcontrolname='seaNoOfDaysInTempStorage']/preceding-sibling::label")
	private List<WebElement> _lblSeaAuthDaysInTempStorage;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='seaContainerSizeTransfereeOnly']/preceding-sibling::label")
	private WebElement _lblContTransferee;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='seaContainerSizeTransfereeOnly']")
	private WebElement _drpDownContTransferee;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='seaContainerSizeTransfereeOnly'] span.ng-option-label")
	private List<WebElement> _drpDownContTransfereeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='seaContainerSizeTransfereeOnly'] span.ng-value-label")
	private WebElement _drpDownContTransfereeOptionSelected;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='seaContainerSizeTransfereePartner']/preceding-sibling::label")
	private WebElement _lblContTransfereePartner;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='seaContainerSizeTransfereePartner']")
	private WebElement _drpDownContTransfereePartner;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='seaContainerSizeTransfereePartner'] span.ng-option-label")
	private List<WebElement> _drpDownContTransfereePartnerOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='seaContainerSizeTransfereePartner'] span.ng-value-label")
	private WebElement _drpDownContTransfereePartnerOptionSelected;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='seaContainerSizeTransfereeFamily']/preceding-sibling::label")
	private WebElement _lblContTransfereeFamily;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='seaContainerSizeTransfereeFamily']")
	private WebElement _drpDownContTransfereeFamily;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='seaContainerSizeTransfereeFamily'] span.ng-option-label")
	private List<WebElement> _drpDownContTransfereeFamilyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='seaContainerSizeTransfereeFamily'] span.ng-value-label")
	private WebElement _drpDownContTransfereeFamilyOptionSelected;

	@FindBy(how = How.CSS, using = "app-sea-shipment input[formcontrolname='seaNoOfDaysInTempStorage']")
	private WebElement _txtBoxSeaAuthDaysInTempStorage;

	@FindBy(how = How.XPATH, using = "//app-sea-shipment//input[@formcontrolname='insuranceType']/parent::label")
	private List<WebElement> _radioBtnSeaInsuranceType;

	@FindBy(how = How.CSS, using = "app-sea-shipment input[formcontrolname='insuranceTypeOther']")
	private WebElement _txtBoxSeaInsuranceTypeOther;

	@FindBy(how = How.XPATH, using = "//app-sea-shipment//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnSeaGrossUp;

	@FindBy(how = How.XPATH, using = "//app-sea-shipment//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnSeaReimbursedBy;

	@FindBy(how = How.CSS, using = "app-sea-shipment input[formcontrolname='paidByOther']")
	private WebElement _txtBoxSeaReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-sea-shipment textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaSeaBenefitComment;

	// Non-Us Inland Shipment
	@FindBy(how = How.XPATH, using = "//app-non-us-inland-shipment//input[@formcontrolname='nonUsNoWeightVolumeCap']/parent::label")
	private WebElement _chkBoxNoNonUsWeighVolCap;

	@FindBy(how = How.CSS, using = "app-non-us-inland-shipment input[formcontrolname='nonUsWeightCap']")
	private WebElement _txtBoxNonUsWeightCap;

	@FindBy(how = How.CSS, using = "app-non-us-inland-shipment input[formcontrolname='nonUsVolumeCap']")
	private WebElement _txtBoxNonUsVolumeCap;

	@FindBy(how = How.XPATH, using = "//app-non-us-inland-shipment//input[@formcontrolname='nonUsUnitOfWeightCap']/parent::label")
	private List<WebElement> _radioBtnNonUsUnitOfWeightCap;

	@FindBy(how = How.XPATH, using = "//app-non-us-inland-shipment//input[@formcontrolname='nonUsUnitOfVolumeCap']/parent::label")
	private List<WebElement> _radioBtnNonUsUnitOfVolCap;

	@FindBy(how = How.XPATH, using = "//app-non-us-inland-shipment//input[@formcontrolname='insuranceType']/parent::label")
	private List<WebElement> _radioBtnNonusInsuranceType;

	@FindBy(how = How.CSS, using = "app-non-us-inland-shipment input[formcontrolname='insuranceTypeOther']")
	private WebElement _txtBoxNonUsInsuranceTypeOther;

	@FindBy(how = How.XPATH, using = "//app-non-us-inland-shipment//input[@formcontrolname='nonUsNoOfDaysInTempStorage']/preceding-sibling::label")
	private List<WebElement> _lblAuthDaysInTempStorage;

	@FindBy(how = How.CSS, using = "app-non-us-inland-shipment input[formcontrolname='nonUsNoOfDaysInTempStorage']")
	private WebElement _txtBoxAuthDaysInTempStorage;

	@FindBy(how = How.XPATH, using = "//app-non-us-inland-shipment//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnNonUsGrossUp;

	@FindBy(how = How.XPATH, using = "//app-non-us-inland-shipment//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnNonUsReimbursedBy;

	@FindBy(how = How.CSS, using = "app-non-us-inland-shipment input[formcontrolname='paidByOther']")
	private WebElement _txtBoxNonUsReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-non-us-inland-shipment textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaNonUsBenefitComment;

	// Permanent Storage
	@FindBy(how = How.XPATH, using = "//app-permanant-storage//input[@formcontrolname='permNoWeightVolCap']/parent::label")
	private WebElement _chkBoxNoWeighVolCap;

	@FindBy(how = How.CSS, using = "app-permanant-storage input[formcontrolname='permWeightCap']")
	private WebElement _txtBoxPermWeightCap;

	@FindBy(how = How.CSS, using = "app-permanant-storage input[formcontrolname='permVolumeCap']")
	private WebElement _txtBoxPermVolumeCap;

	@FindBy(how = How.XPATH, using = "//app-permanant-storage//input[@formcontrolname='permUnitOfWeightCap']/parent::label")
	private List<WebElement> _radioBtnPermUnitOfWeightCap;

	@FindBy(how = How.XPATH, using = "//app-permanant-storage//input[@formcontrolname='permUnitOfVolumeCap']/parent::label")
	private List<WebElement> _radioBtnPermUnitOfVolCap;

	@FindBy(how = How.XPATH, using = "//app-permanant-storage//input[@formcontrolname='insuranceType']/parent::label")
	private List<WebElement> _radioBtnPermInsuranceType;

	@FindBy(how = How.CSS, using = "app-permanant-storage input[formcontrolname='insuranceTypeOther']")
	private WebElement _txtBoxPermInsuranceTypeOther;

	@FindBy(how = How.XPATH, using = "//app-permanant-storage//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnGrossUpPermStorage;

	@FindBy(how = How.XPATH, using = "//app-permanant-storage//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnReimbursedByPermStorage;

	@FindBy(how = How.CSS, using = "app-permanant-storage input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherPermStorage;

	@FindBy(how = How.CSS, using = "app-permanant-storage textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaBenefitCommentPermStorage;

	// Pet Shipment
	@FindBy(how = How.XPATH, using = "//app-pet-shipment//input[@formcontrolname='petNoOfPets']/preceding-sibling::label")
	private WebElement _lblNumOfPets;

	@FindBy(how = How.CSS, using = "app-pet-shipment input[formcontrolname='petNoOfPets']")
	private WebElement _txtBoxNumOfPets;

	@FindBy(how = How.CSS, using = "app-pet-shipment input[formcontrolname='petMaxAmount']")
	private WebElement _txtBoxMaxAmountPetShipment;

	@FindBy(how = How.CSS, using = "app-pet-shipment ng-select[formcontrolname='petCurrency']")
	private WebElement _drpDownCurrencyPetShip;

	@FindBy(how = How.CSS, using = "app-pet-shipment ng-select[formcontrolname='petCurrency'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyOptionsPetShip;

	@FindBy(how = How.CSS, using = "app-pet-shipment ng-select[formcontrolname='petCurrency'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionSelectedPetShip;

	@FindBy(how = How.XPATH, using = "//app-pet-shipment//input[@formcontrolname='petDetail']/parent::label")
	private List<WebElement> _radioBtnDetail;

	@FindBy(how = How.XPATH, using = "//app-pet-shipment//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnGrossUpPetShipment;

	@FindBy(how = How.XPATH, using = "//app-pet-shipment//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnReimbursedByPetShipment;

	@FindBy(how = How.CSS, using = "app-pet-shipment input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherPetShipment;

	@FindBy(how = How.CSS, using = "app-pet-shipment textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaBenefitCommentPetShipment;

	// DiscardAndDonate
	@FindBy(how = How.XPATH, using = "//app-discard-and-donate//input[@formcontrolname='grossedUpInd']/parent::label")
	private List<WebElement> _radioBtnGrossUpDiscardDonate;

	@FindBy(how = How.XPATH, using = "//app-discard-and-donate//input[@formcontrolname='paidByCode']/parent::label")
	private List<WebElement> _radioBtnReimbursedByDiscardDonate;

	@FindBy(how = How.CSS, using = "app-discard-and-donate input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherDiscardDonate;

	@FindBy(how = How.CSS, using = "app-discard-and-donate textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaBenefitCommentDiscardDonate;

	@FindBy(how = How.CSS, using = "app-us-domenstic-vanline-shipment input[type=text]")
	private List<WebElement> _txtBoxUSDomVanlineWeightCostCap;
	
	@FindBy(how = How.CSS, using = "app-air-shipment input[type='number']")
	private List<WebElement> _txtBoxAirShipWtVolContainer;
	
	@FindBy(how = How.CSS, using = "app-sea-shipment input[type='number']")
	private List<WebElement> _txtBoxSeaShipWtVolContainer;
	
	@FindBy(how = How.CSS, using = "app-non-us-inland-shipment input[type='number']")
	private List<WebElement> _txtBoxNonUsWtVolContainer;
	
	@FindBy(how = How.CSS, using = "app-permanant-storage input[type='number']")
	private List<WebElement> _txtBoxPermStorageWtVolContainer;

	LinkedHashMap<WebElement, String> seaWeightVolTxtBoxFieldsMap = new LinkedHashMap<WebElement, String>();
	LinkedHashMap<WebElement, String> airWeightVolTxtBoxFieldsMap = new LinkedHashMap<WebElement, String>();
	LinkedHashMap<WebElement, String> nonUsInlandWeightVolTxtBoxFieldsMap = new LinkedHashMap<WebElement, String>();
	LinkedHashMap<WebElement, String> permStorWeightVolTxtBoxFieldsMap = new LinkedHashMap<WebElement, String>();
	
	LinkedHashMap<List<WebElement>, String> seaWeightVolRadioBtnFieldsMap = new LinkedHashMap<List<WebElement>, String>();	
	LinkedHashMap<List<WebElement>, String> airWeightVolRadioBtnFieldsMap  = new LinkedHashMap<List<WebElement>, String>();
	LinkedHashMap<List<WebElement>, String> nonUsInlandWeightVolRadioBtnFieldsMap  = new LinkedHashMap<List<WebElement>, String>();
	LinkedHashMap<List<WebElement>, String> permStorWeightVolRadioBtnFieldsMap  = new LinkedHashMap<List<WebElement>, String>();

	private String contSizeTransferee, contSizeTransfereePartner, contSizeTransfereeFamily;
	PDT_HouseHoldGoodsBenefit houseHoldGoodsBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getHouseHoldGoodsDataList("Household Goods");

	public void setContSizeTransferee(String contSize) {
		contSizeTransferee = contSize;
	}

	public String getContSizeTransferee() {
		return contSizeTransferee;
	}

	public void setContSizeTransfereePartner(String contSize) {
		contSizeTransfereePartner = contSize;
	}

	public String getContSizeTransfereePartner() {
		return contSizeTransfereePartner;
	}

	public void setContSizeTransfereeFamily(String contSize) {
		contSizeTransfereeFamily = contSize;
	}

	public String getContSizeTransfereeFamily() {
		return contSizeTransfereeFamily;
	}

	public void populateAirShipHashMap() {
		airWeightVolTxtBoxFieldsMap.put(_txtBoxAirShipWeightCap, PDTConstants.WEIGHT_CAP);
		airWeightVolTxtBoxFieldsMap.put(_txtBoxAirVolumeCap, PDTConstants.VOLUME_CAP);
		airWeightVolTxtBoxFieldsMap.put(_txtBoxAirNoOfEContainers, _lblAirNoOfEContainers.getText());
		airWeightVolTxtBoxFieldsMap.put(_txtBoxAirNoOfDContainers, _lblAirNoOfDContainers.getText());
		airWeightVolTxtBoxFieldsMap.put(_txtBoxAirNoOfLDNContainers, _txtBoxAirNoOfLDNContainers.getText());
		airWeightVolRadioBtnFieldsMap.put(_radioBtnAirUnitOfWeightCap, PDTConstants.UNIT_OF_WT_CAP);
		airWeightVolRadioBtnFieldsMap.put(_radioBtnAirWeightCapAppliesTo, _lblAirWeightCapAppliesTo.getText());
		airWeightVolRadioBtnFieldsMap.put(_radioBtnAirUnitOfVolumeCap, PDTConstants.UNIT_OF_VOL_CAP);
		airWeightVolRadioBtnFieldsMap.put(_radioBtnAirVolumeCapAppliesTo, _lblAirVolumeCapAppliesTo.getText());
		airWeightVolRadioBtnFieldsMap.put(_radioBtnAirEContainerAppliesTo, _lblAirEContainerAppliesTo.getText());
		airWeightVolRadioBtnFieldsMap.put(_radioBtnAirDContainerAppliesTo, _lblAirDContainerAppliesTo.getText());
		airWeightVolRadioBtnFieldsMap.put(_radioBtnAirLDNContainerAppliesTo, _lblAirLDNContainerAppliesTo.getText());
	}

	public void populateSeaShipHashMap() {
		seaWeightVolTxtBoxFieldsMap.put(_txtBoxSeaShipWeightCap, PDTConstants.WEIGHT_CAP);
		seaWeightVolTxtBoxFieldsMap.put(_txtBoxSeaVolumeCap, PDTConstants.VOLUME_CAP);
		seaWeightVolRadioBtnFieldsMap.put(_radioBtnSeaUnitOfWeightCap, PDTConstants.UNIT_OF_WT_CAP);
		seaWeightVolRadioBtnFieldsMap.put(_radioBtnSeaUnitOfVolCap, PDTConstants.UNIT_OF_VOL_CAP);
	}

	public void populateNonUsInlandHashMap() {
		nonUsInlandWeightVolTxtBoxFieldsMap.put(_txtBoxNonUsWeightCap, PDTConstants.WEIGHT_CAP);
		nonUsInlandWeightVolTxtBoxFieldsMap.put(_txtBoxNonUsVolumeCap, PDTConstants.VOLUME_CAP);
		nonUsInlandWeightVolRadioBtnFieldsMap.put(_radioBtnNonUsUnitOfWeightCap, PDTConstants.UNIT_OF_WT_CAP);
		nonUsInlandWeightVolRadioBtnFieldsMap.put(_radioBtnNonUsUnitOfVolCap, PDTConstants.UNIT_OF_VOL_CAP);
	}

	public void populatePermStorageHashMap() {
		permStorWeightVolTxtBoxFieldsMap.put(_txtBoxPermWeightCap, PDTConstants.WEIGHT_CAP);
		permStorWeightVolTxtBoxFieldsMap.put(_txtBoxPermVolumeCap, PDTConstants.VOLUME_CAP);
		permStorWeightVolRadioBtnFieldsMap.put(_radioBtnPermUnitOfWeightCap, PDTConstants.UNIT_OF_WT_CAP);
		permStorWeightVolRadioBtnFieldsMap.put(_radioBtnPermUnitOfVolCap, PDTConstants.UNIT_OF_VOL_CAP);
	}

	public boolean verifyElementExistAndVisible(WebElement element, String lblElement, String subBenefitFormName) {
		if (CoreFunctions.isElementExist(driver, element, 1)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_DISPLAYED, CoreConstants.PASS, lblElement, subBenefitFormName));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_HIDDEN, CoreConstants.PASS, lblElement, subBenefitFormName));
			return false;
		}
	}

	public boolean verifyElementListExistAndVisible(List<WebElement> element, String lblElement, String subBenefitFormName) {		
		if(element.size() > 0) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_DISPLAYED, CoreConstants.PASS, lblElement, subBenefitFormName));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ELEMENT_HIDDEN, CoreConstants.PASS, lblElement, subBenefitFormName));
			return false;
		}
	}

	public void verifyWeightVolFieldDisplayStatus(LinkedHashMap<WebElement, String> txtBoxWtVolCapMap,
			LinkedHashMap<List<WebElement>, String> radioBtnUnitOfWtVolMap, boolean chkFieldDisplayStatus, String subBenefitFormName) {
		List<Boolean> displayStatusWtVolTxtBox = new ArrayList<Boolean>();
		List<Boolean> displayStatusWtVolRadioField = new ArrayList<Boolean>();
		for (Map.Entry<WebElement, String> m : txtBoxWtVolCapMap.entrySet()) {			
			displayStatusWtVolTxtBox.add(verifyElementExistAndVisible(m.getKey(), m.getValue(), subBenefitFormName));
		}

		for (Map.Entry<List<WebElement>, String> m : radioBtnUnitOfWtVolMap.entrySet()) {
			displayStatusWtVolRadioField.add(verifyElementListExistAndVisible(m.getKey(), m.getValue(), subBenefitFormName));
		}

		if (chkFieldDisplayStatus)
			printFieldsVisibleStatusInReport(displayStatusWtVolTxtBox, displayStatusWtVolRadioField, subBenefitFormName);
		else
			printFieldsHiddenStatusInReport(displayStatusWtVolTxtBox, displayStatusWtVolRadioField, subBenefitFormName);

	}

	public void printFieldsHiddenStatusInReport(List<Boolean> statusWtVolTxtBoxFieldHidden,
			List<Boolean> statusWtVolRadioFieldHidden, String subBenefitFormName) {
		if (statusWtVolTxtBoxFieldHidden.stream().allMatch(t -> t.booleanValue() == false)
				&& statusWtVolRadioFieldHidden.stream().allMatch(t -> t.booleanValue() == false))
			Reporter.addStepLog(MessageFormat.format(PDTConstants.WT_VOL_FIELDS_HIDDEN, CoreConstants.PASS, subBenefitFormName));
		else
			Assert.fail(MessageFormat.format(PDTConstants.WT_VOL_FIELDS_NOT_HIDDEN, CoreConstants.FAIL, subBenefitFormName));
	}

	public void printFieldsVisibleStatusInReport(List<Boolean> statusWtVolTxtBoxFieldHidden,
			List<Boolean> statusWtVolRadioFieldHidden, String subBenefitFormName) {
		if (statusWtVolTxtBoxFieldHidden.stream().allMatch(t -> t.booleanValue() == true)
				&& statusWtVolRadioFieldHidden.stream().allMatch(t -> t.booleanValue() == true))
			Reporter.addStepLog(MessageFormat.format(PDTConstants.WT_VOL_FIELDS_DISPLAYED, CoreConstants.PASS, subBenefitFormName));
		else
			Assert.fail(MessageFormat.format(PDTConstants.WT_VOL_FIELDS_NOT_HIDDEN, CoreConstants.FAIL, subBenefitFormName));
	}

	public void fillUSDomesticForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _chkBoxNoWeighCostCap,
					_chkBoxNoWeighCostCap.getText());
			// Check the checkbox to hide the fields
			CoreFunctions.click(driver, _chkBoxNoWeighCostCap, _chkBoxNoWeighCostCap.getText());
			// verify WeightCap & CostCap fields are hidden.
			if (verifyElementExistAndVisible(_txtBoxWeightCapInPounds, PDTConstants.WEIGHT_CAP_IN_POUNDS, subBenefitFormName)
					&& verifyElementExistAndVisible(_txtBoxCostCapInUsd, PDTConstants.COST_CAP_IN_USD, subBenefitFormName)) {
				Assert.fail(MessageFormat.format(PDTConstants.WT_VOL_FIELDS_NOT_HIDDEN, CoreConstants.FAIL, subBenefitFormName));
			}
				
			// Check the checkbox to display the fields.
			CoreFunctions.click(driver, _chkBoxNoWeighCostCap, _chkBoxNoWeighCostCap.getText());
			// verify WeightCap & CostCap fields are displayed.
			if (!verifyElementExistAndVisible(_txtBoxWeightCapInPounds, PDTConstants.WEIGHT_CAP_IN_POUNDS, subBenefitFormName)
					&& !verifyElementExistAndVisible(_txtBoxCostCapInUsd, PDTConstants.COST_CAP_IN_USD, subBenefitFormName)) {
				Assert.fail(MessageFormat.format(PDTConstants.WT_VOL_FIELDS_HIDDEN, CoreConstants.FAIL, subBenefitFormName));
			}
			CoreFunctions.clearAndSetText(driver, _txtBoxWeightCapInPounds, PDTConstants.WEIGHT_CAP_IN_POUNDS,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.weightCapInPounds);
			CoreFunctions.clearAndSetText(driver, _txtBoxCostCapInUsd, PDTConstants.COST_CAP_IN_USD,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.costCapInUsd);
			CoreFunctions.clearAndSetText(driver, _txtBoxAuthorizedDaysInTempStorage,
					PDTConstants.AUTH_DAYS_TEMP_STORAGE_SIT,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.authDaysInTempStorage);

			CoreFunctions.selectItemInListByText(driver, _radioBtnInsuranceType,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.insuranceType, PDTConstants.INSURANCE_TYPE,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.insuranceType,
					_txtBoxInsuranceTypeOtherUsDomestic,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.otherInsuranceType, subBenefitFormName,
					PDTConstants.OTHER_INSURANCE_TYPE);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnVanlineGrossUp);
			CoreFunctions.selectItemInListByText(driver, _radioBtnVanlineGrossUp,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnVanlineReimbursedBy,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.reimbursedBy, _txtBoxReimbursedByOtherVanline,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForVanline, PDTConstants.COMMENT,
					houseHoldGoodsBenefitData.usDomesticVanlineShipment.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillAutoShipmentForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxMaxNumOfAutos,
					_txtBoxMaxNumOfAutos.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxNumOfAutos, _lblMaxNumOfAutos.getText(),
					houseHoldGoodsBenefitData.autoShipment.maxNumOfAutos);
			CoreFunctions.selectItemInListByText(driver, _radioBtnInsuranceTypeForAutoShipment,
					houseHoldGoodsBenefitData.autoShipment.insuranceType, PDTConstants.INSURANCE_TYPE,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.autoShipment.insuranceType, _txtBoxInsuranceTypeOther,
					houseHoldGoodsBenefitData.autoShipment.otherInsuranceType, subBenefitFormName,
					PDTConstants.OTHER_INSURANCE_TYPE);
			CoreFunctions.selectItemInListByText(driver, _radioShipmentDependent,
					houseHoldGoodsBenefitData.autoShipment.shipDependOnOriginDest, _lblShipmentDependent.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnGrossUp);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					houseHoldGoodsBenefitData.autoShipment.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnReimbursedBy,
					houseHoldGoodsBenefitData.autoShipment.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.autoShipment.reimbursedBy, _txtBoxReimbursedByOther,
					houseHoldGoodsBenefitData.autoShipment.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaBenefitComment, PDTConstants.COMMENT,
					houseHoldGoodsBenefitData.autoShipment.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillSelfMoveForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxMaxAmount, PDTConstants.MAX_AMOUNT);
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmount, PDTConstants.MAX_AMOUNT,
					houseHoldGoodsBenefitData.selfMove.maxAmount);
			CoreFunctions.clickElement(driver, _drpDownCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptions,
					houseHoldGoodsBenefitData.selfMove.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnGrossUpSelfMove);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUpSelfMove,
					houseHoldGoodsBenefitData.selfMove.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
					true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnReimbursedBySelfMove,
					houseHoldGoodsBenefitData.selfMove.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.selfMove.reimbursedBy, _txtBoxReimbursedByOtherSelfMove,
					houseHoldGoodsBenefitData.selfMove.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaBenefitCommentSelfMove, PDTConstants.COMMENT,
					houseHoldGoodsBenefitData.selfMove.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillAirShipmentForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			
			CoreFunctions.explicitWaitTillElementVisibility(driver, _chkBoxAirShipWeighVolCap,
					_chkBoxAirShipWeighVolCap.getText());
			populateAirShipHashMap();
			CoreFunctions.click(driver, _chkBoxAirShipWeighVolCap, _chkBoxAirShipWeighVolCap.getText());
			if(_txtBoxAirShipWtVolContainer.size() == 1)
				verifyWeightVolFieldDisplayStatus(airWeightVolTxtBoxFieldsMap, airWeightVolRadioBtnFieldsMap, false, subBenefitFormName);
			CoreFunctions.click(driver, _chkBoxAirShipWeighVolCap, _chkBoxAirShipWeighVolCap.getText());
			if(_txtBoxAirShipWtVolContainer.size() > 1)
				verifyWeightVolFieldDisplayStatus(airWeightVolTxtBoxFieldsMap, airWeightVolRadioBtnFieldsMap, true, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtBoxAirShipWeightCap, PDTConstants.WEIGHT_CAP,
					houseHoldGoodsBenefitData.airShipment.weightCap);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirUnitOfWeightCap,
					houseHoldGoodsBenefitData.airShipment.unitOfWeightCap, PDTConstants.UNIT_OF_WT_CAP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirWeightCapAppliesTo,
					houseHoldGoodsBenefitData.airShipment.weightCapAppliesTo, _lblAirWeightCapAppliesTo.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.clearAndSetText(driver, _txtBoxAirVolumeCap, PDTConstants.VOLUME_CAP,
					houseHoldGoodsBenefitData.airShipment.volCap);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirUnitOfVolumeCap,
					houseHoldGoodsBenefitData.airShipment.unitOfVolCap, PDTConstants.UNIT_OF_VOL_CAP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirVolumeCapAppliesTo,
					houseHoldGoodsBenefitData.airShipment.volCapAppliesTo, _lblAirVolumeCapAppliesTo.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.clearAndSetText(driver, _txtBoxAirNoOfEContainers, _lblAirNoOfEContainers.getText(),
					houseHoldGoodsBenefitData.airShipment.numOfEContainers);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirEContainerAppliesTo,
					houseHoldGoodsBenefitData.airShipment.eContAppliesTo, _lblAirEContainerAppliesTo.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.clearAndSetText(driver, _txtBoxAirNoOfDContainers, _lblAirNoOfDContainers.getText(),
					houseHoldGoodsBenefitData.airShipment.numOfDContainers);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirDContainerAppliesTo,
					houseHoldGoodsBenefitData.airShipment.dContAppliesTo, _lblAirDContainerAppliesTo.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.clearAndSetText(driver, _txtBoxAirNoOfLDNContainers, _lblAirNoOfLDNContainers.getText(),
					houseHoldGoodsBenefitData.airShipment.numOfLDNContainers);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirLDNContainerAppliesTo,
					houseHoldGoodsBenefitData.airShipment.ldnContAppliesTo, _lblAirLDNContainerAppliesTo.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.clearAndSetText(driver, _txtBoxAirAuthDaysInTempStorage,
					PDTConstants.AUTH_DAYS_TEMP_STORAGE_SIT,
					houseHoldGoodsBenefitData.airShipment.authDaysInTempStorage);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirInsuranceType,
					houseHoldGoodsBenefitData.airShipment.insuranceType, PDTConstants.INSURANCE_TYPE,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.airShipment.insuranceType, _txtBoxAirInsTypeOther,
					houseHoldGoodsBenefitData.airShipment.otherInsuranceType, subBenefitFormName,
					PDTConstants.OTHER_INSURANCE_TYPE);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnAirGrossUp);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirGrossUp,
					houseHoldGoodsBenefitData.airShipment.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirReimbursedBy,
					houseHoldGoodsBenefitData.airShipment.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.airShipment.reimbursedBy, _txtBoxAirReimbursedByOther,
					houseHoldGoodsBenefitData.airShipment.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaAirBenefitComment, PDTConstants.COMMENT,
					houseHoldGoodsBenefitData.airShipment.comment);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillSeaShipmentForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _chkBoxSeaShipWeighVolCap,
					_chkBoxSeaShipWeighVolCap.getText());

			populateSeaShipHashMap();
			CoreFunctions.click(driver, _chkBoxSeaShipWeighVolCap, _chkBoxSeaShipWeighVolCap.getText());
			if(_txtBoxSeaShipWtVolContainer.size()==1)
				verifyWeightVolFieldDisplayStatus(seaWeightVolTxtBoxFieldsMap, seaWeightVolRadioBtnFieldsMap, false, subBenefitFormName);
			CoreFunctions.click(driver, _chkBoxSeaShipWeighVolCap, _chkBoxSeaShipWeighVolCap.getText());
			if(_txtBoxSeaShipWtVolContainer.size() > 1)
				verifyWeightVolFieldDisplayStatus(seaWeightVolTxtBoxFieldsMap, seaWeightVolRadioBtnFieldsMap, true, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtBoxSeaShipWeightCap, PDTConstants.WEIGHT_CAP,
					houseHoldGoodsBenefitData.seaShipment.weightCap);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSeaUnitOfWeightCap,
					houseHoldGoodsBenefitData.seaShipment.unitOfWeightCap, PDTConstants.UNIT_OF_WT_CAP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.clearAndSetText(driver, _txtBoxSeaVolumeCap, PDTConstants.VOLUME_CAP,
					houseHoldGoodsBenefitData.seaShipment.volCap);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSeaUnitOfVolCap,
					houseHoldGoodsBenefitData.seaShipment.unitOfVolCap, PDTConstants.UNIT_OF_VOL_CAP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			String randContSizeTransferee = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownContTransferee, _drpDownContTransfereeOptions,
					_drpDownContTransfereeOptionSelected, _lblContTransferee.getText());
			setContSizeTransferee(randContSizeTransferee);
			String randContSizeTransfereePartner = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownContTransfereePartner,
					_drpDownContTransfereePartnerOptions, _drpDownContTransfereePartnerOptionSelected,
					_lblContTransfereePartner.getText());
			setContSizeTransfereePartner(randContSizeTransfereePartner);
			String randContSizeTransfereeFamily = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver,
					addNewPolicyPage, subBenefitFormName, _drpDownContTransfereeFamily,
					_drpDownContTransfereeFamilyOptions, _drpDownContTransfereeFamilyOptionSelected,
					_lblContTransfereeFamily.getText());
			setContSizeTransfereeFamily(randContSizeTransfereeFamily);
			CoreFunctions.clearAndSetText(driver, _txtBoxSeaAuthDaysInTempStorage,
					PDTConstants.AUTH_DAYS_TEMP_STORAGE_SIT,
					houseHoldGoodsBenefitData.seaShipment.authDaysInTempStorage);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSeaInsuranceType,
					houseHoldGoodsBenefitData.seaShipment.insuranceType, PDTConstants.INSURANCE_TYPE,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.seaShipment.insuranceType, _txtBoxSeaInsuranceTypeOther,
					houseHoldGoodsBenefitData.seaShipment.otherInsuranceType, subBenefitFormName,
					PDTConstants.OTHER_INSURANCE_TYPE);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnSeaGrossUp);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSeaGrossUp,
					houseHoldGoodsBenefitData.seaShipment.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSeaReimbursedBy,
					houseHoldGoodsBenefitData.seaShipment.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.seaShipment.reimbursedBy, _txtBoxSeaReimbursedByOther,
					houseHoldGoodsBenefitData.seaShipment.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaSeaBenefitComment, PDTConstants.COMMENT,
					houseHoldGoodsBenefitData.seaShipment.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillNonUsInlandShipmentForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _chkBoxNoNonUsWeighVolCap,
					_chkBoxNoNonUsWeighVolCap.getText());

			populateNonUsInlandHashMap();
			CoreFunctions.click(driver, _chkBoxNoNonUsWeighVolCap, _chkBoxNoNonUsWeighVolCap.getText());
			if(_txtBoxNonUsWtVolContainer.size() == 1)
				verifyWeightVolFieldDisplayStatus(nonUsInlandWeightVolTxtBoxFieldsMap,
					nonUsInlandWeightVolRadioBtnFieldsMap, false, subBenefitFormName);
			CoreFunctions.click(driver, _chkBoxNoNonUsWeighVolCap, _chkBoxNoNonUsWeighVolCap.getText());
			if(_txtBoxNonUsWtVolContainer.size() > 1)
				verifyWeightVolFieldDisplayStatus(nonUsInlandWeightVolTxtBoxFieldsMap,
					nonUsInlandWeightVolRadioBtnFieldsMap, true, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtBoxNonUsWeightCap, PDTConstants.WEIGHT_CAP,
					houseHoldGoodsBenefitData.nonUsInlandShipment.weightCap);
			CoreFunctions.selectItemInListByText(driver, _radioBtnNonUsUnitOfWeightCap,
					houseHoldGoodsBenefitData.nonUsInlandShipment.unitOfWeightCap, PDTConstants.UNIT_OF_WT_CAP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.clearAndSetText(driver, _txtBoxNonUsVolumeCap, PDTConstants.VOLUME_CAP,
					houseHoldGoodsBenefitData.nonUsInlandShipment.volCap);
			CoreFunctions.selectItemInListByText(driver, _radioBtnNonUsUnitOfVolCap,
					houseHoldGoodsBenefitData.nonUsInlandShipment.unitOfVolCap, PDTConstants.UNIT_OF_VOL_CAP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.clearAndSetText(driver, _txtBoxAuthDaysInTempStorage, PDTConstants.AUTH_DAYS_TEMP_STORAGE_SIT,
					houseHoldGoodsBenefitData.nonUsInlandShipment.authDaysInTempStorage);
			CoreFunctions.selectItemInListByText(driver, _radioBtnNonusInsuranceType,
					houseHoldGoodsBenefitData.nonUsInlandShipment.insuranceType, PDTConstants.INSURANCE_TYPE,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.nonUsInlandShipment.insuranceType, _txtBoxNonUsInsuranceTypeOther,
					houseHoldGoodsBenefitData.nonUsInlandShipment.insuranceType, subBenefitFormName,
					PDTConstants.OTHER_INSURANCE_TYPE);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnNonUsGrossUp);
			CoreFunctions.selectItemInListByText(driver, _radioBtnNonUsGrossUp,
					houseHoldGoodsBenefitData.nonUsInlandShipment.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnNonUsReimbursedBy,
					houseHoldGoodsBenefitData.nonUsInlandShipment.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.nonUsInlandShipment.reimbursedBy, _txtBoxNonUsReimbursedByOther,
					houseHoldGoodsBenefitData.nonUsInlandShipment.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaNonUsBenefitComment, PDTConstants.COMMENT,
					houseHoldGoodsBenefitData.nonUsInlandShipment.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillPermanentStorageForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _chkBoxNoWeighVolCap,
					_chkBoxNoWeighVolCap.getText());
			
			populatePermStorageHashMap();
			CoreFunctions.click(driver, _chkBoxNoWeighVolCap, _chkBoxNoWeighVolCap.getText());	
			if(_txtBoxPermStorageWtVolContainer.size() == 1)
				verifyWeightVolFieldDisplayStatus(permStorWeightVolTxtBoxFieldsMap, permStorWeightVolRadioBtnFieldsMap,
					false, subBenefitFormName);
			CoreFunctions.click(driver, _chkBoxNoWeighVolCap, _chkBoxNoWeighVolCap.getText());
			if(_txtBoxPermStorageWtVolContainer.size() > 1)
				verifyWeightVolFieldDisplayStatus(permStorWeightVolTxtBoxFieldsMap, permStorWeightVolRadioBtnFieldsMap,
					true, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtBoxPermWeightCap, PDTConstants.WEIGHT_CAP,
					houseHoldGoodsBenefitData.permStorage.weightCap);
			CoreFunctions.selectItemInListByText(driver, _radioBtnPermUnitOfWeightCap,
					houseHoldGoodsBenefitData.permStorage.unitOfWeightCap, PDTConstants.UNIT_OF_WT_CAP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.clearAndSetText(driver, _txtBoxPermVolumeCap, PDTConstants.VOLUME_CAP,
					houseHoldGoodsBenefitData.permStorage.volCap);
			CoreFunctions.selectItemInListByText(driver, _radioBtnPermUnitOfVolCap,
					houseHoldGoodsBenefitData.permStorage.unitOfVolCap, PDTConstants.UNIT_OF_VOL_CAP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnPermInsuranceType,
					houseHoldGoodsBenefitData.permStorage.insuranceType, PDTConstants.INSURANCE_TYPE,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage, houseHoldGoodsBenefitData.permStorage.insuranceType, _txtBoxPermInsuranceTypeOther,
					houseHoldGoodsBenefitData.permStorage.otherInsuranceType, subBenefitFormName, PDTConstants.OTHER_INSURANCE_TYPE);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnGrossUpPermStorage);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUpPermStorage,
					houseHoldGoodsBenefitData.permStorage.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnReimbursedByPermStorage,
					houseHoldGoodsBenefitData.permStorage.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.permStorage.reimbursedBy, _txtBoxReimbursedByOtherPermStorage,
					houseHoldGoodsBenefitData.permStorage.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaBenefitCommentPermStorage, PDTConstants.COMMENT,
					houseHoldGoodsBenefitData.permStorage.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillPetShipmentForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfPets, _lblNumOfPets.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfPets, _lblNumOfPets.getText(),
					houseHoldGoodsBenefitData.petShipment.numberOfPets);
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmountPetShipment, PDTConstants.MAX_AMOUNT,
					houseHoldGoodsBenefitData.petShipment.maxAmount);
			CoreFunctions.clickElement(driver, _drpDownCurrencyPetShip);
			CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptionsPetShip,
					houseHoldGoodsBenefitData.petShipment.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN,
					true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnDetail, houseHoldGoodsBenefitData.petShipment.detail,
					PDTConstants.DETAIL, PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnGrossUpPetShipment);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUpPetShipment,
					houseHoldGoodsBenefitData.petShipment.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnReimbursedByPetShipment,
					houseHoldGoodsBenefitData.petShipment.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.petShipment.reimbursedBy, _txtBoxReimbursedByOtherPetShipment,
					houseHoldGoodsBenefitData.petShipment.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaBenefitCommentPetShipment, PDTConstants.COMMENT,
					houseHoldGoodsBenefitData.petShipment.comment);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillDiscardDonateForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _radioBtnGrossUpDiscardDonate);
			//CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnGrossUpDiscardDonate);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUpDiscardDonate,
					houseHoldGoodsBenefitData.discardDonate.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnReimbursedByDiscardDonate,
					houseHoldGoodsBenefitData.discardDonate.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHoldGoodsBenefitData.discardDonate.reimbursedBy, _txtBoxReimbursedByOtherDiscardDonate,
					houseHoldGoodsBenefitData.discardDonate.reimbursedByOther, subBenefitFormName,
					PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaBenefitCommentDiscardDonate, PDTConstants.COMMENT,
					houseHoldGoodsBenefitData.discardDonate.comment);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}
}
