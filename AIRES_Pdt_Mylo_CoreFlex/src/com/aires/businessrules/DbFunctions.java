package com.aires.businessrules;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.DbQueries;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.utilities.Log;

public class DbFunctions {

	static LinkedHashMap<String, String> myloQueryStatementMap = new LinkedHashMap<String, String>();
	static LinkedHashMap<String, String> myloQTableColumnFields = new LinkedHashMap<String, String>();
	static String environment = System.getProperty("envt").toLowerCase();
	// static String environment =
	// CoreFunctions.getPropertyFromConfig("envt").toLowerCase();

	static LinkedHashMap<String, String> pdtExpenseCodeQueryStatementMap = new LinkedHashMap<String, String>();
	
	public static String getDBConnectionStringAsPerEnvt(String envt) {
		String dbURL = null;
		switch (envt) {
		case "qa":
			dbURL = "jdbc:oracle:thin:isisdba/irisqaisisdba@corpqavl300.corp.aires.com:1521:IRISQA";
			//dbURL = "jdbc:oracle:thin:isisdba/irisnextisisdba@corptesvl300.corp.aires.com:1521:IRISNEXT";
			break;
		case "dev":
			dbURL = "jdbc:oracle:thin:isisdba/irisdevisisdba@corptesvl300.corp.aires.com:1521:IRISDEV";
			break;
		case "test":
			//dbURL = "jdbc:oracle:thin:policydba/testpo@corptesvl300.corp.aires.com:1521:IRISTEST";
			dbURL = "jdbc:oracle:thin:isisdba/iristestisisdba@corptesvl300.corp.aires.com:1521:iristest";
			break;
		case "prod":
			// For Production Envt. - Change username/Password & verify DB connection
			// details
			dbURL = "jdbc:oracle:thin:isisdba/iristestisisdba@corpprdl200.corp.aires.com:1521:IRIS";
			break;
		case "uat":
			dbURL = "jdbc:oracle:thin:policydba/uatpo@corpqavl300.corp.aires.com:1521:IRISUAT";
			break;
		case "preprod":
			dbURL = "jdbc:oracle:thin:isisdba/iristestisisdba@corptesvl300.corp.aires.com:1521:iristest";
			break;

		default:
			Assert.fail(PDTConstants.DATABASE_CONNECTION + PDTConstants.NOT_EXIST);
		}
		return dbURL;
	}

