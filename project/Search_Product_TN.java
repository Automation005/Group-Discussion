package com.complete.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search_Product_TN {
	

	public static void main(String[] args) {
	    WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		
	    String actuatTitle = driver.getTitle();
		String expctedTitle = ("Your Store");
		String actualCurrent = driver.getCurrentUrl();
		String expectedCurrentUrl = "https://tutorialsninja.com/demo";
		
		WebElement Cart = driver.findElement(By.cssSelector("span#cart-total"));
		WebElement CreateAccountLink = driver.findElement(By.linkText("My Account"));
		 
		if (actuatTitle.equals(expctedTitle) && Cart.isDisplayed() && CreateAccountLink.isEnabled()) {
			System.out.println("Landing page is correct");
			
			
		}else {
			System.out.println("Landing page is incorrect");		
			
		}
		 
		driver.findElement(By.cssSelector("input.form-control.input-lg")).sendKeys("HP");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		driver.findElement(By.xpath("//button[@type='button']/descendant::span[@class='hidden-xs hidden-sm hidden-md']")).click();
		
		
				
		

	}
}

