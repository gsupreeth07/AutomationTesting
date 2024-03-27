package org.Selenium.test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class NewTest {
  @Test(dataProvider = "createcustomer")
  public void f(String n, String s) {
  }

  @DataProvider
  public Object[][] createcustomer() {
    return new Object[][] {
      new Object[] { "Customer2", "Customer2_descr" },
      new Object[] { "Customer3", "Customer3_descr" },
      new Object[] { "Customer4", "Customer4_descr" },
      new Object[] { "Customer5", "Customer1_descr" },
    };
  }
  @DataProvider
  public Object [][] createproject(){
  return new Object[][]{
	   new Object[] { "Project1" ,"Customer1", "Customer1_descr" },
	      new Object[] {"Project2", "Customer2", "Customer2_descr" },
	      new Object[] {"Project3", "Customer3", "Customer3_descr" },
	      new Object[] {"Project4", "Customer4", "Customer4_descr" },
	      new Object[] { "Project5" ,"Customer5", "Customer1_descr" },
  
  };
  }
}

