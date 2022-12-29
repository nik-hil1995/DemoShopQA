package com.rwb.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rwb.actionDrivers.Actionable;
import com.rwb.baseTest.BaseClass;

public class IndexPage extends BaseClass {

	Actionable act = new Actionable();

	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	WebElement myAccountbtn;

	@FindBy(xpath = "//a[contains(text(),'My Wishlist')]")
	WebElement wishlistbtn;

	@FindBy(css = ".noo-search")
	WebElement searchBar;

	@FindBy(xpath = "(//img[@class='custom-logo'])[1]")
	WebElement CustomLogo;

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickTosignIn() {
		myAccountbtn.click();
		return new LoginPage();
	}

	public boolean validateLogo() {
		return act.isDisplayed(driver, CustomLogo);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public SearchResultPage searchProducts(String productName) {
		act.type(searchBar, productName);
		searchBar.sendKeys(Keys.ENTER);
		return new SearchResultPage();

	}


}
