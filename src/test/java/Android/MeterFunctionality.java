package Android;

import Parent.Reporting;
import Utils.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is test case for Verificaton of Meter For Unsubscribed and Anonymous user*/
public class MeterFunctionality {
    String testCaseName = "Meter Functionality Test";
    String testCaseDescription = "Verify Meter For Unsubscribed and Anonymous user";
    @BeforeTest
    public void setUp() throws Exception
    {
        launchNYTApp();
        skipInitialAccountSetup();
    }

    @Test
    public void meterFunctionality() throws Exception
    {

        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            boolean meterStatusAnonymousUser = CommonUtils.checkMeter();

            if(meterStatusAnonymousUser)
            {
                extentTest.log(LogStatus.PASS, "Meter status for Anonymous user");
            }
            else
            {
                extentTest.log(LogStatus.FAIL, "Meter status for Anonymous user");
            }


            waitForSpecificTime(10);
            loginUnsubscribedUser();
            waitForSpecificTime(10);
            boolean meterStatusUnsubscribedUser = checkMeter();

            if(meterStatusUnsubscribedUser)
            {
                extentTest.log(LogStatus.PASS, "Meter status for Unsubscribed user");
            }
            else
            {
                extentTest.log(LogStatus.FAIL, "Meter status for Unsubscribed user");
            }

            if(meterStatusAnonymousUser&&meterStatusUnsubscribedUser)
            {
                extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
            }
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }

}
