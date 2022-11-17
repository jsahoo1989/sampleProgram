package com.aires.managers;

import org.openqa.selenium.WebDriver;

import com.aires.pages.mobilityx.MobilityX_AuthorizationPage;
import com.aires.pages.mobilityx.MobilityX_DashboardHomePage;
import com.aires.pages.mobilityx.MobilityX_LoginPage;

public class PageObjectManager_MobilityX {
	private WebDriver _driver;
	private MobilityX_LoginPage _loginPage;
	private MobilityX_DashboardHomePage _dashboardHomePage;
	private MobilityX_AuthorizationPage _authorizationPage;
	
	public PageObjectManager_MobilityX(WebDriver driver) {
		this._driver = driver;
	}

	public MobilityX_LoginPage getLoginPage() {
		return (_loginPage == null) ? _loginPage = new MobilityX_LoginPage(_driver) : _loginPage;
	}
	
	public MobilityX_DashboardHomePage getDashboardHomePage() {
		return (_dashboardHomePage == null) ? _dashboardHomePage = new MobilityX_DashboardHomePage(_driver)
				: _dashboardHomePage;
	}
	
	public MobilityX_AuthorizationPage getAuthorizationPage() {
		return (_authorizationPage == null) ? _authorizationPage = new MobilityX_AuthorizationPage(_driver)
				: _authorizationPage;
	}
}
