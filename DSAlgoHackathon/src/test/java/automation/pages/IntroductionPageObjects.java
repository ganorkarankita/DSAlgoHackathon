package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class IntroductionPageObjects extends BrowserFactory {

	@FindBy(xpath = "//p[contains(text(),'Introduction')]")
	WebElement Header;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement TryHere;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	public IntroductionPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String validatingLLIntroductionPage() {
		String ActUrl = driver.getCurrentUrl();
		return ActUrl;
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
