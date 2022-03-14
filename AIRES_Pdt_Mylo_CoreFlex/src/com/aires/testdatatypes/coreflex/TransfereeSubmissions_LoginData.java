package com.aires.testdatatypes.coreflex;


public class TransfereeSubmissions_LoginData {
	
	public String application;
	public LoginUserDEV loginUserDEV;
	public LoginUserQA loginUserQA;
	public LoginUserUAT loginUserUAT;

	public class LoginUserDEV {
		public String userName;
		public String password;
		public String fullName;
	}

	public class LoginUserQA {
		public String userName;
		public String password;
		public String fullName;
	}
	
	public class LoginUserUAT {
		public String userName;
		public String password;
		public String fullName;
	}
}