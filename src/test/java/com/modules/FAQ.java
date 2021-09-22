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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.extent.report.ExtentReportBaseClass;
import com.login.LoginScenarios;

public class FAQ extends ExtentReportBaseClass{
	ChromeDriver driver;
	
	@Test
	
	public void AddFAQ() {
		test = extent.createTest("AddFAQTest", "Testing the addition of FAQ");
		//login to the portal
		
		LoginScenarios.LandConfigTest();
		driver=LoginScenarios.driver;
		test.log(Status.INFO, "Logged in to the portal");
		//open FAQ module
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='FAQ']")));
		driver.findElementByXPath("//span[text()='FAQ']").click();
		test.log(Status.INFO, "Opened FAQ Module");
		//click on Add button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
		driver.findElementByXPath("//main/div[1]/div[2]/button").click();
		test.log(Status.INFO, "Clicked Add button");
		//add FAQ data
		driver.findElementByName("questionArabic").sendKeys("What is the price of this bundle?");
		driver.findElementByName("questionBengali").sendKeys("What is the price of this bundle?");
		driver.findElementByName("questionEnglish").sendKeys("What is the price of this bundle?");
		driver.findElementByName("questionFrench").sendKeys("What is the price of this bundle?");
		driver.findElementByName("questionHindi").sendKeys("What is the price of this bundle?");
		driver.findElementByName("questionTagalog").sendKeys("What is the price of this bundle?");
		driver.findElementByName("questionUrdu").sendKeys("What is the price of this bundle?");
		driver.findElementByName("answerArabic").sendKeys("Price is Rs.100");
		driver.findElementByName("answerBengali").sendKeys("Price is Rs.100");
		driver.findElementByName("answerEnglish").sendKeys("Price is Rs.100");
		driver.findElementByName("answerFrench").sendKeys("Price is Rs.100");
		driver.findElementByName("answerHindi").sendKeys("Price is Rs.100");
		driver.findElementByName("answerTagalog").sendKeys("Price is Rs.100");
		driver.findElementByName("answerUrdu").sendKeys("Price is Rs.100");
		//set order
		int i=1;
		while(i<=1000) {
			String num=String.valueOf(i);
			driver.findElementByName("order").click();
			driver.findElementByName("order").sendKeys(num);
			if(driver.findElements( By.xpath("//label[text()='Order']//following-sibling::p") ).size() != 0) {
			if(driver.findElementByXPath("//label[text()='Order']//following-sibling::p").getText().matches("Order is already assigned"))
			{ 
			i++;
			num=String.valueOf(i);
			Actions action=new Actions(driver);
			WebElement orderfield=driver.findElementByName("order");
			action.keyDown(orderfield, Keys.CONTROL).sendKeys("a").sendKeys(Keys.BACK_SPACE).build().perform();
			driver.findElementByName("order").sendKeys(num);
			}
			else
				break;
		}
		else
			break;
			
		}//end of while loop
		driver.findElementById("mui-component-select-visibility").click();
		driver.findElementByXPath("//*[@id=\"menu-visibility\"]/div[3]/ul/li[2]").click();
		test.log(Status.INFO, "Added required information to submit form");
		//submit the form
	    driver.findElementByXPath("//span[text()='Submit']").click();
	    test.log(Status.PASS, "Record added successfully");
		driver.close();
	}
	
	@Test
	public void DeleteFAQ() {
		 ExtentTest test = extent.createTest("DeleteVersionHistory", "Testing Delete Feature");
		//login to the portal
		
		LoginScenarios.LandConfigTest();
		driver=LoginScenarios.driver;
		 test.log(Status.INFO, "Logged in to the portal");
		//open banks module
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='FAQ']")));
		driver.findElementByXPath("//span[text()='FAQ']").click();
		 test.log(Status.INFO, "Opened FAQ Module");
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
		tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[17]/div/button[2]")).click();
		driver.findElementByXPath("//span[text()='Yes']").click();
		 test.log(Status.INFO, "Clicked the delete button");
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[1]/td[17]/div/button[2]")));
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
	
	//update FAQ
	@Test
	public void UpdateFAQ() throws Throwable {
		 ExtentTest test = extent.createTest("UpdateVersionTest", "Testing Update Feature");	
		// login to the portal

		LoginScenarios.LandConfigTest();
		driver = LoginScenarios.driver;
		test.log(Status.INFO, "Logged in to the portal");
		// open banks module
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='FAQ']")));
		driver.findElementByXPath("//span[text()='FAQ']").click();
		 test.log(Status.INFO, "Opened FAQ Module");
		driver.findElementByXPath("//main/div[2]");
		// locate the table on page
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
		WebElement htmltable = driver.findElement(By.tagName("table"));
		// check if any record appear in the table
		List<WebElement> tableRows = htmltable.findElements(By.xpath("//table/tbody/tr"));
		 test.log(Status.INFO, "Checking records for update");
		if(tableRows.size()>0) {
		//click on edit button of first row
			tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[17]/div/button[1]")).click();
			test.log(Status.INFO, "Clicked on the update icon");
			//update FAQ data
			driver.findElementByName("questionArabic").sendKeys(Keys.chord(Keys.CONTROL, "a"),"What is the updated price of this bundle?");
			driver.findElementByName("questionBengali").sendKeys(Keys.chord(Keys.CONTROL, "a"),"What is the updated price of this bundle?");
			driver.findElementByName("questionEnglish").sendKeys(Keys.chord(Keys.CONTROL, "a"),"What is the updated price of this bundle?");
			driver.findElementByName("questionFrench").sendKeys(Keys.chord(Keys.CONTROL, "a"),"What is the updated price of this bundle?");
			driver.findElementByName("questionHindi").sendKeys(Keys.chord(Keys.CONTROL, "a"),"What is the updated price of this bundle?");
			driver.findElementByName("questionTagalog").sendKeys(Keys.chord(Keys.CONTROL, "a"),"What is the updated price of this bundle?");
			driver.findElementByName("questionUrdu").sendKeys(Keys.chord(Keys.CONTROL, "a"),"What is the updated price of this bundle?");
			driver.findElementByName("answerArabic").sendKeys(Keys.chord(Keys.CONTROL, "a"),"Updated Price is Rs.100");
			driver.findElementByName("answerBengali").sendKeys(Keys.chord(Keys.CONTROL, "a"),"updated Price is Rs.100");
			driver.findElementByName("answerEnglish").sendKeys(Keys.chord(Keys.CONTROL, "a"),"updated Price is Rs.100");
			driver.findElementByName("answerFrench").sendKeys(Keys.chord(Keys.CONTROL, "a"),"updated Price is Rs.100");
			driver.findElementByName("answerHindi").sendKeys(Keys.chord(Keys.CONTROL, "a"),"updated Price is Rs.100");
			driver.findElementByName("answerTagalog").sendKeys(Keys.chord(Keys.CONTROL, "a"),"updated Price is Rs.100");
			driver.findElementByName("answerUrdu").sendKeys(Keys.chord(Keys.CONTROL, "a"),"updated Price is Rs.100");
			
			driver.findElementById("mui-component-select-visibility").click();
			driver.findElementByXPath("//*[@id=\"menu-visibility\"]/div[3]/ul/li[2]").click();
			
			//submit the form
			driver.findElementByXPath("//span[text()='Update']").click();
			test.log(Status.INFO, "Form Submitted with updated data");
			wait1.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
			test.log(Status.INFO, "Record Updated successfully");
	}
		else
		{
			 test.log(Status.INFO, "No data found for update");
			
		}
      driver.close();
		
	}
	
}
