package com.aires.testdatatypes.coreflex;

public class Benefit {
	private String benefitType;
	private String benefitDisplayName;
	private String subBenefits;
	private String benefitAmount;
	private String benefitDesc;
	private String points;
	private String multipleBenefitSelection;
	private Integer numberOfBenefitSelected;
	private boolean selectBenefitOnFPTPage;
	private String grossUp;
	private String reimbursedBy;
	private String comment;
	private boolean deleteBenefitOnMBBPage;
	private String payments;	

	public Benefit(String benefitDisplayName, String benefitAmount, String benefitDesc) {
		this.benefitDisplayName = benefitDisplayName;
		this.benefitAmount = benefitAmount;
		this.benefitDesc = benefitDesc;
	}

	public Benefit(String benefitDisplayName, String benefitAmount, String benefitDesc, String points) {
		this.benefitDisplayName = benefitDisplayName;
		this.benefitAmount = benefitAmount;
		this.benefitDesc = benefitDesc;
		this.points = points;
	}

	public Benefit(String benefitType, String benefitDisplayName, String subBenefits, String benefitAmount,
			String benefitDesc, String multipleBenefitSelection) {
		this.benefitType = benefitType;
		this.benefitDisplayName = benefitDisplayName;
		this.benefitAmount = benefitAmount;
		this.benefitDesc = benefitDesc;
		this.subBenefits = subBenefits;
		this.multipleBenefitSelection = multipleBenefitSelection;
	}

	public Benefit(String benefitType, String benefitDisplayName, String subBenefits, String benefitAmount,
			String benefitDesc, String points, String multipleBenefitSelection) {
		this.benefitType = benefitType;
		this.benefitDisplayName = benefitDisplayName;
		this.benefitAmount = benefitAmount;
		this.benefitDesc = benefitDesc;
		this.points = points;
		this.subBenefits = subBenefits;
		this.multipleBenefitSelection = multipleBenefitSelection;
	}

	public Benefit(String benefitType, String benefitDisplayName, String benefitAmount, String benefitDesc,
			String points) {
		this.benefitType = benefitType;
		this.benefitDisplayName = benefitDisplayName;
		this.benefitAmount = benefitAmount;
		this.benefitDesc = benefitDesc;
		this.points = points;
	}

	public Benefit(String benefitDisplayName, String benefitAmount, String benefitDesc, String points,
			String multipleBenefitSelection, String comment, String grossUp, String reimbursedBy) {
		this.benefitDisplayName = benefitDisplayName;
		this.benefitAmount = benefitAmount;
		this.benefitDesc = benefitDesc;
		this.points = points;
		this.multipleBenefitSelection = multipleBenefitSelection;
		this.comment = comment;
		this.grossUp = grossUp;
		this.reimbursedBy = reimbursedBy;
	}

	public String getGrossUp() {
		return grossUp;
	}

	public void setGrossUp(String grossUp) {
		this.grossUp = grossUp;
	}

	public String getReimbursedBy() {
		return reimbursedBy;
	}

	public void setReimbursedBy(String reimbursedBy) {
		this.reimbursedBy = reimbursedBy;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getBenefitDisplayName() {
		return benefitDisplayName;
	}

	public void setBenefitDisplayName(String benefitDisplayName) {
		this.benefitDisplayName = benefitDisplayName;
	}

	public String getBenefitType() {
		return benefitType;
	}

	public void setBenefitType(String benefitType) {
		this.benefitType = benefitType;
	}

	public String getSubBenefits() {
		return subBenefits;
	}

	public void setSubBenefits(String subBenefits) {
		this.subBenefits = subBenefits;
	}

	public String getBenefitAmount() {
		return benefitAmount;
	}

	public void setBenefitAmount(String benefitAmount) {
		this.benefitAmount = benefitAmount;
	}

	public String getBenefitDesc() {
		return benefitDesc;
	}

	public void setBenefitDesc(String benefitDesc) {
		this.benefitDesc = benefitDesc;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getMultipleBenefitSelection() {
		return multipleBenefitSelection;
	}

	public void setMultipleBenefitSelection(String multipleBenefitSelection) {
		this.multipleBenefitSelection = multipleBenefitSelection;
	}

	public Integer getNumberOfBenefitSelected() {
		return numberOfBenefitSelected;
	}

	public void setNumberOfBenefitSelected(Integer numberOfBenefitSelected) {
		this.numberOfBenefitSelected = numberOfBenefitSelected;
	}

	public boolean getSelectBenefitOnFPTPage() {
		return selectBenefitOnFPTPage;
	}

	public void setSelectBenefitOnFPTPage(boolean selectBenefitOnFPTPage) {
		this.selectBenefitOnFPTPage = selectBenefitOnFPTPage;
	}
	
	public boolean getDeleteBenefitOnMBBPage() {
		return deleteBenefitOnMBBPage;
	}

	public void setDeleteBenefitOnMBBPage(boolean deleteBenefitOnMBBPage) {
		this.deleteBenefitOnMBBPage = deleteBenefitOnMBBPage;
	}
	
	public String getPayments() {
		return payments;
	}

	public void setPayments(String payments) {
		this.payments = payments;
	}

	@Override
	public boolean equals(Object obj) {
		Benefit benefit = (Benefit) obj;
		if (benefitAmount.equals(benefit.getBenefitAmount())
				&& benefitDisplayName.equals(benefit.getBenefitDisplayName())
				&& benefitDesc.equals(benefit.getBenefitDesc())
				&& (benefit.getPoints() == null || benefit.getPoints().equals(points)))
			return true;
		return false;
	}

}
