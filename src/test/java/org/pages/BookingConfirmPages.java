package org.pages;

import org.base.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmPages extends Utility{
	public BookingConfirmPages() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='order_no']")
	private WebElement orderid;
			
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement myiterbtn;

	public WebElement getOrderid() {
		return orderid;
	}

	public WebElement getMyiterbtn() {
		return myiterbtn;
	}
	
	

}
