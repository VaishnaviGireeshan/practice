package com.sai.selAssmt1;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class UserPurchaseValidation extends BaseClass1 {
	Actions actions;

	@BeforeMethod
	public void setUp() {
		intialize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test
	public void userPurchaseValidation() {
		// Login
		isElementPresent(By.cssSelector("#input-email"), 10).sendKeys("fokucocaxe@mailinator.com");

		isElementPresent(By.cssSelector("#input-password"), 10).sendKeys("Pa$$w0rd!");

		isClickable(By.cssSelector("input[value='Login']"), 10).click();

		// Verify login
		WebElement bannerText = isElementPresent(By.xpath("//h2[text()='My Account']"), 10);
		Assert.assertEquals(bannerText.getText(), "My Account", "My account banner text not found");

		// Navigate to a product
		isClickable(By.xpath("//a[text()='MP3 Players']"), 10).click();
		isClickable(By.xpath("//a[text()='Show All MP3 Players']"), 10).click();
		isClickable(By.xpath("//a[text()='iPod Classic']"), 10).click();

		// Add product to cart
		isClickable(By.xpath("//button[text()='Add to Cart']"), 10).click();

		// Verify product added message
		WebElement cartTotalDetails = driver.findElement(By.cssSelector("#cart-total"));
		wait.until(ExpectedConditions.textToBePresentInElement(cartTotalDetails, "1 item(s) - $122.00"));
		Assert.assertEquals(cartTotalDetails.getText(), "1 item(s) - $122.00", "Product cart total details not found");

		// Proceed to checkout
		isClickable(By.cssSelector("div[id='cart']>button"), 10).click();
		isClickable(By.cssSelector("div[id='cart']>ul>li:nth-of-type(2)>div>p>a:nth-of-type(2)"), 10).click();

		// Filling billing details
		isClickable(By.cssSelector("#input-payment-firstname"), 10).sendKeys("fokucocaxe");
		isClickable(By.cssSelector("#input-payment-lastname"), 10).sendKeys("Jo");
		isClickable(By.cssSelector("#input-payment-company"), 10).sendKeys("Naveen");
		isClickable(By.cssSelector("#input-payment-address-1"), 10).sendKeys("5-23");
		isClickable(By.cssSelector("#input-payment-address-2"), 10).sendKeys("Queen Street West");
		isClickable(By.cssSelector("#input-payment-city"), 10).sendKeys("Toronto");
		isClickable(By.cssSelector("#input-payment-postcode"), 10).sendKeys("NYC 3E2");

		// Select country, region and postal code in the checkout process.
		WebElement countrySelect = isElementPresent(By.cssSelector("#input-payment-country"), 10);
		dropDownSelection(countrySelect, "Canada");

		WebElement regionSelect = isElementPresent(By.cssSelector("#input-payment-zone"), 30);
		dropDownSelection(regionSelect, "Nunavut");

		// Billing Details
		WebElement billingDetailsRadioBtn = isElementVisible(By.cssSelector("input[name='payment_address']"), 10);
		if (!billingDetailsRadioBtn.isSelected()) {
			billingDetailsRadioBtn.click();
		}
		isClickable(By.cssSelector("#button-payment-address"), 10).click();

		// Delivery Details
		WebElement deliveryDetailsRadioBtn = isElementVisible(By.cssSelector("input[name='shipping_address']"), 10);
		if (!deliveryDetailsRadioBtn.isSelected()) {
			deliveryDetailsRadioBtn.click();
		}
		isClickable(By.cssSelector("#button-shipping-address"), 10).click();

		// Delivery Method
		WebElement deliveryMethodRadioBtn = isElementVisible(By.cssSelector("input[name='shipping_method']"), 10);
		if (!deliveryMethodRadioBtn.isSelected()) {
			deliveryMethodRadioBtn.click();
		}
		isElementPresent(By.cssSelector("textarea[name='comment']"), 10).sendKeys("Dolor in voluptas ei");
		isClickable(By.cssSelector("#button-shipping-method"), 10).click();

		// Payment Method
		WebElement cashOnDeliveryRadioBtn = isElementVisible(By.cssSelector("input[value='cod']"), 10);
		if (!cashOnDeliveryRadioBtn.isSelected()) {
			cashOnDeliveryRadioBtn.click();
		}
		WebElement agreeCheckBox = isElementVisible(By.cssSelector("input[name='agree']"), 10);
		if (!agreeCheckBox.isSelected()) {
			agreeCheckBox.click();
		}

		isClickable(By.cssSelector("#button-payment-method"), 10).click();
		WebElement productValidation = isElementPresent(By.cssSelector("tbody>tr>td:nth-of-type(2)>a"), 10);
		WebElement productQuantityValidation = isElementPresent(By.cssSelector("tbody>tr>td:nth-of-type(3)"), 10);

		// Get the text from the elements
		String actualProductText = productValidation.getText();
		String actualQuantityText = productQuantityValidation.getText();

		// Define the expected values
		String expectedProductText = "iPod Classic";
		String expectedQuantityText = "1";

		// Comparing the actual and expected values
		if (actualProductText.equals(expectedProductText) && actualQuantityText.equals(expectedQuantityText)) {
			// Both values are as expected
			System.out.println("Both values are as expected");
		} else {
			// One or both values are not as expected
			System.out.println("One or both values are not as expected");
		}

		// Confirm purchase
		isClickable(By.cssSelector("input[value='Confirm Order']"), 10).click();

		// validating confirmation message
		WebElement confirmationMessage = isElementPresent(By.cssSelector("#content>h1"), 10);
		Assert.assertEquals(confirmationMessage.getText(), "Your order has been placed!",
				"Confirmation message not found");

	}
}
