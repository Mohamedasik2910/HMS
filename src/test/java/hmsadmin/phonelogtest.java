package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;
import hms.pages.frontofficepage;
import hms.pages.phonecallpage;

public class phonelogtest extends Testbase {
	Loginpage objlog;
	frontofficepage objfront;
	phonecallpage objphone;
	
	public phonelogtest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		intialization();
		objlog=new Loginpage();
		objfront=new frontofficepage();
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		
		objfront.getboxtitle();
		objfront.hmsfrontoffice();
		
		objphone=new phonecallpage();
		objphone.clickonphonecall();
	}
	@Test
	public void getphonelog()
	{
		String Expectedscreenresult="Phone Call Log List";
		String Actualscreenresult=objphone.screentitle();
		
		Assert.assertEquals(Actualscreenresult, Expectedscreenresult);
		objphone.clickonaddcall();
		
		String Expectedboxtitle="Add Call Log";
		String Actualboxtitle=objphone.boxtitl();
		Assert.assertEquals(Actualboxtitle, Expectedboxtitle);
		
		objphone.addphoneloggdetails();
		
		
	}
	
	

}
