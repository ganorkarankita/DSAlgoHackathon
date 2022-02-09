package automation.pages;

import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class TreePageObjects extends BrowserFactory {

	public TreePageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String validateTreePage() {
		String CurrentUrl = driver.getCurrentUrl();

		return CurrentUrl;
	}
}
