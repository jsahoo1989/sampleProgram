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
import com.aires.testdatatypes.mylo.MyloCAStates;
import com.aires.testdatatypes.mylo.MyloIndiaStates;
import com.aires.testdatatypes.mylo.MyloMemoryCapacityFileIds;
import com.aires.testdatatypes.mylo.MyloUSStates;
import com.aires.testdatatypes.mylo.Mylo_Assignment_HistoryDetails_DEV5;
import com.aires.testdatatypes.mylo.Mylo_Assignment_HistoryDetails_PREPROD;
import com.aires.testdatatypes.mylo.Mylo_Assignment_HistoryDetails_UAT;
import com.aires.testdatatypes.mylo.Mylo_DropDownFieldData;
import com.aires.testdatatypes.mylo.Mylo_FileData;
import com.aires.testdatatypes.mylo.Mylo_JourneyDetails_DEV5;
import com.aires.testdatatypes.mylo.Mylo_JourneyDetails_PREPROD;
import com.aires.testdatatypes.mylo.Mylo_JourneyDetails_QA4;
import com.aires.testdatatypes.mylo.Mylo_JourneyDetails_UAT;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.google.gson.Gson;

public class JsonDataReader_Mylo {
	private final String _loginDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_LoginData.json";	
	private final String _MyloUSStatesFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_USStates.json";
	private final String _MyloCAStatesFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_CAStates.json";
	private final String _MyloIndiaStatesFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_IndiaStates.json";
	private final String _MyloHistoryDetailsUATFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_Assignment_HistoryDetails_UAT.json";
	private final String _MyloHistoryDetailsPREPRODFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_Assignment_HistoryDetails_PREPROD.json";
	private final String _MyloHistoryDetailsDEV5FilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_Assignment_HistoryDetails_DEV5.json";
	private final String _JourneyDetailsUATFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_JourneyDetails_UAT.json";
	private final String _JourneyDetailsQA4FilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_JourneyDetails_QA4.json";
	private final String _JourneyDetailsPREPRODFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_JourneyDetails_PREPROD.json";
	private final String _JourneyDetailsDEV5FilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_JourneyDetails_DEV5.json";
	private final String _MylofileDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_FileData.json";
	private final String _MyloMemoryCapacityFileIdPath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/MyloMemoryCapacityFileIds.json";
	private final String _MyloDropDownFieldsDataPath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mylo/Mylo_DropDownFieldData.json";
	private List<Mylo_LoginData> _loginDataList;
	private List<MyloUSStates> _USStatesList;
	private List<MyloCAStates> _CAStatesList;
	private List<MyloIndiaStates> _IndiaStatesList;
	private List<Mylo_Assignment_HistoryDetails_UAT> _myloAssignHistoryDet_UAT;
	private List<Mylo_Assignment_HistoryDetails_PREPROD> _myloAssignHistoryDet_PREPROD;
	private List<Mylo_Assignment_HistoryDetails_DEV5> _myloAssignHistoryDet_DEV5;
	private List<Mylo_JourneyDetails_UAT> _journeyDetailsUATList;
	private List<Mylo_JourneyDetails_QA4> _journeyDetailsQA4List;
	private List<Mylo_JourneyDetails_PREPROD> _journeyDetailsPREPRODList;
	private List<Mylo_JourneyDetails_DEV5> _journeyDetailsDEV5List;
	private List<Mylo_DropDownFieldData> _dropdownList;
	private List<Mylo_FileData> _fileDataList;
	private List<MyloMemoryCapacityFileIds> _fileIdDetailsList;
	
