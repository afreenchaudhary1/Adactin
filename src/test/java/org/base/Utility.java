package org.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {
public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\driver\\chromedriver.exe");
		
	    driver = new ChromeDriver();
		return driver;
	}
	public static void getUrl(String txt) {
		driver.get(txt);
	}
	public static void type(WebElement element, String txt) {
		element.sendKeys(txt);
			
	}
	public static void btnClick(WebElement element) {
		element.click();
		
	}
	public static void Dropdown(WebElement element,String txt) {
	    Select s=new Select(element);
	    s.selectByVisibleText(txt);
       // s.selectByValue(txt);
	}


}
