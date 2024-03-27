package org.Selenium.utils;

import org.testng.Assert;

public class FormyUtils extends ActitimeUtils
{

	public void selectComponent(String name) {
		
		click("id", "navbarDropdownMenuLink");
		verifyElementisVisible("xpath", "//div[@aria-labelledby='navbarDropdownMenuLink']");
		click("xpath", "//a[text()='" + name + "']");
		verifyElementisVisible("xpath", "//h1[text()='" + name + "']");
		Assert.assertEquals(name, getText("tagname", "h1"));
	}
}
