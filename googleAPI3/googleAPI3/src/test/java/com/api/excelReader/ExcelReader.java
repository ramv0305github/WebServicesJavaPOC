package com.api.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static FileInputStream file;
	static FileOutputStream fos;
	static String filePath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Row row;
	static Cell cell;
	static CellType cell1;
    static int noOfColum;
	public ExcelReader(String filePath) throws Exception
	{
		 file = new FileInputStream(new File(filePath));
		 workbook = new XSSFWorkbook(file);
		
	}
	
	public int getNoOfRow()
	{
		sheet=workbook.getSheetAt(0);
		return sheet.getLastRowNum()+1;
		
		
	}
	
	public static String getData(int rowNum,String columnName)
	{
		 sheet = workbook.getSheetAt(0);
		 row=sheet.getRow(0);
		 noOfColum= row.getPhysicalNumberOfCells();	
		 int col_num = -1;
		 for(int i=0;i<noOfColum;i++)
		 {
			 if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(columnName))
			 {
				 col_num=i;
			 }
		 }
		 
		 row=sheet.getRow(rowNum);
		 cell= row.getCell(col_num);
		 cell1=cell.getCellType();
		 
		 if(cell.getCellType()==cell1.STRING)
			 return cell.getStringCellValue();
		 if(cell.getCellType()==cell1.NUMERIC)
			 return String.valueOf(cell.getNumericCellValue());
		      //return StringValueOf(n);
		return cell.getStringCellValue();
		 
		 
		// return cell.getStringCellValue();
				
	}	
	
	public static void setValue(int rowNum,String columnName,String value) throws Exception
	{
		try {
			sheet = workbook.getSheetAt(0);
			 row=sheet.getRow(0);
			 noOfColum= row.getPhysicalNumberOfCells();	
			 int col_num = -1;
			 for(int i=0;i<noOfColum;i++)
			 {
				 if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(columnName))
				 {
					 col_num=i;
				 }
			 }
			 
			 cell=sheet.getRow(rowNum).getCell(col_num);
			 if(cell == null)
		            cell = sheet.getRow(rowNum).createCell(col_num);
			cell.setCellValue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			 fos = new FileOutputStream("TestData.xlsx");
		        workbook.write(fos);
		        fos.close();
		}
	}
	
	
	

		 
		 
		 
	}
	
	
	


