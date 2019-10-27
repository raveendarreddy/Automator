package stepdefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.DriverEngine;

public class HomePage extends DriverEngine
{
	
	@Given("^I Start the application$")
	public void start_the_application() throws Throwable 
	{
		driver.get(ec.getObjects("url"));
	}

	@When("^I click on Bank project page$")
	public void google_search_button_visibility_on_home_page_something() throws Throwable 
	{
		driver.findElement(By.linkText(ec.getObjects("bank_project_page"))).click();
	} 
	@Then("^I verify the title of the web page$")
	public void verify_Title_Of_Page() throws Throwable 
	{
		
		assertEquals(driver.getTitle().trim(), ec.getObjects("bank_broject_title"),"Title is not matching..");  
 
	} 

}
