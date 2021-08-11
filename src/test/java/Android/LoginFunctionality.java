package Android;

import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.TouchAction;
import org.testng.annotations.*;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.Settings.*;
import static ObjectRepository.AndroidOR.ForYou.*;
import static Parent.Constants.*;
import static Parent.Reporting.*;
import static Utils.CommonUtils.*;

/*
*This is test case for Verificaton of Login Functionality through For You>>Settings
*/
public class LoginFunctionality {
    String testCaseName = "Login Functionality Test";
    String testCaseDescription = "Verify Login Functionality through For You>>Settings";

    @Test
    public void loginFunctionality() throws Exception
    {
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            extentTest.log(LogStatus.INFO, "App Launched");
            extentTest.log(LogStatus.INFO, "Initial Subscription & Login skipped!");
            setUp();
            login(true);
            extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
            tearDown();
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
            tearDown();
        }
    }
}
