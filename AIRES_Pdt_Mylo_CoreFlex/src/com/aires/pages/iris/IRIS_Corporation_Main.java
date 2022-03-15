package com.aires.pages.iris;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.pages.iris.basepage.BasePage;
import com.aires.utilities.getWindowText;
import com.aventstack.extentreports.Status;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.ButtonDescription;
import com.hp.lft.sdk.java.CheckBox;
import com.hp.lft.sdk.java.CheckBoxDescription;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.DialogDescription;
import com.hp.lft.sdk.java.Editor;
import com.hp.lft.sdk.java.EditorDescription;
import com.hp.lft.sdk.java.Label;
import com.hp.lft.sdk.java.LabelDescription;
import com.hp.lft.sdk.java.List;
import com.hp.lft.sdk.java.ListDescription;
import com.hp.lft.sdk.java.Menu;
import com.hp.lft.sdk.java.MenuDescription;
import com.hp.lft.sdk.java.TabControl;
import com.hp.lft.sdk.java.TabControlDescription;
import com.hp.lft.sdk.java.TreeView;
import com.hp.lft.sdk.java.TreeViewDescription;
import com.hp.lft.sdk.java.UiObject;
import com.hp.lft.sdk.java.UiObjectDescription;
import com.hp.lft.sdk.java.Window;
import com.hp.lft.sdk.java.WindowDescription;
import com.vimalselvam.cucumber.listener.Reporter;

public class IRIS_Corporation_Main extends BasePage {
	private String windowTitle;

	public IRIS_Corporation_Main() throws Exception {
		super();
	}

	private Editor editor;
	private Button button;
	private Editor nameEditor = _IRIS.describe(Editor.class,
			new EditorDescription.Builder().attachedText("Name*").build());

	private Button _codeLockdownToolButton = Desktop
			.describe(Window.class,
					new WindowDescription.Builder().title("Corporation - 12C - AIRES-CIS-DEMO&'TEST(CLIENT) #49211")
							.build())
			.describe(Button.class, new ButtonDescription.Builder().attachedText("Code Lockdown Tool")
					.label("Code Lockdown Tool").build());

	Editor dNBEditor = _IRIS.describe(Editor.class, new EditorDescription.Builder().attachedText("DNB #").build());

	private Button addButton = _IRIS.describe(Button.class, new ButtonDescription.Builder().label("Add").build());

	private Dialog queryCorporationDialog = IRIS_PageMaster.getDialogObject(_IRIS, "Query Corporation");

	private Window corporation12CWindow = Desktop.describe(Window.class,
			new WindowDescription.Builder().title("Corporation - 12C").build());
	private Dialog queryCorporationNotFoundDialog = corporation12CWindow.describe(Dialog.class,
			new DialogDescription.Builder().title("Query Corporation").build());

	private Dialog infoDialog = queryCorporationNotFoundDialog.describe(Dialog.class,
			new DialogDescription.Builder().title("Info").build());
	private Button oKButton = infoDialog.describe(Button.class, new ButtonDescription.Builder().label("OK").build());

	private Button cancelButton = queryCorporationNotFoundDialog.describe(Button.class,
			new ButtonDescription.Builder().label("Cancel").build());

	private UiObject mainPanelBasicPanelUiObject = IRIS_PageMaster.getUiObjectWithAttachedText(_IRIS,
			"com.aires.iris.view.corporation.main.MainPanel$BasicPanel", "Corporation");

	private TabControl jTabbedPaneTabControl;
	private boolean _isExists = false;
	private boolean _printReportMsg = true;

	public Editor getEditorByName(String editorName) {
		switch (editorName) {
		case "name":
			return nameEditor;
		default:
			Assert.fail("No editor was found");
		}
		return editor;
	}

	public Button getButtonByName(String buttonName) throws Exception {
		switch (buttonName) {
		case "add":
			return addButton;
		case "CodeLockDownButton":
			return IRIS_PageMaster.getButtonObjectFromLabel(
					IRIS_PageMaster.getWindowObject(getWindowText.getActiveWindowText()), "Code Lockdown Tool");
		default:
			Assert.fail("No button was found");
		}
		return button;
	}

	public void setTextInEditor(String text, String editorName, String label) throws GeneralLeanFtException {
		editor = getEditorByName(editorName);
		Helpers.setEditorText(editor, "TEXT", label);
	}

	public void clickCorporationButton(String buttonName, String label) throws Exception {
		button = getButtonByName(buttonName);
		Helpers.clickButton(button, label);
	}

