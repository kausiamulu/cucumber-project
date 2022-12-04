package org.stepdefinition;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.pom.FbForgotPojo;
import org.pom.FbLoginPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	FbLoginPojo l;
	FbForgotPojo p;
	
	@Given("User have to enter login page")
	public void user_have_to_enter_login_page() {
		openChromeBrowser();
		toLaunchUrl("https://www.facebook.com/");
		maxWindow();
		
	    
	}

	@When("User have to enter valid email and invalid password")
	public void user_have_to_enter_valid_email_and_invalid_password() throws IOException {
		 l= new FbLoginPojo();
		WebElement userText=l.getUserName();
		fillTextBox(userText,readDataFromExcel("Login",1,0));
		WebElement txtPwd=l.getPwd();
		fillTextBox(txtPwd, readDataFromExcel("Login",1,1));
	    
	}

	@When("User have to click login button")
	public void user_have_to_click_login_button() {
	
	l= new FbLoginPojo();
	WebElement btn=l.getLoginBtn();
	toClickButton(btn);
	}
    
	@Then("User have to be in invalid credentials page")
	public void user_have_to_be_in_invalid_credentials_page()  {
		
		String url= toFetchUrl();
		if(url.contains("privacy_mutation_token"))
		{
		System.out.println("invalid credential");
		}
		else
		{
			System.out.println("valid credential");
		}
		
		
		
	}

@When("User have to enter invalid email and valid password")
		public void user_have_to_enter_invalid_email_and_valid_password() {
	
	l= new FbLoginPojo();
	WebElement userText=l.getUserName();
	fillTextBox(userText,"nanthukaus@gmail.com");
	WebElement txtPwd=l.getPwd();
	fillTextBox(txtPwd,"nanthu@123");
		   
		}

@Then("User have to be in invalid credential page")
public void user_have_to_be_in_invalid_credential_page() {
	
	String t= toFetchUrl();
	if(t.contains("privacy_mutation_token"))
	{
	System.out.println("invalid credential");
	}
	else
	{
		System.out.println("valid credential");
	}
	
    
}	

@Given("User have to click the forgotten password")
public void user_have_to_click_the_forgotten_password() {
	 p= new FbForgotPojo();
	 WebElement forgotPwd=p.getForgotPwd();
	 toClickButton(forgotPwd);
}

@When("User have to enter mailid")
public void user_have_to_enter_mailid() {
	p= new FbForgotPojo();
	WebElement mailText=p.getMailAddr();
	fillTextBox(mailText,"kausalya1990@gmail.com");   
}

@When("User have to click the search button")
public void user_have_to_click_the_search_button() {
	p= new FbForgotPojo();
	WebElement searchBtn=p.getSearch();
	toClickButton(searchBtn);
    
}

@Then("it should navigate to reset password page")
public void it_should_navigate_to_reset_password_page() {
	
   System.out.println("navigate to reset password page");
}







}
