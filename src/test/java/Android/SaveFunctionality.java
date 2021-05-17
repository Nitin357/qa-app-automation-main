package Android;

import ObjectRepository.AndroidOR.ForYou;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.ForYou.settingsIcon;
import static ObjectRepository.AndroidOR.Sections.*;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*
 *
 *
 *
 *
 *
 *
 *
 * THIS TEST CASE IS TO BE MODIFIED ACCORDING TO CHARM BRACELET
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */
/*This is test case for Verificaton of Login Functionality through For You>>Settings*/
public class SaveFunctionality {
    @BeforeClass
    public void setUp() throws Exception {
        launchNYTApp();
        skipInitialAccountSetup();
        Thread.sleep(5000);
        login();
    }


    @Test
    public void saveFunctionality() throws Exception {

        String testCaseName = "Article Save functionality Verification";
        String testCaseDescription = "Verify articles are saved by tapping on save option";
        try {

            /*
            *
            *
            *
            *This test case needs to be updated as currently no articles are seen in "Saved for Later Section"
            *
            *
            *
            */
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            sectionsIcon().click();
            Thread.sleep(10000);
            mostPopular().click();
            Thread.sleep(10000);
            java.util.List<MobileElement> homeTabArticles = (List<MobileElement>) driver.findElementsById("tablet_grid_item");
            homeTabArticles.get(0).click();
            Thread.sleep(10000);
            articleFrontSaveButton().click();



            MobileElement articleHeading = (MobileElement) driver.findElementByXPath("//div[starts-with(@id,\"link\")]");
            System.out.println("+"+articleHeading.getText()+"+");
            Thread.sleep(10000);

            String articleHeadingText=articleHeading.getText();
            driver.navigate().back();
            driver.navigate().back();
            savedForLater().click();
//            extentTest.log(LogStatus.INFO, "App Launched");
//            extentTest.log(LogStatus.INFO, "Initial Subscription & Login skipped!");
//            extentTest.log(LogStatus.INFO, "For You Icon Clicked!");
//            Thread.sleep(10000);
//            if (ForYou.greetingMessage().getText().equals(greetingMessage)) {
//                extentTest.log(LogStatus.INFO, "Greeting message verified");
//                extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
//            } else {
//                extentTest.log(LogStatus.INFO, "Greeting message is incorrect");
//                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
//            }
        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
        }
    }

}