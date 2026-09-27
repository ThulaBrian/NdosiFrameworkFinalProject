package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {
    private static final String reportDir = System.getProperty("user.dir") + "/Reports/WebAutomationAdvancedProject.html";

    //Main reporting engine object (holds all test results)
    private static ExtentReports extentReports;

    //Responsible for creating the actual HTML file with a nice UI
    private static ExtentSparkReporter extentSparkReporter;

    //This method initializes and configures the report
    //It is called at the beginning of the test suite
    public static ExtentReports extentReports(){

        //Create a fresh ExtentReports object
        extentReports = new ExtentReports();

        //Create the Spark Reporter and point it to our report file location
        extentSparkReporter = new ExtentSparkReporter(new File(reportDir));

        // Attach the reporter to the main ExtentReports object
        // Without this, nothing will be written to the HTML file
        extentReports.attachReporter(extentSparkReporter);

        // Set the title that appears in the browser tab when you open the report
        extentSparkReporter.config().setDocumentTitle("Extent Report");

        // Optional: Change the look of the report
        extentSparkReporter.config().setTheme(Theme.DARK);

        // Set the big title/name shown at the top of the report
        extentSparkReporter.config().setReportName("WebAutomationAdvancedProject");

        // Add useful system/environment information to the report
        // This helps when debugging (e.g., was it run on Windows or Mac?)
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Execution Machine", System.getProperty("user.name"));

        // Return the fully configured object so the listener can use it
        return extentReports;
    }
}
