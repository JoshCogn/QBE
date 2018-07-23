package com.cognizant.qbe.SmokeTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
//import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
//import org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.cognizant.qbe.ExcelUtility.ExcelUtility;
import com.cognizant.qbe.ExcelUtility.TestData;
import com.cognizant.qbe.Utilities.BaseTest;

public class VehicleQuoteTests extends BaseTest {

	static final String RED = "(255, 0, 0";

	@Test
	public void form_incorrect_cover_start_date() throws InterruptedException {
		int testCaseRowNumber = 3;
		ExcelUtility.setRowNumber(testCaseRowNumber);
		TestData testData = new TestData();

		vehicleQuotePage.setPolicyStartDate("86");
		vehicleQuotePage.setCoverOnBehalfOf(testData.personOrCompany);

		String labelColour = driver.findElement(By.cssSelector("label[for=vehicleForm_getStarted_policyStartDate]"))
				.getCssValue("color");

		Thread.sleep(300);
		String textBoxColour = driver.findElement(By.id("vehicleForm_getStarted_policyStartDate"))
				.getCssValue("border-color");

		assertThat(labelColour, containsString(RED));
		assertThat(textBoxColour, containsString(RED));
	}

	@Test
	public void fill_in_form_incorrect_rego() {
		int testCaseRowNumber = 2;
		ExcelUtility.setRowNumber(testCaseRowNumber);
		TestData testData = new TestData();

		vehicleQuotePage.setPolicyStartDate(testData.policyStartDate);
		vehicleQuotePage.setCoverOnBehalfOf(testData.personOrCompany);

		vehicleQuotePage.setHowToSearchForCar(testData.searchType);
		vehicleQuotePage.setRegistrationNumberState(testData.regoState);
		vehicleQuotePage.setRegistrationNumber(testData.regoNumber);
		vehicleQuotePage.setRegistrationNumberClickFind();

		WebElement errorMessage = driver
				.findElement(By.cssSelector("div[class='ctrl-holder rego-search-error ng-scope']"));
		String regoError = errorMessage.getText();
		String colour = errorMessage.getCssValue("color");
		assertTrue(regoError.contains("Sorry, we can’t find this registration number"));
		assertThat(colour, containsString(RED));

	}

	@Test
	public void fill_in_form_total_using_test_data() throws InterruptedException {

		int testCaseRowNumber = 1;
		ExcelUtility.setRowNumber(testCaseRowNumber);
		TestData testData = new TestData();

		vehicleQuotePage.setPolicyStartDate(testData.policyStartDate);
		vehicleQuotePage.setCoverOnBehalfOf(testData.personOrCompany);

		vehicleQuotePage.setHowToSearchForCar(testData.searchType);
		vehicleQuotePage.setSearchYear(testData.searchYear);
		vehicleQuotePage.setSearchMake(testData.searchMake);
		vehicleQuotePage.setSearchModel(testData.searchModel);
		vehicleQuotePage.setSearchBodyStyle(testData.searchBodyStyle);
		vehicleQuotePage.setSearchEngineSize(testData.searchEngineSize);
		vehicleQuotePage.setSearchCar(testData.searchCar);

		vehicleQuotePage.setAddress(testData.address);

		vehicleQuotePage.setLocationParked(testData.locationParked);
		vehicleQuotePage.setPrimaryCarUse(testData.primaryCarUse);
		vehicleQuotePage.setCommercialType(testData.commericalType);
		vehicleQuotePage.setIfManufacturerOptionsFitted(testData.isManufacturerOpitonsFitted);
		vehicleQuotePage.selectManufacturerOptions(testData.manufacturerOpitonsFittedList);

		vehicleQuotePage.setIfModifiedSinceManufactured(testData.isModifiedSinceManufacturered);
		vehicleQuotePage.selectModifications(testData.modifiedSinceManufactureredList);

		vehicleQuotePage.setFinanceOnCar(testData.financeOnCar);
		vehicleQuotePage.setWhoFinancedWith(testData.whoFinancedWith);

		vehicleQuotePage.setIfOriginalOwner(testData.originalOwner);
		vehicleQuotePage.setIfBoughtInLastYear(testData.isBoughtInLastYear);
		vehicleQuotePage.setCarCost(testData.carCost);

		vehicleQuotePage.setCarPreviousDamange(testData.carPreviousDamage);
		vehicleQuotePage.setIfHavePriceEvidence(testData.writtenEvidence);
		vehicleQuotePage.setSalvageValue(testData.salvageValue);

		vehicleQuotePage.setCarColour(testData.carColour);

		vehicleQuotePage.setEmailAddress(testData.emailAddress);
		vehicleQuotePage.setPromoCode(testData.promoCode);

	}

