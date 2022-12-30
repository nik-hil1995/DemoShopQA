package com.rwb.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rwb.actionDrivers.Actionable;
import com.rwb.baseTest.BaseClass;

public class CheckoutPage extends BaseClass {

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	Actionable act = new Actionable();

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

	@FindBy(css = "#billing_postcode")
	WebElement billingpincode;

	@FindBy(css = "#billing_phone")
	WebElement billingPhone;

	@FindBy(css = "#billing_email")
	WebElement billingEmail;

	@FindBy(css = "#place_order")
	WebElement PlaceOrderBtn;

	@FindBy(xpath = "//input[@name='terms-field']")
	WebElement termsField;

	@FindBy(css = ".woocommerce-terms-and-conditions-checkbox-text")
	WebElement termsandcondn;

	public OrderConfirmationPage checkoutProcess(String f_Name, String l_name, String country, String street,
			String city,
			String state, String pin, String phonenum, String emailadd) {
		billing_first_name.sendKeys(f_Name);
		billing_last_name.sendKeys(l_name);
		countrydrpdwn.click();
		searchCountry.sendKeys("ind");
		act.implicitWait(driver);
        for (WebElement a : countrymatch) {
			if (a.getText().equalsIgnoreCase(country)) {
				a.click();
			}
		
		}
		houseNum.sendKeys(street);
		billingCity.sendKeys(city);
		billingState.click();
		act.implicitWait(driver);
		searchState.sendKeys(state);
		for (WebElement b : stateOptions) {
			if (b.getText().equalsIgnoreCase(state)) {
				b.click();
			}

			billingpincode.sendKeys(pin);
			billingPhone.sendKeys(phonenum);
			billingEmail.sendKeys(emailadd);
			termsandcondn.click();
			PlaceOrderBtn.click();


		}
		return new OrderConfirmationPage();
	}


}
