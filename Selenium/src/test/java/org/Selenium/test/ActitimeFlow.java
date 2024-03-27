package org.Selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeFlow {
	static WebDriver driver;

	String customerName = null;
	String projectName = null;
	@BeforeTest
	public void login() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver",
//				"drivers/chromedriver.exe");
//		driver = new ChromeDriver();
		
		customerName = new Faker().name().firstName(); 
		projectName = new Faker().company().name();
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();

		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		Thread.sleep(5000);
		
	}

	@Test(priority = 1)
	public void createcustomer() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//a[contains(@href,'tasklist.do')]"))));
		if(element.isDisplayed() && element.isEnabled())
			element.click();
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[@class='item createNewCustomer ellipsis']")).click();
		driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder']")).sendKeys(customerName);
		driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
		System.out.println("Waiting for the visibility of success msg");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toasts']//span"))));
		
		System.out.println("Waiting for the In-visibility of success msg");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toasts']//span"))));
		
	
	
	
	}

	@Test(priority = 2)
	public void createproject() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.xpath("//div[@id='cpTreeBlock']//div[@class='addNewButton']")).click();
		driver.findElement(By.xpath("//div[@class='item createNewProject ellipsis']")).click();
		driver.findElement(By.xpath("//input[@id='projectPopup_projectNameField']"))
				.sendKeys(projectName);
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(
				By.xpath("//div[@class='node customerNode notSelected']//div[@class='editButton available']")).click();
	
		System.out.println("Waiting for the visibility of success msg");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toasts']//span"))));
		
		System.out.println("Waiting for the In-visibility of success msg");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toasts']//span"))));
		Thread.sleep(5000);
	
	}

	//@Test(priority = 3)
	public void deletecustomerproject() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.xpath("//div[@class='headerBlock']//div[@class='actionButton']")).click();
		driver.findElement(By.xpath("//div[@class='dropdownContainer actionsMenu']//div[text()='Delete']")).click();
		driver.findElement(By.xpath("//div[@class='buttonIcon']//span[text()='Delete permanently']")).click();
		
		
		System.out.println("Waiting for the visibility of success msg");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toasts']//span"))));
		
		System.out.println("Waiting for the In-visibility of success msg");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toasts']//span"))));
		

	}
	
	@AfterTest
	public void cleanup()
	{
		driver.close();
	}
}
