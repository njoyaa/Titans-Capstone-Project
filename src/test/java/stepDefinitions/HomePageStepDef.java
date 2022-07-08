package stepDefinitions;

import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.HomePageObj;
import utilities.WebDriverUtilities;

public class HomePageStepDef extends Base {

	HomePageObj home = new HomePageObj();

	@When("User click on Currency")
	public void user_click_on_currency() {
		WebDriverUtilities.wait2();
		logger.info("Clicking on the Currency Button");
		home.clickingOnCurrency();
		WebDriverUtilities.takeScreenShot();
	}

	@When("User Chose Euro from dropdown")
	public void user_chose_euro_from_dropdown() {
//home.chosinCurrency("EUR");
		WebDriverUtilities.wait2();
		logger.info("Clicking on the Euro button");
		home.choosingEuro();
	}

	@Then("currency value should change to Euro")
	public void currency_value_should_change_to_euro() {
		WebDriverUtilities.wait2();
		logger.info("Checking the Currency sign on Homepage");
		home.confirmingEuroSign();
		WebDriverUtilities.takeScreenShot();
	}

//***********************Shopping Cart Scenario*******************************

	@When("User click on shopping cart")
	public void user_click_on_shopping_cart() {
		WebDriverUtilities.wait2();
		logger.info("Clicking on Shopping Cart Button");
		home.clickingOnShoopingCart();
		WebDriverUtilities.wait2();
	}

	@Then("“Your shopping cart is empty!” message should display")
	public void your_shopping_cart_is_empty_message_should_display() {
		WebDriverUtilities.wait2();
		logger.info("Checking the empty Shopping Cart message");
		home.confirmingEmptyShoppingCart();
		WebDriverUtilities.wait2();
		WebDriverUtilities.takeScreenShot();
	}
}
