package Android;

import ObjectRepository.AndroidOR.Home;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.Sections.*;
import static Parent.Constants.driver;
import static Parent.Constants.expectedAricleHeading;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is contains all test cases related to Charm Bracelet*/
public class ArticleFrontTests_CharmBracelet {
    String testCaseName;
    String testCaseDescription;
    @BeforeTest
    public void setUp() throws Exception
    {
        launchNYTApp();
        skipInitialAccountSetup();
        reachToExpectedArticle();
    }


/*This test case tests functionality of share button on CharmBracelet*/
    @Test
    public void shareButtonTest() throws Exception
    {
        testCaseName = "Test Share Button functionality";
        testCaseDescription = "Test Share Button functionality on Article Front >> Charm Bracelet";
        try
        {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            articleFrontShareButton().click();
            if(shareMessageAndroid().isDisplayed())
            {
                extentTest.log(LogStatus.INFO,"Share Button working properly");
                extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
                driver.navigate().back();
            }
            else
            {

                extentTest.log(LogStatus.INFO,"Share Button NOT working properly");
                extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
            }

        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }



/*This test case tests functionality of comments button on CharmBracelet and all the functionalities inside comment window*/
    @Test
    public void commentsButton_Functionality() throws Exception
    {
        testCaseName = "Test Comments Button and comments functionality";
        testCaseDescription = "Test comments Button functionality on Article Front >> Charm Bracelet and rest of the comments functionality i.e. reporting,flagging etc on comments";
        boolean flagButtonStatus=false,recommendButtonStatus=false,replyButtonStatus=false;
        try
        {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            articleFrontCommentButton().click();
            waitForElementLoad("id",commentFlagButton_ID,10);
            commentFlagButton().click();
            if(flagWindow().isDisplayed())
            {
                flagButtonStatus=true;
                extentTest.log(LogStatus.INFO,"Flag button working");
                flagWindow_cancelButton().click();
            }
            else
            {
                extentTest.log(LogStatus.INFO,"Flag button NOT working");

            }
            int earlierRecommendations,laterRecommendations;
            String earlierRecommendationsText = commentRecommendButton().getText();
            earlierRecommendations= Integer.parseInt(earlierRecommendationsText.substring(earlierRecommendationsText.indexOf("("),earlierRecommendationsText.indexOf(")")));

            commentRecommendButton().click();
            waitForSpecificTime(5);
            String laterRecommendationsText = commentRecommendButton().getText();
            laterRecommendations= Integer.parseInt(laterRecommendationsText.substring(laterRecommendationsText.indexOf("("),laterRecommendationsText.indexOf(")")));

            if(laterRecommendations>earlierRecommendations)
            {
                recommendButtonStatus=true;
                extentTest.log(LogStatus.INFO,"Recommend button working");
            }
            else
            {
                extentTest.log(LogStatus.INFO,"Recommend button NOT working");
            }

            commentReplyButton().click();
            waitForSpecificTime(5);
            if(authorNameToReply().isDisplayed())
            {
                replyButtonStatus=true;
                extentTest.log(LogStatus.INFO,"Reply button working");
                driver.navigate().back();
            }
            else
            {
                extentTest.log(LogStatus.INFO,"Reply button NOT working");
            }

            if(flagButtonStatus&&recommendButtonStatus&&replyButtonStatus)
            {
                extentTest.log(LogStatus.INFO,"Comment functionality working properly");
                extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
            }
            else
            {
                extentTest.log(LogStatus.INFO,"Comment functionality working properly");
                extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);

            }
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }

    }



/*This test case tests functionality of save button on CharmBracelet*/
    @Test
    public void saveButtonTest() throws Exception
    {
        testCaseName = "Test Save Button functionality";
        testCaseDescription = "Test Save Button functionality on Article Front >> Charm Bracelet";
        try
        {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            articleFrontSaveButton().click();
            goBackToHomeTab();
            sectionsIcon().click();
            waitForElementLoad("id",mostPopular_ID,10);
            savedForLater().click();waitForSpecificTime(5);
            boolean headingFound=false;
            for(int pageSwipeUp = 0; pageSwipeUp<3;pageSwipeUp++)
            {
                for(int i=0;i<savedLaterArticleHeadings().size();i++)
                {
                    if(savedLaterArticleHeadings().get(i).equals(expectedAricleHeading))
                    {

                        extentTest.log(LogStatus.INFO,"Save button working properly");
                        extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
                        savedLaterArticleHeadings().get(i).click();
                        waitForSpecificTime(10);
                        articleFrontSaveButton().click();
                        headingFound=true;
                        break;
                    }
                }
                if(headingFound)
                {
                    break;
                }
            }

            if(headingFound==false)
            {
                extentTest.log(LogStatus.INFO,"Saved article not found in saved articles section");
                extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
            }
            goBackToHomeTab();
        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }



//This method is used to reach to a specific article on which this test is to be executed
    public static void reachToExpectedArticle() throws Exception
    {
        goBackToHomeTab();
        sectionsIcon().click();
        waitForSpecificTime(10);
        searchButton().click();
        waitForElementLoad("id",searchField_ID,10);
        searchField().sendKeys(expectedAricleHeading);
        List <MobileElement> searchResults = searchResultArticleHeadings();
        for(int i =0;i< searchResults.size();i++)
        {
            if (searchResults.get(i).getText().equals(expectedAricleHeading))
            {
                searchResults.get(i).click();
            }
        }
        waitForSpecificTime(10);
    }
}
