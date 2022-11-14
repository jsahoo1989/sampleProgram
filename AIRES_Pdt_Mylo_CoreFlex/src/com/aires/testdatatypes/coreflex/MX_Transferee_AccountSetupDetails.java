package com.aires.testdatatypes.coreflex;

public class MX_Transferee_AccountSetupDetails {
	public String module;
	public CheckAccountType checkAccountType;
	public WireTransferAccountType wireTransferAccountType;

	public class CheckAccountType {
		public String accountType;
		public String currency;
		public String accountHoldersName;
		public String address1;
		public String address2;
		public String city;
		public String state;
		public String province;
		public String postalCode;
		public String country;
		public String accountClosingDate;
	}

	public class WireTransferAccountType {
		public String accountType;
		public String currency;
		public String accountHoldersName;
		public String accountHolderDOB;
		public String bankName;
		public String bankAddress1;
		public String bankAddress2;
		public String bankCity;
		public String bankState;
		public String bankProvince;
		public String bankPostalCode;
		public String bankCountry;
		public String accountIBAN;
		public String swiftRouting;
		public String bankAccountClosingDate;
	}
}
