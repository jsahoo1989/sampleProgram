package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	@FindBy(how = How.CSS, using = "app-aires-file-teams")
	private WebElement _fileTeam;

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

	@FindBy(how = How.CSS, using = "h4 b")
	private WebElement _fileId;

	@FindBy(how = How.CSS, using = "#M_number")
	private WebElement _trackNo;

	@FindBy(how = How.CSS, using = "app-transferee div[class$='usertitle']")
	private WebElement _tName;

	@FindBy(how = How.CSS, using = "button[aria-controls='collapseoriginAddress']")
	private WebElement _orgDetailsBtn;

	@FindBy(how = How.CSS, using = "#originAddress ng-select[name='country'] span[class='ng-value-label']")
	private WebElement _orgCountry;

	@FindBy(how = How.CSS, using = "#originAddress input[name='address1']")
	private WebElement _orgAddress1;

	@FindBy(how = How.CSS, using = "#originAddress input[name='address2']")
	private WebElement _orgAddress2;

	@FindBy(how = How.CSS, using = "#originAddress input[name='city']")
	private WebElement _orgCity;

	@FindBy(how = How.CSS, using = "#originAddress input[name='zipCode']")
	private WebElement _orgZipCode;

	@FindBy(how = How.CSS, using = "#originAddress ng-select[name='state'] span[class='ng-value-label']")
	private WebElement _orgState;

	@FindBy(how = How.CSS, using = "button[aria-controls='collapsedestinationAddress']")
	private WebElement _destDetailsBtn;

	@FindBy(how = How.CSS, using = "#destinationAddress ng-select[name='country'] span[class='ng-value-label']")
	private WebElement _destCountry;

	@FindBy(how = How.CSS, using = "#destinationAddress input[name='address1']")
	private WebElement _destAddress1;

	@FindBy(how = How.CSS, using = "#destinationAddress input[name='address2']")
	private WebElement _destAddress2;

	@FindBy(how = How.CSS, using = "#destinationAddress input[name='city']")
	private WebElement _destCity;

	@FindBy(how = How.CSS, using = "#destinationAddress input[name='zipCode']")
	private WebElement _destZipCode;

	@FindBy(how = How.CSS, using = "#destinationAddress ng-select[name='state'] span[class='ng-value-label']")
	private WebElement _destState;

	@FindBy(how = How.CSS, using = "ul[class='mylo-grid-header'] li")
	private List<WebElement> _queryResultColHeader;

	@FindBy(how = How.CSS, using = "div[class='mylo-grid']  i[class*='icon-Caret']")
	private List<WebElement> _columnCaretBtn;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	private String environment= System.getProperty("envt");
	//private String environment = CoreFunctions.getPropertyFromConfig("envt");
	private LinkedHashMap<String, WebElement> journeyWebElementsMap = new LinkedHashMap<String, WebElement>();

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
		journeyWebElementsMap.put(MYLOConstants.ADVANCED, _queryPopUpHeader);
		journeyWebElementsMap.put(MYLOConstants.TRANSFEREE_NAME, _queryPopUpHeader);
		journeyWebElementsMap.put(MYLOConstants.AIRES_FILE_TEAM, _fileTeam);
		journeyWebElementsMap.put(MYLOConstants.SUB_SERVICE_ID, _queryPopUpHeader);
	}

	/**
	 * Scroll to the element passed as a parameter on Journey page
	 * 
	 * @param sectionName
	 * @param pageName
	 */
	public void scrollToJourneySection(String sectionName, String pageName) {
		mapJourneySectionWebElements();
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, journeyWebElementsMap.get(sectionName), sectionName);
			CoreFunctions.highlightObject(driver, journeyWebElementsMap.get(sectionName));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					sectionName, pageName));
		}
	}

	/**
	 * Verify section header text of elements passed as a parameter on Journey Page
	 * 
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
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_HEADER_TEXT_DISPLAYED, CoreConstants.PASS,
					headerName, sectionName));
		else
			Reporter.addStepLog(
					MessageFormat.format(MYLOConstants.INCORRECT_HEADER_TEXT, CoreConstants.FAIL, headerName,
							CoreFunctions.getElementText(driver, journeyWebElementsMap.get(sectionName)), sectionName));

		return flag;
	}

	/**
	 * Getting the required File Info from Json based on the parameters passed
	 * 
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
	 * 
	 * @param msg
	 * @return
	 */
	public boolean verifyPopUpMessage(String msg) {
		return BusinessFunctions.verifyMyloPopUpMessage(driver, _popUpMessage, msg, MYLOConstants.JOURNEY);
	}

	/**
	 * Verify Mylo Toast Message
	 * 
	 * @param msg
	 * @return
	 */
	public boolean verifyToastMessage(String msg) {
		return BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, msg, MYLOConstants.JOURNEY);
	}

	public Map<String, String> getJourneyPageFieldValues(String fieldName) {
		Map<String, String> requiredValuesMap = new LinkedHashMap<String, String>();
		switch (fieldName) {
		case MYLOConstants.ASSIGNMENT_ID:
			requiredValuesMap.put(fieldName, CoreFunctions.getElementText(driver, _fileId));
			break;
		case MYLOConstants.TRANSFEREE_NAME:
			requiredValuesMap.put(fieldName, CoreFunctions.getElementText(driver, _tName));
			break;
		case MYLOConstants.TRACKING_NUMBER:
			CoreFunctions.scrollToElementUsingJavaScript(driver, _authTrackSection, MYLOConstants.AUTH_TRACK_SECTION);
			requiredValuesMap.put(fieldName, CoreFunctions.getAttributeText(_trackNo, MYLOConstants.VALUE));
			break;
		case MYLOConstants.ORIGIN_ADDRESS:
			requiredValuesMap = getOriginAddressDetails();
			break;
		case MYLOConstants.DESTINATION_ADDRESS:
			requiredValuesMap = getDestAddressDetails();
			break;
		}
		return requiredValuesMap;
	}

	private Map<String, String> getDestAddressDetails() {
		Map<String, String> destAddressDetails = new LinkedHashMap<String, String>();
		CoreFunctions.scrollClickUsingJS(driver, _destDetailsBtn, MYLOConstants.DESTINATION_ADDRESS_DETAILS_BUTTON);
		destAddressDetails.put(MYLOConstants.DESTINATION_COUNTRY, CoreFunctions.getElementText(driver, _destCountry));
		destAddressDetails.put(MYLOConstants.DESTINATION_STATE, CoreFunctions.getElementText(driver, _destState));
		destAddressDetails.put(MYLOConstants.DESTINATION_CITY,
				CoreFunctions.getAttributeText(_destCity, MYLOConstants.VALUE));
		destAddressDetails.put(MYLOConstants.DESTINATION_ADDRESS1,
				CoreFunctions.getAttributeText(_destAddress1, MYLOConstants.VALUE));
		destAddressDetails.put(MYLOConstants.DESTINATION_ADDRESS2,
				CoreFunctions.getAttributeText(_destAddress2, MYLOConstants.VALUE));
		destAddressDetails.put(MYLOConstants.DESTINATION_ZIPCODE,
				CoreFunctions.getAttributeText(_destZipCode, MYLOConstants.VALUE));
		return destAddressDetails;
	}

	private Map<String, String> getOriginAddressDetails() {
		Map<String, String> orgAddressDetails = new LinkedHashMap<String, String>();
		CoreFunctions.scrollClickUsingJS(driver, _orgDetailsBtn, MYLOConstants.ORIGIN_ADDRESS_DETAILS_BUTTON);
		orgAddressDetails.put(MYLOConstants.ORIGIN_COUNTRY, CoreFunctions.getElementText(driver, _orgCountry));
		orgAddressDetails.put(MYLOConstants.ORIGIN_STATE, CoreFunctions.getElementText(driver, _orgState));
		orgAddressDetails.put(MYLOConstants.ORIGIN_CITY, CoreFunctions.getAttributeText(_orgCity, MYLOConstants.VALUE));
		orgAddressDetails.put(MYLOConstants.ORIGIN_ADDRESS1,
				CoreFunctions.getAttributeText(_orgAddress1, MYLOConstants.VALUE));
		orgAddressDetails.put(MYLOConstants.ORIGIN_ADDRESS2,
				CoreFunctions.getAttributeText(_orgAddress2, MYLOConstants.VALUE));
		orgAddressDetails.put(MYLOConstants.ORIGIN_ZIPCODE,
				CoreFunctions.getAttributeText(_orgZipCode, MYLOConstants.VALUE));
		return orgAddressDetails;
	}

	public String clickColumnCaretButtonOnResultsModal(String colName) {
		String sortColName = "";
		try {
			List<String> valuesToIgnore = Stream.of(MYLOConstants.TRANSFEREE_NAME, MYLOConstants.FILE_ID)
					.collect(Collectors.toList());
			String colHeader = (colName.equals(MYLOConstants.RANDOM))
					? CoreFunctions.getRandomOutOfSelectedElementValueFromList(driver, _queryResultColHeader,
							valuesToIgnore)
					: colName;
			int index= (colName.equals(MYLOConstants.RANDOM))?colHeader.indexOf(colHeader) + 1:colHeader.indexOf(colHeader);
			sortColName = CoreFunctions.getElementText(driver,
					_queryResultColHeader.get(index));
			CoreFunctions.click(driver, _columnCaretBtn.get(index), sortColName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, colName));
		}
		return sortColName;
	}

}
