package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;
import hms.utility.Datepicker;
import hms.utility.commonutility;


public class phonecallpage extends Testbase {
	@FindBy(css="a[href='http://triotend.com/tts/admin/generalcall']")WebElement phcall;
	@FindBy(xpath="//h3[text()='Phone Call Log List']")WebElement screetitle;
	
    @FindBy(css="div.box-tools>a")WebElement addcalllog;
    
    @FindBy(xpath="//h4[text()=' Add Call Log']")WebElement boxtitle;
    
    @FindBy(css="form#formadd input[name='name']")WebElement name;
    @FindBy(css="form#formadd input[name='contact']")WebElement contact;
    @FindBy(css="form#formadd input[name='date']")WebElement date;
    @FindBy(css="form#formadd textarea[name='description']")WebElement description;
    @FindBy(css="form#formadd input[name='follow_up_date']")WebElement followdate;
    @FindBy(css="form#formadd input[name='call_dureation']")WebElement duration;
    @FindBy(css="form#formadd textarea[name='note']")WebElement note;
    @FindBy(css="form#formadd input[value='Incoming']")WebElement radio;
    @FindBy(css="button[type='submit']")WebElement submit;
    
    public phonecallpage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void clickonphonecall()
    {
    	phcall.click();
    }
    public String screentitle()
    {
    	commonutility.waitelement(screetitle);
    	return screetitle.getText();
    }
    
    public void clickonaddcall()
    {
    	addcalllog.click();
    }
    
    public String boxtitl()
    {
    	commonutility.waitelement(boxtitle);
    	return boxtitle.getText();
    }

    public void addphoneloggdetails()
    {
    	name.sendKeys("Dravid");
    	contact.sendKeys("987654123");
    	
    	description.sendKeys("Consult");
    	
    	date.click();
    	Datepicker objdate=new Datepicker();
    	objdate.datpicker("7/7/2023");
    	duration.sendKeys("2");
    	
    	followdate.click();
    	Datepicker objfodate=new Datepicker();
    	objfodate.datpicker("8/8/2023");
    	
    	note.sendKeys("Health issue Discussion");
    	
    	radio.click();
    	
    	submit.click();
    	
    	
    }
}
