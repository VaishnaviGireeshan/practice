package com.sai.selAssmt1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitBase {
	WebDriver driver;
	WebDriverWait wait;

	public void initialSetUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);// open new instance of Chrome Browser
		wait = new WebDriverWait(driver, 10);
	}

	public WebElement isElementDisplayed(By by, int timeInSecond) {
		return new WebDriverWait(driver, timeInSecond).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public WebElement isElementClickable(By by, int timeInSecond) {
		return new WebDriverWait(driver, timeInSecond).until(ExpectedConditions.elementToBeClickable(by));
	}

	public WebElement isElementPrecent(By by, int timeInSecond) {
		return new WebDriverWait(driver, timeInSecond).until(ExpectedConditions.presenceOfElementLocated(by));
	}

//	public WebElement isElementSelectable(By by, int timeInSecond) {
//        return new WebDriverWait(driver, timeInSecond).until(ExpectedConditions.elementToBeSelected(by));
//    }
	public void selectFromDropdown(WebElement element, String visibleText) {
		Select se = new Select(element);
		se.selectByVisibleText(visibleText);
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}
}
