package org.digisoft.training.Switchto;

import java.util.Iterator;
import java.util.Set;

import org.digisoft.training.Actatime.ActitimeUtlits;
import org.testng.annotations.Test;

public class HandlingFramedemo extends ActitimeUtlits{
	@Test
	public void multiWindow() {
		getDriver("edge");
		launch("https://www.w3schools.com/");
		
		click("linktext", "HTML");
		
		click("linktext","HTML Basic");
		
		click("linktext","Try it Yourself »");
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		Iterator<String> i = windowIDs.iterator();
		
		String parentWindow = i.next();
		String childWindow = i.next();
		
		driver.switchTo().window(childWindow);
		
		driver.switchTo().frame(getElement("id", "iframeResult"));
		
		getText("tagname", "h1");
		getText("tagname", "p");
		
		
		
		
		
	}

}
