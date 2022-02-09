package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class DSIntroPageObjects extends BrowserFactory {

	@FindBy(xpath = "//a[@href='time-complexity']")
	WebElement DSIntroTime;

	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	@FindBy(xpath = "//a[@href='/logout']")
	WebElement SignOut;
	@FindBy(xpath = "//div[contains(text(),'Logged out successfully')]")
	WebElement LoggedOutMsg;

	public DSIntroPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public DSTimeComplexPageObjects TimeComplexity() {
		Action.click(driver, DSIntroTime);
		return new DSTimeComplexPageObjects();
	}

	public String ValidateHomePage() {
		String CurrentURL = driver.getCurrentUrl();
		return CurrentURL;
	}

	public StartUpPageObjects NN() {
		Action.click(driver, NN);
		return new StartUpPageObjects();
	}

	public HomePageObjects SignOutValiadtion() {
		Action.click(driver, SignOut);
		Action.isDisplayed(driver, LoggedOutMsg);
		return new HomePageObjects();
	}

}
