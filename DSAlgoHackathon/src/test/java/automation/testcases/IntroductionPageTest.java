package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.EditorWindowObjects;
import automation.pages.HomePageObjects;
import automation.pages.IntroductionPageObjects;
import automation.pages.LinkedListObjects;
import automation.pages.RegistrationPageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class IntroductionPageTest extends BrowserFactory {

	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	RegistrationPageObjects RegisterPO;
	LinkedListObjects LinkedListPO;
	IntroductionPageObjects IntroPO;
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
	public void verifyLLIntroduction() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();
		LinkedListPO = new LinkedListObjects();
		IntroPO = new IntroductionPageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		LinkedListPO = HomePO.LLGetStarted();

		IntroPO = LinkedListPO.Introduction();
		String ActURL = IntroPO.validatingLLIntroductionPage();
		System.out.println(ActURL);
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/linked-list/introduction/");

	}

	@Test
	public void verifyTryHere() throws InterruptedException {

		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();
		LinkedListPO = new LinkedListObjects();
		IntroPO = new IntroductionPageObjects();
		EditorPO = new EditorWindowObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		LinkedListPO = HomePO.LLGetStarted();

		IntroPO = LinkedListPO.Introduction();

		EditorPO = IntroPO.tryHere();
		String ActUrl = EditorPO.ValidatingEditorPage();
		Assert.assertEquals(ActUrl, "https://dsportalapp.herokuapp.com/tryEditor");

	}
}
