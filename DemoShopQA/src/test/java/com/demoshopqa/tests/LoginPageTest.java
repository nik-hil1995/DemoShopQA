/**
 * 
 */
package com.demoshopqa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoshopqa.baseTest.BaseClass;
import com.demoshopqa.pageObjects.HomePage;
import com.demoshopqa.pageObjects.IndexPage;
import com.demoshopqa.pageObjects.LoginPage;

/**
 * @author NIkhil Kumar
 *
 */
public class LoginPageTest extends BaseClass {

	IndexPage indexpage;
	HomePage homepage;

	@BeforeMethod
	public void setup() {
		LaunchApp();
	}

	@AfterMethod
	public void teardonw() {
		driver.quit();
	}


	@Test
	public void verifyLogin() {
		indexpage = new IndexPage();
		LoginPage loginpage = indexpage.clickTosignIn();
		homepage = loginpage.loginToApp(prop.getProperty("UserEmail"), prop.getProperty("Password"));
		Assert.assertEquals(homepage.getCurrURL(), prop.getProperty("homepageurl"));
	}

}
