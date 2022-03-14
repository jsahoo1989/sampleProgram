package com.aires.testdatatypes.pdt;

public class PDT_AssignmentHousingBenefit {
	public String benefitName;
	public AssignmentHousing assignmentHousing;
	public SecurityDeposit securityDeposit;
	public FinderFees finderFees;
	
	public class AssignmentHousing {
		public String maxAmount;
		public String detail;
		public String currency;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class SecurityDeposit {
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class FinderFees {
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
}
