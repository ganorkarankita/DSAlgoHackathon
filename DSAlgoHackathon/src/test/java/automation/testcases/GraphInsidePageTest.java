package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.GrapParcQuePageObjects;
import automation.pages.GraphInsidePageObjects;
import automation.pages.GraphPageObject;
import automation.pages.GraphRepresentPageObjects;
import automation.pages.HomePageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class GraphInsidePageTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	GraphPageObject GraphPO;
	GraphInsidePageObjects GraphInPO;
	GraphRepresentPageObjects GraphRepresentPO;
	GrapParcQuePageObjects GrapPracQuePO;

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
	public void verifyGraphPageLinks() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		GraphInPO = new GraphInsidePageObjects();
		GraphRepresentPO = new GraphRepresentPageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		GraphPO = HomePO.GraphGetStarted();
		GraphInPO = GraphPO.Graph();

		GraphInPO = GraphInPO.GraphPage();
		Thread.sleep(2000);

		GraphInPO = GraphInPO.GraphPage();
		String ActURL = GraphInPO.validateGraphInsidePage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/graph/graph/");
		Thread.sleep(2000);

		GraphRepresentPO = GraphInPO.GraphRepresentation();
		String ActURL2 = GraphRepresentPO.validateGraphRepresentationPage();
		Assert.assertEquals(ActURL2, "https://dsportalapp.herokuapp.com/graph/graph-representations/");
		driver.navigate().back();
		Thread.sleep(2000);

	}

	@Test
	public void verifyGraphPracQue() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		GraphInPO = new GraphInsidePageObjects();
		GraphRepresentPO = new GraphRepresentPageObjects();
		GrapPracQuePO = new GrapParcQuePageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		GraphPO = HomePO.GraphGetStarted();
		GraphInPO = GraphPO.Graph();
		GrapPracQuePO = GraphInPO.GraphPracQue();
		Thread.sleep(2000);

	}

}
