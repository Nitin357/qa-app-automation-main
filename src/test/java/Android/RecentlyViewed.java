package Android;

import ObjectRepository.AndroidOR.Sections;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.Sections.*;
import static Parent.Constants.driver;
import static Parent.Constants.expectedArticleHeading;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;
import static Utils.CommonUtils.setUp;

/*This is contains all test cases related to Charm Bracelet*/
public class RecentlyViewed {
    String testCaseName;
    String testCaseDescription;

    /*This test case tests functionality of recently viewed option in sections tab*/
    @Test
    public void recentlyViewedTest() throws Exception {
        testCaseName = "Test Recently viewed functionality";
        testCaseDescription = "Test Share Button functionality on Recently viewed articles";
        try {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            setUp();
            createRandomNewUser_Login();
            goBackToHomeTab();
            reachToExpectedArticle();
            goBackToHomeTab();
            sectionsIcon().click();
            recentlyViewed().click();
            boolean articlePresence = false;
            int scrollPage = 0;
            List<MobileElement> articleHeadings = recentlyviewedArticleHeadings();
            do {
                for (int i = 0; i < articleHeadings.size(); i++)
                {
                    if (articleHeadings.get(i).getText().equals(expectedArticleHeading))
                    {
                        articlePresence = true;
                        break;
                    }
                }
                if(articlePresence)
                {
                    break;
                }
                scrollDownPage();
                scrollPage++;
            } while (scrollPage <= 3);

            if (articlePresence) {
                extentTest.log(LogStatus.INFO, "Article found in recently viewed tab");
                extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
            } else {
                extentTest.log(LogStatus.INFO, "Article NOT found in recently viewed tab");
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            }

        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
        }
    }
}