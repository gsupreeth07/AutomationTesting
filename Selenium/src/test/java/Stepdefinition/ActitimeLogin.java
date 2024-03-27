package Stepdefinition;

import java.util.concurrent.TimeUnit;

import org.Selenium.util.ActitimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeLogin extends ActitimeUtil{
	WebDriver driver;

	@Given("admin is on login page")
	public void admin_is_on_login_page() {
		getdriver("chrome");
		launch("http://localhost:8080/login.do");
		
	/*	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/login.do"); */

	}

	@When("user enter admin and manager")
	public void user_enter_admin_and_manager() {
		
		type("name", "username", "admin");
		type("name", "pwd", "manager");
		
		/* driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager"); */

	}

	@When("click on login")
	public void click_on_login() {
		
		loginbutton();
		pause(3000);
		// driver.findElement(By.id("loginButton")).click();

	}

	@Then("user is navigate to actitime page")
	public void user_is_navigate_to_actitime_page() {

		verifyHomepagetitle();
	}

	@When("user enter admi and password")
	public void user_enter_admi_and_password() {
		
		type("name", "username", "admi");
		type("name", "pwd", "manager");
		
	/*	driver.findElement(By.name("username")).sendKeys("admi");
		driver.findElement(By.name("pwd")).sendKeys("manager"); */

	}

	@Then("user get a warning messages")
	public void user_get_a_warning_messages() {
		verifyinvalid();
	}
	@When("user enter admin and passwor")
	public void user_enter_admin_and_passwor() {
		type("name", "username", "admin");
		type("name", "pwd", "manage");
		
	/*	driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manage");*/
		
	}

	@When("user not enter username and password")
	public void user_not_enter_username_and_password() {
		type("name", "username", " ");
		type("name", "pwd", " ");
		
	/*	driver.findElement(By.name("username")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("pwd")).sendKeys(Keys.ENTER);*/
	}


}
