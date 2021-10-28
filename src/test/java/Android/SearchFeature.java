package Android;

import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


import java.sql.Driver;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.Sections.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

public class SearchFeature  {

    String testCaseName = "Search feature Test";
    String testCaseDescription = "Search Article And Verify Article";
    String SerchArticleText = "How a Nuclear bomb Could Save Earth From a Stealthy Asteroid";
    String SerchKeyText = "Trump";

    @Test
    public void SearchArticleFeature() throws Exception {
        try {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            setUp();
            waitForSpecificTime(2);
            sectionsIcon().click();
            waitForSpecificTime(2);
            searchButton().click();
            waitForSpecificTime(2);
            searchField().sendKeys(SerchArticleText);
            if (searchResultArticleHeadings().size() != 0) {
                extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
            } else {
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            }
            tearDown();
        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            tearDown();
        }
    }
        @Test
        public void SearchKeywordFeature() throws Exception {
            try {
                Reporting.initializeReporting(testCaseName, testCaseDescription);
                setUp();
                waitForSpecificTime(2);
                sectionsIcon().click();
                waitForSpecificTime(2);
                searchButton().click();
                waitForSpecificTime(2);
                searchField().sendKeys(SerchKeyText);
                if (searchResultArticleHeadings().size()!=0) {
                    extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
                } else {
                    extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
                }
                tearDown();
            } catch (Exception ex) {
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
                tearDown();
            }
        }
    }






