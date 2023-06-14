package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Datepicker;
import hms.utility.commonutility;

public class complainpage extends Testbase {
	
	
	@FindBy(css="a.btn-primary[href='http://triotend.com/tts/admin/complaint']")WebElement complain;

	@FindBy(css="h3.box-title")WebElement screentitle;
	@FindBy(css="div.box-tools>a")WebElement addcomplain;
	
	@FindBy(xpath="//h4[text()=' Add Complain']")WebElement boxtitle;
	//@FindBy(css="div[id='myModal'] h4[class='box-title']")WebElement boxtitle;
	
	@FindBy(css="form#formadd select[name='complaint']")WebElement complaintype;
	@FindBy(css="form#formadd select[name='source']")WebElement source;
	@FindBy(css="form#formadd input[name='name']")WebElement complainby;
	@FindBy(css="form#formadd input[name='contact']")WebElement phone;
	@FindBy(css="form#formadd input[name='date']")WebElement date;
	@FindBy(css="form#formadd textarea[name='description']")WebElement desc;
	@FindBy(css="form#formadd input[name='action_taken']")WebElement action;
	@FindBy(css="form#formadd input[name='assigned']")WebElement assigned;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='file']")WebElement fileuplod;
	
	public complainpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickcomplain()
	{
		
		complain.click();
	}
	
    public String getscreentitle()
    {
    	return screentitle.getText();
    }
    
    public void clickaddcomplain()
    {
    	addcomplain.click();
    }
    
    public String gettboxtitle()
    {
    	commonutility.waitelement(boxtitle);
    	return boxtitle.getText();
    }
	
    public void getcomplaindetails(String data[])
    {
    	Select drp=new Select(complaintype);
    	drp.selectByVisibleText(data[0]);
    	
    	Select drp1=new Select(source);
    	drp1.selectByVisibleText(data[1]);
    	
    	complainby.sendKeys(data[2]);
    	
    	phone.sendKeys(data[3]);
    	
    	date.click();
    	Datepicker dt=new Datepicker();
    	dt.datpicker(data[4]);
    	
    	desc.sendKeys(data[5]);
    	
    	action.sendKeys(data[6]);
    	
    	assigned.sendKeys(data[7]);
    	
    	note.sendKeys(data[8]);
    	
    	commonutility.clickonwebelement(fileuplod);
    	commonutility.fileupload(data[9]);
    }
	

}
