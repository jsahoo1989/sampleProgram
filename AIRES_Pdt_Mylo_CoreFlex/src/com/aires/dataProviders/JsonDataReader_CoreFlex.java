package com.aires.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_AllowancesBenefitsData;
import com.aires.testdatatypes.coreflex.CoreFlex_HousingBenefitsData;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.CoreFlex_SettlingInBenefitsData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.aires.testdatatypes.coreflex.MX_Transferee_AccountSetupDetails;
import com.aires.testdatatypes.coreflex.MX_Transferee_BenefitData;
import com.aires.testdatatypes.coreflex.MX_Transferee_LoginData;
import com.aires.testdatatypes.coreflex.MX_Transferee_MyProfileData;
import com.aires.testdatatypes.coreflex.TransfereeSubmissions_LoginData;
import com.google.gson.Gson;

public class JsonDataReader_CoreFlex {
	
	private final String _housingBenefitsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/CoreFlex_HousingBenefitsData.json";
	
	private final String _allowanceBenefitsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/CoreFlex_AllowancesBenefitsData.json";
	
	private final String _settlingInBenefitsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/CoreFlex_SettlingInBenefitsData.json";
	
	private final String _mxTransfereeLoginDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/MX_Transferee_LoginData.json";
	
	private final String _policySetupPagesDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/CoreFlex_PolicySetupPagesData.json";
	
	private final String _transfereeSubmissionsLoginDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/TransfereeSubmissions_LoginData.json";
	
	private final String _mxTransfereeBenefitDataFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/MX_Transferee_BenefitData.json";
	
	private final String _mxTransfereeAccountSetupDetailsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/MX_Transferee_AccountSetupDetails.json";
	
	private final String _mxTransfereeMyProfileFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/MX_Transferee_MyProfileData.json";
	
	private List<CoreFlex_HousingBenefitsData> _housingBenefitslist;
	private List<CoreFlex_AllowancesBenefitsData> _allowancesBenefitslist;
	private List<CoreFlex_SettlingInBenefitsData> _settlingInBenefitslist;
	private List<MX_Transferee_LoginData> _mxTransfereeLoginDatalist;
	private List<CoreFlex_PolicySetupPagesData> _policySetupPagesDatalist;
	private List<TransfereeSubmissions_LoginData> _transfereeSubmissionsLoginDatalist;
	private MX_Transferee_AccountSetupDetails _mxTransfereeAccountDetails;
	private List<MX_Transferee_MyProfileData> _mxTransfereeMyProfileDataList;
	private MX_Transferee_BenefitData _mxTransfereeBenefitData;
	
	public JsonDataReader_CoreFlex() {
		_housingBenefitslist = getHousingBenefitData();
		_allowancesBenefitslist = getAllowancesBenefitData();
		_settlingInBenefitslist = getSettlingInBenefitData();
		_mxTransfereeLoginDatalist = getMXTransfereeLoginData();
		_policySetupPagesDatalist = getPolicySetupPagesData();
		_transfereeSubmissionsLoginDatalist = getTransfereeSubmissionsLoginData();
		_mxTransfereeAccountDetails = getAccountSetupDetails();
		_mxTransfereeMyProfileDataList = getMXTransfereeMyProfileData();
		_mxTransfereeBenefitData = getMXTransfereeBenefitData();
	}
	
