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
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData;
import com.aires.testdatatypes.pdt.PDT_AssignmentHousingBenefit;
import com.aires.testdatatypes.pdt.PDT_CompensationServicesBenefit;
import com.aires.testdatatypes.pdt.PDT_CulturalTrainingBenefit;
import com.aires.testdatatypes.pdt.PDT_DestinationServicesBenefit;
import com.aires.testdatatypes.pdt.PDT_DuplicateHousingBenefit;
import com.aires.testdatatypes.pdt.PDT_FinalMoveBenefit;
import com.aires.testdatatypes.pdt.PDT_HomeLeaveBenefit;
import com.aires.testdatatypes.pdt.PDT_HomePurchaseBenefit;
import com.aires.testdatatypes.pdt.PDT_HouseHoldGoodsBenefit;
import com.aires.testdatatypes.pdt.PDT_HouseHuntingTripBenefit;
import com.aires.testdatatypes.pdt.PDT_ImmigrationBenefit;
import com.aires.testdatatypes.pdt.PDT_LanguageTrainingBenefit;
import com.aires.testdatatypes.pdt.PDT_LoginData;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.aires.testdatatypes.pdt.PDT_LoginInfo;
import com.aires.testdatatypes.pdt.PDT_OneTimePaymentBenefit;
import com.aires.testdatatypes.pdt.PDT_OngoingPaymentReimbursementBenefit;
import com.aires.testdatatypes.pdt.PDT_PreAcceptanceServiceBenefit;
import com.aires.testdatatypes.pdt.PDT_PropertyManagementBenefit;
import com.aires.testdatatypes.pdt.PDT_RentalAssistanceBenefit;
import com.aires.testdatatypes.pdt.PDT_TemporaryLivingBenefit;
import com.google.gson.Gson;

public class JsonDataReader_Pdt {

	private final String _loginDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_LoginData.json";
	private final String _loginInfoFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_LoginInfo.json";
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
	private final String _FinalMoveFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_FinalMove.json";
	private final String _loginDetailsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_LoginDetails.json";
	private final String _HomeLeaveFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_HomeLeaveBenefit.json";
	private final String _TemporaryLivingFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_TemporaryLivingBenefit.json";
	private final String _DestinationServicesFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_DestinationServicesBenefit.json";
	private final String _RentalAssistanceFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_RentalAssistanceBenefit.json";
	private final String _CompensationServicesFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_CompensationServicesBenefit.json";
	private final String _DuplicateHousingFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_DuplicateHousingBenefit.json";
	private final String _AssignmentHousingFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_AssignmentHousingBenefit.json";
	private final String _OneTimePaymentFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_OneTimePaymentBenefit.json";
	private final String _OngoingPaymentReimbursementFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_OngoingPaymentReimbursementBenefit.json";
	private final String _PropertyManagementFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_PropertyManagementBenefit.json";
	private final String _HomePurchaseFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_HomePurchaseBenefit.json";
	private final String _HouseholdGoodsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "pdt/PDT_HouseHoldGoodsBenefit.json";
	private final String _MobilityXAuthDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "mobilityx/MobilityX_AuthorizationData.json";

	private List<PDT_LoginData> _loginDataList;
	private List<PDT_LoginDetails> _loginDetailsList;
	private List<PDT_LoginInfo> _loginInfoList;
	private List<PDT_PreAcceptanceServiceBenefit> _preAcceptanceServicelist;
	private List<PDT_ImmigrationBenefit> _immigrationList;
	private List<PDT_HouseHuntingTripBenefit> _houseHuntingTripList;
	private List<PDT_LanguageTrainingBenefit> _languageTrainingList;
	private List<PDT_CulturalTrainingBenefit> _culturalTrainingList;
	private List<PDT_FinalMoveBenefit> _finalMoveList;
	private List<PDT_HomeLeaveBenefit> _homeLeaveList;
	private List<PDT_TemporaryLivingBenefit> _temporaryLivingList;
	private List<PDT_DestinationServicesBenefit> _destinationServicesList;
	private List<PDT_RentalAssistanceBenefit> _rentalAssistanceList;
	private List<PDT_CompensationServicesBenefit> _compensationServicesList;
	private List<PDT_DuplicateHousingBenefit> _duplicateHousingList;
	private List<PDT_AssignmentHousingBenefit> _assignmentHousingList;
	private List<PDT_OneTimePaymentBenefit> _oneTimePaymentList;
	private List<PDT_OngoingPaymentReimbursementBenefit> _ongoingPaymentReimbursementList;
	private List<PDT_PropertyManagementBenefit> _propertyManagementList;
	private List<PDT_HomePurchaseBenefit> _homePurchaseList;
	private List<PDT_HouseHoldGoodsBenefit> _houseHoldGoodsList;
	private List<MobilityX_AuthorizationData> _mobilityXAuthorizationDataList;

