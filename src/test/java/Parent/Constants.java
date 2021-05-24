package Parent;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Contains constants vlaues to be used throughout the execution*/
public class Constants {

    // Diver object
    public static AppiumDriver driver;
    //Capabilities object
    public static DesiredCapabilities cap = new DesiredCapabilities();
    //UID of Device
    public static String deviceName;
    //Platform of Device
    public static String platformName;
    //Login Credentials
    public static String loginUserName;
    public static String loginUserPassword;
    //Completion Moment Message on For You
    public static String completionMomentMessage="You’re all caught up";
    //Greeting Message on For You
    public static String greetingMessage="Your daily recommendations from across The Times.";
    //    public static WebDriverWait wait=new WebDriverWait(driver, 20);
    public static boolean apkFileAvailable;
    public static String apkFilePath;
    public static String apkFileFolderPath=(System.getProperty("user.dir")+"//apkFile");
    public static String downloadsFolderPath="/Users/webdunia/Downloads";
    public static String expectedAricleHeading = "How Joe Biden Can Win a Nobel Peace Prize";

}
