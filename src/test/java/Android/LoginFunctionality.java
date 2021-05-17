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
            waitForElementLoad("id",forYouIcon_ID,5);
            forYouIcon().click();
            waitForElementLoad("id",sectionIcon_ID,1);
            settingsIcon().click();
            waitForElementLoad("xpath",loginOrRegisterButton_XPATH,5);
            loginOrRegisterButton().click();
            waitForElementLoad("id",loginWithEmailInsteadOption_ID,5);
            loginWithEmailInsteadOption().click();
            waitForSpecificTime(5);
            emailIdTextField().sendKeys(loginUserName);
            passwordTextField().sendKeys(loginUserPassword);
            waitForElementLoad("id",loginButton_ID,5);
            loginButton().click();
            waitForSpecificTime(5);
            TouchAction action = new TouchAction(driver);
            extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }
}
