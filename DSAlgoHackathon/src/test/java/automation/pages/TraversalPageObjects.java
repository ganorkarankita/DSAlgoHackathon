package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class TraversalPageObjects extends BrowserFactory {

	@FindBy(xpath = "//p[contains(text(),'Traversal')]")
	WebElement Header;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement TryHere;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	public TraversalPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String validatingTrversalPage() {
		String CurrentURL = driver.getCurrentUrl();

		return CurrentURL;
	}

	public EditorWindowObjects tryHere() {
		Action.click(driver, TryHere);

		return new EditorWindowObjects();
	}

	public StartUpPageObjects NN() {
		Action.click(driver, NN);

		return new StartUpPageObjects();
	}
}
