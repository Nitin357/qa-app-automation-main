package Android;

import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


import static ObjectRepository.AndroidOR.CommonElements.sectionsIcon;
import static ObjectRepository.AndroidOR.Sections.*;
import static Parent.Constants.driver;
import static Parent.Constants.expectedArticleHeading;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*
*This test case tests navigation of most popular section from sections tab
*/
public class SectionFrontNavigation {
    String testCaseName;
    String testCaseDescription;
    @Test
    public void sectionFrontNavigation() throws Exception {
        testCaseName = "Test Most popular navigation functionality";
        testCaseDescription = "Test navigation of most popular from sections tab";
        try {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            setUp();
            sectionsIcon().click();
            mostPopular().click();
            waitForSpecificTime(5);
            if (driver.findElementsByXPath(mostPopularHeader_Xpath).size()!=0)
            {
                extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            }
            tearDown();
        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            tearDown();
        }
    }
}