package org.testng;

import org.base.Utility;
import org.openqa.selenium.By;
import org.pages.LoginPages;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngClass extends Utility{
	@Test
	//@Parameters({"Username,Password"})
	@Parameters({"UserName","Password"})
	public void param1(String name,String credentials) {
		getDriver();
		getUrl("https://adactinhotelapp.com/index.php");
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(credentials);
        LoginPages lp=new LoginPages();
        btnClick(lp.getLoginBtn());
	}
	
	
//	@Test
//	@Parameters({"UserName","Password"})
//	public void param2(@Optional("opt name")String name,String credentials) {
//     System.out.println("name is: "+name);
//     System.out.println("password is: "+credentials);
//	}

}
