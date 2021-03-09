package Android;

import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.*;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.Settings.*;
import static ObjectRepository.AndroidOR.ForYou.*;
import static Parent.Constants.*;
import static Parent.Reporting.*;
import static Utils.CommonUtils.*;

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
            Thread.sleep(10000);
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
            extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }
}