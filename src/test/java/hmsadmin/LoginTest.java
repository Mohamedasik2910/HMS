package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;

public class LoginTest extends Testbase {
	Loginpage obj;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		obj=new Loginpage();
	}
	
	@Test
	public void Loginhmstest()
	{
		String Expectedresult="Smart Hospital : Hospital Management System";
		String Actualresult=obj.getpagetitle();
		Assert.assertEquals(Actualresult, Expectedresult);
		
		Assert.assertTrue(obj.logodisplayed());
		
		String Expectedpagetitle="Admin Login";
		String Actualpagetitle=obj.getscreentitle();
		Assert.assertEquals(Actualpagetitle, Expectedpagetitle);
		
		obj.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		obj.logout();
	}
		
		@AfterMethod
		public void teardown()
		{
			driver.close();
		}
		

	}


