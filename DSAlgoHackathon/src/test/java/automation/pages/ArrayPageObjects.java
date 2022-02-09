package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class ArrayPageObjects extends BrowserFactory {

	@FindBy(xpath = "//a[contains(text(),'Arrays in Python')]")
	WebElement ArrayinPython;
	@FindBy(xpath = "//a[contains(text(),'Arrays Using List')]")
	WebElement ArrayList;
	@FindBy(xpath = "//a[contains(text(),'Basic Operations in Lists')]")
	WebElement ArrayOpLists;
	@FindBy(xpath = "//a[contains(text(),'Applications of Array')]")
	WebElement ArrayAppli;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	public ArrayPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public ArrayPythonPageObjects ArrayinPython() {
		Action.click(driver, ArrayinPython);
		return new ArrayPythonPageObjects();
	}

	public ArrayListPageObjects ArrayUsingList() {
		Action.click(driver, ArrayList);
		return new ArrayListPageObjects();
	}

	public ArrayOpPageObjects BasicOperationinLists() {
		Action.click(driver, ArrayOpLists);
		return new ArrayOpPageObjects();
	}

	public ArrayAppliPageObjects ApplicationofArray() {
		Action.click(driver, ArrayAppli);
		return new ArrayAppliPageObjects();
	}

	public String validateArrayPage() {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	}

	public StartUpPageObjects NN() {
		Action.click(driver, NN);
		return new StartUpPageObjects();
	}

}
