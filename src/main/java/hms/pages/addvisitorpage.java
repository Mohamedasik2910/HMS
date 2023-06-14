package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Datepicker;
import hms.utility.commonutility;

public class addvisitorpage extends Testbase {
	@FindBy(css="h3.titlefix")WebElement visitortitle;
	@FindBy(css="a.btn-sm")WebElement addvisitor;
	@FindBy(css="#myModal > div > div > div.modal-header.modal-media-header > h4")WebElement addvisitortitle;
	@FindBy(css="form#formadd select[name='purpose']")WebElement purpose;
	@FindBy(css="form#formadd input[name='name']")WebElement pname;
	@FindBy(css="form#formadd input[name='contact']")WebElement pno;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement pid;
	@FindBy(css="form#formadd input[name='pepples']")WebElement pnop;
	@FindBy(css="form#formadd input[name='date']")WebElement datepicker;
	@FindBy(css="form#formadd textarea[name='note']")WebElement pnote;
	@FindBy(css="form#formadd input[name='file']")WebElement fileupload;
	@FindBy(css="button.close1")WebElement closescreen;
	
	
	
	
	public addvisitorpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getvisitortitle()
	{
		return visitortitle.getText();
		
	}
	public void clickaddvisitor()
	{
		addvisitor.click();
	}
	public String getaddvisitortitle()
	{
		
		commonutility.waitelement(addvisitortitle);
		return addvisitortitle.getText();
		
	}
	public void closescreens()
	{
		closescreen.click();
	}
	public void addvistordetails()
	{
		Select drp=new Select(purpose);
		drp.selectByVisibleText("checkup");
		
		pname.sendKeys("King");
		pno.sendKeys("987654321");
		pid.sendKeys("Id_0001");
		pnop.sendKeys("2");
		pnote.sendKeys("To Consult Doctor");
		
		datepicker.click();
		Datepicker objdate=new Datepicker();
		 
		
		
		commonutility.clickonwebelement(fileupload);
		commonutility.fileupload("E:\\Fileupload\\Chatbots.docx");
	}
	public void addvistorexcel(String data[])
	{
		Select drp=new Select(purpose);
		drp.selectByVisibleText(data[0]);
		
		pname.sendKeys(data[1]);
		pno.sendKeys(data[2]);
		pid.sendKeys(data[3]);
		pnop.sendKeys(data[4]);
		pnote.sendKeys(data[6]);
		
		datepicker.click();
		Datepicker objdate=new Datepicker();
		objdate.datpicker(data[5]);
		
		
		commonutility.clickonwebelement(fileupload);
		commonutility.fileupload(data[7]);	
		
	
	}
	

}
