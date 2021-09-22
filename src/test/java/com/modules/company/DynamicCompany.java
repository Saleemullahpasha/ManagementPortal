package com.modules.company;

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

public class DynamicCompany  extends ExtentReportBaseClass{
	ChromeDriver driver;
	
	@Test
	public void AddCompany()  {
		test = extent.createTest("AddDynamicCompanyTest", "Testing the addition of Dynamic Company Fields");
		// login to the portal
		
		LoginScenarios.LandConfigTest();
		driver = LoginScenarios.driver;
		// click on company module
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Company']")));
		driver.findElementByXPath("//span[text()='Company']").click();
		// open company page
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Company Dynamic']")));
		driver.findElementByXPath("//span[text()='Company Dynamic']").click();
		//click on add button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Add New']")));
		driver.findElementByXPath("//span[text()='Add New']").click();
		
		// click on add dynamic button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Dynamic Field']")));
		driver.findElementByXPath("//span[text()='Dynamic Field']").click();
		//add data
		driver.findElementByName("labelText").sendKeys("Test Label");
		driver.findElementByName("defaultValue").sendKeys("Test");
		driver.findElementByName("minLength").sendKeys(Keys.chord(Keys.CONTROL, "a"), "0");
		driver.findElementByName("maxLength") .sendKeys(Keys.chord(Keys.CONTROL, "a"), "50");
		driver.findElementByName("placeHolderText").sendKeys("Testing");
		//driver.findElementByName("validation").sendKeys("");
		
	
		driver.findElementById("mui-component-select-type").click();
		List<WebElement> list2=driver.findElementsByXPath("//ul[contains(@class, 'MuiList-root MuiMenu-list MuiList-padding')]//li");
		if (list2.size()>0) {
			list2.get(1).click();
		}
	//	list2=null;
		driver.findElementById("mui-component-select-visibilityStatus");
		driver.findElementById("mui-component-select-visibilityStatus").click();
		List<WebElement> list=driver.findElementsByXPath("//ul[contains(@class, 'MuiList-root MuiMenu-list MuiList-padding')]//li");
		if (list.size()>0) {
			list.get(1).click();
		}
		/*
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Add New']")));
		driver.findElementByXPath("//span[text()='Add New']").click();
		
		// add data in the form
		
		driver.findElementByName("companyNameArabic").sendKeys("My Test Company");
		driver.findElementByName("companyNameBengali").sendKeys("My Test Company");
		driver.findElementByName("companyNameEnglish").sendKeys("My Test Company");
		driver.findElementByName("companyNameFrench").sendKeys("My Test Company");
		driver.findElementByName("companyNameTagalog").sendKeys("My Test Company");
		driver.findElementByName("companyNameUrdu").sendKeys("My Test Company");
		driver.findElementByName("serviceProvider").sendKeys("My Test Company");
		driver.findElementByName("usecaseId").sendKeys("My Test Company");
		driver.findElementByName("friType").sendKeys("My Test Company");
		driver.findElementById("mui-component-select-partialPayment").click();
		List<WebElement> list=driver.findElementsByXPath("//ul[contains(@class, 'MuiList-root MuiMenu-list MuiList-padding')]//li");
		if (list.size()>0) {
			list.get(1).click();
		}
		
		driver.findElementById("mui-component-select-companyTypeId").click();
		list=null;
		list=driver.findElementsByXPath("//ul[contains(@class, 'MuiList-root MuiMenu-list MuiList-padding')]//li");
		if (list.size()>0) {
			list.get(1).click();
		}
		String imagePath = System.getProperty("user.dir") + "/src/test/resources/test.png";
		driver.findElementByName("companyIcon").sendKeys(imagePath);
		
		//set the order number
		int i=1;
		while(i<=1000) {
			String num=String.valueOf(i);
			driver.findElementByName("order").sendKeys(num);
		if(driver.findElementByXPath("//form/div/div[11]/div/p").isDisplayed()) {
			if(driver.findElementByXPath("//form/div/div[11]/div/p").getText().matches("Order is already assigned"))
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
		driver.findElementById("mui-component-select-visibilityStatus").click();
		List<WebElement> list2=driver.findElementsByXPath("//ul[contains(@class, 'MuiList-root MuiMenu-list MuiList-padding')]//li");
		if (list2.size()>0) {
			list2.get(1).click();
		}
			// submit the form
		driver.findElementByXPath("//span[text()='Submit']").click();
		WebDriverWait wait1=new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
		test.log(Status.INFO, "Record added successfully");
		driver.close();*/
	}
	//Delete company
	@Test
	public void DelCompany() {
		test = extent.createTest("DeleteCompanyTest", "Testing the deletion of Company");
		// login to the portal
		
		LoginScenarios.LandConfigTest();
		driver = LoginScenarios.driver;
		// click on company module
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Company']")));
		driver.findElementByXPath("//span[text()='Company']").click();
		// open type page
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[3]/div/div/div/a[4]")));
		driver.findElementByXPath("//div[3]/div/div/div/a[4]").click();
		driver.findElementByXPath("//main/div[2]");
		// locate the table on page
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
		WebElement htmltable = driver.findElement(By.tagName("table"));
		// check if any record appear in the table
		List<WebElement> tableRows = htmltable.findElements(By.xpath("//table/tbody/tr"));
		if (tableRows.size() > 0) {
			// if records are present, check the number of record present using pagination
			// field
			String size = driver.findElementByXPath("//main/div[2]/div/div/p[2]").getText();
			String oldsize = size.substring(size.indexOf('f') + 1);
			oldsize = oldsize.trim();

			// store the current number of records
			int length = Integer.parseInt(oldsize);
			// perform deletion by clicking the delete button
			tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[7]/button[2]")).click();
			driver.findElementByXPath("//span[text()='Yes']").click();
			test.log(Status.INFO, "Clicked the delete button");
			WebDriverWait wait2 = new WebDriverWait(driver, 20);
			wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[1]/td[7]/button[2]")));
			// get the new number of records after deletion using pagination field
			size = driver.findElementByXPath("//main/div[2]/div/div/p[2]").getText();
			oldsize = size.substring(size.indexOf('f') + 1);
			oldsize = oldsize.trim();
			// this line will check if record is deleted from the list
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
	//update company
	@Test
	public void UpdateCompany() {
		
		test = extent.createTest("UpdateCompanyTest", "Testing the update feature");
		// login to the portal
		LoginScenarios.LandConfigTest();
		driver = LoginScenarios.driver;
		// click on company module
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Company']")));
		driver.findElementByXPath("//span[text()='Company']").click();
		// open type page
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[3]/div/div/div/a[4]")));
		driver.findElementByXPath("//div[3]/div/div/div/a[4]").click();
		driver.findElementByXPath("//main/div[2]");
		// locate the table on page
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
		WebElement htmltable = driver.findElement(By.tagName("table"));
		// check if any record appear in the table
		List<WebElement> tableRows = htmltable.findElements(By.xpath("//table/tbody/tr"));
		if (tableRows.size() > 0) {
			tableRows.get(0).findElement(By.xpath("//table/tbody/tr[1]/td[7]/button[1]")).click();

			// update data in the form

			driver.findElementByName("companyNameArabic").sendKeys(Keys.chord(Keys.CONTROL, "a"), "My updated Company");
			driver.findElementByName("companyNameBengali").sendKeys(Keys.chord(Keys.CONTROL, "a"), "My updated Company");
			driver.findElementByName("companyNameEnglish").sendKeys(Keys.chord(Keys.CONTROL, "a"), "My updated Company");
			driver.findElementByName("companyNameFrench").sendKeys(Keys.chord(Keys.CONTROL, "a"), "My updated Company");
			driver.findElementByName("companyNameTagalog").sendKeys(Keys.chord(Keys.CONTROL, "a"), "My updated Company");
			driver.findElementByName("companyNameUrdu").sendKeys(Keys.chord(Keys.CONTROL, "a"), "My updated Company");
			driver.findElementByName("serviceProvider").sendKeys(Keys.chord(Keys.CONTROL, "a"), "My updated Company");
			driver.findElementByName("usecaseId").sendKeys(Keys.chord(Keys.CONTROL, "a"), "My updated Company");
			driver.findElementByName("friType").sendKeys(Keys.chord(Keys.CONTROL, "a"), "My updated Company");
			driver.findElementById("mui-component-select-partialPayment").click();
			driver.findElementByXPath("//*[@id=\"Company-partialPayment\"]/div[3]/ul/li[2]").click();
			driver.findElementById("mui-component-select-companyTypeId").click();
			driver.findElementByXPath("//*[@id=\"Company-companyTypeId\"]/div[3]/ul/li[2]").click();
			driver.findElementByName("companyIcon").sendKeys("C:\\Users\\Iqra Andleeb\\Downloads\\test.png");
			driver.findElementById("mui-component-select-visibilityStatus").click();
			driver.findElementByXPath("//*[@id=\"Company-visibilityStatus\"]/div[3]/ul/li[2]").click();
			// submit the form
			driver.findElementByXPath("//span[text()='Update']").click();
			WebDriverWait wait2 = new WebDriverWait(driver, 20);
			wait2.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//main/div[1]/div[2]/button")));
			
		}
		else
		{
			 test.log(Status.INFO, "No data found for update");
			
		}
        driver.close();
	}
}
