package com.aires.testdatatypes.pdt;

public class PDT_CulturalTrainingBenefit {
	public String benefitName;
	public CulturalTrainingEmployee culturalTrainingEmployee;
	public CulturalTrainingFamily culturalTrainingFamily;
	
	public class CulturalTrainingEmployee {
		public String numberOfDays;
		public String otherNumberOfDays;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comments;
	}
	
	public class CulturalTrainingFamily {
		public String numberOfDays;
		public String otherNumberOfDays;
		public String grossUp;
		public String reimbursedBy;
		public String reimbursedByOther;
		public String comments;
	}
}
