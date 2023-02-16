package generic;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest
{
	public WebDriver driver;
	public WebDriverWait wait;
	public final String dBrowser="chrome";
	public final String dURL="https://demo.actitime.com";
	public final String dTimeout="5";
	
	@Parameters({"browser","url","timeout"})
	@BeforeMethod
	public void openApp(@Optional(dBrowser) String browser,@Optional(dURL) String url,@Optional(dTimeout) String timeout)
	{
		Reporter.log("Open the browser:"+browser,true);
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		Reporter.log("Enter the URL:"+url,true);
		driver.get(url);
		
		Reporter.log("Maximize the browser",true);
		driver.manage().window().maximize();
		
		Reporter.log("Set the TimeOut:"+timeout,true);
		long intTimeout = Long.parseLong(timeout);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(intTimeout));
		wait=new WebDriverWait(driver, Duration.ofSeconds(intTimeout));
		
		
	}
	
	
	@AfterMethod
	public void closeApp()
	{
		Reporter.log("Close the browser",true);
		driver.quit();
	}
}
