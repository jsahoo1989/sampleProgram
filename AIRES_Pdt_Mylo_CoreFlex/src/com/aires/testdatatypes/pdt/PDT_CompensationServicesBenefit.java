package com.aires.testdatatypes.pdt;

public class PDT_CompensationServicesBenefit {
	public String benefitName;
	public LetterOfAssignment letterOfAssignment;
	public CostEstimateWithTax costEstimateWithTax;
	public CostEstimateWithoutTax costEstimateWithoutTax;
	public BalanceSheet balanceSheet;
	public AllowanceUpdates allowanceUpdates;
	public GlobalDataCollection globalDataCollection;
	public PayrollInstructions payrollInstructions;
	
	public class LetterOfAssignment {
		public String comment;
	}
	
	public class CostEstimateWithTax {
		public String comment;
	}
	
	public class CostEstimateWithoutTax {
		public String comment;
	}
	
	public class BalanceSheet {
		public String comment;
	}
	
	public class AllowanceUpdates {
		public String comment;
	}
	
	public class GlobalDataCollection {
		public String comment;
	}
	
	public class PayrollInstructions {
		public String comment;
	}
}
