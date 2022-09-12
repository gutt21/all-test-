package daraprovide;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class datademo3 {


	@Test(dataProvider = "data")
	public void test1(String name,String pass) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("txtUsername")).sendKeys(name);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.close();


	}
	@DataProvider(parallel = true)
	public String [][] data() {
		String [][]data= {
				{"Admin","admin123"},
				{"Admin","admin12"},
				{"Admin","admin123"},
				{"Admin","admin12"}
		};
		return data;

	}


	@DataProvider(parallel = true)
	public String[][] data1() {

		String data[][]= {
				{"admin@yourstore.com","admin"},
				{"admin@yourstore.com","admn"}

		};
		return data;

	}
	@DataProvider(parallel = true)
	public String [][] data2() throws Exception{

		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\akash\\eclipse-workspace\\testngdemo1\\excel\\demo.xlsx");
		XSSFSheet sheet=book.getSheet("Sheet1");
		int a=sheet.getPhysicalNumberOfRows();
		int b=sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println(a);
        System.out.println(b);
        String data[][]=new String [a][b];
        for(int i=0;i<a;i++) {
        	for(int j=0;j<b;j++) {
        		DataFormatter da=new DataFormatter();
        		data[i][j]=da.formatCellValue(sheet.getRow(i).getCell(j));
        	}
        }
		return data;





	}


}
