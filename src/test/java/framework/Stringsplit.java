package framework;

import org.testng.annotations.Test;

public class Stringsplit {

	
	
	@Test
	public void test()
	{
		
		String a="akash_guttedar_boy";
		 String [] b=a.split("_");
		 for(int i=0;i<b.length;i++) {
			 System.out.println(b[i]);
		 }
		 System.out.println();
		
		
		
	}
}
