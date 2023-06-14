package hms.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.commonutility;

public class pharmacypage extends Testbase 
{
	@FindBy(css="a[href='http://triotend.com/tts/admin/pharmacy/bill']")WebElement pharmacyclick;
	@FindBy(xpath="//h3[text()=' Pharmacy Bill']")WebElement screentitle;
	@FindBy(css="a[href='http://triotend.com/tts/admin/pharmacy/search']")WebElement medicineclick;
	@FindBy(xpath="//h3[text()='Medicines']")WebElement screentitle1;
	@FindBy(css="div.box-tools>a")WebElement addmedicineclick;
	@FindBy(xpath="//h4[text()='Add Medicine Details']")WebElement boxtitle;
	
	@FindBy(css="form#formadd input[name='medicine_name']")WebElement medicinename;
	@FindBy(css="form#formadd select[name='medicine_category_id']")WebElement medcategory;
	@FindBy(css="form#formadd input[name='medicine_company']")WebElement medicinecompany;
	@FindBy(css="form#formadd input[name='medicine_composition']")WebElement medcomp;
	@FindBy(css="form#formadd input[name='medicine_group']")WebElement medgroup;
	@FindBy(css="form#formadd input[name='supplier']")WebElement supp;
	@FindBy(css="form#formadd input[name='unit']")WebElement unit;
	@FindBy(css="form#formadd input[name='min_level']")WebElement minlevel;
	@FindBy(css="form#formadd input[name='reorder_level']")WebElement reorderlevel;
	@FindBy(css="form#formadd input[name='vat']")WebElement vat;
	@FindBy(css="form#formadd input[name='unit_packing']")WebElement unitpacking;
	@FindBy(css="form#formadd input[name='vat_ac']")WebElement vatac;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='medicine_image']")WebElement image;
	
	public pharmacypage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//pharmacy_click
	public void pharmacyonclick()
	{
		commonutility.waitelement(pharmacyclick);
		pharmacyclick.click();
	}
	
	//Get_Screen_Title
	public String getscreentitle()
	{
		commonutility.waitelement(screentitle);
		return screentitle.getText();
	}
	
	//Medicine_Button_click
	public void medicineclickon()
	{
		commonutility.waitelement(medicineclick);
		medicineclick.click();
	}
	
	//Get_Screen_Title1
	public String getscreentitle1()
	{
		commonutility.waitelement(screentitle1);
		return screentitle1.getText();
	}
	
	//Add_Medicine_Button_Click
	public void addmedicineclickon()
	{
		commonutility.waitelement(addmedicineclick);
		addmedicineclick.click();
	}
	
	//Get_Boxtitle
	public String getboxtitle()
	{
		commonutility.waitelement(boxtitle);
		return boxtitle.getText();
		
	}
	
	//Add_Basic_Details
	public void getmedicinedetails(String data[])
	{
		medicinename.sendKeys(data[0]);
		
		commonutility.clickonwebelement(medcategory);
		Select db=new Select(medcategory);
		db.selectByVisibleText(data[1]);
		
		medicinecompany.sendKeys(data[2]);
		medcomp.sendKeys(data[3]);
		medgroup.sendKeys(data[4]);
		supp.sendKeys(data[5]);
		unit.sendKeys(data[6]);
		minlevel.sendKeys(data[7]);
		reorderlevel.sendKeys(data[8]);
		vat.sendKeys(data[9]);
		unitpacking.sendKeys(data[10]);
		vatac.sendKeys(data[11]);
		note.sendKeys(data[12]);
		
		commonutility.clickonwebelement(image);
		commonutility.fileupload(data[13]);
		
	}
	
	

}
