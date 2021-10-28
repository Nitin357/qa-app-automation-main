package Android;


import Parent.Constants;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.testng.annotations.Test;

import java.util.List;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.Sections.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;
import static Utils.CommonUtils.tearDown;
import static Utils.CommonUtils.swipeLeft;
import static ObjectRepository.AndroidOR.Photos.*;

public class Photos_Slideshow {


    String testCaseName = "Photos Test";
    String testCaseDescription = "Verify Photos tab working and image slideshow";

    @Test
    public void Photos_slideshow() throws Exception
    {
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            setUp();
            //login(true);
            //goBackToHomeTab();
            sectionsIcon().click();
            waitForSpecificTime(3);
            Photos().click();
            waitForSpecificTime( 5);
            Photo_list_0().click();
            waitForSpecificTime( 3);
            for(int i=1; i<=25; i++) {
                swipeLeft();
                waitForSpecificTime( 2);
            }
            Photo_list_1().click();
            for(int i=1; i<=26; i++) {
                swipeLeft();
                waitForSpecificTime( 2);
            }
            if(Photo_list_0().isDisplayed())
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
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
            tearDown();
        }
    }}
