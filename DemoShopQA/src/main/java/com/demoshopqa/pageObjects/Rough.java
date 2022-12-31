package com.demoshopqa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {

	public static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://shop.demoqa.com/");
		driver.findElement(By.cssSelector(".noo-search")).click();
		WebElement form_control = driver.findElement(By.cssSelector(".form-control"));
		form_control.sendKeys("Shirt");
		form_control.sendKeys(Keys.ENTER);
		List<WebElement> productTitle = driver.findElements(By.xpath("//div[@class='noo-product-inner']"));
		WebElement prod = productTitle.stream().filter(product -> product
				.findElement(By.xpath("//div[@class='noo-product-inner']//h3")).getText()
				.equals("PINK DROP SHOULDER OVERSIZED T SHIRT"))
				.findFirst().orElse(null);
		System.out.println(prod.getText());
	}

}
