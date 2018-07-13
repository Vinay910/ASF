package com.masteringselenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverFactory {
	
	private static List<WebDriverThread> wedDriverThreadPool=Collections.synchronizedList(new ArrayList<WebDriverThread>());
	private static ThreadLocal<WebDriverThread> driverThread;
	@BeforeSuite
	public static void instantiteDriverObject()
	{
		System.setProperty("webdriver.gecko.driver", "..\\ASF\\Drivers\\geckodriver.exe");
		driverThread=new ThreadLocal<WebDriverThread>() {
			protected WebDriverThread initialValue() {
			WebDriverThread webDriverThread=new WebDriverThread();
			wedDriverThreadPool.add(webDriverThread);
				return webDriverThread;	
			}
		};
	}

	public static WebDriver getDriver() throws Exception
	{
		return driverThread.get().getDriver();
	}
	@AfterMethod
	public static void clearCookies() throws Exception
	{
		getDriver().manage().deleteAllCookies();
	}
	@AfterSuite
	public static void closeDriverObjects() throws Exception
	{
		for(WebDriverThread webdriver:wedDriverThreadPool)
		{
			webdriver.quitDriver();
		}
	}
}
