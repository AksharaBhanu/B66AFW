package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {

	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(id="loginButton")
	private WebElement loginBTN;
	
	@FindBy(xpath = "//span[contains(text(),'invalid')]")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void clickLoginButton()
	{
		loginBTN.click();
	}
	
	public boolean verifyErrMsgDispalyed(WebDriverWait wait)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("Err Msg is Displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("Err Msg is Not Displayed",true);
			return false;
		}
	}
}
