package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import hms.base.Testbase;
import hms.pages.Loginpage;
import hms.pages.bloodpage;
import hms.utility.ReadExcel;

public class bloodtest extends Testbase {
	
	Loginpage objlp;
	bloodpage objbl;
	
public bloodtest()
{
	super();
}


@BeforeMethod
public void setup()
{
	intialization();
	objlp=new Loginpage();
	objbl=new bloodpage();
	objlp.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
}
@DataProvider
public Object[][] getblooddetail()
{
	Object[][]data=ReadExcel.getTestData("blooddetails");
	return data;
}

@Test(dataProvider="getblooddetail")
public void getbloodexcel(String bld[])
{
	objbl.clickonblood();
	String Expectedscreentitle="Blood Bank Status";
	String Actualscreentitle=objbl.getscreentitle();
	Assert.assertEquals(Actualscreentitle, Expectedscreentitle);
	objbl.clickondonor();
	
	String Expectedboxtitle="Donor Details";
	String Actualboxtitle=objbl.getboxtitle();
	Assert.assertEquals(Actualboxtitle, Expectedboxtitle);
	
	objbl.clickonaddblood();
	
	String Expectedboxtitle2="Add Donor Details";
	String Actualboxtitle2=objbl.getboxtitle2();
	Assert.assertEquals(Actualboxtitle2, Expectedboxtitle2);
	objbl.getblooddetailsexcel(bld);
	
	
}



}
