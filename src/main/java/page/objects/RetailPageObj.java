package page.objects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import io.cucumber.java.en.When;

public class RetailPageObj extends Base {

	public RetailPageObj() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "TEST ENVIRONMENT")
	private WebElement retailPage;

	public boolean retail_page() {
		Assert.assertTrue(retailPage.isDisplayed());
		Assert.assertEquals("TEST ENVIRONMENT", retailPage.getText());
		if (retailPage.isDisplayed()) {
			System.out.println("Confirmed");
			return true;
		} else
			System.out.println("Not this time");
		return false;
	}

	@FindBy(xpath = "//span[text() ='My Account']")
	private WebElement myAccount;

	public void user_click_on_myAcc() {
		myAccount.click();
	}

	@FindBy(linkText = "Login")
	private WebElement loginClick;

	public void loginOption() {
		loginClick.click();
	}

	@FindBy(id = "input-email")
	private WebElement emailInput;

	@FindBy(id = "input-password")
	private WebElement passInput;

	public void emailPassInput(String email, String password) {
		emailInput.sendKeys(email);
		passInput.sendKeys(password);
	}

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	public void loginButtonClick() {
		loginButton.click();
	}

	@FindBy(xpath = "//h2[text() = 'My Account']")
	private WebElement dashBoardPage;

	public void accountDashboard() {
		if (driver.getPageSource().contains("Warning: No match for E-Mail Address and/or Password.")) {
			driver.close();
			if (dashBoardPage.isDisplayed())
				System.out.println("Sucessfully logged in");
		} else {
			String message = dashBoardPage.getText();
			if (message.isEmpty())
				driver.close();
		}
	}

	// **********************Next Scenario*************

	@FindBy(linkText = "Register for an affiliate account")
	private WebElement registerAffiliate;

	public void registerForAffiliate() {
		registerAffiliate.click();
	}

	@FindBy(id = "input-company")
	public WebElement companyInput;
	@FindBy(id = "input-website")
	public WebElement websiteInput;
	@FindBy(id = "input-tax")
	public WebElement taxInput;

	@FindBy(id = "input-paypal")
	public WebElement paypalInput;
	@FindBy(id = "input-cheque")
	public WebElement chequeInput;

	@FindBy(xpath = "//input[@type= 'radio' and @value= 'cheque']")
	private WebElement chequeRadioButton;

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/fieldset[2]/div[2]/div[1]/div[2]/label[1]")
	private WebElement paypalRadioButton;

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/fieldset[2]/div[2]/div[1]/div[3]/label[1]")
	private WebElement checkRadioButton;

	public void paymentOption(String paymentOption) {
		if (paymentOption.trim().equalsIgnoreCase("cheque")) {
			if (chequeRadioButton.isSelected()) {
				chequeRadioButton.click();
			}

		} else if (paymentOption.equalsIgnoreCase("paypal")) {
			paypalRadioButton.click();
		} else
			checkRadioButton.click();
	}

	@FindBy(xpath = "//input[@value='1']")
	private WebElement agree;

	public void checkBoxClick() {
		agree.click();
	}

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	public void continueClick() {
		continueButton.click();
	}

	@FindBy(xpath = "//div[@class= 'alert alert-success alert-dismissible']")
	private WebElement successMesg;

	public boolean successMessageValidation() {
		if (successMesg.isDisplayed())
			return true;
		else
			return false;
	}

//**********************Next Scenario*************
	@FindBy(xpath = "//a[contains(text(),'Edit your affiliate information')]")
	private WebElement editAffiliate;

	public void editAffiliateInfo() {
		editAffiliate.click();
	}

	@FindBy(xpath = "//input[@type= 'radio' and @value= 'bank']")
	private WebElement bank;

	public void bankAccountOption() {
		bank.click();
	}

	@FindBy(id = "input-bank-name")
	public WebElement bankName;
	@FindBy(id = "input-bank-branch-number")
	public WebElement bankBranchName;
	@FindBy(id = "input-bank-swift-code")
	public WebElement BankSwiftCode;
	@FindBy(id = "input-bank-account-name")
	public WebElement BankAccName;
	@FindBy(id = "input-bank-account-number")
	public WebElement BankAccNumber;

	// **********************Next Scenario*************

	@FindBy(xpath = "//a[contains(text(),'Edit your account information')]")
	private WebElement editAccInfo;

	public void editAccountInfo() {
		editAccInfo.click();
	}

	@FindBy(id = "input-firstname")
	public WebElement firstNameInput;

	@FindBy(id = "input-lastname")
	public WebElement lastNameInput;

	@FindBy(id = "input-email")
	public WebElement newEmailInput;

	@FindBy(id = "input-telephone")
	public WebElement telephoneInput;

	@FindBy(xpath = " //body/div[@id='account-account']/div[1]")
	private WebElement successMsg;

}