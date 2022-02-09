package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.DSIntroPageObjects;
import automation.pages.DSTimeComplexPageObjects;
import automation.pages.DsIntroPracQuePageObjects;
import automation.pages.EditorWindowObjects;
import automation.pages.HomePageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class DsTimeComplexPageTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	DSIntroPageObjects DSIntroPO;
	DSTimeComplexPageObjects DSTimePO;
	DsIntroPracQuePageObjects DSPracQuePO;
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
	public void verifyDsComplexityPage() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		DSTimePO = new DSTimeComplexPageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		DSIntroPO = HomePO.DSIntroGetStarted();

		DSTimePO = DSIntroPO.TimeComplexity();
		Thread.sleep(2000);
		String ActTitle = DSTimePO.validatingTimeComplexityPage();
		Assert.assertEquals(ActTitle, "Time Complexity");

	}

	@Test
	public void verifyPracticeQu() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		DSTimePO = new DSTimeComplexPageObjects();
		DSPracQuePO = new DsIntroPracQuePageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		DSIntroPO = HomePO.DSIntroGetStarted();

		DSTimePO = DSIntroPO.TimeComplexity();
		Thread.sleep(2000);
		DSTimePO.DSIntroPracQue();
		Thread.sleep(2000);
		String ActURL = DSPracQuePO.DSIntroPracQuePage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/data-structures-introduction/practice");

	}

	@Test
	public void verifyDSIntroTryHere() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		DSTimePO = new DSTimeComplexPageObjects();
		DSPracQuePO = new DsIntroPracQuePageObjects();
		EditorPO = new EditorWindowObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		DSIntroPO = HomePO.DSIntroGetStarted();

		DSTimePO = DSIntroPO.TimeComplexity();
		Thread.sleep(2000);

		EditorPO = DSTimePO.tryHere();
		String ActUrl = EditorPO.ValidatingEditorPage();
		Assert.assertEquals(ActUrl, "https://dsportalapp.herokuapp.com/tryEditor");

	}
}
