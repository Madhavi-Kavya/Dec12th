package com.Agility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PO_RecurrenceButton {
	
	public @FindBy(xpath="//*[@id='mat-button-toggle-3']/label/div") WebElement recurrenceButton;
	
	public @FindBy(xpath="//*[@id='mat-button-toggle-5']/label/div/i") WebElement tableView;
	
	public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-header-row") WebElement tableViewHeaderRow;
	
	public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[1]/div[2]/div/span[1]") WebElement ColourScheduled;

	public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[1]/div[2]/div/span[3]") WebElement ColourReScheduled;
	
	public @FindBy(xpath="/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[1]/div[2]/div/span[5]") WebElement ColourCompleted;
	///html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[1]/div[2]/div/span[1]
}
