package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Params {
  @Test
  @Parameters({"val1","val2"})
  public void Sum(int val1,int val2) {
	  int sums=val1+val2;
	  System.out.println("the sum of two value is:"+sums);
	  }
  @Test
  @Parameters({"val1","val2"})
  public void Sum1(int val1,int val2) {
	  int sums=val1-val2;
	  System.out.println("the diffrence of two value is:"+sums);
	  }
}
