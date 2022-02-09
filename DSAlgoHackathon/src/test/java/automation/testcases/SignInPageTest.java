package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.HomePageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class SignInPageTest extends BrowserFactory {

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
	public void SignUpTest() throws Throwable {
		HomePageObjects HomePO = new HomePageObjects();
		SignInPageObjects SignInPO = new SignInPageObjects();
		StartUpPageObjects StartUpPO = new StartUpPageObjects();

		StartUpPO.ClickGetstarted();
		Thread.sleep(5000);
		SignInPO = HomePO.SignIn();
		Thread.sleep(2000);

		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		String ActURL = HomePO.ValidateHomePage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/home");

	}

}
