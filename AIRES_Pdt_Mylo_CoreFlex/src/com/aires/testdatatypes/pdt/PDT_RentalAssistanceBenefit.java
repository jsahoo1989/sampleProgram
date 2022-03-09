package com.aires.testdatatypes.pdt;

public class PDT_RentalAssistanceBenefit {
	public String benefitName;
	public RentalTour rentalTour;
	public FinderFees finderFees;
	
	public class RentalTour {
		public String duration;
		public String durationOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class FinderFees {
		public String maxAmount;
		public String currency;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}	
}
