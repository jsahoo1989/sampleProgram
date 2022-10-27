package com.aires.testdatatypes.coreflex;

public class CoreFlex_LifestyleBenefitsData {

	public String benefitName;
	public ConciergeHomeCleaningServicesReimbursement conciergeHomeCleaningServicesReimbursement;
	public ChildCareServicesReimbursement childCareServicesReimbursement;
	
	public class ConciergeHomeCleaningServicesReimbursement{
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class ChildCareServicesReimbursement{	
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
}
