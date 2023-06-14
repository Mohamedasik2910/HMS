package hms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;

public class frontofficepage extends Testbase {
	@FindBy(css="ul.sidebar-menu>li")WebElement frontoffice;
	@FindBy(css="h3.box-title")WebElement boxtitle;
	@FindBy(css="a[href='http://triotend.com/tts/admin/visitors']")WebElement Visitor;
	public frontofficepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getboxtitle()
	{
		return boxtitle.getText();
		
	}
	
	public void hmsfrontoffice()
	{
		frontoffice.click();
		
	}
	public void hmsfrontofficevisitor()
	{
		Visitor.click();
	}
	
	
	
	

}
