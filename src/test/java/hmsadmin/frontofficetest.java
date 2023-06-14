package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;
import hms.pages.frontofficepage;

public class frontofficetest extends Testbase {
Loginpage objlog;
frontofficepage objfront;


public frontofficetest()
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
}
@Test
public void hmsfrontoffice()
{
	objfront.hmsfrontoffice();
	
	String Expectedresult="Appointment Details";
	String actualresult=objfront.getboxtitle();
	Assert.assertEquals(actualresult, Expectedresult);
	objfront.hmsfrontofficevisitor();
	
}


}
