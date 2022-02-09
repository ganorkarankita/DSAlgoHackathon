package automation.pages;

import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class GraphRepresentPageObjects extends BrowserFactory {

	public GraphRepresentPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String validateGraphRepresentationPage() {
		String ActURL = driver.getCurrentUrl();
		return ActURL;

	}
}
