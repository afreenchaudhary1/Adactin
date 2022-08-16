package org.stepdefination;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageManager;
import org.pages.SelectHotelPages;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelectHotelStepDefination extends Utility{
	PageManager pm;
	SelectHotelPages sp;
	//select hotel
		@Given("User is on SelectHotel page.")
		public void user_is_on_SelectHotel_page() throws IOException  {
			String expectedtitle ="https://adactinhotelapp.com/HotelAppBuild2/SelectHotel.php";
			  String actualtitle =driver.getCurrentUrl();     
		      Assert.assertEquals(actualtitle, expectedtitle);
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      TakesScreenshot tk=(TakesScreenshot)driver;
				File src=tk.getScreenshotAs(OutputType.FILE);
				File des=new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\screenshots\\searchresult.png");
				//copy sec to des
				FileUtils.copyFile(src, des);
//				Thread.sleep(2000);
		}

		@When("User selects a specific hotel")
		public void user_selects_a_specific_hotel() throws  IOException, InterruptedException  {
			Thread.sleep(5000);
			pm = new PageManager();
			sp= pm.getSp();
			btnClick(sp.getRadioBtn());
			Thread.sleep(5000);
			File l = new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\Excel\\hotelselect.xlsx");
			
			WebElement d1 = driver.findElement(By.id("hotel_name_4"));
			String a1 = d1.getAttribute("value");
			
			WebElement d2 = driver.findElement(By.id("price_night_4"));
			String a2 = d2.getAttribute("value");
			
			WebElement d3 = driver.findElement(By.id("total_price_4"));
			String a3 = d3.getAttribute("value");
			
			//set the workbook
			Workbook w = new XSSFWorkbook();
			
//			Sheet s = w.getSheet("Sheet2"); 
			Sheet s = w.createSheet("Sheet2");
			
			//to creat new row
			Row r = s.createRow(2);
					
			//to create new cell
			Cell c = r.createCell(0);		
			c.setCellValue(a1);
			
			Cell c1 = r.createCell(1);		
			c1.setCellValue(a2);
			
			Cell c3 = r.createCell(2);		
			c3.setCellValue(a3);     
			
			
			
			FileOutputStream o = new FileOutputStream(l);
			
			w.write(o);
            Thread.sleep(5000);
			TakesScreenshot tk=(TakesScreenshot)driver;
			File src=tk.getScreenshotAs(OutputType.FILE);
			File des=new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\screenshots\\hotelselected.png");
			//copy sec to des
			FileUtils.copyFile(src, des);
//			Thread.sleep(2000);
		}

		@Then("User should click on continue Button.")
		public void user_should_click_on_continue_Button() throws InterruptedException {
			Thread.sleep(5000);
		    btnClick(sp.getContinueBtn());
		}

}
