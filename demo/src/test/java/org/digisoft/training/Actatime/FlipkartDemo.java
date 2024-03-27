package org.digisoft.training.Actatime;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FlipkartDemo extends ActitimeUtlits{
@Test
	public void suggestion() {
		getDriver("chrome");
		launch("https://www.flipkart.com/");
		
		Actions a = new Actions(driver);
		
		WebElement fashion = getElement("xpath", "//div[@aria-label='Fashion']");
		
		a.moveToElement(fashion).perform();
		
		 List<WebElement> sugesstion = Elements("xpath", "//object");
		 
		 for (WebElement webElement : sugesstion) {
			System.out.println(webElement);
		}
	}
}

