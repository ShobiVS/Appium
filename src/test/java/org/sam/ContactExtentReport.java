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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;


public class ContactExtentReport {
	public static AndroidDriver<WebElement> driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	
	
@BeforeSuite
private void tc1() throws IOException {
	htmlreporter=new ExtentHtmlReporter("ContactReport.html");
	extent=new ExtentReports();
	extent.attachReporter(htmlreporter);
    test=extent.createTest("Andriod", "contact application");
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
	test.log(Status.INFO, "Appium click the add button");
	
    WebElement add = driver.findElement(By.xpath(property.getProperty("add")));
    add.click();
    test.log(Status.PASS, "Appium send the keys");
    WebElement phname = driver.findElement(By.xpath(property.getProperty("name")));
    phname.sendKeys(property.getProperty("phname"));
    test.log(Status.PASS, "Appium send the phone number");
    WebElement phnumber = driver.findElement(By.xpath(property.getProperty("phone")));
    phnumber.sendKeys(property.getProperty("phnumber"));
    
    }

     @Test(priority=1)
private void tc2() {
    	 test.log(Status.PASS, "Appium write the test case 2");
    	 System.out.println("Test case 2");
	
}
     @Test(priority=2)
     private void tc3() {
		test.log(Status.PASS, "Appium Write the test case 3");
		System.out.println("Test Case 3");
	}
     
     @AfterSuite
     private void tc4() {
		test.log(Status.PASS, "Appium quit the apk");
		extent.flush();
		driver.quit();

	}


}
