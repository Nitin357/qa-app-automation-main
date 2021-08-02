package Android;

import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.ForYou.settingsIcon;
import static ObjectRepository.AndroidOR.Sections.recentlyViewed;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*
*This is test case for Verificaton of Login Functionality through For You>>Settings
*/
public class NativeLogin_SocialLogin {
    /*
    * Tests Native login functionality
    */
    @Test
    public void nativeLoginFunctionality() throws Exception
    {
        String testCaseName = "Native Login Functionality Test";
        String testCaseDescription = "Verify Native Login Functionality through Settings";
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            setUp();
            forYouIcon().click();
            waitForSpecificTime(2);
            settingsIcon().click();
            waitForSpecificTime(2);
            loginOrRegisterButton().click();
            waitForSpecificTime(2);
            loginWithEmailInsteadOption().click();
            waitForSpecificTime(2);
            createOne_NewAccountOption().click();
            waitForSpecificTime(2);
            createAccountWithEmailInstead().click();
            generateRandomEamail_Password();
            waitForSpecificTime(1);
            emailIdTextField().sendKeys(randomEmailID);
            waitForSpecificTime(1);
            passwordTextField().sendKeys(randomPassword);
            confirmPasswordTextField().sendKeys(randomPassword);
            waitForSpecificTime(2);
            createAccountButton_Settings_Login_CA().click();
            waitForSpecificTime(5);
            if((driver.findElementsById(accountCreationConfirmation_ID)).size()!=0)
            {
                extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
                continueWithoutSubscription_NewUser().click();
                waitForSpecificTime(2);
                logoutButton().click();
            }
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

    /*
     * Tests Social login functionality
     */
    @Test
    public void socialLoginFunctionality() throws Exception
    {

        String testCaseName = "Social Login Functionality Test";
        String testCaseDescription = "Verify Social Login Functionality through Settings";
        boolean googleLogin,fbLogin;
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            setUp();
            logoutIfLoggedIn();
            loginOrRegisterButton().click();
            waitForSpecificTime(2);
            loginWithGoogleButton().click();
            waitForSpecificTime(5);
            if(driver.findElementsById(logInWithGoogleButton_ID).size()==0)
            {
                extentTest.log(LogStatus.PASS, "Google login window present");
                googleLogin=true;
                driver.navigate().back();
            }
            else
            {
                extentTest.log(LogStatus.FAIL, "Google login window present");
                googleLogin=false;
            }
            loginWithFacebookButton().click();
            waitForSpecificTime(5);
            if(driver.findElementsById(logInWithFacebookButton_ID).size()==0)
            {
                extentTest.log(LogStatus.PASS, "FB login window present");
                fbLogin=true;
                driver.navigate().back();
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
                extentTest.log(LogStatus.FAIL,testCaseName+":"+testCaseDescription);
            }


        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }

    /*
     * Tests login functionality from article front>>save later button
     */
    @Test
    public static void articleFrontLogin()
    {

        String testCaseName = "Test Login Functionality from article front";
        String testCaseDescription = "Verify Login Functionality from save for later option on article front";
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            setUp();
            reachToExpectedArticle();
            waitForSpecificTime(2);
            moreOptionsArticleFront().click();
            waitForSpecificTime(2);
            loginSignup_Articlefront().click();
//            articleFrontSaveButton().click();
            waitForSpecificTime(2);
//            loginButton_ArticleFront_Save().click();
            waitForSpecificTime(5);
            loginWithEmailInsteadOption().click();
            waitForSpecificTime(5);
            emailIdTextField().sendKeys(loginUserName_SubscriberUser);
            waitForSpecificTime(5);
            passwordTextField().sendKeys(loginUserPassword_SubscribedUser);
            waitForSpecificTime(5);
            loginButton().click();
            waitForSpecificTime(5);
            goBackToHomeTab();
            goToSettingsPage();
            if(driver.findElementsByXPath(logOutButton_Xpath).size()!=0)
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

    /*
     * Tests login functionality from recently viewed
     */
    @Test
    public static void recentlyViewedLogin()
    {
        String testCaseName = "Test Login Functionality from recently viewed option";
        String testCaseDescription = "Verify Login Functionality from recently viewed option in sections tab";
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            setUp();
            logoutIfLoggedIn();
            goBackToHomeTab();
            sectionsIcon().click();
            recentlyViewed().click();
            loginButton_ArticleFront_Save().click();
            waitForSpecificTime(2);
            loginWithEmailInsteadOption().click();
            waitForSpecificTime(2);
            emailIdTextField().sendKeys(loginUserName_SubscriberUser);
            waitForSpecificTime(2);
            passwordTextField().sendKeys(loginUserPassword_SubscribedUser);
            waitForSpecificTime(2);
            loginButton().click();
            waitForSpecificTime(2);
            goBackToHomeTab();
            goToSettingsPage();
            if(driver.findElementsByXPath(logOutButton_Xpath).size()!=0)
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