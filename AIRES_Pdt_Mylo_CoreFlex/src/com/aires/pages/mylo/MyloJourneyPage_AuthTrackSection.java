package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
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
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;

public class MyloJourneyPage_AuthTrackSection extends Base {

	public MyloJourneyPage_AuthTrackSection(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.XPATH, using = "//app-authorization-tracking/descendant::i[@class='icon-PlusCircle_Open']/parent::button")
	private WebElement _authTrackAddBtn;

	@FindBy(how = How.XPATH, using = "//app-authorization-tracking/descendant::i[@class='icon-Pencil_Open']/parent::button")
	private WebElement _authTrackEditBtn;

	@FindBy(how = How.ID, using = "M_comment")
	private List<WebElement> _authTrackComments;

	@FindBy(how = How.CSS, using = "ng-select[name='type']")
	private List<WebElement> _authTrackTypes;
	
	@FindBy(how = How.CSS, using = "ng-select[name='type'] span[class='ng-value-label']")
	private List<WebElement> _authTrackTypeDropdownValues;

	@FindBy(how = How.XPATH, using = "//button[text()='History']")
	private List<WebElement> _authTrackHistoryNumbers;

	@FindBy(how = How.XPATH, using = "//app-authorization-tracking/descendant::i[@class='icon-FloppyDisk_Open']/parent::button")
	private WebElement _authTrackSaveBtn;

	@FindBy(how = How.CSS, using = "input[id='M_number']")
	private List<WebElement> _authTrackNumbers;
	
	@FindBy(how = How.CSS, using = "i[class='icon-Trash_Open']")
	private List<WebElement> _authTrackDeleteIcon;

	@FindBy(how = How.CSS, using = "div[class='mylo-popup']")
	private WebElement _myloPopUp;

	@FindBy(how = How.CSS, using = "app-authorization-popup h5")
	private WebElement _authTrackHistoryHeader;

	@FindBy(how = How.ID, using = "number")
	private WebElement _authTrackCurrentNumber;

	@FindBy(how = How.CSS, using = "table th")
	private List<WebElement> _authTrackHistoryTableHeaders;
	
	@FindBy(how = How.CSS, using = "label[for*='M_']")
	private List<WebElement> _authTrackFieldLabels;
	
	@FindBy(how = How.CSS, using = "div[role='alert']")
	private List<WebElement> _alertMessages;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement _YesButton;
	
	@FindBy(how = How.CSS, using = "ng-select[name='sort-type']")
	private WebElement _sortBy;
	
	@FindBy(how = How.CSS, using = "app-authorization-tracking a")
	private WebElement _noAuthTrackLink;
	
	@FindBy(how = How.CSS, using = "app-authorization-tracking")
	private WebElement _authTrackSection;
	
	private final By _dropdownOptions = By.cssSelector("div[role='option']>span");
	
	LinkedHashMap<String, WebElement> authTrackWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> authTrackUpdatedFieldValuesMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> authTrackFieldsCharacterLimitMap = new LinkedHashMap<String, String>();


	public void mapAuthTrackWebElements(int index) {
		authTrackWebElementsMap.put(MYLOConstants.AUTH_TRACK_TYPE, _authTrackTypes.get(index));
		authTrackWebElementsMap.put(MYLOConstants.AUTH_TRACK_NUMBER, _authTrackNumbers.get(index));
		authTrackWebElementsMap.put(MYLOConstants.AUTH_TRACK_COMMENT, _authTrackComments.get(index));
		authTrackWebElementsMap.put(MYLOConstants.HISTORY, _authTrackHistoryNumbers.get(index));
		authTrackWebElementsMap.put(MYLOConstants.ADD_BUTTON, _authTrackAddBtn);
		authTrackWebElementsMap.put(MYLOConstants.EDIT_BUTTON, _authTrackEditBtn);
		authTrackWebElementsMap.put(MYLOConstants.SAVE_BUTTON, _authTrackSaveBtn);
		authTrackWebElementsMap.put(MYLOConstants.YES_BUTTON, _YesButton);
		authTrackWebElementsMap.put(MYLOConstants.SORT_BY, _sortBy);
	}
	
