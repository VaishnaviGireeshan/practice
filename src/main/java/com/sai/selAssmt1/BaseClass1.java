package com.sai.selAssmt1;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterMethod;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass1 {

		protected WebDriver driver;
		protected WebDriverWait wait;
		protected Actions actions;

		// Method to initialize the WebDriver
		public void intialize() {
			// Use WebDriverManager to set up ChromeDriver
			WebDriverManager.chromedriver().setup();
			// Create a new instance of the ChromeDriver
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 10);
			driver.manage().window().maximize();

		}

		public void dropDownSelection(WebElement element, String visibleText) {
			Select sc = new Select(element);
			sc.selectByVisibleText(visibleText);
		}

		public WebElement isClickable(By by, int timeInSeconds) {
			return new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.elementToBeClickable(by));

		}

		public WebElement isElementVisible(By by, int timeInSeconds) {
			return new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));

		}

		public WebElement isElementPresent(By by, int timeInSeconds) {
			return new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.presenceOfElementLocated(by));

		}
		public void sleep() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	}

		// Method to close the WebDriver after each test method
		@AfterMethod
		public void tearDown() {
			driver.close();
		}

	}


