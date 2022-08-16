package org.pages;

import org.base.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPages extends Utility{

	public SelectHotelPages() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(xpath="//input[@onclick='check_uncheck4();']")
	private WebElement radioBtn;
	
	
	@FindBy(id="continue")
	private WebElement continueBtn;


	public WebElement getRadioBtn() {
		return radioBtn;
	}


	public WebElement getContinueBtn() {
		return continueBtn;
	}
    
}
