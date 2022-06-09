package com.aires.testdatatypes.coreflex;

public class CoreFlex_HousingBenefitsData {

	public String benefitName;
	public DuplicateHousing duplicateHousing;
	public TemporaryLivingTransportation temporaryLivingTransportation;
	public TemporaryLivingLodging temporaryLivingLodging;
	public TemporaryLivingMeals temporaryLivingMeals;
	public HomePurchaseClosingCosts homePurchaseClosingCosts;
	public HomePurchasePoints homePurchasePoints;
	public HomePurchaseInspections homePurchaseInspections;
	
	public class DuplicateHousing{
		public String duration;
		public String durationOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class TemporaryLivingTransportation{
		public String duration;
		public String transportationType;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class TemporaryLivingLodging{
		public String duration;
		public String maxAmount;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class TemporaryLivingMeals{
		public String duration;
		public String type;
		public String maxAmount;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class HomePurchaseClosingCosts{
		public String directBillEligible;
		public String maxHomePurchasePrice;
		public String closingCostCap;
		public String currency;
		public String airesPrefferedLenders;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class HomePurchasePoints{		
		public String maxHomePurchasePrice;		
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class HomePurchaseInspections{				
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
}
