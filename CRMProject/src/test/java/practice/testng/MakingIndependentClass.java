package practice.testng;
import org.testng.annotations.Test;

public class MakingIndependentClass {
 
		@Test(priority = 1)
		public void createContactTest() {
			System.out.println("execute create contact with -->HDFC ");

		}
		@Test(priority = 2)
		public void modifyContactTest() {
			System.out.println("create contact ICICI");
			System.out.println("execute query insert contatc in DB==>ICICI");
			
			System.out.println("modify contactTest-->ICICI-->ICICI_1");

		}
		@Test(priority = 3)
		public void deleteContactTest() {
			System.out.println("create UPI contact ");
			System.out.println("execute query insert contatc in DB==>UPI");
	        System.out.println("Delete contact UPI");
		}

	
}
