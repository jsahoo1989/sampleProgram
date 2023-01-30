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
import com.aires.pages.mylo.MyloJourneyPage_PartnerSection;
import com.aires.pages.mylo.MyloJourneyPage_SecondaryContact;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeAndFamilySection;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.aires.utilities.MyloNewFileUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneySecondaryContact_Steps {
	private TestContext _testContext;
	private MyloJourneyPage_SecondaryContact _myloJourneyPage_SecondaryContact;
	private MyloJourneyPage_CreateNewFileSection _myloNewFileSection;
	private MyloJourneyPage_TransfereeSection _myloJourneyPageTransfereeSection;
	private MyloJourneyPage_PartnerSection _myloJourneyPagePartnerSection;
	private MyloJourneyPage_TransfereeAndFamilySection _myloJourneyPageTransfereeAndFamilySection;
	private Mylo_DashboardHomePage _myloDashboardPage;

	public List<String> memberRelation = new ArrayList<String>();
	String firstName;
	String lastName;
	String pronoun;
	String patnerRelation;
	String phoneNumber;
	String phoneType;
	String emailAddress;
	String emailType;

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public MyloJourneySecondaryContact_Steps(TestContext context) {
		_testContext = context;
		_testContext.getMyloPageObjectManager().getDashboardHomePage();
		_testContext.getMyloPageObjectManager().getJourneyPage();
		_testContext.getMyloPageObjectManager().getLoginPage();
		_myloJourneyPage_SecondaryContact = _testContext.getMyloPageObjectManager().getJourneyPageSecondaryContact();
		_myloNewFileSection = _testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
		_myloJourneyPageTransfereeSection = _testContext.getMyloPageObjectManager().getJourneyPageTransfereeSection();
		_myloJourneyPagePartnerSection = _testContext.getMyloPageObjectManager().getJourneyPagePartnerSection();
		_testContext.getMyloPageObjectManager().getJourneyPageOtherSection();
		_testContext.getMyloPageObjectManager().getJourneyPageDependentSection();
		_myloJourneyPageTransfereeAndFamilySection = _testContext.getMyloPageObjectManager()
				.getJourneyPageTransfereeAndFamilySection();
		_myloDashboardPage = _testContext.getMyloPageObjectManager().getDashboardHomePage();
		_myloNewFileSection = _testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();

	}

	/*
	 * @Given("^he is on Mylo Journey Summary page by clicking on \"([^\"]*)\" button on 'Create New File' popup after entering all mandatory fields$"
	 * ) public void
	 * he_is_on_Mylo_Journey_Summary_page_by_clicking_on_button_on_Create_New_File_popup_after_entering_all_mandatory_fields(
	 * String button) {
	 * _myloNewFileSection.createNewFile(MYLOConstants.AUTOMATION_CLIENT_ID); }
	 */
	/*
	 * @Given("^he adds below members in the 'Transferee and Family Details' Section after clicking on \"([^\"]*)\" displayed in the right panel$"
	 * ) public void
	 * he_adds_below_members_in_the_Transferee_and_Family_Details_Section_after_clicking_on_displayed_in_the_right_panel(
	 * String section, DataTable table) { _myloJourneyPageTransfereeSection
	 * .clickFieldsOnTransfereeSection(MYLOConstants.
	 * TRANSFEREE_FAMILY_DETAILS_BUTTON);
	 * Assert.assertTrue(_myloJourneyPageTransfereeSection.verifySectionHeader(
	 * MYLOConstants.TRANSFEREE_FAMILY),
	 * MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED,
	 * CoreConstants.FAIL, MYLOConstants.TRANSFEREE_FAMILY));
	 * _myloJourneyPageTransfereeAndFamilySection.addTransfereeAndFamily(table); }
	 */

	@When("^he clicks on the \"([^\"]*)\" link displayed under the 'Secondary Contact' section after expanding the 'Primary Contact Details' section in the right panel$")
	public void he_clicks_the_link_in_the_Secondary_Contact_module_after_clicking_Primary_Contact_Details_dropdown_arrow_displayed_in_the_right_panel(
			String link) {
		_myloJourneyPage_SecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_SecondaryContact.clickSelectSecondaryContactLink();
		Assert.assertTrue(_myloJourneyPage_SecondaryContact.isSelectSecondaryContactPopupDisplayed(),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP, CoreConstants.FAIL,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));

	}

	@Then("^clicking 'save' buttton on 'Please select a Secondary Contact' popup after selecting the above created members individually should display the contact in 'Secondary Contact' section$")
	public void clicking_save_buttton_after_selecting_above_created_members_individually_should_display_the_contact_in_Secondary_Contact_section() {
		_myloJourneyPage_SecondaryContact.selectAndVerifySecondaryContact();
	}

	@Then("^following warning message should be displayed after replacing the secondary contact with the primary contact upon clicking the 'change' button displayed under \"([^\"]*)\" section$")
	public void by_clicking_on_change_button_on_the_selected_Secondary_Contact_card_below_should_appear_upon_clicking_save_button_after_selecting_primary_contact_on_Please_select_a_Secondary_Contact_popup(
			String section, DataTable table) {
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(1);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPage_SecondaryContact.clickButtonInSecondaryContactCard(MYLOConstants.CHANGE_BUTTON);
		_myloJourneyPage_SecondaryContact.selectPrimaryContactOnSecondaryContactPopup();
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		Assert.assertTrue(_myloJourneyPage_SecondaryContact.isErrorDialogDisplayed(),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP, CoreConstants.FAIL,
						MYLOConstants.SECONDARY_CONTACT_INCORRECT_SELECTION_ERROR));
	}

	@Then("^clicking 'save' buttton after selecting a different member should change the contact in 'Secondary Contact' section$")
	public void clicking_save_buttton_after_selecting_a_different_member_should_change_the_contact_in_Secondary_Contact_section() {
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(1);
		String secondaryContactName = _myloJourneyPage_SecondaryContact.getContactNameOnPopUp(1);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		CoreFunctions.verifyText(
				_myloJourneyPage_SecondaryContact.getSelectedSecondaryContactDetails(MYLOConstants.NAME),
				secondaryContactName, MYLOConstants.SECONDARY_CONTACT_NAME);

	}

	@Given("^he adds members in the 'Transferee and Family Details' Section after clicking on \"([^\"]*)\" displayed in the right panel$")
	public void he_adds_members_in_the_Transferee_and_Family_Details_Section_after_clicking_on_displayed_in_the_right_panel(
			String button) {
		_myloJourneyPageTransfereeSection
				.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		Assert.assertTrue(_myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.TRANSFEREE_FAMILY),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_FAMILY));
		_myloJourneyPageTransfereeAndFamilySection.addPartnerWithMandatoryFields(MYLOConstants.DOMESTIC_PARTNER);
		;
	}

	@Given("^he has clicked 'Save' button after selecting a member on 'Please select Secondary contat' popup in 'Secondary contact' section$")
	public void he_has_clicked_Save_button_after_selecting_a_member_on_Please_select_Secondary_contat_popup_in_Secondary_contact_section() {
		_myloJourneyPage_SecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_SecondaryContact.clickSelectSecondaryContactLink();
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(1);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
	}

	@When("^he clicks on the 'remove' button on the secondary contact card under 'Secondary Contact' section$")
	public void he_clicks_on_the_remove_button_on_the_secondary_contact_card_under_Secondary_Contact_section() {
		_myloJourneyPage_SecondaryContact.clickButtonInSecondaryContactCard(MYLOConstants.REMOVE_BUTTON);
	}

	@Then("^the secondary contact should be removed from the file with the secondary contact section displaying as \"([^\"]*)\"$")
	public void the_secondary_contact_should_be_removed_from_the_file_with_the_secondary_contact_section_displaying_as(
			String link) {
		Assert.assertTrue(_myloJourneyPage_SecondaryContact.isSelectSecondaryContactLinkDisplayed(),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP, CoreConstants.FAIL,
						MYLOConstants.SECONDARY_CONTACT_INCORRECT_SELECTION_ERROR));
	}

	@Then("^the removed contact should still be presented in the 'Transferee & Family' section$")
	public void the_removed_contact_should_still_be_presented_in_the_Transferee_Family_section() {
		_myloJourneyPage_SecondaryContact.clickSelectSecondaryContactLink();
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(1);
		String partnerName = _myloJourneyPage_SecondaryContact.getContactNameOnPopUp(1);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.CANCEL_BUTTON);
		_myloJourneyPagePartnerSection.verifyPartnerExist(partnerName);
	}

	@Then("^below \"([^\"]*)\" should appear upon clicking \"([^\"]*)\" button after selecting primary contact on 'Please select a Secondary Contact' popup displayed by clicking \"([^\"]*)\" link$")
	public void below_should_appear_upon_clicking_button_after_selecting_primary_contact_on_Please_select_a_Secondary_Contact_popup_displayed_by_clicking_link(
			String warningMessage, String button, String link, DataTable table) {

		_myloJourneyPage_SecondaryContact.clickSelectSecondaryContactLink();
		_myloJourneyPage_SecondaryContact.selectPrimaryContactOnSecondaryContactPopup();
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		Assert.assertTrue(_myloJourneyPage_SecondaryContact.isErrorDialogDisplayed(),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP, CoreConstants.FAIL,
						MYLOConstants.SECONDARY_CONTACT_INCORRECT_SELECTION_ERROR));
	}

	@Then("^he should be able to add the removed member again after selecting same member on 'Please select a Secondary Contact' popup$")
	public void he_should_be_able_to_add_the_removed_member_again_after_selecting_same_member_on_Please_select_a_Secondary_Contact_popup() {
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(1);
		String secondaryContactName = _myloJourneyPage_SecondaryContact.getContactNameOnPopUp(1);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		CoreFunctions.verifyText(
				_myloJourneyPage_SecondaryContact.getSelectedSecondaryContactDetails(MYLOConstants.NAME),
				secondaryContactName, MYLOConstants.SECONDARY_CONTACT_NAME);

	}

	@Given("^he adds \"([^\"]*)\" in the 'Transferee and Family Details' Section after clicking on \"([^\"]*)\" displayed in the right panel$")
	public void he_adds_in_the_Transferee_and_Family_Details_Section_after_clicking_on_displayed_in_the_right_panel(
			String member, String button) {
		_myloJourneyPageTransfereeSection
				.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		Assert.assertTrue(_myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.TRANSFEREE_FAMILY),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_FAMILY));
		_myloJourneyPageTransfereeAndFamilySection.addTransfereeAndFamily(member);
	}

	@Given("^he has saved the \"([^\"]*)\" by clicking on \"([^\"]*)\" link under Secondary Contact Section that is displayed by clicking Primary contact details drop down arrow$")
	public void he_has_saved_the_by_clicking_on_link_under_Secondary_Contact_Section_that_is_displayed_by_clicking_Primary_contact_details_drop_down_arrow(
			String member, String link) {
		_myloJourneyPage_SecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_SecondaryContact.clickSelectSecondaryContactLink();
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(1);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
	}

	@Given("^he has saved the 'partner' by clicking on 'change' button on secondary contact card under 'Secondary Contact' details section$")
	public void he_has_saved_the_partner_by_clicking_on_change_button_on_secondary_contact_card_under_Secondary_Contact_details_section() {
		String partnerName = _myloJourneyPageTransfereeAndFamilySection
				.getSavedPartnerName(MYLOConstants.DOMESTIC_PARTNER);
		CoreFunctions.waitHandler(5);
		_myloJourneyPage_SecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_SecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_SecondaryContact.clickSelectSecondaryContactLink();
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(partnerName);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
	}

	@When("^he updates the below fields of the selected \"([^\"]*)\" in the 'Transferee and Family Section' after clicking on \"([^\"]*)\"$")
	public void he_updates_the_below_fields_of_the_selected_member_in_the_Transferee_and_Family_Section_after_clicking_on(
			String member, String button, DataTable table) {
		_myloJourneyPageTransfereeAndFamilySection.updateFields(member,
				_myloJourneyPageTransfereeAndFamilySection.getSavedPartnerName(MYLOConstants.DOMESTIC_PARTNER));
	}

	@Then("^the updated information of the \"([^\"]*)\" should be displayed for the secondary contact in the secondary contact section$")
	public void the_updated_information_of_the_member_should_be_displayed_for_the_secondary_contact_in_the_secondary_contact_section(
			String member) {
		_myloJourneyPage_SecondaryContact.isSelectedSecondaryContactUpdated(member);
	}

	@Then("^the updated information of the 'partner' should be displayed for the secondary contact in the secondary contact section$")
	public void the_updated_information_of_the_partner_should_be_displayed_for_the_secondary_contact_in_the_primary_contact_section() {
		_myloJourneyPage_SecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_SecondaryContact.isSelectedSecondaryContactUpdated(MYLOConstants.PARTNER);
	}

	@Then("^Secondary Contact section should be updated after updating the below fields of selected secondary contact on Transferee and Family members$")
	public void secondary_Contact_section_should_be_updated_after_updating_the_below_fields_of_selected_secondary_contact_on_Transferee_and_Family_members(
			DataTable table) {
		String dependentName = _myloJourneyPageTransfereeAndFamilySection.getSavedDependentName(MYLOConstants.PARENT);
		_myloJourneyPage_SecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_SecondaryContact.clickButtonInSecondaryContactCard(MYLOConstants.CHANGE_BUTTON);
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(dependentName);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.DEPENDENT, dependentName);
		_myloJourneyPage_SecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_SecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_SecondaryContact.isSelectedSecondaryContactUpdated(MYLOConstants.DEPENDENT);

		String otherName = _myloJourneyPageTransfereeAndFamilySection.getSavedOtherName(MYLOConstants.OTHER);
		_myloJourneyPage_SecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_SecondaryContact.clickButtonInSecondaryContactCard(MYLOConstants.CHANGE_BUTTON);
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(otherName);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.OTHER, otherName);
		_myloJourneyPage_SecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_SecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_SecondaryContact.isSelectedSecondaryContactUpdated(MYLOConstants.OTHER);

	}

	@Given("^he is on Mylo Journey Summary page by clicking on \"([^\"]*)\" button on 'Create New File' popup after entering all mandatory fields$")
	public void he_is_on_Mylo_Journey_Summary_page_by_clicking_on_button_on_Create_New_File_popup_after_entering_all_mandatory_fields(
			String button) {

		MyloNewFileUtil.setFileID(CoreFunctions.getPropertyFromConfig("FileID"));
		MyloNewFileUtil.setTransfereeFirstName(CoreFunctions.getPropertyFromConfig(MYLOConstants.TRANSFEREE_FIRSTNAME));
		MyloNewFileUtil.setTransfereeLastName(CoreFunctions.getPropertyFromConfig(MYLOConstants.TRANSFEREE_LASTNAME));
		_myloDashboardPage.selectParameterFromQueryScreen(MYLOConstants.FILE);
		_myloDashboardPage.selectOptionsForFileParameters(MYLOConstants.FILE_ID, MyloNewFileUtil.getFileID());
		_myloDashboardPage.createNewFileIfNotFound(MyloNewFileUtil.getFileID(), MYLOConstants.AUTOMATION_CLIENT_ID,
				_myloNewFileSection);
		_myloJourneyPage_SecondaryContact.verifyAndUpdatePrimaryContact(MyloNewFileUtil.getTransfereeFirstName(),
				MyloNewFileUtil.getTransfereeLastName());
		_myloJourneyPage_SecondaryContact.verifyAndRemoveSecondaryContactIfPresent();
	}

	@Given("^he adds below members in the 'Transferee and Family Details' Section after clicking on \"([^\"]*)\" displayed in the right panel$")
	public void he_adds_below_members_in_the_Transferee_and_Family_Details_Section_after_clicking_on_displayed_in_the_right_panel(
			String section, DataTable table) {
		_myloJourneyPageTransfereeSection
				.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		Assert.assertTrue(_myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.TRANSFEREE_FAMILY),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_FAMILY));
		_myloJourneyPageTransfereeAndFamilySection.verifyAndCreateTransfereeAndFamilyIfNotExist(table,
				_myloDashboardPage, _myloNewFileSection);
	}

	@When("^he views the 'Primary Contact Details' section in the right panel$")
	public void he_views_the_Primary_Contact_Details_section_in_the_right_panel() {
		_myloJourneyPage_SecondaryContact.highlightPrimaryContactSection();
	}

	@Then("^the transferee created during file creation should be visible in the 'Primary Contact Details' section$")
	public void the_transferee_created_during_file_creation_should_be_visible_in_the_Primary_Contact_Details_section() {
		_myloNewFileSection.verifyFileInfoPrimaryContactSection(
				MyloNewFileUtil.getTransfereeFirstName() + " " + MyloNewFileUtil.getTransfereeLastName());
	}

	@Then("^upon clicking 'change' button on primary contact card should display 'Please select a Primary Contact' popup$")
	public void upon_clicking_change_button_on_primary_contact_card_should_display_Please_select_a_Primary_Contact_popup() {
		_myloJourneyPage_SecondaryContact.clickChangeButtonInPrimaryContactCard();
		Assert.assertTrue(_myloJourneyPage_SecondaryContact.isSelectPrimaryContactPopupDisplayed(),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP, CoreConstants.FAIL,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));
	}

	@Then("^clicking 'save' button on 'Please select a Primary Contact' popup after selecting the above created members individually should display the contact in 'Primary Contact' section$")
	public void clicking_save_button_on_Please_select_a_Primary_Contact_popup_after_selecting_the_above_created_members_individually_should_display_the_contact_in_Primary_Contact_section()
			throws Throwable {
		_myloJourneyPage_SecondaryContact.selectAndVerifyPrimaryContact();
	}

	@Given("^he has saved the 'partner' by clicking on 'change' button on primary contact card under 'Primary Contact' details section$")
	public void he_has_saved_the_partner_by_clicking_on_change_button_on_primary_contact_card_under_Primary_Contact_details_section() {
		String partnerName = _myloJourneyPageTransfereeAndFamilySection
				.getSavedPartnerName(MYLOConstants.DOMESTIC_PARTNER);
		_myloJourneyPage_SecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_SecondaryContact.clickChangeButtonInPrimaryContactCard();
		_myloJourneyPage_SecondaryContact.selectPrimaryContactOnPopup(partnerName);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
	}

	@When("^he updates the below fields of the 'partner' in the 'Transferee and Family Section' after clicking on \"([^\"]*)\"$")
	public void he_updates_the_below_fields_of_the_partner_in_the_Transferee_and_Family_Section_after_clicking_on(
			String arg1, DataTable table) {
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.PARTNER,
				_myloJourneyPageTransfereeAndFamilySection.getSavedPartnerName(MYLOConstants.DOMESTIC_PARTNER));
	}

	@Then("^the updated information of the 'partner' should be displayed for the primary contact in the primary contact section$")
	public void the_updated_information_of_the_partner_should_be_displayed_for_the_primary_contact_in_the_primary_contact_section() {
		_myloJourneyPage_SecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_SecondaryContact.isSelectedPrimaryContactUpdated(MYLOConstants.PARTNER);
	}

	@Then("^Primary Contact section should be updated after updating the below fields of selected primary contact on Transferee and Family members$")
	public void primary_Contact_section_should_be_updated_after_updating_the_below_fields_of_selected_primary_contact_on_Transferee_and_Family_members(
			DataTable table) {
		String dependentName = _myloJourneyPageTransfereeAndFamilySection.getSavedDependentName(MYLOConstants.PARENT);
		_myloJourneyPage_SecondaryContact.scrollToPrimaryContactSection();
		_myloJourneyPage_SecondaryContact.clickChangeButtonInPrimaryContactCard();
		_myloJourneyPage_SecondaryContact.selectPrimaryContactOnPopup(dependentName);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.DEPENDENT, dependentName);
		_myloJourneyPage_SecondaryContact.isSelectedPrimaryContactUpdated(MYLOConstants.DEPENDENT);
		String otherName = _myloJourneyPageTransfereeAndFamilySection.getSavedOtherName(MYLOConstants.OTHER);
		_myloJourneyPage_SecondaryContact.clickChangeButtonInPrimaryContactCard();
		_myloJourneyPage_SecondaryContact.selectPrimaryContactOnPopup(otherName);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPageTransfereeAndFamilySection.updateFields(MYLOConstants.OTHER, otherName);
		_myloJourneyPage_SecondaryContact.isSelectedPrimaryContactUpdated(MYLOConstants.OTHER);

	}
}
