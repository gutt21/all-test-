package alldemo;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionclass {



	public static void main(String[] args) throws Exception {
		
			
	}
	public void akash() throws Exception {
		System.setProperty("webdriver.chrome.driver",".//driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		//driver.findElement(By.name("q")).sendKeys(9591441751);
		
		
		Thread.sleep(3000);		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();


	}
	
	public void exel() throws Exception {
		XSSFWorkbook work=new XSSFWorkbook("C:\\Users\\akash\\eclipse-workspace\\testngdemo1\\excel\\demo.xlsx");
		XSSFSheet sheet=work.getSheet("Sheet1");
		XSSFCell aka=sheet.getRow(0).getCell(0);
		System.out.println(aka);
	}

}
