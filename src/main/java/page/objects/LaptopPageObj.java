package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import junit.framework.Assert;

public class LaptopPageObj extends Base {
	public LaptopPageObj() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Laptops & Notebooks")
	private WebElement laptopMenu;

	public void clickingOnlaptopNotebookMenue() {
//		laptopMenu.click();
		Actions x = new Actions(driver);
		x.moveToElement(laptopMenu).build().perform();
	}

	@FindBy(linkText = "Show All Laptops & Notebooks")
	private WebElement showAll;

	public void showAllItems() {
		showAll.click();
	}

	@FindBy(tagName = "img")
	private List<WebElement> allItems;

	public List<WebElement> confirmingAllItems() {
//	Assert.assertTrue(allItems.iterator().next());
		List<WebElement> laptopItems = allItems;
		return laptopItems;
	}

	@FindBy(xpath = "//a[text() = 'MacBook']")
	private WebElement macBook1;

	public void clickingMacBook() {
		macBook1.click();
	}

	@FindBy(id = "button-cart")
	private WebElement macBookAddedToCart;

	public void addMacToCart() {
		macBookAddedToCart.click();
	}

	public boolean sucessMessageConfirmation() {
		return macBookAddedToCart.isDisplayed();
	}

	@FindBy(css = "#cart")
	private WebElement cartItems;

	public boolean cartListConfirmation() {
		if (cartItems.isDisplayed())
			return true;
		else
			return false;
	}

	@FindBy(css = "#cart-total")
	private WebElement cartTotalItems;

	public void clickingOnCartButton() {
		cartTotalItems.click();
	}

	@FindBy(xpath = "//button[@type='button' and @title='Remove']")
	private WebElement deletButton;

	public void clickingOnXButton() {
		deletButton.click();
	}

	@FindBy(xpath = "(//i[@class='fa fa-shopping-cart'])[2]")
	private WebElement cartListEmpty;

	public boolean emptyCartList() {
		cartListEmpty.isDisplayed();
		return true;
	}

	// ********** Next Scenario**********

	@FindBy(xpath = "(//i[@class='fa fa-exchange'])[2]")
	private WebElement compareMacBook;

	public void clickingOnMacCompare() {
		compareMacBook.click();
	}

	@FindBy(xpath = "(//i[@class='fa fa-exchange'])[3]")
	private WebElement compareMacAir;

	public void clickingOnMacAirCompare() {
		compareMacAir.click();
	}

	@FindBy(linkText = "MacBook Air")
	private WebElement macCompareMessage;

	public boolean confirmingMacSuccessMessage() {
		macCompareMessage.getText();
		Assert.assertTrue(macCompareMessage.isDisplayed());
		return true;
	}

	@FindBy(id = "compare-total")
	private WebElement compareList;

	public void clickingOnCompareList() {
		compareList.click();
	}

	@FindBy(linkText = "Product Comparison")
	private WebElement confirmingProductCompare;

	public boolean confirmingProductCompareList() {
		confirmingProductCompare.getText();
		return confirmingProductCompare.isDisplayed();
	}

	@FindBy(xpath = "(//button[@type='button'])[22]")
	private WebElement sonyWishlist;

	public void clickingOnSonyWishList() {
		sonyWishlist.click();
	}

	@FindBy(xpath = "(//a[contains(text(), 'Sony VAIO')])[1]")
	private WebElement sonyWishlistMessage;
	@FindBy(xpath = "(//a[contains(text(), 'login')])[1]")
	private WebElement sonyWishlistMessageLogin;

	public void confirmingLoginRequiredMessage() {
		Assert.assertTrue(sonyWishlistMessage.isDisplayed());
		sonyWishlistMessage.getText();
		System.out.println("You must" + sonyWishlistMessageLogin.getText() + " or create an account to save "
				+ sonyWishlistMessage.getText() + " to your wish list!");
	}

	@FindBy(xpath = "//a[text() = 'MacBook Pro']")
	private WebElement macPro;

	public void clickingOnMacPro() {
		macPro.click();
	}

	@FindBy(xpath = "//h2[text() = '$2,000.00']")
	private WebElement macProPrice;

	public void checkingMacProPrice() {
		Assert.assertEquals("$2,000.00", macProPrice.getText());
	}
}
