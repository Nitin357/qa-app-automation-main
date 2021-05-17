package Android;

import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.Sections.mostPopular;
import static Parent.Constants.driver;
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
public class ShareFunctionality {
    @BeforeClass
    public void setUp() throws Exception {
        launchNYTApp();
        skipInitialAccountSetup();
        Thread.sleep(5000);
        login();
    }

    @Test
    public void shareFunctionality() throws Exception {

        String testCaseName = "Article Share functionalityVerification";
        String testCaseDescription = "Verify articles are Shared by tapping on share option";
        try {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            Thread.sleep(10000);
            sectionsIcon().click();
            Thread.sleep(10000);
            mostPopular().click();
            Thread.sleep(10000);
            List<MobileElement> homeTabArticles = (List<MobileElement>) driver.findElementsById("tablet_grid_item");
            homeTabArticles.get(0).click();
            Thread.sleep(10000);
            articleFrontShareButton().click();

            MobileElement articleHeading = (MobileElement) driver.findElementByXPath("//[starts-with(@id,\"link\")]");
            System.out.println("+"+articleHeading.getText()+"+");
            String articleHeadingText=articleHeading.getText();
            Thread.sleep(10000);

            MobileElement copyTextAndroid = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView");
            if((copyTextAndroid.getText()).contains(articleHeadingText))
            {
                extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            }
//            MobileElement copyButtonAndroid = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView");
//            copyButtonAndroid.click();
        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
        }
    }
}