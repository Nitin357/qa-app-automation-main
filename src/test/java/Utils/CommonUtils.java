package Utils;

import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.CommonElements.continueWithoutAccountButton;
import static ObjectRepository.AndroidOR.ForYou.settingsIcon;
import static ObjectRepository.AndroidOR.ForYou.settingsIcon_ID;
import static ObjectRepository.AndroidOR.Sections.*;
import static ObjectRepository.AndroidOR.Sections.searchResultArticleHeadings;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;


/*Contains all the common reusable methods*/
public class CommonUtils {

    /*Set device name and platform name for execution*/
    public static void setDeviceInfo()
    {
        platformName="Android";
    }

    /*Set driver capabilities to launch NYT app*/
    public static void setCapabilitiesToInstallApp() throws Exception
    {
        setDeviceInfo();
        cap.setCapability("platformName", platformName);
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    /*Set driver capabilities to launch NYT app*/
    public static void setAppCapabilities() throws Exception
    {
           setDeviceInfo();
           cap.setCapability("platformName", platformName);
           cap.setCapability("appPackage", "com.nytimes.android");
           cap.setCapability("appActivity", "com.nytimes.android.MainActivity");
    }

    /*Launch NYT app*/
    public static void launchNYTApp() throws Exception
    {
        setAppCapabilities();
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }


    /*Skip sign in and subscription at initial launch*/

    /*
    * This method is used to close all connections
    * Arguments: None
    * Return   : Nothing
    */
    public static void tearDown() throws Exception
    {
        driver.quit();
    }

    /*
     *This method is used to skip initial account login and subscription while launching fresh installed app
     *Arguments: None
     *Return   : Nothing
     */

    public static void skipInitialAccountSetup() throws Exception
    {
            waitForSpecificTime(2);
            TouchAction touch=new TouchAction(driver);
            Dimension size = driver.manage().window().getSize();
            new TouchAction(driver).press(PointOption.point(size.getWidth()/10, size.getHeight()/10)).release().perform();
            waitForElementLoad("id",continueWithoutAccountButton_ID,10);
            continueWithoutAccountButton().click();
            waitForElementLoad("id",continueWithoutAccountButton_ID,10);
            continueWithoutSubscribeButton().click();
            waitForSpecificTime(10);
    }


    /*Login*/
    public static void login(Boolean userSubscriptionStatus) throws Exception
    {

        String userEmail="",userPassword="";
        if (userSubscriptionStatus)
        {
            userEmail = loginUserName_SubscriberUser;
            userPassword = loginUserPassword_SubscribedUser;
        }
        else
        {
            userEmail = loginUserName_UnsubscriberUser;
            userPassword = loginUserPassword_UnsubscribedUser;
        }
        goToSettingsPage();
        waitForSpecificTime(2);
        loginOrRegisterButton().click();
        waitForSpecificTime(5);
        loginWithEmailInsteadOption().click();
//        waitForSpecificTime(5);
        emailIdTextField().sendKeys(userEmail);
//        waitForSpecificTime(5);
        passwordTextField().sendKeys(userPassword);
//        waitForSpecificTime(5);
        loginButton().click();
        waitForSpecificTime(5);
        goBackToHomeTab();
    }

    /*Login*/
    public static void createRandomNewUser_Login() throws Exception
    {
        goBackToHomeTab();
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
        waitForSpecificTime(2);
        passwordTextField().sendKeys(randomPassword);
        waitForSpecificTime(1);
        confirmPasswordTextField().sendKeys(randomPassword);
        waitForSpecificTime(2);
        createAccountButton_Settings_Login_CA().click();
        waitForSpecificTime(10);
        do{
            continueWithoutSubscription_NewUser().click();
            waitForSpecificTime(2);
        }while(driver.findElementsById(getContinueWithoutAccountButton_NewAcct_ID).size()!=0);
        waitForSpecificTime(2);
        driver.navigate().back();
    }

    /*Go to settings page*/
    public static void goToSettingsPage() throws Exception
    {
        goBackToHomeTab();
        waitForElementLoad("id",forYouIcon_ID,5);
        forYouIcon().click();
        waitForSpecificTime(5);
        settingsIcon().click();
        waitForSpecificTime(5);
    }

    /*Generate random email id and password*/
    public static void generateRandomEamail_Password() throws Exception
    {
//        Date date = new Date();
        String currentTime= String.valueOf((System.currentTimeMillis()));
        randomEmailID= "automationtest"+currentTime+"@maildrop.cc";
        randomPassword= "ATP@"+currentTime+"atp";
    }
    /*Logout*/
    public static void logoutIfLoggedIn() throws Exception
    {

        goBackToHomeTab();
        waitForElementLoad("id",forYouIcon_ID,5);
        forYouIcon().click();
        waitForSpecificTime(2);
        settingsIcon().click();
        waitForSpecificTime(2);
        if(driver.findElementsByXPath(logOutButton_Xpath).size()!=0)
        {
            logoutButton().click();
            waitForSpecificTime(2);
            confirmLogoutButton().click();
        }

    }

    /*Check for registration/login popup for meter*/
    public static boolean checkMeter() throws Exception
    {
        boolean meterStatus=false;
            sectionsIcon().click();
            waitForElementLoad("id",mostPopular_ID,10);
            mostPopular().click();

            int meterCount = 4;
            java.util.List<MobileElement> homeTabArticles = (List<MobileElement>) driver.findElementsById("tablet_grid_item");
            for (int i = 0; i <= meterCount; i++) {
                waitForSpecificTime(2);
                homeTabArticles = (List<MobileElement>) driver.findElementsById("tablet_grid_item");
//                System.out.println(homeTabArticles.size());

                if ((i + homeTabArticles.size()) < meterCount) {
                    for (int j = 0; j < homeTabArticles.size(); j++) {
                        homeTabArticles.get(j).click();
                        waitForSpecificTime(5);
                        if ((driver.findElementsById(subscriptionPopUp_ID).size() != 0)) {
                            meterStatus = true;
                            driver.navigate().back();
                            driver.navigate().back();
                            todayIcon().click();
                            break;
                        }
                        else {
                            waitForSpecificTime(2);
                            scrollDownPage();
                            waitForSpecificTime(2);
                            scrollDownPage();
                            waitForSpecificTime(2);
                            scrollDownPage();
                            driver.navigate().back();
                            waitForSpecificTime(10);
                            i++;
                        }
                        if (meterStatus == true) {
                            break;
                        }
                    }
                    Dimension size = driver.manage().window().getSize();
                    int startx = size.getWidth() / 2;
                    int endx = size.getWidth() / 2;
                    int starty = (int) (size.getHeight() * 0.80);
                    int endy = (int) (size.getHeight() * 0.01);
                    new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
                } else {
                    homeTabArticles.get(i).click();
                    waitForSpecificTime(5);
                    if ((driver.findElementsById(subscriptionPopUp_ID).size() != 0)) {
                        meterStatus = true;
                        driver.navigate().back();
                        driver.navigate().back();
                        todayIcon().click();
                        break;
                    }
                    else {
                        waitForSpecificTime(2);
                        scrollDownPage();
                        waitForSpecificTime(2);
                        scrollDownPage();
                        waitForSpecificTime(2);
                        scrollDownPage();
                        driver.navigate().back();
                        waitForSpecificTime(2);
                    }
                }
                if (meterStatus == true) {
                    break;
                }
            }

        return meterStatus;
    }

    /*Opens app and skips initial login */
    public static void setUp() throws Exception
    {
        launchNYTApp();
        skipInitialAccountSetup();
    }

    /*Scroll down page*/
    public static void scrollDownPage()
    {
        Dimension size = driver.manage().window().getSize();
        int startx = size.getWidth() / 2;
        int endx = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.50);
        int endy = (int) (size.getHeight() * 0.10);
        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
    }

