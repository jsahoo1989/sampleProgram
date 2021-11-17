package com.aires.pages.iris;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.RegExpProperty;
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
import com.hp.lft.sdk.java.RadioButton;
import com.hp.lft.sdk.java.RadioButtonDescription;
import com.hp.lft.sdk.java.TabControl;
import com.hp.lft.sdk.java.TabControlDescription;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.TableDescription;
import com.hp.lft.sdk.java.TreeView;
import com.hp.lft.sdk.java.TreeViewDescription;
import com.hp.lft.sdk.java.UiObject;
import com.hp.lft.sdk.java.UiObjectDescription;
import com.hp.lft.sdk.java.Window;
import com.hp.lft.sdk.java.WindowDescription;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListBoxDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;

public class IRIS_PageMaster {

	public static Window getWindowObject(String windowTitle) throws Exception {
		return Desktop.describe(Window.class, new WindowDescription.Builder().title(windowTitle).build());
	}

	public static RadioButton getRadioButtonObject(Window windowName, String attachText) throws Exception {
		return windowName.describe(RadioButton.class,
				new RadioButtonDescription.Builder().attachedText(attachText).build());
	}

	public static UiObject getUiObject(Window windowName, String nativeClass, int indexValue) throws Exception {
		return windowName.describe(UiObject.class,
				new UiObjectDescription.Builder().nativeClass(nativeClass).index(indexValue).build());
	}

	public static UiObject getUiObject(Window windowName, String nativeClass, String text) throws Exception {
		return windowName.describe(UiObject.class,
				new UiObjectDescription.Builder().nativeClass(nativeClass).text(text).build());
	}

	public static UiObject getUiObjectWithAttachedText(Window windowName, String nativeClass, String attachedText)
			throws Exception {
		return windowName.describe(UiObject.class,
				new UiObjectDescription.Builder().nativeClass(nativeClass).attachedText(attachedText).build());
	}

	public static Button getButtonObject(Window windowName, String labelAttachedText) throws Exception {
		return windowName.describe(Button.class, new ButtonDescription.Builder().attachedText(labelAttachedText)
				.label(labelAttachedText).nativeClass("javax.swing.JButton").build());
	}

	public static Button getButtonObject(Window windowName, String labelAttachedText, String className) throws Exception {
		return windowName.describe(Button.class, new ButtonDescription.Builder().attachedText(labelAttachedText)
				.label(labelAttachedText).nativeClass(className).build());
	}
	
	public static Button getButtonObject(Window windowName, String labelAttachedText, int indexValue) throws Exception {
		return windowName.describe(Button.class, new ButtonDescription.Builder().attachedText(labelAttachedText)
				.label(labelAttachedText).nativeClass("javax.swing.JButton").index(indexValue).build());
	}

	public static Button getButtonObjectFromAttachedText(Window windowName, String attachedText) throws Exception {
		return windowName.describe(Button.class,
				new ButtonDescription.Builder().attachedText(attachedText).nativeClass("javax.swing.JButton").build());
	}

	public static Button getButtonObjectFromLabelText(Window windowName, String labelText) throws Exception {
		return windowName.describe(Button.class,
				new ButtonDescription.Builder().label(labelText).nativeClass("javax.swing.JButton").build());
	}

	public static CheckBox getCheckBoxObjectFromLabel(Window windowName, String label) throws Exception {
		return windowName.describe(CheckBox.class, new CheckBoxDescription.Builder().attachedText(label).build());
	}

	public static Button getButtonObjectFromLabel(Window windowName, String label) throws Exception {
		return windowName.describe(Button.class, new ButtonDescription.Builder().label(label).build());
	}

	public static TabControl getTabControlObject(Window windowName, int indexValue) throws Exception {
		return windowName.describe(TabControl.class,
				new TabControlDescription.Builder().nativeClass("javax.swing.JTabbedPane").index(indexValue).build());
	}

	public static TabControl getTabControlObject(Window windowName, String nativeClass, int indexValue)
			throws Exception {
		return windowName.describe(TabControl.class,
				new TabControlDescription.Builder().nativeClass(nativeClass).index(indexValue).build());
	}

	public static Dialog getDialogObject(Window windowName, String title) throws Exception {
		return windowName.describe(Dialog.class, new DialogDescription.Builder().title(title).build());
	}

	public static Label getLabelObject(Window windowName, String title) throws Exception {
		return windowName.describe(Label.class, new LabelDescription.Builder().label(title).build());
	}

	public static TreeView getTreeViewObject(Window windowName, String attachText) throws Exception {
		return windowName.describe(TreeView.class, new TreeViewDescription.Builder().attachedText(attachText).build());
	}

	public static Editor getEditorObject(Window windowName, String attachedText) throws Exception {
		return windowName.describe(Editor.class, new EditorDescription.Builder().attachedText(attachedText).build());
	}

	public static Editor getEditorObjectWithNativeClass(Window windowName, String attachedText, String nativeClass)
			throws Exception {
		return windowName.describe(Editor.class,
				new EditorDescription.Builder().attachedText(attachedText).nativeClass(nativeClass).build());
	}

	public static Editor getEditorObjectWithIndex(Window windowName, String attachedText, String nativeClass, int index)
			throws Exception {
		return windowName.describe(Editor.class, new EditorDescription.Builder().attachedText(attachedText)
				.nativeClass(nativeClass).index(index).build());
	}

	public static Editor getEditorObjectWithIndex(Window windowName, String nativeClass, int index) throws Exception {
		return windowName.describe(Editor.class,
				new EditorDescription.Builder().nativeClass(nativeClass).index(index).build());
	}

