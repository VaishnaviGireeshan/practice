package com.sai.selAssmt1;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserOptions extends ExplicitWaitBase {

	@BeforeMethod
	public void setUp() {
		initialSetUp();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();

	}

	@Test
	public void validateTextFromTabs() {
isElementClickable(By.cssSelector("#tabButton"), 5).click();
	}

}
