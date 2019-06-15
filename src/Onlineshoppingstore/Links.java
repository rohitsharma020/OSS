package Onlineshoppingstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Onlineshoppingstore.TestNGListeneres.class)
public class Links
{
	private static Logger log=Logger.getLogger(Links.class);
	@Test
	public void getLinks() throws IOException
	{
        WebDriver driver=new FirefoxDriver();
        log.info("browser open successfully");
        DOMConfigurator.configure("log4j.xml");
        driver.get("http://webwaves.in/ecommerce/index");
        log.info("URL open successfully");
        
        List<WebElement> links=driver.findElements(By.tagName("a"));
        log.info("Assigned all Link value in List");
        
        int linksCount=links.size();
        
        File src=new File("C:\\Users\\kallu\\Desktop\\LinkText.xlsx");
        FileInputStream f=new FileInputStream(src);
        log.info("Excel file ");
        
        XSSFWorkbook wbo=new XSSFWorkbook(f);
        XSSFSheet wso=wbo.getSheet("Sheet1");
       
        int a=0;
        for (int i = 1; i <linksCount; i++)
        {
			wso.createRow(i).createCell(1).setCellValue(links.get(a).getText());
			log.info("All Link text Collected Successfully");
			
			wso.getRow(i).createCell(2).setCellValue(links.get(a).getAttribute("href"));
			log.info("All link URL collected Successfully");
			a++;
			
			wso.getRow(1).createCell(0).setCellValue(linksCount);
			
			
			 FileOutputStream fout=new FileOutputStream(src);
		        wbo.write(fout);
		}
        
       
       
       
	}
}
	
	 
	 
	 
	 
	 