package hms.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Datepicker;
import hms.utility.commonutility;

public class operationpage extends Testbase
{
	@FindBy(css="a[href='http://triotend.com/tts/admin/operationtheatre/otsearch']")WebElement operation;
	@FindBy(xpath="//h3[text()=' Operation Theatre Patient']")WebElement screentitle;
	@FindBy(css="div.box-tools>a")WebElement addpatient;
	@FindBy(xpath="//h4[text()='Add Patient Details']")WebElement boxtitle;
	
	@FindBy(css="form#formadd select[name='customer_type']")WebElement patienttype;
	@FindBy(css="form#formadd input[name='opd_ipd_no']")WebElement opdno;
	@FindBy(css="form#formadd input[name='patient_name']")WebElement patientname;
	@FindBy(css="form#formadd input[name='guardian_name']")WebElement guardianname;
	@FindBy(css="form#formadd input[name='mobileno']")WebElement mobno;
	@FindBy(css="form#formadd select[name='gender']")WebElement gender;
	@FindBy(css="form#formadd input[name='age']")WebElement age;
	@FindBy(css="form#formadd input[name='month']")WebElement month;
	@FindBy(css="form#formadd input[name='guardian_address']")WebElement address;
	@FindBy(css="form#formadd input[name='result']")WebElement result;
	@FindBy(css="form#formadd textarea[name='remark']")WebElement remark;
	
	@FindBy(css="form#formadd input[name='operation_name']")WebElement opname;
	@FindBy(css="form#formadd input[name='operation_type']")WebElement optype;
	@FindBy(css="form#formadd input[name='date']")WebElement opdate;
	@FindBy(css="form#formadd select[name='consultant_doctor']")WebElement consdoctor;
	@FindBy(css="form#formadd input[name='ass_consultant_1']")WebElement asscon1;
	@FindBy(css="form#formadd input[name='ass_consultant_2']")WebElement asscon2;
	@FindBy(css="form#formadd input[name='anesthetist']")WebElement anes;
	@FindBy(css="form#formadd input[name='anaethesia_type']")WebElement anestype;
	@FindBy(css="form#formadd input[name='ot_technician']")WebElement ottechni;
	@FindBy(css="form#formadd input[name='ot_assistant']")WebElement otass;
	@FindBy(css="form#formadd select[name='organisation']")WebElement tpa;
	@FindBy(css="form#formadd select[name='charge_category_id']")WebElement chargecat;
	@FindBy(css="form#formadd select[name='code']")WebElement code;
	
	public operationpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Operation_Module_Click
	public void operationclickon()
	{
		commonutility.waitelement(operation);
		operation.click();
	}
	//Get_Screen_Title
	public String getscreentitle()
	{
		commonutility.waitelement(screentitle);
		return screentitle.getText();
	}
	//Click_On_Addpatient
	public void addpatientclickon()
	{
		commonutility.waitelement(addpatient);
		addpatient.click();
	}
	
   //Get_Box_Title
	public String getboxtitle()
	{
		commonutility.waitelement(boxtitle);
		return boxtitle.getText();
	}
	//Add_Patient_Details
	public void gettpatientdetail()
	{
		commonutility.clickonwebelement(patienttype);
		Select drp=new Select(patienttype);
		drp.selectByVisibleText("IPD");
		opdno.sendKeys("123");
		patientname.sendKeys("XXX");
		guardianname.sendKeys("YYY");
		mobno.sendKeys("9876543210");
		
		commonutility.clickonwebelement(gender);
		Select drp1=new Select(gender);
		drp1.selectByVisibleText("Male");
		age.sendKeys("29");
		month.sendKeys("11");
		address.sendKeys("Coimbatore");
		result.sendKeys("Positive");
		remark.sendKeys("Under Guideliness");
		
		opname.sendKeys("Heart Surgery");
		optype.sendKeys("Surgery");
		
		commonutility.clickonwebelement(opdate);
		Datepicker dt=new Datepicker();
		dt.datpicker("22/8/1998");
		 
		commonutility.clickonwebelement(consdoctor);
		Select drp2=new Select(consdoctor);
		drp2.selectByVisibleText("John Cartor");
				
		asscon1.sendKeys("AAAA");
		asscon2.sendKeys("BBBB");
		anes.sendKeys("CCCC");
		anestype.sendKeys("Normal");
		ottechni.sendKeys("DDDD");
		otass.sendKeys("EEEE");
		
		commonutility.clickonwebelement(tpa);
		Select drp3=new Select(tpa);
		drp3.selectByVisibleText("FHPL");
		
		commonutility.clickonwebelement(chargecat);
		Select drp4=new Select(chargecat);
		drp4.selectByVisibleText("Bed");
		
		commonutility.clickonwebelement(code);
		Select drp5=new Select(code);
		drp5.selectByVisibleText("143 - nothing");
		
	}
	
	
	
	
	
	

}
