package org.stepdefination;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.base.Utility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.pagemanager.PageManager;
import org.pages.SearchHotelPages;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchHotelStepDefinations extends Utility{
	PageManager pm;
	SearchHotelPages sh;
	//search hotel
		@Given("User is on SearchHotel page.")
		public void user_is_on_SearchHotel_page() throws IOException, InterruptedException  {
			 String expectedtitle ="https://adactinhotelapp.com/HotelAppBuild2/SearchHotel.php";
			  String actualtitle =driver.getCurrentUrl();     
		      Assert.assertEquals(actualtitle, expectedtitle);
		      TakesScreenshot tk=(TakesScreenshot)driver;
				File src=tk.getScreenshotAs(OutputType.FILE);
				File des=new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\screenshots\\validlogin.png");
				//copy sec to des
				FileUtils.copyFile(src, des);
				Thread.sleep(2000);
		      
		}

		@When("User selects the location,hotel,roomtype and  number of rooms.")
		public void user_selects_the_location_hotel_roomtype_and_number_of_rooms() {
			pm = new PageManager();
			sh= pm.getSh();
		    Dropdown(sh.getLocation(),"Sydney");
		    Dropdown(sh.getRooms(),"2 - Two");
		}

		@When("User  enters check-in and check-out dates.")
		public void user_enters_check_in_and_check_out_dates() {
		    type(sh.getCheckIn(),"24/10/2022");
		   	type(sh.getCheckOut(),"2/11/2022");
		    
		}

		@When("User selects adults and children per room.")
		public void user_selects_adults_and_children_per_room() throws IOException, InterruptedException  {
			Dropdown(sh.getAdults(),"2 - Two");
			TakesScreenshot tk=(TakesScreenshot)driver;
			File src=tk.getScreenshotAs(OutputType.FILE);
			File des=new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\screenshots\\searchquery.png");
			//copy sec to des
			FileUtils.copyFile(src, des);
			Thread.sleep(2000);

		}

		@Then("User should click on search Button.")
		public void user_should_click_on_search_Button() {
			btnClick(sh.getBtnSearch());
			
		}
	 

}
