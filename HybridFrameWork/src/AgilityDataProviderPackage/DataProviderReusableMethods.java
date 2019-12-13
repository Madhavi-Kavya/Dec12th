package AgilityDataProviderPackage;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AgilityTestNGpackage.TestNgPO_AMainPage;
import AgilityTestNGpackage.TestNgPO_AMonitorAndMeasure;
import AgilityTestNGpackage.TestNgPO_AgilityHomePage;
import AgilityTestNGpackage.TestNgPO_RecurrenceButton;

public class DataProviderReusableMethods {
  
	public static WebDriver driver;
	File f;
	FileInputStream FIS;
	Workbook W;
	public Sheet S;
	WebDriverWait WW;
	Actions A;
	TestNgPO_AMainPage POAmainpage;
	TestNgPO_AMonitorAndMeasure POAmonitorMeasure;
	TestNgPO_RecurrenceButton POrecurrenceButton;
	
///////////////////////////////////////////////////////////////////////////////////
	@BeforeClass
	public void f()
	{
		System.out.println("Program Started");
	}
	
	////////////////////////////////////////////////////////////////////////////////////////// 
	// @Parameters({"excelFileName"})  
	 @Test(priority=1 , dataProvider = "getDataFromExcel1" , dataProviderClass = DataProviderFromExcel.class) 
     public void excelConnection(String excelFileName) throws Exception
		{
			FIS = new FileInputStream(excelFileName);
			W = Workbook.getWorkbook(FIS);
			S = W.getSheet("Sheet1");		
		}
  
 ////////////////////////////////////////////////////////////////////////////////////////////
	// @Parameters({"url"})
	 @Test (priority =1 , dataProvider = "getDataFromExcel2" , dataProviderClass = DataProviderFromExcel.class) 
     public void launchApplicationChrome(String url) throws Exception
	{
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Jar Dependencies\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Chrome Website Launched");			
	}

	 ///////////////////////////////////////////////////////////////////////////////////////////////
	// @Parameters({"userid" , "password" })
	 @Test (priority=2 , dataProvider = "getDataFromExcel3" , dataProviderClass = DataProviderFromExcel.class)
	 public void enterLoginDetails(String userid , String password) throws Exception
		{
		 TestNgPO_AgilityHomePage POAhomepage = PageFactory.initElements(driver, TestNgPO_AgilityHomePage.class);
			
			System.out.println("Entering Userid");
			POAhomepage.PO_userID.sendKeys(userid);
			System.out.println("Entered");
			
			f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File ("C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Result\\A_UserNameEntered.png"));
						
			POAhomepage.PO_submit.click();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			if(POAhomepage.PO_password.isDisplayed() == true)
			{
				POAhomepage.PO_password.sendKeys(password);			

				f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(f, new File ("C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Result\\A_passwordEntered.png"));
				POAhomepage.PO_LoginButton.click();
				
				System.out.println("Succesfully Entered Username and Password. Now you are in the Next Page.");
				
			}
			else
				System.out.println("Password Not Available");	
		}
	 
///////////////////////////////////////////////////////////////////////////////////////////////////		
	// @Parameters({"expectedCount"})
	 @Test (priority =3 ,dataProvider = "getDataFromExcel4" , dataProviderClass = DataProviderFromExcel.class)
	 public void checkCountInDropDownBox(int expectedCount)
		{
			int actualCount=0;
			TestNgPO_AMainPage POAmainpage = PageFactory.initElements(driver, TestNgPO_AMainPage.class);
			
			Select dropCountry = new Select(POAmainpage.country);
			List<WebElement> CountOfCountries = dropCountry.getOptions();
			
			actualCount=CountOfCountries.size();
			System.out.println("Print : " + actualCount);
			
			if(actualCount == expectedCount)
			{
				System.out.println("PASS- No of Expected Countries 18 Match.");
				Select dropBranch = new Select(POAmainpage.testbranch);
				List<WebElement> CountOfTestBranches = dropBranch.getOptions();
				System.out.println("Test Branches In :"+ dropCountry.getFirstSelectedOption().getText() + "  :  " + CountOfTestBranches.size());
			}			
			else
				System.out.println("FAIL- No of Expected Countries 18 DO NOT Match");		
		}
	 
