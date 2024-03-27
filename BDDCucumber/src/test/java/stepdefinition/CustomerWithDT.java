package stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerWithDT extends ActitimeUtil {
	

@Given("user is on actitime login page")
public void user_is_on_actitime_login_page() {
	
	getdriver("chrome");
	
    launch("http://localhost:8080/login.do");
    
}

@When("login with valid username and password credentials")
public void login_with_valid_username_and_password_credentials() {
    
	login("admin", "manager");
}

@When("user click on login")
public void user_click_on_login() {
	click("id", "loginButton");

    
}

@Then("user click on task page")
public void user_click_on_task_page() {
	 getElement("xpath", "//a[contains(@href,'tasks')]").click();
    
}

@Then("click on add new in task page")
public void click_on_add_new_in_task_page() {
	 clickOnAddNewButton();
	 
	 
	 newCustomer();
}


@Then("user create new <customer> and <customerdes>")
public void user_create_new_customer_and_customerdes(DataTable dataTable) throws InterruptedException {
   Thread.sleep(3000);
	    List<Map<String, String>> data = dataTable.asMaps();
	   data.forEach(d -> {
		   type("id", "customerLightBox_nameField", d.get("customer"));
		   try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   type("id", "customerLightBox_descriptionField", d.get("customerdes"));
		   click("xpath", "//span[text()='Create Customer']");
		   clickOnAddNewButton();
			 newCustomer();
	   });
  click("xpath", "//div[@id='customerLightBoxCloseButton']");
  
}

@Then("click on  customer button")
public void click_on_customer_button() {
	 System.out.println("customer created successfully");
	 driver.close();
    
}

}
