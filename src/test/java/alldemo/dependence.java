package alldemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dependence {

	
	WebDriver driver;
	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			
	}
	@Test(dependsOnMethods = "test1")
	public void test2() {
		driver.findElement(By.name("q")).sendKeys("javatpoint"+Keys.ENTER);
	}
	
}
