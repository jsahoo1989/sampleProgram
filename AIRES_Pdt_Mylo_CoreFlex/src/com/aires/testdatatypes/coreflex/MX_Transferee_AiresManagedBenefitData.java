package com.aires.testdatatypes.coreflex;

import java.util.List;

public class MX_Transferee_AiresManagedBenefitData {
	List<Benefit> coreAiresManagedBenefits;
	List<FlexBenefit> flexAiresManagedBenefits;

	public List<Benefit> getCoreBenefits() {
		return coreAiresManagedBenefits;
	}

	public void setCoreBenefits(List<Benefit> coreAiresManagedBenefits) {
		this.coreAiresManagedBenefits = coreAiresManagedBenefits;
	}

	public List<FlexBenefit> getFlexBenefits() {
		return flexAiresManagedBenefits;
	}

	public void setFlexBenefits(List<FlexBenefit> flexAiresManagedBenefits) {
		this.flexAiresManagedBenefits = flexAiresManagedBenefits;
	}
}
