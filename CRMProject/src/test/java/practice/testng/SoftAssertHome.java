package practice.testng;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertHome {
	
	@Test
	public void softAssertHome(Method mtd) {
		
		System.out.println(mtd.getName()+"  test Started");
		SoftAssert assertobj=new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertEquals("Home", "Home");
		System.out.println("Step-3");
		assertobj.assertEquals("Home-crm", "Home-rm");
		System.out.println("Step-4");
		assertobj.assertAll();
		System.out.println(mtd.getName()+"  test end");	
}
	@Test
	public void logosoftAssertHome(Method mtd) {
		
		System.out.println(mtd.getName()+"  test Started");
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.out.println(mtd.getName()+"  test end");
		
	}
}