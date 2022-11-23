package exceldemo2;

import org.testng.annotations.Test;

public class test_excel_total {

	
	
	excel_read_anil re;
	
	@Test
	public void test_excel() {
		re=new excel_read_anil();
		
		String path="C:\\Users\\akash\\OneDrive\\Desktop\\all in one\\books\\Month_Leads.xlsx";
		for(int i=1;i<2;i++) {
			for(int j=0;j<5;j++) {
				String name=re.test_get(path, "Month Leads", i, j);
		
				System.out.println(name);
				
			}
		}
	
	}
	
}
