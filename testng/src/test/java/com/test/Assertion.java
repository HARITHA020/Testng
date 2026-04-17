package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {
  @Test
  public void testAssertion(){
	  String str1=new String("TestNG");
	  String str2=new String("TestNG");
	  String str3=null;
	  String str4="TestNG";
	  String str5="TestNG";
	  String str6=new String("Noy_TestNG");
	  int val1=5;
	  int val2=6;
	  
	  //check that two object are equal
	  Assert.assertEquals(str1, str2);
	  System.out.println("The equal assert is succesfull");
	  
	  // check that two object are not equal
	  Assert.assertNotEquals(str1, str6);
	  System.out.println("not equal assert is succesfull");
	  
	  //check that a condition is true
	  Assert.assertTrue(val1<val2);
	  System.out.println("true assertion is successful");
	  
	  //check that a condition is false
	  Assert.assertFalse(val1>val2);
	  System.out.println("false assetion is successful");
	  
	  //check that the object is not null
	  Assert.assertNotNull(str1);
	  System.out.println("not null assertion is succesfull");
	  
	  //check that the object is null
	  Assert.assertNull(str3);
	  System.out.println("null assertion is succesfull");
	  
	 // check that the value is same
	  Assert.assertSame(str4, str5);
	  System.out.println("same assertion is succesfull");
	  
	  
	  //check that the value is not same
	  Assert.assertNotSame(str1, str3);
	  System.out.println("not same  assertion is succesfull");
  }
}
