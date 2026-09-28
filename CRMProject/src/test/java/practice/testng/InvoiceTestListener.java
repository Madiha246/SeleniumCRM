package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementation.class)
public class InvoiceTestListener extends BaseClass {
	
	@Test
	public void createInvoioceTest() {
		System.out.println("execute createInvoioceTest ");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, false);
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		
	}
	@Test
	public void createInvoioceWithCntactTest() {
		System.out.println("execute createInvoioceWithCntactTest ");		
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		
	}
	
	

}
