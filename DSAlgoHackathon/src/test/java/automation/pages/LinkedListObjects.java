package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class LinkedListObjects extends BrowserFactory {

	@FindBy(linkText = "Introduction")
	WebElement Intro;
	@FindBy(linkText = "Creating Linked LIst")
	WebElement CreateLL;
	@FindBy(linkText = "Types of Linked List")
	WebElement TypeLL;
	@FindBy(linkText = "Implement Linked List in Python")
	WebElement LLinPython;
	@FindBy(linkText = "Traversal")
	WebElement Traversal;
	@FindBy(linkText = "Insertion")
	WebElement Insertion;
	@FindBy(linkText = "Deletion")
	WebElement Deletion;
	@FindBy(linkText = "//a[contains(text(),'Practice Questions')]")
	WebElement PracticeQue;
	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	public LinkedListObjects() {
		PageFactory.initElements(driver, this);

	}

	public IntroductionPageObjects Introduction() throws InterruptedException {
		// JavascriptExecutor js = (JavascriptExecutor) getDriver(); // Interface
		// js.executeScript("window.scrollBy(0,600)");
		// Reporter.log("Page is scrolled by pixel");
		// Thread.sleep(3000);
		Action.click(driver, Intro);
		return new IntroductionPageObjects();
	}

	public CreatingLLPageObjects CreatingLinkedList() {
		Action.click(driver, CreateLL);
		return new CreatingLLPageObjects();
	}

	public TypesOfLLPageObjects TypesOfLinkedList() {
		Action.click(driver, TypeLL);
		return new TypesOfLLPageObjects();
	}

	public ImplementLLPageObjects ImplementLinkedList() {
		Action.click(driver, LLinPython);
		return new ImplementLLPageObjects();
	}

	public TraversalPageObjects Traversal() {
		Action.click(driver, Traversal);
		return new TraversalPageObjects();
	}

	public InsertionPageObjects Insertion() {
		Action.click(driver, Insertion);
		return new InsertionPageObjects();
	}

	public DeletionPageObjects Deletion() {
		Action.click(driver, Deletion);
		return new DeletionPageObjects();
	}

	public StartUpPageObjects NN() {
		Action.click(driver, NN);
		return new StartUpPageObjects();
	}

	public String ValidateLinkedListPage() {
		String CurrentURL = driver.getCurrentUrl();
		return CurrentURL;
	}

}
