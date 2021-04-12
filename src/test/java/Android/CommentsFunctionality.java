package Android;

import ObjectRepository.AndroidOR.Home;
import Parent.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.ForYou.settingsIcon;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is test case for Verificaton of Login Functionality through For You>>Settings*/
public class CommentsFunctionality {
    String testCaseName = "Comments Functionality Test";
    String testCaseDescription = "Verify Comments Functionality in articles";
    @BeforeTest
    public void setUp() throws Exception
    {
        launchNYTApp();
        skipInitialAccountSetup();
    }

    @Test
    public void loginFunctionality() throws Exception
    {
        boolean flagButtonStatus=false,replyButtonStatus=false,recommendButtonStatus=false;

        try
        {
            Reporting.initializeReporting(testCaseName, testCaseDescription);
            Home.homeTabArticles().get(0).click();
            for(int i=0;i<Home.homeTabArticles().size();i++)
            {
                Thread.sleep(10000);
                if(driver.findElementsById(articleFrontCommentButton_ID).size()!=0)
                {
                    break;
                }
                else
                {
                    driver.navigate().back();
                    Thread.sleep(5000);

                    int width = Home.homeTabArticles().get(i+1).getSize().getWidth();
                    int height = Home.homeTabArticles().get(i+1).getSize().getHeight();

                    Actions act = new Actions(driver);
                    act.moveToElement(Home.homeTabArticles().get(i)).moveByOffset((width/2), (height/2)).click().perform();
                    if(i==(Home.homeTabArticles().size()-1))
                    {
                        extentTest.log(LogStatus.INFO,"No article found on home with comments");
                    }
                }

            }

            Thread.sleep(5000);
            articleFrontCommentButton().click();

            commentFlagButton().click();
            if (driver.findElementsById(commentFlagButton_ID).size()!=0)
            {
                extentTest.log(LogStatus.PASS,"Comment Flag working properly");
                flagButtonStatus=true;
            }
            driver.navigate().back();
            commentReplyButton().click();
            if (driver.findElementsById(authorNameReply_ID).size()!=0)
            {
                extentTest.log(LogStatus.PASS,"Comment Reply working properly");
                replyButtonStatus=true;
            }
            String recommendTextBeforePressingButton=commentRecommendButton().getText();
            recommendTextBeforePressingButton=recommendTextBeforePressingButton.substring(recommendTextBeforePressingButton.indexOf("("),recommendTextBeforePressingButton.indexOf(")"));

            commentRecommendButton().click();
            String recommendTextAfterPressingButton=commentRecommendButton().getText();
            recommendTextAfterPressingButton=recommendTextAfterPressingButton.substring(recommendTextAfterPressingButton.indexOf("("),recommendTextAfterPressingButton.indexOf(")"));

            if(Integer.parseInt(recommendTextBeforePressingButton)<Integer.parseInt(recommendTextAfterPressingButton))
            {
                extentTest.log(LogStatus.PASS,"Comment Recommend working properly");
                recommendButtonStatus=true;
            }

            if(flagButtonStatus&&replyButtonStatus&&recommendButtonStatus)
            {
                extentTest.log(LogStatus.PASS, testCaseName+" : "+testCaseDescription);
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
}