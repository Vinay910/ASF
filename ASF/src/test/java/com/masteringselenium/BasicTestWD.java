package com.masteringselenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicTestWD extends DriverFactory {

	private void googleSearch(final String search) throws Exception
	{
		WebDriver driver=DriverFactory.getDriver();
		driver.get("http://www.google.com");
		WebElement searchField=driver.findElement(By.name("q"));
		searchField.clear();
		searchField.sendKeys(search);
		System.out.println("Page titke is: " +driver.getTitle());
		searchField.submit();
		(new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driverObject)
			{
				return driverObject.getTitle().toLowerCase().startsWith(search.toLowerCase());
			}
		});
		System.out.println("Page title is: "+driver.getTitle());
		//driver.quit();
	}
	@Test
	public void cheese() throws Exception
	{
		googleSearch("Cheese");
	}
	
	@Test
	public void Milk() throws Exception
	{
		googleSearch("Milk");
	}
	
}
