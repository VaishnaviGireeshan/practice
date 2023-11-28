package com.sai.selAssmt1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected WebDriver wd;

	public void initialSetUp() {

		WebDriverManager.chromedriver().setup();

		wd = new ChromeDriver();
		wd.manage().window().maximize();

	}

}
