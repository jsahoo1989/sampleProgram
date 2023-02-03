package com.aires.utilities;

import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.internal.win32.TCHAR;

import com.aires.utilities.TesProc.User32;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

public class getWindowText {

	public static final String getActiveWindowText() {
		setIRISForegroundWindow();
		int handle = OS.GetForegroundWindow();
		int length = OS.GetWindowTextLength(handle);
		if (length == 0)
			return "";
		// Use the character encoding for the default locale
		TCHAR buffer = new TCHAR(0, length + 1);
		OS.GetWindowText(handle, buffer, length + 1);
		return buffer.toString(0, length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(getActiveWindowText());
	}

	static interface User32 extends StdCallLibrary {
		@SuppressWarnings("deprecation")
		User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);

		interface WNDENUMPROC extends StdCallCallback {
			boolean callback(Pointer hWnd, Pointer arg);
		}

		boolean EnumWindows(WNDENUMPROC lpEnumFunc, Pointer userData);

		int GetWindowTextA(Pointer hWnd, byte[] lpString, int nMaxCount);

		Pointer GetWindow(Pointer hWnd, int uCmd);
	}

	public static void setIRISForegroundWindow() {
		final User32 user32 = User32.INSTANCE;

		user32.EnumWindows(new User32.WNDENUMPROC() {

			@Override
			public boolean callback(Pointer hWnd, Pointer arg) {
				byte[] windowText = new byte[512];
				user32.GetWindowTextA(hWnd, windowText, 512);
				String wText = Native.toString(windowText).trim();
				if (!wText.isEmpty() && wText.contains("IRIS Login")) {				
					OS.SetForegroundWindow(hWnd.hashCode());
				}
				return true;				
			}
		}, null);
	}

}