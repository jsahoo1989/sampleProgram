package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
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

public class MyloJourneyPage_TeamPostSection extends Base {

	public MyloJourneyPage_TeamPostSection(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "button[class*='team-post-btn']")
	private List<WebElement> _teamPostFilterSectionHeaders;

	@FindBy(how = How.CSS, using = "i[class='icon-ArrowsOut_Open']")
	private WebElement _teamPostExpandIcon;

	@FindBy(how = How.CSS, using = "app-team-post-view div[class='title']")
	private List<WebElement> _teamPostUpdatedUsers;

	@FindBy(how = How.CSS, using = "app-team-post-view p[class='subtitle']")
	private List<WebElement> _teamPostComments;
	
	@FindBy(how = How.CSS, using = "app-team-post-view p[class='subtitle'] mark")
	private WebElement _teamPostCommentsMarked;

	@FindBy(how = How.CSS, using = "mat-dialog-container p[class='subtitle']")
	private List<WebElement> _teamPostExpandSectionComments;
	
	@FindBy(how = How.CSS, using = "mat-dialog-container p[class='subtitle'] mark")
	private WebElement _teamPostExpandSectionCommentsMarked;

	@FindBy(how = How.CSS, using = "mat-dialog-container")
	private WebElement _teamPostExpandPopUp;

	@FindBy(how = How.CSS, using = "app-team-post-view label")
	private List<WebElement> _teamPostRadioBtns;

	@FindBy(how = How.CSS, using = "app-team-post-view button")
	private WebElement _teamPostEditButton;
	
	@FindBy(how = How.CSS, using = "i[class*='icon-Sort']")
	private WebElement _teamPostSortBtn;

	@FindBy(how = How.CSS, using = "app-team-post-view div[class*='post ']")
	private List<WebElement> _savedTeamPosts;

	@FindBy(how = How.CSS, using = "div[class='post-modal ng-star-inserted']>div")
	private List<WebElement> _savedTeamPostsExpandedSection;

	@FindBy(how = How.XPATH, using = "//app-team-post-footer//i[@class='icon-PlusCircle_Open']/parent::button")
	private WebElement _teamPostsAddIcon;

	@FindBy(how = How.CSS, using = "button[class*='add-post-btn mr']")
	private WebElement _teamPostsSaveBtn;

	@FindBy(how = How.XPATH, using = "//app-team-post-footer//i[@class='icon-Archive_Open']/parent::button")
	private WebElement _teamPostsArchiveBtn;

	@FindBy(how = How.XPATH, using = "//app-team-post-footer//i[@class='icon-Eye_Open']/parent::button")
	private WebElement _teamPostsViewArchiveBtn;

	@FindBy(how = How.CSS, using = "app-team-post-footer input[type='search']")
	private WebElement _teamPostsSearchBox;

	@FindBy(how = How.CSS, using = "textarea[formcontrolname='teamPostComment']")
	private WebElement _teamPostCommentSection;

	@FindBy(how = How.CSS, using = "app-team-post-add-edit button")
	private List<WebElement> _teamPostTypeSelection;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;
	
	@FindBy(how = How.CSS, using = "app-team-post-view span")
	private List<WebElement> _teamPostDates;
	
	@FindBy(how = How.CSS, using = "div[class='post-modal ng-star-inserted'] span")
	private List<WebElement> _teamPostExpandedSectionDates;

	final By _teamPostEditBtn = By.xpath(".//button");

	LinkedHashMap<String, WebElement> teamPostWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, List<WebElement>> teamPostListWebElementsMap = new LinkedHashMap<String, List<WebElement>>();
	LinkedHashMap<String, String> teamPostTyeHexCodeMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> teamPostUpdatedValuesMap = new LinkedHashMap<String, String>();
	String updatedCommentsValue = "", searchedText="", updatedPostTypeValue="";

	/**
	 * Map all the Team Post buttons with there respective locators
	 */
	public void mapTeamPostSectionWebElements() {
		teamPostWebElementsMap.put(MYLOConstants.EXPAND_ICON, _teamPostExpandIcon);
		teamPostWebElementsMap.put(MYLOConstants.ADD_ICON, _teamPostsAddIcon);
		teamPostWebElementsMap.put(MYLOConstants.SAVE_BUTTON, _teamPostsSaveBtn);
		teamPostWebElementsMap.put(MYLOConstants.ARCHIVE_ICON, _teamPostsArchiveBtn);
		teamPostWebElementsMap.put(MYLOConstants.VIEW_ARCHIVE, _teamPostsViewArchiveBtn);
		teamPostWebElementsMap.put(MYLOConstants.EDIT_BUTTON, _teamPostEditButton);
		teamPostWebElementsMap.put(MYLOConstants.SORT, _teamPostSortBtn);
		
	}