    /*Check presence of an apk file at the given path*/
    public static boolean checkAPKFilePresence(String folderPath)
    {
        apkFileAvailable=false;

        File directoryPath = new File(folderPath);
        File filesList[] = directoryPath.listFiles();
        if(filesList!=null)
        {
            for (int i = 0; i < filesList.length; i++)
            {
                System.out.println(i);
                String fileName = filesList[i].getAbsolutePath();
                if (fileName.contains("apk")&&(!fileName.contains("download")))
                {
                    apkFilePath = fileName;
                    apkFileAvailable = true;
                    break;
                }
            }
        }
        return apkFileAvailable;
    }

    /*Deletes all files present at the folder at the file path specified*/
    public static void deleteAllFilesInFolder(File file)
    {
        file = new File(apkFileFolderPath);
        if(file.listFiles()!=null)
        {
            for (File subFile : file.listFiles())
            {
                if(subFile.isDirectory())
                {
                    deleteAllFilesInFolder(subFile);
                }
                else
                {
                    subFile.delete();
                }
            }
        }
    }

    /*Download apk file from website*/
    public static void downloadAPKFromWebsite() throws Exception
    {
        //Erase contents of apkFile folder
        File file=new File(apkFileFolderPath);
        deleteAllFilesInFolder(file);
        //Clear downloads folder
        File file2=new File(downloadsFolderPath);
        deleteAllFilesInFolder(file2);
        apkFileAvailable=false;
        WebDriver driver2=new SafariDriver();
        driver2.navigate().to("https://install.appcenter.ms/");
        waitForSpecificTime(10);
        //Click on sign in with email instead option
        driver2.findElement(By.xpath("//*[@id='content']/div/div[3]/div/div[1]/div[4]/a[1]/div")).click();
        //Enter email id and password
        driver2.findElement(By.name("email")).sendKeys("manish.mittal@diaspark.com");
        driver2.findElement(By.name("password")).sendKeys("manish1979");
        driver2.findElement(By.className("_3EtH0jXex")).click();
        waitForSpecificTime(10);
        JavascriptExecutor js = (JavascriptExecutor) driver2;
        waitForSpecificTime(10);
        WebElement ele = driver2.findElement(By.xpath("//*[@id='layout-viewport']/div[1]/div[2]/div[2]/div[2]/ul/li[31]/a/div/div/div[2]/span[1]"));
        ele.click();
        waitForSpecificTime(10);
        WebElement downloadBTN=driver2.findElement(By.xpath("//*[@id=\"layout-viewport\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/button/div/span"));
        System.out.println(downloadBTN.isEnabled());
        downloadBTN.click();
        while(!apkFileAvailable)
        {
            waitForSpecificTime(10);
            checkAPKFilePresence(downloadsFolderPath);
        }
        File downloadedAPK = new File(apkFilePath);
        downloadedAPK.renameTo(new File(apkFileFolderPath+"\\Nyt.apk"));
        apkFilePath=(apkFileFolderPath+"\\Nyt.apk");
    }

