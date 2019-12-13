package com.hybrid_framework_shared;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class CallingReusableMethods {
	
	public static void main(String[] arg) throws Exception
	{
		
		ReusableMethodsClass R = new ReusableMethodsClass();
		
		R.excelConnection("C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Data\\ReusableMethodDATA.xls" , "Sheet1");
		System.out.println(R.S.getCell(0, 0).getContents());
		
		R.launchApplication(R.S.getCell(0, 0).getContents(), "C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Result\\LaunchAppImg.png");
	  
	//  Have you as a Tester developed a Method(TestScript)--YES, searchJob Method as it was needed.
		R.searchJob("C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Result\\SearchJobImg.png");
		
		R.elementPresent(R.driver.findElement(By.xpath("//*[@id='p0widget']/div/div[1]/div/input")), true, "C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Result\\elementPresentImg.png");
		
		R.countLinks("a", 682, "C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Result\\CountlinkImg.png");
		
		R.startsWithN("a");
		
	//	R.checkForBadLink();		
		
		R.closeApplication();
	}
}
////*[@id="p0widget"]/div/div[1]/div/input
