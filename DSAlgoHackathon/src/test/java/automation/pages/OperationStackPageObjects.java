package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class OperationStackPageObjects extends BrowserFactory {

	@FindBy(xpath = "//a[contains(text(),'Operations in Stack')]")
	WebElement OperationStack;
	@FindBy(xpath = "//a[contains(text(),'Implementation')]")
	WebElement Implement;
	@FindBy(xpath = "//a[contains(text(),'Applications')]")
	WebElement Application;
	@FindBy(xpath = "//a[contains(text(),'Practice Questions')]")
	WebElement StackPracQue;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;
	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement StackTryHere;

	public OperationStackPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String validateOperationStackPage() {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	}

	public EditorWindowObjects tryHere() {
		Action.click(driver, StackTryHere);
		return new EditorWindowObjects();
	}

	public StartUpPageObjects NN() {
		Action.click(driver, NN);
		return new StartUpPageObjects();
	}
}