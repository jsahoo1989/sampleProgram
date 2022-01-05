package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.vimalselvam.cucumber.listener.Reporter;

public class Mylo_AssignmentPage extends Base {

	public Mylo_AssignmentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "input[id='empName']")
	private List<WebElement> _airesFileTeamMemberName;

	@FindBy(how = How.CSS, using = "input[id='startDate']")
	private List<WebElement> _airesFileTeamStartDates;

	@FindBy(how = How.CSS, using = "input[id='endDate']")
	private List<WebElement> _airesFileTeamEndDates;

	@FindBy(how = How.CSS, using = "input[id='empFunctionCode']")
	private List<WebElement> _airesFileTeamRoleName;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'navlist__container')]/li/a")
	private List<WebElement> _assignmentSubMenus;

	@FindBy(how = How.XPATH, using = "//label[text()='Role']//preceding-sibling::ng-select")
	private WebElement _roleSelectButtton;

	@FindBy(how = How.XPATH, using = "//label[text()='Name']//preceding-sibling::ng-select")
	private WebElement _memberNameSelectButtton;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/parent::td/following-sibling::td/button")
	private WebElement _airesFileTeamAddButton;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/parent::td/following-sibling::td/button[text()='Save']")
	private WebElement _airesFileTeamSaveButton;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/following::tbody[1]/tr")
	private List<WebElement> _noOfAddedAiresFileTeamMember;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _popUpMessage;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/ancestor::tr/following-sibling::tbody/descendant::input")
	private List<WebElement> _airesFileTeamMemberGrid;

	@FindBy(how = How.XPATH, using = "//button[text()='No' and contains(@class,'smallbutton')]")
	private WebElement _airesFileTeamNoButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement _airesFileTeamYesButton;

	int noOfAiresFileTeamMember;
	String updatedTeamMember;
	LinkedHashMap<String, String> airesFileTeamExistingMembers = new LinkedHashMap<String, String>();

	final By _dropdownOptions = By.xpath("//div[@role='option']/span");

	public void clickAssignmentTabs(String option) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _assignmentSubMenus);
		CoreFunctions.selectItemInListByText(driver, _assignmentSubMenus, option);
	}

	public boolean verifyActiveTab(String tabName) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _assignmentSubMenus);
		noOfAiresFileTeamMember = _noOfAddedAiresFileTeamMember.size();
		airesFileTeamExistingMembers = CoreFunctions.returnMapFromBothLists(driver, _airesFileTeamRoleName,
				_airesFileTeamMemberName);
		WebElement tabElement = CoreFunctions.returnItemInListByText(driver, _assignmentSubMenus, tabName);
		return (tabElement.getAttribute("class").contains("active")) ? true : false;
	}

	public void clickButtonOnAiresFileTeamSection(String buttonName) {
		switch (buttonName) {
		case MYLOConstants.ADD_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamAddButton, _airesFileTeamAddButton.getText());
			break;
		case MYLOConstants.CANCEL_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamAddButton, _airesFileTeamAddButton.getText());
			break;
		case MYLOConstants.SAVE_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamSaveButton, _airesFileTeamSaveButton.getText());
			break;
		case MYLOConstants.NO_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamNoButton, _airesFileTeamNoButton.getText());
			break;
		case MYLOConstants.YES_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamYesButton, _airesFileTeamYesButton.getText());
			break;
		}
	}

	public void addRole(String roleName) {
		CoreFunctions.click(driver, _roleSelectButtton, _roleSelectButtton.getAttribute(MYLOConstants.NAME));
		CoreFunctions.selectItemInListByText(driver, CoreFunctions.getElementListByLocator(driver, _dropdownOptions),
				roleName);
	}

	public boolean verifyRoleAccessFromUserType(String userType, String roleName) {
		try {
			if (userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE15))
				Assert.assertFalse(verifyRoleInDropdown(roleName));
			else
				Assert.assertTrue(verifyRoleInDropdown(roleName));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean verifyRoleInDropdown(String roleName) {
		try {
			CoreFunctions.click(driver, _roleSelectButtton, _roleSelectButtton.getAttribute(MYLOConstants.NAME));
			List<WebElement> optionsList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			return CoreFunctions.searchElementExistsInListByText(driver, optionsList, roleName);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_DROPDOWN,
					CoreConstants.FAIL, roleName, MYLOConstants.ROLE_NAME));
			return false;
		}
	}

	public void addTeamMember(String memberName) {
		try {
			CoreFunctions.click(driver, _memberNameSelectButtton,
					_memberNameSelectButtton.getAttribute(MYLOConstants.NAME));
			List<WebElement> optionsList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			if (memberName != MYLOConstants.RANDOM) {
				CoreFunctions.selectItemInListByText(driver, optionsList, memberName);
				Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFY_ELEMENT_VALUE_ON_SECTION,
						CoreConstants.PASS, MYLOConstants.ROLE_NAME, memberName, MYLOConstants.AIRES_FILE_TEAM));
			} else {
				updatedTeamMember = CoreFunctions.getRandomElementValueFromList(driver, optionsList);
				CoreFunctions.selectItemInListByText(driver, optionsList, updatedTeamMember);
				Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFY_ELEMENT_VALUE_ON_SECTION,
						CoreConstants.PASS, MYLOConstants.ROLE_NAME, updatedTeamMember, MYLOConstants.AIRES_FILE_TEAM));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_DROPDOWN,
					CoreConstants.FAIL, memberName, MYLOConstants.MEMBER_NAME));
		}

	}

	public boolean verifyExistingTeamMemberInDropdown(String roleName) {
		try {
			CoreFunctions.click(driver, _memberNameSelectButtton,
					_memberNameSelectButtton.getAttribute(MYLOConstants.NAME));
			List<WebElement> optionsList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			return CoreFunctions.searchElementExistsInListByText(driver, optionsList,
					airesFileTeamExistingMembers.get(roleName));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_DROPDOWN,
					CoreConstants.FAIL, airesFileTeamExistingMembers.get(roleName), MYLOConstants.MEMBER_NAME));
			return false;
		}
	}

	public boolean verifyPopUpMessage(String msg) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _popUpMessage, _popUpMessage.getText());
			Assert.assertEquals(_popUpMessage.getText(), msg);
		} catch (Throwable e) {
			return false;
		}
		return true;
	}

	public boolean verifyRowAddedInAiresFileTeam() {
		return (_noOfAddedAiresFileTeamMember.size() != noOfAiresFileTeamMember) ? true : false;
	}

	public boolean verifyUpdatedRow(String roleName) {
		CoreFunctions.waitForBrowserToLoad(driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _airesFileTeamMemberGrid);
		List<String> allRoleNames = _airesFileTeamRoleName.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		List<String> allTeamMembers = _airesFileTeamMemberName.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		List<String> allStartDates = _airesFileTeamStartDates.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		List<String> allEndDates = _airesFileTeamEndDates.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		String currentDate = DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now());
		if (allTeamMembers.get(allRoleNames.indexOf(roleName)).trim().equals(updatedTeamMember)
				&& allStartDates.get(allRoleNames.indexOf(roleName)).trim().equals(currentDate)
				&& allEndDates.get(allRoleNames.indexOf(roleName)).trim().equals(MYLOConstants.ACTIVE)
				&& allEndDates.get(allRoleNames.lastIndexOf(roleName)).trim().equals(currentDate)) {

			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRYFD_UPDATED_ROW, CoreConstants.PASS, roleName,
					MYLOConstants.AIRES_FILE_TEAM));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_UPDATED_ROW, CoreConstants.FAIL, roleName,
				MYLOConstants.AIRES_FILE_TEAM));
		return false;
	}

	public boolean verifyAiresFileTeamRecordsReadonly() {
		for (WebElement element : _airesFileTeamMemberGrid) {
			if (element.getAttribute(MYLOConstants.CLASS).contains(MYLOConstants.MYLO_READONLY))
				continue;
			else
				return false;
		}
		return true;
	}
}
