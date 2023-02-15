package generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static String getData(String path,String sheet,int r,int c) 
	{
		String v="";
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
		}
		catch (Exception e) 
		{

		}
		
		return v;
	}
}
