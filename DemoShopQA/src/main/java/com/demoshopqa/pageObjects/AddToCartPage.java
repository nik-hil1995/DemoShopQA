package com.demoshopqa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPage {

	@FindBy(css = "#pa_color")
	WebElement coloroption;

	@FindBy(css = "#pa_size")
	WebElement sizeoption;

	@FindBy(css = ".qty-increase")
	WebElement QtyIncrease;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement addToCartBtn;

	@FindBy(css = ".cart-button")
	WebElement cartBtn;

	public CartPage addProductToCart(String color, String size) {
		Select select1 = new Select(coloroption);
		select1.selectByValue(color);
		Select select2 = new Select(sizeoption);
		select2.deselectByValue(size);
		QtyIncrease.click();
		addToCartBtn.click();
		cartBtn.click();
		return new CartPage();
	}

}
