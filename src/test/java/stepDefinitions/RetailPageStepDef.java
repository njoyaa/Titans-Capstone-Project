package stepDefinitions;

import java.util.List;
import java.util.Map;

import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.RetailPageObj;
import utilities.WebDriverUtilities;

public class RetailPageStepDef extends Base {
	RetailPageObj mainPage = new RetailPageObj();

	@Given("User is on Retail website")
	public void user_is_on_retail_website() {
		mainPage.retail_page();
		sleep();
		WebDriverUtilities.takeScreenShot();
	}

	@And("User click on MyAccount")
	public void user_click_on_my_account() {
		mainPage.user_click_on_myAcc();
		sleep();
	}

	@When("User click on Login")
	public void user_click_on_login() {
		sleep();
		mainPage.loginOption();
	}

	@And("User enter username {string} and password {string}")
	public void user_enter_username_and_password(String emailV, String pasV) {
		mainPage.emailPassInput(emailV, pasV);
		sleep();
		WebDriverUtilities.takeScreenShot();
	}

	@And("User click on Login button")
	public void user_click_on_login_button() {
		mainPage.loginButtonClick();
		sleep();
	}

	@Then("User should be logged in to MyAccount dashboard")
	public void user_should_be_logged_in_to_my_account_dashboard() {
		mainPage.accountDashboard();
		WebDriverUtilities.takeScreenShot();

	}

	// **********************Register for Affiliate Scenario*************

	@When("User click on ‘Register for an Affiliate Account’ link")
	public void user_click_on_register_for_an_affiliate_account_link() {
		mainPage.registerForAffiliate();
		WebDriverUtilities.takeScreenShot();
	}

	@When("User fill affiliate form with below information")
	public void user_fill_affiliate_form_with_below_information(DataTable datatable) {
		List<Map<String, String>> information = datatable.asMaps(String.class, String.class);
		mainPage.companyInput.sendKeys(information.get(0).get("company"));
		mainPage.websiteInput.sendKeys(information.get(0).get("website"));
		mainPage.taxInput.sendKeys(information.get(0).get("taxID"));
		mainPage.paypalInput.sendKeys(information.get(0).get("paymentMethod"));
		mainPage.chequeInput.sendKeys(information.get(0).get("PayeeName"));
		sleep();
		WebDriverUtilities.takeScreenShot();
	}

	@When("User check on About us check box")
	public void user_check_on_about_us_check_box() {
		mainPage.checkBoxClick();
		sleep();
	}

	@When("User click on Continue button")
	public void user_click_on_continue_button() {
		sleep();
		mainPage.continueClick();
	}

	@Then("User should see a success Message")
	public void user_should_see_a_success_message() {
		mainPage.successMessageValidation();
		WebDriverUtilities.takeScreenShot();
	}

	public static void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//**********************Edit Affiliate Scenario*************

	@When("User click on ‘Edit your affiliate informationlink")
	public void user_click_on_edit_your_affiliate_informationlink() {
		mainPage.editAffiliateInfo();
		sleep();
	}

	@When("user click on Bank Transfer radio button")
	public void user_click_on_bank_transfer_radio_button() {
		mainPage.bankAccountOption();
		sleep();
	}

	@When("User fill Bank information with below information")
	public void user_fill_bank_information_with_below_information(DataTable datatable) {
		List<Map<String, String>> bankInformation = datatable.asMaps(String.class, String.class);
		mainPage.bankName.clear();
		mainPage.bankName.sendKeys(bankInformation.get(0).get("bankName"));
		mainPage.bankBranchName.clear();
		mainPage.bankBranchName.sendKeys(bankInformation.get(0).get("branch"));
		mainPage.BankSwiftCode.clear();
		mainPage.BankSwiftCode.sendKeys(bankInformation.get(0).get("swiftCode"));
		mainPage.BankAccName.clear();
		mainPage.BankAccName.sendKeys(bankInformation.get(0).get("accountName"));
		mainPage.BankAccNumber.clear();
		mainPage.BankAccNumber.sendKeys(bankInformation.get(0).get("accountNumber"));
		WebDriverUtilities.takeScreenShot();
		sleep();
	}

	@And("User click on continue button")
	public void user_click_on_continue_button_Update() {
		mainPage.continueClick();
	}

	@Then("User should see A Success message")
	public void user_should_see_success_message() {
		mainPage.successMessageValidation();
		sleep();
	}

	// **********************Edit information Scenario*************

	@When("User click on ‘Edit your account information’ link")
	public void user_click_on_edit_your_account_information_link() {
		mainPage.editAccountInfo();
		sleep();
	}

	@When("User modify below information")
	public void user_modify_below_information(DataTable datatable) {
		List<Map<String, String>> personalInfo = datatable.asMaps(String.class, String.class);
		mainPage.firstNameInput.clear();
		mainPage.firstNameInput.sendKeys(personalInfo.get(0).get("firstName"));
		mainPage.lastNameInput.clear();
		mainPage.lastNameInput.sendKeys(personalInfo.get(0).get("lastName"));
		mainPage.newEmailInput.clear();
		mainPage.newEmailInput.sendKeys(personalInfo.get(0).get("email"));
		mainPage.telephoneInput.clear();
		mainPage.telephoneInput.sendKeys(personalInfo.get(0).get("telephone"));
		WebDriverUtilities.takeScreenShot();
		sleep();
	}

	@When("User click on (continue*-) button")
	public void user_click_on_continue_button1() {
		sleep();
		mainPage.continueClick();
	}

	@Then("User should See a message ‘Success: Your account has been successfully updated.’")
	public void user_should_see_a_message_success_your_account_has_been_successfully_updated() {
		mainPage.successMessageValidation();
		WebDriverUtilities.takeScreenShot();
		sleep();
	}
}
