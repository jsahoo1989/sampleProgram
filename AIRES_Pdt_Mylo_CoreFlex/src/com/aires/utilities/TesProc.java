package com.aires.utilities;

import java.io.FileInputStream;
import com.aires.businessrules.DbFunctions;

public class TesProc {
	public static String  path;
	public static FileInputStream fis = null;

	
	 public static void main(String[] args)  {
		 Log.info("Start");
		 DbFunctions.deletePolicyByPolicyId(14724);
		 Log.info("Stop");		
	 }
}