	public static void deletePolicyByPolicyId(int policyId) {
		Connection connection = null;
		try {
			connection = getConnection();
			CallableStatement callableStatement = connection
					.prepareCall(DbQueries.CALL_PROCEDURE_DELETE_POLICY_BY_ID);			
			callableStatement.setInt(1, policyId);
			callableStatement.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(CoreConstants.ERROR + "Fail to call procedure");
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				Assert.fail(CoreConstants.ERROR + "Fail to close connection");
			}
		}
	}

	public static String getMyloDBConnectionStringAsPerEnvt(String envt) {
		String dbURL = null;
		switch (envt) {
		case "relonetqa4":
			dbURL = "jdbc:oracle:thin:isisdba/irisuatisisdba@corpqavl300.corp.aires.com:1521:irisuat";
			break;
		case "dev5":
			dbURL = "jdbc:oracle:thin:irisuser/nextir@corptesvl300.corp.aires.com:1521:irisnext";
			break;
		case "test":
			dbURL = "jdbc:oracle:thin:policydba/testpo@corptesvl300.corp.aires.com:1521:IRISTEST";
			break;
		case "prod":
			// For Production Envt. - Change username/Password & verify DB connection
			dbURL = "jdbc:oracle:thin:isisdba/iristestisisdba@corpprdl200.corp.aires.com:1521:IRIS";
			break;
		case "uat":
			dbURL = "jdbc:oracle:thin:irisuser/uatir@corpqavl300.corp.aires.com:1521:irisuat";
			break;
		case "preprod":
			dbURL = "jdbc:oracle:thin:irisuser/testir@corptesvl300.corp.aires.com:1521:iristest";
			break;
		default:
			Assert.fail(PDTConstants.DATABASE_CONNECTION + PDTConstants.NOT_EXIST);
		}
		return dbURL;
	}

	public static List<String> getIdentTypeOptionsFromDB() {
		List<String> identityTypeList = new ArrayList<String>();
		Connection connection = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(getMyloDBConnectionStringAsPerEnvt(environment));
			PreparedStatement pst = connection.prepareStatement(DbQueries.QUERY_GET_IDENTITY_TYPE_DROPDOWNLIST);
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				identityTypeList.add(resultset.getString("IDENTIFICATION_TYPE_DESC"));
			}

		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex.getMessage());
			Log.info(CoreConstants.ERROR + ex.getStackTrace());
			Assert.fail(CoreConstants.SQL_QUERY_FAILED);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				Log.info(CoreConstants.ERROR + ex.getMessage());
				Log.info(CoreConstants.ERROR + ex.getStackTrace());
			}
		}
		return identityTypeList;
	}

	public static void mapMyloQueryStatements() {
		myloQueryStatementMap.put(MYLOConstants.MARITAL_STATUS, DbQueries.QUERY_GET_MARITAL_STATUS_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.PRONOUNS, DbQueries.QUERY_GET_PRONOUNS_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.CITIZENSHIP, DbQueries.QUERY_GET_COUNTRY_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.TRANSFEREE_EMAIL_TYPE,
				DbQueries.QUERY_GET_TRANSFEREE_EMAIL_TYPE_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.TRANSFEREE_PHONE_TYPE, DbQueries.QUERY_GET_PHONE_TYPE_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.TRANSFEREE_ORGDEST, DbQueries.QUERY_GET_LOCATION_TYPE_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.GENDER, DbQueries.QUERY_GET_GENDER_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.VIP, DbQueries.QUERY_GET_MYFILES_INFO_BY_STATUS_AND_VIP);
		myloQueryStatementMap.put(MYLOConstants.EVIP, DbQueries.QUERY_GET_MYFILES_INFO_BY_STATUS_AND_EVIP);
		myloQueryStatementMap.put(MYLOConstants.CONFIDENTIAL,
				DbQueries.QUERY_GET_MYFILES_INFO_BY_STATUS_AND_CONFIDENTIAL);

	}

	public static void mapTableColumnFields() {
		myloQTableColumnFields.put(MYLOConstants.MARITAL_STATUS, MYLOConstants.MARITAL_STATUS_COLUMN);
		myloQTableColumnFields.put(MYLOConstants.PRONOUNS, MYLOConstants.PRONOUN_COLUMN);
		myloQTableColumnFields.put(MYLOConstants.CITIZENSHIP, MYLOConstants.COUNTRY_COLUMN);
		myloQTableColumnFields.put(MYLOConstants.TRANSFEREE_EMAIL_TYPE, MYLOConstants.EMAIL_TYPE_COLUMN);
		myloQTableColumnFields.put(MYLOConstants.TRANSFEREE_PHONE_TYPE, MYLOConstants.PHONE_TYPE_COLUMN);
		myloQTableColumnFields.put(MYLOConstants.TRANSFEREE_ORGDEST, MYLOConstants.LOCATION_TYPE_COLUMN);
		myloQTableColumnFields.put(MYLOConstants.GENDER, MYLOConstants.GENDER_MARKER_DESCRIPTION);

	}

	public static List<String> getTransfereeDropdownListValues(String fieldName) {
		mapMyloQueryStatements();
		mapTableColumnFields();
		List<String> requiredList = new ArrayList<String>();
		Connection connection = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(getMyloDBConnectionStringAsPerEnvt(environment));
			PreparedStatement pst = connection.prepareStatement(myloQueryStatementMap.get(fieldName));
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				requiredList.add(resultset.getString(myloQTableColumnFields.get(fieldName)));
			}

		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex.getMessage());
			Log.info(CoreConstants.ERROR + ex.getStackTrace());
			Assert.fail(CoreConstants.SQL_QUERY_FAILED + "for " + fieldName);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				Log.info(CoreConstants.ERROR + ex.getMessage());
				Log.info(CoreConstants.ERROR + ex.getStackTrace());
			}
		}
		return requiredList;
	}

	public static List<String> getMyFilesInfoByStatusAndCheckBox(String empNo, String status, String checkbox,
			String reqColumn, String noOfRecords, String type) {
		mapMyloQueryStatements();
		Connection connection = null;
		List<String> requiredList = new ArrayList<String>();
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(getMyloDBConnectionStringAsPerEnvt(environment));
			String query = (type.equals(MYLOConstants.CHECKBOX)) ? myloQueryStatementMap.get(checkbox)
					: DbQueries.QUERY_GET_MYFILES_INFO_BY_STATUS_AND_USER;
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, empNo);
			pst.setString(2, status);
			pst.setString(3, noOfRecords);
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				requiredList.add(resultset.getString(reqColumn));
			}
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex.getMessage());
			Log.info(CoreConstants.ERROR + ex.getStackTrace());
			Assert.fail(CoreConstants.SQL_QUERY_FAILED + "for " + status);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				Log.info(CoreConstants.ERROR + ex.getMessage());
				Log.info(CoreConstants.ERROR + ex.getStackTrace());
			}
		}
		return requiredList;
	}

	public static List<String> getAccountingFilesInfoByServiceAndServiceStatus(String service, String serviceStatus,
			String reqColumn, String noOfRecords) {
		Connection connection = null;
		List<String> requiredList = new ArrayList<String>();
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(getMyloDBConnectionStringAsPerEnvt(environment));
			PreparedStatement pst = connection
					.prepareStatement(DbQueries.QUERY_GET_ACCOUNTING_FILES_INFO_BY_SERVICE_AND_SERVICE_STATUS);
			pst.setString(1, service);
			pst.setString(2, serviceStatus);
			ResultSet resultset = pst.executeQuery();
			requiredList = getRequiredResultSet(resultset, noOfRecords, reqColumn);
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex.getMessage());
			Log.info(CoreConstants.ERROR + ex.getStackTrace());
			Assert.fail(CoreConstants.SQL_QUERY_FAILED + "for " + service);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				Log.info(CoreConstants.ERROR + ex.getMessage());
				Log.info(CoreConstants.ERROR + ex.getStackTrace());
			}
		}
		return requiredList;
	}

	public static List<String> getRequiredResultSet(ResultSet resultset, String noOfRecords, String reqColumn) {
		List<String> requiredList = new ArrayList<String>();
		int flag = 1;
		try {
			while (resultset.next()) {
				requiredList.add(resultset.getString(reqColumn));
				if (flag == Integer.parseInt(noOfRecords))
					break;
				flag++;
			}
		} catch (SQLException e) {
			Assert.fail(e.getMessage());
		}
		return requiredList;
	}

	public static List<String> getMyFilesSortResult(String empNo, String status, String colName, String sortOrder,
			String noOfRecords) {
		Connection connection = null;
		List<String> requiredList = new ArrayList<String>();
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(getMyloDBConnectionStringAsPerEnvt(environment));
			PreparedStatement pst = connection
					.prepareStatement(DbQueries.QUERY_GET_MYFILES_INFO_BY_STATUS_AND_SORT_ORDER + " ORDER BY " + colName
							+ " " + sortOrder + ",FILEID asc");
			pst.setString(1, empNo);
			pst.setString(2, status);
			ResultSet resultset = pst.executeQuery();
			int flag = 1;
			int maxRow = Integer.parseInt(noOfRecords);
			while (resultset.next()) {
				requiredList.add(resultset.getString(MYLOConstants.FILEID));
				if (flag == maxRow)
					break;
				flag++;
			}
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex.getMessage());
			Log.info(CoreConstants.ERROR + ex.getStackTrace());
			Assert.fail(CoreConstants.SQL_QUERY_FAILED + "for sorting" + colName);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				Log.info(CoreConstants.ERROR + ex.getMessage());
				Log.info(CoreConstants.ERROR + ex.getStackTrace());
			}
		}
		return requiredList;
	}

	public static List<String> getAccountingSortResult(String service, String serviceStatus, String colName,
			String sortOrder, String noOfRecords) {
		Connection connection = null;
		List<String> requiredList = new ArrayList<String>();
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(getMyloDBConnectionStringAsPerEnvt(environment));
			PreparedStatement pst = connection
					.prepareStatement(DbQueries.QUERY_GET_ACCOUNTING_FILES_INFO_BY_SERVICE_AND_STATUS_AND_SORT_ORDER
							+ " ORDER BY " + colName + " " + sortOrder + ",FILEID asc");
			pst.setString(1, service);
			pst.setString(2, serviceStatus);
			ResultSet resultset = pst.executeQuery();
			requiredList = getRequiredResultSet(resultset, noOfRecords, MYLOConstants.FILEID);
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex.getMessage());
			Log.info(CoreConstants.ERROR + ex.getStackTrace());
			Assert.fail(CoreConstants.SQL_QUERY_FAILED + "for sorting" + colName);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				Log.info(CoreConstants.ERROR + ex.getMessage());
				Log.info(CoreConstants.ERROR + ex.getStackTrace());
			}
		}
		return requiredList;
	}

	public static String getMyloAssignmentRequiredFieldValues(String assignmentID, String colName) {
		Connection connection = null;
		String requiredValue = "";
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(getMyloDBConnectionStringAsPerEnvt(environment));
			PreparedStatement pst = connection.prepareStatement(DbQueries.QUERY_GET_ASSIGNMENT_FIELD_VALUES);
			pst.setString(1, assignmentID);
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				requiredValue = resultset.getString(colName);
			}
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex.getMessage());
			Log.info(CoreConstants.ERROR + ex.getStackTrace());
			Assert.fail(CoreConstants.SQL_QUERY_FAILED + " for " + colName);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				Log.info(CoreConstants.ERROR + ex.getMessage());
				Log.info(CoreConstants.ERROR + ex.getStackTrace());
			}
		}
		return requiredValue;
	}
	
	public static void updateAssignmentStatus(String assignmentStatusCode, int policyId) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement pstChangeStatus = connection.prepareStatement(DbQueries.QUERY_UPDATE_ASSIGNMENT_STATUS);
			pstChangeStatus.setString(1, assignmentStatusCode);
			pstChangeStatus.setString(2, null);
			pstChangeStatus.setInt(3, policyId);
			pstChangeStatus.setString(4, CoreFunctions.getCurrentDateAsGivenFormat("dd-MM-yyyy"));
			System.out.println("prepared statement query=="+pstChangeStatus.toString());
			
			pstChangeStatus.executeUpdate();	
			connection.close();
		} catch (Exception ex) {
			Assert.fail("SQL Query Failed");
		}
	}
	
	public static void populatePDTExpenseCodeQueryStatements() {
		pdtExpenseCodeQueryStatementMap.put(PDTConstants.PRE_ACCEPTANCE_SERVICES, DbQueries.QUERY_GET_PRE_ACCEPTANCE_EXPENSE_CODE);
		pdtExpenseCodeQueryStatementMap.put(PDTConstants.IMMIGRATION, DbQueries.QUERY_GET_IMMIGRATION_EXPENSE_CODE);
		pdtExpenseCodeQueryStatementMap.put(PDTConstants.HOUSE_HUNTING_TRIP, DbQueries.QUERY_GET_HOUSE_HUNTING_TRIP_EXPENSE_CODE);
		pdtExpenseCodeQueryStatementMap.put(PDTConstants.LANGUAGE_TRAINING, DbQueries.QUERY_GET_LANG_TRAIN_EXPENSE_CODE);
		pdtExpenseCodeQueryStatementMap.put(PDTConstants.CULTURAL_TRAINING, DbQueries.QUERY_GET_CULT_TRAIN_EXPENSE_CODE);
	}
	
	public static List<String> getExpenseCodeListForBenefit(String benefitName) {
		populatePDTExpenseCodeQueryStatements();		
		List<String> expenseCodeList = new ArrayList<String>();
		Connection connection = null;		
		try {
			connection = getConnection();		
			PreparedStatement pst = connection.prepareStatement(pdtExpenseCodeQueryStatementMap.get(benefitName));
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				expenseCodeList.add(resultset.getString("EXPENSE_CODE")+" - "+ resultset.getString("DESCRIPTION"));
			}
		
		} catch (Exception ex) {			
			Assert.fail(CoreConstants.SQL_QUERY_FAILED);
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception ex){
				Log.info(CoreConstants.ERROR+ex.getMessage());
				Log.info(CoreConstants.ERROR+ex.getStackTrace());
			}
		}
		return expenseCodeList;
	}
	
	public static Connection getConnection() {
		Connection connection = null;	
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
			getMyloDBConnectionStringAsPerEnvt(System.getProperty("envt")));
			/*Kept the commented code for running in local environment
			 * connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt")));*/
		} catch (SQLException e) {
			Assert.fail("Failed to establish connection to the database");
		}
		return connection;
	}
	
	public static List<String> getExpenseCodeForBenefit(String benefitName) {
		populatePDTExpenseCodeQueryStatements();		
		List<String> expenseCodeList = new ArrayList<String>();
		Connection connection = null;		
		try {
			connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(pdtExpenseCodeQueryStatementMap.get(benefitName));
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				expenseCodeList.add(resultset.getString("EXPENSE_CODE"));
			}
		
		} catch (Exception ex) {			
			Assert.fail(CoreConstants.SQL_QUERY_FAILED);
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception ex){
				Log.info(CoreConstants.ERROR+ex.getMessage());
				Log.info(CoreConstants.ERROR+ex.getStackTrace());
			}
		}
		return expenseCodeList;
	}
}