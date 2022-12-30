package com.demoshopqa.actionDrivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoshopqa.baseTest.BaseClass;

public class Actionable extends BaseClass {

	public void clickToElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}

	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			// System.out.println("Location not found: "+locatorName);
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}

	public boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed");
			} else {
				System.out.println("The element is not Displayed");
			}
		} else {
			System.out.println("Not displayed ");
		}
		return flag;
	}


	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void explicitwait(WebDriver driver, WebElement Ele,Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(Ele));
	}

	public void pageLoadTimeout(WebDriver driver, Duration timeout) {
		driver.manage().timeouts().pageLoadTimeout(timeout);
	}

	public void type(WebElement ele, String text) {
		boolean flag=false;
		try {
			flag= ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
		}
		catch (Exception e) {
			System.out.println("location not found");
			flag = false;
		}
		finally {
			if (flag) {
				System.out.println("Value entered succesfully");
			} else {
				System.out.println("unable to enter the value");
			}
		}
	}

}
