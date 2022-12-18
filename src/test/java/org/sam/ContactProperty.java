package org.sam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ContactProperty {
	public static AndroidDriver<WebElement> driver;
    @BeforeClass
      private void tc1() {
		System.out.println("test case 1");

	}
    
    
	@Test
	private void launchBrowser() throws IOException {
		Properties property=new Properties();
        FileInputStream fis=new FileInputStream("C:\\Users\\SHOBI\\eclipse-workspace\\AppiumClass\\files\\Config.Properties");
        property.load(fis);
	
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", property.getProperty("platformName"));
		cap.setCapability("platformVersion", property.getProperty("Version"));
		cap.setCapability("deviceName", property.getProperty("deviceName"));
		cap.setCapability("udid", property.getProperty("udid"));
		cap.setCapability("appPackage", property.getProperty("com.android.contacts"));
		cap.setCapability("appActivity", property.getProperty("com.android.contacts.activities.PeopleActivity"));
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, cap);
		
        WebElement add = driver.findElement(By.xpath(property.getProperty("add")));
        add.click();
        WebElement phname = driver.findElement(By.xpath(property.getProperty("name")));
	    phname.sendKeys(property.getProperty("phname"));
	    WebElement phnumber = driver.findElement(By.xpath(property.getProperty("phone")));
	    phnumber.sendKeys(property.getProperty("phnumber"));
	    
	    
	    
	}
	@AfterClass
	private void tc2() {
		System.out.println("Test case 2");

	}
	

}
