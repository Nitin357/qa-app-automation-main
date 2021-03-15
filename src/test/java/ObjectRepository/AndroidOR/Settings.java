package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on Settings page*/
public class Settings {

    //Login or register button
    public static MobileElement loginOrRegisterButton()
    {return (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView");}
    //Login with email instead option in popup
    public static MobileElement loginWithEmailInsteadOption()
    {return (MobileElement) driver.findElementByAccessibilityId("already_subscriber_plv");}
    //Email id text field in login popup
    public static MobileElement emailIdTextField()
    {return (MobileElement) driver.findElementById("emailInput");}
    //Password field in login popup
    public static MobileElement passwordTextField()
    {return (MobileElement) driver.findElementById("passwordInput");}
    //Login button in login popup
    public static MobileElement loginButton()
    {return (MobileElement) driver.findElementByAccessibilityId("login_button_lv");}
    //Identifier of signed in user
    public static MobileElement digitalSubscriber()
    {return (MobileElement) driver.findElementByXPath(" /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout");}

}
