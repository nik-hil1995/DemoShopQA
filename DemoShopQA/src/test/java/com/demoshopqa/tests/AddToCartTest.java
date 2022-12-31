/**
 * 
 */
package com.demoshopqa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoshopqa.baseTest.BaseClass;
import com.demoshopqa.pageObjects.IndexPage;
import com.demoshopqa.pageObjects.ProductPage;
import com.demoshopqa.pageObjects.SearchResultPage;

/**
 * @author NIkhil Kumar
 *
 */
public class AddToCartTest extends BaseClass {

	IndexPage indexpage;
	SearchResultPage searchresultpage;
	ProductPage productpage;

	@BeforeMethod
	public void setup() {
		LaunchApp();
	}

	@AfterMethod
	public void teardonw() {

		driver.quit();
	}

	@Test
	public void VerifyAddtocart() throws InterruptedException {
		indexpage = new IndexPage();
		searchresultpage = indexpage.searchProducts("shirt");
		productpage = searchresultpage.addProduct(prop.getProperty("product_Name"));
		productpage.addProductToCart("pink", "36");
		


	}

}
