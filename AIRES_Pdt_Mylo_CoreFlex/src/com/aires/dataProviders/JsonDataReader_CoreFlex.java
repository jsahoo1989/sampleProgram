package com.aires.dataProviders;

import com.aires.managers.FileReaderManager;

public class JsonDataReader_CoreFlex {
	
	private final String _housingBenefitsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/CoreFlex_HousingBenefitsData.json";
	
	private final String _lifeStyleBenefitsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "coreflex/CoreFlex_LifestyleBenefitsData.json";
	
//	private List<CoreFlex_HousingBenefitsData> _housingBenefitslist;
//	private List<CoreFlex_LifestyleBenefitsData> _lifeStyleBenefitslist;
//	
//	public JsonDataReader_CoreFlex() {
//		_housingBenefitslist = getHousingBenefitData();
//		_lifeStyleBenefitslist = getLifeStyleBenefitData();
//	}
//	
//	private List<CoreFlex_HousingBenefitsData> getHousingBenefitData() {
//		Gson gson = new Gson();
//		BufferedReader bufferReader = null;
//		try {
//			bufferReader = new BufferedReader(new FileReader(_housingBenefitsFilePath));
//			CoreFlex_HousingBenefitsData[] housingBenefitList = gson.fromJson(bufferReader, CoreFlex_HousingBenefitsData[].class);
//			return Arrays.asList(housingBenefitList);
//		} catch (FileNotFoundException e) {
//			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _housingBenefitsFilePath);
//		} finally {
//			try {
//				if (bufferReader != null)
//					bufferReader.close();
//			} catch (IOException ignore) {
//			}
//		}
//	}
//	
//	private List<CoreFlex_LifestyleBenefitsData> getLifeStyleBenefitData() {
//		Gson gson = new Gson();
//		BufferedReader bufferReader = null;
//		try {
//			bufferReader = new BufferedReader(new FileReader(_lifeStyleBenefitsFilePath));
//			CoreFlex_LifestyleBenefitsData[] lifeStyleBenefitList = gson.fromJson(bufferReader, CoreFlex_LifestyleBenefitsData[].class);
//			return Arrays.asList(lifeStyleBenefitList);
//		} catch (FileNotFoundException e) {
//			throw new RuntimeException(CoreConstants.JSON_FILE_NOT_FOUND_AT_PATH + _lifeStyleBenefitsFilePath);
//		} finally {
//			try {
//				if (bufferReader != null)
//					bufferReader.close();
//			} catch (IOException ignore) {
//			}
//		}
//	}
//	
//	public final CoreFlex_HousingBenefitsData getHousingBenefitDataList(String policyBenefit) {
//		return _housingBenefitslist.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
//	}
//	
//	public final CoreFlex_LifestyleBenefitsData getLifeStyleBenefitDataList(String policyBenefit) {
//		return _lifeStyleBenefitslist.stream().filter(x -> x.benefitName.equalsIgnoreCase(policyBenefit)).findAny().get();
//	}

}