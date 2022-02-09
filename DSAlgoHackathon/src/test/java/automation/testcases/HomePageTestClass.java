package automation.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.ArrayPageObjects;
import automation.pages.HomePageObjects;
import automation.pages.LinkedListObjects;
import automation.pages.QueuePageObjects;
import automation.pages.RegistrationPageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StackPageObjects;
import automation.pages.StartUpPageObjects;
import automation.pages.TreePageObjects;
import automation.utility.BrowserFactory;

public class HomePageTestClass extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	RegistrationPageObjects RegisterPO;
	LinkedListObjects LinkedListPO;
	StackPageObjects StackPO;
	ArrayPageObjects ArrayPO;
	QueuePageObjects QueuePO;
	TreePageObjects TreePO;

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
	public void verifyHomePageUrl() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		// SignInPO = new SignInPageObjects();
		startUpPO.ClickGetstarted();
		String ActURL = HomePO.ValidateHomePage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/home");
	}

	@Test
	public void VerifyNumpyNinjaLink() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		// SignInPageObjects SignInPO = new SignInPageObjects();
		startUpPO.ClickGetstarted();
		HomePO.NN();
		String ActURL = startUpPO.ValidateURL();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/");

	}

	@Test
	public void VerifySignInBtn() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		String ActURL = SignInPO.ValidateSignInPage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/login");

	}

	@Test
	public void VerifyregisterBtn() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();

		startUpPO.ClickGetstarted();
		RegisterPO = HomePO.Register();
		Thread.sleep(3000);
		String ActURL = RegisterPO.validateRegisterPage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/register");

	}

	@Test
	public void verifyArrayGetStarted() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		ArrayPO = new ArrayPageObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		ArrayPO = HomePO.ArrayGetStarted();
		String ActURL = ArrayPO.validateArrayPage();
		System.out.println(ActURL);
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/array/");

	}

	@Test
	public void verifyLLGetStarted() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();
		LinkedListPO = new LinkedListObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		LinkedListPO = HomePO.LLGetStarted();
		String ActURL = LinkedListPO.ValidateLinkedListPage();
		System.out.println(ActURL);
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/linked-list/");

	}

	@Test
	public void verifyStackGetStarted() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		StackPO = HomePO.StackGetStarted();
		String ActURL = StackPO.validateStackPage();
		System.out.println(ActURL);
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/stack/");

	}

	@Test
	public void VerifySignOut() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));

		HomePO.SignOutValiadtion();
		Reporter.log("Logged out successfully");

	}

}
