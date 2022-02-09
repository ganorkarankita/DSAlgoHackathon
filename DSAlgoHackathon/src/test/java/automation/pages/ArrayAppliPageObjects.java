package automation.pages;

import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class ArrayAppliPageObjects extends BrowserFactory {

	public ArrayAppliPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String ArrayOperationPageObjectsValidation() {
		String ActURL = driver.getCurrentUrl();
		return ActURL;

	}
}
