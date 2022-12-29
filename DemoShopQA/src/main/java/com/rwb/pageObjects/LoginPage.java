package com.rwb.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rwb.baseTest.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement passWord;

	@FindBy(xpath = "//button[@name='login']")
	WebElement loginBtn;

	@FindBy(id = "rememberme")
	WebElement rememberMe;

	@FindBy(xpath = "//a[contains(text(),'Lost your password?')]")
	WebElement lostPassword;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage loginToApp(String email, String password) {
		userName.sendKeys(email);
		passWord.sendKeys(password);
		loginBtn.click();
		return new HomePage();

	}

	public PasswordReset passwordReset() {
		lostPassword.click();
		return new PasswordReset();
	}


}
