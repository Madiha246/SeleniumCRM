package practice.testng;

import org.testng.annotations.Test;

public class DependsOnMethodsPractice3 {

	
		@Test
		public void createContactTest() {
			System.out.println("execute create contact with -->HDFC ");

		}

		@Test(dependsOnMethods = "createContactTest")
		public void modifyContactTest() {

			System.out.println("modify contactTest-->HDFC-->ICICI");

		}

		@Test(dependsOnMethods = "modifyContactTest")
		public void deleteContactTest() {

			System.out.println("Delete contact ICICI");
		}

	
}
