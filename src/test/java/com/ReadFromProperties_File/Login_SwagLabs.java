package com.ReadFromProperties_File;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_SwagLabs {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream ip;
	public ChromeOptions options;
	

	@BeforeMethod
	public void setup() throws Exception {
		driver = new ChromeDriver(options);
	   options = new ChromeOptions();
		options.addArguments("--headless");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(200));
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\ReadFromProperties_File\\data.properties");
		prop.load(ip);
		driver.get(prop.getProperty("Url"));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		

	}

	@Test(priority = 1)
	public void signWithValidUserNameAndValidPassword() {

		driver.findElement(By.cssSelector("#user-name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.cssSelector("#password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.cssSelector("#login-button")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("span.title")).isDisplayed());
		String actualAddToCartMessage = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).getText();
		String expectedAddToCartMessage = prop.getProperty("expectedAddToCartMessage");
		
		Assert.assertTrue(actualAddToCartMessage.equals(expectedAddToCartMessage));
		

		if (expectedAddToCartMessage.equals(actualAddToCartMessage)) {

			System.out.println("the logging page is opened");

		} else
			System.out.println("the credintials are wrong");
	}
	@Test(priority = 2 )
	public void signWithValidUserNameAndInvalidPassword() {
		driver.findElement(By.cssSelector("#user-name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.cssSelector("#password")).sendKeys(prop.getProperty("InvalidPassword"));
		driver.findElement(By.cssSelector("#login-button")).click();
		String actualErrorMessage = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
		String expectedErrorMessage = prop.getProperty("expectedErrorMessage");
		
		Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage));
			
	
	}
	@Test(priority = 3)
	public void signWithInValidUserNameAndValidPassword() {
		driver.findElement(By.cssSelector("#user-name")).sendKeys(prop.getProperty("Invalidusername"));
		driver.findElement(By.cssSelector("#password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.cssSelector("#login-button")).click();
		String actualErrorMessage = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
		String expectedErrorMessage = prop.getProperty("expectedErrorMessage");
		
		Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage));
		
		
		
	}
	@Test(priority = 4)
	public void signWithInValidUserNameAndInvalidPassword() {
		driver.findElement(By.cssSelector("#user-name")).sendKeys(prop.getProperty("Invalidusername"));
		driver.findElement(By.cssSelector("#password")).sendKeys(prop.getProperty("InvalidPassword"));
		driver.findElement(By.cssSelector("#login-button")).click();
		String actualErrorMessage = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
		String expectedErrorMessage = prop.getProperty("expectedErrorMessage");
		
		Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage));
		
		
	}
	@Test (priority = 5)
	public void singInWithoutCredintials() {
		driver.findElement(By.cssSelector("#login-button")).click();
		String actualErrorNoCredent = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
		String expectedErrorNoCredent = prop.getProperty("expectedErrorNoCredent");
		Assert.assertTrue(actualErrorNoCredent.equals(expectedErrorNoCredent));
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	


}
