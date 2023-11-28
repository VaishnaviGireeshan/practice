package com.sai.selAssmt1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Fossil extends BaseClass {
	@BeforeMethod
	public void setUp() {
		initialSetUp();
		driver.get("https://www.fossil.com/en-ca/new-arrivals/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void validateNewArrivalsDropDown() {

		WebElement declineOfrBtn = driver.findElement(By.cssSelector("#bx-element-2309860-AnypHOB > button"));
		declineOfrBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement featuredDropDown = driver.findElement(By.cssSelector("#sort-order"));

		selectFromDropdown(featuredDropDown, "New Arrivals");

		WebElement headerTitle = driver.findElement(By.cssSelector("h1[class='header page-title']"));

		Assert.assertEquals(headerTitle.getText(), "New Arrivals", "Header title text does not match!!!");

	}

	

}
