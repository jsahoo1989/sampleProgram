package com.aires.utilities;

import org.testng.asserts.SoftAssert;

public class CustomSoftAssert extends SoftAssert {
	protected String getErrorDetails(Throwable error) {    
		StringBuilder sb = new StringBuilder();
		sb.append(error.getMessage().split("expected")[0]);
	    Throwable cause = error.getCause();
	    while (cause != null) {
	      sb.append(" ").append(cause.getMessage());
	      cause = cause.getCause();
	    }
	    return sb.toString();
	  }
}
