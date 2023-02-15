package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.ETTPage;
import pages.LoginPage;

public class ValidLogin extends BaseTest
{
	@Test(priority = 1)
	public void testValidLogin()
	{
//		1. Enter valid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName("admin");
//		2. Enter valid pw
		loginPage.setPassword("manager");
//		3. click on login
		loginPage.clickLoginButton();
//		4. verify home page is displayed
		ETTPage ettPage=new ETTPage(driver);
		boolean result = ettPage.verifyHomePageIsDisplayed(wait);
		//true-HP P-Pass, false-HPNP-Fail
		Assert.assertEquals(result, true);
	}
}
