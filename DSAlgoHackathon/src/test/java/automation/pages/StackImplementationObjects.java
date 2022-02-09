package automation.pages;

import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class StackImplementationObjects extends BrowserFactory {

	public StackImplementationObjects() {
		PageFactory.initElements(driver, this);

	}

	public String ValidateStackImplePage() {
		String PageTitle = driver.getTitle();

		return PageTitle;

	}
}
