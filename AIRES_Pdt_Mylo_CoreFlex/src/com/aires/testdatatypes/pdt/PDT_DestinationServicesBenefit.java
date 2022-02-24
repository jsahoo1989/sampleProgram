package com.aires.testdatatypes.pdt;

public class PDT_DestinationServicesBenefit {
	public String benefitName;
	public AirPortPickup airPortPickup;
	public AreaTour areaTour;
	public AutoRentalDuringAssignment autoRentalDuringAssignment;
	public ConciergeServices conciergeServices;
	public DepartureServices departureServices;
	public FurnitureRental furnitureRental;
	public ReimbursementOfMemberShipDues reimbursementOfMemberShipDues;
	public SchoolSearch schoolSearch;
	public SettlingInServices settlingInServices;
	public TransitionAssistanceProgram transitionAssistanceProgram;
	public TutionAndEducation tutionAndEducation;
	public String comment;
	
	public class AirPortPickup {
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class AreaTour {
		public String durationInDays;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class AutoRentalDuringAssignment {
		public String carType;
		public String carTypeOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class ConciergeServices {
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class DepartureServices {
		public String numberOfDays;
		public String other;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class FurnitureRental {
		public String duration;
		public String durationOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class ReimbursementOfMemberShipDues {
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class SchoolSearch {
		public String durationInDays;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class SettlingInServices {
		public String durationInDays;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class TransitionAssistanceProgram {
		public String durationInDays;
		public String maxAmount;
		public String currency;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class TutionAndEducation {		
		public String maxAmount;
		public String currency;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
}
