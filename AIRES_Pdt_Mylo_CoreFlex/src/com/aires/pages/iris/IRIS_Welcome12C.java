/**
 * @author srana
 *
 */

package com.aires.pages.iris;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.pages.iris.basepage.BasePage;
import com.aires.utilities.getWindowText;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.vimalselvam.cucumber.listener.Reporter;

public class IRIS_Welcome12C extends BasePage {

	public IRIS_Welcome12C() throws Exception {
		super();
	}
	private boolean _isExists = false;

	public void selectWelcomeWindowModule(String moduleName) throws GeneralLeanFtException, Exception {
		switch (moduleName) {
		case (IRISConstants.CORPORATION_TAB):
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "group_32"), moduleName);
			break;
		case (IRISConstants.ACTIVITY):
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "area_chart_32"), moduleName);
			break;
		case (IRISConstants.PARTNER_TAB):
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "salesman_32"), moduleName);
			break;
		case (IRISConstants.ASSIGNMENT_TAB):
			IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Globe_32").waitUntilEnabled();
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Globe_32"), moduleName);
			break;
		case (IRISConstants.DOCUMENTS_TAB):
			IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "report_32").waitUntilEnabled();
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "report_32"), moduleName);
			break;
		case (IRISConstants.ASSIST_TAB):
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "iristoassit"), moduleName);
			break;
		case (IRISConstants.EXIT_TAB):
			IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "exit_32").waitUntilEnabled();
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "exit_32"), moduleName);
			break;
		default:
			Assert.fail(IRISConstants.ELEMENT_NOT_FOUND);
		}
		
	}

	public void maximizeWindow() throws GeneralLeanFtException {
		_IRIS.maximize();
	}

	public void minimizeWindow() throws GeneralLeanFtException {
		_IRIS.minimize();
	}

	public void exitDialog() throws GeneralLeanFtException {
		try {
			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "exit_32"), IRISConstants.EXIT_TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWindow() throws GeneralLeanFtException {
		_IRIS.close();
	}

	public boolean verifyWindowTitle(String windowTitle) throws Exception {
		CoreFunctions.waitHandler(2);
		_isExists = getWindowText.getActiveWindowText().contains(windowTitle);
		CoreFunctions.waitHandler(2);
		if (_isExists)
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_WINDOW_TITLE, CoreConstants.PASS, windowTitle));
		return _isExists;
	}
}
