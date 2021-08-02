package Parent;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/*
*Contains all the methods and variables for reporting purposes
*/
public class Reporting {
    //Path for creating Report file
    public static String extentReportFile = System.getProperty("user.dir")+"\\extentReportFile.html";
    //Create object of extent report and specify the report file path.
    public static ExtentReports extent = new ExtentReports(extentReportFile, true);
    //Create object for reporter to be used throughout the execution
    public static ExtentTest extentTest;

    /*
     *This method is used to initialise reporting
     *Arguments: None
     *Return   : Nothing
     */
    public static void initializeReporting(String testCaseName, String testCaseDescription)
    {
        extentTest = Reporting.extent.startTest(testCaseName,testCaseDescription);
    }

    /*
     *This method is used to close reporting
     *Arguments: None
     *Return   : Nothing
     */
    public static void closeReporting()
    {
        // close report.
        Reporting.extent.endTest(extentTest);
        // writing everything to document.
        Reporting.extent.flush();
    }
}
