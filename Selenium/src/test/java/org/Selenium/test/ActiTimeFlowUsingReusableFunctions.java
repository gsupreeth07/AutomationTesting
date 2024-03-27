package org.Selenium.test;

import org.Selenium.utils.ActitimeUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class ActiTimeFlowUsingReusableFunctions extends ActitimeUtils {

	String customerName = null;
	String projectName = null;
	
	@BeforeTest
	public void preSetup()
	{
		customerName = new Faker().name().firstName(); 
		projectName = new Faker().company().name();
		
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		getDriver("ff");
		launch("http://localhost/login.do");
		login("admin", "manager");
	}

	@Test(priority = 1)
	public void createcustomer() {
		goToModule("tasks");
		clickOnAddNewButton();
		createCustomerWithDetails(customerName);
	}

	
	@Test(priority = 2)
	public void createproject() {
		goToModule("tasks");
		clickOnAddNewButton();
		createProjectWithDetails(customerName, projectName);
	}
	
	//@Test(priority = 3)
	public void deleteCustomer() {
		goToModule("tasks");
		type("xpath", "//div[@id='cpTreeBlock']//input[contains(@placeholder, 'name')]", customerName);
		
		Actions act = new Actions(driver);
		act.moveToElement(getElement("xpath", "//div[@class='itemsContainer']//span[text()='"+customerName+"']")).perform();
		pauseExecution(2000);
		click("xpath", "//div[@class='itemsContainer']//span[text()='"+customerName+"']/parent::div/following-sibling::div");
		pauseExecution(2000);
		click("xpath","//div[@class='customerNamePlaceHolder']/following-sibling::div");
		
		click("xpath","//div[contains(@class,'edit_customer_sliding')]//div[@class='deleteButton']");
		click("id", "customerPanel_deleteConfirm_submitTitle");
		waitForSuccessMsgToComplete();
		
	}
	
	@AfterMethod
	public void cleanup()
	{
		logout();
		driver.close();
	}
}
