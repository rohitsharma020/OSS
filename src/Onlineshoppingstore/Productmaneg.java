package Onlineshoppingstore;

import java.awt.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productmaneg {

	public Menu m=null;
    public Productmaneg(WebDriver driver){
    	m=PageFactory.initElements(driver, Menu.class);
    } 
    @FindBy(linkText="Product Management")
    WebElement productmanagementlink;
    
    @FindBy(linkText="Inventory Control")
    WebElement inventorycontrollink;
    
  public void pm(){
	  productmanagementlink.click();
   Sleeper.sleepTightInSeconds(5);
   inventorycontrollink.click();
  }
	
	
}
