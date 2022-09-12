package excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelupateatawriteon_excel {

	
	public static void main(String[] args) {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("empty");
		
		Object data[][]= {
				{"number","id","password"},
				{1,"akash","974akaso"},
				{1,"akash","974akaso"},
				{1,"akash","974akaso"}
		};
		
		int rows=data.length;
		int cols=data[0].length;
		System.out.println(rows);
		System.out.println(cols);
		
		for(int i=0;i<rows;i++){
			
			XSSFRow row=sheet.createRow(i);
			for(int j=0;j<cols;j++) {
		    XSSFCell clles =row.createCell(j);
				Object value=data[i][j];
				if(value instanceof String)
					clles.setCellValue((String)value);
				if(value instanceof Integer)
					clles.setCellValue((Integer)value);
				if(value instanceof Boolean)
					clles.setCellValue((Integer)value);
				
				
			}
			
		}
		String path=".\\excel\\updateexcel.xlsx";
		FileOutputStream output;
		try {
			output = new FileOutputStream(path);
			workbook.write(output);
			output.close();
			System.out.println("successfull");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
