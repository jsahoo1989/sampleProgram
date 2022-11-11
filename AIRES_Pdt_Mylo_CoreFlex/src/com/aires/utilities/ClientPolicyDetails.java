package com.aires.utilities;

public class ClientPolicyDetails {
	private static Integer policyId;
	private static String policyName;
	private static String clientId;
	private static String clientName;
	public static void setPolicyName(String pName) {
		policyName = pName;
	}

	public static String getPolicyName() {
		return policyName;
	}

	public static void setPolicyId(int pId) {
		policyId = pId;
	}

	public static Integer getPolicyId() {
		return policyId;
	}
	
	public static void setClientId(String cId) {
		clientId = cId;
	}

	public static void setClientName(String cName) {
		clientName = cName;
	}
	
	public static String getClientId() {
		return clientId;
	}

	public static String getClientName() {
		return clientName;
	}
}
