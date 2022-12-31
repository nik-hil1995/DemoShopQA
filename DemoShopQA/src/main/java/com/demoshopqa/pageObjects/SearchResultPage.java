package com.demoshopqa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshopqa.baseTest.BaseClass;

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
	List<WebElement> products;

	@FindBy(xpath = "//div[@class='noo-product-inner']//h3")
	WebElement productTitle;

	
	
	
	public WebElement isProductAvailable(String productName) {
		return products.stream()
				.filter(product -> product.findElement(By.xpath("//div[@class='noo-product-inner']//h3"))
				.getText().equals(productName)).findFirst().orElse(null);


	}

	public ProductPage addProduct(String producttoadd) {
		products.stream()
				.filter(product -> product.findElement(By.xpath("//div[@class='noo-product-inner']//h3"))
				.getText().equals(producttoadd)).findFirst().orElse(null);
		productTitle.click();
		return new ProductPage();
	}



}
