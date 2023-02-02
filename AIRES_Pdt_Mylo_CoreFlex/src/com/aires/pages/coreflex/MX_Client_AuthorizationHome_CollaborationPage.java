package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.utilities.EmailUtil;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MX_Client_AuthorizationHome_CollaborationPage extends Base {

	public MX_Client_AuthorizationHome_CollaborationPage(WebDriver driver) {
		super(driver);
	}

	// Heading text Contributors
	@FindBy(how = How.CSS, using = "span[id*='afwfot1']")
	private WebElement _headingText_Contributors;

	@FindBy(how = How.XPATH, using = "//span[text()='Contributor workflow']")
	private WebElement _headingTextContributorWorkflow;

	// Heading text Approver
	@FindBy(how = How.ID, using = "aRegion:1:afwfot11")
	private WebElement _headingText_Approver;

	// Link - Add a contributor
	@FindBy(how = How.ID, using = "aRegion:1:afwfots2")
	private WebElement _link_addAContributor;

	// Link - Add a approver
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add an approver')]")
	private WebElement _link_addAnApprover;

	// iFrame - Add a Contributor
	@FindBy(how = How.XPATH, using = "//iframe[starts-with(@id, 'j_id')]")
	private static WebElement _iframe_AddAContributon;

	// Checkbox Contribute to Authorization
	@FindBy(how = How.ID, using = "cpRequestHelp0::content")
	private WebElement _chk_contributToAuthorization;

	// Checkbox Review the initiation
	@FindBy(how = How.ID, using = "cpRequestHelp1::content")
	private WebElement _chk_reviewTheInitiation;

	// Dropdown Contributor name
	@FindBy(how = How.CSS, using = "#cpsoc2\\:\\:content > option")
	private List<WebElement> _drpDwn_contributorName;

	// Textarea comments
	@FindBy(how = How.ID, using = "cpcomments::content")
	private WebElement _txtArea_comments;

	// Button Add Contributor
	@FindBy(how = How.CSS, using = "#startCollaboratingBtn > a > span")
	private WebElement _btn_addContributor;

	// Button Add Approver
	@FindBy(how = How.CSS, using = "#apacaB1 > a > span")
	private WebElement _btn_addApprover;

	// Button Cancel
	@FindBy(how = How.ID, using = "cpacaL1::text")
	private WebElement _btn_cancel;

	// Icon Close
	@FindBy(how = How.ID, using = "j_id1035::close")
	private WebElement _icon_close;

	@FindBy(how = How.ID, using = "cpsoc2::content")
	private WebElement _contributorName;

	// Radio Button Label List - Authorization Type
	@FindBy(how = How.XPATH, using = "//span[@class='af_selectBooleanRadio_content-input']/label")
	private static List<WebElement> _radioButtonLabel_listForAll;

	// Radio Button Label List - Authorization Type
	@FindBy(how = How.CSS, using = "label[id*='cpRequestHelp'][class='p_OraHiddenLabel']")
	private static List<WebElement> _radioButtonLabel_AuthorizationType;

	// Added contributors list on Collaboration Tab
	@FindBy(how = How.CSS, using = "span.RXBigText")
	private static List<WebElement> _list_Contributors;

	// Approver Name text box
	@FindBy(how = How.CSS, using = "input[id*='apempname']")
	private WebElement _txtbox_ApproverName;

	// Approver Email text box
	@FindBy(how = How.CSS, using = "input[id*='apemail']")
	private WebElement _txtbox_ApproverEmail;

	// Approver job title text box
	@FindBy(how = How.CSS, using = "input[id*='apempTitle']")
	private WebElement _txtbox_ApproverJobTitle;

	// Approver comment text box
	@FindBy(how = How.CSS, using = "textarea[id='apcomments::content']")
	private WebElement _txtbox_ApproverComment;

	// Added Approver list on Collaboration Tab
	@FindBy(how = How.CSS, using = "span.RXBigText")
	private static List<WebElement> _list_Approver;

	@FindBy(how = How.XPATH, using = "//span[text()='Start contributing to the authorization now']")
	// @FindBy(how = How.XPATH, using = "//span[text()='Start contributing to the
	// budget now']")
	private WebElement _startContributingButton;

	@FindBy(how = How.XPATH, using = "//span[text()='Start contributing to the budget now']")
	private WebElement _startContributingToBudgetButton;

	// App approver title on Add Approver dialog
	@FindBy(how = How.ID, using = "apot1")
	private WebElement _titleOnAddApproverDialog;

	@FindBy(how = How.ID, using = "aRegion:0:floatingMenuIterator:2:displayName")
	private WebElement _linkFloatingMenu_AddApprover;

	@FindBy(how = How.CSS, using = "label.p_OraHiddenLabel")
	private static List<WebElement> _listRadioButtonRoutingOrder;

	@FindBy(how = How.XPATH, using = "//span[text()='Start routing']")
	private WebElement _linkFloatingMenu_StartRouting;

	@FindBy(how = How.XPATH, using = "	//span[text()='Routing order']")
	private WebElement _textRoutingOrder;

	@FindBy(how = How.ID, using = "aRegion:1:cspw1::close")
	private WebElement _closeIcon;

	@FindBy(how = How.XPATH, using = "//span[text()='Route to approvers']")
	private WebElement _linkFloatingMenu_RouteToApprover;

	@FindBy(how = How.XPATH, using = "//span[text()='Review approvers']")
	private WebElement _linkFloatingMenu_ReviewApprovers;

	final By _floatingMenu_AddApproverByLocator = By.id("aRegion:0:floatingMenuIterator:2:displayName");
	final By _link_AddAnApproverByLocator = By.id("aRegion:1:afwfots12");

	// Add Approver - Start Route in floating menu
	@FindBy(how = How.CSS, using = "div.RXAuthFloatIconBox span")
	private List<WebElement> _floatingMenu_DisplayTextList;

	// Go Back to Dashboard Link after click on Start Route in floating menu
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Back to dashboard')]")
	private WebElement _linkGoBackToDashboard;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Go back to task list')]")
	private WebElement _linkGoBackToTaskList;

	// Send Comment to Contributor - Email Locators - Text Area
	@FindBy(how = How.CSS, using = ".RXInputText textarea")
	private WebElement _textAreaAuthWorkFlow;

	// Send Comment to Contributor - Email Locators - Reply To Dropdown
	@FindBy(how = How.CSS, using = ".af_selectOneChoice_content")
	private WebElement _dropDownReplyTo;

	// Send Comment to Contributor - Email Locators - Reply To Dropdown
	@FindBy(how = How.CSS, using = ".RXSmallPrimaryButton>a")
	private WebElement _btnSaveOnAuthWorkFlowAction;

	@FindBy(how = How.XPATH, using = "//span[text()='View initiation']")
	private WebElement _linkViewInitiation;

	@FindBy(how = How.XPATH, using = "//span[text()='2 Approver(s)']")
	private WebElement _linkCollaborationApprover;

	@FindBy(how = How.XPATH, using = "//span[text()='Submitted']")
	private WebElement _textSubmittedApprover;

	@FindBy(how = How.XPATH, using = "//span[@title='Remove']")
	private WebElement _linkRemoveFirstApprover;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Approver(s)')]")
	private WebElement _textApproverDetail;

	@FindBy(how = How.XPATH, using = "//span[@class='RXBigText RXBold']")
	private List<WebElement> _textApproverList;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'collPanelInner')]//span[@class='RXBigText RXBold']")
	private WebElement _addedContributorsList;

	@FindBy(how = How.CSS, using = "span[id*='wwcpot121']")
	private WebElement _headerApproverIntiation;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Proceed with Current Approver List')]")
	private WebElement btnProceedForApprovers;

	@FindBy(how = How.CSS, using = "span[id*='csceot14']")
	private WebElement _headerIntiation;

	@FindBy(how = How.CSS, using = "span[id*='cdot4']")
	private WebElement linkContinueInitiatiation;

	@FindBy(how = How.CSS, using = "span[id*='afwfiotii']")
	private List<WebElement> _staticApproverList;

	@FindBy(how = How.CSS, using = "label[class*='Label']")
	private static List<WebElement> _listProxyApproverRequestTypeRadio;

	@FindBy(how = How.CSS, using = "textarea[id*='adpadcomments']")
	private WebElement _txtboxProxyApproverComment;

	@FindBy(how = How.XPATH, using = "//span[text()='SUBMIT TO AIRES']")
	private WebElement _buttonSubmitToAires;

	@FindBy(how = How.XPATH, using = "//span[text()='SUBMIT']")
	private WebElement _buttonSubmit;

	@FindBy(how = How.CSS, using = "span[title='Approve as proxy']")
	private WebElement _linkApproveAsProxy;

	@FindBy(how = How.XPATH, using = "//table[contains(@id,'afwfstatus')]/parent::td/following::td/descendant::span[contains(@class,'RXBigText RXBold')]")
	private List<WebElement> _listApprovers;

	@FindBy(how = How.XPATH, using = "//span[@title='Remove']")
	private List<WebElement> _listRemoveApprover;

	@FindBy(how = How.XPATH, using = "//*[@id='growls']//div[@class='growl-message']")
	private WebElement _txtGrowlMessage;

	@FindBy(how = How.CSS, using = "select[class='af_selectOneChoice_content']")
	private WebElement _approverNameDropdown;

	// @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Add a comment*']")
	// //Locator is locating two text areas
	@FindBy(how = How.CSS, using = "textarea[id*='ngComments']")
	private WebElement _textareaComments;

	@FindBy(how = How.XPATH, using = "//span[text()='Save']")
	private WebElement _commentsSaveButton;

	@FindBy(how = How.XPATH, using = "//span[text()='Send']")
	private WebElement _commentsSentButton;

	@FindBy(how = How.CSS, using = "a[id*='window11::close']")
	private WebElement _commentsCloseIcon;

	// @FindBy(how = How.XPATH, using =
	// "//table[contains(@id,'aRegion:0:cmntItr:0:nlPG')]//span")
	@FindBy(how = How.CSS, using = "span[id*='cmntItr']")
	private List<WebElement> _commentslist;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'next...')]")
	private WebElement _textWhatNextPopUp;

	@FindBy(how = How.XPATH, using = "//span[text()='Upload a document' and @class='RXAuthFormFloatText']")
	private WebElement _textUploadDocument;

	@FindBy(how = How.XPATH, using = "//span[text()='Review contributors']")
	private WebElement _textReviewContributors;

	@FindBy(how = How.CSS, using = "span[class*='LastSavedTimeHandler']")
	private WebElement _textSavingInformation;

	@FindBy(how = How.XPATH, using = "//span[text()='Submit to Aires']")
	private WebElement _textSubmitToAires;

	@FindBy(how = How.XPATH, using = "//span[text()='Start routing']")
	private WebElement _textStartRouting;

	@FindBy(how = How.XPATH, using = "//span[text()='Cancel routing']")
	private WebElement _textCancelRouting;

	@FindBy(how = How.CSS, using = "select[class='af_selectOneChoice_content']")
	private WebElement _contributorNameDropdown;

	@FindBy(how = How.CSS, using = "span[class*='TextMessageHandler']")
	private WebElement _textAllChangesSaved;

	@FindBy(how = How.CSS, using = "span[id*='floatingMenuIterator']")
	private List<WebElement> _listWhatNextFloatingMenu;

	@FindBy(how = How.XPATH, using = "//span[text()='Comments']")
	private WebElement _commentLabelText;

	@FindBy(how = How.XPATH, using = "//span[text()='Add a comment']")
	private WebElement _linkAddComment;

	@FindBy(how = How.XPATH, using = "//span[text()='Submit to Aires']")
	private WebElement _submitToAiresButton;

	@FindBy(how = How.XPATH, using = "//span[text()='SUBMIT']")
	private WebElement _submitButton;

	@FindBy(how = How.ID, using = "aRegion:1:nlWindow::close")
	private WebElement _closeIconOfCommentDialog;

	// Add a contributor Pop-Up : ADD CONTRIBUTOR Button
	@FindBy(how = How.ID, using = "startCollaboratingBtn")
	private WebElement _addContributorButton;

	// Add approver Pop-Up : ADD APPROVER Button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'ADD APPROVER')]")
	private WebElement _addApproverButton;

	// Team Comment Icon
	@FindBy(how = How.CSS, using = "span[class*='icon-comment']")
	private WebElement _teamComment;

	// Team Comment Section
	@FindBy(how = How.CSS, using = "div[id*='teamCommentsPGL']")
	private WebElement _teamCommentsSection;

	// Add A Team Comment Button
	@FindBy(how = How.CSS, using = "span[id*='commentText']")
	private WebElement _addATeamComment;

	// Comment To Select Field
	@FindBy(how = How.CSS, using = "select[id*='ngCommentsType']")
	private WebElement _commentToSelectField;

	// Comment To Approver Select Field
	@FindBy(how = How.CSS, using = "select[title*='Collaborator Name']")
	private WebElement _commentToApproverSelectField;

	// Comments textArea Field
	@FindBy(how = How.CSS, using = "textarea[id*='ngComments']")
	private WebElement _commentsTextAreaField;

	// Comments Approver textArea Field
	@FindBy(how = How.CSS, using = "textarea[name*='wfccomments']")
	private WebElement _commentsApproverTextAreaField;

	// Send Button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Send')]")
	private WebElement _sendButton;

	// Save Button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	private WebElement _saveButton;

	// Team Comment Window Close
	@FindBy(how = How.CSS, using = "a[id*='Window::close']")
	private WebElement _teamCommentWindowCloseButton;

	// Team Comment Window Close
	@FindBy(how = How.CSS, using = "a[id*='window111::close']")
	private WebElement _teamCommentApproverWindowCloseButton;

	// Most Recent Added Team Comment
	@FindBy(how = How.CSS, using = "span[id*='cmntItr']")
	private List<WebElement> _mostRecentAddedTeamCommentList;

	// Most Recent Added Approver Team Comment
	@FindBy(how = How.CSS, using = "span[id*='otComm']")
	private List<WebElement> _mostRecentAddedApproverTeamCommentList;

	// Team Comment Sort Text
	@FindBy(how = How.CSS, using = "span[id*='sortText']")
	private WebElement _teamCommentSortText;

	// Team Comment Added Date & Time
	@FindBy(how = How.CSS, using = "span[class='RXSmallTextMuted']")
	private List<WebElement> _teamCommentAddedDataTimeList;

	// Team Comment Filter Text
	@FindBy(how = How.CSS, using = "span[id*='filterText']")
	private WebElement _teamCommentFilterText;

	// Team Comments Filter Options checkbox
	@FindBy(how = How.CSS, using = "a[class*='filter-checkbox-text']")
	private List<WebElement> _filterOptionsCheckbox;

	// Team Comments Filter Comments To List
	@FindBy(how = How.CSS, using = "span[class='RXSmallText RXBold'][id*='cmntItr']")
	private List<WebElement> _filterCommentsToList;

	// Team Comment Filter Result Text
	@FindBy(how = How.ID, using = "aRegion:0:CommentResultTextId")
	private WebElement _teamCommentResultText;

	// Team Comment Filter Button
	@FindBy(how = How.CSS, using = "div[id*='aRegion:0:ngbt']")
	private WebElement _teamCommentFilterButton;

	// Remove Contributor
	@FindBy(how = How.CSS, using = "div[id*='collabPanel'] span[title='Remove']")
	private WebElement _removeDefaultContributorButton;

	// Route in Sequential Order
	@FindBy(how = How.XPATH, using = "//label[contains(@id,'routingType')][contains(text(),'Route in sequential order')]")
	private WebElement _radioRouteInSequentialOrder;

	// Send To All Approver At Once
	@FindBy(how = How.XPATH, using = "//label[contains(@id,'routingType')][contains(text(),'Send to all approvers at once')]")
	private WebElement _radioSendToAllApproverAtOnce;

	// Collaborator removed Growl Message
	@FindBy(how = How.XPATH, using = "//div[@class='growl-message'][contains(string(),'has been removed successfully.')]")
	private WebElement _textCollaboratorRemovedGrowlMessage;

	// Authorization Contributor
	@FindBy(how = How.XPATH, using = "//table[contains(@class,'AFCollobratorPanel')]//span[contains(text(),'Authorization')]")
	private WebElement _textAuthorizationContributor;

	// RoutedSuccessApprovalWF Dialog
	@FindBy(how = How.CSS, using = "div[id*='confSuccess::popup-container']")
	private WebElement _dialogRoutedSuccessApprovalWF;

	// RoutedSuccessApprovalWF Dialog - Heading Text
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'RXModalTitle')]//span[contains(text(),'Initiation')]")
	private WebElement _textRoutedSuccessApprovalWFHeading;

	// Continue working on this initiation button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Continue working on this initiation')]")
	private WebElement _buttonContinueWorkingOnThisInitiation;

	// Contributor Route Success Icon
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Started this initiation')]//ancestor::table[contains(@class,'AFCollobratorPanel')]//span[contains(@class,'ServicesSuccessIcon')]")
	private WebElement _iconContributorAuthRouteSuccess;

	// Approval WF Started text
	@FindBy(how = How.CSS, using = "span[id*='approver'] span[class='AFItalic RXBiggerText']")
	private WebElement _textRoutingForApproval;

	// Button - Start routing
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel routing')]")
	private WebElement _buttonCancelRouting;

	// Button - Submit to Aires Floating
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Submit to Aires')]")
	private WebElement _floatingButtonSubmitToAires;

	// Button - Start routing
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Resubmit to Aires')]")
	private WebElement _buttonResubmitToAires;

	final By _linkViewInitiationByLocator = By.xpath("//span[text()='View initiation']");
	final By _linkCollaborationApproverByLocator = By.xpath("//span[text()='2 Approver(s)']");
	final By _textApproverDetails = By.xpath("//span[contains(text(),'Approver(s)')]");
	final By _headingApproverWorkflowByLocator = By.xpath("//span[text()='Approval workflow']");
	final By _listApproversByLocator = By.xpath(
			"//table[contains(@id,'afwfstatus')]/parent::td/following::td/descendant::span[contains(@class,'RXBigText RXBold')]");
	final By _growlMessageByLocator = By.className("growl-message");
	final By _closeGrowlMessageByLocator = By.className("growl-close");
	final By _addViewCommentsLink = By.xpath("//span[text()='View/Add comments']");
	final By _commentsLabel = By.xpath("//span[text()='Comments']");
	final By _addACommentLink = By.xpath("//span[text()='Add a comment']");

	// Methods
	private WebElement _webElement = null;

	/**
	 * Method to verify navigated Page
	 */
	public boolean verifyPageNavigation() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _headingTextContributorWorkflow, MobilityXConstants.CONTRIBUTOR_WORKFLOW);
			CoreFunctions.scrollToElementUsingJavaScript(driver, _headingTextContributorWorkflow,
					MobilityXConstants.CONTRIBUTOR_WORKFLOW);
			return CoreFunctions.isElementExist(driver, _headingTextContributorWorkflow, 5);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_MOBILITYX_CLIENT_AUTH_COLLABORATION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyPageHeading(String elementName, String expectedHeading) {
		Log.info("Element Name : " + elementName + "**** Expected Heading : " + expectedHeading);
		return CoreFunctions.getElementText(driver, returnElementAsPerName(elementName))
				.equalsIgnoreCase(expectedHeading);
	}

	public boolean removeDefaultAdditionalContributors() {
		boolean isDefaultAddtionalCountributorsRemoved = false;
		try {
			CoreFunctions.waitHandler(1);
			CoreFunctions.moveToElement(driver, _textAuthorizationContributor);
			CoreFunctions.hoverAndClick(driver, _removeDefaultContributorButton,
					MobilityXConstants.REMOVE_DEFAULT_ADDITIONAL_CONTRIBUTOR);
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _textCollaboratorRemovedGrowlMessage);
			isDefaultAddtionalCountributorsRemoved = true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_REMOVING_ADDITIONAL_DEFAULT_CONTRIBUTORS_FROM_CONTRIBUTOR_WORKFLOW,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isDefaultAddtionalCountributorsRemoved) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_REMOVED_ADDITIONAL_DEFAULT_CONTRIBUTORS_FROM_CONTRIBUTOR_WORKFLOW,
					CoreConstants.PASS));
		}
		return isDefaultAddtionalCountributorsRemoved;
	}

	public WebElement returnElementAsPerName(String pageName) {
		WebElement element = null;
		switch (pageName) {
		case MobilityXConstants.COLLABORATION_TAB:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _headingText_Contributors,
					_headingText_Contributors.getText());
			element = _headingText_Contributors;
			break;
		case MobilityXConstants.ADD_CONTRIBUTOR:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _link_addAContributor,
					_link_addAContributor.getText());
			element = _link_addAContributor;
			break;
		case MobilityXConstants.ADD_AN_APPROVER:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _headingText_Approver,
					_headingText_Approver.getText());
			element = _headingText_Approver;
			break;
		case MobilityXConstants.ADD_APPROVER_TITLE_ON_APPROVER_DIALOG:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _titleOnAddApproverDialog,
					_titleOnAddApproverDialog.getText());
			element = _titleOnAddApproverDialog;
			break;
		default:
			Assert.fail(COREFLEXConstants.NO_ELEMENT_FOUND);
		}
		return element;
	}

	public void clickCloseButtonOfCommentDialogBox() {
		CoreFunctions.waitHandler(3);
		CoreFunctions.click(driver, _closeIconOfCommentDialog, _closeIconOfCommentDialog.getText());
	}

	public void clickAddaContributor_Link_Button(String pageName) {
		switch (pageName) {
		case MobilityXConstants.COLLABORATION_TAB:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _link_addAContributor,
					_link_addAContributor.getText());
			CoreFunctions.click(driver, _link_addAContributor, _link_addAContributor.getText());
			switchToiFrame_Contributor_Approver();
			break;
		case MobilityXConstants.ADD_CONTRIBUTOR:
			CoreFunctions.waitHandler(3);
			CoreFunctions.click(driver, _btn_addContributor, MobilityXConstants.ADD_CONTRIBUTOR);
			CoreFunctions.waitHandler(5);
			driver.switchTo().defaultContent();
			CoreFunctions.explicitWaitTillElementVisibility(driver, _headingText_Contributors,
					MobilityXConstants.TITLE_CONTRIBUTORS + MobilityXConstants.TITLE);
			break;
		default:
			Assert.fail(COREFLEXConstants.NO_ELEMENT_FOUND);
		}
	}

	public void clickAddanApprover_Link_Button(String linkName) {
		switch (linkName) {
		case MobilityXConstants.ADD_AN_APPROVER:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _btn_addApprover, _btn_addApprover.getText());
			CoreFunctions.click(driver, _btn_addApprover, MobilityXConstants.ADD_AN_APPROVER);
			driver.switchTo().defaultContent();
			break;
		case MobilityXConstants.LINK_ADD_APPROVER:
			if (CoreFunctions.isElementExist(driver, _link_addAnApprover, 4)) {
				CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _link_addAnApprover,
						_link_addAnApprover.getText());
				CoreFunctions.click(driver, _link_addAnApprover, _link_addAnApprover.getText());
				switchToiFrame_Contributor_Approver();
			}
			break;
		case MobilityXConstants.LINK_GO_BACK_TO_DASHBOARD:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkGoBackToDashboard,
					_linkGoBackToDashboard.getText());
			CoreFunctions.click(driver, _linkGoBackToDashboard, _linkGoBackToDashboard.getText());
			break;
		default:
			Assert.fail(COREFLEXConstants.NO_ELEMENT_FOUND);
		}
	}

	public void clickAddApproverOnFloatingMenu() {
		if (CoreFunctions.isElementByLocatorExist(driver, _floatingMenu_AddApproverByLocator, 5)) {
			CoreFunctions.click(driver, _linkFloatingMenu_AddApprover, MobilityXConstants.ADD_AN_APPROVER);
			switchToiFrame_Contributor_Approver();
		}
	}

	public void switchToiFrame_Contributor_Approver() {
		try {
			CoreFunctions.waitHandler(6);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _iframe_AddAContributon, MobilityXConstants.IFRAME);
			driver.switchTo().frame(_iframe_AddAContributon);
		} catch (ElementNotFoundException e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void addContributor(DataTable contributorData) {
		CoreFunctions.waitHandler(8);
		java.util.List<java.util.List<String>> data = contributorData.raw();

		// Select What would you like to Contribute as 'Contribute to the authorization'
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioButtonLabel_listForAll, data.get(1).get(0));

		// Select Contributor name
		CoreFunctions.waitHandler(10);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDwn_contributorName);
		BusinessFunctions.selectValueFromDropdown(driver, _contributorName, data.get(1).get(1));

		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _txtArea_comments, MobilityXConstants.COMMENTS);
		CoreFunctions.clearAndSetText(driver, _txtArea_comments, data.get(1).get(2));
	}

	public boolean verifyContributorAdded(String contributorName) {
		CoreFunctions.waitHandler(2);
		return BusinessFunctions.verifyItemExistsInList(driver, _list_Contributors, contributorName);
	}

	public void addGlobalMobilitycontributor(DataTable contributorData) {
		CoreFunctions.waitHandler(6);
		java.util.List<java.util.List<String>> data = contributorData.raw();
		if (!BusinessFunctions.verifyItemExistsInList(driver, _list_Contributors, data.get(1).get(1))) {
			BusinessFunctions.selectRadioAsPerLabelText(driver, _radioButtonLabel_listForAll, data.get(1).get(0));
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDwn_contributorName);
			BusinessFunctions.selectValueFromDropdown(driver, _contributorName, data.get(1).get(1));
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _txtArea_comments,
					MobilityXConstants.COMMENTS);
			CoreFunctions.clearAndSetText(driver, _txtArea_comments, data.get(1).get(2));
		} else {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.VERIFY_CONTIRBUTOR_ADDED, CoreConstants.PASS,
					data.get(1).get(1)));
		}
	}

	public void addApprover(DataTable approverData) {
		java.util.List<java.util.List<String>> data = approverData.raw();
		CoreFunctions.waitHandler(3);
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _txtbox_ApproverName,
				MobilityXConstants.APPROVER_NAME_FIELD);
		CoreFunctions.clearAndSetText(driver, _txtbox_ApproverName, data.get(1).get(0));

		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _txtbox_ApproverEmail,
				MobilityXConstants.APPROVER_EMAIL_FIELD);
		CoreFunctions.clearAndSetText(driver, _txtbox_ApproverEmail, data.get(1).get(1));

		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _txtbox_ApproverJobTitle,
				MobilityXConstants.APPROVER_JOB_TITLE_FIELD);
		CoreFunctions.clearAndSetText(driver, _txtbox_ApproverJobTitle, data.get(1).get(2));

		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _txtbox_ApproverComment,
				MobilityXConstants.APPROVER_COMMENTS_FIELD);
		CoreFunctions.clearAndSetText(driver, _txtbox_ApproverComment, data.get(1).get(3));
	}

	public void fillDetailsOnAddApproverPopUp(String approverName, String approverEmail, String approverJobTitle,
			String approverComment) {
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.clearAndSetText(driver, _txtbox_ApproverName, approverName);
		CoreFunctions.clearAndSetText(driver, _txtbox_ApproverEmail, approverEmail);
		CoreFunctions.clearAndSetText(driver, _txtbox_ApproverJobTitle, approverJobTitle);
		CoreFunctions.clearAndSetText(driver, _txtbox_ApproverComment, approverComment);
	}

	public boolean verifyApproverAdded(String ApproverName) {
		CoreFunctions.waitHandler(2);
		CoreFunctions.scrollToElementUsingJavaScript(driver, _headingTextContributorWorkflow, MobilityXConstants.CONTRIBUTOR_WORKFLOW);
		CoreFunctions.scrollUpUsigActions(driver);
		CoreFunctions.scrollToElementUsingJavaScript(driver, _headingTextContributorWorkflow, MobilityXConstants.CONTRIBUTOR_WORKFLOW);		
		return BusinessFunctions.verifyItemExistsInList(driver, _list_Approver, ApproverName);
	}

	public boolean isStartContributingButtonExist() {
		try {
			CoreFunctions.waitHandler(15);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _startContributingButton,
					_startContributingButton.getText());
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.VERIFIED_START_CONTRIBUTING_BUTTON, CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickStartContributingButton() {
		CoreFunctions.clickElement(driver, _startContributingButton);
	}

	public void submitAuthorizationForm() {
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.clickUsingJS(driver, _submitToAiresButton, _submitToAiresButton.getText());
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.waitHandler(2);
		CoreFunctions.click(driver, _submitButton, _submitButton.getText());
		CoreFunctions.waitUntilBrowserReady(driver);
	}

	public void waitTillSuccessMessageInVisibility() {
		if (CoreFunctions.isElementByLocatorExist(driver, _growlMessageByLocator, MobilityXConstants.CUSTOM_TIME)) {
			driver.findElement(By.className("growl-close")).click();
			CoreFunctions.explicitWaitWithLocatorTillElementDisappears(driver, _closeGrowlMessageByLocator);
		}
	}

	public void clickStartRoutingAfterSelectRoutingType(String routingType) {
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.waitHandler(2);
		CoreFunctions.highlightObject(driver, _textRoutingOrder);
		CoreFunctions.selectItemInListByText(driver, _listRadioButtonRoutingOrder, routingType);
		CoreFunctions.click(driver, _linkFloatingMenu_StartRouting, _linkFloatingMenu_StartRouting.getText());
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.click(driver, _closeIcon, CoreFunctions.getAttributeText(_closeIcon, MobilityXConstants.TITLE));
	}

	public void clickStartRoutingForBostonScientific(String routingType) {
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.scrollVerticallyDownByGivenPixle(driver, -300);
		CoreFunctions.waitHandler(2);
		CoreFunctions.highlightObject(driver, _textRoutingOrder);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _listRadioButtonRoutingOrder, routingType);
		CoreFunctions.click(driver, _linkFloatingMenu_StartRouting, _linkFloatingMenu_StartRouting.getText());
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.click(driver, _closeIcon, CoreFunctions.getAttributeText(_closeIcon, MobilityXConstants.TITLE));
		CoreFunctions.waitHandler(2);
	}

	public void clickStartRoutingForApprover() {
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.scrollVerticallyDownByGivenPixle(driver, -300);
		CoreFunctions.waitHandler(2);
		CoreFunctions.click(driver, _linkFloatingMenu_RouteToApprover, _linkFloatingMenu_RouteToApprover.getText());
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.waitHandler(2);
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.click(driver, _linkGoBackToTaskList,
				CoreFunctions.getAttributeText(_linkGoBackToTaskList, MobilityXConstants.TITLE));
	}

	public void navigateToUrl(String url) {
		driver.navigate().to(url);
		CoreFunctions.waitUntilBrowserReady(driver);
	}

	public void selectElementOnFloatingMenu(String elementName) {
		CoreFunctions.waitHandler(3);
		BusinessFunctions.selectItemFromListUsingText(driver, _floatingMenu_DisplayTextList, elementName);
	}

	public void addCommentThroughReviewCommentEmail() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _btnSaveOnAuthWorkFlowAction, "Save Button");
		CoreFunctions.setElementText(driver, _textAreaAuthWorkFlow,
				"Review Comment Added To Test Review Approver Comments Fuctionality");
		CoreFunctions.waitHandler(2);
		BusinessFunctions.selectValueFromDropdown(driver, _dropDownReplyTo, "Test Six");
		CoreFunctions.waitHandler(2);
		CoreFunctions.click(driver, _btnSaveOnAuthWorkFlowAction, "Save Button");
	}

	public boolean verifyLabelNameOnCollaborationTab(String labelName) {
		boolean isLabelExist = false;
		if (CoreFunctions.isElementByLocatorExist(driver, _linkViewInitiationByLocator, 6)) {
			CoreFunctions.click(driver, _linkViewInitiation, _linkViewInitiation.getText());
		}
		if (CoreFunctions.isElementByLocatorExist(driver, _linkCollaborationApproverByLocator, 6)) {
			CoreFunctions.click(driver, _linkCollaborationApprover, _linkCollaborationApprover.getText());
		}
		switch (labelName) {
		case MobilityXConstants.SUBMITTED:
			if (CoreFunctions.isElementVisible(_textSubmittedApprover)
					&& _textSubmittedApprover.getText().contains(MobilityXConstants.SUBMITTED)) {
				CoreFunctions.highlightObject(driver, _textSubmittedApprover);
				isLabelExist = true;
			}
			break;
		default:
			Assert.fail(MobilityXConstants.NO_ELEMENT_FOUND);
		}
		CoreFunctions.writeMessageToReport(isLabelExist, MobilityXConstants.VERIFY_LABEL_ON_COLLABORATION_TAB,
				MobilityXConstants.FAILED_TO_VERIFY_LABEL_ON_COLLABORATION_TAB, labelName);
		return isLabelExist;
	}

	public void UpdateApproversWorkFlow(String labelName) {

		switch (labelName) {
		case MobilityXConstants.REMOVE_APPROVER:
			int totalApprover = _textApproverList.size();
			if (totalApprover > 1)
				removeApprover(totalApprover);
			break;
		case MobilityXConstants.START_ROUTING:
			if (CoreFunctions.isElementByLocatorExist(driver, _headingApproverWorkflowByLocator,
					MobilityXConstants.CUSTOM_TIME)) {
				CoreFunctions.click(driver, _linkFloatingMenu_StartRouting, _linkFloatingMenu_StartRouting.getText());
				CoreFunctions.waitUntilBrowserReady(driver);
			}
			break;
		case MobilityXConstants.PROCEED_APPROVER:
			CoreFunctions.click(driver, btnProceedForApprovers, MobilityXConstants.PROCEED_APPROVER);
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		case MobilityXConstants.ROUTE_TO_APPROVERS:
			CoreFunctions.click(driver, _linkFloatingMenu_RouteToApprover, MobilityXConstants.ROUTE_TO_APPROVERS);
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		case MobilityXConstants.CONTINUE_INITIATION:
			CoreFunctions.click(driver, linkContinueInitiatiation, MobilityXConstants.PROCEED_APPROVER);
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		case MobilityXConstants.REVIEW_APPROVERS:
			CoreFunctions.click(driver, _linkFloatingMenu_ReviewApprovers, _linkFloatingMenu_ReviewApprovers.getText());
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		default:
			Assert.fail(MobilityXConstants.NO_ELEMENT_FOUND);

		}
	}

	@SuppressWarnings("unused")
	public void verifyApproverWorkFlowPopup(String labelName) {
		boolean isExists = false;
		switch (labelName) {
		case MobilityXConstants.PROCEED_APPROVER:
			CoreFunctions.waitForBrowserToLoad(driver);
			_webElement = _headerApproverIntiation;
			CoreFunctions.explicitWaitTillElementVisibility(driver, _headerApproverIntiation,
					MobilityXConstants.PROCEED_APPROVER);
			isExists = _webElement.getText().contains(MobilityXConstants.HEADER_PROCEED_APPROVER) ? true : false;
		default:
			Assert.fail(MobilityXConstants.NO_ELEMENT_FOUND);

		}
	}

	public void addApprovers(DataTable approverTable, String approverName) {
		java.util.List<java.util.List<String>> approverData = approverTable.raw();
		for (int i = 1; i < approverData.size(); i++) {
			CoreFunctions.waitUntilBrowserReady(driver);
			CoreFunctions.waitHandler(3);
			clickAddanApprover_Link_Button(MobilityXConstants.LINK_ADD_APPROVER);
			fillDetailsOnAddApproverPopUp(approverData.get(i).get(0), approverData.get(i).get(1),
					approverData.get(i).get(2), approverData.get(i).get(3));
			clickAddanApprover_Link_Button(MobilityXConstants.ADD_AN_APPROVER);
			Assert.assertTrue(verifyApproverAdded(approverData.get(i).get(0)),
					approverName + MobilityXConstants.IS_NOT_DISPLAYED);
			CoreFunctions.waitHandler(2);
		}
	}

	public void removeApprover(int totalApprover) {
		for (int i = 0; i < totalApprover - 2; i++) {
			CoreFunctions.waitHandler(2);
			CoreFunctions.hoverAndClick(driver, _linkRemoveFirstApprover, MobilityXConstants.REMOVE_APPROVER);
			CoreFunctions.waitUntilBrowserReady(driver);
		}
	}

	public boolean isStaticApproverExistOnCollaborationTab(DataTable approverTable) {
		boolean isStaticApproverExist = false;
		java.util.List<java.util.List<String>> approverData = approverTable.raw();
		CoreFunctions.scrollVerticallyDownByGivenPixle(driver, 250);
		for (int i = 1; i < approverData.size(); i++) {
			isStaticApproverExist = CoreFunctions.searchElementExistsInListByText(driver, _staticApproverList,
					approverData.get(i).get(0))
					&& CoreFunctions.searchElementExistsInListByText(driver, _staticApproverList,
							approverData.get(i).get(1)) ? true : false;
			if (!isStaticApproverExist) {
				return isStaticApproverExist;
			}
		}
		return isStaticApproverExist;
	}

	public void clickStartRoutingForProxyApprover(String routingType) {
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.scrollVerticallyDownByGivenPixle(driver, -300);
		CoreFunctions.waitHandler(2);
		CoreFunctions.highlightObject(driver, _textRoutingOrder);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _listRadioButtonRoutingOrder, routingType);
		CoreFunctions.click(driver, _linkFloatingMenu_StartRouting, _linkFloatingMenu_StartRouting.getText());
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.click(driver, linkContinueInitiatiation, linkContinueInitiatiation.getText());
	}

	public void processRequestByProxyApprover(String request, String approverComment) {
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.click(driver, _linkApproveAsProxy, _linkApproveAsProxy.getText());
		BusinessFunctions.selectRadioAsPerLabelText(driver, _listProxyApproverRequestTypeRadio, request);
		CoreFunctions.clearAndSetText(driver, _txtboxProxyApproverComment, approverComment);
		switch (request) {
		case "Approve":
			CoreFunctions.click(driver, _buttonSubmitToAires, _buttonSubmitToAires.getText());
			break;
		case "Deny":
			CoreFunctions.click(driver, _buttonSubmit, _buttonSubmit.getText());
			break;
		default:
			Assert.fail(MobilityXConstants.NOT_EXIST);
		}
	}

	public void removeAllApprovers() {
		Log.info("outside loop ist size==" + _listRemoveApprover.size());
		for (int i = _listRemoveApprover.size() - 1; i >= 0; i--) {
			Log.info("insid loop ist size==" + _listRemoveApprover.size());
			Log.info("webelement text==" + _listRemoveApprover.get(i));
			CoreFunctions.hoverAndClick(driver, _listRemoveApprover.get(i), MobilityXConstants.REMOVE_APPROVER);
			if (CoreFunctions.isElementByLocatorExist(driver, _growlMessageByLocator, 25)) {
				driver.findElement(By.className("growl-close")).click();
				CoreFunctions.explicitWaitWithLocatorTillElementDisappears(driver, _closeGrowlMessageByLocator);
			}
		}
	}

	public void checkExistingApproverAndRemove() {
		if (CoreFunctions.isElementByLocatorExist(driver, _listApproversByLocator, 60)) {
			removeAllApprovers();
		}
	}

	public void clickCommentsLink() {
		CoreFunctions.isElementByLocatorExist(driver, _commentsLabel, MobilityXConstants.CUSTOM_TIME);
		driver.findElement(_commentsLabel).click();
	}

	public void addCommentsToContributor(String contributor, String comment) {
		if (CoreFunctions.isElementByLocatorExist(driver, _commentsLabel, 25)) {
			CoreFunctions.waitHandler(8);
			driver.findElement(_commentsLabel).click();
			CoreFunctions.click(driver, _commentLabelText, _commentLabelText.getText());
			CoreFunctions.waitHandler(8);
			driver.findElement(_addACommentLink).click();
			CoreFunctions.click(driver, _linkAddComment, _linkAddComment.getText());
			BusinessFunctions.selectValueFromDropdown(driver, _contributorNameDropdown, contributor);
			CoreFunctions.clearAndSetText(driver, _textareaComments, comment);
			CoreFunctions.click(driver, _commentsSentButton, _commentsSentButton.getText());
			CoreFunctions.waitUntilBrowserReady(driver);
		}
	}

	public void addComments(String approver, String comment) {
		if (CoreFunctions.isElementByLocatorExist(driver, _addViewCommentsLink, 25)) {
			driver.findElement(_addViewCommentsLink).click();
			CoreFunctions.explicitWaitWithLocatorTillElementAppears(driver, _commentsLabel);
			BusinessFunctions.selectValueFromDropdown(driver, _approverNameDropdown, approver);
			CoreFunctions.clearAndSetText(driver, _textareaComments, comment);
			CoreFunctions.click(driver, _commentsSaveButton, _commentsSaveButton.getText());
			CoreFunctions.waitUntilBrowserReady(driver);
		}
	}

	public boolean verifyCommentAdded(String approverComment) {
		CoreFunctions.waitHandler(3);
		List<WebElement> commentsList = CoreFunctions.waitAndReturnListUntilElementsVisible(driver,
				driver.findElements(By.cssSelector("table[id*='icom'] span")));
		for (WebElement e : commentsList) {
			System.out.println("comment value is " + e.getText().replace("\"", "").trim());
		}
		if (CoreFunctions.searchElementExistsInListByText(driver, commentsList, approverComment)) {
			CoreFunctions.explicitWaitAndReturnElement(driver, _commentsCloseIcon).click();
			CoreFunctions.explicitWaitWithLocatorTillElementDisappears(driver, _commentsLabel);
			Reporter.addStepLog("<b>Verified that the Comments were added successfully. </b>");
			return true;
		}
		return false;
	}

	public boolean verifyElementOnWhatNextFloatingMenu(DataTable table) {
		java.util.List<java.util.List<String>> data = table.raw();
		for (int i = 0; i < data.get(0).size(); i++) {
			if (!CoreFunctions.searchElementExistsInListByText(driver, _listWhatNextFloatingMenu, data.get(0).get(i))) {
				return false;
			}
		}
		return true;
	}

	public boolean verifyContributorCommentOnCommentDialog(String contributorComment) {

		CoreFunctions.waitHandler(4);
		CoreFunctions.waitTillElementVisibleWithCustomTime(driver, _commentLabelText, MobilityXConstants.CUSTOM_TIME);
		if (CoreFunctions.searchElementExistsInListByText(driver, _commentslist, contributorComment)) {
			driver.findElement(_commentsLabel).click();
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.VERIFIED_COMMENT_ADDED, CoreConstants.PASS,
					contributorComment));
			return true;
		}
		return false;
	}

	/**
	 * Method to add contributors & Approvers from the data table
	 * 
	 * @param tableData
	 * @return
	 */
	public boolean addContributorsAndApprovers(DataTable tableData) {
		boolean collaboratorAddedSuccessfully = false;
		try {
			List<List<String>> collaboratorsData = tableData.raw();
			for (int counter = 1; counter < collaboratorsData.size(); counter++) {
				addCollaborator(collaboratorsData, counter);
				collaboratorAddedSuccessfully = verifyCollaboratorAdded(collaboratorsData, counter);
				if (!collaboratorAddedSuccessfully) {
					break;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.FAILED_TO_ADD_COLLABORATORS, CoreConstants.FAIL));
		}
		if (collaboratorAddedSuccessfully) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.COLLABORATORS_ADDED_SUCCESSFULLY, CoreConstants.PASS));
		}
		return collaboratorAddedSuccessfully;
	}

	private void addCollaborator(List<List<String>> collaboratorsData, int counter) {
		String collaborator = collaboratorsData.get(counter).get(0);
		switch (collaborator) {
		case MobilityXConstants.CONTRIBUTOR:
			clickAddaContributor_Link_Button(MobilityXConstants.COLLABORATION_TAB);
			BusinessFunctions.selectRadioAsPerLabelText(driver, _radioButtonLabel_AuthorizationType,
					collaboratorsData.get(counter).get(1));
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDwn_contributorName);
			BusinessFunctions.selectValueFromDropdown(driver, _contributorName, collaboratorsData.get(counter).get(1));
			CoreFunctions.clearAndSetText(driver, _txtArea_comments, collaboratorsData.get(counter).get(2));
			clickAddaContributor_Link_Button(MobilityXConstants.ADD_CONTRIBUTOR);
			break;
		case MobilityXConstants.APPROVER:
			CoreFunctions.waitHandler(1);
			clickAddanApprover_Link_Button(MobilityXConstants.LINK_ADD_APPROVER);
			CoreFunctions.clearAndSetText(driver, _txtbox_ApproverName, collaboratorsData.get(counter).get(1));
			CoreFunctions.clearAndSetText(driver, _txtbox_ApproverEmail, collaboratorsData.get(counter).get(3));
			CoreFunctions.clearAndSetText(driver, _txtbox_ApproverJobTitle, collaboratorsData.get(counter).get(4));
			CoreFunctions.clearAndSetText(driver, _txtbox_ApproverComment, collaboratorsData.get(counter).get(2));
			clickAddanApprover_Link_Button(MobilityXConstants.ADD_AN_APPROVER);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _link_addAnApprover, "Add a Approver");
			break;
		default:
			Assert.fail(MobilityXConstants.INVALID_COLLABORATOR);
		}
	}

	private boolean verifyCollaboratorAdded(List<List<String>> collaboratorsData, int counter) {
		boolean collaboratorSuccessfullyVerified = false;
		String collaborator = collaboratorsData.get(counter).get(0);
		switch (collaborator) {
		case MobilityXConstants.CONTRIBUTOR:
			collaboratorSuccessfullyVerified = verifyContributorAdded(collaboratorsData.get(counter).get(1));
			break;
		case MobilityXConstants.APPROVER:
			collaboratorSuccessfullyVerified = verifyApproverAdded(collaboratorsData.get(counter).get(1));
			break;
		default:
			Assert.fail(MobilityXConstants.INVALID_COLLABORATOR);
		}
		return collaboratorSuccessfullyVerified;
	}

	public void setAuthFormRoutingOrder(String routingOrder) {
		try {
			switch (routingOrder) {
			case MobilityXConstants.ROUTE_IN_SEQUENTIAL_ORDER:
				CoreFunctions.clickElement(driver, _radioRouteInSequentialOrder);
				break;
			case MobilityXConstants.SEND_TO_ALL_APPROVERS_AT_ONCE:
				CoreFunctions.clickElement(driver, _radioSendToAllApproverAtOnce);
				break;
			default:
				Assert.fail(MobilityXConstants.INVALID_ROUTING_ORDER);
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_SETTING_ROUTING_ORDER_FOR_APPROVAL_WORKFLOW,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	public boolean verifyInitiationRoutedToApproverWFDialog() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _dialogRoutedSuccessApprovalWF,
					MobilityXConstants.INTIATION_ROUTED_FOR_APPROVAL_WORKFLOW);
			CoreFunctions.waitHandler(2);
			CoreFunctions.verifyText(driver, _textRoutedSuccessApprovalWFHeading,
					MobilityXConstants.INTIATION_ROUTED_FOR_APPROVAL_WF_DIALOG_HEADING
							.replace("FN", CoreFunctions.getPropertyFromConfig("Transferee_firstName"))
							.replace("LN", CoreFunctions.getPropertyFromConfig("Transferee_lastName")),
					MobilityXConstants.INTIATION_ROUTED_FOR_APPROVAL_WORKFLOW);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_INTIATION_ROUTED_FOR_APPROVAL_WORKFLOW_DIALOG,
					CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_INITIATION_ROUTED_TO_APPROVER_WORKFLOW_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public void clickElementOnPage(String element) {
		try {
			switch (element) {
			case MobilityXConstants.CONTINUE_WORKING_ON_THIS_INITIATION:
				CoreFunctions.clickElement(driver, _buttonContinueWorkingOnThisInitiation);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_INITIATION_ROUTED_TO_APPROVER_WORKFLOW_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	public boolean verifyContributorWFCompleted() {
		try {
			if (CoreFunctions.isElementExist(driver, _iconContributorAuthRouteSuccess, 3)) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_CONTRIBUTOR_WORKFLOW_COMPLETED_ON_COLLABORATION_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CONTRIBUTOR_WORKFLOW_COMPLETED_ON_COLLABORATION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyApprovalWFStarted(String expectedApprovalWorkflowStatusText) {
		try {
			if (CoreFunctions.getElementText(driver, _textRoutingForApproval)
					.equals(expectedApprovalWorkflowStatusText)) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_APPROVER_WORKFLOW_STARTED_ON_COLLABORATION_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_APPROVER_WORKFLOW_STARTED_ON_COLLABORATION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyFloatingButtonsPostStartRouting() {
		try {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonCancelRouting, MobilityXConstants.CANCEL_ROUTING);
			CoreFunctions.waitHandler(2);
			if ((CoreFunctions.isElementExist(driver, _buttonCancelRouting, 2))
					&& (CoreFunctions.isElementExist(driver, _floatingButtonSubmitToAires, 2))) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_BUTTONS_DISPLAYED_ON_FLOATING_MENU_POST_START_ROUTING_ON_COLLABORATION_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_BUTTONS_DISPLAYED_ON_FLOATING_MENU_POST_START_ROUTING_ON_COLLABORATION_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyEmailNotificationSentToApprover(String approverName) throws Exception {

		String expectedEmailSubject = "Mobility Initiation for "
				+ (CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT).trim() + " "
						+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT).trim())
				+ " requires your review";
		String approverReceivedEmailText = ((EmailUtil.verifyEmailPresentAndReturnResult(MobilityXConstants.HOST,
				getApproverEmailID(approverName), MobilityXConstants.AUTO_EMAIL_PWD,
				MobilityXConstants.EMAIL_FROM_APPROVAL_REQUEST, expectedEmailSubject,
				MobilityXConstants.MOBILITY_APPROVAL_REQUEST)));

		if (approverReceivedEmailText.equals(MobilityXConstants.EMAIL_NOT_FOUND)) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.EMAIL_NOTIFICATION_NOT_RECEIVED_BY_APPROVER,
					CoreConstants.PASS, approverName));
			return false;
		}

		approverReceivedEmailText = (approverReceivedEmailText.replaceAll("<br>", "")).trim();
		approverReceivedEmailText = (approverReceivedEmailText.replaceAll(",", "")).trim();
		if (approverReceivedEmailText.equals(approverName)) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_EMAIL_NOTIFICATION_RECEIVED_BY_APPROVER,
					CoreConstants.PASS, approverName));
			return true;
		} else
			return false;
	}

	public boolean verifyCFContentsInApproverEmail(String approverName) {
		boolean isCFContentsVerifiedInApproverEmail = false;
		try {
			String expectedEmailSubject = "Mobility Initiation for "
					+ (CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT).trim() + " "
							+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT).trim())
					+ " requires your review";
			isCFContentsVerifiedInApproverEmail = verifyBenefitPointsInAppproverEmail(approverName,
					expectedEmailSubject)
					&& verifyTransfereePolicyDetailsInAppproverEmail(approverName, expectedEmailSubject);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_COREFLEX_ASSIGNMENT_DETAILS_ON_APPROVAL_REQUIRED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCFContentsVerifiedInApproverEmail) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_COREFLEX_ASSIGNMENT_DETAILS_ON_APPROVAL_REQUIRED_EMAIL,
					CoreConstants.PASS, approverName));
		}
		return isCFContentsVerifiedInApproverEmail;
	}

	private boolean verifyTransfereePolicyDetailsInAppproverEmail(String approverName, String expectedEmailSubject) {
		boolean isTransfereePolicyDetailsVerified = false;
		try {
			String transfereeFirstName = EmailUtil.searchEmailAndReturnResult(MobilityXConstants.HOST,
					getApproverEmailID(approverName), MobilityXConstants.AUTO_EMAIL_PWD,
					MobilityXConstants.EMAIL_FROM_APPROVAL_REQUEST, expectedEmailSubject,
					MobilityXConstants.APPROVAL_EMAIL_TRANSFEREE_FIRST_NAME);
			String transfereeLastName = EmailUtil.searchEmailAndReturnResult(MobilityXConstants.HOST,
					getApproverEmailID(approverName), MobilityXConstants.AUTO_EMAIL_PWD,
					MobilityXConstants.EMAIL_FROM_APPROVAL_REQUEST, expectedEmailSubject,
					MobilityXConstants.APPROVAL_EMAIL_TRANSFEREE_LAST_NAME);
			String relocationPolicyName = EmailUtil.searchEmailAndReturnResult(MobilityXConstants.HOST,
					getApproverEmailID(approverName), MobilityXConstants.AUTO_EMAIL_PWD,
					MobilityXConstants.EMAIL_FROM_APPROVAL_REQUEST, expectedEmailSubject,
					MobilityXConstants.APPROVAL_EMAIL_RELOCATION_POLICY);
			CoreFunctions.verifyText(transfereeFirstName, CoreFunctions.getPropertyFromConfig("Transferee_firstName"),
					MobilityXConstants.APPROVAL_EMAIL_TRANSFEREE_FIRST_NAME);
			CoreFunctions.verifyText(transfereeLastName, CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
					MobilityXConstants.APPROVAL_EMAIL_TRANSFEREE_LAST_NAME);
			CoreFunctions.verifyText(relocationPolicyName, CoreFunctions.getPropertyFromConfig("Assignment_Policy"),
					MobilityXConstants.APPROVAL_EMAIL_RELOCATION_POLICY);
			isTransfereePolicyDetailsVerified = true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_TRANSFEREE_AND_POLICY_DETAILS_ON_APPROVAL_REQUIRED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isTransfereePolicyDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_TRANSFEREE_AND_POLICY_DETAILS_ON_APPROVAL_REQUIRED_EMAIL,
					CoreConstants.PASS, approverName));
		}
		return isTransfereePolicyDetailsVerified;
	}

	private boolean verifyBenefitPointsInAppproverEmail(String approverName, String expectedEmailSubject) {
		boolean isBenefitPointsVerified = false;
		try {
			String actualResultBenefitTotalPoints = EmailUtil.searchEmailAndReturnResult(MobilityXConstants.HOST,
					getApproverEmailID(approverName), MobilityXConstants.AUTO_EMAIL_PWD,
					MobilityXConstants.EMAIL_FROM_APPROVAL_REQUEST, expectedEmailSubject,
					MobilityXConstants.APPROVAL_EMAIL_BENEFIT_TOTAL_POINTS_AND_SUBMITTED_POINTS);
			actualResultBenefitTotalPoints = actualResultBenefitTotalPoints.trim();
			String actualResultBenefitPoints[] = actualResultBenefitTotalPoints.split("/");
			CoreFunctions.verifyValue(Double.parseDouble(actualResultBenefitPoints[0].trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")),
					MobilityXConstants.TOTAL_SUBMITTED_POINTS);
			CoreFunctions.verifyValue(Double.parseDouble(actualResultBenefitPoints[1].trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					MobilityXConstants.TOTAL_AVAILABLE_POINTS);
			isBenefitPointsVerified = true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_SUBMITTED_AND_TOTAL_AVAILABLE_BENEFIT_POINTS_ON_APPROVAL_REQUIRED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitPointsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_AND_TOTAL_AVAILABLE_BENEFIT_POINTS_ON_APPROVAL_REQUIRED_EMAIL,
					CoreConstants.PASS, approverName));
		}
		return isBenefitPointsVerified;
	}

	private String getApproverEmailID(String approverName) {
		switch (approverName) {
		case MobilityXConstants.TEST_APPROVER_ONE:
			return "airesautomation@aires.com";
		case MobilityXConstants.TEST_APPROVER_TWO:
			return "airesautomationTransferee@aires.com";
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
		return null;
	}

	public void clickButtonOnApproverEmail(String approverName, String buttonName, TestContext testContext) {
		try {
			switch (buttonName) {
			case MobilityXConstants.SUBMIT_MY_RESPONSE:
				clickSubmitMyResponseButton(approverName, testContext);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_BUTTON_ON_APPROVAL_REQUIRED_EMAIL,
					CoreConstants.FAIL, e.getMessage(), buttonName));
		}
	}

	private void clickSubmitMyResponseButton(String approverName, TestContext testContext) {
		String expectedEmailSubject = "Mobility Initiation for "
				+ (CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT).trim() + " "
						+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT).trim())
				+ " requires your review";
		String submitMyResponseEmailText = EmailUtil.searchEmailAndReturnResult(MobilityXConstants.HOST,
				getApproverEmailID(approverName), MobilityXConstants.AUTO_EMAIL_PWD,
				MobilityXConstants.EMAIL_FROM_APPROVAL_REQUEST, expectedEmailSubject,
				MobilityXConstants.SUBMIT_MY_RESPONSE);
		String submitMyResponseURL = submitMyResponseEmailText.substring(1, submitMyResponseEmailText.length() - 1);
		String submitMyResponseURLArr[] = submitMyResponseURL.split("\" style=\"float:right\"><font color=\"#228EA7\">View Full Details");
		testContext.getWebDriverManager().getDriver().navigate().to(submitMyResponseURLArr[0]);
	}

}
