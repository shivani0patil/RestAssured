package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
	public String getDataExcel(String shetname,int rownum, int celnum) throws Throwable, IOException
	{
	 FileInputStream fss=new FileInputStream("./src/test/resources/Book5.xlsx");
     Workbook wh=WorkbookFactory.create(fss);
     String data=wh.getSheet(shetname).getRow(rownum).getCell(celnum).toString();
      wh.close();
      return data;
      
	}
	
	public int getRowNum(String shetname) throws Throwable, IOException
	{
	 FileInputStream fss=new FileInputStream("./src/test/resources/Book5.xlsx");
     Workbook wh=WorkbookFactory.create(fss);
     int data=wh.getSheet(shetname).getLastRowNum();
      wh.close();
      return data;
      
	}
	public void getDataWriteExcel(String shetname,int rownum, int celnum) throws Throwable, IOException
	{
	 FileInputStream fss=new FileInputStream("./src/test/resources/Book5.xlsx");
     Workbook wh=WorkbookFactory.create(fss);
     wh.getSheet(shetname).getRow(rownum).createCell(celnum);
     
     FileOutputStream out=new FileOutputStream("./src/test/resources/Book5.xlsx");
     wh.write(out);
      wh.close();
      
      
	}

	
	
}
