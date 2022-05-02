package com.aires.testdatatypes.coreflex;

import java.util.List;

public class MX_Transferee_BenefitDetails {
	List<Benefit> coreBenefits;
	List<FlexBenefit> flexBenefits;
	List<OtherBenefit> otherBenefits;

	public List<OtherBenefit> getOtherBenefits() {
		return otherBenefits;
	}

	public void setOtherBenefits(List<OtherBenefit> otherBenefits) {
		this.otherBenefits = otherBenefits;
	}

	public List<Benefit> getCoreBenefits() {
		return coreBenefits;
	}

	public void setCoreBenefits(List<Benefit> coreBenefits) {
		this.coreBenefits = coreBenefits;
	}

	public List<FlexBenefit> getFlexBenefits() {
		return flexBenefits;
	}

	public void setFlexBenefits(List<FlexBenefit> flexBenefits) {
		this.flexBenefits = flexBenefits;
	}
}
