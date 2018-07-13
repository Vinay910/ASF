package com.masteringselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.masteringselenium.config.DriverType;

public class WebDriverThread {
	

	private WebDriver webdriver;
	private DriverType selectedDriverType;
	private final DriverType defaultDriverType= DriverType.FIREFOX;
	private final String browserName=System.getProperty("browser").toUpperCase();
	private final String operatingSystem=System.getProperty("os.name").toUpperCase();
	private final String systemArchitecture=System.getProperty("os.arch");
	
	public WebDriver getDriver() throws Exception
	{
		if(null==webdriver)
		{
			selectedDriverType = determineEffectiveDriverType();
			DesiredCapabilities desiredCapabilities=selectedDriverType.getDesiredCapabilities();
			initiateWebDriver(desiredCapabilities);
			
		}
		
		return webdriver;
	}
	private void initiateWebDriver(DesiredCapabilities desiredCapabilities) {
		webdriver=selectedDriverType.getWebDriverObject(desiredCapabilities);
		
	}
	private DriverType determineEffectiveDriverType() 
	{
		DriverType driverType=defaultDriverType;
		driverType=DriverType.valueOf(browserName);
		return driverType;
	}
	public void quitDriver()
	{
		if(null!=webdriver)
		{
			webdriver.quit();
		}
	}

}
