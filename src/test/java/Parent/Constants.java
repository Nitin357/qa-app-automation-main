package Parent;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constants {
//    public static MobileElement driver2;
    public static AppiumDriver driver;
    public static DesiredCapabilities cap = new DesiredCapabilities();
    public static String deviceName;
    public static String platformName;
    public static String loginUserName;
    public static String loginUserPassword;
    public static String completionMomentMessage="You're all caught up";
    public static String greetingMessage="Your daily recommendations from across The Times.";
    //    public static WebDriverWait wait=new WebDriverWait(driver, 20);


}
