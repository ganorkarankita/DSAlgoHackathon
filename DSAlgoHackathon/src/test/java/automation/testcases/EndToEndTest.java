package automation.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.actiondriver.Action;
import automation.pages.DSIntroPageObjects;
import automation.pages.DSTimeComplexPageObjects;
import automation.pages.EditorWindowObjects;
import automation.pages.HomePageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class EndToEndTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	DSIntroPageObjects DSIntroPO;
	DSTimeComplexPageObjects DSTimePO;
	EditorWindowObjects EditorPO;

	EditorWindowObjects EditorWindowPO;

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
	public void DemoEndToEndTest() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		DSTimePO = new DSTimeComplexPageObjects();
		EditorPO = new EditorWindowObjects();
		EditorWindowPO = new EditorWindowObjects();

		startUpPO.ClickGetstarted();
		Thread.sleep(1000);
		SignInPO = HomePO.SignIn();
		Thread.sleep(1000);
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(1000);
		Reporter.log("You are logged in");
		DSIntroPO = HomePO.DSIntroGetStarted();
		Thread.sleep(1000);
		Action.scrollByPixel(driver, 700);
		Thread.sleep(2000);
		DSTimePO = DSIntroPO.TimeComplexity();
		Thread.sleep(1000);
		EditorPO = DSTimePO.tryHere();
		Thread.sleep(1000);
		EditorWindowPO.VerifyInput("print\"Hello\"");
		Thread.sleep(2000);
		boolean Condition = EditorWindowPO.Run();
		// Assert.assertTrue(Condition);
		if (Condition) {
			Reporter.log("Bad Input");
		} else {
			Reporter.log("No Errors");
		}

		Thread.sleep(2000);
		String output = EditorWindowPO.validateoutput();
		Reporter.log("Output is :" + output);
		driver.navigate().back();
		Thread.sleep(2000);
		Action.scrollByPixel(driver, -800);

		Reporter.log("Page is scrolled by pixel");
		Thread.sleep(3000);
		HomePO.SignOutValiadtion();
		Thread.sleep(2000);
		Reporter.log("Logged out successfully");

	}

}
