package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	public final String gURL="https://demo.actitime.com";
	public final String dTimeout="5";
	
	@Parameters({"browser","url","gridurl","timeout"})
	@BeforeMethod
	public void openApp(@Optional(dBrowser) String browser,@Optional(dURL) String url,@Optional(gURL) String gridurl, @Optional(dTimeout) String timeout) throws MalformedURLException
	{
		URL remote=new URL(gridurl);
		Reporter.log("Open the browser:"+browser,true);
		if(browser.equalsIgnoreCase("chrome"))
		{
//			driver=new ChromeDriver();
			
			driver=new RemoteWebDriver(remote,new ChromeOptions());
		}
		else
		{
//			driver=new FirefoxDriver();
			driver=new RemoteWebDriver(remote,new FirefoxOptions());
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
