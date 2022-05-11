package com.aires.testdatatypes.coreflex;

public class CoreFlex_SettlingInBenefitsData {

	public String benefitName;
	public LanguageTrainingEmployee languageTrainingEmployee;
	public LanguageTrainingFamily languageTrainingFamily;
	public BenefitDetails benefitDetails;
	
	public class LanguageTrainingEmployee{
		public String maxNumberOfHours;
		public String selfLearningTool;
		public String maxAmount;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}	
	public class LanguageTrainingFamily{
		public String maxNumberOfHoursPerPerson;
		public String maxNumberOfHoursPerFamily;
		public String selfLearningTool;
		public String maxAmount;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
	}
	
	public class BenefitDetails{
		public String benefitDisplayName;
		public String allowanceAmountMessage;
		public String benefitLongDescription;
		public String flexPoints;
		public String airesManagedService;
	}
}
