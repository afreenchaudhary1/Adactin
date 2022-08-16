package org.stepdefination;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.base.Utility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageManager;
import org.pages.LoginPages;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefinations extends Utility{
	
	PageManager pm;
	LoginPages lp;
		@Given("User is on Adactin Login page.")
		public void user_is_on_Adactin_Login_page() {
			getDriver();
			getUrl("https://adactinhotelapp.com/HotelAppBuild2/");
			driver.manage().window().maximize();
		}

		@When("User enters {string} and {string}")
		public void user_enters_and(String name, String pass) {
			pm = new PageManager();
		    lp= pm.getLp();
		    WebElement username=lp.getUsername();
		    type(username, name);
		   WebElement password=lp.getPassword();;
		    
		    type(password,pass);
		}

		@Then("User should click on Login Button")
		public void user_should_click_on_Login_Button() throws IOException, InterruptedException  {
			btnClick(lp.getLoginBtn());
			TakesScreenshot tk=(TakesScreenshot)driver;
			File src=tk.getScreenshotAs(OutputType.FILE);
			File des=new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\screenshots\\invalidlogin.png");
			//copy sec to des
			FileUtils.copyFile(src, des);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.close();
			
		
		}

		@When("User enters username and password")
		public void user_enters_username_and_password() {
			pm = new PageManager();
		    lp= pm.getLp();
		    WebElement username=lp.getUsername();
		    WebElement password=lp.getPassword();
		    type(username, "sahil3102");
		    type(password,"sahil3105");
		    
		}

		@Then("User again click on Login Button")
		public void user_again_click_on_Login_Button() {
			btnClick(lp.getLoginBtn());
			
		}

		

}
