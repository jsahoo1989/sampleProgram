package com.aires.dataProviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.MyloEnvironmentDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class JsonDataWriter_Mylo {
	
	private final String _myloEnvDetailsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/MyloEnvironmentDetails.json";
	
	
	private List<MyloEnvironmentDetails> getMyloEnvironmentDetails() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_myloEnvDetailsFilePath));
			MyloEnvironmentDetails[] loginInfo = gson.fromJson(bufferReader, MyloEnvironmentDetails[].class);
			return Arrays.asList(loginInfo);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _myloEnvDetailsFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	public final void setMyloFileIDByEnvt(String envt,String fileID) throws IOException {
			ObjectMapper mapper = new ObjectMapper();
	        // Read the JSON file into a Java object
	        List<MyloEnvironmentDetails> envDetailsList = getMyloEnvironmentDetails();
	        for (MyloEnvironmentDetails envDetails : envDetailsList) {  	
				System.out.println(envDetails.getEnvironment());
	        	if(envDetails.getEnvironment().equals(envt)) {
	        		envDetails.details.setMyloFileID(fileID);
		        	break;
				}
			}
	        mapper.writeValue(new File(_myloEnvDetailsFilePath), envDetailsList);
	
	}
}
