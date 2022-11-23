package framedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frametest3 {

	
	

	
	@Test
	public void test1() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame("left");
		String name=driver.findElement(By.xpath("//h1[text()='Left']/../ul/li[2]")).getText();
	     System.out.println(name);
	}
}
