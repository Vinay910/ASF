package com.masteringselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum DriverType implements DriverSetUp {
	
	FIREFOX{

		public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
			return new FirefoxDriver(desiredCapabilities);
		}

		public DesiredCapabilities getDesiredCapabilities() {
			System.setProperty("webdriver.gecko.driver", "../ASF/Drivers/geckodriver.exe");
			DesiredCapabilities desiredCapabilities=DesiredCapabilities.firefox();
			return desiredCapabilities;
		}
		},
	IE{

		public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
			return new InternetExplorerDriver(desiredCapabilities);
		}

		public DesiredCapabilities getDesiredCapabilities() {
			System.setProperty("webdriver.ie.driver", "../ASF/Drivers/MicrosoftWebDriver.exe");
			DesiredCapabilities desiredCapabilities=DesiredCapabilities.internetExplorer();
			return desiredCapabilities;
		}},
	
	CHROME{

		public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
		return new ChromeDriver(desiredCapabilities);
		}

		public DesiredCapabilities getDesiredCapabilities() {
			System.setProperty("webdriver.chrome.driver", "../ASF/Drivers/chromedriver.exe");
			DesiredCapabilities desiredCapabilities=DesiredCapabilities.chrome();
			return desiredCapabilities;
		}},
	PHANTOMJS
	{

		public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
			
			return new PhantomJSDriver(desiredCapabilities);
		}

		public DesiredCapabilities getDesiredCapabilities() {
			System.setProperty("webdriver.chrome.driver", "../ASF/Drivers/phantomjs.exe");
			DesiredCapabilities desiredCapabilities=DesiredCapabilities.phantomjs();
			return desiredCapabilities;
		}
			
	},

}
