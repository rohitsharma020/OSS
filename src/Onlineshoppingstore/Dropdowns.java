package Onlineshoppingstore;

import java.awt.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dropdowns {
	public Menu m=null;
    public Dropdowns(WebDriver driver){
    	m=PageFactory.initElements(driver, Menu.class);
    } 
          @FindBy(id="category")
          WebElement selectcat;
 
    @FindBy(id="stock")
    WebElement selectstock;
    
    public void select(){
    	selectcat.click();;
    }
    public void stock(){
    	selectstock.click();
    	
    	
    }
 

}