	public static List getListObject(Window windowName, String attachedText) throws Exception {
		return windowName.describe(List.class, new ListDescription.Builder().attachedText(attachedText).build());
	}

	public static List getListObjectWithIndex(Window windowName, String attachedText, int index) throws Exception {
		return windowName.describe(List.class,
				new ListDescription.Builder().attachedText(attachedText).index(index).build());
	}

	public static Table getTableObject(Window windowName, String nativeClassValue) throws Exception {
		return windowName.describe(Table.class, new TableDescription.Builder().nativeClass(nativeClassValue).build());
	}

	public static Table getTableObject(Window windowName) throws Exception {
		return windowName.describe(Table.class, new TableDescription.Builder().build());
	}

	public static Table getTableObject(Window windowName, String nativeClassValue, String tagName) throws Exception {
		return windowName.describe(Table.class,
				new TableDescription.Builder().nativeClass(nativeClassValue).tagName(tagName).build());
	}

	public static Table getTableObjectWithAttachText(Window windowName, String nativeClassValue, String attachedText)
			throws Exception {
		return windowName.describe(Table.class,
				new TableDescription.Builder().nativeClass(nativeClassValue).attachedText(attachedText).build());
	}

	public static Table getTableObjectWithIndex(Window windowName, String nativeClassValue, int index)
			throws Exception {
		return windowName.describe(Table.class,
				new TableDescription.Builder().nativeClass(nativeClassValue).index(index).build());
	}

	public static Menu getMenuObject(Window windowName, String labelMenuName, String labelMenuOption) throws Exception {
		return windowName.describe(Menu.class, new MenuDescription.Builder().label(labelMenuName).build())
				.describe(Menu.class, new MenuDescription.Builder().label(labelMenuOption).build());
	}

	public static Menu getMenuObject(Menu menuName, String labelMenuName) throws Exception {
		return menuName.describe(Menu.class, new MenuDescription.Builder().label(labelMenuName).build());
	}

	public static Menu getMenuObject2(Window windowName, String labelMenuName, String labelMenuOption,
			String nativeClass) throws Exception {
		return windowName
				.describe(Menu.class,
						new MenuDescription.Builder().label(labelMenuName).nativeClass(nativeClass).build())
				.describe(Menu.class, new MenuDescription.Builder().label(labelMenuOption).build());
	}

	public static Menu getMenuObject(Window windowName, String labelMenuName) throws Exception {
		return windowName.describe(Menu.class, new MenuDescription.Builder().label(labelMenuName).build());
	}

	public static Menu getMenuObjectWithPath(Window windowName, String labelMenuName, String path) throws Exception {
		return windowName.describe(Menu.class, new MenuDescription.Builder().label(labelMenuName).path(path).build());
	}

	public static Menu getMenuObjectWithPath(Window windowName, String labelMenuName, String path, String nativeClass)
			throws Exception {
		return windowName.describe(Menu.class,
				new MenuDescription.Builder().label(labelMenuName).path(path).nativeClass(nativeClass).build());
	}

	// IRIS - Web Locators
	public static WebElement getWebElementByInnerText(Browser browser, String innerTextValue) throws Exception {
		return browser.describe(WebElement.class,
				new WebElementDescription.Builder().innerText(innerTextValue).tagName("SPAN").build());
	}

	public static WebElement getWebElementByClassName(Browser browser, String className) throws Exception {
		return browser.describe(WebElement.class,
				new WebElementDescription.Builder().className(className).tagName("SPAN").build());
	}

	public static ListBox getListBoxObject(Browser browser, String name) throws Exception {
		return browser.describe(ListBox.class, new ListBoxDescription.Builder().name(name).tagName("UL").build());
	}

	public static ListBox getListBoxObject(Browser browser, String name, int indexValue) throws Exception {
		return browser.describe(ListBox.class,
				new ListBoxDescription.Builder().name(name).role("combobox").tagName("DIV").index(indexValue).build());
	}

	public static com.hp.lft.sdk.web.Table getWebTableObject(Browser browser, String className, int indexValue)
			throws Exception {
		return browser.describe(com.hp.lft.sdk.web.Table.class, new com.hp.lft.sdk.web.TableDescription.Builder()
				.className(className).index(indexValue).tagName("TABLE").build());
	}

	public static EditField getWebEditorObject(Browser _browser, String fieldName, String tagName, String tagType)
			throws GeneralLeanFtException {
		return _browser.describe(EditField.class,
				new EditFieldDescription.Builder().name(fieldName).tagName(tagName).type(tagType).build());

	}

	public static UiObject getJPanelUiObject(String windowTitle, String dialogTitle, String attachedText) throws GeneralLeanFtException {
		return Desktop.describe(Window.class, new WindowDescription.Builder()
				.title(windowTitle).build())
				.describe(Dialog.class, new DialogDescription.Builder()
				.title(dialogTitle).build())
				.describe(UiObject.class, new UiObjectDescription.Builder()
				.attachedText(new RegExpProperty(attachedText))
				.nativeClass("javax.swing.JPanel")
				.path("JPanel;JPanel;JPanel;JOptionPane;JPanel;JLayeredPane;JRootPane;JDialog;AssignFrame;")
				.tagName("JPanel")
				.text(attachedText).build());
	}
	
	public static ListBox getListBoxObject(Browser browser, String name, String tagName) throws Exception {
		return browser.describe(ListBox.class,
				new ListBoxDescription.Builder().name(name).tagName(tagName).build());
	}
	
	public static List getListObject(Window windowName, String attachedText, int indexNumber) throws Exception {
		return windowName.describe(List.class, new ListDescription.Builder().attachedText(attachedText).nativeClass("javax.swing.JComboBox").index(indexNumber).build());
	}
}
