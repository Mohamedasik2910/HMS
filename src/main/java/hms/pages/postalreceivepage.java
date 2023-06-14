package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;
import hms.utility.Datepicker;
import hms.utility.commonutility;

public class postalreceivepage extends Testbase
{
	
	@FindBy(css="ul.sidebar-menu>li")WebElement fronoffice;
	
	@FindBy(css="button#dropdownMenu1")WebElement postalclick;
	

	
	@FindBy(css="ul.dropdown-menu.multi-level>li")WebElement receive;
	
	//@FindBy(xpath="a[href='http://triotend.com/tts/admin/receive']")WebElement receive;
	

	@FindBy(xpath="//h3[text()='Postal Receive List']")WebElement screentitle;
	@FindBy(xpath="//i[@class='fa fa-plus']")WebElement addreceive;
	@FindBy(xpath="//h4[text()=' Add Receive']")WebElement boxtitle;
	@FindBy(css="form#formadd input[name='from_title']")WebElement fromtitle;
	@FindBy(css="form#formadd input[name='ref_no']")WebElement refno;
	@FindBy(css="form#formadd textarea[name='address']")WebElement address;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='to_title']")WebElement title;
	@FindBy(css="form#formadd input[name='date']")WebElement date;
	@FindBy(css="form#formadd input[name='file']")WebElement file;
	@FindBy(css="button.close1")WebElement close;
	
	public postalreceivepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void frontofficeclick()
	{
	
		fronoffice.click();
	}
	
	public void postalonclick()
	{
		commonutility.waitelement(postalclick);
		postalclick.click();
	}
	
	public void clickonrecive()
	{
		commonutility.waitelement(receive);
		receive.click();
	}
	
	public String getscreentitle()
	{
		commonutility.waitelement(screentitle);
		return screentitle.getText();
	}
	
	public void clickaddrecive()
	{
		commonutility.waitelement(addreceive);
		addreceive.click();
	}
	
	public String getboxtitle()
	{
		commonutility.waitelement(boxtitle);
		return boxtitle.getText();
	}
	
	public void getreceivedexcel(String data[])
	{
		fromtitle.sendKeys(data[0]);
		refno.sendKeys(data[1]);
		address.sendKeys(data[2]);
		note.sendKeys(data[3]);
		title.sendKeys(data[4]);
		date.click();
		Datepicker dp=new Datepicker();
		dp.datpicker(data[5]);
		commonutility.clickonwebelement(file);
		commonutility.fileupload(data[6]);
		close.click();
		
	}

}
