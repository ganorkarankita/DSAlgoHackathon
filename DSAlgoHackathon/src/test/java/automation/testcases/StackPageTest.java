package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.HomePageObjects;
import automation.pages.OperationStackPageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StackAppliObjects;
import automation.pages.StackImplementationObjects;
import automation.pages.StackPageObjects;
import automation.pages.StackPracQuePageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class StackPageTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	StackPageObjects StackPO;
	OperationStackPageObjects OpStackPO;
	StackImplementationObjects StackImplePO;
	StackAppliObjects StackAppliPO;
	StackPracQuePageObjects StackQuePO;

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
	public void verifyStackPageLinks() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		OpStackPO = new OperationStackPageObjects();
		StackImplePO = new StackImplementationObjects();
		StackAppliPO = new StackAppliObjects();
		StackQuePO = new StackPracQuePageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		StackPO = HomePO.StackGetStarted();

		OpStackPO = StackPO.OperationStack();
		String ActURL = OpStackPO.validateOperationStackPage();
		System.out.println(ActURL);
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/stack/operations-in-stack/");
		driver.navigate().back();
		Thread.sleep(1000);

		StackImplePO = StackPO.Implement();
		String ActURL1 = OpStackPO.validateOperationStackPage();
		System.out.println(ActURL1);
		Assert.assertEquals(ActURL1, "https://dsportalapp.herokuapp.com/stack/implementation/");
		driver.navigate().back();
		Thread.sleep(1000);

		StackAppliPO = StackPO.Application();
		String ActURL2 = OpStackPO.validateOperationStackPage();
		System.out.println(ActURL2);
		Assert.assertEquals(ActURL2, "https://dsportalapp.herokuapp.com/stack/stack-applications/");
		driver.navigate().back();
		Thread.sleep(1000);

	}

	@Test
	public void varifyNumpyNinjalink() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		OpStackPO = new OperationStackPageObjects();
		StackImplePO = new StackImplementationObjects();
		StackAppliPO = new StackAppliObjects();
		StackQuePO = new StackPracQuePageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		StackPO = HomePO.StackGetStarted();
		Thread.sleep(2000);
		StackPO.NN();
		Thread.sleep(2000);
		String ActURL = startUpPO.ValidateURL();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/");

	}

}
