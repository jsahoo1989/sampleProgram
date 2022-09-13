package com.aires.testdatatypes.coreflex;

public class MX_Client_Dashboard_BscData {

	public String module;
	public AuthTypeInfo authTypeInfo;
	public BscEmployeeInfo bscEmployeeInfo;
	public RelocationInfo relocationInfo;
	public ReportingInfo reportingInfo;
	public AuthorizationInfo authorisationInfo;
	public FlexBenefitInfo flexBenefitInfo;
	public PreDecisionBenefitInfo preDecisionBenefitInfo;

	public class AuthTypeInfo {

		public String assesment;
		public String airesInstruction;
		public String costEstimate;
		public String authTemplate;
	}

	public class BscEmployeeInfo {
		public String relocationPolicy;
		public String vipMove;
		public String immigrationServices;
		public String currentCity;
		public String currentState;
		public String currentcountry;
		public String destinationLoc;
		public String destinationCity;
		public String destinationProvince;
		public String destCountry;
		public String emailOne;
		public String homeStatus;
		public String originHomeAddress;
		public String originHomeCity;
		public String originHomeState;
		public String originHomeCountry;
		public String officeOriginCityState;
		public String destinationOfficeLocation;
		public String mobilePhone;	
		public String employeeID;
	}

	public class RelocationInfo {
		public String transferType;
		public String assignmentType;
		public String newSalary;
		public String newSalaryCurrency;
		public String jobTitle;
		public String excesBag;
		public String predecisionBenfit;
		public String startDateInNewLocation;
		public String newJobTitle;	
		public String immigration;
	}

	public class ReportingInfo {
		public String costCenter;
		public String glNumber;
		public String division;
		public String operatingUnit;
		public String companyCode;
		public String costRechargeBack;
		public String legalNameHomeCompany;
		public String legalNameHostCompany;
		public String payRollLoc;
		public String region;
		public String payrollLocation;
	}

	public class AuthorizationInfo {
		public String hrManagerName;
		public String hrManagerEmail;
		public String fundingMember;
		public String hiringManagerName;
		public String fundingECMember;
	}
	
	public class FlexBenefitInfo {
		public String homeFindingTrip;
		public String petShipment;
		public String propertyManagement;
		public String applianceAllowance;	
		public String initialTotalPoints;
		public String increasedTotalPoints;
		public String decreasedTotalPoints;
	}
	
	public class PreDecisionBenefitInfo {
		public String airesToInitiateImmigrationServices;		
	}
}
