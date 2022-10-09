package windowsdemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gettitle {

	
	
	
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String as=driver.getWindowHandle();
		String akash=driver.getCurrentUrl();
		driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='User Management']")).click();
		driver.findElement(By.xpath("//ul[@role='menu']//li")).click();
		for(int i=0;i<3;i++) {
			
			String title=driver.getTitle();
			if(title.contains("facebook")) {
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(akash);
			}else if(title.contains("instgram")) {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(akash);
			}
		}
				
		driver.switchTo().window(as);
		driver.get(akash);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("chrome://settings/");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
