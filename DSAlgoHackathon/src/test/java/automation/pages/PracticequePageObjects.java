package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class PracticequePageObjects extends BrowserFactory {

	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	public PracticequePageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String ValidatingPracticeQuePage() {
		String ActualURL = driver.getCurrentUrl();
		return ActualURL;
	}

	public StartUpPageObjects NN() {
		Action.click(driver, NN);
		return new StartUpPageObjects();
	}
}
