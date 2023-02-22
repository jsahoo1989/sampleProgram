package com.aires.testdatatypes.pdt;

public class PDT_FinalMoveBenefit {
	public String benefitName;
	public FinalMoveTransportation finalMoveTransportation;
	public FinalMoveLodging finalMoveLodging;
	public FinalMoveMeals finalMoveMeals;
	public String comment;
	
	public class FinalMoveTransportation {		
		public String transportationType;		
		public String minMileageEconomyAir;
		public String minMileageBusinessAir;
		public String accompanyingFamilyMember;
		public String grossUp;
		public String excessBaggageFees;
		public String maxAmtPerPerson;
		public String currency;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class FinalMoveLodging {		
		public String duration;		
		public String numberOfNights;
		public String maxAmount;
		public String flatAmountPerNight;
		public String currency;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class FinalMoveMeals {
		public String numberOfDaysPerMeal;
		public String numberOfDays;
		public String type;		
		public String maxAmount;
		public String maxAmtTransferee;
		public String maxAmtTransfereeDetail;
		public String maxAmtTransfereeCurrency;
		public String maxAmtAdult;
		public String maxAmtAdultDetail;
		public String maxAmtAdultCurrency;
		public String maxAmtChildren;
		public String maxAmtChildrenDetail;
		public String maxAmtChildrenCurrency;		
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
}
