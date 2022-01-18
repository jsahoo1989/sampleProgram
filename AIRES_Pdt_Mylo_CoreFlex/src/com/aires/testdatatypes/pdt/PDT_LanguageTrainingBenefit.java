package com.aires.testdatatypes.pdt;

public class PDT_LanguageTrainingBenefit {
	public String benefitName;
	public LanguageTrainingEmployee languageTrainingEmployee;
	public LanguageTrainingFamily languageTrainingFamily;
	
	public class LanguageTrainingEmployee {
		public String maxNumOfHours;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comments;
	}
	
	public class LanguageTrainingFamily {
		public String maxNumOfHrsPerPerson;
		public String maxNumOfHrsPerFamily;	
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comments;
	}
}
