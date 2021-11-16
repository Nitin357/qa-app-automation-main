package Android;


import Parent.Constants;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.testng.annotations.Test;
import static Utils.CommonUtils.*;

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
            sectionsIcon().click();
            waitForSpecificTime(5);
            Photos().click();
            waitForSpecificTime( 20);
            String photocount = photo_info().getText().replaceAll("[^0-9]", "");
            int imagecount = Integer.parseInt(photocount);
            int addvert = imagecount / 6;
            Photo_list_0().click();
            waitForSpecificTime( 8);
            int image=1;
            do {
                swipeLeft();
                waitForSpecificTime( 1);
                image++;
            }while(image<=(imagecount+addvert));
            scrollDownPage();
            scrollDownPage();
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