	public JsonDataReader_Pdt() {
		_loginDataList = getUserData();
		_loginDetailsList = getLoginByApplication();
		_loginInfoList = getLoginInfoByEnvt();
		_preAcceptanceServicelist = getPreAcceptanceData();
		_immigrationList = getImmigrationData();
		_houseHuntingTripList = getHouseHuntingTripData();
		_languageTrainingList = getLanguageTrainingData();
		_culturalTrainingList = getCulturalTrainingData();
		_finalMoveList = getFinalMoveData();
		_homeLeaveList = getHomeLeaveData();
		_temporaryLivingList = getTemporaryLivingData();
		_destinationServicesList = getDestinationServicesData();
		_rentalAssistanceList = getRentalAssistanceData();
		_compensationServicesList = getCompensationServicesData();
		_duplicateHousingList = getDuplicateHousingData();
		_assignmentHousingList = getAssignmentHousingData();
		_oneTimePaymentList = getOneTimePaymentData();
		_ongoingPaymentReimbursementList = getOngoingPaymentReimbursementData();
		_propertyManagementList = getPropertyManagementData();
		_homePurchaseList = getHomePurchaseData();
		_houseHoldGoodsList = getHouseHoldGoodData();
		_mobilityXAuthorizationDataList = getMobilityXAuthData();
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
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _loginDetailsFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<PDT_LoginInfo> getLoginInfoByEnvt() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_loginInfoFilePath));
			PDT_LoginInfo[] loginInfo = gson.fromJson(bufferReader, PDT_LoginInfo[].class);
			return Arrays.asList(loginInfo);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _loginInfoFilePath);
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
	
	private List<PDT_FinalMoveBenefit> getFinalMoveData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_FinalMoveFilePath));
			PDT_FinalMoveBenefit[] finalMove = gson.fromJson(bufferReader, PDT_FinalMoveBenefit[].class);
			return Arrays.asList(finalMove);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _FinalMoveFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_HomeLeaveBenefit> getHomeLeaveData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_HomeLeaveFilePath));
			PDT_HomeLeaveBenefit[] homeLeave = gson.fromJson(bufferReader, PDT_HomeLeaveBenefit[].class);
			return Arrays.asList(homeLeave);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _HomeLeaveFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_TemporaryLivingBenefit> getTemporaryLivingData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_TemporaryLivingFilePath));
			PDT_TemporaryLivingBenefit[] tempLiving = gson.fromJson(bufferReader, PDT_TemporaryLivingBenefit[].class);
			return Arrays.asList(tempLiving);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _TemporaryLivingFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_DestinationServicesBenefit> getDestinationServicesData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_DestinationServicesFilePath));
			PDT_DestinationServicesBenefit[] destinationServices = gson.fromJson(bufferReader, PDT_DestinationServicesBenefit[].class);
			return Arrays.asList(destinationServices);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _DestinationServicesFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_RentalAssistanceBenefit> getRentalAssistanceData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_RentalAssistanceFilePath));
			PDT_RentalAssistanceBenefit[] rentalAssistance = gson.fromJson(bufferReader, PDT_RentalAssistanceBenefit[].class);
			return Arrays.asList(rentalAssistance);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _RentalAssistanceFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_CompensationServicesBenefit> getCompensationServicesData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_CompensationServicesFilePath));
			PDT_CompensationServicesBenefit[] compensationServices = gson.fromJson(bufferReader, PDT_CompensationServicesBenefit[].class);
			return Arrays.asList(compensationServices);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _CompensationServicesFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_DuplicateHousingBenefit> getDuplicateHousingData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_DuplicateHousingFilePath));
			PDT_DuplicateHousingBenefit[] duplicateHousing = gson.fromJson(bufferReader, PDT_DuplicateHousingBenefit[].class);
			return Arrays.asList(duplicateHousing);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _DuplicateHousingFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_OneTimePaymentBenefit> getOneTimePaymentData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_OneTimePaymentFilePath));
			PDT_OneTimePaymentBenefit[] oneTimePayment = gson.fromJson(bufferReader, PDT_OneTimePaymentBenefit[].class);
			return Arrays.asList(oneTimePayment);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _OneTimePaymentFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_OngoingPaymentReimbursementBenefit> getOngoingPaymentReimbursementData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_OngoingPaymentReimbursementFilePath));
			PDT_OngoingPaymentReimbursementBenefit[] oneTimePayment = gson.fromJson(bufferReader, PDT_OngoingPaymentReimbursementBenefit[].class);
			return Arrays.asList(oneTimePayment);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _OngoingPaymentReimbursementFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}

	private List<PDT_AssignmentHousingBenefit> getAssignmentHousingData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_AssignmentHousingFilePath));
			PDT_AssignmentHousingBenefit[] assignmentHousing = gson.fromJson(bufferReader, PDT_AssignmentHousingBenefit[].class);
			return Arrays.asList(assignmentHousing);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _AssignmentHousingFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_PropertyManagementBenefit> getPropertyManagementData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_PropertyManagementFilePath));
			PDT_PropertyManagementBenefit[] propertyManagement = gson.fromJson(bufferReader, PDT_PropertyManagementBenefit[].class);
			return Arrays.asList(propertyManagement);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _PropertyManagementFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_HomePurchaseBenefit> getHomePurchaseData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_HomePurchaseFilePath));
			PDT_HomePurchaseBenefit[] homePurchaseBenefit = gson.fromJson(bufferReader, PDT_HomePurchaseBenefit[].class);
			return Arrays.asList(homePurchaseBenefit);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _HomePurchaseFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}
	
	private List<PDT_HouseHoldGoodsBenefit> getHouseHoldGoodData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_HouseholdGoodsFilePath));
			PDT_HouseHoldGoodsBenefit[] houseHoldGoodBenefit = gson.fromJson(bufferReader, PDT_HouseHoldGoodsBenefit[].class);
			return Arrays.asList(houseHoldGoodBenefit);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _HouseholdGoodsFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}		
	}

	private List<MobilityX_AuthorizationData> getMobilityXAuthData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_MobilityXAuthDataFilePath));
			MobilityX_AuthorizationData[] mobilityXAuthData = gson.fromJson(bufferReader, MobilityX_AuthorizationData[].class);
			return Arrays.asList(mobilityXAuthData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _MobilityXAuthDataFilePath);
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
	
	public final PDT_LoginInfo getLoginByEnvt(String envt) {
		return _loginInfoList.stream().filter(x -> x.environment.equalsIgnoreCase(envt)).findAny().get();
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
	
	public final PDT_FinalMoveBenefit getFinalMoveDataList(String policyBenefit) {
		return _finalMoveList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_HomeLeaveBenefit getHomeLeaveDataList(String policyBenefit) {
		return _homeLeaveList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_TemporaryLivingBenefit getTemporaryLivingDataList(String policyBenefit) {
		return _temporaryLivingList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_DestinationServicesBenefit getDestinationServicesDataList(String policyBenefit) {
		return _destinationServicesList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_RentalAssistanceBenefit getRentalAssistanceDataList(String policyBenefit) {
		return _rentalAssistanceList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_CompensationServicesBenefit getCompensationServicesDataList(String policyBenefit) {
		return _compensationServicesList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_DuplicateHousingBenefit getDuplicateHousingDataList(String policyBenefit) {
		return _duplicateHousingList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_AssignmentHousingBenefit getAssignmentHousingDataList(String policyBenefit) {
		return _assignmentHousingList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_OneTimePaymentBenefit getOneTimePaymentBenefitDataList(String policyBenefit) {
		return _oneTimePaymentList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_OngoingPaymentReimbursementBenefit getOngoingPaymentReimbursementDataList(String policyBenefit) {
		return _ongoingPaymentReimbursementList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_PropertyManagementBenefit getPropertyManagementDataList(String policyBenefit) {
		return _propertyManagementList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_HomePurchaseBenefit getHomePurchaseDataList(String policyBenefit) {
		return _homePurchaseList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final PDT_HouseHoldGoodsBenefit getHouseHoldGoodsDataList(String policyBenefit) {
		return _houseHoldGoodsList.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final MobilityX_AuthorizationData getDataByModuleName(String moduleName) {
		return _mobilityXAuthorizationDataList.stream().filter(x -> x.module.equalsIgnoreCase(moduleName)).findAny().get();
	}
}