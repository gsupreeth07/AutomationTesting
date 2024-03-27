package org.Selenium.test;

import java.util.List;

import org.Selenium.utils.ActitimeUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ATUsingTextFile extends ActitimeUtils {

	List<String> data = null;
	String customerName = null;
	String projectName = null;
	int rowCount = 0;

	@BeforeTest
	public void preSetup() {

		rowCount = readActitimeTestData().size();
		data = readActitimeTestData();
		getDriver(browser);
		launch(url);
		login(userName, password);

	}

	@Test(priority = 1)
	public void createcustomer() {
		goToModule("tasks");
		for (int i = 1; i < rowCount; i++) {
			System.out.println(data.get(0));
			customerName = data.get(i).split(" | ")[0];
			clickOnAddNewButton();
			createCustomerWithDetails(customerName);
		}

	}

	@Test(priority = 2)
	public void createproject() {
		// goToModule("tasks");
		for (int i = 1; i < rowCount; i++) {
			customerName = data.get(i).split(" | ")[0];
			projectName = data.get(i).split(" | ")[4];
			clickOnAddNewButton();
			createProjectWithDetails(customerName, projectName);
		}
	}

	@Test(priority = 3)
	public void deleteCustomer() {
//		goToModule("tasks");
		for (int i = 1; i <rowCount ; i++) {
			customerName = data.get(i).split(" | ")[0];
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

	@AfterTest
	public void cleanup() {
		logout();
		driver.close();
	}
}
