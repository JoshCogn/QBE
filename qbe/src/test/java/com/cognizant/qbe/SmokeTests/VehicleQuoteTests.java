package com.cognizant.qbe.SmokeTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
//import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
//import org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.cognizant.qbe.CustomExpectedConditions.CustomExpectedConditions;
import com.cognizant.qbe.ExcelUtility.ExcelUtility;
import com.cognizant.qbe.ExcelUtility.TestData;
import com.cognizant.qbe.Utilities.BaseTest;


public class VehicleQuoteTests extends BaseTest {

	static final String RED = "(255, 0, 0";
	
	@Test
	public void form_submitted_with_empty_fields() throws InterruptedException {
//		String test = "//label[contains(text(),'What\u2019s the full address where it\u2019s usually kept?')]";
//		System.out.println(test);
//		System.out.println(driver.findElement(By.xpath(test)).getText());
//		
//		WebElement tee = driver.findElement(By.xpath("//*[@id=\"vehicleForm_tellUsABitMore\"]/fieldset/div/h2"));
//		vehicleQuotePage.scrollToElement(tee);
//		vehicleQuotePage.waitUntilElementVisibleInPortView(tee);
//		
//		Thread.sleep(2000);
//		
//		WebElement nav = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/h1/span"));
//		vehicleQuotePage.scrollToElement(nav);
//		vehicleQuotePage.waitUntilElementVisibleInPortView(nav);

		vehicleQuotePage.setPolicyStartDate("");

		vehicleQuotePage.setHowToSearchForCar(testData.searchType);
		vehicleQuotePage.setSearchYear(testData.searchYear);
		vehicleQuotePage.setSearchMake(testData.searchMake);
		vehicleQuotePage.setSearchModel(testData.searchModel);
		vehicleQuotePage.setSearchBodyStyle(testData.searchBodyStyle);
		vehicleQuotePage.setSearchEngineSize(testData.searchEngineSize);
		vehicleQuotePage.setSearchCar(testData.searchCar);
		
		Thread.sleep(500);
		
		vehicleQuotePage.clickNextButton();
		
		boolean visible;
		
		WebElement validationSummary = driver.findElement(By.cssSelector("div.scfValidationSummary"));
		vehicleQuotePage.waitUntilElementVisibleInPortView(validationSummary);
		visible = vehicleQuotePage.isElementVisibleInPortView(validationSummary);
		assertThat(visible, is(true));
		
		driver.findElement(By.xpath("//strong[text()='When would you want to start your cover?']")).click();
		WebElement label = driver.findElement(By.cssSelector("label[for='vehicleForm_getStarted_policyStartDate']"));
		vehicleQuotePage.waitUntilElementVisibleInPortView(label);
		visible = vehicleQuotePage.isElementVisibleInPortView(label);
		assertThat(visible, is(true));
		
		Thread.sleep(1000);
//		WebElement nav = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/h1/span"));
//
//		vehicleQuotePage.scrollToElement(nav);
//		Thread.sleep(2000);
//		vehicleQuotePage.waitUntilElementVisibleInPortView(nav);


		//driver.findElement(By.xpath("//strong[contains(text(),'s the full address where it')]")).click();
		driver.findElement(By.xpath("//strong[contains(text(),'What\u2019s the full address where it\u2019s usually kept?')]")).click();
		//Thread.sleep(1000);
		
		label = driver.findElement(By.cssSelector("div[field-key='address'] label"));
		vehicleQuotePage.waitUntilElementVisibleInPortView(label);
		visible = vehicleQuotePage.isElementVisibleInPortView(label);
		assertThat(visible, is(true));
		
		String question = " the primary use of your car?";
//		vehicleQuotePage.scrollToElement(nav);
//		vehicleQuotePage.waitUntilElementVisibleInPortView(nav);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//strong[contains(text(),' the primary use of your car?')]")).click();
		label = driver.findElement(By.xpath("//label[contains(text(),'" + question + "')]"));
		vehicleQuotePage.waitUntilElementVisibleInPortView(label);
		visible = vehicleQuotePage.isElementVisibleInPortView(label);
		assertThat(visible, is(true));
		
		question = "What colour is the car?";
		driver.findElement(By.xpath("//strong[contains(text(),'" + question + "')]")).click();
		label = driver.findElement(By.xpath("//label[contains(text(),'" + question + "')]"));
		vehicleQuotePage.waitUntilElementVisibleInPortView(label);
		visible = vehicleQuotePage.isElementVisibleInPortView(label);
		assertThat(visible, is(true));
		
	}

	@Test
	public void form_scrolling() {
		// WebElement optionsLabel =
		// driver.findElement(By.cssSelector("div[field-key='modificationsOptions']
		// label:first-child"));
		WebElement bottomH2 = driver.findElement(By.xpath("//*[@id=\"main\"]/section/div/div/h2"));
		WebElement topH1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/h1/span"));

		System.out.println("h1 isDisplayed: " + topH1.isDisplayed());
		System.out.println("h2 isDisplayed: " + bottomH2.isDisplayed());
		Point point = bottomH2.getLocation();
		System.out.println("x: " + point.x + ", y: " + point.y);
		Point point1 = topH1.getLocation();
		System.out.println("x: " + point1.x + ", y: " + point1.y);

		Boolean visible = vehicleQuotePage.isElementVisibleInPortView(bottomH2);

		System.out.println(visible);

		visible = vehicleQuotePage.isElementVisibleInPortView(topH1);

		System.out.println(visible);
	}

	@Test
	public void form_car_cost_too_low() {
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
		
		WebElement label = driver.findElement(By.cssSelector("label[for='vehicleForm_carDetails_carCost']"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(CustomExpectedConditions.elementColourIsEqual(label, RED));
		assertThat(label.getCssValue("color"), containsString(RED));
		
	}

	@Test
	public void form_incorrect_cover_start_date() throws InterruptedException {
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
	public void form_incorrect_rego() {

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
	public void form_fill_total() throws InterruptedException {

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
