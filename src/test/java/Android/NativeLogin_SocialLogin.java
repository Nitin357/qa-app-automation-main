package Android;

import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.Sections.recentlyViewed;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is test case for Verificaton of Login Functionality through For You>>Settings*/
public class NativeLogin_SocialLogin {
    @Test
    public void nativeLoginFunctionality() throws Exception
    {

        String testCaseName = "Native Login Functionality Test";
        String testCaseDescription = "Verify Native Login Functionality through Settings";
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            extentTest.log(LogStatus.INFO, "App Launched");
            extentTest.log(LogStatus.INFO, "Initial Subscription & Login skipped!");
            setUp();
            logoutIfLoggedIn();
            goBackToHomeTab();
            goToSettingsPage();
            waitForSpecificTime(5);
            loginOrRegisterButton().click();
            loginWithEmailInsteadOption().click();
            waitForSpecificTime(5);
            createOne_NewAccountOption().click();
            waitForElementLoad("id",createAccountWithEmailInstead_ID,5);
            createAccountWithEmailInstead().click();
            generateRandomEamail_Password();
            waitForSpecificTime(5);
            emailIdTextField().sendKeys(randomEmailID);
            waitForSpecificTime(5);
            passwordTextField().sendKeys(randomPassword);
            confirmPasswordTextField().sendKeys(randomPassword);
            createAccountButton_Settings_Login_CA().click();
            if((driver.findElementsById(accountCreationConfirmation_ID)).size()!=0)
            {
                extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
                continueWithoutSubscription_NewUser().click();
                waitForSpecificTime(2);
                logoutIfLoggedIn();            }
            else
            {
                extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
            }
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }



    @Test
    public void socialLoginFunctionality() throws Exception
    {

        String testCaseName = "Social Login Functionality Test";
        String testCaseDescription = "Verify Social Login Functionality through Settings";
        boolean googleLogin,fbLogin;
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            extentTest.log(LogStatus.INFO, "App Launched");
            extentTest.log(LogStatus.INFO, "Initial Subscription & Login skipped!");
            setUp();
            logoutIfLoggedIn();
            loginOrRegisterButton().click();
            loginWithGoogleButton().click();
            waitForSpecificTime(5);
            if(driver.findElementsByXPath(googleLoginWindow_XPATH).size()!=0)
            {
                extentTest.log(LogStatus.PASS, "Google login window present");
                googleLogin=true;
            }
            else
            {
                extentTest.log(LogStatus.FAIL, "Google login window present");
                googleLogin=false;
            }
            driver.navigate().back();
            loginWithFacebookButton().click();
            if(driver.findElementsById(facebookLoginWindow_ID).size()!=0)
            {
                extentTest.log(LogStatus.PASS, "FB login window present");
                fbLogin=true;
            }
            else
            {
                extentTest.log(LogStatus.FAIL, "FB login window present");
                fbLogin=false;
            }

            if(googleLogin&&fbLogin)
            {
                extentTest.log(LogStatus.PASS,testCaseName+":"+testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.PASS,testCaseName+":"+testCaseDescription);
            }


        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }

    @Test
    public static void articleFrontLogin()
    {

        String testCaseName = "Test Login Functionality from article front";
        String testCaseDescription = "Verify Login Functionality from save for later option on article front";
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            extentTest.log(LogStatus.INFO, "App Launched");
            extentTest.log(LogStatus.INFO, "Initial Subscription & Login skipped!");
            setUp();
            logoutIfLoggedIn();
            reachToExpectedArticle();
            articleFrontSaveButton().click();
            loginButton_ArticleFront_Save().click();
            waitForSpecificTime(5);
            loginWithEmailInsteadOption().click();
            waitForSpecificTime(5);
            emailIdTextField().sendKeys(loginUserName_SubscriberUser);
            waitForSpecificTime(5);
            passwordTextField().sendKeys(loginUserPassword_SubscribedUser);
            waitForElementLoad("id",loginButton_ID,5);
            loginButton().click();
            waitForSpecificTime(5);
            goBackToHomeTab();
            goToSettingsPage();
            if(logoutButton().isDisplayed())
            {
                extentTest.log(LogStatus.PASS, testCaseName+":"+testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.FAIL, testCaseName+":"+testCaseDescription);
            }
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }



    @Test
    public static void recentlyViewedLogin()
    {

        String testCaseName = "Test Login Functionality from recently viewed option";
        String testCaseDescription = "Verify Login Functionality from recently viewed option in sections tab";
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            extentTest.log(LogStatus.INFO, "App Launched");
            extentTest.log(LogStatus.INFO, "Initial Subscription & Login skipped!");
            setUp();
            logoutIfLoggedIn();
            goBackToHomeTab();
            sectionsIcon().click();
            recentlyViewed().click();
            loginButton_ArticleFront_Save().click();
            waitForSpecificTime(5);
            loginWithEmailInsteadOption().click();
            waitForSpecificTime(5);
            emailIdTextField().sendKeys(loginUserName_SubscriberUser);
            waitForSpecificTime(5);
            passwordTextField().sendKeys(loginUserPassword_SubscribedUser);
            waitForElementLoad("id",loginButton_ID,5);
            loginButton().click();
            waitForSpecificTime(5);
            goBackToHomeTab();
            goToSettingsPage();
            if(logoutButton().isDisplayed())
            {
                extentTest.log(LogStatus.PASS, testCaseName+":"+testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.FAIL, testCaseName+":"+testCaseDescription);
            }
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }
}