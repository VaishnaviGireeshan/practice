package com.sai.selAssmt1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Rogers extends RogersBase {

	@BeforeMethod
	public void setUp() {
		initialSetUp();
		driver.get("https://www.homedepot.ca/en/home.html");
		driver.manage().window().maximize();
	}

	@Test
	public void validateSearchField() {
		WebElement searchField = driver.findElement(By.cssSelector("#ge-search"));
		searchField.sendKeys("mobile devices");

	}

}
