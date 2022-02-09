package automation.pages;

import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class QueuePageObjects extends BrowserFactory {

	public QueuePageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String validateQueuePage() {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	}

}