//////////////////////////////////////////////////////////////////////////////////////////////////
	// @Parameters({"testFilePath"})
	 @Test (priority=4 ,dataProvider = "getDataFromExcel5" , dataProviderClass = DataProviderFromExcel.class)
	 public void selectDropDownBox(String testFilePath) throws Exception
		{
		
			POAmainpage = PageFactory.initElements(driver, TestNgPO_AMainPage.class);
			
			System.out.println("Sending info into Dropdown box");
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
			POAmainpage.country.sendKeys("India");
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			POAmainpage.testbranch.sendKeys("Agility Test Branch");
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			POAmainpage.selectyear.sendKeys("2019");
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("selected filter");
			
			WW = new WebDriverWait(driver, 20);
			WW.until(ExpectedConditions.elementToBeClickable(POAmainpage.monitorANDmeasure));
			
			f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(testFilePath));
			
			POAmainpage.monitorANDmeasure.click();
			System.out.println("Entered Monitoring And Measuring");	
			
		}
	 
///////////////////////////////////////////////////////////////////////////////////////////////////
	 @Test(priority=6)
	 public void checkMonitorAndMeasure()
		{
			
			POAmonitorMeasure = PageFactory.initElements(driver, TestNgPO_AMonitorAndMeasure.class);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			A = new Actions(driver);
			A.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			System.out.println("No oF Scheduled " + POAmonitorMeasure.countScheduled.getAttribute("innerHTML"));
			System.out.println("No oF ReScheduled " + POAmonitorMeasure.countReScheduled.getAttribute("innerHTML"));
			System.out.println("No oF Completed " + POAmonitorMeasure.countCompleted.getAttribute("innerHTML"));

			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			A.moveToElement(POAmonitorMeasure.buttonReSchedule).perform();
			A.click(POAmonitorMeasure.buttonReSchedule).build().perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", POAmonitorMeasure.buttonReSchedule);

			System.out.println("ReScheduled Button Clicked");				
		}
	 
