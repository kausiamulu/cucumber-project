package org.pom;

import org.baseclass.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPojo extends BaseClass {
	public FbLoginPojo()
	{
		PageFactory.initElements(driver,this);
	}
@FindBy(id="email")
private WebElement userName;
@FindBy(name="pass")
private WebElement pwd;
@FindBy(xpath="//button[@name='login']")
private WebElement loginBtn;

public WebElement getUserName() {
	return userName;
}

public WebElement getPwd() {
	return pwd;
}
public WebElement getLoginBtn() {
	return loginBtn;
}
}
