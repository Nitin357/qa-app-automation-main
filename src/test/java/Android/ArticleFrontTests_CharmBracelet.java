package Android;

import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.Sections.*;
import static Parent.Constants.driver;
import static Parent.Constants.expectedArticleHeading;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is contains all test cases related to Charm Bracelet*/
public class ArticleFrontTests_CharmBracelet {
    String testCaseName;
    String testCaseDescription;

    /*This test case tests functionality of share button on CharmBracelet*/
    @Test
    public void shareButtonTest() throws Exception {
        testCaseName = "Test Share Button functionality";
        testCaseDescription = "Test Share Button functionality on Article Front >> Charm Bracelet";
        try {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            setUp();
            login(true);
            reachToExpectedArticle();
            articleFrontShareButton().click();
            waitForSpecificTime(2);
            if (shareMessageAndroid().isDisplayed()) {
                extentTest.log(LogStatus.INFO, "Share Button working properly");
                extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
                driver.navigate().back();
            } else {

                extentTest.log(LogStatus.INFO, "Share Button NOT working properly");
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            }
            tearDown();
        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            tearDown();
        }
    }


    /*This test case tests functionality of comments button on CharmBracelet and all the functionalities inside comment window*/
    @Test
    public void commentsButton_Functionality() throws Exception {
        testCaseName = "Test Comments Button and comments functionality";
        testCaseDescription = "Test comments Button functionality on Article Front >> Charm Bracelet and rest of the comments functionality i.e. reporting,flagging etc on comments";
        boolean flagButtonStatus = false, recommendButtonStatus = false, replyButtonStatus = false;
        try {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            setUp();
            login(true);
            reachToExpectedArticle();
            articleFrontCommentButton().click();
            waitForSpecificTime(5);
            commentFlagButton().click();
            waitForSpecificTime(2);
            if (driver.findElements(By.id(flagWindow_ID)).size()!=0)
            {
                flagButtonStatus = true;
                extentTest.log(LogStatus.INFO, "Flag button working");
                driver.navigate().back();
            }
            else {
                extentTest.log(LogStatus.INFO, "Flag button NOT working");

            }
            int earlierRecommendations, laterRecommendations;
            String earlierRecommendationsText = commentRecommendButton().getText();
            earlierRecommendations = Integer.parseInt(earlierRecommendationsText.substring(earlierRecommendationsText.indexOf("(")+1, earlierRecommendationsText.indexOf(")")));

            commentRecommendButton().click();
            waitForSpecificTime(5);
            String laterRecommendationsText = commentRecommendButton().getText();
            laterRecommendations = Integer.parseInt(laterRecommendationsText.substring(laterRecommendationsText.indexOf("(")+1, laterRecommendationsText.indexOf(")")));

            if (laterRecommendations > earlierRecommendations||laterRecommendations < earlierRecommendations) {
                recommendButtonStatus = true;
                extentTest.log(LogStatus.INFO, "Recommend button working");
                commentRecommendButton().click();
            } else {
                extentTest.log(LogStatus.INFO, "Recommend button NOT working");
            }

            commentReplyButton().click();
            waitForSpecificTime(2);
            if (driver.findElements(By.id(authorNameReply_ID)).size()!=0) {
                replyButtonStatus = true;
                extentTest.log(LogStatus.INFO, "Reply button working");
                driver.navigate().back();
            } else {
                extentTest.log(LogStatus.INFO, "Reply button NOT working");
            }

            if (flagButtonStatus && recommendButtonStatus && replyButtonStatus) {
                extentTest.log(LogStatus.INFO, "Comment functionality working properly");
                extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
            } else {
                extentTest.log(LogStatus.INFO, "Comment functionality working properly");
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);

            }
            tearDown();
        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            tearDown();
        }

    }


    /*This test case tests functionality of save button on CharmBracelet*/
    @Test
    public void saveButtonTest() throws Exception {
        testCaseName = "Test Save Button functionality";
        testCaseDescription = "Test Save Button functionality on Article Front >> Charm Bracelet";
        try {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            setUp();
            login(true);
            reachToExpectedArticle();
            articleFrontSaveButton().click();
            goBackToHomeTab();
            sectionsIcon().click();
            waitForElementLoad("id", mostPopular_ID, 10);
            savedForLater().click();
            waitForSpecificTime(5);
            boolean headingFound = false;
            for (int pageSwipeUp = 0; pageSwipeUp < 3; pageSwipeUp++) {
                for (int i = 0; i < savedLaterArticleHeadings().size(); i++) {
                    if (savedLaterArticleHeadings().get(i).equals(expectedArticleHeading)) {

                        extentTest.log(LogStatus.INFO, "Save button working properly");
                        extentTest.log(LogStatus.PASS, testCaseName + " : " + testCaseDescription);
                        savedLaterArticleHeadings().get(i).click();
                        waitForSpecificTime(10);
                        articleFrontSaveButton().click();
                        headingFound = true;
                        break;
                    }
                }
                if (headingFound) {
                    break;
                }
            }

            if (headingFound == false) {
                extentTest.log(LogStatus.INFO, "Saved article not found in saved articles section");
                extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            }
            goBackToHomeTab();
            tearDown();
        } catch (Exception ex) {
            extentTest.log(LogStatus.FAIL, testCaseName + " : " + testCaseDescription);
            tearDown();
        }
    }
}


