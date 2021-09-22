package com.modules.appmenu;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.extent.report.ExtentReportBaseClass;
import com.login.LoginScenarios;

public class AppSubMenu extends ExtentReportBaseClass  {
	
    ChromeDriver driver;
	
	@Test
	public void AddSubMenu() {
		test = extent.createTest("AddSubMenuTest", "Testing the addition of SubMenu");
		// login to the portal
		LoginScenarios.LandConfigTest();
		driver = LoginScenarios.driver;
		// click on App sub menu module
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='App Menu']")));
		driver.findElementByXPath("//span[text()='App Menu']").click();
		// open App sub menu page
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='App Submenu']")));
		driver.findElementByXPath("//span[text()='App Submenu']").click();
		// click on add button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Add New']")));
		driver.findElementByXPath("//span[text()='Add New']").click();
		// add data in the form
		driver.findElementById("mui-component-select-menuId").click();
		driver.findElementByXPath("//*[@id=\"menu-menuId\"]/div[3]/ul/li[2]").click();
		driver.findElementByName("subMenu").sendKeys("Test Submenu");
		driver.findElementByXPath("//form/div/div[3]/button[1]").click();
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Add New']")));
		test.log(Status.INFO, "Record added successfully");
		driver.close();
	}
	
	//delete submenu
	@Test
	public void DelSubmenu() {
		test = extent.createTest("AddSubMenuTest", "Testing the addition of SubMenu");
		// login to the portal
	
		LoginScenarios.LandConfigTest();
		driver = LoginScenarios.driver;
		// click on App sub menu module
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='App Menu']")));
		driver.findElementByXPath("//span[text()='App Menu']").click();
		// open App sub menu page
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='App Submenu']")));
		driver.findElementByXPath("//span[text()='App Submenu']").click();
		//locate the table on page
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
		WebElement htmltable = driver.findElement(By.tagName("table"));
		// check if any record appear in the table
		List<WebElement> tableRows = htmltable.findElements(By.xpath("//table/tbody/tr"));
		if (tableRows.size() > 0) {
			// if records are present, check the number of record present using pagination field
			String size = driver.findElementByXPath("//main/div[2]/div/div/p[2]").getText();
			String oldsize = size.substring(size.indexOf('f') + 1);
			oldsize = oldsize.trim();
			// store the current number of records
			int length = Integer.parseInt(oldsize);
			// perform deletion by clicking the delete button
			tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[3]/button[2]")).click();
			driver.findElementByXPath("//span[text()='Yes']").click();
			WebDriverWait wait2 = new WebDriverWait(driver, 20);
			wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[1]/td[3]/button[2]")));
			// get the new number of records after deletion using pagination field
			size = driver.findElementByXPath("//main/div[2]/div/div/p[2]").getText();
			oldsize = size.substring(size.indexOf('f') + 1);
			oldsize = oldsize.trim();
			// this line will check if record is deleted from the list
			if (length > Integer.parseInt(oldsize))
				test.log(Status.PASS, "Record deleted successfully");

			else
				test.log(Status.FAIL, "Record could not be deleted. Deletion failed");	

		}
		else
		{
			test.log(Status.INFO, "No Data Exists");

		}
		driver.close();
		
	}
	//update submenu
	@Test
	public void UpdateSubmenu() {
		test = extent.createTest("UpdateSubmenuTest", "Testing Update Feature");	
		// login to the portal
		
		LoginScenarios.LandConfigTest();
		driver = LoginScenarios.driver;
		// click on App sub menu module
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='App Menu']")));
		driver.findElementByXPath("//span[text()='App Menu']").click();
		// open App sub menu page
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='App Submenu']")));
		driver.findElementByXPath("//span[text()='App Submenu']").click();
		//locate the table on page
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
		WebElement htmltable = driver.findElement(By.tagName("table"));
		// check if any record appear in the table
		List<WebElement> tableRows = htmltable.findElements(By.xpath("//table/tbody/tr"));
		if (tableRows.size() > 0) {
			tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[3]/button[1]")).click();	
			driver.findElementById("mui-component-select-menuId").click();
			driver.findElementByXPath("//*[@id=\"menu-menuId\"]/div[3]/ul/li[2]").click();
			driver.findElementByName("subMenu").sendKeys(Keys.chord(Keys.CONTROL,"a"),"Updated Submenu");
			driver.findElementByXPath("//span[text()='Update']").click();
			WebDriverWait wait2 = new WebDriverWait(driver, 20);
			wait2.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
			test.log(Status.INFO, "Record Updated successfully");
			
		}
		else
		{
			 test.log(Status.INFO, "No data found for update");
			
		}

				driver.close();
		
	}
}
