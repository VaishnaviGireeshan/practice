package com.sai.selAssmt1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RogersBase {
	WebDriver driver;
	public void initialSetUp() { 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();// open new instance of Chrome Browser
	}
}
