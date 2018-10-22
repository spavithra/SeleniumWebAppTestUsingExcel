package toursapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup 
{	
	WebDriver driver;
	String baseUrl = "http://newtours.demoaut.com/";
	public WebDriver getDriver()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/pavithra/Desktop/pavithra_mac_selenium/chromedriver/");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		return driver;
	}
}