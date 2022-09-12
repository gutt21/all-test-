package excel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datareadformulinexcel {

	

	public static void main(String[] args) throws Exception {

		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\akash\\eclipse-workspace\\testngdemo1\\excel\\readdataformul.xlsx");
		XSSFSheet sheet=book.getSheet("Sheet1");
		int ag=sheet.getPhysicalNumberOfRows();
		int as=sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i=0;i<ag;i++) {
			XSSFRow row=sheet.getRow(i);	
			for(int j=0;j<as;j++) {
				XSSFCell cells=row.getCell(j);
				
				switch(cells.getCellType()) {
				
				case STRING:
					System.out.print(cells.getStringCellValue());
					break;
					
				case NUMERIC:
					System.out.print(cells.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cells.getBooleanCellValue());
					break;
				case FORMULA:
					System.out.print(cells.getNumericCellValue());
					break;
				}
				System.out.print("|");
				
			}
			System.out.println(" ");
		}
		 
	
  
	}
	
}
