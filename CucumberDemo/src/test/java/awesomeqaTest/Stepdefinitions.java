package awesomeqaTest;

import static org.testng.Assert.assertEquals;

import awesomeqa.AwesomeQa;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinitions {
	
	AwesomeQa aq = new AwesomeQa();
	
	@Given("I am in login page of awesomeqa applicaton")

	public void I_am_in_login_page_of_awesomeqa_applicaton()
	{
		aq.launchWeb();
		System.out.println("I am in login page of awesomeqa applicaton");
		String expt = "Returning Customer";
		String act = aq.launchWeb();
		assertEquals(expt,act);
		
	}
	
    @When("I enter the username")  
	public void I_enter_the_username()
	{
    	aq.enterUsername("johndoe12345@gmail.com");
		System.out.println("I enter the username");
	}
    
    @When("I enter the password")  
	public void I_enter_the_password()
	{
    	aq.enterPassword("johndoe123");
		System.out.println("I enter the password");
	}
    @And("I click on login button")  
	public void I_click_on_login_button()
	{
    	aq.clickLogin();
    	System.out.println("I click on login button");
	}
    @Then("I am in my account details page")
    public void I_am_in_my_account_details_page()
    {
    	String expt = "My Account";
    	String act = aq.accountPage();
    	assertEquals(expt,act);
    	System.out.println("I am in my account details page");
    }
    
}