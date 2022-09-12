package daraprovide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datademo {

	@Test(dataProvider = "akash",dataProviderClass = datademo2.class)
	public void test1(String emails,String passs) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement email=driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys(emails);
		WebElement pass=	driver.findElement(By.id("Password"));
		pass.clear();
		pass.sendKeys(passs);
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		boolean akash=driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).isDisplayed();
		Assert.assertTrue(akash);
		Thread.sleep(5000);
		driver.close();
	}
	
	@DataProvider(parallel = true)
	public String[][] data() {
		
		String data[][]= {
				{"admin@yourstore.com","admin"},
				{"admin@yourstore.com","admn"},
				{"admin@yourstore.com","admin"},
				{"admin@yourstore.com","admn"}
		};
		return data;
		
	}
	
	
	
	
}
