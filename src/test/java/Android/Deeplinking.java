package Android;

import Parent.Reporting;
import Parent.Constants;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import static ObjectRepository.AndroidOR.Deeplinking.*;
import static ObjectRepository.AndroidOR.Sections.*;

import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

public class Deeplinking {

    String testCaseName = "Deeplinking";
    String testCaseDescription = "Verify Deeplinking working";

    @Test
    public void Deeplinking_FirstLink() throws Exception {


        try {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            setUp();
            waitForSpecificTime(10);
            link().get(1).click();
            waitForSpecificTime(10);
            link().get(1).click();
            waitForSpecificTime(10);
            link().get(1).click();
            waitForSpecificTime(10);
        }

        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);

        }

    }
}
