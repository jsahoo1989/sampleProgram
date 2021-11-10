package com.aires.businessrules;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedHashMap;

import org.testng.Assert;

import com.aires.businessrules.constants.PDTConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.DbQueries;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

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
			dbURL = "jdbc:oracle:thin:isisdba/iristestisisdba@corptesvl300.corp.aires.com:1521:IRISTEST";
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

	public static String connectDB_ReturnColumnValue(String sqlQuery, String columnName) {
		String columnValue = null;
		Connection connection = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));

			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery(sqlQuery);
			if (true) {
				Reporter.addStepLog(CoreConstants.PASS + "SQL Query Executed Successfully : \n'" + sqlQuery + "'");
				while (resultset.next()) {
					columnValue = resultset.getString(columnName);
					Reporter.addStepLog(CoreConstants.PASS + "Value Displayed under Column Name '" + columnName
							+ "' is : " + columnValue);
					// System.out.println(resultset.getString("DBMS_CRYPTO_HASH"));
				}
			}
			connection.close();
		} catch (Exception ex) {
			System.err.println(ex);
			Assert.fail("SQL Query Failed");
		}
		return columnValue;
	}

	public static LinkedHashMap<String, Integer> getCarRentalRates(String countryRegion, String rentalCarClass) {
		int daily_rate = 0,	weekly_rate = 0, monthly_rate = 0;
		Connection connection = null;
		LinkedHashMap<String, Integer> CarRatesMap = new LinkedHashMap<String, Integer>();
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));			
			PreparedStatement pst = connection.prepareStatement(DbQueries.QUERY_CAR_RENTAL_RATE);
			pst.setString(1, countryRegion);
			pst.setString(2, rentalCarClass);
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				daily_rate = resultset.getInt(PDTConstants.RATE);
				weekly_rate = resultset.getInt(PDTConstants.WEEKLY_RATE);
				monthly_rate = resultset.getInt(PDTConstants.MONTHLY_RATE);
			}
			CarRatesMap.put(PDTConstants.DAILY_RATE, daily_rate);
			CarRatesMap.put(PDTConstants.WEEKLY_RATE, weekly_rate);
			CarRatesMap.put(PDTConstants.MONTHLY_RATE, monthly_rate);
		
		} catch (Exception ex) {			
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex.getStackTrace());			
			Assert.fail(PDTConstants.SQL_QUERY_FAILED);

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
		return CarRatesMap;
	}

	public static int getAirFareRate(String fromCountryRegion, String toCountryRegion, String aireFareClass) {
		Connection connection = null;
		int airFareRate = 0;
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
			
			PreparedStatement pst = connection.prepareStatement(DbQueries.QUERY_AIR_FARE_RATE);
			pst.setString(1, fromCountryRegion);
			pst.setString(2, toCountryRegion);
			pst.setString(3, aireFareClass);
			ResultSet resultset = pst.executeQuery();			
			while (resultset.next()) {
				airFareRate = resultset.getInt(PDTConstants.RATE);				
			}			
		} catch (Exception ex) {			
			Assert.fail(PDTConstants.SQL_QUERY_FAILED);
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex);			
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return airFareRate;
	}

	public static String getCountryRegion(String countryCode) {
		Connection connection = null;
		String regionName = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
			CallableStatement callableStatement = connection
					.prepareCall(DbQueries.CALL_PROCEDURE_GET_COUNTRY_REGION);
			callableStatement.registerOutParameter(1, Types.VARCHAR);
			callableStatement.setString(2, countryCode);
			callableStatement.setString(3, "N");
			callableStatement.execute();
			regionName = callableStatement.getString(1);			
		} catch (Exception ex) {
			Assert.fail(CoreConstants.ERROR + PDTConstants.FAIL_CALL_PROC_GET_COUNTRY_REGION);
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex);
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return regionName;
	}
	
	public static String getPortCodeFromHistoricTable(String portTypeCode, String countryCode, String stateCode, String city) {
		String portCode = null;
		Connection connection = null;		
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));			
			PreparedStatement pst = connection.prepareStatement(DbQueries.QUERY_GET_PORT_CODE_FROM_HISTORIC_TABLE);
			pst.setString(1, portTypeCode);
			pst.setString(2, countryCode);
			pst.setString(3, stateCode);
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				portCode = resultset.getString("port_code");
			}
		
		} catch (Exception ex) {			
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex.getStackTrace());			
			Assert.fail(PDTConstants.SQL_QUERY_FAILED);

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
		return portCode;
	}
	
	/*public static LinkedHashMap<String, String> fetchCountryPorts(String portTypeCode, String countryCode) {
		String portCode = null;
		Connection connection = null;		
		LinkedHashMap<String, String> portsInfoMap = new LinkedHashMap<String, String>();
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));			
			PreparedStatement pst = connection.prepareStatement(DbQueries.QUERY_FETCH_COUNTRY_PORTS);
			pst.setString(1, countryCode);
			pst.setString(2, portTypeCode);			
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				portCode = resultset.getString("port_code");
			}
		
		} catch (Exception ex) {			
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex.getStackTrace());			
			Assert.fail(AiresConstants.SQL_QUERY_FAILED);

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
		return portCode;
	}*/
	
	public static String getAirShipmentCost(String airShipmentSize, String originCountryCode, String destCountryCode, String oaPortCode, String daPortCode, String afOriginPortCode, String afDestPortCode) {
		Connection connection = null;
		double airShipmentRate = 0.00;

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
			CallableStatement callableStatement = connection
					.prepareCall(DbQueries.CALL_PROCEDURE_GET_AIR_SHIPMENT_COST);			
			callableStatement.setString(1, airShipmentSize);
			callableStatement.setString(2, originCountryCode);
			callableStatement.setString(3, destCountryCode);
			callableStatement.setString(4, oaPortCode);
			callableStatement.setString(5, daPortCode);
			callableStatement.setString(6, afOriginPortCode);
			callableStatement.setString(7, afDestPortCode);
			callableStatement.registerOutParameter(8, Types.DOUBLE);
			callableStatement.registerOutParameter(9, Types.NUMERIC);
			callableStatement.registerOutParameter(10, Types.VARCHAR);
			callableStatement.execute();
			airShipmentRate = callableStatement.getDouble(8);
			airShipmentRate = (double)((int)airShipmentRate);
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex);
			Assert.fail(CoreConstants.ERROR + PDTConstants.FAIL_CALL_PROC_GET_AIR_SHIPMENT_COST);
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return BusinessFunctions.setMoneyFormat(airShipmentRate);
	}
	
	public static String getSeaShipmentCost(String seaShipmentSize, String originCountryCode, String destCountryCode, String oaPortCode, String daPortCode, String ofOriginPortCode, String ofDestPortCode, String originStateCode, String destStateCode) {
		Connection connection = null;
		double seaShipmentRate = 0.00;

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
			CallableStatement callableStatement = connection
					.prepareCall(DbQueries.CALL_PROCEDURE_GET_SEA_SHIPMENT_COST);			
			callableStatement.setString(1, seaShipmentSize);
			callableStatement.setString(2, originCountryCode);
			callableStatement.setString(3, destCountryCode);
			callableStatement.setString(4, oaPortCode);
			callableStatement.setString(5, daPortCode);
			callableStatement.setString(6, ofOriginPortCode);
			callableStatement.setString(7, ofDestPortCode);
			callableStatement.setString(8, originStateCode);
			callableStatement.setString(9, destStateCode);
			callableStatement.registerOutParameter(10, Types.DOUBLE);
			callableStatement.registerOutParameter(11, Types.INTEGER);
			callableStatement.registerOutParameter(12, Types.VARCHAR);
			callableStatement.execute();
			seaShipmentRate = callableStatement.getDouble(10);
			seaShipmentRate = (double)((int)seaShipmentRate);
		} catch (Exception ex) {
			Assert.fail(CoreConstants.ERROR + PDTConstants.FAIL_CALL_PROC_GET_SEA_SHIPMENT_COST);
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex);
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return BusinessFunctions.setMoneyFormat(seaShipmentRate);
	}
	
	public static String getSurfaceShipmentCost(String seaShipmentSize, String originCountryCode, String destCountryCode, String mileage) {
		Connection connection = null;
		Double seaShipmentRate = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
			CallableStatement callableStatement = connection
					.prepareCall(DbQueries.CALL_PROCEDURE_GET_SURFACE_SHIPMENT_COST);			
			callableStatement.setInt(1, Integer.parseInt(mileage));
			callableStatement.setString(2, seaShipmentSize);
			callableStatement.setString(3, originCountryCode);
			callableStatement.setString(4, destCountryCode);
			callableStatement.registerOutParameter(5, Types.DOUBLE);
			callableStatement.registerOutParameter(6, Types.INTEGER);
			callableStatement.registerOutParameter(7, Types.VARCHAR);
			callableStatement.execute();
			seaShipmentRate = callableStatement.getDouble(5);			
		} catch (Exception ex) {
			Assert.fail(CoreConstants.ERROR + PDTConstants.FAIL_CALL_PROC_GET_SURFACE_SHIPMENT_COST);
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex);
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return BusinessFunctions.setMoneyFormat(seaShipmentRate);
	}
	
	public static String getSeaSurfaceTempStorageCost(String tempStorageDays, String seaSurfShipmentSize, String originCountryCode, String destCountryCode, String oaPortCode, String daPortCode, String shipmentPreference) {
		Connection connection = null;
		Double tempStorageRate = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
			CallableStatement callableStatement = connection
					.prepareCall(DbQueries.CALL_PROCEDURE_GET_TEMP_STORAGE_COST);			
			callableStatement.setInt(1, Integer.parseInt(tempStorageDays));
			callableStatement.setString(2, originCountryCode);
			callableStatement.setString(3, destCountryCode);
			callableStatement.setString(4, oaPortCode);
			callableStatement.setString(5, daPortCode);
			callableStatement.setString(6, shipmentPreference);
			callableStatement.setString(7, seaSurfShipmentSize);
			callableStatement.registerOutParameter(8, Types.DOUBLE);
			callableStatement.registerOutParameter(9, Types.NUMERIC);
			callableStatement.registerOutParameter(10, Types.VARCHAR);
			callableStatement.execute();
			tempStorageRate = callableStatement.getDouble(8);
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex);
			Assert.fail(CoreConstants.ERROR + PDTConstants.FAIL_CALL_PROC_GET_TEMP_STORAGE_COST);
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return BusinessFunctions.setMoneyFormat(tempStorageRate);
	}
	
	public static String getInternationalPermanentStorageCost(String originCountryCode, String destCountryCode, String oaPortCode, String daPortCode, String permStorageSize) {
		Connection connection = null;
		double permStorageRate = 0.00;

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
			CallableStatement callableStatement = connection
					.prepareCall(DbQueries.CALL_PROCEDURE_GET_INTNL_PERM_STORAGE_COST);			
			
			callableStatement.setString(1, originCountryCode);
			callableStatement.setString(2, destCountryCode);
			callableStatement.setString(3, oaPortCode);
			callableStatement.setString(4, daPortCode);
			callableStatement.setString(5, permStorageSize);
			callableStatement.registerOutParameter(6, Types.DOUBLE);
			callableStatement.registerOutParameter(7, Types.NUMERIC);
			callableStatement.registerOutParameter(8, Types.VARCHAR);
			callableStatement.execute();
			permStorageRate = callableStatement.getDouble(6);
			permStorageRate = (double)((int)permStorageRate);
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex);
			Assert.fail(CoreConstants.ERROR + "Fail to call procedure");
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return BusinessFunctions.setMoneyFormat(permStorageRate);
	}
	
	public static void deleteDelegateInfo(String userName) {		
		Connection connection = null;		
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(
					getDBConnectionStringAsPerEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));			
			PreparedStatement pstUserInfo = connection.prepareStatement(DbQueries.QUERY_DELETE_DELEGATE_FROM_USERINFO);
			PreparedStatement pstDelegateConfig = connection.prepareStatement(DbQueries.QUERY_DELETE_DELEGATE_FROM_DELEGATECONFIG);
			pstUserInfo.setString(1, userName);
			pstDelegateConfig.setString(1, userName);
			pstUserInfo.executeUpdate();
			pstDelegateConfig.executeUpdate();			
		} catch (Exception ex) {			
			Log.info(CoreConstants.ERROR+ex.getMessage());
			Log.info(CoreConstants.ERROR+ex.getStackTrace());			
			Assert.fail(PDTConstants.SQL_QUERY_FAILED);

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
		
	}
}
