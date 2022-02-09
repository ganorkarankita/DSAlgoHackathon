package automation.pages;

import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class GrapParcQuePageObjects extends BrowserFactory {

	public GrapParcQuePageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String validateGraphPracQuePage() {
		String ActURL = driver.getCurrentUrl();
		return ActURL;

	}
}
