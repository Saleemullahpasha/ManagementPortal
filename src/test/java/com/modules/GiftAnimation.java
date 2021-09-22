package com.modules;

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

public class GiftAnimation extends ExtentReportBaseClass {
	ChromeDriver driver;

	@Test
	
	public void AddGiftTest() throws Exception {
		
        // creates a test to be added in extent report  
       test = extent.createTest("AddGiftTest", "Testing the addition of gift animation");
       /*
        test.info("This step shows usage of info(details)");     
        // log with snapshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");*/
        LoginScenarios.LandConfigTest();
		driver=LoginScenarios.driver;
		test.log(Status.INFO, "Logged in to the portal");
		//open gift animation module
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Gift Animation']")));
		driver.findElementByXPath("//span[text()='Gift Animation']").click();
		test.log(Status.INFO, "Opened Gift Animation Module");
		//click on Add button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
		driver.findElementByXPath("//main/div[1]/div[2]/button").click();
		test.log(Status.INFO, "Clicked Add button");
		//add Gift data
		String filePath = System.getProperty("user.dir") + "/src/test/resources/Test.json";
		driver.findElementByName("fileUrl").sendKeys(filePath);
		driver.findElementByName("description").sendKeys("This is Test description while running selenium test script");
		test.log(Status.INFO, "Added required information to submit form");
		//submit the form
		driver.findElementByXPath("//span[text()='Submit']").click();
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
		test.log(Status.PASS, "Record added successfully");
		driver.close();
	}
	@Test
	
	public void DeleteGiftTest() throws InterruptedException {
	 test = extent.createTest("DeleteGiftTest", "Testing the deletion of gift animation");
	 //login to the portal
	  LoginScenarios.LandConfigTest();
	  driver=LoginScenarios.driver;
	  test.log(Status.INFO, "Logged in to the portal");
		//open Gift Animation module
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Gift Animation']")));
		driver.findElementByXPath("//span[text()='Gift Animation']").click();
		driver.findElementByXPath("//main/div[2]");
		test.log(Status.INFO, "Opened Gift Animation Module");
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
		tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[3]/button[2]")).click();
		 test.log(Status.INFO, "Clicked the delete button");
		
		driver.findElementByXPath("//span[text()='Yes']").click();
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[1]/td[3]/button[2]")));
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
	public void UpdateGiftTest() throws Throwable {

    test = extent.createTest("UpdateGiftTest", "Testing Update Feature");	
	//login to the portal

	LoginScenarios.LandConfigTest();
	driver=LoginScenarios.driver;
	 test.log(Status.INFO, "Logged in to the portal");
	//open gifts module
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Gift Animation']")));
	driver.findElementByXPath("//span[text()='Gift Animation']").click();
	driver.findElementByXPath("//main/div[2]");
	 test.log(Status.INFO, "Opened Gfit Animation Module");
	//locate the table on page
	WebDriverWait wait1 = new WebDriverWait(driver, 20);
	wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
	WebElement htmltable=driver.findElement(By.tagName("table"));
	//check if any record appear in the table
	List<WebElement> tableRows =  htmltable.findElements(By.xpath("//table/tbody/tr"));
	 test.log(Status.INFO, "Checking records for update");
	if(tableRows.size()>0) {
		//click on edit button of first row
		tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[3]/button[1]")).click();
		 test.log(Status.INFO, "Clicked on the update icon");
		//update gift data
		 String filePath = System.getProperty("user.dir") + "/src/test/resources/Test.json";
		 driver.findElementByName("fileUrl").sendKeys(filePath);
		 driver.findElementByName("description").sendKeys(Keys.chord(Keys.CONTROL, "a"),"This is Updated Test description while running selenium test script");
		//submit the form
		driver.findElementByXPath("//span[text()='Submit']").click();
		test.log(Status.INFO, "Form Submitted with updated data");
		wait1.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
		test.log(Status.INFO, "Record Updated successfully");
	}
	else
	{
		//Reporter.log("No data exists");
		 test.log(Status.INFO, "No data found for update");
	}
	driver.close();

}

}
