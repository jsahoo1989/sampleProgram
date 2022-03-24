package com.aires.testdatatypes.pdt;

public class PDT_OneTimePaymentBenefit {
	public String benefitName;
	public MiscRelocationAllowance miscReloAllowance;
	public LumpSum lumpSum;
	public LeaseBreak leaseBreak;
	public ApplianceAllowance applAllowance;
	public AutoRegistrationCosts autoRegCost;
	public AutoLossOnSale autoLossOnSale;
	public OtherOneTimePayment otherOneTimePayment;
	
	public class MiscRelocationAllowance {
		public String calculationMethod;
		public String otherCalculationMethod;
		public String maxAmount;
		public String currency;
		public String frequency;
		public String whenToMakePayment;
		public String indicateNumOfWeeksBefore;
		public String otherNumOfWeeksBefore;
		public String otherPaymentTime;
		public String grossUp;		
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class LumpSum {
		public String calculationMethod;
		public String otherCalculationMethod;
		public String maxAmount;
		public String currency;
		public String frequency;
		public String otherFrequency;
		public String whenToMakePayment;
		public String indicateNumOfWeeksBefore;
		public String otherNumOfWeeksBefore;		
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class LeaseBreak {
		public String maxNumOfMonths;
		public String otherMaxNumOfMonths;
		public String maxAmount;
		public String currency;
		public String frequency;
		public String otherFrequency;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class ApplianceAllowance {
		public String maxAmount;
		public String currency;
		public String frequency; 
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class AutoRegistrationCosts {
		public String maxAmount;
		public String currency;
		public String frequency; 
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class AutoLossOnSale {
		public String maxNumOfAutos;
		public String otherMaxNumOfAutos;
		public String maxAmtPerAuto;
		public String currency;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class OtherOneTimePayment {
		public String paymentDesc;
		public String maxAmount;
		public String currency;
		public String frequency; 
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
}

