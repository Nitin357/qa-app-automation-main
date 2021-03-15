package Utils;

import io.appium.java_client.AppiumDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Iterator;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.CommonElements.continueWithoutAccountButton;
import static Parent.Constants.*;

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
