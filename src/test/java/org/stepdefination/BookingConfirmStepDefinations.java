package org.stepdefination;






import org.base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageManager;
import org.pages.BookingConfirmPages;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BookingConfirmStepDefinations extends Utility{
	PageManager pm;
	BookingConfirmPages bp;
	//copying id
		@Given("User is on BookingConfirmation page")
		public void user_is_on_BookingConfirmation_page()  {
			Assert.assertTrue(true);
			
		}


		@Then("user clicks on the MyItinerary Button.")
		public void user_clicks_on_the_MyItinerary_Button() throws InterruptedException {
			Thread.sleep(5000);
			WebElement btn=driver.findElement(By.xpath("//a[text()='Booked Itinerary']"));
			btn.click();
		}


}
