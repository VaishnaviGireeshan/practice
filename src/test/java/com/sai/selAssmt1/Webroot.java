package com.sai.selAssmt1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webroot extends BaseClass {

	@BeforeMethod
	public void setUp() {
		initialSetUp();
		driver.get("https://www.webroot.com/us/en/cart?key=9C8868A3-2846-4BC4-AAFC-C7B9B69AF60C");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	public void validateBilling() {
		WebElement emailInput = driver.findElement(By.cssSelector("input[name='billing.customer_email']"));
		WebElement firstNameInput = driver.findElement(By.cssSelector("input[name='billing.first_name']"));
		WebElement lastNameInput = driver.findElement(By.cssSelector("input[name='billing.last_name']"));
		WebElement addressInput = driver.findElement(By.cssSelector("input[name='billing.address_1']"));
		WebElement cityInput = driver.findElement(By.cssSelector("input[aria-label='City']"));
		WebElement cityPostalCode = driver.findElement(By.cssSelector("input[name='billing.postal_code']"));
		WebElement cookieAcceptBtn = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
		WebElement paymentOptions = driver.findElement(By.cssSelector(" div.cart-payment > div:nth-child(3)"));

		cookieAcceptBtn.click();
		emailInput.sendKeys("kinginthenorth@winterfell.com");
		firstNameInput.sendKeys("Jon");
		lastNameInput.sendKeys("Snow");
		addressInput.sendKeys("44 Kingsmoor Close");

		selectFromDropdown(driver.findElement(By.cssSelector("select[name='billing.country']")), "Canada");
		selectFromDropdown(driver.findElement(By.cssSelector("select[name='billing.state']")), "Alberta");

		cityInput.sendKeys("St'Albert");
		cityPostalCode.sendKeys("T8N 0S4");

		boolean isPaymentOptionsDisplayed = paymentOptions.isDisplayed();
		Assert.assertTrue(isPaymentOptionsDisplayed, "Payment options are not displayed");

	}


}
