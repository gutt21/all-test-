package parallel;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class datademo3 {


	
	@Test()
	public void test1() {
		System.out.println("test"+Thread.currentThread().getId());
	}
	
	@Test
	public void test2() {
		System.out.println("test"+Thread.currentThread().getId());
	}
	
	@Test
	public void test3() {
		System.out.println("test"+Thread.currentThread().getId());
	}
	
	@Test
	public void test4() {
		System.out.println("test"+Thread.currentThread().getId());
	}



}
