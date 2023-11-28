package com.sai.selAssmt1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsExample extends ExplicitWaitBase {
//alert is not part of the DOM
	@BeforeMethod
	public void setUp() {
		initialSetUp();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

	}

	@Test
	public void validateSimpleAlert() {
		WebElement alertBtn = isElementClickable(By.cssSelector("#alertButton"), 5);
		alertBtn.click();// accepting the alert
		driver.switchTo().alert().accept();// Send future commands to a different frame or window

	}

	@Test
	public void validateTimeAlert() {
		WebElement timeAlertBtn = isElementClickable(By.cssSelector("#timerAlertButton"), 5);
		timeAlertBtn.click();// accepting the alert
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

	}

	@Test
	public void validateConfirmAlert() {
		WebElement confirmAlertBtn = isElementClickable(By.cssSelector("#confirmButton"), 5);
		confirmAlertBtn.click();// accepting the alert
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		// creating ref variable of alert interface and initializing it with the alert
		// which is present in the webpage by providing a wait
		alert.dismiss();

	}

	@Test
	public void validatepromptAlert() {
		WebElement promptAlertBtn = isElementClickable(By.cssSelector("#promtButton"), 5);
		promptAlertBtn.click();// accepting the alert
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("aassdd");
		alert.accept();

	}

}
