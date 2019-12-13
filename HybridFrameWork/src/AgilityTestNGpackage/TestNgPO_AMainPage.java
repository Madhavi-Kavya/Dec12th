package AgilityTestNGpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class TestNgPO_AMainPage {	
	
		public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-dashboard/app-mainfilter/div/div/div/div[1]/select") WebElement country;
		public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-dashboard/app-mainfilter/div/div/div/div[2]/select") WebElement testbranch;
		public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-dashboard/app-mainfilter/div/div/div/div[3]/select") WebElement selectyear;
		public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-dashboard/div/div[2]/div[1]/div[2]/div[2]/div[2]/div") WebElement monitorANDmeasure;
	}