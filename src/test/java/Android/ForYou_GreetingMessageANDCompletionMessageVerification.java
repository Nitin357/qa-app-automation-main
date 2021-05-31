package Android;

import ObjectRepository.AndroidOR.ForYou;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static ObjectRepository.AndroidOR.CommonElements.forYouIcon;
import static ObjectRepository.AndroidOR.CommonElements.forYouIcon_ID;
import static ObjectRepository.AndroidOR.ForYou.settingsIcon;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is test case for Verificaton of Greeting Message and Completion Moment Component in For You*/
public class ForYou_GreetingMessageANDCompletionMessageVerification {

    @BeforeClass
    public void setUp() throws Exception
    {
        launchNYTApp();
        skipInitialAccountSetup();
        waitForElementLoad("id",forYouIcon_ID,5);
        forYouIcon().click();
    }


    //This test case verifies Greeting Message on For You tab
    @Test
    public void greetingMessage() throws Exception
    {

        String testCaseName = "Greeting Message Verification";
        String testCaseDescription = "Verify Greeting Message in For You";
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            extentTest.log(LogStatus.INFO, "App Launched");
            extentTest.log(LogStatus.INFO, "Initial Subscription & Login skipped!");
            extentTest.log(LogStatus.INFO, "For You Icon Clicked!");
            waitForSpecificTime(10);
            if(ForYou.greetingMessage().getText().equals(greetingMessage))
            {
                extentTest.log(LogStatus.INFO, "Greeting message verified");
                extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.INFO, "Greeting message is incorrect");
                extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
            }
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }


    //This test case verifies completion message on for you tab
    @Test
    public void completionMessage() throws Exception
    {

        String testCaseName = "Completion Moment Message Verification";
        String testCaseDescription = "Verify Completion Moment Component in For You";
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            waitForSpecificTime(10);
            //Scrolling functionality
            Dimension size = driver.manage().window().getSize();
            int startx = size.getWidth()/2;
            int endx = size.getWidth()/2;
            int starty = (int)(size.getHeight()* 0.80);
            int endy = (int)(size.getHeight()* 0.01);
            new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
            new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
            new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
            new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
            new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
            if(ForYou.completionMomentComponent().getText().equals(completionMomentMessage))
            {
                extentTest.log(LogStatus.INFO, "Completion moment component verified");
                extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.INFO, "Completion moment component is incorrect");
                extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
            }
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }
}
