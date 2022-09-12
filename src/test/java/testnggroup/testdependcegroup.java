package testnggroup;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class testdependcegroup {


	@Test(groups = "akash")
	public void test1() {
		System.out.println("group1");
	}
	@Ignore
	@Test(groups = "shekhar")
	public void test2() {
		System.out.println("group2");
	}
	@Test(groups = "akash")
	public void test3() {
		System.out.println("group1");
	}
	@Test(groups = "khadar")
	public void test4() {
		System.out.println("group3");
	}
	@Ignore
	@Test(groups = "shekhar")
	public void test5() {
		System.out.println("group2");
	}
	@Test(groups = "khadar")
	public void test6() {
		System.out.println("group3");
	}

	
	
}