///////////////////////////////////////////////////////////////////////////////////////////////////
	// @Parameters({"SDate" , "EDate"})
	 @Test(priority =5 ,dataProvider = "getDataFromExcel6" , dataProviderClass = DataProviderFromExcel.class)
	 public void selectDatePicker(String SDate, String EDate) throws NoSuchElementException, InterruptedException
		{
			int NoOfMonths =0;
			int i=0;
			
			A = new Actions(driver);
			A.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).build().perform();
			
			System.out.println("Page Up");
			System.out.println("Entered Date Picker:");		

			POAmonitorMeasure = PageFactory.initElements(driver, TestNgPO_AMonitorAndMeasure.class);
			System.out.println("POM done:");
			
			POAmonitorMeasure.startCalendar.click();
			System.out.println("From Calender clicked");

			String startDate = SDate;
			String startCal[] = startDate.split("/");
			System.out.println("Start Month : " + startCal[1]);
			System.out.println("Start Year : " + startCal[2]);

					
			String endDate = EDate;
			String endCal[] = endDate.split("/");
			System.out.println("End Month : " + endCal[1]);
			System.out.println("End Year : " + endCal[2]);
			
			if((startCal[2]).equalsIgnoreCase(endCal[2]))
			{	
				 NoOfMonths = Integer.valueOf(endCal[1])-Integer.valueOf(startCal[1]) ;
				 System.out.println("Difference - No of Months : " + NoOfMonths );		
			}	
			
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			String date1= dateFormat.format(date);  // Now format the date

			System.out.println("Current date and time is " + date1);		
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			A.moveToElement(POAmonitorMeasure.startCalendar);
			A.click(POAmonitorMeasure.startCalendar);
			System.out.println("From Calender clicked");
			
			System.out.println("Current date and time From Start Calender " + POAmonitorMeasure.CurrentDateInStartCalender.getAttribute("max"));
			String todayDate1 = POAmonitorMeasure.CurrentDateInStartCalender.getAttribute("max");
			SimpleDateFormat todayDate2 = new SimpleDateFormat("MM/DD/YYYY");
			todayDate1 = todayDate2.format(date);
			System.out.println("Only Today Date " + todayDate1);

			String[] todayMOn = todayDate1.split("/");
			System.out.println("Only Today Month " + todayMOn[0]);
			
			A.moveToElement(POAmonitorMeasure.startCalBackArrow);
			System.out.println("Moved to statr calender Bck arrow");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			int count = Integer.valueOf(todayMOn[0]);
			--count;
				
			for(int k= count ; k >Integer.valueOf(startCal[1]) ; --k )
			{
			A.moveToElement(POAmonitorMeasure.startCalBackArrow);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			POAmonitorMeasure.startCalBackArrow.click();
			System.out.println("Back Arrow From Start Calender Icon Clicked >.");
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			
			System.out.println("Before Start Calender Switch");
			switch(Integer.valueOf(startCal[1]))
			{
			case 1 :
				driver.findElement(By.xpath("//*[@id='mat-datepicker-2']/div[2]/mat-month-view/table/tbody/tr[2]/td[2]/div")).click();
				System.out.println("Switch January");
				break;
				
			case 2 :
				driver.findElement(By.xpath("//*[@id='mat-datepicker-2']/div[2]/mat-month-view/table/tbody/tr[1]/td[2]/div")).click();
				System.out.println("Switch Febuary");
				break;
				
			case 3:
				driver.findElement(By.xpath("//*[@id='mat-datepicker-2']/div[2]/mat-month-view/table/tbody/tr[1]/td[2]/div")).click();
				System.out.println("Switch March");
				break;
				
			case 4:
				driver.findElement(By.xpath("//*[@id='mat-datepicker-2']/div[2]/mat-month-view/table/tbody/tr[2]/td[2]/div")).click();
				System.out.println("Switch April");
				break;
				
			case 5 :
				driver.findElement(By.xpath("//*[@id='mat-datepicker-2']/div[2]/mat-month-view/table/tbody/tr[1]/td[2]/div")).click();
				System.out.println("Switch May");
				break;

			default:
				System.out.println("Default  Switch");
						
			}
			System.out.println("Out Of Start Calender First Switch");
		
			
	//***********************************************************************	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Wait for 40 Sec");
		
		count = Integer.valueOf(todayMOn[0]);
		System.out.println("MOnth in Second Count " + count);
		
		WebDriverWait WW = new WebDriverWait(driver, 20);
		WW.until(ExpectedConditions.elementToBeClickable(POAmonitorMeasure.endCalendar));
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		A.moveToElement(POAmonitorMeasure.endCalendar);
		A.click(POAmonitorMeasure.endCalendar);
		
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", POAmonitorMeasure.endCalendar);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//*[@id='cdk-overlay-1']")).isDisplayed() ==true)
		System.out.println("/////////////////////////////////////////////////");	
		
		System.out.println("Clicked On End Calender");

		System.out.println("Second While == Month to be selected : " + Integer.valueOf(endCal[1]));	
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Wait for 20 Sec Till End Calender Opens");


		while(count >= Integer.valueOf(endCal[1]))
		{
			System.out.println("Inside While");

			A.moveToElement(POAmonitorMeasure.endCalBackArrow);
			System.out.println("Moved to back arrow");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", POAmonitorMeasure.endCalBackArrow);

			//POAmonitorMeasure.endCalBackArrow.click();
			System.out.println("Back Arrow From End Calender Icon Clicked >.");
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			count--;
		}
		
		System.out.println("out of 2 Nd while Loop");
		
		System.out.println("Inside End Calender Switch .");
		switch(Integer.valueOf(endCal[1]))
		{
		case 1 :
			driver.findElement(By.xpath("//*[@id='mat-datepicker-2']/div[2]/mat-month-view/table/tbody/tr[2]/td[2]/div")).click();
			System.out.println("Switch January");
			break;
			
		case 2 :
			driver.findElement(By.xpath("//*[@id='mat-datepicker-2']/div[2]/mat-month-view/table/tbody/tr[1]/td[2]/div")).click();
			System.out.println("Switch Febuary");
			break;
			
		case 3:
			driver.findElement(By.xpath("//*[@id='mat-datepicker-2']/div[2]/mat-month-view/table/tbody/tr[1]/td[2]/div")).click();
			System.out.println("Switch March");
			break;
			
		case 4:                       
			driver.findElement(By.xpath("//*[@id='mat-datepicker-3']/div[2]/mat-month-view/table/tbody/tr[2]/td[2]/div")).click();
			System.out.println("Switch April");
			break;
			
		case 5 :                       
			driver.findElement(By.xpath("//*[@id='mat-datepicker-3']/div[2]/mat-month-view/table/tbody/tr[2]/td[2]/div")).click();
			System.out.println("Switch May");
			break;
			
		case 6 :                      
			driver.findElement(By.xpath("//*[@id='mat-datepicker-3']/div[2]/mat-month-view/table/tbody/tr[1]/td[2]/div")).click();
			System.out.println("Switch June");
			break;
			
		case 7 :                       
			driver.findElement(By.xpath("//*[@id='mat-datepicker-3']/div[2]/mat-month-view/table/tbody/tr[2]/td[2]/div")).click();
			System.out.println("Switch July");
			break;
			
		case 8 :      
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();" , driver.findElement(By.xpath("//*[@id='mat-datepicker-3']/div[2]/mat-month-view/table/tbody/tr[1]/td[2]/div")));
			System.out.println("Switch August");
			break;
			
		case 9 :                      
			driver.findElement(By.xpath("//*[@id='mat-datepicker-3']/div[2]/mat-month-view/table/tbody/tr[2]/td[1]/div")).click();
			System.out.println("Switch September");
			break;

		default:
			System.out.println("Failed Switch");
			break;		
		}  
		System.out.println("Out of End Calender Switch. ");
	}	

