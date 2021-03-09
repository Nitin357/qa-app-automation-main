package Parent;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Reporting {
    public static String extentReportFile = System.getProperty("user.dir")+"\\extentReportFile.html";
//    System.out.println(System.getProperty("user.dir"));
    // Create object of extent report and specify the report file path.
    public static ExtentReports extent = new ExtentReports(extentReportFile, true);
    public static ExtentTest extentTest;
    public static void initializeReporting(String testCaseName, String testCaseDescription)
    {
        extentTest = Reporting.extent.startTest(testCaseName,testCaseDescription);
    }
    public static void closeReporting()
    {
        // close report.
        Reporting.extent.endTest(extentTest);
        // writing everything to document.
        Reporting.extent.flush();
    }
}
