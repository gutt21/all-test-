package exceldemo;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class exceldemo2 {





	@Test
	public void exceltest() throws Exception {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String path=".\\excel\\OrangeHRm.xlsx";
		XSSFWorkbook book=new XSSFWorkbook(path);
		XSSFSheet sheet=book.getSheet("Sheet1");
		int a=sheet.getPhysicalNumberOfRows();
		int b=sheet.getRow(0).getPhysicalNumberOfCells();
          System.out.println(a);
          System.out.println(b);
          
		for(int i=0;i<=a;i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<=b;j++) {
				XSSFCell cell=row.getCell(j);
				
				
			System.out.print(cell.getStringCellValue());
					
				
			}



		}










	}



	}
