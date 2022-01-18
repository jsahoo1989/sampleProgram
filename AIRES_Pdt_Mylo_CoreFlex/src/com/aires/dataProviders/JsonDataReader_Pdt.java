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
import com.aires.testdatatypes.pdt.PDT_ImmigrationBenefit;
import com.aires.testdatatypes.pdt.PDT_LoginData;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.aires.testdatatypes.pdt.PDT_PreAcceptanceServiceBenefit;
import com.google.gson.Gson;

public class JsonDataReader_Pdt {

	private final String _loginDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_LoginData.json";
	private final String _PreAcceptanceServiceFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_PreAcceptanceServiceBenefit.json";
	private final String _ImmigrationFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_ImmigrationBenefit.json";
	private final String _HouseHuntingTripFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_HouseHuntingTripBenefit.json";
	private final String _LanguageTrainingFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_LanguageTrainingBenefit.json";
	private final String _CulturalTrainingFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_CulturalTrainingBenefit.json";

	private final String _loginDetailsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_LoginDetails.json";

	private List<PDT_LoginData> _loginDataList;

	private List<PDT_LoginDetails> _loginDetailsList;

	private List<PDT_PreAcceptanceServiceBenefit> _preAcceptanceServicelist;
	private List<PDT_ImmigrationBenefit> _immigrationList;
	private List<PDT_HouseHuntingTripBenefit> _houseHuntingTripList;
	private List<PDT_LanguageTrainingBenefit> _languageTrainingList;
	private List<PDT_CulturalTrainingBenefit> _culturalTrainingList;

	public JsonDataReader_Pdt() {
		_loginDataList = getUserData();
		_loginDetailsList = getLoginByApplication();
		_preAcceptanceServicelist = getPreAcceptanceData();
		_immigrationList = getImmigrationData();
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

	private List<PDT_LoginDetails> getLoginByApplication() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_loginDetailsFilePath));
			PDT_LoginDetails[] application = gson.fromJson(bufferReader, PDT_LoginDetails[].class);
			return Arrays.asList(application);
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
	
	private List<PDT_PreAcceptanceServiceBenefit> getPreAcceptanceData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_PreAcceptanceServiceFilePath));
			PDT_PreAcceptanceServiceBenefit[] preAcceptanceService = gson.fromJson(bufferReader,
					PDT_PreAcceptanceServiceBenefit[].class);
			return Arrays.asList(preAcceptanceService);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _PreAcceptanceServiceFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<PDT_ImmigrationBenefit> getImmigrationData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_ImmigrationFilePath));
			PDT_ImmigrationBenefit[] immigration = gson.fromJson(bufferReader, PDT_ImmigrationBenefit[].class);
			return Arrays.asList(immigration);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _ImmigrationFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<PDT_HouseHuntingTripBenefit> getHouseHuntingTripData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_HouseHuntingTripFilePath));
			PDT_HouseHuntingTripBenefit[] houseHuntingTrip = gson.fromJson(bufferReader,
					PDT_HouseHuntingTripBenefit[].class);
			return Arrays.asList(houseHuntingTrip);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _HouseHuntingTripFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<PDT_LanguageTrainingBenefit> getLanguageTrainingData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_LanguageTrainingFilePath));
			PDT_LanguageTrainingBenefit[] languageTraining = gson.fromJson(bufferReader,
					PDT_LanguageTrainingBenefit[].class);
			return Arrays.asList(languageTraining);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _LanguageTrainingFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<PDT_CulturalTrainingBenefit> getCulturalTrainingData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_CulturalTrainingFilePath));
			PDT_CulturalTrainingBenefit[] culturalTraining = gson.fromJson(bufferReader, PDT_CulturalTrainingBenefit[].class);
			return Arrays.asList(culturalTraining);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _CulturalTrainingFilePath);
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
	
	public final PDT_LoginDetails getLoginByApplication(String applicationName) {
		return _loginDetailsList.stream().filter(x -> x.application.equalsIgnoreCase(applicationName)).findAny().get();
	}

	public final PDT_PreAcceptanceServiceBenefit getPreAcceptanceDataList(String policyBenefit) {
		return _preAcceptanceServicelist.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny()
				.get();
	}

	public final PDT_ImmigrationBenefit getImmigrationDataList(String policyBenefit) {
		return _immigrationList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}

	public final PDT_HouseHuntingTripBenefit getHouseHuntingTripDataList(String policyBenefit) {
		return _houseHuntingTripList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny()
				.get();
	}

	public final PDT_LanguageTrainingBenefit getLanguageTrainingDataList(String policyBenefit) {
		return _languageTrainingList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny()
				.get();
	}

	public final PDT_CulturalTrainingBenefit getCulturalTrainingDataList(String policyBenefit) {
		return _culturalTrainingList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
}