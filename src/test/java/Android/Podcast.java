package Android;

import Parent.Constants;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static ObjectRepository.AndroidOR.CommonElements.forYouIcon;
import static ObjectRepository.AndroidOR.CommonElements.sectionsIcon;
import static ObjectRepository.AndroidOR.Podcasts.*;
import static ObjectRepository.AndroidOR.Sections.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is contains all test cases related to Charm Bracelet*/
public class Podcast {
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
        testCaseName = "Test podcast functionality";
        testCaseDescription = "Test presence of podcast indicator on all the tabs";
        try {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            sectionsIcon().click();
            podcast().click();
            boolean homeTabPresence=false,forYouTabPresence=false,sectionsTabPresence=false,afPresence=false;
            waitForElementLoad("id",podcastsPage_ID,10);
            podcastPage().click();
            waitForSpecificTime(5);
            playButton().click();
            waitForSpecificTime(5);
            //check for indicator
            if(Constants.driver.findElementsById(podcastsIndicator_ID).size()!=0)
            {
                extentTest.log(LogStatus.INFO, "Indicator present at Article Front");
                afPresence = true;
            }
            goBackToHomeTab();
            //check for indicator
            if(Constants.driver.findElementsById(podcastsIndicator_ID).size()!=0)
            {
                extentTest.log(LogStatus.INFO, "Indicator present at Home Tab");
                homeTabPresence = true;
            }
            forYouIcon().click();
            //checkfor indicator
            if(Constants.driver.findElementsById(podcastsIndicator_ID).size()!=0)
            {
                extentTest.log(LogStatus.INFO, "Indicator present at ForYou Tab");
                forYouTabPresence = true;
            }
            sectionsIcon().click();
            //check for indicator
            if(Constants.driver.findElementsById(podcastsIndicator_ID).size()!=0)
            {
                extentTest.log(LogStatus.INFO, "Indicator present at Sections Tab");
                sectionsTabPresence = true;
            }


            if (homeTabPresence && forYouTabPresence && sectionsTabPresence && afPresence)
            {
                extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            }

        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
        }
    }
}