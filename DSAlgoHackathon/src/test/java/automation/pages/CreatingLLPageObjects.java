package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class CreatingLLPageObjects extends BrowserFactory {

	@FindBy(xpath = "//p[contains(text(),'Creating Linked LIst')]")
	WebElement Header;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement TryHere;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	public CreatingLLPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String validatingLLCreatingLLPage() {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
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
