package Android;

import Parent.Reporting;
import Utils.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.ForYou.*;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*This is test case for Verificaton of changing font size in application*/
public class FontSize {
    @Test
    public void articleFront_FontSize() throws Exception
    {

        String testCaseName = "Font Size Functionality Test";
        String testCaseDescription = "Verify change in font size on article front by changing it from the app";
        try
        {
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            setUp();
            login(true);
            boolean jumboSizeChange=false,extraLargeSizeChange=false;
            String earlierSize,laterSize;
            int eSize,lSize;

            reachToExpectedArticle();
            waitForSpecificTime(5);
            moreOptionsArticleFront().click();
            textSize_Articlefront().click();
            large_TextSize().click();
            okButton_TextSizeWindow().click();
            earlierSize = articleHeaing().getCssValue("font-size");
            eSize = Integer.parseInt(earlierSize.substring(0,earlierSize.indexOf('p')));
            waitForSpecificTime(5);
            moreOptionsArticleFront().click();
            textSize_Articlefront().click();
            extraLarge_TextSize().click();
            okButton_TextSizeWindow().click();
            laterSize = articleHeaing().getCssValue("font-size");
            lSize = Integer.parseInt(earlierSize.substring(0,earlierSize.indexOf('p')));
            if(lSize>eSize)
            {
                extentTest.log(LogStatus.INFO, "Size changed to small");
                extraLargeSizeChange = true;
            }
            eSize=lSize;
            waitForSpecificTime(5);
            moreOptionsArticleFront().click();
            textSize_Articlefront().click();
            jumbo_TextSize().click();
            okButton_TextSizeWindow().click();
            laterSize = articleHeaing().getCssValue("font-size");
            lSize = Integer.parseInt(earlierSize.substring(0,earlierSize.indexOf('p')));
            if(lSize>eSize)
            {
                extentTest.log(LogStatus.INFO, "Size changed to small");
                jumboSizeChange = true;
            }
            if(jumboSizeChange&&extraLargeSizeChange)
            {
                extentTest.log(LogStatus.PASS,testCaseName+" : "+ testCaseDescription);
            }



        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }

    @Test
    public void forYouSectionFront_FontSize() throws Exception
    {

        String testCaseName = "Font Size Functionality Test";
        String testCaseDescription = "Verify change in font size on for you tab by changing it from the app";
        try
        {
            String earlierSize,laterSize;
            boolean smallSizeChange=false,jumboSizeChange=false;
            int eSize,lSize;
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            setUp();
            login(true);
            goBackToHomeTab();
            forYouIcon().click();
            waitForElementLoad("id",settingsIcon_ID,10);
            settingsIcon().click();
            waitForSpecificTime(5);
            textSizeIcon().click();
            large_TextSize().click();
            okButton_TextSizeWindow().click();
            driver.navigate().back();
            waitForSpecificTime(5);
            earlierSize = greetingMessage().getCssValue("font-size");
            eSize = Integer.parseInt(earlierSize.substring(0,earlierSize.indexOf('p')));
            waitForElementLoad("id",settingsIcon_ID,10);
            settingsIcon().click();
            waitForSpecificTime(5);
            textSizeIcon().click();
            small_TextSize().click();
            okButton_TextSizeWindow().click();
            driver.navigate().back();
            waitForSpecificTime(5);
            laterSize = greetingMessage().getCssValue("font-size");
            lSize = Integer.parseInt(laterSize.substring(0,earlierSize.indexOf('p')));
            if(lSize<eSize)
            {
                extentTest.log(LogStatus.INFO, "Size changed to small");
                smallSizeChange = true;
            }
            eSize=lSize;
            waitForElementLoad("id",settingsIcon_ID,10);
            settingsIcon().click();
            waitForSpecificTime(5);
            textSizeIcon().click();
            jumbo_TextSize().click();
            okButton_TextSizeWindow().click();
            driver.navigate().back();
            waitForSpecificTime(5);
            laterSize = greetingMessage().getCssValue("font-size");
            lSize = Integer.parseInt(laterSize.substring(0,earlierSize.indexOf('p')));
            if(lSize>eSize)
            {
                extentTest.log(LogStatus.INFO, "Size changed to jumbo");
                jumboSizeChange=true;
            }
            if(jumboSizeChange&&smallSizeChange)
            {
                extentTest.log(LogStatus.PASS,testCaseName+" : "+ testCaseDescription);
            }

        }
        catch (Exception ex)
        {
            extentTest.log(LogStatus.FAIL, testCaseName+" : "+testCaseDescription);
        }
    }
}