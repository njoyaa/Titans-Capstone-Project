
package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page.objects.DesktopPageObj;
import utilities.WebDriverUtilities;

public class DesktopPageStepDef extends Base {
	DesktopPageObj desktop = new DesktopPageObj();

	@When("User click on Desktops tab")
	public void user_click_on_desktops_tab() {
		desktop.desktopMenuClick();
		logger.info("clicking on desktop tab");
		WebDriverUtilities.takeScreenShot();
	}

	@When("User click on Show all desktops")
	public void user_click_on_show_all_desktops() {
		WebDriverUtilities.wait2();
		desktop.showAllDesktopButton();
		logger.info("clicking on show all desktop item tab");
	}

	@Then("User should see all items are present in Desktop page")
	public void user_should_see_all_items_are_present_in_desktop_page() {

		List<WebElement> desktopItemList = desktop.confirmingAllItems();
		for (WebElement items : desktopItemList) {
			Assert.assertTrue(items.isDisplayed());
			logger.info("checking the whole elements");
		}
	}

//*********************Add to Cart-HP Scenario*********************

	@And("User click ADD TO CART option on HP LP3065 item")
	public void user_click_add_to_cart_option_on_hp_lp3065_item() {
		desktop.HPSelect();
		logger.info("clicking on HP Model");
		WebDriverUtilities.wait2();
		WebDriverUtilities.takeScreenShot();
		logger.info("clicking on add to cart button");
	}

	@And("User select quantity {string}")
	public void user_select_quantity(String string) {
		WebDriverUtilities.wait2();
		desktop.unitQuantity(string);
		logger.info("adding the quantity");
	}

	@Then("User should see a message ‘Success: you have added HP LP3065 to your Shopping cart!’")
	public void user_should_see_a_message_success_you_have_added_hp_lp_to_your_shopping_cart() {
		WebDriverUtilities.wait2();
		desktop.confirmAddToCart();
		WebDriverUtilities.takeScreenShot();
		logger.info("confirming the add to cart message");
	}

	// *********************Add to Cart -Canon Scenario*********************

	@And("User click ADD TO CART option on Canon EOS5D item")
	public void user_click_add_to_cart_option_on_canon_eos5d_item() {
		desktop.clickingOnCanonCamera();
		logger.info("adding the Camera to cart");
	}

	@And("User select color from dropdown Red")
	public void user_select_color_from_dropdown_red() {
		WebDriverUtilities.wait2();
		desktop.choosingCameraColor();
		logger.info("Choosing the camera color");
//		desktop.addToCart();
	}

	@Then("User should see a message ‘Success: You have added Canon EOS5D to your shopping cart!’")
	public void user_should_see_a_message_success_you_have_added_canon_eos_5d_to_your_shopping_cart() {
		desktop.confirmingCameraAddToCart();
		WebDriverUtilities.takeScreenShot();
		logger.info("confirming the add to cart message");
		WebDriverUtilities.wait2();
	}

	// *********************Review Scenario*********************

	@And("User click on Canon EOS5D item")
	public void user_click_on_canon_eos_5d_item() {
		desktop.clickingOnCanonCamera();
		logger.info("opening the camera page");
		WebDriverUtilities.wait2();
	}

	@And("User click on write a review link")
	public void user_click_on_write_a_review_link() {
		desktop.clickingOnCanonReview();
		logger.info("clicking on review button");
		WebDriverUtilities.wait2();
	}

	@And("user fill the review information with below information")
	public void user_fill_the_review_information_with_below_information(DataTable datatable) {
		List<Map<String, String>> reviewerInfo = datatable.asMaps(String.class, String.class);
		desktop.enteringName(reviewerInfo.get(0).get("yourName"));
		logger.info("typing the name");
		WebDriverUtilities.wait2();
		desktop.comments(reviewerInfo.get(0).get("yourReview"));
		logger.info("writing the comments");
		WebDriverUtilities.wait2();
		desktop.rating(reviewerInfo.get(0).get("Rating"));
		logger.info("choosing the rating level");
		WebDriverUtilities.wait2();
		WebDriverUtilities.takeScreenShot();
	}

	@And("User click on Continue Button")
	public void user_click_on_continue_button() {
		desktop.clickingOnContinue();
	}

	@Then("User should see a message with {string}")
	public void user_should_see_a_message_with(String string) {
		Assert.assertTrue(desktop.confirmAddToCart());
		logger.info("confirming the submitting message");
		WebDriverUtilities.wait2();
		WebDriverUtilities.takeScreenShot();
	}
}
