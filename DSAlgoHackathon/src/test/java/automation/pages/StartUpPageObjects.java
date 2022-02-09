package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class StartUpPageObjects extends BrowserFactory {
	// Webdriver driver;

	// Definig Webelements

	@FindBy(xpath = "//button[contains(text(),'Get Started')]")
	WebElement getStarted;

	// Creating constructor
	public StartUpPageObjects() {
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(driver, this);
	}

	// perform action

	public String ValidateURL() {
		String URLofStartUpPage = driver.getCurrentUrl();
		return URLofStartUpPage;
	}

	public HomePageObjects ClickGetstarted() {
		Action.click(driver, getStarted);
		return new HomePageObjects();

	}

	public String getTitle() {
		String StartUpPageTitle = driver.getTitle();
		return StartUpPageTitle;
	}

}
