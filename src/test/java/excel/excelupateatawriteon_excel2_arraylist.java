package excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.ICell;

public class excelupateatawriteon_excel2_arraylist {

	
	public static void main(String[] args) {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("empty");
		
		ArrayList <Object[]> data=new ArrayList<Object[]>();
		data.add(new Object[] {"number","name","password"});
		data.add(new Object[] {101,"akash","123"});
		data.add(new Object[] {102,"khadar","143"});
		data.add(new Object[] {103,"shekhar","156"});
		
		int rows=0;
		
				
		for(Object i[]:data){
			
			XSSFRow row=sheet.createRow(rows++);
			int cols=0;
			for(Object value:i) {
		    XSSFCell clles =row.createCell(cols++);				
				if(value instanceof String)
					clles.setCellValue((String)value);
				if(value instanceof Integer)
					clles.setCellValue((Integer)value);
				if(value instanceof Boolean)
					clles.setCellValue((Integer)value);
			
				
			}
			
		}
		String path=".\\excel\\updateexcel2.xlsx";
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
