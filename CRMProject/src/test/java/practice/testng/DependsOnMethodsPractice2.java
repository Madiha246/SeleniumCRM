package practice.testng;
import org.testng.annotations.Test;


public class DependsOnMethodsPractice2 {

	@Test
	public void createOrderTest() {
		System.out.println("Exceute create Ordertest==>123");
		String str=null;
		System.out.println(str.equals("123"));
	}
	
	@Test(dependsOnMethods="createOrderTest")
	public void billingAnOrderTest() {
		System.out.println("Exceute billingAnOrderTest==>123");
	}


}
