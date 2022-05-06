package com.aires.testdatatypes.coreflex;

public class MX_Transferee_AccountSetupDetails {
	public String accountType;
	public String currency;
	public String accountHoldersName;
	public Address mailingAddress;

	public class Address {
		public String address1;
		public String address2;
		public String city;
		public String state;
		public String province;
		public String postalCode;
		public String country;
		public String accountClosingDate;
	}
}
