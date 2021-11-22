package com.aires.pages.iris;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.pages.iris.basepage.BasePage;
import com.aires.utilities.Log;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.Editor;
import com.hp.lft.sdk.java.EditorDescription;
import com.vimalselvam.cucumber.listener.Reporter;

public class IRIS_Corporation_Accounting extends BasePage {
	
	private String windowTitle;
	private boolean _isExists = false;

	public IRIS_Corporation_Accounting() throws Exception {
		super();
	}

	private Editor editor;
	private Button button;
	private Editor nameEditor = _IRIS.describe(Editor.class,
			new EditorDescription.Builder().attachedText("Name*").build());
	
	/**
	 * Verify Overview tab title.
	 * 
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public boolean verifyAccountingTab() throws GeneralLeanFtException {
		_IRIS.maximize();
		try {
			CoreFunctions.waitHandler(5);
			if (IRIS_PageMaster.getTabControlObject(_IRIS, 0).getSelectedTab().equals(IRISConstants.ACCOUNTING)) {
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CURRENT_TAB, CoreConstants.PASS,
						IRIS_PageMaster.getTabControlObject(_IRIS, 0).getSelectedTab()));
				return true;
			}
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR+e.getStackTrace());
			Assert.fail("Failed to verify Overview tab");

		}
		return false;
	}
	
	/**
	 * Verify CoreFlex Enabled Column in Policy table.
	 * 
	 * @param policyName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPolicyTableColumn(String searchColumnName) throws Exception {	
		
		//Helpers.printColumnHeaders(IRIS_PageMaster.getTableObject(_IRIS,"com.aires.iris.view.corporation.accounting.PolicyPanel$1"));
		
		_isExists = Helpers.searchJTableColumn((IRIS_PageMaster.getTableObject(_IRIS,"com.aires.iris.view.corporation.accounting.PolicyPanel$1")), searchColumnName);
		
		if (_isExists)
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_TABLE_COLUMN_NAME, CoreConstants.PASS, searchColumnName,
					IRISConstants.ACCOUNTING));

		return _isExists;
	}


}
