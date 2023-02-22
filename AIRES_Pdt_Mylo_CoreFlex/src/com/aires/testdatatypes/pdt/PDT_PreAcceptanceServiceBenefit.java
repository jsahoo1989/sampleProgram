package com.aires.testdatatypes.pdt;

public class PDT_PreAcceptanceServiceBenefit {
	public String benefitName;
	public CandidateSelection candidateSelection;
	public PreAcceptanceTripTransportation preAcceptanceTripTransportation;
	public PreAcceptanceTripLodging preAcceptanceTripLodging;
	public PreAcceptanceTripMeals preAcceptanceTripMeals;
	public PreAcceptanceTripRentalCar preAcceptanceTripRentalCar;
	public String comment;
	
	public class CandidateSelection {
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class PreAcceptanceTripTransportation {
		public String numberOfTrips;
		public String transportationType;
		public String transportationTypeOther;
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
	
	public class PreAcceptanceTripLodging {
		public String numberOfNightsPerTrip;
		public String maxAmount;
		public String flatAmtPerNight;
		public String currencyCode;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class PreAcceptanceTripMeals {
		public String numberOfDaysPerMeal;
		public String mealTypeCode;
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
	
	public class PreAcceptanceTripRentalCar {
		public String duration;
		public String sizeClass;
		public String otherSizeClass;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
}
