package ObjectRepository.AndroidOR;

import Parent.Constants;
import org.openqa.selenium.*;
import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the common elements (not page specific)*/
public class CommonElements {

        //The popup for selection of account that comes at first launch of app
        public static MobileElement accountSelectionPopUp()
        { return (MobileElement) driver.findElementById("credential_picker_layout");}
        //Option to select none of the accounts from account selection popup
        public static MobileElement noneOfTheAboveAccountSelection()
        { return (MobileElement) driver.findElementById("cancel");}
        //Button to create a new account while launhing the app for the first time
        public static MobileElement createAccountButton()
        { return (MobileElement) driver.findElementById("createAccountButton");}
        //Button to continue without account creation while launhing the app for the first time
        public static MobileElement continueWithoutAccountButton()
        {return (MobileElement) driver.findElementById("continueButton");}
        //Button to continue without subscription while launhing the app for the first time
        public static MobileElement continueWithoutSubscribeButton()
        {return (MobileElement) driver.findElementById("continueButton");}
        //Button to view subscription options while launhing the app for the first time
        public static MobileElement subscribeOptionsButton()
        {return (MobileElement) driver.findElementById("subscribeOptionsButton");}
        //Today icon at bottom of application
        public static MobileElement todayIcon()
        {
                List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById("icon");
                return bottomNavigation.get(0);
        }
        //For You icon at bottom of application
        public static MobileElement forYouIcon()
        {
                List <MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById("icon");
                return bottomNavigation.get(1);
        }
        //Sections icon at bottom of application
        public static MobileElement sectionsIcon()
        {
                List <MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById("icon");
                return bottomNavigation.get(2);
        }
      }