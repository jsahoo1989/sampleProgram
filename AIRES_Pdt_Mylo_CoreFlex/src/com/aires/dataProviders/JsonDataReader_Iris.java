package com.aires.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.iris.IRIS_AssignmentData;
import com.google.gson.Gson;

public class JsonDataReader_Iris {
	
	private final String _irisAssignmentDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "iris/IRIS_AssignmentData.json";	
	
	private List<IRIS_AssignmentData> _assignmentDataList;
	
	public JsonDataReader_Iris() {
		_assignmentDataList = getAssignmentModuleData();
	}
	
	private List<IRIS_AssignmentData> getAssignmentModuleData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_irisAssignmentDataFilePath));
			IRIS_AssignmentData[] assignmentModuleData = gson.fromJson(bufferReader, IRIS_AssignmentData[].class);
			return Arrays.asList(assignmentModuleData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _irisAssignmentDataFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	public final IRIS_AssignmentData getAssignmentDataByTabName(String tabName) {
		return _assignmentDataList.stream().filter(x -> x.tabName.equalsIgnoreCase(tabName)).findAny().get();
	}
}