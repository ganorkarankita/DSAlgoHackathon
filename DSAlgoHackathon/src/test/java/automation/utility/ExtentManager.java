package automation.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentSparkReporter sparkReporter;

	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setExtent() {

		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("Report.html");

		extent.attachReporter(sparkReporter);

		// extent.setSystemInfo("HostName", "MyHost");
		// extent.setSystemInfo("ProjectName", "MyStoreProject");
		// extent.setSystemInfo("Tester", "Hitendra");
		// extent.setSystemInfo("OS", "Win10");
		// extent.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		extent.flush();
	}

}
