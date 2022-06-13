package com.aires.testdatatypes.coreflex;

import java.util.List;

public class CoreFlex_PolicySetupPagesData {

	public String application;
	public GeneralInformationPage generalInformationPage;
	public FlexPolicySetupPage flexPolicySetupPage;
	public CustomBundlesPage customBundlesPage;
	public PolicyBenefitsCategories policyBenefitsCategories;
	public TransfereeSubmissionsDetails transfereeSubmissionsDetails;
	public GeneralInformationPagePostVersioning generalInformationPagePostVersioning;
	
	public class GeneralInformationPage{
		public String policyType;
		public String employeeType;
		public String homeownerType;
		public String cappedPolicy;
	}	
	
	public class FlexPolicySetupPage{
		public String flexAllowanceType;
		public String lockTheBenefitsPointsSelection;
		public String benefitsExpirationTracingPrompt;
		public String benefitsExpirationDate;
		public String StaticFixedTotalPointsAvailable;
		public String customCashoutBenefitName;
		public String maxPortionCashoutPercent;
		public String pointExchangeRate;
	}	
	
	public class CustomBundlesPage{
		public String customBundleName;
	}
	
	public class TransfereeSubmissionsDetails{
		public String requestDialogComment;
	}
	
	public class PolicyBenefitsCategories{
		public List<String> benefitsCategories;
		public List<String> housingSelectableBenefits;
		public List<String> movingSelectableBenefits;
		public List<String> settlingInSelectableBenefits;
		public List<String> lifeStyleSelectableBenefits;
		public List<String> allowancesSelectableBenefits;
	}
	
	public class GeneralInformationPagePostVersioning{
		public String policyType;
		public String employeeType;
		public String homeownerType;
		public String cappedPolicy;
	}	
}
