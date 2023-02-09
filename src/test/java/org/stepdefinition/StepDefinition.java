package org.stepdefinition;

import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.pom.FbForgotPojo;
import org.pom.FbLoginPojo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	FbLoginPojo f;
	FbForgotPojo p;
	@Given("User have to enter login page")
	public void user_have_to_enter_login_page() {
	    
	}

	@Given("User have to click the forgotten password")
	public void user_have_to_click_the_forgotten_password() {
		 p= new FbForgotPojo();
		WebElement forgotlink =p.getForgotPwd();
		toClickButton(forgotlink);  
	}

	@When("User have to enter mailid")
	public void user_have_to_enter_mailid(DataTable t) {
		p= new FbForgotPojo();
		
		List <String> li= t.asList();
		WebElement mailTxt=p.getMailAddr();
	fillTextBox(mailTxt, li.get(1));
	    
	}

	@When("User have to click the search button")
	public void user_have_to_click_the_search_button() {
		p=new FbForgotPojo();
		WebElement searchBtn=p.getSearch();
		toClickButton(searchBtn);
	   
	}

	@Then("it should navigate to reset password page")
	public void it_should_navigate_to_reset_password_page() {
	   
	}

	@Given("User have to maximize the window")
	public void user_have_to_maximize_the_window() {
	   
	}

	@When("User have to enter emailid and password")
	public void user_have_to_enter_emailid_and_password(DataTable d) {
		List<List<String>> lt=d.asLists();
		
		f= new FbLoginPojo();
		WebElement userTxt=f.getUserName();
		fillTextBox(userTxt,lt.get(1).get(3));
		WebElement pwdTxt=f.getPwd();
		fillTextBox(pwdTxt,lt.get(2).get(1));
	    
	}

		
	

	@When("User have to click login button")
	public void user_have_to_click_login_button() {
	   f = new FbLoginPojo();
		WebElement lgnTxt= f.getLoginBtn();
		toClickButton(lgnTxt);
	    
	}

	@Then("User have to be in invalid credentials page")
	public void user_have_to_be_in_invalid_credentials_page() {
	String s=toFetchUrl();
	if (s.contains("privacy_mutation_token"))
	{
	  System.out.println("invalid credential");  
	}
	else
	{
		System.out.println("valid credential");
	}

	}
	
	
}
	