package com.aires.businessrules;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.DbQueries;
import com.aires.businessrules.constants.PDTConstants;

public class DbFunctions {
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
			dbURL = "jdbc:oracle:thin:isisdba/irisqaisisdba@corpqavl300.corp.aires.com:1521:IRISQA";
			//dbURL = "jdbc:oracle:thin:isisdba/iristestisisdba@corptesvl300.corp.aires.com:1521:IRISTEST";
			break;
		case "prod":
			// For Production Envt. - Change username/Password & verify DB connection
			// details
			dbURL = "jdbc:oracle:thin:isisdba/iristestisisdba@corpprdl200.corp.aires.com:1521:IRIS";
			break;
		default:
			Assert.fail("Database connection" + PDTConstants.NOT_EXIST);
		}
		return dbURL;
	}

	
	public static void deletePolicyByPolicyId(int policyId) {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
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
}