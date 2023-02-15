package scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;

public class TestCase1 extends BaseTest
{
	@Test
	public void testA()
	{
		Reporter.log(driver.getTitle(),true);
		String v=Excel.getData("./data/input.xlsx","TestCase1",1, 0);
		Reporter.log("XL:"+v,true);
		driver.switchTo().activeElement().sendKeys(v);
	}
}
