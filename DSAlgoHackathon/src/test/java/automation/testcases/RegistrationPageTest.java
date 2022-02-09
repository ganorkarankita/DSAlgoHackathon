package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.HomePageObjects;
import automation.pages.RegistrationPageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class RegistrationPageTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	RegistrationPageObjects RegisterPO;

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
	public void RegistrationTest() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		// SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();

		startUpPO.ClickGetstarted();
		RegisterPO = HomePO.Register();
		RegisterPO.Registration("Abcd", "Abcd@1234", "Abcd@1234");
		String ActURL = HomePO.ValidateHomePage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/register");

	}

}
