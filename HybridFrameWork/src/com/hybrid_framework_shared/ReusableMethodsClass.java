package com.hybrid_framework_shared;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethodsClass {
	
	//Declaring Global Variables
	public  WebDriver driver;
	public File f;
	public FileInputStream FIS;
	public WebDriverWait WW;
	public Workbook W;
	public Sheet S;
	
	
	//***************************************************************************
	//Method Name   : LaunchApplication
	//Description   : To Launch Application
	//Author        : Madhavi
	//DateOfCreation: July 8th 2019
	//VerifiedBy    : MySenior
	//*************************************************************************
 
	public void launchApplication(String url , String desFilePath) throws Exception
	{
		 driver = new FirefoxDriver();
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(f, new File(desFilePath));		 
	}
	//*************************************************************************
	//Method      : closeApplication
	//Description : Close Application
	//Author      : Madhavi
	//Date Created: July 8th 2019
	//Verified By : MySenior
	//***************************************************************************
	public void closeApplication()
	{
		System.out.println("Closing Application");
		driver.close();
	}
	//***************************************************************************
	public void elementPresent(WebElement element , boolean exepectedValue , String destFilePath) throws Exception
	{
		WW = new WebDriverWait(driver , 20);
		WW.until(ExpectedConditions.visibilityOf(element));
		
		boolean actualValue = element.isDisplayed();
		if(actualValue == exepectedValue)
		{
			System.out.println("Pass - Element Displayed");
			f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(destFilePath));
		}
		else
		{
			System.out.println("Fail - Element Not Displayed");
			f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(destFilePath));
		}		
	}
	//*******************************************************************************
	//Method       : excelConnection
	//Description  : Connecting to Excel
	//Author       : Madhavi
	//Date Created : July 8th 2019
	//Verified     : MySenior
	//********************************************************************************
	public void excelConnection(String inputFile , String sheetName) throws Exception
	{
		System.out.println("Inside Excel Conn");
		FIS = new FileInputStream(inputFile); 
		W = Workbook.getWorkbook(FIS);
		S = W.getSheet(sheetName);	
		
		System.out.println("Excel got Conn");

	}
	//*********************************************************************************
	//Method       : countLinks
	//Description  : Counting No Of links
	//Author       : Madhavi
	//Date Created : July 8th 2019
	//Verified By  : MySenior
	//***********************************************************************************
	public void countLinks(String Wlocator , int ExepectedLinks , String destFilePath) throws Exception
	{		
		List<WebElement> NoOfLinks = driver.findElements(By.tagName(Wlocator));
		
		System.out.println(NoOfLinks.size());
		if(NoOfLinks.size() == ExepectedLinks)
		{
			System.out.println("Pass -- Count Of Links Matches" + NoOfLinks.size());
			f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(destFilePath));
		}
		else
		{
			System.out.println("Fail -- Count of links Do not Match." + " Actual = " + NoOfLinks.size() + " Expected = " + ExepectedLinks);
			f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(destFilePath));
		}
	}
	//***********************************************************************
	//Method      : searchJob
	//Description : To enter the details and Click Search Button
	//Date Created: July 8th 2019
	//Author      : Madhavi
	//Verified By : MySenior
	//***************************************************************************
	public void searchJob(String destFilePath) throws Exception
	{
		System.out.println("In Search Job method");
		
		PO_HomePage POhome = PageFactory.initElements(driver, PO_HomePage.class);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Click on the Later Button of the Pop Up. So that it does not Block the Execution.
		//#geoLocPopUp
		driver.findElement(By.id("block")).click();
		System.out.println("Pop Up Dismissed");
		
		POhome.PO_mainSearchJob.click();

		POhome.PO_searchJob.sendKeys("Medical Billing");
		POhome.PO_location.sendKeys("Hyderabad");
		POhome.PO_experience.sendKeys("3");
		POhome.PO_salary.sendKeys("5");
		POhome.PO_button.click();
		f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(destFilePath));

	}
	//*************************************************************************
	//Method       : StartsWithN
	//Description  : To check if the Links Start with "N"
	//Author       : Madhavi
	//Date Created : 10th July 2019
	//Verified By  : MySenior
	//*************************************************************************
	public void startsWithN(String Wlocator)
	{
		List<WebElement> CountLink = driver.findElements(By.tagName(Wlocator));
		int i;
		for(i=0;i<CountLink.size();i++)
		{
			if(CountLink.get(i).getText().startsWith("N"))
				System.out.println(CountLink.get(i).getText() + "==" + CountLink.get(i).getAttribute("href"));
		}
		System.out.println("No Of Links Starting with N : " + i);		
	}
	//*************************************************************************
		//Method       : checkForBadLink
		//Description  : To check if the Links have 404/500 error
		//Author       : Madhavi
		//Date Created : 10th July 2019
		//Verified By  : MySenior
		//*************************************************************************
	public void checkForBadLink()
	{
		System.out.println("Still need to Check for Bad links");
	}
	
}




