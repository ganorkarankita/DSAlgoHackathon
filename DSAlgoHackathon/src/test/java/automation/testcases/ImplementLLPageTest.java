package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.HomePageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StackImplementationObjects;
import automation.pages.StackPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class ImplementLLPageTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	StackPageObjects StackPO;
	StackImplementationObjects StackImplePO;

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
	public void verifyImplementingLLPage() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		StackImplePO = new StackImplementationObjects();

		StackPO = new StackPageObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		StackPO = HomePO.StackGetStarted();
		StackImplePO = StackPO.Implement();

		String ActPageTitle = StackImplePO.ValidateStackImplePage();
		Assert.assertEquals(ActPageTitle, "Implementation");
	}

}
