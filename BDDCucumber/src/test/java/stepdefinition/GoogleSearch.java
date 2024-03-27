package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GoogleSearch extends ActitimeUtil {

	
	@Given("user is on Google Homepage")
	public void user_is_on_google_homepage() {
		getdriver("chrome");
	    launch("https://www.google.com");
	    
	}

	@When("enter a {string} in searchBox")
	public void enter_a_in_search_box(String ors) {
		 type("name", "q", ors);
	    
	}

	@And("user print all the hyperlinks in google homepage")
	public void user_print_all_the_hyperlinks_in_google_homepage() {
	    
	    
	}
}
