package testngdemo1;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testdemo1 {

	@Test
	public void test() {
		
		
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	   driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
	   
//	   driver.findElement(By.xpath("//select[@id='course']")).click();
//	   driver.findElement(By.xpath("//select[@id='course']/../..//option[@value='select']")).click();
   
	   
	   
       WebElement akash=driver.findElement(By.xpath("//select[@id='course']"));
	   Select se=new Select(akash);
	   //se.selectByVisibleText("Java");
	   se.selectByIndex(3);
	   Actions as=new Actions(driver);
	 //as.scrollByAmount(50, 200).build().perform();
	   as.scrollToElement(driver.findElement(By.xpath("//h2[normalize-space()='Recent Tutorials']"))).build().perform();
	   
	   
	}
}
