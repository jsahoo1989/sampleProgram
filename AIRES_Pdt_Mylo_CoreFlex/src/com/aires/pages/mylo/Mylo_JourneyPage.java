package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.MyloFileInformationDetails;
import com.vimalselvam.cucumber.listener.Reporter;

public class Mylo_JourneyPage extends Base {

	public Mylo_JourneyPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "app-authorization-tracking")
	private WebElement _authTrackSection;
	
	@FindBy(how = How.CSS, using = "app-expense-taxes")
	private WebElement _taxReportSection;
	
	@FindBy(how = How.CSS, using = "app-aires-file-information h2")
	private WebElement _fileInformationSection;
	
	@FindBy(how = How.CSS, using = "ng-select[name='office']")
	private WebElement _fileInformationOffice;
	
	@FindBy(how = How.ID, using = "T_Grade")
	private WebElement _transfereeGrade;
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Mailing: ']")
	private WebElement _mailingAddressHeader;
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Origin ']")
	private WebElement _originAddressHeader;
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Destination ']")
	private WebElement _destinationAddressHeader;
	
	@FindBy(how = How.CSS, using = "app-team-post h1")
	private WebElement _teamPostsHeader;
	
	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _popUpMessage;
	
	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;
	
	@FindBy(how = How.CSS, using = "h5[class='modal-title']")
	private WebElement _queryPopUpHeader;
	
	String environment= System.getProperty("envt");
	String application= System.getProperty("application");
	//String environment= CoreFunctions.getPropertyFromConfig("envt");
	//String application= CoreFunctions.getPropertyFromConfig("application");
	
	Map<String, String> journeyDetailsMap = new LinkedHashMap<String,String>();
	LinkedHashMap<String, WebElement> journeyWebElementsMap = new LinkedHashMap<String, WebElement>();
	
	/**
	 * Map all sections with its header text
	 */
	public void mapJourneySectionWebElements() {
		journeyWebElementsMap.put(MYLOConstants.AUTH_TRACK_SECTION, _authTrackSection);
		journeyWebElementsMap.put(MYLOConstants.TAX_REPORTING_SECTION, _taxReportSection);
		journeyWebElementsMap.put(MYLOConstants.FILE_INFORMATION_SECTION, _fileInformationSection);
		journeyWebElementsMap.put(MYLOConstants.OFFICE, _fileInformationOffice);
		journeyWebElementsMap.put(MYLOConstants.TRANSFEREE_GRADE, _transfereeGrade);
		journeyWebElementsMap.put(MYLOConstants.MAILING_ADDRESS, _mailingAddressHeader);
		journeyWebElementsMap.put(MYLOConstants.ORIGIN_ADDRESS, _originAddressHeader);
		journeyWebElementsMap.put(MYLOConstants.DESTINATION_ADDRESS, _destinationAddressHeader);
		journeyWebElementsMap.put(MYLOConstants.TEAM_POSTS, _teamPostsHeader);
		journeyWebElementsMap.put(MYLOConstants.MY_FILES, _queryPopUpHeader);
		journeyWebElementsMap.put(MYLOConstants.MY_FILES_QUERY_RESULT, _queryPopUpHeader);
		journeyWebElementsMap.put(MYLOConstants.QUERY_POPUP, _queryPopUpHeader);
		journeyWebElementsMap.put(MYLOConstants.ACCOUNTING, _queryPopUpHeader);
	}
	
	
	/**
	 * Scroll to the element passed as a parameter on Journey page
	 * @param sectionName
	 * @param pageName
	 */
	public void scrollToJourneySection(String sectionName,String pageName) {
		mapJourneySectionWebElements();
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, journeyWebElementsMap.get(sectionName),
					sectionName);
			CoreFunctions.highlightObject(driver, journeyWebElementsMap.get(sectionName));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					sectionName, pageName));
		}
	}
	
	/**
	 * Verify section header text of elements passed as a parameter on Journey Page
	 * @param sectionName
	 * @param headerName
	 * @return
	 */
	public boolean verifySectionHeader(String sectionName, String headerName) {
		mapJourneySectionWebElements();
		boolean flag = false;
		try {
			flag = CoreFunctions.getElementText(driver, journeyWebElementsMap.get(sectionName)).equals(headerName);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					sectionName, MYLOConstants.JOURNEY));
		}
		if (flag)
			Reporter.addStepLog(
					MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_DISPLAYED, CoreConstants.PASS, headerName,sectionName));
		else
			Reporter.addStepLog(
					MessageFormat.format(MYLOConstants.INCORRECT_HEADER_TEXT, CoreConstants.FAIL, headerName,
							CoreFunctions.getElementText(driver, journeyWebElementsMap.get(sectionName)), sectionName));

		return flag;
	}
	
	
	/**
	 * Getting the required File Info from Json based on the parameters passed
	 * @param fileType
	 * @return
	 */
	public String getFileInfo(String fileType, String fieldName) {
		MyloFileInformationDetails myloFileDetails = FileReaderManager.getInstance().getMyloJsonReader()
				.getFileInformationDetails(environment);
		List<String> journeyCategory = (myloFileDetails.journeyDetails.stream().map(x -> x.fileType)
				.collect(Collectors.toList()));
		String reqString = (fieldName.equals(MYLOConstants.FILE_ID))
				? myloFileDetails.journeyDetails.get(journeyCategory.indexOf(fileType)).fileId
				: (fieldName.equals(MYLOConstants.CLIENT_ID))
						? myloFileDetails.journeyDetails.get(journeyCategory.indexOf(fileType)).clientId
						: (fieldName.equals(MYLOConstants.CLIENT_NAME))
								? myloFileDetails.journeyDetails.get(journeyCategory.indexOf(fileType)).clientName
								: myloFileDetails.journeyDetails.get(journeyCategory.indexOf(fileType)).policyType;
		return reqString;
	}
	
	/**
	 * Verify Mylo PopUp Message
	 * @param msg
	 * @return
	 */
	public boolean verifyPopUpMessage(String msg) {
		return BusinessFunctions.verifyMyloPopUpMessage(driver, _popUpMessage, msg, MYLOConstants.JOURNEY);
	}
	
	/**
	 * Verify Mylo Toast Message
	 * @param msg
	 * @return
	 */
	public boolean verifyToastMessage(String msg) {
		return BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, msg, MYLOConstants.JOURNEY);
	}

}
