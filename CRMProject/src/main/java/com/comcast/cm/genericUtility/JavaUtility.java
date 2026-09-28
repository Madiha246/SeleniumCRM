package com.comcast.cm.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int randomInputs() {
		Random r=new Random();
		int ran=r.nextInt();
		return ran;
	}
		
	public String currentDate() {
		Date d=new Date(); //gives current date including time
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");//we dont want time so we use data mention and mention in() what format to use
		return sim.format(d); //it gives for which date, format is required
		
	}
}
