package page.objects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import core.Base;
import utilities.WebDriverUtilities;

public class DesktopPageObj extends Base {

	public DesktopPageObj() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Desktops")
	private WebElement desktopMenu;

	public void desktopMenuClick() {
		desktopMenu.click();
	}

	@FindBy(linkText = "Show All Desktops")
	private WebElement show;

	public void showAllDesktopButton() {
		show.click();
		// WebDriverUtilities.mouseHover(desktopMenu);
	}

	@FindBy(css = ".img-responsive")
	private List<WebElement> allItems;

	public List<WebElement> confirmingAllItems() {
		List<WebElement> destTopItems = allItems;
		return destTopItems;
	}

	@FindBy(xpath = "//img[@title='HP LP3065' and @class ='img-responsive']")
	private WebElement HPLaptop;

	public void HPSelect() {
		HPLaptop.click();
	}

	@FindBy(css = "#input-option225")
	WebElement deliveryDate;

	public void selectDeliveryDate() {
		deliveryDate.sendKeys("2022/08/20");
	}

	@FindBy(css = "#input-quantity")
	private WebElement unitQty;

	public void unitQuantity(String qty) {
		unitQty.clear();
		unitQty.sendKeys(qty);
	}

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement add;

	public void addToCart() {
		add.click();
	}

	@FindBy(xpath = "//body/div[@id='product-product']/div[1]")
	private WebElement message;

	public boolean confirmAddToCart() {
		Assert.assertTrue(message.isDisplayed());
		return true;
	}

	@FindBy(xpath = "//img[@title='Canon EOS 5D Camera' and @class ='img-responsive']")
	private WebElement camera;

	public void clickingOnCanonCamera() {
		camera.click();
	}

	@FindBy(css = "#input-option226")
	private WebElement colors;

	public void choosingCameraColor() {
		Select colorSelect = new Select(colors);
		colorSelect.selectByValue("15");
	}

	@FindBy(xpath = "//body/div[@id='product-product']/div[1]")
	private WebElement sucessmessage;

	public boolean confirmingCameraAddToCart() {
		Assert.assertTrue(message.isDisplayed());
		WebDriverUtilities.wait2();
		return true;
	}

	@FindBy(xpath = "//a[text() = 'Write a review']")
	private WebElement review;

	public void clickingOnCanonReview() {
		review.click();
	}

	@FindBy(id = "input-name")
	private WebElement name;

	public void enteringName(String nameInput) {
		name.sendKeys(nameInput);
	}

	@FindBy(id = "input-review")
	private WebElement comment;

	public void comments(String commentsInput) {
		comment.sendKeys(commentsInput);
	}

	@FindBy(xpath = "//input[@type ='radio']")
	private List<WebElement> ratingList;

	public void rating(String ratingNumber) {
		for (WebElement element : ratingList) {
			if (element.getAttribute("value").equalsIgnoreCase(ratingNumber.trim())) {
				element.click();
				break;
			}
		}
	}

	@FindBy(id = "button-review")
	private WebElement continueBotton;

	public void clickingOnContinue() {
		continueBotton.click();
	}

	@FindBy(xpath = "//i[@class='fa fa-check-circle']")
	private WebElement successGreenButton;

	public boolean istheTickButtonPresent() {
		successGreenButton.isDisplayed();
		return true;
	}
}