	private List<CoreFlex_HousingBenefitsData> getHousingBenefitData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_housingBenefitsFilePath));
			CoreFlex_HousingBenefitsData[] housingBenefitList = gson.fromJson(bufferReader, CoreFlex_HousingBenefitsData[].class);
			return Arrays.asList(housingBenefitList);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _housingBenefitsFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<CoreFlex_AllowancesBenefitsData> getAllowancesBenefitData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_allowanceBenefitsFilePath));
			CoreFlex_AllowancesBenefitsData[] allowanceBenefitList = gson.fromJson(bufferReader, CoreFlex_AllowancesBenefitsData[].class);
			return Arrays.asList(allowanceBenefitList);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _allowanceBenefitsFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<CoreFlex_SettlingInBenefitsData> getSettlingInBenefitData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_settlingInBenefitsFilePath));
			CoreFlex_SettlingInBenefitsData[] settlingInBenefitList = gson.fromJson(bufferReader, CoreFlex_SettlingInBenefitsData[].class);
			return Arrays.asList(settlingInBenefitList);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _settlingInBenefitsFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<MX_Transferee_LoginData> getMXTransfereeLoginData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_mxTransfereeLoginDataFilePath));
			MX_Transferee_LoginData[] _mxTransfereeLoginDatalist = gson.fromJson(bufferReader, MX_Transferee_LoginData[].class);
			return Arrays.asList(_mxTransfereeLoginDatalist);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _mxTransfereeLoginDataFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<CoreFlex_PolicySetupPagesData> getPolicySetupPagesData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_policySetupPagesDataFilePath));
			CoreFlex_PolicySetupPagesData[] _policySetupPagesDatalist = gson.fromJson(bufferReader, CoreFlex_PolicySetupPagesData[].class);
			return Arrays.asList(_policySetupPagesDatalist);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _policySetupPagesDataFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<TransfereeSubmissions_LoginData> getTransfereeSubmissionsLoginData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_transfereeSubmissionsLoginDataFilePath));
			TransfereeSubmissions_LoginData[] _transfereeSubmissionLoginDatalist = gson.fromJson(bufferReader, TransfereeSubmissions_LoginData[].class);
			return Arrays.asList(_transfereeSubmissionLoginDatalist);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _transfereeSubmissionsLoginDataFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
		
	private MX_Transferee_AccountSetupDetails getAccountSetupDetails() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_mxTransfereeAccountSetupDetailsFilePath));
			MX_Transferee_AccountSetupDetails _accountSetupDetails = gson.fromJson(bufferReader,
					MX_Transferee_AccountSetupDetails.class);
			return _accountSetupDetails;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(
					CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _mxTransfereeAccountSetupDetailsFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<MX_Transferee_MyProfileData> getMXTransfereeMyProfileData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_mxTransfereeMyProfileFilePath));
			MX_Transferee_MyProfileData[] _myProfileData = gson.fromJson(bufferReader,
					MX_Transferee_MyProfileData[].class);
			return Arrays.asList(_myProfileData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(
					CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _mxTransfereeMyProfileFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private MX_Transferee_BenefitData getMXTransfereeBenefitData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(_mxTransfereeBenefitDataFilePath));
			return gson.fromJson(bufferReader, MX_Transferee_BenefitData.class);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _mxTransfereeBenefitDataFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	
	public final CoreFlex_HousingBenefitsData getHousingBenefitDataList(String policyBenefit) {
		return _housingBenefitslist.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final CoreFlex_AllowancesBenefitsData getLifeStyleBenefitDataList(String policyBenefit) {
		return _allowancesBenefitslist.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final CoreFlex_SettlingInBenefitsData getSettlingInBenefitDataList(String policyBenefit) {
		return _settlingInBenefitslist.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
	}
	
	public final MX_Transferee_LoginData getloginDetailsByUserFirstName(String userFirstName) {
		return _mxTransfereeLoginDatalist.stream().filter(x -> x.firstName.equalsIgnoreCase(userFirstName)).findAny().get();
	}
	
	public final CoreFlex_PolicySetupPagesData getPolicySetupPagesDataList(String pageName) {
		return _policySetupPagesDatalist.stream().filter(x -> x.application.equalsIgnoreCase(pageName)).findAny().get();
	}
	
	public final TransfereeSubmissions_LoginData getTransfereeSubmissionLoginDataList(String applicationName) {
		return _transfereeSubmissionsLoginDatalist.stream().filter(x -> x.application.equalsIgnoreCase(applicationName)).findAny().get();
	}
	
	public List<Benefit> getMXTransfereeCoreBenefitDetails() {
		return _mxTransfereeBenefitData.getCoreBenefits();
	}
	
	public MX_Transferee_AccountSetupDetails getMxTransfereeAccountSetupDetails() {
		return _mxTransfereeAccountDetails;
	}
	
	public final MX_Transferee_MyProfileData getMyProfileDataDataByUserFirstName(String userFirstName) {
		return _mxTransfereeMyProfileDataList.stream().filter(x -> x.firstName.equalsIgnoreCase(userFirstName)).findAny()
				.get();
	}
	
	public List<FlexBenefit> getMXTransfereeFlexBenefitData() {
		return _mxTransfereeBenefitData.getFlexBenefits();
	}
	
	public List<Benefit> getAllFlexBenefitsData() {
		List<Benefit> benefits = new ArrayList<Benefit>();
		_mxTransfereeBenefitData.getFlexBenefits().stream().forEach(b -> benefits.addAll(b.getBenefits()));
		return benefits;
	}
}