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
import com.firstcry.utilities.ExcelReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class StepDefinitions {
    
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private StoreLocatorPage storeLocatorPage;
    private PreschoolLocatorPage preschoolLocatorPage;
    private Map<String, String> storeData;
    private Map<String, String> pincodeData;
    
    @Given("User launches the FirstCry application")
    public void user_launches_the_first_cry_application() throws IOException {
        System.out.println("Getting WebDriver from WebDriverManager...");
        driver = WebDriverManager.getDriver();
        if (driver == null) {
            throw new RuntimeException("WebDriver is null! Make sure Hooks are running properly.");
        }
        System.out.println("WebDriver obtained successfully: " + driver.getClass().getSimpleName());
        
        // Initialize HomePage first since we're now opening the main page
        homePage = new HomePage(driver);
        System.out.println("HomePage initialized successfully.");
        
        // Initialize Excel data here
        storeData = ExcelReader.getStoreData();
        pincodeData = ExcelReader.getPincodeData();
        System.out.println("Excel data loaded successfully.");
    }
    
    @And("User enters mobile number {string} and logs in")
    public void user_enters_mobile_number_and_logs_in(String mobileNumber) throws InterruptedException {
        // Navigate to login page first
        homePage.navigateToLogin();
        
        // Initialize LoginPage after navigating to it
        loginPage = new LoginPage(driver);
        
        loginPage.enterMobileNo(mobileNumber);
        loginPage.clickContinue();
        loginPage.submitOTP();
    }
    
    @When("User navigates to Store Locator page")
    public void user_navigates_to_store_locator_page() throws InterruptedException {
        homePage.hoverOverStoreAndPreschool();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        storeLocatorPage = new StoreLocatorPage(driver);
        String actualPageTitle = storeLocatorPage.verifyStorePage();
        Assert.assertEquals(actualPageTitle, "Store Locator", "Store Locator page not loaded correctly");
    }
    
    @And("User clicks on Search button without selecting dropdowns")
    public void user_clicks_on_search_button_without_selecting_dropdowns() {
        storeLocatorPage.clickSearch();
    }
    
    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedErrorMessage) {
        String actualErrorMessage;
        if (expectedErrorMessage.equals("Please Select Store Type")) {
            if (storeLocatorPage == null) throw new RuntimeException("Store Locator page is not initialized");
            actualErrorMessage = storeLocatorPage.verifyError();
        } else if (expectedErrorMessage.equals("Ooopss…")) {
            if (preschoolLocatorPage == null) throw new RuntimeException("Preschool Locator page is not initialized");
            actualErrorMessage = preschoolLocatorPage.verifyInvalidError();
        } else {
            throw new RuntimeException("Unexpected error message: " + expectedErrorMessage);
        }
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match expected");
        System.out.println("Error message verified: " + actualErrorMessage);
    }

    @And("User selects store type, state and city from Excel")
    public void user_selects_store_type_state_and_city_from_excel() {
        storeLocatorPage.selectStoreType(storeData.get("storeType"));
        storeLocatorPage.selectState(storeData.get("state"));
        storeLocatorPage.selectCity(storeData.get("city"));
        System.out.println("Selected store data: " + storeData.get("storeType") + ", " + 
                          storeData.get("state") + ", " + storeData.get("city"));
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

    @When("User navigates to Preschool Locator page")
    public void user_navigates_to_preschool_locator_page() throws InterruptedException {
        if (storeLocatorPage != null) {
            storeLocatorPage.hoverOverStoreAndPreschool();
        } else {
            homePage.hoverOverStoreAndPreschool();
        }
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        preschoolLocatorPage = new PreschoolLocatorPage(driver);
        String actualPageTitle = preschoolLocatorPage.verifyPreschoolLocator();
        Assert.assertEquals(actualPageTitle, "Preschool Locator", "Preschool Locator page not loaded correctly");
    }
    
    @And("User enters {string} pincode from Excel")
    public void user_enters_pincode_from_excel(String pincodeKey) {
        String pincode = pincodeData.get(pincodeKey);
        preschoolLocatorPage.enterPincode(pincode);
        preschoolLocatorPage.clickSubmit();
        System.out.println("Entered pincode: " + pincode + " (key: " + pincodeKey + ")");
    }
    
    @Then("Preschool information should be displayed")
    public void preschool_information_should_be_displayed() {
        String actualPreschoolInfo = preschoolLocatorPage.verifyPreschool();
        Assert.assertEquals(actualPreschoolInfo, "Preschools Near You", "Preschool info not displayed correctly");
        System.out.println("Preschool info displayed: " + actualPreschoolInfo);
    }

    @And("User refreshes the Preschool Locator page")
    public void user_refreshes_preschool_locator_page() {
        driver.navigate().refresh();
    }
}