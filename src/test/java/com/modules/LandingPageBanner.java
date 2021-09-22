package com.modules;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.extent.report.ExtentReportBaseClass;
import com.login.LoginScenarios;

public class LandingPageBanner extends ExtentReportBaseClass  {
	ChromeDriver driver;
	
	@Test
	public void AddBanner() {
		 test = extent.createTest("AddBannerTest", "Testing the addition of banner");
		//login to the portal
		LoginScenarios.LandConfigTest();
		driver=LoginScenarios.driver;
		test.log(Status.INFO, "Logged in to the portal");
		//open Landing page banner module
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Landing Page Banner']")));
		driver.findElementByXPath("//span[text()='Landing Page Banner']").click();
		test.log(Status.INFO, "Opened Banner Module");
		//click on Add button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
		driver.findElementByXPath("//main/div[1]/div[2]/button").click();
		test.log(Status.INFO, "Clicked Add button");
		//add banner data
		String imagePath = System.getProperty("user.dir") + "/src/test/resources/payment.jpg";
		driver.findElementByName("imageUrl").sendKeys(imagePath);
		driver.findElementById("mui-component-select-menu").click();
		driver.findElementByXPath("//ul/li[2]").click();
		driver.findElementById("mui-component-select-purpose").click();
		driver.findElementByXPath("//ul/li[2]").click();
		//set order
		int i=1;
		while(i<=1000) {
		String num=String.valueOf(i);
		driver.findElementByName("sortOrder").click();
		driver.findElementByName("sortOrder").sendKeys(num);
		if(driver.findElementByXPath("//form/div/div[4]/div/p").isDisplayed()) {
			if(driver.findElementByXPath("//form/div/div[4]/div/p").getText().matches("Order is already assigned"))
			{ 
				i++;
				num=String.valueOf(i);
				Actions action=new Actions(driver);
				WebElement orderfield=driver.findElementByName("sortOrder");
				action.keyDown(orderfield, Keys.CONTROL).sendKeys("a").sendKeys(Keys.BACK_SPACE).build().perform();
				driver.findElementByName("sortOrder").sendKeys(num);
			}
			else
				break;
		}
		else
			break;

		}//end of while loop
		driver.findElementByXPath("//form/div/div[5]/div/div").click();
		driver.findElementByXPath("//ul/li[3]").click();
		test.log(Status.INFO, "Added required information to submit form");
		//submit the form
		driver.findElementByXPath("//span[text()='Submit']").click();
		test.log(Status.PASS, "Record added successfully");
		driver.close();
	}
	
	//delete banner
	@Test
	
	public void DeleteBanner() throws Exception {
		test = extent.createTest("DeleteBannerTest", "Testing Delete Feature");
		//login to the portal
		
		LoginScenarios.LandConfigTest();
		driver=LoginScenarios.driver;
		 test.log(Status.INFO, "Logged in to the portal");
		//open Banners module
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Landing Page Banner']")));
		driver.findElementByXPath("//span[text()='Landing Page Banner']").click();
		 test.log(Status.INFO, "Opened Banner Module");
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
		tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[7]/button[2]")).click();
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
	public void UpdateBanner() throws Throwable {
		
		test = extent.createTest("UpdateBannerTest", "Testing Update Feature");	
		//login to the portal
	
		LoginScenarios.LandConfigTest();
		driver=LoginScenarios.driver;
		test.log(Status.INFO, "Logged in to the portal");
		//open banner module
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Landing Page Banner']")));
		driver.findElementByXPath("//span[text()='Landing Page Banner']").click();
		driver.findElementByXPath("//main/div[2]");
		 test.log(Status.INFO, "Opened Banner Module");
		//locate the table on page
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
		WebElement htmltable=driver.findElement(By.tagName("table"));
		//check if any record appear in the table
		List<WebElement> tableRows =  htmltable.findElements(By.xpath("//table/tbody/tr"));
		 test.log(Status.INFO, "Checking records for update");
		if(tableRows.size()>0) {
		//click on edit button of first row
			tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[7]/button[1]")).click();
			test.log(Status.INFO, "Clicked on the update icon");
			//update banner data
			String imagePath = System.getProperty("user.dir") + "/src/test/resources/payment.jpg";
			driver.findElementByName("imageUrl").sendKeys(imagePath);
			driver.findElementById("mui-component-select-menu").click();
			driver.findElementByXPath("//ul/li[2]").click();
			driver.findElementById("mui-component-select-purpose").click();
			driver.findElementByXPath("//ul/li[2]").click();
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
	
	