package com.rwb.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rwb.baseTest.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".woocommerce-thankyou-order-received")
	WebElement SuccessMesg;

	@FindBy(xpath = "//li[@class='order']//strong")
	WebElement orderId;

	public void orderConfirmation(String Message1) {
		String Message = SuccessMesg.getText();
		if (Message.equalsIgnoreCase(Message1)) {
			System.out.println("Success");
		} else {
			System.out.println("Failue");
		}
	}

	public void verifyOrderID(String actualOrderID) {
		if (orderId.getText().equalsIgnoreCase(actualOrderID)) {
			System.out.println("Success");
		} else {
			System.out.println("failure");
		}
	}

}
