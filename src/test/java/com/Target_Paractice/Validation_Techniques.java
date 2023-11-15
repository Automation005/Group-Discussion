package com.Target_Paractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Validation_Techniques {
	public WebDriver driver;
	
	
	@Test (priority =1)
	public void use_Wrong_Password() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.target.com/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("//span[@class='styles__ListItemText-sc-diphzn-1 jaMNVl'][text()='Sign in']")).click();
		driver.findElement(By.cssSelector("input#username")).sendKeys("mayhachour@gmail.com");
		driver.findElement(By.cssSelector("input#password")).sendKeys("Maya4092012");
		driver.findElement(By.cssSelector("button#login")).click();
		 
		 }
	@Test(priority =2)
	public void costcoLogin () {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.costco.com");
		driver.findElement(By.cssSelector("a#header_sign_in")).click();
		driver.findElement(By.cssSelector("#signInName")).sendKeys("java@gmail.com");
		driver.findElement(By.cssSelector("input#password")).sendKeys("java@123");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		
		
		
		
		
		
		
	}
		
		
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
		
	}

}
