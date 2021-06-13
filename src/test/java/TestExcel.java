import org.apache.log4j.Logger;

public class TestExcel {

	public static void main(String[] args) 
	{
		Logger log = Logger.getLogger("devpinoyLogger");
		ExcelReader excel = new ExcelReader("C:\\filewriting\\ExcelReader\\TestData.xlsx");
		String sheetName = "Trainer";
		
		log.debug("Getting the row count");
		System.out.println(excel.getRowCount(sheetName));
		
		log.debug("Getting the column count");
		System.out.println(excel.getColumnCount(sheetName));
		
		log.debug("Getting the data");
		System.out.println(excel.getCellData(sheetName, "username", 2));
		
		log.debug("Entering the data");
		excel.setCellData(sheetName, "username", 4, "Ishita");
		excel.setCellData(sheetName, "password", 4, "Karnan");
		
		System.out.println("File updated");  
	} 
 
}
