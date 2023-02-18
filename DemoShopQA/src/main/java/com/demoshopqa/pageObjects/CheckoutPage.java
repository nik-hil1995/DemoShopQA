package com.demoshopqa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshopqa.actionDrivers.Actionable;
import com.demoshopqa.baseTest.BaseClass;

public class CheckoutPage extends BaseClass {

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
    LoginPage loginpage;
	
	
	
	Actionable act = new Actionable();
/*
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

	
	@FindBy(xpath = "//input[@name='terms-field']")
	WebElement termsField;

	
	

	public OrderConfirmationPage checkoutProcess(String f_Name, String l_name, String country, String street,
			String city,
			String state, String pin, String phonenum, String emailadd) throws InterruptedException {
		billing_first_name.sendKeys(f_Name);
		billing_last_name.sendKeys(l_name);
		countrydrpdwn.click();
		searchCountry.sendKeys("ind");
        for (WebElement a : countrymatch) {
			if (a.getText().equalsIgnoreCase(country)) {
				a.click();
			}
		
		}

		houseNum.sendKeys(street);
		billingCity.sendKeys(city);
		act.implicitWait(driver);
		billingState.click();
		searchState.sendKeys(state);
		for (WebElement b : stateOptions) {
			if (b.getText().equalsIgnoreCase(state)) {
				b.click();
			}
			billingpincode.sendKeys(pin);
			billingPhone.sendKeys(phonenum);
			billingEmail.sendKeys(emailadd);

			act.clickToElement(driver, termsandcondn);
			PlaceOrderBtn.click();


		}
		return new OrderConfirmationPage();
	}
	
	*/
	
	@FindBy(css = ".showlogin")
	WebElement loginbtn;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement termsandcondn;
	
	@FindBy(css = "#place_order")
	WebElement PlaceOrderBtn;


	public OrderConfirmationPage checkoutAProduct() throws InterruptedException {
	loginbtn.click();
	loginpage=new LoginPage();
	loginpage.loginToApp(prop.getProperty("UserEmail"), prop.getProperty("Password"));
	Thread.sleep(6000);
    termsandcondn.click();
	PlaceOrderBtn.click();
	
	return new OrderConfirmationPage();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

}
