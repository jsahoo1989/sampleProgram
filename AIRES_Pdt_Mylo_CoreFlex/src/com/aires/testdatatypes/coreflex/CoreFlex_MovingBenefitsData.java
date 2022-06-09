package com.aires.testdatatypes.coreflex;

public class CoreFlex_MovingBenefitsData {

	public String benefitName;
	public FinalMoveTransportation finalMoveTransportation;
	public FinalMoveLodging finalMoveLodging;
	public FinalMoveMeals finalMoveMeals;
	
	public class FinalMoveTransportation{
		public String transportationType;
		public String minMilForEconomyAirTravel;
		public String minMilForBusinessAirTravel;
		public String minHrsForBusinessAirTravel;
		public String minFlightTimeExclLayovers;
		public String accompanyingFamilyMembers;
		public String excessBaggageFees;
		public String maxAmountPerPerson;		
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class FinalMoveLodging{
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
	
	public class FinalMoveMeals{
		public String numberOfDaysForMeal;
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
