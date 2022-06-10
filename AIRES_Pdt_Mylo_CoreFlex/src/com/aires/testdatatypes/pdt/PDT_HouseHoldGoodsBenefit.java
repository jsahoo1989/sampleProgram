package com.aires.testdatatypes.pdt;

public class PDT_HouseHoldGoodsBenefit {
	public String benefitName;
	public USDomesticVanlineShipment usDomesticVanlineShipment;
	public AutoShipment autoShipment;
	public SelfMove selfMove;
	public AirShipment airShipment;
	public SeaShipment seaShipment;
	public NonUsInlandShipment nonUsInlandShipment;
	public PermanentStorage permStorage;
	public PetShipment petShipment;
	public DiscardDonate discardDonate;
	
	public class USDomesticVanlineShipment {
		public String noWeightCostCap;
		public String weightCapInPounds;
		public String costCapInUsd;
		public String authDaysInTempStorage;
		public String insuranceType;
		public String otherInsuranceType;
		public String excessValuationDueToValPaidBy;
		public String excessValuationDueToWeightPaidBy;
		public String otherExcessValPaidBy;
		public String otherExcessWeightPaidBy;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;	
	}
	public class AutoShipment {
		public String maxNumOfAutos;
		public String insuranceType;
		public String otherInsuranceType;
		public String shipDependOnOriginDest;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;	
		
	}
	public class SelfMove {
		public String maxAmount;
		public String currency;		
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;	
	}
	public class AirShipment {
		public String noWeightVolCap;
		public String weightCap;
		public String unitOfWeightCap;
		public String weightCapAppliesTo;
		public String volCap;
		public String unitOfVolCap;
		public String volCapAppliesTo;
		public String numOfEContainers;
		public String eContAppliesTo;
		public String numOfDContainers;
		public String dContAppliesTo;
		public String numOfLDNContainers;
		public String ldnContAppliesTo;
		public String authDaysInTempStorage;
		public String insuranceType;
		public String otherInsuranceType;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;	
	}
	public class SeaShipment {
		public String noWeightVolCap;
		public String weightCap;
		public String unitOfWeightCap;	
		public String volCap;
		public String unitOfVolCap;
		public String containerSizeTransferee;
		public String containerSizeTransfereePartner;
		public String containerSizeTransfereeFamily;
		public String authDaysInTempStorage;
		public String insuranceType;
		public String otherInsuranceType;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;	
	}
	public class NonUsInlandShipment {
		public String noWeightVolCap;
		public String weightCap;
		public String unitOfWeightCap;	
		public String volCap;
		public String unitOfVolCap;
		public String authDaysInTempStorage;
		public String insuranceType;
		public String otherInsuranceType;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;	
	}
	public class PermanentStorage {
		public String noWeightVolCap;
		public String weightCap;
		public String unitOfWeightCap;	
		public String volCap;
		public String unitOfVolCap;		
		public String insuranceType;
		public String otherInsuranceType;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;	
	}
	public class PetShipment {
		public String numberOfPets;
		public String maxAmount;
		public String currency;
		public String detail;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;	
	}
	public class DiscardDonate {
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;	
	}
	
}
