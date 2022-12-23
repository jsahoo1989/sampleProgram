package com.aires.pages.mylo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.utilities.MyloNewFileUtil;

public class MyloJourneyPage_FileTeamSection extends Base {

	public MyloJourneyPage_FileTeamSection(WebDriver driver) {
		super(driver);
	}

	// WebElements related to Advanced Query section

	@FindBy(how = How.CSS, using = "app-aires-file-teams button label")
	private List<WebElement> _fileTeamButtonLabels;

	@FindBy(how = How.CSS, using = "app-aires-file-teams button")
	private List<WebElement> _fileTeamButtons;

	@FindBy(how = How.CSS, using = "app-aires-file-teams ng-select")
	private List<WebElement> _fileTeamDropdownFields;

	@FindBy(how = How.CSS, using = "app-aires-file-teams input")
	private List<WebElement> _fileTeamFieldValues;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement _yesBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	private WebElement _noBtn;

	// WebElements related to Journey Page

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	private final By _dropdownOptions = By.xpath("//div[@role='option']/span");

	public void clickFileTeamButtons(String buttonName) {
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _fileTeamButtonLabels, buttonName);
		CoreFunctions.click(driver, _fileTeamButtons.get(index), buttonName);
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
	}

	public String setFileTeamDropdownFields(String fieldName, String fieldValue) {
		WebElement fieldElement = BusinessFunctions.returnItemFromListUsingAttribute(driver, _fileTeamDropdownFields,
				fieldName, MYLOConstants.FORMCONTROLNAME);
		CoreFunctions.click(driver, fieldElement, fieldName);
		return BusinessFunctions.setMyloDropdownFields(driver, _dropdownOptions, fieldValue, fieldName);
	}

	public void addFileTeamDetailsIfNotPresent() {
		if (MyloNewFileUtil.get_ppc() == null) {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			clickFileTeamButtons(MYLOConstants.EDIT_BUTTON);
			clickFileTeamButtons(MYLOConstants.ADD_BUTTON);
			setFileTeamDropdownFields(MYLOConstants.ROLE, MYLOConstants.PPC);
			MyloNewFileUtil.set_ppc(setFileTeamDropdownFields(MYLOConstants.NAME, MYLOConstants.RANDOM));
			clickFileTeamButtons(MYLOConstants.SAVE_BUTTON);
			CoreFunctions.click(driver, _yesBtn, MYLOConstants.YES_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			clickFileTeamButtons(MYLOConstants.EDIT_BUTTON);
			clickFileTeamButtons(MYLOConstants.ADD_BUTTON);
			setFileTeamDropdownFields(MYLOConstants.ROLE, MYLOConstants.MSPEC);
			MyloNewFileUtil.set_mspec(setFileTeamDropdownFields(MYLOConstants.NAME, MYLOConstants.RANDOM));
			clickFileTeamButtons(MYLOConstants.SAVE_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		}
	}

}
