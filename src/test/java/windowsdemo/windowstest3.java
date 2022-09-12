package windowsdemo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public	 class windowstest3 {



	@Test
	public void test1() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));		
		String ag=driver.getWindowHandle();
		WebElement age=  driver.findElement(By.xpath("//button[@id='newTabBtn']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", age);
		Set<String> aged= driver.getWindowHandles();
		for(String ak:aged) {
			if(!ak.equals(ag)) {
				driver.switchTo().window(ak);
				driver.findElement(By.id("alertBox")).click();					
				Alert as=driver.switchTo().alert();
				System.out.println(as.getText());
				as.accept();
				Thread.sleep(5000);
				driver.close();
			}

		}
		driver.switchTo().window(ag);
		driver.findElement(By.id("name")).sendKeys("akash guttedar");
		Thread.sleep(5000);
		driver.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
