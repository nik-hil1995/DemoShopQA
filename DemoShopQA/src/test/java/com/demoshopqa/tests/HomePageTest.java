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
public class HomePageTest extends BaseClass {

	IndexPage indexpage;
	LoginPage loginpage;
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
	public void verifytheorder() {
		indexpage = new IndexPage();
		LoginPage loginpage = indexpage.clickTosignIn();
		homepage = loginpage.loginToApp(prop.getProperty("UserEmail"), prop.getProperty("Password"));
		boolean result = homepage.validateOrder();
		Assert.assertTrue(result);
	}

	@Test
	public void verifythaddress() {
		indexpage = new IndexPage();
		LoginPage loginpage = indexpage.clickTosignIn();
		homepage = loginpage.loginToApp(prop.getProperty("UserEmail"), prop.getProperty("Password"));
		boolean address = homepage.vaidateAddress();
		Assert.assertTrue(address);
	}
	



}
