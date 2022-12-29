package com.rwb.baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rwb.actionDrivers.Actionable;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;

	public void loadConfig() {
		try {
			Properties prop=new Properties();
			System.out.println("super constructot invoked");
	        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");	
	        prop.load(file);
			System.out.println("driver: " + driver);
	        
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void LaunchApp() {
		WebDriverManager.chromedriver().setup();
		String Browser = prop.getProperty("browser");
		if (Browser.contains("chrome")) {
			driver = new ChromeDriver();
		}
		else if (Browser.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (Browser.contains("edgedriver")) {
			driver = new EdgeDriver();

		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(prop.getProperty("URL"));

	}
	
}
