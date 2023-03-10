package com.aires.managers;

import com.aires.pages.iris.IRIS_ActivityAndFinancePage;
import com.aires.pages.iris.IRIS_AssignmentOverviewPage;
import com.aires.pages.iris.IRIS_AssignmentServicePage;
import com.aires.pages.iris.IRIS_AssignmentTransfereeNFamilyPage;
import com.aires.pages.iris.IRIS_Corporation_Accounting;
import com.aires.pages.iris.IRIS_Corporation_Main;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.pages.iris.IRIS_Welcome12C;

public class IrisPageManager {

	private String browserTitle;
	public IRIS_LoginPage irisLoginPage;
	public IRIS_Welcome12C irisWelcome12C;
	public IRIS_Corporation_Main irisCorporationMain;
	public IRIS_Corporation_Accounting irisCorporationAccounting;
	public IRIS_AssignmentOverviewPage irisAssignmentOverviewPage;
	public IRIS_ActivityAndFinancePage irisActivityAndFinancePage;
	public IRIS_AssignmentTransfereeNFamilyPage irisAssignmentTransfereeAndFamilyPage;
	public IRIS_AssignmentServicePage irisAssignmentServicePage;
	
	public IrisPageManager(String browserTitle) {
		this.browserTitle = browserTitle;
	}
	
	
}
