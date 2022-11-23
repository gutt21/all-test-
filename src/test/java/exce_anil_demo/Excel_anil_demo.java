package exce_anil_demo;

import java.lang.Math;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

public class Excel_anil_demo {









	@Test
	public void get_excel() {
		String path=".\\excel\\anil back .";
		String pathxls=path+"xlsx";
		FileInputStream input;
		try {
			input = new FileInputStream(pathxls);
			XSSFWorkbook book=new XSSFWorkbook(input);
			XSSFSheet sheet=book.getSheet("Month Leads");
			XSSFRow row=sheet.getRow(1);
			XSSFCell cell=row.getCell(1);
			int lastRowNum = sheet.getLastRowNum()+1;
			String e = "";
			//int ag=sheet.getFirstRowNum()+2;
			int ag=sheet.getPhysicalNumberOfRows();
			//int ag=sheet.getLastRowNum();
			System.out.println(ag);
			int as=sheet.getRow(0).getPhysicalNumberOfCells();



			for(int i=ag-1;i<ag;i++) {
				row=sheet.getRow(i);	
				for(int j=0;j<as;j++) {
					cell=row.getCell(j);

					switch(cell.getCellType()) {

					case STRING:

						if(j==1 | j==2) {

							String name=cell.getStringCellValue();
							e=e + ";" + name;
							System.out.print(cell.getStringCellValue());
							set_test("Month Leads", i+1, j, getAlphaString(5),pathxls); 
							break;

						}else {
							String name=cell.getStringCellValue();
							e=e + ";" + name;
							System.out.print(cell.getStringCellValue());
							set_test("Month Leads", i+1, j, name,pathxls); 
							break;
						}

					}
					System.out.print("|");

				}
				System.out.println(" ");
			}
			/*System.out.println(e);
			int o = 0;

			for(int i=0;i<e.split(";").length-1;i++) {
				set_test("Sheet1", lastRowNum, o, getAlphaString(5),
						  path);
				o = o+1;
			}*/
			String pathcsv=path+"csv";
			excelTocsvConvert(pathcsv,pathxls);



		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getAlphaString(int n)
	{
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}





	public static String set_test(String sheetname,int rownum,int colnum,String data,String path) {

		try {

			FileInputStream	input=new FileInputStream(path);
			XSSFWorkbook	work=new XSSFWorkbook(input);
			XSSFSheet	sheet=work.getSheet(sheetname);
			XSSFRow	row=sheet.getRow(rownum);


			if(row==null) {
				row=sheet.createRow(rownum);
			}
			XSSFCell	cell=row.getCell(colnum);
			if(cell==null) {
				cell=row.createCell(colnum);
			}

			cell.setCellValue(data);
			FileOutputStream output=new FileOutputStream(path);
			work.write(output);

			output.flush();
			output.close();
			work.close();


		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "pass";
	}





	public static void excelTocsvConvert(String csvfile,String xlsfile) {


		// For storing data into CSV files
		StringBuffer data = new StringBuffer();
		try {
			FileOutputStream fos = new FileOutputStream(csvfile);

			// Get the workbook object for XLSX file
			XSSFWorkbook wBook = new XSSFWorkbook(new FileInputStream(xlsfile));

			// Get first sheet from the workbook
			XSSFSheet sheet = wBook.getSheet("Month Leads");
			Row row;
			Cell cell;

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {

					cell = cellIterator.next();

					switch (cell.getCellType()) {
					case BOOLEAN:
						data.append(cell.getBooleanCellValue() + ",");

						break;
					case NUMERIC:
						data.append(cell.getNumericCellValue() + ",");

						break;
					case STRING:
						data.append(cell.getStringCellValue() + ",");
						break;

					case BLANK:
						data.append(""+ ",");
						break;

					default:
						data.append(cell + ",");

					}
				}
				data.append('\n');
			}

			fos.write(data.toString().getBytes());
			fos.close();

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}








	public void set_excel_cvs() {
		try {
			File file=new File(".\\excel\\anil back .csv");
			FileWriter filew=new FileWriter(file);
			CSVWriter write= new CSVWriter(filew);






		}catch(Exception e) {
			e.printStackTrace();
		}
	}




}
