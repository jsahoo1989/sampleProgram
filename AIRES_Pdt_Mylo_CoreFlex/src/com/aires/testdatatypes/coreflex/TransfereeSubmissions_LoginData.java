package com.aires.testdatatypes.coreflex;

public class TransfereeSubmissions_LoginData {

	public String application;
	public Dev dev;
	public Qa qa;
	public Uat uat;
	public PreProd preprod;
	public Prod prod;

	public class Dev {
		public String userName;
		public String password;
		public String fullName;
	}

	public class Qa {
		public String userName;
		public String password;
		public String fullName;
	}

	public class Uat {
		public String userName;
		public String password;
		public String fullName;
	}
	
	public class PreProd {
		public String userName;
		public String password;
		public String fullName;
	}

	public class Prod {
		public String userName;
		public String password;
		public String fullName;
	}
}