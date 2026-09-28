package practice.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.comcast.cm.genericUtility.ExcelUtility;

public class TgetRwCOUNT {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility eu=new ExcelUtility();
		int r=eu.getRowCount("Product");
		
System.out.println(r);
	}

}
