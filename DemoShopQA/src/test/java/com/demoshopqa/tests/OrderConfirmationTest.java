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
public class OrderConfirmationTest extends BaseClass{

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

	@AfterMethod
	public void teardonw() {

		driver.quit();
	}

	
	
	
    @Test
	public void VerifyTheOrderConfimration() throws InterruptedException {
		indexpage = new IndexPage();
		searchResultPage = indexpage.searchProducts("shirt");
		productPage = searchResultPage.addProduct(prop.getProperty("product_Name"));
		cartpage = productPage.addProductToCart("pink", "36");
		checkoutpage=cartpage.goToCheckout();
		orderconfirmationpage=checkoutpage.checkoutAProduct();
		Assert.assertTrue(orderconfirmationpage.orderConfirmation("Thank you. Your order has been received."));
	}
    
    
	@Test
	public void CheckWhethererTheOrderID() throws InterruptedException {
		VerifyTheOrderConfimration();
		Assert.assertTrue(orderconfirmationpage.verifyOrderID());
		
	}
	
	
	
}