	// @Test
	public void fill_in_form_manual_data() throws InterruptedException {

		// I CHANGED THE START PAGE
		// homePage.clickCarInsurance();
		// carInsurancePage.clickGetAQuote();

		assert (driver.getTitle().contains("Vehicle"));

		vehicleQuotePage.setPolicyStartDate("29/07/2018");

		vehicleQuotePage.setCoverOnBehalfOf("Company");

		// Thread.sleep(1000);

		vehicleQuotePage.setHowToSearchForCar("Use registration number");
		vehicleQuotePage.setRegistrationNumberState("NSW");
		vehicleQuotePage.setRegistrationNumber("ABC123187321637");
		vehicleQuotePage.setRegistrationNumberClickFind();

		String regoError = driver.findElement(By.cssSelector("div[class='ctrl-holder rego-search-error ng-scope']"))
				.getText();
		assert (regoError.contains("Sorry, we can’t find this registration number"));

		Thread.sleep(2000);

		// 1990, Volvo, 240, body style, ...
		// vehicleQuotePage.setSearchYear("1990");
		// vehicleQuotePage.setSearchMake("Volvo");
		// vehicleQuotePage.setSearchModel("240");
		// vehicleQuotePage.setSearchBodyStyle("Sedan");
		// vehicleQuotePage.selectCar("B230F GL Sedan 4dr Auto 4sp 2.3i");

		// no original owner Q
		// vehicleQuotePage.setHowToSearchForCar("Search for vehicle");
		// vehicleQuotePage.setSearchYear("1994");
		// vehicleQuotePage.setSearchMake("Holden");
		// vehicleQuotePage.setSearchModel("Commodore");
		// vehicleQuotePage.setSearchBodyStyle("Wagon");
		// vehicleQuotePage.setSearchEngineSize("4987");
		// vehicleQuotePage.setSearchCar("VR Executive Wagon 5dr Auto 4sp 5.0i");

		vehicleQuotePage.setHowToSearchForCar("Search for vehicle");
		vehicleQuotePage.setSearchYear("2016");
		vehicleQuotePage.setSearchMake("Honda");
		vehicleQuotePage.setSearchModel("Civic");
		vehicleQuotePage.setSearchBodyStyle("Sedan");
		vehicleQuotePage.setSearchEngineSize("1798");
		vehicleQuotePage.setSearchCar("9th Gen Ser II Vi Sedan 4dr Man 5sp 1.8i [MY15]");

		// Thread.sleep(2000);

		vehicleQuotePage.setAddress("1 Semple Street RYDE, NSW, 2112");

		// Thread.sleep(1000);

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
		// vehicleQuotePage.selectManufacturerOptions("Air Conditioning", "Airbag -
		// Drivers");
		vehicleQuotePage.selectManufacturerOptions("Paint - Metallic/Pearl");

		vehicleQuotePage.setIfModifiedSinceManufactured("Yes");
		vehicleQuotePage.selectModifications("Changes to the chassis of the vehicle",
				"Higher engine performance than standard");

		vehicleQuotePage.setFinanceOnCar("Lease");
		vehicleQuotePage.setWhoFinancedWith("Albany Finance");

		vehicleQuotePage.setIfOriginalOwner("No"); // break Original Owner
		vehicleQuotePage.setIfBoughtInLastYear("Yes");
		vehicleQuotePage.setCarCost("420");

		vehicleQuotePage.setIfOriginalOwner("Yes"); // break Original Owner
		vehicleQuotePage.setWhenDidYouBuyYear("2016");
		vehicleQuotePage.setWhenDidYouBuyMonth("October");

		vehicleQuotePage.setCarPreviousDamange("Hail damage");
		vehicleQuotePage.setIfHavePriceEvidence("Yes");
		vehicleQuotePage.setSalvageValue("300");

		vehicleQuotePage.setCarColour("Green");

		vehicleQuotePage.setEmailAddress("email@address.com");
		vehicleQuotePage.setPromoCode("ABC123");

	}
}
