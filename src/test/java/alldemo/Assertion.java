package alldemo;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion {


	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		SoftAssert soft=new SoftAssert();
		driver.findElement(By.name("q")).sendKeys("javatpoint"+Keys.ENTER);
	//	boolean ag=driver.findElement(By.xpath("//h3[contains(text(),'Jaatpoint: Tutorials List')]")).isDisplayed();
		//Assert.assertTrue(ag);
		String actual=driver.getTitle();
		String ex="javatpoint - Google Search";
		Assert.assertEquals(actual, ex);
		//soft.assertEquals(actual, ex);	
		System.out.println(actual);
		System.out.println("success");
		driver.close();





	}
}
