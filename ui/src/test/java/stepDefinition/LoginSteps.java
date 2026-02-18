package stepDefinition;

import Drivers.PlaywrightInstanceProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("the website is opened")
    public void the_website_is_opened() {
        PlaywrightInstanceProvider.getInstance().getPage().navigate("https://www.saucedemo.com/");
        System.out.println("Step 0: Website is opened");
    }

    @And("the user enter username")
    public void the_user_enter_username() {
        PlaywrightInstanceProvider.getInstance().getPage().locator(loginPage.UsernameField).fill("standard_user");
        System.out.println("Step 2: The user enter username");
    }

    @And("the user enter password")
    public void the_user_enter_password() {
        System.out.println("Step 3: The user enter password");
    }

    @Then("Click the login button")
    public void Click_the_login_button() {
        System.out.println("Step 4: Click the login button");
    }

}



