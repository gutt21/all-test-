package excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeformul {

	
	
	public static void main(String[] args) throws Exception {
		
		XSSFWorkbook book=new XSSFWorkbook();
		XSSFSheet sheet=book.createSheet("number");
		
		XSSFRow row=sheet.createRow(0);
		
		row.createCell(0).setCellValue(100);
		row.createCell(1).setCellValue(100);
		row.createCell(2).setCellValue(100);
		row.createCell(3).setCellFormula("A1+B1+C1");
		
		FileOutputStream output=new FileOutputStream(".\\excel\\writeformul.xlsx");
		book.write(output);
		System.out.println("suceesfull");
	}
}
