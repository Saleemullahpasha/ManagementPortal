package com.modules;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import com.extent.report.ExtentReportBaseClass;
import com.login.LoginScenarios;

public class BlockedIMEI extends ExtentReportBaseClass  {
	ChromeDriver driver;
	
	@Test
	public void AddBlockedIMEI() {
		 test = extent.createTest("AddBlockedIMEITest", "Testing the addition of Blocked IMEI");
		  
		//login to the portal
		LoginScenarios.LandConfigTest();
		driver=LoginScenarios.driver;
		test.log(Status.INFO, "Logged in to the portal");
		//open IMEI module
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Blocked IMEI']")));
		driver.findElementByXPath("//span[text()='Blocked IMEI']").click();
		test.log(Status.INFO, "Opened Blocked IMEI Module");
		//click on Add button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
		driver.findElementByXPath("//main/div[1]/div[2]/button").click();
		test.log(Status.INFO, "Clicked Add button");
		//add Version data
		driver.findElementByName("imei").sendKeys("232323232323231");
	    test.log(Status.INFO, "Added required information to submit form");
		//submit the form
		driver.findElementByXPath("//span[text()='Submit']").click();
		test.log(Status.PASS, "Record added successfully");
		driver.close();
	
	}
	
	@Test
	
	public void DeleteIMEI() throws Exception {
	test = extent.createTest("DeleteIMEITest", "Testing Delete Feature");
		//login to the portal
		
		LoginScenarios.LandConfigTest();
		driver=LoginScenarios.driver;
		 test.log(Status.INFO, "Logged in to the portal");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Blocked IMEI']")));
		driver.findElementByXPath("//span[text()='Blocked IMEI']").click();
		 test.log(Status.INFO, "Opened Blocked IMEI Module");
		driver.findElementByXPath("//main/div[2]");
		//locate the table on page
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
	    WebElement htmltable=driver.findElement(By.tagName("table"));
	    //check if any record appear in the table
		List<WebElement> tableRows =  htmltable.findElements(By.xpath("//table/tbody/tr"));
		test.log(Status.INFO, "Checking if any records are present");
		if(tableRows.size()>0) {
			//if records are present, check the number of record present using pagination field
			String size=driver.findElementByXPath("//main/div[2]/div/div/p[2]").getText();
			String oldsize=size.substring(size.indexOf('f')+1);
			oldsize=oldsize.trim();
		
			//store the current number of records
			int length=Integer.parseInt(oldsize);
			//perform deletion by clicking the delete button
		tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[4]/div/button[2]")).click();
		driver.findElementByXPath("//span[text()='Yes']").click();
		 test.log(Status.INFO, "Clicked the delete button");
		Thread.sleep(1000);
		//get the new number of records after deletion using pagination field
		size=driver.findElementByXPath("//main/div[2]/div/div/p[2]").getText();
		oldsize=size.substring(size.indexOf('f')+1);
		oldsize=oldsize.trim();
		//this line will check if record is deleted from the list
		if(length>Integer.parseInt(oldsize))
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
	
	@Test
	public void UpdateIMEI() throws Throwable {
		
		test = extent.createTest("UpdateBlockedIMEI", "Testing Update Feature");	
		//login to the portal
	
		LoginScenarios.LandConfigTest();
		driver=LoginScenarios.driver;
		test.log(Status.INFO, "Logged in to the portal");
		//open banner module
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Blocked IMEI']")));
		driver.findElementByXPath("//span[text()='Blocked IMEI']").click();
		driver.findElementByXPath("//main/div[2]");
		 test.log(Status.INFO, "Opened Blocked IMEI Module");
		//locate the table on page
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
		WebElement htmltable=driver.findElement(By.tagName("table"));
		//check if any record appear in the table
		List<WebElement> tableRows =  htmltable.findElements(By.xpath("//table/tbody/tr"));
		 test.log(Status.INFO, "Checking records for update");
		if(tableRows.size()>0) {
		//click on edit button of first row
			tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[4]/div/button[1]")).click();
			test.log(Status.INFO, "Clicked on the update icon");
			//update version data
			driver.findElementByName("imei").sendKeys(Keys.chord(Keys.CONTROL, "a"),"121212121212121");
			
			test.log(Status.INFO, "Form Submitted with updated data");
			//submit the form
			driver.findElementByXPath("//span[text()='Update']").click();
			wait1.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
			test.log(Status.INFO, "Record Updated successfully");;
		}
		else
		{
			 test.log(Status.INFO, "No data found for update");
			
		}
        driver.close();
		
	}
	


}
