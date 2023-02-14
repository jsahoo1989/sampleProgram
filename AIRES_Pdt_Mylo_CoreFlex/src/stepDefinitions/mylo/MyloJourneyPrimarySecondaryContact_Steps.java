package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.MyloJourneyPage_PrimarySecondaryContact;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeAndFamilySection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.aires.utilities.CustomSoftAssert;
import com.aires.utilities.MyloNewFileUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneyPrimarySecondaryContact_Steps {
	private TestContext _testContext;
	private Mylo_LoginPage _loginPage;
	private Mylo_DashboardHomePage _myloDashboardPage;
	private MyloJourneyPage_PrimarySecondaryContact _myloJourneyPage_PrimarySecondaryContact;
	private MyloJourneyPage_CreateNewFileSection _myloNewFileSection;
	private MyloJourneyPage_TransfereeAndFamilySection _myloJourneyPageTransfereeAndFamilySection;
	private CustomSoftAssert _softAssert;
	private List<String> _transfereeNames = new ArrayList<String>();

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloJourneyPrimarySecondaryContact_Steps(TestContext context) {
		_testContext = context;
		_testContext.getMyloPageObjectManager().getDashboardHomePage();
		_testContext.getMyloPageObjectManager().getJourneyPage();
		_testContext.getMyloPageObjectManager().getLoginPage();
		_loginPage = _testContext.getMyloPageObjectManager().getLoginPage();
		_myloJourneyPage_PrimarySecondaryContact = _testContext.getMyloPageObjectManager()
				.getJourneyPagePrimarySecondaryContact();
		_myloNewFileSection = _testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
		_testContext.getMyloPageObjectManager().getJourneyPageOtherSection();
		_testContext.getMyloPageObjectManager().getJourneyPageDependentSection();
		_myloJourneyPageTransfereeAndFamilySection = _testContext.getMyloPageObjectManager()
				.getJourneyPageTransfereeAndFamilySection();
		_myloDashboardPage = _testContext.getMyloPageObjectManager().getDashboardHomePage();
		_softAssert = _testContext.getSoftAssertObject();
	}

	@Given("^he is on Home Page after successfully logging into the 'Mylo' application$")
	public void he_is_on_Home_Page_after_successfully_logging_into_the_Mylo_application() throws InterruptedException {
		_loginPage.openApplication();
		_loginPage.enterUserEmailAndPasswordForMylo(loginData.MyloUserName, loginData.MyloPassword);
		_loginPage.clickSignIn();
		Assert.assertTrue(_myloDashboardPage.verifyUserName(loginData.MyloProfileName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						loginData.MyloProfileName, MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}

	@Given("^Transferee name is displayed as a primary contact for a newly created file on Journey Summary page$")
	public void transferee_name_is_displayed_as_a_primary_contact_for_a_newly_created_file_on_Journey_Summary_page() {
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.NEW_FILE_BUTTON);
		_myloNewFileSection.createNewFile(MYLOConstants.AUTOMATION_CLIENT_ID);
		CoreFunctions.writeToPropertiesFile(MYLOConstants.FILE_ID, MyloNewFileUtil.getFileID());
		_softAssert.assertTrue(
				_myloJourneyPage_PrimarySecondaryContact.verifySelectedPrimaryContactName(
						MyloNewFileUtil.getTransfereeFirstName() + " " + MyloNewFileUtil.getTransfereeLastName()),
				MessageFormat.format(CoreConstants.FAILED_TO_VERFY, CoreConstants.FAIL,
						MYLOConstants.PRIMARY_CONTACT_NAME));
	}

	@Given("^he adds below members in the 'Transferee and Family Details' section after clicking on 'Transferee and Family Drop down arrow' displayed in the right panel$")
	public void he_adds_below_members_in_the_Transferee_and_Family_Details_section_after_clicking_on_displayed_in_the_right_panel(
			DataTable table) {
		_myloJourneyPageTransfereeAndFamilySection.expandTransfereeDetailsSection();
		_myloJourneyPageTransfereeAndFamilySection.addTransfereeAndFamily(table);
		_transfereeNames = _myloJourneyPageTransfereeAndFamilySection.getSavedTransfereeMemberList(table);
	}

	@When("^he clicks on change button available under primary contact section on journey summary page$")
	public void he_clicks_on_change_button_available_under_primary_contact_section_on_journey_summary_page() {
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.clickChangeButtonInPrimaryContactCard();
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectPrimaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP));
	}

	@Then("^all the added transferee and family members should be displayed on 'Please select a Primary Contact' popup$")
	public void all_added_transferee_and_family_members_should_be_displayed_on_Please_select_a_Primary_Contact_popup() {
		_myloJourneyPage_PrimarySecondaryContact.verifyMembersPresentOnPopup(_transfereeNames, _softAssert);
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.CANCEL_BUTTON);
	}

	@Then("^all the added transferee and family members should be displayed on 'Please select a Secondary Contact' popup after clicking on \"([^\"]*)\" link displayed under the 'Secondary Contact' section$")
	public void all_added_transferee_and_family_members_should_be_displayed_on_Please_select_a_Secondary_Contact_popup_after_clicking_on_link_displayed_under_the_Secondary_Contact_section(
			String linkName) {
		_myloJourneyPage_PrimarySecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_PrimarySecondaryContact.clickSelectSecondaryContactLink();
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectSecondaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));
		_myloJourneyPage_PrimarySecondaryContact.verifyMembersPresentOnPopup(_transfereeNames, _softAssert);
	}

	@Given("^he is on Mylo Journey Summary page for an existing file with all transferee and family members$")
	public void he_is_on_mylo_journey_summary_page_for_an_existing_file_with_all_transferee_and_family_members() {
		_myloDashboardPage.clickOptionFromMainMenu(MYLOConstants.JOURNEY);
		_myloDashboardPage.selectOptionsFromAssignmentMenu(MYLOConstants.QUERY_FILE);
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, _myloNewFileSection.getFileID());
		_myloDashboardPage.clickExecuteButton();
	}

	@Then("^primary contact section should be updated after updating the below fields on selecting all the transferee and family members sucessively$")
	public void primary_contact_section_should_be_updated_after_updating_the_below_fields_on_selecting_all_the_transferee_and_family_members_sucessviely(
			DataTable table) {
		_myloJourneyPageTransfereeAndFamilySection.expandTransfereeDetailsSection();

		String partnerName = _myloJourneyPageTransfereeAndFamilySection
				.getSavedTransfereeMemberName(MYLOConstants.DOMESTIC_PARTNER, MYLOConstants.PARTNER);
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.clickChangeButtonInPrimaryContactCard();
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectPrimaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP));
		_myloJourneyPage_PrimarySecondaryContact.selectPrimaryContactOnPopup(partnerName, _softAssert);
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.PARTNER, partnerName, table);
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.verifySelectedPartnerMemberUpdated(MYLOConstants.PRIMARY_CONTACT,
				_softAssert);
		_myloJourneyPageTransfereeAndFamilySection.updateRandomPartnerRelationship(MYLOConstants.DOMESTIC_PARTNER);
		_myloJourneyPageTransfereeAndFamilySection.scrollToSection(MYLOConstants.PARTNER);
		_myloJourneyPageTransfereeAndFamilySection.clickSaveInEditMember();
		_myloJourneyPageTransfereeAndFamilySection.closeEditModeInTransfereeSection(MYLOConstants.PARTNER);

		String dependentName = _myloJourneyPageTransfereeAndFamilySection
				.getSavedTransfereeMemberName(MYLOConstants.PARENT, MYLOConstants.DEPENDENT);
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.clickChangeButtonInPrimaryContactCard();
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectPrimaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP));
		_myloJourneyPage_PrimarySecondaryContact.selectPrimaryContactOnPopup(dependentName, _softAssert);
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.DEPENDENT, dependentName, table);
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.verifySelectedDependentMemberUpdated(MYLOConstants.PRIMARY_CONTACT,
				_softAssert);
		_myloJourneyPageTransfereeAndFamilySection.updateRandomDependentRelationship(MYLOConstants.PARENT);
		_myloJourneyPageTransfereeAndFamilySection.scrollToSection(MYLOConstants.DEPENDENT);
		_myloJourneyPageTransfereeAndFamilySection.clickSaveInEditMember();
		_myloJourneyPageTransfereeAndFamilySection.closeEditModeInTransfereeSection(MYLOConstants.DEPENDENT);

		String otherName = _myloJourneyPageTransfereeAndFamilySection.getSavedTransfereeMemberName(MYLOConstants.OTHER,
				MYLOConstants.OTHER);
		_myloJourneyPage_PrimarySecondaryContact.clickChangeButtonInPrimaryContactCard();
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectPrimaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP));
		_myloJourneyPage_PrimarySecondaryContact.selectPrimaryContactOnPopup(otherName, _softAssert);
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.OTHER, otherName, table);
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.verifySelectedOtherMemberUpdated(MYLOConstants.PRIMARY_CONTACT,
				_softAssert);
		_myloJourneyPageTransfereeAndFamilySection.updateOtherMemberRelationship(MYLOConstants.OTHER);
		_myloJourneyPageTransfereeAndFamilySection.scrollToSection(MYLOConstants.OTHER);
		_myloJourneyPageTransfereeAndFamilySection.clickSaveInEditMember();
		_myloJourneyPageTransfereeAndFamilySection.closeEditModeInTransfereeSection(MYLOConstants.OTHER);

	}

	@Then("^secondary contact section should be updated after updating the below fields on selecting all the transferee and family members sucessively$")
	public void secondary_contact_section_should_be_updated_after_updating_the_below_fields_on_selecting_all_the_transferee_and_family_members_sucessively(
			DataTable table) {
		_myloJourneyPage_PrimarySecondaryContact.verifyAndUpdatePrimaryContact(
				_myloJourneyPageTransfereeAndFamilySection.getSavedTransfereeName(), _softAssert);

		_myloJourneyPageTransfereeAndFamilySection.expandTransfereeDetailsSection();

		String partnerName = _myloJourneyPageTransfereeAndFamilySection
				.getSavedTransfereeMemberName(MYLOConstants.DOMESTIC_PARTNER, MYLOConstants.PARTNER);
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_PrimarySecondaryContact.clickSelectSecondaryContactLink();
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectSecondaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));
		_myloJourneyPage_PrimarySecondaryContact.selectSecondaryContactOnPopup(partnerName, _softAssert);
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.PARTNER, partnerName, table);
		_myloJourneyPage_PrimarySecondaryContact.verifySelectedPartnerMemberUpdated(MYLOConstants.SECONDARY_CONTACT,
				_softAssert);
		_myloJourneyPageTransfereeAndFamilySection.updateRandomPartnerRelationship(MYLOConstants.DOMESTIC_PARTNER);
		_myloJourneyPageTransfereeAndFamilySection.scrollToSection(MYLOConstants.PARTNER);
		_myloJourneyPageTransfereeAndFamilySection.clickSaveInEditMember();
		_myloJourneyPageTransfereeAndFamilySection.closeEditModeInTransfereeSection(MYLOConstants.PARTNER);

		String dependentName = _myloJourneyPageTransfereeAndFamilySection
				.getSavedTransfereeMemberName(MYLOConstants.PARENT, MYLOConstants.DEPENDENT);
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSecondaryContactCard(MYLOConstants.CHANGE_BUTTON);
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectSecondaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));
		_myloJourneyPage_PrimarySecondaryContact.selectSecondaryContactOnPopup(dependentName, _softAssert);
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.DEPENDENT, dependentName, table);
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_PrimarySecondaryContact.verifySelectedDependentMemberUpdated(MYLOConstants.SECONDARY_CONTACT,
				_softAssert);
		_myloJourneyPageTransfereeAndFamilySection.updateRandomDependentRelationship(MYLOConstants.PARENT);
		_myloJourneyPageTransfereeAndFamilySection.scrollToSection(MYLOConstants.DEPENDENT);
		_myloJourneyPageTransfereeAndFamilySection.clickSaveInEditMember();
		_myloJourneyPageTransfereeAndFamilySection.closeEditModeInTransfereeSection(MYLOConstants.DEPENDENT);

		String otherName = _myloJourneyPageTransfereeAndFamilySection.getSavedTransfereeMemberName(MYLOConstants.OTHER,
				MYLOConstants.OTHER);
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSecondaryContactCard(MYLOConstants.CHANGE_BUTTON);
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectSecondaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));
		_myloJourneyPage_PrimarySecondaryContact.selectSecondaryContactOnPopup(otherName, _softAssert);
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.OTHER, otherName, table);
		_myloJourneyPage_PrimarySecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_PrimarySecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_PrimarySecondaryContact.verifySelectedOtherMemberUpdated(MYLOConstants.SECONDARY_CONTACT,
				_softAssert);
		_myloJourneyPageTransfereeAndFamilySection.updateOtherMemberRelationship(MYLOConstants.OTHER);
		_myloJourneyPageTransfereeAndFamilySection.scrollToSection(MYLOConstants.OTHER);
		_myloJourneyPageTransfereeAndFamilySection.clickSaveInEditMember();
		_myloJourneyPageTransfereeAndFamilySection.closeEditModeInTransfereeSection(MYLOConstants.OTHER);

	}

	@When("^he selects same contact on \"([^\"]*)\" popup which is already selected on primary contact Section$")
	public void he_selects_same_contact_on_popup_which_is_already_selected_on_primary_contact_Section(
			String popupName) {
		String _transfereeName = _myloJourneyPageTransfereeAndFamilySection.getSavedTransfereeName();
		_myloJourneyPage_PrimarySecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_PrimarySecondaryContact.verifyAndRemoveSecondaryContactIfPresent();
		_myloJourneyPage_PrimarySecondaryContact.clickSelectSecondaryContactLink();
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectSecondaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));
		_myloJourneyPage_PrimarySecondaryContact.selectSecondaryContactOnPopup(_transfereeName, _softAssert);
	}

	@Then("^warning message should appear after clicking save button on \"([^\"]*)\" popup$")
	public void warning_message_should_appear_after_clicking_save_button_on_popup(String popupName) {
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPage_PrimarySecondaryContact.verifySecondaryErrorDialogDisplayed();
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.CANCEL_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.expandTransfereeDetailsSection();
	}

	@Then("^warning message should appear if he tries to select same contact on \"([^\"]*)\" popup which is already selected on primary secondary Section$")
	public void warning_message_should_appear_if_he_tries_to_select_same_contact_on_popup_which_is_already_selected_on_primary_secondary_Section(
			String popupName) {
		String partnerName = _myloJourneyPageTransfereeAndFamilySection
				.getSavedTransfereeMemberName(MYLOConstants.DOMESTIC_PARTNER, MYLOConstants.PARTNER);
		_myloJourneyPage_PrimarySecondaryContact.clickSelectSecondaryContactLink();
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectSecondaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));
		_myloJourneyPage_PrimarySecondaryContact.selectSecondaryContactOnPopup(partnerName, _softAssert);
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);

		_myloJourneyPage_PrimarySecondaryContact.clickChangeButtonInPrimaryContactCard();
		Assert.assertTrue(_myloJourneyPage_PrimarySecondaryContact.isSelectPrimaryContactPopupDisplayed(),
				MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
						MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP));
		_myloJourneyPage_PrimarySecondaryContact.selectPrimaryContactOnPopup(partnerName, _softAssert);
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPage_PrimarySecondaryContact.verifyPrimaryErrorDialogDisplayed();
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.CANCEL_BUTTON);
	}

	@Then("^he should be able to remove the secondary contact by clicking remove on Secondary Contact Card$")
	public void clicking_change_button_on_secondary_contact_card_should_remove_the_contact_from_Secondary_Contact_section() {
		_myloJourneyPage_PrimarySecondaryContact.clickButtonInSecondaryContactCard(MYLOConstants.REMOVE_BUTTON);
		_myloJourneyPage_PrimarySecondaryContact.verifySelectSecondaryContactLinkDisplayed();
	}

}