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
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.google.gson.Gson;

public class JsonDataReader_Mylo {
	private final String _loginDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_LoginData.json";	
	
	private final String _AssignmentDetailsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_AssignmentDetais.json";
	private List<Mylo_LoginData> _loginDataList;
	private List<MyloAssignmentDetails> _assignmentDetailsList;
	
	public JsonDataReader_Mylo() {
		_loginDataList = getUserData();
		_assignmentDetailsList = getAssignmentDetails();
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
	
	public final Mylo_LoginData getloginDetailsByUserProfileName(String userProfileName) {
		return _loginDataList.stream().filter(x -> x.MyloProfileName.equalsIgnoreCase(userProfileName)).findAny().get();
	}
	
	public final MyloAssignmentDetails getAssignmentDetailsByApplication(String applicationName) {
		return _assignmentDetailsList.stream().filter(x -> x.application.equalsIgnoreCase(applicationName)).findAny().get();
	}
}