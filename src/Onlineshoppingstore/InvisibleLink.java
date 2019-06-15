
package Onlineshoppingstore;

import java.io.File;
import java.io.FileInputStream;
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

public class InvisibleLink {
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
        int count=0;
        int a=0;
        for (int i = 1; i <linksCount; i++)
        {
        	if(links.get(a).isDisplayed()){
        	count=count+1;	
        	}
        }
        log.info("total no of links="+links.size());
        log.info("no of invisible links collected is=="+count);
        System.out.println("no of invisible Links="+count);
}
}