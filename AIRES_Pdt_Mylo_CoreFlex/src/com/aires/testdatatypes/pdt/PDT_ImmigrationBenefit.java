package com.aires.testdatatypes.pdt;

public class PDT_ImmigrationBenefit {
	public String benefitName;
	public ImmigrationFees immigrationFees;
	public ImmigrationTravel immigrationTravel;
	
	public class ImmigrationFees {
		public String authorizedFees;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;		
	}
	
	public class ImmigrationTravel {
		public String numberOfTrips;
		public String otherNumberOfTrips;
		public String accompanyingFamilyMembers;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
}
