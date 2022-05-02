package com.aires.testdatatypes.coreflex;

import java.util.List;

public class OtherBenefit {
	private String category;
	private List<Benefit> benefits;

	public OtherBenefit(String category, List<Benefit> benefits) {
		super();
		this.category = category;
		this.benefits = benefits;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Benefit> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<Benefit> benefits) {
		this.benefits = benefits;
	}

	@Override
	public boolean equals(Object obj) {
		OtherBenefit benefit = (OtherBenefit) obj;
		if (benefit.getCategory().equals(category) && benefit.getBenefits().equals(benefits)) {
			return true;
		}
		return false;
	}
}
