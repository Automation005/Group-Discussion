package com.Macys_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics_WeDriver {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.walmart.com");
	    driver.findElement(By.linkText("Account")).click();
	    
	
		
		
		
		

	}

}
