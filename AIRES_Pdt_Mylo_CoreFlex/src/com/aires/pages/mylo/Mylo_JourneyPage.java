package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.Mylo_JourneyDetails_DEV5;
import com.aires.testdatatypes.mylo.Mylo_JourneyDetails_PREPROD;
import com.aires.testdatatypes.mylo.Mylo_JourneyDetails_QA4;
import com.aires.testdatatypes.mylo.Mylo_JourneyDetails_UAT;
import com.vimalselvam.cucumber.listener.Reporter;

public class Mylo_JourneyPage extends Base {

	public Mylo_JourneyPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "app-authorization-tracking")
	private WebElement _authTrackSection;
	
	@FindBy(how = How.CSS, using = "app-aires-file-information h2")
	private WebElement _fileInformationSection;
	
	@FindBy(how = How.CSS, using = "ng-select[name='office']")
	private WebElement _fileInformationOffice;
	
	@FindBy(how = How.ID, using = "T_Grade")
	private WebElement _transfereeGrade;
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Mailing: ']")
	private WebElement _mailingAddressHeader;
	
	String environment= System.getProperty("envt");
	String application= System.getProperty("application");
	//String environment= CoreFunctions.getPropertyFromConfig("envt");
	//String application= CoreFunctions.getPropertyFromConfig("application");
	List<String> journeyCategory = new ArrayList<String>();
	List<String> journeyDetails = new ArrayList<String>();
	Map<String, String> journeyDetailsMap = new LinkedHashMap<String,String>();
	LinkedHashMap<String, WebElement> journeyWebElementsMap = new LinkedHashMap<String, WebElement>();
	
	public void mapJourneySectionWebElements() {
		journeyWebElementsMap.put(MYLOConstants.AUTH_TRACK_SECTION, _authTrackSection);
		journeyWebElementsMap.put(MYLOConstants.FILE_INFORMATION_SECTION, _fileInformationSection);
		journeyWebElementsMap.put(MYLOConstants.OFFICE, _fileInformationOffice);
		journeyWebElementsMap.put(MYLOConstants.TRANSFEREE_GRADE, _transfereeGrade);
		journeyWebElementsMap.put(MYLOConstants.MAILING_ADDRESS, _mailingAddressHeader);
	}
	
	
	public void scrollToJourneySection(String elementName,String pageName) {
		mapJourneySectionWebElements();
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, journeyWebElementsMap.get(elementName),
					elementName);
			CoreFunctions.highlightObject(driver, journeyWebElementsMap.get(elementName));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, elementName, pageName));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					elementName, pageName));
		}
	}
	
	public String getMyloJourneyDetailsByFileType(String fileType) {
		switch (environment) {
		case MYLOConstants.UAT:
			List<Mylo_JourneyDetails_UAT> myloUATJourneyDetails = FileReaderManager.getInstance().getMyloJsonReader()
					.getMyloJourneyDetailsUAT();
			journeyCategory.addAll(myloUATJourneyDetails.stream().map(x -> x.fileType).collect(Collectors.toList()));
			journeyDetails.addAll(myloUATJourneyDetails.stream().map(x -> x.fileInfo).collect(Collectors.toList()));
			break;
		case MYLOConstants.PREPROD:
			List<Mylo_JourneyDetails_PREPROD> myloPREPRODJourneyDetails = FileReaderManager.getInstance()
					.getMyloJsonReader().getMyloJourneyDetailsPREPROD();
			journeyCategory
					.addAll(myloPREPRODJourneyDetails.stream().map(x -> x.fileType).collect(Collectors.toList()));
			journeyDetails.addAll(myloPREPRODJourneyDetails.stream().map(x -> x.fileInfo).collect(Collectors.toList()));
			break;
		case MYLOConstants.DEV5:
			List<Mylo_JourneyDetails_DEV5> myloDEV5JourneyDetails = FileReaderManager.getInstance().getMyloJsonReader()
					.getMyloJourneyDetailsDEV5();
			journeyCategory.addAll(myloDEV5JourneyDetails.stream().map(x -> x.fileType).collect(Collectors.toList()));
			journeyDetails.addAll(myloDEV5JourneyDetails.stream().map(x -> x.fileInfo).collect(Collectors.toList()));
			break;
		case MYLOConstants.RELONETQA4:
			List<Mylo_JourneyDetails_QA4> myloQA4JourneyDetails = FileReaderManager.getInstance().getMyloJsonReader()
					.getMyloJourneyDetailsQA4();
			journeyCategory.addAll(myloQA4JourneyDetails.stream().map(x -> x.fileType).collect(Collectors.toList()));
			journeyDetails.addAll(myloQA4JourneyDetails.stream().map(x -> x.fileInfo).collect(Collectors.toList()));
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ENVIRONMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ENVIRONMENT_NAME);
		}
		
		journeyDetailsMap = IntStream.range(0, journeyCategory.size()).boxed()
				.collect(Collectors.toMap(journeyCategory::get, journeyDetails::get));
		journeyCategory.clear();
		journeyDetails.clear();
		return journeyDetailsMap.get(fileType);
	}
	
	public String getFileInfoFieldByEnvtAndType(String fileType,String field) {
		String reqString;
		List<String> fileInfoFields = new ArrayList<String>();
		fileInfoFields.add(MYLOConstants.FILE_ID);
		fileInfoFields.add(MYLOConstants.CLIENT_ID);
		fileInfoFields.add(MYLOConstants.CLIENT_NAME);
		fileInfoFields.add(MYLOConstants.STATUS);
		fileInfoFields.add(MYLOConstants.POLICY_TYPE);
		fileInfoFields.add(MYLOConstants.PROVIDER);
		fileInfoFields.add(MYLOConstants.JOURNEY_TYPE);
		fileInfoFields.add(MYLOConstants.OFFICE);
		String fileInfomation = getMyloJourneyDetailsByFileType(fileType);
		reqString=fileInfomation.split(";")[fileInfoFields.indexOf(field)];
		journeyDetailsMap.clear();
		return reqString;
	}

}
