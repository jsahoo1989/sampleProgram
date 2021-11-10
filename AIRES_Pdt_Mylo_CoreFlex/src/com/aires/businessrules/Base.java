/***********************************Header Start*********************************************************************************
 * Application/ Module Name				: AIRES
 * Class Name        				    : Login Page 
 * Owner								: Test Automation Team
 ***********************************************************************
 * Creation /Modification Log: 
 * Date				By					  Notes                                    
 ---------			--------			---------
 *22/04/2020		Rahul Sharma		Create Base class to implement singleton class 
 ***********************************************************************
 * Review/Feedback Log: 
 * Date				By					Notes                                    
 ---------			--------			---------
 * [Date]			[Reviewer]			[Brief description of the review/feedback comments]

 ************************************************************************************************
 * Functional Test Coverage Description  : Identified and defined all web elements in Add Role.												   
 ************************************************************************************************
 * Notes								: NA
 * Assumptions							: NA
 * Limitations							: NA
=============List of Resources used=========================
 * User Defined Functions				: BusinessFunctions
 ***********************************Header End*********************************************************************************/

package com.aires.businessrules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aires.managers.WebDriverManager;

public class Base {

	protected WebDriver driver;
	WebDriverManager webDriverManager;

	//Constructor
	public Base (WebDriver driver){
		if (driver==null) {
			driver = webDriverManager.getDriver();
			PageFactory.initElements(driver,  this);
		}
		else {
			this.driver = driver;
			PageFactory.initElements(driver,  this);
		}
	}
}
