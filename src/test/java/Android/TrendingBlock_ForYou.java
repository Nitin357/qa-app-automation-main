package Android;

import Parent.Constants;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static ObjectRepository.AndroidOR.CommonElements.forYouIcon;
import static ObjectRepository.AndroidOR.ForYou.*;
import static ObjectRepository.AndroidOR.ManageInterests.healthAndFitnessAddButton;
import static ObjectRepository.AndroidOR.ManageInterests.topicsOfInterest;
import static Parent.Constants.recentlyFollowedChannel;
import static Parent.Constants.trendingSectionHeader;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is test case for followed channels functionality*/
public class TrendingBlock_ForYou {
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

            //for logged out user
            forYouIcon().click();
            waitForSpecificTime(5);
            boolean blockPresence=false;
            do {
                List<MobileElement> channelsPresent=channelNames_ForYou();
                for(int i =0 ; i<channelsPresent.size();i++)
                {
                    if(channelsPresent.get(i).getText().equals(trendingSectionHeader));
                    {
                        blockPresence=true;
                        extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
                        break;
                    }
                }
                if(blockPresence)
                {
                    break;
                }
                scrollDownPage();
            }while(Constants.driver.findElementsById(completionMomentComponent_ID).size()==0);
            if(!blockPresence)
            {
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            }
        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
        }
    }
}