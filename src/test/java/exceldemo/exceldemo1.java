package exceldemo;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class exceldemo1 {

	
	
	
	
	// write on excel 
	@Test
	public void testexcel() throws Exception {
		
		XSSFWorkbook work=new XSSFWorkbook();
		XSSFSheet sheet=work.createSheet("akash");
		
		
		Object data[][]= {
				{"names", "acoount", "place"},
				{"akash", "saving", "gulbarga"},
				{"khadar", "current", "raichur"},
				{"shekhara", "saving", "bijapur"},
				{"asg", "facebook", "bidhar"}
						};
		
		
		int row=data.length;
		int col=data[0].length;
		System.out.println(row);
		System.out.println(col);
		
		for(int i=0;i<row;i++) {
			
			XSSFRow rows=sheet.createRow(i);
			
			for(int j=0;j<col;j++) {
				
				XSSFCell clles=rows.createCell(j);
				
				System.out.print(data[i][j]+" ");
				
				Object value=data[i][j];
				if(value instanceof String)
					clles.setCellValue((String)value);
				if(value instanceof Integer)
					clles.setCellValue((Integer)value);
				if(value instanceof Boolean)
					clles.setCellValue((Integer)value);
				
				
			}
			System.out.println(" ");
			
			
		}
		
		FileOutputStream file=new FileOutputStream(".\\excel\\guttedarboy.xlsx");
		work.write(file);
		file.close();
		System.out.println("successfull");
		
		
		
	}
}
