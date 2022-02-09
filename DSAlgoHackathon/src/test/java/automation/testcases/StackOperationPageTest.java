package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.EditorWindowObjects;
import automation.pages.HomePageObjects;
import automation.pages.OperationStackPageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StackPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class StackOperationPageTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	StackPageObjects StackPO;
	OperationStackPageObjects OpStackPO;
	EditorWindowObjects EditorPO;

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
	public void verifyStackPageLinks() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		StackPO = new StackPageObjects();
		OpStackPO = new OperationStackPageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		StackPO = HomePO.StackGetStarted();
		OpStackPO = StackPO.OperationStack();
		Thread.sleep(2000);
		String ActURL = OpStackPO.validateOperationStackPage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/stack/operations-in-stack/");
		driver.navigate().back();
		Thread.sleep(1000);

	}

	@Test
	public void verifyTryHere() throws InterruptedException {

		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		StackPO = new StackPageObjects();
		OpStackPO = new OperationStackPageObjects();
		EditorPO = new EditorWindowObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		StackPO = HomePO.StackGetStarted();
		OpStackPO = StackPO.OperationStack();
		Thread.sleep(2000);

		EditorPO = OpStackPO.tryHere();
		String ActUrl = EditorPO.ValidatingEditorPage();
		Assert.assertEquals(ActUrl, "https://dsportalapp.herokuapp.com/tryEditor");

	}

}
