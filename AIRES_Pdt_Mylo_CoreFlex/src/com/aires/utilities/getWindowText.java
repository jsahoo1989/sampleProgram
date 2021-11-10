package com.aires.utilities;

import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.internal.win32.TCHAR;

public class getWindowText {
	
	  public static final String getActiveWindowText() {
	        int handle = OS.GetForegroundWindow();
	        int length = OS.GetWindowTextLength(handle);
	        if(length == 0) return "";
	        // Use the character encoding for the default locale
	        TCHAR buffer = new TCHAR(0, length + 1);
	        OS.GetWindowText(handle, buffer, length + 1);
	        return buffer.toString(0, length);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
	        Thread.sleep(1000L);
	    } catch(InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	    System.out.println(getActiveWindowText());
	}
}