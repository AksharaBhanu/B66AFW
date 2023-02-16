package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.LoginPage;

public class InvalidLogin extends BaseTest
{
	
	@Test(priority = 2)
	public void testInvalidLogin()
	{
//		1. Enter invalid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName("abcd");
		
//		2. Enter invalid pwd
		loginPage.setPassword("xyz");
		
//		3. click on login button
		loginPage.clickLoginButton();
		
//		4. verify that err msg is displayed
		boolean result = loginPage.verifyErrMsgDispalyed(wait);
		Assert.assertEquals(result, true);
	}
}
