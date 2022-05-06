package com.aires.iris.web.helpers;

import com.aires.utilities.Log;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.CheckBox;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.RadioGroup;
import com.hp.lft.sdk.web.WebElement;

public class WebHelpers {
	
	public WebHelpers() throws Exception {		
	}
	
	public static void setEditorText(EditField editor, String text, String elementName)
	{
		try {
			editor.waitUntilVisible();
			editor.setValue(text);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	public static void clickButton(Button button, String elementName)
	{
		try {
			button.waitUntilEnabled();
			button.click();
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}		
	}
	
	public static void clickLink(Link link, String elementName)
	{
		try {
			link.waitUntilExists();
			link.click();
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}		
	}
	
	public static void clickRadioButton(RadioGroup button, String elementName)
	{
		try {
			button.waitUntilEnabled();
			button.click();
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}		
	}
	
	public static void selectFromList(ListBox list, String option, String elementName)
	{		
		try {
			list.waitUntilVisible();
			list.select(option);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}
	
	public static void WaitTillElementVisible(WebElement element, int time) {		
		try {
			element.waitUntilVisible(time);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}
	
	public static void clickElement(WebElement element, String elementName)
	{
		try {
			element.waitUntilExists();
			element.click();
			Log.info("Verfified clicked element:-"+elementName);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}		
	}
	
	public static void clickImageIcon(Image element, String elementName)
	{
		try {
			element.waitUntilExists();
			element.click();
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}		
	}
	
	public static void clickCheckBox(CheckBox element, String elementName)
	{
		try {
			element.waitUntilExists();
			element.set(true);
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}		
	}
	
}
