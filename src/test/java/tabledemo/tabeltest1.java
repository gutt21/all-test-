package tabledemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import alldemo.timeout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class tabeltest1 {

	
	
	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.nyse.com/ipo-center/filings");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    List<WebElement> row=driver.findElements(By.xpath("//table[2]/tbody/tr"));
		
		System.out.println("total number of row"+row.size());
		List<WebElement> col=driver.findElements(By.xpath("//table[2]/tbody/tr[1]/td"));
		System.out.println("total number of column"+col.size());
		
		//particular value is output
		String name=driver.findElement(By.xpath("//table[2]/tbody/tr[1]/td[7]")).getText();
		System.out.println( "paricular value:- "+name);
		
		
		//all data in the table
		
//		for(int i=1;i<=row.size();i++) {
//			
//			for(int j=1;j<=col.size();j++) {
//				String n=driver.findElement(By.xpath("//table[2]/tbody/tr["+i+"]/td["+j+"]")).getText();
//				System.out.print(n+" = ");
//			}
//			System.out.println();
//		}
		
		for(int i=1;i<=row.size();i++) {
			
		String date=	driver.findElement(By.xpath("//table[2]/tbody/tr["+i+"]/td[1]")).getText();
							
		if(date.equals("07/27/2022")) {
			String amt=	driver.findElement(By.xpath("//table[2]/tbody/tr["+i+"]/td[7]")).getText();
			
			System.out.println(date+" "+amt);
		}
		}
		
		
		List<WebElement> akash=driver.findElements(By.xpath("//table[1]/thead/tr/th"));
		
		
		for(WebElement age:akash) {
			System.out.print(age.getText()+"  =  ");
		}
		System.out.println();
		driver.close();
		
		
		
		
	}
	
	
}