	/**
	 * Map all the Team Post Type with there respective Color HexCodes
	 */
	public void mapTeamPostTypeHexCodes() {
		teamPostTyeHexCodeMap.put(MYLOConstants.GENERAL, MYLOConstants.GENERAL_POST_TYPE_HEXCODE);
		teamPostTyeHexCodeMap.put(MYLOConstants.OPERATIONS, MYLOConstants.OPERATIONS_POST_TYPE_HEXCODE);
		teamPostTyeHexCodeMap.put(MYLOConstants.EXPENSE, MYLOConstants.EXPENSE_POST_TYPE_HEXCODE);
		teamPostTyeHexCodeMap.put(MYLOConstants.RATES, MYLOConstants.RATES_POST_TYPE_HEXCODE);
	}

	/**
	 * Map all the Team Post WebElement List with there respective locators
	 */
	public void mapTeamPostSectionWebElementsList() {
		teamPostListWebElementsMap.put(MYLOConstants.TEAM_POSTS, _savedTeamPosts);
		teamPostListWebElementsMap.put(MYLOConstants.TEAM_POST_EXPANDED, _savedTeamPostsExpandedSection);
		teamPostListWebElementsMap.put(MYLOConstants.VIEW_ARCHIVE, _savedTeamPosts);
		teamPostListWebElementsMap.put(MYLOConstants.TEAM_POSTS_DATES, _teamPostDates);
		teamPostListWebElementsMap.put(MYLOConstants.TEAM_POST_EXPANDED_DATES, _teamPostExpandedSectionDates);
	}

