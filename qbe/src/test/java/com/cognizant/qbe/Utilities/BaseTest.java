package com.cognizant.qbe.Utilities;

import org.testng.annotations.Test;

import com.cognizant.qbe.ExcelUtility.ExcelUtility;
import com.cognizant.qbe.ExcelUtility.TestData;
import com.cognizant.qbe.Pages.CarInsurancePage;
import com.cognizant.qbe.Pages.HomePage;
import com.cognizant.qbe.Pages.VehicleQuotePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	protected WebDriver driver;
	protected HomePage homePage;
	protected CarInsurancePage carInsurancePage;
	protected VehicleQuotePage vehicleQuotePage;
	protected TestData testData;
	
	@BeforeTest
	public void beforeTest() {
		ExcelUtility.setExcelFileSheet("Sheet1");
		ExcelUtility.initialiseColumnDictionary();
		System.out.println("Clear Status");
		ExcelUtility.clearStatus();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\695136\\Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qbe.com.au/insurance/vehicle/vehicle");
		
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		homePage = new HomePage(driver);
		carInsurancePage = new CarInsurancePage(driver);
		vehicleQuotePage = new VehicleQuotePage(driver);
		
		//get the test name
		ExcelUtility.setRowToTestCase(method.getName());
		testData = new TestData();
		
	}

	@AfterMethod
	public void afterMethod() {
//		driver.quit();
	}

}
