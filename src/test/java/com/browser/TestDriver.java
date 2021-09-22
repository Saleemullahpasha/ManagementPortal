package com.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDriver {

/*	private static WebDriver driver;	
	
	@Parameters("browserName")
	@Test
public static void Login(String browserName) {
	
	driver=BrowserDriver.setBrowser(browserName);
	
	driver.get("https://nstp-slmfrontend.evampsaanga.com/");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("rabail@managementportal.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("demo1234");
	driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.urlContains("dashboard"));
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div/h4")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main/h2")));
	if(driver.findElement(By.xpath("//span[text()='Dashboard']")).isEnabled())
		Reporter.log("Landed on dashboard");
	else  
		Reporter.log("Error while Landing on dashboard");
	driver.close();
}

*/
}
