package excel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class exce_read_test_class {

	read_excel re;

	@Test
	public void test_data() {

		String path="C:\\Users\\akash\\OneDrive\\Desktop\\all in one\\books\\Month_Leads.xlsx";
		// Company First name Last name Month Leads
		re=new read_excel(path);

		for(int i=1;i<2;i++) {
			for(int j=0;j<5;j++) {
				String name=re.test_get("Month Leads", i, j);
				re.set_test("Month Leads", 2, j, name);
				System.out.println(name);
		}
		}	
		//re.set_test("Month Leads", 2, 1, "telus serviceyyy");
		re.setdatavalue("Month Leads", "Company", 3, "telus serviceyyy");
		//re.set_test("Month Leads", 2, 2, "aniyl");
		re.setdatavalue("Month Leads", "First name", 3, "aniyl");
		//re.set_test("Month Leads", 2, 3, "lnuy");
		re.setdatavalue("Month Leads", "Last name", 3, "lnuy");
			String name=re.getcelldata("Month Leads", "Company", 3);
			//String name=re.test_get("Month Leads", 2, 1);
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.com");
			driver.findElement(By.name("q")).sendKeys(name+Keys.ENTER);



	}



}