	public void deleteAuthTrackaData(int index) {
		try {
			CoreFunctions.highlightElementAndClick(driver, _authTrackDeleteIcon.get(index), MYLOConstants.DELETE_BUTTON);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, MYLOConstants.DELETE_BUTTON, MYLOConstants.AUTH_TRACK_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.DELETE_BUTTON, MYLOConstants.AUTH_TRACK_SECTION));
		}
	}
	
	public boolean verifyNoAuthTrackFileLink() {
		boolean flag= CoreFunctions.isElementVisible(_noAuthTrackLink);
		return flag;
	}
	
	public void clickOnNoAuthTrackLink() {
		try {
			CoreFunctions.highlightElementAndClick(driver, _noAuthTrackLink, MYLOConstants.NO_AUTHTRACK_FILE);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, MYLOConstants.NO_AUTHTRACK_FILE, MYLOConstants.AUTH_TRACK_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.NO_AUTHTRACK_FILE, MYLOConstants.AUTH_TRACK_SECTION));
		}
	}

	public void authTrackButtonEnabilityStatus(String type, String btnName) {
		mapAuthTrackWebElements(0);
		BusinessFunctions.verifyMyloButtonEnabilityStatus(type, authTrackWebElementsMap.get(btnName), btnName,
				MYLOConstants.AUTH_TRACK_SECTION, MYLOConstants.JOURNEY);
	}

	public String getHoverCommentText(int index) {
		String requiredText = "";
		try {
			requiredText = CoreFunctions.getAttributeText(_authTrackComments.get(index), MYLOConstants.TITLE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, MYLOConstants.COMMENTS, MYLOConstants.AUTH_TRACK_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.COMMENTS, MYLOConstants.AUTH_TRACK_SECTION));
		}
		return requiredText;
	}

	public void verifyMyloAuthTrackHistorySectionPopUp(String userType, DataTable table) {
		if (userType.contains(MYLOConstants.WITHOUT)) {
			Assert.assertFalse(CoreFunctions.isElementExist(driver, _myloPopUp, 5),
					MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.FAIL,
							MYLOConstants.AUTH_TRACK_SECTION, MYLOConstants.JOURNEY));
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_NOT_ON_PAGE, CoreConstants.PASS,
					MYLOConstants.AUTH_TRACK_SECTION, MYLOConstants.JOURNEY));
		} else {
			Assert.assertTrue(CoreFunctions.isElementExist(driver, _myloPopUp, 5),
					MessageFormat.format(MYLOConstants.VRFIED_POPUP_NOT_ON_PAGE, CoreConstants.FAIL,
							MYLOConstants.AUTH_TRACK_SECTION, MYLOConstants.JOURNEY));
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VRFIED_POPUP_DISPLAYED_ON_PAGE, CoreConstants.PASS,
					MYLOConstants.AUTH_TRACK_SECTION, MYLOConstants.JOURNEY));
			Assert.assertTrue(verifyFieldsAvailableOnAuthTrackHistoryPopup(table));
		}
	}

	public boolean verifyFieldsAvailableOnAuthTrackHistoryPopup(DataTable table) {
		CoreFunctions.getElementText(driver, _authTrackHistoryHeader);
		boolean flag = true;
		java.util.List<List<String>> data = table.asLists(String.class);
		for (int i = 0; i < data.get(0).size(); i++) {
			try {
				if (!(data.get(0).get(i)
						.equals(CoreFunctions.getElementText(driver, _authTrackHistoryTableHeaders.get(i)))))
					flag = false;
			} catch (Exception e) {
				Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						data.get(0).get(i) + MYLOConstants.HEADER, MYLOConstants.AUTH_TRACK_HISTORY));
			}
		}
		return flag;
	}

	public void clickFieldsOnAuthTrackSection(String fieldName, int index) {
		mapAuthTrackWebElements(index);
		try {
			WebElement element = authTrackWebElementsMap.get(fieldName);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.AUTH_TRACK_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.AUTH_TRACK_SECTION));
		}
	}
	
	public boolean verifyFieldsAvailableOnAuthTrackSection(DataTable table) {
		boolean flag = true;
		java.util.List<List<String>> data = table.asLists(String.class);
		for (int i = 0; i < 4; i++) {
			try {
				if (!(data.get(0).get(i)
						.equals(CoreFunctions.getElementText(driver, _authTrackFieldLabels.get(i)))))
					flag = false;
			} catch (Exception e) {
				Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						data.get(0).get(i)+ MYLOConstants.FIELD_NAME, MYLOConstants.AUTH_TRACK_SECTION));
			}
		}
		return flag;
	}
	
	public void addAuthTrackDataIfNotPresent() {
		if (MyloNewFileUtil.get_trackingNumber() == null) {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.scrollToElementUsingJS(driver, _authTrackSection, MYLOConstants.AUTH_TRACK_SECTION);
			CoreFunctions.highlightObject(driver, _authTrackSection);
			CoreFunctions.highlightElementAndClick(driver, _authTrackAddBtn, MYLOConstants.ADD_BUTTON);
			clickFieldsOnAuthTrackSection(MYLOConstants.AUTH_TRACK_TYPE, 0);
			setTypeDropDownField(MYLOConstants.AUTH_TRACK_TYPE, MYLOConstants.RANDOM, 0);
			String trackingNumber=BusinessFunctions.setMyloInputFields(driver, MYLOConstants.AUTH_TRACK_NUMBER, "10",
					_authTrackNumbers.get(0), MYLOConstants.RANDOM_INTEGER);
			setAuthTrackFields(MYLOConstants.AUTH_TRACK_COMMENT, "10", 0);
			clickFieldsOnAuthTrackSection(MYLOConstants.SAVE_BUTTON, 0);
			MyloNewFileUtil.set_trackingNumber(trackingNumber);
		}
	}
	
	public void setAuthTrackFields(String fieldName, String fieldValue,int index) {
		mapAuthTrackWebElements(index);
		try {
			WebElement reqWebElement = authTrackWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			String setValue = CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
			authTrackUpdatedFieldValuesMap.put(fieldName, setValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.AUTH_TRACK_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.AUTH_TRACK_SECTION));
		}
	}
	
	public void setTypeDropDownField(String fieldName, String fieldValue,int index) {
		String updatedValue = null;
		mapAuthTrackWebElements(index);
		try {
			List<WebElement> optionList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			updatedValue = CoreFunctions.setDifferentDropDownFieldsForMylo(driver, fieldValue, optionList);
			authTrackUpdatedFieldValuesMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.AUTH_TRACK_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.AUTH_TRACK_SECTION));
		}
	}
	
	public String getAuthTrackFieldValue(String fieldName,int index) {
		mapAuthTrackWebElements(index);
		String requiredValue = null;
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, authTrackWebElementsMap.get(fieldName), fieldName);
			requiredValue = CoreFunctions.getAttributeText(authTrackWebElementsMap.get(fieldName),
							MYLOConstants.VALUE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.AUTH_TRACK_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.AUTH_TRACK_SECTION));
		}
		return requiredValue;
	}
	
	public void mapAuthTrackFieldsCharacterLimitMap() {
		authTrackFieldsCharacterLimitMap.put(MYLOConstants.AUTH_TRACK_NUMBER,
				MYLOConstants.AUTHTRACK_NUMBER_CHAR_LIMIT);
		authTrackFieldsCharacterLimitMap.put(MYLOConstants.AUTH_TRACK_COMMENT,
				MYLOConstants.AUTHTRACK_COMMENT_CHAR_LIMIT);
	}
	
	public void verifyDifferentAuthTrackFieldsUpdatedValue(DataTable table, int index) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			Assert.assertTrue((verifyAuthTrackFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), index)),MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
					MYLOConstants.AUTH_TRACK_SECTION));
		}
	}
	
	public boolean verifyAuthTrackFieldsUpdatedValue(String fieldName,int index) {
		boolean flag = false;
		mapAuthTrackFieldsCharacterLimitMap();
		String updatedValue = null;
		try {
			updatedValue = authTrackUpdatedFieldValuesMap.get(fieldName);
			int fieldCharLimit = Integer.parseInt(authTrackFieldsCharacterLimitMap.get(fieldName));
			updatedValue = updatedValue.length() > fieldCharLimit ? updatedValue.substring(0, fieldCharLimit)
					: updatedValue;
			flag = getAuthTrackFieldValue(fieldName, index).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.AUTH_TRACK_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.AUTH_TRACK_SECTION));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.AUTH_TRACK_SECTION));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.AUTH_TRACK_SECTION));
		return flag;
	}
	
	public boolean verifyToastMessage(String msg,int index) {
		boolean flag = false;
		flag = (BusinessFunctions.verifyMyloToastMessage(driver, _alertMessages.get(index), msg, MYLOConstants.AUTH_TRACK_SECTION));
		return flag;
	}
	
	public void verifyAuthTrackFieldSortingOrder(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String order = data.get(i).get(MYLOConstants.SORTING_ORDER);
			setSortingOrder(fieldName, order);
			boolean flag = (fieldName.equals(MYLOConstants.AUTH_TRACK_TYPE))
					? verifyAuthTrackTypeSortingOrder(fieldName, order)
					: verifyAuthTrackNumberSortingOrder(fieldName, order);
			Assert.assertTrue(flag,MessageFormat.format(MYLOConstants.VERIFIED_FIELDS_NOT_SORTED, CoreConstants.FAIL,
					MYLOConstants.AUTH_TRACK_SECTION,fieldName, order));
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_FIELDS_SORTED, CoreConstants.PASS,
					MYLOConstants.AUTH_TRACK_SECTION,fieldName, order));
		}
	}
	
	public void setSortingOrder(String fieldName, String order) {
		selectSortByAndOrder(fieldName);
		selectSortByAndOrder(order);
		
	}
	
	public void selectSortByAndOrder(String selectDropdown) {
		List<WebElement> optionList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		if (optionList==null) {
			clickFieldsOnAuthTrackSection(MYLOConstants.SORT_BY, 0);
			optionList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		}
		CoreFunctions.setDifferentDropDownFieldsForMylo(driver, selectDropdown, optionList);
	}
	
	public boolean verifyAuthTrackTypeSortingOrder(String fieldName, String order) {
		List<String> listTypeValues = _authTrackTypeDropdownValues.stream().map(x -> x.getText())
				.collect(Collectors.toList());
		List<String> copyTypeValues = new ArrayList<String>(listTypeValues);
		if (order.equals(MYLOConstants.ASCENDING))
			Collections.sort(copyTypeValues);
		else
			Collections.sort(copyTypeValues, Collections.reverseOrder());
		boolean flag = (listTypeValues.equals(copyTypeValues));
		return flag;
	}
	
	public boolean verifyAuthTrackNumberSortingOrder(String fieldName, String order) {
		List<Integer> listNumberValues = _authTrackNumbers.stream().map(x ->Integer.parseInt(x.getAttribute(MYLOConstants.VALUE)))
				.collect(Collectors.toList());
		List<Integer> copyNumberValues = new ArrayList<Integer>(listNumberValues);
		if (order.equals(MYLOConstants.ASCENDING))
			Collections.sort(copyNumberValues);
		else
			Collections.sort(copyNumberValues, Collections.reverseOrder());
		boolean flag = (listNumberValues.equals(copyNumberValues));
		return flag;
	}

}
