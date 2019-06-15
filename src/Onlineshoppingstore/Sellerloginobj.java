package Onlineshoppingstore;

import java.awt.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sellerloginobj {
	public Menu m=null;
    public Sellerloginobj(WebDriver driver){
    	m=PageFactory.initElements(driver, Menu.class);
    } 
    @FindBy(name="username")
    WebElement UserTextbox;
    
    @FindBy(name="password")
    WebElement Password;
    
    @FindBy(xpath="//*[@id='login-box-inner']/form/div[3]/div/button")
    WebElement Login;
    
    public void login(String u,String p){
    	UserTextbox.clear();
    	UserTextbox.sendKeys(u);
    	Password.clear();
    	Password.sendKeys(p);
    	Login.click(); 
    	

    }
}

