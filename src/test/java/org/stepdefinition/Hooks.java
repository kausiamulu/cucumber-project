package org.stepdefinition;

import org.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	@Before
	public void bfClass()
	{
		System.out.println("scenerio started");
		openChromeBrowser();
		toLaunchUrl("https://www.facebook.com/");
		maxWindow();
	}
	@After
	public void afClass()
	{
		closeBrowser();
		System.out.println("Scenerio ended");
		
	}

}
