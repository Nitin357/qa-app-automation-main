package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on Settings page*/
public class Settings {
    //These are identifiers of elements
    public static String loginOrRegisterButton_XPATH="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView";
    public static String loginWithEmailInsteadOption_ID="already_subscriber_plv";
    public static String emailIdTextField_ID="emailInput";
    public static String passwordTextField_ID="passwordInput";
    public static String loginButton_ID="login_button_lv";
    public static String logOutButton_TEXT="Log Out";
    public static String digitalSubscriber_XPATH=" /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout";
    public static String logInWithGoogleButton_ID="google_button";
    public static String logInWithFacebookButton_ID="facebook_button";
    public static String googleLoginWindow_XPATH="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout";
    public static String facebookLoginWindow_ID="u_0_0_a0";
    public static String createOneAccountOption_ID="accountButton";
    public static String createAccountWithEmailInstead_ID="accountLink";
    public static String confirmPasswordTextField_ID="passwordConfirmInput";
    public static String createAccountButton_ID="create_account_button_cav";
    public static String accountCreationConfirmation_ID="emailHeader";
    public static String confirmLogoutButton_ID="button1";

    //These return element directly
    //Login or register button
    public static MobileElement loginOrRegisterButton()
    {return (MobileElement) driver.findElementByXPath(loginOrRegisterButton_XPATH);}
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
    {return (MobileElement) driver.findElementByXPath(digitalSubscriber_XPATH);}
    //Identifier for LOG OUT Button
    public static MobileElement logoutButton()
    {return (MobileElement) driver.findElementByLinkText(logOutButton_TEXT);}
    public static MobileElement loginWithGoogleButton()
    {return (MobileElement) driver.findElementById(logInWithGoogleButton_ID);}
    public static MobileElement loginWithFacebookButton()
    {return (MobileElement) driver.findElementById(logInWithFacebookButton_ID);}
    public static MobileElement googleLoginWindow()
    {return (MobileElement) driver.findElementByXPath(googleLoginWindow_XPATH);}
    public static MobileElement facebookLoginWindow()
    {return (MobileElement) driver.findElementById(facebookLoginWindow_ID);}
    public static MobileElement createOne_NewAccountOption()
    {return (MobileElement) driver.findElementsById(createOneAccountOption_ID);}
    public static MobileElement createAccountWithEmailInstead()
    {return (MobileElement) driver.findElementById(createAccountWithEmailInstead_ID);}
    public static MobileElement confirmPasswordTextField()
    {return (MobileElement) driver.findElementById(confirmPasswordTextField_ID);}
    public static MobileElement createAccountButton_Settings_Login_CA()
    {return (MobileElement) driver.findElementById(createAccountButton_ID);}
    public static MobileElement accountCreationConfirmation()
    {return (MobileElement) driver.findElementById(accountCreationConfirmation_ID);}
    public static MobileElement confirmLogoutButton()
    {return (MobileElement) driver.findElementById(confirmLogoutButton_ID);}


}
