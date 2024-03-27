package org.Selenium.util;

import org.openqa.selenium.By;

import junit.framework.Assert;

public class ActitimeUtil extends WebdriverUtil {

	public void launch(String url) {
		System.out.println("launching the application");
		driver.get(url);
	}

	public void login(String name, String password) {
		type("id", "name", name);
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

	public void verifyinvalid() {
		String text = driver
				.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
		Assert.assertEquals(text, "Username or Password is invalid. Please try again.");
		driver.close();
	}

}
