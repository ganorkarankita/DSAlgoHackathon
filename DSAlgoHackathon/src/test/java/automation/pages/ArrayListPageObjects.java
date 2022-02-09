package automation.pages;

import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class ArrayListPageObjects extends BrowserFactory {

	public ArrayListPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String ArrayListPageValidation() {
		String ActURL = driver.getCurrentUrl();
		return ActURL;

	}

}
