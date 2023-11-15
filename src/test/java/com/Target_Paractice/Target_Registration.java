package com.Target_Paractice;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Target_Registration {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.target.com/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.linkText("Create Account")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id=username]")).sendKeys(Util.emailWithDateTimeStamp());
		driver.findElement(By.cssSelector("input#firstname")).sendKeys("auto");
		driver.findElement(By.cssSelector("input#lastname")).sendKeys("java");
		driver.findElement(By.cssSelector("input#phone")).sendKeys("5104840716");
		driver.findElement(By.cssSelector("input.h-text-left")).sendKeys("Automation23$");
		driver.findElement(By.cssSelector("input[name=keepMeSignedIn]")).click();
		driver.findElement(By.cssSelector("button#createAccount")).click();
		
				
	}
	

}
