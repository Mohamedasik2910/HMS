package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;
import hms.utility.Datepicker;
import hms.utility.commonutility;

public class postaldispatchpage extends Testbase {
	
	@FindBy(css="ul.dropdown-menu.multi-level>li:nth-child(2)")WebElement send;
	@FindBy(xpath="//h3[text()='Postal Dispatch List']")WebElement screentitle;
	@FindBy(css="div.box-tools>a")WebElement adddispatch;
	@FindBy(xpath="//h4[text()=' Add Dispatch']")WebElement boxtitle;
	
	@FindBy(css="input[name='to_title']")WebElement totile;
	@FindBy(css="input[name='ref_no']")WebElement refno;
	@FindBy(css="textarea[name='address']")WebElement address;
	@FindBy(css="textarea[name='note']")WebElement note;
	@FindBy(css="input[name='from_title']")WebElement fromtitle;
	@FindBy(css="input[name='date']")WebElement date;
	@FindBy(css="input[name='file']")WebElement fileupload;
	
	
	public postaldispatchpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickdispatch()
	{
		commonutility.waitelement(send);
		send.click();
	}
	
	public String getscreentitle()
	{
		commonutility.waitelement(screentitle);
		return screentitle.getText();
		
	}
	
	public void clickadddispatch()
	{
		commonutility.waitelement(adddispatch);
		adddispatch.click();
	}
	
	public String getboxtitle()
	{
		commonutility.waitelement(boxtitle);
		return boxtitle.getText();
		
	}
	
	public void getdispatchexcel(String data[])
	{
		totile.sendKeys(data[0]);
		refno.sendKeys(data[1]);
		address.sendKeys(data[2]);
		note.sendKeys(data[3]);
		fromtitle.sendKeys(data[4]);
		
		date.click();
		Datepicker dt=new Datepicker();
		dt.datpicker(data[5]);
		
		commonutility.clickonwebelement(fileupload);
		commonutility.fileupload(data[6]);
	}
	
	
	

}
