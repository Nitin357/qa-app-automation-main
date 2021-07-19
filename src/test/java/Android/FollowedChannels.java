package Android;

import Parent.Constants;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.CommonElements.sectionsIcon;
import static ObjectRepository.AndroidOR.ForYou.*;
import static ObjectRepository.AndroidOR.ManageInterests.*;
import static ObjectRepository.AndroidOR.Podcasts.*;
import static ObjectRepository.AndroidOR.Sections.podcast;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is test case for followed channels functionality*/
public class FollowedChannels {
    String testCaseName;
    String testCaseDescription;

    /*This test case tests navigation of most popular section from sections tab*/
    @Test
    public void followedChannels() throws Exception {
        testCaseName = "Test followed channels functionality";
        testCaseDescription = "Test presence of new articles in feed for newly followed channel";
        try{
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            setUp();
            login(false);
            forYouIcon().click();
            waitForSpecificTime(5);
            int counter=0;
            boolean settingsOptionPresentOnForYou=false;
            //scroll till we find completion moment message
            do {
                if(Constants.driver.findElementsById(settings_GamesSection_ID).size()!=0)
                {
                    settingsGameSection().click();
                    settingsOptionPresentOnForYou=true;
                    extentTest.log(LogStatus.PASS, "Manage Interests through Game Block");
                    break;
                }
                else
                {
                    scrollDownPage();
                }
            }while(Constants.driver.findElementsById(completionMomentComponent_ID).size()==0);
            if(settingsOptionPresentOnForYou)
            {
                waitForSpecificTime(5);
                topicsOfInterest().click();
                waitForSpecificTime(5);
                healthAndFitnessAddButton().click();
                waitForSpecificTime(2);
                driver.navigate().back();
                goBackToHomeTab();
                forYouIcon().click();
                waitForSpecificTime(5);
                boolean testStatus=false;
                do {
                    List<MobileElement> channelsPresent=channelNames_ForYou();
                    for(int i =0 ; i<channelsPresent.size();i++)
                    {
                        if(channelsPresent.get(i).getText().equals(recentlyFollowedChannel));
                        {
                                 counter++;
                        }
                    }
                    scrollDownPage();
                }while(Constants.driver.findElementsById(completionMomentComponent_ID).size()==0);
                if(counter>0&&counter<3)
                {
                    extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
                }
            }
            else
            {
                extentTest.log(LogStatus.FAIL, "Manage Interests present through Game Block");
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            }
        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
        }
    }
}