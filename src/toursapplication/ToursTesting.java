package toursapplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ToursTesting {

	WebDriver driver;
	
	public ToursTesting (WebDriver driver)
	{
		this.driver = driver;
	}
	public void login(String username, String password)
	{
		System.out.println("entered login method");
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		System.out.println("logged in successfully");
	}
	public void searchFlight(int type, int serviceclass, String dropdownvalue, String dropdownvalue1,String dropdownvalue2, String dropdownvalue3, String dropdownvalue4, String dropdownvalue5, String dropdownvalue6, String dropdownvalue7)
	{
		System.out.println("entered searchflight method");
		this.radioButton(By.name("tripType"), type );
		this.dropdownFunction(driver.findElement(By.name("passCount")), dropdownvalue);
		this.dropdownFunction(driver.findElement(By.name("fromPort")), dropdownvalue1);
		this.dropdownFunction(driver.findElement(By.name("fromMonth")), dropdownvalue2);
		this.dropdownFunction(driver.findElement(By.name("fromDay")), dropdownvalue3);
		this.dropdownFunction(driver.findElement(By.name("toPort")), dropdownvalue4);
		this.dropdownFunction(driver.findElement(By.name("toMonth")), dropdownvalue5);
		this.dropdownFunction(driver.findElement(By.name("toDay")), dropdownvalue6);
		this.dropdownFunction(driver.findElement(By.name("airline")), dropdownvalue7);
		this.radioButton(By.name("servClass"), serviceclass);
		this.clickfunc(By.name("findFlights"));
		System.out.println("finished searchflight method");
	}
	public void dropdownFunction(WebElement var1,String dropdownvalue) {
		
		//WebElement var1 = driver.findElement(By.xpath("//*[@id='format']"));
		new Select(var1).selectByVisibleText(dropdownvalue);
	}
	
	public void radioButton(By radioelement, int indexofarray) {
		
		List<WebElement> radioarray;
		radioarray = driver.findElements(radioelement);
		radioarray.get(indexofarray).click();
	}
	
	public void clickfunc(By button)
	{
		driver.findElement(button).click();
	}
	public WebElement verifyloginpage(String loginpage)
	{
		WebElement login = driver.findElement(By.name("findflight"));
		if(login.getText().contains(loginpage))
		{
			return null;
		}
		else
		{
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a")).click();
		}
		return null;
	}
	public void signoff()
	{
		System.out.println("entered sign in method");
		this.clickfunc(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"));
		System.out.println("Application is signed off successfully");
	}
}
