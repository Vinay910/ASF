package com.masteringselenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class DriverFactory {
	
	private static ThreadLocal<WebDriverThread> driverThread;
	@BeforeSuite
	public static void instantiteDriverObject()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vinayak\\eclipse-workspace\\ASF\\Drivers\\geckodriver.exe");
		driverThread=new ThreadLocal<WebDriverThread>() {
			protected WebDriverThread initialValue() {
			WebDriverThread webDriverThread=new WebDriverThread();
				return webDriverThread;	
			}
		};
	}

	public static WebDriver getDriver() throws Exception
	{
		return driverThread.get().getDriver();
	}
	@AfterMethod
	public static void quitDriver() throws Exception
	{
		driverThread.get().quitDriver();
	}
}
