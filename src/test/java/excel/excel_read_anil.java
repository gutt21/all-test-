package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_read_anil {

	
	
	
	
	public String test_get(String path,String sheetname,int rownum,int colnum) {
		try {
		FileInputStream input=new FileInputStream(path);
		XSSFWorkbook book=new XSSFWorkbook(input);
		XSSFSheet sheet=book.getSheet(sheetname);
		XSSFRow row=sheet.getRow(rownum);
		XSSFCell cell=row.getCell(colnum);
		
		switch(cell.getCellType()) {
		
		case STRING:
			String name=cell.getStringCellValue();
			return name;
		case NUMERIC:
			String numb=String.valueOf(cell.getStringCellValue());
			return numb;
		}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "row number is did not exit";
	}
	
	
	
	
	public String set_test(String path,String sheetname,int rownum,int colnum,String data) {
		
		try {
			
		FileInputStream input=new FileInputStream(path);
		XSSFWorkbook book=new XSSFWorkbook(input);
		XSSFSheet sheet=book.getSheet(sheetname);
		XSSFRow row=sheet.getRow(rownum);
		
		if(row==null) {
			row=sheet.createRow(rownum);
		}
		XSSFCell cell=row.getCell(colnum);
		if(cell==null) {
			cell=row.createCell(colnum);
		}
		
		cell.setCellValue(data);
		FileOutputStream output=new FileOutputStream(path);
		book.write(output);
		output.flush();
		output.close();
		book.close();
		
		
		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "pass";
	}
	
	
	
	
	
}
