package Onlineshoppingstore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC1user {
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		driver=new FirefoxDriver();
		driver.get("http://webwaves.in/ecommerce/");
	}
	@Test
	public void data(){
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println("no of links"+"   "+links.size());
	
		int count=0;
		for(int i=0;i<links.size();i++){
		if(links.get(i).isDisplayed()){
			String name=links.get(i).getText();
			Sleeper.sleepTightInSeconds(3);
			links.get(i).click();
			Sleeper.sleepTightInSeconds(5);
     	String url=driver.getCurrentUrl();
	
		System.out.println(name+"   "+url);
			count++;		
		}
		driver.navigate().back();
		links=driver.findElements(By.tagName("a"));
	}
		
	}

}
