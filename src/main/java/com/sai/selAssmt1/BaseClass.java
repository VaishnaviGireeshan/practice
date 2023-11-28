package com.sai.selAssmt1;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected WebDriver driver;
	Scanner sc = new Scanner(System.in);

	public void initialSetUp() {
		System.out.println("Select the browser:\nChrome\nEdge\nFirefox");
		String enteredBrowser = sc.nextLine();
		selectAndLaunchBrowser(enteredBrowser);
		WebDriverManager.chromedriver().setup();
	
	}

	public WebDriver selectAndLaunchBrowser(String browser) {

		switch (browser.toLowerCase()) {// setup webdriver
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser choice: " + browser);
		}
		return driver;
	}

	// generic method
	public void selectFromDropdown(WebElement element, String visibleText) {
		Select se = new Select(element);
		se.selectByVisibleText(visibleText);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}