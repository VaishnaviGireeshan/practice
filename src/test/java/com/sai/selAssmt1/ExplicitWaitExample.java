package com.sai.selAssmt1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExample extends ExplicitWaitBase {
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		initialSetUp();
		driver.get("https://www.webroot.com/us/en/cart?key=9C8868A3-2846-4BC4-AAFC-C7B9B69AF60C");
		driver.manage().window().maximize();

		/*
		 * parameterized constructor WebDriverWait(WebDriver driver, long
		 * timeOutInSeconds)
		 */

	}

	@Test
	public void ExplicitWaitDemo() {

		WebElement cookieAcceptBtn = isElementDisplayed(By.xpath("//button[text()='Accept All'][1]"), 5);
		cookieAcceptBtn.click();

		WebElement startShoppingBtn = isElementPrecent(By.xpath("//a[text()='Start Shopping']"), 3);
		startShoppingBtn.click();

		WebElement shopNowBtn = isElementDisplayed(By.xpath("//a[text()='Shop Now']"), 5);
		shopNowBtn.click();

		WebElement buyNowBtn = isElementClickable(By.xpath("//div/span[text()='Basic']/following-sibling::a[1]"), 4);
		buyNowBtn.click();

		WebElement emailInput = isElementPrecent(By.cssSelector("input[name='billing.customer_email']"), 6);
		emailInput.sendKeys("kinginthenorth@winterfell.com");

		WebElement firstNameInput = isElementPrecent(By.cssSelector("input[name='billing.first_name']"), 7);
		firstNameInput.sendKeys("Jon");

		WebElement lastNameInput = isElementPrecent(By.cssSelector("input[name='billing.last_name']"), 5);
		lastNameInput.sendKeys("Snow");

		WebElement addressInput = isElementPrecent(By.cssSelector("input[name='billing.address_1']"), 4);
		addressInput.sendKeys("44 Kingsmoor Close");

		WebElement cityInput = driver.findElement(By.cssSelector("input[aria-label='City']"));
		WebElement cityPostalCode = driver.findElement(By.cssSelector("input[name='billing.postal_code']"));

		selectFromDropdown(driver.findElement(By.cssSelector("select[name='billing.country']")), "Canada");
		selectFromDropdown(driver.findElement(By.cssSelector("select[name='billing.state']")), "Alberta");

		cityInput.sendKeys("St'Albert");
		cityPostalCode.sendKeys("T8N0S4");

	}

}
