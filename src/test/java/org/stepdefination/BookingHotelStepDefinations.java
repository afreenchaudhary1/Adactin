package org.stepdefination;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.base.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageManager;
import org.pages.BookingHotelPages;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingHotelStepDefinations extends Utility{
	PageManager pm;
	BookingHotelPages bh;
	
	//booking hotel 
		@Given("User is on BookAHotel page.")
		public void user_is_on_BookAHotel_page() throws IOException  {
			String expectedtitle ="https://adactinhotelapp.com/HotelAppBuild2/BookHotel.php";
			  String actualtitle =driver.getCurrentUrl();     
		      Assert.assertEquals(actualtitle, expectedtitle);
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      TakesScreenshot tk=(TakesScreenshot)driver;
				File src=tk.getScreenshotAs(OutputType.FILE);
			   File des=new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\screenshots\\Addedbookingdetails.png");
			  //copy sec to des
			  FileUtils.copyFile(src, des);
		    
		    
		}

		@When("User enters firstname,lastname,billing address and credit card number")
		public void user_enters_firstname_lastname_billing_address_and_credit_card_number() throws InterruptedException {
			Thread.sleep(5000);
			pm=new PageManager();
			bh=pm.getBh();
		    WebElement fname=bh.getFname();
		    WebElement lname=bh.getLname();
		    WebElement add=bh.getAddress();
		    WebElement card=bh.getCardno();
		    type(fname,"team6");
		    type(lname,"sprint2");
		    type(add,"St Thomas Road, Churchgate Mumbai");
		    //type(card,"2111111111111111");
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("arguments[0].setAttribute('value', '2111111111111111')", card);
		    
		}

		@When("User selects credit card type and expiry date")
		public void user_selects_credit_card_type_and_expiry_date() {
			WebElement ct=bh.getCardtype();
			WebElement m=bh.getExpmonth();
			WebElement y=bh.getExpyear();
		    Dropdown(ct,"VISA");
		    Dropdown(m,"October");
		    Dropdown(y,"2022");
		}

		@When("User enters CVV number")
		public void user_enters_CVV_number() throws IOException   {
			WebElement cvv=bh.getCvv();
			type(cvv,"123");
			TakesScreenshot tk=(TakesScreenshot)driver;
			File src=tk.getScreenshotAs(OutputType.FILE);
			File des=new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\screenshots\\Addedbookingdetails.png");
			//copy sec to des
			FileUtils.copyFile(src, des);
			

		}

		@Then("User should click on Book Now Button.")
		public void user_should_click_on_Book_Now_Button() throws InterruptedException  {
			Thread.sleep(5000);
			WebElement btn=bh.getBookbtn();
		   btnClick(btn); 
		 
		}

}
