package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	
	@Test(dataProvider="getData")
	public void ceateContactTest(String firstName, String lastName) {
		System.out.println("Firstname : "+firstName+", LastName:" +lastName);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="Madiha";
		objArr[0][1]="shanam";
		
		objArr[1][0]="Mas";
		objArr[1][1]="iha";
		
		objArr[2][0]="Mada";
		objArr[2][1]="Ma";
		
		return objArr;
		
	}

}
