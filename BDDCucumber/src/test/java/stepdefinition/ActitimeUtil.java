package stepdefinition;

import org.openqa.selenium.By;

import junit.framework.Assert;

public class ActitimeUtil extends WebdriverUtil {

	public void launch(String url) {
		System.out.println("launching the application");
		driver.get(url);
	}

	public void login(String name, String password) {
		type("id", "username", name);
		type("name", "pwd", password);

	}

	public void loginbutton() {
		click("id", "loginButton");
	}

	public void pause(int ms) {
		System.out.println("application got pause for " + ms);

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void verifyHomepagetitle() {
		Assert.assertEquals("actiTIME - Enter Time-Track", "actiTIME - Enter Time-Track");
		driver.close();
	}

	
	public void clickOnAddNewButton() {
		click("xpath", "//div[text()='Add New']");
		
	}

	public void newCustomer() {
		click("xpath", "//div[@class='item createNewCustomer ellipsis']");
		
	//	Assert.assertEquals("//span[text()='Create New Customer']", "Create New Customer");
	}

}
