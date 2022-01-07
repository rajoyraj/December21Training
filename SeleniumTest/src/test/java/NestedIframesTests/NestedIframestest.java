package NestedIframesTests;

import org.testng.annotations.Test;

import NestedIframesPages.NestedIframes;
import framework.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NestedIframestest extends TestBase {
  @Test
  public void canTestNestedIframes() {
	  
	  NestedIframes nf=new NestedIframes(this.getDriver()).navigate();
	  
	  System.out.println(nf.getText());
  }
  @BeforeMethod
  public void setUp() {
	  super.setup();
  }

  @AfterMethod
  public void tearDown() {
	  super.cleanup();
  }

}
