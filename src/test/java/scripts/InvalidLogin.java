package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.LoginPage;

public class InvalidLogin extends BaseTest
{
	
	@Test(priority = 2)
	public void testInvalidLogin()
	{
//		get the test data from excel sheet
		String un=Excel.getData("./data/input.xlsx","InvalidLogin",1,0);
		String pw=Excel.getData("./data/input.xlsx","InvalidLogin",1,1);
		
//		1. Enter invalid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		
//		2. Enter invalid pwd
		loginPage.setPassword(pw);
		
//		3. click on login button
		loginPage.clickLoginButton();
		
//		4. verify that err msg is displayed
		boolean result = loginPage.verifyErrMsgDispalyed(wait);
		Assert.assertEquals(result, true);
	}
}
