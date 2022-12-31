package com.demoshopqa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoshopqa.baseTest.BaseClass;
import com.demoshopqa.pageObjects.AccountCreationPage;
import com.demoshopqa.pageObjects.IndexPage;
import com.demoshopqa.pageObjects.LoginPage;

public class OnboardingTest extends BaseClass {

	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreation;

	@BeforeMethod
	public void setup() {
		LaunchApp();
	}

	@AfterMethod
	public void teardonw() {
		driver.quit();
	}

	@Test
	public void verifyNewOnboarding() {
		indexpage = new IndexPage();
		indexpage.clickTosignIn();
		accountcreation = new AccountCreationPage();
		String actualURL = accountcreation.newRegister(prop.getProperty("user_name"),
				prop.getProperty("user_email_new"),
				prop.getProperty("Password"));
		Assert.assertEquals(actualURL, prop.getProperty("homepageurl"));
	}

}
