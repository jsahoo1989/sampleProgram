package com.aires.testdatatypes.coreflex;

public class CoreFlex_SettlingInBenefitsData {

	public String benefitName;
	public LanguageTrainingEmployee languageTrainingEmployee;
	public LanguageTrainingFamily languageTrainingFamily;
	public CulturalTrainingEmployee culturalTrainingEmployee;
	public CulturalTrainingFamily culturalTrainingFamily;
	public ConciergeServices conciergeServices;
	public AreaTour areaTour;
	public AirportPickup airportPickup;
	public PreAcceptanceTripTransportation preAcceptanceTripTransportation;
	public PreAcceptanceTripLodging preAcceptanceTripLodging;
	public PreAcceptanceRentalCar preAcceptanceRentalCar;
	public PreAcceptanceTripMeals preAcceptanceTripMeals;
	public FurnitureRental furnitureRental;
	public EduAssistSchlSearch eduAssistSchlSearch;
	
	public class LanguageTrainingEmployee{
		public String maxNumberOfHours;
		public String selfLearningTool;
		public String maxAmount;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}	
	public class LanguageTrainingFamily{
		public String maxNumberOfHoursPerPerson;
		public String maxNumberOfHoursPerFamily;
		public String selfLearningTool;
		public String maxAmount;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class CulturalTrainingEmployee{
		public String employeeDuration;
		public String employeeOtherDuration;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class CulturalTrainingFamily{
		public String familyDuration;
		public String familyOtherDuration;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class ConciergeServices{
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class AreaTour{
		public String durationDays;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class AirportPickup{
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class PreAcceptanceTripTransportation{
		public String numberOfTrips;
		public String transportationType;
		public String distance;
		public String unitOfDistance;
		public String minFlightTimeExclLayovers;
		public String accompanyingFamilyMember;
		public String excessBaggageFees;
		public String maxAmountPerPerson;		
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class PreAcceptanceTripLodging{
		public String numberOfNightsPerTripLodging;		
		public String amountLodging;
		public String flatAmountPerNightLodging;
		public String currencyLodging;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class PreAcceptanceRentalCar{
		public String durationDaysRentalCar;		
		public String rentalCarSize;
		public String rentalCarSizeOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class PreAcceptanceTripMeals{
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
	
	public class FurnitureRental{
		public String duration;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class EduAssistSchlSearch{
		public String durationDays;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
}
