package com.aires.testdatatypes.iris;

public class IRIS_AssignmentData {
	public String tabName;
	public File file;
	public ClientContact clientContact;
	public AiresFileTeamHistory airesFileTeamHistory;
	public OriginAddress originAddress;
	public DestinationAddress destinationAddress;
	public Authorization authorization;
	public String firstName;
	public String lastName;
	public BasicInformation basicInformation;
	public MiscInformation miscInformation;
	public File_AnotherClient file_AnotherClient;
	public ClientAnother_Contact clientAnother_Contact;

	public class AiresFileTeamHistory {
		public String functionEMAC;
		public String empNameEMAC;
		public String functionMSPEC;
		public String empNameMSPEC;
		public String functionPPC;
		public String empNamePPC;
	}

	public class Authorization {
		public String type;
		public String number;
	}

	public class BasicInformation {
		public String transferType;
		public String citizenship;
		public String emailAddress;
		public String type;
		public String description;
		public String springboardEmailAddress;
	}

	public class ClientContact {
		public String fName;
		public String lName;
		public String prefix;
		public String gen;
		public String email;
	}

	public class DestinationAddress {
		public String street1;
		public String city;
		public String zip;
		public String state;
		public String country;
	}

	public class File {
		public String type;
		public String office;
		public String springboardPolicy;
		public String sprinboardUserClientID;
	}

	public class MiscInformation {
		public String homeStat;
	}

	public class OriginAddress {
		public String street1;
		public String city;
		public String zip;
		public String state;
		public String country;
	}

	public class File_AnotherClient {
		public String clientID;
		public String policy;
	}

	public class ClientAnother_Contact {
		public String fName;
		public String lName;
	}
}