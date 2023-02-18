package com.demoshopqa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshopqa.baseTest.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".woocommerce-thankyou-order-received")
	WebElement SuccessMesg;

	@FindBy(xpath = "//li[@class='order']//strong")
	WebElement orderId;

	public boolean orderConfirmation(String Message1) {
		boolean flag= false;
		String Message = SuccessMesg.getText();
		if (Message.equalsIgnoreCase(Message1)) {
			flag= true;
		} else {
			flag= false;
		}
		return flag;
	}

	public boolean verifyOrderID() {
		boolean flag=false;
		if (orderId.isDisplayed()) {
			flag= true;
		} else {
			flag= false;
		}
		return flag;
	}

}
