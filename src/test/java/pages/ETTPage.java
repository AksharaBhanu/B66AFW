package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ETTPage 
{
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public ETTPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHomePageIsDisplayed(WebDriverWait wait)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(logoutLink));
			Reporter.log("HomePage is displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("HomePage is NOT displayed",true);
			return false;
		}
	}
}
