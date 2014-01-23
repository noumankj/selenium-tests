package com.wikia.webdriver.PageObjectsFactory.PageObject.Mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wikia.webdriver.Common.Core.Assertion;

public class MobileEditModePageObject extends MobileBasePageObject {

	public MobileEditModePageObject(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="textarea")
	private WebElement textArea;
	@FindBy(css="#wkMainCntHdr > h1")
	private WebElement selectedPageHeader;
	@FindBy(css="#wkMobileCancel")
	private WebElement editCancelButton;
	@FindBy(css="#wkPreview")
	private WebElement editPreviewButton;

	public void verifyEditModeContent(String text) {
		Assertion.assertStringContains(textArea.getText(), text);
	}
	
	public MobileArticlePageObject clickCancel() {
		editCancelButton.click();
		return new MobileArticlePageObject(driver);
	}
	
	public String getHeader(){
		return selectedPageHeader.getText();
	}
	
	public MobileEditPreviewPageObject clickPreview() {
		editPreviewButton.click();
		return new MobileEditPreviewPageObject(driver);
	}
}
