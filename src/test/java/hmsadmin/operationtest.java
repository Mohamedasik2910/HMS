package hmsadmin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;
import hms.pages.operationpage;

public class operationtest extends Testbase {
	Loginpage objlog;
	operationpage objop;
	
public operationtest()
{
	super();
}
@BeforeMethod
public void setup()
{
	intialization();
	objlog=new Loginpage();
	objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	
	objop=new operationpage();
}

@Test
public void getpatientdetails() 
{
	objop.operationclickon();
	
	String Expectedscreentitle="Operation Theatre Patient";
	String Actualscreentitle=objop.getscreentitle();
	Assert.assertEquals(Actualscreentitle, Expectedscreentitle);
	objop.addpatientclickon();
	
	String Expectedboxtitle="Add Patient Details";
	String Actualboxtitle=objop.getboxtitle();
	Assert.assertEquals(Actualboxtitle, Expectedboxtitle);
	objop.gettpatientdetail();
	
}



}
