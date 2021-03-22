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
import org.openqa.selenium.Dimension;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.CommonElements.continueWithoutAccountButton;
import static ObjectRepository.AndroidOR.ForYou.settingsIcon;
import static ObjectRepository.AndroidOR.Sections.mostPopular;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.*;
import static Parent.Reporting.extentTest;

/*Contains all the common reusable methods*/
public class CommonUtils {

/*Set device name and platform name for execution*/
    public static void setDeviceInfo()
    {
        deviceName="R9WN90G3ZBJ";
        platformName="Android";
    }

/*Set driver capabilities to launch NYT app*/
    public static void setCapabilities() throws Exception
    {
           setDeviceInfo();
           cap.setCapability("deviceName", deviceName);
           cap.setCapability("platformName", platformName);
           cap.setCapability("appPackage", "com.nytimes.android");
           cap.setCapability("appActivity", "com.nytimes.android.MainActivity");
    }

/*Launch NYT app*/
    public static void launchNYTApp() throws Exception
    {
        setCapabilities();
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);


    }

/*Skip sign in and subscription at initial launch*/
    public static void skipInitialAccountSetup() throws Exception
    {
            Thread.sleep(10000);
            continueWithoutAccountButton().click();
            Thread.sleep(5000);
            continueWithoutSubscribeButton().click();
            Thread.sleep(5000);
    }

/*Login as unsubscribed user*/
    public static void loginUnsubscribedUser() throws Exception
    {
        Thread.sleep(5000);
        forYouIcon().click();
        Thread.sleep(10000);
        settingsIcon().click();
        Thread.sleep(5000);
        loginOrRegisterButton().click();
        Thread.sleep(5000);
        loginWithEmailInsteadOption().click();
        Thread.sleep(5000);
        emailIdTextField().sendKeys("himanshu.sharma@diaspark.com");
        Thread.sleep(5000);
        passwordTextField().sendKeys("test123");
        Thread.sleep(5000);
        loginButton().click();
        Thread.sleep(5000);
        driver.navigate().back();
    }

/*Check for registration/login popup for meter*/
    public static boolean checkMeter() throws Exception
    {
        boolean meterStatus=false;
        try {
            sectionsIcon().click();
            Thread.sleep(10000);
            mostPopular().click();

            int meterCount = 4;
            java.util.List<MobileElement> homeTabArticles = (List<MobileElement>) driver.findElementsById("tablet_grid_item");
            for (int i = 0; i <= meterCount; i++) {
                Thread.sleep(10000);

                homeTabArticles = (List<MobileElement>) driver.findElementsById("tablet_grid_item");
                System.out.println(homeTabArticles.size());

                if ((i + homeTabArticles.size()) < meterCount) {
                    for (int j = 0; j < homeTabArticles.size(); j++) {
                        homeTabArticles.get(j).click();
                        Thread.sleep(10000);
                        if ((driver.findElementsById(subscriptionPopUp_ID).size() != 0)) {
                            meterStatus = true;
                            driver.navigate().back();
                            driver.navigate().back();
                            todayIcon().click();
                            break;
                        }
                        driver.navigate().back();
                        Thread.sleep(10000);
                        i++;
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
                    Thread.sleep(10000);
                    if ((driver.findElementsById(subscriptionPopUp_ID).size() != 0)) {
                        meterStatus = true;
                        driver.navigate().back();
                        driver.navigate().back();
                        todayIcon().click();
                        break;
                    }
                    driver.navigate().back();
                    Thread.sleep(10000);
                }
                if (meterStatus == true) {
                    break;
                }
            }
        }
        catch (Exception E)
        {
            
        }
        return meterStatus;
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
                loginUserName=credentials[1][0];
                loginUserPassword=credentials[1][1];
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
