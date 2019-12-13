package com.Agility;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.awt.Robot;

public class A_ReusableMethodsONE {
	
	PO_RecurrenceButton POrecurrenceButton;
	public void checkingColours()
	{ 
		String col;
		col = POrecurrenceButton.ColourScheduled.getCssValue("background-color").trim();
		System.out.println("Colour Of Label Scheduled : " + col);
		col = POrecurrenceButton.ColourReScheduled.getCssValue("background-color");
		System.out.println("Colour Of Label ReScheduled : " + col);
		col = POrecurrenceButton.ColourCompleted.getCssValue("background-color");
		System.out.println("Colour Of Label Completed : " + col);		
	}
	
	public void recurrenceButtonCheck() throws AWTException
	{
		A_ReusableMethods.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		POrecurrenceButton = PageFactory.initElements(A_ReusableMethods.driver , PO_RecurrenceButton.class);
		
		JavascriptExecutor execute1 = (JavascriptExecutor) A_ReusableMethods.driver;
		execute1.executeScript("arguments[0].click();" ,POrecurrenceButton.recurrenceButton );
		
		A_ReusableMethods.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor execute2 = (JavascriptExecutor) A_ReusableMethods.driver;
		execute2.executeScript("arguments[0].click();" ,POrecurrenceButton.tableView );
		
		A_ReusableMethods.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		List<WebElement> countTableViewRows = POrecurrenceButton.tableViewHeaderRow.findElements(By.xpath("//*[@class='mat-row']"));
		///html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[1]/mat-cell[5]
	
		System.out.println("No OF Rows In the Table : " + countTableViewRows.size());
		
		int i=0;
		String name;
		for( i=1 ; i<= countTableViewRows.size() ; i++)
		{			
			name= A_ReusableMethods.driver.findElement(By.xpath("/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[" + i + "]/mat-cell[5]")).getText();
			                                                   ///html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[10]/mat-cell[10]/span[1]
			String RecurrenceScheduled = A_ReusableMethods.driver.findElement(By.xpath("/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[" + i + "]/mat-cell[10]/span[1]")).getAttribute("innerHTML");
			String RecurrenceReScheduled = A_ReusableMethods.driver.findElement(By.xpath("/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[" + i + "]/mat-cell[10]/span[2]")).getAttribute("innerHTML");
			String RecurrenceCompleted = A_ReusableMethods.driver.findElement(By.xpath("/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[" + i + "]/mat-cell[10]/span[2]")).getAttribute("innerHTML");
			System.out.println("--------------------------------------");	
			System.out.println(name);

			System.out.print("  Scheduled : " + RecurrenceScheduled);
			System.out.print("  ReScheduled : " +RecurrenceReScheduled);
			System.out.println("  Completed : " +RecurrenceCompleted);		
		}		
	}
}

/*JavascriptExecutor execute3 = (JavascriptExecutor) A_ReusableMethods.driver;
execute3.executeScript("window.scrollTo(0, document.body.scrollHeight)");*/


//	A_ReusableMethods.driver.findElement(By.xpath("//*[@id='cdk-overlay-2']")).click();
