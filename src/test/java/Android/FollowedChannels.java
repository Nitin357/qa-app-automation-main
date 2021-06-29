package Android;

import Parent.Constants;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static ObjectRepository.AndroidOR.CommonElements.forYouIcon;
import static ObjectRepository.AndroidOR.CommonElements.sectionsIcon;
import static ObjectRepository.AndroidOR.Podcasts.*;
import static ObjectRepository.AndroidOR.Sections.podcast;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is test case for followed channels functionality*/
public class FollowedChannels {
    String testCaseName;
    String testCaseDescription;

    @BeforeTest
    public void setUp() throws Exception {
        launchNYTApp();
        skipInitialAccountSetup();
    }


    /*This test case tests navigation of most popular section from sections tab*/
    @Test
    public void shareButtonTest() throws Exception {
        testCaseName = "Test followed channels functionality";
        testCaseDescription = "Test presence of new articles in feed for newly followed channel";
        try{
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            extentTest.log(LogStatus.INFO, "Indicator present at Home Tab");
            extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
        }
    }
}