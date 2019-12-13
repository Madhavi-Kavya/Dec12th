package com.hybrid_framework_shared;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OpenIEBrowser {
	
	public static void main(String[] arg) throws Exception
	{
			 			
	System.setProperty("webdriver.ie.driver" , "C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Jar Dependencies\\IEDriverServer_Win32_2.47.0\\IEDriverServer.exe");
	
	DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
	capabilitiesIE.setCapability(
	InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			
	WebDriver driver = new InternetExplorerDriver(capabilitiesIE);
		
		driver.get("https://www.youtube.com");
		//Alert A = driver.switchTo().alert();
		//A.dismiss();
		//System.out.println("Alert Handeled.");
		driver.manage().window().maximize();
		driver.close();
		System.out.println("Closed");
	}
}
