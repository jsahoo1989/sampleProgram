/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 17/04/2020			 Rahul Sharma					 This class is used to manage the file reading through config, json etc.
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods. 														   
 ***********************************Header End*********************************************************************************/

package com.aires.managers;

import com.aires.dataProviders.ConfigFileReader;
import com.aires.dataProviders.JsonDataReader_CoreFlex;
import com.aires.dataProviders.JsonDataReader_Iris;
import com.aires.dataProviders.JsonDataReader_Mylo;

import com.aires.dataProviders.JsonDataReader_Pdt;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader_Pdt jsonDataReader;
	private static JsonDataReader_CoreFlex jsonDataReaderCoreFlex;
	private static JsonDataReader_Mylo MylojsonDataReader;
	private static JsonDataReader_Iris jsonDataReaderIris;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}
	
	public JsonDataReader_CoreFlex getCoreFlexJsonReader() {
		return (jsonDataReaderCoreFlex == null) ? new JsonDataReader_CoreFlex() : jsonDataReaderCoreFlex;
	}
	
	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }
	 
	 public JsonDataReader_Pdt getJsonReader(){
		 return (jsonDataReader == null) ? new JsonDataReader_Pdt() : jsonDataReader;
	 }
		 
  	public JsonDataReader_Mylo getMyloJsonReader(){
		 return (jsonDataReader == null) ? new JsonDataReader_Mylo() : MylojsonDataReader;
	}
  	
  	public JsonDataReader_Iris getIrisJsonReader() {
		return (jsonDataReaderIris == null) ? new JsonDataReader_Iris() : jsonDataReaderIris;
	}
}