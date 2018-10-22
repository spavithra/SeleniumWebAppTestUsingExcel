package toursapplication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCase extends DriverSetup{

	WebDriver driver;
	ToursTesting tours;
	@BeforeTest
	public void setUp()
	{
		System.out.println("Entered setup");
		this.driver = getDriver();
	}
	
	@Test
	public void BookFlight() throws Exception
	{
	driver = getDriver();
	tours = new ToursTesting(driver);
	ExcelUtils.setExcelFile();
//login details are entered and logged in
	String username = ExcelUtils.getCellData(1, 1);
	String password = ExcelUtils.getCellData(1, 2);
	tours.login(username, password);
	String loginpage = "findflight";
	tours.verifyloginpage(loginpage);
//flight details are entered to search available flight list
	int type = ExcelUtils.getCellData1(2, 3);
	int serviceclass = ExcelUtils.getCellData1(3, 4);
	String dropdownvalue = ExcelUtils.getCellData(2, 5);
	String dropdownvalue1 = ExcelUtils.getCellData(2, 6);
	String dropdownvalue2 = ExcelUtils.getCellData(2,7);
	String dropdownvalue3 = ExcelUtils.getCellData(2,8);
	String dropdownvalue4 = ExcelUtils.getCellData(2,9);
	String dropdownvalue5 = ExcelUtils.getCellData(2,10);
	String dropdownvalue6 = ExcelUtils.getCellData(2,11);
	String dropdownvalue7 = ExcelUtils.getCellData(3,12);
	tours.searchFlight(type, serviceclass, dropdownvalue, dropdownvalue1, dropdownvalue2, dropdownvalue3, dropdownvalue4, dropdownvalue5, dropdownvalue6, dropdownvalue7);
	tours.signoff();
	}
	
	@AfterTest
	public void afterTest() throws Exception 
	{
		Thread.sleep(6000);  
	}
}
