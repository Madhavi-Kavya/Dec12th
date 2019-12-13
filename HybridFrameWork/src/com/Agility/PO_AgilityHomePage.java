package com.Agility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PO_AgilityHomePage {
		
	public @FindBy(xpath="/html/body/app-root/app-login/div/div/div[2]/div/div/div[1]/form/div/div[1]/div/input") WebElement PO_userID; 

	public @FindBy(xpath="/html/body/app-root/app-login/div/div/div[2]/div/div/div[1]/form/div/div[3]/button/span") WebElement PO_submit;
	
	public @FindBy(xpath="/html/body/app-root/app-login/div/div/div[2]/div/div/div[1]/form/div/div[1]/div[2]/input") WebElement PO_password;

	public @FindBy(xpath="//*[@id='btnLogin']/span") WebElement PO_LoginButton;

}
 
//IE
//<span class="mat-button-wrapper">
//<input class="form-control ng-untouched ng-pristine ng-invalid" type="password" placeholder="Please Enter Password" _ngcontent-c2="" formControlName="Password" trim="blur" ng-reflect-trim="blur" ng-reflect-type="password" ng-reflect-name="Password" value=""/>
//<input class="form-control ng-invalid ng-dirty ng-touched" type="text" placeholder="Please Enter User Name" _ngcontent-c2="" formControlName="Username" trim="blur" ng-reflect-trim="blur" ng-reflect-type="text" ng-reflect-name="Username">
//<input class="form-control ng-untouched ng-pristine ng-invalid" type="text" placeholder="Please Enter User Name" _ngcontent-c2="" formControlName="Username" trim="blur" ng-reflect-trim="blur" ng-reflect-type="text" ng-reflect-name="Username"/>

//Chrome
////*[@id="btnLogin"]/span
///html/body/app-root/app-login/div/div/div[2]/div/div/div[1]/form/div/div[1]/div[2]/input
///html/body/app-root/app-login/div/div/div[2]/div/div/div[1]/form/div/div[1]/div/input
///html/body/app-root/app-login/div/div/div[2]/div/div/div[1]/form/div/div[3]/button/span

