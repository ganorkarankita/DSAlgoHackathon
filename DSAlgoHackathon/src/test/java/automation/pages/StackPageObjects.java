package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class StackPageObjects extends BrowserFactory {

	@FindBy(xpath = "//a[contains(text(),'Operations in Stack')]")
	WebElement OperationStack;
	@FindBy(xpath = "//a[contains(text(),'Implementation')]")
	WebElement Implement;
	@FindBy(xpath = "//a[contains(text(),'Applications')]")
	WebElement Application;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	public StackPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public OperationStackPageObjects OperationStack() {
		Action.click(driver, OperationStack);

		return new OperationStackPageObjects();
	}

	public StackImplementationObjects Implement() {
		Action.click(driver, Implement);

		return new StackImplementationObjects();
	}

	public StackAppliObjects Application() {
		Action.click(driver, Application);

		return new StackAppliObjects();
	}

	public String validateStackPage() {
		String CurrentUrl = driver.getCurrentUrl();

		return CurrentUrl;
	}

	public StartUpPageObjects NN() {
		Action.click(driver, NN);

		return new StartUpPageObjects();
	}
}
