package com.browser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Marketplace {

public WebDriver driver;
	
	@BeforeTest
	public void drivers() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	
	public void login() {
		driver.get("http://3.9.241.58/marketplace2-4/default/customer/account/login/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("mysynary@tempmailin.com");
		driver.findElement(By.id("pass")).sendKeys("hassaN123@");
		driver.findElement(By.id("send2")).click();
		
	}
	
	@Test(priority=2)
	public void placeorder() throws Exception  {
		login();
		driver.findElement(By.xpath("//span[contains(.,'Products')]")).click();                                         			// products
	//	driver.findElement(By.xpath("(//div[@class='card pt-4'])[1]")).click();   // click on watches
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ol/li[5]/a"))));
		driver.findElement(By.xpath("//ol/li[5]/a")).click();
		WebDriverWait waitl = new WebDriverWait(driver, 40);
		waitl.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[@class='card-seller-img'])[1]"))));
		driver.findElement(By.xpath("(//a[@class='card-seller-img'])[1]")).click();     			// watch img
//		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='Add to Cart']"))));
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();	       // click on add to cart
		Thread.sleep(2500);
	/*	
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[7]/a[1]"))).click();
		new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"top-cart-btn-checkout\"]")));
		new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"top-cart-btn-checkout\"]"))).click(); // cart icon
		*/
	
	/*	WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[7]/a[1]"))));
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[7]/a[1]")).click();*/
		
		driver.findElement(By.xpath("//span[@class='counter qty']")).click();
		//driver.findElement(By.id("top-cart-btn-checkout")).click();
		driver.findElement(By.xpath("//span[text()='View and Edit Cart']")).click();
		Thread.sleep(5000);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='page-title']"))));
		String title=driver.findElement(By.xpath("//h1[@class='page-title']")).getText();
		SoftAssert sf= new SoftAssert();
		sf.assertEquals(title, "Shopping Cart");
		
		driver.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();
		new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("ko_unique_2"))));
		driver.findElement(By.name("ko_unique_2")).click();
		
	}
	
	
	
	@AfterTest
	public void ConnClose() {
//		driver.close();
//		driver.quit();
		
	}
	
	
	
	
}
