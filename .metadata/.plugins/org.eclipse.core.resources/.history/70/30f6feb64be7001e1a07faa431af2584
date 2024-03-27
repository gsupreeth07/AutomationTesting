package stepdefinition;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Googl extends ActitimeUtil {
	
	@Given("user is on Google page")
	public void user_is_on_google_page() {
	    getdriver("chrome");
	    launch("https://www.google.com");
	    
	}

	@When("user enter {} in searchBox")
	public void user_enter_in_search_box(String org) {
	   type("name", "q", org);
	}

	@And("click on Search button")
	public void click_on_search_button() {
	    click("name", "btnK");
	    
	}

	@Then("user Navigate to results page")
	public void user_navigate_to_results_page() {
	    int count = getElements("tagname", "h3").size();
	    System.out.println("total result : "+count );
	    
	}

	@And("user print all the hyperlinks")
	public void user_print_all_the_hyperlinks() {
		  List<WebElement> link = getElements("tagname", "h3");
		  link.forEach(e -> System.out.println(e.getText()));
		  
		  driver.close();
	    
	}
}


