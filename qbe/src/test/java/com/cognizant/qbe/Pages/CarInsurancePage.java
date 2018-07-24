package com.cognizant.qbe.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarInsurancePage extends BasePage{
	
	public CarInsurancePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickGetAQuote() {
		driver.findElement(By.linkText("Get a quote")).click();
	}
}
