package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import static Parent.Constants.driver;

public class ForYou {

    public static MobileElement settingsIcon()
    {return (MobileElement) driver.findElementByAccessibilityId("Settings");}
    public static MobileElement greetingMessage()
    {return (MobileElement) driver.findElementById("textViewSalutation");}
    public static MobileElement completionMomentComponent()
    {return (MobileElement) driver.findElementById("completionHeadline");}
}
