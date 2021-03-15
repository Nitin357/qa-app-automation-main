package Parent;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/*Contains all the methods for reporting purposes*/
public class Reporting {

    //Path for creating Report file
    public static String extentReportFile = System.getProperty("user.dir")+"\\extentReportFile.html";
    //    System.out.println(System.getProperty("user.dir"));
    // Create object of extent report and specify the report file path.
    public static ExtentReports extent = new ExtentReports(extentReportFile, true);
    public static ExtentTest extentTest;

/*Initialize reporter*/
    public static void initializeReporting(String testCaseName, String testCaseDescription)
    {
        extentTest = Reporting.extent.startTest(testCaseName,testCaseDescription);
    }

/*Close reporter*/
    public static void closeReporting()
    {
        // close report.
        Reporting.extent.endTest(extentTest);
        // writing everything to document.
        Reporting.extent.flush();
    }
}
