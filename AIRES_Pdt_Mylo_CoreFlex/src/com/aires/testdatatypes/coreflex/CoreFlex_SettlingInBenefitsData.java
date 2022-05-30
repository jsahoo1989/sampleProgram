package com.aires.testdatatypes.coreflex;

public class CoreFlex_SettlingInBenefitsData {

	public String benefitName;
	public LanguageTrainingEmployee languageTrainingEmployee;
	public LanguageTrainingFamily languageTrainingFamily;
	public CulturalTrainingEmployee culturalTrainingEmployee;
	public CulturalTrainingFamily culturalTrainingFamily;
	
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
	
	public class CulturalTrainingEmployee{
		public String employeeDuration;
		public String employeeOtherDuration;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
	
	public class CulturalTrainingFamily{
		public String familyDuration;
		public String familyOtherDuration;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comment;		
	}
}
