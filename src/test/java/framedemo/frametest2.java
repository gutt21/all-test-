package framedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frametest2 {

	
	
	@Test
	public void test1() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("name")).sendKeys("java");
		driver.switchTo().frame("frm3");
		driver.switchTo().frame("frm1");
		WebElement ag=driver.findElement(By.id("course"));
		//driver.findElement(By.xpath("//option[@value='java']")).click();
		Select akash=new Select(ag);
		akash.selectByVisibleText("Java");
		driver.switchTo().parentFrame();
		driver.findElement(By.id("name")).sendKeys("akash guttedar");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);	
		driver.switchTo();
		
	}
}
