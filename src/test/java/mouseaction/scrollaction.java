package mouseaction;

import java.time.Duration;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scrollaction {
	
	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.javatpoint.com/java-tutorial");
	    WebElement akash=driver.findElement(By.xpath("//tbody/tr[1]/td[1]/fieldset[2]/div[1]/ul[1]/li[1]/a[1]"));
		
		Actions ac=new Actions(driver);
		//ac.scrollToElement(akash).build().perform();
		ac.scrollByAmount(0, 5000).build().perform();
		
		
	}
	   @Test
	   public void shouldScrollToElement() {
		   WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
	        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");

	        WebElement iframe = driver.findElement(By.tagName("iframe"));
	        new Actions(driver)
	                .scrollToElement(iframe)
	                .perform();

	        
	    }
	   
	   @Test
	    public void shouldScrollFromViewportByGivenAmount() {
		   WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
	        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");

	        WebElement footer = driver.findElement(By.tagName("footer"));
	        int deltaY = footer.getRect().y;
	        new Actions(driver)
	                .scrollByAmount(0, deltaY)
	                .perform();

	      
	    }
	   
	   
	   
	   
	   
}
