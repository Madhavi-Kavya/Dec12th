package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	@Given("^OPen The FireFox Browser$")
	public void OpenFireFoxBrowser()
	{
		System.out.println("Here we are Opening the FireFox Browser");
	}
	@When("^Enter Your Login Details$")
	public void EnterLoginDetails()
	{
		System.out.println("Here you are Supposed to enter UserName and Login");
	}
	@Then("^Reset the Details$")
	public void ResetDetails()
	{
		System.out.println("We are Resetting the details");
	}
	@And("^Count the Links$")
	public void CountLinks()
	{
		System.out.println("Count the Links In the Web Page");
	}

}
