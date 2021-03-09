package ObjectRepository.AndroidOR;

import Parent.Constants;
import org.openqa.selenium.*;
import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

public class CommonElements {



        public static MobileElement accountSelectionPopUp()
        { return (MobileElement) driver.findElementById("credential_picker_layout");}
        public static MobileElement noneOfTheAboveAccountSelection()
        { return (MobileElement) driver.findElementById("cancel");}
        public static MobileElement createAccountButton()
        { return (MobileElement) driver.findElementById("createAccountButton");}
        public static MobileElement continueWithoutAccountButton()
        {return (MobileElement) driver.findElementById("continueButton");}
        public static MobileElement continueWithoutSubscribeButton()
        {return (MobileElement) driver.findElementById("continueButton");}
        public static MobileElement subscribeOptionsButton()
        {return (MobileElement) driver.findElementById("subscribeOptionsButton");}
        public static MobileElement todayIcon()
        {
                List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById("icon");
                return bottomNavigation.get(0);
        }
        public static MobileElement forYouIcon()
        {
                List <MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById("icon");
                return bottomNavigation.get(1);
        }
        public static MobileElement sectionsIcon()
        {
                List <MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById("icon");
                return bottomNavigation.get(2);
        }


      }