package com.sai.selAssmt1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingWebTables extends TestBase {

	@BeforeMethod
	public void setUp() {
		initialSetUp();
		wd.get("https://www.w3schools.com/html/html_tables.asp");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, null);

	}

	@Test
	public void testingWebTable() {
		List<WebElement> numOfRows = wd.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
		List<WebElement> numOfColumns = wd.findElements(By.xpath("//table[@id='customers']//tbody//tr//th"));

		System.out.println("No of rows: " + numOfRows.size());// 7
		System.out.println("No of colums: " + numOfColumns.size());// 3

		String beforeXpath = "//table[@id='customers']//tbody//tr[";
		// table[@id='customers']//tbody//tr[4]//td[3]
		String afterXapth = "]//td[";

		for (int i = 2; i <= numOfRows.size(); i++) {// 2<=7
			for (int j = 1; j <= numOfColumns.size(); j++) {// 1<=3
				WebElement selectedTableElement = wd.findElement(By.xpath(beforeXpath + i + afterXapth + j + "]"));
				if (selectedTableElement.getText().equals("Helen Bennett")) {
					Assert.assertEquals(selectedTableElement.getText(), "Helen Bennett", "Value Mismatch!!!");
				}
			}

			break;

		}

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}