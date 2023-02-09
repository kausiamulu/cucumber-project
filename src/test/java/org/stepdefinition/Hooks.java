package org.stepdefinition;

import org.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	@Before(order=1)
	public void bfClass()
	{
		System.out.println("scenerio started");
		openChromeBrowser();
		toLaunchUrl("https://www.facebook.com/");
		maxWindow();
	}
	@Before(order=2)
	public void before1()
	{
		System.out.println("Scenerio1");
	}
	@Before(order=3)
	public void bef3()
	{
		System.out.println("scenerio 2");
	}
	@After(order=3)
	public void af2()
	{
		System.out.println("scenerio completion");
	}
	@After(order=2)
	public void afClass()
	{
		closeBrowser();
		System.out.println("Scenerio ended");
		
	}

}
