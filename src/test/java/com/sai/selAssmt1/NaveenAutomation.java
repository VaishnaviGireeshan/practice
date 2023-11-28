package com.sai.selAssmt1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NaveenAutomation extends BaseClass {
	/*
	 * contains the actual test case that utilizes NaveenAutomationContactUs class
	 * for testing the Contact Us form.
	 */
	@BeforeMethod
	public void setUp() {
		initialSetUp();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=information/contact\r\n");
		driver.manage().window().maximize();
	}

	@Test
	public void validateContactUs() {
		WebElement nameInput = driver.findElement(By.cssSelector("#input-name"));
		WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
		WebElement enquiryInput = driver.findElement(By.cssSelector("#input-enquiry"));
		WebElement submitBtn = driver.findElement(By.cssSelector("div[class='pull-right']>input"));

		nameInput.sendKeys("Jon");
		emailInput.sendKeys("kinginthenorth@winterfell.com");
		enquiryInput.sendKeys("sample enquiry");
		submitBtn.submit();

		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL,
				"https://naveenautomationlabs.com/opencart/index.php?route=information/contact/success",
				"Incorrect URL");

		WebElement enquirySuccessMsg = driver.findElement(By.cssSelector("#content > p"));
		Assert.assertEquals(enquirySuccessMsg.getText(), "Your enquiry has been successfully sent to the store owner!",
				"Incorrect Message displayed");

	}

}
