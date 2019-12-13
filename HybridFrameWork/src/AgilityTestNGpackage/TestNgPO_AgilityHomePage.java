package AgilityTestNGpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestNgPO_AgilityHomePage { 
  
	public @FindBy(xpath="/html/body/app-root/app-login/div/div/div[2]/div/div/div[1]/form/div/div[1]/div/input") WebElement PO_userID; 

	public @FindBy(xpath="/html/body/app-root/app-login/div/div/div[2]/div/div/div[1]/form/div/div[3]/button/span") WebElement PO_submit;
	
	public @FindBy(xpath="/html/body/app-root/app-login/div/div/div[2]/div/div/div[1]/form/div/div[1]/div[2]/input") WebElement PO_password;

	public @FindBy(xpath="//*[@id='btnLogin']/span") WebElement PO_LoginButton;

}
