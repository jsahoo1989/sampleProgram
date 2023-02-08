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
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_LinkMobilityJourneySection extends Base {
	public MyloJourneyPage_LinkMobilityJourneySection(WebDriver driver) {
		super(driver);
	}

	// WebElements related to Link Mobility Journey section

	@FindBy(how = How.CSS, using = "app-similar-assignments")
	private WebElement _linkMobJourneyPopUp;

	@FindBy(how = How.CSS, using = "div[class='mylo-grid-warea similar-assignment-warea'] label")
	private List<WebElement> _linkMobJourneyTransfereeNames;

	@FindBy(how = How.CSS, using = "li[class='text-truncate highlight-matched-col']")
	private List<WebElement> _linkMobJourneyEmailNames;

	@FindBy(how = How.CSS, using = "div[class*='subtitle-text']")
	private List<WebElement> _dataIntegrityAlertMsg;

	@FindBy(how = How.CSS, using = "app-similar-assignments button[class*='mylo-query']")
	private List<WebElement> _linkMobJourneyPopUpButtons;

	@FindBy(how = How.CSS, using = "app-similar-assignments ul[class='even ng-star-inserted'] li label")
	private List<WebElement> _lnkMobJourneyRadioBtns;

	@FindBy(how = How.XPATH, using = "//app-similar-assignments//ul[@class='even ng-star-inserted']/li[5]")
	private List<WebElement> _lnkMobJourneyFileIDs;

	@FindBy(how = How.CSS, using = "app-link-existing-mobility-journey button")
	private List<WebElement> _lnkExistingJourneyBtns;

	@FindBy(how = How.CSS, using = "#pills-profile-tab")
	private List<WebElement> _linkExistingJourneyCard;

	@FindBy(how = How.CSS, using = "div[class*='tab-subtitle']")
	private List<WebElement> _journeyCardDetails;

	@FindBy(how = How.CSS, using = "div[class*='tab-title p']")
	private List<WebElement> _journeyTabInformation;

	@FindBy(how = How.CSS, using = "div[class='mylo-grid-warea similar-assignment-warea'] button")
	private List<WebElement> _filesAttachedToTransferee;

	@FindBy(how = How.CSS, using = "div[class='card card-body expand-wrarea'] li")
	private List<WebElement> _fileInfoAttached;

	@FindBy(how = How.CSS, using = "app-similar-assignments ul[class='mylo-grid-header'] li")
	private List<WebElement> _linkPopUpColumns;

	// WebElements related to Journey Page

	@FindBy(how = How.CSS, using = "app-filenotepurplebubble")
	private WebElement _purpleBubbleSectionSummaryPage;

	@FindBy(how = How.CSS, using = "app-footer button")
	private List<WebElement> _footerSectionBtns;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "button[class='other-journey-btn']")
	private WebElement _linkJourneyBtn;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _errorText;

	@FindBy(how = How.CSS, using = "div[class*='swal2-popup'] button[style*='display: inline-block']")
	private List<WebElement> _errorPopUpBtns;

	/**
	 * Click Buttons On LinkMobJourney Pop Up Section
	 * 
	 * @param btnName
	 * @param section
	 */
	public void clickButtonsOnLinkMobJourneySection(String btnName, String section) {
		try {
			List<WebElement> btnList = (section.equals(MYLOConstants.LINK_MOBILITY_JOURNEY))
					? _linkMobJourneyPopUpButtons
					: _lnkExistingJourneyBtns;
			CoreFunctions.explicitWaitTillElementListVisibility(driver, btnList);
			CoreFunctions.clickItemInListByText(driver, btnList, btnName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, btnName));
		}
	}

	/**
	 * Click Yes/No for Linking Different Type of JourneyType
	 * 
	 * @param option
	 */
	public void clickOptionForLinkDifferentJourneyType(String option) {
		try {
			if (CoreFunctions.isElementExist(driver, _errorText, MYLOConstants.CUSTOM_WAIT_TIME)) {
				Assert.assertEquals(CoreFunctions.getElementText(driver, _errorText),
						MYLOConstants.LINK_DIFFERENT_JOURNEY_TYPE_MSG);
				CoreFunctions.explicitWaitTillElementListVisibility(driver, _errorPopUpBtns);
				CoreFunctions.clickItemInListByText(driver, _errorPopUpBtns, option);
				BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, option));
		}
	}

	/**
	 * Click Footer section Buttons of Mylo Journey Page
	 * 
	 * @param btnName
	 */
	public void clickFooterSectionJourneyPage(String btnName) {
		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _footerSectionBtns);
			BusinessFunctions.selectItemFromListUsingText(driver, _footerSectionBtns, btnName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, btnName));
		}
	}

	/**
	 * Click Link Journey Button on Mylo Journey Page
	 */
	public void clickLinkJourneyBtn() {
		try {
			CoreFunctions.click(driver, _linkJourneyBtn, MYLOConstants.LINK_JOURNEY);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.LINK_JOURNEY));
		}
	}

	/**
	 * Click Files Attached To Transferee on Link Mobility Pop Up Section
	 * 
	 * @param name
	 */
	public void clickFilesAttachedToTransferee(String name) {
		try {
			int index = CoreFunctions.getRandomNumber(0, _filesAttachedToTransferee.size());
			CoreFunctions.highlightObject(driver, _filesAttachedToTransferee.get(index));
			CoreFunctions.scrollClickUsingJS(driver, _filesAttachedToTransferee.get(index), name);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, name));
		}
	}

	/**
	 * Select Random Transferee Details on Link Mobility Pop Up Section
	 * 
	 * @return
	 */
	public String selectRandomTransfereeDetail() {
		String fileIDSelected = "";
		try {
			int index = CoreFunctions.getRandomNumber(0, _lnkMobJourneyRadioBtns.size());
			CoreFunctions.click(driver, _lnkMobJourneyRadioBtns.get(index),
					MYLOConstants.LINK_MOBILITY_JOURNEY_RADIO_BUTTON);
			fileIDSelected = CoreFunctions.getElementText(driver, _lnkMobJourneyFileIDs.get(index));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE,
					MYLOConstants.LINK_MOBILITY_JOURNEY_RADIO_BUTTON));
		}
		return fileIDSelected;
	}

	/**
	 * Select Random Journey Card on Link Section
	 * 
	 * @return
	 */
	public String selectRandomJourneyCard() {
		String journeyDetailsSelected = "";
		try {
			int index = CoreFunctions.getRandomNumber(0, _linkExistingJourneyCard.size());
			CoreFunctions.click(driver, _linkExistingJourneyCard.get(index), MYLOConstants.LINK_MOBILITY_JOURNEY_CARD);
			journeyDetailsSelected = CoreFunctions.getElementText(driver, _journeyCardDetails.get(index));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE,
					MYLOConstants.LINK_MOBILITY_JOURNEY_RADIO_BUTTON));
		}
		return journeyDetailsSelected;
	}

	/**
	 * Check Link Mobility Journey Pop Up Exist or not
	 * 
	 * @return
	 */
	public boolean isLinkMobilityJourneyPopUpExist() {
		boolean flag = false;
		try {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			flag = CoreFunctions.isElementExist(driver, _linkMobJourneyPopUp, MYLOConstants.CUSTOM_DISSAPEAR_WAIT_TIME);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, MYLOConstants.LINK_MOBILITY_JOURNEY));
		}
		return flag;
	}

	/**
	 * Check whether navigated to Journey Summary Page or not
	 * 
	 * @return
	 */
	public boolean isNavigatedToSummaryPage() {
		boolean flag = false;
		try {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			flag = CoreFunctions.isElementExist(driver, _purpleBubbleSectionSummaryPage,
					MYLOConstants.CUSTOM_WAIT_TIME);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.PURPLE_BUBBLE_SECTION, MYLOConstants.JOURNEY));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_NAVIGATED_TO_PAGE, CoreConstants.PASS,
					MYLOConstants.JOURNEY));
		return flag;
	}

	/**
	 * Check details of Files Attached to Transferee on Link Mobility Pop Up Section
	 * 
	 * @return
	 */
	public boolean verifyFilesAttachedToTransfereeInLinkSection() {
		boolean flag = false;
		try {
			flag = CoreFunctions.isElementListExist(driver, _fileInfoAttached, MYLOConstants.CUSTOM_WAIT_TIME);
			_fileInfoAttached.stream().map(i -> CoreFunctions.getElementText(driver, i));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, MYLOConstants.FILES_ATTACHED_TRANSFEREE));
		}
		return flag;
	}

	/**
	 * Verify Link Journey Button Text on Journey Page with the expected text passed
	 * as a parameter
	 * 
	 * @param expectedText
	 * @return
	 */
	public boolean verifyJourneyBtnText(String expectedText) {
		boolean flag = false;
		try {
			flag = CoreFunctions.getElementText(driver, _linkJourneyBtn).equals(expectedText);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, expectedText));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_TEXT_VALUE, CoreConstants.PASS,
					MYLOConstants.LINK_JOURNEY, expectedText, MYLOConstants.PURPLE_BUBBLE_SECTION));
		return flag;
	}

	/**
	 * Check buttons enable or disable on Link Mobility Journey Pop Up Section
	 * 
	 * @param btnName
	 * @param type
	 * @param section
	 * @return
	 */
	public boolean verifyLinkMobJourneyButtonEnabilityStatus(String btnName, String type, String section) {
		boolean flag = false;
		try {
			List<WebElement> btnList = (section.equals(MYLOConstants.LINK_MOBILITY_JOURNEY))
					? _linkMobJourneyPopUpButtons
					: _lnkExistingJourneyBtns;
			WebElement element = BusinessFunctions.returnItemIfExistsInList(driver, btnList, btnName);
			flag = BusinessFunctions.verifyMyloButtonEnabilityStatus(type, element, btnName, section,
					MYLOConstants.JOURNEY);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					btnName, section));
		}
		return flag;
	}

	/**
	 * Verify all Column names on Link Mobility Journey Pop Up section
	 * 
	 * @param table
	 * @return
	 */
	public boolean verifyLinkPopUpColumnNames(DataTable table) {
		boolean flag = false;
		try {
			List<String> actualValues = _linkPopUpColumns.stream().map(i -> CoreFunctions.getElementText(driver, i))
					.collect(Collectors.toList());
			flag = table.asLists(String.class).get(0).equals(actualValues);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.LINK_MOBILITY_JOURNEY_COLUMN_NAMES, MYLOConstants.LINK_MOBILITY_JOURNEY));
		}
		return flag;
	}

	/**
	 * Verify Journey Information of Linked Assignment
	 * 
	 * @param fileID
	 * @param journeyInfo
	 * @return
	 */
	public boolean verifyLinkedAssignmentJourneyInfo(String fileID, String journeyInfo) {
		boolean flag = false;
		try {
			String actualJourneyDetails = CoreFunctions.getAttributeText(_journeyTabInformation.get(
					BusinessFunctions.returnindexItemFromListUsingText(driver, _journeyTabInformation, fileID, true)),
					MYLOConstants.TITLE);
			flag = actualJourneyDetails.replaceAll("\\s", "").equals(journeyInfo.replaceAll("\\s", ""));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.LINKED_ASSIGNMENT_JOURNEY_INFO, MYLOConstants.LINK_MOBILITY_JOURNEY));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VALUE_UPDATED_ON_SECTION, CoreConstants.PASS,
					journeyInfo, MYLOConstants.LINKED_ASSIGNMENT_JOURNEY_INFO, MYLOConstants.LINK_JOURNEY,
					MYLOConstants.JOURNEY));
		return flag;
	}

	/**
	 * Verify File ID of Linked Assignment
	 * 
	 * @param fileID
	 * @return
	 */
	public boolean verifyLinkedAssignmentFileID(String fileID) {
		boolean flag = false;
		try {
			flag = CoreFunctions.searchElementExistsInListByText(driver, _journeyTabInformation, fileID);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.LINKED_ASSIGNMENT_FILE_ID, MYLOConstants.LINK_MOBILITY_JOURNEY));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VALUE_UPDATED_ON_SECTION, CoreConstants.PASS, fileID,
					MYLOConstants.FILE_ID, MYLOConstants.LINK_JOURNEY, MYLOConstants.JOURNEY));
		return flag;
	}

	/**
	 * Verify all Data Integrity Message on Link Mobility Journey Section
	 * 
	 * @return
	 */
	public boolean verifyDataIntegrityAlertMsg() {
		boolean flag = false;
		try {
			List<String> actualTextList = _dataIntegrityAlertMsg.stream()
					.map(i -> CoreFunctions.getElementText(driver, i)).collect(Collectors.toList());
			List<String> expectedTextList = new ArrayList<String>(Arrays.asList(MYLOConstants.LINK_NEW_JOURNEY_MSG,
					MYLOConstants.LINK_EXISTING_JOURNEY_MSG, MYLOConstants.DECISION_FOR_LINKING_MSG));
			flag = actualTextList.equals(expectedTextList);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.DATA_INTEGRITY_MSG, MYLOConstants.LINK_MOBILITY_JOURNEY));
		}
		if (flag) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_MESSAGE_DISPLAYED, CoreConstants.PASS,
					MYLOConstants.LINK_NEW_JOURNEY_MSG, MYLOConstants.LINK_MOBILITY_JOURNEY));
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_MESSAGE_DISPLAYED, CoreConstants.PASS,
					MYLOConstants.LINK_EXISTING_JOURNEY_MSG, MYLOConstants.LINK_MOBILITY_JOURNEY));
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_MESSAGE_DISPLAYED, CoreConstants.PASS,
					MYLOConstants.DECISION_FOR_LINKING_MSG, MYLOConstants.LINK_MOBILITY_JOURNEY));
		}
		return flag;
	}

	/**
	 * Verify All field values displayed on Link Mobility Journey Section
	 * 
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 */
	public boolean verifyAllMatchFieldValuesOnLinkPopUp(String fieldName, String fieldValue) {
		boolean flag = false;
		try {
			List<WebElement> valueList = (fieldName.equals(MYLOConstants.TRANSFEREE_NAME))
					? _linkMobJourneyTransfereeNames
					: _linkMobJourneyEmailNames;
			flag = valueList.stream().allMatch(i -> CoreFunctions.getElementText(driver, i).contains(fieldValue));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.LINK_MOBILITY_JOURNEY));
		}
		return flag;
	}
}
