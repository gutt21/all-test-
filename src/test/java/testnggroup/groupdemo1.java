package testnggroup;

import org.testng.annotations.Test;

public class groupdemo1 {

	@Test(groups = "akash")
	public void test1() {
		System.out.println("group1");
	}
	@Test(groups = "shekhar")
	public void test2() {
		System.out.println("group2");
	}
	@Test(groups = "akash")
	public void test3() {
		System.out.println("group1");
	}
	@Test(groups = {"khadar","akash"})
	public void test4() {
		System.out.println("group3");
	}
	@Test(groups = "shekhar")
	public void test5() {
		System.out.println("group2");
	}
	@Test(groups = "khadar")
	public void test6() {
		System.out.println("group3");
	}
	
	
    @Test(dependsOnGroups = "akash")
	public void maintest() {
		System.out.println("main test");
	}
	
	

}
