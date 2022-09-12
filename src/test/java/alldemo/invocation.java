package alldemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class invocation {

	@Test(invocationCount = 3,invocationTimeOut = 1000)
	public void test1() {
		System.out.println("test1");
	}
	@Ignore
	@Test(invocationCount = 2,invocationTimeOut = 7000)
	public void test2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.javatpoint.com/testng-tutorial");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		
	}
	
}
