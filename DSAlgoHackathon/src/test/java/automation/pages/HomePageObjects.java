package automation.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class HomePageObjects extends BrowserFactory {

	@FindBy(linkText = "Sign in")
	WebElement SignIn;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement Register;

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement DSIntroGetStarted;

	@FindBy(xpath = "//a[@href='array']")
	WebElement ArrayGetStarted;

	@FindBy(xpath = "//a[@href='linked-list']")
	WebElement LLGetStarted;

	@FindBy(xpath = "//a[@href='stack']")
	WebElement StackGetStarted;

	@FindBy(xpath = "//a[@href='graph']")
	WebElement GraphGetStarted;

	@FindBy(linkText = "Data Structures")
	WebElement DSDropdown;

	@FindBy(linkText = "NumpyNinja")
	WebElement NN;

	@FindBy(xpath = "//a[contains(text(),'Stack')]")
	WebElement DropdownStack;
	@FindBys({ @FindBy(className = "dropdown-menu"), @FindBy(xpath = "//a[@href='/array']") })
	WebElement arrayDD;
	@FindBys({ @FindBy(className = "dropdown-menu"), @FindBy(xpath = "//a[@href='/linked-list']") })
	WebElement llDD;
	@FindBys({ @FindBy(className = "dropdown-menu"), @FindBy(xpath = "//a[@href='/stack']") })
	WebElement StackDD;
	@FindBys({ @FindBy(className = "dropdown-menu"), @FindBy(xpath = "//a[@href='/queue']") })
	WebElement queueDD;
	@FindBys({ @FindBy(className = "dropdown-menu"), @FindBy(xpath = "//a[@href='/tree']") })
	WebElement treeDD;
	@FindBys({ @FindBy(className = "dropdown-menu"), @FindBy(xpath = "//a[@href='/graph']") })
	WebElement graphDD;
	@FindBys({ @FindBy(xpath = "//div[contains(@class,'dropdown-menu')]//a") })
	List<WebElement> DDList;

	@FindBy(xpath = "//a[@href='/logout']")
	WebElement SignOut;
	@FindBy(xpath = "//div[contains(text(),'Logged out successfully')]")
	WebElement LoggedOutMsg;

	public HomePageObjects() {
		PageFactory.initElements(driver, this);

	}

	public SignInPageObjects SignIn() {
		Action.click(driver, SignIn);
		return new SignInPageObjects();
	}

	public RegistrationPageObjects Register() {
		Action.click(driver, Register);
		return new RegistrationPageObjects();
	}

	public DSIntroPageObjects DSIntroGetStarted() {
		Action.click(driver, DSIntroGetStarted);
		return new DSIntroPageObjects();
	}

	public ArrayPageObjects ArrayGetStarted() {
		Action.click(driver, ArrayGetStarted);
		return new ArrayPageObjects();
	}

	public LinkedListObjects LLGetStarted() {
		Action.click(driver, LLGetStarted);
		return new LinkedListObjects();
	}

	public GraphPageObject GraphGetStarted() {
		Action.click(driver, GraphGetStarted);
		return new GraphPageObject();
	}

	public String ValidateHomePage() {
		String CurrentURL = driver.getCurrentUrl();
		return CurrentURL;
	}

	public StartUpPageObjects NN() {
		Action.click(driver, NN);
		return new StartUpPageObjects();
	}

	public StackPageObjects StackGetStarted() {
		Action.click(driver, StackGetStarted);
		return new StackPageObjects();
	}

	public ArrayPageObjects DSDropdownArray() {
		Action.click(driver, DSDropdown);
		Action.click(driver, arrayDD);
		return new ArrayPageObjects();
	}

	public LinkedListObjects DSDropdownLL() {
		Action.click(driver, DSDropdown);
		Action.click(driver, llDD);
		return new LinkedListObjects();
	}

	public StackPageObjects DSDropdownStack() {
		Action.click(driver, DSDropdown);
		Action.click(driver, StackDD);
		return new StackPageObjects();
	}

	public QueuePageObjects DSDropdownQueue() {
		Action.click(driver, DSDropdown);
		Action.click(driver, queueDD);
		return new QueuePageObjects();
	}

	public TreePageObjects DSDropdownTree() {
		Action.click(driver, DSDropdown);
		Action.click(driver, treeDD);
		return new TreePageObjects();
	}

	public GraphPageObject DSDropdownGraph() {
		Action.click(driver, DSDropdown);
		Action.click(driver, graphDD);
		return new GraphPageObject();
	}

	public void DSDropdownList() {
		Action.click(driver, DSDropdown);

		List<WebElement> list = DDList;
		Reporter.log("The no of item in dropdown list:" + list.size());

		int i;
		for (i = 0; i < list.size(); i++) {
			Reporter.log(list.get(i).getText());

		}

	}

	public HomePageObjects SignOutValiadtion() {
		Action.click(driver, SignOut);
		Action.isDisplayed(driver, LoggedOutMsg);
		return new HomePageObjects();
	}

}
