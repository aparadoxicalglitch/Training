package com.firstcry.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.firstcry.base.WebDriverManager;
import com.fristcry.pages.HomePage;
import com.fristcry.pages.LoginPage;
import com.fristcry.pages.PreschoolLocatorPage;
import com.fristcry.pages.StoreLocatorPage;

import java.util.ArrayList;

public class StepDefinitions {
    
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private StoreLocatorPage storeLocatorPage;
    private PreschoolLocatorPage preschoolLocatorPage;
    
    @Given("User launches the FirstCry application")
    public void user_launches_the_first_cry_application() {
        System.out.println("Getting WebDriver from WebDriverManager...");
        driver = WebDriverManager.getDriver();
        if (driver == null) {
            throw new RuntimeException("WebDriver is null! Make sure Hooks are running properly.");
        }
        System.out.println("WebDriver obtained successfully: " + driver.getClass().getSimpleName());
        loginPage = new LoginPage(driver);
        System.out.println("LoginPage initialized successfully.");
    }
    
    @And("User enters mobile number {string} and logs in")
    public void user_enters_mobile_number_and_logs_in(String mobileNumber) throws InterruptedException {
        loginPage.enterMobileNo(mobileNumber);
        loginPage.clickContinue();
        loginPage.submitOTP();
        homePage = new HomePage(driver);
    }
    
    @When("User navigates to Store Locator page")
    public void user_navigates_to_store_locator_page() throws InterruptedException {
        homePage.hoverOverStoreAndPreschool();
        
        // Switch to Store Locator tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        
        storeLocatorPage = new StoreLocatorPage(driver);
        
        // Verify Store Locator page is loaded
        String actualPageTitle = storeLocatorPage.verifyStorePage();
        Assert.assertEquals(actualPageTitle, "Store Locator", "Store Locator page not loaded correctly");
    }
    
    @And("User selects store type {string}, state {string} and city {string}")
    public void user_selects_store_type_state_and_city(String storeType, String state, String city) {
        storeLocatorPage.selectStoreType(storeType);
        storeLocatorPage.selectState(state);
        storeLocatorPage.selectCity(city);
    }
    
    @And("User clicks on Search button")
    public void user_clicks_on_search_button() {
        storeLocatorPage.clickSearch();
    }
    
    @Then("Store name should be displayed")
    public void store_name_should_be_displayed() {
        String actualStoreName = storeLocatorPage.verifyStore();
        Assert.assertNotNull(actualStoreName, "Store name is not displayed");
        Assert.assertFalse(actualStoreName.trim().isEmpty(), "Store name is empty");
        System.out.println("Store found: " + actualStoreName);
    }
    
    @And("User clicks on Search button without selecting dropdowns")
    public void user_clicks_on_search_button_without_selecting_dropdowns() {
        storeLocatorPage.clickSearch();
    }
    
    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedErrorMessage) {
        String actualErrorMessage;
        

        if (expectedErrorMessage.equals("Please Select Store Type")) {

            if (storeLocatorPage == null) {
                throw new RuntimeException("Store Locator page is not initialized");
            }
            actualErrorMessage = storeLocatorPage.verifyError();
        } else if (expectedErrorMessage.equals("Ooopss…")) {
 
            if (preschoolLocatorPage == null) {
                throw new RuntimeException("Preschool Locator page is not initialized");
            }
            actualErrorMessage = preschoolLocatorPage.verifyInvalidError();
        } else {
            throw new RuntimeException("Unexpected error message: " + expectedErrorMessage);
        }
        
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, 
            "Error message does not match expected message");
        System.out.println("Error message verified: " + actualErrorMessage);
    }
    
    @When("User navigates to Preschool Locator page")
    public void user_navigates_to_preschool_locator_page() throws InterruptedException {

        if (storeLocatorPage != null) {
            storeLocatorPage.hoverOverStoreAndPreschool();
        } else {

            homePage.hoverOverStoreAndPreschool();
        }
        

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.switchTo().window(tabs.get(2));
        
        preschoolLocatorPage = new PreschoolLocatorPage(driver);
        

        String actualPageTitle = preschoolLocatorPage.verifyPreschoolLocator();
        Assert.assertEquals(actualPageTitle, "Preschool Locator", "Preschool Locator page not loaded correctly");
    }
    
    @And("User enters pincode {string}")
    public void user_enters_pincode(String pincode) {
        preschoolLocatorPage.enterPincode(pincode);
        preschoolLocatorPage.clickSubmit();
    }
    
    @Then("Preschool information should be displayed")
    public void preschool_information_should_be_displayed() {
        String actualPreschoolInfo = preschoolLocatorPage.verifyPreschool();
        Assert.assertEquals(actualPreschoolInfo, "Preschools Near You", 
            "Preschool information is not displayed correctly");
        System.out.println("Preschool information displayed: " + actualPreschoolInfo);
    }
}