package Android;

import Parent.Reporting;
import Utils.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.ForYou.*;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;
import static Utils.CommonUtils.*;

/*
*These are test cases for Verificaton of changing font size in application
*/
public class FontSize {
    /*
    * This test case verifies font size change functionality on article front
    */
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
            Dimension eSize,lSize;
            reachToExpectedArticle();
            waitForSpecificTime(5);
            moreOptionsArticleFront().click();
            waitForSpecificTime(2);
            textSize_Articlefront().click();
            large_TextSize().click();
            okButton_TextSizeWindow().click();
            waitForSpecificTime(2);
            eSize = opinionBannerArticleFront().getSize();
            waitForSpecificTime(5);
            moreOptionsArticleFront().click();
            waitForSpecificTime(2);
            textSize_Articlefront().click();
            waitForSpecificTime(2);
            extraLarge_TextSize().click();
            okButton_TextSizeWindow().click();
            waitForSpecificTime(2);
            lSize = opinionBannerArticleFront().getSize();
            if(eSize.height<lSize.height||eSize.width<lSize.width)
            {
                extentTest.log(LogStatus.INFO, "Size changed to Extra Large");
                extraLargeSizeChange = true;
            }
            eSize=lSize;
            waitForSpecificTime(5);
            moreOptionsArticleFront().click();
            waitForSpecificTime(2);
            textSize_Articlefront().click();
            waitForSpecificTime(1);
            jumbo_TextSize().click();
            okButton_TextSizeWindow().click();
            waitForSpecificTime(2);
            lSize = opinionBannerArticleFront().getSize();
            System.out.println(eSize+":"+lSize);
            if(eSize.height<lSize.height||eSize.width<lSize.width)
            {
                extentTest.log(LogStatus.INFO, "Size changed to Jumbo");
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

    /*
     * This test case verifies font size change functionality on for you section front
     */
    @Test
    public void forYouSectionFront_FontSize() throws Exception
    {
        String testCaseName = "Font Size Functionality Test";
        String testCaseDescription = "Verify change in font size on for you tab by changing it from for You";
        try
        {
            String earlierSize,laterSize;
            boolean smallSizeChange=false,jumboSizeChange=false;
            Dimension eSize,lSize;
            Reporting.initializeReporting(testCaseName,testCaseDescription);
            setUp();
            login(true);
            goBackToHomeTab();
            forYouIcon().click();
            waitForSpecificTime(2);
            settingsIcon().click();
            waitForSpecificTime(2);
            textSizeIcon().click();
            waitForSpecificTime(2);
            large_TextSize().click();
            okButton_TextSizeWindow().click();
            waitForSpecificTime(2);
            driver.navigate().back();
            waitForSpecificTime(2);
            eSize = greetingMessage().getSize();
            waitForSpecificTime(2);
            settingsIcon().click();
            waitForSpecificTime(5);
            textSizeIcon().click();
            waitForSpecificTime(1);
            small_TextSize().click();
            okButton_TextSizeWindow().click();
            driver.navigate().back();
            waitForSpecificTime(5);
            lSize = greetingMessage().getSize();
            if(eSize.height>lSize.height||eSize.width>lSize.width)
            {
                extentTest.log(LogStatus.INFO, "Size changed to small");
                smallSizeChange = true;
            }
            eSize=lSize;
            waitForSpecificTime(5);
            settingsIcon().click();
            waitForSpecificTime(5);
            textSizeIcon().click();
            waitForSpecificTime(1);
            jumbo_TextSize().click();
            okButton_TextSizeWindow().click();
            driver.navigate().back();
            waitForSpecificTime(5);
            lSize = greetingMessage().getSize();
            if(eSize.height<lSize.height||eSize.width<lSize.width)
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