package com.cognizant.qbe.Utilities;

import org.testng.annotations.Test;

import com.cognizant.qbe.ExcelUtility.ExcelUtility;
import com.cognizant.qbe.ExcelUtility.TestData;
import com.cognizant.qbe.Pages.CarInsurancePage;
import com.cognizant.qbe.Pages.HomePage;
import com.cognizant.qbe.Pages.VehicleQuotePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	protected WebDriver driver;
	protected HomePage homePage;
	protected CarInsurancePage carInsurancePage;
	protected VehicleQuotePage vehicleQuotePage;
	protected TestData testData;
	protected String browser;

	@BeforeTest
	public void beforeTest() {
		ExcelUtility.setExcelFileSheet("Sheet1");
		ExcelUtility.initialiseColumnDictionary();
		System.out.println("Clear Status");
		ExcelUtility.clearStatus();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		browser = System.getProperty("browser");
		System.out.println("Browser :" + browser);
		if (browser == null) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\695136\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\695136\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("PhantomJS")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);                
			caps.setCapability("takesScreenshot", true);  
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
			                        "C:\\Users\\695136\\PhantomJS\\bin\\phantomjs.exe");
            driver = new PhantomJSDriver(caps);	
		} else if (browser.equalsIgnoreCase("HTMLUnit")) {
			driver = new HtmlUnitDriver(true);
		} else {
			//  C:\Users\695136\AppData\Local\Mozilla Firefox\firefox.exe
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\695136\\Software\\geckodriver-win32\\geckodriver.exe");
			File firefoxPathBinary = new File("C:\\Users\\695136\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			System.setProperty("webdriver.firefox.bin", firefoxPathBinary.getAbsolutePath());
			driver = new FirefoxDriver();
			browser = "Firefox";
		}

		driver.get("https://www.qbe.com.au/insurance/vehicle/vehicle");

		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		System.out.println("got webpage");

		homePage = new HomePage(driver);
		carInsurancePage = new CarInsurancePage(driver);
		vehicleQuotePage = new VehicleQuotePage(driver);

		// get the test name
		ExcelUtility.setRowToTestCase(method.getName());
		testData = new TestData();
		
	}

	@AfterMethod
	public void afterMethod() {
		// driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public String getBrowser() {
		return browser;
	}

}
