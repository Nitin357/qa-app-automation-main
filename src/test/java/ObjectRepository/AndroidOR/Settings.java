package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on Settings page*/
public class Settings {
    //These are identifiers of elements
    public static String loginOrRegisterButton_ID="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView";
    public static String loginWithEmailInsteadOption_ID="already_subscriber_plv";
    public static String emailIdTextField_ID="emailInput";
    public static String passwordTextField_ID="passwordInput";
    public static String loginButton_ID="login_button_lv";
    public static String digitalSubscriber_ID=" /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout";


    //These return element directly
    //Login or register button
    public static MobileElement loginOrRegisterButton()
    {return (MobileElement) driver.findElementByXPath(loginOrRegisterButton_ID);}
    //Login with email instead option in popup
    public static MobileElement loginWithEmailInsteadOption()
    {return (MobileElement) driver.findElementByAccessibilityId(loginWithEmailInsteadOption_ID);}
    //Email id text field in login popup
    public static MobileElement emailIdTextField()
    {return (MobileElement) driver.findElementById(emailIdTextField_ID);}
    //Password field in login popup
    public static MobileElement passwordTextField()
    {return (MobileElement) driver.findElementById(passwordTextField_ID);}
    //Login button in login popup
    public static MobileElement loginButton()
    {return (MobileElement) driver.findElementByAccessibilityId(loginButton_ID);}
    //Identifier of signed in user
    public static MobileElement digitalSubscriber()
    {return (MobileElement) driver.findElementByXPath(digitalSubscriber_ID);}

}
