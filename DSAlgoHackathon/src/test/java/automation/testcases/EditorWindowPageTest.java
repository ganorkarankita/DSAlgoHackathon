package automation.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.EditorWindowObjects;
import automation.pages.HomePageObjects;
import automation.pages.OperationStackPageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StackPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class EditorWindowPageTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	StackPageObjects StackPO;
	OperationStackPageObjects OpStackPO;
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
	public void verifyEditorWindowforGoodInput() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		StackPO = new StackPageObjects();
		OpStackPO = new OperationStackPageObjects();
		EditorWindowPO = new EditorWindowObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		StackPO = HomePO.StackGetStarted();
		OpStackPO = StackPO.OperationStack();
		Thread.sleep(2000);
		OpStackPO.tryHere();
		Thread.sleep(3000);
		EditorWindowPO.VerifyInput("print\"Hello\"");
		Thread.sleep(3000);
		boolean Condition = EditorWindowPO.Run();
		// Assert.assertTrue(Condition);
		if (Condition) {
			Reporter.log("Bad Input");
		} else {
			Reporter.log("No Errors");
		}

		Thread.sleep(3000);
		String output = EditorWindowPO.validateoutput();
		Reporter.log("Output is :" + output);

	}

	@Test
	public void verifyEditorWindowforBadInput() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		StackPO = new StackPageObjects();
		OpStackPO = new OperationStackPageObjects();
		EditorWindowPO = new EditorWindowObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		StackPO = HomePO.StackGetStarted();
		OpStackPO = StackPO.OperationStack();
		Thread.sleep(2000);
		OpStackPO.tryHere();
		Thread.sleep(3000);
		EditorWindowPO.VerifyInput("print\"Hello");
		Thread.sleep(3000);
		boolean Condition = EditorWindowPO.Run();
		// Assert.assertTrue(Condition);
		if (Condition) {
			Reporter.log("Bad Input");
		} else {
			Reporter.log("No Errors");
		}

		Thread.sleep(3000);
		String output = EditorWindowPO.validateoutput();
		Reporter.log("Output is :" + output);

	}
}
