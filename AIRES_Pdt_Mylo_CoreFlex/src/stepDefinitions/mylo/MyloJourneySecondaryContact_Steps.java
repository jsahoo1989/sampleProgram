package stepDefinitions.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.MyloJourneyPage_DependentSection;
import com.aires.pages.mylo.MyloJourneyPage_OtherSection;
import com.aires.pages.mylo.MyloJourneyPage_PartnerSection;
import com.aires.pages.mylo.MyloJourneyPage_SecondaryContact;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeAndFamilySection;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.testdatatypes.mylo.Mylo_LoginData;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloJourneySecondaryContact_Steps {
	private TestContext _testContext;
	private Mylo_DashboardHomePage _myloDashboardPage;
	private Mylo_JourneyPage _myloJourneyPage;
	private Mylo_LoginPage _loginPage;
	private MyloJourneyPage_SecondaryContact _myloJourneyPage_SecondaryContact;
	private MyloJourneyPage_CreateNewFileSection _myloNewFileSection;
	private MyloJourneyPage_TransfereeSection _myloJourneyPageTransfereeSection;
	private MyloJourneyPage_PartnerSection _myloJourneyPagePartnerSection;
	private MyloJourneyPage_OtherSection _myloJourneyPageOtherSection;
	private MyloJourneyPage_DependentSection _myloJourneyPageDependentSection;
	private MyloJourneyPage_TransfereeAndFamilySection _myloJourneyPageTransfereeAndFamilySection;

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
		_myloDashboardPage = _testContext.getMyloPageObjectManager().getDashboardHomePage();
		_myloJourneyPage = _testContext.getMyloPageObjectManager().getJourneyPage();
		_loginPage = _testContext.getMyloPageObjectManager().getLoginPage();
		_myloJourneyPage_SecondaryContact = _testContext.getMyloPageObjectManager().getJourneyPageSecondaryContact();
		_myloNewFileSection = _testContext.getMyloPageObjectManager().getJourneyPageCreateNewFileSection();
		_myloJourneyPageTransfereeSection = _testContext.getMyloPageObjectManager().getJourneyPageTransfereeSection();
		_myloJourneyPagePartnerSection = _testContext.getMyloPageObjectManager().getJourneyPagePartnerSection();
		_myloJourneyPageOtherSection = _testContext.getMyloPageObjectManager().getJourneyPageOtherSection();
		_myloJourneyPageDependentSection = _testContext.getMyloPageObjectManager().getJourneyPageDependentSection();
		_myloJourneyPageTransfereeAndFamilySection = _testContext.getMyloPageObjectManager()
				.getJourneyPageTransfereeAndFamilySection();
	}

	@Given("^he is on Mylo Journey Summary page by clicking on \"([^\"]*)\" button on 'Create New File' popup after entering all mandatory fields$")
	public void he_is_on_Mylo_Journey_Summary_page_by_clicking_on_button_on_Create_New_File_popup_after_entering_all_mandatory_fields(
			String button) {
		_myloNewFileSection.createNewFile(MYLOConstants.AUTOMATION_CLIENT_ID);
	}

	@Given("^he adds below members in the 'Transferee and Family Details' Section after clicking on \"([^\"]*)\" displayed in the right panel$")
	public void he_adds_below_members_in_the_Transferee_and_Family_Details_Section_after_clicking_on_displayed_in_the_right_panel(
			String section, DataTable table) {
		_myloJourneyPageTransfereeSection
				.clickFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON);
		Assert.assertTrue(_myloJourneyPageTransfereeSection.verifySectionHeader(MYLOConstants.TRANSFEREE_FAMILY),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL,
						MYLOConstants.TRANSFEREE_FAMILY));
		_myloJourneyPageTransfereeAndFamilySection.addTransfereeAndFamily(table);
	}

	@When("^he clicks the \"([^\"]*)\" link in the 'Secondary Contact' module after clicking 'Primary Contact Details' dropdown arrow displayed in the right panel$")
	public void he_clicks_the_link_in_the_Secondary_Contact_module_after_clicking_Primary_Contact_Details_dropdown_arrow_displayed_in_the_right_panel(
			String link) {
		_myloJourneyPage_SecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_SecondaryContact.clickSelectSecondaryContactLink();
		Assert.assertTrue(_myloJourneyPage_SecondaryContact.isSelectSecondaryContactPopupDisplayed(),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP, CoreConstants.FAIL,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));

	}

	@Then("^clicking 'save' buttton after selecting above created members individually should display the contact in 'Secondary Contact' section$")
	public void clicking_save_buttton_after_selecting_above_created_members_individually_should_display_the_contact_in_Secondary_Contact_section() {
		_myloJourneyPage_SecondaryContact.selectAndVerifySecondaryContact();
	}

	@Then("^by clicking on 'change' button on the selected Secondary Contact card below \"([^\"]*)\" should appear upon clicking 'save' button after selecting primary contact on 'Please select a Secondary Contact' popup$")
	public void by_clicking_on_change_button_on_the_selected_Secondary_Contact_card_below_should_appear_upon_clicking_save_button_after_selecting_primary_contact_on_Please_select_a_Secondary_Contact_popup(
			String button, DataTable table) {
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(1);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectSecondaryContactDialog(MYLOConstants.SUBMIT_BUTTON);
		_myloJourneyPage_SecondaryContact.clickChangeButton();
		_myloJourneyPage_SecondaryContact.selectPrimaryContactOnSecondaryContactPopup();
		_myloJourneyPage_SecondaryContact.clickButtonInSelectSecondaryContactDialog(MYLOConstants.SUBMIT_BUTTON);
		Assert.assertTrue(_myloJourneyPage_SecondaryContact.isErrorDialogDisplayed(),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP, CoreConstants.FAIL,
						MYLOConstants.SECONDARY_CONTACT_INCORRECT_SELECTION_ERROR));
	}

	@Then("^clicking 'save' buttton after selecting a different member should change the contact in 'Secondary Contact' section$")
	public void clicking_save_buttton_after_selecting_a_different_member_should_change_the_contact_in_Secondary_Contact_section() {
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(1);
		String secondaryContactName = _myloJourneyPage_SecondaryContact.getContactNameOnPopUp(1);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectSecondaryContactDialog(MYLOConstants.SUBMIT_BUTTON);
		CoreFunctions.verifyText(_myloJourneyPage_SecondaryContact.getSelectedSecondaryContactName(),
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
		_myloJourneyPageTransfereeAndFamilySection.addPartnerWithMandatoryFields(MYLOConstants.DOMESTIC_PARTNER);;
	}

	@Given("^he has clicked 'Save' button after selecting a member on 'Please select Secondary contat' popup in 'Secondary contact' section$")
	public void he_has_clicked_Save_button_after_selecting_a_member_on_Please_select_Secondary_contat_popup_in_Secondary_contact_section() {
		_myloJourneyPage_SecondaryContact.expandPrimaryContactDetailsSection();
		_myloJourneyPage_SecondaryContact.clickSelectSecondaryContactLink();
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(1);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectSecondaryContactDialog(MYLOConstants.SUBMIT_BUTTON);
	}

	@When("^he clicks on the 'remove' button on the secondary contact card under 'Secondary Contact' section$")
	public void he_clicks_on_the_remove_button_on_the_secondary_contact_card_under_Secondary_Contact_section() {
		_myloJourneyPage_SecondaryContact.clickRemoveButton();
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
		Assert.assertTrue(_myloJourneyPagePartnerSection.isPartnerExist());
	}

	@Then("^below \"([^\"]*)\" should appear upon clicking \"([^\"]*)\" button after selecting primary contact on 'Please select a Secondary Contact' popup displayed by clicking \"([^\"]*)\" link$")
	public void below_should_appear_upon_clicking_button_after_selecting_primary_contact_on_Please_select_a_Secondary_Contact_popup_displayed_by_clicking_link(
			String warningMessage, String button, String link, DataTable table) {

		_myloJourneyPage_SecondaryContact.clickSelectSecondaryContactLink();
		_myloJourneyPage_SecondaryContact.selectPrimaryContactOnSecondaryContactPopup();
		_myloJourneyPage_SecondaryContact.clickButtonInSelectSecondaryContactDialog(MYLOConstants.SUBMIT_BUTTON);
		Assert.assertTrue(_myloJourneyPage_SecondaryContact.isErrorDialogDisplayed(),
				MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_POPUP, CoreConstants.FAIL,
						MYLOConstants.SECONDARY_CONTACT_INCORRECT_SELECTION_ERROR));
	}

	@Then("^he should be able to add the removed member again after selecting same member on 'Please select a Secondary Contact' popup$")
	public void he_should_be_able_to_add_the_removed_member_again_after_selecting_same_member_on_Please_select_a_Secondary_Contact_popup() {
		_myloJourneyPage_SecondaryContact.selectSecondaryContactOnPopup(1);
		String secondaryContactName = _myloJourneyPage_SecondaryContact.getContactNameOnPopUp(1);
		_myloJourneyPage_SecondaryContact.clickButtonInSelectSecondaryContactDialog(MYLOConstants.SUBMIT_BUTTON);
		CoreFunctions.verifyText(_myloJourneyPage_SecondaryContact.getSelectedSecondaryContactName(),
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
		_myloJourneyPage_SecondaryContact.clickButtonInSelectSecondaryContactDialog(MYLOConstants.SUBMIT_BUTTON);
	}

	@When("^he updates the below fields of the selected \"([^\"]*)\" in the 'Transferee and Family Section' after clicking on \"([^\"]*)\"$")
	public void he_updates_the_below_fields_of_the_selected_member_in_the_Transferee_and_Family_Section_after_clicking_on(
			String member, String button, DataTable table) {
		_myloJourneyPageTransfereeAndFamilySection.updateFields(member, table);
	}

	@Then("^the updated information of the \"([^\"]*)\" should be displayed for the secondary contact in the secondary contact section$")
	public void the_updated_information_of_the_member_should_be_displayed_for_the_secondary_contact_in_the_secondary_contact_section(
			String member) {
		_myloJourneyPage_SecondaryContact.isSelectedSecondaryContactUpdated(member);

	}

}
