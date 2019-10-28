package stepdefinition;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.DriverEngine;

public class LoginPage extends DriverEngine {
	
	

	@Given("I go to Login page")
	public void i_go_to_Login_page() {
		driver.get(ec.getObjects("loginurl"));
	}

	@When("I enter EmailId")
	public void i_enter_EmailId() {
	    driver.findElement(setLocatorType("email_id_field")).sendKeys(ec.getObjects("emailid"));
	}

	@When("I enter Password")
	public void i_enter_password() {
	    driver.findElement(setLocatorType("password_field")).sendKeys(ec.getObjects("password"));

	}

	@Then("I click on Login button")
	public void i_click_on_Login_button() {
	    driver.findElement(setLocatorType("submit_button")).click();
	}

	@Then("I verify successful login")
	public void i_verify_successful_login() {
		assertEquals(driver.findElement(setLocatorType("login_success")).getText().trim(), ec.getObjects("login_page_text"),"Login was not successful,please check..");
	}

}
