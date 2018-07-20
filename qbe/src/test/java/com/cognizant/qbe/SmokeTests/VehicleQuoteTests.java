package com.cognizant.qbe.SmokeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.cognizant.qbe.Utilities.BaseTest;

public class VehicleQuoteTests extends BaseTest {
	@Test
	public void fill_in_form() throws InterruptedException {
		
		// I CHANGED THE START PAGE
		//homePage.clickCarInsurance();
		//carInsurancePage.clickGetAQuote();
		
		assert(driver.getTitle().contains("Vehicle"));
		
		vehicleQuotePage.setPolicyStartDate("29/07/2018");
		
		vehicleQuotePage.setCoverOnBehalfOf("Company");
		
		//Thread.sleep(1000);
		
		/*
		vehicleQuotePage.setHowToSearchForCar("Use registration number");
		vehicleQuotePage.setRegistrationNumberState("NSW");
		vehicleQuotePage.setRegistrationNumber("ABC123187321637");
		vehicleQuotePage.setRegistrationNumberClickFind();
		
		String regoError = driver.findElement(By.cssSelector("div[class='ctrl-holder rego-search-error ng-scope']")).getText();
		assert(regoError.contains("Sorry, we can’t find this registration number"));
		
		Thread.sleep(2000);
		*/
		
		// 1990, Volvo, 240, body style, ...
		// vehicleQuotePage.setSearchYear("1990");
		// vehicleQuotePage.setSearchMake("Volvo");
		// vehicleQuotePage.setSearchModel("240");
		// vehicleQuotePage.setSearchBodyStyle("Sedan");
		// vehicleQuotePage.selectCar("B230F GL Sedan 4dr Auto 4sp 2.3i");
		
		//no original owner Q
//		vehicleQuotePage.setHowToSearchForCar("Search for vehicle");
//		vehicleQuotePage.setSearchYear("1994");
//		vehicleQuotePage.setSearchMake("Holden");
//		vehicleQuotePage.setSearchModel("Commodore");
//		vehicleQuotePage.setSearchBodyStyle("Wagon");
//		vehicleQuotePage.setSearchEngineSize("4987");
//		vehicleQuotePage.setSearchCar("VR Executive Wagon 5dr Auto 4sp 5.0i");	
		
		vehicleQuotePage.setHowToSearchForCar("Search for vehicle");
		vehicleQuotePage.setSearchYear("2016");
		vehicleQuotePage.setSearchMake("Honda");
		vehicleQuotePage.setSearchModel("Civic");
		vehicleQuotePage.setSearchCar("9th Gen Ser II Vi Sedan 4dr Man 5sp 1.8i [MY15]");	
		
		
		//Thread.sleep(2000);
		
		vehicleQuotePage.setAddress("1 Semple Street RYDE, NSW, 2112");

		//Thread.sleep(1000);
		
		// -- Car Details --
		vehicleQuotePage.setLocationParked("Garage");
		vehicleQuotePage.setPrimaryCarUse("Private");
		Thread.sleep(1000);
		vehicleQuotePage.setPrimaryCarUse("Business");
		vehicleQuotePage.setBusinessType("Pilot vehicle");
		Thread.sleep(1000);
		vehicleQuotePage.setPrimaryCarUse("Commercial");
		vehicleQuotePage.setCommercialType("Security Patrol");
		vehicleQuotePage.setIfManufacturerOptionsFitted("Yes");
		//vehicleQuotePage.selectManufacturerOptions("Air Conditioning", "Airbag - Drivers");
		vehicleQuotePage.selectManufacturerOptions("Paint - Metallic/Pearl");
		
		vehicleQuotePage.setIfModifiedSinceManufactured("Yes");
		vehicleQuotePage.selectModifications("Changes to the chassis of the vehicle", "Higher engine performance than standard");

		vehicleQuotePage.setFinanceOnCar("Lease");
		vehicleQuotePage.setWhoFinancedWith("Albany Finance");
		
		vehicleQuotePage.setIfOriginalOwner("No");	// break Original Owner
		vehicleQuotePage.setIfBoughtInLastYear("Yes");
		vehicleQuotePage.setCarCost("420");
		
		vehicleQuotePage.setIfOriginalOwner("Yes");	// break Original Owner
		vehicleQuotePage.setWhenDidYouBuyYear("2016");
		vehicleQuotePage.setWhenDidYouBuyMonth("October");
		
		vehicleQuotePage.setCarPreviousDamange("Hail damage");
		vehicleQuotePage.setIfHavePriceEvidence("Yes");
		vehicleQuotePage.setSalvageValue("300");
		
		vehicleQuotePage.setCarColour("Green");
		
		
		
		
		
		
		
	}
}
