package com.Agility;

import org.testng.annotations.Test;

public class A_CallingReusableMethods {
	
	public static void main(String[] arg) throws Exception
	{ 
				
		A_ReusableMethods A_RM = new A_ReusableMethods();		
	
		A_RM.excelConnection("C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Data\\ABC_DATA.xls");
		

			for( A_RM.r =0;A_RM.r <A_RM.RowCount; A_RM.r++)
			{				
		
	//	A_RM.launchApplicationIE(A_RM.S.getCell(0, 0).getContents() , "C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Result\\A_launchApplication.png");

		A_RM.launchApplicationChrome(A_RM.S.getCell(0, A_RM.r).getContents() , "C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Result\\A_launchApplication.png");

		A_RM.enterLoginDetails(A_RM.S.getCell(1, A_RM.r).getContents() , A_RM.S.getCell(2, A_RM.r).getContents());
		
		A_RM.checkCountInDropDownBox(18);
		
		A_RM.selectDropDownBox("C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Result\\A_dropDownBoxSelected.png");
					
		A_RM.selectDatePicker();
		
		A_RM.checkMonitorAndMeasure();
		
		A_RM.countingFlipperCards();
		
		A_ReusableMethodsONE A_RMone = new A_ReusableMethodsONE();
		A_RMone.recurrenceButtonCheck();
		
		A_RMone.checkingColours();
		
		A_RM.closeApplication();	
			
		}
	}
}


