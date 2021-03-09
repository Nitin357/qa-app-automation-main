package Android;

import ObjectRepository.AndroidOR.ForYou;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static ObjectRepository.AndroidOR.CommonElements.forYouIcon;
import static ObjectRepository.AndroidOR.ForYou.settingsIcon;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.launchNYTApp;
import static Utils.CommonUtils.skipInitialAccountSetup;

public class ForYou_GreetingMessageVerification {
    String testCaseName = "Greeting Message Verification";
    String testCaseDescription = "Verify Greeting Message in For You";
    @BeforeTest
    public void setUp() throws Exception
    {
        launchNYTApp();
        skipInitialAccountSetup();
        Thread.sleep(5000);
        forYouIcon().click();
    }

    @Test
    public void greetingMessage() throws Exception
    {

        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            extentTest.log(LogStatus.INFO, "App Launched");
            extentTest.log(LogStatus.INFO, "Initial Subscription & Login skipped!");
            extentTest.log(LogStatus.INFO, "For You Icon Clicked!");
            Thread.sleep(10000);
            System.out.println("--"+ForYou.greetingMessage().getText()+"--");
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
}
