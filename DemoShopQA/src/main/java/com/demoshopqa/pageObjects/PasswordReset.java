package com.demoshopqa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshopqa.baseTest.BaseClass;

public class PasswordReset extends BaseClass {

	@FindBy(id = "user_login")
	WebElement password_email;

	@FindBy(xpath = "//button[@value='Reset password']")
	WebElement resetBtn;

	public PasswordReset() {
		PageFactory.initElements(driver, this);
	}

	public void resetPassword(String username) {
		password_email.sendKeys(username);
		resetBtn.click();
	}



}
