package com.rwb.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rwb.baseTest.BaseClass;

public class SearchResultPage extends BaseClass {


	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "noo-woo-filter")
	WebElement color_filter;

	@FindBy(xpath = "(//select[@class='noo-woo-filter'])[2]")
	WebElement size_filter;

	@FindBy(xpath = "(//select[@class='noo-woo-filter'])[3]")
	WebElement grid_filter;

	@FindBy(xpath = "(//select[@name=\"orderby\"])[1]")
	WebElement orderby_filter;

	@FindBy(xpath = "//div[@class='noo-product-inner']")
	List<WebElement> productTitle;

	
	
	
	public void validateProduct(String productName) {
      WebElement prod= productTitle.stream().filter(product->product.findElement(By.xpath("//div[@class='noo-product-inner']/h3/a"))
				.getText().equals(productName)).findFirst().orElse(null);

	}

	public AddToCartPage addProduct(String producttoadd) {
		WebElement prod= productTitle.stream().filter(product->product.findElement(By.xpath("//div[@class='noo-product-inner']/h3/a"))
				.getText().equals(producttoadd)).findFirst().orElse(null);
		prod.click();
		return new AddToCartPage();
	}



}
