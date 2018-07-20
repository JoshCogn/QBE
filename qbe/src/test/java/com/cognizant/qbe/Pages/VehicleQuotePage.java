package com.cognizant.qbe.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleQuotePage extends BasePage {
	WebDriver driver;

	public VehicleQuotePage(WebDriver driver) {
		this.driver = driver;
	}

	public void setPolicyStartDate(String date) {
		date = date.replace("/", "");
		WebElement policyStartDate = driver.findElement(By.id("vehicleForm_getStarted_policyStartDate"));
		policyStartDate.clear();
		policyStartDate.sendKeys(date);
	}

	public void setCoverOnBehalfOf(String option) {
		option = option.toLowerCase();
		driver.findElement(By.xpath("//label[@for='personOrCompany_" + option + "']")).click();
	}

	public void setHowToSearchForCar(String searchType) {
		if (searchType.equalsIgnoreCase("Use registration number")) {
			driver.findElement(By.xpath("//label[@for='searchType_rego']")).click();
		}
		if (searchType.equalsIgnoreCase("Search for vehicle")) {
			driver.findElement(By.xpath("//label[@for='searchType_search']")).click();
		}

	}

	public void setSearchYear(String year) {
		selectFromDropdown("Year", year);
	}

	public void setSearchMake(String make) {
		selectFromDropdown("Make", make);
	}

	public void setSearchModel(String model) {
		selectFromDropdown("Model", model);
	}

	public void setSearchBodyStyle(String bodyStyle) {
		selectFromDropdown("Body style", bodyStyle);
	}

	public void setSearchEngineSize(String engineSize) {
		selectFromDropdown("Engine size", engineSize);
	}

	public void selectFromDropdown(String placeholder, String selectText) {
		WebElement dropdown = driver.findElement(By.xpath("//input[@placeholder='" + placeholder + "']"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));

		// System.out.println("before");
		// System.out.println("displayed: " + dropdown.isDisplayed());
		// System.out.println("enabled: " + dropdown.isEnabled());
		// System.out.println("selected: " + dropdown.isSelected());

		dropdown.click();

		// System.out.println("after");
		// System.out.println("displayed: " + dropdown.isDisplayed());
		// System.out.println("enabled: " + dropdown.isEnabled());
		// System.out.println("selected: " + dropdown.isSelected());

		// System.out.println(driver.findElement(By.xpath("//input[@placeholder='Make']")).isEnabled());

		// WebDriverWait wait = new WebDriverWait(driver, 5);
		//// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+selectText+"']")));
		// wait.until(ExpectedConditions.elementSelectionStateToBe(dropdown, true));

		dropdown.findElement(By.xpath("//span[text()='" + selectText + "']")).click();
	}

	public void setSearchCar(String selectCar) {
		driver.findElement(By.xpath("//label[text()='" + selectCar + "']")).click();
	}

	public void setAddress(String address) {
		//get first sibling
		//"//input[@id='vehicleForm_aboutYourCar_address']/following-sibling::ul/li[1]"
		WebElement streetAddress = driver.findElement(By.id("vehicleForm_aboutYourCar_address"));
		streetAddress.sendKeys(address);
		
		streetAddress.findElement(By.xpath("following-sibling::ul/li[1]")).click();
		//streetAddress.sendKeys(Keys.ENTER);
	}

	public void setLocationParked(String location) {

		Select locationSelect = new Select(driver.findElement(By.id("vehicleForm_carDetails_locationParked")));
		locationSelect.selectByVisibleText(location);
	}

	public void setPrimaryCarUse(String option) {
		option = option.toLowerCase();
		driver.findElement(By.xpath("//label[@for='primaryCarUse_" + option + "']")).click();
	}

	public void setIfManufacturerOptionsFitted(String selection) {
		selection = selection.toLowerCase();
		driver.findElement(By.xpath("//label[@for='carDetails_modifications_" + selection + "']")).click();
	}

	public void setIfModifiedSinceManufactured(String selection) {
		selection = selection.toLowerCase();
		driver.findElement(By.xpath("//label[@for='carDetails_modificationsBuilt_" + selection + "']")).click();
	}

	public void setFinanceOnCar(String finance) {
		Select locationSelect = new Select(driver.findElement(By.id("vehicleForm_carDetails_carFinance")));
		locationSelect.selectByVisibleText(finance);
	}

	public void setRegistrationNumberState(String state) {
		Select stateSelect = new Select(driver.findElement(By.id("vehicleForm_aboutYourCar_carRegoNumberState")));
		stateSelect.selectByVisibleText(state);
	}

	public void setRegistrationNumber(String regoNumberString) {
		driver.findElement(By.id("vehicleForm_aboutYourCar_carRegoNumber")).sendKeys(regoNumberString);

	}

	public void setRegistrationNumberClickFind() {
		driver.findElement(By.xpath("//a[text()='Find my car']")).click();
	}

	public void selectManufacturerOptions(String... options) {
		// driver.findElement(By.xpath("//label[starts-with(@for,'modificationsOptions_')
		// and text()='Air Conditioning']"));

		for (String option : options) {
			driver.findElement(
					By.xpath("//label[starts-with(@for,'modificationsOptions_') and text()='" + option + "']")).click();
		}
	}

	public void selectModifications(String... options) {
		// label works, but text is in a span, not a label. also contains whitespace?
		// "//label[starts-with(@for,'modificationsBuiltOptions_')]/span[contains(text(),'Changes
		// to the chassis of the vehicle')]"

		for (String option : options) {
			driver.findElement(By.xpath(
					"//label[starts-with(@for,'modificationsBuiltOptions_')]/span[contains(text(),'" + option + "')]"))
					.click();
		}
	}

	public void setBusinessType(String activity) {
		Select stateSelect = new Select(driver.findElement(By.id("vehicleForm_carDetails_businessActivityType")));
		stateSelect.selectByVisibleText(activity);
	}

	public void setCommercialType(String activity) {
		Select stateSelect = new Select(driver.findElement(By.id("vehicleForm_carDetails_commercialActivityType")));
		stateSelect.selectByVisibleText(activity);		
	}

	public void setWhoFinancedWith(String choice) {
		//"//div[@label-key='financeWith']//input[@type='search']"
		//"div[label-key='financeWith'] input[type='search']"
		WebElement dropdown = driver.findElement(By.cssSelector("div[label-key='financeWith'] input[type='search']"));
		//WebElement dropdown = driver.findElement(By.cssSelector("div#vehicleForm_carDetails_carFinance input[type='search']"));
		dropdown.click();
//		dropdown.findElement(By.cssSelector("span:contains('"+choice+"')"));
		dropdown.findElement(By.xpath("//span[text()='" + choice + "']")).click();		
	}

	public void setIfOriginalOwner(String choice) {
		choice = choice.toLowerCase();
		driver.findElement(By.cssSelector("label[for='carDetails_originalOwner_" + choice + "']")).click();		
	}
	
	public void setIfBoughtInLastYear(String choice) {
		choice = choice.toLowerCase();
		driver.findElement(By.cssSelector("label[for='carDetails_last12Months_" + choice + "']")).click();
	}

	public void setCarCost(String cost) {
		driver.findElement(By.id("vehicleForm_carDetails_carCost")).sendKeys(cost);
	}

	public void setWhenDidYouBuyYear(String yearInput) {
		Select yearSelect = new Select(driver.findElement(By.id("vehicleForm_carDetails_whenDidYouBuyYear")));
		yearSelect.selectByVisibleText(yearInput);
	}
	
	public void setWhenDidYouBuyMonth(String monthInput) {
		Select monthSelect = new Select(driver.findElement(By.id("vehicleForm_carDetails_whenDidYouBuyMonth")));
		monthSelect.selectByVisibleText(monthInput);
	}

	public void setCarPreviousDamange(String damage) {
		Select damageSelect = new Select(driver.findElement(By.id("vehicleForm_carDetails_existingDamage")));
		damageSelect.selectByVisibleText(damage);
	}

	public void setIfHavePriceEvidence(String choice) {
		choice = choice.toLowerCase();
		driver.findElement(By.cssSelector("label[for='carDetails_writtenEvidence_" + choice + "']")).click();		
	}

	public void setSalvageValue(String value) {
		driver.findElement(By.id("vehicleForm_carDetails_salvageValue")).sendKeys(value);
	}

	public void setCarColour(String colour) {
		WebElement dropdown = driver.findElement(By.cssSelector("div#colour input[type='search']"));
		dropdown.click();
		dropdown.findElement(By.xpath("//*[text()='" + colour + "']")).click();		
	}
	
	



}
