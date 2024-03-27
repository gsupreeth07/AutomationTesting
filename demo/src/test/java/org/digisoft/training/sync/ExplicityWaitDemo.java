package org.digisoft.training.sync;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicityWaitDemo {
	@Test
	public void FormFill() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("E:\\DigiSoft\\demo\\html\\timeout.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		
		WebDriverWait wait = new WebDriverWait(driver, 4);
		driver.findElement(By.tagName("button")).click();
		
	//	System.out.println();
	
		
		//driver.close();

	}
}
