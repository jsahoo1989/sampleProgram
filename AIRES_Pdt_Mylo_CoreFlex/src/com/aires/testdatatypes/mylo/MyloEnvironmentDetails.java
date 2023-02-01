package com.aires.testdatatypes.mylo;

public class MyloEnvironmentDetails {
	public String environment;
	public Details details;

	public String getEnvironment() {
		return environment;
	}

	public class Details {
		public String myloUserWithResources;
		public String myloUserWithoutResources;
		public String myloPassword;
		public String myloProfileName;
		public String myloFileID;
		public String clientId;
		public String clientName;
		public String mxClientUserName;
		public String mxClientPassword;
		public String mxClientUserProfileName;
		public String mobilityXURL;
		public String myloURL;
		public String transfereeName;

		public void setMyloFileID(String myloFileID) {
			this.myloFileID = myloFileID;
		}

	}

}