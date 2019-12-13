package AgilityTestNGpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestNgPO_AMonitorAndMeasure { 
	
	public @FindBy(xpath ="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[2]/div[1]/div/div[1]/div/span") WebElement countScheduled;

	public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[2]/div[1]/div/div[2]/a") WebElement buttonScheduled;
	
	public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[2]/div[2]/div/div[1]/div/span") WebElement countReScheduled;

	public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[2]/div[2]/div/div[2]/a") WebElement buttonReSchedule;

	public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[2]/div[3]/div/div[1]/div/span") WebElement countCompleted;

	public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[2]/div[3]/div/div[2]/a") WebElement buttonCompleted;
	
	public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/app-mainfilter/div/div/div/div[3]/select") WebElement selectYear;
	
	public @FindBy(xpath="//*[@id='mat-input-2']") WebElement CurrentDateInStartCalender;
	
	
	//Data Picker POM
	public @FindBy(xpath=("//*[@id='mat-input-2']")) WebElement startCalendar;
	
	public @FindBy(xpath=("//*[@id='mat-input-3']")) WebElement endCalendar;
	
	public @FindBy(xpath="//*[@id='mat-datepicker-2']/div[1]/div/button[2]") WebElement startCalBackArrow;
	
	public @FindBy(xpath="//*[@id='mat-datepicker-2']/div[1]/div/button[3]") WebElement startCalFrontArrow;
			            
	public @FindBy(xpath="//*[@id='mat-datepicker-3']/div[1]/div/button[2]") WebElement endCalBackArrow;

	public @FindBy(xpath="//*[@id='mat-datepicker-3']/div[1]/div/button[3]") WebElement endCalFrontArrow;
	
}
