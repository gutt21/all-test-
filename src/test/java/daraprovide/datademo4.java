package daraprovide;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datademo4 {

	
	public static void main(String[] args) throws Exception {

		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\akash\\eclipse-workspace\\testngdemo1\\excel\\demo.xlsx");
		XSSFSheet sheet=book.getSheet("Sheet1");
		int ag=sheet.getPhysicalNumberOfRows();
		int as=sheet.getRow(0).getPhysicalNumberOfCells();
		String data[][]=new String[ag][as];
		for(int i=0;i<ag;i++) {
			for(int j=0;j<as;j++) {
				DataFormatter ds= new  DataFormatter();
				data[i][j]=ds.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.print(data[i][j]+"  ");
			}
			System.out.println(" ");
		}
		 
	
  
	}
}
