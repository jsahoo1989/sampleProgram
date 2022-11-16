package com.aires.utilities;

public class MyloNewFileUtil {
	
	private static String _transfereeFirstName;
	private static String _transfereeLastName;
	private static String _fileID;
	private static String _clientID;
	private static String _policyType;
	private static String _journeyType;
	private static String _officeType;
	private static String _taxTreatment;
	private static boolean _repatInd;

	public static String getTransfereeFirstName() {
		return _transfereeFirstName;
	}

	public static void setTransfereeFirstName(String tFName) {
		_transfereeFirstName = tFName;
	}

	public static String getTransfereeLastName() {
		return _transfereeLastName;
	}

	public static void setTransfereeLastName(String tLName) {
		_transfereeLastName = tLName;
	}

	public static String getFileID() {
		return _fileID;
	}

	public static void setFileID(String fID) {
		_fileID = fID;
	}

	public static String getClientID() {
		return _clientID;
	}

	public static void setClientID(String cID) {
		_clientID = cID;
	}

	public static String getPolicyType() {
		return _policyType;
	}

	public static void setPolicyType(String pType) {
		_policyType = pType;
	}

	public static String getJourneyType() {
		return _journeyType;
	}

	public static void setJourneyType(String jType) {
		_journeyType = jType;
	}

	public static String getOfficeType() {
		return _officeType;
	}

	public static void setOfficeType(String oType) {
		_officeType = oType;
	}

	public static String getTaxTreatment() {
		return _taxTreatment;
	}

	public static void setTaxTreatment(String treatment) {
		_taxTreatment = treatment;
	}

	public static boolean isRepatInd() {
		return _repatInd;
	}

	public static void setRepatInd(boolean rInd) {
		_repatInd = rInd;
	}

}
