package com.sai.selAssmt1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsExample extends ExplicitWaitBase {

	Actions actions;

	@BeforeMethod
	public void setUp() {
		initialSetUp();
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		actions = new Actions(driver);
	}

	@Test
	public void validateActionClick() {
		WebElement clickMeBtn = isElementClickable(By.xpath("//button[text()='Click Me']"), 5);
		actions.click(clickMeBtn).perform();
		WebElement clickMeMsg = isElementDisplayed(By.cssSelector("#dynamicClickMessage"), 5);
		Assert.assertEquals(clickMeMsg.getText(), "You have done a dynamic click", "Message not found");
	}

	@Test
	public void validateActionRightClick() {
		WebElement rightClickBtn = isElementClickable(By.cssSelector("#rightClickBtn"), 5);
		actions.contextClick(rightClickBtn).perform();
		WebElement rightClickMsg = isElementDisplayed(By.cssSelector("#rightClickMessage"), 5);
		Assert.assertEquals(rightClickMsg.getText(), "You have done a right click", "Message not found");
	}

	@Test
	public void validateActionDoubleClick() {
		WebElement doubleClickBtn = isElementClickable(By.cssSelector("#doubleClickBtn"), 5);
		actions.moveToElement(doubleClickBtn).doubleClick().perform();
		WebElement doubleClickMsg = isElementDisplayed(By.cssSelector("#doubleClickMessage"), 5);
		Assert.assertEquals(doubleClickMsg.getText(), "You have done a double click", "Message not found");
	}

	@Test
	public void validateActionToolTip() {
		driver.navigate().to("https://demoqa.com/tool-tips");
		WebElement toolTipBtn = isElementClickable(By.cssSelector("#toolTipButton"), 5);
		actions.moveToElement(toolTipBtn).perform();
		wait.until(ExpectedConditions.attributeContains(By.cssSelector("#toolTipButton"), "aria-describedby",
				"buttonToolTip"));
		// sleep();

		Assert.assertEquals(toolTipBtn.getAttribute("aria-describedby"), "buttonToolTip", "Tool tip not visible");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}




