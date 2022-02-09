package automation.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import automation.actiondriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;

	@BeforeTest

	public void readConfig() {
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(fs);
			System.out.println("driver: " + driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void launchapp() {
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "C:\\AnkitaWork\\Selenium
		// Drivers\\chromedriver.exe");
		String browserName = prop.getProperty("browser");

		if (browserName.contains("Chrome")) {
			driver = new ChromeDriver();
		} else {
			System.out.println("Browser is unavailable");
		}

		driver.manage().window().maximize();
		// Delete all the cookies
		driver.manage().deleteAllCookies();
		// Implicit TimeOuts
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));

	}
}
