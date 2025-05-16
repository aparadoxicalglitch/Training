package loginDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loginDemo.LoginDemo;
import loginDemo.homePage;
import loginDemo.loginPage;

public class LoginDefinitionPOM {
	
	WebDriver wd = new ChromeDriver();
	loginPage lp = new loginPage(wd);
	homePage hp = new homePage(wd);
	
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		wd.get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("^User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username , String password) {
		lp.enterUsername(username);
		lp.enterPassword(password);
	}

	@And("Clicks on login button")
	public void clicks_on_login_button() {
		lp.clickLogin();
	}

	@Then("^Login should be (.*)$")
	public void login_should_be(String result) {
	    if (result.equalsIgnoreCase("success")) {
	        hp.verify();
	    } else if (result.equalsIgnoreCase("failure")) {
	        lp.invalid();
	    } else {
	        throw new IllegalArgumentException("Unknown result type: " + result);
	    }
	}

}