	public void queryCorporation(String id) throws Exception {
		Helpers.selectMenu(IRIS_PageMaster.getMenuObject(_IRIS, "Query", "Corporation"),
				IRISConstants.QUERY_CORPORATION);
		Helpers.setEditorText(IRIS_PageMaster.getEditorObject(queryCorporationDialog, "ID:"), id, IRISConstants.ID);
		Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(queryCorporationDialog, IRISConstants.BTN_EXECUTE),
				IRISConstants.BTN_EXECUTE);
	}

	public void selectContactListFromTree() throws Exception {
		windowTitle = getWindowText.getActiveWindowText();
		System.out.print("else" + windowTitle + "done");
		Window window = Desktop.describe(Window.class, new WindowDescription.Builder().title(windowTitle).build());
		TreeView jTreeTreeView = window.describe(TreeView.class, new TreeViewDescription());
		Helpers.selectTreeViewNode(jTreeTreeView, "Contact List");
		Helpers.selectTreeViewNode(jTreeTreeView, "Contact List;Ana A Hewitson");
		Thread.sleep(500);
		Helpers.selectTreeViewNode(jTreeTreeView, "Contact List;Edward A Borer");
		Thread.sleep(500);
		Helpers.selectTreeViewNode(jTreeTreeView, "Contact List;Gabriel A North");
	}

	public void selectStatusFromCorporationDropdown(String option) throws Exception {
		windowTitle = getWindowText.getActiveWindowText();
		System.out.print("else" + windowTitle + "done");
		Window window = Desktop.describe(Window.class, new WindowDescription.Builder().title(windowTitle).build());
		List aIProviderList = window.describe(List.class, new ListDescription.Builder().attachedText("AI Provider")
				.nativeClass("javax.swing.JComboBox").index(1).build());
		Helpers.selectFromList(aIProviderList, option, IRISConstants.AI_PROVIDER);
	}

	public void saveCorporationMainChanges() throws Exception {
		windowTitle = getWindowText.getActiveWindowText();
		Window window = Desktop.describe(Window.class, new WindowDescription.Builder().title(windowTitle).build());
		Helpers.saveChanges(window);
	}

	public void closeWindow() throws GeneralLeanFtException {
		windowTitle = getWindowText.getActiveWindowText();
		Window window = Desktop.describe(Window.class, new WindowDescription.Builder().title(windowTitle).build());
		window.close();
	}

	public void selectCorporationModules(java.util.List<String> subModulesNameList) throws Exception {
		_IRIS = getIRISWindow();
		_IRIS.maximize();
		Thread.sleep(2000);
		for (String moduleName : subModulesNameList) {
			jTabbedPaneTabControl = _IRIS.describe(TabControl.class,
					new TabControlDescription.Builder().nativeClass("javax.swing.JTabbedPane").index(0).build());
			System.out.println(moduleName);
			jTabbedPaneTabControl.select(moduleName);
			Thread.sleep(1000);
			switchToCorporationModule(moduleName);
		}
		_IRIS.restore();
	}

	public void selectCorporationModules(String moduleName) throws Exception {
		_IRIS = getIRISWindow();
		_IRIS.maximize();
		Thread.sleep(3000);
		jTabbedPaneTabControl = _IRIS.describe(TabControl.class,
				new TabControlDescription.Builder().nativeClass("javax.swing.JTabbedPane").index(0).build());
		jTabbedPaneTabControl.waitUntilEnabled();
		Thread.sleep(3000);
		jTabbedPaneTabControl.select(moduleName);
		Thread.sleep(1000);
		switchToCorporationModule(moduleName);
	}

	public void selectCorporation(String moduleName) throws Exception {
		_IRIS = getIRISWindow();
		Thread.sleep(2000);
		System.out.println(moduleName);
		IRIS_PageMaster.getTabControlObject(_IRIS, 0).select(moduleName);
	}

	public void switchToCorporationModule(String moduleName) throws Exception {
		switch (moduleName) {
		case "Main":
			UiObject mainPanelBasicPanelUiObject = _IRIS.describe(UiObject.class,
					new UiObjectDescription.Builder().attachedText("Corporation")
							.nativeClass("com.aires.iris.view.corporation.main.MainPanel$BasicPanel").build());
			Assert.assertTrue(mainPanelBasicPanelUiObject.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Contact":
			UiObject contactPanelListPanelUiObject = _IRIS.describe(UiObject.class,
					new UiObjectDescription.Builder().attachedText("Contact List")
							.nativeClass("com.aires.iris.view.corporation.contact.ContactPanel$ListPanel").build());
			Assert.assertTrue(contactPanelListPanelUiObject.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Comment":
			Label searchWithinCommentsStLabel = _IRIS.describe(Label.class,
					new LabelDescription.Builder().label("Search within comments ").build());
			Assert.assertTrue(searchWithinCommentsStLabel.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Activity":
			CheckBox includeCompletedActivitiesCheckBox = _IRIS.describe(CheckBox.class,
					new CheckBoxDescription.Builder().attachedText("Include Completed Activities").build());
			Assert.assertTrue(includeCompletedActivitiesCheckBox.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Aires Team":
			UiObject jPanelUiObject = _IRIS.describe(UiObject.class, new UiObjectDescription.Builder()
					.attachedText("M&A History").index(2).nativeClass("javax.swing.JPanel").build());
			Assert.assertTrue(jPanelUiObject.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Requirements":
			UiObject requirementsPanelServiceAgreementPanelUiObject = _IRIS.describe(UiObject.class,
					new UiObjectDescription.Builder().attachedText("Service Agreements").nativeClass(
							"com.aires.iris.view.corporation.requirements.RequirementsPanel$ServiceAgreementPanel")
							.build());
			Assert.assertTrue(requirementsPanelServiceAgreementPanelUiObject.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Exception Workflow Setup":
			Label setupTypeStLabel = _IRIS.describe(Label.class,
					new LabelDescription.Builder().label("Setup Type").build());
			Assert.assertTrue(setupTypeStLabel.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Capped Cost Setup":
			Helpers.handleMessageDialog(_IRIS);
			UiObject jPanelUiObjectCappedCostSetup = _IRIS.describe(UiObject.class,
					new UiObjectDescription.Builder().attachedText("Select a Cap or Create a New Cap").index(1)
							.nativeClass("javax.swing.JPanel").build());
			Assert.assertTrue(jPanelUiObjectCappedCostSetup.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Insurance":
			UiObject insurancePanelCorpInsPanelUiObject = _IRIS.describe(UiObject.class,
					new UiObjectDescription.Builder().attachedText("Insurance")
							.nativeClass("com.aires.iris.view.corporation.insurance.InsurancePanel$CorpInsPanel")
							.build());
			Assert.assertTrue(insurancePanelCorpInsPanelUiObject.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Accounting":
			UiObject policyPanelUiObject = _IRIS.describe(UiObject.class,
					new UiObjectDescription.Builder().attachedText("Policy")
							.nativeClass("com.aires.iris.view.corporation.accounting.PolicyPanel").build());
			Assert.assertTrue(policyPanelUiObject.exists());
			Reporter.addStepLog(CoreConstants.PASS + "" + moduleName + " was clicked and verified successfully");
			break;
		case "Billing Matrix":
			Label billingCurrencyStLabel = _IRIS.describe(Label.class,
					new LabelDescription.Builder().attachedText("Billing Currency").label("Billing Currency").build());
			Assert.assertTrue(billingCurrencyStLabel.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Reports":
			UiObject jPanelUiObjectReports = _IRIS.describe(UiObject.class, new UiObjectDescription.Builder()
					.attachedText("Available Reports").index(1).nativeClass("javax.swing.JPanel").build());
			Assert.assertTrue(jPanelUiObjectReports.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		case "Year End":
			Label yearStLabel = _IRIS.describe(Label.class, new LabelDescription.Builder().label("Year:").build());
			Assert.assertTrue(yearStLabel.exists());
			Reporter.addStepLog(Status.PASS + " " + moduleName + " was clicked and verified successfully");
			break;
		}

	}

	public void clickCorporationModuleLink(String linkName, String tabName) throws Exception {

		Menu documentManagementMenu = getIRISWindow().describe(Menu.class,
				new MenuDescription.Builder().label(tabName).build());
		switch (linkName) {
		case IRISConstants.ATTACH_MENU:
			Menu attachMenu = documentManagementMenu.describe(Menu.class,
					new MenuDescription.Builder().label(linkName).build());
			CoreFunctions.waitHandler(2);
			Helpers.selectMenu(attachMenu, IRISConstants.ATTACH_MENU);
			break;
		case IRISConstants.VIEW_ALL_MENU:
			Menu viewMenu = documentManagementMenu.describe(Menu.class,
					new MenuDescription.Builder().label("View").build());
			Menu aLLMenu = viewMenu.describe(Menu.class, new MenuDescription.Builder().label("ALL").build());
			CoreFunctions.waitHandler(2);
			Helpers.selectMenu(aLLMenu, IRISConstants.VIEW_ALL_MENU);
			break;
		case IRISConstants.PARTNER_ALLOCATION_CORP_NAME:
			Menu viewPartnerAllocationForPartnerMenu = documentManagementMenu.describe(Menu.class,
					new MenuDescription.Builder().label(linkName).build());
			CoreFunctions.waitHandler(2);
			Helpers.selectMenu(viewPartnerAllocationForPartnerMenu, IRISConstants.PARTNER_ALLOCATION_NAME);
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.VERIFIED_DOC_MGMT_LINK_CLICKED, CoreConstants.PASS, linkName));
			break;
		}
		Reporter.addStepLog(
				MessageFormat.format(IRISConstants.VERIFIED_DOC_MGMT_LINK_CLICKED, CoreConstants.PASS, linkName));
	}

	public boolean verfiyCorporationNotFoundMessage(String msg) throws GeneralLeanFtException {
		_isExists = infoDialog.getVisibleText().contains(msg) ? true : false;
		Helpers.clickButton(oKButton, oKButton.getLabel());
		Helpers.clickButton(cancelButton, IRISConstants.BUTTON_CANCEL);
		if (_isExists && _printReportMsg) {
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CORPORATION_NOT_FOUND_MESSAGE,
					CoreConstants.PASS, msg));
		}
		return _isExists;
	}

	public boolean verifyMainTab(String tabName) throws GeneralLeanFtException {
		_IRIS.maximize();
		if (mainPanelBasicPanelUiObject.isEnabled() ? true : false)
			_isExists = true;
		Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_CURRENT_TAB, CoreConstants.PASS, tabName));
		return _isExists;
	}

	public HashMap<String, Boolean> verifyTextEditorValueOnCorporationTab(HashMap<String, String> editorMap,
			String tabName) throws GeneralLeanFtException {
		HashMap<String, Boolean> editorResultMap = new HashMap<String, Boolean>();
		for (@SuppressWarnings("rawtypes")
		Map.Entry m : editorMap.entrySet()) {

			_isExists = Helpers.searchAndVerifySelectedItemInList((List) getElementByName(m.getKey().toString()),
					m.getValue().toString());

			if (_isExists)
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_FIELD_ON_TAB, CoreConstants.PASS,
						(List) getElementByName(m.getKey().toString()), m.getValue().toString(), tabName));

			editorResultMap.put(m.getKey().toString(), _isExists);
		}
		return editorResultMap;
	}

	public HashMap<String, Boolean> verifyDropDownValueOnCorporationTab(HashMap<String, String> dropDownMap,
			String tabName) throws GeneralLeanFtException {
		HashMap<String, Boolean> dropDownResultMap = new HashMap<String, Boolean>();
		for (@SuppressWarnings("rawtypes")
		Map.Entry m : dropDownMap.entrySet()) {
			_isExists = Helpers.searchAndVerifySelectedItemInList((List) getElementByName(m.getKey().toString()),
					m.getValue().toString());

			if (_isExists)
				Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_FIELD_ON_TAB, CoreConstants.PASS,
						(List) getElementByName(m.getKey().toString()), m.getValue().toString(), tabName));
			dropDownResultMap.put(m.getKey().toString(), _isExists);
		}
		return dropDownResultMap;
	}

	public List getElementByListName(String elementName) throws GeneralLeanFtException {
		List element = null;
		Window _IRIS = Desktop.describe(Window.class,
				new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build());
		switch (elementName) {
		case IRISConstants.ROLE_DROPDOWN:
			List roleList = _IRIS.describe(List.class, new ListDescription.Builder().attachedText("Role*").build());
			element = roleList;
			break;
		case IRISConstants.IND_DROPDOWN:
			List indList = _IRIS.describe(List.class, new ListDescription.Builder().attachedText("Ind*").build());
			element = indList;
			break;
		case IRISConstants.STATUS_DROPDOWN:
			List aIProviderList = _IRIS.describe(List.class, new ListDescription.Builder().attachedText("AI Provider")
					.nativeClass("javax.swing.JComboBox").index(1).build());
			element = aIProviderList;
			break;
		default:
			Assert.fail(IRISConstants.NO_ELEMENT_FOUND);
			break;
		}

		return element;
	}

	public Editor getElementByName(String elementName) throws GeneralLeanFtException {
		Editor element = null;
		Window _IRIS = Desktop.describe(Window.class,
				new WindowDescription.Builder().title(getWindowText.getActiveWindowText()).build());
		switch (elementName) {
		case IRISConstants.NAME_TEXT_BOX:
			Editor nameEditor = _IRIS.describe(Editor.class,
					new EditorDescription.Builder().attachedText("Name*").build());
			element = nameEditor;
			break;
		case IRISConstants.PARENT_ID_TEXT_BOX:
			Editor parentIDEditor = _IRIS.describe(Editor.class,
					new EditorDescription.Builder().attachedText("Parent ID").build());
			element = parentIDEditor;
			break;
		default:
			Assert.fail(IRISConstants.NO_ELEMENT_FOUND);
			break;
		}

		return element;
	}

	public void ClickOnCodeLockdownToolButton() {
		try {
			Helpers.clickButton(_codeLockdownToolButton, _codeLockdownToolButton.getAttachedText());
			Reporter.addStepLog(MessageFormat.format(IRISConstants.VERIFIED_BUTTON_CLICKED, CoreConstants.PASS,
					_codeLockdownToolButton.getAttachedText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}