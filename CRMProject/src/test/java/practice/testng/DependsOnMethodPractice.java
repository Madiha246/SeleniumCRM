package practice.testng;
import org.testng.annotations.Test;

public class DependsOnMethodPractice {
	
		@Test
		public void createOrderTest() {
			System.out.println("Exceute create Ordertest==>123");
		}
		
		@Test(dependsOnMethods="createOrderTest")
		public void billingAnOrderTest() {
			System.out.println("Exceute billingAnOrderTest==>123");
		}


	
}
