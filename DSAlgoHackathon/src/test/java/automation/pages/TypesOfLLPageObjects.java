package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class TypesOfLLPageObjects extends BrowserFactory {

	@FindBy(xpath = "//p[contains(text(),'Types of Linked List')]")
	WebElement Header;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement TryHere;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;
	@FindBy(linkText = "Types of Linked List")
	WebElement TypeLL;
	@FindBy(linkText = "singly linked list")
	WebElement singly;
	@FindBy(linkText = "linked list")
	WebElement LinkedL;
	@FindBy(linkText = "doubly linked list")
	WebElement doubly;
	@FindBy(linkText = "type of the linked list")
	WebElement TypeLLLink;

	public TypesOfLLPageObjects() {
		PageFactory.initElements(driver, this);

	}

	public String ValidatingTypeOfLL() {
		Action.click(driver, TypeLL);
		String CurrentURL = driver.getCurrentUrl();

		return CurrentURL;

	}

	public String SinglyLink() {
		Action.click(driver, singly);
		String CurrentURL = driver.getCurrentUrl();
		driver.navigate().back();

		return CurrentURL;

	}

	public String LinkedListLink() {
		Action.click(driver, LinkedL);
		String CurrentURL = driver.getCurrentUrl();
		driver.navigate().back();

		return CurrentURL;

	}

	public String DoublyLink() {
		Action.click(driver, doubly);
		String CurrentURL = driver.getCurrentUrl();
		driver.navigate().back();

		return CurrentURL;

	}

	public String TypeOfLLLink() {
		Action.click(driver, TypeLLLink);
		String CurrentURL = driver.getCurrentUrl();
		driver.navigate().back();

		return CurrentURL;

	}

	public String validatingTypesOfLLPage() {
		String CurrentURL = driver.getCurrentUrl();

		return CurrentURL;
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
