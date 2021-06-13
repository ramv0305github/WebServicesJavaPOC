package com.api.main;

import com.api.excelReader.ExcelReader;
import com.api.googleAPI.AddPlace;
import com.api.googleAPI.DeletePlace;
import com.api.googleAPI.GetPlace;
import com.api.googleAPI.UpdatePlace;
import com.api.report.ExtentReport;

public class ExecuteTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String filePath="TestData.xlsx";
		ExcelReader dataTable=new ExcelReader(filePath);
		int noOfRow;
		noOfRow=dataTable.getNoOfRow();
		String testCaseName;
		int i;
		ExtentReport.report();
		for(i=0;i<noOfRow;i++)
		{
			testCaseName=ExcelReader.getData(i, "TestcaseName");
			switch(testCaseName)
			{
			case "AddPlace":
				AddPlace.execute(i);
				System.out.println("---------------------------------------------");
				break;
			case "GetPlace":
				GetPlace.execute(i);
				System.out.println("---------------------------------------------");
				break;
			case "UpdatePlace":
				UpdatePlace.execute(i);
				System.out.println("---------------------------------------------");
				break;
			case "DeletePlace":
				DeletePlace.execute(i);
				System.out.println("---------------------------------------------");
				break;

			}
		}

		ExtentReport.endTest();
		ExtentReport.flush();


	}

}
