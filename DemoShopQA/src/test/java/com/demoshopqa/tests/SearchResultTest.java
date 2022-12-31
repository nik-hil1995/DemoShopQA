/**
 * 
 */
package com.demoshopqa.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoshopqa.baseTest.BaseClass;
import com.demoshopqa.pageObjects.IndexPage;
import com.demoshopqa.pageObjects.SearchResultPage;

/**
 * @author NIkhil Kumar
 *
 */
public class SearchResultTest extends BaseClass {

	IndexPage indexpage;
	SearchResultPage searchresultpage;

	@BeforeMethod
	public void setup() {
		LaunchApp();
	}

	@AfterMethod
	public void teardonw() {

		driver.quit();
	}

	@Test
	public void VerifytheAvailablityofProd() throws InterruptedException {
		indexpage = new IndexPage();
		searchresultpage = indexpage.searchProducts("SHIRT");
		WebElement result = searchresultpage.isProductAvailable(prop.getProperty("product_Name"));
		Assert.assertTrue(result.isDisplayed());
	}


}

