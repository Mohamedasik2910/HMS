package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;
import hms.pages.addvisitorpage;
import hms.pages.frontofficepage;
import hms.utility.ReadExcel;

public class addvisitortest extends Testbase  {
	Loginpage objlog;
	frontofficepage objfronpage;
	addvisitorpage objvisitor;
	
	public addvisitortest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		objlog=new Loginpage();
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		
		
		objfronpage=new frontofficepage();
		objvisitor=new addvisitorpage();
		
		objfronpage.getboxtitle();
		objfronpage.hmsfrontoffice();
		objfronpage.hmsfrontofficevisitor();
		objvisitor=new addvisitorpage();
	}
	@DataProvider
	public Object[][] getvistordata()
	{
		Object[][]data=ReadExcel.getTestData("testdata");
		return data;
		
	}
	@Test(dataProvider="getvistordata")
	public void hmsaddvisitor(String Vis[])
	{
		String Expectedtitle="Visitor List";
		String Actualtitle=objvisitor.getvisitortitle();
	
		Assert.assertEquals(Actualtitle, Expectedtitle);
		
		objvisitor.clickaddvisitor();
		
		String Expectedscreentitle="Add Visitor";
	    String Actualscreentitle=objvisitor.getaddvisitortitle();
		
		Assert.assertEquals(Actualscreentitle, Expectedscreentitle);
		
		objvisitor.addvistordetails();
		objvisitor.closescreens();
		//objvisitor.addvistorexcel(Vis);
		
		}
		
		
		
		 
		
	}
	


