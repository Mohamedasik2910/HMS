package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;
import hms.pages.pharmacypage;
import hms.utility.ReadExcel;

public class pharmacytest extends Testbase {

	Loginpage objlog;
	pharmacypage objphar;
	
	public pharmacytest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		objlog=new Loginpage();
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		
		objphar=new pharmacypage();
	}
	
	@DataProvider
	public Object[][] getpharexcel()
	{
		Object[][]data=ReadExcel.getTestData("pharmacy");
		return data;
		
	}
	
	@Test(dataProvider="getpharexcel")
	public void getphardetails(String phar[])
	{
		objphar.pharmacyonclick();
		
		String Expectedscreentitle="Pharmacy Bill";
		String Actualscreentitle=objphar.getscreentitle();
		Assert.assertEquals(Actualscreentitle, Expectedscreentitle);
		objphar.medicineclickon();
		
		String Expectedscreentitle1="Medicines";
		String Actualscreentitle1=objphar.getscreentitle1();
		Assert.assertEquals(Actualscreentitle1, Expectedscreentitle1);
		objphar.addmedicineclickon();
		
		String Expectedboxtitle="Add Medicine Details";
		String Actualboxtitle=objphar.getboxtitle();
		Assert.assertEquals(Actualboxtitle, Expectedboxtitle);
		objphar.getmedicinedetails(phar);
		
		
		
	}
}
