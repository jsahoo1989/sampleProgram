/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 17/04/2020			 Rahul Sharma					 Create an utility to read data from json file
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the utility methods to read data from json file 														   
 ***********************************Header End*********************************************************************************/

package com.aires.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.MyloAssignmentDetails;
import com.aires.testdatatypes.mylo.MyloCAStates;
import com.aires.testdatatypes.mylo.MyloIndiaStates;
import com.aires.testdatatypes.mylo.MyloUSStates;
import com.aires.testdatatypes.mylo.Mylo_AssignmentShipmentDetails;
import com.aires.testdatatypes.mylo.Mylo_Assignment_HistoryDetails_UAT;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.google.gson.Gson;

public class JsonDataReader_Mylo {
	private final String _loginDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_LoginData.json";	
	
	private final String _AssignmentDetailsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_AssignmentDetais.json";
	private final String _AssignmentDetailsShipmentFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_AssignmentShipmentDetails.json";
	private final String _MyloUSStatesFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_USStates.json";
	private final String _MyloCAStatesFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_CAStates.json";
	private final String _MyloIndiaStatesFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_IndiaStates.json";
	private final String _MyloHistoryDetailsUATFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_Assignment_HistoryDetails_UAT.json";
	private List<Mylo_LoginData> _loginDataList;
	private List<MyloAssignmentDetails> _assignmentDetailsList;
	private List<Mylo_AssignmentShipmentDetails> _assignmentShipmentDetailsList;
	private List<MyloUSStates> _USStatesList;
	private List<MyloCAStates> _CAStatesList;
	private List<MyloIndiaStates> _IndiaStatesList;
	private List<Mylo_Assignment_HistoryDetails_UAT> _myloAssignHistoryDet_UAT;
	
	public JsonDataReader_Mylo() {
		_loginDataList = getUserData();
		_assignmentDetailsList = getAssignmentDetails();
		_assignmentShipmentDetailsList = getAssignmentShipmentDetails();
		_USStatesList=getUSStates();
		_CAStatesList=getCAStates();
		_IndiaStatesList=getIndiaStates();
		_myloAssignHistoryDet_UAT = getMyloHistoryDetails_UAT();
	}
	private List<Mylo_LoginData> getUserData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_loginDataFilePath));
			Mylo_LoginData[] customers = gson.fromJson(bufferReader, Mylo_LoginData[].class);
			return Arrays.asList(customers);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _loginDataFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<MyloAssignmentDetails> getAssignmentDetails() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_AssignmentDetailsFilePath));
			MyloAssignmentDetails[] application = gson.fromJson(bufferReader, MyloAssignmentDetails[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _AssignmentDetailsFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<Mylo_AssignmentShipmentDetails> getAssignmentShipmentDetails() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_AssignmentDetailsShipmentFilePath));
			Mylo_AssignmentShipmentDetails[] application = gson.fromJson(bufferReader, Mylo_AssignmentShipmentDetails[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _AssignmentDetailsShipmentFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<MyloUSStates> getUSStates() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_MyloUSStatesFilePath));
			MyloUSStates[] application = gson.fromJson(bufferReader, MyloUSStates[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _MyloUSStatesFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<MyloCAStates> getCAStates() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_MyloCAStatesFilePath));
			MyloCAStates[] application = gson.fromJson(bufferReader, MyloCAStates[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _MyloCAStatesFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<MyloIndiaStates> getIndiaStates() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_MyloIndiaStatesFilePath));
			MyloIndiaStates[] application = gson.fromJson(bufferReader, MyloIndiaStates[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _MyloIndiaStatesFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<Mylo_Assignment_HistoryDetails_UAT> getMyloHistoryDetails_UAT() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_MyloHistoryDetailsUATFilePath));
			Mylo_Assignment_HistoryDetails_UAT[] application = gson.fromJson(bufferReader, Mylo_Assignment_HistoryDetails_UAT[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _MyloHistoryDetailsUATFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	public final Mylo_LoginData getloginDetailsByUserProfileName(String userProfileName) {
		return _loginDataList.stream().filter(x -> x.MyloProfileName.equalsIgnoreCase(userProfileName)).findAny().get();
	}
	
	public final MyloAssignmentDetails getAssignmentDetailsByApplication(String applicationName) {
		return _assignmentDetailsList.stream().filter(x -> x.application.equalsIgnoreCase(applicationName)).findAny().get();
	}
	
	public final Mylo_AssignmentShipmentDetails getAssignmentShipmentDetailsByEnv(String envName) {
		return _assignmentShipmentDetailsList.stream().filter(x -> x.environment.equalsIgnoreCase(envName)).findAny().get();
	}
	
	public final List<MyloUSStates> getMyloUSStates() {
		return _USStatesList;
	}
	public final List<MyloCAStates> getMyloCAStates() {
		return _CAStatesList;
	}
	public final List<MyloIndiaStates> getMyloIndiaStates() {
		return _IndiaStatesList;
	}
	public final List<Mylo_Assignment_HistoryDetails_UAT> getMyloAssignmentUATHistoryDetails() {
		return _myloAssignHistoryDet_UAT;
	}
}