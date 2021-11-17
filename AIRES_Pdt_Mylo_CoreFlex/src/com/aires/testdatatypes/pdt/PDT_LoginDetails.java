package com.aires.testdatatypes.pdt;


public class PDT_LoginDetails {
	
	public String application;
	public MxTransferee mxTransferee;
	public SpringboardTransferee springboardTransferee;
	public UserIRISTestQA userIRISTestQA;
	public UserIRISTestDEV userIRISTestDEV;
	public UserIRISProd userIRISProd;

	public class MxTransferee {
		public String userName;
		public String password;
		public String firstName;
		public String lastName;

	}

	public class MxLinkedTransferee {
		public String userName;
		public String password;
		public String firstName;
		public String lastName;
	}

	public class SpringboardTransferee {
		public String userName;
		public String password;
		public String firstName;
		public String lastName;

	}

	public class UserIRISTestQA {
		public String userName;
		public String password;
		public String firstName;
		public String lastName;
	}

	public class UserIRISTestDEV {
		public String userName;
		public String password;
		public String firstName;
		public String lastName;
	}
	
	public class UserIRISProd {
		public String userName;
		public String password;
		public String firstName;
		public String lastName;
	}

}