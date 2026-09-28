package practice.testng;

import org.testng.annotations.Test;


public class InvocationCountPractice {

	@Test(invocationCount=10)
	public void createOrderTest() {
		System.out.println("Exceute create Ordertest==>123");
		
	}
	
	@Test(enabled=false)
	public void billingAnOrderTest() {
		System.out.println("Exceute billingAnOrderTest==>123");
}
}