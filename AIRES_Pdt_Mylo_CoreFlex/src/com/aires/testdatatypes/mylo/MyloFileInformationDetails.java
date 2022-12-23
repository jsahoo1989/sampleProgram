package com.aires.testdatatypes.mylo;

import java.util.List;

public class MyloFileInformationDetails {
	public String environment;
	public List<JourneyDetails> journeyDetails;
	
	public class JourneyDetails{
		public String fileType;
		public String fileId;
		public String clientId;
		public String clientName;
		public String policyType;
		public String details;
	}
	
}
