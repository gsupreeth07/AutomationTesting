package Stepdefinition;

import static org.testng.Assert.assertEquals;

import java.security.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	WebDriver driver;
	
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    
	 WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost/supreeth/web/index.php/auth/login");
	 
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
	    
	   driver.findElement(By.name("username")).sendKeys("Admin");
	   driver.findElement(By.name("password")).sendKeys("Supreeth@123");
	}

	@When("click on login button")
	public void click_on_login_button() {
	    
	  driver.findElement(By.xpath("//button")).click();
	}

	@Then("user is navigate to homepage")
	public void user_is_navigate_to_homepage() {
		
	  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@When("user enter inavalid username and valid password")
	public void user_enter_inavalid_username_and_valid_password() {
		 driver.findElement(By.name("username")).sendKeys("Admi");
		   driver.findElement(By.name("password")).sendKeys("Supreeth@123");
	}

	@Then("user get a warning message")
	public void user_get_a_warning_message() {
	    Assert.assertEquals(driver.findElements(By.xpath("//p[text()='Invalid credentials']")), "Invalid credentials");
	}

	@When("user enter valid username and invalid password")
	public void user_enter_valid_username_and_invalid_password() {
		 driver.findElement(By.name("username")).sendKeys("Admin");
		   driver.findElement(By.name("password")).sendKeys("Supreeth@");
	}

	@When("user not enter username and possword")
	public void user_not_enter_username_and_possword() {
		driver.findElement(By.name("username")).sendKeys(Keys.ENTER);
		
		   driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	}


}
