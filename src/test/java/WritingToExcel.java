import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingToExcel {

	public static void main(String[] args) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet0 = workbook.createSheet("FirstSheet");
        
                 //  Row row0  = sheet0.createRow(0); 
      
                 //Cell cellB = row0.createCell(1);
							/*
							 * Cell cellC = row0.createCell(2); Cell cellD = row0.createCell(3); Cell cellE
							 * = row0.createCell(4);
							 * 
							 * cellA.setCellValue("API"); cellB.setCellValue("Description");
							 * cellC.setCellValue("Status Code"); cellD.setCellValue("Response");
							 * cellE.setCellValue("Result");
							 */
        
        for(int rows=0;rows<10;rows++)
        {
        	Row row  = sheet0.createRow(rows);
        	 for(int cols=0;cols<10;cols++)
        	 {
        		 Cell cell = row.createCell(cols);
        		 cell.setCellValue((int)(Math.random()*100)); 
        	 }
        		 
        	 }
       
       File f = new File("C:\\filewriting\\myoutputFile.xlsx");
       FileOutputStream fos = new FileOutputStream(f);
       workbook.write(fos);
       fos.close();
       System.out.println("File Created");
       
       
	}

}
 