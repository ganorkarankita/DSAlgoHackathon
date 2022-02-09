package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.HomePageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StackAppliObjects;
import automation.pages.StackPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class StackAppliPageTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	StackPageObjects StackPO;
	StackAppliObjects StackAppliPO;

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
		StackAppliPO = new StackAppliObjects();
		StackPO = new StackPageObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		StackPO = HomePO.StackGetStarted();
		StackAppliPO = StackPO.Application();

		String ActPageTitle = StackAppliPO.ValidateStackApplicationPage();
		Assert.assertEquals(ActPageTitle, "Applications");
	}

}
