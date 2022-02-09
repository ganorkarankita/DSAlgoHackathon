package automation.pages;

import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class StackAppliObjects extends BrowserFactory {

	public StackAppliObjects() {
		PageFactory.initElements(driver, this);

	}

	public String ValidateStackApplicationPage() {
		String PageTitle = driver.getTitle();

		return PageTitle;

	}

}
