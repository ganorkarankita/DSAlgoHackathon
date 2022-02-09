package automation.pages;

import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class ArrayPracQuePageObjects extends BrowserFactory {

	public ArrayPracQuePageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String validateArrayPracQue() {
		String ActURL = driver.getCurrentUrl();
		return ActURL;

	}
}
