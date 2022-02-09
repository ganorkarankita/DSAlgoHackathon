package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class RegistrationPageObjects extends BrowserFactory {

	// Webdriver driver;
	@FindBy(xpath = "//input[@name='username']")
	WebElement Rusername;
	@FindBy(xpath = "//input[@name='password1']")
	WebElement Rpassword1;
	@FindBy(xpath = "//input[@name='password2']")
	WebElement Rpassword2;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement Register;

	public RegistrationPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String validateRegisterPage() {
		String CurrentURL = driver.getCurrentUrl();

		return CurrentURL;
	}

	public HomePageObjects Registration(String username, String password1, String password2) {
		Action.type(Rusername, username);
		Action.type(Rpassword1, password1);
		Action.type(Rpassword2, password2);
		Action.click(driver, Register);

		return new HomePageObjects();

	}

}
