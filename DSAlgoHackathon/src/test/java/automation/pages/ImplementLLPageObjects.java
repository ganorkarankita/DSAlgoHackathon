package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class ImplementLLPageObjects extends BrowserFactory {

	@FindBy(xpath = "//p[contains(text(),'Implement Linked List in Python')]")
	WebElement Header;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement TryHere;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	public ImplementLLPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String validatingImplementationOfLLPage() {
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
