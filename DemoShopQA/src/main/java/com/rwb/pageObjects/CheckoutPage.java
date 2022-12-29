package com.rwb.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rwb.baseTest.BaseClass;

public class CheckoutPage extends BaseClass {

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#billing_first_name")
	WebElement billing_first_name;

	@FindBy(css = "#billing_last_name")
	WebElement billing_last_name;

	@FindBy(css = "#select2-billing_country-container")
	WebElement countrydrpdwn;

	@FindBy(css = ".select2-search__field")
	WebElement searchCountry;

	@FindBy(css = ".select2-results__option")
	List<WebElement> countrymatch;

	@FindBy(css = "#billing_address_1")
	WebElement houseNum;

	@FindBy(css = "#billing_city")
	WebElement billingCity;

	@FindBy(css = "#select2-billing_state-container")
	WebElement billingState;

	@FindBy(css = ".select2-search__field")
	WebElement searchState;

	@FindBy(css = ".select2-results__option")
	List<WebElement> stateOptions;


}
