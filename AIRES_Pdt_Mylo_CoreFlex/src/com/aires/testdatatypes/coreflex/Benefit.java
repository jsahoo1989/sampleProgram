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
	private String airesManagedService;	
	private String irisServiceName;
	private String irisSubserviceType;
	private String irisSubserviceName;
	private  String irisSubserviceID;
	private String subServiceActivityFinance;
	private String subServiceFunction;
	private String compID;
	private String company;
	private String initialTracingPrompt;
	private String endTracingPrompt;
	private String postInitialTracingCardStatus;
	private String postEndTracingCardStatus;
	private boolean multipleBenefitSubmission;
	private String secondTracingPrompt;
	private String postSecondTracingCardStatus;
	private String thirdTracingPrompt;
	private String postThirdTracingCardStatus;
	private String policyCreationGroup;
	private boolean selectBenefitOnPBCPage;
	private boolean deselectBenefitOnPBCPage;
	private Integer noOfMilestones;
	private String allMilestones;
	private String subbenefitToBeDeselected;	

	public String getSubbenefitToBeDeselected() {
		return subbenefitToBeDeselected;
	}

	public void setSubbenefitToBeDeselected(String subbenefitToBeDeselected) {
		this.subbenefitToBeDeselected = subbenefitToBeDeselected;
	}

	public String getAllMilestones() {
		return allMilestones;
	}

	public void setAllMilestones(String allMilestones) {
		this.allMilestones = allMilestones;
	}

	public Integer getNoOfMilestones() {
		return noOfMilestones;
	}

	public void setNoOfMilestones(Integer noOfMilestones) {
		this.noOfMilestones = noOfMilestones;
	}	
	
	
	public boolean isSelectBenefitOnPBCPage() {
		return selectBenefitOnPBCPage;
	}

	public void setSelectBenefitOnPBCPage(boolean selectBenefitOnPBCPage) {
		this.selectBenefitOnPBCPage = selectBenefitOnPBCPage;
	}
	
	public boolean isDeselectBenefitOnPBCPage() {
		return deselectBenefitOnPBCPage;
	}

	public void setDeselectBenefitOnPBCPage(boolean deselectBenefitOnPBCPage) {
		this.deselectBenefitOnPBCPage = deselectBenefitOnPBCPage;
	}

	public String getPolicyCreationGroup() {
		return policyCreationGroup;
	}

	public void setPolicyCreationGroup(String policyCreationGroup) {
		this.policyCreationGroup = policyCreationGroup;
	}

	public boolean getMultipleBenefitSubmission() {
		return multipleBenefitSubmission;
	}

	public void setMultipleBenefitSubmission(boolean multipleBenefitSubmission) {
		this.multipleBenefitSubmission = multipleBenefitSubmission;
	}

	public String getPostInitialTracingCardStatus() {
		return postInitialTracingCardStatus;
	}

	public void setPostInitialTracingCardStatus(String postInitialTracingCardStatus) {
		this.postInitialTracingCardStatus = postInitialTracingCardStatus;
	}

	public String getPostEndTracingCardStatus() {
		return postEndTracingCardStatus;
	}

	public void setPostEndTracingCardStatus(String postEndTracingCardStatus) {
		this.postEndTracingCardStatus = postEndTracingCardStatus;
	}

	public String getInitialTracingPrompt() {
		return initialTracingPrompt;
	}

	public void setInitialTracingPrompt(String initialTracingPrompt) {
		this.initialTracingPrompt = initialTracingPrompt;
	}

	public String getEndTracingPrompt() {
		return endTracingPrompt;
	}

	public void setEndTracingPrompt(String endTracingPrompt) {
		this.endTracingPrompt = endTracingPrompt;
	}

	public String getSubServiceActivityFinance() {
		return subServiceActivityFinance;
	}

	public void setSubServiceActivityFinance(String subServiceActivityFinance) {
		this.subServiceActivityFinance = subServiceActivityFinance;
	}

	public String getSubServiceFunction() {
		return subServiceFunction;
	}

	public void setSubServiceFunction(String subServiceFunction) {
		this.subServiceFunction = subServiceFunction;
	}

	public String getCompID() {
		return compID;
	}

	public void setCompID(String compID) {
		this.compID = compID;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

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
	
	public String getAiresManagedService() {
		return airesManagedService;
	}

	public void setAiresManagedService(String airesManagedService) {
		this.airesManagedService = airesManagedService;
	}
	
	public String getIrisServiceName() {
		return irisServiceName;
	}

	public void setIrisServiceName(String irisServiceName) {
		this.irisServiceName = irisServiceName;
	}

	public String getIrisSubserviceType() {
		return irisSubserviceType;
	}

	public void setIrisSubserviceType(String irisSubserviceType) {
		this.irisSubserviceType = irisSubserviceType;
	}

	public String getIrisSubserviceName() {
		return irisSubserviceName;
	}

	public void setIrisSubserviceName(String irisSubserviceName) {
		this.irisSubserviceName = irisSubserviceName;
	}
	
	public String getIrisSubserviceID() {
		return irisSubserviceID;
	}

	public void setIrisSubserviceID(String irisSubserviceID) {
		this.irisSubserviceID = irisSubserviceID;
	}
	
	public String getSecondTracingPrompt() {
		return secondTracingPrompt;
	}

	public void setSecondTracingPrompt(String secondTracingPrompt) {
		this.secondTracingPrompt = secondTracingPrompt;
	}

	public String getPostSecondTracingCardStatus() {
		return postSecondTracingCardStatus;
	}

	public void setPostSecondTracingCardStatus(String postSecondTracingCardStatus) {
		this.postSecondTracingCardStatus = postSecondTracingCardStatus;
	}

	public String getThirdTracingPrompt() {
		return thirdTracingPrompt;
	}

	public void setThirdTracingPrompt(String thirdTracingPrompt) {
		this.thirdTracingPrompt = thirdTracingPrompt;
	}

	public String getPostThirdTracingCardStatus() {
		return postThirdTracingCardStatus;
	}

	public void setPostThirdTracingCardStatus(String postThirdTracingCardStatus) {
		this.postThirdTracingCardStatus = postThirdTracingCardStatus;
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
