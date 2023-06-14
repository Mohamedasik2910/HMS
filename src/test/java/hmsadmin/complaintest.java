package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;
import hms.pages.complainpage;
import hms.pages.frontofficepage;
import hms.utility.ReadExcel;

public class complaintest extends Testbase {
	Loginpage objlog;
	frontofficepage objfrnt;
	complainpage objcom;
	
	public complaintest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		objlog=new Loginpage();
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		
		objfrnt=new frontofficepage();
		objfrnt.hmsfrontoffice();
		
		objcom=new complainpage();
	}
	@DataProvider
	public Object[][] getcomplain()
	{
		Object[][]data=ReadExcel.getTestData("complaindata");
		return data;
		
	}
	
	@Test(dataProvider="getcomplain")
	public void getcomplainexceldetail(String com[])
	{
		
		objcom.clickcomplain();
		
		String Expectedscreentitle="Complain List";
		String Actualscreentitle=objcom.getscreentitle();
		
		Assert.assertEquals(Actualscreentitle, Expectedscreentitle);
		objcom.clickaddcomplain();
		
		String Expectedboxtitle="Add Complain";
		String Actualboxtitle=objcom.gettboxtitle();
	
		
		Assert.assertEquals(Actualboxtitle, Expectedboxtitle);
		
		
	
		objcom.getcomplaindetails(com);
		
	}

}
