package org.digisoft.training.Actatime;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Dragger extends ActitimeUtlits {
@Test
	public void demo() {
	getDriver("chrome");

	
	launch("https://jqueryui.com/draggable/");
	
	Actions a = new Actions(driver);
	
	
	driver.switchTo().frame(0);
	
	a.moveToElement(getElement("id", "draggable")).perform();
	a.clickAndHold();
	a.moveByOffset(100,0);
	
	
	
	
	}
}
