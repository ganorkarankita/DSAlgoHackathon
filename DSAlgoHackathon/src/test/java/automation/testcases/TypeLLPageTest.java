package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.CreatingLLPageObjects;
import automation.pages.HomePageObjects;
import automation.pages.IntroductionPageObjects;
import automation.pages.LinkedListObjects;
import automation.pages.RegistrationPageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.pages.TypesOfLLPageObjects;
import automation.utility.BrowserFactory;

public class TypeLLPageTest extends BrowserFactory {

	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	RegistrationPageObjects RegisterPO;
	LinkedListObjects LinkedListPO;
	IntroductionPageObjects IntroPO;
	CreatingLLPageObjects CreatingLLPO;
	TypesOfLLPageObjects TypesLLPO;

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
	public void verifyTypeLLPage() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();
		LinkedListPO = new LinkedListObjects();
		IntroPO = new IntroductionPageObjects();
		CreatingLLPO = new CreatingLLPageObjects();
		TypesLLPO = new TypesOfLLPageObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		LinkedListPO = HomePO.LLGetStarted();

		TypesLLPO = LinkedListPO.TypesOfLinkedList();
		String ActURL = TypesLLPO.ValidatingTypeOfLL();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/");
	}

	@Test
	public void verifyExternalLinks() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();
		LinkedListPO = new LinkedListObjects();
		IntroPO = new IntroductionPageObjects();
		CreatingLLPO = new CreatingLLPageObjects();
		TypesLLPO = new TypesOfLLPageObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		LinkedListPO = HomePO.LLGetStarted();

		TypesLLPO = LinkedListPO.TypesOfLinkedList();
		String ActURL = TypesLLPO.SinglyLink();
		Assert.assertEquals(ActURL, "https://www.javatpoint.com/singly-linked-list");

		TypesLLPO = LinkedListPO.TypesOfLinkedList();
		String ActURL1 = TypesLLPO.DoublyLink();
		Assert.assertEquals(ActURL1, "https://www.javatpoint.com/doubly-linked-list");

		TypesLLPO = LinkedListPO.TypesOfLinkedList();
		String ActURL2 = TypesLLPO.LinkedListLink();
		Assert.assertEquals(ActURL2, "https://www.javatpoint.com/ds-linked-list");

		TypesLLPO = LinkedListPO.TypesOfLinkedList();
		String ActURL3 = TypesLLPO.TypeOfLLLink();
		Assert.assertEquals(ActURL3, "https://www.javatpoint.com/ds-types-of-linked-list");

	}

	@Test
	public void verifyTypeOfLL() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		RegisterPO = new RegistrationPageObjects();
		LinkedListPO = new LinkedListObjects();
		IntroPO = new IntroductionPageObjects();
		CreatingLLPO = new CreatingLLPageObjects();
		TypesLLPO = new TypesOfLLPageObjects();

		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		LinkedListPO = HomePO.LLGetStarted();

		TypesLLPO = LinkedListPO.TypesOfLinkedList();
		String ActURL = TypesLLPO.validatingTypesOfLLPage();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/");

	}
}
