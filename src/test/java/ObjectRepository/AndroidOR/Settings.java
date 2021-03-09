package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static Parent.Constants.driver;

public class Settings {

    public static MobileElement loginOrRegisterButton()
    {return (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView");}
    public static MobileElement loginWithEmailInsteadOption()
    {return (MobileElement) driver.findElementByAccessibilityId("already_subscriber_plv");}
    public static MobileElement emailIdTextField()
    {return (MobileElement) driver.findElementById("emailInput");}
    public static MobileElement passwordTextField()
    {return (MobileElement) driver.findElementById("passwordInput");}
    public static MobileElement loginButton()
    {return (MobileElement) driver.findElementByAccessibilityId("login_button_lv");}
    public static MobileElement digitalSubscriber()
    {return (MobileElement) driver.findElementByXPath(" /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout");}

}
