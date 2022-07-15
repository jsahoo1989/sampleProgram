package com.aires.iris.helpers;

import java.sql.Timestamp;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.testng.Assert;

import com.aires.businessrules.constants.IRISConstants;
import com.aires.utilities.Log;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.ButtonDescription;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.DialogDescription;
import com.hp.lft.sdk.java.Editor;
import com.hp.lft.sdk.java.Label;
import com.hp.lft.sdk.java.List;
import com.hp.lft.sdk.java.ListItem;
import com.hp.lft.sdk.java.Menu;
import com.hp.lft.sdk.java.RadioButton;
import com.hp.lft.sdk.java.TabControl;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.TreeView;
import com.hp.lft.sdk.java.Window;

public class Helpers {

	public Helpers() throws Exception {
	}

	static DefaultMutableTreeNode _searchNode;
	static TreeNode _treeRoot;

	public static void setEditorText(Editor editor, String text, String elementName) {
		try {
			editor.waitUntilEnabled();
			editor.setText(text);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public static void clickButton(Button button, String elementName) {
		try {
			button.waitUntilEnabled();
			button.click();
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public static void clickLabel(Label label, String elementName) {
		try {
			label.waitUntilEnabled();
			label.click();
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public static void clickRadioButton(RadioButton radioButton, String elementName) {
		try {
			radioButton.waitUntilEnabled();
			radioButton.click();
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public static void selectFromList(List list, String option, String elementName) {
		try {
			list.waitUntilVisible();
			list.select(option);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public static void selectMenu(Menu menuName, String elementName) throws Exception {
		try {
			menuName.waitUntilVisible();
			menuName.select();
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public static void setTableCellValue(Table table, int rowCount, String columnName, String value)
			throws GeneralLeanFtException {
		table.waitUntilVisible();
		if (table.getRows().size() > 0 & table.getColumnHeaders().contains(columnName)) {
			table.getCell(rowCount, columnName).setValue(value);
			// table.getRows().
		} else {
			Assert.fail("The column name was not found");
		}
	}

	public static void selectTableRow(Table table, int rowNumber) throws GeneralLeanFtException {
		table.selectRows(rowNumber);
	}

	public static void deSelectTableRow(Table table, int rowNumber) throws GeneralLeanFtException {
		table.deselectRows(rowNumber);
	}

	public static void selectTreeNode(JTree tree, String nodeName) {
		_searchNode = searchNode(_treeRoot, nodeName);
		if (_searchNode != null) {
			TreeNode[] nodes = ((DefaultTreeModel) tree.getModel()).getPathToRoot(_searchNode);
			TreePath tpath = new TreePath(nodes);
			tree.scrollPathToVisible(tpath);
			tree.setSelectionPath(tpath);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static DefaultMutableTreeNode searchNode(TreeNode root, String nodeName) {
		DefaultMutableTreeNode node = null;		
		Enumeration enumeration = _searchNode.breadthFirstEnumeration();
		while (enumeration.hasMoreElements()) {
			node = (DefaultMutableTreeNode) enumeration.nextElement();
			if (nodeName.equals(node.getUserObject().toString())) {
				return node;
			}
		}
		// tree node return null
		return null;
	}

	public static void selectTreeViewNode(TreeView treeView, String nodeName) throws Exception {
		// treeView.select(nodeName);
	}

	public static void saveChanges(Window window) throws Exception {
		Button saveButton = window.describe(Button.class, new ButtonDescription.Builder().label("Save").build());
		Dialog saveSuccessfulDialog = window.describe(Dialog.class,
				new DialogDescription.Builder().title("Save successful.").build());
		Button oKButton = saveSuccessfulDialog.describe(Button.class,
				new ButtonDescription.Builder().label("OK").build());
		clickButton(saveButton, "Save");
		clickButton(oKButton, "Ok");
	}

	/**
	 * Search and select item from dialog.
	 * 
	 * @param listObj
	 * @param elementName
	 * @param searchText
	 */
	public static void selectItemFromDialog(List listObj, String item, String searchText) {
		try {
			listObj.waitUntilVisible();
			java.util.List<ListItem> resultList = listObj.getItems();
			for (ListItem row : resultList) {
				if (row.getText().contains(searchText)) {
					Log.info(" File id " + searchText + " found");
					listObj.select(row);
					break;
				}
			}
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Select/click the tab passed as parameter.
	 * 
	 * @param tabObj
	 * @param tabName
	 */
	public static void selectTabControl(TabControl tabObj, String tabName) {
		try {
			tabObj.waitUntilVisible();
			tabObj.select(tabName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verfiy landed on Tab.
	 * 
	 * @param tabName
	 * @param btnName
	 */
	public static void verifyLandedOnTab(String tabName, Button btnName) {
		try {
			btnName.waitUntilVisible();
			if (btnName.isVisible()) {
			} else {
				Assert.fail(IRISConstants.FAILED_TO_LOAD_TEXT + tabName);
			}
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Generate unique employeeid.
	 * 
	 * @return
	 */
	public static String generateEmpId() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String empNum = Long.toString(timestamp.getTime());
		return empNum;
	}

	public static String generateEmailAddress() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String empNum = Long.toString(timestamp.getTime());
		String emailId = empNum + IRISConstants.AIRES_DOMAIN;
		return emailId;
	}

	/**
	 * Search and verify Selected Item in List
	 * 
	 * @param listObj
	 * @param searchText
	 * @return
	 */
	public static boolean searchAndVerifySelectedItemInList(List listObj, String searchText) {
		boolean _isExists = false;
		try {
			listObj.waitUntilVisible();
			java.util.List<ListItem> resultList = listObj.getSelectedItems();
			for (ListItem row : resultList) {
				if (row.getText().equals(searchText)) {
					_isExists = true;
					break;
				}
			}
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
		return _isExists;
	}

	/**
	 * Search a value in table
	 * 
	 * @param table
	 * @param searchColumnName
	 * @param searchString
	 * @param columnValueToBeReturned
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public static String searchJTable(Table table, String searchColumnName, String searchString,
			String columnValueToBeReturned) throws GeneralLeanFtException {
		table.waitUntilVisible();
		String returnValue = null;
		if (table.getRows().size() > 0 & table.getColumnHeaders().contains(searchColumnName)) {
			for (int rowCount = 0; rowCount < table.getRows().size(); rowCount++) {
				if (table.getCell(rowCount, searchColumnName).getValue().toString().equals(searchString)) {
					returnValue = table.getCell(rowCount, columnValueToBeReturned).getValue().toString();
					break;
				}
			}
		} else {
			Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
		}
		return returnValue;
	}

	/**
	 * Search a value in table
	 * 
	 * @param table
	 * @param searchColumnName
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public static boolean searchJTableColumn(Table table, String searchColumnName) throws GeneralLeanFtException {
		table.waitUntilVisible();
		if (table.getRows().size() > 0 & table.getColumnHeaders().contains(searchColumnName)) {
			return true;
		} else {
			Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
			return false;
		}
	}

	public static int getTableRowCount(Table table) throws Exception {
		return table.getRows().size();
	}

	public static void handleMessageDialog(Window window) throws Exception {
		Dialog messageDialog = window.describe(Dialog.class, new DialogDescription.Builder().title("Message").build());
		Button oKButton = messageDialog.describe(Button.class, new ButtonDescription.Builder().label("OK").build());
		oKButton.click();
	}

	public static void printColumnHeaders(Table tableObject) throws GeneralLeanFtException {		
		for(int i=0; i<tableObject.getColumnHeaders().size();i++) {
			System.out.println(tableObject.getColumnHeaders().get(i));
		}
	}
	
	public static int getRowIdMatchingCellValue(Table table, String searchColumnName, String searchString)
			throws GeneralLeanFtException {
		table.waitUntilVisible();
		if (table.getRows().size() > 0 & table.getColumnHeaders().contains(searchColumnName)) {
			for (int rowCount = 0; rowCount < table.getRows().size(); rowCount++) {
				if (table.getCell(rowCount, searchColumnName).getValue().toString().equals(searchString)) {
					return rowCount;
				}
			}
		} else {
			Assert.fail(IRISConstants.COLUMN_NAME_NOT_FOUND);
		}
		return -1;
	}
}
