package com.sai.selAssmt1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesExample extends ExplicitWaitBase {
	@BeforeMethod
	public void setUp() {
		initialSetUp();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();

	}

	@Test
	public void validateTextFrame1() {
		//driver.switchTo().frame("frame1");
		WebElement frameText1 = isElementDisplayed(By.cssSelector("#sampleHeading"), 5);
		Assert.assertEquals(frameText1.getText(), "This is a sample page", "Message mismatch");
		//driver.switchTo().defaultContent();
	}

	@Test
	public void validateTextOutsideFrame() {
		driver.switchTo().defaultContent();
		WebElement frameOutText = isElementDisplayed(By.cssSelector("#framesWrapper>div"), 5);

		System.out.println(frameOutText.getText());
	}

	@Test
	public void validateTextFrame2() {
		driver.switchTo().frame("frame2");
		WebElement frameText2 = isElementDisplayed(By.cssSelector("#sampleHeading"), 5);
		Assert.assertEquals(frameText2.getText(), "This is a sample page", "Message mismatch");
		driver.switchTo().defaultContent();
	}
}
