package com.review;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void Test() {
	  
	  System.out.println("I am from the test method");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("I am from the before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("I am from the after method");
  }
  

  @BeforeClass
  public void beforeClass() {
	  System.out.println("I am from beforeclass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("I am from afterclass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("I am from beforetest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("I am from the aftertest");
  }

}