    /*Install apk in phone*/
    public static void installApk() throws Exception
    {
        if(checkAPKFilePresence(apkFileFolderPath)==false)
        {
            downloadAPKFromWebsite();
        }
        setCapabilitiesToInstallApp();
        driver.installApp(apkFilePath);
        //Delete the apk file after installation
        File file=new File(apkFileFolderPath);
        deleteAllFilesInFolder(file);
        driver.quit();
    }

    /*Wait for given number of seconds for element located by XPATH/ID*/
    public static void waitForElementLoad(String locatedBY, String locator, int secondsToWait) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(driver,secondsToWait*1000);
        switch (locatedBY)
        {
            case "id": wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                        break;
            case "xpath":wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                        break;
            default: waitForSpecificTime(secondsToWait);
                break;
        }

    }


    /*Wait for specific no of seconds passed as argument to this method*/
    public static void waitForSpecificTime(int seconds)
    {

        long start = System.currentTimeMillis();
        long elapsedTime =0;
        while(elapsedTime<seconds*1000)
        {
            long end = System.currentTimeMillis();
            elapsedTime = end - start;
        }

    }

    public static void refreshForYouPage()
    {

    }

    /*Go back to home tab from anywhere on app*/
    public static void goBackToHomeTab()
    {
        if(driver.findElementsById(todayIcon_ID).size()==0)
        {
            while (driver.findElementsById(todayIcon_ID).size() == 0)
            {
                driver.navigate().back();
                waitForSpecificTime(2);
            }
        }
        todayIcon().click();
    }

    //This method is used to reach to a specific article on which this test is to be executed
    public static void reachToExpectedPodcastArticle() throws Exception
    {
        goBackToHomeTab();
        sectionsIcon().click();
        waitForSpecificTime(2);
        searchButton().click();
        waitForElementLoad("id",searchField_ID,10);
        searchField().sendKeys(expectedPodcastArticleHeading);
        driver.getKeyboard().pressKey("\n");
        waitForSpecificTime(10);
//        searchField().sendKeys(Keys.ENTER);
        List <MobileElement> searchResults = searchResultArticleHeadings();
        for(int i =0;i< searchResults.size();i++)
        {
            if (searchResults.get(i).getText().equals(expectedPodcastArticleHeading))
            {
                searchResults.get(i).click();
                break;
            }
        }
        waitForSpecificTime(5);
    }
    //This method is used to reach to a specific article on which this test is to be executed
    public static void reachToExpectedArticle() throws Exception
    {
        goBackToHomeTab();
        sectionsIcon().click();
        waitForSpecificTime(2);
        searchButton().click();
        waitForElementLoad("id",searchField_ID,10);
        searchField().sendKeys(expectedArticleHeading);
        driver.getKeyboard().pressKey("\n");
        waitForSpecificTime(10);
//        searchField().sendKeys(Keys.ENTER);
        List <MobileElement> searchResults = searchResultArticleHeadings();
        for(int i =0;i< searchResults.size();i++)
        {
            if (searchResults.get(i).getText().equals(expectedArticleHeading))
            {
                searchResults.get(i).click();
                break;
            }
        }
        waitForSpecificTime(5);
    }

    /*Check presence of ad slug*/
    public static boolean checkAdPresence()
    {
        if(driver.findElementsByXPath(adSlug_Text_Xpath).size()!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*Get credentials from Excel and set them in constant values*/
    public static void getCredentialsFromExcel()
    {
        {
            try
            {
                File file = new File (System.getProperty("user.dir")+"/Credentials.xlsx");
                FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
                //creating Workbook instance that refers to .xlsx file
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
                //for multiple values in excel
                String credentials[][]=new String[20][20];
                int i=0,j=0;
                Iterator<Row> itr = sheet.iterator(); //iterating over excel file
                while (itr.hasNext())
                {
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                    while (cellIterator.hasNext())
                    {

                        Cell cell = cellIterator.next();
                        credentials[i][j]=cell.getStringCellValue();
                        j++;
                    }j=0;
                    i++;
                }i=0;
                loginUserName_SubscriberUser =credentials[1][0];
                loginUserPassword_SubscribedUser =credentials[1][1];

                loginUserName_UnsubscriberUser =credentials[2][0];
                loginUserPassword_UnsubscribedUser =credentials[2][1];
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
