package com.aires.pages.iris;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.pages.iris.basepage.BasePage;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.aires.utilities.Log;
import com.aires.utilities.getWindowText;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.ButtonDescription;
import com.hp.lft.sdk.java.CheckBox;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.DialogDescription;
import com.vimalselvam.cucumber.listener.Reporter;

public class IRIS_LoginPage extends BasePage {
	public IRIS_LoginPage() throws Exception {
		super();
	}

	public CheckBox resetPasswordCheckBox = IRIS_PageMaster.getCheckBoxObjectFromLabel(_IRIS, "Reset Password");
	private static String _userName = null, _password = null, _database = null;

	public void SelectDatabaseType(String type) throws Exception {
		Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Database:"), type, IRISConstants.DATABASE_NAME);
	}

	public void setUserNameText(String text) throws Exception {
		IRIS_PageMaster.getEditorObject(_IRIS, "Username:").setText(text);
	}

	public void setPasswordText(String text) throws Exception {
		IRIS_PageMaster.getEditorObject(_IRIS, "Password:").setText(text);
	}

	public void setPasswordSecurily(String password) throws Exception {
		IRIS_PageMaster.getEditorObject(_IRIS, "Password:").waitUntilEnabled();
		IRIS_PageMaster.getEditorObject(_IRIS, "Password:").setSecure("5e621bafcfc4b282a5df729e8543");
	}

	public void clickElement(String elementName) throws Exception {
		switch (elementName) {
		case ("Login"):
			IRIS_PageMaster.getButtonObject(_IRIS, "Login").waitUntilEnabled();
			IRIS_PageMaster.getButtonObject(_IRIS, "Login").click();
			break;
		case ("Exit"):
			IRIS_PageMaster.getButtonObject(_IRIS, "Exit").waitUntilEnabled();
			IRIS_PageMaster.getButtonObject(_IRIS, "Exit").click();
			break;
		case ("Minimize"):
			_IRIS.minimize();
			break;
		default:
			Assert.fail("No element was found");
		}
	}

	public void checkinACheckbox() throws Exception {
		if (com.hp.lft.sdk.CheckedState.UNCHECKED == null)
			IRIS_PageMaster.getCheckBoxObjectFromLabel(_IRIS, "Reset Password")
					.setState(com.hp.lft.sdk.CheckedState.CHECKED);
	}

	public void loginToIRISApp(String userName, String password, String database) throws Exception {
		try {
			IRIS_PageMaster.getListObject(_IRIS, "Database:").waitUntilEnabled();
			Helpers.selectFromList(IRIS_PageMaster.getListObject(_IRIS, "Database:"), database,
					IRISConstants.DATABASE_NAME);
			Helpers.setEditorText(IRIS_PageMaster.getEditorObject(_IRIS, "Username:"), userName,
					IRISConstants.USERNAME);
			Helpers.setEditorText(IRIS_PageMaster.getEditorObject(_IRIS, "Password:"), password,
					IRISConstants.PASSWORD);
			Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, "Login"), IRISConstants.BUTTON_LOGIN);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getIRISLoginAsPerEnvt(PDT_LoginDetails loginData_IRIS) throws Exception {
		if (CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("QA")) {
			_userName = loginData_IRIS.userIRISTestQA.userName;
			_password = CoreFunctions.getPropertyFromConfig("envt").toLowerCase()
					+ loginData_IRIS.userIRISTestQA.password;
			_database = CoreFunctions.getPropertyFromConfig("envt").toUpperCase();
		} else if (CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("Test")) {
			_userName = loginData_IRIS.userIRISTestQA.userName;
			_password = CoreFunctions.getPropertyFromConfig("envt").toLowerCase()
					+ loginData_IRIS.userIRISTestQA.password;
			_database = IRISConstants.IRIS_DATABASE;
		}else if (CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("Dev")) {
			_userName = loginData_IRIS.userIRISTestDEV.userName;
			_password = CoreFunctions.getPropertyFromConfig("envt").toLowerCase()
					+ loginData_IRIS.userIRISTestDEV.password;
			_database = CoreFunctions.getPropertyFromConfig("envt").toUpperCase();
		} else {
			_userName = loginData_IRIS.userIRISProd.userName;
			_password = loginData_IRIS.userIRISProd.password;
			_database = IRISConstants.IRIS_DATABASE;
		}
		Log.info("User Name : " + _userName + "\nPassword : " + BusinessFunctions.encodedPassword(_password) + "\nDatabase : " + _database);
		Reporter.addStepLog("Login Credentials Entered for IRIS Application are : \nUsername : "+_userName+"\nPassword : "+BusinessFunctions.encodedPassword(_password)+ "\nDatabase : " + _database);
		loginToIRISApp(_userName, _password, _database);
		handleErrorDialog();
	}

	

	public void handleErrorDialog() throws Exception {
		CoreFunctions.waitHandler(3);
		String windowTitle = getWindowText.getActiveWindowText();
		if (windowTitle.equalsIgnoreCase("Error")) {
			Dialog errorDialog = Desktop.describe(Dialog.class,
					new DialogDescription.Builder().title(windowTitle).build());
			Button oKButton = errorDialog.describe(Button.class, new ButtonDescription.Builder().label("OK").build());
			Helpers.clickButton(oKButton, oKButton.getLabel());
			Log.info("OK button is clicked in Error Dialog");
		} else
			Log.info("No Error Dialog is Displayed");
	}
	
	
}