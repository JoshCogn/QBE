package com.cognizant.qbe.ExcelUtility;

public class TestData {
	
	public String policyStartDate;
	public String personOrCompany;
	public String searchType;
	public String regoState;
	public String regoNumber;
	public String searchYear;
	public String searchMake;
	public String searchModel;
	public String searchBodyStyle;
	public String searchEngineSize;
	public String searchCar;
	public String address;
	public String locationParked;
	public String primaryCarUse;
	public String businessType;
	public String commericalType;
	public String isManufacturerOpitonsFitted;
	public String[] manufacturerOpitonsFittedList;
	public String isModifiedSinceManufacturered;
	public String[] modifiedSinceManufactureredList;
	public String financeOnCar;
	public String whoFinancedWith;
	public String originalOwner;
	public String isBoughtInLastYear;
	public String carCost;
	public String carPurchaseYear;
	public String carPurchaseMonth;
	public String carPreviousDamage;
	public String writtenEvidence;
	public String salvageValue;
	public String carColour;
	public String emailAddress;
	public String promoCode;
	
	public TestData(){
		
		policyStartDate = ExcelUtility.getDataOfColumnLabel("Policy Start Date");
		personOrCompany = ExcelUtility.getDataOfColumnLabel("Person Or Company");
		searchType = ExcelUtility.getDataOfColumnLabel("Search Type");
		regoState = ExcelUtility.getDataOfColumnLabel("[Rego] state");
		regoNumber = ExcelUtility.getDataOfColumnLabel("[Rego] Registration Number");
		searchYear = ExcelUtility.getDataOfColumnLabel("[Search] Year");
		searchMake = ExcelUtility.getDataOfColumnLabel("[Search] Make");
		searchModel = ExcelUtility.getDataOfColumnLabel("[Search] Model");
		searchBodyStyle = ExcelUtility.getDataOfColumnLabel("[Search] Body Style");
		searchEngineSize = ExcelUtility.getDataOfColumnLabel("[Search] Engine Size");
		searchCar = ExcelUtility.getDataOfColumnLabel("[Search] Car");
		address = ExcelUtility.getDataOfColumnLabel("Address");
		locationParked = ExcelUtility.getDataOfColumnLabel("Location Parked");
		primaryCarUse = ExcelUtility.getDataOfColumnLabel("Primary Car Use");
		businessType = ExcelUtility.getDataOfColumnLabel("Business Type");
		commericalType = ExcelUtility.getDataOfColumnLabel("Commerical Type");
		isManufacturerOpitonsFitted = ExcelUtility.getDataOfColumnLabel("Manufacturer Options Fitted");
		manufacturerOpitonsFittedList = ExcelUtility.getDataOfColumnLabel("Manufacturer Options Fitted List").split(",");
		isModifiedSinceManufacturered = ExcelUtility.getDataOfColumnLabel("Modified Since Manufactured");
		modifiedSinceManufactureredList = ExcelUtility.getDataOfColumnLabel("Modified Since Manufactured List").split(",");
		financeOnCar = ExcelUtility.getDataOfColumnLabel("Finance On Car");
		whoFinancedWith = ExcelUtility.getDataOfColumnLabel("Who Financed With");
		originalOwner = ExcelUtility.getDataOfColumnLabel("Original Owner");
		isBoughtInLastYear = ExcelUtility.getDataOfColumnLabel("Bought In Last Year");
		carCost = ExcelUtility.getDataOfColumnLabel("Car Cost");
		carPurchaseYear = ExcelUtility.getDataOfColumnLabel("Car Purchase Year");
		carPurchaseMonth = ExcelUtility.getDataOfColumnLabel("Car Purchase Month");
		carPreviousDamage = ExcelUtility.getDataOfColumnLabel("Car Previous Damage");
		writtenEvidence = ExcelUtility.getDataOfColumnLabel("Written Evidence");
		salvageValue = ExcelUtility.getDataOfColumnLabel("Salvage Value");
		carColour = ExcelUtility.getDataOfColumnLabel("Car Colour");
		emailAddress = ExcelUtility.getDataOfColumnLabel("Email Address");
		promoCode = ExcelUtility.getDataOfColumnLabel("Promo Code");
		

	}
	

}
