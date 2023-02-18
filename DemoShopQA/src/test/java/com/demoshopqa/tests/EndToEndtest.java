/**
 * 
 */
package com.demoshopqa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoshopqa.baseTest.BaseClass;
import com.demoshopqa.pageObjects.CartPage;
import com.demoshopqa.pageObjects.CheckoutPage;
import com.demoshopqa.pageObjects.IndexPage;
import com.demoshopqa.pageObjects.OrderConfirmationPage;
import com.demoshopqa.pageObjects.ProductPage;
import com.demoshopqa.pageObjects.SearchResultPage;

/**
 * @author NIkhil Kumar
 *
 */
public class EndToEndtest extends BaseClass{

	IndexPage indexpage;
	SearchResultPage searchResultPage;
	ProductPage productPage;
	CartPage cartpage;
	CheckoutPage checkoutpage;
	OrderConfirmationPage orderconfirmationpage;
	@BeforeMethod
	public void setup() {
		LaunchApp();
	}
	@Test
	public void EndtoEndTest() throws InterruptedException {
		indexpage = new IndexPage();
		searchResultPage = indexpage.searchProducts("shirt");
		productPage = searchResultPage.addProduct(prop.getProperty("product_Name"));
		cartpage= productPage.addProductToCart("pink", "36");
		checkoutpage=cartpage.goToCheckout();
        orderconfirmationpage= checkoutpage.checkoutAProduct();
        
		Assert.assertTrue(orderconfirmationpage.orderConfirmation("Thank you. Your order has been received."));
		System.out.println("End to End test successfully passed!!");
	}
	
	
	@AfterMethod
	public void teardonw() {

		driver.quit();
	}

	

	
	
	

	
	
}
