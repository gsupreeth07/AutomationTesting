package org.digisoft.training;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {

	@BeforeClass
	public void beforeclass() {
		System.out.println("beforcalss");
	}
	@BeforeTest
	public void beforec() {
		System.out.println("befortest");
	}
	
	@AfterTest
	public void aferct() {
		System.out.println("aftertest");
	}
	@AfterClass
	public void aferclass() {
		System.out.println("afterclass");
	}
	@Test(priority = 1)
	public void test1() {
		System.out.println("test1");
	}
	//@Test
	public void test2() {
		System.out.println("test2");
	}
//	@Test
	public void test3() {
		System.out.println("test3");
	}
	@AfterMethod
	public void aftermethod2() {
		System.out.println("aftermethod2");
	}
	@AfterMethod()
	public void aftermethod() {
		System.out.println("aftermethod1");
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("beforemethod");
	}
}
