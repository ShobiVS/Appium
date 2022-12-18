package org.sam;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Hybridapp {
	public static AndroidDriver<WebElement> driver;

	@BeforeClass
	private void launchBrowser() throws MalformedURLException {
		

	
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "vivo1820");
		cap.setCapability("udid", "ZHGYEARGFICYGYEM");
		cap.setCapability("appPackage", "com.android.bbkcalculator");
		cap.setCapability("appActivity", "com.android.bbkcalculator.Calculator");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, cap);
		

}
	@Test
	private void tc1() {
		WebElement one=driver.findElement(By.id("com.android.bbkcalculator:id/digit1"));
		one.click();
		WebElement three=driver.findElement(By.id("com.android.bbkcalculator:id/digit3"));
		three.click();
		

	}
	@Test
	private void tc2() {
		WebElement division = driver.findElement(By.id("com.android.bbkcalculator:id/div"));
		division.click();
	}
	@Test
	private void tc3() {
		WebElement eight = driver.findElement(By.id("com.android.bbkcalculator:id/digit8"));
        eight.click();
	}
	@Test
	private void tc4() throws IOException {
		WebElement equal = driver.findElement(By.id("com.android.bbkcalculator:id/equal"));
        equal.click();
        TakesScreenshot ts=(TakesScreenshot)driver;
        File img = ts.getScreenshotAs(OutputType.FILE);
        File f=new File("./ScreenShot\\Calculator.png");
        FileUtils.copyFile(img, f);
	}
	
	@BeforeMethod
	private void StartDate() {
		Date d=new Date();
		System.out.println(d);

	}
	@AfterMethod
	private void endDate() {
		Date d=new Date();
		System.out.println(d);
	}
	
	@AfterClass
	private void closebrowser() {
		driver.quit();
	}
	
	
	
	
	
	
}