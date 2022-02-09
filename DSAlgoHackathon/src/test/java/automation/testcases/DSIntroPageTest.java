package automation.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.DSIntroPageObjects;
import automation.pages.DSTimeComplexPageObjects;
import automation.pages.HomePageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class DSIntroPageTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	DSIntroPageObjects DSIntroPO;
	DSTimeComplexPageObjects DSTimePO;

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
	public void verifyDSIntroPageLinks() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		DSTimePO = new DSTimeComplexPageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		DSIntroPO = HomePO.DSIntroGetStarted();

		DSTimePO = DSIntroPO.TimeComplexity();
		String ActTitle = DSTimePO.validatingTimeComplexityPage();
		Assert.assertEquals(ActTitle, "Time Complexity");
		Thread.sleep(2000);
	}

	@Test
	public void varifyNumpyNinjalink() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		DSIntroPO = new DSIntroPageObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		DSIntroPO = HomePO.DSIntroGetStarted();
		Thread.sleep(2000);
		startUpPO = DSIntroPO.NN();
		Thread.sleep(2000);
		String ActURL = startUpPO.ValidateURL();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/");

	}

	@Test
	public void VerifySignOut() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));

		DSIntroPO = HomePO.DSIntroGetStarted();
		Thread.sleep(2000);

		HomePO.SignOutValiadtion();
		Reporter.log("Logged out successfully");

	}
}