	public JsonDataReader_Mylo() {
		_loginDataList = getUserData();
		_USStatesList=getUSStates();
		_CAStatesList=getCAStates();
		_IndiaStatesList=getIndiaStates();
		_myloAssignHistoryDet_UAT = getMyloHistoryDetails_UAT();
		_myloAssignHistoryDet_PREPROD = getMyloHistoryDetails_PREPROD();
		_myloAssignHistoryDet_DEV5 = getMyloHistoryDetails_DEV5();
		_journeyDetailsUATList = getJourneyDetailsUAT();
		_journeyDetailsQA4List = getJourneyDetailsQA4();
		_journeyDetailsPREPRODList = getJourneyDetailsPREPROD();
		_journeyDetailsDEV5List = getJourneyDetailsDEV5();
		_fileDataList=getFileData();
		_fileIdDetailsList=getFileDetailsData();
		_dropdownList=getDropdownData();
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
	
	private List<Mylo_JourneyDetails_UAT> getJourneyDetailsUAT() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_JourneyDetailsUATFilePath));
			Mylo_JourneyDetails_UAT[] application = gson.fromJson(bufferReader, Mylo_JourneyDetails_UAT[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _JourneyDetailsUATFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<Mylo_JourneyDetails_QA4> getJourneyDetailsQA4() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_JourneyDetailsQA4FilePath));
			Mylo_JourneyDetails_QA4[] application = gson.fromJson(bufferReader, Mylo_JourneyDetails_QA4[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _JourneyDetailsQA4FilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<Mylo_JourneyDetails_PREPROD> getJourneyDetailsPREPROD() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_JourneyDetailsPREPRODFilePath));
			Mylo_JourneyDetails_PREPROD[] application = gson.fromJson(bufferReader, Mylo_JourneyDetails_PREPROD[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _JourneyDetailsPREPRODFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<Mylo_JourneyDetails_DEV5> getJourneyDetailsDEV5() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_JourneyDetailsDEV5FilePath));
			Mylo_JourneyDetails_DEV5[] application = gson.fromJson(bufferReader, Mylo_JourneyDetails_DEV5[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _JourneyDetailsDEV5FilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<Mylo_DropDownFieldData> getDropdownData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_MyloDropDownFieldsDataPath));
			Mylo_DropDownFieldData[] application = gson.fromJson(bufferReader, Mylo_DropDownFieldData[].class);
			return Arrays.asList(application);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _MyloDropDownFieldsDataPath);
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
	
	private List<Mylo_Assignment_HistoryDetails_PREPROD> getMyloHistoryDetails_PREPROD() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_MyloHistoryDetailsPREPRODFilePath));
			Mylo_Assignment_HistoryDetails_PREPROD[] application = gson.fromJson(bufferReader, Mylo_Assignment_HistoryDetails_PREPROD[].class);
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
	
	private List<Mylo_Assignment_HistoryDetails_DEV5> getMyloHistoryDetails_DEV5() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_MyloHistoryDetailsDEV5FilePath));
			Mylo_Assignment_HistoryDetails_DEV5[] application = gson.fromJson(bufferReader, Mylo_Assignment_HistoryDetails_DEV5[].class);
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
	
	private List<Mylo_FileData> getFileData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_MylofileDataFilePath));
			Mylo_FileData[] data = gson.fromJson(bufferReader, Mylo_FileData[].class);
			return Arrays.asList(data);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _MylofileDataFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<MyloMemoryCapacityFileIds> getFileDetailsData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_MyloMemoryCapacityFileIdPath));
			MyloMemoryCapacityFileIds[] data = gson.fromJson(bufferReader, MyloMemoryCapacityFileIds[].class);
			return Arrays.asList(data);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _MyloMemoryCapacityFileIdPath);
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
	
	public final Mylo_FileData getFileDataByFileType(String fileType) {
		return _fileDataList.stream().filter(x -> x.fileType.equalsIgnoreCase(fileType)).findAny().get();
	}
	
	public final List<Mylo_JourneyDetails_UAT> getMyloJourneyDetailsUAT() {
		return _journeyDetailsUATList;
	}
	
	public final List<Mylo_JourneyDetails_QA4> getMyloJourneyDetailsQA4() {
		return _journeyDetailsQA4List;
	}
	
	public final List<Mylo_JourneyDetails_PREPROD> getMyloJourneyDetailsPREPROD() {
		return _journeyDetailsPREPRODList;
	}
	
	public final List<Mylo_JourneyDetails_DEV5> getMyloJourneyDetailsDEV5() {
		return _journeyDetailsDEV5List;
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
	public final List<Mylo_Assignment_HistoryDetails_PREPROD> getMyloAssignmentPREPRODHistoryDetails() {
		return _myloAssignHistoryDet_PREPROD;
	}
	public final List<Mylo_Assignment_HistoryDetails_DEV5> getMyloAssignmentDEV5HistoryDetails() {
		return _myloAssignHistoryDet_DEV5;
	}
	
	public final MyloMemoryCapacityFileIds getFileIdListByEnv(String environmentName) {
		return _fileIdDetailsList.stream().filter(x -> x.environment.equalsIgnoreCase(environmentName)).findAny().get();
	}
	
	public final Mylo_DropDownFieldData getDropDownListByFieldName(String fieldName) {
		return _dropdownList.stream().filter(x -> x.field.equalsIgnoreCase(fieldName)).findAny().get();
	}
}