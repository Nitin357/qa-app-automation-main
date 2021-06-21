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
    //Login Credentials for subscribed user
    public static String loginUserName_SubscriberUser;
    public static String loginUserPassword_SubscribedUser;
    //Login Credentials for unsubscribed user
    public static String loginUserName_UnsubscriberUser;
    public static String loginUserPassword_UnsubscribedUser;
    //Completion Moment Message on For You
    public static String completionMomentMessage="You’re all caught up";
    //Greeting Message on For You
    public static String greetingMessage="Your daily recommendations from across The Times.";
    /*   This is implicit wait and hence not used
    //   public static WebDriverWait wait=new WebDriverWait(driver, 20);
    */
    //Presence of apk file in project folder "qa-app-automation>>apkFile"
    public static boolean apkFileAvailable;
    //Path of apk file used to install in device
    public static String apkFilePath;
    //Path of folder in project that contains apk file
    public static String apkFileFolderPath=(System.getProperty("user.dir")+"//apkFile");
    //Downloads folder path in pc
    public static String downloadsFolderPath="/Users/webdunia/Downloads";
    //Heading of an article on which we are performing article front tests
    public static String expectedArticleHeading = "How Joe Biden Can Win a Nobel Peace Prize";
    //random email id to be created during execution
    public static String randomEmailID = "";
    //random email id's password to be created during execution
    public static String randomPassword = "";

}
