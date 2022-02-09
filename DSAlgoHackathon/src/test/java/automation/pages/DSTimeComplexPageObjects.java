package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class DSTimeComplexPageObjects extends BrowserFactory {

	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement TryHere;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;
	@FindBy(xpath = "//a[contains(text(),'Practice Questions')]")
	WebElement DSIntroPracQue;

	public DSTimeComplexPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String validatingTimeComplexityPage() {
		String ActTitle = driver.getCurrentUrl();

		return ActTitle;
	}

	public DsIntroPracQuePageObjects DSIntroPracQue() {
		Action.click(driver, DSIntroPracQue);
		return new DsIntroPracQuePageObjects();
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
