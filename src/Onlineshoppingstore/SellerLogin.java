package Onlineshoppingstore;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SellerLogin {
	FirefoxDriver driver;
	 Sellerloginobj page1;
	 Productmaneg page2;
	@BeforeTest
	public void open(){
		driver=new FirefoxDriver();
		driver.get("http://webwaves.in/ecommerce/seller/");
	}
	@Test
	public void Slogin(){
		page1=PageFactory.initElements(driver,Sellerloginobj.class);
		page1.login("kalpanaQA@gmail.com", "12345");
		Sleeper.sleepTightInSeconds(5);
	}
	@Test(priority=1)
	public void click(){
		page2=PageFactory.initElements(driver, Productmaneg.class);
		page2.pm();
		Sleeper.sleepTightInSeconds(5);
	
		
	}
}






