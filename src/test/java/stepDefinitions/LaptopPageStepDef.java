package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;

import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page.objects.LaptopPageObj;
import utilities.WebDriverUtilities;

public class LaptopPageStepDef extends Base {
	LaptopPageObj laptop = new LaptopPageObj();

	@And("User click on Laptop &NoteBook tab")
	public void user_click_on_laptop_note_book_tab() {
		laptop.clickingOnlaptopNotebookMenue();
		WebDriverUtilities.wait2();
		logger.info("clicking on Laptop Menu");
		WebDriverUtilities.takeScreenShot();
	}

	@And("User click on Show all Laptop &NoteBook option")
	public void user_click_on_show_all_laptop_note_book_option() {
		laptop.showAllItems();
		WebDriverUtilities.wait2();
		List<WebElement> laptopItemList = laptop.confirmingAllItems();
		for (WebElement items : laptopItemList) {
			Assert.assertTrue(items.isDisplayed());
			logger.info("checking all items are present");
			WebDriverUtilities.takeScreenShot();
		}
	}

	@And("User click on MacBook item")
	public void user_click_on_mac_book_item() {
		WebDriverUtilities.wait2();
		laptop.clickingMacBook();
		logger.info("clicking on macBook item");
	}

	@And("User click add to Cart button")
	public void user_click_add_to_cart_button() {
		laptop.addMacToCart();
		WebDriverUtilities.takeScreenShot();
	}

	@Then("User should see a message ‘Success: You have added MacBook to your shopping cart!’")
	public void user_should_see_a_message_success_you_have_added_mac_book_to_your_shopping_cart() {
		logger.info("checking the success message for MacBook");
		laptop.sucessMessageConfirmation();
		WebDriverUtilities.wait2();
		WebDriverUtilities.takeScreenShot();
	}

	@Then("User should see {string} item\\(s){double} showed to the cart")
	public void user_should_see_item_s_showed_to_the_cart(String string, Double double1) {
		WebDriverUtilities.wait2();
		laptop.cartListConfirmation();
		logger.info("checking the number of items for cart");
	}

	@And("User click on cart option")
	public void user_click_on_cart_option() {
		laptop.clickingOnCartButton();
		WebDriverUtilities.wait2();
		logger.info("clicking on the cart button");
	}

	@And("user click on red X button to remove the item from cart")
	public void user_click_on_red_x_button_to_remove_the_item_from_cart() {
		WebDriverUtilities.wait2();
		logger.info("checking the delet button in Cart List");
		laptop.clickingOnXButton();
		WebDriverUtilities.takeScreenShot();
	}

	@Then("item should be removed and cart should show {int} item\\(s)")
	public void item_should_be_removed_and_cart_should_show_item_s(Integer int1) {
		WebDriverUtilities.wait2();
		logger.info("checking the removed items");
		laptop.emptyCartList();
		WebDriverUtilities.takeScreenShot();
	}

//********** Comparison Scenario**********	

	@And("User click on product comparison icon on ‘MacBook’")
	public void user_click_on_product_comparison_icon_on_mac_book() {
		WebDriverUtilities.wait2();
		logger.info("clicking the compare button for MacBook");
		laptop.clickingOnMacCompare();
		WebDriverUtilities.wait2();
	}

	@And("User click on product comparison icon on ‘MacBook Air")
	public void user_click_on_product_comparison_icon_on_mac_book_air() {
		WebDriverUtilities.wait2();
		laptop.clickingOnMacAirCompare();
		logger.info("clicking the compare button for MacBook Air");
		laptop.clickingOnMacAirCompare();
		WebDriverUtilities.wait2();
	}

	@Then("User should see a message ‘Success: You have added MacBook Air to your product comparison!’")
	public void user_should_see_a_message_success_you_have_added_mac_book_air_to_your_product_comparison() {
		WebDriverUtilities.wait2();
		logger.info("checking the success message for the comparison list");
		laptop.confirmingMacSuccessMessage();
		WebDriverUtilities.wait2();
	}

	@When("User click on Product comparison link")
	public void user_click_on_product_comparison_link() {
		WebDriverUtilities.wait2();
		logger.info("clicking on the comparison link");
		laptop.clickingOnCompareList();
		WebDriverUtilities.wait2();
	}

	@Then("User should see Product Comparison Chart")
	public void user_should_see_product_comparison_chart() {
		WebDriverUtilities.wait2();
		logger.info("checking the comparison cart");
		laptop.confirmingProductCompareList();
		WebDriverUtilities.wait2();
		WebDriverUtilities.takeScreenShot();
	}

	// ********** Wish List Scenario**********

	@When("User click on heart icon to add ‘Sony VaIO’ laptop to wish list")
	public void user_click_on_heart_icon_to_add_sony_va_io_laptop_to_wish_list() {
		WebDriverUtilities.wait2();
		logger.info("adding the Sony to wish list");
		laptop.clickingOnSonyWishList();
		WebDriverUtilities.takeScreenShot();
	}

	@Then("User should get a message ‘You must login or create an account to save Sony VAIO to your wish list!’")
	public void user_should_get_a_message_you_must_login_or_create_an_account_to_save_sony_vaio_to_your_wish_list() {
		WebDriverUtilities.wait2();
		logger.info("checking the login required message for wish list");
		laptop.confirmingLoginRequiredMessage();
		WebDriverUtilities.takeScreenShot();
	}

	// ********** Price Scenario**********

	@When("User click on ‘MacBook Pro’ item")
	public void user_click_on_mac_book_pro_item() {
		WebDriverUtilities.wait2();
		logger.info("clicking on the macBook Pro item");
		laptop.clickingOnMacPro();
	}

	@Then("User should see ‘${double}’ price tag is present on UI.")
	public void user_should_see_$_price_tag_is_present_on_ui(Double double1) {
		WebDriverUtilities.wait2();
		logger.info("checking the price of the MacBook Pro");
		laptop.checkingMacProPrice();
		WebDriverUtilities.takeScreenShot();
	}
}
