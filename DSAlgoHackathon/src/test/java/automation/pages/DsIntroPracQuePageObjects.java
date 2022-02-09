package automation.pages;

import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class DsIntroPracQuePageObjects extends BrowserFactory {

	public DsIntroPracQuePageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String DSIntroPracQuePage() {
		String ActURL = driver.getCurrentUrl();
		return ActURL;
	}

}
