package org.stepdefination;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.base.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.pagemanager.PageManager;
import org.pages.BookedIternaryPages;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookedIternaryStepDefination extends Utility{
	PageManager pm;
	BookedIternaryPages bi;
    
	
    
	//verify and cacel
	@Given("User is on BookedItinerary Page.")
	public void user_is_on_BookedItinerary_Page() throws IOException {
		String expectedtitle ="https://adactinhotelapp.com/HotelAppBuild2/BookedItinerary.php";
		  String actualtitle =driver.getCurrentUrl();     
	      Assert.assertEquals(actualtitle, expectedtitle);
	      TakesScreenshot tk=(TakesScreenshot)driver;
			File src=tk.getScreenshotAs(OutputType.FILE);
			File des=new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\screenshots\\bookeditinerary.png");
			//copy sec to des
			FileUtils.copyFile(src, des);
			
	}
	
	@When("User will Copy order id of first record")
	public void user_will_Copy_order_id_of_first_record() throws AWTException{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	   pm=new PageManager();
	   bi=pm.getBi();
	   WebElement fr = bi.getFirstrec();
	   Actions ac= new Actions(driver);
	   ac.moveToElement(fr).doubleClick().build().perform();
	   Robot r = new Robot();
	   r.keyPress(KeyEvent.VK_CONTROL);
	   r.keyPress(KeyEvent.VK_C);
	   r.keyRelease(KeyEvent.VK_CONTROL);
	   r.keyRelease(KeyEvent.VK_C);
	}
	

	@When("User will paste the OrderId")
	public void user_will_paste_the_OrderId() throws AWTException, IOException {
	  WebElement sb = bi.getSearchoi();
	  sb.click();
	  Robot r = new Robot();
	   r.keyPress(KeyEvent.VK_CONTROL);
	   r.keyPress(KeyEvent.VK_V);
	   r.keyRelease(KeyEvent.VK_CONTROL);
	   r.keyRelease(KeyEvent.VK_V);
	   TakesScreenshot tk=(TakesScreenshot)driver;
		File src=tk.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\screenshots\\useridcopypaste.png");
		//copy sec to des
		FileUtils.copyFile(src, des);
		
	   
	}

	@Then("User should click on Go Button.")
	public void user_should_click_on_Go_Button() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	    bi.getGobtn().click();
	    TakesScreenshot tk=(TakesScreenshot)driver;
		File src=tk.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\asus\\eclipse-workspace\\AdactinProject\\screenshots\\searchresult.png");
		//copy sec to des
		FileUtils.copyFile(src, des);
//		 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}

	@When("User clicks on Cancel Selected Button")
	public void user_clicks_on_Cancel_Selected_Button() throws IOException, InterruptedException {
		 pm=new PageManager();
		 bi=pm.getBi();
		 Thread.sleep(5000);
		 bi.getChbox().click();
	     bi.getCansel().click();;

	}

	@Then("User should click on OK Button.")
	public void user_should_click_on_OK_Button() throws IOException, InterruptedException {
		Alert al = driver.switchTo().alert();
		al.accept();
		Thread.sleep(5000);
		driver.close();
	}

}
