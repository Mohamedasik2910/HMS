package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;
import hms.pages.postaldispatchpage;
import hms.pages.postalreceivepage;
import hms.utility.ReadExcel;

public class postaldispatchtest extends Testbase{
	Loginpage objlog;
	postalreceivepage objpos;
	postaldispatchpage objdis;
	
	public postaldispatchtest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		objlog=new Loginpage();
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		
		objpos=new postalreceivepage();
		objpos.frontofficeclick();
		
		objdis=new postaldispatchpage();
		 
	}
	
	@DataProvider
	public Object[][] getdispatchdetails()
	{
		Object[][]data=ReadExcel.getTestData("postalreceive");
		return data;
		
	}
	@Test(dataProvider="getdispatchdetails")
	public void getdispatchdetail(String disp[])
	{
		objpos.postalonclick();
		objdis.clickdispatch(); 
		
		String Expectedscreentitle="Postal Dispatch List";
		String Actualscreentitle=objdis.getscreentitle();
		
		Assert.assertEquals(Actualscreentitle, Expectedscreentitle);
		objdis.clickadddispatch();
		
		String Expectedboxtitle="Add Dispatch";
		String Actualboxtitle=objdis.getboxtitle();
		
		Assert.assertEquals(Actualboxtitle, Expectedboxtitle);
		objdis.getdispatchexcel(disp);
		
	}
	

}
