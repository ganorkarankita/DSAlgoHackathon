package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.pages.ArrayAppliPageObjects;
import automation.pages.ArrayListPageObjects;
import automation.pages.ArrayOpPageObjects;
import automation.pages.ArrayPageObjects;
import automation.pages.ArrayPracQuePageObjects;
import automation.pages.ArrayPythonPageObjects;
import automation.pages.EditorWindowObjects;
import automation.pages.HomePageObjects;
import automation.pages.SignInPageObjects;
import automation.pages.StartUpPageObjects;
import automation.utility.BrowserFactory;

public class ArrayPythonPageTest extends BrowserFactory {

	HomePageObjects HomePO;
	StartUpPageObjects startUpPO;
	SignInPageObjects SignInPO;
	ArrayPythonPageObjects ArrayPythonPO;
	ArrayListPageObjects ArrayListPO;
	ArrayOpPageObjects ArrayOpPO;
	ArrayAppliPageObjects ArrayApplicPO;
	ArrayPageObjects ArrayPO;
	ArrayPracQuePageObjects ArrayPracQuePO;
	EditorWindowObjects EditorPO;

	@BeforeMethod()
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		launchurl("chrome");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void verifyArrayPageLinks() throws InterruptedException {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		ArrayPythonPO = new ArrayPythonPageObjects();
		ArrayListPO = new ArrayListPageObjects();
		ArrayOpPO = new ArrayOpPageObjects();
		ArrayApplicPO = new ArrayAppliPageObjects();
		ArrayPO = new ArrayPageObjects();
		ArrayPracQuePO = new ArrayPracQuePageObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));

		ArrayPO = HomePO.ArrayGetStarted();
		ArrayPythonPO = ArrayPO.ArrayinPython();
		Thread.sleep(2000);

		ArrayPythonPO = ArrayPO.ArrayinPython();
		String ActURL = ArrayPythonPO.validateArrayPythonPage();
		System.out.println(ActURL);
		Assert.assertEquals(ActURL, "https://dsportalapp.herokuapp.com/array/arrays-in-python/");
		Thread.sleep(2000);

		ArrayListPO = ArrayPO.ArrayUsingList();
		String ActURL1 = ArrayListPO.ArrayListPageValidation();
		System.out.println(ActURL1);
		Assert.assertEquals(ActURL1, "https://dsportalapp.herokuapp.com/array/arrays-using-list/");
		driver.navigate().back();
		Thread.sleep(2000);

		ArrayOpPO = ArrayPO.BasicOperationinLists();
		String ActURL2 = ArrayOpPO.ArrayOperationPageObjectsValidation();
		System.out.println(ActURL2);
		Assert.assertEquals(ActURL2, "https://dsportalapp.herokuapp.com/array/basic-operations-in-lists/");
		driver.navigate().back();
		Thread.sleep(2000);

		ArrayApplicPO = ArrayPO.ApplicationofArray();
		String ActURL3 = ArrayApplicPO.ArrayOperationPageObjectsValidation();
		System.out.println(ActURL3);
		Assert.assertEquals(ActURL3, "https://dsportalapp.herokuapp.com/array/applications-of-array/");
		driver.navigate().back();
		Thread.sleep(2000);

		ArrayPracQuePO = ArrayPythonPO.ArrayPracQue();
		String ActURL4 = ArrayApplicPO.ArrayOperationPageObjectsValidation();
		System.out.println(ActURL4);
		Assert.assertEquals(ActURL4, "https://dsportalapp.herokuapp.com/array/practice");
		driver.navigate().back();
		Thread.sleep(2000);

	}

	@Test
	public void verifyArrayEditorWindow() {
		HomePO = new HomePageObjects();
		startUpPO = new StartUpPageObjects();
		SignInPO = new SignInPageObjects();
		ArrayPythonPO = new ArrayPythonPageObjects();
		EditorPO = new EditorWindowObjects();

		startUpPO.ClickGetstarted();

		SignInPO = HomePO.SignIn();
		HomePO = SignInPO.Login(prop.getProperty("username"), prop.getProperty("password"));
		ArrayPO = HomePO.ArrayGetStarted();
		ArrayPythonPO = ArrayPO.ArrayinPython();

		EditorPO = ArrayPythonPO.tryHere();
		String ActUrl = EditorPO.ValidatingEditorPage();
		Assert.assertEquals(ActUrl, "https://dsportalapp.herokuapp.com/tryEditor");

	}
}
