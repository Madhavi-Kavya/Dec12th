package AgilityDataProviderPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Agility.A_ReusableMethods;

public class DataProviderFromExcel {
	
	A_ReusableMethods ARM = new A_ReusableMethods();  
  
  @DataProvider
  public Object[][] getDataFromExcel1() {
	  
     Object[][]  objectExcel = new Object[2][1] ;
     
     objectExcel[0][0] = "C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Data\\BBData.xls";
     
     objectExcel[1][0] = "C:\\Users\\rgunturu\\Desktop\\JavaPractise\\HybridFrameWork Shared Folder\\Test Data\\BBData.xls";
   
    
    return objectExcel;
  }
  
  @DataProvider
  public Object[][] getDataFromExcel2() {
	  
	     Object[][]  objectExcel = new Object[2][1] ;
	     
	     objectExcel[0][0] = ARM.S.getCell(0, 0).getContents();	     
	    
	     objectExcel[1][0] = ARM.S.getCell(0, 1).getContents();
	     
	    return objectExcel;
	  }
  
  @DataProvider
  public Object[][] getDataFromExcel3() {
	  
	     Object[][]  objectExcel = new Object[2][4];	     
	     
	     objectExcel[0][0] = ARM.S.getCell(1, 0).getContents();
	     objectExcel[0][0] = ARM.S.getCell(2, 0).getContents();	    
	     
	     objectExcel[1][1] = ARM.S.getCell(1, 1).getContents();
	     objectExcel[1][1] = ARM.S.getCell(2, 1).getContents();
	    
	    return objectExcel;
	  }
  
  @DataProvider
  public Object[][] getDataFromExcel4() {
	  
     Object[][]  objectExcel = new Object[2][1] ;
     
     objectExcel[0][3] = ARM.S.getCell(3, 0).getContents();

      objectExcel[1][3] = ARM.S.getCell(3, 1).getContents();
    
    return objectExcel;
  }
  
  @DataProvider
  public Object[][] getDataFromExcel5() {
	  
     Object[][]  objectExcel = new Object[2][1] ;
     
     objectExcel[0][3] = ARM.S.getCell(4, 0).getContents();

     objectExcel[1][3] = ARM.S.getCell(4, 1).getContents();
    
    return objectExcel;
  }
  
  
  @DataProvider
  public Object[][] getDataFromExcel6() {
	  
	     Object[][]  objectExcel = new Object[2][2];	     
	     
	     objectExcel[0][0] = ARM.S.getCell(5, 0).getContents();
	     objectExcel[0][0] = ARM.S.getCell(6, 0).getContents();	    
	     
	     objectExcel[1][1] = ARM.S.getCell(5, 1).getContents();
	     objectExcel[1][1] = ARM.S.getCell(6, 1).getContents();
	    
	    return objectExcel;
	  }
}
