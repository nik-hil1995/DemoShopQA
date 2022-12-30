package com.demoshopqa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshopqa.baseTest.BaseClass;

public class AccountCreationPage extends BaseClass {

	@FindBy(id = "reg_username")
	WebElement usernameReg;

	@FindBy(id = "reg_email")
	WebElement email_reg;

	@FindBy(id = "reg_password")
	WebElement password_reg;

	@FindBy(xpath = "//button[@name='register']")
	WebElement registerBtn;

	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}

	public void newRegister(String user_Name, String user_email, String user_pass) {
		usernameReg.sendKeys(user_Name);
		email_reg.sendKeys(user_email);
		password_reg.sendKeys(user_pass);
		registerBtn.click();
	}

}
