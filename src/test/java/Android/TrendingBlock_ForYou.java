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

/*
*This is test case for checking presence of trending block on for you page
*/
public class TrendingBlock_ForYou {
    String testCaseName;
    String testCaseDescription;
    @Test
    public void trendingBlockVisiblityTest() throws Exception {
        testCaseName = "Test tending block functionality";
        testCaseDescription = "Test presence of trending block in for you section";
        try{
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            setUp();
            //for logged out user
            forYouIcon().click();
            waitForSpecificTime(5);
            boolean blockPresence=false;
            do {
                List<MobileElement> channelsPresent=channelNames_ForYou();
                for(int i =0 ; i<channelsPresent.size();i++)
                {
                    channelsPresent=channelNames_ForYou();
                    if((channelsPresent.get(i).getText()).equals(trendingSectionHeader))
                    {
                        blockPresence=true;
                        extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
                        break;
                    }
                    else
                    {
                        scrollDownPage();
                        waitForSpecificTime(2);
                    }
                }
                if(blockPresence)
                {
                    break;
                }
            }while(Constants.driver.findElementsById(completionMomentComponent_ID).size()==0);
            if(!blockPresence)
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