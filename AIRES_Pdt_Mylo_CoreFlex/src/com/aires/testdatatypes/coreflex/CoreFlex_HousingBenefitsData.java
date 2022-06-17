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
	public HouseHuntingTripTransportation houseHuntingTripTransportation;
	public HouseHuntingTripLodging houseHuntingTripLodging;
	public HouseHuntingTripRentalCar houseHuntingTripRentalCar;
	public HouseHuntingTripMeals houseHuntingTripMeals;
	
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
	
	public class HouseHuntingTripTransportation{
		public String numberOfTrips;
		public String transportationType;
		public String minMilForEconomyAirTravel;
		public String minMilForBusinessAirTravel;
		public String minFlightTimeExclLayovers;
		public String accompanyingFamilyMember;
		public String excessBaggageFees;
		public String maxAmountPerPerson;		
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class HouseHuntingTripLodging{
		public String numberOfNightsPerTrip;
		public String maxAmountLodging;
		public String flatAmountPerNight;
		public String currencyLodging;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class HouseHuntingTripRentalCar{
		public String durationDays;		
		public String rentalCarSize;
		public String rentalCarSizeOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class HouseHuntingTripMeals{
		public String numberOfDaysForMeal;
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