	/**
	 * Click on any Button available on the Team Post section based on the
	 * buttonName passed as parameter
	 * 
	 * @param fieldName
	 */
	public void clickButtonsOnTeamPostSection(String fieldName) {
		mapTeamPostSectionWebElements();
		try {
			WebElement element = teamPostWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TEAM_POSTS));
		}
	}

	/**
	 * Set Comments on Team Post section
	 * 
	 * @param fieldValue
	 * @param type
	 */
	public void setTeamPostCommentField(String fieldValue, String type) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _teamPostCommentSection, MYLOConstants.TEAM_POST_COMMENTS);
		updatedCommentsValue = BusinessFunctions.setMyloInputFields(driver, MYLOConstants.TEAM_POST_COMMENTS,
				fieldValue, _teamPostCommentSection, type);
		CoreFunctions.click(driver, _teamPostCommentSection, MYLOConstants.TEAM_POST_COMMENTS);
	}

	/**
	 * Select Post Type on Team Post section
	 * 
	 * @param fieldValue
	 */
	public void selectTeamPostTypeField(String fieldValue) {
		try {
			updatedPostTypeValue = (fieldValue.equals(MYLOConstants.RANDOM))
					? _teamPostTypeSelection.get(CoreFunctions.getRandomNumber(0, _teamPostTypeSelection.size()))
							.getText()
					: fieldValue;
			CoreFunctions.clickItemInListByText(driver, _teamPostTypeSelection, updatedPostTypeValue);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			teamPostUpdatedValuesMap.put(updatedPostTypeValue, updatedCommentsValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldValue, MYLOConstants.TEAM_POSTS));
		}
	}

	/**
	 * Select Team Post based on the Post Type passed as parameter
	 * 
	 * @param postType
	 */
	public void selectTeamPost(String postType) {
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _teamPostComments,
					teamPostUpdatedValuesMap.get(postType));
			CoreFunctions.click(driver, _teamPostRadioBtns.get(index), postType);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.TEAM_POST_RADIO_BUTTONS, MYLOConstants.TEAM_POSTS));
		}
	}

	
	/**
	 * Verify Post successfully displayed on Mylo Journey Page under TeamPost &
	 * Expanded section of TeamPost based on the sectionName passed as parameter
	 * 
	 * @param postType
	 * @param sectionName
	 * @return
	 */
	public boolean verifyTeamPostDisplayed(String postType, String sectionName) {
		boolean flag = false;
		mapTeamPostSectionWebElementsList();
		List<WebElement> _teamPostComment = (sectionName.equals(MYLOConstants.TEAM_POST_EXPANDED))
				? _teamPostExpandSectionComments
				: _teamPostComments;
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _teamPostComment,
					teamPostUpdatedValuesMap.get(postType));
			CoreFunctions.highlightObject(driver, teamPostListWebElementsMap.get(sectionName).get(index));
			flag = CoreFunctions
					.getAttributeText(teamPostListWebElementsMap.get(sectionName).get(index), MYLOConstants.CLASS)
					.contains(postType.toLowerCase());
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					postType, sectionName));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_SECTION_DISPLAYED, CoreConstants.PASS,
					postType + MYLOConstants.SPACE + MYLOConstants.TEAM_POST_TYPE, sectionName));
		return flag;
	}

	/**
	 * Verify Team Post Background Color displayed on Mylo Journey Page under
	 * TeamPost & Expanded section of TeamPost based on the postType & sectionName
	 * passed as parameter
	 * 
	 * @param postType
	 * @param sectionName
	 * @return
	 */
	public boolean verifyTeamPostBgColor(String postType, String sectionName) {
		String bgColor = "";
		boolean flag = false;
		mapTeamPostTypeHexCodes();
		List<WebElement> _teamPostComment = (sectionName.equals(MYLOConstants.TEAM_POST_EXPANDED))
				? _teamPostExpandSectionComments
				: _teamPostComments;
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _teamPostComment,
					teamPostUpdatedValuesMap.get(postType));
			bgColor = Color.fromString(
					teamPostListWebElementsMap.get(sectionName).get(index).getCssValue(MYLOConstants.BACKGROUND_COLOR))
					.asHex();
			flag = bgColor.equals(teamPostTyeHexCodeMap.get(postType));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					postType, MYLOConstants.TEAM_POSTS));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_BG_COLOR, CoreConstants.PASS, postType,
					teamPostTyeHexCodeMap.get(postType), sectionName));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BACKGROUND_COLOR_MISMATCHED, CoreConstants.FAIL,
					postType + MYLOConstants.TEAM_POST_TYPE, teamPostTyeHexCodeMap.get(postType), bgColor,
					sectionName));
		return flag;
	}

	/**
	 * Verify Edit option availability for userName passed as the parameter
	 * 
	 * @param userName
	 * @return
	 */
	public boolean isTeamPostEditOptionExist(String userName) {
		boolean flag = false;
		try {
			WebElement _requiredTeamPost = _savedTeamPosts.get(BusinessFunctions
					.returnindexItemFromListUsingText(driver, _teamPostUpdatedUsers, userName + MYLOConstants.COLON));
			flag = CoreFunctions.isChildElementExist(driver, _requiredTeamPost, _teamPostEditBtn);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.EDIT_BUTTON + " button", MYLOConstants.TEAM_POSTS));
		}
		return flag;
	}

	/**
	 * Verify buttons of Team Post is enable or disable
	 * @param type
	 */
	public void isTeamPostBtnEnabled(String buttonName, String type) {
		BusinessFunctions.verifyMyloButtonEnabilityStatus(type, teamPostWebElementsMap.get(buttonName),
				buttonName, MYLOConstants.TEAM_POSTS, MYLOConstants.JOURNEY);
	}

	/**
	 * Add Team Post for PostType passed as a parameter
	 * @param postType
	 */
	public void addTeamPostWithRandomComments(String postType) {
		clickButtonsOnTeamPostSection(MYLOConstants.ADD_ICON);
		setTeamPostCommentField("15", MYLOConstants.RANDOM_STRING);
		selectTeamPostTypeField(postType);
		clickButtonsOnTeamPostSection(MYLOConstants.SAVE_BUTTON);
	}

	/**
	 * Add teamPost if not exist under TeamPost Section on Journey Page
	 * @param table
	 */
	public void addmultipleTeamPostIfNotExist(DataTable table) {
		if (!(CoreFunctions.isElementListExist(driver, _savedTeamPosts, 5))) {
			java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
			for (int i = 0; i < data.size(); i++) {
				addTeamPostWithRandomComments(data.get(i).get(MYLOConstants.TEAM_POST_TYPE));
			}
		}
	}
	
	/**
	 * Clicks on Filter section of passed PostType as a parameter
	 * 
	 * @param postType
	 */
	public void clickFilterOnTeamPostSection(String postType) {
		CoreFunctions.selectItemInListByText(driver, _teamPostFilterSectionHeaders, postType);
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
	}
	
	public boolean verifyFilteredPostDisplayed(String postType, String sectionName) {
		mapTeamPostSectionWebElementsList();
		boolean flag = false;
		try {
			List<String> postColorCodes = (teamPostListWebElementsMap.get(sectionName).stream()
					.map(x -> x.getAttribute(MYLOConstants.CLASS)).collect(Collectors.toList()));
			flag = postColorCodes.stream().allMatch(x -> x.contains(postType.toLowerCase()));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					postType, sectionName));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_SECTION_DISPLAYED, CoreConstants.PASS,
					postType + MYLOConstants.SPACE + MYLOConstants.TEAM_POST_TYPE, sectionName));
		return flag;
	}
	
	public boolean verifyFilteredPostBgColor(String postType, String sectionName) {
		mapTeamPostSectionWebElementsList();
		mapTeamPostTypeHexCodes();
		boolean flag = false;
		try {
			List<String> postColorCodes = (teamPostListWebElementsMap.get(sectionName).stream()
					.map(x -> Color.fromString(x.getCssValue(MYLOConstants.BACKGROUND_COLOR)).asHex())
					.collect(Collectors.toList()));
			flag = postColorCodes.stream().allMatch(x -> x.equalsIgnoreCase(teamPostTyeHexCodeMap.get(postType)));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					postType, MYLOConstants.TEAM_POSTS));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFED_POSTS_FILTERED_POSTYPE, CoreConstants.PASS, postType,
					sectionName));
		else
			Reporter.addStepLog(
					MessageFormat.format(MYLOConstants.POSTS_NOT_FILTERED, CoreConstants.FAIL, postType, sectionName));
		return flag;
	}
	
	public void searchTeamPostComments() {
		try {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			//List<String> listKeys = new ArrayList<String>(teamPostUpdatedValuesMap.keySet());
			//String randomPostType = listKeys
				//	.get(CoreFunctions.getRandomNumber(0, teamPostUpdatedValuesMap.keySet().size()-1));
			String randomComments = teamPostUpdatedValuesMap.get(MYLOConstants.GENERAL);
			//int beginIndex = CoreFunctions.getRandomNumber(0, randomComments.length() - 4);	
			//searchedText = randomComments.substring(beginIndex, beginIndex + 3);
			searchedText = randomComments.substring(0, 3);
			CoreFunctions.clearAndSetText(driver, _teamPostsSearchBox, MYLOConstants.TEAM_POST_SEARCHBOX, searchedText);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, CoreConstants.FAIL,
					MYLOConstants.TEAM_POST_SEARCHBOX));
		}
	}
	
	/**
	 * Verify that searched Text comment is displayed in Team Post section
	 * @param sectionName
	 * @return
	 */
	public boolean verifyPostDisplayedOnSearchedComments(String sectionName) {
		boolean flag = false;
		try {
			List<WebElement> _teamPostComment = (sectionName.equals(MYLOConstants.TEAM_POST_EXPANDED))
					? _teamPostExpandSectionComments
					: _teamPostComments;
			flag = _teamPostComment.stream().allMatch(x -> x.getText().contains(searchedText));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					searchedText, sectionName));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFED_POSTS_FILTERED_COMMENTS, CoreConstants.PASS,
					searchedText, sectionName));
		return flag;
	}

	/**
	 * Verify that searched Text displayed in Bold format on Team Post section
	 * @param sectionName
	 * @return
	 */
	public boolean verifySearchedTextDisplayedInBold(String sectionName) {
		boolean flag = false;
		try {
			WebElement _commentsMarked = (sectionName.equals(MYLOConstants.TEAM_POST_EXPANDED))
					? _teamPostExpandSectionCommentsMarked
					: _teamPostCommentsMarked;
			flag = CoreFunctions.getElementText(driver, _commentsMarked).equals(searchedText);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					searchedText, sectionName));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFED_SEARCH_COMMENT_CHARACTERS_BOLD,
					CoreConstants.PASS, searchedText, sectionName));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.SEARCH_COMMENT_CHARACTERS_NOT_BOLD,
					CoreConstants.FAIL, searchedText, sectionName));
		return flag;
	}
	
	public boolean verifyTeamPostUpdated(String sectionName) {
		boolean flag = false;
		mapTeamPostSectionWebElementsList();
		List<WebElement> _teamPostComment = (sectionName.equals(MYLOConstants.TEAM_POST_EXPANDED))
				? _teamPostExpandSectionComments
				: _teamPostComments;
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _teamPostComment,
					updatedCommentsValue);
			CoreFunctions.highlightObject(driver, teamPostListWebElementsMap.get(sectionName).get(index));
			flag = CoreFunctions
					.getAttributeText(teamPostListWebElementsMap.get(sectionName).get(index), MYLOConstants.CLASS)
					.contains(updatedPostTypeValue.toLowerCase());
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					updatedPostTypeValue, sectionName));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_SECTION_DISPLAYED, CoreConstants.PASS,
					updatedPostTypeValue + MYLOConstants.SPACE + MYLOConstants.TEAM_POST_TYPE, sectionName));
		return flag;
	}
	
	public boolean verifyTeamPostSorted(String sortOrder, String datesSection) {
		boolean flag = false;
		mapTeamPostSectionWebElementsList();
		try {
			List<String> postDatesInFormat = teamPostListWebElementsMap.get(datesSection).stream()
					.map(x -> CoreFunctions.getStringDateInFormat(x.getText(), "dd MMM yyyy", "YYYY-MM-dd"))
					.collect(Collectors.toList());
			List<String> copyPostDates = new ArrayList<String>(postDatesInFormat);
			CoreFunctions.sortListByOrder(sortOrder, copyPostDates);
			flag = (postDatesInFormat.equals(copyPostDates));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					datesSection, MYLOConstants.TEAM_POSTS));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_SECTION_DISPLAYED, CoreConstants.PASS,
					datesSection, MYLOConstants.TEAM_POST_EXPANDED));
		return flag;
	}

}
