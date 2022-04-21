package com.aires.testdatatypes.pdt;

public class PDT_HomePurchaseBenefit {
	public String benefitName;
	public HomePurchaseClosingCost homePurchaseClosingCost;
	public HomePurchasePoints homePurchasePoints;
	public HomePurchaseInspections homePurchaseInspections;
	public HomePurchaseBonus homePurchaseBonus;
	public MortgageDifferentials mortgDiff;
	public MortgageSubsidy mortgSubsidy;
	
	public class HomePurchaseClosingCost {
		public String directBillEligible;
		public String maxPercentHomePurPrice;
		public String closingCostCap;
		public String currency;
		public String grossUp;
		public String airesPreferredLenders;
		public String airesPreferredLendersOther;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comments;
	}
	
	public class HomePurchasePoints {
		public String maxPercentHomePurPrice;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comments;
	}
	
	public class HomePurchaseInspections {
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comments;
	}
	
	public class HomePurchaseBonus {
		public String maxAmount;
		public String currency;
		public String desirableCalculation;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comments;
	}
	
	public class MortgageDifferentials {
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comments;
	}
	
	public class MortgageSubsidy {
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comments;
	}
}
