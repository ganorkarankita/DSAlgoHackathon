package automation.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.ArrayPageObjects;
import automation.pages.GraphPageObject;
import automation.pages.HomePageObjects;
import automation.pages.LinkedListObjects;
import automation.pages.QueuePageObjects;
import automation.pages.RegistrationPageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StackPageObjects;
import automation.pages.StartUpPageObjects;
import automation.pages.TreePageObjects;
import automation.utility.BrowserFactory;

public class DSDropDownTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	RegistrationPageObjects RegisterPO;
	LinkedListObjects LinkedListPO;
	StackPageObjects StackPO;
	ArrayPageObjects ArrayPO;
	QueuePageObjects QueuePO;
	TreePageObjects TreePO;
	GraphPageObject GraphPO;

	@BeforeMethod()
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		launchurl("chrome");
	}

	@AfterMethod()
	public void teardown() {
		driver.quit();

	}

	@Test
	public void DSDropdownlinksValidation() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();
		LinkedListPO = new LinkedListObjects();
		StackPO = new StackPageObjects();
		ArrayPO = new ArrayPageObjects();
		QueuePO = new QueuePageObjects();
		TreePO = new TreePageObjects();
		GraphPO = new GraphPageObject();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));

		ArrayPO = HomePO.DSDropdownArray();
		String ActURL1 = StackPO.validateStackPage();
		Reporter.log(ActURL1);
		Assert.assertEquals(ActURL1, "https://dsportalapp.herokuapp.com/array/");
		Thread.sleep(2000);

		LinkedListPO = HomePO.DSDropdownLL();
		String ActURL2 = StackPO.validateStackPage();
		Reporter.log(ActURL2);
		Assert.assertEquals(ActURL2, "https://dsportalapp.herokuapp.com/linked-list/");
		Thread.sleep(2000);

		StackPO = HomePO.DSDropdownStack();
		String ActURL3 = StackPO.validateStackPage();
		Reporter.log(ActURL3);
		Assert.assertEquals(ActURL3, "https://dsportalapp.herokuapp.com/stack/");
		Thread.sleep(2000);

		QueuePO = HomePO.DSDropdownQueue();
		String ActURL4 = StackPO.validateStackPage();
		Reporter.log(ActURL4);
		Assert.assertEquals(ActURL4, "https://dsportalapp.herokuapp.com/queue/");
		Thread.sleep(2000);

		TreePO = HomePO.DSDropdownTree();
		String ActURL5 = StackPO.validateStackPage();
		Reporter.log(ActURL5);
		Assert.assertEquals(ActURL5, "https://dsportalapp.herokuapp.com/tree/");
		Thread.sleep(2000);

		GraphPO = HomePO.DSDropdownGraph();
		String ActURL6 = StackPO.validateStackPage();
		Reporter.log(ActURL6);
		Assert.assertEquals(ActURL6, "https://dsportalapp.herokuapp.com/graph/");
		Thread.sleep(2000);

	}

	@Test

	public void DSDropdownItemsByVisibleText() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();
		LinkedListPO = new LinkedListObjects();
		StackPO = new StackPageObjects();
		ArrayPO = new ArrayPageObjects();
		QueuePO = new QueuePageObjects();
		TreePO = new TreePageObjects();
		GraphPO = new GraphPageObject();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		HomePO.DSDropdownList();
	}

}
