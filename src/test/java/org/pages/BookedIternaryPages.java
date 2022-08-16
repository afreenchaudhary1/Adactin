package org.pages;

import org.base.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedIternaryPages extends Utility{
	public BookedIternaryPages() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(xpath="//td//input[@class='select_text'][1]")
	private WebElement firstrec;
	
	@FindBy(id="order_id_text")
	private WebElement searchoi;
	
		@FindBy(xpath="//input[@value='Go']")
	private WebElement gobtn;
	
	@FindBy(id="check_all")
	private WebElement chbox;
	
	@FindBy(name="cancelall")
	private WebElement cansel;

	public WebElement getSearchoi() {
		return searchoi;
	}

	public WebElement getGobtn() {
		return gobtn;
	}

	public WebElement getChbox() {
		return chbox;
	}

	public WebElement getCansel() {
		return cansel;
	}

	public WebElement getFirstrec() {
		return firstrec;
	}
    

}
