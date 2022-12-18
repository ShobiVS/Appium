package org.sam;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Webapplication {
	public static AndroidDriver<WebElement> driver;

	public static void main(String[] args) throws MalformedURLException, AWTException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "Vivo1820");
		cap.setCapability("udid", "ZHGYEARGFICYGYEM");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, cap);
		
		WebElement accept = driver.findElement(By.id("com.android.chrome:id/terms_accept"));
		accept.click();
		Thread.sleep(2000);
		WebElement nothanks = driver.findElement(By.id("com.android.chrome:id/negative_button"));
		nothanks.click();
		WebElement src = driver.findElement(By.id("com.android.chrome:id/url_bar"));
		src.sendKeys("flipkart.com");
		
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		WebElement srchbtn1 = driver.findElement(By.xpath("//*[@text='Search for Products, Brands and More']"));
		Thread.sleep(1000);
		srchbtn1.sendKeys("Apple iphone");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

}
