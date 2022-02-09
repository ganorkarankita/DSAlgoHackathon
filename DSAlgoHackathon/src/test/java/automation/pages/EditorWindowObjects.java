package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.actiondriver.Action;
import automation.utility.BrowserFactory;

public class EditorWindowObjects extends BrowserFactory {

	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement TryHere;

	@FindBy(xpath = "//button[@type='button']")
	WebElement Run;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement Output;
	// @FindBy(className = "CodeMirror")
	// WebElement codemirrorEle;

	// @FindBys({@FindBy(className = "CodeMirror-line"),})
	// List<WebElement> CodeMirrorLine;

	public EditorWindowObjects() {
		PageFactory.initElements(driver, this);

	}

	public String ValidatingEditorPage() {
		String ActualURL = driver.getCurrentUrl();

		return ActualURL;
	}

	public void VerifyInput(String Code) {
		/* getting codemirror element */
		WebElement codeMirror = driver.findElement(By.className("CodeMirror"));

		/*
		 * getting the first line of code inside codemirror and clicking it to bring it
		 * in focus
		 */
		WebElement codeLine = codeMirror.findElements(By.className("CodeMirror-line")).get(0);
		codeLine.click();

		/* sending keystokes to textarea once codemirror is in focus */
		WebElement txtbx = codeMirror.findElement(By.cssSelector("textarea"));
		txtbx.sendKeys(Code);

		// WebElement queryInput = driver.findElement(By.className("CodeMirror"));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].CodeMirror.setValue(\"" + Code + "\");",
		// queryInput);

	}

	public boolean Run() throws InterruptedException {
		Action.click(driver, Run);
		return Action.Alert(driver);

	}

	public String validateoutput() throws InterruptedException {

		String output = Output.getText();
		return output;

	}
}
