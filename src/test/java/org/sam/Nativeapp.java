package org.sam;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Nativeapp {
	public static AndroidDriver<WebElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "Vivo1820");
		cap.setCapability("udid", "ZHGYEARGFICYGYEM");
		cap.setCapability("appPackage", "com.android.bbkcalculator");
		cap.setCapability("appActivity", "com.android.bbkcalculator.Calculator");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, cap);
		WebElement eight = driver.findElement(By.id("com.android.bbkcalculator:id/digit8"));
		eight.click();
		WebElement plus = driver.findElement(By.id("com.android.bbkcalculator:id/plus"));
		plus.click();
		WebElement nine = driver.findElement(By.id("com.android.bbkcalculator:id/digit9"));
		nine.click();
		WebElement equal = driver.findElement(By.id("com.android.bbkcalculator:id/equal"));
		equal.click();
}
}
