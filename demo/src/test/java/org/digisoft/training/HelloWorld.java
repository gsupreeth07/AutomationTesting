package org.digisoft.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelloWorld {
	@Test
	public void FormFill() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/form");

		WebElement FirstName = driver.findElement(By.id("first-name"));
		FirstName.sendKeys("Supreeth");
		Thread.sleep(2000);

		WebElement LastName = driver.findElement(By.id("last-name"));
		LastName.sendKeys("g");
		Thread.sleep(2000);

		WebElement JobTitle = driver.findElement(By.id("job-title"));
		LastName.sendKeys("QA");

		WebElement Radio = driver.findElement(By.id("radio-button-1"));

		if (Radio.isDisplayed()) {
			if (!Radio.isSelected()) {
				Radio.click();
			}

			driver.findElement(By.xpath("//a[text()='Submit']")).click();

		}
		Thread.sleep(3000);
		WebElement Message = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			System.out.println("Result:"+Message);	
		driver.close();

	}
		
	
}
