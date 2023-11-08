package com.Target_Paractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_Drop_Down {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.petco.com");
	driver.findElement(By.cssSelector("button[aria-label='My Account']")).click();
	driver.findElement(By.cssSelector("button[style='margin-top:1.0625rem']")).click();
	driver.findElement(By.cssSelector("input#email")).sendKeys(Util.emailWithDateTimeStamp());
	driver.findElement(By.cssSelector("button[name=action]")).click();
	driver.findElement(By.cssSelector("input#password")).sendKeys("Selenium@123");
	driver.findElement(By.cssSelector("button[name=action]")).click();
	
	
	
	
	

	}

}
