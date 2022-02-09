package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class SignInPageObjects extends BrowserFactory {

	@FindBy(name = "username")
	WebElement UserName;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement Login;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement LoginPU;
	@FindBy(xpath = "//a[@href='linked-list']")
	WebElement Register;
	// @FindBy(xpath = "//div[contains(text(),'You are logged in')]")
	// WebElement loggedinmsg;

	public SignInPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public HomePageObjects Login(String username, String password) {
		Action.type(UserName, username);
		Action.type(Password, password);
		Action.click(driver, Login);

		return new HomePageObjects();

	}

	public RegistrationPageObjects Register() {
		Action.click(driver, Register);

		return new RegistrationPageObjects();
	}

	public String ValidateSignInPage() {
		String CurrentURL = driver.getCurrentUrl();

		return CurrentURL;
	}

}