/////////////////////////////////////////////////////////////////////////////////////////////////////	 
	 @Test(priority=7)
	 public void countingFlipperCards()
		{
			
			POAmonitorMeasure = PageFactory.initElements(driver, TestNgPO_AMonitorAndMeasure.class);

			WebElement gridView = driver.findElement(By.xpath("/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[4]/div"));
			List<WebElement> CountCards = gridView.findElements(By.xpath("//*[@class='flipper']"));
						
			int i = CountCards.size();
			System.out.println("Count Cards.size() ==== " + CountCards.size());
			
			System.out.println("No of Cards In Scheduled Grid View By using TagName : " + driver.findElement(By.xpath("/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[2]/div[1]/div/div[1]/div/span")).getAttribute("innerHTML"));
			
			if(Integer.toString(i).equalsIgnoreCase(POAmonitorMeasure.countReScheduled.getAttribute("innerHTML")))
				System.out.println("The ReScheduled Card Matches--PASS");
			else
				System.out.println("The ReScheduled Card Matches Does NOT MATCH - FAIL");
		}
	 
////////////////////////////////////////////////////////////////////////////////////////////////////
	 @Test(priority=8)
	 public void recurrenceButtonCheck() throws AWTException
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			POrecurrenceButton = PageFactory.initElements(driver , TestNgPO_RecurrenceButton.class);
			
			JavascriptExecutor execute1 = (JavascriptExecutor) driver;
			execute1.executeScript("arguments[0].click();" ,POrecurrenceButton.recurrenceButton );
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			JavascriptExecutor execute2 = (JavascriptExecutor) driver;
			execute2.executeScript("arguments[0].click();" ,POrecurrenceButton.tableView );
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
			
			List<WebElement> countTableViewRows = POrecurrenceButton.tableViewHeaderRow.findElements(By.xpath("//*[@class='mat-row']"));
		
			System.out.println("No OF Rows In the Table : " + countTableViewRows.size());
			
			int i=0;
			String name;
			for( i=1 ; i<= countTableViewRows.size() ; i++)
			{			
				name= driver.findElement(By.xpath("/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[" + i + "]/mat-cell[5]")).getText();
				                                                   ///html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[10]/mat-cell[10]/span[1]
				String RecurrenceScheduled = driver.findElement(By.xpath("/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[" + i + "]/mat-cell[10]/span[1]")).getAttribute("innerHTML");
				String RecurrenceReScheduled = driver.findElement(By.xpath("/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[" + i + "]/mat-cell[10]/span[2]")).getAttribute("innerHTML");
				String RecurrenceCompleted = driver.findElement(By.xpath("/html/body/app-root/app-mainpage/mat-sidenav-container/mat-sidenav-content/app-monitoring-measurements/div/div[3]/div/div/div/mat-table/mat-row[" + i + "]/mat-cell[10]/span[2]")).getAttribute("innerHTML");
				System.out.println("--------------------------------------");	
				System.out.println(name);

				System.out.print("  Scheduled : " + RecurrenceScheduled);
				System.out.print("  ReScheduled : " +RecurrenceReScheduled);
				System.out.println("  Completed : " +RecurrenceCompleted);		
			}		
		}
	 
//////////////////////////////////////////////////////////////////////////////////////////////////
	 @Test(priority=9)
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
	 
///////////////////////////////////////////////////////////////////////////////////////////////////
	 @AfterClass 
     public void closeApplication() {
	  driver.close();
	  System.out.println("Driver Closed");
  }

////////////////////////////////////////////////////////////////////////////////////////////////////
}

