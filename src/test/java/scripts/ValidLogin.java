package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.ETTPage;
import pages.LoginPage;

public class ValidLogin extends BaseTest
{
	@Test(priority = 1)
	public void testValidLogin()
	{
		//Get the Test Data
		String un = Excel.getData("./data/input.xlsx", "ValidLogin",1,0);
		String pw = Excel.getData("./data/input.xlsx", "ValidLogin",1,1);
		
//		1. Enter valid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		
//		2. Enter valid pw
		loginPage.setPassword(pw);
		
//		3. click on login
		loginPage.clickLoginButton();
		
//		4. verify home page is displayed
		ETTPage ettPage=new ETTPage(driver);
		boolean result = ettPage.verifyHomePageIsDisplayed(wait);
		
		//true-HP P-Pass, false-HPNP-Fail
		Assert.assertEquals(result, true);
	}
}
