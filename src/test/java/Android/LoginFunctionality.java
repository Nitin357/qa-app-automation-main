package Android;

import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.TouchAction;
import org.testng.annotations.*;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.Settings.*;
import static ObjectRepository.AndroidOR.ForYou.*;
import static Parent.Constants.*;
import static Parent.Reporting.*;
import static Utils.CommonUtils.*;

/*This is test case for Verificaton of Login Functionality through For You>>Settings*/
public class LoginFunctionality {
    String testCaseName = "Login Functionality Test";
    String testCaseDescription = "Verify Login Functionality through For You>>Settings";
    @BeforeTest
    public void setUp() throws Exception
    {
        launchNYTApp();
        skipInitialAccountSetup();
    }

    @Test
    public void loginFunctionality() throws Exception
    {

        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            extentTest.log(LogStatus.INFO, "App Launched");
            extentTest.log(LogStatus.INFO, "Initial Subscription & Login skipped!");
            Thread.sleep(5000);
            forYouIcon().click();
            Thread.sleep(1000);
            settingsIcon().click();
            Thread.sleep(5000);
            loginOrRegisterButton().click();
            Thread.sleep(5000);
            loginWithEmailInsteadOption().click();
            Thread.sleep(5000);
            emailIdTextField().sendKeys(loginUserName);
            Thread.sleep(5000);
            passwordTextField().sendKeys(loginUserPassword);
            Thread.sleep(5000);
            loginButton().click();
            Thread.sleep(5000);
            TouchAction action = new TouchAction(driver);
            extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }
}
