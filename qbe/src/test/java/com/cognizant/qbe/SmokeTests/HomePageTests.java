package com.cognizant.qbe.SmokeTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.cognizant.qbe.Utilities.BaseTest;

public class HomePageTests extends BaseTest {
	@Test
	public void navigate_to_car_insurance() {
		String pageTitle = driver.getTitle();
		assert(pageTitle.contains("Car, Home, Travel, CTP Insurance | QBE"));
		homePage.clickCarInsurance();
		pageTitle = driver.getTitle();
		assert(pageTitle.contains("Car Insurance Quotes"));
		
	}
}
