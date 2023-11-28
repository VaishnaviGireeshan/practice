package com.sai.selAssmt1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrightCloud extends BaseClass {
	@BeforeMethod
	public void setUp() {
		initialSetUp();
		driver.get("https://www.brightcloud.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		acceptCookies();
	}

	@Test()
	public void servicesValidation() {
		
		List<WebElement> services = driver.findElements(By.cssSelector("ul[class='text-right clean-list']>li"));

		for (WebElement service : services) {
			System.out.println(service.getText());

			if (service.getText().equals("Partner Services")) {
				service.click();

			}

		}
		System.out.println("----------------------------------------------");


		List<WebElement> partnerServices = driver
				.findElements(By.cssSelector("#brightcloud-services-drop > section > ul"));

		for (WebElement partnerService : partnerServices) {
			System.out.println(partnerService.getText());

			if (partnerService.getText().equals("IP Reputation")) {
				partnerService.click();
				
			}

		}

	}

	private void acceptCookies() {
		WebElement cookieBanner = driver.findElement(By.cssSelector("#onetrust-banner-sdk"));
		if (cookieBanner.isDisplayed()) {
			WebElement acceptButton = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
			acceptButton.click();
		}
	}


}
