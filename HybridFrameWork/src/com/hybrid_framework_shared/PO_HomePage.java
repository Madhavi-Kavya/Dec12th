package com.hybrid_framework_shared;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PO_HomePage {

	//R.driver.findElement(By.className("searchJob")).click();
	public @FindBy(className="searchJob") WebElement PO_mainSearchJob;

	public @FindBy(xpath="//*[@id='skill']/div[1]/div[2]/input") WebElement PO_searchJob ;
	public @FindBy(xpath="//*[@id='location']/div[1]/div[2]/input") WebElement PO_location;
	public @FindBy(xpath="//*[@id='exp_dd']/div[1]/input[1]") WebElement PO_experience;
	public @FindBy(xpath="//*[@id='salary_dd']/div[1]/input[1]") WebElement PO_salary;
	public @FindBy(xpath="//*[@id='qsbFormBtn']") WebElement PO_button;
	
}
 
//	R.driver.findElement(By.xpath("//*[@id='p0widget']/div/div[1]/div/input"))

////*[@id="skill"]/div[1]/div[2]/input
////*[@id="location"]/div[1]/div[2]/input
////*[@id="exp_dd"]/div[1]/input[1]
////*[@id="salary_dd"]/div[1]/input[1]
////*[@id="qsbFormBtn"]