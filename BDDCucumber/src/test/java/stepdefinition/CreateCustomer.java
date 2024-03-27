package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class CreateCustomer extends ActitimeUtil {

	@Given("user is on application login page")
	public void user_is_on_application_login_page() {
	    getdriver("edge");
	    launch("http://localhost:8080/login.do");
	    
	}

	@When("login with valid credentials")
	public void login_with_valid_credentials() {
		
		login("admin", "manager");
		
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		click("id", "loginButton");
	    
	}

	@Then("user click on task")
	public void user_click_on_task() {
	    getElement("xpath", "//a[contains(@href,'tasks')]").click();
	 
	    
	}

	@And("click on add new")
	public void click_on_add_new() {
	    clickOnAddNewButton();
	    
	    
	}

	@And("click on new customer")
	public void click_on_new_customer() {
	    newCustomer();
	    
	}

	@Then("user enter {} and {}")
	public void user_enter_customer01_and_customer01_des(String customername, String customerdescription) throws InterruptedException {
		Thread.sleep(2000);
	    type("xpath","//input[@id='customerLightBox_nameField']", customername);
	    type("xpath", "//textarea[@id='customerLightBox_descriptionField']", customerdescription);
	    
	}

	@And("click on create customer")
	public void click_on_create_customer() {
	    click("xpath", "//span[text()='Create Customer']");
	    
	    driver.close();
	    
}
}
