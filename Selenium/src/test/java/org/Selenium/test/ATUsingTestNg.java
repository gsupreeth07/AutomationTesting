package org.Selenium.test;

import java.util.Iterator;
import java.util.List;

import org.Selenium.utils.ActitimeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ATUsingTestNg extends ActitimeUtils {
@Parameters({"url","browser","userName","password","timeout"})
	@BeforeTest
	public void preSetup() {

		getDriver(browser);
		launch(url);
		login(userName, password);
		goToModule("tasks");
	}

//	@Test(priority = 1, dataProvider = "createcustomer", dataProviderClass = NewTest.class)
	public void createcustomer(String customerName, String customerDesc) {

		clickOnAddNewButton();
		createCustomerWithDetails(customerName);
	}

//	@Test(priority = 2, dataProvider = "createproject", dataProviderClass = NewTest.class)
	public void createproject(String projectName, String customerName, String customerDesc) {
		// goToModule("tasks");

		clickOnAddNewButton();
		createProjectWithDetails(customerName, projectName);
	}

//	@Test(priority = 3)
	public void deleteCustomer(String customerName) {
		// goToModule("tasks");

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
	
	@Test
	public void deleteAllCustomer() {
		List<WebElement> all = driver.findElements(By.xpath("//div[@class='unfilteredContainer']//div[@class='itemsContainer']"));
		for (WebElement a : all) {
			System.out.println(a);
		}
	}

	@AfterMethod
	public void postTestExecution(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenShot(result.getTestName());
		}
	}

	@AfterTest
	public void cleanup() {
		logout();
		driver.close();
	}
}
