package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.CreatingLLPageObjects;
import automation.pages.HomePageObjects;
import automation.pages.ImplementLLPageObjects;
import automation.pages.InsertionPageObjects;
import automation.pages.IntroductionPageObjects;
import automation.pages.LinkedListObjects;
import automation.pages.RegistrationPageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.pages.TraversalPageObjects;
import automation.pages.TypesOfLLPageObjects;
import automation.utility.BrowserFactory;

public class InsertionPageTest extends BrowserFactory {
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
	InsertionPageObjects Insertion;

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
	public void verifyInsertionPage() throws InterruptedException {
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
		Insertion = new InsertionPageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		LinkedListPO = HomePO.LLGetStarted();

		Insertion = LinkedListPO.Insertion();
		String ActURL6 = Insertion.validatingInsertionPage();
		Assert.assertEquals(ActURL6, "https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/");

	}
}
