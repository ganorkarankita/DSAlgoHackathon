package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.utility.BrowserFactory;

public class StackPracQuePageObjects extends BrowserFactory {

	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	public StackPracQuePageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String ValidatingStackPracticeQuePage() {
		String ActualURL = driver.getCurrentUrl();

		return ActualURL;
	}
}
