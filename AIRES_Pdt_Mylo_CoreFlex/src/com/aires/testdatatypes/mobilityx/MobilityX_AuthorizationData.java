package com.aires.testdatatypes.mobilityx;

public class MobilityX_AuthorizationData {
	public String module;
	public GlobalReloEmpIdentificationInfo globalReloEmpIdentificationInfo;
	public GlobalReloTransferInfo globalReloTransferInfo;
	public GlobalReloFinancialInfo globalReloFinancialInfo;
	public GlobalReloFamilyInfo globalReloFamilyInfo;
	public GlobalReloAuthorizationInfo globalReloAuthInfo;
	public DefaultAuthForm defaultAuthForm;
	
	public class GlobalReloEmpIdentificationInfo {
		public String employeeId;
		public String officePhone;
		public String email;
		public String gender;
		public String originCity;
		public String originCountry;
		public String destinationCountry;
		public String empCurrentlyOnAssignment;
		public String homeCountry;
		public String dualCitizenShip;
	}
	
	public class GlobalReloTransferInfo {
		public String receivingRegion;
		public String projectRelated;
		public String relocationPolicy;
		public String startDateInNewLocation;
		public String assignmentEndDate;
		public String businessGroup;
		public String jobFamily;
	}
	
	public class GlobalReloFinancialInfo {
		public String payRoll;
		public String rfgl;
		public String costCenter;
		public String tafCostCenter;
	}
	
	public class GlobalReloFamilyInfo {
		public String maritalStatus;
		public String greenCardHolder;
		public String isSpouseEmployed;
	}
	
	public class GlobalReloAuthorizationInfo {
		public String authorizedBy;
		public String homeMobilityPartner;
		public String levelOneManagerName;
		public String levelOneManagerEmail;
		public String levelOneManagerId;
		public String hrManagerName;
		public String hrManagerEmail;
		public String hrManagerId;
		public String sponsorName;
		public String sponsorEmail;
		public String sponsorId;
	}
	
	public class DefaultAuthForm{
		public String relocationPolicy;
		public String originCity;
		public String originCountry;
		public String destinationCity;
		public String destinationCountry;
		public String homeStatus;
		public String email;
	}
}
