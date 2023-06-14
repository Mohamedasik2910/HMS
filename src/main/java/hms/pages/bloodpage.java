package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.commonutility;

public class bloodpage extends Testbase {
	@FindBy(css="ul.sidebar-menu>li:nth-child(8)")WebElement clickblood;
	@FindBy(xpath="//h3[text()='Blood Bank Status']")WebElement screentitle;
	@FindBy(css="a.btn-primary[href='http://triotend.com/tts/admin/bloodbank/search']")WebElement clickdonor;
	
	@FindBy(xpath="//h3[text()=' Donor Details']")WebElement boxtitle;
	//@FindBy(css="a.pull-right")WebElement clickaddblood;
	//@FindBy(xpath="//i[text()=' Add Blood Donor']")WebElement clickaddblood;
	
	@FindBy(css="a.btn-primary[data-toggle='modal']")WebElement clickaddblood;
	@FindBy(xpath="//h4[text()='Add Donor Details']")WebElement boxtitle2;
	@FindBy(css="form#formadd input[name='donor_name']")WebElement name;
	@FindBy(css="form#formadd input[name='age']")WebElement age;
	@FindBy(css="form#formadd input[name='month']")WebElement month;
	@FindBy(css="form#formadd select[name='blood_group']")WebElement bloodgroup;
	@FindBy(css="form#formadd select[name='gender']")WebElement gender;
	@FindBy(css="form#formadd input[name='father_name']")WebElement fname;
	@FindBy(css="form#formadd input[name='contact_no']")WebElement phno;
	@FindBy(css="form#formadd textarea[name='address']")WebElement address;
	@FindBy(css="button.close12")WebElement close;
	
public bloodpage()
{
	PageFactory.initElements(driver, this);
}

public void clickonblood()
{
	clickblood.click();
}

public String getscreentitle()
{
	commonutility.waitelement(screentitle);
	return screentitle.getText();
}

public void clickondonor()
{
	clickdonor.click();
}

public String getboxtitle()
{
	commonutility.waitelement(boxtitle);
	return boxtitle.getText();
}
public void clickonaddblood()
{
	commonutility.waitelement(clickaddblood);
	clickaddblood.click();
}
public String getboxtitle2()
{
	commonutility.waitelement(boxtitle2);
	return boxtitle2.getText();
}
public void getblooddetailsexcel(String data[])
{
	name.sendKeys(data[0]);
	age.sendKeys(data[1]);
	month.sendKeys(data[2]);
	
	Select drp=new Select(bloodgroup);
	drp.selectByVisibleText(data[3]);
	
	Select drp1=new Select(gender);
	drp1.selectByVisibleText(data[4]);
	
	fname.sendKeys(data[5]);
	phno.sendKeys(data[6]);
	address.sendKeys(data[7]);
	close.click();
}



}
