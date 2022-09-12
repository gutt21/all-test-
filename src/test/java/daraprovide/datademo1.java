package daraprovide;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class datademo1 {


	@Test(dataProvider = "akash",dataProviderClass = datademo2.class)
	public void test1(String name,String pass) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("txtUsername")).sendKeys(name);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.close();


	}
	@DataProvider
	public String [][] data() {
		String [][]data= {
				{"Admin","admin123"},
				{"Admin","admin12"},
				{"Admin","admin123"}
		};
		return data;

	}




}
