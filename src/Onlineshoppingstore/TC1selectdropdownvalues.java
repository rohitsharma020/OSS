package Onlineshoppingstore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class TC1selectdropdownvalues {
	
  FirefoxDriver driver;
  Dropdowns value;
  FileInputStream fso;
  FileOutputStream fo;
  XSSFWorkbook wbo;
  XSSFSheet wso;
  
  public void category1() throws IOException{
	  value=PageFactory.initElements(driver,Dropdowns.class);
       value.select();
	  fso=new FileInputStream("C:\\Users\\sai\\Downloads\\Dropdowns Expected.xlsx");
	  wbo=new XSSFWorkbook(fso);
	  wso=wbo.getSheet("Select Catagory");
	  Row r;
	  int rows=wso.getLastRowNum();
	 for(int i=1;i<rows;i++){
		 r=wso.getRow(i);
		 
		 
	 }
  }
	
	
	
	
	
	

}
