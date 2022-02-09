package automation.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.CreatingLLPageObjects;
import automation.pages.DeletionPageObjects;
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

public class LinkedListPageTest extends BrowserFactory {
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
	DeletionPageObjects Deletion;

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
	public void verifyLinkedListPage() throws InterruptedException {
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
		Deletion = new DeletionPageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		LinkedListPO = HomePO.LLGetStarted();

		JavascriptExecutor js = (JavascriptExecutor) driver; // Interface
		js.executeScript("window.scrollBy(0,600)");

		IntroPO = LinkedListPO.Introduction();
		String ActURL = IntroPO.validatingLLIntroductionPage();
		System.out.println(ActURL);
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/linked-list/introduction/");
		driver.navigate().back();
		Thread.sleep(2000);

		CreatingLLPO = LinkedListPO.CreatingLinkedList();
		String ActURL1 = CreatingLLPO.validatingLLCreatingLLPage();
		Assert.assertEquals(ActURL1, "https://dsportalapp.herokuapp.com/linked-list/creating-linked-list/");
		driver.navigate().back();
		Thread.sleep(5000);

		TypesLLPO = LinkedListPO.TypesOfLinkedList();
		String ActURL2 = TypesLLPO.ValidatingTypeOfLL();
		Assert.assertEquals(ActURL2, "https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/");
		driver.navigate().back();
		Thread.sleep(5000);

		ImpleLLPO = LinkedListPO.ImplementLinkedList();
		String ActURL4 = ImpleLLPO.validatingImplementationOfLLPage();
		Assert.assertEquals(ActURL4, "https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/");
		driver.navigate().back();
		Thread.sleep(5000);

		Traversal = LinkedListPO.Traversal();
		String ActURL5 = Traversal.validatingTrversalPage();
		Assert.assertEquals(ActURL5, "https://dsportalapp.herokuapp.com/linked-list/traversal/");
		driver.navigate().back();
		Thread.sleep(3000);

		Insertion = LinkedListPO.Insertion();
		String ActURL6 = Insertion.validatingInsertionPage();
		Assert.assertEquals(ActURL6, "https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/");
		driver.navigate().back();
		Thread.sleep(3000);

		Deletion = LinkedListPO.Deletion();
		String ActURL7 = Deletion.validatingDeletionPage();
		Assert.assertEquals(ActURL7, "https://dsportalapp.herokuapp.com/linked-list/deletion-in-linked-list/");
		driver.navigate().back();
		Thread.sleep(3000);
	}

	@Test
	public void varifyNumpyNinjalink() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		LinkedListPO = new LinkedListObjects();
		startUpPO.ClickGetstarted();
		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		LinkedListPO = HomePO.LLGetStarted();
		LinkedListPO.NN();
		String ActURL = startUpPO.ValidateURL();
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/");

	}

}
