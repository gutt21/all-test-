package windowsdemo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public	 class windowstest2 {



	/**
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));	
		String parent=driver.getWindowHandle();
		WebElement age=  driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", age);
		Set<String>child=driver.getWindowHandles();


		for(String akash:child) {


			if(!akash.equals(parent)) {

				driver.switchTo().window(akash);
				driver.findElement(By.id("firstName")).sendKeys("akash");
				driver.findElement(By.id("lastName")).sendKeys("guttedar");				
				Thread.sleep(3000);	
				WebElement aka=	driver.findElement(By.id("BlogArchive1_ArchiveMenu"));
				Select se=new Select(aka);
				se.selectByIndex(1);
				Thread.sleep(5000);	
				driver.close();
			}

		}
		driver.switchTo().window(parent);
		driver.findElement(By.id("name")).sendKeys("akash guttedar");
		driver.close();












	}
}
