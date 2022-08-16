package org.pages;

import org.base.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPages extends Utility{
	public SearchHotelPages() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(xpath="//select[@name='room_nos']")
	private WebElement rooms;

	@FindBy(xpath="//input[@class='date_pick'][1]")
	private WebElement checkIn;

	@FindBy(name="datepick_out")
	private WebElement checkOut;

	@FindBy(xpath="//select[@id='adult_room']")
	private WebElement adults;

	@FindBy(xpath="//input[@value='Search']")
	private WebElement btnSearch;

	public WebElement getLocation() {
		return location;
	}

	public WebElement getRooms() {
		return rooms;
	}

	public WebElement getCheckIn() {
		return checkIn;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getAdults() {
		return adults;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}


}
