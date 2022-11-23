package alldemo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionclass {



	public static void main(String[] args) throws Exception {
		/*
		 * System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver.exe");
		 * WebDriver driver = new ChromeDriver();
		 * driver.get("https://www.africau.edu/images/default/sample.pdf");
		 */
		long now = System.currentTimeMillis();
		long nowPlus5Minutes = now - TimeUnit.MINUTES.toMillis(5);
		String s = System.getProperty("user.home") + "//Downloads"; ;
		final File folder = new File(s);
		listFilesForFolder(folder);

	}
	
	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	    	String s = fileEntry.getName();
	    	long lastModified = fileEntry.lastModified();
	    	Date d=new Date(lastModified);
	    	
	    	if(s.contains("f5epi")) {
	    		System.out.println(s);
	    		System.out.println(d);
	    	}
	    }
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
