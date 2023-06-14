package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Datepicker;
import hms.utility.commonutility;

public class financeincomepage extends Testbase {
	@FindBy(css="ul.sidebar-menu>li:nth-child(10)")WebElement finclick;
	
	@FindBy(css="ul.treeview-menu.menu-open>li:nth-child(1)")WebElement incomeclick;
	
	@FindBy(css="div.box-header>h3")WebElement screentitle;
	@FindBy(css="div.box-tools>a")WebElement clickaddincome;
	
	@FindBy(xpath="//h4[text()='Add Income']")WebElement boxtitle;
	
	@FindBy(css="form#add_income select[name='inc_head_id']")WebElement purpose;
	@FindBy(css="form#add_income input[name='name']")WebElement name;
	@FindBy(css="form#add_income input[name='invoice_no']")WebElement invoice;
	@FindBy(css="form#add_income input[name='date']")WebElement date;
	@FindBy(css="form#add_income input[name='amount']")WebElement amount;
	@FindBy(css="form#add_income input[name='documents']")WebElement fileupload;
	@FindBy(css="form#add_income textarea[name='description']")WebElement desc;
	
	public financeincomepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickfinanceincome()
	{
	finclick.click();
	
	}
	
	public void clickincome()
	{
		incomeclick.click();
	}
	
	public String getscreentitle()
	{
		return screentitle.getText();
	}
	
	public void clickonaddincome()
	{
		clickaddincome.click();
	}
	
	public String getboxtitle()
	{
		commonutility.waitelement(boxtitle);
		return boxtitle.getText();
	}
	
	public void getincomedetails()
	{
		
		Select dlb=new Select(purpose);
		dlb.selectByVisibleText("Based on testing levels");
		
		name.sendKeys("Vijay");
		
		invoice.sendKeys("ID_0123");
		
		date.click();
		Datepicker obj=new Datepicker();
		obj.datpicker("7/7/1988");
		
		amount.sendKeys("10000");
		
		commonutility.clickonwebelement(fileupload);
		commonutility.fileupload("E:\\Fileupload\\Chatbots.docx");
		
		desc.sendKeys("As per Doctor Advice");
		
	}
	
	public void getincomedetailsexcel(String data[])
	{
		commonutility.waitelement(purpose);
		Select dlb=new Select(purpose);
		dlb.selectByVisibleText(data[0]);
		
		
		name.sendKeys(data[1]);
		
		invoice.sendKeys(data[2]);
		
		date.click();
		Datepicker obj=new Datepicker();
		obj.datpicker(data[3]);
		
		amount.sendKeys(data[4]);
		
		commonutility.clickonwebelement(fileupload);
		commonutility.fileupload(data[5]);
		
		desc.sendKeys(data[6]);
		
		
	}
	
	
	
	

}
