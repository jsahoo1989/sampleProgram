package com.aires.testdatatypes.coreflex;

public class CoreFlex_SettlingInBenefitsData {

	public String benefitName;
	public LanguageTrainingEmployee languageTrainingEmployee;
	public LanguageTrainingFamily languageTrainingFamily;
	
	public class LanguageTrainingEmployee{
		public String maxNumberOfHours;
		public String selfLearningTool;
		public String maxAmount;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;
		public String flexPoints;
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
}
