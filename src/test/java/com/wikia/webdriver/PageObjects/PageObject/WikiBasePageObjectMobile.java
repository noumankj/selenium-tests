package com.wikia.webdriver.PageObjects.PageObject;

import org.openqa.selenium.WebDriver;

public class WikiBasePageObjectMobile extends BasePageObject{
	
	public WikiBasePageObjectMobile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	public void openHomePage()
	{
		executeScript("");
		driver.get("http://mediawiki119.wikia.com/wiki/Formatting?useskin=wikiamobile");
	}
	

}
