package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.CreatingLLPageObjects;
import automation.pages.HomePageObjects;
import automation.pages.ImplementLLPageObjects;
import automation.pages.IntroductionPageObjects;
import automation.pages.LinkedListObjects;
import automation.pages.RegistrationPageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.pages.TraversalPageObjects;
import automation.pages.TypesOfLLPageObjects;
import automation.utility.BrowserFactory;

public class TraversalPageTest extends BrowserFactory {
	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	RegistrationPageObjects RegisterPO;
	LinkedListObjects LinkedListPO;
	IntroductionPageObjects IntroPO;
	CreatingLLPageObjects CreatingLLPO;
	TypesOfLLPageObjects TypesLLPO;
	ImplementLLPageObjects ImpleLLPO;
	TraversalPageObjects Traversal;

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
	public void verifyTtraversalPage() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();
		LinkedListPO = new LinkedListObjects();
		IntroPO = new IntroductionPageObjects();
		CreatingLLPO = new CreatingLLPageObjects();
		TypesLLPO = new TypesOfLLPageObjects();
		ImpleLLPO = new ImplementLLPageObjects();
		Traversal = new TraversalPageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		LinkedListPO = HomePO.LLGetStarted();

		Traversal = LinkedListPO.Traversal();
		String ActURL = Traversal.validatingTrversalPage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/linked-list/traversal/");
	}
}
