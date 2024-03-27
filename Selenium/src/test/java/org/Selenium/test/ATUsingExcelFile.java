package org.Selenium.test;
import java.util.List;

import org.Selenium.utils.ActitimeUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ATUsingExcelFile extends ActitimeUtils {

	List<String> data = null;
	String customerName = null;
	String projectName = null;
	int rowCount = 0;
	String sheetName = "CreateProject";
	

	@BeforeTest
	public void preSetup() {

		rowCount = rowCount(sheetName);
		
		getDriver(browser);
		launch(url);
		login(userName, password);

	}

	@Test(priority = 1)
	public void createcustomer() {
		goToModule("tasks");
		for (int i = 1; i < rowCount; i++) {
			
			customerName = getMyCellValue(sheetName, i, 0);
			clickOnAddNewButton();
			createCustomerWithDetails(customerName);
		}

	}

	@Test(priority = 2)
	public void createproject() {
		// goToModule("tasks");
		for (int i = 1; i < rowCount; i++) {
			customerName = getMyCellValue(sheetName, i, 0);
			projectName = getMyCellValue(sheetName, i, 1);
			clickOnAddNewButton();
			createProjectWithDetails(customerName, projectName);
		}
	}

	@Test(priority = 3)
	public void deleteCustomer() {
//		goToModule("tasks");
		for (int i = 1; i <rowCount ; i++) {
			customerName = getMyCellValue(sheetName, i, 0);
			type("xpath", "//div[@id='cpTreeBlock']//input[contains(@placeholder, 'name')]", customerName);

			Actions act = new Actions(driver);
			act.moveToElement(getElement("xpath", "//div[@class='itemsContainer']//span[text()='" + customerName + "']"))
					.perform();
			pauseExecution(2000);
			click("xpath", "//div[@class='itemsContainer']//span[text()='" + customerName
					+ "']/parent::div/following-sibling::div");
			pauseExecution(2000);
			click("xpath", "//div[@class='customerNamePlaceHolder']/following-sibling::div");

			click("xpath", "//div[contains(@class,'edit_customer_sliding')]//div[@class='deleteButton']");
			click("id", "customerPanel_deleteConfirm_submitTitle");
			waitForSuccessMsgToComplete();
			
		}
	
	}

	@AfterMethod
	public void postTestExecution(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			takeScreenShot(result.getTestName());
		}
	}
	@AfterTest
	public void cleanup() {
		logout();
		driver.close();
	}
}
