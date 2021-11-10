package com.aires.utilities;

import java.util.ArrayList;
import java.util.Hashtable;

public class TestUtil {

	public static boolean IsExecutable(String TestCaseName, Xls_Reader xls) {
		for (int rNum = 2; rNum <= xls.getRowCount("Test Cases"); rNum++) {
			if (xls.getCellData("Test Cases", "TestScenario", rNum).equals(TestCaseName)) {
				if (xls.getCellData("Test Cases", "RunMode", rNum).equals("Y")) {
					return true;
				} else {
					return false;
				}
			}
		}

		return false;
	}

	public static Object[][] getdata(String TestCaseName, Xls_Reader xls, String SheetName) {

		int TestCaseStartIndex = 0;
		for (int rNum = 1; rNum <= xls.getRowCount(SheetName); rNum++) {

			if (xls.getCellData(SheetName, 0, rNum).equals(TestCaseName)) {
				TestCaseStartIndex = rNum;
				break;
			}
		}
		System.out.println("Test case start index is = " + "" + TestCaseStartIndex);

		int TestColStartIndex = TestCaseStartIndex + 1;
		int Col = 0;
		while (!xls.getCellData(SheetName, Col, TestColStartIndex).equals("")) {
			Col++;
		}
		System.out.println("Total columns inside the above test case is = " + Col);

		int RowStartIndex = TestCaseStartIndex + 2;
		int Row = 0;
		while (!xls.getCellData(SheetName, 0, (RowStartIndex + Row)).equals("")) {
			Row++;
		}
		System.out.println("Total rows inside the above test case is = " + Row);

		Object[][] data = new Object[Row][1];
		Hashtable<String, String> table = null;
		for (int rNum = RowStartIndex; rNum < (RowStartIndex + Row); rNum++) {
			table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < Col; cNum++) {
				table.put(xls.getCellData(SheetName, cNum, TestColStartIndex), xls.getCellData(SheetName, cNum, rNum));
			}
			data[rNum - (RowStartIndex)][0] = table;
		}
		return data;
	}

	public static Object[][] setdata(String TestCaseName, Xls_Reader xls, String SheetName) {

		int TestCaseStartIndex = 0;
		for (int rNum = 1; rNum <= xls.getRowCount(SheetName); rNum++) {

			if (xls.getCellData(SheetName, 0, rNum).equals(TestCaseName)) {
				TestCaseStartIndex = rNum;
				break;
			}
		}

		System.out.println("Test case start index is = " + TestCaseStartIndex);
		int TestColStartIndex = TestCaseStartIndex + 1;
		int Col = 0;
		while (!xls.getCellData(SheetName, Col, TestColStartIndex).equals("")) {
			Col++;
		}
		return setdata(null, null, null);
	}

	public static String getExcelValueForColumnName(String TestCaseName, Xls_Reader xls, String SheetName, int colNum,
			int rowNum) {
		int TestCaseStartIndex = 0;
		for (int rNum = 1; rNum <= xls.getRowCount(SheetName); rNum++) {
			if (xls.getCellData(SheetName, colNum, rNum).equals(TestCaseName)) {
				TestCaseStartIndex = rNum;
				break;
			}
		}
		return xls.getCellData(SheetName, rowNum, TestCaseStartIndex).toString();
	}

	public static String getExcelValueForColumnName(String TestCaseName, Xls_HSSFReader xls, String SheetName,
			int colNum, int rowNum) {
		int TestCaseStartIndex = 0;
		for (int rNum = 1; rNum <= xls.getRowCount(SheetName); rNum++) {
			if (xls.getCellData(SheetName, colNum, rNum).equals(TestCaseName)) {
				TestCaseStartIndex = rNum;
				break;
			}
		}
		return xls.getCellData(SheetName, rowNum, TestCaseStartIndex).toString();

	}

	public static ArrayList<String> getListOfCellValueOfAColumnName(String TestCaseName, Xls_HSSFReader xls,
			String SheetName, int colNum) {
		ArrayList<String> listData = new ArrayList<String>();
		int TestCaseStartIndex = 0;
		System.out.println("SheetName : " + SheetName);
		System.out.println("TestCaseName : " + TestCaseName);
		
		for (int rNum = 1; rNum <= xls.getRowCount(SheetName); rNum++) {
			if (xls.getCellData(SheetName, colNum, rNum).equals(TestCaseName)) {
				TestCaseStartIndex = rNum;
				for (int rNum1 = 3; rNum1 <= xls.getRowCount(SheetName); rNum1++) {
					listData.add(xls.getCellData(SheetName, colNum, rNum1).toString());
				}
			}
		}
		System.out.println(listData + "***excel");
		return listData;
		// break;
	}

	public static ArrayList<String> getColumnNamesFromExcel(Xls_HSSFReader xls, String SheetName) {
		ArrayList<String> listColData = new ArrayList<String>();
		int rNum = 2;
		for (int cNum = 0; cNum < xls.getColumnCounts(SheetName); cNum++) {
			listColData.add(xls.getCellData(SheetName, cNum, rNum).toString().toUpperCase());
		}
		System.out.println("excel : " + listColData);
		return listColData;
	}

	public static int getTotalNumberOfRows(Xls_HSSFReader xls, String SheetName) {
		int totalRows;
		totalRows = xls.getRowCount(SheetName);
		System.out.println(totalRows);
		return totalRows;

	}
}
