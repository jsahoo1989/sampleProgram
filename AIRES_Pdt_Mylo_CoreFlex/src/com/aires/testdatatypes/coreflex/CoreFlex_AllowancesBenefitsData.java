package com.aires.testdatatypes.coreflex;

public class CoreFlex_AllowancesBenefitsData {

	public String benefitName;
	public LumpSum lumpSum;
	public AutoRentalDuringAssignment autoRentalDuringAssignment;
	public GoodsAndServicesAllowance goodsAndServicesAllowance;
	
	public class LumpSum{
		public String calculationMethod;
		public String grossUp;
		public String maxAmountIfApplicable;
		public String currency;
		public String frequency;
		public String whenToMakePayment;
		public String indicateNumberOfWeeksBeforeTransferDate;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class GoodsAndServicesAllowance{
		public String calculationMethod;
		public String grossUp;
		public String maxAmountIfApplicable;
		public String currency;
		public String frequency;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class AutoRentalDuringAssignment{	
		public String rentalCarType;
		public String rentalCarTypeOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
}
