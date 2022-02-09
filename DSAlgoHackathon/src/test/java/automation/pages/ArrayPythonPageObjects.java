package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class ArrayPythonPageObjects extends BrowserFactory {

	@FindBy(xpath = "//a[contains(text(),'Arrays in Python')]")
	WebElement ArrayPython;
	@FindBy(xpath = "//a[contains(text(),'Array Using List')]")
	WebElement ArrayList;
	@FindBy(xpath = "//a[contains(text(),'Basic Operations in Lists')]")
	WebElement ArrayOpLists;
	@FindBy(xpath = "//a[contains(text(),'Application of Array')]")
	WebElement ArrayAppli;
	@FindBy(xpath = "//a[contains(text(),'Practice Questions')]")
	WebElement ArrayPracQue;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;
	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement ArrayTryHere;

	public ArrayPythonPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String validateArrayPythonPage() {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	}

	public ArrayPythonPageObjects ArrayInPythonValidation() {
		Action.click(driver, ArrayPython);
		return new ArrayPythonPageObjects();
	}

	public ArrayListPageObjects ArrayUsingListValidation() {
		Action.click(driver, ArrayList);
		return new ArrayListPageObjects();
	}

	public ArrayOpPageObjects BasicOperationListValidation() {
		Action.click(driver, ArrayOpLists);
		return new ArrayOpPageObjects();
	}

	public ArrayAppliPageObjects ArrayApplicationPage() {
		Action.click(driver, ArrayAppli);
		return new ArrayAppliPageObjects();
	}

	public ArrayPracQuePageObjects ArrayPracQue() {
		Action.click(driver, ArrayPracQue);
		return new ArrayPracQuePageObjects();
	}

	public EditorWindowObjects tryHere() {
		Action.click(driver, ArrayTryHere);
		return new EditorWindowObjects();
	}

	public StartUpPageObjects NN() {
		Action.click(driver, NN);
		return new StartUpPageObjects();
	}

}
