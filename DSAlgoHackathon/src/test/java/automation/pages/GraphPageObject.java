package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class GraphPageObject extends BrowserFactory {

	@FindBy(xpath = "//a[@href='graph']")
	WebElement Graph2;
	@FindBy(xpath = "//a[@href='graph-representations']")
	WebElement GraphRepresent;

	public GraphPageObject() {
		PageFactory.initElements(driver, this);
	}

	public String validateGraphPage() {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	}

	public GraphInsidePageObjects Graph() {
		Action.click(driver, Graph2);
		return new GraphInsidePageObjects();
	}

	public GraphRepresentPageObjects GraphRepresentation() {
		Action.click(driver, GraphRepresent);
		return new GraphRepresentPageObjects();
	}
}
