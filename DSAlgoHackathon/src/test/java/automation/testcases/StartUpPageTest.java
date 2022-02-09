package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.HomePageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class StartUpPageTest extends BrowserFactory {
	// Webdriver driver;
	StartUpPageObjects StartUpPO;
	HomePageObjects HomePO;

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
	public void verifyTitle() {
		StartUpPO = new StartUpPageObjects();
		String ActTitle = StartUpPO.getTitle();
		Assert.assertEquals(ActTitle, "Numpy Ninja");

	}

	@Test
	public void verifyurl() {
		String ActURL = StartUpPO.ValidateURL();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/");

	}

	@Test
	public void verifyGetStartedBtnIsWorking() {
		StartUpPO = new StartUpPageObjects();
		HomePO = new HomePageObjects();
		StartUpPO.ClickGetstarted();
		String ActURL = HomePO.ValidateHomePage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/home");
	}
}
