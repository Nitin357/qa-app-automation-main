package Android;

import Parent.Constants;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

import java.util.List;

import static ObjectRepository.AndroidOR.CommonElements.forYouIcon;
import static ObjectRepository.AndroidOR.CommonElements.sectionsIcon;
import static ObjectRepository.AndroidOR.ForYou.channelNames_ForYou;
import static ObjectRepository.AndroidOR.ForYou.completionMomentComponent_ID;
import static ObjectRepository.AndroidOR.Podcasts.playButton;
import static ObjectRepository.AndroidOR.Podcasts.podcastsIndicator_ID;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*
*This is test case presence of Ad slug
*/
public class AdPresence_ForYou {
    String testCaseName;
    String testCaseDescription;
    @Test
    public void adPresence() throws Exception {
        testCaseName = "Test Presence of AD slug";
        testCaseDescription = "Test ad slug on for you & for you>>article front";
        try {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            setUp();
            login(true);
            goBackToHomeTab();
            forYouIcon().click();
            boolean adPresence_ArticleFront = false ,adPresence_ForYou = false;
            waitForSpecificTime(5);
            List<MobileElement> channelsPresent=channelNames_ForYou();
            channelsPresent.get(1).click();
            for(int scrollCount = 0; scrollCount<10;scrollCount++ )
            {
                waitForSpecificTime(5);
                adPresence_ArticleFront = checkAdPresence();
                if(adPresence_ArticleFront)
                {
                    break;
                }
                else
                {
                    scrollDownPage();
                }
            }
            Constants.driver.navigate().back();
            waitForSpecificTime(2);
            while(Constants.driver.findElementsById(completionMomentComponent_ID).size()==0)
            {
                waitForSpecificTime(5);
                adPresence_ForYou = checkAdPresence();
                if(adPresence_ForYou)
                {
                    break;
                }
                else
                {
                    scrollDownPage();
                }
            }
            if (adPresence_ArticleFront && !adPresence_ForYou)
            {
                extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            }
            tearDown();
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            tearDown();
        }
    }
}