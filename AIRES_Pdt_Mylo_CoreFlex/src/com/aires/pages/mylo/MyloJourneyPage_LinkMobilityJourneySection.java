package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;

public class MyloJourneyPage_LinkMobilityJourneySection extends Base {
	public MyloJourneyPage_LinkMobilityJourneySection(WebDriver driver) {
		super(driver);
	}

	// WebElements related to Link Mobility Journey section

	@FindBy(how = How.CSS, using = "app-similar-assignments")
	private WebElement _linkMobJourneyPopUp;

	@FindBy(how = How.CSS, using = "div[class='mylo-grid-warea similar-assignment-warea'] label")
	private List<WebElement> _linkMobJourneyTransfereeNames;

	@FindBy(how = How.CSS, using = "div[class*='subtitle-text']")
	private List<WebElement> _dataIntegrityAlertMsg;

	@FindBy(how = How.CSS, using = "app-similar-assignments button[class*='mylo-query']")
	private List<WebElement> _linkMobJourneyPopUpButtons;
	
	@FindBy(how = How.CSS, using = "app-filenotepurplebubble")
	private WebElement _purpleBubbleSectionSummaryPage;

	@FindBy(how = How.CSS, using = "app-footer button")
	private List<WebElement> _footerSectionBtns;
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	public boolean isLinkMobilityJourneyPopUpExist() {
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		return CoreFunctions.isElementExist(driver, _linkMobJourneyPopUp, 6);
	}

	public void clickButtonsOnLinkMobJourneySection(String btnName, String section) {
		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _linkMobJourneyPopUpButtons);
			CoreFunctions.clickItemInListByText(driver, _linkMobJourneyPopUpButtons, btnName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, btnName));
		}
	}

	public boolean verifyDataIntegrityAlertMsg() {
		List<String> actualTextList = _dataIntegrityAlertMsg.stream().map(i -> CoreFunctions.getElementText(driver, i))
				.collect(Collectors.toList());
		List<String> expectedTextList = new ArrayList<String>(Arrays.asList(MYLOConstants.LINK_NEW_JOURNEY_MSG,
				MYLOConstants.LINK_EXISTING_JOURNEY_MSG, MYLOConstants.DECISION_FOR_LINKING_MSG));
		return actualTextList.equals(expectedTextList);
	}

	public boolean verifyAllMatchedTransfereeNames(String transfereeName) {
		return _linkMobJourneyTransfereeNames.stream().allMatch(i -> CoreFunctions.getElementText(driver, i).contains(transfereeName));
	}
	
	public boolean isNavigatedToSummaryPage() {
		return CoreFunctions.isElementExist(driver, _purpleBubbleSectionSummaryPage, MYLOConstants.CUSTOM_WAIT_TIME);
	}
	
	public void clickOnFooterSectionBtns(String btnName) {
		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _footerSectionBtns);
			BusinessFunctions.selectItemFromListUsingText(driver, _footerSectionBtns, MYLOConstants.SEND_LOGIN_CREDENTIALS);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, btnName));
		}
	}

}
