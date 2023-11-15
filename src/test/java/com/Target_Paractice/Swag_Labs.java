package com.Target_Paractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Swag_Labs {
    WebDriver driver;  
	SoftAssert softassert = new SoftAssert();//create the object of the soft assert class
	public ChromeOptions options;
	@BeforeMethod
	public void setup() {
		driver= new ChromeDriver();   //create object of my ChromeDriver  // abstract method of WebDriver
		driver.manage().deleteAllCookies(); // use refrence driver to call those abstract methods
		//options.addArguments("--remote-debugging-port=9222"); 
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://saucedemo.com");
	    System.out.println(driver.getTitle());
	    
		
	}
	
	@Test(priority = 1)
	public void veriyLoginWithValidCredintial() {
		
	    driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
	    driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
	    driver.findElement(By.cssSelector("input#login-button")).click();
	    softassert .assertTrue(driver.findElement(By.cssSelector("span.title")).isDisplayed());
	    softassert.assertAll();	
	    driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
	    
	   String actualtextbox = driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).getText();
	   String expectedtextbox = "Add to cart";
	   softassert.assertTrue(actualtextbox.equals(expectedtextbox));
	   if (actualtextbox.equals(expectedtextbox)) {
		   System.out.println("page element exists");
		   
	   }else
	   
	   System.out.println("page element don't exists");
	   
	   
	    
		
	}
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredintials() {
		    driver.findElement(By.cssSelector("input#user-name")).sendKeys("azul");
		    driver.findElement(By.cssSelector("input#password")).sendKeys("secret");
		    driver.findElement(By.cssSelector("input#login-button")).click();
		    String actualWarningMessage=driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		    String expectedWarningMessage ="Epic sadface: Username and password do not match any user in this service";
		    softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		    softassert.assertAll();
		    
		    
	}
	@Test(priority = 3)
	public void verifyLoginWithNoCredintial() {
		 driver.findElement(By.cssSelector("input#login-button")).click();
		 String actualWarningMessage= driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		 String expectedWarningMessage ="Epic sadface: Username is required";
		 softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		 softassert.assertAll();
		 
		
	}
	
	@AfterMethod
	public void tearDown() {
	//driver.quit();	
	}
	

}
