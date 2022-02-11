package com.aires.testdatatypes.pdt;

public class PDT_HomeLeaveBenefit {
	public String benefitName;
	public HomeLeaveTransportation homeLeaveTransportation;
	public HomeLeaveLodging homeLeaveLodging;
	public HomeLeaveMeals homeLeaveMeals;
	public String comment;

	public class HomeLeaveTransportation {
		public String transferNumberOfTrips;
		public String assignmentNumberOfTrips;
		public String frequencyTrip;
		public String frequencyTripOther;
		public String transportationType;
		public String minMileageEconomyAir;
		public String minMileageBusinessAir;
		public String accompanyingFamilyMember;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class HomeLeaveLodging {
		public String durationInDays;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class HomeLeaveMeals {
		public String numberOfDaysPerMeal;
		public String type;
		public String maxAmount;
		public String maxAmtTransferee;
		public String maxAmtTransfereeDetail;
		public String maxAmtTransfereeCurrency;
		public String maxAmtAdult;
		public String maxAmtAdultDetail;
		public String maxAmtAdultCurrency;
		public String maxAmtChild;
		public String maxAmtChildDetail;
		public String maxAmtChildCurrency;		
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	

}
