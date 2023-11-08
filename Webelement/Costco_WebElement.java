package com.Webelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Costco_WebElement {
	
	public WebDriver driver;
	
	@Test 
	public void webElement () {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.costco.com/");
		  
		 List<WebElement> links =driver.findElements(By.tagName("a"));
		 System.out.println("Total number of links present is :" + links.size()); // number of links peresent in this webpage 
		 
		 
		 WebElement link201 = links.get(200); //  choose link 201 to open it 
		 
		 System.out.println("the text of the link is :" + link201.getText());// name of the link 
		 
		 System.out.println("the url for the link 200 is : " + link201.getAttribute("href")); //Url of that specific link
		 
		 System.out.println(link201.getLocation().x + "------>" + link201.getLocation().y); // find the cordinate x,y of the link 
		 
		 link201.click(); // open one of the links 
		 
		 // verification of certain Elemenet in new page 
		 
		  String ActualDisplayMessage = driver.findElement(By.cssSelector("div[class='eco-ks-hero-container'] h1")).getText();
		  String expectedDisplayMessage = "Kirkland Signature means quality and value.";
		  
		  Assert.assertTrue(ActualDisplayMessage.contains(expectedDisplayMessage));	 // verification  of  certain element in the new paga 
		                                                                            // you can declare more elemenet if you want 
		
	}
	
	@AfterMethod
	public void tearDown () {
	 driver.quit();
	}
	
	

}
