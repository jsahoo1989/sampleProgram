package com.aires.testdatatypes.coreflex;

public class CoreFlex_SettlingInBenefitsData {

	public String benefitName;
	public LanguageTrainingEmployee languageTrainingEmployee;
	public LanguageTrainingFamily languageTrainingFamily;
	public FlexBenefitDetails flexBenefitDetails;
	public CoreBenefitDetails coreBenefitDetails;
	
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
	
	public class FlexBenefitDetails{
		public String benefitDisplayName;
		public String allowanceAmountMessage;
		public String benefitLongDescription;
		public String flexPoints;
		public String airesManagedService;
		public String benefitCategory;
		public String multipleBenefitSelection;
		public int numberOfBenefitSelected;
	}
	
	public class CoreBenefitDetails{
		public String benefitDisplayName;
		public String allowanceAmountMessage;
		public String benefitLongDescription;
		public String benefitCategory;
	}
}
