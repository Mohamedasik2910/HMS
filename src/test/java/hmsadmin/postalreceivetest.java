package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;
import hms.pages.postalreceivepage;
import hms.utility.ReadExcel;

public class postalreceivetest extends Testbase {
	Loginpage objlog;
	postalreceivepage objpos;
	
public postalreceivetest()
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
}

@DataProvider
public Object[][] getreceivedetails()
{
	Object[][]data=ReadExcel.getTestData("postalreceive");
	return data;
	
}

@Test(dataProvider="getreceivedetails")
public void getreceivedetail(String rec[])
{
	objpos.frontofficeclick();
	objpos.postalonclick();
	objpos.clickonrecive();
	
	
	String Expectedscreentitle="Postal Receive List";
	String Actualscreentitle=objpos.getscreentitle();
	
	Assert.assertEquals(Actualscreentitle, Expectedscreentitle);
	
	objpos.clickaddrecive();
	
	String Expectedboxtitle="Add Receive";
	String Actualboxtitle=objpos.getboxtitle();
	
	Assert.assertEquals(Actualboxtitle, Expectedboxtitle);
	System.out.println("Hai");
	objpos.getreceivedexcel(rec);
	
	
	
}
	

}
