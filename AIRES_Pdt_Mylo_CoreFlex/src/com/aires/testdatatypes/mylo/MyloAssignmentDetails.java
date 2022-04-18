package com.aires.testdatatypes.mylo;


public class MyloAssignmentDetails {
	public String application;
	public ActiveAssignment activeAssignment;
	public AffinityEnabled affinityEnabled;
	public AffinityNotEnabled affinityNotEnabled;
	public AiresshProvider airesshProvider;
	public NotAiresshProvider notairesshProvider;
	public CanceledFile canceledFile;
	public ClosedFile closedFile;
	public RelocationPolicyType relocationPolicyType;
	public LumpSumpPlanPolicyType lumpSumpPlanPolicyType;
	public DomesticPolicyType domesticPolicyType;
	public ClosedFileIdentDoc closedFileIdentDoc;
	public TransfereeWithFamily transfereeWithFamily;
	public TransfereeWithOtherFamilyMembers transfereeWithOtherFamilyMembers;

	public class ActiveAssignment {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class AffinityEnabled {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class AffinityNotEnabled {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class AiresshProvider {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class NotAiresshProvider {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class CanceledFile {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class ClosedFile {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class RelocationPolicyType {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class LumpSumpPlanPolicyType {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class DomesticPolicyType {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class ClosedFileIdentDoc {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}

	public class TransfereeWithFamily {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}
	
	public class TransfereeWithOtherFamilyMembers {
		public String fileID;
		public String clientID;
		public String clientName;
		public String status;
		public String policyType;
		public String provider;
		public String journeyType;
		public String office;
	}
}