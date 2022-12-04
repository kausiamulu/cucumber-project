package org.pom;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbForgotPojo extends BaseClass {
	public FbForgotPojo()
	{
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement forgotPwd;
	public WebElement getForgotPwd() {
		return forgotPwd;
	}
    @FindBy(xpath="//input[@type='text']") 
	private WebElement mailAddr;
	public WebElement getMailAddr() {
		return mailAddr;
	}
  @FindBy(xpath="//button[text()='Search']")
  private WebElement search;
public WebElement getSearch() {
	return search;
}
   
}
