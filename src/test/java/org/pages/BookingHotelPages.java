package org.pages;

import org.base.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingHotelPages extends Utility{
	public BookingHotelPages() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="first_name")
	private WebElement fname;
	
	@FindBy(name="last_name")
	private WebElement lname;
	
	@FindBy(css="#address")
	private WebElement address;
	
	@FindBy(xpath="//input[@name='cc_num']")
	private WebElement cardno;
	
	@FindBy(className="select_combobox")
	private WebElement cardtype;
	
	@FindBy(xpath="//select[@id='cc_exp_month']")
	private WebElement expmonth;
	
	@FindBy(xpath="//select[@name='cc_exp_year']")
	private WebElement expyear;
	
	@FindBy(xpath="//input[@id='cc_cvv']")
	private WebElement cvv;
	
	@FindBy(css="#book_now")
	private WebElement bookbtn;
	
	
	

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardno() {
		return cardno;
	}

	public WebElement getCardtype() {
		return cardtype;
	}

	public WebElement getExpmonth() {
		return expmonth;
	}

	public WebElement getExpyear() {
		return expyear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBookbtn() {
		return bookbtn;
	}

	
	

}
