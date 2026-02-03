package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
//Dataprovider1
	
@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
     {
		
		String path =".\\testData\\Opencart_LoginData.xlsx";//takin xl file from test data folder
		
		
		ExcelUtility xlutil=new ExcelUtility(path); //Creating an object for excelutility
		
		
		int totalrows= xlutil.getRowCount("Sheet1");
		int totalcols= xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]= new String [totalrows][totalcols]; //created for two dimensional array  which can store
		
		for(int i=1;i<=totalrows;i++) //read the data from excel storing in 2 dimensional array
			
		{
			for(int j=0;j<totalcols;j++)//i is rows and j is col
				
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);//1,0
				
			}
		}
		return logindata; //returning two dimensional array	
		
	}
}
