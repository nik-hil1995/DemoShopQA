package com.demoshopqa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshopqa.baseTest.BaseClass;

public class CartPage extends BaseClass {

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr[@class='cart_item']//td[5]//span//bdi")
	WebElement priceTotal;

	@FindBy(xpath = "(//td[@data-title='Total']//span//bdi)[2]")
	WebElement total;

	@FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a")
	WebElement proceedBtn;



	public boolean pricevalidation() {
		boolean flag = false;
		if (priceTotal.isDisplayed()) {
			flag = true;

		} else {
			flag = false;
		}
		return flag;
		
	}

	public CheckoutPage goToCheckout() {
		proceedBtn.click();
		return new CheckoutPage();
	}

}
