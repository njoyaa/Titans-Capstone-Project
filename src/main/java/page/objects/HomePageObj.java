package page.objects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class HomePageObj extends Base {
	public HomePageObj() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Currency']")
	private WebElement currencyButton;

	public void clickingOnCurrency() {
		currencyButton.click();
	}

	@FindBy(xpath = "//span[text()='Currency']")
	private List<WebElement> currencies;

	public void chosinCurrency(String currencyOption) {
		for (WebElement currencyList : currencies) {
			currencyList.getAttribute("name").equals(currencyOption);
			currencyList.click();
		}
	}

	@FindBy(xpath = "//button[contains(text(),'Euro')]")
	private WebElement euro;

	public void choosingEuro() {
		euro.click();
	}

	@FindBy(xpath = "//strong[text()='€']")
	private WebElement euroSign;

	public void confirmingEuroSign() {
		Assert.assertEquals("€", euroSign.getText());
		Assert.assertTrue(euroSign.isDisplayed());
	}

	// **********Next Scenario**********

	@FindBy(xpath = "//span[text()='Shopping Cart']")
	private WebElement shoppingCart;

	public void clickingOnShoopingCart() {
		shoppingCart.click();
	}

	@FindBy(xpath = "(//p[contains(text(),'Your shopping cart is empty!')])[1]")
	private WebElement shoppingCartMessage;

	public boolean confirmingEmptyShoppingCart() {
//		Assert.assertEquals("Your shopping cart is empty!", shoppingCartMessage.getText());
		return shoppingCartMessage.isDisplayed();

	}
}
