package NestedIframesTests;

import org.testng.annotations.Test;

import NestedIframesPages.NestedIframes;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NestedIframestest extends com.DriverManager.TestBase {
  @Test
  public void canTestNestedIframes() {
	  
	  String expectedText="Child Iframe";
	  
	  NestedIframes nf=new NestedIframes(this.getDriver()).navigate();
	  
	  //System.out.println(nf.getText());
	  String actualText=nf.getText();
	  
	  Assert.assertEquals(actualText, expectedText);
	  
	  
  }
  @BeforeMethod
  public void setUp() throws IOException {
	  super.setup();
  }

  @AfterMethod
  public void tearDown() {
	  super.cleanup();
  }

}
