package fileupload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fileupload {

	
	
	static WebDriver driver;
	
	public static void one() throws Exception {
		
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.monsterindia.com/");
		driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']")).click();
		//driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\akash\\Downloads\\logo.pdf");
		WebElement akash=driver.findElement(By.xpath("//input[@id='file-upload']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",akash);
		
		Robot rb=new Robot();
		rb.delay(2000);
		StringSelection ss=new StringSelection("C:\\Users\\akash\\OneDrive\\Desktop\\PhotoResizer\\logo.pdf");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.id("pop_upload")).click();
		
		
	}
	
	
	public static void two() {
		driver.findElement(By.name("fullname")).sendKeys("akash");
	}
	
	@Test
	public void test() throws Exception {
		one();
		two();
	}
	
	
}
