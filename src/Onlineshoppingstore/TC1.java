package Onlineshoppingstore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Onlineshoppingstore.TestNGListeneres.class)
public class TC1 {
	private static Logger log=Logger.getLogger(TC1.class);
	FirefoxDriver driver;
	 Sellerloginobj page1;
	 Productmaneg page2;
	 Dropdowns page3;
	  FileInputStream fso;
	  FileOutputStream fo;
	  XSSFWorkbook wbo;
	  XSSFSheet wso;
	 
	@BeforeTest
	public void open(){
		DOMConfigurator.configure("log4j.xml");
		driver=new FirefoxDriver();
		log.info("successfully browser opened");
		driver.get("http://webwaves.in/ecommerce/seller/");
		log.info("successfully page navigated");
	}
	@Test
	public void Slogin(){
		page1=PageFactory.initElements(driver,Sellerloginobj.class);
		page1.login("kalpanaQA@gmail.com", "12345");
		log.info("successfully login with inserted details");
		Sleeper.sleepTightInSeconds(5);
	}
	@Test(priority=1)
	public void click(){
		page2=PageFactory.initElements(driver, Productmaneg.class);
		page2.pm();
		log.info("successfully link clicked");
		Sleeper.sleepTightInSeconds(5);
	
	}
	@Test(priority=2)
	public void selectvalue() throws IOException{
		 page3=PageFactory.initElements(driver,Dropdowns.class);
	       page3.select();
	       Sleeper.sleepTightInSeconds(5);
	       fso=new FileInputStream("C:\\Users\\sai\\Downloads\\Dropdowns Expected (2).xlsx");
	 	  wbo=new XSSFWorkbook(fso);
	 	  wso=wbo.getSheet("Select Catagory");
	 	  	 	  Row r;	
	 	  	 	  
	      WebElement selectcategory=page3.selectcat.findElement(By.id("category"));
	      log.info("successfully select category dropdown clicked" );
 	List<WebElement>value=selectcategory.findElements(By.tagName("option"));
	 	for(int v=0;v<value.size();v++){
			r=wso.getRow(v+1);
			try{
			String expected=r.getCell(0).getStringCellValue();
			log.info("sucessfully get the expected values");
	 	String actual=value.get(v).getText();
	 	r.createCell(1).setCellValue(actual);
	 	log.info("successfully actual dropdown values are inserted");
		
	 	if(expected.equals(actual)){
	 		r.createCell(2).setCellValue("pass");
	}	
	 	else{
	 		r.createCell(2).setCellValue("fail"); 	
	     	}
		}catch(Exception e){
			System.out.println(e);
		}
 	
		fo=new FileOutputStream("C:\\Users\\sai\\Downloads\\Dropdowns Expected (2).xlsx");
	 	wbo.write(fo);	
	}
}
	@Test(priority=3)
	public void selectstock() throws IOException{
		 page3=PageFactory.initElements(driver,Dropdowns.class);
	       page3.select();
	       fso=new FileInputStream("C:\\Users\\sai\\Downloads\\Dropdowns Expected (2).xlsx");
	 	  wbo=new XSSFWorkbook(fso);
	 	  wso=wbo.getSheet("Stock");
	 	  Row r;
	 	  
  
	 	    WebElement selectstockvalue=page3.selectstock.findElement(By.id("stock"));
		 	log.info("successfully select stock dropdown clicked");
    
	List<WebElement>value=selectstockvalue.findElements(By.tagName("option"));
	 	for(int i=0;i<value.size();i++){
			r=wso.getRow(i+1);
			try{
			 	String expected=r.getCell(0).getStringCellValue();
			 	log.info("successfully get the expected values");

	 	String actual=value.get(i).getText();
	 	r.createCell(1).setCellValue(actual);
	 	log.info("successfully actual dropdown values are inserted");

	 	if(expected.equals(actual)){
	 		r.createCell(2).setCellValue("pass");
	}	
	 	else{
	 		r.createCell(2).setCellValue("fail"); 	
	 		
	 	}
			}catch(Exception e){
				System.out.println(e);
			} 	    
	 	fo=new FileOutputStream("C:\\Users\\sai\\Downloads\\Dropdowns Expected (2).xlsx");
	 	wbo.write(fo);	
	 	log.info("successfully saved all values in excel");

	}
	}
                  
}
	
		
	
	
	

	





