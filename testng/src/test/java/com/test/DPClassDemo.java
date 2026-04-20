package com.test;

import org.testng.annotations.DataProvider;


public class DPClassDemo {
	@DataProvider(name="testData")
	public Object[][] dataProv(){
		return new Object[][] {
			{"selenium"},{"TestNG"}
		};
	}
}
