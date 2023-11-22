package com.Target_Paractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCart_SwagLabs {
	public WebDriver driver;
	public ChromeOptions options;
	public Properties prop;
	public FileInputStream ip;
	
	@BeforeMethod
	public void addToCart() throws Exception {
		driver = new ChromeDriver(); // create object of my ChromeDriver // abstract method of WebDriver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); // use reference driver to call those abstract methods
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\complete\\project\\Swag.properties");
		prop.load(ip);	
		driver.get("https://saucedemo.com");
	}
	
	
	@Test
	public void purchaseProducet() {
		
		
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
	}

}
