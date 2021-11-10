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
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods. 														   
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
import com.aires.testdatatypes.pdt.PDT_LoginData;
import com.google.gson.Gson;

public class JsonDataReader_Pdt {
	
	private final String _loginDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_LoginData.json";
	
	private List<PDT_LoginData> _loginDataList;
	
	public JsonDataReader_Pdt() {
		_loginDataList = getUserData();
	}
	
	private List<PDT_LoginData> getUserData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_loginDataFilePath));
			PDT_LoginData[] customers = gson.fromJson(bufferReader, PDT_LoginData[].class);
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
	
	public final PDT_LoginData getloginDetailsByUserFirstName(String userFirstName) {
		return _loginDataList.stream().filter(x -> x.firstName.equalsIgnoreCase(userFirstName)).findAny().get();
	}
	

}