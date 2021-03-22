package ObjectRepository.AndroidOR;

import Parent.Constants;
import org.openqa.selenium.*;
import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the common elements (not page specific)*/
public class CommonElements {
        //These are identifiers of elements
        public static String accountSelectionPopUp_ID="credential_picker_layout";
        public static String noneOfTheAboveAccountSelection_ID="cancel";
        public static String createAccountButton_ID="createAccountButton";
        public static String continueWithoutAccountButton_ID="continueButton";
        public static String continueWithoutSubscribeButton_ID="continueButton";
        public static String subscribeOptionsButton_ID="subscribeOptionsButton";
        public static String todayIcon_ID="icon";
        public static String forYouIcon_ID="icon";
        public static String sectionIcon_ID="icon";
        public static String subscriptionPopup_createAccountButton_ID="cardButton";
        public static String subscriptionPopup_loginButton_ID="login";
        public static String subscriptionPopUp_ID="card";

        //These return element directly
        //The popup for selection of account that comes at first launch of app
        public static MobileElement accountSelectionPopUp()
        { return (MobileElement) driver.findElementById(accountSelectionPopUp_ID);}
        //Option to select none of the accounts from account selection popup
        public static MobileElement noneOfTheAboveAccountSelection()
        { return (MobileElement) driver.findElementById(noneOfTheAboveAccountSelection_ID);}
        //Button to create a new account while launhing the app for the first time
        public static MobileElement createAccountButton()
        { return (MobileElement) driver.findElementById(createAccountButton_ID);}
        //Button to continue without account creation while launhing the app for the first time
        public static MobileElement continueWithoutAccountButton()
        {return (MobileElement) driver.findElementById(continueWithoutAccountButton_ID);}
        //Button to continue without subscription while launhing the app for the first time
        public static MobileElement continueWithoutSubscribeButton()
        {return (MobileElement) driver.findElementById(continueWithoutSubscribeButton_ID);}
        //Button to view subscription options while launhing the app for the first time
        public static MobileElement subscribeOptionsButton()
        {return (MobileElement) driver.findElementById(subscribeOptionsButton_ID);}
        //Today icon at bottom of application
        public static MobileElement todayIcon()
        {
                List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(todayIcon_ID);
                return bottomNavigation.get(0);
        }
        //For You icon at bottom of application
        public static MobileElement forYouIcon()
        {
                List <MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(forYouIcon_ID);
                return bottomNavigation.get(1);
        }
        //Sections icon at bottom of application
        public static MobileElement sectionsIcon()
        {
                List <MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(sectionIcon_ID);
                return bottomNavigation.get(2);
        }
        public static MobileElement subscriptionPopup_createAccountButton()
        {return (MobileElement) driver.findElementById(subscriptionPopup_createAccountButton_ID);}
        public static MobileElement subscriptionPopup_loginButton()
        {return (MobileElement) driver.findElementById(subscriptionPopup_loginButton_ID);}
        public static MobileElement subscriptionPopup()
        {return (MobileElement) driver.findElementById(subscriptionPopUp_ID);}


}