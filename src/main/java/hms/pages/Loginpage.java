package hms.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;

public class Loginpage extends Testbase {
	@FindBy(css="img[src='http://triotend.com/tts/backend/images/s_logo.png']")WebElement logo;
	@FindBy(css="h3.font-white")WebElement logotitle;
	@FindBy(css="input#email")WebElement username;
	@FindBy(css="input#password")WebElement password;
	@FindBy(css="button.btn")WebElement singin;
	@FindBy(css="img[src='http://triotend.com/tts/uploads/staff_images/no_image.png']")WebElement icon;
	@FindBy(css="a[href='http://triotend.com/tts/site/logout']")WebElement logout;
public Loginpage()
{
	PageFactory.initElements(driver, this);
}

public String getpagetitle()
{
	return driver.getTitle();
	
}
public boolean logodisplayed()
{
	return logo.isDisplayed();
	
}

public String getscreentitle()
{
	return logotitle.getText();
	
}

public void loginhms(String uname, String pwd)
{
	username.sendKeys(uname);
	password.sendKeys(pwd);
	singin.click();
}
	
	public void logout()
	{
		icon.click();
		logout.click();
		
	}
	
	
}





