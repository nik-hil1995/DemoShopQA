package com.demoshopqa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshopqa.baseTest.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Orders')]")
	WebElement orders;

	@FindBy(xpath = "//a[contains(text(),'Account details')]")
	WebElement account;

	@FindBy(id = "account_display_name")
	WebElement displayName;

	@FindBy(id = "account_display_name")
	WebElement Name;

	@FindBy(xpath = "//td[@data-title='Order']")
	WebElement orderid;

	@FindBy(xpath = "//button[@name='save_account_details']")
	WebElement savebtn;

	@FindBy(xpath = "//a[contains(text(),'Addresses')]")
	WebElement address;

	@FindBy(xpath = "//h3[contains(text(),'Billing address')]")
	WebElement billingAddress;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean vaidateAddress() {
		boolean flag = false;
		address.click();
		if (billingAddress.isDisplayed()) {
			flag = true;

		} else {
			flag = false;
		}
		return flag;
	}

	public boolean validateOrder() {
		boolean flag = false;
		orders.click();
		if (orderid.isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public String getCurrURL() {
		return driver.getCurrentUrl();
	}


}
