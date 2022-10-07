package com.aires.testdatatypes.coreflex;

public class CoreFlex_MovingBenefitsData {

	public String benefitName;
	public FinalMoveTransportation finalMoveTransportation;
	public FinalMoveLodging finalMoveLodging;
	public FinalMoveMeals finalMoveMeals;
	public HomeLeaveTransportation homeLeaveTransportation;
	public HomeLeaveLodging homeLeaveLodging;
	public HomeLeaveRentalCar homeLeaveRentalCar;
	public HomeLeaveMeals homeLeaveMeals;
	public PermanentStorage permanentStorage;
	public AirShipment airShipment;
	public AutoShipment autoShipment;
	public SeaSurfaceShipment seaSurfaceShipment; 
	public PetShipment petShipment;
	public InlandShipment inlandShipment;

	public class FinalMoveTransportation {
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

	public class HomeLeaveTransportation {
		public String assignmentNumberOfTrips;
		public String frequencyTrip;
		public String frequencyTripOther;
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

	public class HomeLeaveLodging {
		public String durationDays;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}

	public class HomeLeaveRentalCar {
		public String durationDays;
		public String rentalCarSize;
		public String rentalCarSizeOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}

	public class HomeLeaveMeals {
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

	public class PermanentStorage {
		public String weightCap;
		public String unitOfWeightCap;
		public String volumeCap;
		public String unitOfVolumeCap;
		public String insuranceType;
		public String insuranceTypeOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}

	public class AirShipment {
		public String weightCap;
		public String unitOfWeightCap;
		public String volumeCap;
		public String unitOfVolumeCap;
		public String insuranceType;
		public String insuranceTypeOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
		public String weightCapAppliesTo;
		public String volCapAppliesTo;
		public String noOfEContainers;
		public String eContainerAppliesTo;
		public String noOfDContainers;
		public String dContainerAppliesTo;
		public String noOfLDNContainers;
		public String LDNContainerAppliesTo;
		public String canThisBenefitBeTradedForAnotherBenefit;
		public String excessValuationDueToWeightPaid;
		public String excessValuationDueToValuePaid;
		public String temporaryStorageDuration;
		public boolean discardAndDonate;
	}

	public class AutoShipment {
		public String maxNoOfAutos;
		public String grossUp;
		public String insuranceType;
		public String insuranceTypeOther;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}

	public class SeaSurfaceShipment {
		public String temporaryStorageDuration;
		public String grossUp;
		public String insuranceType;
		public String insuranceTypeOther;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}

	public class InlandShipment {
		public String temporaryStorageDuration;
		public String grossUp;
		public String insuranceType;
		public String insuranceTypeOther;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}

	public class PetShipment {
		public String noOfPets;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
}
