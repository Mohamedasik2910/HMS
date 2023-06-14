package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;
import hms.pages.financeincomepage;
import hms.pages.frontofficepage;
import hms.utility.ReadExcel;

public class financeincometest extends Testbase {
	Loginpage objlog;
	frontofficepage objfront;
	financeincomepage objfin;
	
	public financeincometest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		objlog=new Loginpage();
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		
		objfront=new frontofficepage();
		objfront.getboxtitle();
		
		objfin=new financeincomepage();
		
	}
	@DataProvider
	public Object[][] getincomedetails()
	{
		Object[][]data=ReadExcel.getTestData("incomedata");
		return data;
	}
	
	@Test(dataProvider="getincomedetails")
	public void financeincomedetail(String inc[])
	{
		objfin.clickfinanceincome();
		objfin.clickincome();
		
		String Expectedscreentitle="Income List";
		String Actualscreentitle=objfin.getscreentitle();
		Assert.assertEquals(Actualscreentitle, Expectedscreentitle);
		
		objfin.clickonaddincome();
		
		String Expectedboxtitle="Add Income";
		String Actualboxtitle=objfin.getboxtitle();
		Assert.assertEquals(Actualboxtitle, Expectedboxtitle);
		
		//objfin.getincomedetails();
		objfin.getincomedetailsexcel(inc);
		
		
	}
	

}
