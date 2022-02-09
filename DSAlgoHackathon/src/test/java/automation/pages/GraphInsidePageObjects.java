package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class GraphInsidePageObjects extends BrowserFactory {

	@FindBy(linkText = "Graph")
	WebElement Graph2;
	@FindBy(linkText = "Graph Representations")
	WebElement GraphRepresent;
	@FindBy(xpath = "//a[contains(text(),'Practice Questions')]")
	WebElement GraphPracQue;

	public GraphInsidePageObjects() {
		PageFactory.initElements(driver, this);

	}

	public GraphInsidePageObjects GraphPage() {
		Action.click(driver, Graph2);
		return new GraphInsidePageObjects();
	}

	public GraphRepresentPageObjects GraphRepresentation() {
		Action.click(driver, GraphRepresent);
		return new GraphRepresentPageObjects();
	}

	public GrapParcQuePageObjects GraphPracQue() {
		Action.click(driver, GraphPracQue);
		return new GrapParcQuePageObjects();
	}

	public String validateGraphInsidePage() {
		String ActURL = driver.getCurrentUrl();
		return ActURL;

	}

}
