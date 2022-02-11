package com.aires.testdatatypes.pdt;

public class PDT_TemporaryLivingBenefit {
	public String benefitName;
	
	public TemporaryLivingLodging temporaryLivingLodging;
	public TemporaryLivingMeals temporaryLivingMeals;
	public TemporaryLivingTransportation temporaryLivingTransportation;
	public String comment;
	
	public class TemporaryLivingLodging {
		public String durationInDays;
		public String maxAmount;
		public String flatAmount;
		public String detail;
		public String currencyCode;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class TemporaryLivingMeals {
		public String durationInDays;
		public String type;
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
	
	public class TemporaryLivingTransportation {
		public String durationInDays;
		public String transportationType;
		public String transportationTypeOther;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
}
