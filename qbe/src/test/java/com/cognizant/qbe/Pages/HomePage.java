package com.cognizant.qbe.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author 695136
 *
 */
public class HomePage extends BasePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCarInsurance() {
		//make sure car tab is selected
		
		driver.findElement(By.id("phbody_0_phhomesectiontabs_0_rptTab_rptLinks_0_ancLink_0")).click();

	}
}
