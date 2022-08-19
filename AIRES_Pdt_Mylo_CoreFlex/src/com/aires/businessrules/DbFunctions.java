package com.aires.businessrules;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public static String getDBConnectionStringAsPerEnvt(String envt) {
		String dbURL = null;
		switch (envt) {
		case "qa":
			dbURL = "jdbc:oracle:thin:isisdba/irisqaisisdba@corpqavl300.corp.aires.com:1521:IRISQA";
			break;
		case "dev":
			dbURL = "jdbc:oracle:thin:isisdba/irisdevisisdba@corptesvl300.corp.aires.com:1521:IRISDEV";
			break;
		case "test":
			dbURL = "jdbc:oracle:thin:policydba/testpo@corptesvl300.corp.aires.com:1521:IRISTEST";
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
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			/*connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));*/
			
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(System.getProperty("envt").toLowerCase()));
			CallableStatement callableStatement = connection
					.prepareCall(DbQueries.CALL_PROCEDURE_DELETE_POLICY_BY_ID);			
			
			callableStatement.setInt(1, policyId);
			callableStatement.execute();
		} catch (Exception ex) {
			Assert.fail(CoreConstants.ERROR + "Fail to call procedure");
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception ex){
				Assert.fail(CoreConstants.ERROR + "Fail to close connection");
			}
		}
	}
	
	public static String getMyloDBConnectionStringAsPerEnvt(String envt) {
		String dbURL = null;
		switch (envt) {
		case "RELONETQA4":
			//dbURL = "jdbc:oracle:thin:irisuser/nextir@corptesvl300.corp.aires.com:1521:irisnext";
			dbURL = "jdbc:oracle:thin:isisdba/irisuatisisdba@corpqavl300.corp.aires.com:1521:irisuat";
			break;
		case "DEV5":
			dbURL = "jdbc:oracle:thin:irisuser/nextir@corptesvl300.corp.aires.com:1521:irisnext";				 
			break;
		case "TEST":
			dbURL = "jdbc:oracle:thin:policydba/testpo@corptesvl300.corp.aires.com:1521:IRISTEST";
			break;
		case "PROD":
			// For Production Envt. - Change username/Password & verify DB connection
			// details
			dbURL = "jdbc:oracle:thin:isisdba/iristestisisdba@corpprdl200.corp.aires.com:1521:IRIS";
			break;
		case "UAT":
			dbURL = "jdbc:oracle:thin:irisuser/uatir@corpqavl300.corp.aires.com:1521:irisuat";
			break;
		case "PREPROD":
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
			connection = DriverManager.getConnection(
					getMyloDBConnectionStringAsPerEnvt(System.getProperty("envt")));			
			//connection = DriverManager.getConnection(
				//	getMyloDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt")));			
			PreparedStatement pst = connection.prepareStatement(DbQueries.QUERY_GET_IDENTITY_TYPE_DROPDOWNLIST);
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				identityTypeList.add(resultset.getString("IDENTIFICATION_TYPE_DESC"));
			}
		
		} catch (Exception ex) {			
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex.getStackTrace());			
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
		return identityTypeList;
	}
	
	public static void mapMyloQueryStatements() {
		myloQueryStatementMap.put(MYLOConstants.MARITAL_STATUS, DbQueries.QUERY_GET_MARITAL_STATUS_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.PRONOUNS, DbQueries.QUERY_GET_PRONOUNS_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.CITIZENSHIP, DbQueries.QUERY_GET_COUNTRY_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.TRANSFEREE_EMAIL_TYPE, DbQueries.QUERY_GET_TRANSFEREE_EMAIL_TYPE_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.TRANSFEREE_PHONE_TYPE, DbQueries.QUERY_GET_PHONE_TYPE_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.TRANSFEREE_ORGDEST, DbQueries.QUERY_GET_LOCATION_TYPE_DROPDOWNLIST);
		myloQueryStatementMap.put(MYLOConstants.GENDER, DbQueries.QUERY_GET_GENDER_DROPDOWNLIST);
		
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
			connection = DriverManager.getConnection(
					getMyloDBConnectionStringAsPerEnvt(System.getProperty("envt")));	
			//connection = DriverManager.getConnection(
				//	getMyloDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt")));			
			PreparedStatement pst = connection.prepareStatement(myloQueryStatementMap.get(fieldName));
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				requiredList.add(resultset.getString(myloQTableColumnFields.get(fieldName)));
			}
		
		} catch (Exception ex) {			
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex.getStackTrace());			
			Assert.fail(CoreConstants.SQL_QUERY_FAILED + "for " + fieldName);
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
		return requiredList;
	}
}