package com.test;

import org.testng.annotations.Test;
public class GroupsPractice {
	
  @Test(groups="groupA")
  public void method1() {
	  System.out.println("menthod 1 for the group A");
  }
  
  @Test(groups="groupA")
  public void method2() {
	  System.out.println("menthod 2 for the group A");
  }
  
  @Test(groups="groupB")
  public void method3() {
	  System.out.println("menthod 3 for the group B");
  }
  
  @Test(dependsOnGroups="groupA")
  public void methodgroup() {
	  System.out.println("running the dependent test");
  }
   
  @Test
  public void demo() {
	  
  }
}
