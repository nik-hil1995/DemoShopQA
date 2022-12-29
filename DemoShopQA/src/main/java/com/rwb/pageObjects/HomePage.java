package com.rwb.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rwb.baseTest.BaseClass;

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

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void updateAccountdetails(String updatedName) {
		account.click();
		displayName.sendKeys(updatedName);
		savebtn.click();

	}

	public boolean validateOrder() {
		boolean flag = false;
		if (orderid.isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

}
